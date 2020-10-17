package com.nsw.backend.mard.p01.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class Constant01 {

    public static final Long SYSTEM_ID = 1L;
    public static final String MINISTRY_NAME = "BNNPTNT";
    public static final String MINISTRY_NAME_EN = "MARD";
    public static final String MARD_PROC_CODE = "04";
    public static final Long ACTIVE = 1L;
    public static final Long IN_ACTIVE = 0L;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01AttachmentType {
        CN_VUNG_CSAT_DONG_VAT(1, "Giấy chứng nhận vùng, cơ sở an toàn dịch bệnh nơi xuất phát cửa động vật(nếu có)"),
        BS_CNTP_HOAC_PKTXN_DONG_VAT(2, "Bản sao giấy chứng nhận tiêm phòng, phiếu kết quả xét nghiệm bệnh động vật (nếu có)"),
        BS_YCVSTY_VOI_DONG_VAT(3, "Bản sao yêu cầu vệ sinh thú y của chủ hàng hoặc nước nhập khẩu đối với động vật xuất khẩu (nếu có)"),
        BS_HPMB(4, "Bản sao hợp đồng mua bán (nếu có)"),
        FILE_ND_CNKD(5, "File nội dung cần chứng nhận kiểm dịch (nếu có)"),
        GTK(6, "Các giấy tờ khác có liên quan (nếu có)");

        private int id;
        private String attachmentTypeCode;

        Hoso01AttachmentType(int id, String attachmentTypeCode) {
            this.id = id;
            this.attachmentTypeCode = attachmentTypeCode;
        }

        public static Constant01.Hoso01AttachmentType findById(int i) {
            return Arrays.stream(Constant01.Hoso01AttachmentType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01PHuongTienVanChuyen {
        HANG_KHONG(1, "Hàng không/Aeroplane / 飞机"),
        DUONG_SAT(2, "Đường sắt /Railway Wagon / 铁路货车"),
        DUONG_BO(3, "Đường bộ/Road vehicle / 公路车辆"),
        DUONG_THUY(4, "Đường thủy /Ship/船舶 "),
        PHUONG_TIEN_KHAC(5, "Phương tiện khác/Other/其他  ");

        private int id;
        private String name;

        Hoso01PHuongTienVanChuyen(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Constant01.Hoso01PHuongTienVanChuyen findById(int i) {
            return Arrays.stream(Constant01.Hoso01PHuongTienVanChuyen.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01MaBoNganh {
        BTC(1, "BTC", "Bộ Tài chính"),
        BCT(2, "BCT", "Bộ Công thương"),
        BGTVT(3, "BGTVT", "Bộ Giao thông vận tải"),
        BYTE(4, "BYTE", "Bộ Y tế"),
        BNN_PTNT(5, "BNN&PTNT", "Bộ Nông nghiệp và Phát triển nông thôn"),
        BTN_MT(6, "BTN&MT", "Bộ Tài nguyên và Môi trường"),
        BQP(7, "BQP", "Bộ Quốc Phòng");


        private int id;
        private String code;
        private String name;

        Hoso01MaBoNganh(int id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }

        public static Constant01.Hoso01MaBoNganh findById(int i) {
            return Arrays.stream(Constant01.Hoso01MaBoNganh.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01HangHoa {
        HH01(1, "HH01", "Hàng hóa fake 1"),
        HH02(2, "HH02", "Hàng hóa fake 2"),
        HH03(3, "HH03", "Hàng hóa fake 3"),
        HH04(4, "HH04", "Hàng hóa fake 4");

        private int id;
        private String code;
        private String name;

        Hoso01HangHoa(int id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }

        public static Constant01.Hoso01HangHoa findById(int i) {
            return Arrays.stream(Constant01.Hoso01HangHoa.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01Status {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận"),
        DA_TIEP_NHAN(2, "Đã tiếp nhận"),
        DA_CAP_GIAY_CNKD(3, "Đã cấp giấy chứng nhận"),
        YC_SUA_DOI_BO_XUNG(4, "Yêu cầu sửa đổi bổ sung"),
        //        CHO_TIEP_NHAN_BO_SUNG(5, "Chờ tiếp nhận hồ sơ bổ sung"),//bo phan tiep nhan
        BI_TU_CHOI(6, "Bị từ chối"),
        CHO_TIEP_NHAN_SUA_HS(7, "Chờ tiếp nhận yêu cầu sửa hồ sơ"),//chuyen viens
        DONG_Y_SUA_HS(8, "Đồng ý sửa"),
        YC_RUT_HS(9, "Yêu cầu rút hồ sơ"),
        DA_RUT_HS(10, "Đã rút hồ sơ"),
        YC_SUA_GIAY_CNKD(11, "Chờ tiếp nhận yêu cầu chỉnh sửa GCN"),
        YC_HUY_GIAY_CNKD(15, "Chờ tiếp nhận yêu cầu hủy GCN"),
        //        DONG_Y_SUA_GIAY_CNKD(12, "Đồng ý sửa giấy chứng nhận"),
        DONG_Y_HUY_GIAY_CNKD(13, "Đồng ý hủy giấy chứng nhận"),
        LO_HANG_KHONG_DAT(14, "Lô hàng không đạt chất lượng"),
        TU_CHOI_RUT_HS(16, "Từ chối rút"),
        TU_CHOI_SUA_HS(17, "Từ chối sửa hồ sơ");

        private int id;
        private String name;

        Hoso01Status(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Constant01.Hoso01Status findById(int i) {
            return Arrays.stream(Constant01.Hoso01Status.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01pPaymentStatus {
        INIT(-1, ""),
        TB_AP_PHI(1, "Thông báo áp phí"),
        XAC_NHAN_THANH_TOAN_PHI(2, "Xác nhận đã thanh toán phi"),
        YC_NOP_PHI_BO_XUNG(3, "Yêu cầu nộp phí bổ xung"),
        DA_CHUYEN_KHOAN_BO_XUNG(4, "Đã chuyển khoản bổ xung");

        private int id;
        private String name;

        Hoso01pPaymentStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Constant01.Hoso01pPaymentStatus findById(int i) {
            return Arrays.stream(Constant01.Hoso01pPaymentStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01LicenseType {

        MAU_13A(1, "13A"),
        MAU_13B(2, "13B"),
        MAU_HK_PIG(3, "Hong Kong Pig Product"),
        MAU_MALAY_SPDV(4, "Malaysia Animal Product"),
        MAU_HK_CHICKEN(5, "Hong Kong Chicken Product"),
        MAU_TQ_SPDV(6, "China Animal Product");

        private int id;
        private String name;

        Hoso01LicenseType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Constant01.Hoso01LicenseType findById(int i) {
            return Arrays.stream(Constant01.Hoso01LicenseType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso01DeleteStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu hủy"),
        TU_CHOI_YEU_CAU(4, "Từ chối yêu cầu hủy"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu hủy");
        private int id;
        private String name;

        Hoso01DeleteStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso01DeleteStatus findById(int i) {
            return Arrays.stream(Hoso01DeleteStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    public interface MessageFunction {
        // Chức năng
        String FUNC_01 = "01";
        String FUNC_02 = "02";
        String FUNC_03 = "03";
        String FUNC_04 = "04";
        String FUNC_05 = "05";
        String FUNC_06 = "06";
        String FUNC_07 = "07";
        String FUNC_08 = "08";
        String FUNC_09 = "09";
        String FUNC_10 = "10";
        String FUNC_11 = "11";
        String FUNC_12 = "12";
        String FUNC_13 = "13";
        String FUNC_14 = "14";
        String FUNC_15 = "15";
        String FUNC_16 = "16";
        String FUNC_17 = "17";
        String FUNC_18 = "18";
        String FUNC_19 = "19";
        String FUNC_20 = "20";
        String FUNC_21 = "21";
        String FUNC_22 = "22";
        String FUNC_23 = "23";
        String FUNC_24 = "24";
        String FUNC_25 = "25";
        String FUNC_26 = "26";
        String FUNC_27 = "27";
        String FUNC_28 = "28";
        String FUNC_29 = "29";
        String FUNC_30 = "30";
        String FUNC_31 = "31";
        String FUNC_32 = "32";
        String FUNC_33 = "33";
        String FUNC_34 = "34";
        String FUNC_35 = "35";
        String FUNC_36 = "36";
        String FUNC_37 = "37";
        String FUNC_38 = "38";
        String FUNC_39 = "39";
        String FUNC_40 = "40";
        String FUNC_41 = "41";
        String FUNC_42 = "42";
        String FUNC_43 = "43";
        String FUNC_44 = "44";
        String FUNC_45 = "45";
        String FUNC_46 = "46";
        String FUNC_47 = "47";
        String FUNC_48 = "48";
        String FUNC_49 = "49";
        String FUNC_50 = "50";
        String FUNC_51 = "51";
        String FUNC_52 = "52";
        String FUNC_53 = "53";
        String FUNC_54 = "54";
        String FUNC_55 = "55";
        String FUNC_56 = "56";
        String FUNC_57 = "57";
    }

    public interface MessageType { // Loại chứng từ Response - Request

        String TYPE_10 = "10";  // [NSW--> BNN] Hồ sơ yêu cầu cấp giấy chứng nhận kiểm dịch
        String TYPE_11 = "11";  // [NSW--> BNN] DN xin rút hồ sơ khi BNN chưa xử lý hồ sơ
        String TYPE_12 = "12";  // BNN: Trả kết quả thẩm định hồ sơ - yêu cầu bổ sung thông tin
        String TYPE_13 = "13";  // BNN: gửi kết quả thẩm định hồ sơ: đã tiếp nhận hồ sơ
        String TYPE_14 = "14";  // [NSW--> BNN] DN gửi yêu cầu xin sửa hồ sơ (sau khi BNN tiếp nhận)
        String TYPE_15 = "15";  // BNN: Trả kết quả yêu cầu xin rút: Đồng ý/Từ chối
        String TYPE_16 = "16";  // [NSW--> BNN] DN xin rút hồ sơ
        String TYPE_17 = "17";  // BNN: Thông báo kết quả đồng ý/từ chối yêu cầu xin rút hồ sơ
        String TYPE_18 = "18";  // BNN: Thông báo áp phí
        String TYPE_19 = "19";  // [NSW--> BNN]Đã nộp phí
        String TYPE_20 = "20";  // BNN: Gửi giấy CNKD mẫu 13a
        String TYPE_21 = "21";  // BNN: Gửi giấy CNKD mẫu 13b
        String TYPE_22 = "22";  // BNN: Gửi giấy CNKD mẫu Hong Kong (sản phẩm thịt lợn)
        String TYPE_23 = "23";  // BNN: Gửi giấy CNKD mẫu Malaysia
        String TYPE_24 = "24";  // BNN: Gửi giấy CNKD mẫu Hong Kong (sản phẩm thịt gà)
        String TYPE_25 = "25";  // BNN: Gửi giấy CNKD mẫu Trung Quốc
        String TYPE_26 = "26";  // BNN: BNN gửi công văn thông báo kết quả không đạt yêu cầu xuất khẩu
        String TYPE_27 = "27";  // [NSW--> BNN] DN gửi yêu cầu xin hủy GCN
        String TYPE_28 = "28";  // BNN: gửi trả kết quả từ chối/ đồng ý yêu cầu xin hủy GCN
        String TYPE_29 = "29";  // [NSW--> BNN] DN gửi yêu cầu chỉnh sửa CNKD
        String TYPE_30 = "30";  // BNN: gửi thông báo từ chối chỉnh sửa CNKD
    }

    public static class WebServiceURL {
        private static final String WS_URL = "send/01/sendAll/";

        private WebServiceURL() {
        }

        public static String get(Environment environment) {
            return environment.getRequiredProperty("SEND_WS_ROOT_URL") + WS_URL;
        }
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
