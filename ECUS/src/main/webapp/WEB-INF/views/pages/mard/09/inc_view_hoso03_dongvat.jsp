<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 11/15/19
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div id="modal_XemHoso03DV" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body">
            <div id="pageView" class="tab-content" style="display: flex">
                <div id="hoso" class="tab-pane fade active in col-md-12">
                    <h4 style="font-weight: bold; text-align: center">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        Độc lập - Tự do - Hạnh phúc
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        ------------
                    </h4>

                    <div style="width: 100px; height: 100px; border: solid 1px; display: flex; align-items: center; justify-content: center; position: absolute; top: 0px; right: 0px">
                        <b>Mẫu 3</b>
                    </div>
                    <h4 style="font-weight: bold; text-align: center">
                        ĐƠN ĐĂNG KÝ KIỂM DỊCH
                    </h4>
                    <p class="code" style="font-weight: bold; text-align: center">
                        Số: <span data-bind="text: fiHSCode"></span>
                    </p>
                    <p class="code" style="font-weight: bold; text-align: center">
                        Kính gửi: <span data-bind="text: fiKinhGui"></span>
                    </p>
                    <p class="content">
                        Tên tổ chức, cá nhân: <span style="font-weight: bold" data-bind="text: fiNameOfRegistration"></span>
                    </p>
                    <p class="content">
                        Địa chỉ: <span style="font-weight: bold" data-bind="text: fiAddressOfRegistration"></span>
                    </p>
                    <p class="content">
                        Điên thoại: <span style="font-weight: bold" data-bind="text: fiFax"></span> Fax: <span style="font-weight: bold" data-bind="text: fiFax"></span>. Email: <span style="font-weight: bold" data-bind="text: fiEmail"></span>
                    </p>
                    <p class="content">
                        Đề nghị quý Cơ quan kiểm dịch lô hàng: <b>Nhập khẩu</b>
                    </p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center" rowspan="2">STT</th>
                            <th class="text-center" rowspan="2">Tên hàng hóa</th>
                            <th class="text-center" rowspan="2">Số lượng (con đực)</th>
                            <th class="text-center" rowspan="2">Số lượng (con cái)</th>
                            <th class="text-center" rowspan="2">Tuổi</th>
                            <th class="text-center" rowspan="2">Cửa khẩu nhập</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstGood">
                            <tr>
                                <td data-bind="text: $index() + 1"></td>
                                <td data-bind="text: fiProductName"></td>
                                <td class="text-right" data-bind="text: fiQuantityMale"></td>
                                <td class="text-right" data-bind="text: fiQuantityFemale"></td>
                                <td class="text-right" data-bind="text: fiAge"></td>
                                <td data-bind="text: fiImportPortOfDestName"></td>
                            </tr>
                        </tbody>

<%--                    <tfoot>--%>
<%--                    <tr>--%>
<%--                        <td class="t-bold t-center">Tổng số</td>--%>
<%--                        <td></td>--%>
<%--                        <td></td>--%>
<%--                        <td></td>--%>
<%--                        <td data-bind=""></td>--%>
<%--                        <td></td>--%>
<%--                    </tr>--%>
<%--                    </tfoot>--%>
                    </table>

                    <p class="content">
                        Thông tin công ty xuất khẩu
                    </p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center" rowspan="2">STT</th>
                            <th class="text-center" rowspan="2">Tên công ty xuất khẩu</th>

                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstExporter">
                        <tr>
                            <td data-bind="text: $index() + 1"></td>
                            <td data-bind="text: fiExporterName"></td>
                        </tr>
                        </tbody>
                    </table>

                    <p class="code">
                        Số hợp đồng hoặc số chứng từ thanh toán: <span style="font-weight: bold" data-bind="text: fiContractNo"></span>
                    </p>
                    <p class="code">
                        Nước xuất khẩu: <span style="font-weight: bold" data-bind="text: fiExportCountryName"></span>
                    </p>
                    <p class="code">
                        Cửa khẩu xuất: <span style="font-weight: bold" data-bind="text: fiExportPortDestName"></span>
                    </p>
                    <p class="code">
                        Tổ chức, cá nhân nhập khẩu: <span style="font-weight: bold" data-bind="text: fiImportContactPerson"></span>
                    </p>
                    <p class="code">
                        Nước nhập khẩu: <span style="font-weight: bold" data-bind="text: fiImportCountryName"></span>
                    </p>
                    <p class="code">
                        Phương tiện vận chuyển: <span style="font-weight: bold" data-bind="text: fiTransportType"></span>
                    </p>
                    <p class="code">
                        Mục đích sử dụng: <span style="font-weight: bold" data-bind="text: fiPurpose"></span>
                    </p>

                    <p class="content">
                        Địa điểm cách ly kiểm dịch:
                    </p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center" rowspan="2">STT</th>
                            <th class="text-center" rowspan="2">Tên nơi cách ly kiểm dịch</th>
                            <th class="text-center" rowspan="2">Địa chỉ nuôi cách ly kiểm dịch</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstIsolatedLocation">
                        <tr>
                            <td data-bind="text: $index() + 1"></td>
                            <td data-bind="text: fiIsoLocName"></td>
                            <td data-bind="text: fiIsoLocAddress"></td>
                        </tr>
                        </tbody>
                    </table>

                    <p class="code">
                        Số vận đơn tàu: <span style="font-weight: bold" data-bind="text: fiBillOfLadingNo"></span> ngày cấp <span style="font-weight: bold" data-bind="date: fiBillOfLadingIssuedDate"></span>
                    </p>

                    <p class="code">
                        Địa điểm kiểm dịch: <span style="font-weight: bold" data-bind="text: fiQuarantineName"></span>
                    </p>

                    <p class="code">
                        Thời gian kiểm dịch: từ <span style="font-weight: bold" data-bind="date: fiQuarantineTimeFrom"></span> đến <span style="font-weight: bold" data-bind="date: fiQuarantineTimeTo"></span>
                    </p>
                    <p class="code">
                        Địa điểm giám sát: <span style="font-weight: bold" data-bind="text: fiMonitoringLocName"></span>
                    </p>
                    <p class="code">
                        Thời gian giám sát: từ <span style="font-weight: bold" data-bind="date: fiMonitoringLocTimeFrom"></span> đến <span style="font-weight: bold" data-bind="date: fiMonitoringLocTimeTo"></span>
                    </p>
                    <p class="code">
                        Số bản giấy chứng nhận kiểm dịch cần cấp: <span style="font-weight: bold" data-bind="text: fiCertificateQuantity"></span>
                    </p>
                    <p>
                        Chúng tôi xin cam kết: bảo đảm nguyên trạng hàng hoá nhập khẩu, đưa về đúng địa điểm, đúng thời gian được đăng ký và chỉ đưa hàng hoá ra lưu thông sau khi được quý Cơ quan cấp Giấy chứng nhận kiểm dịch
                    </p>
                    <div class="col-md-12">
                        <div style="float: left; text-align: center">

                        </div>
                        <div style="float: right; text-align: center">
                            <p><b>TỔ CHỨC/ CÁ NHÂN ĐĂNG KÝ</b></p>
                            <span data-bind="text: fiSignedBy"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <a data-bind="attr: {href: fiLinkFile}" class="btn green" target="_blank">
                Xuất word
            </a>
            <button class="btn" data-dismiss="modal">
                <spring:message code="conmon.button.dong"/>
            </button>
        </div>
    </div>
</div>
