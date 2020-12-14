/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard08Constant {

    static Mard08Constant instance;
    public static Mard08Constant getInstance(){
        synchronized(Mard08Constant.class){
            return new Mard08Constant();
        }
    }
    @Autowired
    Environment environment;
    
    public interface Page {
        public static final String HOME = "mard.08.home";
        public static final String CREATE = "mard.08.create";
        public static final String CERT = "mard.08.cert";
        public static final String EDIT = "mard.08.edit";
        public static final String YCS = "mard.08.ycs";
        public static final String VIEW = "mard.08.view";
    }

    public interface API {
        public static final String BACKEND = "mard.api.backend";
        public static final String COUNTRY_GET = "mard.08.danhmuc.quocgia";
        public static final String PROVINCE_GET = "mard.08.danhmuc.tinhthanh";
        public static final String PORT_GET = "mard.08.danhmuc.port";
        public static final String UOM_TYPE_GET = "mard.08.danhmuc.uomtype";
        public static final String UOMS_GET = "mard.08.danhmuc.uoms";
        public static final String ATTACHMENT_TYPE_GET = "mard.08.danhmuc.attachmenttype";
        public static final String LIST_STATUS_HOSO_GET = "mard.08.tbdhoso08.statushoso";
        public static final String LIST_HOSO_TYPE_GET = "mard.08.tbdhoso08.hosotype";
        public static final String LIST_DOCUMENT_TYPE_GET = "mard.08.tbdhoso08.documenttype";
        public static final String HOSO_CREATE = "mard.08.tbdhoso08.create";
        public static final String HOSO_EDIT = "mard.08.tbdhoso08.edit";
        public static final String HOSO_SEND = "mard.08.tbdhoso08.send";
        public static final String HOSO_CANCEL = "mard.08.tbdhoso08.cancel";
        public static final String HOSO_DELETE = "mard.08.tbdhoso08.delete";
        public static final String HOSO_GET_BY_FILTER = "mard.08.tbdhoso08.findfilter";
        public static final String HISTORY_BY_HS_CODE = "mard.08.tbdhoso08.history_by_hs_code";
        public static final String ATTACHMENT_CREATE = "mard.08.tbdhoso08.attachmentcreate";
        public static final String ATTACHMENT_DOWNLOAD = "mard.08.tbdhoso08.attachmentdownload";
        public static final String ATTACHMENT_DELETE = "mard.08.tbdhoso08.attachmentdelete";
        public static final String ATTACHMENT_FIND_BY_ID = "mard.08.tbdhoso08.attachmentfindbyid";
        public static final String ATTACHMENT_FIND_BY_MA_HS_GET = "mard.08.tbdhoso08.attachmentfindbymahs";
        public static final String LICENSE_VIEW_GET = "mard.08.tbdhoso08.viewlicense";
        public static final String GIAYPHEP_GET = "mard.08.giayphep.get";
        public static final String GIAYPHEP_GET_BY_TAX_CODE = "mard.08.giayphep.get_by_tax_code";
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(API.BACKEND) + environment.getRequiredProperty(key);
    }
}
