<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="inc_script.jsp" %>
<style type="text/css">
    .validationMessage{
        color:red;
    }
    p.code {text-align: left;}
</style>

<script type="text/javascript" src="<c:url value='/app/mard/01/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/index.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/model.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/LichSuXuLy.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/ThongbaoKhongdatYCXK.js?v=${version}'/>"></script>
<div id="mard01Home">
    <div class="col-md-12">
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <%--                    <i class="icon-settings font-dark"></i>--%>
                    <span class="caption-subject bold uppercase"><spring:message
                            code="mard.01.title.them_ho_so"/></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span class="caption-subject bold uppercase"><spring:message
                                    code="common.tracuu.thong_tin_tim_kiem"/> </span>
                        </div>
                        <div class="panel-body">
                            <form role="form" class="form-horizontal" name="thongTinHsForm">
                                <div class="form-group" style="margin-top: 15px">
                                    <div class="col-md-12">
                                        <div class="col-md-2">
                                            <label><spring:message
                                                    code="common.tracuu.ma_ho_so"/></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input
                                                    data-bind="value : maHoSo"
                                                    class="form-control"
                                            />
                                        </div>
                                        <div class="col-md-2">
                                            <label><spring:message code="common.tracuu.trang_thai_ho_so"/></label>
                                        </div>
                                        <div class="col-md-4">
                                            <select class="form-control" id="thhs" name="fiMaDvkd"
                                                    data-bind="optionsCaption: 'Chọn...', options: fiTrangthaiList, value: trangThaiHS, optionsValue : 'id', optionsText : 'name'"></select>
                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2">
                                            <label>Ngày gửi hồ sơ từ ngày</label>
                                        </div>
                                        <div class="col-md-4">
                                            <input
                                                    data-bind="datepicker: ngayTaoTuNgay"
                                                    class="form-control form-control-inline date-picker"
                                                    data-date-format="dd/mm/yyyy" type="text" value=""
                                                    maxlength="10"/>
                                        </div>
                                        <div class="col-md-2">
                                            <label><spring:message code="common.tracuu.ngay_gui_den"/></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input
                                                    data-bind="datepicker: ngayTaoDenNgay"
                                                    class="form-control form-control-inline date-picker"
                                                    data-date-format="dd/mm/yyyy" type="text" value=""
                                                    maxlength="10"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2">
                                            <label><spring:message code="common.tracuu.ngay_cap_giay_phep_tu"/></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input
                                                    data-bind="datepicker: ngayCapTuNgay"
                                                    class="form-control form-control-inline date-picker"
                                                    data-date-format="dd/mm/yyyy" type="text" value=""
                                                    maxlength="10"/>
                                        </div>
                                        <div class="col-md-2">
                                            <label><spring:message code="common.tracuu.ngay_cap_giay_phep_den"/></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input
                                                    data-bind="datepicker: ngayCapDenNgay"
                                                    class="form-control form-control-inline date-picker"
                                                    data-date-format="dd/mm/yyyy" type="text" value=""
                                                    maxlength="10"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group" style="margin-top: 15px">
                                    <div class="col-md-12">
                                        <div class="col-md-2">
                                            <label><spring:message
                                                    code="common.tracuu.so_giay_phep"/></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input
                                                    data-bind="value : soCongVan"
                                                    class="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group nsw-text-center">
                                    <a href="javascript:;" class="btn green" id="searchHoSo"
                                       data-bind="click: searchHoSoClick"><i class="fa fa-search"></i> Tìm kiếm</a>
                                    <a href="/mard/01/create" class="btn green" id="btnAddNew"><i
                                            class="fa fa-edit"></i> Thêm mới</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-6"></div>
                            <div class="col col-md-12 nsw-text-right">
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
                        <table class="table table-striped table-bordered table-hover table-checkable order-column"
                               id="mard08Items">
                            <thead>
                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.STT"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.lich_su_tac_dong"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.ten_doanh_nghiep"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.ma_ho_so"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.so_giay_phep"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.ngay_gui_ho_so"/></th>
                                <%--                                <th class="text-center"><spring:message--%>
                                <%--                                        code="mard.01.table.col.ngay_kiem_dich"/></th>--%>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.trang_thai"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.xem"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.thong_bao_ap"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.thongbao_khongdat"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.xem_giay_phep"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.xin_sua"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.xin_rut"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.sua"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.01.table.col.xoa"/></th>
                            </tr>
                            </thead>
                            <tbody id="list-container" data-bind="foreach: Items">
                            <tr>
                                <td data-bind="text: $index() + 1">
                                </td>
                                <td class="text-center">
                                    <a class="fa fa-lg fa-history tooltips" href="javascript:void(0)"
                                       data-bind="click: $parent.showLSXL"></a>
                                </td>
                                <td data-bind="text: fiExporterNameVni">
                                </td>
                                <td class="text-center">
                                    <a data-bind="text : fiNSWFileCode, click: $parent.xemHoso"></a>
                                </td>
                                <td data-bind="text: fiLicenseNo">
                                </td>
                                <td class="text-center" data-bind="datetime: fiCreatedDate">
                                </td>
                                <%--                                <td class="text-center" data-bind="date: fiTimeQuarantine">--%>
                                <%--                                </td>--%>
                                <td class="text-center" data-bind="text: textStatus">
                                </td>
                                <td class="text-center">
                                    <a class="fa fa-eye" href="javascript:void(0)"
                                       data-bind="visible: isShowXemHS, click: $parent.showHoso"></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="fa fa-eye"
                                       data-bind="visible: isShowAP, click: $parent.showTBAP"></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="fa fa-eye"
                                       data-bind="visible: isShowTBKD, click: $parent.showThongBaoKhongDatYCXK"></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="fa fa-eye"
                                       data-bind="visible: isShowXemGP, click: $parent.showGP"></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="fa fa-edit"
                                       data-bind="visible: isShowXinsua, click: $parent.xinSuaHoso"></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="fa fa-download"
                                       data-bind="visible: isShowXinrut, click: $parent.xinRutHoso"></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="fa fa-edit"
                                       data-bind="visible: isShowSua, click: $parent.suaHoso"></a>
                                </td>
                                <td class="text-center">
                                    <a href="#" class="fa fa-close fa-lg" style="color:red"
                                       data-bind="visible: isShowXoa, click: $root.xoaHoso"></a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="row">
                            <div class="col col-md-6">
                            </div>
                            <div class="col col-md-12 nsw-text-right">
                                <div id="list-page" class="nsw-flr">
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
            </div>
        </div>
        <div id="modalXoaHoso" class="modal in modal-overflow" tabindex="-1"
             data-backdrop="static" data-keyboard="false"
             data-bind="with: xinXoaHoSoVM"
        >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <b class="modal-title"><spring:message code="mard.08.modal.notice"/></b>
            </div>
            <div class="modal-body">
                <div style="padding: 10px 0px;">
                    <span><spring:message code="mard.08.modal.xoa_hs"/> <strong
                            data-bind="text: fiHSCode"></strong>?</span>
                </div>
            </div>
            <div class="modal-footer">
                <div class="text-center">
                    <button class="btn green" data-bind="click: $root.deleteProfile">
                        <spring:message code="conmon.button.dong_y"/>
                    </button>
                    <button class="btn" data-dismiss="modal">
                        <spring:message code="conmon.button.huy"/>
                    </button>
                </div>
            </div>
        </div>
<%--        yêu cầu huỷ giấy chứng nhận--%>
        <div id="modalycsgcn" class="modal in modal-overflow" tabindex="-1"
             data-backdrop="static" data-keyboard="false"
                     data-bind="with: YeuCauSuaGCN"
        >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <b class="modal-title"><spring:message code="mard.01.modal.xin_sua_gcn"/></b>
            </div>
            <div class="modal-body">
                <div style="padding: 10px 0px;">
                    <%--                        <strong data-bind="text: fiHSCode"></strong>?--%>
                    <p><spring:message code="mard.01.modal.ngay_yeu_cau_sua_gcn"/><a class="nsw-require-field">*</a></p>
                    <input
                            data-bind="datepicker: fiRequestDate"
                            class="form-control"
                            id="fiRequestDate"
                            data-date-format="dd/mm/yyyy"
                            type="date"
                    disabled/>
                    <p class="nsw-require-field validate" id="fiRequestDate-validate"></p>
                    <p><spring:message code="mard.01.modal.ten_file_dinh_kem"/></p>
                    <input
                            class="form-control"
                            data-bind="value: fiFileName"
                    />
                    <p><spring:message code="mard.01.modal.file_dinh_kem"/></p>
                    <input
                            id="gcn_file_dinhkem"
                            type="file"
                            class="form-control"
                    />
                    <p><spring:message code="mard.01.modal.noi_dung"/><a class="nsw-require-field">*</a></p>
                    <textarea
                            class="form-control"
                            data-bind="value: fiReason"
                    >

                    </textarea>
                    <p class="nsw-require-field validate" id="fiReason-validate"></p>
                </div>
            </div>
            <div class="modal-footer">
                <div class="text-center">
                    <button class="btn green"
                            data-bind="click: sendYCSGCN"
                    >
                        <spring:message code="conmon.button.dong_y"/>
                    </button>
                    <button class="btn" data-dismiss="modal">
                        <spring:message code="conmon.button.huy"/>
                    </button>
                </div>
            </div>
        </div>
        <div id="modalychgcn" class="modal in modal-overflow" tabindex="-1"
             data-backdrop="static" data-keyboard="false"
                     data-bind="with: YeuCauHuyGCN"
        >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <b class="modal-title"><spring:message code="mard.01.modal.xin_huy_gcn"/></b>
            </div>
            <div class="modal-body">
                <div style="padding: 10px 0px;">
                    <p><spring:message code="mard.01.modal.noi_dung_huy"/><a class="nsw-require-field">*</a></p>
                    <textarea
                            class="form-control"
                            data-bind="value: fiReason"
                    >

                    </textarea>
                    <p class="nsw-require-field validate" id="fiReason-huy-validate"></p>
                </div>
            </div>
            <div class="modal-footer">
                <div class="text-center">
                    <button class="btn green"
                            data-bind="click: sendYCHGCN"
                    >
                        <spring:message code="conmon.button.dong_y"/>
                    </button>
                    <button class="btn" data-dismiss="modal">
                        <spring:message code="conmon.button.huy"/>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- ko with: showHoso01VM() -->
    <%@include file="inc_view_hoso.jsp" %>
    <!-- /ko -->

    <%@include file="inc_view_thongbaoapphi.jsp" %>
    <%@include file="inc_view_lichsuXuly.jsp" %>

    <!-- ko with: show13a() -->
    <%@include file="inc_view_gcn13a.jsp" %>
    <!-- /ko -->

    <!-- ko with: show13b() -->
    <%@include file="inc_view_gcn13b.jsp" %>
    <!-- /ko -->

    <!-- ko with: showGPChina() -->
    <%@include file="inc_view_gcn_china.jsp" %>
    <!-- /ko -->

    <!-- ko with: showGPHKGa() -->
    <%@include file="inc_view_gcn_hk_ga.jsp" %>
    <!-- /ko -->

    <!-- ko with: showGPHKLon() -->
    <%@include file="inc_view_gcn_hk_lon.jsp" %>
    <!-- /ko -->

    <!-- ko with: showGPMalay() -->
    <%@include file="inc_view_gcn_malay.jsp" %>
    <!-- /ko -->

    <!-- ko with: thongBaoKhongdatYCXK() -->
    <%@include file="inc_view_tb_khongdat_ycxk.jsp"%>
    <!-- /ko -->
</div>
<template id="cancel-template">
    <form role="form" class="form-horizontal" id="cancel-form">
        <div class="form-group">
            <div class="col-md-2">
                Nội dung đơn yêu cầu xin rút hồ sơ: <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10">
                <textarea rows="3" class="form-control" id="fiLydo" name="fiLydo" type="text" maxlength="2000"
                          data-bind="value: fiLydo"></textarea>
            </div>
        </div>
    </form>
</template>

