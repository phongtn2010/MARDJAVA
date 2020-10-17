<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
//MONRE 01

 NSWLang["sbv_01_msg_chon"] = "<spring:message code="sbv.01.message.chon" />";
 NSWLang["sbv_01_msg_xuat_khau"] = "<spring:message code="sbv.01.message.xuatkhau" />";
 NSWLang["sbv_01_msg_nhap_khau"] = "<spring:message code="sbv.01.message.nhapkhau" />";
 NSWLang["sbv_01_status_01"] = "<spring:message code="sbv.01.status.01" />";
 NSWLang["sbv_01_status_02"] = "<spring:message code="sbv.01.status.02" />";
 NSWLang["sbv_01_status_03"] = "<spring:message code="sbv.01.status.03" />";
 NSWLang["sbv_01_status_04"] = "<spring:message code="sbv.01.status.04" />";
 NSWLang["sbv_01_status_05"] = "<spring:message code="sbv.01.status.05" />";
 NSWLang["sbv_01_status_06"] = "<spring:message code="sbv.01.status.06" />";
 NSWLang["sbv_01_status_07"] = "<spring:message code="sbv.01.status.07" />";
 NSWLang["sbv_01_status_08"] = "<spring:message code="sbv.01.status.08" />";
 NSWLang["sbv_01_status_09"] = "<spring:message code="sbv.01.status.09" />";
 NSWLang["sbv_01_status_10"] = "<spring:message code="sbv.01.status.10" />";
 NSWLang["sbv_01_form_error_01"] = "<spring:message code="sbv.01.form.error.01" />";
 NSWLang["sbv_01_form_error_02"] = "<spring:message code="sbv.01.form.error.02" />";
 NSWLang["sbv_01_form_error_03"] = "<spring:message code="sbv.01.form.error.03" />";
 NSWLang["sbv_01_form_error_04"] = "<spring:message code="sbv.01.form.error.04" />";
 NSWLang["sbv_01_form_error_05"] = "<spring:message code="sbv.01.form.error.05" />";
 NSWLang["sbv_01_form_error_06"] = "<spring:message code="sbv.01.form.error.06" />";
 NSWLang["sbv_01_lichsh_table_00"] = "<spring:message code="sbv.01.lichsu.table.00" />";
 NSWLang["sbv_01_lichsh_table_01"] = "<spring:message code="sbv.01.lichsu.table.01" />";
 NSWLang["sbv_01_lichsh_table_02"] = "<spring:message code="sbv.01.lichsu.table.02" />";
 NSWLang["sbv_01_lichsh_table_03"] = "<spring:message code="sbv.01.lichsu.table.03" />";
 NSWLang["sbv_01_lichsh_table_04"] = "<spring:message code="sbv.01.lichsu.table.04" />";
 NSWLang["sbv_01_lichsh_table_05"] = "<spring:message code="sbv.01.lichsu.table.05" />";
 NSWLang["sbv_01_lichsh_table_06"] = "<spring:message code="sbv.01.lichsu.table.06" />";
 NSWLang["sbv_01_lichsh_table_07"] = "<spring:message code="sbv.01.lichsu.table.07" />";
 NSWLang["sbv_01_lichsh_table_08"] = "<spring:message code="sbv.01.lichsu.table.08" />";
 NSWLang["sbv_01_popup_xemgxn"] = "<spring:message code="sbv.01.popup.xemgxn" />";
 NSWLang["sbv_01_popup_guihs"] = "<spring:message code="sbv.01.popup.guiHoSo" />";
 NSWLang["sbv_01_popup_guihs_confirm"] = "<spring:message code="sbv.01.popup.guiHoSo.confirm" />";
 NSWLang["sbv_01_popup_huyhs"] = "<spring:message code="sbv.01.popup.huyHoSo" />";
 NSWLang["sbv_01_popup_huyhs_01"] = "<spring:message code="sbv.01.popup.huyHoSo.01" />";
 NSWLang["sbv_01_popup_xemvanban"] = "<spring:message code="sbv.01.popup.xemvanban" />";
 NSWLang["sbv_01_popup_xemvanban_bt_pdf"] = "<spring:message code="sbv.01.baocao.xuatpdf" />";
 NSWLang["sbv_01_popup_xemvanban_bt_docx"] = "<spring:message code="sbv.01.baocao.xuatdoc" />";
 NSWLang["sbv_01_form_teptin_error_1"] = "<spring:message code="sbv.01.form.teptin.error.1" />";
 NSWLang["sbv_01_form_teptin_error_2"] = "<spring:message code="sbv.01.form.teptin.error.2" />";
 NSWLang["sbv_01_form_teptin_error_3"] = "<spring:message code="sbv.01.form.teptin.error.3" />";
 NSWLang["sbv_01_form_teptin_error_4"] = "<spring:message code="sbv.01.form.teptin.error.4" />";
 NSWLang["sbv_01_form_tiente_error_5"] = "<spring:message code="sbv.01.form.tiente.error.5" />";
 NSWLang["sbv_01_form_tiente_error_6"] = "<spring:message code="sbv.01.form.tiente.error.6" />";
 NSWLang["sbv_01_form_tiente_error_7"] = "<spring:message code="sbv.01.form.tiente.tgxnk" />";
 NSWLang["sbv_01_form_timkiem_ngaytao"] = "<spring:message code="sbv.01.form.timkiem.ngaytao" />";
 NSWLang["sbv_01_gxn_table_tiente_01"] = "<spring:message code="sbv.01.gxn.table.tiente.th.01" />";
 NSWLang["sbv_01_gxn_table_tiente_02"] = "<spring:message code="sbv.01.gxn.table.tiente.th.02" />";
 NSWLang["sbv_01_gxn_table_tiente_03"] = "<spring:message code="sbv.01.gxn.table.tiente.th.03" />";
 NSWLang["sbv_01_gxn_table_tiente_04"] = "<spring:message code="sbv.01.gxn.table.tiente.th.04" />";
 NSWLang["sbv_01_token_error"] = "<spring:message code="sbv.01.guihoso.token" />";
 NSWLang["sbv_01_totalSizeUploadError"] = "<spring:message code="sbv.01.totalSizeUploadError" />";
 NSWLang["sbv_01_totalSizeUploadErrorDefault"] = "<spring:message code="sbv.01.statusKySo.Default" />";
NSWLang["sbv.01.trang-dau-tien"] = "<spring:message code="sbv.01.trang-dau-tien" />";
NSWLang["sbv.01.trang-truoc"] = "<spring:message code="sbv.01.trang-truoc" />";
NSWLang["sbv.01.trang-sau"] = "<spring:message code="sbv.01.trang-sau" />";
NSWLang["sbv.01.trang-cuoi"] = "<spring:message code="sbv.01.trang-cuoi" />";


</script>