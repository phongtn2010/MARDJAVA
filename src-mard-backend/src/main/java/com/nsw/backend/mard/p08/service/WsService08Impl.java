/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.mard.p08.client.*;
import com.nsw.backend.mard.p08.constant.Constant08;
import com.nsw.backend.mard.p08.exception.NSWException;
import com.nsw.backend.mard.p08.helper.ReflectionHelper;
import com.nsw.backend.mard.p08.model.*;
import com.nsw.backend.mard.p08.repositories.Tbdcvcnkd08Repository;
import com.nsw.backend.mard.p08.repositories.Tbdcvvsty08Repository;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service("wsService08")
@Transactional(rollbackFor = NSWException.class)
public class WsService08Impl implements WsService08 {
    private static final Logger log = LoggerFactory.getLogger(WsService08Impl.class);

    private final Tbdhoso08Service regProfileService;

    private final Tbdlichsu08Service hstService;

    private final Tbdcvvsty08Repository vetHygRepo;

    private final Tbdcvcnkd08Repository quarantineRepo;

    private final Environment environment;

    private Gson gson;

    @Autowired
    public WsService08Impl(Tbdhoso08Service regProfileService, Tbdlichsu08Service hstService, Tbdcvvsty08Repository vetHygRepo, Tbdcvcnkd08Repository quarantineRepo, Environment environment) {
        this.regProfileService = regProfileService;
        this.hstService = hstService;
        this.vetHygRepo = vetHygRepo;
        this.quarantineRepo = quarantineRepo;
        this.environment = environment;
    }

    @Override
    public ResponseJson sendProfile(Tbdhoso08 regProfile) throws NSWException {
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant08.MessageType.TYPE_10);
        if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.TAO_MOI.getId()) {
            message.setFunction(Constant08.MessageFunction.FUNC_01);
        } else if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.CHO_TIEP_NHAN.getId()) {
            message.setFunction(Constant08.MessageFunction.FUNC_02);
        } else if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.YEU_CAU_BO_SUNG.getId()) {
            message.setFunction(Constant08.MessageFunction.FUNC_03);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }

        ResponseJson response = createSendRequest(Constant08.WebServiceURL.get(environment), message);
        if (response.isSuccess()) {
            int statusYCBS = Constant08.Hoso08Status.YEU_CAU_BO_SUNG.getId();
            int updateStatus = Constant08.Hoso08Status.CHO_TIEP_NHAN.getId();
            if (regProfile.getFiHSStatus() == statusYCBS) {
                updateStatus = Constant08.Hoso08Status.CHO_TIEP_NHAN_YCS.getId();
            }
            regProfile.setFiHSStatus((long) updateStatus);
            regProfile.setFiCreatedDate(new Date());
            regProfileService.update(regProfile);
            hstService.save(createHistory(regProfile, "Gửi hồ sơ", regProfile.getFiImporterName(), regProfile.getFiTaxCode()));
        }
        return response;
    }

    @Override
    public ResponseJson updateKqtd(ResponseWrapper request) {
        try {
            String function = request.getHeader().getSubject().getFunction();
            Tbdhoso08 regProfile = regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference());
            QuarantineResult quarantineResult = getGson().fromJson(getGson().toJson(request.getData()), QuarantineResult.class);
            int status;
            switch (function) {
                case Constant08.MessageFunction.FUNC_06:
                    status = Constant08.Hoso08Status.TU_CHOI_HO_SO.getId();
                    break;
                case Constant08.MessageFunction.FUNC_07:
                    status = Constant08.Hoso08Status.YEU_CAU_BO_SUNG.getId();
                    break;
                case Constant08.MessageFunction.FUNC_05:
                    status = Constant08.Hoso08Status.DA_TIEP_NHAN.getId();
                    break;
                default:
                    throw new NSWException("Invalid Function " + function + "on ProfileRegistration Response");
            }
            internalStatusUpdate(request.getHeader(), quarantineResult.getFiCreaterName(), status);
            if (!StringUtils.isEmpty(quarantineResult.getFiReason())) {
                hstService.save(createHistory(
                        regProfile,
                        "Phản hồi từ chuyên viên: " + quarantineResult.getFiReason(),
                        "Cục Thú Y",
                        quarantineResult.getFiCreaterName()));
            }
            return new ResponseJson(true, "");
        } catch (NSWException e) {
            log.debug("Exception caught", e);
            log.debug("Message: {}", e.getMessage());
            return new ResponseJson(false, "", e.getMessage());
        }
    }


    @Override
    public ResponseJson updateKQXinRutHS(ResponseWrapper responseWrapper) throws NSWException {
        QuarantineCancelResponse quarantineCancelResponse = getGson().fromJson(getGson().toJson(responseWrapper.getData()), QuarantineCancelResponse.class);
        Tbdhoso08 regProfile = regProfileService.findByFiHSCode(responseWrapper.getHeader().getSubject().getReference());
        if (Constant08.MessageFunction.FUNC_09.equals(responseWrapper.getHeader().getSubject().getFunction())) {
            hstService.save(createHistory(
                    regProfile,
                    "Yêu cầu rút được thông qua",
                    "Cục Thú Y",
                    quarantineCancelResponse.getFiCreaterName()));
            internalStatusUpdate(responseWrapper.getHeader(), quarantineCancelResponse.getFiCreaterName(), Constant08.Hoso08Status.DA_RUT_HO_SO.getId());
        } else {
            hstService.save(createHistory(
                    regProfile,
                    "Yêu cầu rút bị từ chối",
                    "Cục Thú Y",
                    quarantineCancelResponse.getFiCreaterName()));
            internalStatusUpdate(responseWrapper.getHeader(), quarantineCancelResponse.getFiCreaterName(), Constant08.Hoso08Status.TU_CHOI_YCR.getId());
        }
        if (!StringUtils.isEmpty(quarantineCancelResponse.getFiReason())) {
            hstService.save(createHistory(
                    regProfile,
                    "Phản hồi từ chuyên viên: " + quarantineCancelResponse.getFiReason(),
                    "Cục Thú Y",
                    quarantineCancelResponse.getFiCreaterName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson updateKQXinSuaHS(ResponseWrapper responseWrapper) throws NSWException {
        QuarantineCancelResponse quarantineCancelResponse = getGson().fromJson(getGson().toJson(responseWrapper.getData()), QuarantineCancelResponse.class);
        Tbdhoso08 regProfile = regProfileService.findByFiHSCode(responseWrapper.getHeader().getSubject().getReference());

        if (Constant08.MessageFunction.FUNC_16.equals(responseWrapper.getHeader().getSubject().getFunction())) {
            internalStatusUpdate(responseWrapper.getHeader(), quarantineCancelResponse.getFiCreaterName(), Constant08.Hoso08Status.DONG_Y_YCS.getId());
            hstService.save(createHistory(
                    regProfile,
                    "Yêu cầu sửa được thông qua",
                    "Cục Thú Y",
                    quarantineCancelResponse.getFiCreaterName()));

        } else {
            regProfile.setFiActive(false);
            Tbdhoso08 oldProfile = regProfileService.findById(regProfile.getFiIdHSParent());
            oldProfile.setFiActive(true);
            oldProfile.setFiHSStatus((long) Constant08.Hoso08Status.TU_CHOI_YCS.getId());
            regProfileService.save(regProfile);
            regProfile = regProfileService.save(oldProfile);
            hstService.save(createHistory(
                    regProfile,
                    "Yêu cầu sửa bị từ chối",
                    "Cục Thú Y",
                    quarantineCancelResponse.getFiCreaterName()));

        }
        if (!StringUtils.isEmpty(quarantineCancelResponse.getFiReason())) {
            hstService.save(createHistory(
                    regProfile,
                    "Phản hồi từ chuyên viên: " + quarantineCancelResponse.getFiReason(),
                    "Cục Thú Y",
                    quarantineCancelResponse.getFiCreaterName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson xlCVVSTY(ResponseWrapper request) throws NSWException {
        Header header = request.getHeader();
        VeterinaryHygiene vetHyg = getGson().fromJson(getGson().toJson(request.getData()), VeterinaryHygiene.class);
        Tbdcvvsty08 veterinaryHygieneDoc = new Tbdcvvsty08();
        BeanUtils.copyProperties(vetHyg, veterinaryHygieneDoc);
        ReflectionHelper.initListIfNull(vetHyg);
        veterinaryHygieneDoc.setFiHSCode(vetHyg.getFiNSWFileCode());
        veterinaryHygieneDoc.setFiCompanyName(vetHyg.getFiProductCompany());
        veterinaryHygieneDoc.setFiCompanyAddress(vetHyg.getFiProductCompanyAddress());
        veterinaryHygieneDoc.setFiExecutionTime(vetHyg.getFiAnimalExecutionTime());
        veterinaryHygieneDoc.setFiPurpose(vetHyg.getFiAnimalPurpose());
        veterinaryHygieneDoc.setFiContent(vetHyg.getFiResponseContent());
        veterinaryHygieneDoc.setFiRecipient(vetHyg.getFiRecipient());
        veterinaryHygieneDoc.setFiSignConfirmDate(vetHyg.getFiSignConfirmDate());
        veterinaryHygieneDoc.setFiSignConfirmName(vetHyg.getFiSignConfirmName());
        veterinaryHygieneDoc.setFiSignConfirmAddress(vetHyg.getFiSignConfirmAddress());
        veterinaryHygieneDoc.setFiSignConfirmTitle(vetHyg.getFiSignerRole());
        veterinaryHygieneDoc.setFiEditReason(vetHyg.getFiReasonEdit());
        vetHyg.getFiAnimalList().forEach(animal -> {
            Tbdvstydongvat08 animalDoc = new Tbdvstydongvat08();
            BeanUtils.copyProperties(animal, animalDoc);
            animalDoc.setFiAnimalSort((int) animal.getFiAnimalSort());
            animalDoc.setFiIdAnimal(animal.getFiAnimalId());
            animalDoc.setFiAnimalName(animal.getFiAnimalName());
            animalDoc.setFiCountryOrigin(animal.getFiAnimalExporterStateName());
            animalDoc.setFiQtyFemale(animal.getFiAnimalQuantityFemale());
            animalDoc.setFiQtyMale(animal.getFiAnimalQuantityMale());
            animalDoc.setFiPortName(animal.getFiAnimalPortOfDestinationName());
            veterinaryHygieneDoc.getLstAnimal().add(animalDoc);
        });
        veterinaryHygieneDoc.getLstCompany().add(new Tbdvstyctyxk08(vetHyg.getFiProductCompany(), vetHyg.getFiProductCompanyAddress()));

        if (null != vetHyg.getFiLocationQuarantineList()) {
            vetHyg.getFiLocationQuarantineList().forEach(isoLoc -> veterinaryHygieneDoc.getLstIsoLoc().add(
                    new Tbdvstyclkd08(isoLoc.getFiLocationQuarantineName(), isoLoc.getFiLocationQuarantineAddress())));
        }

        Tbdcvvsty08 oldVetHygDoc = vetHygRepo.findByFiHSCode(header.getSubject().getReference());
        if (oldVetHygDoc != null) {
            oldVetHygDoc.setLstAnimal(null);
            oldVetHygDoc.setLstCompany(null);
            oldVetHygDoc.setLstIsoLoc(null);
            vetHygRepo.delete(oldVetHygDoc);
            StringBuilder hstContent = new StringBuilder("Đã cấp công văn VSTY chỉnh sửa");
            if (!StringUtils.isEmpty(veterinaryHygieneDoc.getFiEditReason())) {
                hstContent.append(". Lý do: ").append(veterinaryHygieneDoc.getFiEditReason());
            }
            internalStatusUpdate(header, veterinaryHygieneDoc.getFiSignConfirmName(), Constant08.Hoso08Status.DA_CAP_GP_VSTY.getId(), hstContent.toString());
        } else {
            internalStatusUpdate(header, veterinaryHygieneDoc.getFiSignConfirmName(), Constant08.Hoso08Status.DA_CAP_GP_VSTY.getId());
        }
        vetHygRepo.save(veterinaryHygieneDoc);

        return new ResponseJson(true, vetHyg);
    }

    @Override
    public ResponseJson updateKDNK(ResponseWrapper request) throws NSWException {
        Quaranine quarantine = getGson().fromJson(gson.toJson(request.getData()), Quaranine.class);
        ReflectionHelper.initListIfNull(quarantine);
        Tbdcvcnkd08 quarantineDoc = new Tbdcvcnkd08();
        BeanUtils.copyProperties(quarantine, quarantineDoc);
        quarantineDoc.setFiHSCode(quarantine.getFiNSWFileCode());
        quarantineDoc.setFiQuarantineNo(quarantine.getFiQuarantineNo());
        quarantineDoc.setFiQuarantineType(quarantine.getFiProductType());
        quarantineDoc.setFiExecutionTime(quarantine.getFiMealExecutionTime());
        quarantineDoc.setFiPurpose(quarantine.getFiMealPurpose());
        quarantineDoc.setFiContent(quarantine.getFiResponseContent());
        quarantineDoc.setFiDispatchExpires(quarantine.getFiDispatchExpires());
        quarantineDoc.setFiEditReason(quarantine.getFiReasonEdit());
        quarantineDoc.setFiDispatchType(quarantine.getFiProductType());
        quarantineDoc.setFiEditReason(quarantine.getFiReasonEdit());
        quarantineDoc.setFiSignConfirmTitle(quarantine.getFiSignerRole());

        quarantineDoc.setLstCompany(new ArrayList<>());
        quarantine.getFiCompanyList().forEach(company -> {
            Tbdcnkdctyxk08 companyDoc = new Tbdcnkdctyxk08();
            BeanUtils.copyProperties(company, companyDoc);
            companyDoc.setFiExporterName(company.getFiCompanyName());
            companyDoc.setFiExporterAddress(company.getFiCompanyAddress());
            quarantineDoc.getLstCompany().add(companyDoc);
        });

        quarantineDoc.setLstProduct(new ArrayList<>());
        quarantine.getFiGoodsList().forEach(goods -> {
            Tbdcnkdhanghoa08 goodsDoc = new Tbdcnkdhanghoa08();
            BeanUtils.copyProperties(goods, goodsDoc);
            goodsDoc.setFiAge((int) goods.getFiAge());
            goodsDoc.setFiSort(goods.getFiGoodsSort());
            goodsDoc.setFiProductCode(goods.getFiCodeOfGoods());
            goodsDoc.setFiProductName(goods.getFiNameOfGoods());
            goodsDoc.setFiProductScienceName(goods.getFiNameSicenceOfGoods());
            goodsDoc.setFiQtyFemale(goods.getFiAnimalQuantityFemale());
            if (quarantine.getFiProductType() == 4) {
                goodsDoc.setFiQtyMale(goods.getFiQuantityOrVolumn().intValue());
            }
            goodsDoc.setFiQtyMale(goods.getFiAnimalQuantityMale());
            goodsDoc.setFiPackingType(goods.getFiWayOfPackinglist());
            goodsDoc.setFiNumber(goods.getFiQuantityOrVolumn());
            goodsDoc.setFiUnitCode(goods.getFiQuantityUnitCode());
            goodsDoc.setFiUnitName(goods.getFiQuantityUnitName());
            goodsDoc.setFiNetWeight(goods.getFiNetWeight());
            goodsDoc.setFiNWUnitCode(goods.getFiNetWeightUnitCode());
            goodsDoc.setFiNWUnitName(goods.getFiNetWeightUnitName());
            goodsDoc.setFiGrossWeight(goods.getFiGrossWeight());
            goodsDoc.setFiGWUnitCode(goods.getFiGrossWeightUnitCode());
            goodsDoc.setFiGWUnitName(goods.getFiGrossWeightUnitName());
            goodsDoc.setFiPurpose(goods.getFiPurposeUse());
            goodsDoc.setFiCountryOriginName(goods.getFiOriginationName());
            goodsDoc.setFiCountryOrigin(goods.getFiOriginationCode());
            goodsDoc.setFiPortName(goods.getFiImportPortOfDestinationName());
            goodsDoc.duplicateQuantityData();
            //KD DONG VAT
            if (quarantine.getFiProductType() == 2 || quarantine.getFiProductType() == 3) {
                //SAN PHAM DONG VAT / BOT THIT XUONG
                goodsDoc.setFiNetWeight(goodsDoc.getFiNumber());
                goodsDoc.setFiNWUnitCode(goods.getFiQuantityUnitCode());
                goodsDoc.setFiNWUnitName(goods.getFiQuantityUnitName());
                goodsDoc.setFiNumber(-1d);
                goodsDoc.setFiGrossWeight(-1d);
            }
            quarantineDoc.getLstProduct().add(goodsDoc);
        });

        quarantineDoc.setLstMfr(new ArrayList<>());
        quarantine.getFiManufactureList().forEach(manufacturer -> {
            Tbdcnkdnmsx08 manufacturerDoc = new Tbdcnkdnmsx08();
            BeanUtils.copyProperties(manufacturer, manufacturerDoc);
            manufacturerDoc.setFiFactoryName(manufacturer.getFiManufactureName());
            manufacturerDoc.setFiFactoryAddress(manufacturer.getFiManufactureAddress());
            quarantineDoc.getLstMfr().add(manufacturerDoc);
        });

        quarantineDoc.setLstIsoLoc(new ArrayList<>());
        quarantine.getFiLocationQuarantineList().forEach(locationQuarantine -> {
            Tbdcnkdddcl08 locationQuarantineDoc = new Tbdcnkdddcl08();
            BeanUtils.copyProperties(locationQuarantine, locationQuarantineDoc);
            locationQuarantineDoc.setFiIsoLocName(locationQuarantine.getFiLocationQuarantineName());
            locationQuarantineDoc.setFiIsoLocAddress(locationQuarantine.getFiLocationQuarantineAddress());
            quarantineDoc.getLstIsoLoc().add(locationQuarantineDoc);
        });
        Tbdcvcnkd08 oldQuarantineDoc = quarantineRepo.findFirstByFiHSCodeOrderByFiIdCVDesc(request.getHeader().getSubject().getReference());
        if (oldQuarantineDoc != null) {
            oldQuarantineDoc.setLstCompany(null);
            oldQuarantineDoc.setLstIsoLoc(null);
            oldQuarantineDoc.setLstMfr(null);
            oldQuarantineDoc.setLstProduct(null);
            quarantineRepo.delete(oldQuarantineDoc);
            StringBuilder hstContent = new StringBuilder("Đã cấp công văn KDNK chỉnh sửa");
            if (!StringUtils.isEmpty(quarantineDoc.getFiEditReason())) {
                hstContent.append(". Lý do: ").append(quarantineDoc.getFiEditReason());
            }
            internalStatusUpdate(request.getHeader(), quarantineDoc.getFiSignConfirmName(), Constant08.Hoso08Status.DA_CAP_GP_KDNK.getId(), hstContent.toString());
        } else {
            internalStatusUpdate(request.getHeader(), quarantineDoc.getFiSignConfirmName(), Constant08.Hoso08Status.DA_CAP_GP_KDNK.getId());
        }
        quarantineRepo.save(quarantineDoc);

        //Update RegProfile License
        Tbdhoso08 regProfile = regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference());
        regProfile.setFiLicenseNo(quarantine.getFiQuarantineNo());
        regProfile.setFiLicensedDate(quarantine.getFiSignConfirmDate());
        regProfileService.save(regProfile);
        return new ResponseJson(true, quarantineDoc);
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                    .create();
        }
        return gson;
    }

    private Tbdlichsu08 createHistory(Tbdhoso08 regProfile, String hstContent, String senderCode, String senderName) {
        Tbdlichsu08 history = new Tbdlichsu08();
        history.setFiSenderUnitCode(senderCode);
        if (StringUtils.isNotEmpty(senderCode)) {
            history.setFiSenderUnitName(senderCode);
        }
        history.setFiSenderName(senderName);
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiHSCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiTimeline(new Date());
        history.setFiReceiverCode("NSW");
        history.setFiReceiverName("Cổng thông tin một cửa quốc gia");
        history.setFiStatus(regProfile.getFiHSStatus());

        return history;
    }

    @Override
    public void internalStatusUpdate(Header header, String exactSenderName, long status, String... reasons) throws NSWException {
        if (status != -1) {
            Tbdhoso08 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
            if (regProfile == null) {
                throw new NSWException("Mã hồ sơ không tồn tại");
            }
            regProfile.setFiHSStatus(status);
            String hstContent = "Cập nhật trạng thái hồ sơ: " + Constant08.Hoso08Status.findById((int) status).getName();

            if (reasons.length > 0) {
                hstContent = reasons[0];
            }

            hstService.save(createHistory(regProfile, hstContent,
                    "Cục Thú Y",
                    exactSenderName));
            regProfileService.save(regProfile);
        } else {
            throw new IllegalArgumentException("Status must not be -1");
        }
    }

    @Override
    public ResponseJson requestUpdateProfile(RequestEdit requestEdit) {
        SendMessage message = SendMessage.parse(requestEdit.getRegProfile());
        message.setType(Constant08.MessageType.TYPE_17);
        message.setFunction(Constant08.MessageFunction.FUNC_15);
        message.setReason(requestEdit.getFiReason());
        return createSendRequest(Constant08.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException {
        Tbdhoso08 regProfile = requestCancel.getRegProfile();
        SendMessage message = SendMessage.parse(regProfile);
        message.setReason(requestCancel.getFiReason());
        if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.CHO_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant08.Hoso08Status.YEU_CAU_BO_SUNG.getId()
        ) {
            message.setType(Constant08.MessageType.TYPE_11);
            message.setFunction(Constant08.MessageFunction.FUNC_04);
        } else if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.DA_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant08.Hoso08Status.DONG_Y_YCS.getId()
                || regProfile.getFiHSStatus() == Constant08.Hoso08Status.TU_CHOI_YCR.getId()) {
            message.setType(Constant08.MessageType.TYPE_13);
            message.setFunction(Constant08.MessageFunction.FUNC_08);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }
        return createSendRequest(Constant08.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson updateKQVSTY(ResponseWrapper responseWrapper) throws NSWException {
        VeterinaryHygieneResult veterinaryHygieneResult = getGson().fromJson(gson.toJson(responseWrapper.getData()), VeterinaryHygieneResult.class);
        if (veterinaryHygieneResult != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            internalStatusUpdate(responseWrapper.getHeader(), veterinaryHygieneResult.getFiCreaterName(), Constant08.Hoso08Status.DA_CO_KQ_VSTY.getId(), String.format(
                    "Kết quả VSTY không đạt. Chuyên viên xử lý: %s. Đơn vị xử lý: %s. Ngày xử lý: %s",
                    veterinaryHygieneResult.getFiCreaterName(),
                    veterinaryHygieneResult.getFiDepartment(),
                    simpleDateFormat.format(veterinaryHygieneResult.getFiResultDate())
            ));
            return new ResponseJson(true, "Cập nhật phản hồi VSTY thành công");
        } else {
            return new ResponseJson(false, "Không tìm thấy dữ liệu");
        }
    }

    @Override
    public ResponseJson getXml(SendMessage sendMessage) throws NSWException {
        Tbdhoso08 regProfile = regProfileService.findByFiHSCode(sendMessage.getFiNSWFileCode());
        if (regProfile == null) throw new NSWException("Hồ sơ không tồn tại");
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(sendMessage.getType());
        message.setXmlOnly(Boolean.TRUE);
        if (Constant08.MessageType.TYPE_10.equals(message.getType())) {
            if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.TAO_MOI.getId() ||
                    regProfile.getFiHSCode() == null) {
                message.setFunction(Constant08.MessageFunction.FUNC_01);
            } else if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.CHO_TIEP_NHAN.getId()) {
                message.setFunction(Constant08.MessageFunction.FUNC_02);
            } else if (regProfile.getFiHSStatus() == Constant08.Hoso08Status.YEU_CAU_BO_SUNG.getId()) {
                message.setFunction(Constant08.MessageFunction.FUNC_03);
            } else {
                throw new NSWException("Hồ sơ không hợp lệ");
            }
        } else if (Constant08.MessageType.TYPE_17.equals(message.getType())) {
            message.setFunction(Constant08.MessageFunction.FUNC_15);
            message.setReason(regProfile.getFiModifyReason());
        } else {
            throw new NSWException("Bản tin yêu cầu chưa hỗ trợ ký số");
        }
        ResponseJson response = createSendRequest(Constant08.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        return response;
    }

    private ResponseJson createSendRequest(String url, SendMessage sendData) {
        log.debug("attempt to send: {} {}", url, sendData);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SendMessage> entity = new HttpEntity<>(sendData, headers);
        ResponseJson response = new ResponseJson();
        response.setSuccess(false);
        try {
            response = restTemplate.postForObject(url, entity, ResponseJson.class);
            log.debug("Response: {}", response);
        } catch (Exception ex) {
            log.debug("Call WS Error!");
        }
        return response;
    }
}
