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
public class Monre08Constant {

    static Monre08Constant instance;

    public static Monre08Constant getInstance() {
        synchronized (Monre08Constant.class) {
            return new Monre08Constant();
        }
    }
    @Autowired
    Environment environment;

    public static final Long UNIT_SYSTEMID = 10l;
    
    public interface FileServices {
//        public static final String USER = "admin";
//        public static final String PASSWORD = "94373d59-f925-4e33-b6e2-ae6207dbbab2";
        public static final String MINISTRY = "monre";
        public static final String PROCEDURE = "08";
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "monre.api.backend";
        
        //Ho so
        public static final String HOSO_INSERT = "monre.08.tbdhoso08.insert";
        public static final String HOSO_UPDATE = "monre.08.tbdhoso08.update";
        public static final String HOSO_STATUS = "monre.08.tbdhoso08.status";
        public static final String HOSO_SEARCH = "monre.08.tbdhoso08.search";
        public static final String HOSO_DELETE = "monre.08.tbdhoso08.delete";
        public static final String HOSO_OWNER = "monre.08.tbdhoso08.owner";
        public static final String HOSO_SEND = "monre.08.api.hoso.send";
        public static final String HOSO_GET_BYID = "monre.08.tbdhoso08.getbyid";
        public static final String HOSO_GET_BYCODE = "monre.08.tbdhoso08.getbymahoso";
        
        //Lich su
        public static final String LICHSU_SEARCH = "monre.08.TbdlichsuXuly8.search";
        
        //danh sach dinh kem 
        public static final String DANHSACH_DINHKEM = "monre.08.danhmuc.danhsach.kinhkem";
        
        //Ket qua xu ly
        public static final String KQXL_SEARCH = "monre.08.Tbdkqxl8.data";
        public static final String KQRUT_SEARCH = "monre.08.Tbdycrut8.search";
        
        //Danh muc
        public static final String DANHMUC_CUAKHAU = "monre.08.danhmuc.cuakhau";
        public static final String DANHMUC_DVXL = "monre.08.danhmuc.dvxl";
        
        public static final String CSSX_SEARCH = "monre.08.cososx.search";
        public static final String CSSX_SAVE = "monre.08.cososx.insert";
        public static final String CSSX_DELETE = "monre.08.cososx.delete";
        
        //Thong tin giay xac nhan thu tuc 01
        public static final String HOSO_GXN1 = "monre.08.gxn01.get";
        public static final String HOSO_THONGBAO = "monre.08.api.hoso.thongbao";
        public static final String DOWNLOAD = "monre.08.api.hoso.thongbao.download";
                
    }

    public interface UNIT_TYPE {

        public static final Long SOLUONG = 4l;
        public static final Long TRONGLUONG = 4l;
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Monre08Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
    
    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Monre08Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
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
        public static final String HOME = "monre.08.home";
        public static final String CREATE = "monre.08.create";
        public static final String VIEW = "monre.08.view";
    }
}
