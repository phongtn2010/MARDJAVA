/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moit.constant;

import org.springframework.core.env.Environment;

public class MOIT01Constant {

    static MOIT01Constant instance;
    public static final String EnableSign = "nsw.moit.01.sign";

    public static MOIT01Constant getInstance() {
        synchronized (MOIT01Constant.class) {
            return new MOIT01Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOIT01Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOIT01Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "moit.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "moit.01.tbdhoso1.insert";
        public static final String HOSO_UPDATE = "moit.01.tbdhoso1.update";
        public static final String HOSO_STATUS = "moit.01.tbdhoso1.status";
        public static final String HOSO_SEARCH = "moit.01.tbdhoso1.search";
        public static final String HOSO_DELETE = "moit.01.tbdhoso1.delete";
        public static final String HOSO_OWNER = "moit.01.tbdhoso1.owner";
        public static final String HOSO_SEND = "moit.01.api.hoso.send";
        public static final String HOSO_GET_BYID = "moit.01.tbdhoso1.getbyid";
        public static final String HOSO_GET_BYCODE = "moit.01.tbdhoso1.getbymahoso";
        public static final String HOSO_THONGBAO = "moit.01.api.vanban";

        //Lich su
        public static final String LICHSU_SEARCH = "moit.01.tbdlichsu1.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "moit.01.tbdkqxl1.data";

        //Danh muc
        public static final String DANHMUC_HS = "moit.01.danhmuc.hs";
        public static final String DANHMUC_LOAIFILE = "moit.01.danhmuc.tailieu";
        public static final String DANHMUC_TRANGTHAI = "moit.01.danhmuc.trangthai";

        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "moit.01.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "moit.01.api.hoso.upload";
        
        public static final String DINHKEM_GET_BYID = "moit.01.tbdhoso1.dinhkem";

    }

    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_13 = "13";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_18 = "18";
    }

    public interface MSG_FUNC {

        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_04 = "04";
        public static final String FUNC_05 = "05";
        public static final String FUNC_06 = "06";
        public static final String FUNC_08 = "08";
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
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";
        public static final Long TU_CHOI_HOSO = 3L;
        public static final String TU_CHOI_HOSO_STR = "Từ chối hồ sơ";
        public static final Long YC_BO_SUNG = 4L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_RUT_HOSO = 5L;
        public static final String DA_RUT_HOSO_STR = "Đã rút hồ sơ";
        public static final Long DA_BO_SUNG_HOSO = 6L;
        public static final String DA_BO_SUNG_HOSO_STR = "Đã bổ sung hồ sơ"; 
        public static final Long YC_RUT_HOSO = 7L;
        public static final String YC_RUT_HOSO_STR = "Yêu cầu xin rút hồ sơ"; 
        public static final Long DONG_Y_YC_RUT = 8L;
        public static final String DONG_Y_YC_RUT_STR = "Đồng ý yêu cầu rút hồ sơ"; 
        public static final Long YC_SUA_HOSO = 9L;
        public static final String YC_SUA_HOSO_STR = "Yêu cầu sửa hồ sơ";
        public static final Long DONG_Y_YC_SUA = 10L;
        public static final String DONG_Y_YC_SUA_STR = "Đồng ý yêu cầu xin sửa";
        public static final Long TU_CHOI_YC_SUA = 11L;
        public static final String TU_CHOI_YC_SUA_STR = "Từ chối yêu cầu xin sửa";
        public static final Long DUOC_CAP_VANBAN = 12L;
        public static final String DUOC_CAP_VANBAN_STR = "Được cấp văn bản chấp thuận";
        public static final Long DIEU_CHINH_VANBAN = 13L;
        public static final String DIEU_CHINH_VANBAN_STR = "Điều chỉnh văn bản chấp thuận";
        public static final Long DA_THU_HOI = 14L;
        public static final String DA_THU_HOI_STR = "Đã thu hồi";
        public static final Long TU_CHOI_YC_RUT = 15L;
        public static final String TU_CHOI_YC_RUT_STR = "Từ chối yêu cầu rút hồ sơ";
    }

    public class Pages {

        public static final String HOME = "moit.01.home";
        public static final String EDIT = "moit.01.edit";
        public static final String VIEW = "moit.01.view";
    }

    public class Routes {

        public static final String ROOT_HOME = "/moit/01";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
    }

    public class DANHMUC {

        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";
        public static final String DM_MAHS = "DM_MAHS";
        public static final String DM_LOAIFILE = "DM_LOAIFILE";
    }
}
