<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="application/javascript">
 
 NSWLang["mard.17.msg.table.history.stt"] = "<spring:message code="mard.17.msg.table.history.stt" />";
 NSWLang["mard.17.msg.table.history.donViXuLy"] = "<spring:message code="mard.17.msg.table.history.donViXuLy" />";
 NSWLang["mard.17.msg.table.history.chuyenVien"] = "<spring:message code="mard.17.msg.table.history.chuyenVien" />";
 NSWLang["mard.17.msg.table.history.ngayXuLy"] = "<spring:message code="mard.17.msg.table.history.ngayXuLy" />";
 NSWLang["mard.17.msg.table.history.noiDung"] = "<spring:message code="mard.17.msg.table.history.noiDung" />";
 NSWLang["mard.17.msg.table.history.trangThai"] = "<spring:message code="mard.17.msg.table.history.trangThai" />";
 NSWLang["mard.17.msg.table.history.taiLieuDinhKem"] = "<spring:message code="mard.17.msg.table.history.taiLieuDinhKem" />";
 
 NSWLang["mard.17.send.confirm"] = "<spring:message code="mard.17.send.confirm" />";
 NSWLang["mard.17.select.option"] = "<spring:message code="mard.17.select.option" />";
 NSWLang["mard.17.dateNotValid"] = "<spring:message code="mard.17.dateNotValid" />";
 NSWLang["mard.17.msg.xoaHoSoOk"] = "<spring:message code="mard.17.msg.xoaHoSoOk" />";
 NSWLang["mard.17.msg.xoaHoSoNo"] = "<spring:message code="mard.17.msg.xoaHoSoNo" />";
 NSWLang["mard.17.tepDinhKem.notValid"] = "<spring:message code="mard.17.tepDinhKem.notValid" />";
 NSWLang["mard.17.thuoc.notValid"] = "<spring:message code="mard.17.thuoc.notValid" />";
 NSWLang["mard.17.uploadSize"] = "<spring:message code="mard.17.uploadSize" />";
 NSWLang["mard.17.uploadInfo"] = "<spring:message code="mard.17.uploadInfo" />";
 NSWLang["mard.17.uploadInfo3"] = "<spring:message code="mard.17.uploadInfo3" />";

 NSWLang["mard.17.index.table.thongBaoPhi"] = "<spring:message code="mard.17.index.table.thongBaoPhi" />";
 NSWLang["mard.17.table.thongBaoPhi.col.stt"] = "<spring:message code="mard.17.table.thongBaoPhi.col.stt" />";
 NSWLang["mard.17.table.thongBaoPhi.col.fiAccountName"] = "<spring:message code="mard.17.table.thongBaoPhi.col.fiAccountName" />";
 NSWLang["mard.17.table.thongBaoPhi.col.fiAccountNo"] = "<spring:message code="mard.17.table.thongBaoPhi.col.fiAccountNo" />";
 NSWLang["mard.17.table.thongBaoPhi.col.fiCreateDate"] = "<spring:message code="mard.17.table.thongBaoPhi.col.fiCreateDate" />";
 NSWLang["mard.17.table.thongBaoPhi.col.fiNote"] = "<spring:message code="mard.17.table.thongBaoPhi.col.fiNote" />";
 NSWLang["mard.17.table.thongBaoPhi.col.fiTotalFee"] = "<spring:message code="mard.17.table.thongBaoPhi.col.fiTotalFee" />";
 NSWLang["mard.17.table.thongBaoPhi.col.fiTotalFeeChar"] = "<spring:message code="mard.17.table.thongBaoPhi.col.fiTotalFeeChar" />";

 NSWLang["mard.17.index.table.thongBaoChuyenKhoan"] = "<spring:message code="mard.17.index.table.thongBaoChuyenKhoan" />";
 NSWLang["mard.17.table.thongBaoChuyenKhoan.col.stt"] = "<spring:message code="mard.17.table.thongBaoChuyenKhoan.col.stt" />";
 NSWLang["mard.17.table.thongBaoChuyenKhoan.col.fiAccountName"] = "<spring:message code="mard.17.table.thongBaoChuyenKhoan.col.fiAccountName" />";
 NSWLang["mard.17.table.thongBaoChuyenKhoan.col.fiAccountNo"] = "<spring:message code="mard.17.table.thongBaoChuyenKhoan.col.fiAccountNo" />";
 NSWLang["mard.17.table.thongBaoChuyenKhoan.col.fiCreateDate"] = "<spring:message code="mard.17.table.thongBaoChuyenKhoan.col.fiCreateDate" />";
 NSWLang["mard.17.table.thongBaoChuyenKhoan.col.fiNote"] = "<spring:message code="mard.17.table.thongBaoChuyenKhoan.col.fiNote" />";
 NSWLang["mard.17.table.thongBaoChuyenKhoan.col.fiTotalFee"] = "<spring:message code="mard.17.table.thongBaoChuyenKhoan.col.fiTotalFee" />";
 NSWLang["mard.17.table.thongBaoChuyenKhoan.col.fiTotalFeeChar"] = "<spring:message code="mard.17.table.thongBaoChuyenKhoan.col.fiTotalFeeChar" />";
 NSWLang["mard.17.msg.capNhatHoSoOk"] = "<spring:message code="mard.17.msg.capNhatHoSoOk" />";
 NSWLang["mard.17.msg.capNhatHoSoNo"] = "<spring:message code="mard.17.msg.capNhatHoSoNo" />";
 NSWLang["mard.17.msg.taoMoiHoSoOk"] = "<spring:message code="mard.17.msg.taoMoiHoSoOk" />";
 NSWLang["mard.17.msg.taoMoiHoSoNo"] = "<spring:message code="mard.17.msg.taoMoiHoSoNo" />";
 NSWLang["mard.17.msg.addHangHoaNo"] = "<spring:message code="mard.17.msg.addHangHoaNo" />";

 NSWLang["mard.17.popup.lichSuHoSo"] = "<spring:message code="mard.17.popup.lichSuHoSo" />";


 NSWLang["mard.17.trang-dau-tien"] = "<spring:message code="mard.17.trang-dau-tien" />";
 NSWLang["mard.17.trang-truoc"] = "<spring:message code="mard.17.trang-truoc" />";
 NSWLang["mard.17.trang-sau"] = "<spring:message code="mard.17.trang-sau" />";
 NSWLang["mard.17.trang-cuoi"] = "<spring:message code="mard.17.trang-cuoi" />";
 NSWLang["mard.17.reason"] = "<spring:message code="mard.17.reason" />";
 NSWLang["mard.17.action.success"] = "<spring:message code="mard.17.action.success" />";
 NSWLang["mard.17.action.error"] = "<spring:message code="mard.17.action.error" />";
 NSWLang["mard.17.index.table.th.12"] = "<spring:message code="mard.17.index.table.th.12" />";
 NSWLang["mard.17.index.table.th.14"] ="<spring:message code="mard.17.index.table.th.14" />";
 NSWLang["mard.17.guiThanhToanPhi"] = "<spring:message code="mard.17.guiThanhToanPhi" />";
 NSWLang["mard.17.ngayGuiThanhToanPhi"] = "<spring:message code="mard.17.ngayGuiThanhToanPhi" />";
 NSWLang["mard.17.tepDinhKemThanhToanPhi"] = "<spring:message code="mard.17.tepDinhKemThanhToanPhi" />";
 NSWLang["mard.17.send.timeout"] = "<spring:message code="mard.17.send.timeout" />";
 NSWLang["mard.17.TbdThuoc17.fiProductType"] = "<spring:message code="mard.17.TbdThuoc17.fiProductType" />";
 NSWLang["mard.17.TbdThuoc17.fiNameOfProduct"] = "<spring:message code="mard.17.TbdThuoc17.fiNameOfProduct" />";
 NSWLang["mard.17.TbdThuoc17.fiWeight"] = "<spring:message code="mard.17.TbdThuoc17.fiWeight" />";
 NSWLang["mard.17.TbdThuoc17.fiWeightUnitName"] = "<spring:message code="mard.17.TbdThuoc17.fiWeightUnitName" />";
 NSWLang["mard.17.TbdThuoc17.fiMainUse"] = "<spring:message code="mard.17.TbdThuoc17.fiMainUse" />";
 NSWLang["mard.17.TbdThuoc17.fiOrigin"] = "<spring:message code="mard.17.TbdThuoc17.fiOrigin" />";
 NSWLang["mard.17.TbdThuoc17.fiOrganization"] = "<spring:message code="mard.17.TbdThuoc17.fiOrganization"/>";
 NSWLang["mard.17.TbdThuoc17.fiSerialNo"] = "<spring:message code="mard.17.TbdThuoc17.fiSerialNo"/>";
 NSWLang["mard.17.TbdThuoc17.fiTotal"] = "<spring:message code="mard.17.TbdThuoc17.fiTotal"/>";
 NSWLang["mard.17.TbdThuoc17.fiMoneyUnitName"] = "<spring:message code ="mard.17.TbdThuoc17.fiMoneyUnitName"/>";
 NSWLang["mard.17.TbdThuoc17.fiProductFile"] = "<spring:message code="mard.17.TbdThuoc17.fiProductFile" />";
 NSWLang["mard.17.TbdThuoc17.fiOtherProductType"] = "<spring:message code="mard.17.TbdThuoc17.fiOtherProductType" />";
 NSWLang["mard.17.form.thongTinThuoc"] = "<spring:message code="mard.17.form.thongTinThuoc" />";
 NSWLang["mard.17.loiCapNhatDuLieu"] = "<spring:message code="mard.17.loiCapNhatDuLieu" />";
 NSWLang["mard.17.loiKieuFileExcel"] = "<spring:message code="mard.17.loiKieuFileExcel" />";
 NSWLang["mard.17.dinhDangFileThongBaoPhi"] = "<spring:message code="mard.17.dinhDangFileThongBaoPhi" />";
 NSWLang["mard.16.confirmSave"] = "<spring:message code="mard.16.confirmSave" />";
 NSWLang["mard.17.TbdThuoc3.chucnang"] = "<spring:message code="mard.17.TbdThuoc3.chucnang" />";
 NSWLang["mard.17.TbdThuoc3.buttonSua"] = "<spring:message code="mard.17.TbdThuoc3.buttonSua" />";
 NSWLang["mard.17.TbdThuoc3.buttonXoa"] = "<spring:message code="mard.17.TbdThuoc3.buttonXoa" />";



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
