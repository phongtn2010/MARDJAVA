/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.constant;

import org.springframework.core.env.Environment;


public class MT58Constant {
    static MT58Constant instance;
    public static final String EnableSign = "nsw.mt.58.sign";
    public static MT58Constant getInstance() {
        synchronized (MT58Constant.class) {
            return new MT58Constant();
        }
    }
    
    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MT58Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
    
    public String getBackendCommonApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(MT58Constant.API.BACKEND_COMMON) + environment.getRequiredProperty(key);
    }
    
    public interface API {

        public static final String BACKEND_COMMON = "nsw.common.url";
        public static final String BACKEND = "mt.api.backend";
        
        //Ho so
        public static final String HOSO_INSERT = "mt.58.tbdhoso58.insert";
        public static final String HOSO_UPDATE = "mt.58.tbdhoso58.update";
        public static final String HOSO_STATUS = "mt.58.tbdhoso58.status";
        public static final String HOSO_SEARCH = "mt.58.tbdhoso58.search";
        public static final String HOSO_DELETE = "mt.58.tbdhoso58.delete";
        public static final String HOSO_OWNER = "mt.58.tbdhoso58.owner";
        public static final String HOSO_SEND = "mt.58.api.hoso.send";
        public static final String HOSO_GET_BYID = "mt.58.tbdhoso58.getbyid";
        public static final String HOSO_GET_BYCODE = "mt.58.tbdhoso58.getbymahoso";
        public static final String HOSO_THONGBAO = "mt.58.api.vanban";
        
        //Lich su
        public static final String LICHSU_SEARCH = "mt.58.tbdlichsu58.search";
        
        //Ket qua xu ly
        public static final String KQXL_SEARCH = "mt.58.tbdkqxl58.data";
        //Ket qua yeu cau sua van ban
        public static final String KQYCS_VB = "mt.58.tbdvbycsua58.data";
        //Ket qua yeu cau tra lai van ban
        public static final String KQYCTL_VB = "mt.58.tbdvbyctralai58.data";
        
        //Danh muc
        public static final String DANHMUC_DONVIXULY = "mt.58.danhmuc.donvixuly";
        public static final String DANHMUC_LOAIFILE = "mt.58.danhmuc.tailieu";
        public static final String DANHMUC_TRANGTHAI = "mt.58.danhmuc.trangthai";
        public static final String DANHMUC_LOAIHINH_DENGHI_CAP = "mt.58.danhmuc.loaihinhdenghi";
        public static final String DANHMUC_TUYENVANTAI = "mt.58.danhmuc.tuyenvantai";
        public static final String DANHMUC_TUYENVANTAI_CHITIET = "mt.58.danhmuc.tuyenvantai.chitiet";
        public static final String DANHMUC_CUAKHAUDENDI = "mt.58.danhmuc.cuakhaudendi";
        public static final String DANHMUC_CUAKHAUNHAPXUAT = "mt.58.danhmuc.cuakhaunhapxuat";
        
        //Upload and download file
        public static final String ATTACHMENT_DOWNLOAD = "mt.58.api.hoso.download";
        public static final String ATTACHMENT_UPLOAD = "mt.58.api.hoso.upload";
        
        //Dinh kem
        public static final String DINHKEM_GET_BYID = "mt.58.tbdhoso58.dinhkem";
        
                
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
        public static final String HOME = "mt.58.home";
        public static final String EDIT = "mt.58.edit";
        public static final String VIEW = "mt.58.view";
    }

    public class Routes {
        public static final String URI_THU_TUC_58 = "/mt/58";
        public static final String URI_THU_TUC_59 = "/mt/59";
        public static final String URI_THU_TUC_60 = "/mt/60";
    }
    
    public class View {        
        public static final String HOME = "/{code}/home";
        public static final String INDEX = "/{code}/index";
        public static final String EDIT = "/{code}/edit";
        public static final String VIEW = "/{code}/view";
    }
    
    public class ViewType {

        public static final String HOME = "home";
        public static final String EDIT = "edit";
        public static final String VIEW = "view";
    }
    
    public class DANHMUC {

        public static final String HS_TRANGTHAI = "HS_TRANGTHAI";
        public static final String HS_DONVIXULY = "HS_DONVIXULY";
        public static final String HS_LOAIHINH_DENGHI_CAP = "HS_LOAIHINH_DENGHI_CAP";
        public static final String HS_LOAIFILE = "HS_LOAIFILE";
    }
}
