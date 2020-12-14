/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.constant;

import org.springframework.core.env.Environment;

/**
 *
 * @author HuongMK
 */
public class Moh02Constant {

    static Moh02Constant instance;
    public static final String EnableSign = "nsw.moh.02.sign";

    public static final String DM_CQXL = "DM_CQXL";
    public static final String DM_TRANGTHAI = "DM_TRANGTHAI";

    public class Routes {

        public static final String ROOT_HOME = "/moh/02";
    }

    public static Moh02Constant getInstance() {
        synchronized (Moh02Constant.class) {
            return new Moh02Constant();
        }
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(API.BACKEND) + environment.getRequiredProperty(key);
    }

    public class Pages {

        public static final String HOME = "moh.02.home";
        public static final String EDIT = "moh.02.edit";
        public static final String VIEW = "moh.02.view";
        public static final String VIEW_GP = "moh.02.view.gp";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
        public static final String VIEW_GP = "/view_gp";
    }

    public class DANHMUC {

        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";
        public static final String DM_TINHTHANH = "DM_TINHTHANH";
        public static final String DM_QUOCGIA = "DM_QUOCGIA";
        public static final String DM_TEPTIN = "DM_TEPTIN";
        public static final String DM_DONVI_TINH = "DM_DONVI_TINH";
        public static final String DM_HINHTHUC = "DM_HINHTHUC";
        public static final String DM_VANCHUYEN = "DM_VANCHUYEN";
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "moh.api.backend";
        public static final String BACKEND_UPLOADFILE = "moh.api.uploadFile";

        public static final String DANHMUC_TRANGTHAI = "moh.02.danhmuc.status";
        public static final String DANHMUC_TINHTHANH = "moh.02.danhmuc.tinhthanh";
        public static final String DANHMUC_QUOCGIA = "moh.02.danhmuc.quocgia";
        public static final String DANHMUC_TEPTIN = "moh.02.danhmuc.teptin";
        public static final String DANHMUC_DONVI_TINH = "moh.02.danhmuc.dvtinh";
        public static final String DANHMUC_HINHTHUC = "moh.02.danhmuc.hinhthuc";
        public static final String DANHMUC_VANCHUYEN = "moh.02.danhmuc.vanchuyen";

        public static final String HOSO_GET_BYID = "moh.02.hoso.getbyidhoso";
        public static final String HOSO_UPDATE = "moh.02.hoso.update";
        public static final String HOSO_SEARCH = "moh.02.hoso.timkiem";
        public static final String HOSO_INSERT = "moh.02.hoso.taomoi";
        public static final String HOSO_SEND = "moh.02.hoso.send";
        public static final String LICHSU_SEARCH = "moh.02.tbdlichsu.search";
        public static final String HOSO_DELETE = "moh.02.hoso.xoa";
        public static final String HOSO_GET_GIAYPHEP = "moh.02.hoso.getDataGp";
        public static final String HOSO_OWNER = "moh.02.hoso.owner";

        public static final String ATTACHMENT_UPLOAD = "moh.02.hoso.uploadFile";
        public static final String UPLOAD = "moh.api.upload";

        public static final String DINHKEM_GET_BYCODE = "moh.02.dinhkem.download";
        public static final String ATTACHMENT_DOWNLOAD = "moh.02.giayphep.linkdownload";

        public static final String KQXL_SEARCH = "moh.02.kqxl.data";

    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long YC_BOSUNG = 2L;
        public static final String YC_BOSUNG_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_BOSUNG = 3L;
        public static final String DA_BOSUNG_STR = "Đã bổ sung hồ sơ";
        public static final Long RUT_HS = 4L;
        public static final String RUT_HS_STR = "Rút hồ sơ";
        public static final Long DA_TIEP_NHAN = 5L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";
        public static final Long TC_CAP_GP = 6L;
        public static final String TC_CAP_GP_STR = "Từ chối cấp giấy phép";
        public static final Long CAP_GP = 7L;
        public static final String CAP_GP_STR = "Cấp giấy phép";
        public static final Long TU_CHOI_HS = 8L;
        public static final String TU_CHOI_HS_STR = "Từ chối hồ sơ";
    }

    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_13 = "13";
    }

    public interface MSG_FUNC {

        public static final String FUNCTION_01 = "01";
        public static final String FUNCTION_02 = "02";
        public static final String FUNCTION_03 = "03";
        public static final String FUNCTION_04 = "04";
        public static final String FUNCTION_05 = "05";
        public static final String FUNCTION_06 = "06";
        public static final String FUNCTION_07 = "07";
        public static final String FUNCTION_08 = "08";
        public static final String FUNCTION_09 = "09";
    }

    public interface TOKEN {

        public static final String URL_API = "http://demo.blameo.com:2468/filedata/FileAttachments/GetToken";
//        public static final String URL_API = "https://vietesoft.com";
        public static final String URL_URI = "/api/ApiAccount/Login";
        public static final String CLIENT_ID = "NSW";
        public static final String CLIENT_KEY = "676e8b1b13e894b7bc65c085d120fc25";
        public static final String PARAM_ID = "clientId";
        public static final String PARAM_KEY = "clientKey";
    }

}
