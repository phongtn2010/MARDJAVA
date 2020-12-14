<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript">
    //common
    NSWLang["stt"] = "<spring:message code="common.table.col.stt" />";
    NSWLang["moh_typea_didong"] = "<spring:message code="moh.typea.hoso.di_dong" />";
    NSWLang["moh_typea_hanhdong"] = "<spring:message code="moh.typea.cosobaohanh.hanh_dong" />";
    NSWLang["luu"] = "<spring:message code="moh.typea.button.luu" />";
    NSWLang["huy"] = "<spring:message code="conmon.button.huy" />";
    NSWLang["moh_typea_thong_tin_chung"] = "<spring:message code="moh.typea.thong_tin_chung" />";
    NSWLang["chon"] = "<spring:message code="common.chon" />"; 
    NSWLang["moh_typea_trangthietbi"] = "<spring:message code="moh.typea.hoso.trang_thiet_bi_y_te" />"; 
    NSWLang["common_msg_xoathietbi"] = "<spring:message code="moh.p06.common.msg.xoathietbi" />"; 
    NSWLang["common_msg_xoathanhcong"] = "<spring:message code="common.msg.xoathanhcong" />"; 
    NSWLang["them"] = "<spring:message code="moh.typea.button.them" />";  
    NSWLang["chon_file"] = "<spring:message code="moh.typea.button.chon_tep" />";  
    NSWLang["tep_dinh_kem"] = <spring:message code="moh.p06.common.tepdinhkem" />;      
    NSWLang["common_typea"] = <spring:message code="moh.p06.common.typea" />;   
    NSWLang["common_typea_error_khonghople"] = <spring:message code="moh.p06.common.error.khonghople" />;
    //header
     
    //thong tin van ban
    NSWLang["moh_typea_mst"] = "<spring:message code="moh.mst" />";
    NSWLang["moh_typea_sovanban"] = "<spring:message code="moh.typea.so_van_ban" />";
    NSWLang["moh_typea_don_vi_nhan_ho_so"] = "<spring:message code="moh.typea.don_vi_nhan_ho_so" />";
    NSWLang["moh_typea_tinh"] = "<spring:message code="moh.typea.hoso.tinh_thanh_pho" />";
    NSWLang["moh_typea_quanhuyen"] = "<spring:message code="moh.typea.hoso.quan_huyen" />";
    NSWLang["moh_typea_cmt"] = "<spring:message code="moh.typea.hoso.so_cmt" />";
    NSWLang["moh_typea_ngaycap"] = "<spring:message code="moh.typea.hoso.ngay_cap" />";
    //xacnhannopphi
    NSWLang["most_01_dondk_nguoi_nop"] = "<spring:message code="moh.typea.nopphi.nguoi_nop" />";
    NSWLang["most_01_nopphi_dien_thoai"] = "<spring:message code="moh.typea.hoso.dien_thoai" />";
    NSWLang["most_01_dondk_ngay_nop"] = "<spring:message code="moh.typea.nopphi.ngay_nop" />";
    NSWLang["most_01_nopphi_so_hoa_don"] = "<spring:message code="moh.typea.nopphi.so_hoa_don" />";
    NSWLang["most_01_nopphi_tongtien"] = "<spring:message code="moh.typea.nopphi.tong_tien" />";
    NSWLang["moh_06_xac_nhan_nop_phi"] = "<spring:message code="common.xac_nhan_nop_phi" />";   
    NSWLang["moh_06_xac_nhan_nop_phi_nop_bo_xung"] = "<spring:message code="moh.typea.nopphi.nop_bo_xung" />";   
    NSWLang["moh_06_xac_nhan_nop_phi_nop_moi"] = "<spring:message code="moh.typea.nopphi.nop_moi" />";   

    //themthietbi
    NSWLang["moh_typea_themtb_chitiettb"] = "<spring:message code="moh.typea.chitiettb" />";
    NSWLang["moh_typea_themtb_khaibaotb"] = "<spring:message code="moh.typea.themthietbi.khai_bao_thiet_bi" />";
    NSWLang["moh_typea_tenthietbi"] = "<spring:message code="moh.typea.thietbi.ten" />";
    NSWLang["moh_typea_themthietbi_loai_thiet_bi"] = "<spring:message code="moh.typea.themthietbi.loai_thiet_bi" />";
    NSWLang["moh_typea_chusohuu"] = "<spring:message code="moh.typea.themthietbi.chu_so_huu" />";    
    NSWLang["moh_typea_chusohuu"] = "<spring:message code="moh.typea.themthietbi.chu_so_huu" />";    
    NSWLang["moh_typea_dc_chu_so_huu"] = "<spring:message code="moh.typea.themthietbi.dc_chu_so_huu" />";    
    NSWLang["moh_typea_qg_chu_so_huu"] = "<spring:message code="moh.typea.themthietbi.qg_chu_so_huu" />";    
    NSWLang["moh_typea_thietbi_tieuchuanapdung"] = "<spring:message code="moh.typea.thietbi.tieu_chuan_ap_dung" />";    
    NSWLang["moh_typea_ten_chi_tiet"] = "<spring:message code="moh.typea.chitiettb.ten_chi_tiet" />";    
    NSWLang["moh_typea_thietbi_ma_san_pham"] = "<spring:message code="moh.typea.thietbi.ma_san_pham" />";    
    NSWLang["moh_typea_chitiettb_dong_goi"] = "<spring:message code="moh.typea.chitiettb.dong_goi" />";    
    NSWLang["moh_typea_hangsx"] = "<spring:message code="moh.typea.chitiettb.hang_sx" />";    
    NSWLang["moh_typea_dia_chi_sx"] = "<spring:message code="moh.typea.chitiettb.dia_chi_cssx" />";    
    NSWLang["moh_typea_nuoc_sx"] = "<spring:message code="moh.typea.chitiettb.nuoc_sx" />";    
    NSWLang["moh_typea_phu_luc"] = "<spring:message code="moh.typea.chitiettb.phu_luc" />";        
    NSWLang["moh_typea_phu_luc_giaithich"] = "<spring:message code="moh.typea.themthietbi.phuluc.giaithich" />";  
    NSWLang["moh_typea_phu_luc_giaithich_1"] = "<spring:message code="moh.typea.themthietbi.phuluc.giaithich.1" />";
    NSWLang["moh_typea_phu_luc_giaithich_2"] = "<spring:message code="moh.typea.themthietbi.phuluc.giaithich.2" />";
    NSWLang["moh_typea_phu_luc_giaithich_3"] = '<spring:message code="moh.typea.themthietbi.phuluc.giaithich.3" />';
    NSWLang["ten_co_so"] = "<spring:message code="moh.typea.hoso.ten_co_so" />";   
    NSWLang["moh_typea_tep_tai_ve"] = "<spring:message code="moh.typea.tepdinhkem.tai_ve" />";        
    NSWLang["moh_typea_phan_nhom"] = "<spring:message code="moh.typea.chitiettb.phan_nhom" />";        
    NSWLang["moh_typea_nhom_tb"] = "<spring:message code="moh.typea.chitiettb.nhom_tb" />";    
    NSWLang["moh_typea_nhieu_cssx"] = "<spring:message code="moh.typea.chitiettb.nhieu_cssx" />";    
    NSWLang["moh_typea_phannhom_donle"] = "<spring:message code="moh.06.chitiettb.phannhom.donle" />"; 
    NSWLang["moh_typea_phannhom_vitro"] = "<spring:message code="moh.06.chitiettb.phannhom.ivd" />";        
    NSWLang["moh_typea_phannhom_ivd"] = "<spring:message code="moh.06.chitiettb.phannhom.vitro" />";                
    NSWLang["moh_typea_phannhom_cumttbytkhac"] = "<spring:message code="moh.06.chitiettb.phannhom.cumttbytkhac" />";        
    NSWLang["moh_typea_phannhom_hethongttbyt"] = "<spring:message code="moh.06.chitiettb.phannhom.hethongttbyt" />";        
    NSWLang["moh_typea_phannhom_hottbyt"] = "<spring:message code="moh.06.chitiettb.phannhom.hottbyt" />";        
    NSWLang["moh_06_nhomtb_sd1lan"] = "<spring:message code="moh.06.chitiettb.nhomtb.sd1lan" />";        
    NSWLang["moh_06_nhomtb_tbkhac"] = "<spring:message code="moh.06.chitiettb.nhomtb.tbkhac" />";        
    NSWLang["moh_06_nhieucssx_mot"] = "<spring:message code="moh.06.chitiettb.nhieucssx.mot" />";        
    NSWLang["moh_06_nhieucssx_nhieu"] = "<spring:message code="moh.06.chitiettb.nhieucssx.nhieu" />";        


    //cosobaohanh
    NSWLang["moh_typea_co_so_bao_hanh"] = "<spring:message code="moh.typea.cosobaohanh" />";        
    NSWLang["moh_typea_co_so_bao_hanh_diachi"] = "<spring:message code="moh.typea.cosobaohanh.dia_chi" />";        
    NSWLang["moh_typea_them_moi_co_so_bao_hanh"] = "<spring:message code="moh.typea.cosobaohanh.themmoicosobaohanh" />";            

    // trang thai ho so
    NSWLang["moh_typea_trangthaihoso_choxachan"] = "<spring:message code="moh.06.hoso.trangthai.choxacnhan" />";        
    NSWLang["moh_typea_trangthaihoso_noplaiphi"] = "<spring:message code="moh.06.hoso.trangthai.noplaiphi" />";        
    NSWLang["moh_typea_trangthaihoso_dangxuly"] = "<spring:message code="moh.06.hoso.trangthai.dangxuly" />";        
    NSWLang["moh_typea_trangthaihoso_traketqua"] = "<spring:message code="moh.06.hoso.trangthai.traketqua" />";        
    NSWLang["moh_typea_trangthaihoso_thuhoi"] = "<spring:message code="moh.06.hoso.trangthai.thuhoi" />";        
</script>