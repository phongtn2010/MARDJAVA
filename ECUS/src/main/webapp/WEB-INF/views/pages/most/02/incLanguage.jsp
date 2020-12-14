<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript">
    NSWLang["most_02_ngaycap"] = "<spring:message code="most.02.common.ngaycap" />";
    NSWLang["most_02_diachikho"] = "<spring:message code="most.02.hoso.diadiemluugiu" />";
    NSWLang["most_01_dmhanghoa"] = "<spring:message code="most.01.dmhanghoa" />"; 
    NSWLang["most_02_tepdinhkem"] = "<spring:message code="most.02.common.filedinhkem" />";
    NSWLang["most_common_msg_xoahanghoa"] = "<spring:message code="most.common.msg.xoahanghoa" />";
    NSWLang["most_common_msg_xoahopdong"] = "<spring:message code="most.common.msg.xoahopdong" />";
    NSWLang["most_common_msg_xoavandong"] = "<spring:message code="most.common.msg.xoavandong" />";
    NSWLang["most_common_msg_xoahoadon"] = "<spring:message code="most.common.msg.xoahoadon" />";
    NSWLang["most_common_msg_xoadanhmuchanghoa"] = "<spring:message code="most.common.msg.xoadanhmuchanghoa" />";
    NSWLang["most_common_msg_xoagiaychungnhan"] = "<spring:message code="most.common.msg.xoagiaychungnhan" />";
    NSWLang["most_common_msg_xoatailieukhac"] = "<spring:message code="most.common.msg.xoatailieukhac" />"; 
    NSWLang["most_02_confirm_huy"] = "<spring:message code="most.02.msg.confirm.huy" />";
    NSWLang["most_02_tokhai_tontai"] = "<spring:message code="most.02.tokhai_tontai" />";
    NSWLang["most_02_label_BoKHCN"] = "<spring:message code="most.02.label.BoKHCN" />";
    NSWLang["most_02_label_vudoluong"] = "<spring:message code="most.02.label.vudoluong" />";
    NSWLang["most_02_label_xhcnvn"] = "<spring:message code="most.02.label.xhcnvn" />";
    NSWLang["most_02_label_doclaptudo"] = "<spring:message code="most.02.label.doclaptudo" />";
    
    //hoso
    NSWLang["most_02_coquanxuly"] = "<spring:message code="most.02.hoso.coquanxuly" />";
    NSWLang["most_02_hoso_masothue"] = "<spring:message code="common.ma_so_thue" />";
    NSWLang["most_02_hoso_diachi"] = "<spring:message code="most.02.hoso.diachi" />";
    NSWLang["most_02_hoso_nguoidaidien"] = "<spring:message code="most.02.hoso.nguoidaidien" />";  
    NSWLang["most_02_hoso_sodienthoai"] = "<spring:message code="most.02.hoso.sodienthoai" />";      
    NSWLang["most_02_hoso_tendoanhnghiep"] = "<spring:message code="most.02.hoso.tendoanhnghiep" />";        
    NSWLang["most_02_hoso_fax"] = "<spring:message code="most.02.hoso.fax" />";    
    
    
    //tokhai
    NSWLang["most_02_tokhai_popup_thongtintokhai"] = "<spring:message code="most.02.hoso.danhsachtokhai" />";
    NSWLang["most_02_tokhai_hanghoa_nhapkhau_so"] = "<spring:message code="most.02.tokhai.hanghoa_nhapkhau_so" />";        
    NSWLang["most_02_tokhai_ngay_dang_ky"] = "<spring:message code="most.02.tokhai.ngay_dang_ky" />";        
    NSWLang["most_02_tokhai_hanghoa_namdangky"] = "<spring:message code="most.02.tokhai.namdangky" />";        
    NSWLang["most_02_tokhai_hanghoa_ma_hai_quan"] = "<spring:message code="most.02.tokhai.ma_hai_quan" />";        
    NSWLang["most_02_tokhai_hanghoa_ngay_tao"] = "<spring:message code="most.02.tokhai.ngay_tao" />";        
    NSWLang["most_02_tokhai_command_xoa"] = "<spring:message code="most.02.tokhai.command.xoa" />";        
    NSWLang["most_02_tokhai_command_xem"]  = "<spring:message code="most.02.tokhai.command.xem" />";        
    NSWLang["most_02_tokhai_hanghoa_thongtintimkiem"] = "<spring:message code="most.02.tokhai.thongtintimkiem" />";        
    NSWLang["most_02_tokhai_hanghoa_ketquatimkiem"] = "<spring:message code="most.02.tokhai.ketquatimkiem" />";        
    NSWLang["most_02_tokhai_command_xoa"] = "<spring:message code="most.02.tokhai.command.xoa" />";
    NSWLang["most_02_tokhai_command_xem"] = "<spring:message code="most.02.tokhai.command.xem" />";
    NSWLang["most_02_tokhai_command_sua"] = "<spring:message code="most.02.tokhai.command.sua" />";
    
    //hopdong
    NSWLang["most_02_hopdong_ngayhopdong"] = "<spring:message code="most.02.hopdong.ngayhopdong" />";  
    NSWLang["most_01_hopdong"] = "<spring:message code="most.01.hopdong" />";
    
    //chungnhanxuatxuso
    NSWLang["most_02_filetypename_chungnhanxuatxuso"] = "<spring:message code="most.02.filetypename.chungnhanxuatxuso" />";    
    NSWLang["most_02_chungnhanxuatxuso"] = "<spring:message code="most.02.chungnhanxuatxuso" />";    
    NSWLang["most_02_chungnhanxuatxuso_cmd_xoa"] = "<spring:message code="most.02.chungnhanxuatxuso.command.xoa" />";    
    NSWLang["most_02_chungnhanxuatxuso_msg_xoa"] = "<spring:message code="most.02.chungnhanxuatxuso.msg.xoa" />";  
    
 //talieukhac
    NSWLang["most_02_filetypename_talieukhac"] = "<spring:message code="most.02.filetypename.talieukhac" />";    
    NSWLang["most_02_filetypename_talieukhac"] = "<spring:message code="most.02.filetypename.talieukhac" />";    
    NSWLang["most_02_talieukhac"] = "<spring:message code="most.02.hoso.talieukhac" />";    
    NSWLang["most_02_talieukhac_cmd_xoa"] = "<spring:message code="most.02.talieukhac.command.xoa" />";    
    NSWLang["most_02_talieukhac_msg_xoa"] = "<spring:message code="most.02.talieukhac.msg.xoa" />";  
    NSWLang["most_02_talieukhac_ngaytailieu"] = "<spring:message code="most.02.tailieukhac.ngaytailieu" />"; 
    
    //hanghoa
    NSWLang["most_02_hanghoa_ngaybatdaunk"] = "<spring:message code="most.02.hanghoa.ngaybatdaunk" />"; 
    NSWLang["most_02_hanghoa_ngayketthucnk"] = "<spring:message code="most.02.hanghoa.ngayketthucnk" />"; 
    NSWLang["most_01_hanghoa_thongtinhanghoa"] = "<spring:message code="most.01.hanghoa.thongtinhanghoa" />";
    NSWLang["most_02_hanghoa_tenhanghoa"] = "<spring:message code="most.02.table.col.tenhanghoa" />";
    NSWLang["most_02_hanghoa_nhan_hieu"] = "<spring:message code="most.02.table.col.nhan_hieu" />";
    NSWLang["most_02_hanghoa_kieuloai"] = "<spring:message code="most.02.table.col.kieuloai" />";
    NSWLang["most_02_hanghoa_soluong_khoiluong"] = "<spring:message code="most.02.table.col.soluong_khoiluong" />";
    NSWLang["most_02_hanghoa_donvitinh"] = "<spring:message code="most.02.table.col.donvitinh" />";
    NSWLang["most_02_hanghoa_sotokhai"] = "<spring:message code="most.02.hanghoa.sotokhai" />";
    NSWLang["most_02_hanghoa_mahoso"] = "<spring:message code="most.02.hanghoa.mahoso" />";
    NSWLang["most_02_hanghoa_loaidoituong"] = "<spring:message code="most.02.hoso.hanghoa.loaidoituong" />";
    NSWLang["most_02_hanghoa_loaidoituong_pt_do"] = "<spring:message code="most.02.hoso.hanghoa.loaidoituong.pt_do" />";
    NSWLang["most_02_hanghoa_loaidoituong_hangdonggoi"] = "<spring:message code="most.02.hoso.hanghoa.loaidoituong.hangdonggoi" />";

    //thongbaokiemtra
    NSWLang["most_02_thongbaokiemtra"] = "<spring:message code="most.02.thongbaokiemtra" />";
    NSWLang["most_02_thongbaokiemtra_thoigiankiemtra"] = "<spring:message code="most.02.thongbaokiemtra.thoigiankiemtra" />";
    NSWLang["most_02_thongbaokiemtra_diadiemkt"] = "<spring:message code="most.02.thongbaokiemtra.diadiemkt" />";
    NSWLang["most_02_thongbaokiemtra_phuongthuckt"] = "<spring:message code="most.02.thongbaokiemtra.phuongthuckt" />";    
    
    //thongbaoketquakiemtra
    NSWLang["most_02_thongbaokqktra"] = "<spring:message code="most.02.thongbaokqktra" />";
    NSWLang["most_02_thongbaokqktra_title"] = "<spring:message code="most.02.thongbaokqktra.title" />";
    NSWLang["most_02_thongbaokqktra_sodki"] = "<spring:message code="most.02.thongbaokqktra.sodki" />";  
    NSWLang["most_02_thongbaokqktra_cancukiemtra"] = "<spring:message code="most.02.thongbaokqktra.cancukiemtra" />";        
    NSWLang["most_02_thongbaokqktra_cosonhapkhau"] = "<spring:message code="most.02.thongbaokqktra.cosonhapkhau" />";
    NSWLang["most_02_thongbaokqktra_chungtu"] = "<spring:message code="most.02.thongbaokqktra.chungtu" />";
    NSWLang["most_02_thongbaokqktra_hopdong"] = "<spring:message code="most.02.thongbaokqktra.hopdong" />";
    NSWLang["most_02_thongbaokqktra_dmhanghoa"] = "<spring:message code="most.02.thongbaokqktra.dmhanghoa" />";
    NSWLang["most_02_thongbaokqktra_giaychungnhanxuatxu"] = "<spring:message code="most.02.thongbaokqktra.giaychungnhanxuatxu" />";
    NSWLang["most_02_thongbaokqktra_tokhai"] = "<spring:message code="most.02.thongbaokqktra.tokhai" />";
    NSWLang["most_02_thongbaokqktra_ketquaktra"] = "<spring:message code="most.02.thongbaokqktra.ketquaktra" />";
    NSWLang["most_02_thongbaokqktra_ketqua"] = "<spring:message code="most.02.thongbaokqktra.ketqua" />";
    NSWLang["most_02_thongbaokqktra_ghichu"] = "<spring:message code="most.02.thongbaokqktra.ghichu" />"; 
    NSWLang["most_02_thongbaokqktra_chuky_cqktr"] = "<spring:message code="most.02.thongbaokqktra.chuky_cqktr" />";    
    NSWLang["most_02_thongbaokqktra_kyten"] = "<spring:message code="most.02.thongbaokqktra.kyten" />"; 
    NSWLang["most_02_thongbaokqktra_ngayky"] = "<spring:message code="most.02.thongbaokqktra.ngayky" />"; 
    NSWLang["most_02_thongbaokqktra_status_dat"] = "<spring:message code="most.02.thongbaokqktra.status.dat" />";    
    NSWLang["most_02_thongbaokqktra_status_khongdat"] = "<spring:message code="most.02.thongbaokqktra.status.khongdat" />";    
    //loaifile 
    NSWLang["most_02_filetypename_talieukhac"] = "<spring:message code="most.02.filetypename.talieukhac" />"; 
    NSWLang["most_02_filetypename_chungnhanxuatxuso"] = "<spring:message code="most.02.filetypename.chungnhanxuatxuso" />"; 
    NSWLang["most_02_filetypename_hopdong"] = "<spring:message code="most.02.filetypename.hopdong" />"; 
    NSWLang["most_02_filetypename_dmhanghoa"] = "<spring:message code="most.02.filetypename.dmhanghoa" />"; 
    NSWLang["most_02_filetypename_tokhai"] = "<spring:message code="most.02.filetypename.tokhai" />"; 
    NSWLang["most_02_filetypename_thuyetminh"] = "<spring:message code="most.02.filetypename.thuyetminh" />"; 
    
    NSWLang["most_02_hanghoa_sotokhai"] = "<spring:message code="most.02.hanghoa.sotokhai" />"; 
    NSWLang["most_02_hanghoa_mahoso"] = "<spring:message code="most.02.hanghoa.mahoso" />"; 
    NSWLang["most_02_laytutk"] = "<spring:message code="most.02.laytutk" />";
</script>