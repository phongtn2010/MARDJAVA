<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style type="text/css">
    .validationMessage {
        color: red;
    }
</style>
<div class="row" id="mt-container">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"> <spring:message code="mard.04.tenthutuc"/></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i
                                            class="fa fa-gift"></i> <spring:message code="mard.04.hoso.tracuu.timkiem"/> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchFormMic">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.04.hoso.tracuu.mahoso"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo"
                                                           data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'"
                                                           placeholder="<spring:message code="common.tracuu.ma_ho_so" />"
                                                           type="text"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message
                                                            code="mard.04.hoso.tracuu.trangthaihoso"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select class="form-control select2" id="trangThaiHoSo"
                                                            name="trangThaiHoSo"
                                                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                                                        , value : trangThaiHoSo
                                                        , options : fiTrangThaiList
                                                        , optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Ngày nộp từ ngày</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="input-group">
                                                        <input placeholder="dd/mm/yyyy" name="ngayNopTuNgay"
                                                               id="ngayNopTuNgay" data-bind="datepicker : ngayNopTuNgay"
                                                               class="form-control form-control-inline date-picker"
                                                               data-date-format="dd/mm/yyyy" type="text" value=""
                                                               maxlength="10" readonly
                                                               style="background: transparent !important"/>
                                                        <a class="input-group-addon"
                                                           style="background: #fff !important;"
                                                           href="javascript:void(0)"
                                                           data-bind="event : {click : clearfiNgayNopTuNgay}">
                                                            <i class="fa fa-close"></i>
                                                        </a>
                                                    </div>
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Ngày nộp đến ngày</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="input-group">
                                                        <input placeholder="dd/mm/yyyy" name="ngayNopDenNgay"
                                                               id="ngayNopDenNgay"
                                                               data-bind="datepicker : ngayNopDenNgay"
                                                               class="form-control form-control-inline date-picker"
                                                               data-date-format="dd/mm/yyyy" type="text" value=""
                                                               maxlength="10" readonly
                                                               style="background: transparent !important"/>
                                                        <a class="input-group-addon"
                                                           style="background: #fff !important;"
                                                           href="javascript:void(0)"
                                                           data-bind="event : {click : clearfiNgayNopDenNgay}">
                                                            <i class="fa fa-close"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Ngày cấp phép từ ngày</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="input-group">
                                                        <input placeholder="dd/mm/yyyy" name="ngayCapphepTuNgay"
                                                               id="ngayCapphepTuNgay"
                                                               data-bind="datepicker : ngayCapphepTuNgay"
                                                               class="form-control form-control-inline date-picker"
                                                               data-date-format="dd/mm/yyyy" type="text" value=""
                                                               maxlength="10" readonly
                                                               style="background: transparent !important"/>
                                                        <a class="input-group-addon"
                                                           style="background: #fff !important;"
                                                           href="javascript:void(0)"
                                                           data-bind="event : {click : clearfiNgayCapphepTuNgay}">
                                                            <i class="fa fa-close"></i>
                                                        </a>
                                                    </div>
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Ngày cấp phép đến ngày</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="input-group">
                                                        <input placeholder="dd/mm/yyyy" name="ngayCapphepDenNgay"
                                                               id="ngayCapphepDenNgay"
                                                               data-bind="datepicker : ngayCapphepDenNgay"
                                                               class="form-control form-control-inline date-picker"
                                                               data-date-format="dd/mm/yyyy" type="text" value=""
                                                               maxlength="10" readonly
                                                               style="background: transparent !important"/>
                                                        <a class="input-group-addon"
                                                           style="background: #fff !important;"
                                                           href="javascript:void(0)"
                                                           data-bind="event : {click : clearfiNgayCapphepDenNgay}">
                                                            <i class="fa fa-close"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Loại đơn đăng ký</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select class="form-control select2" id="loaiDon"
                                                            name="loaiDon"
                                                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                                                        , value : maLoaiDon
                                                        , options : lstLoaidon
                                                        , optionsText : 'name'">
                                                    </select>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Trạng thái phí</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select class="form-control select2" id="trangthaiPhi"
                                                            name="trangthaiPhi"
                                                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                                                        , value : maTrangthaiPhi
                                                        , options : lstTrangthaiPhi
                                                        , optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSoClick"
                                               data-bind="click: searchHoSoClick"><i
                                                    class="fa fa-search"></i><spring:message
                                                    code="mard.04.hoso.timkiem"/></a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-6">
                        <spring:message code="mard.04.hoso.tracuu.ketquatimkiem"/>
                        <b> <a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a>
                        </b><spring:message code="common.pager.ban_ghi"/>
                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager" class="nsw-flr">
                            <!-- ko with:paging()-->
                            <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !firstPageActive() }">
                                    <a data-bind="click: goToFirst"><spring:message code="mard.04.hoso.trangdau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !previousPageActive() }">
                                    <a data-bind="click: goToPrevious"><spring:message
                                            code="mard.04.hoso.trangtruoc"/></a>
                                </li>
                                <!-- ko foreach: getPages() -->
                                <li data-bind="css: { active: $parent.currentPage() === $data }">
                                    <a data-bind="click: $parent.goToPage, text: $data"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !nextPageActive() }">
                                    <a data-bind="click: goToNext"><spring:message code="mard.04.hoso.trangsau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !lastPageActive() }">
                                    <a data-bind="click: goToLast"><spring:message code="mard.04.hoso.trangcuoi"/></a>
                                </li>
                            </ul>
                            <!-- /ko -->
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column"
                       id="monre06Items">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 1%;vertical-align: middle;"><spring:message
                                code="mard.04.hoso.danhsach.stt"/></th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                                code="mard.04.hoso.danhsach.lichsuxuly"/></th>
                        <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                                code="mard.04.hoso.danhsach.mahoso"/></th>
                        <th class="text-center" style="width: 15%;vertical-align: middle;">Tên doanh nghiệp</th>
                        <th class="text-center" style="width: 25%;vertical-align: middle;">Loại đơn đăng ký</th>
                        <th class="text-center" style="width: 15%;vertical-align: middle;"><spring:message
                                code="mard.04.hoso.danhsach.trangthai"/></th>
                        <th class="text-center" style="width: 15%;vertical-align: middle;">Trạng thái phí</th>
                        <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                                code="mard.04.hoso.danhsach.ngaygui"/></th>
                        <th class="text-center" style="width: 10%;vertical-align: middle;">Ngày cấp phép</th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;">Xem kết quả</th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                                code="mard.04.hoso.danhsach.thongbaophi"/></th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;">Xác nhận đơn</th>
                    </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT" style="vertical-align: middle;">
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-history"
                                                                data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"
                                   data-bind="text : fiMaHoso, click: $parent.bXemClick.bind($parent)"></a>
                            </td>
                            <td class="text-center" data-bind="text : fiTenTochuc"
                                style="vertical-align: middle;"></td>
                            <td class="text-center" data-bind="text : fiTenLoaidon"
                                style="vertical-align: middle;"></td>
                            <td class="text-center" style="max-width: 200px;vertical-align: middle;">
                                <a href="javascript:void(0)"
                                   data-bind="text : fiTenTrangthai, event : {click : $parent.fiTrangThaiClick.bind($parent)}"></a>
                            </td>
                            <td class="text-center" style="max-width: 200px;vertical-align: middle;">
                                <a href="javascript:void(0)"
                                   data-bind="text : fiTenTrangthaiphi, event : {click : $parent.fiTrangThaiphiClick.bind($parent)}"></a>
                            </td>
                            <td class="text-center" data-bind="text : fiNgayguiText"
                                style="vertical-align: middle;"></td>
                            <td class="text-center" data-bind="text : fiNgayCapText"
                                style="vertical-align: middle;"></td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips"
                                                                data-original-title="Xem kết quả kiểm dịch"
                                                                data-bind="visible: bXemkqKiemDich, click: $parent.bXemkqKiemDichClick.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-usd tooltips"
                                                                data-original-title="Thông báo phí"
                                                                data-bind="visible: bThongBaoPhi, click: $parent.bThongBaoPhiClick.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-file-pdf-o tooltips"
                                                                data-original-title="Đơn đăng ký"
                                                                data-bind="visible: bDonDangKy, click: $parent.bDonDangKyClick.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                        </tr>
                    </script>
                </table>
                <div class="row">
                    <div class="col col-md-6">
                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager" class="nsw-flr">
                            <!-- ko with:paging()-->
                            <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !firstPageActive() }">
                                    <a data-bind="click: goToFirst">
                                        <spring:message code="mard.04.hoso.trangdau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !previousPageActive() }">
                                    <a data-bind="click: goToPrevious">
                                        <spring:message code="mard.04.hoso.trangtruoc"/></a>
                                </li>
                                <!-- ko foreach: getPages() -->
                                <li data-bind="css: { active: $parent.currentPage() === $data }">
                                    <a data-bind="click: $parent.goToPage, text: $data"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !nextPageActive() }">
                                    <a data-bind="click: goToNext">
                                        <spring:message code="mard.04.hoso.trangsau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !lastPageActive() }">
                                    <a data-bind="click: goToLast">
                                        <spring:message code="mard.04.hoso.trangcuoi"/></a>
                                </li>
                            </ul>
                            <!-- /ko -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="inc_script.jsp" %>
<script src="<c:url value='/app/mard/04/model.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/mard/04/index.js?v=${version}'/>" type="text/javascript"></script>

<%--form view lịch sử--%>
<template id="history-tmpl">
    <form role="form" class="form-horizontal" id="history-form">
        <p><spring:message code="common.history.mahoso"/> <b data-bind="text: fiMaHoso"></b></p>
        <div class="row">
            <div class="col col-md-6">
                <spring:message code="common.tong"/> <b><a id="lbTotalRecords" data-bind="text: totalCount"
                                                           href="javascript:void(0);"></a> </b><spring:message
                    code="common.pager.ban_ghi"/>
            </div>
            <div class="col col-md-6 nsw-text-right">
                <div class="nsw-flr">
                    <!-- ko with:paging()-->
                    <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                        <li data-bind="css: { disabled: !firstPageActive() }">
                            <a data-bind="click: goToFirst"> <spring:message code="mard.04.hoso.trangdau"/>
                            </a>
                        </li>
                        <li data-bind="css: { disabled: !previousPageActive() }">
                            <a data-bind="click: goToPrevious">
                                <spring:message code="mard.04.hoso.trangtruoc"/></a>
                        </li>
                        <!-- ko foreach: getPages() -->
                        <li data-bind="css: { active: $parent.currentPage() === $data }">
                            <a data-bind="click: $parent.goToPage, text: $data"></a>
                        </li>
                        <!-- /ko -->
                        <li data-bind="css: { disabled: !nextPageActive() }">
                            <a data-bind="click: goToNext"><spring:message code="mard.04.hoso.trangsau"/>
                            </a>
                        </li>
                        <li data-bind="css: { disabled: !lastPageActive() }">
                            <a data-bind="click: goToLast"><spring:message code="mard.04.hoso.trangcuoi"/></a>
                        </li>
                    </ul>
                    <!-- /ko -->
                </div>
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr>
                <th class="text-center"><b><spring:message code="mard.04.hoso.lichsu.stt"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.donvixuly"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.nguoixuly"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.noidung"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.thoigian"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.trangthaihoso"/></b></th>
            </tr>
            </thead>
            <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
            </tbody>
            <script id="historyItemTmpl" type="text/html">
                <tr>
                    <td data-bind="text : STT"></td>
                    <td class="text-left" style="width: 15%;" data-bind="text : fiDonviXuly"></td>
                    <td class="text-left" style="width: 15%;" data-bind="text : fiNguoiXuly"></td>
                    <td class="text-left" data-bind="text : fiNoidung"></td>
                    <td class="text-center" data-bind="text : fiThoigianText"></td>
                    <td class="text-left" style="width: 15%;" data-bind="text : fiTenTrangthai"></td>
                </tr>
            </script>
        </table>
    </form>
</template>
<%--end form view lịch sử--%>

<%--Form view kết quả xử lý--%>
<template id="kqxl-template">
    <form role="form" class="form-horizontal" id="kqxl-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Mã hồ sơ: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiMaHoso"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Nội dung: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNoiDung"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Ngày xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="date : fiNgayXl"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Đơn vị xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiDonviXl"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Chuyên viên xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiChuyenvienXl"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
        </div>
    </form>
</template>
<%--end form view kết quả xử lý--%>
