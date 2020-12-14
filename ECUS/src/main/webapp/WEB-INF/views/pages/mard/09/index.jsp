<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
    .validationMessage{
        color:red;
    }
    p.code {text-align: left;}
</style>
<div class="row" id="mt-container">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"><span class="caption-subject bold uppercase"> <spring:message code="mard.09.tenthutuc" /></span></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i class="fa fa-gift"></i> <spring:message code="mard.tracuu.timkiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.mahoso" /></label>
                                                </div>
                                                <div class="col-md-10">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.trangthaihosodvkd" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSoDVKD" name="trangThaiHoSo" class="form-control select2"
                                                            data-bind="value : trangThaiKD, options : fiTrangthaiList, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.trangthaihosodvgs" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSoDVGS" name="trangThaiHoSo" class="form-control select2"
                                                            data-bind="value : trangThaiGS, options : fiTrangthaiList, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.ngaynoptu" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" data-bind="datepicker2: ngayTaoTuNgay, datepickerOptions: { endDate: ngayTaoDenNgay }" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="mard.tracuu.ngaynopden" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="ngayTaoDenNgay" data-bind="datepicker2: ngayTaoDenNgay, datepickerOptions: { startDate: ngayTaoTuNgay }" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.ngaycappheptu" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayCapTuNgay" id="ngayCapTuNgay" data-bind="datepicker2: ngayCapTuNgay, datepickerOptions: { endDate: ngayCapDenNgay }" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.ngaycapphepden" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayCapDenNgay" id="ngayCapDenNgay" data-bind="datepicker2: ngayCapDenNgay, datepickerOptions: { startDate: ngayCapTuNgay }" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Số giấy phép được cấp</label>
                                                </div>
                                                <div class="col-md-10">
                                                    <input class="form-control" name="soCongVan" id="soCongVan" data-bind="value : soCongVan, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="Số giấy phép được cấp" type="text">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: searchHoSoClick"><i class="fa fa-search"></i> Tìm kiếm</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-6">
                        <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager" class="nsw-flr">
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
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="monre06Items">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.stt" /></th>
                            <th class="text-center" width="10%"> <spring:message code="mard.danhsach.mahoso" /> </th>
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.lichsuxuly" /> </th>
                            <th class="text-center" width="25%"> <spring:message code="mard.danhsach.tendoanhnghiep" /> </th>
                            <th class="text-center" width="7%"> <spring:message code="mard.danhsach.ngaygui" /> </th>
                            <th class="text-center" width="20%"> <spring:message code="mard.danhsach.trangthaidonvikiemdich" /> </th>
                            <th class="text-center" width="20%"> <spring:message code="mard.danhsach.trangthaidonvigiamsat" /> </th>
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.xem" /> </th>
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.thongbaoapphi" /> </th>
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.xemxacnhandon" /> </th>
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.xemgiayphep" /> </th>
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.xemcongvanxnclkhongdat" /> </th>
                            <th class="text-center" width="5%"> <spring:message code="mard.danhsach.thongbaokhongcapcnkd" /> </th>
                        </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="text : fiHSCode, click: $parent.bXemHoso.bind($parent)"></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-history" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center" data-bind="text : fiNameOfRegistration"></td>
                            <td class="text-center" data-bind="datetime : fiCreatedDate"></td>
                            <td class="text-center" data-bind="text : fiKDStatus"></td>
                            <td class="text-center" data-bind="text : fiGSStatus"></td>
                            <td class="text-center" >
                                <a href="javascript:void(0)"><i class="fa fa-eye" data-bind="click: $parent.bXemHoSo.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="visible: isShowApphi"><i class="fa fa-eye" data-bind=" click: $parent.bXemThongbaoApphi.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-eye" data-bind="visible: isShowXND, click: $parent.bXemXacnhanDon.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="visible: isShowXemCongVan"><i class="fa fa-eye" data-bind="visible: true, click: $parent.btnXemGiayphepClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="visible: isShowXemTB"><i class="fa fa-eye" data-bind="visible: true, click: $parent.bXemTbKhongcap.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="visible: isShowKhongcapCNKD"><i class="fa fa-eye" data-bind="visible: true, click: $parent.bXemTbKhongcapCNKD.bind($parent)" src="" alt=""/></a>
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
                </div>
            </div>
            <div id="modalXinRut" class="modal in modal-overflow container" tabindex="-1"
                 data-backdrop="static" data-keyboard="false" data-bind="with: xinRutHoSoVM">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <b class="modal-title"><spring:message code="mard.08.modal.notice"/></b>
                </div>
                <div class="modal-body">
                    <div class="col-md-12" style="padding-bottom: 15px; padding-top: 10px;">
                        <p><strong><spring:message code="mard.08.modal.xin_rut"/> <span data-bind="text: fiHSCode"></span>?</strong></p>
                    </div>
                    <form role="form" class="form-horizontal" data-bind="visible: !hideReason()">
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.08.tokhai.noi_dung_xin_rut"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-10">
                                    <textarea rows="3" class="form-control" data-bind="value: fiReason"></textarea>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="text-center" style="padding-top: 10px">
                        <span class="nsw-require-field" data-bind="text: errorMsg"></span>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="text-center">
                        <button class="btn green" data-bind="click: sendRequestDeleteProfile">
                            <spring:message code="conmon.button.dong_y"/>
                        </button>
                        <button class="btn" data-dismiss="modal">
                            <spring:message code="conmon.button.huy"/>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    <!-- ko with: xemDanhsachGCN() -->
    <%@include file="inc_view_dsgiayphep.jsp"%>
    <%@include file="inc_view_cert_xncl.jsp"%>
    <%@include file="inc_view_cert_cnkd_dv.jsp"%>
    <%@include file="inc_view_cert_cnkd_spdv.jsp"%>
    <%@include file="inc_view_cert_gvc_dv.jsp"%>
    <%@include file="inc_view_cert_gvc_spdv.jsp"%>
    <!-- /ko -->

    <!-- ko with: tbXNCLKhongdat() -->
    <%@include file="inc_view_thongbao_xncl_khongdat.jsp"%>
    <!-- /ko -->

    <!-- ko with: tbKhongcapCNKD() -->
    <%@include file="inc_view_thongbao_khongcap_cnkd.jsp"%>
    <!-- /ko -->

    <%@include file="inc_view_lichsuXuly.jsp"%>

    <%@include file="inc_view_thongbaoapphi.jsp"%>

    <!-- ko with: xemHoSo03DV() -->
    <%@include file="inc_view_hoso03_dongvat.jsp"%>
    <!-- /ko -->

    <!-- ko with: xemHoSo03SPDV() -->
    <%@include file="inc_view_hoso03_sp_dongvat.jsp"%>
    <!-- /ko -->

    <!-- ko with: xemHoSo20DV() -->
    <%@include file="inc_view_hoso20a_dongvat.jsp"%>
    <!-- /ko -->

    <!-- ko with: xemHoSo20SPDV() -->
    <%@include file="inc_view_hoso20a_sp_dongvat.jsp"%>
    <!-- /ko -->

    <%@include file="inc_xacnhandon.jsp"%>

</div>
<%@include file="inc_script.jsp" %>


<script src="<c:url value='/app/mard/09/TBXNCLKhongDatVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/EditCerVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/TBKhongcapCNKDVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/model.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/mard/09/index.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/mard/09/SuaGCNVM.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/mard/09/LichSuXuLy.js?v=${version}' />" type="text/javascript"></script>

<template id="confirm-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" id="xoahoso-form">
            <div class="col-md-12">
                <span data-bind="text: fiMsg"></span><b data-bind="text: fiMaHoso"></b>
            </div>
        </form>
    </div>
</template>
<template id="lichsu-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" id="lichsu-form">
            <div class="form-group">

            </div>
        </form>
    </div>
</template>
<template id="history-tmpl">
<form role="form" class="form-horizontal" id="history-form">
    <p><spring:message code="common.history.mahoso" /> <b data-bind="text: fiMaHoso"></b></p>
    <div class="row">
        <div class="col col-md-6">
            <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
        </div>
        <div class="col col-md-6 nsw-text-right">
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
    <table class="table table-striped table-bordered table-hover table-checkable order-column">
        <thead>
            <tr>
                <th class="text-center"><b><spring:message code="mard.lichsu.stt" /></b></th>
                <th><b><spring:message code="mard.lichsu.nguoixuly" /></b></th>
                <th><b><spring:message code="mard.lichsu.donvixuly" /></b></th>
                <th style="max-width: 200px;"><b><spring:message code="mard.lichsu.noidung" /></b></th>
                <th class="text-center"><b><spring:message code="mard.lichsu.thoigian" /></b></th>
                <th style="max-width: 200px;"><b><spring:message code="mard.lichsu.trangthaihoso" /></b></th>
            </tr>
        </thead>
        <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
        </tbody>
        <script id="historyItemTmpl" type="text/html">
            <tr>
                <td data-bind="text : STT"></td>
                <td class="text-left" data-bind="text : fiTenNggui"></td>
                <td class="text-left" data-bind="text : fiTenDvgui"></td>
                <td class="text-left" data-bind="text : fiNoidung"></td>
                <td class="text-center" data-bind="text : fiNgaytao"></td>
                <td class="text-left" data-bind="text : fiTenTt"></td>
            </tr>
            </script>
        </table>
    </form>
</template>
<template id="kqxl-template">
    <form role="form" class="form-horizontal" id="kqxl-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Mã hồ sơ: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiMaHoso">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Nội dung: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiLydo">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Ngày xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="date : fiNgayXl">
                </div>
            </div>

            <div class="col-md-12" data-bind="if: fiNgaytraKq">
                <div class="col-md-4">
                    <label>Ngày trả kết quả: </label>
                </div>
                <div class="col-md-8" data-bind="date : fiNgaytraKq">
                </div>
            </div>

            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Đơn vị xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiDonviXl">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Người xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNguoiXl">
                </div>
            </div>
            <div class="col-md-12" data-bind="visible: visibleFile">
                <div class="col-md-4">
                    <label>Tệp đính kèm: </label>
                </div>
                <div class="col-md-8">
                    <a target="_blank" href="javascript:void(0);" data-bind="attr: { href: downloadUrl}, text: fiTenTep"></a>
                </div>
            </div>
        </div>
    </form>

</template>

<template id="cancel-template">
    <form role="form" class="form-horizontal" id="cancel-form">
        <div class="form-group">
            <div class="col-md-2">
                Ngày yêu cầu xin rút hồ sơ: <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10">
                <input class="form-control date-picker" id="fiNgayYc" name="fiNgayYc"  data-bind="datepicker : fiNgayYc" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2">
                Nội dung đơn yêu cầu xin rút hồ sơ: <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10">
                <textarea rows="3" class="form-control" id="fiLydo" name="fiLydo" type="text" maxlength="2000" data-bind="value: fiLydo"></textarea>
            </div>
        </div>
    </form>
</template>

<template id="delete-template">
    <form role="form" class="form-horizontal" id="delete-form">
        <div class="form-group">
            <div class="col-md-12">
                <p>Bạn có chắc chắn muốn xóa hồ sơ?</p>
            </div>
        </div>
    </form>
</template>

<template id="phanhoi-xncl-template">
    <form role="form" class="form-horizontal" id="phanhoi-xncl-form">
        <div class="form-group">
            <div class="col-md-3">
                Nội dung phản hồi: <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-9">
                <textarea rows="3" class="form-control" id="fiNoiDungPhanHoiXNCL" name="fiNoidungYc" type="text" maxlength="2000" data-bind="value: fiNoidungYc"></textarea>
            </div>
        </div>
    </form>
</template>
