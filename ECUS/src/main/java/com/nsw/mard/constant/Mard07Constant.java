package com.nsw.mard.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard07Constant {
    private static Mard07Constant instance;
    public static Mard07Constant getInstance() {
        synchronized (Mard07Constant.class) {
            if (instance == null) {
                instance = new Mard07Constant();
            }
            return instance;
        }
    }

    @Autowired
    Environment environment;

    public static class Page {
        private Page(){

        }
        public static final String HOME = "mard.07.home";
        public static final String CREATE = "mard.07.create";
        public static final String EDIT = "mard.07.edit";
        public static final String VIEW = "mard.07.view";
        public static final String YCS = "mard.07.ycs";
    }

    public static class API {

        private API() {
        }

        public static final String BACKEND = "mard.api.backend";
        public static final String TIMKIEM = "mard.07.hoso.find";
        public static final String DANHSACH_TRANGTHAI = "mard.07.danhmuc.trangthai";
        public static final String DANHSACH_TINHTHANH = "mard.07.danhmuc.tinhthanh";
        public static final String DANHSACH_QUOCGIA = "mard.07.danhmuc.quocgia";
        public static final String DANHSACH_CUAKHAU = "mard.07.danhmuc.cuakhau";
        public static final String DANHSACH_DINHKEM = "mard.07.danhmuc.dinhkem";
        public static final String DANHSACH_MUCDICHSD = "mard.07.danhmuc.mdsd";
        public static final String DANHSACH_DONVITINH = "mard.07.danhmuc.unit";
        public static final String DANHMUC_HANGHOA = "mard.07.danhmuc.hanghoa";
        public static final String DANHSACH_GIAYPHEP06 = "mard.07.danhmuc.giayphep06";
        public static final String CREATE_HOSO = "mard.07.hoso.create";
        public static final String EDIT_HOSO = "mard.07.hoso.edit";
        public static final String SEND_HOSO = "mard.07.hoso.send";
        public static final String CANCEL_HOSO = "mard.07.hoso.cancel";
        public static final String DELETE_HOSO = "mard.07.hoso.delete";
        public static final String HOSO_APPHI = "mard.07.hoso.apphi";
        public static final String HOSO_LICHSUXULY = "mard.07.hoso.lichsu";
        public static final String LICENSE_GET = "mard.07.license.get";
        public static final String ATTACHMENT_CREATE = "mard.07.dinhkem.create";
        public static final String ATTACHMENT_DOWNLOAD = "mard.07.dinhkem.download";
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Mard07Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
}
