package com.nsw.backend.mard.p25.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.nsw.backend.mard.p25.client.*;
import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.dto.Ananytical;
import com.nsw.backend.mard.p25.dto.BNNThongBaoThuHoiGDK;
import com.nsw.backend.mard.p25.model.*;
import com.nsw.backend.mard.p25.dto.SendMessage;
import com.nsw.backend.mard.p25.helper.WsServiceHelper;
import com.nsw.backend.mard.p25.exception.NSWException;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("wsService25")
@Transactional(rollbackFor = NSWException.class)
public class WsServiceImpl implements WsService {
    private static final Logger log = LoggerFactory.getLogger(WsServiceImpl.class);
    private final TbdHoso25Service tbdHoso25Service;
    private final TbdLichsu25Service tbdLichsu25Service;
    private final TbdXacNhanDon25Service tbdXacNhanDon25Service;
    private final TbdHangHoa25Service tbdHangHoa25Service;
    private final TbdHangHoaFile25Service tbdHangHoaFile25Service;
    private final TbdLichSuHH25Service tbdLichSuHH25Service;
    private final TbdChiTieuDG25Service tbdChiTieuDG25Service;

    @Autowired
    private TbdHosoTccd25Service tbdHosoTccd25Service;
    @Autowired
    private TbdKQXL25Service tbdKQXL25Service;
    private Gson gson;

    private final Environment environment;

    @Autowired
    public WsServiceImpl(TbdHoso25Service tbdHoso25Service, TbdLichsu25Service tbdLichsu25Service, Environment environment, TbdXacNhanDon25Service tbdXacNhanDon25Service, TbdHangHoa25Service tbdHangHoa25Service, TbdHangHoaFile25Service tbdHangHoaFile25Service, TbdLichSuHH25Service tbdLichSuHH25Service, TbdChiTieuDG25Service tbdChiTieuDG25Service) {
        this.tbdHoso25Service = tbdHoso25Service;
        this.tbdLichsu25Service = tbdLichsu25Service;
       // this.certService = certService;
        this.environment = environment;
        this.tbdXacNhanDon25Service = tbdXacNhanDon25Service;
        this.tbdHangHoa25Service = tbdHangHoa25Service;
        this.tbdHangHoaFile25Service = tbdHangHoaFile25Service;
        this.tbdLichSuHH25Service = tbdLichSuHH25Service;
        this.tbdChiTieuDG25Service = tbdChiTieuDG25Service;
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
        String action="";
        switch (function) {
            case Constant25.MessageFunction.FUNC_11:
                status=Constant25.HosoStatus.DA_XAC_NHAN_GDK.getId();
                action=Constant25.HosoStatus.DA_XAC_NHAN_GDK.getName();
                break;
            default:
                return new ResponseJson(false, "","MESSAGE 13 - "+function+" CHUA DUOC DINH NGHIA");

        }

        XacNhanDon xnd = getGson().fromJson(getGson().toJson(request.getData()), XacNhanDon.class);
        TbdHoso25 tbdHoso25 =tbdHoso25Service.findByFiHSCode(request.getHeader().getSubject().getReference());

        if(tbdHoso25==null){
            return new ResponseJson(false, "","MA HO SO KHONG TON TAI");
        }

        mappingXacNhanDon(xnd);
        tbdHoso25.setFiHSStatus(status);
        tbdHoso25Service.save(tbdHoso25);
        tbdLichsu25Service.save(createHistory(tbdHoso25,action,request.getHeader(),xnd.getDepartmentName()));
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson tiepNhanKetQuaXuLy(ResponseWrapper request) throws NSWException {
        String function = request.getHeader().getSubject().getFunction();
        int status=0;
        String action="";
        switch (function) {
            case Constant25.MessageFunction.FUNC_06:
                status=Constant25.HosoStatus.DA_TIEP_NHAN.getId();
                action=Constant25.HosoStatus.DA_TIEP_NHAN.getName();
                break;
            case Constant25.MessageFunction.FUNC_07:
                status=Constant25.HosoStatus.BPMC_YCBS_HO_SO.getId();
                action=Constant25.HosoStatus.BPMC_YCBS_HO_SO.getName();
                break;
            case Constant25.MessageFunction.FUNC_08:
                status=Constant25.HosoStatus.DA_TU_CHOI.getId();
                action=Constant25.HosoStatus.DA_TU_CHOI.getName();
                break;
            case Constant25.MessageFunction.FUNC_09:
                status=Constant25.HosoStatus.TACN_YCBS_HO_SO.getId();
                action=Constant25.HosoStatus.TACN_YCBS_HO_SO.getName();
                break;
            case Constant25.MessageFunction.FUNC_10:
                status=Constant25.HosoStatus.DA_TU_CHOI_CAP_GDK.getId();
                action=Constant25.HosoStatus.DA_TU_CHOI_CAP_GDK.getName();
                break;
            default:
                return new ResponseJson(false, "","MESSAGE 12 - "+function+" CHUA DUOC DINH NGHIA");

        }
        KetQuaXuLy xnd=null;
        try{
            xnd = getGson().fromJson(getGson().toJson(request.getData()), KetQuaXuLy.class);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
        internalStatusUpdate(request.getHeader(), xnd.getFiNameOfStaff(), status,xnd.getFiReason());
        TbdHoso25 tbdHoso25 = tbdHoso25Service.findByFiHSCode(xnd.getFiNSWFileCode());
        if(null==tbdHoso25){
            return new ResponseJson(false, "","KHONG TIM THAY MA HO SO");
        }
        tbdLichsu25Service.save(createHistory(
                tbdHoso25Service.findByFiHSCode(request.getHeader().getSubject().getReference()),
                action , request.getHeader(), xnd.getFiNameOfStaff()));

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
        String function = request.getHeader().getSubject().getFunction();
        int status=0;
        String action="";
        switch (function) {
            case Constant25.MessageFunction.FUNC_12:
                status=Constant25.HosoStatus.DA_THU_HOI_GXN.getId();
                action=Constant25.HosoStatus.DA_THU_HOI_GXN.getName();
                break;
            default:
                return new ResponseJson(false, "","MESSAGE 14 - "+function+" CHUA DUOC DINH NGHIA");

        }
        BNNThongBaoThuHoiGDK thuHoiGDK = getGson().fromJson(getGson().toJson(request.getData()),BNNThongBaoThuHoiGDK.class);
        TbdXacNhanDon25 xacNhanDon25 = tbdXacNhanDon25Service.findByFiNSWFileCode(thuHoiGDK.getFiNSWFileCode());
        if(null==xacNhanDon25){
            return new ResponseJson(false, "","MA HO SO KHONG TON TAI");
        }
        xacNhanDon25.setFiNgayThuHoi(thuHoiGDK.getFiCancelDate());
        xacNhanDon25.setFiLyDoThuHoi(thuHoiGDK.getFiReason());
        xacNhanDon25.setFiNguoiXN(thuHoiGDK.getFiSignConfirmName());
        tbdXacNhanDon25Service.save(xacNhanDon25);
        TbdHoso25 tbdHoso25=tbdHoso25Service.findByFiHSCode(thuHoiGDK.getFiNSWFileCode());
        tbdHoso25.setFiHSStatus(status);
        tbdHoso25Service.save(tbdHoso25);
        tbdLichsu25Service.save(createHistory(tbdHoso25,"Thu hồi giấy đăng ký",request.getHeader(),thuHoiGDK.getFiSignConfirmName()));
        return new ResponseJson(true, "");
    }

    @Override
    public ResponseJson tccdGuiKQKT(ResponseWrapper request)  throws NSWException{
        try{
            String function = request.getHeader().getSubject().getFunction();
            int status=0;
            String action="";
            switch (function) {
                case Constant25.MessageFunction.FUNC_14:
                    status=Constant25.HosoStatus.DA_CO_KQ_DANH_GIA_SPH.getId();
                    action=Constant25.HosoStatus.DA_CO_KQ_DANH_GIA_SPH.getName();
                    break;
                default:
                    return new ResponseJson(false, "","MESSAGE 16 - "+function+" CHUA DUOC DINH NGHIA");

            }

            TCCDGuiKQKT kqkt = getGson().fromJson(getGson().toJson(request.getData()), TCCDGuiKQKT.class);
            TbdHoso25 tbdHoso25 = tbdHoso25Service.findByFiHSCode(kqkt.getFiNSWFileCode());
            List<TbdHanghoa25> listHanghoa25=tbdHoso25.getFiProductList();
            for (TbdHanghoa25 hanghoa25: listHanghoa25) {
                if(hanghoa25.getFiIdProduct().equals(Integer.valueOf(kqkt.getFiMaHangHoa()))){
                    List<TbdHangHoaFile25> listHangHoa=new ArrayList<>();
                    hanghoa25.setFiTrangThaiHangHoa(status);
                    for (AttachmentResult attach : kqkt.getFiDanhSachDinhKem()) {
                        TbdHangHoaFile25 hanghoaFile = new TbdHangHoaFile25();
                        hanghoaFile.setFiIDHangHoa(kqkt.getFiMaHangHoa());
                        hanghoaFile.setFiFileId(attach.getFiAttachmentId());
                        hanghoaFile.setFiFileLink(attach.getFiLinkFile());
                        hanghoaFile.setFiFileName(attach.getFiNameOfAttachment());
                        hanghoaFile.setFiLoaiFile(1);
                        hanghoaFile.setFiTenLoai("File thông tin kết quả phân tích");
                        listHangHoa.add(hanghoaFile);
                    }
                    if(!listHangHoa.isEmpty()&&null!=listHangHoa){
                        tbdHangHoaFile25Service.saveAll(listHangHoa);
                    }
                    hanghoa25.setFiKqdgsph(kqkt.getFiKetQuaDanhGia());
                    tbdHangHoa25Service.save(hanghoa25);
                    tbdLichSuHH25Service.save(createLichSuHangHoa(tbdHoso25,hanghoa25,"TCCD gửi kết quả",kqkt.getFiAssignName(),action,Constant25.BNN_SEND));
                }
            }
            TbdhosoTccd25 tbdhosoTccd25 = new TbdhosoTccd25();
            tbdhosoTccd25.setFiMaCqkt(tbdHoso25.getFiIdDVXL());
            tbdhosoTccd25.setFiTenCqkt(tbdHoso25.getFiNameDVXL());
            tbdhosoTccd25.setFiHsCode(kqkt.getFiNSWFileCode());
            tbdhosoTccd25.setFiIdFileGcn(kqkt.getFiMaFileGCN());
            tbdhosoTccd25.setFiNameFileGcn(kqkt.getFiNameFileGCN());
            tbdhosoTccd25.setFiLinkGcn(kqkt.getFiLinkFileGCN());
            tbdhosoTccd25.setFiIdHangHoa(kqkt.getFiMaHangHoa());
            tbdhosoTccd25.setFiTenHangHoa(kqkt.getFiTenHangHoa());
            tbdhosoTccd25.setFiLoaiDanhgia(kqkt.getFiKetQuaDanhGia());
            tbdhosoTccd25.setFiNgaycap(kqkt.getFiNgayCap());
            tbdhosoTccd25.setFiSoGcn(kqkt.getFiSoGCN());
            tbdHosoTccd25Service.save(tbdhosoTccd25);
            return new ResponseJson(true, "");
        }catch (Exception e){
            return new ResponseJson(false, "LOI TRONG QUA TRINH XU LY BAN TIN");
        }

    }

    @Override
    public ResponseJson guiXuLyKQ(ResponseWrapper request) throws NSWException {
        try{
            String function = request.getHeader().getSubject().getFunction();
            int status=0;
            String action="";
            switch (function) {
                case Constant25.MessageFunction.FUNC_19:
                    status=Constant25.HosoStatus.BPMC_YCBS_KQ_DANH_GIA_SPH.getId();
                    action=Constant25.HosoStatus.BPMC_YCBS_KQ_DANH_GIA_SPH.getName();
                    break;
                case Constant25.MessageFunction.FUNC_20:
                    status=Constant25.HosoStatus.DA_TIEP_NHAN_KQ_DANH_GIA_SPH.getId();
                    action=Constant25.HosoStatus.DA_TIEP_NHAN_KQ_DANH_GIA_SPH.getName();
                    break;
                default:
                    return new ResponseJson(false, "","MESSAGE 18 - "+function+" CHUA DUOC DINH NGHIA");

            }
            BNNXuLyKQ bnnXuLyKQ = getGson().fromJson(getGson().toJson(request.getData()),BNNXuLyKQ.class);

            TbdKQXL25 tbdKQXL25 = tbdKQXL25Service.findByFiNSWFileCodeAndFiProId(bnnXuLyKQ.getFiNSWFileCode(),bnnXuLyKQ.getFiMaHangHoa());
            TbdHanghoa25 tbdHanghoa25 = tbdHangHoa25Service.findByFiIdProduct(bnnXuLyKQ.getFiMaHangHoa());
            TbdHoso25 tbdHoso25 = tbdHoso25Service.findByFiHSCode(bnnXuLyKQ.getFiNSWFileCode());
            if(tbdKQXL25==null||tbdHanghoa25==null||tbdHoso25==null){
                return new ResponseJson(false, "","KHONG TIM THAY HO SO/HANG HOA");
            }
            tbdKQXL25.setFiLyDo(bnnXuLyKQ.getFiLyDo());
            tbdKQXL25.setFiNgayPhanHoi(bnnXuLyKQ.getFiResponseDate());
            tbdKQXL25.setFiNguoiXL(bnnXuLyKQ.getFiNameOfStaff());
            tbdKQXL25Service.save(tbdKQXL25);
            tbdHanghoa25.setFiTrangThaiHangHoa(status);
            tbdHangHoa25Service.save(tbdHanghoa25);
            tbdLichSuHH25Service.save(createLichSuHangHoa(tbdHoso25,tbdHanghoa25,action,bnnXuLyKQ.getFiNameOfStaff(),action,2));
        }catch (Exception ex){

        }
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

        GuiHSTCCD guiHSTCCD = new GuiHSTCCD();
        guiHSTCCD.setFiIdDVXL(tbdHoso25.getFiIdDVXL());
        guiHSTCCD.setFiNameDVXL(tbdHoso25.getFiNameDVXL());
        guiHSTCCD.setFiNSWFileCode(tbdHoso25.getFiNSWFileCode());

        List<TbdHanghoa25> tbdHanghoa25s = tbdHoso25.getFiProductList();
        List<TbdHanghoa25> tbdHangHoaBT = new ArrayList<>();
        for (TbdHanghoa25 hangHoa: tbdHanghoa25s){
            TbdHanghoa25 hang = new TbdHanghoa25();
            hang.setFiIdProduct(hangHoa.getFiIdProduct());
            hang.setFiProName(hangHoa.getFiProName());
            hang.setFiProIdLoai(hangHoa.getFiProIdLoai());
            hang.setFiProNameLoai(hangHoa.getFiProNameLoai());
            List<TbdChiTieuDG25> lstChiTieuDG25 = tbdChiTieuDG25Service.findByFiIdProduct(hangHoa.getFiIdProduct());
            hang.setFiListChiTieu(lstChiTieuDG25);
            tbdHangHoaBT.add(hang);
        }

        guiHSTCCD.setFiProductList(tbdHangHoaBT);
        message.setDataRequest(getGson().toJson(guiHSTCCD));
        ResponseJson response = WsServiceHelper.createSendRequest(Constant25.WebServiceURL.get(environment), message);
        if (response.isSuccess()) {
            // Ghi lại lịch sử gửi mới
            int statusUpdate=Constant25.HosoStatus.CHO_KQ_DANH_GIA_SPH.getId();
            String action=Constant25.HosoStatus.CHO_KQ_DANH_GIA_SPH.getName();
            List<TbdHanghoa25> lsHangHoa=tbdHoso25.getFiProductList();
            for (TbdHanghoa25 tbdHanghoa25: lsHangHoa){
                tbdHanghoa25.setFiTrangThaiHangHoa(statusUpdate);
                tbdLichSuHH25Service.save(createLichSuHangHoa(tbdHoso25,tbdHanghoa25,action,tbdHoso25.getFiImporterName(),action,1));
            }
            tbdHangHoa25Service.saveAll(lsHangHoa);
        } else {
            throw new NSWException("Có lỗi trong quá trình gửi hồ sơ! " + response.getMessage());
        }
        return response;
    }

    @Override
    public ResponseJson yeuCauRutHS(TbdYcrut25 requestCancel) {

        SendMessage message = new SendMessage();

        requestCancel.setFiRequestedDate(null);
        message.setFiMaHoso(requestCancel.getFiNSWFileCode());
        message.setType(Constant25.MessageType.TYPE_11);
        message.setFunction(Constant25.MessageFunction.FUNC_05);
        message.setDataRequest(getGson().toJson(requestCancel));
        message.setFiIdHoso(Long.valueOf(requestCancel.getFiIdHS()));
        ResponseJson response = WsServiceHelper.createSendRequest(Constant25.WebServiceURL.get(environment), message);
        if (response.isSuccess()){
            TbdHoso25 hs25= tbdHoso25Service.findById(requestCancel.getFiIdHS());
            hs25.setFiHSStatus(Constant25.HosoStatus.DA_RUT_HO_SO.getId());
            tbdLichsu25Service.save(createHistory(hs25,Constant25.HosoStatus.DA_RUT_HO_SO.getName()));
            tbdHoso25Service.save(hs25);
            response.setSuccess(true);
            response.setMessage("Rút hồ sơ thành công");
        }else{
            response.setSuccess(false);
            response.setMessage("Có lỗi xảy ra khi rút hồ sơ");
        }
        return response;
    }

    @Override
    public ResponseJson dnNopKQ(TbdKQXL25 tbdKQXL25, TbdHoso25 tbdHoso25) throws NSWException {
        SendMessage message = new SendMessage();
        message.setFiMaHoso(tbdKQXL25.getFiNSWFileCode());
        message.setDataRequest(getGson().toJson(tbdKQXL25));
        message.setFiIdHoso(Long.valueOf(tbdHoso25.getFiIdHS()));
        String type=Constant25.MessageType.TYPE_17;
        String function="";
        String action="";
        int status=tbdHoso25.getFiHSStatus();
        switch (tbdHoso25.getFiHSStatus()){
            case 26:
            case 28:
                function=Constant25.MessageFunction.FUNC_15;
                status=Constant25.HosoStatus.CHO_TIEP_NHAN_KQ_DANH_GIA_SPH.getId();
                action=Constant25.HosoStatus.CHO_TIEP_NHAN_KQ_DANH_GIA_SPH.getName();
                break;
            case 32:
            case 33:
                function=Constant25.MessageFunction.FUNC_17;
                status=Constant25.HosoStatus.CHO_TIEP_NHAN_KQ_DANH_GIA_SPH_GUI_BS_BPMC.getId();
                action=Constant25.HosoStatus.CHO_TIEP_NHAN_KQ_DANH_GIA_SPH_GUI_BS_BPMC.getName();
                break;
            case 38:
                function=Constant25.MessageFunction.FUNC_18;
                status=Constant25.HosoStatus.CHO_TIEP_NHAN_KQ_DANH_GIA_SPH_GUI_BS_TACN.getId();
                action=Constant25.HosoStatus.CHO_TIEP_NHAN_KQ_DANH_GIA_SPH_GUI_BS_TACN.getName();
                break;
        }
        message.setFunction(function);
        message.setType(type);
        ResponseJson response = WsServiceHelper.createSendRequest(Constant25.WebServiceURL.get(environment), message);
        if (response.isSuccess()){
            tbdKQXL25Service.save(tbdKQXL25);
            TbdHanghoa25 tbdHanghoa25 = tbdHangHoa25Service.findByFiIdProduct(tbdKQXL25.getFiProId());
            tbdHanghoa25.setFiTrangThaiHangHoa(status);
            if(tbdHoso25.getFiHSType()==3){
                tbdHoso25.setFiIdDVXL(tbdKQXL25.getFiDVXLCode());
                tbdHoso25.setFiNameDVXL(tbdKQXL25.getFiDVXLName());
                tbdHoso25Service.save(tbdHoso25);
            }
            tbdHangHoa25Service.save(tbdHanghoa25);
            tbdLichSuHH25Service.save(createLichSuHangHoa(tbdHoso25,tbdHanghoa25,action,tbdHoso25.getFiImporterName(),action,1));
            response.setSuccess(true);
        }else{
            response.setSuccess(false);
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
    private TbdLichSuHH25 createLichSuHangHoa(TbdHoso25 tbdHoso25,TbdHanghoa25 hangHoa,String hstContent,String nguoiGui,String trangThai,Integer send){
        TbdLichSuHH25 tbdLichSuHH25 = new TbdLichSuHH25();
        tbdLichSuHH25.setFiIDHangHoa(hangHoa.getFiIdProduct());
        tbdLichSuHH25.setFiHoatDong(1);
        tbdLichSuHH25.setFiNgayGui(new Date());
        if(null==nguoiGui||nguoiGui.equals("")){
            tbdLichSuHH25.setFiNguoiGui("Cục Chăn Nuôi");
        }else{
            tbdLichSuHH25.setFiNguoiGui(nguoiGui);
        }
        tbdLichSuHH25.setFiNguoiNhan(tbdHoso25.getFiImporterName());
        tbdLichSuHH25.setFiNoiDung(hstContent);
        tbdLichSuHH25.setFiTrangThai(trangThai);
        tbdLichSuHH25.setFiNswSend(send);
        return tbdLichSuHH25;
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
    private void mappingXacNhanDon(XacNhanDon xnd){
        TbdXacNhanDon25 tbdXacNhanDon25 = new TbdXacNhanDon25();
        tbdXacNhanDon25.setFiNSWFileCode(xnd.getFiNSWFileCode());
        tbdXacNhanDon25.setFiSoGXN(xnd.getFiAniFeedConfirmNo());
        tbdXacNhanDon25.setFiIdCqcd(xnd.getFiAssignID());
        tbdXacNhanDon25.setFiNameCqcd(xnd.getFiAssignName());
        tbdXacNhanDon25.setFiIdCqxl(xnd.getDepartmentCode());
        tbdXacNhanDon25.setFiNameCqxl(xnd.getDepartmentName());
        tbdXacNhanDon25.setFiNgayXN(xnd.getFiSignConfirmDate());
        tbdXacNhanDon25.setFiNoiXN(xnd.getFiSignConfirmPlace());
        tbdXacNhanDon25.setFiNguoiXN(xnd.getFiSignName());
        tbdXacNhanDon25.setFiDvdg(xnd.getFiAssignNameOther());
        tbdXacNhanDon25.setFiGhiChu(xnd.getFiNoteGoods());
        for(Goods hangHoa:xnd.getFiProductList()){
            for (Ananytical ananytical:hangHoa.getFiAnanyticalRequiredList()) {
                TbdChiTieuDG25 tbdChiTieuDG25 = new TbdChiTieuDG25();
                tbdChiTieuDG25.setFiIdProduct(hangHoa.getFiGoodsId());
                tbdChiTieuDG25.setFiTenHangHoa(hangHoa.getFiNameOfGoods());
                tbdChiTieuDG25.setFiTenChiTieu(ananytical.getFiAnanyticalName());
                tbdChiTieuDG25.setFiHinhThucCB(ananytical.getFiFormOfPublication());
                tbdChiTieuDG25.setFiHamLuong(ananytical.getFiRequired());
                tbdChiTieuDG25.setFiMaDVT(ananytical.getFiRequireUnitID());
                tbdChiTieuDG25.setFiTenDVT(ananytical.getFiRequireUnitName());
                tbdChiTieuDG25.setFiGhiChu(ananytical.getFiNote());
                tbdChiTieuDG25.setFiNSWFileCode(xnd.getFiNSWFileCode());
                tbdChiTieuDG25Service.save(tbdChiTieuDG25);
            }
        }
        tbdXacNhanDon25Service.save(tbdXacNhanDon25);
    }
}
