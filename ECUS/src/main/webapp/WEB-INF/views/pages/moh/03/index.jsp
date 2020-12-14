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
                    <span class="caption-subject bold uppercase"> <spring:message code="moh.03.tenthutuc"/></span>
                </div>
            </div>
            <div class="table-toolbar">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span class="caption-subject bold uppercase"><i
                                        class="fa fa-gift"></i> <spring:message
                                        code="moh.03.hoso.tracuu.timkiem"/> </span>
                            </div>
                            <div class="panel-body">
                                <form role="form" class="form-horizontal" name="searchForm">
                                    <div class="form-group" style="margin-top: 15px;">
                                        <div class="col-md-12">
                                            <div class="col-md-2 nsw-text-right">
                                                <label><spring:message code="moh.03.hoso.tracuu.mahoso"/></label>
                                            </div>
                                            <div class="col-md-4">
                                                <input class="form-control" name="maHoSo" id="maHoSo"
                                                       data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'"
                                                       placeholder="<spring:message code="common.tracuu.ma_ho_so" />"
                                                       type="text" maxlength="35"/>
                                            </div>
                                            <div class="col-md-2 nsw-text-right">
                                                <label><spring:message
                                                        code="moh.03.hoso.tracuu.trangthaihoso"/></label>
                                            </div>
                                            <div class="col-md-4">
                                                <select class="form-control select2" id="trangThaiHoSo"
                                                        name="trangThaiHoSo"
                                                        data-bind="value : trangThaiHoSo,
                                                        options : fiTrangthaiList,
                                                        optionsValue : 'id',
                                                        optionsCaption: 'Chọn...',
                                                        optionsText : 'name'">
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-2 nsw-text-right">
                                                <label><spring:message
                                                        code="moh.03.hoso.tracuu.ngaynoptu"/></label>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="input-group">
                                                    <input name="ngayNopTuNgay" id="ngayNopTuNgay"
                                                           class="form-control form-control-inline date-picker"
                                                           data-bind="datepicker : ngayNopTuNgay"
                                                           data-date-format="dd/mm/yyyy" type="text" value=""
                                                           placeholder="dd/mm/yyyy" readonly
                                                           style="background: transparent !important"/>
                                                    <a class="input-group-addon" style="background: #fff !important;"
                                                       href="javascript:void(0)"
                                                       data-bind="event : {click : clearfiNgayNopTu}">
                                                        <i class="fa fa-close"></i>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="col-md-2 nsw-text-right">
                                                <label><spring:message
                                                        code="moh.03.hoso.tracuu.ngaynopden"/></label>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="input-group">
                                                    <input name="ngayNopDenNgay" id="ngayNopDenNgay"
                                                           class="form-control form-control-inline date-picker"
                                                           data-bind="datepicker : ngayNopDenNgay"
                                                           data-date-format="dd/mm/yyyy" type="text" value=""
                                                           placeholder="dd/mm/yyyy" readonly
                                                           style="background: transparent !important"/>
                                                    <a class="input-group-addon" style="background: #fff !important;"
                                                       href="javascript:void(0)"
                                                       data-bind="event : {click : clearfiNgayNopDen}">
                                                        <i class="fa fa-close"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-2 nsw-text-right">
                                                <label><spring:message
                                                        code="moh.03.hoso.tracuu.ngaycaptu"/></label>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="input-group">
                                                    <input name="ngayCapTuNgay" id="ngayCapTuNgay"
                                                           class="form-control form-control-inline date-picker"
                                                           data-date-format="dd/mm/yyyy"
                                                           data-bind="datepicker : ngayCapTuNgay"
                                                           type="text" value="" placeholder="dd/mm/yyyy"
                                                           readonly style="background: transparent !important"/>
                                                    <a class="input-group-addon" style="background: #fff !important;"
                                                       href="javascript:void(0)"
                                                       data-bind="event : {click : clearfiNgayCapTu}">
                                                        <i class="fa fa-close"></i>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="col-md-2 nsw-text-right">
                                                <label><spring:message
                                                        code="moh.03.hoso.tracuu.ngaycapden"/></label>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="input-group">
                                                    <input name="ngayCapDenNgay" id="ngayCapDenNgay"
                                                           class="form-control form-control-inline date-picker"
                                                           data-bind="datepicker : ngayCapDenNgay"
                                                           data-date-format="dd/mm/yyyy" type="text" value=""
                                                           placeholder="dd/mm/yyyy" readonly
                                                           style="background: transparent !important"/>
                                                    <a class="input-group-addon" style="background: #fff !important;"
                                                       href="javascript:void(0)"
                                                       data-bind="event : {click : clearfiNgayCapDen}">
                                                        <i class="fa fa-close"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group nsw-text-center">
                                        <a href="javascript:;" class="btn green" id="searchHoSoClick"
                                           data-bind="click: searchHoSoClick"><i
                                                class="fa fa-search"></i> <spring:message
                                                code="moh.03.hoso.timkiem"/></a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-6">
                    <spring:message code="moh.03.hoso.tracuu.ketquatimkiem"/>
                    <b> <a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a>
                    </b><spring:message code="common.pager.ban_ghi"/>
                </div>
                <div class="col col-md-6 nsw-text-right">
                    <div id="list-pager" class="nsw-flr">
                        <!-- ko with:paging()-->
                        <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                            <li data-bind="css: { disabled: !firstPageActive() }">
                                <a data-bind="click: goToFirst"><spring:message code="moh.03.hoso.trangdau"/></a>
                            </li>
                            <li data-bind="css: { disabled: !previousPageActive() }">
                                <a data-bind="click: goToPrevious"><spring:message
                                        code="moh.03.hoso.trangtruoc"/></a>
                            </li>
                            <!-- ko foreach: getPages() -->
                            <li data-bind="css: { active: $parent.currentPage() === $data }">
                                <a data-bind="click: $parent.goToPage, text: $data"></a>
                            </li>
                            <!-- /ko -->
                            <li data-bind="css: { disabled: !nextPageActive() }">
                                <a data-bind="click: goToNext"><spring:message code="moh.03.hoso.trangsau"/></a>
                            </li>
                            <li data-bind="css: { disabled: !lastPageActive() }">
                                <a data-bind="click: goToLast"><spring:message code="moh.03.hoso.trangcuoi"/></a>
                            </li>
                        </ul>
                        <!-- /ko -->
                    </div>
                </div>
            </div>
            <table class="table table-striped table-bordered table-hover table-checkable order-column"
                   id="moh03Items">
                <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center" style="width: 1%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.stt"/></th>
                    <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.lichsuxuly"/></th>
                    <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.mahoso"/></th>
                    <th class="text-center" style="width: 15%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.tendoanhnghiep"/></th>
                    <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.ngaynop"/></th>
                    <th class="text-center" style="width: 15%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.ngaycapphep"/></th>
                    <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.trangthai"/></th>
                    <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                            code="moh.03.hoso.danhsach.xemgiayphep"/></th>
                </tr>
                </thead>
                <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                </tbody>
                <script id="itemTmpl" type="text/html">
                    <tr>
                        <td style="vertical-align: middle;" data-bind="text: STT">
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
                        <td class="text-center" style="vertical-align: middle;" data-bind="text : fiTenDn">
                        </td>
                        <td class="text-center" style="vertical-align: middle;" data-bind="text : fiNgayguiText">
                        </td>
                        <td class="text-center" style="vertical-align: middle;" data-bind="text : fiNgaycapGpText">
                        </td>
                        <td class="text-center" style="vertical-align: middle;">
                            <a href="javascript:void(0)"
                               data-bind="text : fiTenTt, click: $parent.bTrangthaiClick.bind($parent)"></a>
                        </td>
                        <td class="text-center" style="vertical-align: middle;">
                            <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips"
                                                            data-original-title="Xem giấy phép"
                                                            data-bind="visible: bXemGiayPhep, click: $parent.bXemGpClick.bind($parent)"
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
                                    <spring:message code="moh.03.hoso.trangdau"/></a>
                            </li>
                            <li data-bind="css: { disabled: !previousPageActive() }">
                                <a data-bind="click: goToPrevious">
                                    <spring:message code="moh.03.hoso.trangtruoc"/></a>
                            </li>
                            <!-- ko foreach: getPages() -->
                            <li data-bind="css: { active: $parent.currentPage() === $data }">
                                <a data-bind="click: $parent.goToPage, text: $data"></a>
                            </li>
                            <!-- /ko -->
                            <li data-bind="css: { disabled: !nextPageActive() }">
                                <a data-bind="click: goToNext">
                                    <spring:message code="moh.03.hoso.trangsau"/></a>
                            </li>
                            <li data-bind="css: { disabled: !lastPageActive() }">
                                <a data-bind="click: goToLast">
                                    <spring:message code="moh.03.hoso.trangcuoi"/></a>
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
<%@include file="inc_css_index.jsp" %>
<script src="<c:url value='/app/moh/03/model.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/moh/03/index.js?v=${version}'/>" type="text/javascript"></script>

<%--start form confirm deleted--%>
<template id="confirm-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" id="xoahoso-form">
            <div class="col-md-12">
                <span data-bind="text: fiMsg"></span><b data-bind="text: fiIdHoso"></b>
            </div>
        </form>
    </div>
</template>
<%--End form confirm deleted--%>

<%--start form history--%>
<template id="history-tmpl">
    <form role="form" class="form-horizontal" id="history-form">
        <p><spring:message code="common.history.mahoso"/> <b data-bind="text: fiMaHoso"></b></p>
        <div class="row">
            <div class="col col-md-2">
                <spring:message code="common.tong"/> <b><a id="lbTotalRecords" data-bind="text: totalCount"
                                                           href="javascript:void(0);"></a> </b><spring:message
                    code="common.pager.ban_ghi"/>
            </div>
            <div class="col col-md-10 nsw-text-right">
                <div class="nsw-flr">
                    <!-- ko with:paging()-->
                    <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                        <li data-bind="css: { disabled: !firstPageActive() }">
                            <a data-bind="click: goToFirst">Trang đầu</a>
                        </li>
                        <li data-bind="css: { disabled: !previousPageActive() }">
                            <a data-bind="click: goToPrevious">Trang trước</a>
                        </li>
                        <!-- ko foreach: getPages() -->
                        <li data-bind="css: { active: $parent.currentPage() === $data }">
                            <a data-bind="click: $parent.goToPage, text: $data"></a>
                        </li>
                        <!-- /ko -->
                        <li data-bind="css: { disabled: !nextPageActive() }">
                            <a data-bind="click: goToNext">Trang sau</a>
                        </li>
                        <li data-bind="css: { disabled: !lastPageActive() }">
                            <a data-bind="click: goToLast">Trang cuối</a>
                        </li>
                    </ul>
                    <!-- /ko -->
                </div>
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover table-checkable order-column"
               style="float: left;width: 100%;table-layout: fixed;">
            <thead>
            <tr>
                <th class="text-center" style="width: 5%;"><spring:message
                        code="moh.03.hoso.lichsuxuly.stt"/></th>
                <th class="text-center"><spring:message
                        code="moh.03.hoso.lichsuxuly.tendonvi"/></th>
                <th class="text-center"><spring:message
                        code="moh.03.hoso.lichsuxuly.noidung"/></th>
                <th class="text-center"><spring:message
                        code="moh.03.hoso.lichsuxuly.linkcongvan"/></th>
                <th class="text-center"><spring:message
                        code="moh.03.hoso.lichsuxuly.thoigian"/></th>
                <th class="text-center" style="max-width: 200px;"><spring:message
                        code="moh.03.hoso.lichsuxuly.trangthai"/></th>
            </tr>
            </thead>
            <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
            </tbody>
            <script id="historyItemTmpl" type="text/html">
                <tr>
                    <td style="word-wrap: break-word; vertical-align: middle;" data-bind="text : STT"></td>
                    <td style="word-wrap: break-word; max-width: 220px !important; vertical-align: middle;" class="text-left"
                        data-bind="text : fiTenDvgui"></td>
                    <td class="text-left"
                        style="width: 220px;text-align: left;word-wrap: break-word;max-width: 220px !important;vertical-align: middle;"
                        data-bind="text : fiNoidung"></td>
                    <td style="word-wrap: break-word; max-width: 220px !important; vertical-align: middle;" class="text-left">
                        <a target="_blank" data-bind="text: fiLinkCv, attr: { href: fiLinkCv}"></a>
                    </td>
                    <td style="word-wrap: break-word; max-width: 220px !important; vertical-align: middle;" class="text-center"
                        data-bind="text : fiNgaytao"></td>
                    <td style="word-wrap: break-word; max-width: 220px !important; vertical-align: middle;" class="text-left"
                        data-bind="text : fiTenTt"></td>
                </tr>
            </script>
        </table>
    </form>
</template>
<%--end form history--%>

<%--start form rut ho so--%>
<template id="ruthoso-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="ruthoso-form" id="ruthoso-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></label> <b data-bind="text: fiMaHoso"></b></p>
            </div>
            <div class="col-md-2">
                <label><spring:message code="common.msg.ly_do"/></label>
                <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10">
                <textarea name="fiNoidung" id="fiNoidung" onblur="this.value=removeSpaces(this.value);"
                          data-bind="value: fiNoidung" require="true"
                          placeholder="<spring:message code="common.msg.ly_do" />"
                          style="width: 90%; height: 150px; max-width: 90%; max-height: 150px; resize: none; overflow-x: hidden;"
                          maxlength="2000"></textarea>
            </div>
        </form>
    </div>
</template>
<%--end form rut ho so--%>

<%--form ket qua xu ly--%>
<template id="kqxl-template">
    <form role="form" class="form-horizontal" id="kqxl-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label><spring:message code="moh.03.kqxl.mahoso"/></label>
                </div>
                <div class="col-md-8" data-bind="text : fiMaHoso" style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label><spring:message code="moh.03.kqxl.noidung"/></label>
                </div>
                <div class="col-md-8" data-bind="text : fiNoidung" style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label><spring:message code="moh.03.kqxl.ngayxl"/></label>
                </div>
                <div class="col-md-8" data-bind="date : fiNgayXl" style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label><spring:message code="moh.03.kqxl.donvixl"/></label>
                </div>
                <div class="col-md-8" data-bind="text : fiDonviXl" style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label><spring:message code="moh.03.kqxl.linkcv"/></label>
                </div>
                <div class="col-md-8" style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                    <a target="_blank" data-bind="text: fiLinkCv, attr: { href: fiLinkCv}"></a>
                </div>
            </div>
        </div>
    </form>
</template>
<%--end form ket qua xu ly--%>