package com.vnsw.ws.p1.common;

import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.p1.message.ResponseWrapper;

public class Constants01 {
    public interface MARD01_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_13 = "13";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_17 = "17";
        public static final String TYPE_18 = "18";
        public static final String TYPE_19 = "19";
        public static final String TYPE_20 = "20";
        public static final String TYPE_21 = "21";
        public static final String TYPE_22 = "22";
        public static final String TYPE_23 = "23";
        public static final String TYPE_24 = "24";
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
        public static final String TYPE_35 = "35";
        public static final String TYPE_36 = "36";

    }

    public interface MARD01_FUNCTION {

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
        public static final String FUNCTION_99 = "99";
    }

    public interface RES_URI {
        public static final String URI_UPDATE_STATUS_HOSO = "/mard/01/ws/updateTrangthaiHS";
        public static final String URI_UPDATE_LICHSU = "/mard/01/ws/updateLichsuHS";
        public static final String URI_UPDATE_KQTD_HOSO01 = "/mard/01/ws/updateKQTDhoso01";
        public static final String URI_UPDATE_CNKD_13A = "/mard/01/ws/xlCNKD13A";
        public static final String URI_UPDATE_CNKD_13B = "/mard/01/ws/xlCNKD13B";
        public static final String URI_UPDATE_CNKD_CHINA = "/mard/01/ws/xlCNKDChina";
        public static final String URI_UPDATE_CNKD_HONGKONG_CHICKEN = "/mard/01/ws/xlCNKDHongKongChicken";
        public static final String URI_UPDATE_CNKD_MALAYSIA = "/mard/01/ws/xlCNKDMalaysia";
        public static final String URI_UPDATE_CNKD_HONGKONG_PIG = "/mard/01/ws/xlCNKDHongKongPig";
        public static final String URI_UPDATE_XACNHANDON = "/mard/01/ws/updateXacNhanDon";
        public static final String URI_UPDATE_KETQUA_XIN_SUA_HS = "/mard/01/ws/updateKQXinSuaHS";
        public static final String URI_UPDATE_KETQUA_XIN_RUT_HS = "/mard/01/ws/updateKQXinRutHS";
        public static final String URI_UPDATE_KETQUA_XIN_SUA_CNKD = "/mard/01/ws/updateKQXinSuaCNKD";
        public static final String URI_UPDATE_TB_APPHI = "/mard/01/ws/updateTBAP";
        public static final String URI_UPDATE_XACNHAN_PHI = "/mard/01/ws/updateXNPHI";
        public static final String URI_UPDATE_KQYC_XUAT_KHAU = "/mard/01/ws/updateYCXuatKhau";
        public static final String URI_UPDATE_KETQUA_HUY_CNKD = "/mard/01/ws/updateKQHuyCNKD";
        public static final String URI_GET_HS_BY_ID = "/mard/01/ws/hoso/";
    }

    public interface HosoStatus {

        public static final Long TAO_MOI = 0l;
        public static final String TAO_MOI_STR = "Tạo mới";
        public static final Long CHO_TIEP_NHAN = 1l;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận hồ sơ";
        public static final Long CHO_TIEP_NHAN_BO_SUNG = 2l;
        public static final String CHO_TIEP_NHAN_BO_SUNG_STR = "Chờ tiếp nhận hồ sơ gửi bổ sung";
        public static final Long DA_HUY = 3l;
        public static final String DA_HUY_STR = "Đã hủy hồ sơ";
        public static final Long BI_TU_CHOI = 4l;
        public static final String BI_TU_CHOI_STR = "Bị từ chối";
        public static final Long YEU_CAU_BO_SUNG = 5l;
        public static final String YEU_CAU_BO_SUNG_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_TIEP_NHAN = 6l;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận hồ sơ";
        public static final Long DA_XAC_NHAN_DON_KHAI_BAO_KD = 7l;
        public static final String DA_XAC_NHAN_DON_KHAI_BAO_KD_STR = "Đã xác nhận đơn khai báo kiểm dịch";
        public static final Long DA_GUI_THONG_BAO_AP_PHI = 8l;
        public static final String DA_GUI_THONG_BAO_AP_PHI_STR = "Đã gửi thông báo áp phí";
        public static final Long DA_NOP_PHI_CK = 9l;
        public static final String DA_NOP_PHI_CK_STR = "Đã nộp phí chuyển khoản";
        public static final Long DA_YC_NOP_BS_PHI = 10l;
        public static final String DA_YC_NOP_BS_PHI_STR = "Đã yêu cầu nộp bổ sung phí";
        public static final Long THONG_BAO_XU_LY_LO_HANG = 11l;
        public static final String THONG_BAO_XU_LY_LO_HANG_STR = "Thông báo xử lý lô hàng";
        public static final Long CNKD_13A = 12l;
        public static final String CNKD_13A_STR = "Giấy chứng nhận kiểm dịch - mẫu 13A";
        public static final Long CNKD_13B = 13l;
        public static final String CNKD_13B_STR = "Giấy chứng nhận kiểm dịch - mẫu 13B";
        public static final Long CNKD_HKP = 14l;
        public static final String CNKD_HKP_STR = "Giấy chứng nhận kiểm dịch - Mẫu Hong Kong (sản phẩm thịt lợn)";
        public static final Long CNKD_M = 15l;
        public static final String CNKD_M_STR = "Giấy chứng nhận kiểm dịch - mẫu Malaysia";
        public static final Long CNKD_HKC = 16l;
        public static final String CNKD_HKC_STR = "Giấy chứng nhận kiểm dịch - mẫu Hong Kong (sản phẩm thịt gà)";
        public static final Long CNKD_CN = 17l;
        public static final String CNKD_CN_STR = "Giấy chứng nhận kiểm dịch - mẫu Trung Quốc";
        public static final Long CHO_TIEP_NHAN_YCCS = 18l;
        public static final String CHO_TIEP_NHAN_YCCS_STR = "Chờ tiếp nhận Yêu cầu xin sửa hồ sơ";
        public static final Long DONG_Y_YCCS = 19l;
        public static final String DONG_Y_YCCS_STR = "Đồng ý Yêu cầu chỉnh sửa hồ sơ";
        public static final Long TU_CHOI_YCCS = 20l;
        public static final String TU_CHOI_YCCS_STR = "Từ chối Yêu cầu chỉnh sửa hồ sơ";
        public static final Long CHO_TIEP_NHAN_YC_XIN_RUT = 21l;
        public static final String CHO_TIEP_NHAN_YC_XIN_RUT_STR = "Chờ tiếp nhận Yêu cầu xin rút hồ sơ";
        public static final Long CHO_TIEP_NHAN_YC_XIN_SUA = 22l;
        public static final String CHO_TIEP_NHAN_YC_XIN_SUA_STR = "Chờ tiếp nhận Yêu cầu xin sửa hồ sơ";
        public static final Long DONG_Y_YC_XIN_RUT = 23l;
        public static final String DONG_Y_YC_XIN_RUT_STR = "Cán bộ tiếp nhận đồng ý yêu cầu xin rút hồ sơ";
        public static final Long TU_CHOI_YC_XIN_RUT = 24l;
        public static final String TU_CHOI_YC_XIN_RUT_STR = "Cán bộ tiếp nhận từ chối yêu cầu xin rút hồ sơ";
        public static final Long CHO_TIEP_NHAN_YC_CS_GCN = 25l;
        public static final String CHO_TIEP_NHAN_YC_CS_GCN_STR = "Chờ tiếp nhận Yêu cầu xin sửa giấy chứng nhận";
        public static final Long DA_CHINH_SUA_GCN_THEO_YC = 26l;
        public static final String DA_CHINH_SUA_GCN_THEO_YC_STR = "Đã chỉnh sửa giấy chứng nhận theo yêu cầu";
        public static final Long TU_CHOI_YC_CS_GCN = 27l;
        public static final String TU_CHOI_YC_CS_GCN_STR = "Từ chối yêu cầu chỉnh sửa giấy chứng nhận";
        public static final Long DA_SUA_GCN_KIEM_DICH = 28l;
        public static final String DA_SUA_GCN_KIEM_DICH_STR = "Đã sửa giấy chứng nhận kiểm dịch";
        public static final Long DA_SUADOI_BS = 29l;
        public static final String DA_SUADOI_BS_STR = "Đã sửa đổi bổ sung hồ sơ theo YC của BNN";

    }


    public interface ENVELOP_TAG_ENCODE {

        public static final String OPEN_TAG = "&lt;Envelope&gt;";
        public static final String CLOSE_TAG = "&lt;/Envelope&gt;";
    }

    public interface TAG_ENCODE {

        public final static String OPEN_TAG = "&lt;";
        public static final String CLOSE_TAG = "&gt;";
        public static final String UNKNOW_TAG = "";
        public static final String AND_TAG = "&";
    }

    public interface TAG_NO_ENCODE {

        public final static String OPEN_TAG = "<";
        public static final String CLOSE_TAG = ">";
        public static final String AND_TAG = "&";
    }
}
