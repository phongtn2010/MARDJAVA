package com.nsw.mard.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard06Constant {
    static Mard06Constant instance;
    public static Mard06Constant getInstance() {
        synchronized (Mard06Constant.class) {
            if (instance == null) {
                instance = new Mard06Constant();
            }
            return instance;
        }
    }
    @Autowired
    Environment environment;

    public static class Page {
        private Page(){

        }
        public static final String HOME = "mard.06.home";
        public static final String CREATE = "mard.06.create";
        public static final String EDIT = "mard.06.edit";
        public static final String VIEW = "mard.06.view";
        public static final String YCS = "mard.06.ycs";
    }

    public static class API {
        private API(){

        }
        public static final String BACKEND = "mard.api.backend";
        public static final String COUNTRY_GET = "mard.06.danhmuc.quocgia";
        public static final String PORT_GET = "mard.06.danhmuc.port";
        public static final String UOMS_GET = "mard.06.danhmuc.uoms";
        public static final String PROVINCE_GET = "mard.06.danhmuc.tinhthanh";
        public static final String LIST_STATUS_HOSO_GET = "mard.06.danhmuc.statushoso";
        public static final String ATTACHMENT_TYPE_GET = "mard.06.danhmuc.attachtype";
        public static final String HOSO_CREATE = "mard.06.tbdhoso06.create";
        public static final String HOSO_SEND = "mard.06.tbdhoso06.send";
        public static final String HOSO_EDIT = "mard.06.tbdhoso06.edit";
        public static final String HOSO_GET_BY_FILTER = "mard.06.tbdhoso06.findfilter";
        public static final String HOSO_CANCEL = "mard.06.tbdhoso06.cancel";
        public static final String HOSO_DELETE = "mard.06.tbdhoso06.delete";
        public static final String ATTACHMENT_CREATE = "mard.06.dinhkem.create";
        public static final String ATTACHMENT_DOWNLOAD = "mard.06.dinhkem.download";
        public static final String ATTACHMENT_DELETE = "mard.06.dinhkem.delete";
        public static final String LICENSE_VIEW_GET = "mard.06.tbdhoso06.viewlicense";
        public static final String HISTORY_BY_HS_CODE = "mard.06.tbdhoso06.history";

    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(API.BACKEND) + environment.getRequiredProperty(key);
    }
}
