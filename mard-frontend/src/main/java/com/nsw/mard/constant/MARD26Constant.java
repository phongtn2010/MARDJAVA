/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.constant;

import org.springframework.core.env.Environment;

public class MARD26Constant {

    static MARD26Constant instance;
    public static final String EnableSign = "nsw.mard.26.sign";

    public static MARD26Constant getInstance() {
        synchronized (MARD26Constant.class) {
            return new MARD26Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MARD26Constant.TbdHoso26API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MARD26Constant.TbdHoso26API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface TbdHoso26API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mard.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "mard.26.tbdhoso26.insert";
        public static final String HOSO_UPDATE = "mard.26.tbdhoso26.update";
        public static final String HOSO_STATUS = "mard.26.tbdhoso26.status";
        public static final String HOSO_SEARCH = "mard.26.tbdhoso26.search";
        public static final String HOSO_DELETE = "mard.26.tbdhoso26.delete";
        public static final String HOSO_OWNER = "mard.26.tbdhoso26.owner";
        public static final String HOSO_SEND = "mard.26.api.hoso.send";
        public static final String HOSO_GET_BYID = "mard.26.tbdhoso26.getbyid";
        public static final String HOSO_GET_BYCODE = "mard.26.tbdhoso26.getbymahoso";
        public static final String HOSO_THONGBAO = "mard.26.api.vanban";
        public static final String CONGVAN_THUHOI_DINHKEM = "mard.26.api.thuhoi.congvan";
        public static final String HOSO_FIND_BY_FILTER = "mard.26.tbdhoso26.find";

        //Lich su
        public static final String LICHSU_SEARCH = "mard.26.tbdlichsu26.search";
        public static final String KQXL_SEARCH = "mard.26.tbdhskqxl26.data";

        //Danh muc
        public static final String DANHMUC_CQGS = "mard.26.danhmuc.cqgs";
        public static final String DANHMUC_TRANGTHAI = "mard.26.danhmuc.trangthai";
        public static final String GET_BY_CAT_NO = "mard.26.danhmuc.getbycatno";

        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "mard.26.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "mard.26.api.hoso.upload";

        //Dinh kem
        public static final String DINHKEM_GET_BYID = "mard.26.tbdhoso26.dinhkem";

        //Tra cuu san pham tu thu tuc TACN
        public static final String SEARCH_PRODUCT_FROM_TACN = "mard.26.product.search";

    }

    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_18 = "18";
    }

    public interface MSG_FUNC {

        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_04 = "04";
        public static final String FUNC_05 = "05";
        public static final String FUNC_06 = "06";
        public static final String FUNC_08 = "08";
        public static final String FUNC_11 = "11";
        public static final String FUNC_12 = "12";
        public static final String FUNC_13 = "13";
        public static final String FUNC_14 = "14";
        public static final String FUNC_15 = "15";
        public static final String FUNC_16 = "16";
        public static final String FUNC_17 = "17";
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận hồ sơ";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận hồ sơ";
        public static final Long DUOC_CAP_GIAYPHEP = 3L;
        public static final String DUOC_CAP_GIAYPHEP_STR = "Thông báo cấp công văn";
        public static final Long DA_THU_HOI = 4L;
        public static final String DA_THU_HOI_STR = "Thông báo thu hồi công văn";
    }

    public class Pages {

        public static final String HOME_PATTERN = "mard.%s.home";
        public static final String EDIT_PATTERN = "mard.%s.edit";
        public static final String VIEW_PATTERN = "mard.%s.view";
    }

    public class Routes {

        public static final String ROOT = "/mard";
        public static final String URI_THU_TUC_26 = "/26";
        public static final String URI_THU_TUC_13 = "/13";
    }

    public class View {

        public static final String HOME = "/{code}/home";
        public static final String INDEX = "/{code}/index";
        public static final String EDIT = "/{code}/edit";
        public static final String VIEW = "/{code}/view";
    }

    public class ViewType {

        public static final String HOME = "mard.26.home";
        public static final String CREATE = "mard.26.create";
        public static final String EDIT = "mard.26.edit";
        public static final String VIEW = "mard.26.view";
    }

    public class DANHMUC {

        public static final String HS_TRANGTHAI = "HS_TRANGTHAI";
        public static final String HS_CQGS_PHIABAC = "HS_CQGS_PHIABAC";
        public static final String HS_CQGS_PHIATRUNG = "HS_CQGS_PHIATRUNG";
        public static final String HS_CQGS_PHIANAM = "HS_CQGS_PHIANAM";
    }
}
