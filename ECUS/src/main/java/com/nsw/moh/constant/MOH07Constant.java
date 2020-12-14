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
public class MOH07Constant {

    static MOH07Constant instance;
    public static final String EnableSign = "nsw.moh.07.sign";
    
    public interface UploadAccount {
        public static final String USER = "moh.07.upload_user_account";
        public static final String KEY = "moh.07.upload_user_pass";
    }
    
    public static MOH07Constant getInstance() {
        synchronized (MOH07Constant.class) {
            return new MOH07Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH07Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MOH07Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "moh.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "moh.07.tbdhoso7.insert";
        public static final String HOSO_UPDATE = "moh.07.tbdhoso7.update";
        public static final String HOSO_STATUS = "moh.07.tbdhoso7.status";
        public static final String HOSO_SEARCH = "moh.07.tbdhoso7.search";
        public static final String HOSO_DELETE = "moh.07.tbdhoso7.delete";
        public static final String HOSO_OWNER = "moh.07.tbdhoso7.owner";
        public static final String HOSO_GET_BYID = "moh.07.tbdhoso7.getbyid";
        public static final String HOSO_GET_BYCODE = "moh.07.tbdhoso7.getbymahoso";
        
        public static final String HOSO_SEND = "moh.07.api.hoso.send";        
        public static final String HOSO_THONGBAO = "moh.07.api.vanban";

        //Lich su
        public static final String LICHSU_SEARCH = "moh.07.tbdlichsu7.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "moh.07.tbdkqxl7.data";

        //Danh muc
        public static final String DANHMUC_TINHTHANH = "moh.07.danhmuc.tinhthanh";
        public static final String DANHMUC_QUANHUYEN = "moh.07.danhmuc.quanhuyen";        
        public static final String DANHMUC_COSOSANXUAT = "moh.07.danhmuc.cososanxuat";
        public static final String DANHMUC_QUOCGIA = "moh.07.danhmuc.quocgia";
        public static final String DANHMUC_DONVINHAN = "moh.07.danhmuc.donvinhan";
        public static final String DANHMUC_THONGTINTKTT = "moh.07.danhmuc.thongtinthanhtoan";
        
        public static final String DANHMUC_DONDK_NHOMTTBYT = "moh.07.danhmuc.dondk.nhomttb";
        public static final String DANHMUC_DONDK_LOAITTBYT = "moh.07.danhmuc.dondk.loaittb";
        public static final String DANHMUC_DONDK_LOAI_HOSO_TTBYT = "moh.07.danhmuc.dondk.loaihosottb";
        
        public static final String DANHMUC_TTB_NHOM = "moh.07.danhmuc.ttb.nhomttb";
        public static final String DANHMUC_TTB_PHANNHOM = "moh.07.danhmuc.ttb.phannhom";
        public static final String DANHMUC_TTB_LOAI = "moh.07.danhmuc.ttb.loaittb";
        public static final String DANHMUC_TAILIEU = "moh.07.danhmuc.loaifile";
        public static final String DANHMUC_TAILIEU_TTB = "moh.07.danhmuc.file_loaittb";
        
        public static final String DANHMUC_TRANGTHAI = "moh.07.danhmuc.trangthai";
        
        public static final String DANHMUC_CSBH = "moh.07.csbh.search";
        public static final String DANHMUC_CSBH_ADD = "moh.07.csbh.add";
        public static final String DANHMUC_CSBH_UPDATE = "moh.07.csbh.update";
        public static final String DANHMUC_CSBH_DELETE = "moh.07.csbh.delete";

        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "moh.07.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "moh.07.api.hoso.upload";
        
        public static final String DKLH_CHECK = "moh.07.api.dklh.check";

    }

    public interface MSG_TYPE {

        public static final String TYPE_101 = "101";
        public static final String TYPE_11 = "11";
        public static final String TYPE_102 = "102";
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
        public static final Long CHO_XAC_NHAN_PHI = 1L;
        public static final String CHO_XAC_NHAN_PHI_STR = "Chờ tiếp nhận hồ sơ";
        public static final Long DA_XAC_NHAN_PHI = 2L;
        public static final String DA_XAC_NHAN_PHI_STR = "Xác nhận thanh toán";
        public static final Long YC_BO_SUNG = 3L;
        public static final String YC_BO_SUNG_STR = "Yêu cầu sửa đổi bổ sung hồ sơ";
        public static final Long DA_TIEP_NHAN = 4L;
        public static final String DA_TIEP_NHAN_STR = "Đã tiếp nhận hồ sơ";
        public static final Long DA_BO_SUNG_HOSO = 5L;
        public static final String DA_BO_SUNG_HOSO_STR = "Sửa đổi bổ sung theo yêu cầu"; 
        public static final Long TU_CHOI_HOSO = 6L;
        public static final String TU_CHOI_HOSO_STR = "Yêu cầu nộp lại phí"; 
        public static final Long TU_CHOI_CAP_PHEP = 7L;
        public static final String TU_CHOI_CAP_PHEP_STR = "Hồ sơ từ chối cấp số đăng ký"; 
        public static final Long DUOC_CAP_GIAYPHEP = 8L;
        public static final String DUOC_CAP_GIAYPHEP_STR = "Hồ sơ đã cấp số đăng ký";
        public static final Long THU_HOI_GIAYPHEP = 9L;
        public static final String THU_HOI_GIAYPHEP_STR = "Thu hồi cấp số đăng ký";
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

        public static final String DANHMUC_TINHTHANH = "DANHMUC_TINHTHANH";
        public static final String DANHMUC_QUANHUYEN = "DANHMUC_QUANHUYEN";        
        public static final String DANHMUC_COSOSANXUAT = "DANHMUC_COSOSANXUAT";
        public static final String DANHMUC_QUOCGIA = "DANHMUC_QUOCGIA";
        public static final String DANHMUC_DONVINHAN = "DANHMUC_DONVINHAN";
        public static final String DANHMUC_DONDK_NHOMTTBYT = "DANHMUC_DONDK_NHOMTTBYT";
        public static final String DANHMUC_DONDK_LOAITTBYT = "DANHMUC_DONDK_LOAITTBYT";
        public static final String DANHMUC_DONDK_LOAI_HOSO_TTBYT = "DANHMUC_DONDK_LOAI_HOSO_TTBYT";
        public static final String DANHMUC_TTB_NHOM = "DANHMUC_TTB_NHOM";
        public static final String DANHMUC_TTB_PHANNHOM = "DANHMUC_TTB_PHANNHOM";
        public static final String DANHMUC_TTB_LOAI = "DANHMUC_TTB_LOAI";
        public static final String DANHMUC_TAILIEU = "DANHMUC_TAILIEU";
        public static final String DANHMUC_TAILIEU_TTB = "DANHMUC_TAILIEU_TTB";
        public static final String DANHMUC_TRANGTHAI = "DANHMUC_TRANGTHAI";
        public static final String DANHMUC_CSBH = "DANHMUC_CSBH";
        public static final String DANHMUC_THONGTINTKTT = "DANHMUC_THONGTINTKTT";

    }
}
