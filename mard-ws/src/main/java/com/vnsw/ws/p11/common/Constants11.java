/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p11.common;

public class Constants11 {

    public interface MARD11_TYPE {
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
    }

    public interface MARD11_FUNCTION {

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
        public static final String FUNCTION_99 = "99";
    }

    public interface RES_URI {
        // Cap nhat trang thai ho so
        public static final String URI_UPDATE_STATUS_HOSO = "/mard/11/ws/updateTrangthaiHS/";
        public static final String URI_UPDATE_LICHSU = "/mard/11/ws/logSend/";
        public static final String URI_UPDATE_KQTD = "/mard/11/ws/updateKqtd/";
        public static final String URI_UPDATE_XAC_ND= "/mard/11/ws/updateXacnhandon/";
        public static final String URI_KQ_XIN_RUT_HS = "/mard/11/ws/updateKQXinRutHS/";
        public static final String URI_KQ_XIN_SUA_HS = "/mard/11/ws/updateKQXinSuaHS/";
        public static final String URI_TB_AP_PHI = "/mard/11/ws/tbApPhi/";
        public static final String URI_TB_AP_PHI_BS = "/mard/11/ws/tbApPhiBoSung/";
        public static final String URI_TB_GCN = "/mard/11/ws/thongbaoGCN/";
        public static final String URI_DE_NGHI_GUI_GCN = "/mard/11/ws/denghicapGCN/";
        public static final String URI_TB_LOHANG_CAN_XL = "/mard/11/ws/tblohangcanXL/";
        public static final String URI_KQ_XIN_SUA_GCN = "/mard/11/ws/updateKQXinSuaGCN/";
        public static final String URL_GET_HOSO = "/mard/11/ws/getHoSo/";
        public static final String URL_GET_GCN = "/mard/11/ws/getGCN/";
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
        public static final Long DA_XAC_NHAN_GIAY_KHAI_BAO_KD = 6l;
        public static final String DA_XAC_NHAN_GIAY_KHAI_BAO_KD_STR = "Đã xác nhận Giấy đăng ký kiểm dịch";
        public static final Long DA_GUI_THONG_BAO_AP_PHI = 7l;
        public static final String DA_GUI_THONG_BAO_AP_PHI_STR = "Đã gửi thông báo áp phí";
        public static final Long DA_NOP_PHI_CK = 8l;
        public static final String DA_NOP_PHI_CK_STR = "Đã thanh toán chuyển khoản";
        public static final Long DA_YC_NOP_BS_PHI = 9l;
        public static final String DA_YC_NOP_BS_PHI_STR = "Yêu cầu thanh toán bổ sung";
        public static final Long DA_NOP_BS_PHI = 10l;
        public static final String DA_NOP_BS_PHI_STR = "Đã thanh toán chuyển khoản bổ sung";
        public static final Long THONG_BAO_XU_LY_LO_HANG = 11l;
        public static final String THONG_BAO_XU_LY_LO_HANG_STR = "Thông báo xử lý lô hàng";
        public static final Long DE_NGHI_CUNG_CAP_TT_GIAY_CHUNG_NHAN = 12l;
        public static final String DE_NGHI_CUNG_CAP_TT_GIAY_CHUNG_NHAN_STR = "Đề nghị cung cấp thông tin Giấy chứng nhận";
        public static final Long CUNG_CAP_TT_GIAY_CHUNG_NHAN = 13l;
        public static final String CUNG_CAP_TT_GIAY_CHUNG_NHAN_STR = "Đã cung cấp thông tin Giấy chứng nhận";
        public static final Long DA_PHE_DUYET_GCN_KIEM_DICH = 14l;
        public static final String DA_PHE_DUYET_GCN_KIEM_DICH_STR = "Đã phê duyệt Giấy chứng nhận kiểm dịch";
        public static final Long CHO_TIEP_NHAN_YCCS = 15l;
        public static final String CHO_TIEP_NHAN_YCCS_STR = "Chờ tiếp nhận Yêu cầu xin sửa hồ sơ";
        public static final Long DONG_Y_YCCS = 16l;
        public static final String DONG_Y_YCCS_STR = "Đồng ý Yêu cầu chỉnh sửa hồ sơ";
        public static final Long TU_CHOI_YCCS = 17l;
        public static final String TU_CHOI_YCCS_STR = "Từ chối Yêu cầu chỉnh sửa hồ sơ";
        public static final Long CHO_TIEP_NHAN_YC_XIN_RUT = 18l;
        public static final String CHO_TIEP_NHAN_YC_XIN_RUT_STR = "Chờ tiếp nhận Yêu cầu xin hủy hồ sơ";
        public static final Long DONG_Y_YC_XIN_RUT = 19l;
        public static final String DONG_Y_YC_XIN_RUT_STR = "Cán bộ tiếp nhận đồng ý yêu cầu xin hủy hồ sơ";
        public static final Long TU_CHOI_YC_XIN_RUT = 20l;
        public static final String TU_CHOI_YC_XIN_RUT_STR = "Cán bộ tiếp nhận từ chối yêu cầu xin hủy hồ sơ";
        public static final Long CHO_TIEP_NHAN_YC_CS_GCN = 21l;
        public static final String CHO_TIEP_NHAN_YC_CS_GCN_STR = "Chờ tiếp nhận Yêu cầu xin sửa giấy chứng nhận";
        public static final Long DONG_Y_XIN_SUA_GCN = 22l;
        public static final String DONG_Y_XIN_SUA_GCN_STR = "Cán bộ tiếp nhận Đồng ý cho chỉnh sửa giấy chứng nhận kiểm dịch";
        public static final Long TU_CHOI_XIN_SUA_GCN = 23l;
        public static final String TU_CHOI_XIN_SUA_GCN_STR = "Cán bộ tiếp nhận Từ chối cho chỉnh sửa giấy chứng nhận kiểm dịch";
        public static final Long BNN_CHINH_SUA_GCN = 24l;
        public static final String BNN_CHINH_SUA_GCN_STR = "Đã sửa giấy chứng nhận kiểm dịch";
        public static final Long DA_SUA_DOI_BS_HOSO = 25l;
        public static final String DA_SUA_DOI_BS_HOSO_STR = "Đã sửa đổi bổ sung hồ sơ";
        public static final Long DA_TIEP_NHAN_HOSO = 26l;
        public static final String DA_TIEP_NHAN_HOSO_STR = "Đã tiếp nhận";
        public static final Long DA_XAC_NHAN_DON = 27l;
        public static final String DA_XAC_NHAN_DON_STR = "Thông báo xác nhận đơn đăng ký kiểm dịch thực vật";
        public static final Long THONG_BAO_GCN_KDTV = 28l;
        public static final String THONG_BAO_GCN_KDTV_STR = "Thông báo Giấy Chứng nhận kiểm dịch thực vật";
    }
}
