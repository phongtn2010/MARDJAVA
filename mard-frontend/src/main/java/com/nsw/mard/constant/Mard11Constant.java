/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.constant;

import com.nsw.most.constant.ThuTuc01Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard11Constant {

    static Mard11Constant instance;

    public static Mard11Constant getInstance() {
        synchronized (Mard11Constant.class) {
            return new Mard11Constant();
        }
    }
    @Autowired
    Environment environment;

    public static final Long UNIT_SYSTEMID = 11l;

    public interface FileServices {

        public static final String USER = "admin";
       // public static final String PASSWORD = "94373d59-f925-4e33-b6e2-ae6206dbbab2";
        public static final String MINISTRY = "mard";
        public static final String PROCEDURE = "11";
    }

    public interface API {

        public static final String BACKEND = "mard.api.backend";
        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String tbddinhkem11_create = "mard.11.tbddinhkem11.create";
        public static final String tbddinhkem11_get = "mard.11.tbddinhkem11.get";
        public static final String tbddinhkem11_download = "mard.11.tbddinhkem11.download";
        public static final String tbdhoso11_create = "mard.11.tbdhoso11.create";
        public static final String tbdhoso11_get = "mard.11.tbdhoso11.get";
        public static final String tbdhoso11_search = "mard.11.tbdhoso11.search";
        public static final String tbdhoso11_status = "mard.11.tbdhoso11.status";
        public static final String tbdhoso11_requestUpdate = "mard.11.tbdhoso11.requestUpdate";
        public static final String tbdhoso11_cancel = "mard.11.tbdhoso11.cancel";
        public static final String tbdhoso11_sendAll = "mard.11.tbdhoso11.sendAll";
        public static final String tbdhoso11_sendPayFee = "mard.11.tbdhoso11.sendPayFee";
        public static final String tbdhoso11_delete = "mard.11.tbdhoso11.delete";
        public static final String tbdhoso11_validate = "mard.11.tbdhoso11.validate";
        public static final String tbdhoso11_owner = "mard.11.tbdhoso11.owner";
        public static final String tbdtbapphi11_get = "mard.11.tbdtbapphi11.tbphi";

        public static final String danhmuc_dinhkem = "mard.11.danhmuc.dinhkem";
        public static final String danhmuc_unit = "mard.11.danhmuc.unit";
        public static final String danhmuc_quocgia = "mard.11.danhmuc.quocgia";
        public static final String danhmuc_cuakhau = "mard.11.danhmuc.cuakhau";
        public static final String danhmuc_donvixuly = "mard.11.danhmuc.donvixuly";
        public static final String danhmuc_tinhthanh = "mard.11.danhmuc.tinhthanh";

        public static final String tbdtbtt11_create = "mard.11.tbdtbtt11.create";

        public static final String quarantine_get = "mard.11.quarantine.get";
        public static final String quarantine_goods = "mard.11.quarantine.goods";
        public static final String quarantine_document = "mard.11.quarantine.document";

        public static final String gcn_mau14a = "mard.11.gcn.mau14a";
        public static final String gcn_mau14b = "mard.11.gcn.mau14b";

        public static final String tbdtbapphi11_tbphi = "mard.11.tbdtbapphi11.tbphi";
        public static final String tbdkqtd11_kqtd = "mard.11.tbdkqtd11.kqtd";

        public static final String tbdxinruths11_ruths = "mard.11.tbdxinruths11.ruths";
        public static final String tbdycsuahs11_suahs = "mard.11.tbdycsuahs11.suahs";
        public static final String tbdtbxllh11_lohang = "mard.11.tbdtbxllh11.lohang";
        public static final String tbdyccttgcn11_ycgcn = "mard.11.tbdyccttgcn11.ycgcn";
        public static final String tbdtcsuagcn11_tcsuagcn = "mard.11.tbdtcsuagcn11.tcsuagcn";
        public static final String tbdtcsuagcn11_create = "mard.11.tbdtcsuagcn11.create";
        public static final String tbdgcn11_send = "mard.11.tbdgcn11.send";
        public static final String danhmuc_donggoi = "mard.11.danhmuc.donggoi";
        public static  final String danhmuc_chuyencho = "mard.11.danhmuc.chuyencho";
        
    }

    public interface UNIT_TYPE {

        public static final Long SOLUONG = 4l;
        public static final Long TRONGLUONG = 4l;
        public static final Long THETICH = 4l;
    }

    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Mard11Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
    
    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(Mard11Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }

    public interface Page {

        public static final String HOME = "mard.11.home";
        public static final String CREATE = "mard.11.create";
        public static final String VIEW = "mard.11.view";
        public static final String CERT = "mard.11.cert";
    }
}
