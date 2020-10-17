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
public class Most03Constant {

    static Most03Constant instance;
    
    public interface PROCEDUCE_INFO {
        public static final String MINISTRY_CODE = "MOST";
        public static final String PROCEDUCE_CODE = "03";
    }

    public static Most03Constant getInstance() {
        synchronized (Most03Constant.class) {
            return new Most03Constant();
        }
    }
    @Autowired
    Environment environment;

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Most03Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Most03Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public static final String EnableSign = "nsw.most.03.sign";
    public static final String DocType = "BKHCN0200002";

    public interface Page {

        public static final String HOME = "most.03.home";
        public static final String CREATE = "most.03.create";
        public static final String VIEW = "most.03.view";
        public static final String RESULT = "most.03.result";
    }

    public interface API {

        public static final String BACKEND = "most.03.backend";
        public static final String BACKEND_COMMON = "nsw.common.url";

        public static final String HS_STATUS = "most.03.api.hoso.status";
        public static final String HS_SEARCH = "most.03.api.hoso.search";
        public static final String HS_INSERT = "most.03.api.hoso.insert";
        public static final String HS_UPDATE = "most.03.api.hoso.update";
        public static final String HS_GETBYID = "most.03.api.hoso.getbyid";
        public static final String HS_GETBYCODE = "most.03.api.hoso.getbycode";
        public static final String HS_SEND = "most.03.api.hoso.send";
        public static final String HS_OWNER = "most.03.api.hoso.owner";
        public static final String HS_DELETE = "most.03.api.hoso.delete";
        public static final String HS_HISTORY = "most.03.api.hoso.history";
        public static final String HS_IMPORT = "most.03.api.hoso.import";
        public static final String HS_CONGVAN = "most.03.api.hoso.congvan";
        public static final String HS_THONGTINGIAHAN = "most.03.api.hoso.ttgiahan";
        public static final String HS_QUYETDINH = "most.03.api.hoso.quyetdinh";

        public static final String DM_MAUPHUONGTIENDO = "most.03.api.danhmuc.mauphuongtiendo";
        public static final String DM_QUOCGIA = "most.03.api.danhmuc.quocgia";
        public static final String DM_LOAIFILE = "most.03.api.danhmuc.loaifiledinhkem";
        public static final String DM_DVTHUNGHIEM = "most.03.api.danhmuc.donvithunghiem";
        public static final String DM_LOAIHOSO = "most.03.api.danhmuc.loaihoso";
        public static final String HS_LOAIPHUONGTIENDO = "most.03.api.danhmuc.loaiphuongtiendo";
        public static final String DM_DVHAIQUAN = "most.03.api.danhmuc.loaiphuongtiendo";
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận";
        public static final Long DA_RUT = 3L;
        public static final String DA_RUT_STR = "Đã rút hồ sơ";
        public static final Long YC_BO_SUNG = 4L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_BO_SUNG = 5L;
        public static final String DA_BO_SUNG_STR = "Đã bổ sung hồ sơ theo yêu cầu";
        public static final Long DA_SUA_HOSO = 6L;
        public static final String DA_SUA_HOSO_STR = "Đã sửa hồ sơ";
        public static final Long NHAN_QUYET_DINH = 7L;
        public static final String NHAN_QUYET_DINH_STR = "Nhận quyết định";
        public static final Long NHAN_QUYET_DINH_HUY = 8L;
        public static final String NHAN_QUYET_DINH_HUY_STR = "Nhận quyết định hủy";
        public static final Long NHAN_QUYET_DINH_DINH_CHI = 9L;
        public static final String NHAN_QUYET_DINH_DINH_CHI_STR = "Nhận quyết định đình chỉ";
        public static final Long YC_HUY_QUYET_DINH = 10L;
        public static final String YC_HUY_QUYET_DINH_STR = "Yêu cầu xin hủy quyết định";
        public static final Long YC_DINH_CHI_QUYET_DINH = 11L;
        public static final String YC_DINH_CHI_QUYET_DINH_STR = "Yêu cầu xin đình chỉ quyết định";
        public static final Long YC_GIA_HAN_QUYET_DINH = 12L;
        public static final String YC_GIA_HAN_QUYET_DINH_STR = "Yêu cầu xin gia hạn quyết định";
        public static final Long NHAN_QUYET_DINH_GIA_HAN = 13L;
        public static final String NHAN_QUYET_DINH_GIA_HAN_STR = "Nhận quyết định gia hạn";
        public static final Long DA_GUI_TT_KHAC_PHUC = 14L;
        public static final String DA_GUI_TT_KHAC_PHUC_STR = "Đã gửi thông tin khắc phục";
        public static final Long DA_NHAN_TT_KHAC_PHUC = 15L;
        public static final String DA_NHAN_TT_KHAC_PHUC_STR = "Đã nhận thông tin khắc phục";
    }
    
    public interface HOSO_TYPE {

        public static final Long TYPE_1 = 1L;
        public static final String TYPE_1_STR = "Đăng ký nhập khẩu mẫu phương tiện đo phục vụ thử nghiệm";
        public static final Long TYPE_2 = 2L;
        public static final String TYPE_2_STR = "Đăng ký phê duyệt mẫu phương tiện đo nhập khẩu";
    }
    
    public interface PHUONG_TIEN_DO_TYPE {

        public static final Long TYPE_1 = 1L;
        public static final String TYPE_1_STR = "Phương tiện đo chưa nhập khẩu";
        public static final Long TYPE_2 = 2L;
        public static final String TYPE_2_STR = "Phương tiện đo đã nhập khẩu sử dụng, chưa phê duyệt mẫu";
    }

    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_18 = "18";
    }

    public interface MSG_FUNC {

        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_04 = "04";
        public static final String FUNC_05 = "05";
        public static final String FUNC_16 = "16";
        public static final String FUNC_18 = "18";
    }

    public static final String JSON_IMPORT = "[\n"
            + "  {\n"
            + "    \"reader\": \"hanghoa\",\n"
            + "    \"sheetIndex\": 2,\n"
            + "    \"feed\": \"table\",\n"
            + "    \"start\": 5,\n"
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
            + "        \"field\": \"fiMaHh\",\n"
            + "        \"type\": \"Long\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"C\",\n"
            + "        \"field\": \"fiTenHh\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"field\": \"fiSotk\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"E\",\n"
            + "        \"field\": \"fiKyhieu\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"F\",\n"
            + "        \"field\": \"fiKieu\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"G\",\n"
            + "        \"field\": \"fiMaQg\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"H\",\n"
            + "        \"field\": \"fiTenQg\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"I\",\n"
            + "        \"field\": \"fiTenNsx\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"J\",\n"
            + "        \"field\": \"fiDactinhKt\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"            
            + "      {\n"
            + "        \"col\": \"K\",\n"
            + "        \"field\": \"fiMaHs\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"L\",\n"
            + "        \"field\": \"fiPhamvido\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"M\",\n"
            + "        \"field\": \"fiCapCx\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"N\",\n"
            + "        \"field\": \"fiSoSx\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"O\",\n"
            + "        \"field\": \"fiGhiChu\",\n"
            + "        \"type\": \"String\"\n"
            + "      }\n"
            + "    ]\n"
            + "  },\n"
            + "  {\n"
            + "    \"reader\": \"tokhai\",\n"
            + "    \"sheetIndex\": 1,\n"
            + "    \"feed\": \"table\",\n"
            + "    \"start\": 11,\n"
            + "    \"end\": 0,\n"
            + "    \"data\": [\n"
            + "      {\n"
            + "        \"col\": \"A\",\n"
            + "        \"field\": \"fiSoTk\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"field\": \"fiNgayDk\",\n"
            + "        \"type\": \"Date\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"C\",\n"
            + "        \"field\": \"fiMaHq\",\n"
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
            + "        \"row\": 2,\n"
            + "        \"field\": \"fiTenCoso\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 2,\n"
            + "        \"field\": \"fiDiachiTsc\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 3,\n"
            + "        \"field\": \"fiSdt\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 3,\n"
            + "        \"field\": \"fiEmail\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 4,\n"
            + "        \"field\": \"fiFax\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 4,\n"
            + "        \"field\": \"fiDiachiVpgg\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 5,\n"
            + "        \"field\": \"fiSoDkkd\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 5,\n"
            + "        \"field\": \"fiNgaycap\",\n"
            + "        \"type\": \"Date\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 6,\n"
            + "        \"field\": \"fiCqCap\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 6,\n"
            + "        \"field\": \"fiMstDn\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 7,\n"
            + "        \"field\": \"fiDnMienTnm\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"D\",\n"
            + "        \"row\": 7,\n"
            + "        \"field\": \"fiLydoDnMien\",\n"
            + "        \"type\": \"String\"\n"
            + "      },\n"
            + "      {\n"
            + "        \"col\": \"B\",\n"
            + "        \"row\": 8,\n"
            + "        \"field\": \"fiLoaiHoso\",\n"
            + "        \"type\": \"Long\"\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "]";

}
