package com.nsw.mard.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard01Constant {
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
        public static final String COUNTRY_GET = "mard.01.danhmuc.quocgia";
        public static final String PORT_GET = "mard.01.danhmuc.cuakhau";
        public static final String PROVINCE_GET = "mard.01.danhmuc.tinhthanh";
        public static final String BACKEND = "mard.api.backend";
        public static final String UOMS_GET = "mard.01.unit";
        public static final String DANHMUC_DONVIXULY = "mard.01.danhmuc.dvxl";
        public static final String DANHMUC_TRANGTHAI = "mard.01.danhmuc.trangthai";
        public static final String THONGBAO_KHONGDAT_YCXK = "mard.01.giayphep.kd_ycxk";
        public static final String DOWNLOAD_DINHKEM = "mard.01.dinhkem.download";
        public static final String DOWNLOAD_DINHKEM_FEE = "mard.01.dinhkem.fee.download";
        public static final String CREATE_HOSO = "mard.01.hoso.taomoi";
        public static final String SEND_HOSO = "mard.01.hoso.send";
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
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Mard01Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
}
