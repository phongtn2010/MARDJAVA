/*
 * Created on 18 Jul 2017 ( Time 08:46:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.nsw.backend.mard.p07.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p07.constant.Constant07;
import com.nsw.backend.mard.p07.exception.NSWException;
import com.nsw.backend.mard.p07.helper.ReflectionHelper;
import com.nsw.backend.mard.p07.model.*;
import com.nsw.backend.mard.p07.repositories.TbdHoso07Repository;
import com.nsw.backend.mard.p07.repositories.TbdYcrut07Repository;
import com.nsw.backend.mard.p07.repositories.TbdYcsua07Repository;
import com.nsw.backend.util.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of TbdHoso07Service
 */
@Service
@Transactional
public class Tbdhoso07ServiceImpl implements TbdHoso07Service {

    private final TbdHoso07Repository regProfileRepository;

    private final TbdLichsu07Service hstService;

    private final TbdYcrut07Repository requestCancelRepo;

    private final TbdYcsua07Repository requestEditRepo;

    private final GiayCN07Service certService;
    private List<String> pendingProfiles;
    private LoadingCache<String, Boolean> pendingQueue;

    @Autowired
    public Tbdhoso07ServiceImpl(TbdHoso07Repository regProfileRepository, TbdLichsu07Service hstService, TbdYcrut07Repository requestCancelRepo, TbdYcsua07Repository requestEditRepo, GiayCN07Service certService) {
        this.regProfileRepository = regProfileRepository;
        this.hstService = hstService;
        this.requestCancelRepo = requestCancelRepo;
        this.requestEditRepo = requestEditRepo;
        this.certService = certService;
    }

    @Override
    public TbdHoso07 findById(int fiIdHoso) {
        return regProfileRepository.findOne(fiIdHoso);
    }

    @Override
    public List<TbdHoso07> findAll() {
        return regProfileRepository.findAll();
    }

    @Override
    public TbdHoso07 save(TbdHoso07 entity) {
        return regProfileRepository.save(entity);
    }

    @Override
    public void delete(int fiIdHoso) {
        regProfileRepository.delete(fiIdHoso);
    }

    @Override
    public void delete(TbdHoso07 entity) {
        regProfileRepository.delete(entity);
    }

    @Override
    public TbdHoso07 create(TbdHoso07 entity) {
        entity.setFiActive(true);
        entity.setFiHSStatus(0);
        TbdHoso07 bo = regProfileRepository.save(entity);
        bo.setFiNSWFileCode(generateMaHoso(bo.getFiIdHS()));
        regProfileRepository.save(bo);
        return bo;
    }

    @Override
    public TbdHoso07 update(TbdHoso07 entity) {
        TbdHoso07 currentHS = getInfoById(entity.getFiIdHS());
        entity.setFiCreatedBy(currentHS.getFiCreatedBy());
        entity.setFiCreatedDate(currentHS.getFiCreatedDate());
        entity.setFiUpdatedBy(currentHS.getFiUpdatedBy());
        entity.setFiActive(true);
        if (entity.getFiHSStatus() == null) {
            entity.setFiHSStatus(currentHS.getFiHSStatus());
            entity.setFiKDStatus(currentHS.getFiKDStatus());
            entity.setFiGSStatus(currentHS.getFiGSStatus());
        }
        entity.getFiAttachmentList().forEach(dinhkem -> {
            dinhkem.setFiIdHS(entity.getFiIdHS());
            dinhkem.setFiActive(Constant07.ACTIVE.intValue());
        });
        return regProfileRepository.save(entity);
    }

    @Override
    public TbdHoso07 getInfoById(int fiIdHoso) {
        return this.findById(fiIdHoso);
    }

    @Override
    public TbdHoso07 updateAfterSendNSW(TbdHoso07 updatedProfile) throws NSWException {
        // in-active hồ sơ gốc
        TbdHoso07 originalProfile = this.findById(updatedProfile.getFiIdHS());

        if (!originalProfile.isFiActive()) throw new NSWException("Hồ sơ không hợp lệ");

        originalProfile.setFiActive(false);

        int fiIdParentHS = updatedProfile.getFiIdHS();
        String fiParentHSCode = updatedProfile.getFiNSWFileCode();
        String fiModifyReason = updatedProfile.getFiModifyReason();

        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiAttachmentList());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiGoodsList());

        // tạo hồ sơ tạm
        updatedProfile.setFiIdHSParent(fiIdParentHS);
        updatedProfile.setFiIdHS(null);
        // Trạng thái hồ sơ hoạt động
        updatedProfile.setFiActive(true);
        updatedProfile.setFiCreatedDate(new Date());
        updatedProfile.setFiHSStatus(Constant07.HosoStatus.CHO_TIEP_NHAN_YCS.getId());

        if (originalProfile.isParallel()) {
            updatedProfile.setFiGSStatus(updatedProfile.getFiHSStatus());
            updatedProfile.setFiKDStatus(originalProfile.getFiKDStatus());
        } else {
            updatedProfile.setFiKDStatus(updatedProfile.getFiHSStatus());
            updatedProfile.setFiGSStatus(originalProfile.getFiGSStatus());
        }

        updatedProfile.setFiPaymentStatus(originalProfile.getFiPaymentStatus());
        //Copy thông tin XND
        if (!StringUtils.isEmpty(originalProfile.getFiRegistrationComfirmNo())) {
            TbdXacnhan07 newRegistrationComfirmNo = new TbdXacnhan07();
            BeanUtils.copyProperties(originalProfile.getFiRegistrationConfirm(), newRegistrationComfirmNo);
            newRegistrationComfirmNo.setFiIdConfirm(null);
            updatedProfile.setFiRegistrationConfirm(newRegistrationComfirmNo);
            updatedProfile.setFiRegistrationComfirmNo(updatedProfile.getFiRegistrationComfirmNo());
        }
        updatedProfile = this.save(updatedProfile);
        this.save(originalProfile);
        return updatedProfile;
    }

    @Override
    public TbdHoso07 findByFiHSCode(String fiMaHoso) {
        return regProfileRepository.findFirstByFiNSWFileCodeAndFiActive(fiMaHoso, true).orElse(null);
    }

    @Override
    public TbdHoso07 saveDraftTbdHoso(TbdHoso07 profile) {
        String historyContent;
        if (profile.getFiIdHS() == null || profile.getFiHSStatus() == null) {
            profile.setFiHSStatus(Constant07.HosoStatus.TAO_MOI.getId());
            profile.setFiGSStatus(Constant07.HosoStatus.TAO_MOI.getId());
            profile.setFiKDStatus(Constant07.HosoStatus.TAO_MOI.getId());
            profile = this.create(profile);
            historyContent = "Tạo mới hồ sơ";
        } else {
            profile.setFiHSStatus(null);
            profile = this.update(profile);
            historyContent = "Cập nhật hồ sơ";
        }
        hstService.createHistory(profile, historyContent);
        return profile;
    }

    @Override
    public TbdYcrut07 cancelHoso(TbdYcrut07 requestCancel) {
        List<Integer> cancellable = Arrays.asList(
                Constant07.HosoStatus.CHO_TIEP_NHAN.getId(),
                Constant07.HosoStatus.DA_TIEP_NHAN.getId(),
                Constant07.HosoStatus.DA_XM_DON_DANG_KY.getId(),
                Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId(),
                Constant07.HosoStatus.DONG_Y_YCS.getId(),
                Constant07.HosoStatus.TU_CHOI_YCR.getId());
        TbdHoso07 regProfile = regProfileRepository.findOne(requestCancel.getFiIdHS());
        if (regProfile == null || !cancellable.contains(regProfile.getFiHSStatus())) {
            throw new IllegalArgumentException("Trạng thái hồ sơ không hợp lệ");
        }
        requestCancel.setFiActive(Constant07.ACTIVE.intValue());
        requestCancel.setFiStatus(Constant07.HosoDeleteStatus.TAO_MOI.getId());
        requestCancel.setFiRequestedDate(DateTimeUtils.getDate());
        Constant07.HosoStatus status;
        if (Constant07.HosoStatus.CHO_TIEP_NHAN.getId() == regProfile.getFiHSStatus()
                || Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId() == regProfile.getFiHSStatus()) {
            requestCancel.setFiRequestType(0); // hố sơ chưa tiếp nhận
            status = Constant07.HosoStatus.DA_RUT_HO_SO;
        } else {
            requestCancel.setFiRequestType(1);  // hồ sơ đã tiếp nhận
            status = Constant07.HosoStatus.CHO_TIEP_NHAN_YCR;
        }
        regProfile.setFiHSStatus(status.getId());
        if (cancellable.contains(regProfile.getFiKDStatus())) {
            regProfile.setFiKDStatus(status.getId());
        }
        if (cancellable.contains(regProfile.getFiGSStatus())) {
            regProfile.setFiGSStatus(status.getId());
        }

        regProfileRepository.save(regProfile);
        hstService.save(createHistoryLog(regProfile, "Yêu cầu rút hồ sơ"));
        return requestCancelRepo.save(requestCancel);
    }

    @Override
    public void rollbackFailedRequestUpdate(TbdHoso07 failedUpdate) {
        TbdHoso07 parent = regProfileRepository.findOne(failedUpdate.getFiIdHSParent());
        parent.setFiActive(true);
        regProfileRepository.save(parent);

        regProfileRepository.delete(failedUpdate.getFiIdHS());
        getSignPendingProfiles().invalidate(failedUpdate.getFiNSWFileCode());
    }

    @Override
    public void rollbackFailedRequestUpdate(String nswFileCode) {
        TbdHoso07 current = findByFiHSCode(nswFileCode);
        if (Boolean.TRUE.equals(getSignPendingProfiles().getIfPresent(nswFileCode))) {
            rollbackFailedRequestUpdate(current);
        }
    }

    @Override
    public FilterResult searchHoso(FilterForm filterForm) {
        filterForm.setFiLstNSWFileCode(certService.findLstNSWFileCode(filterForm));
        return regProfileRepository.searchHoso(filterForm);
    }

    private String generateMaHoso(int id) {
        //HSCode Pattern: {Ministry's name}{ProcedureCode[2]}{Year[2]}{ID of HS[7]}
        return String.format("%s%s%02d%07d",
                Constant07.MINISTRY_NAME,
                Constant07.MARD_PROC_CODE,
                Calendar.getInstance().get(Calendar.YEAR) % 100,
                id);
    }

    private TbdLichsu07 createHistoryLog(TbdHoso07 profile, String historyContent) {
        TbdLichsu07 profileHst = new TbdLichsu07();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(historyContent);
        profileHst.setFiCreatedBy(profile.getFiSignName());
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
