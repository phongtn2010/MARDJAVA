<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="application/javascript">

    NSWLang["mard.16.title"] = "<spring:message code="mard.16.title" />";
    NSWLang["mard.16.donDeNghi"] = "<spring:message code="mard.16.donDeNghi" />";
    NSWLang["mard.16.soDN"] = "<spring:message code="mard.16.soDN" />";
 NSWLang["mard.16.msg.table.history.stt"] = "<spring:message code="mard.16.msg.table.history.stt" />";
 NSWLang["mard.16.msg.table.history.donViXuLy"] = "<spring:message code="mard.16.msg.table.history.donViXuLy" />";
 NSWLang["mard.16.msg.table.history.chuyenVien"] = "<spring:message code="mard.16.msg.table.history.chuyenVien" />";
 NSWLang["mard.16.msg.table.history.ngayXuLy"] = "<spring:message code="mard.16.msg.table.history.ngayXuLy" />";
 NSWLang["mard.16.msg.table.history.noiDung"] = "<spring:message code="mard.16.msg.table.history.noiDung" />";
 NSWLang["mard.16.msg.table.history.trangThai"] = "<spring:message code="mard.16.msg.table.history.trangThai" />";
 NSWLang["mard.16.msg.table.history.taiLieuDinhKem"] = "<spring:message code="mard.16.msg.table.history.taiLieuDinhKem" />";
 
 NSWLang["mard.16.send.confirm"] = "<spring:message code="mard.16.send.confirm" />";
 NSWLang["mard.16.select.option"] = "<spring:message code="mard.16.select.option" />";
 NSWLang["mard.16.dateNotValid"] = "<spring:message code="mard.16.dateNotValid" />";
 NSWLang["mard.16.msg.xoaHoSoOk"] = "<spring:message code="mard.16.msg.xoaHoSoOk" />";
 NSWLang["mard.16.msg.xoaHoSoNo"] = "<spring:message code="mard.16.msg.xoaHoSoNo" />";
 NSWLang["mard.16.tepDinhKem.notValid"] = "<spring:message code="mard.16.tepDinhKem.notValid" />";
 NSWLang["mard.16.thuoc.notValid"] = "<spring:message code="mard.16.thuoc.notValid" />";
 NSWLang["mard.16.msg.capNhatHoSoOk"] = "<spring:message code="mard.16.msg.capNhatHoSoOk" />";
 NSWLang["mard.16.msg.capNhatHoSoNo"] = "<spring:message code="mard.16.msg.capNhatHoSoNo" />";
 NSWLang["mard.16.msg.taoMoiHoSoOk"] = "<spring:message code="mard.16.msg.taoMoiHoSoOk" />";
 NSWLang["mard.16.msg.taoMoiHoSoNo"] = "<spring:message code="mard.16.msg.taoMoiHoSoNo" />";
 NSWLang["mard.16.popup.lichSuHoSo"] = "<spring:message code="mard.16.popup.lichSuHoSo" />";
 NSWLang["mard.16.index.table.xinSuaGiayPhep"] = "<spring:message code="mard.16.index.table.xinSuaGiayPhep" />";
 NSWLang["mard.16.trang-dau-tien"] = "<spring:message code="mard.16.trang-dau-tien" />";
 NSWLang["mard.16.trang-truoc"] = "<spring:message code="mard.16.trang-truoc" />";
 NSWLang["mard.16.trang-sau"] = "<spring:message code="mard.16.trang-sau" />";
 NSWLang["mard.16.trang-cuoi"] = "<spring:message code="mard.16.trang-cuoi" />";
 NSWLang["mard.16.uploadSize"] = "<spring:message code="mard.16.uploadSize" />";
 NSWLang["mard.16.uploadInfo"] = "<spring:message code="mard.16.uploadInfo" />";
 NSWLang["mard.16.reason"] = "<spring:message code="mard.16.reason" />";
 NSWLang["mard.16.action.success"] = "<spring:message code="mard.16.action.success" />";
 NSWLang["mard.16.action.error"] = "<spring:message code="mard.16.action.error" />";
 NSWLang["mard.16.index.table.th.12"] = "<spring:message code="mard.16.index.table.th.12" />";

 NSWLang["mard.16.TbdThuoc3.stt"] = "<spring:message code="mard.16.TbdThuoc3.stt" />";
 NSWLang["mard.16.TbdThuoc16.fiNameOfGoods"] = "<spring:message code="mard.16.TbdThuoc16.fiNameOfGoods" />";
 NSWLang["mard.16.TbdThuoc16.fiNameSicenceOfGoods"] = "<spring:message code="mard.16.TbdThuoc16.fiNameSicenceOfGoods" />";
 NSWLang["mard.16.TbdThuoc16.fiSpecies"] = "<spring:message code="mard.16.TbdThuoc16.fiSpecies" />";
 NSWLang["mard.16.TbdThuoc16.fiOriginal"] = "<spring:message code="mard.16.TbdThuoc16.fiOriginal" />";
 NSWLang["mard.16.TbdThuoc16.fiDateCollect"] = "<spring:message code="mard.16.TbdThuoc16.fiDateCollect" />";
 NSWLang["mard.16.TbdThuoc16.fiOrganization"] = "<spring:message code="mard.16.TbdThuoc16.fiOrganization" />";
 NSWLang["mard.16.TbdThuoc16.fiType"] = "<spring:message code="mard.16.TbdThuoc16.fiType" />";
 NSWLang["mard.16.TbdThuoc16.fiQuantity"] = "<spring:message code="mard.16.TbdThuoc16.fiQuantity" />";
 NSWLang["mard.16.TbdThuoc16.fiQuantityUnitName"] = "<spring:message code="mard.16.TbdThuoc16.fiQuantityUnitName" />";
 NSWLang["mard.16.TbdThuoc16.fiGateOfImportationName"] = "<spring:message code="mard.16.TbdThuoc16.fiGateOfImportationName" />";
 NSWLang["mard.16.TbdThuoc3.mucdich"] = "<spring:message code="mard.16.TbdThuoc3.mucdich" />";
 NSWLang["mard.16.TbdHoSo16.fiTotalQuantity"] = "<spring:message code="mard.16.TbdHoSo16.fiTotalQuantity" />";
 NSWLang["mard.16.TbdHoSo16.fiOrganizationReceiving"] = "<spring:message code="mard.16.TbdHoSo16.fiOrganizationReceiving" />";
 NSWLang["mard.16.TbdHoSo16.fiSummaryOfNumber"] = "<spring:message code="mard.16.TbdHoSo16.fiSummaryOfNumber" />";
 NSWLang["mard.16.TbdHoSo16.fiImportTimeFrom"] = "<spring:message code="mard.16.TbdHoSo16.fiImportTimeFrom" />";
 NSWLang["mard.16.TbdThuoc3.purposeOtherNote"] = "<spring:message code="mard.16.TbdThuoc3.purposeOtherNote" />";
 NSWLang["mard.14.form.tepDinhKem.stt"] = "<spring:message code="mard.14.form.tepDinhKem.stt" />";
 NSWLang["mard.14.form.tepDinhKem.fileName"] = "<spring:message code="mard.14.form.tepDinhKem.fileName" />";
 NSWLang["mard.14.form.tepDinhKem.actionUpload"] = "<spring:message code="mard.14.form.tepDinhKem.actionUpload" />";

 NSWLang["mard.16.TbdHoSo16.fiNameOfRegistration"] = "<spring:message code="mard.16.TbdHoSo16.fiNameOfRegistration" />";
 NSWLang["mard.16.TbdHoSo16.fiAddressOfRegistration"] = "<spring:message code="mard.16.TbdHoSo16.fiAddressOfRegistration" />";
 NSWLang["mard.16.TbdHoSo16.fiPhone"] = "<spring:message code="mard.16.TbdHoSo16.fiPhone" />";
 NSWLang["mard.16.TbdHoSo16.fiFax"] = "<spring:message code="mard.16.TbdHoSo16.fiFax" />";
 NSWLang["mard.16.TbdHoSo16.fiEmail"] = "<spring:message code="mard.16.TbdHoSo16.fiEmail" />";
 NSWLang["mard.16.TbdHoSo16.fiApplicationNo"] = "<spring:message code="mard.16.TbdHoSo16.fiApplicationNo" />";

 NSWLang["mard.16.form.toKhaiKyThuat"] = "<spring:message code="mard.16.form.toKhaiKyThuat" />";
 NSWLang["TbdToKhaiKyThuat16_fiSortDeclaration"] = "<spring:message code="TbdToKhaiKyThuat16_fiSortDeclaration" />";
 NSWLang["TbdToKhaiKyThuat16_fiNameOfGoodsDeclaration"] = "<spring:message code="TbdToKhaiKyThuat16_fiNameOfGoodsDeclaration" />";
 NSWLang["TbdToKhaiKyThuat16_fiNameSicenceOfGoodsDeclaration"] = "<spring:message code="TbdToKhaiKyThuat16_fiNameSicenceOfGoodsDeclaration" />";
 NSWLang["TbdToKhaiKyThuat16_fiDescription"] = "<spring:message code="TbdToKhaiKyThuat16_fiDescription" />";
 NSWLang["TbdToKhaiKyThuat16_fiPartUsed"] = "<spring:message code="TbdToKhaiKyThuat16_fiPartUsed" />";
 NSWLang["TbdToKhaiKyThuat16_fiUsingValue"] = "<spring:message code="TbdToKhaiKyThuat16_fiUsingValue" />";
 NSWLang["TbdToKhaiKyThuat16_fiOtherValueSpecified"] = "<spring:message code="TbdToKhaiKyThuat16_fiOtherValueSpecified" />";
 NSWLang["TbdToKhaiKyThuat16_fiRequiredEcological"] = "<spring:message code="TbdToKhaiKyThuat16_fiRequiredEcological" />";
 NSWLang["TbdToKhaiKyThuat16_fiPlantingSeason"] = "<spring:message code="TbdToKhaiKyThuat16_fiPlantingSeason" />";
 NSWLang["TbdToKhaiKyThuat16_fiDensity"] = "<spring:message code="TbdToKhaiKyThuat16_fiDensity" />";
 NSWLang["TbdToKhaiKyThuat16_fiMainDiseases"] = "<spring:message code="TbdToKhaiKyThuat16_fiMainDiseases" />";
 NSWLang["TbdToKhaiKyThuat16_fiWarnings"] = "<spring:message code="TbdToKhaiKyThuat16_fiWarnings" />";
 NSWLang["mard.16.TbdHoSo16.fiImportTimeFrom"] = "<spring:message code="mard.16.TbdHoSo16.fiImportTimeFrom"/>";
 NSWLang["mard.16.TbdHoSo16.fiLocation"] = "<spring:message code="mard.16.TbdHoSo16.fiLocation"/>";
 NSWLang["mard.16.TbdHoSo16.fiDocument"] = "<spring:message code="mard.16.TbdHoSo16.fiDocument"/>";
 NSWLang["mard.16.TbdHoSo16.fiOtherPaperValue"] = "<spring:message code="mard.16.TbdHoSo16.fiOtherPaperValue"/>";
 NSWLang["mard.16.form.thongTinDinhKem"] = "<spring:message code="mard.16.form.thongTinDinhKem"/>";
    NSWLang["mard.16.kyTen"] = "<spring:message code="mard.16.kyTen"/>";
    NSWLang["mard.16.congHoa"] = "<spring:message code="mard.16.congHoa"/>";
    NSWLang["mard.16.xaHoi"] = "<spring:message code="mard.16.xaHoi"/>";
    NSWLang["mard.16.ngayKyDate"] = "<spring:message code="mard.16.ngayKyDate"/>";
    NSWLang["mard.16.ngayKyThang"] = "<spring:message code="mard.16.ngayKyThang"/>";
    NSWLang["mard.16.ngayKyNam"] = "<spring:message code="mard.16.ngayKyNam"/>";
    NSWLang["mard.16.capGiayPhep"] = "<spring:message code="mard.16.capGiayPhep"/>";
    NSWLang["mard.16.boNNVaPTNT"] = "<spring:message code="mard.16.boNNVaPTNT"/>";
    NSWLang["mard.16.noiNhan"] = "<spring:message code="mard.16.noiNhan"/>";
    NSWLang["mar.16.fiBase"] = "<spring:message code="mar.16.fiBase"/>";
    NSWLang["mar.16.fiLawBase"] = "<spring:message code="mar.16.fiLawBase"/>";
    NSWLang["mar.16.fiReport"] = "<spring:message code="mar.16.fiReport"/>";
    NSWLang["mard.16.send.timeout"] = "<spring:message code="mard.16.send.timeout" />";
    NSWLang["TbdToKhaiKyThuat16_fiDescription2"] = "<spring:message code="TbdToKhaiKyThuat16_fiDescription2"/>";
    NSWLang["mard.16.TbdThuoc16.fiNameOfGoods"] = "<spring:message code="mard.16.TbdThuoc16.fiNameOfGoods"/>";
    NSWLang["mard.16.TbdThuoc16.fiNameSicenceOfGoods"] = "<spring:message code="mard.16.TbdThuoc16.fiNameSicenceOfGoods"/>";
    NSWLang["mard.16.TbdThuoc16.fiType"] = "<spring:message code="mard.16.TbdThuoc16.fiType"/>";
    NSWLang["mard.16.TbdThuoc16.fiQuantity"] = "<spring:message code="mard.16.TbdThuoc16.fiQuantity"/>";
    NSWLang["mard.16.TbdThuoc16.fiQuantityUnitName"] = "<spring:message code="mard.16.TbdThuoc16.fiQuantityUnitName"/>";
    NSWLang["mard.16.TbdThuoc16.fiOrganization"] = "<spring:message code="mard.16.TbdThuoc16.fiOrganization"/>";
    NSWLang["mard.16.TbdThuoc16.fiGateOfImportationName"] = "<spring:message code="mard.16.TbdThuoc16.fiGateOfImportationName"/>";
    NSWLang["mard.16.form.thongTinThuoc"] = "<spring:message code="mard.16.form.thongTinThuoc"/>";
    NSWLang["mard.14.loiCapNhatDuLieu"] = "<spring:message code="mard.14.loiCapNhatDuLieu" />";
    NSWLang["mard.16.loiToKhaiKyThuat"] = "<spring:message code="mard.16.loiToKhaiKyThuat" />";
    NSWLang["mard.14.loiKieuFileExcel"] = "<spring:message code="mard.14.loiKieuFileExcel" />";
    NSWLang["mard.16.confirmSave"] = "<spring:message code="mard.16.confirmSave" />";

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