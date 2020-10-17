package com.nsw.backend.mard.p26.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;

public class Constant26 {
    public static final Long SYSTEM_ID = 25L;
    public static final String MINISTRY_NAME = "BNNPTNT";
    public static final String MARD_PROC_CODE = "25";

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
}
