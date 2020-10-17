<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="application/javascript">
 
 NSWLang["mard.14.msg.table.history.stt"] = "<spring:message code="mard.14.msg.table.history.stt" />";
 NSWLang["mard.14.msg.table.history.donViXuLy"] = "<spring:message code="mard.14.msg.table.history.donViXuLy" />";
 NSWLang["mard.14.msg.table.history.chuyenVien"] = "<spring:message code="mard.14.msg.table.history.chuyenVien" />";
 NSWLang["mard.14.msg.table.history.ngayXuLy"] = "<spring:message code="mard.14.msg.table.history.ngayXuLy" />";
 NSWLang["mard.14.msg.table.history.noiDung"] = "<spring:message code="mard.14.msg.table.history.noiDung" />";
 NSWLang["mard.14.msg.table.history.trangThai"] = "<spring:message code="mard.14.msg.table.history.trangThai" />";
 NSWLang["mard.14.msg.table.history.taiLieuDinhKem"] = "<spring:message code="mard.14.msg.table.history.taiLieuDinhKem" />";
 
 NSWLang["mard.14.send.confirm"] = "<spring:message code="mard.14.send.confirm" />";
 NSWLang["mard.14.select.option"] = "<spring:message code="mard.14.select.option" />";
 NSWLang["mard.14.dateNotValid"] = "<spring:message code="mard.14.dateNotValid" />";
 NSWLang["mard.14.msg.xoaHoSoOk"] = "<spring:message code="mard.14.msg.xoaHoSoOk" />";
 NSWLang["mard.14.msg.xoaHoSoNo"] = "<spring:message code="mard.14.msg.xoaHoSoNo" />";
 NSWLang["mard.14.tepDinhKem.notValid"] = "<spring:message code="mard.14.tepDinhKem.notValid" />";
 NSWLang["mard.14.thuoc.notValid"] = "<spring:message code="mard.14.thuoc.notValid" />";
 NSWLang["mard.14.uploadSize"] = "<spring:message code="mard.14.uploadSize" />";
 NSWLang["mard.14.uploadInfo"] = "<spring:message code="mard.14.uploadInfo" />";
 NSWLang["mard.14.uploadInfo3"] = "<spring:message code="mard.14.uploadInfo3" />";

 NSWLang["mard.14.index.table.thongBaoPhi"] = "<spring:message code="mard.14.index.table.thongBaoPhi" />";
 NSWLang["mard.14.table.thongBaoPhi.col.stt"] = "<spring:message code="mard.14.table.thongBaoPhi.col.stt" />";
 NSWLang["mard.14.table.thongBaoPhi.col.fiAccountName"] = "<spring:message code="mard.14.table.thongBaoPhi.col.fiAccountName" />";
 NSWLang["mard.14.table.thongBaoPhi.col.fiAccountNo"] = "<spring:message code="mard.14.table.thongBaoPhi.col.fiAccountNo" />";
 NSWLang["mard.14.table.thongBaoPhi.col.fiCreateDate"] = "<spring:message code="mard.14.table.thongBaoPhi.col.fiCreateDate" />";
 NSWLang["mard.14.table.thongBaoPhi.col.fiNote"] = "<spring:message code="mard.14.table.thongBaoPhi.col.fiNote" />";
 NSWLang["mard.14.table.thongBaoPhi.col.fiTotalFee"] = "<spring:message code="mard.14.table.thongBaoPhi.col.fiTotalFee" />";
 NSWLang["mard.14.table.thongBaoPhi.col.fiTotalFeeChar"] = "<spring:message code="mard.14.table.thongBaoPhi.col.fiTotalFeeChar" />";

 NSWLang["mard.14.index.table.thongBaoChuyenKhoan"] = "<spring:message code="mard.14.index.table.thongBaoChuyenKhoan" />";
 NSWLang["mard.14.table.thongBaoChuyenKhoan.col.stt"] = "<spring:message code="mard.14.table.thongBaoChuyenKhoan.col.stt" />";
 NSWLang["mard.14.table.thongBaoChuyenKhoan.col.fiAccountName"] = "<spring:message code="mard.14.table.thongBaoChuyenKhoan.col.fiAccountName" />";
 NSWLang["mard.14.table.thongBaoChuyenKhoan.col.fiAccountNo"] = "<spring:message code="mard.14.table.thongBaoChuyenKhoan.col.fiAccountNo" />";
 NSWLang["mard.14.table.thongBaoChuyenKhoan.col.fiCreateDate"] = "<spring:message code="mard.14.table.thongBaoChuyenKhoan.col.fiCreateDate" />";
 NSWLang["mard.14.table.thongBaoChuyenKhoan.col.fiNote"] = "<spring:message code="mard.14.table.thongBaoChuyenKhoan.col.fiNote" />";
 NSWLang["mard.14.table.thongBaoChuyenKhoan.col.fiTotalFee"] = "<spring:message code="mard.14.table.thongBaoChuyenKhoan.col.fiTotalFee" />";
 NSWLang["mard.14.table.thongBaoChuyenKhoan.col.fiTotalFeeChar"] = "<spring:message code="mard.14.table.thongBaoChuyenKhoan.col.fiTotalFeeChar" />";
 NSWLang["mard.14.msg.capNhatHoSoOk"] = "<spring:message code="mard.14.msg.capNhatHoSoOk" />";
 NSWLang["mard.14.msg.capNhatHoSoNo"] = "<spring:message code="mard.14.msg.capNhatHoSoNo" />";
 NSWLang["mard.14.msg.taoMoiHoSoOk"] = "<spring:message code="mard.14.msg.taoMoiHoSoOk" />";
 NSWLang["mard.14.msg.taoMoiHoSoNo"] = "<spring:message code="mard.14.msg.taoMoiHoSoNo" />";

 NSWLang["mard.14.popup.lichSuHoSo"] = "<spring:message code="mard.14.popup.lichSuHoSo" />";


 NSWLang["mard.14.trang-dau-tien"] = "<spring:message code="mard.14.trang-dau-tien" />";
 NSWLang["mard.14.trang-truoc"] = "<spring:message code="mard.14.trang-truoc" />";
 NSWLang["mard.14.trang-sau"] = "<spring:message code="mard.14.trang-sau" />";
 NSWLang["mard.14.trang-cuoi"] = "<spring:message code="mard.14.trang-cuoi" />";
 NSWLang["mard.14.reason"] = "<spring:message code="mard.14.reason" />";
 NSWLang["mard.14.action.success"] = "<spring:message code="mard.14.action.success" />";
 NSWLang["mard.14.action.error"] = "<spring:message code="mard.14.action.error" />";
 NSWLang["mard.14.index.table.th.12"] = "<spring:message code="mard.14.index.table.th.12" />";
 NSWLang["mard.14.guiThanhToanPhi"] = "<spring:message code="mard.14.guiThanhToanPhi" />";
 NSWLang["mard.14.ngayGuiThanhToanPhi"] = "<spring:message code="mard.14.ngayGuiThanhToanPhi" />";
 NSWLang["mard.14.tepDinhKemThanhToanPhi"] = "<spring:message code="mard.14.tepDinhKemThanhToanPhi" />";
 NSWLang["mard.14.send.timeout"] = "<spring:message code="mard.14.send.timeout" />";
 NSWLang["mard.14.TbdThuoc14.fiTypeGood"] = "<spring:message code="mard.14.TbdThuoc14.fiTypeGood" />";
 NSWLang["mard.14.TbdThuoc14.fiNameOfGoods"] = "<spring:message code="mard.14.TbdThuoc14.fiNameOfGoods" />";
 NSWLang["mard.14.TbdThuoc14.fiWeight"] = "<spring:message code="mard.14.TbdThuoc14.fiWeight" />";
 NSWLang["mard.14.TbdThuoc14.fiWeightUnitName"] = "<spring:message code="mard.14.TbdThuoc14.fiWeightUnitName" />";
 NSWLang["mard.14.TbdThuoc14.fiMainUse"] = "<spring:message code="mard.14.TbdThuoc14.fiMainUse" />";
 NSWLang["mard.14.TbdThuoc14.fiOrigin"] = "<spring:message code="mard.14.TbdThuoc14.fiOrigin" />";
 NSWLang["mard.14.form.thongTinThuoc"] = "<spring:message code="mard.14.form.thongTinThuoc" />";
 NSWLang["mard.14.loiCapNhatDuLieu"] = "<spring:message code="mard.14.loiCapNhatDuLieu" />";
 NSWLang["mard.14.loiKieuFileExcel"] = "<spring:message code="mard.14.loiKieuFileExcel" />";
 NSWLang["mard.14.dinhDangFileThongBaoPhi"] = "<spring:message code="mard.14.dinhDangFileThongBaoPhi" />";
 NSWLang["mard.16.confirmSave"] = "<spring:message code="mard.16.confirmSave" />";
 NSWLang["mard.14.TbdThuoc3.chucnang"] = "<spring:message code="mard.14.TbdThuoc3.chucnang" />";
 NSWLang["mard.14.TbdThuoc3.buttonSua"] = "<spring:message code="mard.14.TbdThuoc3.buttonSua" />";
 NSWLang["mard.14.TbdThuoc3.buttonXoa"] = "<spring:message code="mard.14.TbdThuoc3.buttonXoa" />";



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