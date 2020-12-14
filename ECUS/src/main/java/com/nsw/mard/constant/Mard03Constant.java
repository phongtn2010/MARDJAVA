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
public class Mard03Constant {

    public static final String DM_CQXL = "DM_CQXL";
    public static final String DM_TRANGTHAI = "DM_TRANGTHAI";

    public class Routes {

        public static final String ROOT_HOME = "/mard/03";
    }

    public static Mard03Constant getInstance() {
        synchronized (Mard03Constant.class) {
            return new Mard03Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(API.BACKEND) + environment.getRequiredProperty(key);
    }

    public class Pages {

        public static final String HOME = "mard.03.home";
        public static final String EDIT = "mard.03.edit";
        public static final String VIEW = "mard.03.view";
        public static final String VIEW_GP = "mard.03.view.gp";
        public static final String CHARGE = "mard.03.charge";
        public static final String MAU_GIAY_CNHAN = "mard.03.giaycn";
        public static final String MAU_GIAY_CNHANB = "mard.03.giaycnmaub";
        public static final String MAU_DON_KIEMDICH = "mard.03.donkiemdich";
        public static final String DON_XIN_CK = "mard.03.xinchuyenck";
        public static final String CVAN_CK = "mard.03.convanck";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String CHARGE = "/charge";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
        public static final String VIEW_GP = "/view_gp";
        public static final String MAU_GIAY_CNHAN = "/giaycn";
        public static final String MAU_GIAY_CNHANB = "/giaycnb";
        public static final String MAU_DON_KIEMDICH = "/donkiemdich";
        public static final String DON_XIN_CK = "/donxinCk";
        public static final String CVAN_CK = "/cvanCk";

    }

    public class DANHMUC {

        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";
        public static final String DM_CQXL = "DM_CQXL";
        public static final String DM_KHONGOAIQUAN = "DM_KHONGOAIQUAN";
        public static final String DM_CUAKHAU = "DM_CUAKHAU";
        public static final String DM_QUOCGIA = "DM_QUOCGIA";
        public static final String DM_TEPTIN = "DM_TEPTIN";





        public static final String DM_TOCHUC_KT = "DM_TOCHUC_KT";
        public static final String DM_CHITIEU = "DM_CHITIEU";
        public static final String DM_TINHTHANH = "DM_TINHTHANH";
        public static final String DM_LOAI_KT = "DM_LOAI_KT";
        public static final String DM_LOAI_THUCAN = "DM_LOAI_THUCAN";

        public static final String DM_MAHS = "DM_MAHS";
        public static final String DM_NHOMHH = "DM_NHOMHH";
        public static final String DM_DVT_SOLUONG = "DM_DVT_SOLUONG";
        public static final String DM_DVT_KHOILUONG = "DM_DVT_KHOILUONG";
        public static final String DM_DVT_KHOILUONG_BB = "DM_DVT_KHOILUONG_BB";
        public static final String DM_XUATXU = "DM_XUATXU";
        public static final String DM_DV_TIENTE = "DM_DV_TIENTE";
        public static final String DM_LOAIGIAYTO = "DM_LOAIGIAYTO";
        public static final String DM_LOAI_THANHTOAN = "DM_LOAI_THANHTOAN";
        public static final String DM_PHUONG_TIEN = "DM_PHUONG_TIEN";
        public static final String DM_LOAI_HH = "DM_LOAI_HH";
        public static final String DM_TEN_BP = "DM_TEN_BP";
        public static final String DM_LOAI_HS = "DM_LOAI_HS";

    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mard.api.backend";

        public static final String DANHMUC_TRANGTHAI = "mard.03.danhmuc.status";
        public static final String DANHMUC_CQXL = "mard.03.danhmuc.cqxl";
        public static final String DANHMUC_KHO_NGOAI_QUAN = "mard.03.danhmuc.khongoaiquan";
        public static final String DANHMUC_TEPTIN = "mard.03.danhmuc.teptin";
        public static final String DANHMUC_CUAKHAU = "mard.03.danhmuc.cuakhau";
        public static final String DANHMUC_QUOCGIA = "mard.03.danhmuc.quocgia";
        public static final String HOSO_SEARCH = "mard.03.hoso.timkiem";


        public static final String DANHMUC_LOAI_THANHTOAN = "mard.03.danhmuc.loaithanhtoan";
        public static final String DANHMUC_TOCHUC_KT = "mard.03.danhmuc.tochuckt";
        public static final String DANHMUC_CHITIEU = "mard.03.danhmuc.chitieu";
        public static final String DANHMUC_TINHTHANH = "mard.03.danhmuc.tinhthanh";
        public static final String DANHMUC_LOAI_KT = "mard.03.danhmuc.loaikiemtra";
        public static final String DANHMUC_LOAI_THUCAN = "mard.03.danhmuc.loaithucan";
        public static final String DANHMUC_MAHS = "mard.03.danhmuc.mahs";
        public static final String DANHMUC_NHOMHH = "mard.03.danhmuc.nhomhh";
        public static final String DANHMUC_DVT_SOLUONG = "mard.03.danhmuc.dvt.soluong";
        public static final String DANHMUC_DVT_KHOILUONG = "mard.03.danhmuc.dvt.khoiluong";
        public static final String DANHMUC_DVT_KHOILUONG_BB = "mard.03.danhmuc.dvt.khoiluongbb";
        public static final String DANHMUC_XUATXU = "mard.03.danhmuc.xuatxu";
        public static final String DANHMUC_DV_TIENTE = "mard.03.danhmuc.tiente";
        public static final String DANHMUC_LOAIGIAYTO = "mard.03.danhmuc.loaigiayto";
        public static final String DANHMUC_PHUONG_TIEN = "mard.03.danhmuc.phuongtien";
        public static final String DANHMUC_LOAI_HH = "mard.03.danhmuc.loaihh";
        public static final String DANHMUC_TEN_BP = "mard.03.danhmuc.tenbp";
        public static final String DANHMUC_LOAI_HS = "mard.03.danhmuc.loaiHS";

        public static final String HOSO_GET_BYID = "mard.03.hoso.getbyidhoso";
        public static final String HOSO_GET_DATA_XN_DON_BYID = "mard.03.xacnhandon.getdata";
        public static final String HOSO_UPDATE = "mard.03.hoso.update";
        public static final String HOSO_INSERT = "mard.03.hoso.taomoi";
        public static final String HOSO_SEND = "mard.03.hoso.send";
        public static final String LICHSU_SEARCH = "mard.03.tbdlichsu.search";
        public static final String HOSO_DELETE = "mard.03.hoso.xoa";
        public static final String HOSO_GET_GCN_A = "mard.03.hoso.getGiayCNKDDV";
        public static final String HOSO_GET_GCN_B = "mard.03.hoso.getGiayCNKDSPDV";
        public static final String GET_INFO_TB_AP = "mard.03.tbaoapphi.getData";
        public static final String GET_INFO_TB_XNPHI = "mard.03.xnphi.getData";
        public static final String GET_DATA_LOHANG_XL = "mard.03.lohangxl.getData";
        public static final String HOSO_GET_CONGVAN = "mard.03.congvan.getdata";
        public static final String GET_DATA_KDDV = "mard.03.kddv.getData";
        public static final String GET_DATA_KDSPDV = "mard.03.kdspdv.getData";



        public static final String HOSO_XACNHAN_DON = "mard.03.hoso.xacnhandon";
        public static final String HOSO_GET_XNTT = "mard.03.tbdthanhtoanphi.getData";
         public static final String HOSO_PRINT = "mard.03.hoso.print";

    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";
        public static final Long YC_BOSUNG_HS = 3L;
        public static final String YC_BOSUNG_HS_STR = "Yêu cầu sửa đổi bổ sung";
        public static final Long DA_BOSUNG_HS = 4L;
        public static final String DA_BOSUNG_HS_STR = "Đã bổ sung hồ sơ";
        public static final Long RUT_HS = 5L;
        public static final String RUT_HS_STR = "Rút hồ sơ";
        public static final Long TUCHOI_HS = 6L;
        public static final String TUCHOI_HS_STR = "Từ chối hồ sơ";
        public static final Long XACNHAN_DON_DK = 7L;
        public static final String XACNHAN_DON_DK_STR = "Xác nhận Đơn khai báo kiểm dịch";
        public static final Long XINRUT_HS = 8L;
        public static final String XINRUT_HS_STR = "Xin rút hồ sơ";
        public static final Long DONG_Y_XINRUT_HS = 9L;
        public static final String DONG_Y_XINRUT_HS_STR = "Đồng ý xin rút hồ sơ";
        public static final Long TC_XIN_RUT = 10L;
        public static final String TC_XIN_RUT_STR = "Từ chối yêu cầu xin rút hồ sơ";
        public static final Long XINSUA_HS = 11L;
        public static final String XINSUA_HS_STR = "Xin sửa hồ sơ";
        public static final Long DONGY_CHINHSUA_HS = 12L;
        public static final String DONGY_CHINHSUA_HS_STR = "Đồng ý yêu cầu sửa hồ sơ";
        public static final Long TC_YC_SUA_HS = 13L;
        public static final String TC_YC_SUA_HS_STR = "Từ chối yêu cầu sửa hồ sơ";
        public static final Long TB_APPHI = 14L;
        public static final String TB_APPHI_STR = "Thông báo áp phí";
        public static final Long XACNHAN_PHI = 15L;
        public static final String XACNHAN_PHI_STR = "Thông báo xác nhận phí";
        public static final Long LO_HANG_CANXL = 16L;
        public static final String LO_HANG_CANXL_STR = "Lô hàng cần xử lý";
        public static final Long GIAY_CN_KDDV_NK = 17L;
        public static final String GIAY_CN_KDDV_NK_STR = "Giấy chứng nhận kiểm dịch động vật nhập khẩu";
        public static final Long GIAY_CN_KD_SP_DV_NK = 18L;
        public static final String GIAY_CN_KD_SP_DV_NK_STR = "Giấy chứng nhận kiểm dịch sản phẩm động vật nhập khẩu";
        public static final Long SUA_GIAY_CN_KDDV_NK = 19L;
        public static final String SUA_GIAY_CN_KDDV_NK_STR = "Sửa giấy chứng nhận kiểm dịch động vật nhập khẩu";
        public static final Long SUA_GIAY_CN_KD_SP_DV_NK = 20L;
        public static final String SUA_GIAY_CN_KD_SP_DV_NK_STR = "Sửa giấy chứng nhận kiểm dịch sản phẩm động vật nhập khẩu";
        public static final Long DN_XIN_SUA_GCN = 21L;
        public static final String DN_XIN_SUA_GCN_STR = "Xin sửa giấy chứng nhận";
        public static final Long DONGY_XINSUA_GCN_KDDV = 22L;
        public static final String DONGY_XINSUA_GCN_KDDV_STR = "Đồng ý xin sửa giấy chứng nhận kiểm dịch động vật nhập khẩu";
        public static final Long TC_XIN_SUA_GCN = 23L;
        public static final String TC_XIN_SUA_GCN_STR = "Từ chối xin sửa giấy chứng nhận";
        public static final Long XACNHAN_HANG_QUA_CK = 24L;
        public static final String XACNHAN_HANG_QUA_CK_STR = "Xác nhận hàng qua cửa khẩu (16a)";
        public static final Long DN_XIN_HUY_GCN = 25L;
        public static final String DN_XIN_HUY_GCN_STR = "Xin hủy giấy chứng nhận";
        public static final Long DONGY_XIN_HUY_GCN = 26L;
        public static final String DONGY_XIN_HUY_GCN_STR = "Đồng ý xin hủy giấy chứng nhận";
        public static final Long TC_XIN_HUY_GCN = 27L;
        public static final String TC_XIN_HUY_GCN_STR = "Từ chối xin hủy giấy chứng nhận";
        public static final Long DN_XIN_CHUYEN_CK = 28L;
        public static final String DN_XIN_CHUYEN_CK_STR = "Doanh nghiệp xin chuyển cửa khẩu";
        public static final Long CAP_CV_CHUYEN_CK = 29L;
        public static final String CAP_CV_CHUYEN_CK_STR = "Cấp công văn chuyển cửa khẩu";
        public static final Long TC_YC_CAP_CV = 30L;
        public static final String TC_YC_CAP_CV_STR = "Từ chối yêu cầu chuyển cửa khẩu";
        public static final Long CAP_CHINHSUA_CV_CHUYEN_CK = 31L;
        public static final String CAP_CHINHSUA_CV_CHUYEN_CK_STR = "Cấp chỉnh sửa công văn chuyển cửa khẩu";
        public static final Long XIN_RUT_CV_CHUYENKHAU = 32L;
        public static final String XIN_RUT_CV_CHUYENKHAU_STR = "Xin rút công văn chuyển cửa khẩu";
        public static final Long DONGY_XINRUT_CV_CHUYEN_CK = 33L;
        public static final String DONGY_XINRUT_CV_CHUYEN_CK_STR = "Đồng ý yêu cầu xin rút công văn chuyển cửa khẩu";
        public static final Long TC_YC_XINRUT_CV_CHUYEN_CK = 34L;
        public static final String TC_YC_XINRUT_CV_CHUYEN_CK_STR = "Từ chối yêu cầu xin rút công văn chuyển cửa khẩu";
        public static final Long THUHOI_CV_CHUYEN_CK = 35L;
        public static final String THUHOI_CV_CHUYEN_CK_STR = "Thu hồi công văn chuyển cửa khẩu";
        public static final Long DONGY_XINSUA_GCN_SPDV = 36L;
        public static final String DONGY_XINSUA_GCN_SPDV_STR = "Đồng ý xin sửa giấy chứng nhận kiểm dịch sản phẩm động vật nhập khẩu";
        public static final Long XACNHAN_HANG_QUA_CK_16B = 37L;
        public static final String XACNHAN_HANG_QUA_CK_16B_STR = "Xác nhận hàng qua cửa khẩu (16b)";
        public static final Long GUI_SUA_CHUYEN_CK = 38L;
        public static final String GUI_SUA_CHUYEN_CK_STR = "Gửi sửa chuyển cửa khẩu";
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
        public static final String TYPE_26 = "26";
        public static final String TYPE_27 = "27";
        public static final String TYPE_28 = "28";
        public static final String TYPE_29 = "29";
        public static final String TYPE_30 = "30";
        public static final String TYPE_31 = "31";
        public static final String TYPE_32 = "32";
        public static final String TYPE_33 = "33";
        public static final String TYPE_34 = "34";
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
        public static final String FUNCTION_17 = "17";
        public static final String FUNCTION_18 = "18";
        public static final String FUNCTION_19 = "19";
        public static final String FUNCTION_20 = "20";
        public static final String FUNCTION_21 = "21";
        public static final String FUNCTION_22 = "22";
        public static final String FUNCTION_23 = "23";
        public static final String FUNCTION_24 = "24";
        public static final String FUNCTION_25 = "25";
        public static final String FUNCTION_26 = "26";
        public static final String FUNCTION_27 = "27";
        public static final String FUNCTION_28 = "28";
        public static final String FUNCTION_29 = "29";
        public static final String FUNCTION_30 = "30";
        public static final String FUNCTION_31 = "31";
        public static final String FUNCTION_32 = "32";
        public static final String FUNCTION_33 = "33";
        public static final String FUNCTION_34 = "34";
        public static final String FUNCTION_35 = "35";
        public static final String FUNCTION_36 = "36";
        public static final String FUNCTION_37 = "37";
        public static final String FUNCTION_38 = "38";
        public static final String FUNCTION_39 = "39";
        public static final String FUNCTION_40 = "40";
        public static final String FUNCTION_41 = "41";
        public static final String FUNCTION_42 = "42";
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
