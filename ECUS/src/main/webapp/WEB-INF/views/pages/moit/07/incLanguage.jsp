<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
//MONRE 01

 NSWLang["moit_06_msg_chon"] = "<spring:message code="moit.07.message.chon" />";
 NSWLang["moit_06_msg_xuat_khau"] = "<spring:message code="moit.07.message.xuatkhau" />";
 NSWLang["moit_06_msg_nhap_khau"] = "<spring:message code="moit.07.message.nhapkhau" />";
 NSWLang["moit_06_status_01"] = "<spring:message code="moit.07.status.01" />";
 NSWLang["moit_06_status_02"] = "<spring:message code="moit.07.status.02" />";
 NSWLang["moit_06_status_03"] = "<spring:message code="moit.07.status.03" />";
 NSWLang["moit_06_status_04"] = "<spring:message code="moit.07.status.04" />";
 NSWLang["moit_06_status_05"] = "<spring:message code="moit.07.status.05" />";
 NSWLang["moit_06_status_06"] = "<spring:message code="moit.07.status.06" />";
 NSWLang["moit_06_status_07"] = "<spring:message code="moit.07.status.07" />";
 NSWLang["moit_06_status_08"] = "<spring:message code="moit.07.status.08" />";
 NSWLang["moit_06_status_09"] = "<spring:message code="moit.07.status.09" />";
 NSWLang["moit_06_status_10"] = "<spring:message code="moit.07.status.10" />";
 NSWLang["moit_06_form_error_01"] = "<spring:message code="moit.07.form.error.01" />";
 NSWLang["moit_06_form_error_02"] = "<spring:message code="moit.07.form.error.02" />";
 NSWLang["moit_06_form_error_03"] = "<spring:message code="moit.07.form.error.03" />";
 NSWLang["moit_06_form_error_04"] = "<spring:message code="moit.07.form.error.04" />";
 NSWLang["moit_06_form_error_05"] = "<spring:message code="moit.07.form.error.05" />";
 NSWLang["moit_06_form_error_06"] = "<spring:message code="moit.07.form.error.06" />";
 NSWLang["moit_06_lichsh_table_00"] = "<spring:message code="moit.07.lichsu.table.00" />";
 NSWLang["moit_06_lichsh_table_01"] = "<spring:message code="moit.07.lichsu.table.01" />";
 NSWLang["moit_06_lichsh_table_02"] = "<spring:message code="moit.07.lichsu.table.02" />";
 NSWLang["moit_06_lichsh_table_03"] = "<spring:message code="moit.07.lichsu.table.03" />";
 NSWLang["moit_06_lichsh_table_04"] = "<spring:message code="moit.07.lichsu.table.04" />";
 NSWLang["moit_06_lichsh_table_05"] = "<spring:message code="moit.07.lichsu.table.05" />";
 NSWLang["moit_06_lichsh_table_06"] = "<spring:message code="moit.07.lichsu.table.06" />";
 NSWLang["moit_06_popup_xemgxn"] = "<spring:message code="moit.07.popup.xemgxn" />";
 NSWLang["moit_06_popup_guihs"] = "<spring:message code="moit.07.popup.guiHoSo" />";
 NSWLang["moit_06_popup_guihs_confirm"] = "<spring:message code="moit.07.popup.guiHoSo.confirm" />";
 NSWLang["moit_06_popup_huyhs"] = "<spring:message code="moit.07.popup.huyHoSo" />";
 NSWLang["moit_06_popup_huyhs_01"] = "<spring:message code="moit.07.popup.huyHoSo.01" />";
 NSWLang["moit_06_popup_xemvanban"] = "<spring:message code="moit.07.popup.xemvanban" />";
 NSWLang["moit_06_popup_xemvanban_bt_pdf"] = "<spring:message code="moit.07.baocao.xuatpdf" />";
 NSWLang["moit_06_popup_xemvanban_bt_docx"] = "<spring:message code="moit.07.baocao.xuatdoc" />";
 NSWLang["moit_06_form_teptin_error_message"] = "<spring:message code="moit.07.form.teptin.error.message" />";
 NSWLang["moit_06_form_teptin_error_1"] = "<spring:message code="moit.07.form.teptin.error.1" />";
 NSWLang["moit_06_form_teptin_error_2"] = "<spring:message code="moit.07.form.teptin.error.2" />";
 NSWLang["moit_06_form_teptin_error_3"] = "<spring:message code="moit.07.form.teptin.error.3" />";
 NSWLang["moit_06_form_teptin_error_4"] = "<spring:message code="moit.07.form.teptin.error.4" />";
 NSWLang["moit_06_form_tiente_error_5"] = "<spring:message code="moit.07.form.tiente.error.5" />";
 NSWLang["moit_06_form_tiente_error_6"] = "<spring:message code="moit.07.form.tiente.error.6" />";
 NSWLang["moit_06_form_tiente_error_7"] = "<spring:message code="moit.07.form.tiente.tgxnk" />";
 NSWLang["moit_06_form_timkiem_ngaytao"] = "<spring:message code="moit.07.form.timkiem.ngaytao" />";
 NSWLang["moit_06_gxn_table_hanghoa_01"] = "<spring:message code="moit.07.gxn.table.hanghoa.th.01" />";
 NSWLang["moit_06_gxn_table_hanghoa_02"] = "<spring:message code="moit.07.gxn.table.hanghoa.th.02" />";
 NSWLang["moit_06_gxn_table_hanghoa_03"] = "<spring:message code="moit.07.gxn.table.hanghoa.th.03" />";
 NSWLang["moit_06_gxn_table_hanghoa_04"] = "<spring:message code="moit.07.gxn.table.hanghoa.th.04" />";
 NSWLang["moit_06_gxn_table_cuakhau_01"] = "<spring:message code="moit_06_gxn_table_cuakhau_01" />";
 NSWLang["moit_06_gxn_table_cuakhau_02"] = "<spring:message code="moit_06_gxn_table_cuakhau_02" />";
 NSWLang["moit_06_gxn_table_cuakhau_03"] = "<spring:message code="moit_06_gxn_table_cuakhau_03" />";
 NSWLang["moit_06_gxn_table_phuongtien_01"] = "<spring:message code="moit_06_gxn_table_phuongtien_01" />";
 NSWLang["moit_06_gxn_table_phuongtien_02"] = "<spring:message code="moit_06_gxn_table_phuongtien_02" />";

 NSWLang["moit_06_token_error"] = "<spring:message code="moit.07.guihoso.token" />";
 NSWLang["moit_06_totalSizeUploadError"] = "<spring:message code="moit.07.totalSizeUploadError" />";
 NSWLang["moit_06_file_format"] = "<spring:message code="moit.07.tepkhongdungdinhdang" />";
 NSWLang["moit_06_form_ttc_loaihinh_01"] = "<spring:message code="moit.07.form.thongtinchung.loaihinh.01" />";
 NSWLang["moit_06_form_ttc_loaihinh_02"] = "<spring:message code="moit.07.form.thongtinchung.loaihinh.02" />";
 NSWLang["moit_06_form_ttc_loaihinh_03"] = "<spring:message code="moit.07.form.thongtinchung.loaihinh.03" />";
 NSWLang["moit_06_form_ttc_loaihinh_04"] = "<spring:message code="moit.07.form.thongtinchung.loaihinh.04" />";
 NSWLang["moit_06_form_ttc_loaihinh_05"] = "<spring:message code="moit.07.form.thongtinchung.loaihinh.05" />";
 NSWLang["moit_06_form_ttc_loaihoso_01"] = "<spring:message code="moit.07.form.thongtinchung.loaihoso.01" />";
 NSWLang["moit_06_form_ttc_loaihoso_02"] = "<spring:message code="moit.07.form.thongtinchung.loaihoso.02" />";
 NSWLang["moit_06_form_ttc_loaihoso_03"] = "<spring:message code="moit.07.form.thongtinchung.loaihoso.03" />";
 NSWLang["moit_06_form_hanghoa_error_tencuakhau_exist"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.tenCuaKhau.exists" />";
 NSWLang["moit_06_form_hanghoa_error_tenphuongtien_exist"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.tenPhuongTien.exists" />";
 NSWLang["moit_06_form_hanghoa_error_tencuakhau_empty"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.tenCuaKhau.empty" />";
 NSWLang["moit_06_form_hanghoa_error_tenphuongtien_empty"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.tenPhuongTien.empty" />";
 NSWLang["moit_06_form_hanghoa_error_mucDich_empty"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.mucDich.empty" />";
 NSWLang["moit_06_form_hanghoa_error_xnkTuNgay_empty"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.xnkTuNgay.empty" />";
 NSWLang["moit_06_form_hanghoa_error_xnkDenNgay_empty"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.xnkDenNgay.empty" />";
 NSWLang["moit_06_form_hanghoa_error_xnk_between"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.ngayxnk.between" />";
 NSWLang["moit_06_form_hanghoa_error_soLanThucHien_empty"] = "<spring:message code="moit.07.form.thongtinhanghoa.error.soLanThucHien.empty" />";
 
 NSWLang["moit_06_form_hanghoa_trangthai_0"] = "<spring:message code="moit.07.form.thongtinhanghoa.danhsachhanghoa.trangThaiChon" />";
 NSWLang["moit_06_form_hanghoa_trangthai_1"] = "<spring:message code="moit.07.form.thongtinhanghoa.danhsachhanghoa.trangThaiRan" />";
 NSWLang["moit_06_form_hanghoa_trangthai_2"] = "<spring:message code="moit.07.form.thongtinhanghoa.danhsachhanghoa.trangThaiLong" />";
 NSWLang["moit_06_form_hanghoa_trangthai_3"] = "<spring:message code="moit.07.form.thongtinhanghoa.danhsachhanghoa.trangThaiKhi" />";
 NSWLang["moit_06_action_status_huy_ho_so_success"] = "<spring:message code="moit.07.action.xinRut.success" />";
 NSWLang["moit_06_action_status_huy_ho_so_error"] = "<spring:message code="moit.07.action.xinRut.error" />";
 NSWLang["moit_06_action_status_gui_ho_so_error"] = "<spring:message code="moit.07.guihoso.error.4" />";
 NSWLang["moit_06_action_status_gui_ho_so_success"] = "<spring:message code="moit.07.guihoso.success.5" />";
 NSWLang["moit_07_hinhThucNK"] = "<spring:message code="moit.07.form.thongTinChung.hinhThuxXNK.nk" />";
 NSWLang["moit_07_hinhThucXK"] = "<spring:message code="moit.07.form.thongTinChung.hinhThuxXNK.xk" />";
 NSWLang["moit_07_haiQuan_error_empty"] = "<spring:message code="moit.07.form.thongTinHaiQuan.error.empty" />";
 NSWLang["moit_07_haiQuan_error_exists"] = "<spring:message code="moit.07.form.thongTinHaiQuan.error.exists" />";
 NSWLang["moit_07_haiQuan_error_exists"] = "<spring:message code="moit.07.form.thongTinHaiQuan.error.exists" />";
 NSWLang["moit_07_form_cthanghoa_popupTitle"] = "<spring:message code="moit.07.form.cthanghoa.popupTitle" />";
 NSWLang["moit_07_form_cthanghoa_maCSA"] = "<spring:message code="moit.07.form.cthanghoa.maCSA" />";
 NSWLang["moit_07_form_cthanghoa_maHSChat"] = "<spring:message code="moit.07.form.cthanghoa.maHSChat" />";
 NSWLang["moit_07_form_cthanghoa_congThucHH"] = "<spring:message code="moit.07.form.cthanghoa.congThucHH" />";
 NSWLang["moit_07_form_cthanghoa_tenChatTV"] = "<spring:message code="moit.07.form.cthanghoa.tenChatTV" />";
 NSWLang["moit_07_form_cthanghoa_tenChatTA"] = "<spring:message code="moit.07.form.cthanghoa.tenChatTA" />";
 NSWLang["moit_07_form_cthanghoa_tenKhoaHoc"] = "<spring:message code="moit.07.form.cthanghoa.tenKhoaHoc" />";
 NSWLang["moit_07_form_cthanghoa_tenTM"] = "<spring:message code="moit.07.form.cthanghoa.tenTM" />";
 NSWLang["moit_07_form_cthanghoa_maHHC"] = "<spring:message code="moit.07.form.cthanghoa.maHHC" />";
 NSWLang["moit_07_form_cthanghoa_hamLuong"] = "<spring:message code="moit.07.form.cthanghoa.hamLuong" />";
 NSWLang["moit_07_form_cthanghoa_soLuongHH"] = "<spring:message code="moit.07.form.cthanghoa.khoiL" />";
 NSWLang["moit_07_form_cthanghoa_donVT"] = "<spring:message code="moit.07.form.cthanghoa.donVT" />";
 NSWLang["moit_07_form_cthanghoa_loaiHinhHH"] = "<spring:message code="moit.07.form.cthanghoa.loaiHinhHH" />";
 NSWLang["moit_07_form_cthanghoa_moTaHH"] = "<spring:message code="moit.07.form.cthanghoa.moTaHH" />";
 NSWLang["moit_07_form_cthanghoa_soHopD"] = "<spring:message code="moit.07.form.cthanghoa.soHopD" />";
 NSWLang["moit_07_form_cthanghoa_ngayHD"] = "<spring:message code="moit.07.form.cthanghoa.ngayHD" />";
 NSWLang["moit_07_form_cthanghoa_ctXK"] = "<spring:message code="moit.07.form.cthanghoa.ctXK" />";
 NSWLang["moit_07_form_cthanghoa_ghiLai"] = "<spring:message code="moit.07.form.cthanghoa.ghiLai" />";
 NSWLang["moit_07_form_cthanghoa_dong"] = "<spring:message code="moit.07.form.cthanghoa.dong" />";
 NSWLang["moit_07_form_cthanghoa_error_maHonHop"] = "<spring:message code="moit.07.form.cthanghoa.err.maHonHop" />";
 NSWLang["moit_07_form_cthanghoa_error_hamLuong"] = "<spring:message code="moit.07.form.cthanghoa.error.hamLuong" />";
 NSWLang["moit_07_form_cthanghoa_error_chamPhay"] = "<spring:message code="moit.07.form.cthanghoa.err.chamPhay" />";
 NSWLang["moit_07_form_cthanghoa_error_hamLuongIVA"] = "<spring:message code="moit.07.form.cthanghoa.err.hamLuongIVA" />";
 NSWLang["moit_07_form_cthanghoa_error_hamLuongIVB"] = "<spring:message code="moit.07.form.cthanghoa.err.hamLuongIVB" />";
 NSWLang["moit_07_form_cthanghoa_error_thieuHangHoa"] = "<spring:message code="moit.07.form.cthanghoa.err.thieuHangHoa" />";
 NSWLang["moit_07_form_cthanghoa_error_soLCapLanDau"] = "<spring:message code="moit.07.form.cthanghoa.soLCapLanDau" />";
 NSWLang["moit_07_form_cthanghoa_error_soLuongDaNhap"] = "<spring:message code="moit.07.form.cthanghoa.err.soLuongDaNhap" />";
 NSWLang["moit_07_form_cthanghoa_error_err_soLuongConLai"] = "<spring:message code="moit.07.form.cthanghoa.err.soLuongConLai" />";
 NSWLang["moit_07_form_cthanghoa_error_soLuongDaNhapKhongDuocLonHon"] = "<spring:message code="moit.07.form.cthanghoa.err.soLuongDaNhapKhongDuocLonHon" />";
 NSWLang["moit_07_form_cthanghoa_error_err_timKiemSoPK"] = "<spring:message code="moit.07.form.timKiemSoPK" />";

</script>