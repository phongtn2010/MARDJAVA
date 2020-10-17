/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.bca.constant;

import org.springframework.core.env.Environment;

public class BCA02Constant {

    static BCA02Constant instance;
    public static final String EnableSign = "nsw.bca.02.sign";

    public static BCA02Constant getInstance() {
        synchronized (BCA02Constant.class) {
            return new BCA02Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(BCA02Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(BCA02Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "bca.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "bca.02.tbdhoso.create";
        public static final String HOSO_UPDATE = "bca.02.tbdhoso.update";
        public static final String HOSO_STATUS = "bca.02.tbdhoso.status";
        public static final String HOSO_SEARCH = "bca.02.tbdhoso.search";
        public static final String HOSO_DELETE = "bca.02.tbdhoso.delete";
        public static final String HOSO_OWNER = "bca.02.tbdhoso.owner";
        public static final String HOSO_SEND = "bca.02.hoso.send";
        public static final String HOSO_GET_BYID = "bca.02.tbdhoso.getbyidhoso";
        public static final String HOSO_GET_BYCODE = "bca.02.tbdhoso.getbymahoso";
        public static final String HOSO_THONGBAO = "bca.02.tbdgiayphep.getbymahoso";
        public static final String HOSO_THONGBAO_CHITIET = "bca.02.tbdgiayphep.getbyid";
        public static final String HOSO_THANHTOAN_PHI = "bca.02.tbdthanhtoanphi.create";

        //Lich su
        public static final String LICHSU_SEARCH = "bca.02.tbdlichsu.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "bca.02.tbdkqxl.getbyMaHoso";
        //Ket qua yeu cau sua hoso
        public static final String KQYCS_HOSO = "bca.02.tbdhsycsua.getbyMaHoso";
        //Ket qua yeu cau rut hoso
        public static final String KQYCR_HOSO = "bca.02.tbdhsycrut.getbyMaHoso";
        //Ket qua yeu cau sua giay phep
        public static final String KQYCS_GIAYPHEP = "bca.02.tbdgiayphep.getbymahoso";

        //Danh muc
        public static final String DANHMUC_CQXL = "bca.02.danhmuc.cqxl";
        public static final String DANHMUC_LOAIFILE = "bca.02.danhmuc.tailieu";
        public static final String DANHMUC_TRANGTHAI = "bca.02.danhmuc.trangthai";
        public static final String DANHMUC_LOAINGUOI = "bca.02.danhmuc.loainguoi";
        public static final String DANHMUC_DONVI = "bca.02.danhmuc.donvi";

        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "bca.02.hoso.dowload";
        public static final String ATTACHMENT_UPLOAD = "bca.02.hoso.upload";

        public static final String DINHKEM_GET_BYID = "bca.02.tbdhoso.dinhkem";

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
        public static final Long YC_SUA_GIAYPHEP = 6L;
        public static final String YC_SUA_GIAYPHEP_STR = "Yêu cầu xin sửa giấy phép";
        public static final Long DONG_Y_YC_SUA_GP = 7L;
        public static final String DONG_Y_YC_SUA_GP_STR = "Đồng ý yêu cầu sửa giấy phép";
        public static final Long TU_CHOI_CAP_GIAYPHEP = 8L;
        public static final String TU_CHOI_CAP_GIAYPHEP_STR = "Từ chối cấp giấy phép";
        public static final Long DUOC_CAP_GIAYPHEP = 9L;
        public static final String DUOC_CAP_GIAYPHEP_STR = "Thông báo cấp giấy phép";
        public static final Long DA_CAP_LAI_GIAYPHEP = 10L;
        public static final String DA_CAP_LAI_GIAYPHEP_STR = "Thông báo điều chỉnh giấy phép";
        public static final Long DA_THU_HOI = 11L;
        public static final String DA_THU_HOI_STR = "Thông báo thu hồi giấy phép";
        public static final Long TU_CHOI_YC_SUA_GP = 12L;
        public static final String TU_CHOI_YC_SUA_GP_STR = "Từ chối yêu cầu sửa giấy phép";
        public static final Long YC_RUT_HOSO = 13L;
        public static final String YC_RUT_HOSO_STR = "Yêu cầu xin rút hồ sơ";
        public static final Long DONG_Y_YC_RUT = 14L;
        public static final String DONG_Y_YC_RUT_STR = "Đồng ý yêu cầu rút hồ sơ";
        public static final Long TU_CHOI_YC_RUT = 15L;
        public static final String TU_CHOI_YC_RUT_STR = "Từ chối yêu cầu rút hồ sơ";
        public static final Long YC_SUA_HOSO = 16L;
        public static final String YC_SUA_HOSO_STR = "Yêu cầu sửa hồ sơ";
        public static final Long DONG_Y_YC_SUA = 17L;
        public static final String DONG_Y_YC_SUA_STR = "Đồng ý yêu cầu xin sửa";
        public static final Long TU_CHOI_YC_SUA = 18L;
        public static final String TU_CHOI_YC_SUA_STR = "Từ chối yêu cầu xin sửa";
        public static final Long DA_DUYET = 19L;
        public static final String DA_DUYET_STR = "Đã duyệt";
        public static final Long THONG_BAO_PHI = 20L;
        public static final String THONG_BAO_PHI_STR = "Thông báo nộp phí";
        public static final Long DA_THANH_TOAN = 21L;
        public static final String DA_THANH_TOAN_STR = "Đã thanh toán phí";
        public static final Long YC_BS_PHI = 22L;
        public static final String YC_BS_PHI_STR = "Yêu cầu bổ sung thanh toán phí";
        public static final Long DA_THANH_TOAN_PHI = 23L;
        public static final String DA_THANH_TOAN_PHI_STR = "Xác nhận đã thanh toán phí";
    }

    public class Pages {

        public static final String HOME = "bca.02.home";
        public static final String EDIT = "bca.02.edit";
        public static final String VIEW = "bca.02.view";
        public static final String CHARGE = "bca.02.charge";
    }

    public class Routes {

        public static final String ROOT_HOME = "/bca/02";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
        public static final String CHARGE = "/charge";
    }

    public class DANHMUC {

        public static final String DM_CQXL = "DM_CQXL";
        public static final String DM_TRANGTHAI = "DM_TRANGTHAI";
        public static final String DM_LOAIFILE = "DM_LOAIFILE";
        public static final String DM_LOAINGUOI = "DM_LOAINGUOI";
        public static final String DM_DONVI = "DM_DONVI";
    }
}
