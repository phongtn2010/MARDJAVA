package com.nsw.mard.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard01Constant {
    public static final String EnableSign = "nsw.mard.01.sign";
    static Mard01Constant instance;
    public static Mard01Constant getInstance() {
        synchronized (Mard01Constant.class) {
            if (instance == null) {
                instance = new Mard01Constant();
            }
            return instance;
        }
    }
    @Autowired
    Environment environment;

    public interface FileStatus {

        Long TAO_MOI = 0L;
        Long CHO_TIEP_NHAN = 1L;
        Long DA_TIEP_NHAN = 2L;
        Long DA_CAP_GIAY_CHUNG_NHAN = 3L;
        Long YEU_CAU_SUA_DOI_BO_SUNG = 4L;
        Long BI_TU_CHOI = 6L;
        Long CHO_TIEP_NHAN_YEU_CAU_SUA_HO_SO = 7L;
        Long DONG_Y_SUA = 8L;
        Long YEU_CAU_RUT_HO_SO = 9L;
        Long DA_RUT_HO_SO = 10L;
        Long CHO_TIEP_NHAN_YCS_GCN = 11L;
        Long CHO_TIEP_NHAN_YC_HUY_GCN = 15L;
        Long DONG_Y_HUY_GCN = 13L;
        Long LO_HANG_KHONG_DAT_CHAT_LUONG = 15L;
        Long TU_CHOI_RUT = 16L;

    }


    public interface MSG_TYPE {

        String TYPE_10 = "10";
        String TYPE_11 = "11";
        String TYPE_12 = "12";
        String TYPE_13 = "13";
        String TYPE_14 = "14";
        String TYPE_15 = "15";
        String TYPE_16 = "16";
        String TYPE_17 = "17";
        String TYPE_18 = "18";
    }

    public interface MSG_FUNC {

        String FUNC_01 = "01";
        String FUNC_02 = "02";
        String FUNC_03 = "03";
        String FUNC_04 = "04";
        String FUNC_05 = "05";
        String FUNC_06 = "06";
        String FUNC_07 = "07";
        String FUNC_08 = "08";
        String FUNC_09 = "09";
        String FUNC_10 = "10";
        String FUNC_11 = "11";
        String FUNC_12 = "12";
        String FUNC_13 = "13";
        String FUNC_14 = "14";
        String FUNC_15 = "15";
        String FUNC_16 = "16";
        String FUNC_17 = "17";
    }

    public abstract static class Page {
        private Page() {
        }

        public static final String HOME = "mard.01.home";
        public static final String CREATE = "mard.01.create";
        public static final String EDIT_REQUEST = "mard.01.ycs";
        public static final String EDIT = "mard.01.edit";
        public static final String VIEW = "mard.01.view";
    }
    public abstract static class API {
        private API(){

        }

        public static final String ROLL_BACK = "mard.01.hoso.rollback";
        public static final String COUNTRY_GET = "mard.01.danhmuc.quocgia";
        public static final String PORT_GET = "mard.01.danhmuc.cuakhau";
        public static final String PROVINCE_GET = "mard.01.danhmuc.tinhthanh";
        public static final String BACKEND = "mard.api.backend.dev";
        public static final String UOMS_GET = "mard.01.unit";
        public static final String DANHMUC_DONVIXULY = "mard.01.danhmuc.dvxl";
        public static final String DANHMUC_TRANGTHAI = "mard.01.danhmuc.trangthai";
        public static final String THONGBAO_KHONGDAT_YCXK = "mard.01.giayphep.kd_ycxk";
        public static final String DOWNLOAD_DINHKEM = "mard.01.dinhkem.download";
        public static final String DOWNLOAD_DINHKEM_FEE = "mard.01.dinhkem.fee.download";
        public static final String CREATE_HOSO = "mard.01.hoso.taomoi";
        public static final String SAVE_BEFORE_UPDATE = "mard.01.hoso.save_before_update";
        public static final String UPDATE_ONLY = "mard.01.hoso.update_only";
        public static final String SEND_HOSO = "mard.01.hoso.send";
        public static final String SAVE_HOSO = "mard.01.hoso.save";
        public static final String YCS_HOSO = "mard.01.hoso.ycs";
        public static final String XINRUT_HOSO = "mard.01.hoso.xinrut";
        public static final String XINRUT_HOSO_TTN = "mard.01.hoso.xinrut.ttn";
        public static final String DANHMUC_FILE_DINHKEM = "mard.01.danhmuc.file_dinhkem";
        public static final String ATTACHMENT_CREATE = "mard.01.dinhkem.tao";
        public static final String HOSO_GET_BY_FILTER = "mard.01.hoso.timkiem";
        public static final String HOSO_APPHI = "mard.01.hoso.apphi";
        public static final String HOSO_LICHSU = "mard.01.hoso.lichsu";
        public static final String HOSO_GIAYPHEP = "mard.01.hoso.giayphep";
        public static final String HOSO_DELETE = "mard.01.hoso.delete";
        public static final String YEUCAUSUA_GCN = "mard.01.hoso.editCer";
        public static final String YEUCAUHUY_GCN = "mard.01.hoso.cancelCer";
        public static final String GET_XML = "mard.01.getXml";
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Mard01Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
}
