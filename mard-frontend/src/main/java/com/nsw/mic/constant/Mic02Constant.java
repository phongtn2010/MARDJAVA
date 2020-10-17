/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.constant;

import org.springframework.core.env.Environment;

/**
 *
 * @author TamDT
 */
public class Mic02Constant {

    public static final String DM_CQXL = "DM_CQXL";
    public static final String DM_TRANGTHAI = "DM_TRANGTHAI";

    public class Routes {

        public static final String ROOT_HOME = "/mic/02";
    }

    public static Mic02Constant getInstance() {
        synchronized (Mic02Constant.class) {
            return new Mic02Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Mic02Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public class Pages {

        public static final String HOME = "mic.02.home";
        public static final String EDIT = "mic.02.edit";
        public static final String VIEW = "mic.02.view";
        public static final String VIEW_GP = "mic.02.view.gp";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
        public static final String VIEW_GP = "/view_gp";
    }

    public class DANHMUC {

        public static final String DM_NOICAPGP = "DM_NOICAPGP";
        public static final String DM_MUCDICH = "DM_MUCDICH";
        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";
        public static final String DM_CHATLUONG = "DM_CHATLUONG";
        public static final String DM_DVTKHUANKHO = "DM_DVTKHUANKHO";
        public static final String DM_TEVTV = "DM_TEVTV";
        public static final String DM_KIEUIN = "DM_KIEUIN";
        public static final String DM_DVTTOCDO = "DM_DVTTOCDO";
        public static final String DM_TEPTIN = "DM_TEPTIN";
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mic.api.backend";

        public static final String DANHMUC_TRANGTHAI = "mic.02.danhmuc.status";

        public static final String HOSO_SEARCH = "mic.02.tbdhoso.search";
        //DANH MUC
        public static final String DANHMUC_NOICAPGP = "mic.02.danhmuc.noicap";
        public static final String DANHMUC_MUCDICH = "mic.02.danhmuc.mucdich";
        public static final String DANHMUC_CHATLUONG = "mic.02.danhmuc.chatluong";
        public static final String DANHMUC_DVTKHUANKHO = "mic.02.danhmuc.khuankho";
        public static final String DANHMUC_TENTV = "mic.02.danhmuc.tentv";
        public static final String DANHMUC_KIEUIN = "mic.02.danhmuc.kieuin";
        public static final String DANHMUC_DVTOCDO = "mic.02.danhmuc.tocdoin";
        public static final String DANHMUC_TEPTIN = "mic.02.danhmuc.teptin";
        // api hoso
        public static final String HOSO_DELETE = "mic.02.tbdhoso.delete";
        public static final String HOSO_INSERT = "mic.02.tbdhoso.create";
        public static final String HOSO_UPDATE = "mic.02.tbdhoso.update";
        public static final String HOSO_GET_BYID = "mic.02.tbdhoso.getbyidhoso";
        public static final String HOSO_SEND = "mic.02.hoso.send";
        public static final String LICHSU_SEARCH = "mic.02.tbdlichsu.search";
        public static final String HOSO_THONGBAO = "mic.02.tbdgiayphep.getbymahoso";
        public static final String GET_GP_BYID = "mic.02.tbdgiayphep.getbymahoso";
//Ket qua xu ly
        public static final String KQXL_SEARCH = "mic.02.tbdkqxl.getbyMaHoso";
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long YC_BOSUNG_THANHPHAN_HS = 2L;
        public static final String YC_BOSUNG_THANHPHAN_HS_STR = "Yêu cầu bổ sung thành phần hồ sơ";
        public static final Long DA_BOSUNG_THANHPHAN_HS = 3L;
        public static final String DA_BOSUNG_THANHPHAN_HS_STR = "Đã bổ sung thành phần hồ sơ";
        public static final Long DA_TIEP_NHAN = 4L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";
        public static final Long YC_BOSUNG_HS = 5L;
        public static final String YC_BOSUNG_HS_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_BOSUNG_HOSO = 6L;
        public static final String DA_BOSUNG_HOSO_STR = "Đã bổ sung hồ sơ";
        public static final Long DA_RUT_HS = 7L;
        public static final String DA_RUT_HS_STR = "Rút hồ sơ";
        public static final Long TC_CAP_GP = 8L;
        public static final String TC_CAP_GP_STR = "Từ chối cấp giấy phép";
        public static final Long YC_XINRUT_HS = 9L;
        public static final String YC_XINRUT_HS_STR = "Yêu cầu xin rút hồ sơ";
        public static final Long DONG_Y_XINRUT_HS = 10L;
        public static final String DONG_Y_XINRUT_HS_STR = "Đồng ý xin rút hồ sơ";
        public static final Long CAP_GP = 11L;
        public static final String CAP_GP_STR = "Cấp giấy phép";
        public static final Long XIN_SUA_GP = 12L;
        public static final String XIN_SUA_GP_STR = "Xin sửa giấy phép";

        public static final Long TC_SUA_GP = 14L;
        public static final String TC_SUA_GP_STR = "Từ chối sửa giấy phép";
        public static final Long THU_HOI_GIAY_PHEP = 15L;
        public static final String THU_HOI_GIAY_PHEP_STR = "Thu hồi giấp phép";
        public static final Long TU_CHOI_YC_RUT = 16L;
        public static final String TU_CHOI_YC_RUT_STR = "Từ chối yêu cầu rút";
        public static final Long TU_CHOI_TIEPNHAN_HS = 17L;
        public static final String TU_CHOI_TIEPNHAN_HS_STR = "Từ chối tiếp nhận hồ sơ";
        public static final Long DA_SUA_GP = 19L;
        public static final String DA_SUA_GP_STR = "Giấy phép đã sửa đổi";
        public static final Long TU_CHOI_SUA_GP = 20L;
        public static final String TU_CHOI_SUA_GP_STR = "Từ chối sửa giấy phép";
    }

    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_18 = "18";
        public static final String TYPE_19 = "19";
        public static final String TYPE_20 = "20";
        public static final String TYPE_21 = "21";
        public static final String TYPE_22 = "22";
        public static final String TYPE_23 = "23";
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
        public static final String FUNCTION_10 = "10";
        public static final String FUNCTION_11 = "11";
        public static final String FUNCTION_12 = "12";
        public static final String FUNCTION_13 = "13";
        public static final String FUNCTION_14 = "14";
        public static final String FUNCTION_15 = "15";
        public static final String FUNCTION_16 = "16";
        public static final String FUNCTION_18 = "18";
        public static final String FUNCTION_19 = "19";
        public static final String FUNCTION_20 = "20";
        public static final String FUNCTION_21 = "21";
        public static final String FUNCTION_22 = "22";
        public static final String FUNCTION_23 = "23";
        public static final String FUNCTION_24 = "24";
        public static final String FUNCTION_25 = "25";
    }
}
