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
    <div id="modal_XemHoso20SPDV" class="modal container in modal-overflow" tabindex="-1"
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
                        <b>Mẫu 20a</b>
                    </div>
                    <br/>
                    <h4 style="font-weight: bold; text-align: center">
                        GIẤY ĐĂNG KÝ KIỂM DỊCH VÀ KIỂM TRA XÁC NHẬN CHẤT LƯỢNG THỨC ĂN CHĂN NUÔI, THỦY SẢN CÓ NGUỒN GỐC ĐỘNG VẬT NHẬP KHẨU
                    </h4>
                    <div class="container">
                        <div class="col-md-6" style="text-align: right">
                            <p class="code" style="font-weight: bold; text-align: right">
                                Số: <span data-bind="text: fiHSCode"></span>
                            </p>
                            <i>(Dành cho tổ chức, cá nhân đăng ký kiểm tra ghi)</i>
                        </div>
                        <div class="col-md-6" style="text-align: left">
                            <p class="code" style="font-weight: bold;">
                                Số: <span data-bind="text: fiRegistrationComfirmNo"></span>
                            </p>
                            <i>(Dành cho cơ quan kiểm tra ghi)</i>
                        </div>
                    </div>
                    <br/>
                    <p class="code" style="font-weight: bold; text-align: center">
                        Kính gửi: <span data-bind="text: fiKinhGui"></span>
                    </p>
                    <br/>

                    <h4 class="content" style="font-weight: bold">
                        THÔNG TIN BÊN BÁN HÀNG/SELLER:
                    </h4>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center" rowspan="2">STT</th>
                            <th class="text-center" rowspan="2">Hãng</th>
                            <th class="text-center" rowspan="2">Tên nước bán hàng</th>
                            <th class="text-center" rowspan="2">Điện thoại</th>
                            <th class="text-center" rowspan="2">Fax</th>
                            <th class="text-center" rowspan="2">Địa chỉ</th>
                            <th class="text-center" rowspan="2">Nơi xuất hàng</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstSeller">
                        <tr>
                            <td data-bind="text: $index() + 1"></td>
                            <td data-bind="text: fiSellerName"></td>
                            <td data-bind="text: fiSellerStateName"></td>
                            <td data-bind="text: fiSellerPhone ? fiSellerPhone : ''"></td>
                            <td data-bind="text: fiSellerFax"></td>
                            <td data-bind="text: fiSellerAddress"></td>
                            <td data-bind="text: fiPortOfDepartureName"></td>
                        </tr>
                        </tbody>
                    </table>

                    <br/>
                    <h4 class="content" style="font-weight: bold">
                        THÔNG TIN BÊN MUA HÀNG/BUYER:
                    </h4>

                    <p class="content">
                        Tên bên mua hàng: <span style="font-weight: bold" data-bind="text: fiBuyer.fiBuyerName"></span>
                    </p>
                    <p class="content" data-bind="visible: fiBuyer.fiBuyerIdentityNo() != null">
                        Số CMT (cá nhân): <span style="font-weight: bold" data-bind="text: fiBuyer.fiBuyerIdentityNo"></span> Nơi cấp: <span style="font-weight: bold" data-bind="text: fiBuyer.fiBuyerPlaceOfIdentity"></span> Ngày cấp: <span style="font-weight: bold" data-bind="date: fiBuyer.fiBuyerDateOfIdentity"></span>
                    </p>
                    <p class="content">
                        Điên thoại/Phone: <span style="font-weight: bold" data-bind="text: fiBuyer.fiBuyerTel"></span> Fax: <span style="font-weight: bold" data-bind="text: fiBuyer.fiBuyerFax"></span>
                    </p>
                    <p class="content">
                        Địa chỉ/Address: <span style="font-weight: bold" data-bind="text: fiBuyer.fiBuyerAddress"></span>
                    </p>
                    <p class="content">
                        Nơi nhận hàng/Port of Destination: <span style="font-weight: bold" data-bind="text: fiBuyer.fiPortOfDestinationName"></span>
                    </p>
                    <p class="content">
                        Thời gian nhập khẩu dự kiến từ ngày/Importing date from: <span style="font-weight: bold" data-bind="date: fiBuyer.fiImportingDateFrom"></span> đến ngày/to <span style="font-weight: bold" data-bind="date: fiBuyer.fiImportingDateTo"></span>
                    </p>
                    <br/>
                    <h5 class="content" style="font-weight: bold">
                        MÔ TẢ HÀNG HÓA/DESCRIPTION OF GOODS
                    </h5>

                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center" rowspan="2">STT</th>
                            <th class="text-center" rowspan="2">Tên hàng hóa</th>
                            <th class="text-center" rowspan="2">Tên khoa học</th>
                            <th class="text-center" rowspan="2">Cách đóng gói</th>
                            <th class="text-center" rowspan="2">Số lương/Khối lượng(kg)</th>
                            <th class="text-center" rowspan="2">Tên loại bao bì</th>
                            <th class="text-center" rowspan="2">Trọng lượng tịnh</th>
                            <th class="text-center" rowspan="2">Đơn vị tính trọng lượng tịnh</th>
                            <th class="text-center" rowspan="2">Trọng lượng tịnh cả bì</th>
                            <th class="text-center" rowspan="2">Đơn vị tính trọng lượng tịnh cả bì</th>
                            <th class="text-center" rowspan="2">Nước sản xuất</th>
                            <th class="text-center" rowspan="2">Số công nhận TACN, TATS</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstGood">
                        <tr>
                            <td data-bind="text: $index() + 1"></td>
                            <td data-bind="text: fiProductName"></td>
                            <td data-bind="text: fiProductScienceName"></td>
                            <td data-bind="text: fiPackingWay"></td>
                            <td data-bind="text: fiNumber"></td>
                            <td data-bind="text: fiUnitName"></td>
                            <td data-bind="text: fiNetWeight"></td>
                            <td data-bind="text: fiNWUnitName"></td>
                            <td data-bind="text: fiGrossWeight"></td>
                            <td data-bind="text: fiGWUnitName"></td>
                            <td data-bind="text: fiCountryOriginName"></td>
                            <td data-bind="text: fiCirculateNo"></td>
                        </tr>
                        </tbody>
                    </table>

                    <p class="content">
                        Mục đích sử dụng: <span style="font-weight: bold" data-bind="text: fiPurpose"></span>
                    </p>

                    <p class="content">
                        Văn bản chấp thuận kiểm dịch động vật nhập khẩu (nếu có): <span style="font-weight: bold" data-bind="text: fiAccQuarantineDoc"></span>
                    </p>

                    <p class="content">
                        Cơ sở sản xuất/Manufacturer:
                    </p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center" rowspan="2">STT</th>
                            <th class="text-center" rowspan="2">Tên cơ sở sản xuất</th>
                            <th class="text-center" rowspan="2">Địa chỉ cơ sở sản xuất</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstProdMfr">
                        <tr>
                            <td data-bind="text: $index() + 1"></td>
                            <td data-bind="text: fiCompanyName"></td>
                            <td data-bind="text: fiCompanyAddress"></td>
                        </tr>
                        </tbody>
                    </table>

                    <p class="code">
                        Địa điểm tập kết hàng/Location of storage: <span style="font-weight: bold" data-bind="text: fiStorageLocation"></span>
                    </p>
                    <p class="content">
                        Ngày đăng ký lấy mẫu kiểm tra từ ngày/Date for sampling to: <span style="font-weight: bold" data-bind="date: fiSamplingDateFrom"></span> đến ngày/to: <span style="font-weight: bold" data-bind="date: fiSamplingDateTo"></span>
                    </p>
                    <p class="code">
                        Địa điểm đăng ký lấy mẫu kiểm tra/Location for sampling: <span style="font-weight: bold" data-bind="text: fiSamplingLocation"></span>
                    </p>
                    <p class="code">
                        Thông tin người liên hệ/Contact person: <span style="font-weight: bold" data-bind="text: fiContactName"></span>, <span style="font-weight: bold" data-bind="text: fiContactTel"></span>
                    </p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center" rowspan="2">STT</th>
                            <th class="text-center" rowspan="2">Loại giấy tờ</th>
                            <th class="text-center" rowspan="2">Số</th>
                            <th class="text-center" rowspan="2">Ngày</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstDocument">
                        <tr>
                            <td data-bind="text: $index() + 1"/>
                            <td data-bind="text: fiTypeDoc() == 1 ? 'Hợp đồng mua bán/Contract' : fiTypeDoc() == 2 ? 'Hóa đơn mua bán/Invoice' : 'Phiếu đóng gói/Packinglist'"/>
                            <td data-bind="text: fiNumber"/>
                            <td data-bind="date: fiDate"/>
                        </tr>
                        </tbody>
                    </table>

                    <div class="col-md-12">
                        <div style="float: left; text-align: center">

                        </div>
                        <div style="float: right; text-align: center">
                            <p><i>ngày/date: <span data-bind="date: fiSignedDate"></span></i></p>
                            <p><b>Đại hiện tổ chức, cá nhân</b></p>
                            <span data-bind="text: fiSignedBy"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal">
                <spring:message code="conmon.button.dong"/>
            </button>
        </div>
    </div>
</div>
