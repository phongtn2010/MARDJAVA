package com.vnsw.ws.p12.common;

public class Constants12 {

    public interface RES_METHOD {

        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }
    
    public interface BNN12_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
    }

    public interface BNN12_FUNCTION {

        public static final String FUNCTION_01 = "01";
        public static final String FUNCTION_04 = "04";
        public static final String FUNCTION_05 = "05";
        public static final String FUNCTION_06 = "06";
        public static final String FUNCTION_99 = "99";
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận hồ sơ";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận hồ sơ";
        public static final Long DUOC_CAP_GIAYPHEP = 3L;
        public static final String DUOC_CAP_GIAYPHEP_STR = "Thông báo cấp công văn";
        public static final Long DA_THU_HOI = 4L;
        public static final String DA_THU_HOI_STR = "Thông báo thu hồi công văn";
    }

    public interface RES_URI {

        public static final String URI_LICHSU_RESPONSE = "/mard/12/lichsu/data/";
        public static final String URI_GIAY_PHEP = "/mard/12/congvan/data/";
        public static final String URI_LIST_CONG_VAN = "/mard/12/congvan/data/list/create/";
        public static final String URL_HOSO = "/mard/12/hoso/";
        public static final String URL_GET_HOSO = "/mard/12/hoso/getbyidhoso/";
        public static final String URI_KETQUA_XULY = "/mard/12/kqxl/data/";

    }
    
    public interface TYPE_INSPECTION {
        public static final Long MIEN_KIEM_TRA = 1L;
        public static final Long GIAM_KIEM_TRA = 2L;
    }

}
