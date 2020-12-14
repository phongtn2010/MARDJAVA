package com.nsw.mard.constant;

import org.springframework.core.env.Environment;

/**
 * @author HuongMK
 */
public class Mard04Constant {
    public static final String EnableSign = "nsw.mard.04.sign";

    public static final String DM_CQXL = "DM_CQXL";

    public static final String DM_TRANGTHAI = "DM_TRANGTHAI";

    public class Routes {
        public static final String ROOT_HOME = "/mard/04";
    }

    public static Mard04Constant getInstance() {
        synchronized (Mard04Constant.class) {
            return new Mard04Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty("mard.api.backend") + environment.getRequiredProperty(key);
    }

    public class Pages {
        public static final String HOME = "mard.04.home";

        public static final String VIEW = "mard.04.view";

        public static final String XAC_NHAN_DON = "mard.04.xnd";

        public static final String MAU_GIAY_GIULAI = "mard.04.PhytosanitaryDetain";

        public static final String MAU_GIAY_CNKD = "mard.04.PhytosanitaryResult";

        public static final String MAU_GIAY_XNCL = "mard.04.QuanlityResult";

        public static final String MAU_GIAY_CNTP = "mard.04.PhytosanitaryFoodSafetyResult";

        public static final String MAU_GIAY_ATTP = "mard.04.FoodSafetyResult";

        public static final String MAU_GIAY_TAMCAP = "mard.04.TemporaryPhytosanitary";

        public static final String CHARGE = "mard.04.charge";

        public static final String CHARGEBS = "mard.04.chargeBS";

        public static final String XAC_NHAN_PHI = "mard.04.FeeResponse";
    }

    public class View {
        public static final String HOME = "/home";

        public static final String INDEX = "/index";

        public static final String VIEW = "/view";

        public static final String XAC_NHAN_DON = "/xacnhandon";

        public static final String MAU_GIAY_GIULAI = "/PhytosanitaryDetain";

        public static final String MAU_GIAY_CNKD = "/PhytosanitaryResult";

        public static final String MAU_GIAY_XNCL = "/QuanlityResult";

        public static final String MAU_GIAY_CNTP = "/PhytosanitaryFoodSafetyResult";

        public static final String MAU_GIAY_ATTP = "/FoodSafetyResult";

        public static final String MAU_GIAY_TAMCAP = "/TemporaryPhytosanitary";

        public static final String CHARGE = "/charge";

        public static final String CHARGEBS = "/chargeBS";

        public static final String XAC_NHAN_PHI = "/FeeResponse";
    }

    public class DANHMUC {
        public static final String DM_TEPTIN = "DM_TEPTIN";

        public static final String DM_BAOBI = "DM_BAOBI";

        public static final String DM_BOPHANDUNG = "DM_BOPHANDUNG";

        public static final String DM_CQ_KIEMTRA = "DM_CQ_KIEMTRA";

        public static final String DM_CQXL = "DM_CQXL";

        public static final String DM_CUAKHAU = "DM_CUAKHAU";

        public static final String DM_DONVI_TINH = "DM_DONVI_TINH";

        public static final String DM_HANGHOA = "DM_HANGHOA";

        public static final String DM_LOAI_GIAYTO = "DM_LOAI_GIAYTO";

        public static final String DM_LOAIHANG = "DM_LOAIHANG";

        public static final String DM_LOAI_THUCAN = "DM_LOAI_THUCAN";

        public static final String DM_PHUONGTIEN = "DM_PHUONGTIEN";

        public static final String DM_QUOCGIA = "DM_QUOCGIA";

        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";

        public static final String DM_DV_TIENTE = "DM_DV_TIENTE";

        public static final String DM_LOAIDON = "DM_LOAIDON";

        public static final String DM_LOAI_KIEMTRA = "DM_LOAI_KIEMTRA";

        public static final String DM_TRANGTHAI_PHI = "DM_TRANGTHAI_PHI";

        public static final String DM_PHUONGTHUC_KT = "DM_PHUONGTHUC_KT";
    }

    public static interface API {
        public static final String BACKEND_COMMON = "nsw.common.url";

        public static final String BACKEND = "mard.api.backend";

        public static final String DANHMUC_TEPTIN = "mard.04.danhmuc.teptin";

        public static final String DANHMUC_BAOBI = "mard.04.danhmuc.baobi";

        public static final String DANHMUC_BOPHANDUNG = "mard.04.danhmuc.bophandung";

        public static final String DANHMUC_CQ_KIEMTRA = "mard.04.danhmuc.cqkt";

        public static final String DANHMUC_CQXL = "mard.04.danhmuc.cqxl";

        public static final String DANHMUC_CUAKHAU = "mard.04.danhmuc.cuakhau";

        public static final String DANHMUC_DV_TINH = "mard.04.danhmuc.dvtinh";

        public static final String DANHMUC_HANGHOA = "mard.04.danhmuc.hanghoa";

        public static final String DANHMUC_LOAI_GIAYTO = "mard.04.danhmuc.loaigiayto";

        public static final String DANHMUC_LOAIHANG = "mard.04.danhmuc.loaihang";

        public static final String DANHMUC_LOAI_THUCAN = "mard.04.danhmuc.loaiThucan";

        public static final String DANHMUC_PHUONGTIEN = "mard.04.danhmuc.phuongtien";

        public static final String DANHMUC_QUOCGIA = "mard.04.danhmuc.quocgia";

        public static final String DANHMUC_TRANGTHAI = "mard.04.danhmuc.trangthai";

        public static final String DANHMUC_DV_TIENTE = "mard.04.danhmuc.tiente";

        public static final String DANHMUC_LOAIDON = "mard.04.danhmuc.loaidon";

        public static final String DANHMUC_LOAI_KIEMTRA = "mard.04.danhmuc.loaikiemtra";

        public static final String DANHMUC_TRANGTHAI_PHI = "mard.04.danhmuc.trangthaiphi";

        public static final String DANHMUC_PHUONGTHUC_KT = "mard.04.danhmuc.phuongthuckt";

        public static final String HOSO_SEARCH = "mard.04.hoso.timkiem";

        public static final String HOSO_GET_BYID = "mard.04.hoso.getbyidhoso";

        public static final String LICHSU_SEARCH = "mard.04.tbdlichsu.search";

        public static final String HOSO_XACNHAN_DON = "mard.04.hoso.xacnhandon";

        public static final String HOSO_GIULAI_VA_XULY = "mard.04.hoso.getdataGLXL";

        public static final String HOSO_GIAY_CNKDTV = "mard.04.hoso.getdataGiayCNKDTV";

        public static final String HOSO_GIAY_XNCL = "mard.04.hoso.getdataGiayXNCL";

        public static final String HOSO_GIAY_CNTP = "mard.04.hoso.getdataGiayCNTP";

        public static final String HOSO_GIAY_ATTP = "mard.04.hoso.getdataGiayATTP";

        public static final String HOSO_GIAY_TAMCAP = "mard.04.hoso.getdataGiayTamCap";

        public static final String HOSO_GET_THONGBAO_PHI = "mard.04.hoso.getThongBaophi";

        public static final String HOSO_GET_THONGBAO_PHI_BS = "mard.04.hoso.getThongBaophiBS";

        public static final String HOSO_XACNHAN_PHI = "mard.04.xacnhanphi.getdata";

        public static final String KQXL_SEARCH = "mard.04.kqxl.search";

        public static final String DINHKEM_GET_BYID = "mard.04.xnttp.downloaddk";

        public static final String ATTACHMENT_DOWNLOAD = "mard.04.api.download";

        public static final String ATTACHMENT_UPLOAD = "mard.04.hoso.upload";
    }

    public static interface FILE_STATUS {
        public static final Long TAO_MOI = 0L;

        public static final String TAO_MOI_STR = "Mới tạo";

        public static final String CAP_NHAT_STR = "Cập nhật";

        public static final Long CHO_TIEP_NHAN = 1L;

        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";

        public static final Long TUCHOI_HS = 2L;

        public static final String TUCHOI_HS_STR = "Từ chối hồ sơ";

        public static final Long RUT_HS = 3L;

        public static final String RUT_HS_STR = "Rút hồ sơ";

        public static final Long YC_BOSUNG_HS = 4L;

        public static final String YC_BOSUNG_HS_STR = "Yêu cầu bổ sung hồ sơ";

        public static final Long DA_BOSUNG_HS = 5L;

        public static final String DA_BOSUNG_HS_STR = "Đã bổ sung hồ sơ";

        public static final Long DA_TIEP_NHAN = 6L;

        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";

        public static final Long XINRUT_HS = 7L;

        public static final String XINRUT_HS_STR = "Xin rút hồ sơ";

        public static final Long DONG_Y_XINRUT_HS = 8L;

        public static final String DONG_Y_XINRUT_HS_STR = "Đồng ý yêu cầu xin rút hồ sơ";

        public static final Long TC_XIN_RUT = 9L;

        public static final String TC_XIN_RUT_STR = "Từ chối yêu cầu xin rút hồ sơ";

        public static final Long XINSUA_HS = 10L;

        public static final String XINSUA_HS_STR = "Xin sửa hồ sơ";

        public static final Long DONG_Y_XINSUA_HS = 11L;

        public static final String DONG_Y_XINSUA_HS_STR = "Đồng ý yêu cầu xin sửa hồ sơ";

        public static final Long TUCHOI_XINSUA_HS = 12L;

        public static final String TUCHOI_XINSUA_HS_STR = "Từ chối yêu cầu xin sửa hồ sơ";

        public static final Long XACNHAN_DON = 13L;

        public static final String XACNHAN_DON_STR = "Xác nhận đơn đăng ký";

        public static final Long THONGBAO_APPHI = 14L;

        public static final String THONGBAO_APPHI_STR = "Thông báo áp phí";

        public static final Long YCBS_PHI = 15L;

        public static final String YCBS_PHI_STR = "Thông báo bổ sung phí";

        public static final Long XACNHAN_PHI = 16L;

        public static final String XACNHAN_PHI_STR = "Xác nhận thanh toán phí";

        public static final Long DACAP_LENH = 17L;

        public static final String DACAP_LENH_STR = "Đã cấp Lệnh giữ lại và xử lý";

        public static final Long CAPGIAY_TAMCAP = 18L;

        public static final String CAPGIAY_TAMCAP_STR = "Cấp giấy tạm cấp KQKD";

        public static final Long CAPGIAY_CNKD = 19L;

        public static final String CAPGIAY_CNKD_STR = "Cấp giấy KDTV";

        public static final Long DACAP_XNCL = 20L;

        public static final String DACAP_XNCL_STR = "Đã cấp giấy XNCL";

        public static final Long DACAP_XNCL_LAN2 = 21L;

        public static final String DACAP_XNCL_LAN2_STR = "Đã cấp giấy XNCL lần 2";

        public static final Long DACAP_ATTP = 22L;

        public static final String DACAP_ATTP_STR = "Đã cấp giấy ATTP";

        public static final Long DACAP_GIULAI = 23L;

        public static final String DACAP_GIULAI_STR = "Đã cấp Lệnh giữ lại và xử lý chỉnh sửa";

        public static final Long CAPTAM_CNKD = 24L;

        public static final String CAPTAM_CNKD_STR = "Cấp giấy tạm cấp KQKD chỉnh sửa";

        public static final Long CAP_CNKD_CHINHSUA = 25L;

        public static final String CAP_CNKD_CHINHSUA_STR = "Cấp giấy KDTV chỉnh sửa";

        public static final Long DACAP_XNCL_CHINHSUA = 26L;

        public static final String DACAP_XNCL_CHINHSUA_STR = "Đã cấp giấy XNCL chỉnh sửa";

        public static final Long DACAP_XNCL_CHINHSUA_LAN2 = 27L;

        public static final String DACAP_XNCL_CHINHSUA_LAN2_STR = "Đã cấp giấy XNCL lần 2 chỉnh sửa";

        public static final Long DACAP_ATTP_CHINHSUA = 28L;

        public static final String DACAP_ATTP_CHINHSUA_STR = "Đã cấp giấy ATTP chỉnh sửa";

        public static final Long DACAP_CNTP = 29L;

        public static final String DACAP_CNTP_STR = "Đã cấp giấy KDTV & ATTP";

        public static final Long DACAP_CNTP_CHINHSUA = 30L;

        public static final String DACAP_CNTP_CHINHSUA_STR = "Đã cấp giấy KDTV & ATTP chỉnh sửa";

        public static final Long XIN_GIAHAN = 31L;

        public static final String XIN_GIAHAN_STR = "Xin gia hạn thời hạn nộp";

        public static final Long NOP_GCN_TUCONGBO = 32L;

        public static final String NOP_GCN_TUCONGBO_STR = "Nộp bổ sung giấy tờ";

        public static final Long DONGY_YC_GIAHAN = 33L;

        public static final String DONGY_YC_GIAHAN_STR = "Đồng ý yêu cầu gia hạn";

        public static final Long TUCHOI_YC_GIAHAN = 34L;

        public static final String TUCHOI_YC_GIAHAN_STR = "Từ chối yêu cầu gia hạn";

        public static final Long XN_HOANTHANH_HS = 35L;

        public static final String XN_HOANTHANH_HS_STR = "Xác nhận hoàn thành đầy đủ hồ sơ";

        public static final Long HS_CHUA_HOANTHIEN = 36L;

        public static final String HS_CHUA_HOANTHIEN_STR = "Hồ sơ chưa hoàn thiện";
    }

    public static interface MSG_TYPE {
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
    }

    public static interface MSG_FUNC {
        public static final String FUNCTION_00 = "00";

        public static final String FUNCTION_99 = "99";

        public static final String FUNCTION_01 = "01";

        public static final String FUNCTION_02 = "02";

        public static final String FUNCTION_03 = "03";

        public static final String FUNCTION_04 = "04";

        public static final String FUNCTION_05 = "05";

        public static final String FUNCTION_06 = "06";

        public static final String FUNCTION_07 = "07";

        public static final String FUNCTION_08 = "08";

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
    }

}
