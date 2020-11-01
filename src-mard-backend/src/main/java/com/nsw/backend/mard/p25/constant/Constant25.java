/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p25.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class Constant25 {

    public static final Long SYSTEM_ID = 25L;
    public static final String MINISTRY_NAME = "BNNPTNT";
    public static final String MARD_PROC_CODE = "25";

    public static final Long ACTIVE = 1L;
    public static final Long IN_ACTIVE = 0L;
    public static final Integer NSW_SEND=1;
    public static final Integer BNN_SEND=2;
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
        TAO_MOI(0,"Tạo mới"),
        CHO_TIEP_NHAN(1,"Chờ tiếp nhận"),
        CHO_TIEP_NHAN_HS_GUI_BS_BPMC(2,"Chờ tiếp nhận hồ sơ gửi bổ sung theo BPMC"),
        CHO_TIEP_NHAN_HS_GUI_BS_TACN(3,"Chờ tiếp nhận hồ sơ gửi bổ sung theo phòng TACN"),
        DA_BAO_CAO_MIEN_GIAM(5,"Đã báo cáo miễn giảm"),
        CHO_KQ_DANH_GIA_SPH(27,"Chờ kết quả đánh giá sự phù hợp"),
        CHO_TIEP_NHAN_KQ_DANH_GIA_SPH(29,"Chờ tiếp nhận kết quả đánh giá sự phù hợp"),
        CHO_TIEP_NHAN_KQ_DANH_GIA_SPH_GUI_BS_BPMC(30,"Chờ tiếp nhận kết quả đánh giá sự phù hợp gửi bổ sung theo BPMC"),
        CHO_TIEP_NHAN_KQ_DANH_GIA_SPH_GUI_BS_TACN(31,"Chờ tiếp nhận kết quả đánh giá sự phù hợp gửi bổ sung theo phòng TACN"),
        DA_RUT_HO_SO(45,"Đã rút hồ sơ"),
        DA_TU_CHOI_CAP_GDK(21,"Đã từ chối cấp GĐK"),
        DA_XAC_NHAN_GDK(26,"Đã xác nhận GĐK"),
        DA_TIEP_NHAN_KQ_DANH_GIA_SPH(32,"Đã tiếp nhận kết quả đánh giá sự phù hợp"),
        BPMC_YCBS_KQ_DANH_GIA_SPH(33,"BPMC yêu cầu bổ sung kết quả đánh giá sự phù hợp"),
        TACN_YCBS_KQ_DANH_GIA_SPH(38,"Phòng TACN yêu cầu bổ sung kết quả đánh giá sự phù hợp"),
        DA_THU_HOI_TB_KQ_KIEM_TRA(47,"Đã thu hồi thông báo kết quả kiểm tra"),
        BPMC_YCBS_HO_SO(9,"BPMC yêu cầu bổ sung hồ sơ"),
        TACN_YCBS_HO_SO(15,"Phòng TACN yêu cầu bổ sung hồ sơ"),
        DA_TU_CHOI(8,"Đã từ chối"),
        DA_TIEP_NHAN(7,"Đã tiếp nhận"),
        DA_CO_KQ_DANH_GIA_SPH(28,"Đã có kết quả đánh giá sự phù hợp");



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
        private static final String WS_URL = "send/25/sendAll/";

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
    public interface FILE_DINHKEM_TYPE {
        public static final int HOP_DONG = 1;
        public static final int HOA_DON = 2;
        public static final int PHIEU_DG = 3;
        public static final int KHAC = 10;
    }
}
