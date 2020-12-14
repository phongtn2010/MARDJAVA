<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="application/javascript">
 
 NSWLang["mard.20.msg.table.history.stt"] = "<spring:message code="mard.20.msg.table.history.stt" />";
 NSWLang["mard.20.msg.table.history.donViXuLy"] = "<spring:message code="mard.20.msg.table.history.donViXuLy" />";
 NSWLang["mard.20.msg.table.history.chuyenVien"] = "<spring:message code="mard.20.msg.table.history.chuyenVien" />";
 NSWLang["mard.20.msg.table.history.ngayXuLy"] = "<spring:message code="mard.20.msg.table.history.ngayXuLy" />";
 NSWLang["mard.20.msg.table.history.noiDung"] = "<spring:message code="mard.20.msg.table.history.noiDung" />";
 NSWLang["mard.20.msg.table.history.trangThai"] = "<spring:message code="mard.20.msg.table.history.trangThai" />";
 NSWLang["mard.20.msg.table.history.taiLieuDinhKem"] = "<spring:message code="mard.20.msg.table.history.taiLieuDinhKem" />";
 
 NSWLang["mard.20.send.confirm"] = "<spring:message code="mard.20.send.confirm" />";
 NSWLang["mard.20.select.option"] = "<spring:message code="mard.20.select.option" />";
 NSWLang["mard.20.dateNotValid"] = "<spring:message code="mard.20.dateNotValid" />";
 NSWLang["mard.20.msg.xoaHoSoOk"] = "<spring:message code="mard.20.msg.xoaHoSoOk" />";
 NSWLang["mard.20.msg.xoaHoSoNo"] = "<spring:message code="mard.20.msg.xoaHoSoNo" />";
 NSWLang["mard.20.tepDinhKem.notValid"] = "<spring:message code="mard.20.tepDinhKem.notValid" />";
 NSWLang["mard.20.thuoc.notValid"] = "<spring:message code="mard.20.thuoc.notValid" />";
 NSWLang["mard.20.uploadSize"] = "<spring:message code="mard.20.uploadSize" />";
 NSWLang["mard.20.uploadInfo"] = "<spring:message code="mard.20.uploadInfo" />";
 NSWLang["mard.20.uploadInfo3"] = "<spring:message code="mard.20.uploadInfo3" />";

 NSWLang["mard.20.index.table.thongBaoPhi"] = "<spring:message code="mard.20.index.table.thongBaoPhi" />";
 NSWLang["mard.20.table.thongBaoPhi.col.stt"] = "<spring:message code="mard.20.table.thongBaoPhi.col.stt" />";
 NSWLang["mard.20.table.thongBaoPhi.col.fiAccountName"] = "<spring:message code="mard.20.table.thongBaoPhi.col.fiAccountName" />";
 NSWLang["mard.20.table.thongBaoPhi.col.fiAccountNo"] = "<spring:message code="mard.20.table.thongBaoPhi.col.fiAccountNo" />";
 NSWLang["mard.20.table.thongBaoPhi.col.fiCreateDate"] = "<spring:message code="mard.20.table.thongBaoPhi.col.fiCreateDate" />";
 NSWLang["mard.20.table.thongBaoPhi.col.fiNote"] = "<spring:message code="mard.20.table.thongBaoPhi.col.fiNote" />";
 NSWLang["mard.20.table.thongBaoPhi.col.fiTotalFee"] = "<spring:message code="mard.20.table.thongBaoPhi.col.fiTotalFee" />";
 NSWLang["mard.20.table.thongBaoPhi.col.fiTotalFeeChar"] = "<spring:message code="mard.20.table.thongBaoPhi.col.fiTotalFeeChar" />";

 NSWLang["mard.20.index.table.thongBaoChuyenKhoan"] = "<spring:message code="mard.20.index.table.thongBaoChuyenKhoan" />";
 NSWLang["mard.20.table.thongBaoChuyenKhoan.col.stt"] = "<spring:message code="mard.20.table.thongBaoChuyenKhoan.col.stt" />";
 NSWLang["mard.20.table.thongBaoChuyenKhoan.col.fiAccountName"] = "<spring:message code="mard.20.table.thongBaoChuyenKhoan.col.fiAccountName" />";
 NSWLang["mard.20.table.thongBaoChuyenKhoan.col.fiAccountNo"] = "<spring:message code="mard.20.table.thongBaoChuyenKhoan.col.fiAccountNo" />";
 NSWLang["mard.20.table.thongBaoChuyenKhoan.col.fiCreateDate"] = "<spring:message code="mard.20.table.thongBaoChuyenKhoan.col.fiCreateDate" />";
 NSWLang["mard.20.table.thongBaoChuyenKhoan.col.fiNote"] = "<spring:message code="mard.20.table.thongBaoChuyenKhoan.col.fiNote" />";
 NSWLang["mard.20.table.thongBaoChuyenKhoan.col.fiTotalFee"] = "<spring:message code="mard.20.table.thongBaoChuyenKhoan.col.fiTotalFee" />";
 NSWLang["mard.20.table.thongBaoChuyenKhoan.col.fiTotalFeeChar"] = "<spring:message code="mard.20.table.thongBaoChuyenKhoan.col.fiTotalFeeChar" />";
 NSWLang["mard.20.msg.capNhatHoSoOk"] = "<spring:message code="mard.20.msg.capNhatHoSoOk" />";
 NSWLang["mard.20.msg.capNhatHoSoNo"] = "<spring:message code="mard.20.msg.capNhatHoSoNo" />";
 NSWLang["mard.20.msg.taoMoiHoSoOk"] = "<spring:message code="mard.20.msg.taoMoiHoSoOk" />";
 NSWLang["mard.20.msg.taoMoiHoSoNo"] = "<spring:message code="mard.20.msg.taoMoiHoSoNo" />";
 NSWLang["mard.20.msg.addHangHoaNo"] = "<spring:message code="mard.20.msg.addHangHoaNo" />";
 NSWLang["mard.20.popup.lichSuHoSo"] = "<spring:message code="mard.20.popup.lichSuHoSo" />";
 NSWLang["mard.20.trang-dau-tien"] = "<spring:message code="mard.20.trang-dau-tien" />";
 NSWLang["mard.20.trang-truoc"] = "<spring:message code="mard.20.trang-truoc" />";
 NSWLang["mard.20.trang-sau"] = "<spring:message code="mard.20.trang-sau" />";
 NSWLang["mard.20.trang-cuoi"] = "<spring:message code="mard.20.trang-cuoi" />";
 NSWLang["mard.20.reason"] = "<spring:message code="mard.20.reason" />";
 NSWLang["mard.20.action.success"] = "<spring:message code="mard.20.action.success" />";
 NSWLang["mard.20.action.error"] = "<spring:message code="mard.20.action.error" />";
 NSWLang["mard.20.index.table.th.12"] = "<spring:message code="mard.20.index.table.th.12" />";
 NSWLang["mard.20.guiThanhToanPhi"] = "<spring:message code="mard.20.guiThanhToanPhi" />";
 NSWLang["mard.20.ngayGuiThanhToanPhi"] = "<spring:message code="mard.20.ngayGuiThanhToanPhi" />";
 NSWLang["mard.20.tepDinhKemThanhToanPhi"] = "<spring:message code="mard.20.tepDinhKemThanhToanPhi" />";
 NSWLang["mard.20.send.timeout"] = "<spring:message code="mard.20.send.timeout" />";
 NSWLang["mard.20.TbdThuoc20.fiProductType"] = "<spring:message code="mard.20.TbdThuoc20.fiProductType" />";
 NSWLang["mard.20.TbdThuoc20.fiNameOfProduct"] = "<spring:message code="mard.20.TbdThuoc20.fiNameOfProduct" />";
 NSWLang["mard.20.TbdThuoc20.fiWeight"] = "<spring:message code="mard.20.TbdThuoc20.fiWeight" />";
 NSWLang["mard.20.TbdThuoc20.fiWeightUnitName"] = "<spring:message code="mard.20.TbdThuoc20.fiWeightUnitName" />";
 NSWLang["mard.20.TbdThuoc20.fiMainUse"] = "<spring:message code="mard.20.TbdThuoc20.fiMainUse" />";
 NSWLang["mard.20.TbdThuoc20.fiOrigin"] = "<spring:message code="mard.20.TbdThuoc20.fiOrigin" />";
 NSWLang["mard.20.TbdThuoc20.fiOrganization"] = "<spring:message code="mard.20.TbdThuoc20.fiOrganization"/>";
 NSWLang["mard.20.TbdThuoc20.fiSerialNo"] = "<spring:message code="mard.20.TbdThuoc20.fiSerialNo"/>";
 NSWLang["mard.20.TbdThuoc20.fiTotal"] = "<spring:message code="mard.20.TbdThuoc20.fiTotal"/>";
 NSWLang["mard.20.TbdThuoc20.fiManufacturerName"] ="<spring:message code="mard.20.TbdThuoc20.fiManufacturerName"/>";
 NSWLang["mard.20.TbdThuoc20.fiNameOfGoods"] = "<spring:message code="mard.20.TbdThuoc20.fiNameOfGoods" />";
 NSWLang["mard.20.TbdThuoc20.fiTypeOfPackage"] = "<spring:message code="mard.20.TbdThuoc20.fiTypeOfPackage" />";
 NSWLang["mard.20.TbdThuoc20.fiImportTimeFrom"] = "<spring:message code="mard.20.TbdThuoc20.fiImportTimeFrom" />";
 NSWLang["mard.20.TbdThuoc20.fiImportTimeTo"] = "<spring:message code="mard.20.TbdThuoc20.fiImportTimeTo" />";
 NSWLang["mard.20.TbdThuoc20.fiCountryName"] ="<spring:message code="mard.20.TbdThuoc20.fiCountryName" />";
 NSWLang["mard.20.TbdThuoc20.fiWeightKG"] ="<spring:message code="mard.20.TbdThuoc20.fiWeightKG" />";
 NSWLang["mard.20.TbdThuoc20.fiWeightML"] ="<spring:message code="mard.20.TbdThuoc20.fiWeightML" />";
 NSWLang["mard.20.TbdThuoc20.fiActiveIngredient"] = "<spring:message code="mard.20.TbdThuoc20.fiActiveIngredient" />";
 NSWLang["mard.20.TbdThuoc20.fiGate"] = "<spring:message code="mard.20.TbdThuoc20.fiGate" />";
 NSWLang["mard.20.TbdThuoc20.fiDocumentNo"] = "<spring:message code = "mard.20.TbdThuoc20.fiDocumentNo" />";
 NSWLang["mard.20.TbdThuoc20.fiCirculationNo"] = "<spring:message code="mard.20.TbdThuoc20.fiCirculationNo" />";
 NSWLang["mard.20.TbdThuoc20.fiTestResult"] = "<spring:message code="mard.20.TbdThuoc20.fiTestResult" />";
 NSWLang["mard.20.TbdThuoc20.tepDinhKemThuoc"] ="<spring:message code="mard.20.TbdThuoc20.tepDinhKemThuoc" />";
 NSWLang["mard.20.TbdThuoc20.fiDosageType"] = "<spring:message code="mard.20.TbdThuoc20.fiDosageType" />";
 NSWLang["mard.20.TbdThuoc20.fiImporterName"] = "<spring:message code="mard.20.TbdThuoc20.fiImporterName" />";

 NSWLang["mard.20.TbdThuoc20.fiProductFile"] ="<spring:message code="mard.20.TbdThuoc20.fiProductFile" />";
 NSWLang["mard.20.form.thongTinThuoc"] = "<spring:message code="mard.20.form.thongTinThuoc" />";
 NSWLang["mard.20.loiCapNhatDuLieu"] = "<spring:message code="mard.20.loiCapNhatDuLieu" />";
 NSWLang["mard.20.loiKieuFileExcel"] = "<spring:message code="mard.20.loiKieuFileExcel" />";
 NSWLang["mard.20.dinhDangFileThongBaoPhi"] = "<spring:message code="mard.20.dinhDangFileThongBaoPhi" />";
 NSWLang["mard.16.confirmSave"] = "<spring:message code="mard.16.confirmSave" />";
 NSWLang["mard.20.TbdThuoc3.chucnang"] = "<spring:message code="mard.20.TbdThuoc3.chucnang" />";
 NSWLang["mard.20.TbdThuoc3.buttonSua"] = "<spring:message code="mard.20.TbdThuoc3.buttonSua" />";
 NSWLang["mard.20.TbdThuoc3.buttonXoa"] = "<spring:message code="mard.20.TbdThuoc3.buttonXoa" />";
 NSWLang["mard.20.index.table.th.14"] = "<spring:message code="mard.20.index.table.th.14" />"



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
</script>
