package com.nsw.backend.mard.p06.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.mard.p06.client.*;
import com.nsw.backend.mard.p06.constant.Constant06;
import com.nsw.backend.mard.p06.dto.*;
import com.nsw.backend.mard.p06.exception.NSWException;
import com.nsw.backend.mard.p06.helper.WsServiceHelper;
import com.nsw.backend.mard.p06.model.TbdHoso06;
import com.nsw.backend.mard.p06.model.TbdLichsu06;
import com.nsw.backend.util.ResponseJson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Service("wsService06")
@Transactional(rollbackFor = NSWException.class)
public class WsServiceImpl implements WsService {
    private static final Logger log = LoggerFactory.getLogger(WsServiceImpl.class);
    private final TbdHoso06Service regProfileService;
    private final TbdLichsu06Service hstService;
    private final GiayCN06Service certService;
    private Gson gson;

    private final Environment environment;

    @Autowired
    public WsServiceImpl(TbdHoso06Service regProfileService, TbdLichsu06Service hstService, GiayCN06Service certService, Environment environment) {
        this.regProfileService = regProfileService;
        this.hstService = hstService;
        this.certService = certService;
        this.environment = environment;
    }

    @Override
    public ResponseJson sendProfile(TbdHoso06 regProfile) throws NSWException {
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(Constant06.MessageType.TYPE_10);
        if (regProfile.getFiHSStatus() == Constant06.HosoStatus.TAO_MOI.getId()) {
            message.setFunction(Constant06.MessageFunction.FUNC_01);
        } else if (regProfile.getFiHSStatus() == Constant06.HosoStatus.CHO_TIEP_NHAN.getId()) {
            message.setFunction(Constant06.MessageFunction.FUNC_02);
        } else if (regProfile.getFiHSStatus() == Constant06.HosoStatus.YEU_CAU_BO_SUNG.getId()) {
            message.setFunction(Constant06.MessageFunction.FUNC_03);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }

        ResponseJson response = WsServiceHelper.createSendRequest(Constant06.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
            // Ghi lại lịch sử gửi mới
            int statusYCBS = Constant06.HosoStatus.YEU_CAU_BO_SUNG.getId();
            int updateStatus = Constant06.HosoStatus.CHO_TIEP_NHAN.getId();
            if (regProfile.getFiHSStatus() == statusYCBS) {
                updateStatus = Constant06.HosoStatus.CHO_TIEP_NHAN_YCS.getId();
            }
            regProfile.setFiHSStatus(updateStatus);
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
        message.setType(Constant06.MessageType.TYPE_15);
        message.setFunction(Constant06.MessageFunction.FUNC_11);
        message.setReason(requestEdit.getFiReason());
        return WsServiceHelper.createSendRequest(Constant06.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson requestCancelProfile(RequestEdit requestCancel) throws NSWException {
        TbdHoso06 regProfile = requestCancel.getRegProfile();
        SendMessage message = SendMessage.parse(regProfile);
        message.setReason(requestCancel.getFiReason());
        if (regProfile.getFiHSStatus() == Constant06.HosoStatus.CHO_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant06.HosoStatus.YEU_CAU_BO_SUNG.getId()
        ) {
            message.setType(Constant06.MessageType.TYPE_12);
            message.setFunction(Constant06.MessageFunction.FUNC_04);
        } else if (regProfile.getFiHSStatus() == Constant06.HosoStatus.DA_TIEP_NHAN.getId()
                || regProfile.getFiHSStatus() == Constant06.HosoStatus.DONG_Y_YCS.getId()
                || regProfile.getFiHSStatus() == Constant06.HosoStatus.TU_CHOI_YCR.getId()) {
            message.setType(Constant06.MessageType.TYPE_13);
            message.setFunction(Constant06.MessageFunction.FUNC_08);
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }
        return WsServiceHelper.createSendRequest(Constant06.WebServiceURL.get(environment), message);
    }

    @Override
    public ResponseJson processProfileRegisterResponse(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();
        int status;
        switch (function) {
            case Constant06.MessageFunction.FUNC_06:
                status = Constant06.HosoStatus.TU_CHOI_HO_SO.getId();
                break;
            case Constant06.MessageFunction.FUNC_07:
                status = Constant06.HosoStatus.YEU_CAU_BO_SUNG.getId();
                break;
            case Constant06.MessageFunction.FUNC_05:
                status = Constant06.HosoStatus.DA_TIEP_NHAN.getId();
                break;
            default:
                throw new NSWException("Invalid Function " + function + "on ProfileRegistration Response");
        }
        KetQuaThamDinh kqtd = getGson().fromJson(getGson().toJson(request.getData()), KetQuaThamDinh.class);
        internalStatusUpdate(request.getHeader(), kqtd.getFiCreaterName(), status);
        if (!StringUtils.isEmpty(kqtd.getFiReason())) {
            hstService.save(createHistory(
                    regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference()),
                    "Phản hồi từ chuyên viên: " + kqtd.getFiReason(), request.getHeader(), kqtd.getFiCreaterName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processRequestUpdateProfileResponse(ResponseWrapper request) throws NSWException {
        ResponseEdit responseEdit = getGson().fromJson(getGson().toJson(request.getData()), ResponseEdit.class);
        Subject requestSubject = request.getHeader().getSubject();
        TbdHoso06 regProfile = regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference());
        responseEdit.setFiNSWFileCode(requestSubject.getReference());
        if (requestSubject.getFunction().equals(Constant06.MessageFunction.FUNC_12)) {
            internalStatusUpdate(request.getHeader(), responseEdit.getFiCreateName(), Constant06.HosoStatus.DONG_Y_YCS.getId());
        } else if (requestSubject.getFunction().equals(Constant06.MessageFunction.FUNC_13)) {
            regProfile.setFiActive(false);
            TbdHoso06 oldProfile = regProfileService.findById(regProfile.getFiIdHSParent());
            oldProfile.setFiActive(true);
            oldProfile.setFiHSStatus(Constant06.HosoStatus.TU_CHOI_YCS.getId());
            regProfileService.save(regProfile);
            regProfile = regProfileService.save(oldProfile);
        }
        hstService.save(createHistory(regProfile, String.format("Yêu cầu sửa %s",
                requestSubject.getFunction().equals(Constant06.MessageFunction.FUNC_12) ? "được thông qua" : "bị từ chối"),
                request.getHeader(), responseEdit.getFiCreateName()));
        if (!StringUtils.isEmpty(responseEdit.getFiReason())) {
            hstService.save(createHistory(
                    regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference()),
                    "Phản hồi từ chuyên viên: " + responseEdit.getFiReason(), request.getHeader(), responseEdit.getFiCreateName()));
        }

        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processRequestCancelProfileResponse(ResponseWrapper request) throws NSWException {
        ResponseCancel responseCancel = getGson().fromJson(getGson().toJson(request.getData()), ResponseCancel.class);
        Subject requestSubject = request.getHeader().getSubject();
        responseCancel.setFiNSWFileCode(requestSubject.getReference());
        if (requestSubject.getFunction().equals(Constant06.MessageFunction.FUNC_09)) {
            internalStatusUpdate(request.getHeader(), responseCancel.getFiCreateName(), Constant06.HosoStatus.DA_RUT_HO_SO.getId());
        } else if (requestSubject.getFunction().equals(Constant06.MessageFunction.FUNC_10)) {
            internalStatusUpdate(request.getHeader(), responseCancel.getFiCreateName(), Constant06.HosoStatus.TU_CHOI_YCR.getId());
        }
        hstService.save(createHistory(regProfileService.findByFiHSCode(responseCancel.getFiNSWFileCode()),
                String.format("Yêu cầu rút %s",
                        requestSubject.getFunction().equals(Constant06.MessageFunction.FUNC_09) ? "được thông qua" : "bị từ chối"),
                request.getHeader(), responseCancel.getFiCreateName()));
        if (!StringUtils.isEmpty(responseCancel.getFiReason())) {
            hstService.save(createHistory(
                    regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference()),
                    "Phản hồi từ chuyên viên: " + responseCancel.getFiReason(), request.getHeader(), responseCancel.getFiCreateName()));
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processQuarantineResult(ResponseWrapper request) throws NSWException {
        QuarantineDispatch quarantineResult = getGson().fromJson(getGson().toJson(request.getData()), QuarantineDispatch.class);
        quarantineResult.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyKDNK(quarantineResult);
        TbdHoso06 profile = regProfileService.findByFiHSCode(request.getHeader().getSubject().getReference());
        profile.setFiLicenseNo(quarantineResult.getFiDispatchNo());
        profile.setFiLicensedDate(quarantineResult.getFiDispatchDate());
        regProfileService.save(profile);
        internalStatusUpdate(request.getHeader(), quarantineResult.getFiSignConfirmName(), Constant06.HosoStatus.DA_CAP_CV_KDNK.getId());
        if (Constant06.MessageFunction.FUNC_17.equals(request.getHeader().getSubject().getFunction())) {
            internalStatusUpdate(request.getHeader(), quarantineResult.getFiSignConfirmName(), Constant06.HosoStatus.DA_CAP_CV_KDNK.getId(), "Điều chỉnh công văn KDNK");
            if (!StringUtils.isEmpty(quarantineResult.getFiReasonEdit())) {
                internalStatusUpdate(request.getHeader(), quarantineResult.getFiSignConfirmName(), Constant06.HosoStatus.DA_CAP_CV_KDNK.getId(), "Lý do: " + quarantineResult.getFiReasonEdit());
            }
        }

        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processVeterinaryHygieneResult(ResponseWrapper request) throws NSWException {
        VeterinaryHygiene veterinaryHygiene = getGson().fromJson(getGson().toJson(request.getData()), VeterinaryHygiene.class);
        veterinaryHygiene.setFiNSWFileCode(request.getHeader().getSubject().getReference());
        certService.xulyVSTY(veterinaryHygiene);
        internalStatusUpdate(request.getHeader(), veterinaryHygiene.getFiSignConfirmName(), Constant06.HosoStatus.DA_CAP_CV_VSTY.getId());
        if (Constant06.MessageFunction.FUNC_16.equals(request.getHeader().getSubject().getFunction())) {
            internalStatusUpdate(request.getHeader(), veterinaryHygiene.getFiSignConfirmName(), Constant06.HosoStatus.DA_CAP_CV_VSTY.getId(), "Điều chỉnh công văn VSTY");
            if (!StringUtils.isEmpty(veterinaryHygiene.getFiReasonEdit())) {
                internalStatusUpdate(request.getHeader(), veterinaryHygiene.getFiSignConfirmName(), Constant06.HosoStatus.DA_CAP_CV_VSTY.getId(), "Lý do: " + veterinaryHygiene.getFiReasonEdit());
            }
        }
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson processVeterinaryHygieneFail(ResponseWrapper request) throws NSWException {
        VeterinaryHygieneFail veterinaryHygieneResult = getGson().fromJson(getGson().toJson(request.getData()), VeterinaryHygieneFail.class);
        if (veterinaryHygieneResult != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            internalStatusUpdate(request.getHeader(),
                    veterinaryHygieneResult.getFiCreaterName(), Constant06.HosoStatus.DA_CO_KQ_VSTY.getId(), String.format(
                            "Kết quả VSTY %s. Chuyên viên xử lý: %s. Đơn vị xử lý: %s. Ngày xử lý: %s",
                            Objects.equals(veterinaryHygieneResult.getFiResult(), 1) ? "đạt" : "không đạt",
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
    public ResponseJson updateHSStatus(ResponseWrapper request) throws NSWException {
        UpdateStatusBO statusBO = getGson().fromJson(getGson().toJson(request.getData()), UpdateStatusBO.class);
        internalStatusUpdate(request.getHeader(), "Cục Thú Y", statusBO.getFiTrangthai().intValue());
        return new ResponseJson(true, "", "Cập nhật trạng thái hồ sơ thành công");
    }

    @Override
    public ResponseJson getXml(SendMessage sendMessage) throws NSWException {
        TbdHoso06 regProfile = regProfileService.findByFiHSCode(sendMessage.getFiNSWFileCode());
        if (regProfile == null) throw new NSWException("Hồ sơ không tồn tại");
        SendMessage message = SendMessage.parse(regProfile);
        message.setType(sendMessage.getType());
        message.setXmlOnly(Boolean.TRUE);
        if (Constant06.MessageType.TYPE_10.equals(message.getType())) {
            if (regProfile.getFiHSStatus() == Constant06.HosoStatus.TAO_MOI.getId() ||
                    regProfile.getFiNSWFileCode() == null) {
                message.setFunction(Constant06.MessageFunction.FUNC_01);
            } else if (regProfile.getFiHSStatus() == Constant06.HosoStatus.CHO_TIEP_NHAN.getId()) {
                message.setFunction(Constant06.MessageFunction.FUNC_02);
            } else if (regProfile.getFiHSStatus() == Constant06.HosoStatus.YEU_CAU_BO_SUNG.getId()) {
                message.setFunction(Constant06.MessageFunction.FUNC_03);
            } else {
                throw new NSWException("Hồ sơ không hợp lệ");
            }
        } else if (Constant06.MessageType.TYPE_15.equals(message.getType())) {
            message.setFunction(Constant06.MessageFunction.FUNC_11);
            message.setReason(regProfile.getFiReason());
        } else {
            throw new NSWException("Bản tin yêu cầu chưa hỗ trợ ký số");
        }
        ResponseJson response = WsServiceHelper.createSendRequest(Constant06.WebServiceURL.get(environment), message);
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

    private void internalStatusUpdate(Header header, String exactSenderName, int status, String... reasons) throws NSWException {
        if (status != -1) {
            TbdHoso06 regProfile = regProfileService.findByFiHSCode(header.getSubject().getReference());
            if (regProfile == null) {
                throw new NSWException("Mã hồ sơ không tồn tại");
            }
            regProfile.setFiHSStatus(status);
            String hstContent;
            if (reasons.length == 0) {
                hstContent = "Cập nhật trạng thái hồ sơ: " + Constant06.HosoStatus.findById(status).getName();
            } else {
                hstContent = reasons[0];
            }
            hstService.save(createHistory(regProfile, hstContent, header, exactSenderName));
            regProfileService.save(regProfile);
        } else {
            throw new IllegalArgumentException("Status must not be -1");
        }
    }

    private TbdLichsu06 createHistory(TbdHoso06 regProfile, String hstContent) {
        Header header = new Header();
        From from = new From();
        from.setUnitCode(Constant06.SENDER.CODE);
        from.setUnitName(regProfile.getFiImporterName());
        from.setName(regProfile.getFiTaxCode());
        from.setIdentity(regProfile.getFiTaxCode());
        header.setFrom(from);
        return createHistory(regProfile, hstContent, header, regProfile.getFiTaxCode());
    }

    private TbdLichsu06 createHistory(TbdHoso06 regProfile, String hstContent, Header sendHeader, String exactSenderName) {
        TbdLichsu06 history = new TbdLichsu06();
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
        return "Cục Thú Y";
    }

}
