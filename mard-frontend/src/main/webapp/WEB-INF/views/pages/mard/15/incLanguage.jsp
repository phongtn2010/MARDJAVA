<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="application/javascript">
 
 NSWLang["mard.15.msg.table.history.stt"] = "<spring:message code="mard.15.msg.table.history.stt" />";
 NSWLang["mard.15.msg.table.history.donViXuLy"] = "<spring:message code="mard.15.msg.table.history.donViXuLy" />";
 NSWLang["mard.15.msg.table.history.chuyenVien"] = "<spring:message code="mard.15.msg.table.history.chuyenVien" />";
 NSWLang["mard.15.msg.table.history.ngayXuLy"] = "<spring:message code="mard.15.msg.table.history.ngayXuLy" />";
 NSWLang["mard.15.msg.table.history.noiDung"] = "<spring:message code="mard.15.msg.table.history.noiDung" />";
 NSWLang["mard.15.msg.table.history.trangThai"] = "<spring:message code="mard.15.msg.table.history.trangThai" />";
 NSWLang["mard.15.msg.table.history.taiLieuDinhKem"] = "<spring:message code="mard.15.msg.table.history.taiLieuDinhKem" />";
 
 NSWLang["mard.15.send.confirm"] = "<spring:message code="mard.15.send.confirm" />";
 NSWLang["mard.15.select.option"] = "<spring:message code="mard.15.select.option" />";
 NSWLang["mard.15.dateNotValid"] = "<spring:message code="mard.15.dateNotValid" />";
 NSWLang["mard.15.msg.xoaHoSoOk"] = "<spring:message code="mard.15.msg.xoaHoSoOk" />";
 NSWLang["mard.15.msg.xoaHoSoNo"] = "<spring:message code="mard.15.msg.xoaHoSoNo" />";
 NSWLang["mard.15.tepDinhKem.notValid"] = "<spring:message code="mard.15.tepDinhKem.notValid" />";
 NSWLang["mard.15.thuoc.notValid"] = "<spring:message code="mard.15.thuoc.notValid" />";
 NSWLang["mard.15.msg.capNhatHoSoOk"] = "<spring:message code="mard.15.msg.capNhatHoSoOk" />";
 NSWLang["mard.15.msg.capNhatHoSoNo"] = "<spring:message code="mard.15.msg.capNhatHoSoNo" />";
 NSWLang["mard.15.msg.taoMoiHoSoOk"] = "<spring:message code="mard.15.msg.taoMoiHoSoOk" />";
 NSWLang["mard.15.msg.taoMoiHoSoNo"] = "<spring:message code="mard.15.msg.taoMoiHoSoNo" />";
 NSWLang["mard.15.popup.lichSuHoSo"] = "<spring:message code="mard.15.popup.lichSuHoSo" />";
 NSWLang["mard.15.index.table.xinSuaGiayPhep"] = "<spring:message code="mard.15.index.table.xinSuaGiayPhep" />";
 NSWLang["mard.15.trang-dau-tien"] = "<spring:message code="mard.15.trang-dau-tien" />";
 NSWLang["mard.15.trang-truoc"] = "<spring:message code="mard.15.trang-truoc" />";
 NSWLang["mard.15.trang-sau"] = "<spring:message code="mard.15.trang-sau" />";
 NSWLang["mard.15.trang-cuoi"] = "<spring:message code="mard.15.trang-cuoi" />";
 NSWLang["mard.15.uploadSize"] = "<spring:message code="mard.15.uploadSize" />";
 NSWLang["mard.15.uploadInfo"] = "<spring:message code="mard.15.uploadInfo" />";
 NSWLang["mard.15.reason"] = "<spring:message code="mard.15.reason" />";
 NSWLang["mard.15.action.success"] = "<spring:message code="mard.15.action.success" />";
 NSWLang["mard.15.action.error"] = "<spring:message code="mard.15.action.error" />";
 NSWLang["mard.15.index.table.th.12"] = "<spring:message code="mard.15.index.table.th.12" />";

 NSWLang["mard.15.TbdThuoc3.stt"] = "<spring:message code="mard.15.TbdThuoc3.stt" />";
 NSWLang["mard.15.TbdThuoc15.fiNameOfGoods"] = "<spring:message code="mard.15.TbdThuoc15.fiNameOfGoods" />";
 NSWLang["mard.15.TbdThuoc15.fiNameSicenceOfGoods"] = "<spring:message code="mard.15.TbdThuoc15.fiNameSicenceOfGoods" />";
 NSWLang["mard.15.TbdThuoc15.fiSpecies"] = "<spring:message code="mard.15.TbdThuoc15.fiSpecies" />";
 NSWLang["mard.15.TbdThuoc15.fiOriginal"] = "<spring:message code="mard.15.TbdThuoc15.fiOriginal" />";
 NSWLang["mard.15.TbdThuoc15.fiDateCollect"] = "<spring:message code="mard.15.TbdThuoc15.fiDateCollect" />";
 NSWLang["mard.15.TbdThuoc15.fiOrganization"] = "<spring:message code="mard.15.TbdThuoc15.fiOrganization" />";
 NSWLang["mard.15.TbdThuoc15.fiType"] = "<spring:message code="mard.15.TbdThuoc15.fiType" />";
 NSWLang["mard.15.TbdThuoc15.fiQuantity"] = "<spring:message code="mard.15.TbdThuoc15.fiQuantity" />";
 NSWLang["mard.15.TbdThuoc15.fiQuantityUnitName"] = "<spring:message code="mard.15.TbdThuoc15.fiQuantityUnitName" />";
 NSWLang["mard.15.TbdThuoc15.fiGateOfImportationName"] = "<spring:message code="mard.15.TbdThuoc15.fiGateOfImportationName" />";
 NSWLang["mard.15.TbdThuoc3.mucdich"] = "<spring:message code="mard.15.TbdThuoc3.mucdich" />";
 NSWLang["mard.15.TbdHoSo15.fiTotalQuantity"] = "<spring:message code="mard.15.TbdHoSo15.fiTotalQuantity" />";
 NSWLang["mard.15.TbdHoSo15.fiOrganizationReceiving"] = "<spring:message code="mard.15.TbdHoSo15.fiOrganizationReceiving" />";
 NSWLang["mard.15.TbdHoSo15.fiSummaryOfNumber"] = "<spring:message code="mard.15.TbdHoSo15.fiSummaryOfNumber" />";
 NSWLang["mard.15.TbdHoSo15.fiImportTimeFrom"] = "<spring:message code="mard.15.TbdHoSo15.fiImportTimeFrom" />";
 NSWLang["mard.15.TbdThuoc3.purposeOtherNote"] = "<spring:message code="mard.15.TbdThuoc3.purposeOtherNote" />";
 NSWLang["mard.14.form.tepDinhKem.stt"] = "<spring:message code="mard.14.form.tepDinhKem.stt" />";
 NSWLang["mard.14.form.tepDinhKem.fileName"] = "<spring:message code="mard.14.form.tepDinhKem.fileName" />";
 NSWLang["mard.14.form.tepDinhKem.actionUpload"] = "<spring:message code="mard.14.form.tepDinhKem.actionUpload" />";

 NSWLang["mard.15.TbdHoSo15.fiNameOfRegistration"] = "<spring:message code="mard.15.TbdHoSo15.fiNameOfRegistration" />";
 NSWLang["mard.15.TbdHoSo15.fiAddressOfRegistration"] = "<spring:message code="mard.15.TbdHoSo15.fiAddressOfRegistration" />";
 NSWLang["mard.15.TbdHoSo15.fiPhone"] = "<spring:message code="mard.15.TbdHoSo15.fiPhone" />";
 NSWLang["mard.15.TbdHoSo15.fiFax"] = "<spring:message code="mard.15.TbdHoSo15.fiFax" />";
 NSWLang["mard.15.TbdHoSo15.fiEmail"] = "<spring:message code="mard.15.TbdHoSo15.fiEmail" />";
 NSWLang["mard.15.TbdHoSo15.fiApplicationNo"] = "<spring:message code="mard.15.TbdHoSo15.fiApplicationNo" />";
 NSWLang["mard.15.send.timeout"] = "<spring:message code="mard.15.send.timeout" />";
 NSWLang["mard.15.TbdThuoc15.fiNameOfGoods"] = "<spring:message code="mard.15.TbdThuoc15.fiNameOfGoods" />";
 NSWLang["mard.15.TbdThuoc15.fiNameSicenceOfGoods"] = "<spring:message code="mard.15.TbdThuoc15.fiNameSicenceOfGoods" />";
 NSWLang["mard.15.TbdThuoc15.fiSpecies"] = "<spring:message code="mard.15.TbdThuoc15.fiSpecies" />";
 NSWLang["mard.15.TbdThuoc15.fiOriginal"] = "<spring:message code="mard.15.TbdThuoc15.fiOriginal" />";
 NSWLang["mard.15.TbdThuoc15.fiDateCollect"] = "<spring:message code="mard.15.TbdThuoc15.fiDateCollect" />";
 NSWLang["mard.15.TbdThuoc15.fiOrganization"] = "<spring:message code="mard.15.TbdThuoc15.fiOrganization" />";
 NSWLang["mard.15.TbdThuoc15.fiType"] = "<spring:message code="mard.15.TbdThuoc15.fiType" />";
 NSWLang["mard.15.TbdThuoc15.fiQuantity"] = "<spring:message code="mard.15.TbdThuoc15.fiQuantity" />";
 NSWLang["mard.15.TbdThuoc15.fiQuantityUnitName"] = "<spring:message code="mard.15.TbdThuoc15.fiQuantityUnitName" />";
 NSWLang["mard.15.TbdThuoc15.fiGateOfImportationName"] = "<spring:message code="mard.15.TbdThuoc15.fiGateOfImportationName" />";
 NSWLang["mard.15.form.thongTinThuoc"] = "<spring:message code="mard.15.form.thongTinThuoc" />";
 NSWLang["mard.14.loiCapNhatDuLieu"] = "<spring:message code="mard.14.loiCapNhatDuLieu" />";
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