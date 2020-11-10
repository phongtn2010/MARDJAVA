package com.nsw.backend.mard.p25.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.repositories.TbdYcrut25Repository;
import com.nsw.backend.mard.p25.service.TbdLichsu25Service;
import com.nsw.backend.mard.p25.model.*;
import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.mard.p25.helper.ReflectionHelper;
import com.nsw.backend.mard.p25.repositories.TbdHoso25Repository;
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

@Service
@Transactional
public class Tbdhoso25ServiceImpl implements TbdHoso25Service {

    private final TbdHoso25Repository regProfileRepository;
    private final TbdYcrut25Repository requestCancelRepository;
    private final TbdLichsu25Service hstService;

    @Autowired
    public Tbdhoso25ServiceImpl(TbdHoso25Repository regProfileRepository, TbdYcrut25Repository requestCancelRepository, TbdLichsu25Service hstService){
        this.regProfileRepository = regProfileRepository;
        this.requestCancelRepository = requestCancelRepository;
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
    public TbdHoso25 findById(int fiIdHoso) {
        return regProfileRepository.findOne(fiIdHoso);
    }

    @Override
    public List<TbdHoso25> findAll() { return regProfileRepository.findAll();}

    @Override
    public TbdHoso25 save(TbdHoso25 entity){
        entity = regProfileRepository.save(entity);
        if (StringUtils.isEmpty(entity.getFiNSWFileCode())) {
            entity.setFiNSWFileCode(generateMaHoso(entity.getFiIdHS()));
        }


//        entity.getFiProductList().forEach((product -> {
//            if (product.getFiId() == null) {
//                product.setFiId(product.getFiIdProduct());
//            }
//        }));
        return regProfileRepository.save(entity);
    }

    @Override
    public void delete(int fiIdHoso) {
        regProfileRepository.delete(fiIdHoso);
    }

    @Override
    public void delete(TbdHoso25 entity) {
        regProfileRepository.delete(entity);
    }

    @Override
    public TbdHoso25 create(TbdHoso25 entity) {
        entity.setFiActive(true);
        entity.setFiHSStatus(0);
        return this.save(entity);
    }

    @Override
    public TbdHoso25 update(TbdHoso25 entity) {
        TbdHoso25 currentHS = getInfoById(entity.getFiIdHS());
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
    public TbdHoso25 getInfoById(int fiIdHoso) {
        return this.findById(fiIdHoso);
    }

    @Override
    public boolean updateStatus(String fiMaHoso, int fiTrangthai) {
        TbdHoso25 bo = regProfileRepository.findFirstByFiNSWFileCodeAndFiActive(fiMaHoso, true).orElse(null);
        if (bo != null) {
            bo.setFiHSStatus(fiTrangthai);
            regProfileRepository.save(bo);
        }
        return false;
    }

    @Override
    public TbdHoso25 updateAfterSendNSW(TbdHoso25 updatedProfile) throws NSWException {
        // in-active hồ sơ gốc
        TbdHoso25 originalProfile = this.findById(updatedProfile.getFiIdHS());

        if (!originalProfile.isFiActive()) throw new NSWException("Hồ sơ không hợp lệ");

        originalProfile.setFiActive(false);

        int fiIdParentHS = updatedProfile.getFiIdHS();
        String fiParentHSCode = updatedProfile.getFiNSWFileCode();
        String fiModifyReason = updatedProfile.getFiReason();

        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiProductList());
        ReflectionHelper.cleanIdAndFields(updatedProfile.getFiAttachmentList());

        // tạo hồ sơ tạm
        updatedProfile.setFiIdHSParent(fiIdParentHS);
        updatedProfile.setFiIdHS(null);
        // Trạng thái hồ sơ hoạt động
        updatedProfile.setFiActive(true);
        updatedProfile.setFiCreatedDate(new Date());
        updatedProfile.setFiHSStatus(Constant25.HosoStatus.CHO_TIEP_NHAN.getId());

        updatedProfile = this.save(updatedProfile);
        regProfileRepository.save(originalProfile);

        //them mới vào bảng YCS

        return updatedProfile;
    }

    @Override
    public TbdHoso25 findByFiHSCode(String fiMaHoso) {
        return regProfileRepository.findFirstByFiNSWFileCodeAndFiActive(fiMaHoso, true).orElse(null);
    }

    @Override
    public List<TbdHoso25> findAllByFiHSStatus(int fiHSStatus) {
        return regProfileRepository.findAllByFiHSStatusAndFiActive(fiHSStatus, true);
    }

    @Override
    public void internalStatusUpdate(TbdHoso25 regProfile, int status) {
        regProfile.setFiHSStatus(status);
        String hstContent = "Cập nhật trạng thái hồ sơ: " + Constant25.HosoStatus.findById(status).getName();
        //hstService.save(createHistory(regProfile, hstContent,
                //"NSW",
                //regProfile.getFiTaxCode(),
                //regProfile.getFiImporterName()));
        this.save(regProfile);
    }

    @Override
    public void rollbackFailedRequestUpdate(TbdHoso25 result) {
        TbdHoso25 parent = regProfileRepository.findOne(result.getFiIdHSParent());
        parent.setFiActive(true);

        regProfileRepository.save(parent);
        regProfileRepository.delete(result.getFiIdHS());
        getSignPendingProfiles().invalidate(result.getFiNSWFileCode());
    }

    @Override
    public void rollbackFailedRequestUpdate(String nswFileCode) {
        TbdHoso25 current = findByFiHSCode(nswFileCode);
        if(Boolean.TRUE.equals(getSignPendingProfiles().getIfPresent(nswFileCode))) {
            rollbackFailedRequestUpdate(current);
        }
    }

    private TbdLichsu25 createHistory(TbdHoso25 profile, String historyContent) {
        TbdLichsu25 profileHst = new TbdLichsu25();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(historyContent);
        profileHst.setFiCreatedBy(profile.getFiSignName());
        //profileHst.setFiSenderUnitName(profile.getFiImporterName());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        return profileHst;
    }

    private TbdLichsu25 createHistory(TbdHoso25 regProfile, String hstContent, String senderCode, String senderName, String senderUnitName) {
        TbdLichsu25 history = new TbdLichsu25();
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
    public TbdYcrut25 cancelHoso(TbdYcrut25 cancelRequest){
        TbdHoso25 regProfile = regProfileRepository.findOne(cancelRequest.getFiIdHS());

        return requestCancelRepository.save(cancelRequest);
    }

    @Override
    public FilterResult searchHoso(FilterForm filterForm) {
        //filterForm.setFiLstNSWFileCode(findLstNSWFileCode(filterForm));
        return regProfileRepository.searchHoso(filterForm);
    }

    //private List<String> findLstNSWFileCode(FilterForm filterForm) {
    //    if (!filterForm.isValidForLicenseQuery()) return new ArrayList<>();
    //    return certRepo.findGPByFilter(filterForm.getLicenseNo(), filterForm.getLicenseStartDate(), filterForm.getLicenseEndDate())
    //            .stream().map(TbdHanghoa25::getFiNSWFileCode).collect(Collectors.toList());
    //}

    private String generateMaHoso(long id) {
        //HSCode Pattern: {Ministry's name}{Year[4]}{ID of HS[7]}
        return String.format("%s%s%02d%07d",
                Constant25.MINISTRY_NAME,
                Calendar.getInstance().get(Calendar.YEAR),
                id);
    }

    @Override
    public List<TbdHoso25> findByFiHSStatus(String taxCode,Integer from, Integer to) {
        return regProfileRepository.findByFiHSStatus(taxCode,from, to);
    }

}
