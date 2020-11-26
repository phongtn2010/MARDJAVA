package com.nsw.backend.mard.p26.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsw.backend.mard.p25.constant.Constant25;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class Constant26 {
    public static final Long SYSTEM_ID = 25L;
    public static final String MINISTRY_NAME = "BNN";
    public static final String NSWFILECODE = "MGK";
    public static final String MARD_PROC_CODE = "26";

    public static final Long ACTIVE = 1L;
    public static final boolean _ACTIVE = true;
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
        GIA_CONG_CHE_BIEN_XK("CBXK", "Làm nguyên liệu gia công chế biến xuất khẩu"),
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
    public enum HosoStatus {
        TAO_MOI(0,"Tạo mới"),
        CHO_TIEP_NHAN(1,"Chờ tiếp nhận"),
        DA_TIEP_NHAN(2,"Đã tiếp nhận"),
        DA_CAP_CONG_VAN_MIEN_GIAM(4,"Đã cấp công văn miễn giảm"),
        DA_THU_HOI_CONG_VAN_MIEN_GIAM(6,"Đã thu hồi công văn miễn giảm");
        private int id;
        private String name;

        HosoStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Constant25.HosoStatus findById(int i) {
            return Arrays.stream(Constant25.HosoStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
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
        public static final String FUNC_17 = "17";
        public static final String FUNC_18 = "18";
        public static final String FUNC_19 = "19";
        public static final String FUNC_20 = "20";
        public static final String FUNC_21 = "21";
        public static final String FUNC_22 = "22";
        public static final String FUNC_23 = "23";
        public static final String FUNC_24 = "24";
        public static final String FUNC_25 = "25";
        public static final String FUNC_26 = "26";
        public static final String FUNC_27 = "27";
        public static final String FUNC_28 = "28";
        public static final String FUNC_00 = "00";
        public static final String FUNC_99 = "99";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MessageType { // Loại chứng từ Response - Request
        public static final String TYPE_10 = "10";  // Hồ sơ đăng ký kiểm tra xác nhận thức ăn chăn nuôi nhập khẩu
        public static final String TYPE_11 = "11";  // Yêu cầu huỷ hồ sơ của doanh nghiệp
        public static final String TYPE_12 = "12";  // Thông tin xử lý hồ sơ của cán bộ
        public static final String TYPE_13 = "13";  // Thông tin xác nhận đơn đăng ký kiểm tra xác nhận
        public static final String TYPE_14 = "14";  // BNN gửi thông báo thu hồi Giấy đăng ký xác nhận chất lượng
        public static final String TYPE_15 = "15";  // Hồ sơ tổ chức chỉ định
        public static final String TYPE_16 = "16";  // Kết quả đánh giá sự phù hợp
        public static final String TYPE_17 = "17";  // Nộp kết quả đánh giá sự phù hợp quy chuẩn kỹ thuật
        public static final String TYPE_18 = "18";  // Thông báo kết quả tiếp nhận kết quả
        public static final String TYPE_19 = "19";  // Giấy xác nhận chất lượng
        public static final String TYPE_20 = "20";  // BNN gửi thông báo thu hồi Giấy phép xác nhận chất lượng
        public static final String TYPE_21 = "21";  // NSW gửi kết quả báo cáo
        public static final String TYPE_22 = "22";  // BNN gửi thông báo đã tiếp nhận hồ sơ miễn giảm
        public static final String TYPE_23 = "23";  // BNN gửi thông tin phân nhóm hàng hóa
        public static final String TYPE_24 = "24";  // BNN gửi thông tin loại hàng hóa
        public static final String TYPE_25 = "25";  // BNN gửi thông tin phân loại
    }
    public static class WebServiceURL {
        private static final String WS_URL = "send/26/sendAll/";

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
}
