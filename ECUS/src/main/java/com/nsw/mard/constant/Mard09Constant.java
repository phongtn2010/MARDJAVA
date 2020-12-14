package com.nsw.mard.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard09Constant {

    static Mard09Constant instance;
    public static Mard09Constant getInstance(){
        synchronized(Mard09Constant.class){
            return new Mard09Constant();
        }
    }
    @Autowired
    Environment environment;

    public static class API {

        private API() {
        }

        public static final String ATTACHMENT_CREATE = "mard.09.tbdhoso09.attachmentcreate";
        public static final String ATTACHMENT_DELETE = "mard.09.tbdhoso09.attachmentdelete";
        public static final String ATTACHMENT_TYPE = "mard.09.tbdhoso09.attachmenttype";
        public static final String HISTORY_BY_HS_CODE = "mard.09.tbdhoso09.history_by_hs_code";
        public static final String APPHI_BY_HS_CODE = "mard.09.tbdhoso09.apphi_by_hs_code";
        public static final String TRANGTHAI_HS = "mard.09.tbdhoso09.trangthai_hs";
        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mard.api.backend";
        public static final String HOSO_SAVE = "mard.09.hoso.save";
        public static final String HOSO_UPDATE = "mard.09.hoso.update";
        public static final String GET_XND = "mard.09.hoso.xnd";
        public static final String HOSO_SEND = "mard.09.hoso.send";

        public static final String TBDHOSO_09_FINDFILTER = "mard.09.tbdhoso09.findfilter";
        public static final String TBDHOSO_09_XOA = "mard.09.tbdhoso09.xoa";
        public static final String PHANHOI_XNCL_KHONGDAT = "mard.09.xncl.phanhoi";
        public static final String XINSUA_GCN = "mard.09.gcn.xinsua";
        public static final String TBDHOSO_09_XINRUT = "mard.09.tbdhoso09.xinrut";
        public static final String GIAYPHEP_FIND = "mard.09.giayphep.find";
        public static final String GET_DOCTYPE_BY_FILTER = "mard.09.getdoctypes";
        public static final String GET_DANHSACH_TINNHTHANH = "mard.09.get_danhsach_tinnhthanh";

        public static final String DANHMUC_QUOCGIA = "mard.10.danhmuc.quocgia";
        public static final String DANHMUC_CUAKHAU = "mard.10.danhmuc.cuakhau";
        public static final String DANHMUC_DONVIXULY = "mard.09.danhmuc.donvixuly";

    }


    public String getApiUrl(Environment environment, String key){
        return environment.getRequiredProperty(Mard09Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }

    public static class Page {
        private Page() {
        }

        public static final String HOME = "mard.09.home";
        public static final String EDIT = "mard.09.edit";
        public static final String YCS = "mard.09.ycs";
        public static final String VIEW = "mard.09.xem";
    }

}
