package com.vnsw.ws.p9.common;

public class Constants09 {
    public interface MARD09_TYPE {

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

    }

    public interface MARD09_FUNCTION {

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
        // Cap nhat trang thai ho so

        public static final String URI_UPDATE_STATUS_HOSO = "/mard/09/ws/updateTrangthaiHS";
        public static final String URI_UPDATE_LICHSU = "/mard/09/ws/updateLichsuHS";
        public static final String URI_UPDATE_KQTD = "/mard/09/ws/updateKetQuaThamDinh";
        public static final String URI_UPDATE_XAC_NHAN_DON_DANG_KY = "/mard/09/ws/updateXacNhanDonDangKy";
        public static final String URI_UPDATE_KETQUA_XIN_SUA_HS = "/mard/09/ws/updateKQXinSuaHS";
        public static final String URI_UPDATE_KETQUA_XIN_RUT_HS = "/mard/09/ws/updateKQXinRutHS";
        public static final String URI_UPDATE_GIAY_CNKD = "/mard/09/ws/xlCNKD";
        public static final String URI_UPDATE_GIAY_VAN_CHUYEN = "/mard/09/ws/xlGVC";
        public static final String URI_UPDATE_GIAY_XNCL = "/mard/09/ws/xlXNCL";
        public static final String URI_THONGBAO_APPHI = "/mard/09/ws/tbPhi";
        public static final String URI_THONGBAO_APPHI_BOSUNG = "/mard/09/ws/tbPhiBS";
        public static final String URI_XACNHAN_PHI = "/mard/09/ws/xnPhi";
        public static final String URI_NHAN_CV_XNCL_KHONGDAT = "/mard/09/ws/xlFailXNCL";
        public static final String URI_TB_KHONGCAP_CNKD = "/mard/09/ws/xlCNKDKd";
        public static final String URI_GET_HS_BY_ID = "/mard/09/ws/hoso/";
        public static final String URI_PHANHOI_SUA_GCN = "/mard/09/ws/updateTuchoiXinsuaGCN";
        public static final String URI_UPDATE_YCS = "/mard/09/ws/updateYCS";
    }

    public interface HosoStatus {

        public static final long INIT = -1;
        public static final String INIT_STR = "";

        public static final long TAO_MOI = 0;
        public static final String TAO_MOI_STR = "Tạo mới";

        public static final long CHO_TIEP_NHAN = 1;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";

        public static final long DA_RUT_HO_SO = 2;
        public static final String DA_RUT_HO_SO_STR = "Đã rút hồ sơ";

        public static final long DA_TIEP_NHAN = 3;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";

        public static final long TU_CHOI_HO_SO = 4;
        public static final String TU_CHOI_HO_SO_STR = "Từ chối hồ sơ";

        public static final long TU_CHOI_TIEP_NHAN = 5;
        public static final String TU_CHOI_TIEP_NHAN_STR = "Từ chối tiếp nhận";

        public static final long CHO_TIEP_NHAN_BS = 6;
        public static final String CHO_TIEP_NHAN_BS_STR = "Đã gửi sửa đổi bổ sung";

        public static final long YEU_CAU_BO_SUNG = 7;
        public static final String YEU_CAU_BO_SUNG_STR = "Yêu cầu sửa đổi bổ sung";

        public static final long CHO_TIEP_NHAN_YCS = 8;
        public static final String CHO_TIEP_NHAN_YCS_STR = "Chờ tiếp nhận yêu cầu sửa";

        public static final long DONG_Y_YCS = 9;
        public static final String DONG_Y_YCS_STR = "Đồng ý yêu cầu sửa";

        public static final long TU_CHOI_YCS = 10;
        public static final String TU_CHOI_YCS_STR = "Từ chối yêu cầu sửa";

        public static final long CHO_TIEP_NHAN_YCR = 11;
        public static final String CHO_TIEP_NHAN_YCR_STR = "Chờ tiếp nhận yêu cầu rút";

        public static final long DONG_Y_YCR = 12;
        public static final String DONG_Y_YCR_STR = "Đồng ý yêu cầu rút";

        public static final long TU_CHOI_YCR = 13;
        public static final String TU_CHOI_YCR_STR = "Từ chối yêu cầu rút";

        public static final long DA_XM_DON_DK = 14;
        public static final String DA_XM_DON_DK_STR = "Đã xác minh đơn đăng ký";

        public static final long DA_CAP_GVC = 15;
        public static final String DA_CAP_GVC_STR = "Đã cấp giấy vận chuyển";

        public static final long DA_CAP_CNKD = 16;
        public static final String DA_CAP_CNKD_STR = "Đã cấp giấy chứng nhận kiểm dịch";

        public static final long KHONG_CAP_CNKD = 17;
        public static final String KHONG_CAP_CNKD_STR = "Không cấp giấy chứng nhận kiểm dịch";

        public static final long XNCL_KHONG_DAT = 18;
        public static final String XNCL_KHONG_DAT_STR = "Kết quả XNCL không đạt";

        public static final long XNCL_DAT = 19;
        public static final String XNCL_DAT_STR = "Kết quả XNCL đạt";

        public static final long CHO_PHUC_KHAO = 20;
        public static final String CHO_PHUC_KHAO_STR = "Chờ kết quả phúc khảo lần 2";

        public static final long YCS_CNKD = 21;
        public static final String YCS_CNKD_STR = "Đã yêu cầu sửa GCN Kiểm dịch";

        public static final long YCS_GVC = 22;
        public static final String  YCS_GVC_STR = "Đã yêu cầu sửa GVC";

        public static final long YCS_XNCL = 23;
        public static final String  YCS_XNCL_STR = "Đã yêu cầu sửa XNCL";

        public static final long XNCL_THAT_BAI = 24;
        public static final String XNCL_THAT_BAI_STR = "Kết quả phúc khảo XNCL không đạt";

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
