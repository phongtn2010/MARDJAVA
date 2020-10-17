<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript">
    NSWLang["most_01_table_col_xem_gcn_phuhop"] = "<spring:message code="most.01.table.col.xem_gcn_phuhop" />";
    NSWLang["most_01_table_col_xem_kq_kiem_tra_chat_luong"] = "<spring:message code="most.01.table.col.xem_kq_kiem_tra_chat_luong" />";
    
    //Don DK
    NSWLang["most_01_dondk_nguoi_nhap_khau"] = "<spring:message code="most.01.dondk.nguoi_nhap_khau" />";
    NSWLang["most_01_dondk_ma_so_thue"] = "<spring:message code="most.01.dondk.ma_so_thue" />";
    NSWLang["most_01_dondk_dia_chi_nguoi_nhap_khau"] = "<spring:message code="most.01.dondk.dia_chi_nguoi_nhap_khau" />";
    NSWLang["most_01_dondk_dien_thoai_nguoi_nhap_khau"] = "<spring:message code="most.01.dondk.dien_thoai_nguoi_nhap_khau" />";
    NSWLang["most_01_dondk_nguoi_lien_he"] = "<spring:message code="most.01.dondk.nguoi_lien_he" />";
    NSWLang["most_01_dondk_ten_tc_kiem_tra_dukien"] = "<spring:message code="most.01.dondk.ten_tc_kiem_tra_dukien" />";
    NSWLang["most_01_dondk_diachi_duahanghoa_vekhobaoquan"] = "<spring:message code="most.01.dondk.diachi_duahanghoa_vekhobaoquan" />";
    NSWLang["most_01_dondk_thoigian_dukien_lohangnhapkhau_tungay"] = "<spring:message code="most.01.dondk.thoigian_dukien_lohangnhapkhau_tungay" />";
    NSWLang["most_01_dondk_thoigian_dukien_lohangnhapkhau_denngay"] = "<spring:message code="most.01.dondk.thoigian_dukien_lohangnhapkhau_denngay" />";
    NSWLang["most_01_dondk_fax_nguoi_nhap_khau"] = "<spring:message code="most.01.dondk.fax_nguoi_nhap_khau" />";
    NSWLang["most_01_dondk_email"] = "<spring:message code="most.01.dondk.email" />";    
    NSWLang["most_01_dondk_qcnvn"] = "<spring:message code="most.01.dondk.qcnvn" />";

    //To khai
    NSWLang["most_01_tokhai_hanghoa_nhapkhau_so"] = "<spring:message code="most.01.tokhai.hanghoa_nhapkhau_so" />";
    NSWLang["most_01_tokhai_ngay_dang_ky"] = "<spring:message code="most.01.tokhai.ngay_dang_ky" />";
    NSWLang["most_01_tokhai_namdangky"] = "<spring:message code="most.01.tokhai.namdangky" />";
    NSWLang["most_01_tokhai_ma_hai_quan"] = "<spring:message code="most.01.tokhai.ma_hai_quan" />";
    NSWLang["most_01_tokhai_popup_thongtintokhai"] = "<spring:message code="most.01.tokhai.popup.thongtintokhai" />";
    NSWLang["most_01_tokhai_command_xoa"] = "<spring:message code="most.01.tokhai.command.xoa" />";
    NSWLang["most_01_tokhai_command_xem"] = "<spring:message code="most.01.tokhai.command.xem" />";
    NSWLang["most_01_tokhai_command_sua"] = "<spring:message code="most.01.tokhai.command.sua" />";
    NSWLang["most_01_tokhai_thongtintimkiem"] = "<spring:message code="most.01.tokhai.thongtintimkiem" />";
    NSWLang["most_01_tokhai_ketquatimkiem"] = "<spring:message code="most.01.tokhai.ketquatimkiem" />";
    NSWLang["most_01_tokhai_invalid_year"] = "<spring:message code="most.01.tokhai.invalidyear" />";    

    NSWLang["most_01_thongtintokhai"] = "<spring:message code="most.01.thongtintokhai" />";
    NSWLang["most_01_thongtintokhai_nguoixuatkhau"] = "<spring:message code="most.01.thongtintokhai.nguoixuatkhau" />";
    NSWLang["most_01_thongtintokhai_diachin_xk"] = "<spring:message code="most.01.thongtintokhai.diachin_xk" />";
    NSWLang["most_01_thongtintokhai_diadiemluukho"] = "<spring:message code="most.01.thongtintokhai.diadiemluukho" />";
    NSWLang["most_01_thongtintokhai_diadiemdohang"] = "<spring:message code="most.01.thongtintokhai.diadiemdohang" />";
    NSWLang["most_01_thongtintokhai_vandonso"] = "<spring:message code="most.01.thongtintokhai.vandonso" />";
    NSWLang["most_01_thongtintokhai_hoadonso"] = "<spring:message code="most.01.thongtintokhai.hoadonso" />";
    NSWLang["most_01_thongtintokhai_ngaycaphoadon"] = "<spring:message code="most.01.thongtintokhai.ngaycaphoadon" />";
    NSWLang["most_01_thongtintokhai_soluong"] = "<spring:message code="most.01.thongtintokhai.soluong" />";
    NSWLang["most_01_thongtintokhai_tongtrongluong"] = "<spring:message code="most.01.thongtintokhai.tongtrongluong" />";
    NSWLang["most_01_thongtintokhai_nuoc_xk"] = "<spring:message code="most.01.thongtintokhai.nuoc_xk" />";
    
    //Hang hoa
    NSWLang["most_01_hanghoa_thongtinhanghoa"] = "<spring:message code="most.01.hanghoa.thongtinhanghoa" />";
    NSWLang["most_01_hanghoa_nhomhanghoa"] = "<spring:message code="most.01.hanghoa.nhomhanghoa" />";
    NSWLang["most_01_hanghoa_tenhanghoa"] = "<spring:message code="most.01.hanghoa.tenhanghoa" />";
    NSWLang["most_01_hanghoa_maHS"] = "<spring:message code="most.01.hanghoa.maHS" />";
    NSWLang["most_01_hanghoa_nhanhieu"] = "<spring:message code="most.01.hanghoa.nhanhieu" />";
    NSWLang["most_01_hanghoa_kyhieu_kieuloai"] = "<spring:message code="most.01.hanghoa.kyhieu_kieuloai" />";
    NSWLang["most_01_hanghoa_thongsokythuat"] = "<spring:message code="most.01.hanghoa.thongsokythuat" />";
    NSWLang["most_01_hanghoa_nuocxuatxu"] = "<spring:message code="most.01.hanghoa.nuocxuatxu" />";
    NSWLang["most_01_hanghoa_nhasanxuat"] = "<spring:message code="most.01.hanghoa.nhasanxuat" />";
    NSWLang["most_01_hanghoa_soluong_khoiluong"] = "<spring:message code="most.01.hanghoa.soluong_khoiluong" />";
    NSWLang["most_01_hanghoa_donvitinh"] = "<spring:message code="most.01.hanghoa.donvitinh" />";
    NSWLang["most_01_hanghoa_ketquakiemtra"] = "<spring:message code="most.01.hanghoa.ketquakiemtra" />";
    NSWLang["most_01_hanghoa_ghichu"] = "<spring:message code="most.01.hanghoa.ghichu" />";
    
    NSWLang["most_01_hanghoa_command_xoa"] = "<spring:message code="most.01.hanghoa.command.xoa" />";
    NSWLang["most_01_hanghoa_command_sua"] = "<spring:message code="most.01.hanghoa.command.sua" />";
    NSWLang["most_01_hanghoa_command_xem"] = "<spring:message code="most.01.hanghoa.command.xem" />";
    //Binhvv5
    NSWLang["most_01_hanghoa_kiemtra_dodai_tenhang"] = "<spring:message code="most.01.hanghoa.kiemtra.dodai.tenhang" />";
    //Hop dong
    NSWLang["most_01_hopdong"] = "<spring:message code="most.01.hopdong" />";
    NSWLang["most_01_hopdong_sohopdong"] = "<spring:message code="most.01.hopdong.sohopdong" />";
    NSWLang["most_01_hopdong_ngayhopdong"] = "<spring:message code="most.01.hopdong.ngayhopdong" />";
    
    NSWLang["most_01_hopdong_command_xoa"] = "<spring:message code="most.01.hopdong.command.xoa" />";
    NSWLang["most_01_hopdong_command_luu"] = "<spring:message code="most.01.hopdong.command.luu" />";

    //Van don
    NSWLang["most_01_vandon"] = "<spring:message code="most.01.vandon" />";
    NSWLang["most_01_vandon_sovandon"] = "<spring:message code="most.01.vandon.sovandon" />";
    NSWLang["most_01_vandon_ngay"] = "<spring:message code="most.01.vandon.ngay" />";
    
    NSWLang["most_01_vandon_command_xoa"] = "<spring:message code="most.01.vandon.command.xoa" />";
    NSWLang["most_01_vandon_command_luu"] = "<spring:message code="most.01.vandon.command.luu" />";

    //Hoa don
    NSWLang["most_01_hoadon"] = "<spring:message code="most.01.hoadon" />";
    NSWLang["most_01_hoadon_sohoadon"] = "<spring:message code="most.01.hoadon.sohoadon" />";
    NSWLang["most_01_hoadon_ngay"] = "<spring:message code="most.01.hoadon.ngay" />";
    
    NSWLang["most_01_hoadon_command_xoa"] = "<spring:message code="most.01.hoadon.command.xoa" />";
    NSWLang["most_01_hoadon_command_luu"] = "<spring:message code="most.01.hoadon.command.luu" />";

    //DM Hang hoa
    NSWLang["most_01_dmhanghoa"] = "<spring:message code="most.01.dmhanghoa" />";
    NSWLang["most_01_dmhanghoa_tendanhmuc"] = "<spring:message code="most.01.dmhanghoa.tendanhmuc" />";
    NSWLang["most_01_dmhanghoa_ngay"] = "<spring:message code="most.01.dmhanghoa.ngay" />";

    NSWLang["most_01_dmhanghoa_command_xoa"] = "<spring:message code="most.01.dmhanghoa.command.xoa" />";
    NSWLang["most_01_dmhanghoa_command_luu"] = "<spring:message code="most.01.dmhanghoa.command.luu" />";
    
    //GCN
    NSWLang["most_01_gcn"] = "<spring:message code="most.01.gcn" />";
    NSWLang["most_01_gcn_sogcn"] = "<spring:message code="most.01.gcn.sogcn" />";
    NSWLang["most_01_gcn_loaigcn"] = "<spring:message code="most.01.gcn.loaigcn" />";
    NSWLang["most_01_gcn_ngay"] = "<spring:message code="most.01.gcn.ngay" />";
    NSWLang["most_01_gcn_donvicap"] = "<spring:message code="most.01.gcn.donvicap" />";
    NSWLang["most_01_gcn_hanghoa"] = "<spring:message code="most.01.gcn.hanghoa" />";   
    NSWLang["most_01_gcn_chon"] = "<spring:message code="most.01.gcn.chon" />";
    NSWLang["most_01_gcn_chon"] = "<spring:message code="most.01.gcn.chon" />";
    NSWLang["most_01_gcn_danhsachhanghoadachon"] = "<spring:message code="most.01.gcn.danhsachhanghoadachon" />";
    NSWLang["most_01_gcn_danhsachhhcogcn"] = "<spring:message code="most.01.gcn.danhsachhhcogcn" />";
    NSWLang["most_01_gcn_command_xoa"] = "<spring:message code="most.01.gcn.command.xoa" />";
    NSWLang["most_01_gcn_command_luu"] = "<spring:message code="most.01.gcn.command.luu" />";
    

    //Tai lieu khac
    NSWLang["most_01_tailieukhac"] = "<spring:message code="most.01.tailieukhac" />";
    NSWLang["most_01_tailieukhac_ngay"] = "<spring:message code="most.01.tailieukhac.ngay" />";
    NSWLang["most_01_tailieukhac_loaitailieu"] = "<spring:message code="most.01.tailieukhac.loaitailieu" />";
    
    NSWLang["most_01_tailieukhac_command_xoa"] = "<spring:message code="most.01.tailieukhac.command.xoa" />";
    NSWLang["most_01_tailieukhac_command_xem"] = "<spring:message code="most.01.tailieukhac.command.luu" />";

    //Thong bao
    NSWLang["most_01_thongbao"] = "<spring:message code="most.01.thongbao" />";
    NSWLang["most_01_thongbao_tb"] = "<spring:message code="most.01.thongbao.tb" />";
    NSWLang["most_01_thongbao_ketqua"] = "<spring:message code="most.01.thongbao.ketqua" />";
    NSWLang["most_01_thongbao_thongtinlohang"] = "<spring:message code="most.01.thongbao.thongtinlohang" />";
    NSWLang["most_01_thongbao_sodangky"] = "<spring:message code="most.01.thongbao.sodangky" />";
    NSWLang["most_01_thongbao_danhsachtokhai"] = "<spring:message code="most.01.thongbao.danhsachtokhai" />";
    NSWLang["most_01_thongbao_hopdongso"] = "<spring:message code="most.01.thongbao.hopdongso" />";
    NSWLang["most_01_thongbao_vandonso"] = "<spring:message code="most.01.thongbao.vandonso" />";
    NSWLang["most_01_thongbao_danhmuchanghoaso"] = "<spring:message code="most.01.thongbao.danhmuchanghoaso" />";
    NSWLang["most_01_thongbao_hoadonso"] = "<spring:message code="most.01.thongbao.hoadonso" />";
    NSWLang["most_01_thongbao_noidungsuadoi"] = "<spring:message code="most.01.thongbao.noidungsuadoi" />";
    NSWLang["most_01_thongbao_danhsachhanghoa"] = "<spring:message code="most.01.thongbao.danhsachhanghoa" />";
    NSWLang["most_01_thongbao_cancukiemtra"] = "<spring:message code="most.01.thongbao.cancukiemtra" />";
    NSWLang["most_01_thongbao_quychuankythuat"] = "<spring:message code="most.01.thongbao.quychuankythuat" />";
    NSWLang["most_01_thongbao_cancukhac"] = "<spring:message code="most.01.thongbao.cancukhac" />";
    NSWLang["most_01_thongbao_ketquadanhgiasuphuhop"] = "<spring:message code="most.01.thongbao.ketquadanhgiasuphuhop" />";
    NSWLang["most_01_thongbao_gcnhopquyso"] = "<spring:message code="most.01.thongbao.gcnhopquyso" />";
    NSWLang["most_01_thongbao_gcnhopquyhoacchungthu"] = "<spring:message code="most.01.thongbao.gcnhopquyhoacchungthu" />";
    NSWLang["most_01_thongbao_do"] = "<spring:message code="most.01.thongbao.do" />";
    NSWLang["most_01_thongbao_capngay"] = "<spring:message code="most.01.thongbao.capngay" />";
    NSWLang["most_01_thongbao_daidiencothamquyen"] = "<spring:message code="most.01.thongbao.daidiencothamquyen" />";

    //GCN
    NSWLang["most_01_gcn_popup"] = "<spring:message code="most.01.gcn.popup" />";
    NSWLang["most_01_gcn_ketquakiemtra"] = "<spring:message code="most.01.gcn.ketquakiemtra" />";
    NSWLang["most_01_gcn_nguoinhapkhau"] = "<spring:message code="most.01.gcn.nguoinhapkhau" />";
    NSWLang["most_01_gcn_diachi"] = "<spring:message code="most.01.gcn.diachi" />";
    NSWLang["most_01_gcn_danhsachhanghoa"] = "<spring:message code="most.01.gcn.danhsachhanghoa" />";
    NSWLang["most_01_gcn_thongtinlienquan"] = "<spring:message code="most.01.gcn.thongtinlienquan" />";
    NSWLang["most_01_gcn_danhsachtokhai"] = "<spring:message code="most.01.gcn.danhsachtokhai" />";
    NSWLang["most_01_gcn_hopdong"] = "<spring:message code="most.01.gcn.hopdong" />";
    NSWLang["most_01_gcn_vandon"] = "<spring:message code="most.01.gcn.vandon" />";
    NSWLang["most_01_gcn_danhmuchanghoa"] = "<spring:message code="most.01.gcn.danhmuchanghoa" />";
    NSWLang["most_01_gcn_quychuankythuat"] = "<spring:message code="most.01.gcn.quychuankythuat" />";
    NSWLang["most_01_gcn_dauhopquy"] = "<spring:message code="most.01.gcn.dauhopquy" />";
    NSWLang["most_01_gcn_phuongthucnhan"] = "<spring:message code="most.01.gcn.phuongthucnhan" />";
    NSWLang["most_01_gcn_sogiaychungnhan"] = "<spring:message code="most.01.gcn.sogiaychungnhan" />";
    NSWLang["most_01_gcn_ngaycap"] = "<spring:message code="most.01.gcn.ngaycap" />";
    NSWLang["most_01_gcn_tochucchungnhan"] = "<spring:message code="most.01.gcn.tochucchungnhan" />";
    NSWLang["most_01_gcn_daidien"] = "<spring:message code="most.01.gcn.daidien" />";
    NSWLang["most_01_gcn_noidungsuadoi"] = "<spring:message code="most.01.gcn.noidungsuadoi" />";
    NSWLang["most_01_gcn_hieuluc"] = "<spring:message code="most.01.gcn.hieuluc" />";

    //Tên loại file
    NSWLang["most_01_filetypename_hopdong"] = "<spring:message code="most.01.filetypename.hopdong" />";
    NSWLang["most_01_filetypename_vandon"] = "<spring:message code="most.01.filetypename.vandon" />";
    NSWLang["most_01_filetypename_hoadon"] = "<spring:message code="most.01.filetypename.hoadon" />";
    NSWLang["most_01_filetypename_danhmuchanghoa"] = "<spring:message code="most.01.filetypename.danhmuchanghoa" />";
    NSWLang["most_01_filetypename_giaychungnhan"] = "<spring:message code="most.01.filetypename.giaychungnhan" />";
    NSWLang["most_01_filetypename_tailieukhac"] = "<spring:message code="most.01.filetypename.tailieukhac" />";  
    NSWLang["most_01_msg_khongcantccn"] = "<spring:message code="most.01.msg.khongcantccn" />";   
    NSWLang["most_01_msg_phaichontccn"] = "<spring:message code="most.01.msg.phaichontccn" />";   
    
    //Trang thai thong bao kiem tra
    NSWLang["most_01_tb_status_status1"] = "<spring:message code="most.01.tb.status.status1" />";  
    NSWLang["most_01_tb_status_status2"] = "<spring:message code="most.01.tb.status.status2" />";  
    NSWLang["most_01_tb_status_status3"] = "<spring:message code="most.01.tb.status.status3" />";  
    NSWLang["most_01_tb_status_status4"] = "<spring:message code="most.01.tb.status.status4" />";  
    NSWLang["most_01_tb_status_status5"] = "<spring:message code="most.01.tb.status.status5" />";  
    NSWLang["most_01_tb_status_status6"] = "<spring:message code="most.01.tb.status.status6" />";  
    NSWLang["most_01_tb_status_status7"] = "<spring:message code="most.01.tb.status.status7" />";  
    NSWLang["most_01_tb_status_status8"] = "<spring:message code="most.01.tb.status.status8" />";  
    NSWLang["most_01_tb_status_status9"] = "<spring:message code="most.01.tb.status.status9" />";  
    NSWLang["most_01_tb_status_status10"] = "<spring:message code="most.01.tb.status.status10" />";  
    
    NSWLang["most_common_msg_xoahanghoa"] = "<spring:message code="most.common.msg.xoahanghoa" />";
    NSWLang["most_common_msg_xoahopdong"] = "<spring:message code="most.common.msg.xoahopdong" />";
    NSWLang["most_common_msg_xoavandong"] = "<spring:message code="most.common.msg.xoavandong" />";
    NSWLang["most_common_msg_xoahoadon"] = "<spring:message code="most.common.msg.xoahoadon" />";
    NSWLang["most_common_msg_xoadanhmuchanghoa"] = "<spring:message code="most.common.msg.xoadanhmuchanghoa" />";
    NSWLang["most_common_msg_xoagiaychungnhan"] = "<spring:message code="most.common.msg.xoagiaychungnhan" />";
    NSWLang["most_common_msg_xoatailieukhac"] = "<spring:message code="most.common.msg.xoatailieukhac" />";  
    NSWLang["most_common_msg_phaichontochucchungnhan"] = "<spring:message code="most.common.msg.phaichontochucchungnhan" />"; 
    NSWLang["most_common_msg_hosocanxoa"] = "<spring:message code="most.common.msg.hosocanxoa" />";  
    NSWLang["most_common_msg_tontaihanghoachuacogcn"] = "<spring:message code="most.common.msg.tontaihanghoachuacogcn" />";  
    
    
</script>