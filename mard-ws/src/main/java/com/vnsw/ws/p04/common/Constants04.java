package com.vnsw.ws.p04.common;

public class Constants04 {

    public interface RES_METHOD {

        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }

    public interface MARD04_TYPE {

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
        public static final String TYPE_22 = "22";
        public static final String TYPE_23 = "23";
        public static final String TYPE_24 = "24";
        public static final String TYPE_25 = "25";
        public static final String TYPE_21 = "21";
    }

    public interface MARD04_FUNCTION {

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
        public static final String FUNCTION_99 = "99";
        public static final String FUNCTION_19 = "19";
        public static final String FUNCTION_20 = "20";
        public static final String FUNCTION_21 = "21";
        public static final String FUNCTION_22 = "22";
        public static final String FUNCTION_23 = "23";
        public static final String FUNCTION_24 = "24";
        public static final String FUNCTION_25 = "25";
        public static final String FUNCTION_30 = "30";
        public static final String FUNCTION_31 = "31";
    }

    public interface RES_URI {

        public static final String URI_XACNHAN_PHI = "/mard/04/xacNhanPhi/data/";
        public static final String URI_PH_YEUCAU_SUA_XNCL = "/mard/04/ycSuaXNCL/data/";
        public static final String URI_CHITIEU = "/mard/04/chiTieu/data/";
        public static final String URL_GET_HOSO = "/mard/04/hoso04/getDataById/";
        public static final String URI_THONGBAO_PHI = "/mard/04/TBPhi/create";
        public static final String URI_LICHSU_RESPONSE = "/mard/04/lichsu/data/";
        public static final String URI_XACNHAN_DON = "/mard/04/xacnhandon/create";
        public static final String URI_GIULAI_VA_XULY = "/mard/04/lenhGiulaiVaXuly/create";
        public static final String URI_VAN_BAN_UPDATE = "";
        public static final String URL_HOSO = "";
        public static final String URI_XACNHAN_KDTV = "/mard/04/giayXacNhanKDTV/create";
        public static final String URI_XACNHAN_CHATLUONG = "/mard/04/giayXacNhanCL/create";
        public static final String URI_KETQUA_XULY = "/mard/04/kqXuly/createkqxl";
        public static final String URI_PHANHOI_YC_RUT = "/mard/04/ycrut/data/";
        public static final String URI_PHANHOI_YC_SUA = "/mard/04/ycSua/data/";
        public static final String URI_TAMCAP_KQKDTV = "/mard/04/giayTamCap/create";
        public static final String URI_GET_THANHTOANPHI = "/mard/04/thanhToanPhi/getdataByMahs";

    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long RUT_HS = 2L;
        public static final String RUT_HS_STR = "Rút hồ sơ";
        public static final Long YC_BOSUNG_HS = 3L;
        public static final String YC_BOSUNG_HS_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_BOSUNG_HS = 4L;
        public static final String DA_BOSUNG_HS_STR = "Đã bổ sung hồ sơ";
        public static final Long TUCHOI_HS = 5L;
        public static final String TUCHOI_HS_STR = "Từ chối hồ sơ";
        public static final Long XACNHAN_DON_DK = 6L;
        public static final String XACNHAN_DON_DK_STR = "Xác nhận đơn đăng ký";
        public static final Long XINSUA_HS = 7L;
        public static final String XINSUA_HS_STR = "Xin sửa hồ sơ";
        public static final Long DONGY_CHINHSUA_HS = 8L;
        public static final String DONGY_CHINHSUA_HS_STR = "Đồng ý chỉnh sửa hồ sơ";
        public static final Long XINRUT_HS = 9L;
        public static final String XINRUT_HS_STR = "Xin rút hồ sơ";
        public static final Long DONG_Y_XINRUT_HS = 10L;
        public static final String DONG_Y_XINRUT_HS_STR = "Đồng ý xin rút hồ sơ";
        public static final Long TB_AP_PHI = 11L;
        public static final String TB_AP_PHI_STR = "Thông báo áp phí";
        public static final Long DA_THANHTOAN_PHI = 12L;
        public static final String DA_THANHTOAN_PHI_STR = "Đã thanh toán phí";
        public static final Long DA_THANHTOAN_PHI_ONL = 13L;
        public static final String DA_THANHTOAN_PHI_ONL_STR = "Đã thanh toán phí online";
        public static final Long YC_THANHTOAN_BS = 14L;
        public static final String YC_THANHTOAN_BS_STR = "Yêu cầu thanh toán bổ sung";
        public static final Long TB_DA_THANHTOAN_BS = 15L;
        public static final String TB_DA_THANHTOAN_BS_STR = "Thông báo đã thanh toán phí bổ sung";
        public static final Long XACNHAN_PHI = 16L;
        public static final String XACNHAN_PHI_STR = "Xác nhận phí";
        public static final Long GIAY_TAMCAP_KIEMDICH = 17L;
        public static final String GIAY_TAMCAP_KIEMDICH_STR = "Giấy tạm cấp kết quả kiểm dịch";
        public static final Long DA_TRALAI_KQ = 18L;
        public static final String DA_TRALAI_KQ_STR = "Đã trả kết quả";
        public static final Long LENH_GIULAI_XULY = 19L;
        public static final String LENH_GIULAI_XULY_STR = "Lệnh giữ lại và xử lý";
        public static final Long YC_SUA_GIAY_CNKDXNCL = 20L;
        public static final String YC_SUA_GIAY_CNKDXNCL_STR = "Yêu cầu sửa giấy CNKD/CNCL";
        public static final Long TC_YC_SUA_GIAY_CNKDXNCL = 21L;
        public static final String TC_YC_SUA_GIAY_CNKDXNCL_STR = "Từ chối yêu cầu sửa giấy CNKD/CNCL";
        public static final Long TC_YC_SUA_HS = 22L;
        public static final String TC_YC_SUA_HS_STR = "Từ chối sửa hồ sơ";
        public static final Long TC_XIN_RUT = 23L;
        public static final String TC_XIN_RUT_STR = "Từ chối yêu cầu xin rút";
        public static final Long CHI_TIEU_CL = 24L;
        public static final String CHI_TIEU_CL_STR = "Chi tiêu chất lượng";
    }

    public interface DONVI {

        public static final String NSW = "NSW";
        public static final String BNNPTNT = "Bộ nông nghiệp";
    }
      public interface FEE_RESULT {

        public static final Long DU_PHI = 1L;
        public static final Long BO_SUNG = 2L;
    }
}
