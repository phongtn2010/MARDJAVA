/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.most.constant;

import org.springframework.core.env.Environment;

/**
 *
 * @author Antsoft
 */
public class Most06Constant {
    
    static Most06Constant instance;
    public static final String EnableSign = "nsw.most.06.sign";

    public static Most06Constant getInstance() {
        synchronized (Most06Constant.class) {
            return new Most06Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Most06Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Most06Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }
    
    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "most.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "most.06.tbdhoso.create";
        public static final String HOSO_UPDATE = "most.06.tbdhoso.update";
        public static final String HOSO_STATUS = "most.06.tbdhoso.status";
        public static final String HOSO_SEARCH = "most.06.tbdhoso.search";
        public static final String HOSO_DELETE = "most.06.tbdhoso.delete";
        public static final String HOSO_OWNER = "most.06.tbdhoso.owner";
        public static final String HOSO_SEND = "most.06.hoso.send";
        public static final String HOSO_GET_BYID = "most.06.tbdhoso.getbyidhoso";
        public static final String HOSO_GET_BYCODE = "most.06.tbdhoso.getbymahoso";
        public static final String HOSO_THONGBAO = "most.06.tbdgiayphep.getbymahoso";
        public static final String HOSO_THONGBAO_CHITIET = "most.06.tbdgiayphep.getbyid";
        public static final String HOSO_THANHTOAN_PHI = "most.06.tbdthanhtoanphi.create";

        //Lich su
        public static final String LICHSU_SEARCH = "most.06.tbdlichsu.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "most.06.tbdkqxl.getbyMaHoso";
        //Thong bao tham dinh
        public static final String TBTHAMDINH_SEARCH = "most.06.tbthamdinh.getbyIdHoso";
        //Ket qua yeu cau sua hoso
        public static final String KQYCS_HOSO = "most.06.tbdhsycsua.getbyMaHoso";
        //Ket qua yeu cau rut hoso
        public static final String KQYCR_HOSO = "most.06.tbdhsycrut.getbyMaHoso";

        //Danh muc
        public static final String DANHMUC_DONGVIPX = "most.06.danhmuc.dongvipx";
        public static final String DANHMUC_HINHTHUCCAP = "most.06.danhmuc.hinhthucap";
        public static final String DANHMUC_TRANGTHAI = "most.06.danhmuc.trangthai";
        public static final String DANHMUC_HOATDODV = "most.06.danhmuc.hoatdodonvi";
        public static final String DANHMUC_NGUONKIN = "most.06.danhmuc.nguonkin";
        public static final String DANHMUC_TEPTIN = "most.06.danhmuc.teptin";
        public static final String DANHMUC_NGUONHO = "most.06.danhmuc.nguonho";
        public static final String DANHMUC_LYDODN = "most.06.danhmuc.lydodenghi";
        public static final String DANHMUC_TINHTHANH = "most.06.danhmuc.tinhthanh";
        public static final String DANHMUC_CUAKHAU = "most.06.danhmuc.cuakhau";
        public static final String DANHMUC_CQXL = "most.06.danhmuc.coquanxl";
        public static final String DANHMUC_QUOCGIA = "most.06.danhmuc.quocgia";

        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "most.06.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "most.06.hoso.upload";

        public static final String DINHKEM_GET_BYID = "most.06.tbdhoso.dinhkem";

    }
    
     public interface MSG_TYPE {

        public static final String TYPE_10 = "10";
        public static final String TYPE_11 = "11";
        public static final String TYPE_12 = "12";
        public static final String TYPE_14 = "14";
        public static final String TYPE_15 = "15";
        public static final String TYPE_16 = "16";
        public static final String TYPE_18 = "18";
        public static final String TYPE_20 = "20";
        public static final String TYPE_21 = "21";
        public static final String TYPE_22 = "22";
        public static final String TYPE_23 = "23";
    }

    public interface MSG_FUNC {

        public static final String FUNCTION_01 = "01";
        public static final String FUNCTION_02 = "02";
        public static final String FUNCTION_03 = "03";
        public static final String FUNCTION_04 = "04";
        public static final String FUNCTION_05 = "05";
        public static final String FUNCTION_06 = "06";
        public static final String FUNCTION_07 = "07";
        public static final String FUNCTION_08 = "08";
        public static final String FUNCTION_09 = "09";
        public static final String FUNCTION_10 = "10";
        public static final String FUNCTION_11 = "11";
        public static final String FUNCTION_12 = "12";
        public static final String FUNCTION_13 = "13";
        public static final String FUNCTION_14 = "14";
        public static final String FUNCTION_15 = "15";
        public static final String FUNCTION_16 = "16";
        public static final String FUNCTION_18 = "18";
        public static final String FUNCTION_19 = "19";
        public static final String FUNCTION_20 = "20";
        public static final String FUNCTION_21 = "21";
        public static final String FUNCTION_22 = "22";
        public static final String FUNCTION_23 = "23";
        public static final String FUNCTION_24 = "24";
        public static final String FUNCTION_25 = "25";
    }

    public interface FILE_STATUS {

        public static final Long TAO_MOI = 0L;
        public static final String TAO_MOI_STR = "Mới tạo";

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

        public static final Long TU_CHOI_CAP_GIAY_PHEP = 6L;
        public static final String TU_CHOI_CAP_GIAY_PHEP_STR = "Từ chối cấp Giấy phép";

        public static final Long THU_HOI_GIAY_PHEP = 7L;
        public static final String THU_HOI_GIAY_PHEP_STR = "Thu hồi Giấy phép";

        public static final Long XAC_NHAN_THANH_TOAN = 9L;
        public static final String LE_PHI_THAM_DINH_STR = "Lệ phí thẩm định";

        public static final Long XAC_NHAN_THANH_TOANS = 8L;
        public static final String XAC_NHAN_THANH_TOAN_STR = "Xác nhận thanh toán";

        public static final Long TU_CHOI_TIEP_NHAN_HS = 10L;
        public static final String TU_CHOI_TIEP_NHAN_HS_STR = "Từ chối tiếp nhận hồ sơ";

        public static final Long RUT_HO_SO = 11L;
        public static final String RUT_HO_SO_STR = "Xin rút hồ sơ ";

        public static final Long CAP_GIAY_PHEP = 12L;
        public static final String CAP_GIAY_PHEP_STR = "Cấp Giấy phép";
    
    }

    
      public class Routes {

        public static final String ROOT_HOME = "/most/06";
    }
    
      public class Pages {

        public static final String HOME = "most.06.home";
        public static final String EDIT = "most.06.edit";
        public static final String VIEW = "most.06.view";
        public static final String VIEWKQ = "most.06.viewkq";
    }
        public class View {

        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
        public static final String VIEWKQ = "/viewkq";
    }
         public class DANHMUC {

        public static final String DM_DONGVIPX = "DM_DONGVIPX";
        public static final String DM_HINHTHUCCAP = "DM_HINHTHUCCAP";
        public static final String DM_HOATDODV = "DM_HOATDODV";
        public static final String DM_NGUONKIN = "DM_NGUONKIN";
        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";
        public static final String DM_TEPTIN = "DM_TEPTIN";
        public static final String DM_NGUONHO = "DM_NGUONHO";
        public static final String DM_LYDODN = "DM_LYDODN";
        public static final String DM_TINHTHANH = "DM_TINHTHANH";
        public static final String DM_CUAKHAU = "DM_CUAKHAU";
        public static final String DM_CQXL = "DM_CQXL";
        public static final String DM_QUOCGIA = "DM_QUOCGIA";
    }


    
}
