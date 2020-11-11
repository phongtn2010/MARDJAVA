package com.nsw.backend.mard.p26.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsw.backend.mard.p25.constant.Constant25;
import lombok.Getter;

import java.util.Arrays;

public class Constant26 {
    public static final Long SYSTEM_ID = 25L;
    public static final String MINISTRY_NAME = "BNN";
    public static final String NSWFILECODE = "MGK";
    public static final String MARD_PROC_CODE = "26";

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
}
