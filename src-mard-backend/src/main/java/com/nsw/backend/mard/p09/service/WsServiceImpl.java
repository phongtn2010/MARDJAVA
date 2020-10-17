package com.nsw.backend.mard.p09.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p08.model.Tbdcnkdhanghoa08;
import com.nsw.backend.mard.p08.model.Tbdcvcnkd08;
import com.nsw.backend.mard.p08.repositories.Tbdcvcnkd08Repository;
import com.nsw.backend.mard.p09.client.*;
import com.nsw.backend.mard.p09.constant.Constant09;
import com.nsw.backend.mard.p09.dto.receive.*;
import com.nsw.backend.mard.p09.dto.send.Attachment;
import com.nsw.backend.mard.p09.dto.send.*;
import com.nsw.backend.mard.p09.exception.NSWException;
import com.nsw.backend.mard.p09.helper.WsServiceHelper;
import com.nsw.backend.mard.p09.model.*;
import com.nsw.backend.mard.p09.repositories.TbdXacnhan09Repository;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service("wsService09")
@Transactional(rollbackFor = NSWException.class)
public class WsServiceImpl implements WsService {
    private static final Logger log = LoggerFactory.getLogger(WsServiceImpl.class);
    private static final List<Constant09.Hoso09Status> quotableStatus = Arrays.asList(
            Constant09.Hoso09Status.DA_TIEP_NHAN,
            Constant09.Hoso09Status.YEU_CAU_BO_SUNG,
            Constant09.Hoso09Status.DA_RUT_HO_SO,
            Constant09.Hoso09Status.TU_CHOI_HO_SO,
            Constant09.Hoso09Status.DONG_Y_YCS
    );
    private final Tbdhoso09Service regProfileService;
    private final Tbdlichsu09Service hstService;
    private final GiayCN09Service certService;
    private final Tbdcvcnkd08Repository cert08Repo;
    private final Phi09Service feeService;
    private final TbdXacnhan09Repository regConfirmationRepository;
    private final Environment environment;
    private Gson gson;

    @Autowired
    public WsServiceImpl(Tbdhoso09Service regProfileService, Tbdlichsu09Service hstService, GiayCN09Service certService, Tbdcvcnkd08Repository cert08Repo, Phi09Service feeService, TbdXacnhan09Repository regConfirmationRepository, Environment environment) {
        this.regProfileService = regProfileService;
        this.hstService = hstService;
        this.certService = certService;
        this.cert08Repo = cert08Repo;
        this.feeService = feeService;
        this.regConfirmationRepository = regConfirmationRepository;
        this.environment = environment;
    }

    @Override
    public ResponseJson sendProfile(Tbdhoso09 regProfile) throws NSWException {
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant09.MessageType.TYPE_10);
        if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.TAO_MOI.getId()) {
            message.setFunction(Constant09.MessageFunction.FUNC_01);
        } else if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.CHO_TIEP_NHAN.getId()) {
            message.setFunction(Constant09.MessageFunction.FUNC_02);
        } else if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId()) {
            message.setFunction(Constant09.MessageFunction.FUNC_04);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }


        ResponseJson response = WsServiceHelper.createSendRequest(Constant09.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
            // Ghi lại lịch sử gửi mới
            long statusYCBS = Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId();
            long updateStatus = Constant09.Hoso09Status.CHO_TIEP_NHAN.getId();
            if (regProfile.getFiHSStatus() == statusYCBS || regProfile.getFiKDStatus() == statusYCBS || regProfile.getFiGSStatus() == statusYCBS) {
                updateStatus = Constant09.Hoso09Status.CHO_TIEP_NHAN_YCS.getId();
            }
            regProfile.setFiHSStatus(updateStatus);
            if (regProfile.isParallel()) {
                regProfile.setFiKDStatus(-1L);
                regProfile.setFiGSStatus(updateStatus);
            } else {
                regProfile.setFiKDStatus(updateStatus);
                regProfile.setFiGSStatus(-1L);
            }
            regProfile.setFiCreatedDate(new Date());
            regProfileService.update(regProfile);
            hstService.save(createHistory(regProfile, "Gửi mới hồ sơ"));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi hồ sơ! " + response.getMessage());
        }
        return response;
    }

    @Override
    public ResponseJson updateProfile(RequestEdit requestEdit) {
        SendMessage message = SendMessage.parse(requestEdit.getRegProfile());
        message.setType(Constant09.MessageType.TYPE_13);
        message.setFunction(Constant09.MessageFunction.FUNC_08);
        message.setReason(requestEdit.getFiReason());
        return WsServiceHelper.createSendRequest(Constant09.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException {
        Tbdhoso09 regProfile = requestCancel.getRegProfile();
        SendMessage message = SendMessage.parse(regProfile);
        message.setReason(requestCancel.getFiReason());
        if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.CHO_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId()
        ) {
            message.setType(Constant09.MessageType.TYPE_15);
            message.setFunction(Constant09.MessageFunction.FUNC_03);
        } else if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.DA_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant09.Hoso09Status.DA_XM_DON_DK.getId()
                || regProfile.getFiHSStatus() == Constant09.Hoso09Status.DONG_Y_YCS.getId()
                || regProfile.getFiHSStatus() == Constant09.Hoso09Status.TU_CHOI_YCR.getId()) {
            message.setType(Constant09.MessageType.TYPE_16);
            message.setFunction(Constant09.MessageFunction.FUNC_11);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }
        return WsServiceHelper.createSendRequest(Constant09.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson remarkQualityCertificate(ResponseQualityResult qualityResult) {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(qualityResult.getFiNSWFileCode());
        SendMessage message = SendMessage.parse(regProfile);
        message.setFiNguoitao(qualityResult.getFiResponseUser());
        message.setType(Constant09.MessageType.TYPE_27);
        message.setFunction(Constant09.MessageFunction.FUNC_27);
        message.setReason(qualityResult.getFiDeescription());
        return WsServiceHelper.createSendRequest(Constant09.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson requestModifyCertificate(RequestEditCer requestEditCer) {
        requestEditCer.setFiAttachmentList(new ArrayList<>());
        requestEditCer.getLstAtch().forEach(atch -> {
            atch.setFiHoatdong(1L);
            Attachment attachment = new Attachment();
            attachment.setFiAttachmentId(atch.getFiGuid());
            attachment.setFiLinkFile(atch.getFiDuongDan());
            attachment.setFiAttachmentTypeName(atch.getFiTenLoai());
            attachment.setFiAttachmentTypeCode(atch.getFiMaLoai());
            attachment.setFiAttachmentName(atch.getFiTenTep());
            requestEditCer.getFiAttachmentList().add(attachment);
        });
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(requestEditCer.getFiNSWFileCode());
        hstService.save(createHistory(regProfile, String.format("Yêu cầu chỉnh sửa giấy phép %s với lí do: %s", requestEditCer.getFiCertificateNo(), requestEditCer.getFiReason())));
        certService.requestModifyCertificate(requestEditCer);
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant09.MessageType.TYPE_23);
        message.setFunction(Constant09.MessageFunction.FUNC_21);
        message.setData(requestEditCer);
        return WsServiceHelper.createSendRequest(Constant09.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson processProfileRegisterResponse(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();
        long status;
        switch (function) {
            case Constant09.MessageFunction.FUNC_05:
                status = Constant09.Hoso09Status.TU_CHOI_HO_SO.getId();
                break;
            case Constant09.MessageFunction.FUNC_06:
                status = Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId();
                break;
            case Constant09.MessageFunction.FUNC_29:
                status = Constant09.Hoso09Status.DA_TIEP_NHAN.getId();
                break;
            default:
                throw new NSWException("Invalid Function " + function + "on ProfileRegistration Response");
        }
        KetQuaThamDinh kqtd = getGson().fromJson(getGson().toJson(request.getData()), KetQuaThamDinh.class);
        internalStatusUpdate(request.getHeader(), kqtd.getFiCvXl(), status);
        if (!StringUtils.isEmpty(kqtd.getFiLydo())) {
            internalStatusUpdate(request.getHeader(), kqtd.getFiCvXl(), status, "Phản hồi từ chuyên viên: " + kqtd.getFiLydo());
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processProfileConfirmation(ResponseWrapper request) throws NSWException {
        Header header = request.getHeader();
        XacNhanDon regConfirmation = getGson().fromJson(getGson().toJson(request.getData()), XacNhanDon.class);

        internalStatusUpdate(header, regConfirmation.getFiSignConfirmName(), Constant09.Hoso09Status.DA_XM_DON_DK.getId());
        TbdXacnhan09 regConfirmationEntity = new TbdXacnhan09();
        BeanUtils.copyProperties(regConfirmation, regConfirmationEntity);
        regConfirmationEntity.setFiAnanyticalRequiredList(new ArrayList<>());
        regConfirmation.getFiAnanyticalRequiredList().forEach(ananytical -> regConfirmationEntity.getFiAnanyticalRequiredList().add(
                new TdbXnChitieu09(ananytical.getFiAnanyticalCode(),
                        ananytical.getFiAnanyticalName(),
                        ananytical.getFiRequired())));
        regConfirmationEntity.setFiNSWFileCode(header.getSubject().getReference());

        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
        if (regProfile != null) {
            if (StringUtils.isEmpty(regConfirmationEntity.getFiRegistrationComfirmNo())) {
                regProfile.setFiRegistrationComfirmNo(" ");
            } else {
                regProfile.setFiRegistrationComfirmNo(regConfirmationEntity.getFiRegistrationComfirmNo());
            }
            regProfileService.save(regProfile);
            regConfirmationRepository.save(regConfirmationEntity);
            return new ResponseJson(true, "", "");
        } else {
            return new ResponseJson(false, "", "Hồ sơ không tồn tại");
        }
    }

    @Override
    public ResponseJson processRequestUpdateProfileResponse(ResponseWrapper request) throws NSWException {
        ResponseEdit responseEdit = getGson().fromJson(getGson().toJson(request.getData()), ResponseEdit.class);
        Subject requestSubject = request.getHeader().getSubject();
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference());
        responseEdit.setFiNSWFileCode(requestSubject.getReference());
        if (requestSubject.getFunction().equals(Constant09.MessageFunction.FUNC_09)) {
            processQuotaOnUpdate(request.getHeader(), Constant09.Hoso09Status.TU_CHOI_HO_SO.getId());
            internalStatusUpdate(request.getHeader(), responseEdit.getFiCreaterName(), Constant09.Hoso09Status.DONG_Y_YCS.getId());
        } else if (requestSubject.getFunction().equals(Constant09.MessageFunction.FUNC_10)) {
            regProfile.setFiActive(false);
            Tbdhoso09 oldProfile = regProfileService.findById(regProfile.getFiIdHSParent());
            oldProfile.setFiActive(true);
            regProfileService.save(regProfile);
            regProfile = regProfileService.save(oldProfile);
            internalStatusUpdate(request.getHeader(), responseEdit.getFiCreaterName(), Constant09.Hoso09Status.TU_CHOI_YCS.getId());
        }
        hstService.save(createHistory(regProfile, String.format("Yêu cầu sửa %s",
                requestSubject.getFunction().equals(Constant09.MessageFunction.FUNC_09) ? "được thông qua" : "bị từ chối"), request.getHeader(), responseEdit.getFiCreaterName()));
        if (!StringUtils.isEmpty(responseEdit.getFiReason())) {
            hstService.save(createHistory(regProfile, String.format("Phản hồi từ chuyên viên: %s",
                    responseEdit.getFiReason()), request.getHeader(), responseEdit.getFiCreaterName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processRequestCancelProfileResponse(ResponseWrapper request) throws NSWException {
        ResponseCancel responseCancel = getGson().fromJson(getGson().toJson(request.getData()), ResponseCancel.class);
        Subject requestSubject = request.getHeader().getSubject();
        responseCancel.setFiNSWFileCode(requestSubject.getReference());
        if (requestSubject.getFunction().equals(Constant09.MessageFunction.FUNC_12)) {
            internalStatusUpdate(request.getHeader(), responseCancel.getFiCreaterName(), Constant09.Hoso09Status.DA_RUT_HO_SO.getId(), "Yêu cầu rút được thông qua");
        } else if (requestSubject.getFunction().equals(Constant09.MessageFunction.FUNC_13)) {
            internalStatusUpdate(request.getHeader(), responseCancel.getFiCreaterName(), Constant09.Hoso09Status.TU_CHOI_YCR.getId(), "Yêu cầu rút bị từ chối");
        }
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(responseCancel.getFiNSWFileCode());
        if (!StringUtils.isEmpty(responseCancel.getFiReason())) {
            hstService.save(createHistory(regProfile, String.format("Phản hồi từ chuyên viên: %s",
                    responseCancel.getFiReason()), request.getHeader(), responseCancel.getFiCreaterName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processAnimalQuarantineResult(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();

        AnimalQuarantineResult quarantineResult = getGson().fromJson(getGson().toJson(request.getData()), AnimalQuarantineResult.class);
        quarantineResult.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        quarantineResult.setFiEditStatus(Constant09.MessageFunction.FUNC_15.equals(function) ? Constant09.CertEditStatus.DA_SUA.getId() : null);

        certService.xulyGiayCNKD(quarantineResult);

        if (Constant09.MessageFunction.FUNC_15.equals(function)) {
            internalStatusUpdate(request.getHeader(), quarantineResult.getFiSignConfirmName(), Constant09.Hoso09Status.DA_CAP_CNKD.getId(), "Điều chỉnh giấy chứng nhận kiểm dịch");
        } else {
            internalStatusUpdate(request.getHeader(), quarantineResult.getFiSignConfirmName(), Constant09.Hoso09Status.DA_CAP_CNKD.getId());
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processTransportResult(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();

        TransportResult transportResult = getGson().fromJson(getGson().toJson(request.getData()), TransportResult.class);
        transportResult.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        transportResult.setFiEditStatus(Constant09.MessageFunction.FUNC_25.equals(function) ? Constant09.CertEditStatus.DA_SUA.getId() : null);

        certService.xulyGVC(transportResult);

        if (Constant09.MessageFunction.FUNC_25.equals(function)) {
            internalStatusUpdate(request.getHeader(), transportResult.getFiSignConfirmName(), Constant09.Hoso09Status.DA_CAP_GVC.getId(), "Điều chỉnh giấy vận chuyển");
        } else {
            internalStatusUpdate(request.getHeader(), transportResult.getFiSignConfirmName(), Constant09.Hoso09Status.DA_CAP_GVC.getId());
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processQualityResultNotification(ResponseWrapper request) throws NSWException {
        QualityResultNotification qualityResultNotification = getGson().fromJson(getGson().toJson(request.getData()), QualityResultNotification.class);
        qualityResultNotification.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyTbXNCL(qualityResultNotification);
        internalStatusUpdate(request.getHeader(), qualityResultNotification.getFiCreaterName(), Constant09.Hoso09Status.XNCL_KHONG_DAT.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processQualityResult(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();

        QualityResult qualityResult = getGson().fromJson(getGson().toJson(request.getData()), QualityResult.class);
        qualityResult.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        qualityResult.setFiEditStatus(Constant09.MessageFunction.FUNC_17.equals(function) ? Constant09.CertEditStatus.DA_SUA.getId() : null);

        certService.xulyXNCL(qualityResult);

        if (Constant09.MessageFunction.FUNC_17.equals(function)) {
            internalStatusUpdate(request.getHeader(), qualityResult.getFiSignResultName(), Constant09.Hoso09Status.DA_CAP_XNCL.getId(), "Điều chỉnh giấy xác nhận chất lượng");
        } else {
            internalStatusUpdate(request.getHeader(), qualityResult.getFiSignResultName(), Constant09.Hoso09Status.DA_CAP_XNCL.getId());
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processFeeNotification(ResponseWrapper request) throws NSWException {
        AnimalFee animalFee = getGson().fromJson(getGson().toJson(request.getData()), AnimalFee.class);
        animalFee.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        feeService.xulyTbApPhi(animalFee, request.getHeader());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processAdditionalFeeNotification(ResponseWrapper request) throws NSWException {
        AnimalFee animalFee = getGson().fromJson(getGson().toJson(request.getData()), AnimalFee.class);
        animalFee.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        feeService.xulyTbApPhiBS(animalFee, request.getHeader());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processFeeConfirmation(ResponseWrapper request) throws NSWException {
        AnimalFeeConfirmation feeConfirmation = getGson().fromJson(getGson().toJson(request.getData()), AnimalFeeConfirmation.class);
        feeConfirmation.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        feeService.xulyTbXacNhanPhi(feeConfirmation, request.getHeader());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateModificationRequest(ResponseWrapper request) throws NSWException {
        ResponseEditCer responseCertEditRequest = getGson().fromJson(getGson().toJson(request.getData()), ResponseEditCer.class);
        FilterForm filter = new FilterForm();
        filter.setLicenseNo(responseCertEditRequest.getFiCertificateNo());
        List<String> fiNSWFileCodeLst = certService.findLstNSWFileCode(filter);
        if (CollectionUtils.isEmpty(fiNSWFileCodeLst)) {
            return new ResponseJson(false, "", "Không tìm thấy hồ sơ");
        } else {
            Tbdhoso09 regProfile = regProfileService.findByFiHSCode(fiNSWFileCodeLst.get(0));
            if (regProfile == null) {
                throw new NSWException("Số giấy phép không tồn tại hồ sơ tương ứng");
            }
            StringBuilder hstContent = new StringBuilder();
            if (request.getHeader().getSubject().getFunction().equals(Constant09.MessageFunction.FUNC_22)) {
                hstContent.append("Từ chối");
                responseCertEditRequest.setAccepted(false);
                //Tu choi yeu cau sua GCN
            } else {
                hstContent.append("Đồng ý");
                responseCertEditRequest.setAccepted(true);
            }
            hstContent.append(" yêu cầu sửa GCN mã: ").append(responseCertEditRequest.getFiCertificateNo());
            if (!StringUtils.isEmpty(responseCertEditRequest.getFiDepartment()))
                hstContent.append(". Đơn vị: ").append(responseCertEditRequest.getFiDepartment());
            if (!StringUtils.isEmpty(responseCertEditRequest.getFiCreaterName()))
                hstContent.append(". Chuyên viên: ").append(responseCertEditRequest.getFiCreaterName());
            if (!StringUtils.isEmpty(responseCertEditRequest.getFiReason()))
                hstContent.append(". Lý do: ").append(responseCertEditRequest.getFiReason());
            hstService.save(createHistory(regProfile, hstContent.toString(), request.getHeader(), responseCertEditRequest.getFiCreaterName()));
            certService.xulyKQYCSGCN(responseCertEditRequest);
            return new ResponseJson(true, "", "Đã cập nhật phản hồi xin sửa GCN");
        }
    }

    @Override
    public ResponseJson processQuarantineFailedNotification(ResponseWrapper request) throws NSWException {
        QuarantineFailedNotification failedNotification = getGson().fromJson(getGson().toJson(request.getData()), QuarantineFailedNotification.class);
        failedNotification.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyCnkdKd(failedNotification);
        internalStatusUpdate(request.getHeader(), failedNotification.getFiCreaterName(), Constant09.Hoso09Status.KHONG_CAP_CNKD.getId());

        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException {
        UpdateStatusBO statusBO = getGson().fromJson(getGson().toJson(request.getData()), UpdateStatusBO.class);
        internalStatusUpdate(request.getHeader(), "", statusBO.getFiTrangthai());
        return new ResponseJson(true, "", "Cập nhật trạng thái hồ sơ thành công");
    }

    @Override
    public ResponseJson getXml(SendMessage sendMessage) throws NSWException {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(sendMessage.getFiNSWFileCode());
        if (regProfile == null) throw new NSWException("Hồ sơ không tồn tại");
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(sendMessage.getType());
        message.setXmlOnly(Boolean.TRUE);
        if (Constant09.MessageType.TYPE_10.equals(message.getType())) {
            if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.TAO_MOI.getId() ||
                    regProfile.getFiHSCode() == null) {
                message.setFunction(Constant09.MessageFunction.FUNC_01);
            } else if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.CHO_TIEP_NHAN.getId()) {
                message.setFunction(Constant09.MessageFunction.FUNC_02);
            } else if (regProfile.getFiHSStatus() == Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId()) {
                message.setFunction(Constant09.MessageFunction.FUNC_04);
            } else {
                throw new NSWException("Hồ sơ không hợp lệ");
            }
        } else if (Constant09.MessageType.TYPE_13.equals(message.getType())) {
            message.setFunction(Constant09.MessageFunction.FUNC_08);
            message.setReason(regProfile.getFiModifyReason());
        } else {
            throw new NSWException("Bản tin yêu cầu chưa hỗ trợ ký số");
        }
        ResponseJson response = WsServiceHelper.createSendRequest(Constant09.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        return response;
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                    .create();
        }
        return gson;
    }

    private void internalStatusUpdate(Header header, String exactSenderName, long status, String... reasons) throws NSWException {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
        if (regProfile == null) {
            throw new NSWException("Mã hồ sơ không tồn tại: " + header.getSubject().getReference());
        }
        processQuota(regProfile, status);
        regProfile.setFiHSStatus(status);
        String fromUnit = header.getFrom().getUnitCode();
        String hstContent = "Cập nhật trạng thái hồ sơ: " + Constant09.Hoso09Status.findById((int) status).getName();
        if (StringUtils.equals(fromUnit, regProfile.getFiMonitoringDepartmentCode())) {
            regProfile.setFiGSStatus(status);
        } else if (StringUtils.equals(fromUnit, regProfile.getFiQuarantineDepartmentCode())) {
            regProfile.setFiKDStatus(status);
        } else {
            boolean messageFromParentPU = false;
            if (fromUnit.charAt(0) == regProfile.getFiMonitoringDepartmentCode().charAt(0)) {
                regProfile.setFiGSStatus(status);
                messageFromParentPU = true;
            }
            if (fromUnit.charAt(0) == regProfile.getFiQuarantineDepartmentCode().charAt(0)) {
                regProfile.setFiKDStatus(status);
                messageFromParentPU = true;
            }
            if (messageFromParentPU == false) {
                throw new NSWException("Hồ sơ liên quan không phù hợp với đơn vị xử lý đã đăng ký: "
                        + "Đơn vị yêu cầu: " + fromUnit + " ; Đơn vị đã đăng ký: GS: "
                        + regProfile.getFiMonitoringDepartmentCode() + ", KD: "
                        + regProfile.getFiQuarantineDepartmentCode());
            }
        }
        switch (Constant09.Hoso09Status.findById((int) status)) {
            case DA_CAP_GVC:
                regProfile.setFiHaveTransport(1);
                break;
            case DA_CAP_XNCL:
                regProfile.setFiFailXncl(0);
                break;
            case XNCL_KHONG_DAT:
                regProfile.setFiFailXncl(1);
                break;
            case DA_CAP_CNKD:
                regProfile.setFiFailCnkd(0);
                break;
            case KHONG_CAP_CNKD:
                regProfile.setFiFailCnkd(1);
                break;
            default:
        }
        if (reasons.length == 0) {
            hstService.save(createHistory(regProfile, hstContent, header, exactSenderName));
        } else {
            hstService.save(createHistory(regProfile, reasons[0], header, exactSenderName));
        }
        regProfileService.save(regProfile);
    }

    private void processQuotaOnUpdate(Header header, long status) throws NSWException {
        Tbdhoso09 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
        if (regProfile == null) {
            throw new NSWException("Mã hồ sơ không tồn tại: " + header.getSubject().getReference());
        }
        processQuota(regProfileService.findById(regProfile.getFiIdHSParent()), status);
    }

    private void processQuota(Tbdhoso09 regProfile, long status) throws NSWException {
        return;
//        if (!quotableStatus.contains(Constant09.Hoso09Status.findById((int) status))) {
//            return;
//        }
//        try {
//            Tbdcvcnkd08 sourceLicense = cert08Repo.findGPByFilter(regProfile.getFiAccQuarantineDoc(), null, null).get(0);
//            for (Tbdhanghoa09 product : regProfile.getLstGood()) {
//                Tbdcnkdhanghoa08 product08 = sourceLicense.getLstProduct().stream().filter(childProduct -> childProduct.getFiProductCode().equals(product.getFiProductCode())).findFirst().orElse(null);
//                if (product08 == null)
//                    throw new NSWException("Thông tin giấy tương ứng không hợp lệ! " +
//                            "Không tìm được hàng hóa có mã '" + product.getFiProductCode() + "' tại công văn: " + sourceLicense.getFiDispatchNo() + "|" + sourceLicense.getFiQuarantineNo());
//
//                if (status == Constant09.Hoso09Status.DA_TIEP_NHAN.getId()
//                        || status == Constant09.Hoso09Status.DONG_Y_YCS.getId()) {
//                    if (product.getFiQuotedNumber() == null) product.setFiQuotedNumber((double) 0);
//                    processAnimalQuota(product, product08, true);
//                    processGoodsQuota(product, product08, true);
//                }
//                if (status == Constant09.Hoso09Status.DA_RUT_HO_SO.getId()
//                        || status == Constant09.Hoso09Status.YEU_CAU_BO_SUNG.getId()
//                        || status == Constant09.Hoso09Status.TU_CHOI_HO_SO.getId()
//                ) {
//                    processAnimalQuota(product, product08, false);
//                    processGoodsQuota(product, product08, false);
//                }
//            }
//            cert08Repo.save(sourceLicense);
//        } catch (NSWException ex) {
//            log.debug("Có lỗi xảy ra khi trừ lùi", ex);
//            throw ex;
//        }
    }

    private void processAnimalQuota(Tbdhanghoa09 targetProduct, Tbdcnkdhanghoa08 sourceProduct, boolean isAccounting) throws NSWException {
        if (targetProduct.getFiQuantityMale() != null) {
            long oldQuantity =
                    sourceProduct.getFiQtyMale();
            long accountingQuantity = (isAccounting) ?
                    targetProduct.getFiQuantityMale() : 0;
            long affectedQuantity = accountingQuantity -
                    targetProduct.getFiQuotedQuantityMale();
            targetProduct.setFiQuotedQuantityMale(accountingQuantity);
            sourceProduct.setFiQtyMale((int) (oldQuantity - affectedQuantity));
            if (sourceProduct.getFiQtyMale() < 0) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' bị âm hạn mức %d / %d (gốc)! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(), sourceProduct.getFiQtyMale(), sourceProduct.getFiQtyMaleOrigin()));
            } else if (sourceProduct.getFiQtyMale() > sourceProduct.getFiQtyMaleOrigin()) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' vượt hạn mức %d / %d (gốc)! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(), sourceProduct.getFiQtyMale(), sourceProduct.getFiQtyMaleOrigin()));
            }
        }
        if (targetProduct.getFiQuantityFemale() != null) {
            long oldQuantity =
                    sourceProduct.getFiQtyFemale();
            long accountingQuantity = (isAccounting) ?
                    targetProduct.getFiQuantityFemale() : 0;
            long affectedQuantity = accountingQuantity -
                    targetProduct.getFiQuotedQuantityFemale();
            targetProduct.setFiQuotedQuantityFemale(accountingQuantity);
            sourceProduct.setFiQtyFemale((int) (oldQuantity - affectedQuantity));
            if (sourceProduct.getFiQtyFemale() < 0) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' bị âm hạn mức %d / %d (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(), sourceProduct.getFiQtyFemale(), sourceProduct.getFiQtyFemaleOrigin(), "con đực"));
            } else if (sourceProduct.getFiQtyFemale() > sourceProduct.getFiQtyFemaleOrigin()) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' vượt hạn mức %d / %d (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(), sourceProduct.getFiQtyFemale(), sourceProduct.getFiQtyFemaleOrigin(), "con cái"));
            }
        }
    }

    private void processGoodsQuota(Tbdhanghoa09 targetProduct, Tbdcnkdhanghoa08 sourceProduct, boolean isAccounting) throws NSWException {
        if (targetProduct.getFiNumber() != null && Objects.equals(sourceProduct.getFiNumber(),-1d)) {
            double oldQuantity = sourceProduct.getFiNumber();
            double accountingQuantity = (isAccounting) ? targetProduct.getFiNumber() : 0;
            double affectedQuantity = accountingQuantity - targetProduct.getFiQuotedNumber();
            targetProduct.setFiQuotedNumber(accountingQuantity);
            sourceProduct.setFiNumber(oldQuantity - affectedQuantity);
            if (sourceProduct.getFiNumber() < 0) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' bị âm hạn mức %.3f / %.3f (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(),
                        sourceProduct.getFiNumber(),
                        sourceProduct.getFiNumberOrigin(),
                        sourceProduct.getFiUnitName()));
            } else if (sourceProduct.getFiNumber() > sourceProduct.getFiNumberOrigin()) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' vượt hạn mức %.3f / %.3f (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(),
                        sourceProduct.getFiNumber(),
                        sourceProduct.getFiNumberOrigin(),
                        sourceProduct.getFiUnitName()));
            }
        }
        if (targetProduct.getFiNetWeight() != null && Objects.equals(sourceProduct.getFiNetWeight(),-1d)) {
            double oldQuantity = sourceProduct.getFiNetWeight();
            double accountingQuantity = (isAccounting) ? targetProduct.getFiNetWeight() : 0;
            double affectedQuantity = accountingQuantity - targetProduct.getFiQuotedNetWeight();
            targetProduct.setFiQuotedNetWeight(accountingQuantity);
            sourceProduct.setFiNetWeight(oldQuantity - affectedQuantity);
            if (sourceProduct.getFiNetWeight() < 0) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' bị âm hạn mức %.3f / %.3f (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(),
                        sourceProduct.getFiNetWeight(),
                        sourceProduct.getFiNetWeightOrigin(),
                        sourceProduct.getFiNWUnitCode()));
            } else if (sourceProduct.getFiNumber() > sourceProduct.getFiNumberOrigin()) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' vượt hạn mức %.3f / %.3f (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(),
                        sourceProduct.getFiNetWeight(),
                        sourceProduct.getFiNetWeightOrigin(),
                        sourceProduct.getFiNWUnitCode()));
            }
        }
        if (targetProduct.getFiGrossWeight() != null && Objects.equals(sourceProduct.getFiGrossWeight(),-1d)) {
            double oldQuantity =
                    sourceProduct.getFiGrossWeight();
            double accountingQuantity = (isAccounting) ?
                    targetProduct.getFiGrossWeight() : 0;
            double affectedQuantity = accountingQuantity -
                    targetProduct.getFiQuotedGrossWeight();
            targetProduct.setFiQuotedGrossWeight(accountingQuantity);
            sourceProduct.setFiGrossWeight(oldQuantity - affectedQuantity);
            if (sourceProduct.getFiGrossWeight() < 0) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' bị âm hạn mức %.3f / %.3f (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(),
                        sourceProduct.getFiGrossWeight(),
                        sourceProduct.getFiGrossWeightOrigin(),
                        sourceProduct.getFiGWUnitCode()));
            } else if (sourceProduct.getFiNumber() > sourceProduct.getFiNumberOrigin()) {
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \n" +
                                "Hàng hóa có mã '%s' vượt hạn mức %.3f / %.3f (gốc) %s! Vui lòng kiểm tra lại",
                        sourceProduct.getFiProductCode(),
                        sourceProduct.getFiGrossWeight(),
                        sourceProduct.getFiGrossWeightOrigin(),
                        sourceProduct.getFiGWUnitCode()));
            }
        }
    }

    private Tbdlichsu09 createHistory(Tbdhoso09 regProfile, String hstContent) {
        Header header = new Header();
        From from = new From();
        from.setUnitCode(Constant09.SENDER.CODE);
        from.setUnitName(regProfile.getFiNameOfRegistration());
        from.setName(regProfile.getFiTaxCode());
        from.setIdentity(regProfile.getFiTaxCode());
        header.setFrom(from);
        return createHistory(regProfile, hstContent, header, regProfile.getFiTaxCode());
    }

    private Tbdlichsu09 createHistory(Tbdhoso09 regProfile, String hstContent, Header sendHeader, String exactSenderName) {
        Tbdlichsu09 history = new Tbdlichsu09();
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiHSCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiSenderCode(sendHeader.getFrom().getIdentity());
        history.setFiSenderName(exactSenderName);
        history.setFiSenderUnitCode(sendHeader.getFrom().getUnitCode());
        if (!StringUtils.isEmpty(sendHeader.getFrom().getUnitName())) {
            history.setFiSenderUnitName(sendHeader.getFrom().getUnitName());
        } else {
            //TODO: Map đến các đơn vị tương ứng
            history.setFiSenderUnitName(CmonHelper.instance().getUnitNameByUnitCode(sendHeader.getFrom().getUnitCode()));
        }
        history.setFiStatus(regProfile.getFiHSStatus());

        return history;
    }

}
