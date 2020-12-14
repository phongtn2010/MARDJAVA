/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.constant;

import org.springframework.core.env.Environment;

public class MT42Constant {

    static MT42Constant instance;
    public static final String EnableSign = "nsw.mt.42.sign";

    public static MT42Constant getInstance() {
        synchronized (MT42Constant.class) {
            return new MT42Constant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MT13Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MT13Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mt.api.backend";

        //Ho so
        public static final String HOSO_INSERT = "mt.42.tbdhoso42.insert";
        public static final String HOSO_UPDATE = "mt.42.tbdhoso42.update";
        public static final String HOSO_STATUS = "mt.42.tbdhoso42.status";
        public static final String HOSO_SEARCH = "mt.42.tbdhoso42.search";
        public static final String HOSO_DELETE = "mt.42.tbdhoso42.delete";
        public static final String HOSO_OWNER = "mt.42.tbdhoso42.owner";
        public static final String HOSO_SEND = "mt.42.api.hoso.send";
        public static final String HOSO_GET_BYID = "mt.42.tbdhoso42.getbyid";
        public static final String HOSO_GET_BYCODE = "mt.42.tbdhoso42.getbymahoso";
        public static final String HOSO_THONGBAO = "mt.42.api.vanban";
        public static final String HOSO_THONGBAO_CHITIET = "mt.42.api.vanban.chitiet";
        public static final String HOSO_THONGBAO_LICHSU = "mt.42.api.vanban.lichsu";

        //Lich su
        public static final String LICHSU_SEARCH = "mt.42.tbdlichsu42.search";

        //Ket qua xu ly
        public static final String KQXL_SEARCH = "mt.42.tbdkqxl42.data";
        //Ket qua yeu cau sua van ban
        public static final String KQYCS_VB = "mt.42.tbdvbycsua42.data";
        //Ket qua yeu cau tra lai van ban
        public static final String KQYCTL_VB = "mt.42.tbdvbyctralai42.data";

        //Danh muc
        public static final String DANHMUC_DONVIXULY = "mt.42.danhmuc.donvixuly";
        public static final String DANHMUC_LOAIFILE = "mt.42.danhmuc.tailieu";
        public static final String DANHMUC_TRANGTHAI = "mt.42.danhmuc.trangthai";
        public static final String DANHMUC_NHANHIEU = "mt.42.danhmuc.nhanhieu";
        public static final String DANHMUC_TUYENVANTAI = "mt.42.danhmuc.tuyenvantai";
        public static final String DANHMUC_CUAKHAUDENDI = "mt.42.danhmuc.cuakhaudendi";
        public static final String DANHMUC_CUAKHAUNHAPXUAT = "mt.42.danhmuc.cuakhaunhapxuat";

        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "mt.42.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "mt.42.api.hoso.upload";
        
        //Dinh kem
        public static final String DINHKEM_GET_BYID = "mt.42.tbdhoso42.dinhkem";

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
        public static final Long YC_TRA_LAI_KQ = 13L;
        public static final String YC_TRA_LAI_KQ_STR = "Đã trả lại giấy phép";
    }

    public class Pages {

        public static final String HOME = "mt.42.home";
        public static final String EDIT = "mt.42.edit";
        public static final String VIEW = "mt.42.view";
    }

    public class Routes {
        public static final String ROOT = "/mt/42";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
    }

    public class DANHMUC {

        public static final String HS_TRANGTHAI = "HS_TRANGTHAI";
        public static final String HS_DONVIXULY = "HS_DONVIXULY";
        public static final String HS_CUAKHAUXUATNHAP = "HS_CUAKHAUXUATNHAP";
        public static final String HS_CUAKHAUDENDI = "HS_CUAKHAUDENDI";
        public static final String HS_TUYENVANTAI = "HS_TUYENVANTAI";
        public static final String HS_TUYENVANTAI_CHITIET = "HS_TUYENVANTAI_CHITIET";
        public static final String HS_NHANHIEU = "HS_NHANHIEU";
        public static final String HS_LOAIFILE = "HS_LOAIFILE";
    }

}
