/*
 * Created on 18 Jul 2017 ( Time 08:46:37 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.nsw.backend.mard.p06.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p06.constant.Constant06;
import com.nsw.backend.mard.p06.exception.NSWException;
import com.nsw.backend.mard.p06.helper.ReflectionHelper;
import com.nsw.backend.mard.p06.model.*;
import com.nsw.backend.mard.p06.repositories.TbdCongvan06Repository;
import com.nsw.backend.mard.p06.repositories.TbdHoso06Repository;
import com.nsw.backend.mard.p06.repositories.TbdYcrut06Repository;
import com.nsw.backend.mard.p06.repositories.TbdYcsua06Repository;
import com.nsw.backend.util.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Implementation of TbdHoso06Service
 */
@Service
@Transactional
public class Tbdhoso06ServiceImpl implements TbdHoso06Service {

    private final TbdHoso06Repository regProfileRepository;

    private final TbdYcsua06Repository requestEditRepository;

    private final TbdYcrut06Repository requestCancelRepository;

    private final TbdCongvan06Repository certRepo;

    private final TbdLichsu06Service hstService;

    @Autowired
    public Tbdhoso06ServiceImpl(TbdHoso06Repository regProfileRepository, TbdYcsua06Repository requestEditRepository, TbdYcrut06Repository requestCancelRepository, TbdCongvan06Repository certRepo, TbdLichsu06Service hstService) {
        this.regProfileRepository = regProfileRepository;
        this.requestEditRepository = requestEditRepository;
        this.requestCancelRepository = requestCancelRepository;
        this.certRepo = certRepo;
        this.hstService = hstService;
    }

    private List<String> pendingProfiles;
    private LoadingCache<String, Boolean> pendingQueue;

    @Override
    public LoadingCache<String, Boolean> getSignPendingProfiles() {
        if(pendingQueue == null){
            pendingProfiles = new ArrayList<>();
            this.pendingQueue = CacheBuilder.newBuilder()
                    .maximumSize(10000)
                    .expireAfterWrite(5, TimeUnit.MINUTES)
                    .removalListener(removalNotification -> {
                        if(removalNotification.wasEvicted()){
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

    @Override
    public TbdHoso06 findById(int fiIdHoso) {
        return regProfileRepository.findOne(fiIdHoso);
    }

    @Override
    public List<TbdHoso06> findAll() {
        return regProfileRepository.findAll();
    }

    @Override
    public TbdHoso06 save(TbdHoso06 entity) {
        entity = regProfileRepository.save(entity);
        if (StringUtils.isEmpty(entity.getFiNSWFileCode())) {
            entity.setFiNSWFileCode(generateMaHoso(entity.getFiIdHS()));
        }
        entity.getFiAttachmentList().removeIf(dinhkem -> StringUtils.isEmpty(dinhkem.getFiPath()));
        entity.getFiAttachmentList().forEach(dinhkem -> dinhkem.setFiActive(Constant06.ACTIVE.intValue()));
        entity.getFiProductList().forEach((product -> {
            if (product.getFiId() == null) {
                product.setFiId(product.getFiIdProduct());
            }
        }));
        return regProfileRepository.save(entity);
    }

    @Override
    public void delete(int fiIdHoso) {
        regProfileRepository.delete(fiIdHoso);
    }

    @Override
    public void delete(TbdHoso06 entity) {
        regProfileRepository.delete(entity);
    }

    @Override
    public TbdHoso06 create(TbdHoso06 entity) {
        entity.setFiActive(true);
        entity.setFiHSStatus(0);
        return this.save(entity);
    }

    @Override
    public TbdHoso06 update(TbdHoso06 entity) {
        TbdHoso06 currentHS = getInfoById(entity.getFiIdHS());
        entity.setFiCreatedBy(currentHS.getFiCreatedBy());
        entity.setFiCreatedDate(currentHS.getFiCreatedDate());
        entity.setFiUpdatedBy(currentHS.getFiUpdatedBy());
        if (entity.getFiHSStatus() == null) {
            entity.setFiHSStatus(currentHS.getFiHSStatus());
        }
        entity.setFiActive(true);
        return this.save(entity);
    }

    @Override
    public TbdHoso06 getInfoById(int fiIdHoso) {
        return this.findById(fiIdHoso);
    }

    @Override
    public boolean updateStatus(String fiMaHoso, int fiTrangthai) {
        TbdHoso06 bo = regProfileRepository.findFirstByFiNSWFileCodeAndFiActive(fiMaHoso, true).orElse(null);
        if (bo != null) {
            bo.setFiHSStatus(fiTrangthai);
            regProfileRepository.save(bo);
        }
        return false;
    }

    @Override
    public TbdHoso06 updateAfterSendNSW(TbdHoso06 updatedProfile) throws NSWException {
        // in-active hồ sơ gốc
        TbdHoso06 originalProfile = this.findById(updatedProfile.getFiIdHS());

        if (!originalProfile.isFiActive()) throw new NSWException("Hồ sơ không hợp lệ");

        originalProfile.setFiActive(false);

        int fiIdParentHS = updatedProfile.getFiIdHS();
        String fiParentHSCode = updatedProfile.getFiNSWFileCode();
        String fiModifyReason = updatedProfile.getFiReason();

        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiExporterCountryList());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiProductList());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiLocationQuarantineList());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiProcessingList());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiAttachmentList());

        // tạo hồ sơ tạm
        updatedProfile.setFiIdHSParent(fiIdParentHS);
        updatedProfile.setFiIdHS(null);
        // Trạng thái hồ sơ hoạt động
        updatedProfile.setFiActive(true);
        updatedProfile.setFiCreatedDate(new Date());
        updatedProfile.setFiHSStatus(Constant06.HosoStatus.CHO_TIEP_NHAN_YCS.getId());

        updatedProfile = this.save(updatedProfile);
        regProfileRepository.save(originalProfile);

//         them mới vào bảng YCS
        TbdYcsua06 editRequest = new TbdYcsua06();
        editRequest.setFiIdHS(fiIdParentHS);
        editRequest.setFiNSWFileCode(fiParentHSCode);
        editRequest.setFiRequestedDate(DateTimeUtils.getDate());
        editRequest.setFiActive(1);
        editRequest.setFiStatus(Constant06.HosoEditStatus.TAO_MOI.getId());
        editRequest.setFiReason(fiModifyReason);
        editRequest.setFiCreatedBy(updatedProfile.getFiUpdatedBy());
        requestEditRepository.save(editRequest);

        return updatedProfile;
    }

    @Override
    public TbdHoso06 findByFiHSCode(String fiMaHoso) {
        return regProfileRepository.findFirstByFiNSWFileCodeAndFiActive(fiMaHoso, true).orElse(null);
    }

    @Override
    public List<TbdHoso06> findAllByFiHSStatus(int fiHSStatus) {
        return regProfileRepository.findAllByFiHSStatusAndFiActive(fiHSStatus, true);
    }

    @Override
    public void internalStatusUpdate(TbdHoso06 regProfile, int status) {
        regProfile.setFiHSStatus(status);
        String hstContent = "Cập nhật trạng thái hồ sơ: " + Constant06.HosoStatus.findById(status).getName();
        hstService.save(createHistory(regProfile, hstContent,
                "NSW",
                regProfile.getFiTaxCode(),
                regProfile.getFiImporterName()));
        this.save(regProfile);
    }

    @Override
    public void rollbackFailedRequestUpdate(TbdHoso06 result) {
        TbdHoso06 parent = regProfileRepository.findOne(result.getFiIdHSParent());
        parent.setFiActive(true);

        regProfileRepository.save(parent);
        regProfileRepository.delete(result.getFiIdHS());
        getSignPendingProfiles().invalidate(result.getFiNSWFileCode());
    }

    @Override
    public void rollbackFailedRequestUpdate(String nswFileCode) {
        TbdHoso06 current = findByFiHSCode(nswFileCode);
        if(Boolean.TRUE.equals(getSignPendingProfiles().getIfPresent(nswFileCode))) {
            rollbackFailedRequestUpdate(current);
        }
    }

    private TbdLichsu06 createHistory(TbdHoso06 profile, String historyContent) {
        TbdLichsu06 profileHst = new TbdLichsu06();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(historyContent);
        profileHst.setFiCreatedBy(profile.getFiSignName());
        profileHst.setFiSenderUnitName(profile.getFiImporterName());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        return profileHst;
    }

    private TbdLichsu06 createHistory(TbdHoso06 regProfile, String hstContent, String senderCode, String senderName, String senderUnitName) {
        TbdLichsu06 history = new TbdLichsu06();
        history.setFiSenderCode(senderCode);
        history.setFiSenderName(senderName);
        history.setFiSenderUnitName(senderUnitName);
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiNSWFileCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiTimeline(new Date());
        history.setFiReceiverCode("BNN");
        history.setFiReceiverName("Bộ Nông nghiệp");
        history.setFiStatus(regProfile.getFiHSStatus());
        return history;
    }

    @Override
    public TbdYcrut06 cancelHoso(TbdYcrut06 cancelRequest) {
        TbdHoso06 regProfile = regProfileRepository.findOne(cancelRequest.getFiIdHS());
        if (regProfile == null || regProfile.getFiHSStatus() != Constant06.HosoStatus.CHO_TIEP_NHAN.getId()
                && regProfile.getFiHSStatus() != Constant06.HosoStatus.DA_TIEP_NHAN.getId()
                && regProfile.getFiHSStatus() != Constant06.HosoStatus.TU_CHOI_YCR.getId()
                && regProfile.getFiHSStatus() != Constant06.HosoStatus.DONG_Y_YCS.getId()
                && regProfile.getFiHSStatus() != Constant06.HosoStatus.YEU_CAU_BO_SUNG.getId()
        ) {
            throw new IllegalArgumentException("Trạng thái hồ sơ không hợp lệ");
        }
        cancelRequest.setFiActive(1);
        cancelRequest.setFiStatus(Constant06.HosoDeleteStatus.TAO_MOI.getId());
        cancelRequest.setFiRequestedDate(DateTimeUtils.getDate());

        if (Constant06.HosoStatus.CHO_TIEP_NHAN.getId() == regProfile.getFiHSStatus()
                || Constant06.HosoStatus.YEU_CAU_BO_SUNG.getId() == regProfile.getFiHSStatus()
        ) {
            cancelRequest.setFiRequestType(0); // hố sơ chưa tiếp nhận
            regProfile.setFiHSStatus(Constant06.HosoStatus.DA_RUT_HO_SO.getId());
        } else {
            cancelRequest.setFiRequestType(1);  // hồ sơ đã tiếp nhận
            regProfile.setFiHSStatus(Constant06.HosoStatus.CHO_TIEP_NHAN_YCR.getId());
        }
        regProfileRepository.save(regProfile);
        hstService.save(createHistory(regProfile, "Yêu cầu rút hồ sơ"));
        return requestCancelRepository.save(cancelRequest);
    }

    @Override
    public FilterResult searchHoso(FilterForm filterForm) {
        filterForm.setFiLstNSWFileCode(findLstNSWFileCode(filterForm));
        return regProfileRepository.searchHoso(filterForm);
    }


    private List<String> findLstNSWFileCode(FilterForm filterForm) {
        if (!filterForm.isValidForLicenseQuery()) return new ArrayList<>();
        return certRepo.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
                .stream().map(TbdCongvan06::getFiNSWFileCode).collect(Collectors.toList());
    }


    private String generateMaHoso(long id) {
        //HSCode Pattern: {Ministry's name}{ProcedureCode[2]}{Year[2]}{ID of HS[7]}
        return String.format("%s%s%02d%07d",
                Constant06.MINISTRY_NAME,
                Constant06.MARD_PROC_CODE,
                Calendar.getInstance().get(Calendar.YEAR) % 100,
                id);
    }
}
