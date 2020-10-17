/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.constant;

public class ThuTuc06Constant {

     public static final String ISSIGN = "nsw.moh.06.sign";
    
    public interface API {

        public static final String BACKEND = "moh.api.backend";
        public static final String HOSO_SEARCH = "moh.06.api.search";
        public static final String DELETE = "moh.06.api.delete";
        public static final String HOSO = "moh.06.api.hoso";

        public static final String TINHTHANHPHO = "moh.06.api.danhmuc.province";
        public static final String QUANHUYEN = "moh.06.api.danhmuc.district";
        public static final String UPLOAD_DIALOG = "moh.06.api.upload";
        public static final String FILEDELETE = "moh.06.api.delete_file";
        public static final String COUNTRIES = "moh.06.api.danhmuc.country";
        public static final String DVNHANHOSO = "moh.06.api.danhmuc.donvinhanhoso";
        public static final String LICHSU = "moh.06.api.lichsu.getlichsu";
        public static final String BAOHANH = "moh.06.api.baohanh.getBaoHanhbyMst";
        
        public static final String DVNHANHS = "moh.06.api.dvnhanhs";

        
        public static final String HOSO_SEND = "moh.06.api.send";
        public static final String HOSO_XML_SEND = "moh.06.api.sendxml";        
    }

    public interface DATA_LABLE {
        public static final String UPLOAD_DIALOG = "uploadDialog";
        public static final String DELETELINK = "deleteFile";
        public static final String COUNTRIES = "countries";
        public static final String TINHTHANH = "tinh";
        public static final String QUANHUYEN = "QUANHUYEN";
        public static final String DONVINHANHOSO = "donviList";
        public static final String NGUOITIEPNHAN = "nguoitiepnhan";
        public static final String LOAIPHI = "loaiphi";
        
        //Others
        public static final String HoSo = "hoso";
        public static final String HoSoJSON = "hosoJson";
        //file server bo y te
        public static final String USER = "user";
        public static final String BYT_KEY="password";
    }

    public interface Page {

        public static final String HOME = "moh.06.home";
        public static final String CREATE = "moh.06.create";
        public static final String PHIEUTIEPNHAN = "moh.06.tiepnhan";
        public static final String QLD_HOME = "moh.00.home";
    }

    public interface Status {
        public static final Long TAO_MOI = 0L;
        public static final Long CHO_XAC_NHAN_NOP_PHI = 1L;
        public static final Long YEU_CAU_NOP_LAI_PHI = 2L;
        public static final Long DANG_XU_LY = 3L;
        public static final Long DA_TRA_KET_QUA = 4L;
        public static final Long THU_HOI_NOI_DUNG_CONG_BO = 5L;
        public static final String TAOMOISTRING = "moh.06.hoso.trangthai.taomoi";
        public static final String CHOXACNHANNOPPHI = "moh.06.hoso.trangthai.choxacnhan";
        public static final String YEUCAUNOPLAIPHI = "moh.06.hoso.trangthai.yeucaunoplaiphi";
        public static final String DANGXULY = "moh.06.hoso.trangthai.dangxuly";
        public static final String DATRAKETQUA = "moh.06.hoso.trangthai.datraketqua";
        public static final String THUHOI = "moh.06.hoso.trangthai.thuhoi";
        
    }

    public interface DefaultValue {

        public static final String VALUE_0S = "0";
        public static final String VALUE_1S = "-1";
        public static final Long VALUE_0L = 0L;
    }

    public interface UploadAccount {

        public static final String USER = "upload_user_account";
        public static final String KEY = "upload_user_pass";
    }
    
    public interface BANTIN {
        public static String BANTINGUI = "101";
    }
    
    public interface RES_FUNTION{
        public static String TIEPNHAN = "01";
    }
}
