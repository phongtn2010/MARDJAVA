package com.nsw.backend.mard.p07.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.dic.helper.CmonHelper;
import com.nsw.backend.mard.p06.model.TbdCongvan06;
import com.nsw.backend.mard.p06.model.TbdCvHanghoa06;
import com.nsw.backend.mard.p06.repositories.TbdCongvan06Repository;
import com.nsw.backend.mard.p06.repositories.TbdCvHanghoa06Repository;
import com.nsw.backend.mard.p07.client.*;
import com.nsw.backend.mard.p07.constant.Constant07;
import com.nsw.backend.mard.p07.dto.RegistrationConfirmation;
import com.nsw.backend.mard.p07.dto.RequestEdit;
import com.nsw.backend.mard.p07.dto.RequestEditCer;
import com.nsw.backend.mard.p07.exception.NSWException;
import com.nsw.backend.mard.p07.helper.WsServiceHelper;
import com.nsw.backend.mard.p07.model.TbdHanghoa07;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.mard.p07.model.TbdLichsu07;
import com.nsw.backend.mard.p07.model.TbdXacnhan07;
import com.nsw.backend.mard.p07.repositories.TbdHanghoa07Repository;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("wsService07")
@Transactional(rollbackFor = NSWException.class)
public class WsServiceImpl implements WsService {
    private static final Logger log = LoggerFactory.getLogger(WsServiceImpl.class);

    private static final List<Constant07.HosoStatus> quotableStatus = Arrays.asList(
            Constant07.HosoStatus.DA_TIEP_NHAN,
            Constant07.HosoStatus.YEU_CAU_BO_SUNG,
            Constant07.HosoStatus.DA_RUT_HO_SO,
            Constant07.HosoStatus.TU_CHOI_HO_SO,
            Constant07.HosoStatus.DONG_Y_YCS
    );
    private final TbdHoso07Service regProfileService;

    private final TbdLichsu07Service hstService;

    private final GiayCN07Service certService;

    private final Phi07Service feeService;

    private final Environment environment;

    private TbdCongvan06Repository cert06Repo;

    private Gson gson;

    @Autowired
    public WsServiceImpl(TbdHoso07Service regProfileService, TbdLichsu07Service hstService, GiayCN07Service certService, Phi07Service feeService, TbdCongvan06Repository cert06Repo, Environment environment, TbdCongvan06Repository cert06Repo1) {
        this.regProfileService = regProfileService;
        this.hstService = hstService;
        this.certService = certService;
        this.feeService = feeService;
        this.environment = environment;
        this.cert06Repo = cert06Repo1;
    }

    @Override
    public ResponseJson sendProfile(TbdHoso07 regProfile) throws NSWException {
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant07.MessageType.TYPE_10);
        if (regProfile.getFiHSStatus() == Constant07.HosoStatus.TAO_MOI.getId()) {
            message.setFunction(Constant07.MessageFunction.FUNC_01);
        } else if (regProfile.getFiHSStatus() == Constant07.HosoStatus.CHO_TIEP_NHAN.getId()) {
            message.setFunction(Constant07.MessageFunction.FUNC_02);
        } else if (regProfile.getFiHSStatus() == Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId()) {
            message.setFunction(Constant07.MessageFunction.FUNC_04);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }

        ResponseJson response = WsServiceHelper.createSendRequest(Constant07.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
//         Ghi lại lịch sử gửi mới
            int statusYCBS = Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId();
            int updateStatus = Constant07.HosoStatus.CHO_TIEP_NHAN.getId();
            if(regProfile.getFiHSStatus() == statusYCBS || regProfile.getFiKDStatus() == statusYCBS || regProfile.getFiGSStatus() == statusYCBS){
                updateStatus = Constant07.HosoStatus.CHO_TIEP_NHAN_YCS.getId();
            }
            regProfile.setFiHSStatus(updateStatus);
            if (regProfile.isParallel()) {
                regProfile.setFiKDStatus(-1);
                regProfile.setFiGSStatus(updateStatus);
            } else {
                regProfile.setFiKDStatus(updateStatus);
                regProfile.setFiGSStatus(-1);
            }
            regProfile.setFiCreatedDate(new Date());
            regProfileService.update(regProfile);
            hstService.save(createHistory(regProfile, "Gửi mới hồ sơ"));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi hồ sơ: " + response.getMessage());
        }
        return new ResponseJson(true, "", "Gửi hồ sơ thành công");
    }

    @Override
    public ResponseJson updateProfile(RequestEdit requestEdit) {
        SendMessage message = SendMessage.parse(requestEdit.getRegProfile());
        message.setType(Constant07.MessageType.TYPE_12);
        message.setFunction(Constant07.MessageFunction.FUNC_08);
        message.setReason(requestEdit.getFiReason());
        return WsServiceHelper.createSendRequest(Constant07.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException {
        TbdHoso07 regProfile = requestCancel.getRegProfile();
        SendMessage message = SendMessage.parse(regProfile);
        message.setReason(requestCancel.getFiReason());
        if (regProfile.getFiHSStatus() == Constant07.HosoStatus.CHO_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId()
        ) {
            message.setType(Constant07.MessageType.TYPE_14);
            message.setFunction(Constant07.MessageFunction.FUNC_03);
        } else if (regProfile.getFiHSStatus() == Constant07.HosoStatus.DA_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant07.HosoStatus.DA_XM_DON_DANG_KY.getId()
                || regProfile.getFiHSStatus() == Constant07.HosoStatus.DONG_Y_YCS.getId()
                || regProfile.getFiHSStatus() == Constant07.HosoStatus.TU_CHOI_YCR.getId()) {
            message.setType(Constant07.MessageType.TYPE_15);
            message.setFunction(Constant07.MessageFunction.FUNC_11);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }
        return WsServiceHelper.createSendRequest(Constant07.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson requestModifyCertificate(RequestEditCer requestEditCer) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(requestEditCer.getFiNSWFileCode());
        if (Objects.equals(regProfile.getFiPendingCertEdit(), 1)) {
            throw new NSWException("Giấy phép đang chờ sửa đổi");
        } else {
            hstService.save(createHistory(regProfile, String.format("Yêu cầu chỉnh sửa giấy phép %s với lí do: %s", requestEditCer.getFiCertificateNo(), requestEditCer.getFiReason())));
            if (regProfile.isParallel()) {
                requestEditCer.setFiTypeOfRequest(1);
            } else if (requestEditCer.getFiCertType() == 2) {
                requestEditCer.setFiTypeOfRequest(2);/*GVC*/
            } else {
                requestEditCer.setFiTypeOfRequest(3); /*CNKD*/
            }

            SendMessage message = SendMessage.parse(regProfile);
            message.setType(Constant07.MessageType.TYPE_22);
            message.setFunction(Constant07.MessageFunction.FUNC_21);
            message.setCerNo(requestEditCer.getFiCertificateNo());
            message.setCerType(Long.valueOf(requestEditCer.getFiTypeOfRequest()));
            message.setReason(requestEditCer.getFiReason());
            ResponseJson response = WsServiceHelper.createSendRequest(Constant07.WebServiceURL.get(environment), message);
            if (response.isSuccess()) {
                regProfile.setFiPendingCertEdit(1);
                regProfileService.save(regProfile);
            }
            return response;
        }
    }

    @Override
    public ResponseJson processProfileRegisterResponse(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();
        int status;
        switch (function) {
            case Constant07.MessageFunction.FUNC_05:
                status = Constant07.HosoStatus.TU_CHOI_HO_SO.getId();
                break;
            case Constant07.MessageFunction.FUNC_06:
                status = Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId();
                break;
            case Constant07.MessageFunction.FUNC_61:
                status = Constant07.HosoStatus.DA_TIEP_NHAN.getId();
                break;
            default:
                throw new NSWException("Invalid Function " + function + "on ProfileRegistration Response");
        }

        RegisterResponse kqtd = getGson().fromJson(getGson().toJson(request.getData()), RegisterResponse.class);
        internalStatusUpdate(request.getHeader(), kqtd.getFiCreaterName(), status);
        if (!StringUtils.isEmpty(kqtd.getFiReason())) {
            internalStatusUpdate(request.getHeader(), kqtd.getFiCreaterName(), status, "Phản hồi từ chuyên viên: " + kqtd.getFiReason());
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processProfileConfirmation(ResponseWrapper request) throws NSWException {
        Header header = request.getHeader();
        RegistrationConfirmation regConfirmation = getGson().fromJson(getGson().toJson(request.getData()), RegistrationConfirmation.class);
        TbdXacnhan07 regConfirmationEntity = new TbdXacnhan07();
        BeanUtils.copyProperties(regConfirmation, regConfirmationEntity);
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
        if (regProfile == null) {
            throw new NSWException("Mã hồ sơ không tồn tại");
        }
        regProfile.setFiRegistrationConfirm(regConfirmationEntity);
        regProfile.setFiRegistrationComfirmNo(regConfirmationEntity.getFiRegistrationComfirmNo());
        internalStatusUpdate(header, regConfirmation.getFiCreaterName(), Constant07.HosoStatus.DA_XM_DON_DANG_KY.getId());
        regProfileService.save(regProfile);
        return new ResponseJson(true, "", "");
    }

    @Override
    public ResponseJson processRequestUpdateProfileResponse(ResponseWrapper request) throws NSWException {
        ResponseEdit responseEdit = getGson().fromJson(getGson().toJson(request.getData()), ResponseEdit.class);
        Subject requestSubject = request.getHeader().getSubject();
        responseEdit.setFiNSWFileCode(requestSubject.getReference());
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(responseEdit.getFiNSWFileCode());

        if (requestSubject.getFunction().equals(Constant07.MessageFunction.FUNC_09)) {
            processQuotaOnUpdate(request.getHeader(), Constant07.HosoStatus.TU_CHOI_HO_SO.getId());
            internalStatusUpdate(request.getHeader(), responseEdit.getFiCreaterName(),  Constant07.HosoStatus.DONG_Y_YCS.getId());
        } else if (requestSubject.getFunction().equals(Constant07.MessageFunction.FUNC_10)) {
            regProfile.setFiActive(false);
            TbdHoso07 oldProfile = regProfileService.findById(regProfile.getFiIdHSParent());
            oldProfile.setFiActive(true);
            regProfileService.save(regProfile);
            regProfile = regProfileService.save(oldProfile);
            internalStatusUpdate(request.getHeader(), responseEdit.getFiCreaterName(),  Constant07.HosoStatus.TU_CHOI_YCS.getId());
        }
        hstService.save(createHistory(regProfile, String.format("Yêu cầu sửa %s",
                requestSubject.getFunction().equals(Constant07.MessageFunction.FUNC_09) ? "được thông qua" : "bị từ chối"),
                request.getHeader(), responseEdit.getFiCreaterName()));
        if (!StringUtils.isEmpty(responseEdit.getFiReason())) {
            hstService.save(createHistory(regProfile, String.format("Phản hồi từ chuyên viên: %s"
                    , responseEdit.getFiReason()), request.getHeader(), responseEdit.getFiCreaterName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processRequestCancelProfileResponse(ResponseWrapper request) throws NSWException {
        ResponseCancel responseCancel = getGson().fromJson(getGson().toJson(request.getData()), ResponseCancel.class);
        Subject requestSubject = request.getHeader().getSubject();
        responseCancel.setFiNSWFileCode(requestSubject.getReference());
        if (requestSubject.getFunction().equals(Constant07.MessageFunction.FUNC_12)) {
            internalStatusUpdate(request.getHeader(), responseCancel.getFiCreateName(), Constant07.HosoStatus.DA_RUT_HO_SO.getId());
        } else if (requestSubject.getFunction().equals(Constant07.MessageFunction.FUNC_13)) {
            internalStatusUpdate(request.getHeader(), responseCancel.getFiCreateName(),Constant07.HosoStatus.TU_CHOI_YCR.getId());
        }
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(responseCancel.getFiNSWFileCode());
        hstService.save(createHistory(regProfile, String.format("Yêu cầu rút %s",
                requestSubject.getFunction().equals(Constant07.MessageFunction.FUNC_12) ? "được thông qua" : "bị từ chối"),
                request.getHeader(), responseCancel.getFiCreateName()));
        if (!StringUtils.isEmpty(responseCancel.getFiReason())) {
            hstService.save(createHistory(regProfile, String.format("Phản hồi từ chuyên viên: %s"
                    , responseCancel.getFiReason()), request.getHeader(), responseCancel.getFiCreateName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processAnimalQuarantineResult(ResponseWrapper request) throws NSWException {
        QuarantineResult quarantineResult = getGson().fromJson(getGson().toJson(request.getData()), QuarantineResult.class);
        quarantineResult.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyGiayCNKD(quarantineResult);
        internalStatusUpdate(request.getHeader(), quarantineResult.getFiSignConfirmName(), Constant07.HosoStatus.DA_CAP_GCNKD.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processTransportResult(ResponseWrapper request) throws NSWException {
        TransportResult transportResult = getGson().fromJson(getGson().toJson(request.getData()), TransportResult.class);
        transportResult.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyGVC(transportResult);
        internalStatusUpdate(request.getHeader(), transportResult.getFiSignConfirmName(), Constant07.HosoStatus.DA_CAP_GVC.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processFeeNotification(ResponseWrapper request) throws NSWException {
        PhytosanitaryFee phytosanitaryFee = getGson().fromJson(getGson().toJson(request.getData()), PhytosanitaryFee.class);
        phytosanitaryFee.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        feeService.xulyTbApPhi(phytosanitaryFee);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processAdditionalFeeNotification(ResponseWrapper request) throws NSWException {
        PhytosanitaryFee phytosanitaryFee = getGson().fromJson(getGson().toJson(request.getData()), PhytosanitaryFee.class);
        phytosanitaryFee.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        feeService.xulyTbApPhiBS(phytosanitaryFee);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processFeeConfirmation(ResponseWrapper request) throws NSWException {
        FeeConfirmation feeConfirmation = getGson().fromJson(getGson().toJson(request.getData()), FeeConfirmation.class);
        feeConfirmation.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        feeService.xulyTbXacNhanPhi(feeConfirmation);
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processCertificateModificationRequest(ResponseWrapper request) {
        ResponseEditCer responseCertEditRequest = getGson().fromJson(getGson().toJson(request.getData()), ResponseEditCer.class);
        responseCertEditRequest.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyKQYCSGCN(responseCertEditRequest);
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(responseCertEditRequest.getFiNSWFileCode());
        regProfile.setFiPendingCertEdit(0);
        regProfileService.save(regProfile);
        if (!StringUtils.isEmpty(responseCertEditRequest.getFiReason())) {
            createHistory(regProfile,
                    String.format("Phản hồi từ chuyên viên: %s", responseCertEditRequest.getFiReason()));
        }
        return new ResponseJson(true, "", "Đã cập nhật kết quả yêu cầu sửa GCN thất bại");
    }

    @Override
    public ResponseJson processQuarantineFailedNotification(ResponseWrapper request) throws NSWException {
        QualityFail failedNotification = getGson().fromJson(getGson().toJson(request.getData()), QualityFail.class);
        failedNotification.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyCnkdKd(failedNotification);
        internalStatusUpdate(request.getHeader(), failedNotification.getFiSignConfirmName(), Constant07.HosoStatus.LO_HANG_KHONG_DAT.getId());
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException {
        UpdateStatusBO statusBO = getGson().fromJson(getGson().toJson(request.getData()), UpdateStatusBO.class);
        internalStatusUpdate(request.getHeader(), "Cục Thú Y", statusBO.getFiTrangthai().intValue());
        return new ResponseJson(true, "", "Cập nhật trạng thái hồ sơ thành công");
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> {
                        try {
                            return new Date(jsonElement.getAsJsonPrimitive().getAsLong());
                        } catch (Exception ex) {
                            return DateUtils.parseDate(jsonElement.getAsJsonPrimitive().getAsString());
                        }
                    }).create();
        }
        return gson;
    }

    @Override
    public void internalStatusUpdate(Header header, String exactSenderName, int status, String... reasons) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
        if (regProfile == null) {
            throw new NSWException("Mã hồ sơ không tồn tại");
        }
        processQuota(regProfile, status);
        regProfile.setFiHSStatus(status);
        String fromUnit = header.getFrom().getUnitCode();
        String hstContent = "Cập nhật trạng thái hồ sơ: " + Constant07.HosoStatus.findById(status).getName();
        if (StringUtils.equals(fromUnit, regProfile.getFiDepartmentofMonitorCode())) {
            regProfile.setFiGSStatus(status);
        } else if (StringUtils.equals(fromUnit, regProfile.getFiDepartmentofQuarantineCode())) {
            regProfile.setFiKDStatus(status);
        } else {
            boolean messageFromParentPU = false;
            if (fromUnit.charAt(0) == regProfile.getFiDepartmentofMonitorCode().charAt(0)) {
                regProfile.setFiGSStatus(status);
                messageFromParentPU = true;
            }
            if(fromUnit.charAt(0) == regProfile.getFiDepartmentofQuarantineCode().charAt(0)){
                regProfile.setFiKDStatus(status);
                messageFromParentPU = true;
            }
            if(messageFromParentPU == false) {
                throw new NSWException("Hồ sơ liên quan không phù hợp với đơn vị xử lý đã đăng ký: "
                        + "Đơn vị yêu cầu: " + fromUnit + " ; Đơn vị đã đăng ký: GS: "
                        + regProfile.getFiDepartmentofMonitorCode() + ", KD: "
                        + regProfile.getFiDepartmentofQuarantineCode());
            }
        }
        if (status == Constant07.HosoStatus.DA_CAP_GVC.getId()) {
            regProfile.setFiHaveTransport(1);
            regProfile.setFiPendingCertEdit(0);
        }
        if (status == Constant07.HosoStatus.LO_HANG_KHONG_DAT.getId()) {
            regProfile.setFiFailCnkd(1);
        }
        if (status == Constant07.HosoStatus.DA_CAP_GCNKD.getId()) {
            regProfile.setFiFailCnkd(0);
            regProfile.setFiPendingCertEdit(0);
        }
        if (reasons.length == 0) {
            hstService.save(createHistory(regProfile, hstContent, header, exactSenderName));
        } else {
            hstService.save(createHistory(regProfile, reasons[0], header, exactSenderName));
        }
        regProfileService.save(regProfile);
    }

    @Override
    public ResponseJson getXml(SendMessage sendMessage) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(sendMessage.getFiNSWFileCode());
        if (regProfile == null) throw new NSWException("Hồ sơ không tồn tại");
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(sendMessage.getType());
        message.setXmlOnly(Boolean.TRUE);
        if (Constant07.MessageType.TYPE_10.equals(message.getType())) {
            if (regProfile.getFiHSStatus() == Constant07.HosoStatus.TAO_MOI.getId() ||
                    regProfile.getFiNSWFileCode() == null) {
                message.setFunction(Constant07.MessageFunction.FUNC_01);
            } else if (regProfile.getFiHSStatus() == Constant07.HosoStatus.CHO_TIEP_NHAN.getId()) {
                message.setFunction(Constant07.MessageFunction.FUNC_02);
            } else if (regProfile.getFiHSStatus() == Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId()) {
                message.setFunction(Constant07.MessageFunction.FUNC_04);
            } else {
                throw new NSWException("Hồ sơ không hợp lệ");
            }
        } else if (Constant07.MessageType.TYPE_12.equals(message.getType())) {
            message.setFunction(Constant07.MessageFunction.FUNC_08);
            message.setReason(regProfile.getFiModifyReason());
        } else {
            throw new NSWException("Bản tin yêu cầu chưa hỗ trợ ký số");
        }
        ResponseJson response = WsServiceHelper.createSendRequest(Constant07.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        return response;
    }


    private void processQuotaOnUpdate(Header header, long status) throws NSWException {
        TbdHoso07 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
        if (regProfile == null) {
            throw new NSWException("Mã hồ sơ không tồn tại: " + header.getSubject().getReference());
        }
        processQuota(regProfileService.findById(regProfile.getFiIdHSParent()), status);
    }

    private void processQuota(TbdHoso07 regProfile, long status) throws NSWException {
        return;
//        if (!quotableStatus.contains(Constant07.HosoStatus.findById((int) status)) || StringUtils.isEmpty(regProfile.getFiLicenseNo())) {
//            return;
//        }
//        try {
//            TbdCongvan06 sourceLicense = cert06Repo.findGPByFilter(regProfile.getFiLicenseNo(), null, null).get(0);
//            for (TbdHanghoa07 product : regProfile.getFiGoodsList()) {
//                TbdCvHanghoa06 sourceProduct = sourceLicense.getFiProductList().stream().filter(childProduct -> childProduct.getFiId().toString().equals(product.getFiCodeOfGoods())).findFirst().orElse(null);
//                if (sourceProduct == null) throw new NSWException("Thông tin giấy tương ứng không hợp lệ! Không tìm được hàng hóa có mã '" + product.getFiCodeOfGoods() + "' tại công văn: " + sourceLicense.getFiDispatchNo());
//                if (status == Constant07.HosoStatus.DA_TIEP_NHAN.getId()
//                        || status == Constant07.HosoStatus.DONG_Y_YCS.getId()) {
//                    if (product.getFiQuotedQuantityOrWeight() == null) product.setFiQuotedQuantityOrWeight((double) 0);
//                    processGoodsQuota(product, sourceProduct, true);
//                }
//                if (status == Constant07.HosoStatus.DA_RUT_HO_SO.getId()
//                        || status == Constant07.HosoStatus.YEU_CAU_BO_SUNG.getId()
//                        || status == Constant07.HosoStatus.TU_CHOI_HO_SO.getId()
//                ) {
//                    processGoodsQuota(product, sourceProduct, false);
//                }
//            }
//            cert06Repo.save(sourceLicense);
//        } catch (NSWException ex) {
//            log.debug("Có lỗi xảy ra khi trừ lùi", ex);
//            throw ex;
//        }
    }

    private void processGoodsQuota(TbdHanghoa07 targetProduct, TbdCvHanghoa06 sourceProduct, boolean isAccounting) throws NSWException {
        if (targetProduct.getFiQuantityOrWeight() != null) {
            double oldQuantity =
                    sourceProduct.getFiQuantity();
            double accountingQuantity = (isAccounting) ?
                    targetProduct.getFiQuantityOrWeight() : 0;
            double affectedQuantity = accountingQuantity -
                    targetProduct.getFiQuotedQuantityOrWeight();
            targetProduct.setFiQuotedQuantityOrWeight(accountingQuantity);
            sourceProduct.setFiQuantity(oldQuantity - affectedQuantity);
            if(sourceProduct.getFiQuantity() < 0){
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \nHàng hóa có mã '%s' bị âm hạn mức %.2f / %.2f (gốc)! Vui lòng kiểm tra lại", sourceProduct.getFiId(), sourceProduct.getFiQuantity(), sourceProduct.getFiQuantityOrigin()));
            }
            else if (sourceProduct.getFiQuantity() > sourceProduct.getFiQuantityOrigin()){
                throw new NSWException(String.format("Xảy ra lỗi khi trừ lùi: \nHàng hóa có mã '%s' vượt hạn mức %.2f / %.2f (gốc)! Vui lòng kiểm tra lại", sourceProduct.getFiId(), sourceProduct.getFiQuantity(), sourceProduct.getFiQuantityOrigin()));
            }
        }
    }

    private TbdLichsu07 createHistory(TbdHoso07 regProfile, String hstContent) {
        Header header = new Header();
        From from = new From();
        from.setUnitCode(Constant07.SENDER.CODE);
        from.setUnitName(regProfile.getFiNameOfRegistration());
        from.setName(regProfile.getFiTaxCode());
        from.setIdentity(regProfile.getFiTaxCode());
        header.setFrom(from);
        return createHistory(regProfile, hstContent, header, regProfile.getFiTaxCode());
    }

    private TbdLichsu07 createHistory(TbdHoso07 regProfile, String hstContent, Header sendHeader, String exactSenderName) {
        TbdLichsu07 history = new TbdLichsu07();
        history.setFiContent(hstContent);
        history.setFiHSCode(regProfile.getFiNSWFileCode());
        history.setFiIdHS(regProfile.getFiIdHS());
        history.setFiSenderCode(sendHeader.getFrom().getIdentity());
        history.setFiSenderName(exactSenderName);
        history.setFiSenderUnitCode(sendHeader.getFrom().getUnitCode());
        if (!StringUtils.isEmpty(sendHeader.getFrom().getUnitName())) {
            history.setFiSenderUnitName(sendHeader.getFrom().getUnitName());
        } else {
            //TODO: Map đến các đơn vị tương ứng
            history.setFiSenderUnitName(parseSenderUnitName(sendHeader.getFrom().getUnitCode()));
        }
        history.setFiStatus(regProfile.getFiHSStatus());

        return history;
    }

    private String parseSenderUnitName(String unitCode) {
        return CmonHelper.instance().getUnitNameByUnitCode(unitCode);
    }

    @Autowired
    TbdCvHanghoa06Repository hh06Repository;

    @Autowired
    TbdHanghoa07Repository hh07Repo;

    @Override
    public void migrateData() {
        Set<String> codeOfGoodsSetKG = new HashSet<>();
        List<TbdHanghoa07> listGoods = hh07Repo.findAllByFiQuantityOrWeightUnitCode("KG");
        listGoods.stream()
                .filter(hh07 -> StringUtils.isNotEmpty(hh07.getFiCodeOfGoods()))
                .forEach(hh07 -> codeOfGoodsSetKG.add(hh07.getFiCodeOfGoods()));
        codeOfGoodsSetKG.forEach(code -> {
            TbdCvHanghoa06 hh06 = hh06Repository.findByFiId(Integer.parseInt(code)).orElse(null);
            if (hh06 != null && "TAN".equals(hh06.getFiPackageUnitCode())) {
                double delta = 0;
                if (hh06.getFiQuantity().equals(hh06.getFiQuantityOrigin())) {
                    hh06.setFiQuantity(hh06.getFiQuantity() * 1000d);
                } else {
                    delta = hh06.getFiQuantityOrigin() - hh06.getFiQuantity();
                }
                hh06.setFiQuantityOrigin(hh06.getFiQuantityOrigin() * 1000d);
                hh06.setFiQuantity(hh06.getFiQuantityOrigin() - delta);
                if (hh06.getFiQuantity() < 0) {
                    hh06.setFiQuantity(0d);
                }
                hh06.setFiPackageUnitCode("KG");
                hh06.setFiPackageUnitName("Kilogram");
                log.info(hh06.toString());

            }
        });

        HashSet<String> codeOfGoodsSetTON = new HashSet<>();
        listGoods = hh07Repo.findAllByFiQuantityOrWeightUnitCode("TAN");
        listGoods.stream()
                .filter(hh07 -> StringUtils.isNotEmpty(hh07.getFiCodeOfGoods()))
                .forEach(hh07 -> {
                    codeOfGoodsSetTON.add(hh07.getFiCodeOfGoods());
                    hh07.setFiQuantityOrWeightUnitCode("KG");
                    hh07.setFiQuantityOrWeightUnitName("Kilogram");
                    hh07.setFiQuantityOrWeight(hh07.getFiQuantityOrWeight() * 1000d);
                    hh07.setFiQuotedQuantityOrWeight(hh07.getFiQuotedQuantityOrWeight() * 1000d);
                    log.info(hh07.toString());
                });
        codeOfGoodsSetTON.forEach(code -> {
            TbdCvHanghoa06 hh06 = hh06Repository.findByFiId(Integer.parseInt(code)).orElse(null);
            if (hh06 != null && "TAN".equals(hh06.getFiPackageUnitCode())) {
                hh06.setFiQuantity(hh06.getFiQuantity() * 1000d);
                hh06.setFiQuantityOrigin(hh06.getFiQuantityOrigin() * 1000d);
                hh06.setFiPackageUnitCode("KG");
                hh06.setFiPackageUnitName("Kilogram");
                log.info(hh06.toString());
            } else if (hh06 != null && "KG".equals(hh06.getFiPackageUnitCode())) {
                double delta = hh06.getFiQuantityOrigin() - hh06.getFiQuantity();
                hh06.setFiQuantity(hh06.getFiQuantityOrigin() - delta * 1000d);
                if (hh06.getFiQuantity() < 0) {
                    hh06.setFiQuantity(0d);
                }
                log.info(hh06.toString());
            }
        });

        List<TbdCvHanghoa06> listGoods06 = hh06Repository.findAllByFiPackageUnitCode("TAN");

        listGoods06.forEach(hh06 -> {
            hh06.setFiQuantity(hh06.getFiQuantity() * 1000d);
            hh06.setFiQuantityOrigin(hh06.getFiQuantityOrigin() * 1000d);
            hh06.setFiPackageUnitCode("KG");
            hh06.setFiPackageUnitName("Kilogram");
            log.info(hh06.toString());
        });
    }
}
