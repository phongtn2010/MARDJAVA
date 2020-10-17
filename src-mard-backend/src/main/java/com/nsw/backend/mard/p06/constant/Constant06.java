/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p06.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class Constant06 {

    public static final Long SYSTEM_ID = 6L;
    public static final String MINISTRY_NAME = "BNNPTNT";
    public static final String MARD_PROC_CODE = "09";

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
        DA_CAP_CV_VSTY(14, "Đã cấp CV VSTY"),
        DA_CAP_CV_KDNK(15, "Đã cấp CV KDNK"),
        DA_CO_KQ_VSTY(16, "Đã có kết quả VSTY");

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
    }

    public static class WebServiceURL {
        private static final String WS_URL = "send/06/sendAll/";

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
