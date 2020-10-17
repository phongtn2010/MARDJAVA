package com.nsw.backend.mard.p09.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p08.helper.ReflectionHelper;
import com.nsw.backend.mard.p09.constant.Constant09;
import com.nsw.backend.mard.p09.dto.Hoso09DTO;
import com.nsw.backend.mard.p09.exception.NSWException;
import com.nsw.backend.mard.p09.model.*;
import com.nsw.backend.mard.p09.repositories.Tbdhoso09Repository;
import com.nsw.backend.mard.p09.repositories.Tbdycpk09Repository;
import com.nsw.backend.mard.p09.repositories.Tbdycrut09Repository;
import com.nsw.backend.mard.p09.repositories.Tbdycsua09Repository;
import com.nsw.backend.util.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of Tbdhoso09Service
 */
@Service("tbdhoso09Service")
@Transactional
public class Tbdhoso09ServiceImpl implements Tbdhoso09Service {
    private final Tbdhoso09Repository regProfileRepo;

    private final Tbdycsua09Repository requestEditRepo;

    private final Tbdycrut09Repository requestCancelRepo;

    private final Tbdycpk09Repository requestRemarkRepo;

    private final Tbdlichsu09Service historyService;

    private final GiayCN09Service certService;
    private List<String> pendingProfiles;
    private LoadingCache<String, Boolean> pendingQueue;

    @Autowired
    public Tbdhoso09ServiceImpl(Tbdhoso09Repository regProfileRepo, Tbdycsua09Repository requestEditRepo, Tbdycrut09Repository requestCancelRepo, Tbdycpk09Repository requestRemarkRepo, Tbdlichsu09Service historyService, GiayCN09Service certService) {
        this.regProfileRepo = regProfileRepo;
        this.requestEditRepo = requestEditRepo;
        this.requestCancelRepo = requestCancelRepo;
        this.requestRemarkRepo = requestRemarkRepo;
        this.historyService = historyService;
        this.certService = certService;
    }

    @Override
    public Tbdhoso09 findById(Long fiIdHoso) {
        return regProfileRepo.findOne(fiIdHoso);
    }

    @Override
    public List<Tbdhoso09> findAll() {
        return regProfileRepo.findAll();
    }

    @Override
    public Tbdhoso09 save(Tbdhoso09 tbdhoso09) {
        return regProfileRepo.save(tbdhoso09);
    }

    private Tbdhoso09 create(Tbdhoso09 tbdhoso09) {
        tbdhoso09.setFiActive(true);
        tbdhoso09.setFiHSStatus(0L);
        tbdhoso09.setFiGSStatus(0L);
        tbdhoso09.setFiPaymentStatus(-1L);
        Tbdhoso09 bo = regProfileRepo.save(tbdhoso09);
        bo.setFiHSCode(generateMaHoso(bo.getFiIdHS()));
        bo.getLstAtch().removeIf(dinhkem -> StringUtils.isEmpty(dinhkem.getFiDuongDan()));
        bo.getLstAtch().forEach(dinhkem -> dinhkem.setFiHoatdong(Constant09.ACTIVE));
        regProfileRepo.save(bo);
        return bo;
    }

    @Override
    @Transactional
    public Tbdhoso09 update(Tbdhoso09 tbdhoso09) {
        Tbdhoso09 currentHS = findById(tbdhoso09.getFiIdHS());
        tbdhoso09.setFiCreatedBy(currentHS.getFiCreatedBy());
        tbdhoso09.setFiCreatedDate(currentHS.getFiCreatedDate());
        tbdhoso09.setFiUpdatedBy(currentHS.getFiUpdatedBy());
        tbdhoso09.setFiActive(true);
        if (tbdhoso09.getFiHSStatus() == null) {
            tbdhoso09.setFiHSStatus(currentHS.getFiHSStatus());
            tbdhoso09.setFiKDStatus(currentHS.getFiKDStatus());
            tbdhoso09.setFiGSStatus(currentHS.getFiGSStatus());
        }
        tbdhoso09.getLstAtch().removeIf(dinhkem -> StringUtils.isEmpty(dinhkem.getFiDuongDan()));
        tbdhoso09.getLstAtch().forEach(dinhkem -> dinhkem.setFiHoatdong(Constant09.ACTIVE));
        return regProfileRepo.save(tbdhoso09);
    }

    @Override
    @Transactional
    public Tbdhoso09 updateAfterSendNSW(Tbdhoso09 updatedProfile) throws NSWException {
        // in-active hồ sơ gốc
        Tbdhoso09 originalProfile = this.findById(updatedProfile.getFiIdHS());

        if (!originalProfile.isFiActive()) throw new NSWException("Hồ sơ không hợp lệ");

        originalProfile.setFiActive(false);

        Long fiIdParentHS = originalProfile.getFiIdHS();
        String fiParentHSCode = updatedProfile.getFiHSCode();
        String fiModifyReason = updatedProfile.getFiModifyReason();

        ReflectionHelper.cleanIdAndFields(updatedProfile.getLstExporter());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getLstIsolatedLocation());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getLstProdMfr());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getLstGood());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getLstAtch());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getLstDocument());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getLstSeller());

        // tạo hồ sơ tạm
        updatedProfile.setFiIdHSParent(fiIdParentHS);
        updatedProfile.setFiIdHS(null);
        // Trạng thái hồ sơ hoạt động
        updatedProfile.setFiActive(true);
        updatedProfile.setFiRegistrationComfirmNo(originalProfile.getFiRegistrationComfirmNo());
        updatedProfile.setFiHSStatus(Constant09.Hoso09Status.CHO_TIEP_NHAN_YCS.getId());

        if (originalProfile.isParallel()) {
            updatedProfile.setFiGSStatus(updatedProfile.getFiHSStatus());
            updatedProfile.setFiKDStatus(originalProfile.getFiKDStatus());
        } else {
            updatedProfile.setFiKDStatus(updatedProfile.getFiHSStatus());
            updatedProfile.setFiGSStatus(originalProfile.getFiGSStatus());
        }

        updatedProfile.getLstAtch().removeIf(dinhkem -> StringUtils.isEmpty(dinhkem.getFiDuongDan()));
        updatedProfile.getLstAtch().forEach(dinhkem -> dinhkem.setFiHoatdong(Constant09.ACTIVE));
        updatedProfile.setFiPaymentStatus(originalProfile.getFiPaymentStatus());
        updatedProfile.setFiCreatedDate(new Date());
        updatedProfile = this.save(updatedProfile);
        this.save(originalProfile);

        // them mới vào bảng Tbdycsuahs10
        Tbdycsua09 ycsua09 = new Tbdycsua09();
        ycsua09.setFiIdHS(fiIdParentHS);
        ycsua09.setFiHSCode(fiParentHSCode);
        ycsua09.setFiRequestedDate(new Date());
        ycsua09.setFiActive(Constant09.ACTIVE);
        ycsua09.setFiStatus((long) Constant09.Cvcnkd09EditStatus.TAO_MOI.getId());
        ycsua09.setFiReason(fiModifyReason);
        ycsua09.setFiCreatedBy(updatedProfile.getFiUpdatedBy());
        requestEditRepo.save(ycsua09);

        historyService.save(createHistoryLog(updatedProfile, "Cập nhật hồ sơ tạo yêu cầu xin sửa"));
        return updatedProfile;
    }

    @Override
    public Tbdycrut09 cancelHoso(Tbdycrut09 requestCancel) {
        Tbdhoso09 regProfile = regProfileRepo.findOne(requestCancel.getFiIdHS());
        if (regProfile == null || regProfile.getFiHSStatus() != Constant09.Hoso09Status.CHO_TIEP_NHAN.getId()
                && regProfile.getFiHSStatus() != Constant09.Hoso09Status.DA_TIEP_NHAN.getId()
                && regProfile.getFiHSStatus() != Constant09.Hoso09Status.DA_XM_DON_DK.getId()
                && regProfile.getFiHSStatus() != Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId()
                && regProfile.getFiHSStatus() != Constant09.Hoso09Status.TU_CHOI_YCR.getId()
                && regProfile.getFiHSStatus() != Constant09.Hoso09Status.DONG_Y_YCS.getId()
        ) {
            throw new IllegalArgumentException("Trạng thái hồ sơ không hợp lệ");
        }
        requestCancel.setFiActive(Constant09.ACTIVE);
        requestCancel.setFiStatus((long) Constant09.Hoso09DeleteStatus.TAO_MOI.getId());
        requestCancel.setFiRequestedDate(DateTimeUtils.getDate());
        if (Constant09.Hoso09Status.CHO_TIEP_NHAN.getId() == regProfile.getFiHSStatus()
                || Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId() == regProfile.getFiHSStatus()) {
            requestCancel.setFiRequestType(0L); // hố sơ chưa tiếp nhận
            regProfile.setFiHSStatus(Constant09.Hoso09Status.DA_RUT_HO_SO.getId());
            if (regProfile.isParallel()) {
                regProfile.setFiGSStatus(Constant09.Hoso09Status.DA_RUT_HO_SO.getId());
            } else {
                regProfile.setFiKDStatus(Constant09.Hoso09Status.DA_RUT_HO_SO.getId());
            }
        } else {
            requestCancel.setFiRequestType(1L);  // hồ sơ đã tiếp nhận
            List<Long> cancellable = Arrays.asList(
                    Constant09.Hoso09Status.DA_TIEP_NHAN.getId(),
                    Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId(),
                    Constant09.Hoso09Status.DONG_Y_YCS.getId(),
                    Constant09.Hoso09Status.TU_CHOI_YCR.getId(),
                    Constant09.Hoso09Status.DA_XM_DON_DK.getId());

            regProfile.setFiHSStatus(Constant09.Hoso09Status.CHO_TIEP_NHAN_YCR.getId());
            if (cancellable.contains(regProfile.getFiKDStatus())) {
                regProfile.setFiKDStatus(Constant09.Hoso09Status.CHO_TIEP_NHAN_YCR.getId());
            }
            if (cancellable.contains(regProfile.getFiGSStatus())) {
                regProfile.setFiGSStatus(Constant09.Hoso09Status.CHO_TIEP_NHAN_YCR.getId());
            }
        }
        regProfileRepo.save(regProfile);
        historyService.save(createHistoryLog(regProfile, "Yêu cầu rút hồ sơ"));
        return requestCancelRepo.save(requestCancel);
    }

    @Override
    public Tbdhoso09 findByFiHSCode(String fiMaHoso) {
        return regProfileRepo.findFirstByFiHSCodeAndFiActive(fiMaHoso, true).orElse(null);
    }

    @Override
    public Tbdycpk09 remarkHoso(Tbdycpk09 remarkRequest) throws NSWException {
        Tbdhoso09 regProfile = regProfileRepo.findFirstByFiHSCodeAndFiActive(remarkRequest.getFiHSCode(), true).orElse(null);
        if (regProfile == null || !Objects.equals(1, regProfile.getFiFailXncl())) {
            throw new NSWException("Hồ sơ không hợp lệ");
        }
        remarkRequest.setFiActive(Constant09.ACTIVE);
        remarkRequest.setFiStatus((long) Constant09.Hoso09DeleteStatus.TAO_MOI.getId());
        remarkRequest.setFiRequestedDate(DateTimeUtils.getDate());

        regProfile.setFiHSStatus(Constant09.Hoso09Status.DA_GUI_PHAN_HOI.getId());
        regProfile.setFiGSStatus(Constant09.Hoso09Status.DA_GUI_PHAN_HOI.getId());
        regProfileRepo.save(regProfile);
        historyService.save(createHistoryLog(regProfile, "Gửi yêu cầu phúc khảo kết quả"));
        return requestRemarkRepo.save(remarkRequest);
    }

    @Override
    public Tbdhoso09 saveDraftRegProfile(Hoso09DTO profileDTO) {
        Tbdhoso09 profile = Tbdhoso09.parse(profileDTO);
        String historyContent;
        if (profile.getFiIdHS() == null) {
            profile.setFiHSCreatedDate(new Date());
            profile = this.create(profile);
            historyContent = "Tạo mới hồ sơ";
            profile.setFiHSStatus(Constant09.Hoso09Status.TAO_MOI.getId());
            profile.setFiKDStatus(Constant09.Hoso09Status.TAO_MOI.getId());
            profile.setFiGSStatus(Constant09.Hoso09Status.TAO_MOI.getId());
        } else {
            profile.setFiHSStatus(null);
            profile = this.update(profile);
            historyContent = "Cập nhật hồ sơ";
        }
        // Ghi lại lịch sử tạo mới
        historyService.save(createHistoryLog(profile, historyContent));
        return profile;
    }

    @Override
    public void rollbackFailedRequestUpdate(Tbdhoso09 result) {
        Tbdhoso09 parent = regProfileRepo.findOne(result.getFiIdHSParent());
        parent.setFiActive(true);

        regProfileRepo.save(parent);
        regProfileRepo.delete(result.getFiIdHS());
        getSignPendingProfiles().invalidate(result.getFiHSCode());
    }

    @Override
    public void rollbackFailedRequestUpdate(String nswFileCode) {
        Tbdhoso09 current = findByFiHSCode(nswFileCode);
        if (Boolean.TRUE.equals(pendingQueue.getIfPresent(nswFileCode))) {
            rollbackFailedRequestUpdate(current);
        }
    }

    @Override
    public FilterResult searchHoso(FilterForm filterForm) {
        filterForm.setFiLstNSWFileCode(certService.findLstNSWFileCode(filterForm));
        return regProfileRepo.searchHoso(filterForm);
    }

    private String generateMaHoso(Long id) {
        //HSCode Pattern: {Ministry's name}{ProcedureCode[2]}{Year[2]}{ID of HS[7]}
        return String.format("%s%s%02d%07d",
                Constant09.MINISTRY_NAME,
                Constant09.MARD_PROC_CODE,
                Calendar.getInstance().get(Calendar.YEAR) % 100,
                id);
    }

    private Tbdlichsu09 createHistoryLog(Tbdhoso09 profile, String historyContent) {
        Tbdlichsu09 profileHst = new Tbdlichsu09();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiHSCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(historyContent);
        profileHst.setFiCreatedBy(profile.getFiSignedBy());
        profileHst.setFiSenderUnitName(profile.getFiNameOfRegistration());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        return profileHst;
    }

    @Override
    public LoadingCache<String, Boolean> getSignPendingProfiles() {
        if (pendingQueue == null) {
            pendingProfiles = new ArrayList<>();
            this.pendingQueue = CacheBuilder.newBuilder()
                    .maximumSize(10000)
                    .expireAfterWrite(5, TimeUnit.MINUTES)
                    .removalListener(removalNotification -> {
                        if (removalNotification.wasEvicted()) {
                            //we should rollback automatically
                            String nswFileCode = (String) removalNotification.getKey();
                            rollbackFailedRequestUpdate(findByFiHSCode(nswFileCode));
                        }
                    })
                    .build(new CacheLoader<String, Boolean>() {
                        @Override
                        public Boolean load(String s) throws Exception {
                            return pendingProfiles.contains(s);
                        }
                    });
        }
        return pendingQueue;
    }
}
