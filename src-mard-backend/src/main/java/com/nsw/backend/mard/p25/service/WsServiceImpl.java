package com.nsw.backend.mard.p25.service;


import com.google.gson.Gson;
import com.nsw.backend.mard.p25.client.*;
import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.helper.WsServiceHelper;
import com.nsw.backend.mard.p25.model.TbdLichsu25;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service("wsService25")
@Transactional(rollbackFor = NSWException.class)
public class WsServiceImpl implements WsService {
    private static final Logger log = LoggerFactory.getLogger(WsServiceImpl.class);
    private final TbdHoso25Service tbdHoso25Service;
    private final TbdLichsu25Service tbdLichsu25Service;

    private Gson gson;

    private final Environment environment;

    @Autowired
    public WsServiceImpl(TbdHoso25Service tbdHoso25Service, TbdLichsu25Service tbdLichsu25Service, Environment environment) {
        this.tbdHoso25Service = tbdHoso25Service;
        this.tbdLichsu25Service = tbdLichsu25Service;
       // this.certService = certService;
        this.environment = environment;
    }

    @Override
    public ResponseJson sendProfile(TbdHoso25 tbdHoso25) throws NSWException {
        SendMessage message = SendMessage.parse(tbdHoso25);
        message.setType(Constant25.MessageType.TYPE_10);
        int statusUpdate=0;
        if (tbdHoso25.getFiHSStatus() == Constant25.HosoStatus.TAO_MOI.getId()) {
            message.setFunction(Constant25.MessageFunction.FUNC_01);
            statusUpdate=Constant25.HosoStatus.CHO_TIEP_NHAN.getId();
        } else if (tbdHoso25.getFiHSStatus() == Constant25.HosoStatus.CHO_TIEP_NHAN.getId()) {
            message.setFunction(Constant25.MessageFunction.FUNC_02);
            statusUpdate=Constant25.HosoStatus.CHO_TIEP_NHAN.getId();
        } else if (tbdHoso25.getFiHSStatus() == Constant25.HosoStatus.CHO_TIEP_NHAN_HS_GUI_BS_TACN.getId()) {
            message.setFunction(Constant25.MessageFunction.FUNC_04);
            statusUpdate=Constant25.HosoStatus.CHO_TIEP_NHAN_HS_GUI_BS_TACN.getId();
        }else if (tbdHoso25.getFiHSStatus() == Constant25.HosoStatus.CHO_TIEP_NHAN_HS_GUI_BS_BPMC.getId()) {
            message.setFunction(Constant25.MessageFunction.FUNC_03);
            statusUpdate=Constant25.HosoStatus.CHO_TIEP_NHAN_HS_GUI_BS_BPMC.getId();
        } else {
            throw new NSWException("Hồ sơ không hợp lệ");
        }

        ResponseJson response = WsServiceHelper.createSendRequest(Constant25.WebServiceURL.get(environment), message);
        log.debug("Response: {}", response);
        if (response.isSuccess()) {
            // Ghi lại lịch sử gửi mới

            tbdHoso25.setFiHSStatus(statusUpdate);
            String content="";
            if (tbdHoso25.getFiHSStatus() == Constant25.HosoStatus.TAO_MOI.getId()) {
                tbdHoso25.setFiCreatedDate(new Date());
                content="Gửi mới hồ sơ";
            }else{
                tbdHoso25.setFiUpdatedDate(new Date());
                content="Gửi sửa đổi/bổ sung hồ sơ theo yêu cầu";
            }

            tbdHoso25Service.update(tbdHoso25);
            tbdLichsu25Service.save(createHistory(tbdHoso25, content));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi hồ sơ! " + response.getMessage());
        }
        return response;
    }


    @Override
    public ResponseJson xacNhanDonDK(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();
        int status=0;
        switch (function) {
            case Constant25.MessageFunction.FUNC_11:
                break;
            default:
                throw new NSWException("Invalid Function " + function + "on ProfileRegistration Response");

        }
        Gson gson = new Gson();
        XacNhanDon xnd = gson.fromJson(gson.toJson(request.getData()), XacNhanDon.class);
        internalStatusUpdate(request.getHeader(), xnd.getFiAssignName(), status);

        tbdLichsu25Service.save(createHistory(
                    tbdHoso25Service.findByFiHSCode(request.getHeader().getSubject().getReference()),
                    "Xác nhận đơn đăng ký " , request.getHeader(), xnd.getFiAssignName()));

        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson tiepNhanKetQuaXuLy(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();
        int status=0;
        switch (function) {
            case Constant25.MessageFunction.FUNC_06:
                break;
            case Constant25.MessageFunction.FUNC_07:
                break;
            case Constant25.MessageFunction.FUNC_08:
                break;
            case Constant25.MessageFunction.FUNC_09:
                break;
            case Constant25.MessageFunction.FUNC_10:
                break;
            default:
                throw new NSWException("Invalid Function " + function + "on ProfileRegistration Response");

        }
        Gson gson = new Gson();
        KetQuaXuLy xnd = gson.fromJson(gson.toJson(request.getData()), KetQuaXuLy.class);
        internalStatusUpdate(request.getHeader(), xnd.getFiNameOfStaff(), status);

        tbdLichsu25Service.save(createHistory(
                tbdHoso25Service.findByFiHSCode(request.getHeader().getSubject().getReference()),
                "Xác nhận đơn đăng ký " , request.getHeader(), xnd.getFiNameOfStaff()));

        return new ResponseJson(true, "");
    }


    @Override
    public ResponseJson getXml(SendMessage sendMessage) throws NSWException {
        return null;
    }

    @Override
    public ResponseJson tiepNhanHS2D(ResponseWrapper request)  throws NSWException{
        return null;
    }

    @Override
    public ResponseJson thuHoiGDK(ResponseWrapper request)  throws NSWException{
        return null;
    }

    @Override
    public ResponseJson tccdGuiKQKT(ResponseWrapper request)  throws NSWException{
        return null;
    }

    @Override
    public ResponseJson guiXuLyKQ(ResponseWrapper request)  throws NSWException{
        return null;
    }

    @Override
    public ResponseJson guiGiayXNCL(ResponseWrapper request)  throws NSWException{
        return null;
    }

    @Override
    public ResponseJson thuHoiGiayXNCL(ResponseWrapper request)  throws NSWException{
        return null;
    }

    @Override
    public ResponseJson chuyenChiTieu(TbdHoso25 tbdHoso25) throws NSWException{
        SendMessage message = SendMessage.parse(tbdHoso25);
        message.setType(Constant25.MessageType.TYPE_15);
        message.setFunction(Constant25.MessageFunction.FUNC_13);
        ResponseJson response = WsServiceHelper.createSendRequest(Constant25.WebServiceURL.get(environment), message);
        if (response.isSuccess()) {
            // Ghi lại lịch sử gửi mới
            int statusUpdate=Constant25.HosoStatus.CHO_KQ_DANH_GIA_SPH.getId();
            tbdHoso25.setFiHSStatus(statusUpdate);
            tbdHoso25Service.update(tbdHoso25);
            tbdLichsu25Service.save(createHistory(tbdHoso25, "Chuyển chỉ tiêu kiểm tra cho cả lô hàng"));
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi hồ sơ! " + response.getMessage());
        }
        return response;
    }

    private TbdLichsu25 createHistory(TbdHoso25 tbdHoso25, String hstContent) {
        Header header = new Header();
        From from = new From();
        from.setUnitCode(Constant25.SENDER.CODE);
        from.setUnitName(tbdHoso25.getFiImporterName());
        from.setName(tbdHoso25.getFiTaxCode());
        from.setIdentity(tbdHoso25.getFiTaxCode());
        header.setFrom(from);
        return createHistory(tbdHoso25, hstContent, header, tbdHoso25.getFiTaxCode());
    }

    private TbdLichsu25 createHistory(TbdHoso25 tbdHoso25, String hstContent, Header sendHeader, String exactSenderName) {
        TbdLichsu25 history = new TbdLichsu25();
        history.setFiContent(hstContent);
        history.setFiHSCode(tbdHoso25.getFiNSWFileCode());
        history.setFiIdHS(tbdHoso25.getFiIdHS());
        history.setFiSenderCode(sendHeader.getFrom().getIdentity());
        history.setFiSenderName(exactSenderName);
        history.setFiSenderUnitCode(sendHeader.getFrom().getUnitCode());
        if (!StringUtils.isEmpty(sendHeader.getFrom().getUnitName())) {
            history.setFiSenderUnitName(sendHeader.getFrom().getUnitName());
        } else {
            //TODO: Map đến các đơn vị tương ứng
            history.setFiSenderUnitName(parseSenderUnitName(sendHeader.getFrom().getUnitCode()));
        }
        history.setFiStatus(tbdHoso25.getFiHSStatus());

        return history;
    }
    private String parseSenderUnitName(String unitCode) {
        return "Cục Chăn Nuôi";
    }

    private void internalStatusUpdate(Header header, String exactSenderName, int status, String... reasons) throws NSWException {
        if (status != -1) {
            TbdHoso25 tb = tbdHoso25Service.findByFiHSCode(header.getSubject().getReference());
            if (tb == null) {
                throw new NSWException("Mã hồ sơ không tồn tại");
            }
            tb.setFiHSStatus(status);
            String hstContent;
            if (reasons.length == 0) {
                hstContent = "Cập nhật trạng thái hồ sơ: " + Constant25.HosoStatus.findById(status).getName();
            } else {
                hstContent = reasons[0];
            }
            tbdLichsu25Service.save(createHistory(tb, hstContent, header, exactSenderName));
            tbdHoso25Service.save(tb);
        } else {
            throw new IllegalArgumentException("Status must not be -1");
        }
    }
}
