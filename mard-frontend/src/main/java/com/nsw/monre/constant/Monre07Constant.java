/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.monre.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 *
 * @author AnPhucNguyen
 */
public class Monre07Constant {

    static Monre07Constant instance;

    public static Monre07Constant getInstance() {
        synchronized (Monre07Constant.class) {
            return new Monre07Constant();
        }
    }
    @Autowired
    Environment environment;

    public static final Long UNIT_SYSTEMID = 10l;
    
    public interface FileServices {
        public static final String USER = "admin";
        //public static final String PASSWORD = "94373d59-f925-4e33-b6e2-ae6207dbbab2";
        public static final String MINISTRY = "monre";
        public static final String PROCEDURE = "07";
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "monre.api.backend";
        
        //Ho so
        public static final String HOSO_INSERT = "monre.07.tbdhoso07.insert";
        public static final String HOSO_UPDATE = "monre.07.tbdhoso07.update";
        public static final String HOSO_STATUS = "monre.07.tbdhoso07.status";
        public static final String HOSO_SEARCH = "monre.07.tbdhoso07.search";
        public static final String HOSO_DELETE = "monre.07.tbdhoso07.delete";
        public static final String HOSO_OWNER = "monre.07.tbdhoso07.owner";
        public static final String HOSO_SEND = "monre.07.api.hoso.send";
        public static final String HOSO_GET_BYID = "monre.07.tbdhoso07.getbyid";
        public static final String HOSO_GET_BYCODE = "monre.07.tbdhoso07.getbymahoso";
        
        //Lich su
        public static final String LICHSU_SEARCH = "monre.07.tbdlichsu7.search";
        
        //Ket qua xu ly
        public static final String KQXL_SEARCH = "monre.07.tbdkqxl07.data";
        public static final String KQRUT_SEARCH = "monre.07.tbdycrut7.search";
        
        //Danh muc
        public static final String DANHMUC_CUAKHAU = "monre.07.danhmuc.cuakhau";
        public static final String DANHMUC_DVXL = "monre.07.danhmuc.dvxl";
        public static final String DANHMUC_TINH = "monre.07.danhmuc.tinhthanh";
        public static final String DANHMUC_HUYEN = "monre.07.danhmuc.quanhuyen";
        public static final String DANHMUC_XA = "monre.07.danhmuc.xaphuong";
        
        public static final String CSSX_SEARCH = "monre.07.cososx.search";
        public static final String CSSX_SAVE = "monre.07.cososx.insert";
        public static final String CSSX_DELETE = "monre.07.cososx.delete";
        
        //Thong tin giay xac nhan thu tuc 01
        public static final String HOSO_GXN1 = "monre.07.gxn01.get";
        public static final String HOSO_THONGBAO = "monre.07.api.hoso.thongbao";
        public static final String DOWNLOAD = "monre.07.api.hoso.thongbao.download";
                
    }

    public interface UNIT_TYPE {

        public static final Long SOLUONG = 4l;
        public static final Long TRONGLUONG = 4l;
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Monre07Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
    
    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Monre07Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }
    
    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_12 = "12";
        public static final String TYPE_15 = "15";
        public static final String TYPE_18 = "18";
        public static final String TYPE_19 = "19";
    }

    public interface MSG_FUNC {
        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_04 = "04";
        public static final String FUNC_09 = "09";
        public static final String FUNC_10 = "10";
        public static final String FUNC_11 = "11";
        public static final String FUNC_15 = "15";
        public static final String FUNC_16 = "16";
    }
    
    public interface FILE_STATUS {
    	public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận hồ sơ";
        public static final Long DANG_XU_LY = 2L;
        public static final String DANG_XU_LY_STR = "Đang xử lý";
        public static final Long YC_BO_SUNG = 3L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_RUT_HOSO = 4L;
        public static final String DA_RUT_HOSO_STR = "Đã rút hồ sơ";
        public static final Long DA_BO_SUNG_HOSO = 5L;
        public static final String DA_BO_SUNG_HOSO_STR = "Đã bổ sung hồ sơ"; 
        public static final Long YC_RUT_HOSO = 6L;
        public static final String YC_RUT_HOSO_STR = "Yêu cầu xin rút hồ sơ"; 
        public static final Long DONG_Y_YC_RUT = 7L;
        public static final String DONG_Y_YC_RUT_STR = "Đồng ý yêu cầu rút hồ sơ"; 
        public static final Long TU_CHOI_CAP_TBNK = 8L;
        public static final String TU_CHOI_CAP_TBNK_STR = "Từ chối cấp thông báo nhập khẩu"; 
        public static final Long DUOC_CAP_TBNK = 9L;
        public static final String DUOC_CAP_TBNK_STR = "Thông báo lô hàng phế liệu nhập khẩu";
        public static final Long DA_CAP_LAI_TBNK = 10L;
        public static final String DA_CAP_LAI_TBNK_STR = "Thông báo điều chỉnh Thông báo lô hàng phế liệu nhập khẩu";
        public static final Long DA_THU_HOI = 11L;
        public static final String DA_THU_HOI_STR = "Thông báo thu hồi lô hàng phế liệu nhập khẩu";
        public static final Long TU_CHOI_YC_RUT = 12L;
        public static final String TU_CHOI_YC_RUT_STR = "Từ chối yêu cầu rút hồ sơ";
    }

    public interface Page {
        public static final String HOME = "monre.07.home";
        public static final String CREATE = "monre.07.create";
        public static final String VIEW = "monre.07.view";
    }
}
