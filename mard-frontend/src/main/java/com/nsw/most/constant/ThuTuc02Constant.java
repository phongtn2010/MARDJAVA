/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.constant;

/**
 *
 * @author Nhan
 */
public class ThuTuc02Constant {
    public static final String EnableSign = "nsw.most.02.sign";
    public interface GOV {
        public static final String BKHCN_EN = "most"; 
        public static final String BKHCN_VN = "bkhcn"; 
        public static final String P02 = "02";
    }
    
    public interface ControllerURI {
        public static final String ROOT = "/most/02";
        public static final String HOME = "/home";   
        public static final String HOSO = "/hoso";
        public static final String EDIT_DETAIL = "/edit/{id}";
        public static final String VIEW = "/view/{id}";
    } 
    
    public interface EXCEL_SHEET_CODE {
        public static final String HH = "HH"; //Hang hoa
        public static final String TK = "TK"; //To khai
        public static final String HS = "HS"; //Ho so
    }
    
    public interface PAGE{
        public static final String HOME = "most.02.home";
        public static final String HOSO = "most.02.hoso";
        public static final String VIEW="most.02.view";
    }
    
    public interface API{
        //API
        public static final String HOSO_SEARCH = "most.02.api.search";
        public static final String HOSO = "most.02.api.hoso";
        public static final String GETHOSO = "most.02.api.gethoso";
        public static final String HOSO_HISTORY_SEARCH = "most.02.api.history.search";
        public static final String HOSO_HISTORY_BY_IDHOSO = "most.02.api.history.getbyidhoso";
        public static final String HOSO_HISTORY_BY_IDHOSO_TRANGTHAI = "most.02.api.history.getbyidhosoandtrangthai";

        public static final String HOSO_KQKT = "most.02.api.kqkt";
        public static final String GET_TBKT = "most.02.api.tbkt";
        
        public static final String HOSO_REQUEST_SEND = "most.02.api.send";        
        public static final String HOSO_REQUEST_DELAY = "most.02.api.delay";        
        public static final String HOSO_REQUEST_CANCEL = "most.02.api.cancel";
        public static final String HOSO_REQUEST_EDIT = "most.02.api.edit";
        
        public static final String EXCEL = "most.02.api.excel";
        public static final String DOC_HOSO = "most.02.api.doc.hoso";
        public static final String DOWNLOAD = "most.02.api.doc.kqkt";
        public static final String COUNTRY = "most.01.api.danhmuc.quocgia";
        public static final String DƠNLOADFILE = "most.02.api.download";
        public static final String TENPHUONGTIEN = "most.02.api.mauphuongtiendo";
        //Backend and Service
        public static final String BACKEND = "most.02.backend"; // MOSTbackend 
        public static final String COQUANXULY = "most.02.api.cqxl";
        public static final String CUAKHAU = "most.02.api.cuakhau";
        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String GET_STATE = "/dic/state/vn";
    }
    
    public interface DATA_LABLE{
        public static final String COUNTRY = "quocgia";
        public static final String HOSODATA="hosoData";
        public static final String HOSOJSON="hosoJson";
        public static final String COQUANXULY="cqxl";
        public static final String HAS_REASON="hasReason";
        public static final String CUAKHAU="cuakhau";
        public static final String DanhSachDVHaiQuan = "danhsachdonvihq";
        public static final String TENPHUONGTIEN = "mauptLst";
    }
    
    public interface STATUS{
        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "most.02.trangthai.taomoi";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "most.02.trangthai.chotiepnhan";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "most.02.trangthai.datiepnhan";
//        public static final Long XIN_LUI_HAN=3L;
//         public static final String XIN_LUI_HAN_STR = "most.02.trangthai.xinluihan";
        public static final Long DA_RUT = 3L;
        public static final String DA_RUT_STR = "most.02.trangthai.daruthoso";
        public static final Long YC_BO_SUNG = 4L;
        public static final String YC_BO_SUNG_STR = "most.02.trangthai.yeucauboxung";
//        public static final Long THONGBAO_KIEMTRA = 5L;
        public static final Long DA_BO_SUNG = 5L;
        public static final String DA_BO_SUNG_STR = "Đã bổ sung theo yêu cầu";
        public static final Long THONGBAO_KIEMTRA = 6L;
        public static final String THONGBAO_KIEMTRA_STR = "most.02.trangthai.thongbaokiemtra";

    
        public static final Long DACO_KQ_KIEMTRA = 7L;
        public static final String DACO_KQ_KIEMTRA_STR = "most.02.trangthai.dacokqkiemtra";
        public static final Long DA_SUA_HOSO = 8L;
        public static final String DA_SUA_HOSO_STR = "most.02.trangthai.dasuahoso";
//        public static final Long THONGBAO_KQ_KIEMTRA = 6L;
//        public static final String THONGBAO_KQ_KIEMTRA_STR = "most.02.trangthai.thongbaoketqua";
    }
    
    public interface ACTION{
        public static final String DELETE="delete";
        public static final String CREATE="create";
        public static final String UPDATE="update";
        public static final String DELAY="delay";
        public static final String SEND="send";
        public static final String CANCEL="cancel";        
        
    }
    
    public interface DefaultValue {
        public static final String VALUE_0S = "0";
        public static final String VALUE_1S = "-1";
        public static final Long VALUE_0L = 0L;
        public static final Long VALUE_1L = 1L;
    }
    
    public interface ErrorMessage {
        public static final String ACCESS_DENIED = "Access Denied";
        public static final String ExpireProcessDate = "common_msg_expire";
    }
    
    public interface MessageType {
        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_13 = "13";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_17 = "17";
        public static final String TYPE_18 = "18";
        public static final String TYPE_21 = "21";
    } 
    
    public interface MessageFunction {
        public static final String FUN_01 = "01";
        public static final String FUN_02 = "02";
        public static final String FUN_04 = "04";
        public static final String FUN_05 = "05";
        public static final String FUN_09 = "09";
        public static final String FUN_12 = "12";
        public static final String FUN_03 = "03";
        public static final String FUN_15 = "15";
        public static final String FUN_16 = "16";
        public static final String FUN_18 = "18";
        public static final String FUN_99 = "99";
    }
    
    public interface KHCN02_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_13 = "13";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_17 = "17";
        public static final String TYPE_18 = "18";

    }
    
    public interface KHCN02_FUNCTION {

        public static final String FUNCTION_01 = "01";
        public static final String FUNCTION_02 = "02";
        public static final String FUNCTION_03 = "03";
        public static final String FUNCTION_04 = "04";
        public static final String FUNCTION_05 = "05";
        public static final String FUNCTION_06 = "06";
        public static final String FUNCTION_07 = "07";
        public static final String FUNCTION_08 = "08";
        public static final String FUNCTION_09 = "09";
        public static final String FUNCTION_12 = "12";
        public static final String FUNCTION_15 = "15";
        public static final String FUNCTION_16 = "16";
        public static final String FUNCTION_99 = "99";
    }
}
