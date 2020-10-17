package com.nsw.backend.mard.p09.constant;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Constant09 {

    public static final Long SYSTEM_ID = 9L;
    public static final String MINISTRY_NAME = "BNNPTNT";
    public static final String MINISTRY_NAME_EN = "MARD";
    public static final String MARD_PROC_CODE = "12";


    public static final Long ACTIVE = 1L;
    public static final Long IN_ACTIVE = 0L;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso09Type {
        MAU_3(1L, "ĐĂNG KÝ KIỂM DỊCH ĐỘNG VẬT, SẢN PHẨM ĐỘNG VẬT TRÊN CẠN NHẬP KHẨU"),
        MAU_20A(2L, "ĐĂNG KÝ KIỂM TRA XÁC NHẬN CHẤT LƯỢNG THỨC ĂN CHĂN NUÔI, THỨC ĂN THỦY SẢN CÓ NGUỒN GỐC ĐỘNG VẬT NHẬP KHẨU");
        private long id;
        private String name;

        Hoso09Type(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Hoso09Type findById(Long i) {
            return Arrays.stream(Hoso09Type.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso09Status {
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
        DA_XM_DON_DK(14, "Đã xác minh đơn đăng ký"),
        DA_CAP_GVC(15, "Đã cấp giấy vận chuyển"),
        DA_CAP_CNKD(16, "Đã cấp giấy chứng nhận kiểm dịch"),
        KHONG_CAP_CNKD(17, "Không cấp giấy chứng nhận kiểm dịch"),
        XNCL_KHONG_DAT(18, "Kết quả XNCL không đạt"),
        DA_CAP_XNCL(19, "Đã cấp Giấy XNCL"),
        DA_GUI_PHAN_HOI(20, "Đã gửi phản hồi CV XNCL Không đạt");

        private long id;
        private String name;

        Hoso09Status(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static Hoso09Status findById(int i) {
            return Arrays.stream(Hoso09Status.values()).filter(st -> st.getId() == i)
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

        public PayStatus findById(int i) {
            return Arrays.stream(PayStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso09DeleteStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu hủy"),
        TU_CHOI_YEU_CAU(4, "Từ chối yêu cầu hủy"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu hủy");
        private int id;
        private String name;

        Hoso09DeleteStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Hoso09DeleteStatus findById(int i) {
            return Arrays.stream(Hoso09DeleteStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Hoso09EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu sửa"),
        DA_TIEP_NHAN(2, "Đã tiếp nhận yêu cầu sửa"),
        TU_CHOI_YEU_CAU(4, "Từ chối yêu cầu sửa"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu sửa");
        private int id;
        private String name;

        Hoso09EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Hoso09EditStatus findById(int i) {
            return Arrays.stream(Hoso09EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Cvvsty09EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ xem xét sửa công văn"),
        LDP_DONG_Y_SUA(2, "Lãnh đạo phòng đồng ý sửa công văn"),
        LDP_TU_CHOI_SUA(3, "Lãnh đạo phòng từ chối sửa công văn"),
        LDC_DONG_Y_SUA(4, "Lãnh đạo cục phê duyệt sửa công văn"),
        LDC_TU_CHOI_SUA(5, "Lãnh đạo cục từ chối sửa công văn");
        private int id;
        private String name;

        Cvvsty09EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Cvvsty09EditStatus findById(int i) {
            return Arrays.stream(Cvvsty09EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum Cvcnkd09EditStatus {
        TAO_MOI(0, "Tạo mới"),
        CHO_TIEP_NHAN(1, "Chờ xem xét sửa công văn"),
        LDP_DONG_Y_SUA(2, "Lãnh đạo phòng đồng ý sửa công văn"),
        LDP_TU_CHOI_SUA(3, "Lãnh đạo phòng từ chối sửa công văn"),
        LDC_DONG_Y_SUA(4, "Lãnh đạo cục phê duyệt sửa công văn"),
        LDC_TU_CHOI_SUA(5, "Lãnh đạo cục từ chối sửa công văn");
        private int id;
        private String name;

        Cvcnkd09EditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Cvcnkd09EditStatus findById(int i) {
            return Arrays.stream(Cvcnkd09EditStatus.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum CertEditStatus {
        KHOI_TAO(0, ""),
        CHO_TIEP_NHAN(1, "Chờ tiếp nhận yêu cầu sửa"),
        TU_CHOI_YEU_CAU(2, "Từ chối yêu cầu sửa"),
        DONG_Y_YEU_CAU(3, "Đồng ý yêu cầu sửa"),
        DA_SUA(4, "Đã cấp GCN sửa đổi");
        private int id;
        private String name;

        CertEditStatus(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum AttachedDocType {
        HOP_DONG_MUA_BAN(1, "Hợp đồng mua bán"),
        HOA_DON_MUA_BAN(2, "Hóa đơn mua bán"),
        PHIEU_DONG_GOI(3, "Phiếu đóng gói");
        private int id;
        private String name;

        AttachedDocType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public static AttachedDocType findById(int i) {
            return Arrays.stream(AttachedDocType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum AttachmentType {
        GCN_VSTY(1, "Giấy chứng nhận điều kiện vệ sinh thú y (đối với động vật, sản phẩm động vật nhập khẩu để gia công, chế biến hàng xuất khẩu)", Hoso09Type.MAU_20A),
        GCN_KDDV_NHAP_KHAU(2, "Giấy chứng thực Giấy phép KDTV nhập khẩu (trường hợp quy định phải có giấy phép)", Hoso09Type.MAU_20A),
        HOP_DONG_MUA_BAN(3, "Hợp đồng mua bán", Hoso09Type.MAU_20A),
        PHIEU_DONG_GOI(4, "Phiếu đóng gói (Packing list)", Hoso09Type.MAU_20A),
        HOA_DON_MUA_BAN(5, "Hóa đơn mua bán (Invoice)", Hoso09Type.MAU_20A),
        TAI_LIEU_KHAC(6, "Tài liệu khác", Hoso09Type.MAU_20A),
        TAI_LIEU_DINH_KEM_THU_TUC_3(1, "Tài liệu đính kèm cho thủ tục 3", Hoso09Type.MAU_3);

        private int id;
        private String name;
        private Hoso09Type type;

        AttachmentType(int id, String name, Hoso09Type type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public static AttachmentType findByIdAndType(int i, Hoso09Type regProfile) {
            return Arrays.stream(AttachmentType.values())
                    .filter(st -> st.getId() == i || regProfile == st.getType())
                    .findFirst().orElse(null);
        }

        public static List<AttachmentType> getListByType(Hoso09Type regType) {
            return Arrays.stream(AttachmentType.values())
                    .filter(st -> st.getType() == regType)
                    .collect(Collectors.toList());
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum InspectionType {
        MIEN_KT_CL_TACN_TSNK(1, "Miễn kiểm tra chất lượng thức ăn chăn nuôi, thủy sản nhập khẩu"),
        MIEN_KT_CO_THOI_HAN(2, "Miễn kiểm tra chất lượng có thời hạn"),
        KT_GIAM_CO_THOI_HAN(3, "Kiểm tra giảm có thời hạn"),
        KT_THONG_THUONG(4, "Kiểm tra thông thường"),
        KT_CHAT(5, "Kiểm tra chặt");

        private int id;
        private String name;

        InspectionType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public InspectionType findById(int i) {
            return Arrays.stream(InspectionType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @Getter
    public enum CertificationType {
        GVC(1, "Giấy vận chuyển"),
        CNKD(2, "Chứng nhận kiểm dịch"),
        XNCL(3, "Xác nhận chất lượng");

        private int id;
        private String name;

        CertificationType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public CertificationType findById(int i) {
            return Arrays.stream(CertificationType.values()).filter(st -> st.getId() == i)
                    .findFirst().orElse(null);
        }
    }


    public static class WebServiceURL {
        private static final String WS_URL = "send/09/sendAll/";

        private WebServiceURL() {
        }

        public static String get(Environment environment) {
            return environment.getRequiredProperty("SEND_WS_ROOT_URL") + WS_URL;
        }
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

    public interface SENDER {
        String CODE = "NSW";
        String NAME = "Cổng thông tin một cửa quốc gia";
    }

    public interface RECEIVER {
        String CODE = "BNN";
        String NAME = "Bộ nông nghiệp và PT nông thôn";
    }
}
