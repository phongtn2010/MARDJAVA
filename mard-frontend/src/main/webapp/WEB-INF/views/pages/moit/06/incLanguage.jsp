<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
//MONRE 01

 NSWLang["moit_06_msg_chon"] = "<spring:message code="moit.06.message.chon" />";
 NSWLang["moit_06_msg_xuat_khau"] = "<spring:message code="moit.06.message.xuatkhau" />";
 NSWLang["moit_06_msg_nhap_khau"] = "<spring:message code="moit.06.message.nhapkhau" />";
 NSWLang["moit_06_status_01"] = "<spring:message code="moit.06.status.01" />";
 NSWLang["moit_06_status_02"] = "<spring:message code="moit.06.status.02" />";
 NSWLang["moit_06_status_03"] = "<spring:message code="moit.06.status.03" />";
 NSWLang["moit_06_status_04"] = "<spring:message code="moit.06.status.04" />";
 NSWLang["moit_06_status_05"] = "<spring:message code="moit.06.status.05" />";
 NSWLang["moit_06_status_06"] = "<spring:message code="moit.06.status.06" />";
 NSWLang["moit_06_status_07"] = "<spring:message code="moit.06.status.07" />";
 NSWLang["moit_06_status_08"] = "<spring:message code="moit.06.status.08" />";
 NSWLang["moit_06_status_09"] = "<spring:message code="moit.06.status.09" />";
 NSWLang["moit_06_status_10"] = "<spring:message code="moit.06.status.10" />";
 NSWLang["moit_06_form_error_01"] = "<spring:message code="moit.06.form.error.01" />";
 NSWLang["moit_06_form_error_02"] = "<spring:message code="moit.06.form.error.02" />";
 NSWLang["moit_06_form_error_03"] = "<spring:message code="moit.06.form.error.03" />";
 NSWLang["moit_06_form_error_04"] = "<spring:message code="moit.06.form.error.04" />";
 NSWLang["moit_06_form_error_05"] = "<spring:message code="moit.06.form.error.05" />";
 NSWLang["moit_06_form_error_06"] = "<spring:message code="moit.06.form.error.06" />";
 NSWLang["moit_06_lichsh_table_00"] = "<spring:message code="moit.06.lichsu.table.00" />";
 NSWLang["moit_06_lichsh_table_01"] = "<spring:message code="moit.06.lichsu.table.01" />";
 NSWLang["moit_06_lichsh_table_02"] = "<spring:message code="moit.06.lichsu.table.02" />";
 NSWLang["moit_06_lichsh_table_03"] = "<spring:message code="moit.06.lichsu.table.03" />";
 NSWLang["moit_06_lichsh_table_04"] = "<spring:message code="moit.06.lichsu.table.04" />";
 NSWLang["moit_06_lichsh_table_05"] = "<spring:message code="moit.06.lichsu.table.05" />";
 NSWLang["moit_06_lichsh_table_06"] = "<spring:message code="moit.06.lichsu.table.06" />";
 NSWLang["moit_06_popup_xemgxn"] = "<spring:message code="moit.06.popup.xemgxn" />";
 NSWLang["moit_06_popup_guihs"] = "<spring:message code="moit.06.popup.guiHoSo" />";
 NSWLang["moit_06_popup_guihs_confirm"] = "<spring:message code="moit.06.popup.guiHoSo.confirm" />";
 NSWLang["moit_06_popup_huyhs"] = "<spring:message code="moit.06.popup.huyHoSo" />";
 NSWLang["moit_06_popup_huyhs_01"] = "<spring:message code="moit.06.popup.huyHoSo.01" />";
 NSWLang["moit_06_popup_xemvanban"] = "<spring:message code="moit.06.popup.xemvanban" />";
 NSWLang["moit_06_popup_xemvanban_bt_pdf"] = "<spring:message code="moit.06.baocao.xuatpdf" />";
 NSWLang["moit_06_popup_xemvanban_bt_docx"] = "<spring:message code="moit.06.baocao.xuatdoc" />";
 NSWLang["moit_06_form_teptin_error_message"] = "<spring:message code="moit.06.form.teptin.error.message" />";
 NSWLang["moit_06_form_teptin_error_1"] = "<spring:message code="moit.06.form.teptin.error.1" />";
 NSWLang["moit_06_form_teptin_error_2"] = "<spring:message code="moit.06.form.teptin.error.2" />";
 NSWLang["moit_06_form_teptin_error_3"] = "<spring:message code="moit.06.form.teptin.error.3" />";
 NSWLang["moit_06_form_teptin_error_4"] = "<spring:message code="moit.06.form.teptin.error.4" />";
 NSWLang["moit_06_form_tiente_error_5"] = "<spring:message code="moit.06.form.tiente.error.5" />";
 NSWLang["moit_06_form_tiente_error_6"] = "<spring:message code="moit.06.form.tiente.error.6" />";
 NSWLang["moit_06_form_tiente_error_7"] = "<spring:message code="moit.06.form.tiente.tgxnk" />";
 NSWLang["moit_06_form_timkiem_ngaytao"] = "<spring:message code="moit.06.form.timkiem.ngaytao" />";
 NSWLang["moit_06_gxn_table_hanghoa_01"] = "<spring:message code="moit.06.gxn.table.hanghoa.th.01" />";
 NSWLang["moit_06_gxn_table_hanghoa_02"] = "<spring:message code="moit.06.gxn.table.hanghoa.th.02" />";
 NSWLang["moit_06_gxn_table_hanghoa_03"] = "<spring:message code="moit.06.gxn.table.hanghoa.th.03" />";
 NSWLang["moit_06_gxn_table_hanghoa_04"] = "<spring:message code="moit.06.gxn.table.hanghoa.th.04" />";
 NSWLang["moit_06_gxn_table_cuakhau_01"] = "<spring:message code="moit_06_gxn_table_cuakhau_01" />";
 NSWLang["moit_06_gxn_table_cuakhau_02"] = "<spring:message code="moit_06_gxn_table_cuakhau_02" />";
 NSWLang["moit_06_gxn_table_cuakhau_03"] = "<spring:message code="moit_06_gxn_table_cuakhau_03" />";
 NSWLang["moit_06_gxn_table_phuongtien_01"] = "<spring:message code="moit_06_gxn_table_phuongtien_01" />";
 NSWLang["moit_06_gxn_table_phuongtien_02"] = "<spring:message code="moit_06_gxn_table_phuongtien_02" />";

 NSWLang["moit_06_token_error"] = "<spring:message code="moit.06.guihoso.token" />";
 NSWLang["moit_06_totalSizeUploadError"] = "<spring:message code="moit.06.totalSizeUploadError" />";
 NSWLang["moit_06_file_format"] = "<spring:message code="moit.06.tepkhongdungdinhdang" />";
 NSWLang["moit_06_form_ttc_loaihinh_01"] = "<spring:message code="moit.06.form.thongtinchung.loaihinh.01" />";
 NSWLang["moit_06_form_ttc_loaihinh_02"] = "<spring:message code="moit.06.form.thongtinchung.loaihinh.02" />";
 NSWLang["moit_06_form_ttc_loaihinh_03"] = "<spring:message code="moit.06.form.thongtinchung.loaihinh.03" />";
 NSWLang["moit_06_form_ttc_loaihinh_04"] = "<spring:message code="moit.06.form.thongtinchung.loaihinh.04" />";
 NSWLang["moit_06_form_ttc_loaihinh_05"] = "<spring:message code="moit.06.form.thongtinchung.loaihinh.05" />";
 NSWLang["moit_06_form_ttc_loaihoso_01"] = "<spring:message code="moit.06.form.thongtinchung.loaihoso.01" />";
 NSWLang["moit_06_form_ttc_loaihoso_02"] = "<spring:message code="moit.06.form.thongtinchung.loaihoso.02" />";
 NSWLang["moit_06_form_ttc_loaihoso_03"] = "<spring:message code="moit.06.form.thongtinchung.loaihoso.03" />";
 NSWLang["moit_06_form_hanghoa_error_tencuakhau_exist"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.tenCuaKhau.exists" />";
 NSWLang["moit_06_form_hanghoa_error_tenphuongtien_exist"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.tenPhuongTien.exists" />";
 NSWLang["moit_06_form_hanghoa_error_tencuakhau_empty"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.tenCuaKhau.empty" />";
 NSWLang["moit_06_form_hanghoa_error_tenphuongtien_empty"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.tenPhuongTien.empty" />";
 NSWLang["moit_06_form_hanghoa_error_mucDich_empty"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.mucDich.empty" />";
 NSWLang["moit_06_form_hanghoa_error_xnkTuNgay_empty"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.xnkTuNgay.empty" />";
 NSWLang["moit_06_form_hanghoa_error_xnkDenNgay_empty"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.xnkDenNgay.empty" />";
 NSWLang["moit_06_form_hanghoa_error_xnk_between"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.ngayxnk.between" />";
 NSWLang["moit_06_form_hanghoa_error_soLanThucHien_empty"] = "<spring:message code="moit.06.form.thongtinhanghoa.error.soLanThucHien.empty" />";
 
 NSWLang["moit_06_form_hanghoa_trangthai_0"] = "<spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.trangThaiChon" />";
 NSWLang["moit_06_form_hanghoa_trangthai_1"] = "<spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.trangThaiRan" />";
 NSWLang["moit_06_form_hanghoa_trangthai_2"] = "<spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.trangThaiLong" />";
 NSWLang["moit_06_form_hanghoa_trangthai_3"] = "<spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.trangThaiKhi" />";
 NSWLang["moit_06_action_status_huy_ho_so_success"] = "<spring:message code="moit.06.action.xinRut.success" />";
 NSWLang["moit_06_action_status_huy_ho_so_error"] = "<spring:message code="moit.06.action.xinRut.error" />";
 NSWLang["moit_06_action_status_gui_ho_so_error"] = "<spring:message code="moit.06.guihoso.error.4" />";
 NSWLang["moit_06_action_status_gui_ho_so_success"] = "<spring:message code="moit.06.guihoso.success.5" />";
 NSWLang["moit_06_gioiTinhNam"] = "<spring:message code="moit.06.label.thongTinHoSo.nguoiDDGioiTinh.nam" />";
 NSWLang["moit_06_gioiTinhNu"] = "<spring:message code="moit.06.label.thongTinHoSo.nguoiDDGioiTinh.nu" />";
NSWLang["moit.06.trang-truoc"] = "<spring:message code="moit.06.trang-truoc" />";
NSWLang["moit.06.trang-sau"] = "<spring:message code="moit.06.trang-sau" />";
NSWLang["moit.06.form.tiente.button.luu"] = "<spring:message code="moit.06.form.tiente.button.luu" />";

</script>