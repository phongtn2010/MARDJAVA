package com.nsw.backend.mard.p01.service;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p01.constant.Constant01;
import com.nsw.backend.mard.p01.dto.RequestProEdit;
import com.nsw.backend.mard.p01.exception.NSWException;
import com.nsw.backend.mard.p01.helper.ReflectionHelper;
import com.nsw.backend.mard.p01.model.*;
import com.nsw.backend.mard.p01.repositories.Tbddinhkem01Repository;
import com.nsw.backend.mard.p01.repositories.Tbdhoso01Repository;
import com.nsw.backend.mard.p01.repositories.Tbdycrut01Repository;
import com.nsw.backend.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("tbdhoso01Service")
@Transactional
public class Tbdhoso01ServiceImpl implements Tbdhoso01Service {

    private final Tbdhoso01Repository tbdhoso01Repository;

    private final Tbddinhkem01Repository tbddinhkem01Repository;

    private final Tbdycrut01Repository tbdycrut01Repository;

    private final Tbdlichsu01Service hstService;

    private final GiayCN01Service certService;

    @Autowired
    public Tbdhoso01ServiceImpl(Tbdhoso01Repository tbdhoso01Repository, Tbddinhkem01Repository tbddinhkem01Repository, Tbdycrut01Repository tbdycrut01Repository, Tbdlichsu01Service hstService, GiayCN01Service certService) {
        this.tbdhoso01Repository = tbdhoso01Repository;
        this.tbddinhkem01Repository = tbddinhkem01Repository;
        this.tbdycrut01Repository = tbdycrut01Repository;
        this.hstService = hstService;
        this.certService = certService;
    }

    @Override
    public Tbdhoso01 create(Tbdhoso01 tbdhoso01) {
        ReflectionHelper.initListIfNull(tbdhoso01);
        tbdhoso01.setFiActive(true);
        tbdhoso01.setFiPaymentStatus((long) Constant01.Hoso01pPaymentStatus.INIT.getId());
        tbdhoso01.setFiHSStatus((long) Constant01.Hoso01Status.TAO_MOI.getId());
        Tbdhoso01 bo = tbdhoso01Repository.save(tbdhoso01);
        bo.setFiNSWFileCode(generateMaHoso(bo.getFiIdHS()));
        bo.getFiAttachmentList().forEach(dinhkem -> {
            dinhkem.setFiIdHS(bo.getFiIdHS());
            dinhkem.setFiActive(Constant01.ACTIVE);
            tbddinhkem01Repository.save(dinhkem);
        });
        bo.getFiAnimalProductList().forEach(animalProduct -> animalProduct.setFiAnimalProductID(String.format("%d", animalProduct.getFiIdAnimailProduct())));
        bo.getFiAnimalList().forEach(animal -> animal.setFiID(String.format("%d", animal.getFiIdAnimail())));
        tbdhoso01Repository.save(bo);
        return bo;
    }

    @Override
    public Tbdhoso01 save(Tbdhoso01 tbdhoso01) {
        return tbdhoso01Repository.save(tbdhoso01);
    }

    @Override
    public Tbdhoso01 findById(Long fiIdHS) {
        return tbdhoso01Repository.findOne(fiIdHS);
    }

    @Override
    public Tbdhoso01 update(Tbdhoso01 entity) {
        ReflectionHelper.initListIfNull(entity);

        Tbdhoso01 currentHS = findById(entity.getFiIdHS());
        entity.setFiHSStatus(currentHS.getFiHSStatus());
        entity.setFiNSWFileCode(currentHS.getFiNSWFileCode());
        entity.setFiPaymentStatus(currentHS.getFiPaymentStatus());
        entity.setFiActive(true);
        entity.setFiCreatedBy(currentHS.getFiCreatedBy());
        entity.setFiCreatedDate(currentHS.getFiCreatedDate());
        if (entity.getFiHSStatus() == null) {
            entity.setFiHSStatus(currentHS.getFiHSStatus());
        }
        return tbdhoso01Repository.save(entity);
    }

    @Override
    public Tbdhoso01 updateAfterSendNSW(RequestProEdit requestProEdit) throws NSWException {
        // hồ sơ cũ
        Tbdhoso01 originalProfile = this.findByFiHSCode(requestProEdit.getFiRegistrationProfile().getFiNSWFileCode());
        if (originalProfile.getFiHSStatus() != Constant01.Hoso01Status.DA_TIEP_NHAN.getId() &&
                originalProfile.getFiHSStatus() != Constant01.Hoso01Status.TU_CHOI_RUT_HS.getId() &&
                originalProfile.getFiHSStatus() != Constant01.Hoso01Status.DONG_Y_SUA_HS.getId()) {
            throw new NSWException("Hồ sơ không hợp lệ");
        }
        if (Boolean.FALSE.equals(originalProfile.getFiActive())) throw new NSWException("Hồ sơ không hợp lệ");

        originalProfile.setFiActive(false);

        // hồ sơ mới
        Tbdhoso01 updatedProfile = requestProEdit.getFiRegistrationProfile();

        updatedProfile.setFiIdHS(null);
        updatedProfile.setFiCreatedDate(new Date());
        updatedProfile.setFiCreatedBy(originalProfile.getFiCreatedBy());
        updatedProfile.setFiHSStatus((long) Constant01.Hoso01Status.CHO_TIEP_NHAN_SUA_HS.getId());
        updatedProfile.setFiIdHSParent(originalProfile.getFiIdHS());
        updatedProfile.setFiPaymentStatus(originalProfile.getFiPaymentStatus());
        updatedProfile.setFiCNKDId(originalProfile.getFiCNKDId());
        updatedProfile.setFiLicenseType(originalProfile.getFiLicenseType());
        updatedProfile.setFiLicenseNo(originalProfile.getFiLicenseNo());
        updatedProfile.setFiNSWFileCode(originalProfile.getFiNSWFileCode());
        updatedProfile.setFiActive(true);

        // Ghi lại lịch sử cập nhật
        Tbdlichsu01 profileHst = new Tbdlichsu01();
        profileHst.setFiNSWFileCode(originalProfile.getFiNSWFileCode());
        profileHst.setFiIdHS(originalProfile.getFiIdHS());
        profileHst.setFiHSCode(originalProfile.getFiNSWFileCode());
        profileHst.setFiStatus((long) Constant01.Hoso01Status.CHO_TIEP_NHAN_SUA_HS.getId());
        profileHst.setFiSenderCode(originalProfile.getFiCreatedBy());
        profileHst.setFiContent("Cập nhật hồ sơ tạo yêu cầu xin sửa");
        profileHst.setFiSenderUnitName(originalProfile.getFiExporterNameVni());
        profileHst.setFiSenderName(originalProfile.getFiTaxCode());
        hstService.save(profileHst);

        this.save(originalProfile);
        updatedProfile.setFiPaymentStatus(originalProfile.getFiPaymentStatus());
        updatedProfile = this.create(updatedProfile);
        updatedProfile.setFiHSStatus((long) Constant01.Hoso01Status.CHO_TIEP_NHAN_SUA_HS.getId());
        updatedProfile.setFiNSWFileCode(originalProfile.getFiNSWFileCode());
        this.save(updatedProfile);
        return updatedProfile;
    }

    @Override
    public FilterResult searchHoso(FilterForm filter) {
        filter.setFiLstNSWFileCode(certService.findLstNSWFileCode(filter));
        return tbdhoso01Repository.searchHoso(filter);
    }

    @Override
    public Tbdhoso01 findByFiHSCode(String fiMaHoso) {
        try {
            return tbdhoso01Repository.findFirstByFiNSWFileCodeAndFiActive(fiMaHoso, true).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Tbdycrut01 cancelHoso(Tbdycrut01 ruts01) throws NSWException {
        Tbdhoso01 regProfile = tbdhoso01Repository.findFirstByFiNSWFileCodeAndFiActive(ruts01.getFiNSWFileCode(), true).orElse(null);
        if (regProfile == null || regProfile.getFiHSStatus() != Constant01.Hoso01Status.CHO_TIEP_NHAN.getId()
                && regProfile.getFiHSStatus() != Constant01.Hoso01Status.DA_TIEP_NHAN.getId()
                && regProfile.getFiHSStatus() != Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId()
                && regProfile.getFiHSStatus() != Constant01.Hoso01Status.DONG_Y_SUA_HS.getId()
                && regProfile.getFiHSStatus() != Constant01.Hoso01Status.TU_CHOI_RUT_HS.getId()) {
            throw new NSWException("Trạng thái hồ sơ không hợp lệ");
        }

        ruts01.setFiIdHS(regProfile.getFiIdHS());
        ruts01.setFiActive(Constant01.ACTIVE);
        ruts01.setFiStatus((long) Constant01.Hoso01DeleteStatus.TAO_MOI.getId());
        ruts01.setFiRequestedDate(DateTimeUtils.getDate());

        if (Constant01.Hoso01Status.CHO_TIEP_NHAN.getId() == regProfile.getFiHSStatus()
                || Constant01.Hoso01Status.YC_SUA_DOI_BO_XUNG.getId() == regProfile.getFiHSStatus()
                || Constant01.Hoso01Status.DONG_Y_SUA_HS.getId() == regProfile.getFiHSStatus()
        ) {
            ruts01.setFiRequestType(0L); // hố sơ chưa tiếp nhận
            regProfile.setFiHSStatus((long) Constant01.Hoso01Status.DA_RUT_HS.getId());
        } else {
            ruts01.setFiRequestType(1L);  // hồ sơ đã tiếp nhận
            regProfile.setFiHSStatus((long) Constant01.Hoso01Status.YC_RUT_HS.getId());
        }
        tbdhoso01Repository.save(regProfile);
        hstService.save(createHistoryLog(regProfile, "Yêu cầu rút hồ sơ"));
        return tbdycrut01Repository.save(ruts01);
    }

    @Override
    public void internalStatusUpdate(Tbdhoso01 regProfile, long status) {
        regProfile.setFiHSStatus(status);
        String hstContent = "Cập nhật trạng thái hồ sơ: " + Constant01.Hoso01Status.findById((int) status).getName();
        hstService.save(createHistory(regProfile, hstContent,
                "NSW"
        ));
        this.save(regProfile);
    }

    @Override
    public void rollbackFailedRequestUpdate(Tbdhoso01 result) {
        Tbdhoso01 parent = tbdhoso01Repository.findOne(result.getFiIdHSParent());
        parent.setFiActive(true);
        tbdhoso01Repository.save(parent);

        tbdhoso01Repository.delete(result.getFiIdHS());
        getSignPendingProfiles().invalidate(result.getFiNSWFileCode());
    }

    @Override
    public void rollbackFailedRequestUpdate(String nswFileCode) {
        Tbdhoso01 current = findByFiHSCode(nswFileCode);
        if(Boolean.TRUE.equals(getSignPendingProfiles().getIfPresent(nswFileCode))) {
            rollbackFailedRequestUpdate(current);
        }
    }

    private Tbdlichsu01 createHistory(Tbdhoso01 regProfile, String hstContent, String senderCode) {
        Tbdlichsu01 history = new Tbdlichsu01();
        history.setFiSenderCode(senderCode);
        history.setFiSenderUnitName(regProfile.getFiExporterNameVni());
        history.setFiSenderName(regProfile.getFiTaxCode());
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiNSWFileCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiTimeline(new Date());
        history.setFiReceiverCode("BNN");
        history.setFiReceiverName("Bộ Nông nghiệp");
        history.setFiStatus(regProfile.getFiHSStatus());
        return history;
    }

    /***
     * HSCode Pattern: {Ministry's name}{ProcedureCode[2]}{Year[2]}{ID of HS[7]}
     */

    private Tbdlichsu01 createHistoryLog(Tbdhoso01 profile, String historyContent) {
        Tbdlichsu01 profileHst = new Tbdlichsu01();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiNSWFileCode(profile.getFiNSWFileCode());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(historyContent);
        profileHst.setFiSenderUnitName(profile.getFiExporterNameVni());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        return profileHst;
    }

    private String generateMaHoso(Long id) {
        return String.format("%s%s%02d%07d",
                Constant01.MINISTRY_NAME,
                Constant01.MARD_PROC_CODE,
                Calendar.getInstance().get(Calendar.YEAR) % 100,
                id);
    }

    private List<String> pendingProfiles;
    private LoadingCache<String, Boolean> pendingQueue;

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
