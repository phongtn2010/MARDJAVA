/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 *
 * @author QUANGNV18
 */
public class Most04Constant {

    static Most04Constant instance;

    public static Most04Constant getInstance() {
        synchronized (Most04Constant.class) {
            return new Most04Constant();
        }
    }
    @Autowired
    Environment environment;

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Most04Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Most04Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public static final String EnableSign = "nsw.most.04.sign";

    public interface Page {

        public static final String HOME = "most.04.home";
        public static final String CREATE = "most.04.create";
        public static final String VIEW = "most.04.view";
        public static final String RESULT = "most.04.result";
    }

    public interface API {

        public static final String BACKEND = "most.04.backend";
        public static final String BACKEND_COMMON = "nsw.common.url";

        public static final String HS_STATUS = "most.04.api.hoso.status";
        public static final String HS_SEARCH = "most.04.api.hoso.search";
        public static final String HS_INSERT = "most.04.api.hoso.insert";
        public static final String HS_UPDATE = "most.04.api.hoso.update";
        public static final String HS_GETBYID = "most.04.api.hoso.getbyid";
        public static final String HS_GETBYCODE = "most.04.api.hoso.getbycode";
        public static final String HS_SEND = "most.04.api.hoso.send";
        public static final String HS_OWNER = "most.04.api.hoso.owner";
        public static final String HS_DELETE = "most.04.api.hoso.delete";
        public static final String HS_HISTORY = "most.04.api.hoso.history";
        public static final String HS_IMPORT = "most.04.api.hoso.import";
        public static final String HS_BOSUNGTAILIEU = "most.04.api.hoso.bosungtailieu";
        public static final String HS_CONGVAN = "most.04.api.hoso.congvan";
        public static final String HS_GIAYPHEP = "most.04.api.hoso.giayphep";
        
        public static final String GET_HISTORY = "most.04.api.history.getbyid";
        public static final String GET_DINHKEM_BYID = "most.04.api.dinhkem.getbyid";

        public static final String DM_NHOMHH = "most.04.api.danhmuc.nhomhanghoa";
        public static final String DM_QUOCGIA = "most.04.api.danhmuc.quocgia";
        public static final String DM_LOAIFILE = "most.04.api.danhmuc.loaifiledinhkem";
        public static final String DM_LOAIHOSO = "most.04.api.danhmuc.loaihoso";
        public static final String HS_LOAIPHUONGTIENDO = "most.04.api.danhmuc.loaiphuongtiendo";
    }

    public interface FILE_STATUS {
        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";
        public static final Long THONG_BAO_KIEM_TRA = 3L;
        public static final String THONG_BAO_KIEM_TRA_STR = "Thông báo kiểm tra";
        public static final Long DA_RUT = 4L;
        public static final String DA_RUT_STR = "Đã rút hồ sơ";
        public static final Long YC_BO_SUNG = 5L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_BO_SUNG = 6L;
        public static final String DA_BO_SUNG_STR = "Đã bổ sung hồ sơ theo yêu cầu của CQKT";
        public static final Long YC_XIN_RUT_HOSO = 7L;
        public static final String YC_XIN_RUT_HOSO_STR = "Yêu cầu xin rút hồ sơ"; 
        public static final Long DONG_Y_YC_RUT = 8L;
        public static final String DONG_Y_YC_RUT_STR = "Đồng ý yêu cầu rút"; 
        public static final Long XIN_SUA_HOSO = 9L;
        public static final String XIN_SUA_HOSO_STR = "Xin sửa hồ sơ"; 
        public static final Long DONG_Y_YC_XIN_SUA = 10L;
        public static final String DONG_Y_YC_XIN_SUA_STR = "Đồng ý yêu cầu xin sửa"; 
        public static final Long TU_CHOI_YC_XIN_SUA = 11L;
        public static final String TU_CHOI_YC_XIN_SUA_STR = "Từ chối yêu cầu xin sửa";
        public static final Long YC_BO_SUNG_TAI_LIEU = 12L;
        public static final String YC_BO_SUNG_TAI_LIEU_STR = "Yêu cầu bổ sung tài liệu";
        public static final Long DA_GUI_TAI_LIEU = 13L;
        public static final String DA_GUI_TAI_LIEU_STR = "Đã gửi tài liệu";
        public static final Long DA_CAP_GIAY_CFS = 14L;
        public static final String DA_CAP_GIAY_CFS_STR = "Đã cấp giấy CFS";
        public static final Long TU_CHOI_CAP_GIAY_CFS = 15L;
        public static final String TU_CHOI_CAP_GIAY_CFS_STR = "Từ chối cấp giấy CFS";
        public static final Long DA_THU_HOI_GIAY_CFS = 16L;
        public static final String DA_THU_HOI_GIAY_CFS_STR = "Đã thu hồi giấy CFS";
    }
    
    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_12 = "12";
        public static final String TYPE_18 = "18";
        public static final String TYPE_19 = "19";
    }

    public interface MSG_FUNC {
        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_04 = "04";
        public static final String FUNC_09 = "09";
        public static final String FUNC_10 = "10";
        public static final String FUNC_15 = "15";
        public static final String FUNC_16 = "16";
    }

    public static final String JSON_IMPORT = "[\n"
            + "  {\n"
            + "    \"reader\": \"hanghoa\",\n"
            + "    \"sheetIndex\": 2,\n"
            + "    \"feed\": \"table\",\n"
            + "    \"start\": 3,\n"
            + "    \"end\": 0,\n"
            + "    \"data\": [\n"
            + "      {\n"
            + "        \"col\": \"A\",\n"
            + "        \"field\": \"stt\",\n"
            + "        \"type\": \"Long\",\n"
            + "        \"nullBreak\": true\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"field\": \"fiMaNhomHh\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"C\",\n"
            + "        \"field\": \"fiTenNhomHh\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"field\": \"fiTenHh\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"E\",\n"
            + "        \"field\": \"fiSoDk\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"F\",\n"
            + "        \"field\": \"fiSoHieuTc\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"G\",\n"
            + "        \"field\": \"fiTpHlHchat\",\n"
            + "        \"type\": \"BigDecimal\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"H\",\n"
            + "        \"field\": \"fiMaQgNk\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"I\",\n"
            + "        \"field\": \"fiTenQgNk\",\n"
            + "        \"type\": \"String\"\n"
            + "      }\n"
            + "    ]\n"
            + "  },\n"
            + "  {\n"
            + "    \"reader\": \"hoso\",\n"
            + "    \"sheetIndex\": 1,\n"
            + "    \"feed\": \"random\",\n"
            + "    \"data\": [\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 3,\n"
            + "        \"field\": \"fiTenDn\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 3,\n"
            + "        \"field\": \"fiEmailDn\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 4,\n"
            + "        \"field\": \"fiDiachiDn\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 5,\n"
            + "        \"field\": \"fiDtDn\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 5,\n"
            + "        \"field\": \"fiFaxDn\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 6,\n"
            + "        \"field\": \"fiWebsiteDn\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 7,\n"
            + "        \"field\": \"fiNguoiDd\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 7,\n"
            + "        \"field\": \"fiChucVu\",\n"
            + "        \"type\": \"String\"\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "]";

}
