<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript">

    NSWLang["common_co"] = "<spring:message code="common.co" />";
    NSWLang["common_chon"] = "<spring:message code="common.chon" />";
    NSWLang["common_tatca"] = "<spring:message code="common.tatca" />";
    NSWLang["common_khong"] = "<spring:message code="common.khong" />";
    NSWLang["common_dat"] = "<spring:message code="common.dat" />";
    NSWLang["common_khongdat"] = "<spring:message code="common.khongdat" />";
    NSWLang["common_ngoaidanhmuc"] = "<spring:message code="common.ngoaidanhmuc" />";
    NSWLang["common_ngay"] = "<spring:message code="common.ngay" />";
    NSWLang["common_ghichu"] = "<spring:message code="common.ghichu" />";

    NSWLang["common_tokhai_tokhai"] = "<spring:message code="common.tokhai.tokhai" />";

    NSWLang["common_tokhai_thongtinchung"] = "<spring:message code="common.tokhai.thongtinchung" />";
    NSWLang["common_tokhai_sotokhai"] = "<spring:message code="common.tokhai.sotokhai" />";
    NSWLang["common_tokhai_mahaiquan"] = "<spring:message code="common.tokhai.mahaiquan" />";
    NSWLang["common_tokhai_ngaydangky"] = "<spring:message code="common.tokhai.ngaydangky" />";
    NSWLang["common_tokhai_nnk"] = "<spring:message code="common.tokhai.nnk" />";
    NSWLang["common_tokhai_nnk_tencongty"] = "<spring:message code="common.tokhai.nnk.tencongty" />";
    NSWLang["common_tokhai_nnk_dienthoai"] = "<spring:message code="common.tokhai.nnk.dienthoai" />";
    NSWLang["common_tokhai_nnk_diachi"] = "<spring:message code="common.tokhai.nnk.diachi" />";
    NSWLang["common_tokhai_nxk"] = "<spring:message code="common.tokhai.nxk" />";
    NSWLang["common_tokhai_nxk_tencongty"] = "<spring:message code="common.tokhai.nxk.tencongty" />";
    NSWLang["common_tokhai_nxk_nuoc"] = "<spring:message code="common.tokhai.nxk.nuoc" />";
    NSWLang["common_tokhai_nxk_diachi"] = "<spring:message code="common.tokhai.nxk.diachi" />";
    NSWLang["common_tokhai_hanghoa"] = "<spring:message code="common.tokhai.hanghoa" />";
    NSWLang["common_tokhai_hanghoa_stt"] = "<spring:message code="common.tokhai.hanghoa.stt" />";
    NSWLang["common_tokhai_hanghoa_mahs"] = "<spring:message code="common.tokhai.hanghoa.mahs" />";
    NSWLang["common_tokhai_hanghoa_tenhanghoa"] = "<spring:message code="common.tokhai.hanghoa.tenhanghoa" />";
    NSWLang["common_tokhai_hanghoa_klsl"] = "<spring:message code="common.tokhai.hanghoa.klsl" />";
    NSWLang["common_tokhai_hanghoa_donvitinh"] = "<spring:message code="common.tokhai.hanghoa.donvitinh" />";
    NSWLang["common_tokhai_diadiemluukho"] = "<spring:message code="common.tokhai.diadiemluukho" />";
    NSWLang["common_tokhai_diadiemdohang"] = "<spring:message code="common.tokhai.diadiemdohang" />";
    NSWLang["common_tokhai_soluong"] = "<spring:message code="common.tokhai.soluong" />";
    NSWLang["common_tokhai_tongtrongluong"] = "<spring:message code="common.tokhai.tongtrongluong" />";
    NSWLang["common_tokhai_vdhd"] = "<spring:message code="common.tokhai.vdhd" />";
    NSWLang["common_tokhai_vdhd_sohoadon"] = "<spring:message code="common.tokhai.vdhd.sohoadon" />";
    NSWLang["common_tokhai_vdhd_vandonso"] = "<spring:message code="common.tokhai.vdhd.vandonso" />";
    NSWLang["common_tokhai_vdhd_ngaycaphoadon"] = "<spring:message code="common.tokhai.vdhd.ngaycaphoadon" />";

    NSWLang["common_button_huy"] = "<spring:message code="conmon.button.huy" />";
    NSWLang["common_button_toi_chac_chan"] = "<spring:message code="conmon.button.toi_chac_chan" />";
    NSWLang["common_button_luu"] = "<spring:message code="common.button.luu" />";
    NSWLang["common_button_gui"] = "<spring:message code="common.button.gui" />";
    NSWLang["common_button_view"] = "<spring:message code="conmon.button.view" />";
    NSWLang["common_button_dong"] = "<spring:message code="conmon.button.dong" />";
    NSWLang["common_button_xoa"] = "<spring:message code="common.button.xoa" />";
    NSWLang["common_button_sua"] = "<spring:message code="common.button.sua" />";

    NSWLang["common_msg_he_thong_chua_san_sang"] = "<spring:message code="common.msg.he_thong_chua_san_sang" />";
    NSWLang["common_msg_ly_do_xin_lui_han"] = "<spring:message code="common.msg.ly_do_xin_lui_han" />";
    NSWLang["common_msg_thoi_han_moi_nhap_sai"] = "<spring:message code="common.msg.thoi_han_moi_nhap_sai" />";
    NSWLang["common_msg_loinhaplieu"] = "<spring:message code="common.msg.loinhaplieu" />";
    NSWLang["common_msg_thoi_han_moi_de_hoan_thien"] = "<spring:message code="common.msg.thoi_han_moi_de_hoan_thien" />";
    NSWLang["common_msg_xin_gia_han_ho_so"] = "<spring:message code="common.msg.xin_gia_han_ho_so" />";
    NSWLang["common_msg_vuot_qua_maxlength"] = "<spring:message code="common.msg.vuot_qua_maxlength" />";
    NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"] = "<spring:message code="common.msg.cap_nhat_du_lieu_thanh_cong" />";
    NSWLang["common_msg_xoa_thanh_cong_phuong_tien"] = "<spring:message code="common.msg.xoa_thanh_cong_phuong_tien" />";
    NSWLang["common_msg_chua_nhap"] = "<spring:message code="common.msg.chua_nhap" />";
    NSWLang["common_msg_ly_do"] = "<spring:message code="common.msg.ly_do" />";
    NSWLang["common_msg_xin_gia_han_ho_so"] = "<spring:message code="common.msg.xin_gia_han_ho_so" />";
    NSWLang["common_msg_yeu_cau_huy_ho_so"] = "<spring:message code="common.msg.yeu_cau_huy_ho_so" />";
    NSWLang["common_msg_thong_bao"] = "<spring:message code="common.msg.thong_bao" />";
    NSWLang["common_msg_xoa_ho_so"] = "<spring:message code="common.msg.xoa_ho_so" />";
    NSWLang["common_msg_gui_ho_so"] = "<spring:message code="common.msg.gui_ho_so" />";
    NSWLang["common_msg_gui_yeu_cau"] = "<spring:message code="common.msg.gui_yeu_cau" />";
    NSWLang["common_msg_chuanhapthongtin"] = "<spring:message code="common.msg.chuanhapthongtin" />";
    NSWLang["common_msg_xin_sua_ho_so"] = "<spring:message code="common.msg.xin_sua_ho_so" />";
    NSWLang["common_ten_quy_chuan_viet_nam"] = "<spring:message code="common.ten_quy_chuan_viet_nam" />";
    NSWLang["common_msg_dangimport"] = "<spring:message code="common.msg.dangimport" />";
    NSWLang["common_msg_sendsuccess"] = "<spring:message code="common.msg.sendsuccess" />";
    NSWLang["common_msg_expire"] = "<spring:message code="common.msg.expire" />";
    NSWLang["common_msg_khongtimthay"] = "<spring:message code="common.msg.khongtimthay" />";
    NSWLang["common_msg_xoatokhai"] = "<spring:message code="common.msg.xoatokhai" />";
    NSWLang["common_msg_datontaitokhai"] = "<spring:message code="common.msg.datontaitokhai" />";
    NSWLang["common_msg_invalid_email"] = "<spring:message code="common.msg.formvalid.email" />";

    NSWLang["common_msg_formvaild_required"] = "<spring:message code="common.msg.formvaild.required" />";
    NSWLang["common_msg_formvaild_positivenumber"] = "<spring:message code="common.msg.formvalid.positivenumber" />";
    NSWLang["common_msg_formvaild_maxvalue"] = "<spring:message code="common.msg.formvalid.maxvalue" />";
    NSWLang["common_msg_formvalid_isrequired"] = "<spring:message code="mard.msg.required"/>";
    NSWLang["common_msg_formvaild_maxlength"] = "<spring:message code="common.msg.formvaild.maxlength" />";
    NSWLang["common_msg_formvaild_format"] = "<spring:message code="common.msg.formvaild.format" />";
    NSWLang["common_msg_formvalid_filled"] = "<spring:message code="common.msg.formvalid.filled"/>"
    NSWLang["common_msg_formvalid_isinteger"] = "<spring:message code="common.msg.formvalid.isinteger"/>"

    NSWLang["file_msg_chua_chon_file"] = "<spring:message code="file.msg.chua_chon_file" />";    
    NSWLang["file_msg_dung_luong_toi_da"] = "<spring:message code="file.msg.dung_luong_toi_da" />";
    NSWLang["file_msg_tong_dung_luong_toi_da"] = "<spring:message code="file.msg.tong_dung_luong_toi_da" />";
    NSWLang["file_msg_file_duoc_phep_tai_len"] = "<spring:message code="file.msg.file_duoc_phep_tai_len" />";
    NSWLang["file_msg_tenvuotmaxlength"] = "<spring:message code="file.msg.tenvuotmaxlength" />";

    NSWLang["common_table_col_stt"] = "<spring:message code="common.table.col.stt" />";
    NSWLang["common_table_cmd_sua"] = "<spring:message code="common.table.cmd.sua" />";
    NSWLang["common_table_cmd_xoa"] = "<spring:message code="common.table.cmd.xoa" />";
    NSWLang["common_table_cmd_lichsu"] = "<spring:message code="common.table.cmd.lichsu" />";
    NSWLang["common_table_cmd_xinluihan"] = "<spring:message code="common.table.cmd.xinluihan" />";
    NSWLang["common_table_cmd_xinsua"] = "<spring:message code="common.table.cmd.xinsua" />";
    NSWLang["common_table_cmd_xinhuy"] = "<spring:message code="common.table.cmd.xinhuy" />";


    NSWLang["common_history_lichsuxuly"] = "<spring:message code="common.history.lichsuxuly" />";
    NSWLang["common_history_mahoso"] = "<spring:message code="common.history.mahoso" />";
    NSWLang["common_history_stt"] = "<spring:message code="common.history.stt" />";
    NSWLang["common_history_donvixuly"] = "<spring:message code="common.history.donvixuly" />";
    NSWLang["common_history_nguoixuly"] = "<spring:message code="common.history.nguoixuly" />";
    NSWLang["common_history_thoigian"] = "<spring:message code="common.history.thoigian" />";
    NSWLang["common_history_trangthaihoso"] = "<spring:message code="common.history.trangthaihoso" />";
    NSWLang["common_history_nguoithaydoi"] = "<spring:message code="common.history.nguoithaydoi" />";
    NSWLang["common_history_noidung"] = "<spring:message code="common.history.noidung" />";
    NSWLang["common_history_hanxuly"] = "<spring:message code="common.history.hanxuly" />";

    NSWLang["common_pager_ban_ghi"] = "<spring:message code="common.pager.ban_ghi" />";
    NSWLang["common_msg_khongdungdinhdang"] = "<spring:message code="common.msg.khongdungdinhdang" />";

    //Lich su xu ly ho so
    NSWLang["common_history_lichsuxuly"] = "<spring:message code="common.history.lichsuxuly" />";

    NSWLang["CODE1"] = "<spring:message code="common.error.code1" />";
    NSWLang["CODE2"] = "<spring:message code="common.error.code2" />";
    NSWLang["CODE3"] = "<spring:message code="common.error.code3" />";
    NSWLang["CODE4"] = "<spring:message code="common.error.code4" />";
    NSWLang["CODE5"] = "<spring:message code="common.error.code5" />";

    //Trang danh sach

    NSWLang["common_tracuu_ngay_tao_tu"] = "<spring:message code="common.tracuu.ngay_tao_tu" />";
    NSWLang["common_tracuu_ngay_tao_den"] = "<spring:message code="common.tracuu.ngay_tao_den" />";
    NSWLang["common_tracuu_ngay_gui_tu"] = "<spring:message code="common.tracuu.ngay_gui_tu" />";
    NSWLang["common_tracuu_ngay_gui_den"] = "<spring:message code="common.tracuu.ngay_gui_den" />";

    NSWLang["common_msg_khongnhohon"] = "<spring:message code="common.msg.khongnhohon" />";
    NSWLang["common_msg_khonglonhon"] = "<spring:message code="common.msg.khonglonhon" />";
    NSWLang["common_msg_ngayhientai"] = "<spring:message code="common.msg.ngayhientai" />";
    NSWLang["common_msg_thongbao"] = "<spring:message code="common.msg.thongbao" />";
    NSWLang["common_msg_khonglayduocthongtintokhai"] = "<spring:message code="common.msg.khonglayduocthongtintokhai" />";
    NSWLang["common_msg_thoi_han_cu_de_hoan_thien"] = "<spring:message code="common.msg.thoi_han_cu_de_hoan_thien" />";

    NSWLang["common_excel_sheet_name"] = "<spring:message code="common.excel.sheet.name" />";
    NSWLang["common_excel_sheet_hs"] = "<spring:message code="common.excel.sheet.hs" />";
    NSWLang["common_excel_sheet_hh"] = "<spring:message code="common.excel.sheet.hh" />";
    NSWLang["common_excel_sheet_tk"] = "<spring:message code="common.excel.sheet.tk" />";
    NSWLang["common_excel_msg_loidong"] = "<spring:message code="common.excel.msg.loidong" />";
    NSWLang["common_excel_msg_loicot"] = "<spring:message code="common.excel.msg.loicot" />";
    NSWLang["common_excel_msg_sheet"] = "<spring:message code="common.excel.msg.sheet" />";
    NSWLang["common_msg_cho_ky_so"] = "<spring:message code="common.msg.chokyso" />";

    //Phương tiện
    NSWLang["common_msg_xoa_phuong_tien"] = "<spring:message code="common.msg.xoa_phuong_tien" />";
</script>
<div id="loading10">
    <div class="overlay"></div>
    <img src="data:image/gif;base64,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"/>
    <div>Đang thực hiện...</div>
</div>
