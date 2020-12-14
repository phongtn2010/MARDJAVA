/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.constant;

import org.springframework.core.env.Environment;

public class MTqlptConstant {

    static MTqlptConstant instance;
    public static final String EnableSign = "nsw.mt.qlpt.sign";

    public static MTqlptConstant getInstance() {
        synchronized (MTqlptConstant.class) {
            return new MTqlptConstant();
        }
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MTqlptConstant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MTqlptConstant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mt.api.backend";

        //Phương tiện
        public static final String PHUONGTIEN_INSERT = "mt.qlpt.tbdqlphuongtien.insert";
        public static final String PHUONGTIEN_UPDATE = "mt.qlpt.tbdqlphuongtien.update";
        public static final String PHUONGTIEN_SEARCH = "mt.qlpt.tbdqlphuongtien.search";
        public static final String PHUONGTIEN_DELETE = "mt.qlpt.tbdqlphuongtien.delete";
        public static final String PHUONGTIEN_OWNER = "mt.qlpt.tbdqlphuongtien.owner";
        public static final String PHUONGTIEN_GET_BYBKSXE = "mt.qlpt.tbdqlphuongtien.getbybksxe";
        public static final String PHUONGTIEN_GET_BYIDPHUONGTIEN = "mt.qlpt.tbdqlphuongtien.getbyidphuongtien";

        //Danh muc
        public static final String DANHMUC_NHANHIEU = "mt.qlpt.danhmuc.nhanhieu";
        public static final String DANHMUC_LAOIHINH = "mt.qlpt.danhmuc.loaihinh";
        public static final String DANHMUC_MAUSON = "mt.qlpt.danhmuc.mauson";
        public static final String DANHMUC_QUOCGIA = "mt.qlpt.danhmuc.quocgia";

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
        public static final Long YC_SUA_VANBAN = 6L;
        public static final String YC_SUA_VANBAN_STR = "Yêu cầu xin sửa văn bản";
        public static final Long DONG_Y_YC_SUA_VB = 7L;
        public static final String DONG_Y_YC_SUA_VB_STR = "Đồng ý yêu cầu sửa văn bản";
        public static final Long TU_CHOI_CAP_VANBAN = 8L;
        public static final String TU_CHOI_CAP_VANBAN_STR = "Từ chối cấp văn bản";
        public static final Long DUOC_CAP_VANBAN = 9L;
        public static final String DUOC_CAP_VANBAN_STR = "Thông báo cấp văn bản";
        public static final Long DA_CAP_LAI_VANBAN = 10L;
        public static final String DA_CAP_LAI_VANBAN_STR = "Thông báo điều chỉnh văn bản";
        public static final Long DA_THU_HOI = 11L;
        public static final String DA_THU_HOI_STR = "Thông báo thu hồi văn bản";
        public static final Long TU_CHOI_YC_SUA_VB = 12L;
        public static final String TU_CHOI_YC_SUA_VB_STR = "Từ chối yêu cầu sửa văn bản";
        public static final Long YC_TRA_LAI_KQ = 13L;
        public static final String YC_TRA_LAI_KQ_STR = "Yêu cầu xin trả lại kết quả";
    }

    public class Pages {

        public static final String HOME = "mt.qlpt.home";
        public static final String EDIT = "mt.qlpt.edit";
        public static final String VIEW = "mt.qlpt.view";
    }

    public class Routes {

        public static final String ROOT = "/mt/qlpt";
    }

    public class View {

        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String EDIT = "/edit";
        public static final String VIEW = "/view";
    }

    public class DANHMUC {

        public static final String PT_NHANHIEU = "PT_NHANHIEU";
        public static final String PT_QUOCGIA = "PT_QUOCGIA";
        public static final String PT_LOAIHINH = "PT_LOAIHINH";
        public static final String PT_MAUSON = "PT_MAUSON";

    }

}
