<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="mard06ViewHSModal" data-bind="with: selectedHoSo" class="modal container in modal-overflow" tabindex="-1">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body container" style="display: flex">
        <div id="content-hoso" size="a4" class="a4 col-md-12">
            <div class="text-center">
                <h4 style="font-weight: bold;">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                </h4>
                <h5 style="font-weight: bold">
                    Độc lập - Tự do - Hạnh phúc
                </h5>

                <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                <div class="text-right" style="padding-top: 10px">
                    <h5 class="text-border" style="font-weight: bold">Mẫu 02TS</h5>
                </div>
            </div>
            <div class="text-center" style="padding-top: 15px;">
                <h4 class="uppercase" style="font-weight: bold">ĐƠN <spring:message code="mard.06.ten_thu_tuc"></spring:message></h4>
                <p class="code">
                    <b>Số: <span data-bind="text: fiNSWFileCode"></span></b>
                </p>
                <p class="code">
                    <b>Kính gửi: Cục Thú y</b>
                </p>
            </div>
            <p class="content">
                <span>Tên tổ chức, cá nhân: </span><b data-bind="text: fiImporterName"></b>
            </p>
            <p class="content">
                <span>Địa chỉ: </span><b data-bind="text: fiImporterAddress"></b>
            </p>
            <p class="content">
                <span>Số điện thoại: </span><b data-bind="text: fiImporterTel"></b>
            </p>
            <p class="content">
                <span>Fax: </span><b data-bind="text: fiImporterFax"></b>
            </p>
            <p class="content">
                <span>Email: </span><b data-bind="text: fiImporterEmail"></b>
            </p>
            <p class="content">
                Căn cứ nhu cầu sản xuất, kinh doanh của Công ty <b data-bind="text: fiImporterName"></b>, đề nghị Cục Thú y hướng dẫn Công ty kiểm dịch nhập khẩu lô hàng:
            </p>
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                <tr >
                    <th class="text-center"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                    <th class="text-center"><spring:message code="mard.06.table.ten_thuong_mai"/></th>
                    <th class="text-center"><spring:message code="mard.06.table.ten_khoa_hoc"/></th>
                    <th class="text-center"><spring:message code="mard.06.table.kich_co_ca_the"/></th>
                    <th class="text-center"><spring:message code="mard.06.table.so_luong"/></th>
                    <th class="text-center"><spring:message code="mard.06.table.don_vi_tinh"/></th>
                    <th class="text-center"><spring:message code="mard.06.table.nuoc_xuat_xu"/></th>
                </tr>
                </thead>
                <tbody
                        data-bind="foreach: fiProductList">
                <tr>
                    <td data-bind="text: ($index() + 1)"></td>
                    <td data-bind="text : fiProductBusinessName">
                    </td>
                    <td data-bind="text : fiProductScienceName">
                    </td>
                    <td data-bind="text : fiSizeOrType"></td>
                    <td class="text-right" data-bind="text : fiQuantity"></td>
                    <td data-bind="text: $root.getUnitName(fiPackageUnitCode)"></td>
                    <td data-bind="text: $root.getCountryName(fiOriginCountryCode)"></td>
                </tr>
                </tbody>
            </table>
            <p class="content">
                Tên, địa chỉ công ty xuất khẩu: <span data-bind="foreach: fiExporterCountryList"><b data-bind="text: fiExporterCountryName"></b> (<b data-bind="text: fiExporterCountryAddress"></b>); </span>
            </p>
            <p class="content">
                Tên, địa chỉ cơ sở nuôi/ sản xuất giống/ cơ sở sơ chế, chế biến sản phẩm động vật thủy sản tại nước xuất khẩu:
                <span data-bind="foreach: fiProcessingList"><b data-bind="text: fiProcessingName"></b> -
                    <b data-bind="text: fiProcessingAddress"></b>
                    <b data-bind="visible: fiProcessingApprovalNumber, text: '(' + fiProcessingApprovalNumber + ')'"></b>; </span>
            </p>
            <div data-bind="visible: fiLocationQuarantineList.length > 0">
            <p class="content">
                Tên, địa chỉ nơi cách ly kiểm dịch động vật thủy sản/sản phẩm động vật thủy sản nhập khẩu:
                <span data-bind="foreach: fiLocationQuarantineList"><b data-bind="text: fiLocationQuarantineName"></b> (<b data-bind="text: fiLocationQuarantineAddress"></b>); </span>
            </p>
            </div>
            <p class="content">
                Cửa khẩu nhập: <b data-bind="text: fiBordergateName"></b>
            </p>
            <p class="content">
                Thời gian thực hiện: <b data-bind="text: fiTimeQuarantine"></b>
            </p>
            <p class="content">
                Mục đích sử dụng: <b data-bind="text: fiPurpose"></b>
            </p>
            <p class="content">
                Các giấy tờ có liên quan kèm theo: <b data-bind="text: fiRelatedDocuments"></b>
            </p>
            <p class="content">
                Chúng tôi cam kết chấp hành nghiêm Pháp luật về Thú y.
            </p>
            <div class="row">
                <div class="col-md-6"></div>
                <div class="col-md-6 text-center">
                    <h4 style="font-weight: bold" data-bind="text: fiSignPosition"></h4>
                    <h5 style="font-weight: bold" data-bind="text: fiSignName"></h5>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <div class="text-center">
            <a class="btn green" data-bind="click: function() { $root.taiMauHoSo($data) }">
                <spring:message code="common.button.tai_ve"/>
            </a>
            <a class="btn" href="javascript:void(0)" data-dismiss="modal">
                <spring:message code="conmon.button.dong"/>
            </a>
        </div>
    </div>
</div>
<style>
    .text-border {
        border: 1px solid;
        display: inline;
        padding: 5px;
    }
</style>