/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.constant;

import org.springframework.core.env.Environment;

/**
 *
 * @author Administrator
 */
public class MOH09Constant {

    static MOH09Constant instance;
    public static final String EnableSign = "nsw.moh.09.sign";

    public interface UploadAccount {

        public static final String USER = "moh.09.upload_user_account";
        public static final String KEY = "moh.09.upload_user_pass";
    }

    public static MOH09Constant getInstance() {
        synchronized (MOH09Constant.class) {
            return new MOH09Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH09Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH09Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "moh.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "moh.09.tbdhoso9.insert";
        public static final String HOSO_UPDATE = "moh.09.tbdhoso9.update";
        public static final String HOSO_STATUS = "moh.09.tbdhoso9.status";
        public static final String HOSO_SEARCH = "moh.09.tbdhoso9.search";
        public static final String HOSO_DELETE = "moh.09.tbdhoso9.delete";
        public static final String HOSO_OWNER = "moh.09.tbdhoso9.owner";
        public static final String HOSO_GET_BYID = "moh.09.tbdhoso9.getbyid";
        public static final String HOSO_GET_BYCODE = "moh.09.tbdhoso9.getbymahoso";

        public static final String HOSO_SEND = "moh.09.api.hoso.send";
        public static final String HOSO_THONGBAO = "moh.09.api.vanban";
        
        //Payment
        public static final String PAYMENT_GET = "moh.09.api.payment.get";
        public static final String PAYMENT_SEND = "moh.09.api.payment.send";
        public static final String REPORT_SEND = "moh.09.api.report.send";
        
        //Lich su
        public static final String LICHSU_SEARCH = "moh.09.tbdlichsu9.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "moh.09.tbdkqxl9.data";

        //Danh muc
        public static final String DANHMUC_CUAKHAU = "moh.09.danhmuc.cuakhau";
        public static final String DANHMUC_LOAITHANHTOAN = "moh.09.danhmuc.loaithanhtoan";
        public static final String DANHMUC_DINHKEM = "moh.09.danhmuc.dinhkem";
        public static final String DANHMUC_COQUANKIEMTRA = "moh.09.danhmuc.coquankiemtra";
        public static final String DANHMUC_TRANGTHAI = "moh.09.danhmuc.trangthai";
        public static final String DANHMUC_NHOMSP = "moh.09.danhmuc.nhomsp";
        public static final String DANHMUC_QUOCGIA = "moh.09.danhmuc.quocgia";
        
        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "moh.09.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "moh.09.api.hoso.upload";

    }

    public interface MSG_TYPE {

        public static final String TYPE_101 = "101";
        public static final String TYPE_102 = "102";
        public static final String TYPE_103 = "103";
        public static final String TYPE_104 = "104";
        public static final String TYPE_105 = "105";
        public static final String TYPE_107 = "107";
        public static final String TYPE_109 = "109";
        
    }

    public interface MSG_FUNC {

        public static final String FUNC_01 = "01";
        public static final String FUNC_02 = "02";
        public static final String FUNC_03 = "03";
        public static final String FUNC_09 = "09";
        public static final String FUNC_10 = "10";
        public static final String FUNC_12 = "12";
        public static final String FUNC_14 = "14";
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";
        public static final String CAP_NHAT_STR = "Cập nhật";
        public static final Long CHO_THONG_BAO_PHI = 1L;
        public static final String CHO_THONG_BAO_PHI_STR = "Chờ thông báo phí";
        public static final Long DA_XAC_NHAN_PHI = 2L;
        public static final String DA_XAC_NHAN_PHI_STR = "Xác nhận phí và tiếp nhận hồ sơ";
        public static final Long YC_BO_SUNG = 3L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu sửa đổi bổ sung hồ sơ";
        public static final Long DA_RUT_HOSO = 4L;
        public static final String DA_RUT_HOSO_STR = "Đã rút hồ sơ";
        public static final Long DA_BO_SUNG_HOSO = 5L;
        public static final String DA_BO_SUNG_HOSO_STR = "Sửa đổi bổ sung theo yêu cầu"; 
        public static final Long TU_CHOI_CAP_PHEP = 7L;
        public static final String TU_CHOI_CAP_PHEP_STR = "Thông báo từ chối cấp phép"; 
        public static final Long DUOC_CAP_GIAYPHEP = 8L;
        public static final String DUOC_CAP_GIAYPHEP_STR = "Thông báo đạt/không đạt yêu cầu nhập khẩu";
        public static final Long YC_NOP_LAI_PHI = 9L;
        public static final String YC_NOP_LAI_PHI_STR = "Yêu cầu nộp lại phí";
        public static final Long THANH_TOAN_PHI_BOSUNG = 10L;
        public static final String THANH_TOAN_PHI_BOSUNG_STR = "Thanh toán phí bổ sung";
        public static final Long THONG_BAO_AP_PHI = 11L;
        public static final String THONG_BAO_AP_PHI_STR = "Thông báo áp phí";
        public static final Long CHO_XAC_NHAN_PHI = 12L;
        public static final String CHO_XAC_NHAN_PHI_STR = "Chờ xác nhận thanh toán phí";
        public static final Long DA_GUI_BAO_CAO_XU_LY = 13L;
        public static final String DA_GUI_BAO_CAO_XU_LY_STR = "Đã gửi báo cáo xử lý";
    }

    public class Pages {

        public static final String HOME_PATTERN = "moh.%s.home";
        public static final String EDIT_PATTERN = "moh.%s.edit";
        public static final String VIEW_PATTERN = "moh.%s.view";

        public static final String EDIT_PATTERN_TYPE = "moh.%s.%s.edit";
        public static final String VIEW_PATTERN_TYPE = "moh.%s.%s.view";
    }

    public class Routes {

        public static final String ROOT = "/moh";
        public static final String ROOT_HOME = "/moh/07";
    }

    public class View {

        public static final String HOME = "/{code}/home";
        public static final String INDEX = "/{code}/index";
        public static final String EDIT = "/{code}/edit";
        public static final String VIEW = "/{code}/view";
        public static final String VIEW_TYPE = "/{code}/{type}/view";
        public static final String EDIT_TYPE = "/{code}/{type}/edit";
    }

    public class ViewType {

        public static final String HOME = "home";
        public static final String EDIT = "edit";
        public static final String VIEW = "view";
    }

    public class DANHMUC {

        public static final String DANHMUC_CUAKHAU = "DANHMUC_CUAKHAU";
        public static final String DANHMUC_LOAITHANHTOAN = "DANHMUC_LOAITHANHTOAN";
        public static final String DANHMUC_DINHKEM = "DANHMUC_DINHKEM";
        public static final String DANHMUC_COQUANKIEMTRA = "DANHMUC_COQUANKIEMTRA";
        public static final String DANHMUC_TRANGTHAI = "DANHMUC_TRANGTHAI";
        public static final String DANHMUC_NHOMSP = "DANHMUC_NHOMSP";
        public static final String DANHMUC_QUOCGIA = "DANHMUC_QUOCGIA";

    }
}
