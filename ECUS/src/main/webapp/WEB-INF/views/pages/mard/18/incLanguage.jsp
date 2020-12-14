<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="application/javascript">
 
 NSWLang["mard.18.msg.table.history.stt"] = "<spring:message code="mard.18.msg.table.history.stt" />";
 NSWLang["mard.18.msg.table.history.donViXuLy"] = "<spring:message code="mard.18.msg.table.history.donViXuLy" />";
 NSWLang["mard.18.msg.table.history.chuyenVien"] = "<spring:message code="mard.18.msg.table.history.chuyenVien" />";
 NSWLang["mard.18.msg.table.history.ngayXuLy"] = "<spring:message code="mard.18.msg.table.history.ngayXuLy" />";
 NSWLang["mard.18.msg.table.history.noiDung"] = "<spring:message code="mard.18.msg.table.history.noiDung" />";
 NSWLang["mard.18.msg.table.history.trangThai"] = "<spring:message code="mard.18.msg.table.history.trangThai" />";
 NSWLang["mard.18.msg.table.history.taiLieuDinhKem"] = "<spring:message code="mard.18.msg.table.history.taiLieuDinhKem" />";
 
 NSWLang["mard.18.send.confirm"] = "<spring:message code="mard.18.send.confirm" />";
 NSWLang["mard.18.select.option"] = "<spring:message code="mard.18.select.option" />";
 NSWLang["mard.18.dateNotValid"] = "<spring:message code="mard.18.dateNotValid" />";
 NSWLang["mard.18.msg.xoaHoSoOk"] = "<spring:message code="mard.18.msg.xoaHoSoOk" />";
 NSWLang["mard.18.msg.xoaHoSoNo"] = "<spring:message code="mard.18.msg.xoaHoSoNo" />";
 NSWLang["mard.18.tepDinhKem.notValid"] = "<spring:message code="mard.18.tepDinhKem.notValid" />";
 NSWLang["mard.18.thuoc.notValid"] = "<spring:message code="mard.18.thuoc.notValid" />";
 NSWLang["mard.18.uploadSize"] = "<spring:message code="mard.18.uploadSize" />";
 NSWLang["mard.18.uploadInfo"] = "<spring:message code="mard.18.uploadInfo" />";
 NSWLang["mard.18.uploadInfo3"] = "<spring:message code="mard.18.uploadInfo3" />";

 NSWLang["mard.18.index.table.thongBaoPhi"] = "<spring:message code="mard.18.index.table.thongBaoPhi" />";
 NSWLang["mard.18.table.thongBaoPhi.col.stt"] = "<spring:message code="mard.18.table.thongBaoPhi.col.stt" />";
 NSWLang["mard.18.table.thongBaoPhi.col.fiAccountName"] = "<spring:message code="mard.18.table.thongBaoPhi.col.fiAccountName" />";
 NSWLang["mard.18.table.thongBaoPhi.col.fiAccountNo"] = "<spring:message code="mard.18.table.thongBaoPhi.col.fiAccountNo" />";
 NSWLang["mard.18.table.thongBaoPhi.col.fiCreateDate"] = "<spring:message code="mard.18.table.thongBaoPhi.col.fiCreateDate" />";
 NSWLang["mard.18.table.thongBaoPhi.col.fiNote"] = "<spring:message code="mard.18.table.thongBaoPhi.col.fiNote" />";
 NSWLang["mard.18.table.thongBaoPhi.col.fiTotalFee"] = "<spring:message code="mard.18.table.thongBaoPhi.col.fiTotalFee" />";
 NSWLang["mard.18.table.thongBaoPhi.col.fiTotalFeeChar"] = "<spring:message code="mard.18.table.thongBaoPhi.col.fiTotalFeeChar" />";

 NSWLang["mard.18.index.table.thongBaoChuyenKhoan"] = "<spring:message code="mard.18.index.table.thongBaoChuyenKhoan" />";
 NSWLang["mard.18.index.table.th.15"]= "<spring:message code="mard.18.index.table.th.15"/>";
 NSWLang["mard.18.table.thongBaoChuyenKhoan.col.stt"] = "<spring:message code="mard.18.table.thongBaoChuyenKhoan.col.stt" />";
 NSWLang["mard.18.table.thongBaoChuyenKhoan.col.fiAccountName"] = "<spring:message code="mard.18.table.thongBaoChuyenKhoan.col.fiAccountName" />";
 NSWLang["mard.18.table.thongBaoChuyenKhoan.col.fiAccountNo"] = "<spring:message code="mard.18.table.thongBaoChuyenKhoan.col.fiAccountNo" />";
 NSWLang["mard.18.table.thongBaoChuyenKhoan.col.fiCreateDate"] = "<spring:message code="mard.18.table.thongBaoChuyenKhoan.col.fiCreateDate" />";
 NSWLang["mard.18.table.thongBaoChuyenKhoan.col.fiNote"] = "<spring:message code="mard.18.table.thongBaoChuyenKhoan.col.fiNote" />";
 NSWLang["mard.18.table.thongBaoChuyenKhoan.col.fiTotalFee"] = "<spring:message code="mard.18.table.thongBaoChuyenKhoan.col.fiTotalFee" />";
 NSWLang["mard.18.table.thongBaoChuyenKhoan.col.fiTotalFeeChar"] = "<spring:message code="mard.18.table.thongBaoChuyenKhoan.col.fiTotalFeeChar" />";
 NSWLang["mard.18.msg.capNhatHoSoOk"] = "<spring:message code="mard.18.msg.capNhatHoSoOk" />";
 NSWLang["mard.18.msg.capNhatHoSoNo"] = "<spring:message code="mard.18.msg.capNhatHoSoNo" />";
 NSWLang["mard.18.msg.taoMoiHoSoOk"] = "<spring:message code="mard.18.msg.taoMoiHoSoOk" />";
 NSWLang["mard.18.msg.taoMoiHoSoNo"] = "<spring:message code="mard.18.msg.taoMoiHoSoNo" />";
 NSWLang["mard.18.msg.addHangHoaNo"] = "<spring:message code="mard.18.msg.addHangHoaNo" />";
 NSWLang["mard.18.popup.lichSuHoSo"] = "<spring:message code="mard.18.popup.lichSuHoSo" />";
 NSWLang["mard.18.trang-dau-tien"] = "<spring:message code="mard.18.trang-dau-tien" />";
 NSWLang["mard.18.trang-truoc"] = "<spring:message code="mard.18.trang-truoc" />";
 NSWLang["mard.18.trang-sau"] = "<spring:message code="mard.18.trang-sau" />";
 NSWLang["mard.18.trang-cuoi"] = "<spring:message code="mard.18.trang-cuoi" />";
 NSWLang["mard.18.reason"] = "<spring:message code="mard.18.reason" />";
 NSWLang["mard.18.TbdHoSo18.fiDeclarationNo"] = "<spring:message code="mard.18.TbdHoSo18.fiDeclarationNo" />";
 NSWLang["mard.18.TbdHoSo18.fiBillNo"] = "<spring:message code="mard.18.TbdHoSo18.fiBillNo" />";
 NSWLang["mard.18.action.success"] = "<spring:message code="mard.18.action.success" />";
 NSWLang["mard.18.action.error"] = "<spring:message code="mard.18.action.error" />";
 NSWLang["mard.18.index.table.th.12"] = "<spring:message code="mard.18.index.table.th.12" />";
 NSWLang["mard.18.guiThanhToanPhi"] = "<spring:message code="mard.18.guiThanhToanPhi" />";
 NSWLang["mard.18.ngayGuiThanhToanPhi"] = "<spring:message code="mard.18.ngayGuiThanhToanPhi" />";
 NSWLang["mard.18.tepDinhKemThanhToanPhi"] = "<spring:message code="mard.18.tepDinhKemThanhToanPhi" />";
 NSWLang["mard.18.send.timeout"] = "<spring:message code="mard.18.send.timeout" />";
 NSWLang["mard.18.TbdThuoc18.fiProductType"] = "<spring:message code="mard.18.TbdThuoc18.fiProductType" />";
 NSWLang["mard.18.TbdThuoc18.fiNameOfProduct"] = "<spring:message code="mard.18.TbdThuoc18.fiNameOfProduct" />";
 NSWLang["mard.18.TbdThuoc18.fiWeight"] = "<spring:message code="mard.18.TbdThuoc18.fiWeight" />";
 NSWLang["mard.18.TbdThuoc18.fiWeightUnitName"] = "<spring:message code="mard.18.TbdThuoc18.fiWeightUnitName" />";
 NSWLang["mard.18.TbdThuoc18.fiMainUse"] = "<spring:message code="mard.18.TbdThuoc18.fiMainUse" />";
 NSWLang["mard.18.TbdThuoc18.fiOrigin"] = "<spring:message code="mard.18.TbdThuoc18.fiOrigin" />";
 NSWLang["mard.18.TbdThuoc18.fiOrganization"] = "<spring:message code="mard.18.TbdThuoc18.fiOrganization"/>";
 NSWLang["mard.18.TbdThuoc18.fiSerialNo"] = "<spring:message code="mard.18.TbdThuoc18.fiSerialNo"/>";
 NSWLang["mard.18.TbdThuoc18.fiTotal"] = "<spring:message code="mard.18.TbdThuoc18.fiTotal"/>";
 NSWLang["mard.18.TbdThuoc18.fiLicenseFileNo"] = "<spring:message code="mard.18.TbdThuoc18.fiLicenseFileNo" />";
 NSWLang["mard.18.TbdThuoc18.fiManufacturerName"] ="<spring:message code="mard.18.TbdThuoc18.fiManufacturerName"/>";
 NSWLang["mard.18.TbdThuoc18.fiNameOfGoods"] = "<spring:message code="mard.18.TbdThuoc18.fiNameOfGoods" />";
 NSWLang["mard.18.TbdThuoc18.fiTypeOfPackage"] = "<spring:message code="mard.18.TbdThuoc18.fiTypeOfPackage" />";
 NSWLang["mard.18.TbdThuoc18.fiImportTimeFrom"] = "<spring:message code="mard.18.TbdThuoc18.fiImportTimeFrom" />";
 NSWLang["mard.18.TbdThuoc18.fiImportTimeTo"] = "<spring:message code="mard.18.TbdThuoc18.fiImportTimeTo" />";
 NSWLang["mard.18.TbdThuoc18.fiCountryName"] ="<spring:message code="mard.18.TbdThuoc18.fiCountryName" />";
 NSWLang["mard.18.TbdThuoc18.fiWeightKG"] ="<spring:message code="mard.18.TbdThuoc18.fiWeightKG" />";
 NSWLang["mard.18.TbdThuoc18.fiWeightML"] ="<spring:message code="mard.18.TbdThuoc18.fiWeightML" />";
 NSWLang["mard.18.TbdThuoc18.fiActiveIngredient"] = "<spring:message code="mard.18.TbdThuoc18.fiActiveIngredient" />";
 NSWLang["mard.18.TbdThuoc18.fiGate"] = "<spring:message code="mard.18.TbdThuoc18.fiGate" />";
 NSWLang["mard.18.TbdThuoc18.fiDocumentNo"] = "<spring:message code = "mard.18.TbdThuoc18.fiDocumentNo" />";
 NSWLang["mard.18.TbdThuoc18.fiCirculationNo"] = "<spring:message code="mard.18.TbdThuoc18.fiCirculationNo" />";
 NSWLang["mard.18.form.thongTinThuoc"] = "<spring:message code="mard.18.form.thongTinThuoc" />";
 NSWLang["mard.18.loiCapNhatDuLieu"] = "<spring:message code="mard.18.loiCapNhatDuLieu" />";
 NSWLang["mard.18.loiKieuFileExcel"] = "<spring:message code="mard.18.loiKieuFileExcel" />";
 NSWLang["mard.18.dinhDangFileThongBaoPhi"] = "<spring:message code="mard.18.dinhDangFileThongBaoPhi" />";
 NSWLang["mard.16.confirmSave"] = "<spring:message code="mard.16.confirmSave" />";
 NSWLang["mard.18.TbdThuoc3.chucnang"] = "<spring:message code="mard.18.TbdThuoc3.chucnang" />";
 NSWLang["mard.18.TbdThuoc3.buttonSua"] = "<spring:message code="mard.18.TbdThuoc3.buttonSua" />";
 NSWLang["mard.18.TbdThuoc3.buttonXoa"] = "<spring:message code="mard.18.TbdThuoc3.buttonXoa" />";
 NSWLang["mard.18.TbdThuoc18.fiProductFile"] = "<spring:message code="mard.18.TbdThuoc18.fiProductFile" />";
 NSWLang["mard.18.index.table.th.14"] = "<spring:message code="mard.18.index.table.th.14" />"



 </script>
 <script type="text/javascript">
    var idHoSo = ${idHoSo};
    var isSign = ${isSign};
    var isDevTest = ${isDevTest};
    var isView = ${isView};
    var action = ${action};
    var locale = "${locale}";
    var documentType = "${documentType}";
    var taxCode = "${taxCode}";
    const urlUploadFile = ""
</script>
