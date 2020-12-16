package com.nsw.backend.mard.p26.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.mard.p26.client.From;
import com.nsw.backend.mard.p26.client.Header;
import com.nsw.backend.mard.p26.client.ResponseWrapper;
import com.nsw.backend.mard.p26.dto.PhanHoiDonDK;
import com.nsw.backend.mard.p26.helper.WsServiceHelper;
import com.nsw.backend.mard.p26.constant.Constant26;
import com.nsw.backend.mard.p26.dto.SendMessage;
import com.nsw.backend.mard.p26.exception.NSWException;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.mard.p26.model.TbdLichsu26;
import com.nsw.backend.mard.p26.model.TbdThuHoiCV26;
import com.nsw.backend.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("webService26")
@Transactional(rollbackFor = NSWException.class)
public class WebService26Impl implements WebService26{
    private final TbdHoso26Service tbdHoso26Service;
    private final TbdLichsu26Service tbdLichsu26Service;
    private final TbdThuHoiCV26Service tbdThuHoiCV26Service;
    private final Environment environment;
    private Gson gson;

    public WebService26Impl(Environment environment, TbdHoso26Service tbdHoso26Service, TbdLichsu26Service tbdLichsu26Service, TbdThuHoiCV26Service tbdThuHoiCV26Service) {
        this.environment = environment;
        this.tbdHoso26Service = tbdHoso26Service;
        this.tbdLichsu26Service = tbdLichsu26Service;
        this.tbdThuHoiCV26Service = tbdThuHoiCV26Service;
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context) -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                    .create();
        }
        return gson;
    }
    @Override
    public ResponseJson sendHoso26(TbdHoso26 tbdHoso26) {
        SendMessage message = SendMessage.parse(tbdHoso26);
        message.setType(Constant26.MessageType.TYPE_10);
        int statusUpdate=0;
        if (tbdHoso26.getFiTrangthai() == Constant26.HosoStatus.TAO_MOI.getId()) {
            message.setFunction(Constant26.MessageFunction.FUNC_01);
            statusUpdate=Constant26.HosoStatus.CHO_TIEP_NHAN.getId();
        }
        ResponseJson response = WsServiceHelper.createSendRequest(Constant26.WebServiceURL.get(environment), message);
        if(response.isSuccess()){
            tbdHoso26.setFiTrangthai(statusUpdate);
            tbdHoso26.setFiNgayGui(new Date());
        }
        tbdHoso26Service.update(tbdHoso26);
        tbdLichsu26Service.save(createLichSuEntity(tbdHoso26,"Gửi mới hồ sơ",null,createHeaderFromTBDHoso26(tbdHoso26)));
        return response;
    }

    @Override
    public ResponseJson phanHoiDon(ResponseWrapper request) {
        String function = request.getHeader().getSubject().getFunction();
        int status=0;
        switch (function) {
            case Constant26.MessageFunction.FUNC_03:
                status=Constant26.HosoStatus.DA_TIEP_NHAN.getId();
                break;
            default:
                return new ResponseJson(false, "","MESSAGE 11 - "+function+" CHUA DUOC DINH NGHIA");
        }
        try {
            PhanHoiDonDK phanHoiDonDK = getGson().fromJson(getGson().toJson(request.getData()), PhanHoiDonDK.class);
            TbdHoso26 tbdHoso26 = tbdHoso26Service.findByFiHSCode(phanHoiDonDK.getFiMaHoso());
            if (null==tbdHoso26){
                responseNull();
            }
            tbdHoso26.setFiTrangthai(status);
            tbdHoso26Service.update(tbdHoso26);
            tbdLichsu26Service.save(createLichSuEntity(tbdHoso26,"BNN tiếp nhận đơn đăng ký",
                    phanHoiDonDK.getFiNguoiXL(),createHeaderFromTBDHoso26(tbdHoso26)));
            return new ResponseJson(true, "","");
        }catch (Exception e){
            return new ResponseJson(false, "",e.getMessage());
        }
    }

    @Override
    public ResponseJson tiepNhanCVMienKiem(ResponseWrapper request) {
        String function = request.getHeader().getSubject().getFunction();
        int status=0;
        switch (function) {
            case Constant26.MessageFunction.FUNC_04:
                status=Constant26.HosoStatus.DA_CAP_CONG_VAN_MIEN_GIAM.getId();
                break;
            default:
                return new ResponseJson(false, "","MESSAGE 12 - "+function+" CHUA DUOC DINH NGHIA");

        }
        try {
            TbdHoso26 cvMK =  getGson().fromJson(getGson().toJson(request.getData()), TbdHoso26.class);
            TbdHoso26 tbdHoso26 = tbdHoso26Service.findByFiHSCode(cvMK.getFiMaHoso());
            if (null==tbdHoso26){
                responseNull();
            }
            tbdHoso26.setFiTrangthai(status);
            tbdHoso26.setFiSoCVMienKiem(cvMK.getFiSoCVMienKiem());
            tbdHoso26.setFiCertNo(cvMK.getFiSoCVMienKiem());
            tbdHoso26.setFiNgayKyCV(cvMK.getFiNgayKyCV());
            tbdHoso26.setFiTenNguoiKyCV(cvMK.getFiTenNguoiKyCV());
            tbdHoso26.setFiHieuLucTuNgay(cvMK.getFiHieuLucTuNgay());
            tbdHoso26.setFiHieuLucToiNgay(cvMK.getFiHieuLucToiNgay());

            tbdHoso26.getFiProductList().get(0).setFiProCVMienGiam(cvMK.getFiSoCVMienKiem());
            tbdHoso26.getFiProductList().get(0).setFiProCVMienGiamNgay(cvMK.getFiNgayKyCV());

            tbdHoso26Service.update(tbdHoso26);
            tbdLichsu26Service.save(createLichSuEntity(tbdHoso26,"BNN gửi CV miễn giảm kiểm tra",
                    tbdHoso26.getFiTenNguoiKyCV(),createHeaderFromTBDHoso26(tbdHoso26)));
            return new ResponseJson(true, "","");
        }catch (Exception e){
            return new ResponseJson(false, "",e.getMessage());
        }
    }

    @Override
    public ResponseJson thuHoiCVMienKiem(ResponseWrapper request) {
        String function = request.getHeader().getSubject().getFunction();
        int status=0;
        switch (function) {
            case Constant26.MessageFunction.FUNC_05:
                status=Constant26.HosoStatus.DA_THU_HOI_CONG_VAN_MIEN_GIAM.getId();
                break;
            default:
                return new ResponseJson(false, "","MESSAGE 13 - "+function+" CHUA DUOC DINH NGHIA");
        }
        try {
            TbdThuHoiCV26 tbdThuHoiCV26 =getGson().fromJson(getGson().toJson(request.getData()), TbdThuHoiCV26.class);
            TbdHoso26 tbdHoso26 = tbdHoso26Service.findByFiHSCode(tbdThuHoiCV26.getFiMaHoso());
            if (null==tbdHoso26){
                responseNull();
            }
            tbdHoso26.setFiTrangthai(status);
            tbdThuHoiCV26.setFiIdHoSo26(tbdHoso26.getFiIdHoSo26());
            tbdThuHoiCV26Service.save(tbdThuHoiCV26);
            tbdLichsu26Service.save(createLichSuEntity(tbdHoso26,tbdThuHoiCV26.getFiLyDoThuHoi(),tbdThuHoiCV26.getFiNguoiKy(),createHeaderFromTBDHoso26(tbdHoso26)));
            return new ResponseJson(true, "","");
        }catch (Exception e){
            return new ResponseJson(false, "",e.getMessage());
        }

    }
    private ResponseJson responseNull(){
        return new ResponseJson(false, "","KHONG TIM THAY MA HO SO");
    }

    private TbdLichsu26 createLichSuEntity(TbdHoso26 tbdHoso26, String content, String nameOfStaff, Header header){
        TbdLichsu26 tbdLichsu26 = new TbdLichsu26();
        tbdLichsu26.setFiStatus(tbdHoso26.getFiTrangthai());
        tbdLichsu26.setFiHSCode(tbdHoso26.getFiMaHoso());
        tbdLichsu26.setFiIdHS(tbdHoso26.getFiIdHoSo26());
        tbdLichsu26.setFiSenderCode(header.getFrom().getIdentity());
        tbdLichsu26.setFiSenderUnitCode(header.getFrom().getUnitCode());
        tbdLichsu26.setFiSenderUnitName("Cục Chăn nuôi");

        tbdLichsu26.setFiContent(content);
        tbdLichsu26.setFiSenderName(nameOfStaff);
        return tbdLichsu26;
    }
    private Header createHeaderFromTBDHoso26(TbdHoso26 tbdHoso26){
        Header header = new Header();
        From from = new From();
        from.setUnitCode(Constant26.SENDER.CODE);
        from.setUnitName(tbdHoso26.getFiMasothue());
        from.setName(tbdHoso26.getFiTenDn());
        from.setIdentity(tbdHoso26.getFiMasothue());
        header.setFrom(from);
        return header;
    }
}
