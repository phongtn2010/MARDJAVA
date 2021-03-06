/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.constant;

import org.springframework.core.env.Environment;

public class MOH39Constant {

    static MOH39Constant instance;
    public static final String ENABLE_SIGN_PARTTERN = "nsw.moh.%s.sign";
    public static final String UPLOAD_PATTERN_TYPE = "moh.%s.api.upload";

    public static MOH39Constant getInstance() {
        synchronized (MOH39Constant.class) {
            return new MOH39Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH39Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH39Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "moh.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "moh.39.tbdhoso39.insert";
        public static final String HOSO_UPDATE = "moh.39.tbdhoso39.update";
        public static final String HOSO_STATUS = "moh.39.tbdhoso39.status";
        public static final String HOSO_SEARCH = "moh.39.tbdhoso39.search";
        public static final String HOSO_DELETE = "moh.39.tbdhoso39.delete";
        public static final String HOSO_OWNER = "moh.39.tbdhoso39.owner";
        public static final String HOSO_SEND = "moh.39.api.hoso.send";
        public static final String HOSO_GET_BYID = "moh.39.tbdhoso39.getbyid";
        public static final String HOSO_GET_BYCODE = "moh.39.tbdhoso39.getbymahoso";
        public static final String HOSO_THONGBAO = "moh.39.api.vanban";

        //Lich su
        public static final String LICHSU_SEARCH = "moh.39.tbdlichsu39.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "moh.39.tdbhskqxl39.data";
        //Ket qua yeu cau sua van ban
        public static final String KQYCS_VB = "moh.39.tbhsycrut.data";
        //Ket qua yeu cau tra lai van ban
        public static final String KQYCTL_VB = "moh.39.tbdvbyctralai2.data";

        //Danh muc
        public static final String DANHMUC_CUAKHAU_NHAPKHAU = "moh.39.danhmuc.cuakhaunhapkhau";
        public static final String DANHMUC_TINHTHANH = "moh.39.danhmuc.tinhthanh";
        public static final String DANHMUC_DONVITINH = "moh.39.danhmuc.donvitinh";
        public static final String DANHMUC_TRANGTHAI = "moh.39.danhmuc.trangthai";
        public static final String DANHMUC_NUOCSANXUAT = "moh.39.danhmuc.nuocsanxuat";
        public static final String DANHMUC_MUCDICHNHAPKHAU = "moh.39.danhmuc.mucdichnhapkhau";
        public static final String DANHMUC_LOAIDONHANG = "moh.39.danhmuc.loaidonhang";
        public static final String DANHMUC_NUOCCUNGCAP = "moh.39.danhmuc.nuoccungcap";
        public static final String DANHMUC_LOAIFILE = "moh.39.danhmuc.loaifile";
        public static final String DANHMUC_NGUYENLIEU = "moh.39.danhmuc.nguyenlieu";

        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "moh.39.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "moh.39.api.hoso.upload";

    }

    public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_13 = "13";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_17 = "17";
        public static final String TYPE_18 = "18";
    }

    public interface MSG_FUNC {

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
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_TIEP_NHAN = 1L;
        public static final String CHO_TIEP_NHAN_STR = "Chờ tiếp nhận hồ sơ";
        public static final Long DA_TIEP_NHAN = 2L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận hồ sơ";
        public static final Long YC_BO_SUNG = 3L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu bổ sung hồ sơ";
        public static final Long DA_RUT_HOSO = 4L;
        public static final String DA_RUT_HOSO_STR = "Đã rút hồ sơ";
        public static final Long DA_BO_SUNG_HOSO = 5L;
        public static final String DA_BO_SUNG_HOSO_STR = "Đã bổ sung hồ sơ";
        public static final Long TU_CHOI_HOSO = 6L;
        public static final String TU_CHOI_HOSO_STR = "Từ chối hồ sơ";
        public static final Long TU_CHOI_CAP_PHEP = 7L;
        public static final String TU_CHOI_CAP_PHEP_STR = "Từ chối cấp phép";
        public static final Long DUOC_CAP_GIAYPHEP = 8L;
        public static final String DUOC_CAP_GIAYPHEP_STR = "Thông báo cấp giấy phép";
    }

    public class Pages {

        public static final String HOME_PATTERN = "moh.%s.home";
        public static final String EDIT_PATTERN = "moh.%s.edit";
        public static final String VIEW_PATTERN = "moh.%s.view";
        public static final String RESULT_PATTERN = "moh.%s.result";
        
        public static final String EDIT_PATTERN_TYPE = "moh.%s.%s.edit";
        public static final String VIEW_PATTERN_TYPE = "moh.%s.%s.view";
        public static final String RESULT_PATTERN_TYPE = "moh.%s.%s.result";
    }

    public class Routes {

        public static final String ROOT = "/moh";
        public static final String URI_THU_TUC_38 = "/38";
        public static final String URI_THU_TUC_39 = "/39";
        public static final String URI_THU_TUC_40 = "/40";
        public static final String URI_THU_TUC_41 = "/41";
        public static final String URI_THU_TUC_42 = "/42";
        public static final String URI_THU_TUC_43 = "/43";

        public static final String ROOT_HOME = "/moh/39";
    }

    public class View {

        public static final String HOME = "/{code}/home";
        public static final String INDEX = "/{code}/index";
        public static final String EDIT = "/{code}/edit";
        public static final String VIEW = "/{code}/view";
        public static final String RESULT = "/{code}/result";
        public static final String VIEW_TYPE = "/{code}/{type}/view";
        public static final String EDIT_TYPE = "/{code}/{type}/edit";
        public static final String RESULT_TYPE = "/{code}/{type}/result";
    }

    public class ViewType {

        public static final String HOME = "home";
        public static final String EDIT = "edit";
        public static final String VIEW = "view";
        public static final String RESULT = "result";
    }

    public class DANHMUC {

        public static final String DANHMUC_CUAKHAU_NHAPKHAU = "DANHMUC_CUAKHAU_NHAPKHAU";
        public static final String DANHMUC_TINHTHANH = "DANHMUC_TINHTHANH";
        public static final String DANHMUC_DONVITINH = "DANHMUC_DONVITINH";
        public static final String DANHMUC_TRANGTHAI = "DANHMUC_TRANGTHAI";
        public static final String DANHMUC_NUOCSANXUAT = "DANHMUC_NUOCSANXUAT";
        public static final String DANHMUC_MUCDICHNHAPKHAU = "DANHMUC_MUCDICHNHAPKHAU";
        public static final String DANHMUC_LOAIDONHANG = "DANHMUC_LOAIDONHANG";
        public static final String DANHMUC_NUOCCUNGCAP = "DANHMUC_NUOCCUNGCAP";
        public static final String DANHMUC_LOAIFILE = "DANHMUC_LOAIFILE";
        public static final String DANHMUC_NGUYENLIEU = "DANHMUC_NGUYENLIEU";
    }
}
