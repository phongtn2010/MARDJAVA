/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.constant;

/**
 *
 * @author PhongNguyen
 */
public class ThuTuc01Constant {
    public static final String EnableSign = "nsw.most.01.sign";
    public interface GOV {
        public static final String BKHCN_EN = "most"; 
        public static final String BKHCN_VN = "bkhcn"; 
        public static final String P01 = "01";
    }
    
    public interface EXCEL_SHEET_CODE {
        public static final String HH = "HH"; //Hang hoa
        public static final String TK = "TK"; //To khai
        public static final String HS = "HS"; //Ho so
    }
    
    public interface Status {
        public static final Long MOI_TAO = 0l;
        public static final Long CHO_TIEP_NHAN = 1l;
        public static final Long DA_TIEP_NHAN = 2L;
        public static final Long TU_CHOI_TIEP_NHAN = 3L;
        public static final Long DA_RUT_HOSO = 4L;
        public static final Long BKHCN_YEU_CAU_BS_HOSO = 5L;
        public static final Long DN_BO_SUNG_THEO_YEU_CAU = 6L;
        public static final Long XIN_RUT_HOSO = 7L;
        public static final Long BKHCN_DONG_Y_RUT_HOSO = 8L;
        public static final Long DN_GUI_YEU_CAU_XIN_SUA_HOSO = 9L;
        public static final Long BKHCN_DONG_Y_YEU_CAU_XIN_SUA_HOSO = 10L;
        public static final Long DN_GUI_YEU_CAU_XIN_LUI_HAN_HOSO = 11L;
        public static final Long BKHCN_DONG_Y_XIN_LUI_HAN_HOSO = 12L;
        public static final Long DN_DA_CO_KET_QUA_KIEM_TRA_HOSO = 13L;
        public static final Long DA_THU_HOI_THONG_BAO_KET_QUA_KIEM_TRA = 14L;
    }
    
    public interface DanhMuc {
        public static final String ToChucKiemTra = "tckts"; 
        public static final String ToChucChungNhan = "tcdgs";
        public static final String NhomHangHoa = "nhh";
        public static final String HangHoaMienKiem = "mienkiem";
        public static final String LoaiDinhKem = "loaidinhkem";
        public static final String LoaiGiayChungNhan = "giaychungnhan";
        public static final String DanhSachDVHaiQuan = "danhsachdonvihq";
        
        //Others
        public static final String HoSo = "hoso";
        public static final String HoSoJSON = "hosoJson";
    }
    
    public interface API {
        //Danh muc
        public static final String DANHMUC_TCKT = "most.01.api.danhmuc.tckt";
        public static final String DANHMUC_TCDG = "most.01.api.danhmuc.tcdg";
        public static final String DANHMUC_QCVN = "most.01.api.danhmuc.qcvn";
        public static final String DANHMUC_DVT = "most.01.api.danhmuc.donvitinh";
        public static final String DANHMUC_NHH = "most.01.api.danhmuc.nhomhanghoa";
        public static final String DANHMUC_QG = "most.01.api.danhmuc.quocgia";
        public static final String DANHMUC_MIENKIEM = "most.01.api.danhmuc.mienkiem";
        public static final String DANHMUC_LOAIDINHKEM = "most.01.api.danhmuc.loaidinhkem";
        public static final String DANHMUC_GCN = "most.01.api.danhmuc.giaychungnhan";
        //Backend and Service
        public static final String BACKEND = "most.01.backend";
        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String SERVICE = "most.01.service";
        //FileUpload
        public static final String FILEINFO = "most.01.api.fileinfo";
        public static final String UPLOAD = "most.01.api.upload";
        public static final String DOWNLOAD = "most.01.api.download";
        
        
        //API
        public static final String HOSO = "most.01.api.hoso";
        public static final String HOSO_ID = "most.01.api.hoso.id";
        public static final String HOSO_SEARCH = "most.01.api.search";
        public static final String HOSO_HISTORY = "most.01.api.history";
        public static final String HOSO_SEND = "most.01.api.send";
        public static final String HOSO_SENDXML = "most.01.api.sendxml";
        public static final String HOSO_REQUEST_DELAY = "most.01.api.delay";        
        public static final String HOSO_REQUEST_CANCEL = "most.01.api.cancel";
        public static final String HOSO_REQUEST_DEDIT = "most.01.api.edit";
        public static final String HOSO_GCN = "most.01.api.gcn";
        public static final String HOSO_TOP_HISTORY = "most.01.api.history.gettop";
        public static final String HOSO_HISTORY_BY_CQXL_TRANGTHAI = "most.01.api.history.getbycqxlandtrangthai";
        public static final String HOSO_KQKT = "most.01.api.kqkt";
        public static final String HOSO_CQXL_GETALL = "most.01.api.cqxl.getall";
        
        //Excel
        public static final String EXCEL = "most.01.api.excel";
    } 
    
    public interface Page {
        public static final String HOME = "most.01.home";
        public static final String EDIT = "most.01.edit";
    }
    
    public interface ControllerURI {
        public static final String ROOT = "/most/01";
        public static final String HOME = "/home";   
        public static final String EDIT = "/edit";
        public static final String EDIT_DETAIL = "/edit/{id}";
        public static final String COPY = "/copy/{id}";
        public static final String VIEW = "/view/{id}";
    } 
    
    public interface ErrorMessage {
        public static final String ACCESS_DENIED = "Access Denied";
        public static final String ExpireProcessDate = "common_msg_expire";
        public static final String NOT_SAVE_DOCUMENT = "Hồ sơ không được phép sửa thông tin Tổ chức chứng nhận";
        public static final String NOT_FOUND_CQXL = "Không tìm thấy dữ liệu cơ quan xử lý";
    } 
    
    public interface MessageType {
        public static final String TYPE_10 = "10";
        public static final String TYPE_13 = "13";
        public static final String TYPE_15 = "15";
        public static final String TYPE_17 = "17";
        public static final String TYPE_21 = "21";
    } 
    
    public interface MessageFunction {
        public static final String FUN_01 = "01";
        public static final String FUN_02 = "02";
        public static final String FUN_04 = "04";
        public static final String FUN_09 = "09";
        public static final String FUN_12 = "12";
        public static final String FUN_03 = "03";
        public static final String FUN_18 = "18";
    }
    
    public interface DefaultValue {
        public static final String VALUE_0S = "0";
        public static final String VALUE_1S = "-1";
        public static final Long VALUE_0L = 0L;
        public static final Long VALUE_1L = 1L;
    }
    
    public interface FileUpload {
        public static final int fileSizeThreshold = 20971520;
    }
}
