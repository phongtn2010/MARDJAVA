<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="application/javascript">

    NSWLang["mard.19.msg.table.history.stt"] = "<spring:message code="mard.19.msg.table.history.stt" />";
    NSWLang["mard.19.msg.table.history.donViXuLy"] = "<spring:message code="mard.19.msg.table.history.donViXuLy" />";
    NSWLang["mard.19.msg.table.history.chuyenVien"] = "<spring:message code="mard.19.msg.table.history.chuyenVien" />";
    NSWLang["mard.19.msg.table.history.ngayXuLy"] = "<spring:message code="mard.19.msg.table.history.ngayXuLy" />";
    NSWLang["mard.19.msg.table.history.noiDung"] = "<spring:message code="mard.19.msg.table.history.noiDung" />";
    NSWLang["mard.19.msg.table.history.trangThai"] = "<spring:message code="mard.19.msg.table.history.trangThai" />";
    NSWLang["mard.19.msg.table.history.taiLieuDinhKem"] = "<spring:message code="mard.19.msg.table.history.taiLieuDinhKem" />";

    NSWLang["mard.19.send.confirm"] = "<spring:message code="mard.19.send.confirm" />";
    NSWLang["mard.19.select.option"] = "<spring:message code="mard.19.select.option" />";
    NSWLang["mard.19.dateNotValid"] = "<spring:message code="mard.19.dateNotValid" />";
    NSWLang["mard.19.msg.xoaHoSoOk"] = "<spring:message code="mard.19.msg.xoaHoSoOk" />";
    NSWLang["mard.19.msg.xoaHoSoNo"] = "<spring:message code="mard.19.msg.xoaHoSoNo" />";
    NSWLang["mard.19.tepDinhKem.notValid"] = "<spring:message code="mard.19.tepDinhKem.notValid" />";
    NSWLang["mard.19.thuoc.notValid"] = "<spring:message code="mard.19.thuoc.notValid" />";
    NSWLang["mard.19.uploadSize"] = "<spring:message code="mard.19.uploadSize" />";
    NSWLang["mard.19.uploadInfo"] = "<spring:message code="mard.19.uploadInfo" />";
    NSWLang["mard.19.uploadInfo3"] = "<spring:message code="mard.19.uploadInfo3" />";

    NSWLang["mard.19.index.table.thongBaoPhi"] = "<spring:message code="mard.19.index.table.thongBaoPhi" />";
    NSWLang["mard.19.table.thongBaoPhi.col.stt"] = "<spring:message code="mard.19.table.thongBaoPhi.col.stt" />";
    NSWLang["mard.19.table.thongBaoPhi.col.fiAccountName"] = "<spring:message code="mard.19.table.thongBaoPhi.col.fiAccountName" />";
    NSWLang["mard.19.table.thongBaoPhi.col.fiAccountNo"] = "<spring:message code="mard.19.table.thongBaoPhi.col.fiAccountNo" />";
    NSWLang["mard.19.table.thongBaoPhi.col.fiCreateDate"] = "<spring:message code="mard.19.table.thongBaoPhi.col.fiCreateDate" />";
    NSWLang["mard.19.table.thongBaoPhi.col.fiNote"] = "<spring:message code="mard.19.table.thongBaoPhi.col.fiNote" />";
    NSWLang["mard.19.table.thongBaoPhi.col.fiTotalFee"] = "<spring:message code="mard.19.table.thongBaoPhi.col.fiTotalFee" />";
    NSWLang["mard.19.table.thongBaoPhi.col.fiTotalFeeChar"] = "<spring:message code="mard.19.table.thongBaoPhi.col.fiTotalFeeChar" />";

    NSWLang["mard.19.index.table.thongBaoChuyenKhoan"] = "<spring:message code="mard.19.index.table.thongBaoChuyenKhoan" />";
    NSWLang["mard.19.table.thongBaoChuyenKhoan.col.stt"] = "<spring:message code="mard.19.table.thongBaoChuyenKhoan.col.stt" />";
    NSWLang["mard.19.table.thongBaoChuyenKhoan.col.fiAccountName"] = "<spring:message code="mard.19.table.thongBaoChuyenKhoan.col.fiAccountName" />";
    NSWLang["mard.19.table.thongBaoChuyenKhoan.col.fiAccountNo"] = "<spring:message code="mard.19.table.thongBaoChuyenKhoan.col.fiAccountNo" />";
    NSWLang["mard.19.table.thongBaoChuyenKhoan.col.fiCreateDate"] = "<spring:message code="mard.19.table.thongBaoChuyenKhoan.col.fiCreateDate" />";
    NSWLang["mard.19.table.thongBaoChuyenKhoan.col.fiNote"] = "<spring:message code="mard.19.table.thongBaoChuyenKhoan.col.fiNote" />";
    NSWLang["mard.19.table.thongBaoChuyenKhoan.col.fiTotalFee"] = "<spring:message code="mard.19.table.thongBaoChuyenKhoan.col.fiTotalFee" />";
    NSWLang["mard.19.table.thongBaoChuyenKhoan.col.fiTotalFeeChar"] = "<spring:message code="mard.19.table.thongBaoChuyenKhoan.col.fiTotalFeeChar" />";
    NSWLang["mard.19.msg.capNhatHoSoOk"] = "<spring:message code="mard.19.msg.capNhatHoSoOk" />";
    NSWLang["mard.19.msg.capNhatHoSoNo"] = "<spring:message code="mard.19.msg.capNhatHoSoNo" />";
    NSWLang["mard.19.msg.taoMoiHoSoOk"] = "<spring:message code="mard.19.msg.taoMoiHoSoOk" />";
    NSWLang["mard.19.msg.taoMoiHoSoNo"] = "<spring:message code="mard.19.msg.taoMoiHoSoNo" />";
    NSWLang["mard.19.msg.addHangHoaNo"] = "<spring:message code="mard.19.msg.addHangHoaNo" />";
    NSWLang["mard.19.popup.lichSuHoSo"] = "<spring:message code="mard.19.popup.lichSuHoSo" />";
    NSWLang["mard.19.trang-dau-tien"] = "<spring:message code="mard.19.trang-dau-tien" />";
    NSWLang["mard.19.trang-truoc"] = "<spring:message code="mard.19.trang-truoc" />";
    NSWLang["mard.19.trang-sau"] = "<spring:message code="mard.19.trang-sau" />";
    NSWLang["mard.19.trang-cuoi"] = "<spring:message code="mard.19.trang-cuoi" />";
    NSWLang["mard.19.reason"] = "<spring:message code="mard.19.reason" />";
    NSWLang["mard.19.TbdHoSo19.fiDeclarationNo"] = "<spring:message code="mard.19.TbdHoSo19.fiDeclarationNo" />";
    NSWLang["mard.19.action.success"] = "<spring:message code="mard.19.action.success" />";
    NSWLang["mard.19.action.error"] = "<spring:message code="mard.19.action.error" />";
    NSWLang["mard.19.index.table.th.12"] = "<spring:message code="mard.19.index.table.th.12" />";
    NSWLang["mard.19.guiThanhToanPhi"] = "<spring:message code="mard.19.guiThanhToanPhi" />";
    NSWLang["mard.19.ngayGuiThanhToanPhi"] = "<spring:message code="mard.19.ngayGuiThanhToanPhi" />";
    NSWLang["mard.19.tepDinhKemThanhToanPhi"] = "<spring:message code="mard.19.tepDinhKemThanhToanPhi" />";
    NSWLang["mard.19.send.timeout"] = "<spring:message code="mard.19.send.timeout" />";
    NSWLang["mard.19.TbdThuoc19.fiProductType"] = "<spring:message code="mard.19.TbdThuoc19.fiProductType" />";
    NSWLang["mard.19.TbdThuoc19.fiNameOfProduct"] = "<spring:message code="mard.19.TbdThuoc19.fiNameOfProduct" />";
    NSWLang["mard.19.TbdThuoc19.fiWeight"] = "<spring:message code="mard.19.TbdThuoc19.fiWeight" />";
    NSWLang["mard.19.TbdThuoc19.fiWeightUnitName"] = "<spring:message code="mard.19.TbdThuoc19.fiWeightUnitName" />";
    NSWLang["mard.19.TbdThuoc19.fiMainUse"] = "<spring:message code="mard.19.TbdThuoc19.fiMainUse" />";
    NSWLang["mard.19.TbdThuoc19.fiOrigin"] = "<spring:message code="mard.19.TbdThuoc19.fiOrigin" />";
    NSWLang["mard.19.TbdThuoc19.fiOrganization"] = "<spring:message code="mard.19.TbdThuoc19.fiOrganization"/>";
    NSWLang["mard.19.TbdThuoc19.fiSerialNo"] = "<spring:message code="mard.19.TbdThuoc19.fiSerialNo"/>";
    NSWLang["mard.19.TbdThuoc19.fiTotal"] = "<spring:message code="mard.19.TbdThuoc19.fiTotal"/>";
    NSWLang["mard.19.TbdThuoc19.fiLicenseFileNo"] = "<spring:message code="mard.19.TbdThuoc19.fiLicenseFileNo" />";
    NSWLang["mard.19.TbdThuoc19.fiManufacturerName"] ="<spring:message code="mard.19.TbdThuoc19.fiManufacturerName"/>";
    NSWLang["mard.19.TbdThuoc19.fiNameOfGoods"] = "<spring:message code="mard.19.TbdThuoc19.fiNameOfGoods" />";
    NSWLang["mard.19.TbdThuoc19.fiTypeOfPackage"] = "<spring:message code="mard.19.TbdThuoc19.fiTypeOfPackage" />";
    NSWLang["mard.19.TbdThuoc19.fiImportTimeFrom"] = "<spring:message code="mard.19.TbdThuoc19.fiImportTimeFrom" />";
    NSWLang["mard.19.TbdThuoc19.fiImportTimeTo"] = "<spring:message code="mard.19.TbdThuoc19.fiImportTimeTo" />";
    NSWLang["mard.19.TbdThuoc19.fiCountryName"] ="<spring:message code="mard.19.TbdThuoc19.fiCountryName" />";
    NSWLang["mard.19.TbdThuoc19.fiWeightKG"] ="<spring:message code="mard.19.TbdThuoc19.fiWeightKG" />";
    NSWLang["mard.19.TbdThuoc19.fiWeightML"] ="<spring:message code="mard.19.TbdThuoc19.fiWeightML" />";
    NSWLang["mard.19.TbdThuoc19.fiActiveIngredient"] = "<spring:message code="mard.19.TbdThuoc19.fiActiveIngredient" />";
    NSWLang["mard.19.TbdThuoc19.fiGate"] = "<spring:message code="mard.19.TbdThuoc19.fiGate" />";
    NSWLang["mard.19.TbdThuoc19.fiDocumentNo"] = "<spring:message code = "mard.19.TbdThuoc19.fiDocumentNo" />";
    NSWLang["mard.19.TbdThuoc19.fiCirculationNo"] = "<spring:message code="mard.19.TbdThuoc19.fiCirculationNo" />";
    NSWLang["mard.19.form.thongTinThuoc"] = "<spring:message code="mard.19.form.thongTinThuoc" />";
    NSWLang["mard.19.loiCapNhatDuLieu"] = "<spring:message code="mard.19.loiCapNhatDuLieu" />";
    NSWLang["mard.19.loiKieuFileExcel"] = "<spring:message code="mard.19.loiKieuFileExcel" />";
    NSWLang["mard.19.dinhDangFileThongBaoPhi"] = "<spring:message code="mard.19.dinhDangFileThongBaoPhi" />";
    NSWLang["mard.16.confirmSave"] = "<spring:message code="mard.16.confirmSave" />";
    NSWLang["mard.19.TbdThuoc3.chucnang"] = "<spring:message code="mard.19.TbdThuoc3.chucnang" />";
    NSWLang["mard.19.TbdThuoc3.buttonSua"] = "<spring:message code="mard.19.TbdThuoc3.buttonSua" />";
    NSWLang["mard.19.TbdThuoc3.buttonXoa"] = "<spring:message code="mard.19.TbdThuoc3.buttonXoa" />";
    NSWLang["mard.19.TbdThuoc19.fiProductFile"] = "<spring:message code="mard.19.TbdThuoc19.fiProductFile" />";
    NSWLang["mard.19.index.table.th.14"] = "<spring:message code="mard.19.index.table.th.14" />"




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
