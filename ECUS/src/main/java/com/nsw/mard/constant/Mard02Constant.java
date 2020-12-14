/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.constant;

import org.springframework.core.env.Environment;

/**
 *
 * @author TamDT
 */
public class Mard02Constant {

    public static final String DM_CQXL = "DM_CQXL";
    public static final String DM_TRANGTHAI = "DM_TRANGTHAI";

    public class Routes {

        public static final String ROOT_HOME = "/mard/02";
    }

    public static Mard02Constant getInstance() {
        synchronized (Mard02Constant.class) {
            return new Mard02Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(API.BACKEND) + environment.getRequiredProperty(key);
    }

    public class Pages {

        public static final String HOME = "mard.02.home";
        public static final String EDIT = "mard.02.edit";
        public static final String VIEW = "mard.02.view";
        public static final String VIEW_GP = "mard.02.view.gp";
        public static final String CHARGE = "mard.02.charge";
        public static final String MAU_GIAY_DK = "mard.02.regis";
        public static final String MAU_GIAY_CNKD = "mard.02.PhytosanitaryResult";
        public static final String MAU_GIAY_TAMCAP = "mard.02.TemporaryPhytosanitary";
        public static final String MAU_GIAY_GIULAI = "mard.02.PhytosanitaryDetain";
        public static final String MAU_GIAY_XNCL = "mard.02.QuanlityResult";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String CHARGE = "/charge";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
        public static final String VIEW_GP = "/view_gp";
        public static final String MAU_GIAY_DK = "/registration";
        public static final String MAU_GIAY_CNKD = "/PhytosanitaryResult";
        public static final String MAU_GIAY_TAMCAP = "/TemporaryPhytosanitary";
        public static final String MAU_GIAY_GIULAI = "/PhytosanitaryDetain";
        public static final String MAU_GIAY_XNCL = "/QuanlityResult";

    }

    public class DANHMUC {

        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";
        public static final String DM_HINHTHUC_KT = "DM_HINHTHUC_KT";
        public static final String DM_LOAIDON = "DM_LOAIDON";
        public static final String DM_LOAI_SP = "DM_LOAI_SP";
        public static final String DM_TEPTIN = "DM_TEPTIN";
        public static final String DM_DVTINH = "DM_DVTINH";
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mard.api.backend";
        public static final String DANHMUC_TRANGTHAI = "mard.02.danhmuc.status";
        public static final String DANHMUC_HINHTHUC_KT = "mard.02.danhmuc.hinhthuckt";
        public static final String DANHMUC_LOAIDON = "mard.02.danhmuc.loaidon";
        public static final String DANHMUC_LOAI_SP = "mard.02.danhmuc.loaiSP";
        public static final String DANHMUC_TEPTIN = "mard.02.danhmuc.teptin";
        public static final String DANHMUC_DVTINH = "mard.02.danhmuc.dvtinh";
        public static final String HOSO_GET_BYID = "mard.02.hoso.getbyidhoso";
        public static final String HOSO_GET_CONGVAN = "mard.02.congvan.getData";
        public static final String EDIT_CONGVAN = "mard.02.congvan.editCongvan";

        public static final String HOSO_GET_THONGBAO_PHI = "mard.02.hoso.getThongBaophi";
        public static final String HOSO_UPDATE = "mard.02.hoso.update";
        public static final String HOSO_SEARCH = "mard.02.hoso.timkiem";
        public static final String HOSO_INSERT = "mard.02.hoso.taomoi";
        public static final String HOSO_SEND = "mard.02.hoso.send";
        public static final String LICHSU_SEARCH = "mard.02.tbdlichsu.search";
        public static final String CHITIEU_SEARCH = "mard.02.chitieu.search";

        public static final String CHITIEU_SEARCH_NEW = "mard.02.chitieu.search.new";

        public static final String HOSO_THANHTOAN_PHI = "mard.02.tbdthanhtoanphi.create";
        public static final String HOSO_XACNHAN_PHI = "mard.02.xacnhanphi.getdata";
        public static final String HOSO_GET_XNCL = "mard.02.hoso.getdataXNCL";
        public static final String HOSO_GIULAI_VA_XULY = "mard.02.hoso.getdataGLXL";
        public static final String HOSO_GIAY_TAMCAP = "mard.02.hoso.getdataGiayTamCap";
        public static final String HOSO_GIAY_CNKDTV = "mard.02.hoso.getdataGiayCNKDTV";
        public static final String HOSO_XACNHAN_DON = "mard.02.hoso.xacnhandon";
        public static final String HOSO_DELETE = "mard.02.hoso.xoa";
        public static final String HOSO_GET_XNTT = "mard.02.tbdthanhtoanphi.getData";
        public static final String HOSO_PRINT = "mard.02.hoso.print";

    }

    public interface FILE_STATUS {

       public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long YC_BOSUNG = 2L;
        public static final String YC_BOSUNG_STR = "Yêu cầu bổ sung";
        public static final Long DA_BOSUNG = 3L;
        public static final String DA_BOSUNG_STR = "Đã bổ sung hồ sơ";
        public static final Long TC_HOSO = 4L;
        public static final String TC_HOSO_STR = "Từ chối hồ sơ";
        public static final Long HUY_HOSO = 5L;
        public static final String HUY_HOSO_STR = "Hủy hồ sơ";
        public static final Long DA_TIEP_NHAN = 6L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";
        public static final Long XINSUA_HOSO = 7L;
        public static final String XINSUA_HOSO_STR = "Xin sửa hồ sơ";
        public static final Long DONGY_SUA_HOSO = 8L;
        public static final String DONGY_SUA_HOSO_STR = "Đồng ý xin sửa hồ sơ";
        public static final Long TC_SUA_HOSO = 9L;
        public static final String TC_SUA_HOSO_STR = "Từ chối xin sửa hồ sơ";
        public static final Long XIN_HUY_HOSO = 10L;
        public static final String XIN_HUY_HOSO_STR = "Xin rút hồ sơ";
        public static final Long DONGY_HUY_HOSO = 11L;
        public static final String DONGY_HUY_HOSO_STR = "Đồng ý xin rút hồ sơ";
        public static final Long TC_HUY_HOSO = 12L;
        public static final String TC_HUY_HOSO_STR = "Từ chối xin rút hồ sơ";
        public static final Long CONGVAN_KIEMDICH = 13L;
        public static final String CONGVAN_KIEMDICH_STR = "Công văn kiểm dịch";
        public static final Long XINSUA_CONGVAN = 14L;
        public static final String XINSUA_CONGVAN_STR = "Xin sửa công văn";
        public static final Long DONGY_SUA_CONGVAN = 15L;
        public static final String DONGY_SUA_CONGVAN_STR = "Đồng ý yêu cầu sửa công văn";
        public static final Long TC_SUA_CONGVAN = 16L;
        public static final String TC_SUA_CONGVAN_STR = "Từ chối yêu cầu sửa công văn";
        public static final Long CONGVAN_KIEMDICH_DA_SUADOI = 17L;
        public static final String CONGVAN_KIEMDICH_DA_SUADOI_STR = "Công văn kiểm dịch đã sửa đổi";
    }

    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_13 = "13";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_18 = "18";
        public static final String TYPE_19 = "19";
        public static final String TYPE_20 = "20";
        public static final String TYPE_21 = "21";
        public static final String TYPE_22 = "22";
        public static final String TYPE_23 = "23";
        public static final String TYPE_25 = "25";
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

    public interface TOKEN {

        public static final String URL_API = "http://demo.blameo.com:2468/filedata/FileAttachments/GetToken";
//        public static final String URL_API = "https://vietesoft.com";
        public static final String URL_URI = "/api/ApiAccount/Login";
        public static final String CLIENT_ID = "NSW";
        public static final String CLIENT_KEY = "676e8b1b13e894b7bc65c085d120fc25";
        public static final String PARAM_ID = "clientId";
        public static final String PARAM_KEY = "clientKey";
    }

    public interface PAYTYPE {

        public static final Long ONLINE = 3L;
        public static final Long CHUYEN_KHOAN = 1L;
        public static final Long TRUC_TIEP = 2L;
    }

    public interface FEE_RESULT {

        public static final Long DU_PHI = 1L;
        public static final Long BO_SUNG = 2L;
    }
}
