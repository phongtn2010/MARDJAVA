/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p07.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class Constant07 {

    public static final Long SYSTEM_ID = 7L;
    public static final String MINISTRY_NAME = "BNNPTNT";
    public static final String MARD_PROC_CODE = "10";

    public static final Long ACTIVE = 1L;
    public static final Long IN_ACTIVE = 0L;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum PurposeType {
        KINH_DOANH_THUC_PHAM("KDTP", "Kinh doanh thực phẩm"),
        LAM_GIONG_THUONG_PHAM("GTP", "Làm giống nuôi thương phẩm"),
        LAM_GIONG_BO_ME("GBM", "Làm giống bố mẹ"),
        THU_CONG_MI_NGHE("TCMN", "Làm thủ công mĩ nghệ"),
        LAM_CANH("CANH", "Làm cảnh"),
        CHE_BIEN_THUC_PHAM("CBTP", "Chế biến thực phẩm"),
        MUC_DICH_KHAC("KHAC", "Khác");
        private String code;
        private String name;

        PurposeType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static PurposeType findByCode(String code) {
            return Arrays.stream(PurposeType.values()).filter(t -> t.getCode().equals(code)).findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum HosoType {
        DKKD_DONG_VAT(1, "Đăng ký kiểm dịch đông vật thủy sản"),
        DKKD_SP_DONGVAT(2, "Đăng ký kiểm dịch sản phẩm động vật thủy sản");
        private int id;
        private String name;

        HosoType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static HosoType findById(int i) {
            return Arrays.stream(HosoType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum CongVanType {
        VE_SINH_THU_Y(1, "Vệ sinh thú y"),
        KIEM_DICH_NHAP_KHAU(2, "Kiểm dịch nhập khẩu");
        private int id;
        private String name;

        CongVanType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static HosoType findById(int i) {
            return Arrays.stream(HosoType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum HosoStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận"),
        DA_RUT_HO_SO(2, "Đã rút hồ sơ"),
        DA_TIEP_NHAN(3, "Đã tiếp nhận"),
        TU_CHOI_HO_SO(4, "Từ chối hồ sơ"),
        YEU_CAU_BO_SUNG(7, "Yêu cầu sửa đổi bổ sung"),
        CHO_TIEP_NHAN_YCS(8, "Chờ tiếp nhận yêu cầu sửa"),
        DONG_Y_YCS(9, "Đồng ý yêu cầu sửa"),
        TU_CHOI_YCS(10, "Từ chối yêu cầu sửa"),
        CHO_TIEP_NHAN_YCR(11, "Chờ tiếp nhận yêu cầu rút"),
        TU_CHOI_YCR(13, "Từ chối yêu cầu rút"),
        DA_CAP_GVC(14, "Đã cấp giấy chứng nhận vận chuyển"),
        DA_CAP_GCNKD(15, "Đã cấp giấy chứng nhận kiểm dịch"),
        LO_HANG_KHONG_DAT(16, "Lô hàng không đạt chất lượng"),
        DA_XM_DON_DANG_KY(17, "Đã xác nhận đơn đăng ký");

        private int id;
        private String name;

        HosoStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static HosoStatus findById(int i) {
            return Arrays.stream(HosoStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum HosoDeleteStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu hủy"),
        TU_CHOI_YEU_CAU(4, "Từ chối yêu cầu hủy"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu hủy");
        private int id;
        private String name;

        HosoDeleteStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static HosoDeleteStatus findById(int i) {
            return Arrays.stream(HosoDeleteStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum HosoEditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu sửa"),
        DA_TIEP_NHAN(2, "Đã tiếp nhận yêu cầu sửa"),
        TU_CHOI_YEU_CAU(4, "Từ chối yêu cầu sửa"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu sửa");
        private int id;
        private String name;

        HosoEditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static HosoEditStatus findById(int i) {
            return Arrays.stream(HosoEditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Cvvsty06EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ xem xét sửa công văn"),
        LDP_DONG_Y_SUA(2, "Lãnh đạo phòng đồng ý sửa công văn"),
        LDP_TU_CHOI_SUA(3, "Lãnh đạo phòng từ chối sửa công văn"),
        LDC_DONG_Y_SUA(4, "Lãnh đạo cục phê duyệt sửa công văn"),
        LDC_TU_CHOI_SUA(5, "Lãnh đạo cục từ chối sửa công văn");
        private int id;
        private String name;

        Cvvsty06EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Cvvsty06EditStatus findById(int i) {
            return Arrays.stream(Cvvsty06EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum AttachedDocuments {
        BAN_SAO_GCNKDXK(1, "Bản sao mẫu Giấy chứng nhận kiểm dịch xuất khẩu của cơ quan thẩm quyền nước xuất khẩu có xác nhận của doanh nghiệp "),
        BAN_SAO_GP_CITES(2, "Bản sao Giấy phép CITES có xác nhận của doanh nghiệp "),
        BAN_SAO_GPNKTS(3, "Bản sao Giấy phép nhập khẩu thủy sản của Tổng cục Thủy sản có xác nhận của doanh nghiệp ");

        private int id;
        private String name;

        AttachedDocuments(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static AttachedDocuments findById(int i) {
            return Arrays.stream(AttachedDocuments.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Cvcnkd06EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ xem xét sửa công văn"),
        LDP_DONG_Y_SUA(2, "Lãnh đạo phòng đồng ý sửa công văn"),
        LDP_TU_CHOI_SUA(3, "Lãnh đạo phòng từ chối sửa công văn"),
        LDC_DONG_Y_SUA(4, "Lãnh đạo cục phê duyệt sửa công văn"),
        LDC_TU_CHOI_SUA(5, "Lãnh đạo cục từ chối sửa công văn");
        private int id;
        private String name;

        Cvcnkd06EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Cvcnkd06EditStatus findById(int i) {
            return Arrays.stream(Cvcnkd06EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum PayStatus {
        DA_XAC_NHAN_DON_DK(1, "Đã xác nhận đơn đăng ký"),
        DA_GUI_TB_AP_PHI(2, "Đã gửi thông báo áp phí"),
        DA_GUI_YCTT_PHI(3, "Đã gửi yêu cầu thanh toán phí"),
        DA_XAC_NHAN_TT_PHI(4, "Đã xác nhận thanh toán phí");

        private int id;
        private String name;

        PayStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso06AttachedDocType {
        DKKD_DONG_VAT(1, "Đăng ký kiểm dịch đông vật"),
        DKKD_SP_DONGVAT(2, "Đăng ký kiểm dịch sản phẩm động vật"),
        DKKD_BOT_THIT_XUONG(3, "Đăng ký kiểm dịch bột thịt xương"),
        DKKD_XNCL(4, "Đăng ký kiểm tra xác nhận chất lượng");
        private int id;
        private String name;

        Hoso06AttachedDocType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso06AttachedDocType findById(int i) {
            return Arrays.stream(Hoso06AttachedDocType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum AttachmentType {
        GCN_KD_NUOC_XK(1, "Giấy chứng nhận kiểm dịch của nước xuất khẩu"),
        VAN_TAI_DON_TAU(2, "Vận tải đơn tàu");
        private int id;
        private String name;

        AttachmentType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static AttachmentType findById(int i) {
            return Arrays.stream(AttachmentType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum UnitType {
        TAN(1, "TAN", "Tấn"),
        CON(1, "CON", "Con"),
        QUA(1, "QUA", "Quả"),
        KHAC(1, "KHAC", "Khác");
        private int id;
        private String code;
        private String packageUnitName;

        UnitType(int id, String code, String packageUnitName) {
            this.id = id;
            this.code = code;
            this.packageUnitName = packageUnitName;
        }

        public static UnitType findById(int i) {
            return Arrays.stream(UnitType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum OrganizationType {
        A(1, "A", "Cơ quan thú y vùng I", "Hà Nội"),
        B(2, "B", "Cơ quan thú y vùng II", "Hải Phòng"),
        C(3, "C", "Cơ quan thú y vùng III", "Nghệ An"),
        D(4, "D", "Cơ quan thú y vùng IV", "Đà Nẵng"),
        E(5, "E", "Cơ quan thú y vùng V", "Đắk Lắk"),
        F(6, "F", "Cơ quan thú y vùng VI", "Hồ Chí Minh"),
        G(7, "G", "Cơ quan thú y vùng VII", "Cần Thơ"),
        H(8, "H", "Chi cục KDĐV vùng quảng ninh", "Quảng Ninh"),
        I(9, "I", "Chi cục KDĐV vùng Lào Cai", "Lào Cai"),
        K(10, "K", "Chi cục KDĐV vùng Lạng Sơn", "Lạng Sơn");
        private int id;
        private String code;
        private String name;
        private String address;

        OrganizationType(int id, String code, String name, String address) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.address = address;
        }

        public static OrganizationType findById(int i) {
            return Arrays.stream(OrganizationType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum CertEditStatus {
        KHOI_TAO(0, ""),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu sửa"),
        CHO_THUC_HIEN(3, "Chờ phản hồi sửa GP khác"),
        TU_CHOI_YEU_CAU(2, "Từ chối yêu cầu sửa");
        private int id;
        private String name;

        CertEditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class WebServiceURL {
        private static final String WS_URL = "send/07/sendAll/";

        private WebServiceURL() {
        }

        public static String get(Environment environment) {
            return environment.getRequiredProperty("SEND_WS_ROOT_URL") + WS_URL;
        }
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MessageFunction {
        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_04 = "04";
        public static final String FUNC_05 = "05";
        public static final String FUNC_06 = "06";
        public static final String FUNC_07 = "07";
        public static final String FUNC_08 = "08";
        public static final String FUNC_09 = "09";
        public static final String FUNC_10 = "10";
        public static final String FUNC_11 = "11";
        public static final String FUNC_12 = "12";
        public static final String FUNC_13 = "13";
        public static final String FUNC_14 = "14";
        public static final String FUNC_15 = "15";
        public static final String FUNC_16 = "16";
        public static final String FUNC_17 = "17";
        public static final String FUNC_18 = "18";
        public static final String FUNC_19 = "19";
        public static final String FUNC_20 = "20";
        public static final String FUNC_21 = "21";
        public static final String FUNC_22 = "22";
        public static final String FUNC_23 = "23";
        public static final String FUNC_24 = "24";
        public static final String FUNC_61 = "61";
        public static final String FUNC_00 = "00";
        public static final String FUNC_99 = "99";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MessageType { // Loại chứng từ Response - Request
        public static final String TYPE_10 = "10";  // [NSW--> BNN]Gửi, sửa, bổ sung hồ sơ
        public static final String TYPE_11 = "11";  // Trả kết quả thẩm định hồ sơ
        public static final String TYPE_12 = "12";  // [NSW--> BNN]Rút hồ sơ (trc khi BNN tiếp nhận)
        public static final String TYPE_13 = "13";  // [NSW--> BNN]Gửi yêu cầu xin rút hồ sơ (sau khi BNN tiếp nhận)
        public static final String TYPE_14 = "14";  // Trả kết quả yêu cầu xin rút: Đồng ý/Từ chối
        public static final String TYPE_15 = "15";  // [NSW--> BNN]Gửi yêu cầu xin sửa hồ sơ (sau khi BNN tiếp nhận)
        public static final String TYPE_16 = "16";  // Trả kết quả yêu cầu xin sửa: Đồng ý/Từ chối
        public static final String TYPE_17 = "17";  // Ban hành công văn VSTY
        public static final String TYPE_18 = "18";  // Ban hành công văn KDNK
        public static final String TYPE_19 = "19";  // Gửi kết quả VSTY
        public static final String TYPE_20 = "20";  // Gửi kết quả VSTY
        public static final String TYPE_21 = "21";  // Gửi kết quả VSTY
        public static final String TYPE_22 = "22";  // Gửi kết quả VSTY
        public static final String TYPE_23 = "23";  // Gửi kết quả VSTY
    }

    public interface SENDER {
        String CODE = "NSW";
        String NAME = "Cổng thông tin một cửa quốc gia";
    }

    public interface RECEIVER {
        String CODE = "BNN";
        String NAME = "Bộ nông nghiệp và PT nông thôn";
    }
}