/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.constant;

import org.springframework.core.env.Environment;

/**
 *
 * @author Administrator
 */
public class MOH10Constant {

    static MOH10Constant instance;
    public static final String EnableSign = "nsw.moh.10.sign";
    
    public interface UploadAccount {
        public static final String USER = "moh.10.upload_user_account";
        public static final String KEY = "moh.10.upload_user_pass";
    }
    
    public static MOH10Constant getInstance() {
        synchronized (MOH10Constant.class) {
            return new MOH10Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH10Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH10Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "moh.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "moh.10.tbdhoso10.insert";
        public static final String HOSO_UPDATE = "moh.10.tbdhoso10.update";
        public static final String HOSO_STATUS = "moh.10.tbdhoso10.status";
        public static final String HOSO_SEARCH = "moh.10.tbdhoso10.search";
        public static final String HOSO_DELETE = "moh.10.tbdhoso10.delete";
        public static final String HOSO_OWNER = "moh.10.tbdhoso10.owner";
        public static final String HOSO_GET_BYID = "moh.10.tbdhoso10.getbyid";
        public static final String HOSO_GET_BYCODE = "moh.10.tbdhoso10.getbymahoso";
        
        public static final String HOSO_SEND = "moh.10.api.hoso.send";        
        public static final String HOSO_THONGBAO = "moh.10.api.vanban";

        //Lich su
        public static final String LICHSU_SEARCH = "moh.10.tbdlichsu10.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "moh.10.tbdkqxl10.data";

        //Danh muc
        public static final String DANHMUC_TINHTHANH = "moh.10.danhmuc.tinhthanh";
        public static final String DANHMUC_QUANHUYEN = "moh.10.danhmuc.quanhuyen";        
        public static final String DANHMUC_COSOSANXUAT = "moh.10.danhmuc.cososanxuat";
        public static final String DANHMUC_QUOCGIA = "moh.10.danhmuc.quocgia";
        public static final String DANHMUC_DONVINHAN = "moh.10.danhmuc.donvinhan";
        
        public static final String DANHMUC_DONDK_MDNK = "moh.10.danhmuc.dondk.mucdichnhapkhau";
        public static final String DANHMUC_DONDK_LOAITTBYT = "moh.10.danhmuc.dondk.loaittb";
        public static final String DANHMUC_DONDK_LOAI_HOSO_TTBYT = "moh.10.danhmuc.dondk.loaihosottb";
        
        public static final String DANHMUC_TTB_NHOM = "moh.10.danhmuc.ttb.nhomttb";
        public static final String DANHMUC_TTB_PHANNHOM = "moh.10.danhmuc.ttb.phannhom";
        public static final String DANHMUC_TTB_LOAI = "moh.10.danhmuc.ttb.loaittb";
        public static final String DANHMUC_TAILIEU = "moh.10.danhmuc.loaifile";
        public static final String DANHMUC_TAILIEU_TTB = "moh.10.danhmuc.file_loaittb";
        
        public static final String DANHMUC_TRANGTHAI = "moh.10.danhmuc.trangthai";
        
        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "moh.10.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "moh.10.api.hoso.upload";
    }

    public interface MSG_TYPE {

        public static final String TYPE_101 = "101";
        public static final String TYPE_11 = "11";
        public static final String TYPE_102 = "102";
        public static final String TYPE_13 = "13";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_17 = "17";
        public static final String TYPE_18 = "18";
    }

    public interface MSG_FUNC {

        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_04 = "04";
        public static final String FUNC_05 = "05";
        public static final String FUNC_06 = "06";
        public static final String FUNC_07 = "07";
        public static final String FUNC_08 = "08";
        public static final String FUNC_09 = "09";
        public static final String FUNC_10 = "10";
        public static final String FUNC_11 = "11";
        public static final String FUNC_12 = "12";
        public static final String FUNC_13 = "13";
        public static final String FUNC_14 = "14";
        public static final String FUNC_15 = "15";
        public static final String FUNC_16 = "16";
        public static final String FUNC_17 = "17";
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_XAC_NHAN_PHI = 1L;
        public static final String CHO_XAC_NHAN_PHI_STR = "Chờ xác nhận thanh toán";
        public static final Long DA_XAC_NHAN_PHI = 2L;
        public static final String DA_XAC_NHAN_PHI_STR = "Xác nhận thanh toán";
        public static final Long YC_BO_SUNG = 3L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu sửa đổi bổ sung hồ sơ";
        public static final Long DA_TIEP_NHAN = 4L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận hồ sơ";
        public static final Long DA_BO_SUNG_HOSO = 5L;
        public static final String DA_BO_SUNG_HOSO_STR = "Sửa đổi bổ sung theo yêu cầu"; 
        public static final Long TU_CHOI_HOSO = 6L;
        public static final String TU_CHOI_HOSO_STR = "Từ chối hồ sơ"; 
        public static final Long TU_CHOI_CAP_PHEP = 7L;
        public static final String TU_CHOI_CAP_PHEP_STR = "Hồ sơ từ chối cấp số đăng ký"; 
        public static final Long DUOC_CAP_GIAYPHEP = 8L;
        public static final String DUOC_CAP_GIAYPHEP_STR = "Hồ sơ đã cấp số đăng ký";
        public static final Long THU_HOI_GIAYPHEP = 9L;
        public static final String THU_HOI_GIAYPHEP_STR = "Thu hồi cấp số đăng ký";
    }

    public class Pages {

        public static final String HOME_PATTERN = "moh.%s.home";
        public static final String EDIT_PATTERN = "moh.%s.edit";
        public static final String VIEW_PATTERN = "moh.%s.view";

        public static final String EDIT_PATTERN_TYPE = "moh.%s.%s.edit";
        public static final String VIEW_PATTERN_TYPE = "moh.%s.%s.view";
    }

    public class Routes {

        public static final String ROOT = "/moh";
        public static final String ROOT_HOME = "/moh/07";
    }

    public class View {

        public static final String HOME = "/{code}/home";
        public static final String INDEX = "/{code}/index";
        public static final String EDIT = "/{code}/edit";
        public static final String VIEW = "/{code}/view";
        public static final String VIEW_TYPE = "/{code}/{type}/view";
        public static final String EDIT_TYPE = "/{code}/{type}/edit";
    }

    public class ViewType {

        public static final String HOME = "home";
        public static final String EDIT = "edit";
        public static final String VIEW = "view";
    }

    public class DANHMUC {

        public static final String DANHMUC_TINHTHANH = "DANHMUC_TINHTHANH";
        public static final String DANHMUC_QUANHUYEN = "DANHMUC_QUANHUYEN";        
        public static final String DANHMUC_COSOSANXUAT = "DANHMUC_COSOSANXUAT";
        public static final String DANHMUC_QUOCGIA = "DANHMUC_QUOCGIA";
        public static final String DANHMUC_DONVINHAN = "DANHMUC_DONVINHAN";
        public static final String DANHMUC_DONDK_MDNK = "DANHMUC_DONDK_MDNK";
        public static final String DANHMUC_DONDK_LOAITTBYT = "DANHMUC_DONDK_LOAITTBYT";
        public static final String DANHMUC_DONDK_LOAI_HOSO_TTBYT = "DANHMUC_DONDK_LOAI_HOSO_TTBYT";
        public static final String DANHMUC_TTB_NHOM = "DANHMUC_TTB_NHOM";
        public static final String DANHMUC_TTB_PHANNHOM = "DANHMUC_TTB_PHANNHOM";
        public static final String DANHMUC_TTB_LOAI = "DANHMUC_TTB_LOAI";
        public static final String DANHMUC_TAILIEU = "DANHMUC_TAILIEU";
        public static final String DANHMUC_TAILIEU_TTB = "DANHMUC_TAILIEU_TTB";
        public static final String DANHMUC_TRANGTHAI = "DANHMUC_TRANGTHAI";
        public static final String DANHMUC_CSBH = "DANHMUC_CSBH";

    }
}
