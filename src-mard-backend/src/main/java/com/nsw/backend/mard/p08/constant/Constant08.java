/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Constant08 {

    public static final Long SYSTEM_ID = 8L;
    public static final String MINISTRY_NAME = "BNNPTNT";
    public static final String MINISTRY_NAME_EN = "MARD";
    public static final String MARD_PROC_CODE = "11";

    public static final Long ACTIVE = 1L;
    public static final Long IN_ACTIVE = 0L;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso08Type {
        DKKD_DONG_VAT(1, "Đăng ký kiểm dịch đông vật"),
        DKKD_SP_DONG_VAT(2, "Đăng ký kiểm dịch sản phẩm động vật"),
        DKKD_BOT_THIT_XUONG(3, "Đăng ký kiểm dịch bột thịt xương"),
        DKKD_XNCL_DV(4, "Đăng ký kiểm tra xác nhận chất lượng đồng thời cho động vật"),
        DKKD_XNCL_SP_DONG_VAT(5, "Đăng ký kiểm tra xác nhận chất lượng đồng thời Sản phẩm động vật");
        private int id;
        private String name;

        Hoso08Type(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso08Type findById(int i) {
            return Arrays.stream(Hoso08Type.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso08Status {
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
        DA_CAP_GP_VSTY(14, "Đã cấp CV VSTY"),
        DA_CAP_GP_KDNK(15, "Đã cấp CV KDNK"),
        DA_CO_KQ_VSTY(16, "Đã có kết quả VSTY");

        private int id;
        private String name;

        Hoso08Status(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso08Status findById(int i) {
            return Arrays.stream(Hoso08Status.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso08DeleteStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu hủy"),
        TU_CHOI_YEU_CAU(4, "Từ chối yêu cầu hủy"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu hủy");
        private int id;
        private String name;

        Hoso08DeleteStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso08DeleteStatus findById(int i) {
            return Arrays.stream(Hoso08DeleteStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso08EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu sửa"),
        DA_TIEP_NHAN(2, "Đã tiếp nhận yêu cầu sửa"),
        TU_CHOI_YEU_CAU(4, "Từ chối yêu cầu sửa"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu sửa");
        private int id;
        private String name;

        Hoso08EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso08EditStatus findById(int i) {
            return Arrays.stream(Hoso08EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Cvvsty08EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ xem xét sửa công văn"),
        LDP_DONG_Y_SUA(2, "Lãnh đạo phòng đồng ý sửa công văn"),
        LDP_TU_CHOI_SUA(3, "Lãnh đạo phòng từ chối sửa công văn"),
        LDC_DONG_Y_SUA(4, "Lãnh đạo cục phê duyệt sửa công văn"),
        LDC_TU_CHOI_SUA(5, "Lãnh đạo cục từ chối sửa công văn");
        private int id;
        private String name;

        Cvvsty08EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Cvvsty08EditStatus findById(int i) {
            return Arrays.stream(Cvvsty08EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Cvcnkd08EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ xem xét sửa công văn"),
        LDP_DONG_Y_SUA(2, "Lãnh đạo phòng đồng ý sửa công văn"),
        LDP_TU_CHOI_SUA(3, "Lãnh đạo phòng từ chối sửa công văn"),
        LDC_DONG_Y_SUA(4, "Lãnh đạo cục phê duyệt sửa công văn"),
        LDC_TU_CHOI_SUA(5, "Lãnh đạo cục từ chối sửa công văn");
        private int id;
        private String name;

        Cvcnkd08EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Cvcnkd08EditStatus findById(int i) {
            return Arrays.stream(Cvcnkd08EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso08AttachedDocType {
        HOP_DONG_MUA_BAN(1, "Hợp đồng mua bán"),
        HOA_DON_MUA_BAN(2, "Hóa đơn mua bán"),
        PHIEU_DONG_GOI(3, "Phiếu đóng gói");
        private int id;
        private String name;

        Hoso08AttachedDocType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso08AttachedDocType findById(int i) {
            return Arrays.stream(Hoso08AttachedDocType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    private static final String TYPE_20 = "20";
    private static final String TYPE_20A = "20A";

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum AttachmentType {
        GIAY_CNKD_NUOC_XUAT_20(1, "Bản sao mẫu giấy CNKD của nước xuất", TYPE_20),
        GIAY_CNKD_NUOC_XUAT_20A(1, "Bản sao mẫu giấy CNKD của nước xuất", TYPE_20A),
        HOP_DONG_MUA_BAN(2, "Hợp đồng mua bán", TYPE_20A),
        PHIEU_DONG_GOI(3, "Phiếu đóng gói", TYPE_20A),
        HOA_DON_MUA_BAN(4, "Hóa đơn mua bán", TYPE_20A),
        KQ_PTCL_NUOC_XUAT(5, "Kết quả phân tích chất lượng của nước xuất xứ cấp cho lô hàng", TYPE_20A),
        HANG_SAN_PHAM_NSX(6, "Hãng sản phẩm của Nhà sản xuất", TYPE_20A),
        TIEU_CHUAN_DVNK(7, "Bản tiêu chuẩn công bố áp dụng của ĐV nhập khẩu", TYPE_20A),
        TAI_LIEU_KHAC_20A(8, "Tài liệu khác", TYPE_20),
        TAI_LIEU_KHAC_20(8, "Tài liệu khác", TYPE_20A);

        private int id;
        private String name;
        private String type;

        AttachmentType(int id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public static AttachmentType findById(int i) {
            return Arrays.stream(AttachmentType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }

        public static List<AttachmentType> getListByType(String type) {
            return Arrays.stream(AttachmentType.values()).filter(st -> st.getType().equals(type))
                    .collect(Collectors.toList());
        }
    }

    public interface FileUpload {
        String URL_UPLOAD = "/file/upload";
        String URL_DOWNLOAD = "/file/download";
    }

    public interface MessageFunction {  // Chức năng

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
    }

    public interface MessageType { // Loại chứng từ Response - Request

        String TYPE_10 = "10";  // [NSW--> BNN]Gửi, sửa, bổ sung hồ sơ
        String TYPE_11 = "11";  // [NSW--> BNN]Rút hồ sơ (trc khi BNN tiếp nhận)
        String TYPE_12 = "12";  // Trả kết quả thẩm định hồ sơ
        String TYPE_13 = "13";  // Xác nhận đơn khai báo kiểm dịch
        String TYPE_14 = "14";  // [NSW--> BNN]Gửi yêu cầu xin rút hồ sơ (sau khi BNN tiếp nhận)
        String TYPE_15 = "15";  // Trả kết quả yêu cầu xin rút: Đồng ý/Từ chối
        String TYPE_16 = "16";  // [NSW--> BNN]Gửi yêu cầu xin sửa hồ sơ (sau khi BNN tiếp nhận)
        String TYPE_17 = "17";  // Trả kết quả yêu cầu xin sửa: Đồng ý/Từ chối
        String TYPE_18 = "18";  // Thông báo áp phí
        String TYPE_19 = "19";  // [NSW--> BNN]Đã nộp phí
        String TYPE_20 = "20";  // Yêu cầu thanh toán bổ sung
        String TYPE_21 = "21";  // Lô hàng cần xử lý
        String TYPE_22 = "22";  // Quyết định xử lý vệ sinh thú y (mẫu 9)
        String TYPE_23 = "23";  // Cấp/sửa GCN - mẫu 14a
        String TYPE_24 = "24";  // Cấp/sửa GCN - mẫu 14b
        String TYPE_25 = "25";  // Cấp/sửa GCN - mẫu 15a
        String TYPE_26 = "26";  // Cấp/sửa GCN - mẫu 15b
        String TYPE_27 = "27";  // Cấp/sửa GCN - mẫu 15c
        String TYPE_28 = "28";  // [NSW--> BNN]Doanh nghiệp xin sửa giấy chứng nhận
        String TYPE_29 = "29";  // Từ chối yêu cầu sửa Giấy chứng nhận
    }

    public static class WebServiceURL {
        private static final String WS_URL = "send/08/sendAll/";

        private WebServiceURL() {
        }

        public static String get(Environment environment) {
            return environment.getRequiredProperty("SEND_WS_ROOT_URL") + WS_URL;
        }
    }

    public interface FileServices {
        String USER = "admin";
        //public static final String PASSWORD = "94373d59-f925-4e33-b6e2-ae6206dbbab2";
        String MINISTRY = "mard";
        String PROCEDURE = "08";
    }
}
