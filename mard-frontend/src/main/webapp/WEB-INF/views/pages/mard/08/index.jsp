<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="inc_script.jsp" %>
<%@include file="xemGCN.jsp"%>
<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<div class="row" id="mard08">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
<%--                    <i class="icon-settings font-dark"></i>--%>
                    <span class="caption-subject bold uppercase"> <spring:message code="mard.08.ten_thu_tuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><spring:message code="common.tracuu.thong_tin_tim_kiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ma_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="fiMaHoso" id="fiMaHoso" data-bind="value : fiMaHoso, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" type="text"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.trang_thai_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="fiTrangthai" name="fiTrangthai" class="form-control select2"
                                                            data-bind="value : fiTrangthai, options : lstProfileStatus, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_gui_tu" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: fromFiNgaygui, datepickerOptions: { endDate: toFiNgaygui }"
                                                    />
                                                </div>

                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_den" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: toFiNgaygui, datepickerOptions: { startDate: fromFiNgaygui }"
                                                    />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_cap_giay_phep_tu" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: fromFiNgayCp, datepickerOptions: { endDate: toFiNgayCp }"
                                                    />
                                                </div>

                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_cap_giay_phep_den" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: toFiNgayCp, datepickerOptions: { startDate: fromFiNgayCp }"
                                                    />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label >Số giấy phép</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            data-bind="value: fiSoGiayphep"
                                                            name="fiSoGiayphep" id="fiSoGiayphep" class="form-control form-control-inline"  type="text" value=""  />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <button class="btn green" id="searchHoSo" data-bind="click: searchFieldEnter"><i class="fa fa-search"></i> Tìm kiếm</button>
                                            <a href="/mard/08/create" class="btn green" id="btnAddNew" ><i class="fa fa-edit"></i> Thêm mới</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-6">
                        <spring:message code="common.tong" /> <b data-bind="text: totalCount"></b> <spring:message code="common.pager.ban_ghi" />
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
                <table class="table table-striped table-bordered table-hover order-column" id="mard08Items">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"> STT</th>
                        <th class="text-center"> Lịch sử tác động </th>
                        <th class="text-center"> Tên doanh nghiệp </th>
                        <th class="text-center"> Mã hồ sơ </th>
                        <th class="text-center"> Số giấy phép </th>
                        <th class="text-center"> Ngày gửi hồ sơ </th>
                        <th class="text-center"> Trạng thái </th>
                        <th class="text-center"> Xem đơn khai báo </th>
                        <th class="text-center"> Xem giấy phép </th>
                        <th class="text-center"> Xin sửa </th>
                        <th class="text-center"> Xin rút </th>
                        <th class="text-center"> Sửa </th>
                        <th class="text-center"> Xóa </th>
                    </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemsmard08Tmpl', foreach: mard08Items }">
                    </tbody>
                    <script id="itemsmard08Tmpl" type="text/html">
                        <tr>
                            <td data-bind="text : (($root.paging().currentPage() - 1) * $root.paging().pageSize() + 1 + $index())">
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-history tooltips" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center" data-bind="text : fiImporterName">
                            </td>
                            <td>
                                <a href="javascript:void(0)" data-bind="click: $root.goViewHoSo, text: fiHSCode"></a>
                            </td>
                            <td data-bind="text : fiLicenseNo">

                            </td>
                            <td class="text-center" data-bind="datetime : fiCreatedDate">
                            </td>
                            <td class="text-center" data-bind="text : $parent.getProfileStatus(fiHSStatus)">
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-eye" data-bind="visible: true, click: $parent.bXemHoSo" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 14 || fiHSStatus == 15 || fiHSStatus == 16">
                                    <a href="javascript:void(0)"><i class="fa fa-eye" data-bind="visible: true, click: $parent.viewGiayPhep" src="" alt=""/></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 3 || fiHSStatus == 9 || fiHSStatus == 13 || fiHSStatus == 10">
                                    <a href="#" data-bind="click: $root.goYCSHoSo"><i class="fa fa-lg fa-edit" src="" alt=""/></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 3 || fiHSStatus == 7 || fiHSStatus == 13 || fiHSStatus == 1 || fiHSStatus == 9 || fiHSStatus == 10">
                                    <a href="#" data-bind="click: $root.ycXinRutHoSo"><i class="fa fa-download" src="" alt=""/></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 1 || fiHSStatus == 7 || fiHSStatus == 0">
                                    <a href="#" data-bind="click: $root.goEditHoSo"><i class="fa fa-lg fa-edit" src="" alt=""/></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 0">
                                    <a href="#" data-bind="click: $root.xoaHoso"><i class="fa fa-lg fa-close" style="color: red" src="" alt=""/></a>
                                </div>
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
    </div>
    <%@include file="inc_view_lichsuXuly.jsp"%>
    <%@include file="inc_view_hoso.jsp"%>
    <%@include file="inc_view_cert.jsp"%>
    <!-- xin rut modal -->
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
            <div data-bind="visible: fiHSStatus() == 1" style="padding-top: 15px;"></div>
            <form role="form" class="form-horizontal" data-bind="visible: fiHSStatus() != 1">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label><spring:message code="mard.08.tokhai.ngay_yc_xin_rut"/></label>
                        </div>
                        <div class="col-md-8">
                            <input
                                    data-bind="datepicker: fiRequestedDate"
                                    class="form-control form-control-inline date-picker"
                                    data-date-format="dd/mm/yyyy" type="text" value=""
                                    maxlength="10" disabled/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label><spring:message code="mard.08.tokhai.noi_dung_xin_rut"/> <a
                                    class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-8">
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
                <button class="btn green" data-bind="click: $parent.requestCancelProfile">
                    <spring:message code="conmon.button.dong_y"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- modal xoa ho so -->
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
                <span><spring:message code="mard.08.modal.xoa_hs"/> <strong data-bind="text: fiHSCode"></strong>?</span>
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
    <div id="modalError" class="modal in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.modal.notice"/></b>
        </div>
        <div class="modal-body">
            <span><spring:message code="mard.08.modal.error"/></span>
        </div>
        <div class="modal-footer">
            <div class="text-center">
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.dong"/>
                </button>
            </div>
        </div>
    </div>
    <div id="modalSuccess" class="modal in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.modal.notice"/></b>
        </div>
        <div class="modal-body">
            <span><spring:message code="mard.08.modal.success"/></span>
        </div>
        <div class="modal-footer">
            <div class="text-center">
                <button class="btn green" data-dismiss="modal">
                    <spring:message code="conmon.button.dong"/>
                </button>
            </div>
        </div>
    </div>
    <div id="modalDeleteSuccess" class="modal in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.modal.notice"/></b>
        </div>
        <div class="modal-body">
            <span><spring:message code="mard.08.modal.success"/></span>
        </div>
        <div class="modal-footer">
            <div class="text-center">
                <button class="btn green" data-dismiss="modal">
                    <spring:message code="conmon.button.dong"/>
                </button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value='/app/mard/08/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/model.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/index.js?v=${version}' />"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/KiemDichNhapKhauVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/KiemTraChatLuongVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/KyHoSoVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/ThongTinChungVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/FormVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/ViewVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/LichSuXuLy.js?v=${version}'/>"></script>
