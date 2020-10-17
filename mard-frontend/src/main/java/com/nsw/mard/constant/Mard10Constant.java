/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.constant;

import com.nsw.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Mard10Constant {
    
    static Mard10Constant instance;
    public static Mard10Constant getInstance(){
        synchronized(Mard10Constant.class){
            return new Mard10Constant();
        }
    }
    @Autowired
    Environment environment;
	
	public static final Long UNIT_SYSTEMID = 10l;

    public interface FileServices {
        public static final String USER = "admin";
       // public static final String PASSWORD = "94373d59-f925-4e33-b6e2-ae6206dbbab2";
        public static final String MINISTRY = "mard";
        public static final String PROCEDURE = "10";
    }

    public interface API {
        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mard.api.backend";
        public static final String tbddinhkem10_create = "mard.10.tbddinhkem10.create";
        public static final String tbddinhkem10_get = "mard.10.tbddinhkem10.get";
        public static final String tbddinhkem10_download = "mard.10.tbddinhkem10.download";
        public static final String tbdhoso10_create = "mard.10.tbdhoso10.create";
        public static final String tbdhoso10_get ="mard.10.tbdhoso10.get";
        public static final String tbdhoso10_search = "mard.10.tbdhoso10.search";
        public static final String tbdhoso10_status = "mard.10.tbdhoso10.status";
        public static final String tbdhoso10_requestUpdate = "mard.10.tbdhoso10.requestUpdate";
        public static final String tbdhoso10_cancel = "mard.10.tbdhoso10.cancel";
        public static final String tbdhoso10_sendAll = "mard.10.tbdhoso10.sendAll";
        public static final String tbdhoso10_sendPayFee = "mard.10.tbdhoso10.sendPayFee";
        public static final String tbdhoso10_delete = "mard.10.tbdhoso10.delete";
        public static final String tbdhoso10_validate = "mard.10.tbdhoso10.validate";
        public static final String tbdhoso10_owner = "mard.10.tbdhoso10.owner";
        
        public static final String danhmuc_dinhkem = "mard.10.danhmuc.dinhkem";
        public static final String danhmuc_unit = "mard.10.danhmuc.unit";
        public static final String danhmuc_quocgia = "mard.10.danhmuc.quocgia";
        public static final String danhmuc_cuakhau = "mard.10.danhmuc.cuakhau";
        public static final String danhmuc_donvixuly = "mard.10.danhmuc.donvixuly";
        
        public static final String tbdtbtt10_create = "mard.10.tbdtbtt10.create";
        public static final String tbdxinsuagcn10_create = "mard.10.tbdxinsuagcn10.create";
        
        public static final String quarantine_get = "mard.10.quarantine.get";
        public static final String quarantine_goods = "mard.10.quarantine.goods";
        public static final String quarantine_document = "mard.10.quarantine.document";
        
        public static final String gcn_mau14a = "mard.10.gcn.mau14a";
        public static final String gcn_mau14b = "mard.10.gcn.mau14b";
        
        public static final String tbdtbapphi10_tbphi = "mard.10.tbdtbapphi10.tbphi";
        public static final String tbdkqtd10_kqtd = "mard.10.tbdkqtd10.kqtd";
        
        public static final String tbdxinruths10_ruths = "mard.10.tbdxinruths10.ruths";
        public static final String tbdycsuahs10_suahs ="mard.10.tbdycsuahs10.suahs";
        public static final String tbdlohangxl10_lohang = "mard.10.tbdlohangxl10.lohang";
        public static final String tbdxinsuagcn10_xinsuagcn = "mard.10.tbdxinsuagcn10.xinsuagcn";
    }
    
    public interface UNIT_TYPE{
        public static final Long SOLUONG = 4l;
        public static final Long TRONGLUONG = 4l;
    }
    
    public String getApiUrl(Environment environment, String key){
        return environment.getRequiredProperty(Mard10Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
    
    public interface Page {
        public static final String HOME = "mard.10.home";
        public static final String CREATE = "mard.10.create";
        public static final String VIEW = "mard.10.view";
        public static final String PHIEUTIEPNHAN = "mard.10.tiepnhan";
    }
    
    public static final String JSON_IMPORT = "[\n" +
"  {\n" +
"    \"reader\": \"hanghoa\",\n" +
"    \"sheetIndex\": 2,\n" +
"    \"feed\": \"table\",\n" +
"    \"start\": 3,\n" +
"    \"end\": 0,\n" +
"    \"data\": [\n" +
"      {\n" +
"        \"col\": \"A\",\n" +
"        \"field\": \"fiStt\",\n" +
"        \"type\": \"Long\",\n" +
"        \"nullBreak\": true\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"field\": \"fiTenHh\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"C\",\n" +
"        \"field\": \"fiSoluong\",\n" +
"        \"type\": \"BigDecimal\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"field\": \"fiMdvSl\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"E\",\n" +
"        \"field\": \"fiNoiSx\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"F\",\n" +
"        \"field\": \"fiTlTinh\",\n" +
"        \"type\": \"BigDecimal\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"G\",\n" +
"        \"field\": \"fiMaTlTinh\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"H\",\n" +
"        \"field\": \"fiTlBi\",\n" +
"        \"type\": \"BigDecimal\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"I\",\n" +
"        \"field\": \"fiMaTlBi\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"J\",\n" +
"        \"field\": \"fiLoaiBb\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"K\",\n" +
"        \"field\": \"fiSoHd\",\n" +
"        \"type\": \"String\"\n" +
"      }\n" +
"    ]\n" +
"  },\n" +
"  {\n" +
"    \"reader\": \"hoso\",\n" +
"    \"sheetIndex\": 1,\n" +
"    \"feed\": \"random\",\n" +
"    \"data\": [\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 3,\n" +
"        \"field\": \"fiTenCty\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 3,\n" +
"        \"field\": \"fiEmailCty\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 4,\n" +
"        \"field\": \"fiDiachiCty\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 5,\n" +
"        \"field\": \"fiSdtCty\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 5,\n" +
"        \"field\": \"fiFaxCty\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 7,\n" +
"        \"field\": \"fiMaDvkd\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 7,\n" +
"        \"field\": \"fiMaDvgs\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 8,\n" +
"        \"field\": \"\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 8,\n" +
"        \"field\": \"fiSoVandon\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 9,\n" +
"        \"field\": \"fiSoTk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 10,\n" +
"        \"field\": \"fiTenDtxk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 11,\n" +
"        \"field\": \"fiMaQgxk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 11,\n" +
"        \"field\": \"fiTenQgxk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 12,\n" +
"        \"field\": \"fiMaCkxk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 12,\n" +
"        \"field\": \"fiTenCkxk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 13,\n" +
"        \"field\": \"fiTenDtnk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 14,\n" +
"        \"field\": \"fiTenQgnk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 14,\n" +
"        \"field\": \"fiMaCknk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"E\",\n" +
"        \"row\": 14,\n" +
"        \"field\": \"fiTenCknk\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 15,\n" +
"        \"field\": \"fiPtvt\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 16,\n" +
"        \"field\": \"fiMucdichSd\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 17,\n" +
"        \"field\": \"fiVbCtkd\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 18,\n" +
"        \"field\": \"fiDdkd\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 19,\n" +
"        \"field\": \"fiTgkd\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 19,\n" +
"        \"field\": \"fiTggs\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 20,\n" +
"        \"field\": \"fiDdgs\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 21,\n" +
"        \"field\": \"fiSobanGcn\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 23,\n" +
"        \"field\": \"fiNoiky\",\n" +
"        \"type\": \"String\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"D\",\n" +
"        \"row\": 23,\n" +
"        \"field\": \"fiNgayky\",\n" +
"        \"type\": \"Date\"\n" +
"      },\n" +
"      {\n" +
"        \"col\": \"B\",\n" +
"        \"row\": 24,\n" +
"        \"field\": \"fiNguoiky\",\n" +
"        \"type\": \"String\"\n" +
"      }\n" +
"    ]\n" +
"  }\n" +
"]";    
//
//    public interface Status {
//        public static final Long TAO_MOI = 0L;
//        public static final Long CHO_XAC_NHAN_NOP_PHI = 1L;
//        public static final Long YEU_CAU_NOP_LAI_PHI = 2L;
//        public static final Long DANG_XU_LY = 3L;
//        public static final Long DA_TRA_KET_QUA = 4L;
//        public static final Long THU_HOI_NOI_DUNG_CONG_BO = 5L;
//        public static final String TAOMOISTRING = "mard.10.hoso.trangthai.taomoi";
//        public static final String CHOXACNHANNOPPHI = "mard.10.hoso.trangthai.choxacnhan";
//        public static final String YEUCAUNOPLAIPHI = "mard.10.hoso.trangthai.yeucaunoplaiphi";
//        public static final String DANGXULY = "mard.10.hoso.trangthai.dangxuly";
//        public static final String DATRAKETQUA = "mard.10.hoso.trangthai.datraketqua";
//        public static final String THUHOI = "mard.10.hoso.trangthai.thuhoi";
//        
//    }
//
//    public interface DefaultValue {
//        public static final String VALUE_0S = "0";
//        public static final String VALUE_1S = "-1";
//        public static final Long VALUE_0L = 0L;
//    }
    
//    public interface BANTIN {
//        public static String BANTINGUI = "101";
//    }
//    
//    public interface RES_FUNTION{
//        public static String TIEPNHAN = "01";
//    }
}
