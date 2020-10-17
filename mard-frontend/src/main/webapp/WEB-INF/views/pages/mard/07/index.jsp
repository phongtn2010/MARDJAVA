<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="incLanguage.jsp"%>
<%@include file="inc_script.jsp" %>
<div class="row" id="mard07">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"><span
                            class="caption-subject bold uppercase"> <spring:message code="mard.07.ten_thu_tuc"/></span></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><spring:message code="mard.tracuu.timkiem"/> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.mahoso"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo"
                                                           data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'"
                                                           type="text"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.sovannban"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="soCongVan" id="soCongVan"
                                                           data-bind="value : soCongVan, executeOnEnter : searchFieldEnter, valueUpdate: 'input'"
                                                           type="text">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.trangthaikd"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSoDVKD" name="trangThaiHoSo"
                                                            class="form-control select2"
                                                            data-bind="value : trangThaiKD, options : fiTrangthaiList, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.trangthaigs"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSoDVGS" name="trangThaiHoSo"
                                                            class="form-control select2"
                                                            data-bind="value : trangThaiGS, options : fiTrangthaiList, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.cqkd"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="cqkd"
                                                            class="form-control select2"
                                                            data-bind="value : fiDepartmentofMonitorCode, options : fiListCoquan, optionsValue : 'fiPUCode', optionsCaption: 'Tất cả...', optionsText : 'fiPUDesc'"
                                                    >
                                                    </select>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.cqgs"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="cqgs"
                                                            class="form-control select2"
                                                            data-bind="value : fiDepartmentofQuarantineCode, options : fiListCoquan, optionsValue : 'fiPUCode', optionsCaption: 'Tất cả...', optionsText : 'fiPUDesc'"
                                                    >
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.ngayguitu"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: ngayTaoTuNgay, datepickerOptions: { endDate: ngayTaoDenNgay }"
                                                    />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.ngayguiden"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: ngayTaoDenNgay, datepickerOptions: { startDate: ngayTaoTuNgay }"
                                                    />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.ngaycaptu"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: ngayCapTuNgay, datepickerOptions: { endDate: ngayCapDenNgay }"
                                                    />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.07.tracuu.ngaycapden"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: ngayCapDenNgay, datepickerOptions: { startDate: ngayCapTuNgay }"
                                                    />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo"
                                               data-bind="click: searchHoSoClick"><i class="fa fa-search"></i> Tìm kiếm</a>
                                            <a href="/mard/07/create" class="btn green" id="btnAddNew"><i
                                                    class="fa fa-edit"></i> Thêm mới</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-6">
                        <spring:message code="common.tong"/> <b><a id="lbTotalRecords" data-bind="text: totalCount"
                                                                   href="javascript:void(0);"></a> </b><spring:message
                            code="common.pager.ban_ghi"/>
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
                <table class="table table-striped table-bordered table-hover table-checkable order-column"
                       id="monre06Items">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.stt"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.lichsuxuly"/></th>
                        <th class="text-center" width="25%"><spring:message
                                code="mard.07.danhsach.tendoanhnghiep"/></th>
                        <th class="text-center" width="10%"><spring:message code="mard.07.danhsach.mahoso"/></th>
                        <th class="text-center" width="10%"><spring:message code="mard.07.danhsach.sogiayphep"/></th>
                        <th class="text-center" width="7%"><spring:message code="mard.07.danhsach.ngaygui"/></th>
                        <th class="text-center" width="20%"><spring:message
                                code="mard.07.danhsach.trangthaidonvikiemdich"/></th>
                        <th class="text-center" width="20%"><spring:message
                                code="mard.07.danhsach.trangthaidonvigiamsat"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.xem"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.thongbaoapphi"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.xemgiayphep"/></th>
                        <th class="text-center" width="5%"><spring:message
                                code="mard.07.danhsach.thongbaolohangkhongdat"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.xinsua"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.xinrut"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.sua"/></th>
                        <th class="text-center" width="5%"><spring:message code="mard.07.danhsach.xoa"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstHoso">
                    <tr>
                        <td data-bind="text: (($root.paging().currentPage() - 1) * $root.paging().pageSize() + 1 + $index())"></td>
                        <td>
                            <a href="javascript:void(0)" data-bind="click: $parent.xemLichsu"><i class="fa fa-lg fa-history tooltips"></i></a>
                        </td>
                        <td data-bind="text: fiNameOfRegistration"></td>
                        <td>
                            <a href="javascript:void(0)" data-bind="click: $root.goViewHoSo, text: fiNSWFileCode"></a>
                        </td>
                        <td class="text-center">
                                <span
                                        data-bind="text: fiCertNo"></span>
                        </td>
                        <td data-bind="datetime: fiCreatedDate"></td>
                        <td data-bind="text: $root.getProfileStatus(fiKDStatus)"></td>
                        <td data-bind="text: $root.getProfileStatus(fiGSStatus)"></td>
                        <td>
                            <a href="javascript:void(0)" data-bind="click: $root.viewDonDK"><i class="fa fa-eye"></i></a>
                        </td>
                        <td>
                            <a href="javascript:void(0)" data-bind="visible: isShowApphi, click: $parent.xemTBApphi"><i class="fa fa-eye"></i></a>
                        </td>
                        <td>
                            <div data-bind="visible: fiGSStatus == 14 || fiGSStatus == 15 || fiKDStatus == 14 || fiKDStatus == 15">
                                <a href="javascript:void(0)" data-bind="click: $root.viewLstGiayPhep"><i class="fa fa-eye"></i></a>
                            </div>
                        </td>
                        <td>
                            <div
                                    data-bind="visible: fiGSStatus == 16 || fiKDStatus == 16"
                            >
                            <a href="javascript:void(0)" data-bind="click: $root.viewLHKD"><i class="fa fa-eye"></i></a>
                            </div>
                        </td>
                        <td class="text-center">
                            <div data-bind="visible: fiGSStatus == 3 || fiGSStatus == 9 || fiGSStatus == 10 || fiGSStatus == 13 || fiGSStatus == 17 || fiKDStatus == 3 || fiKDStatus == 9 || fiKDStatus == 10 || fiKDStatus == 13 || fiKDStatus == 17">
                                <a href="javascript:void(0)" data-bind="click: $root.goYCSHoSo"><i class="fa fa-edit"></i></a>
                            </div>
                        </td>
                        <td class="text-center">
                            <div data-bind="visible: fiGSStatus == 1 || fiGSStatus == 3 || fiGSStatus == 7 || fiGSStatus == 9 || fiGSStatus == 10 || fiGSStatus == 13 || fiGSStatus == 17 || fiKDStatus == 1 || fiKDStatus == 3 || fiKDStatus == 7 || fiKDStatus == 9 || fiKDStatus == 10 || fiKDStatus == 13 || fiKDStatus == 17">
                                <a href="javascript:void(0)" data-bind="click: $root.goYCRHoSo"><i class="fa fa-download"></i></a>
                            </div>
                        </td>
                        <td class="text-center">
                            <div data-bind="visible: fiGSStatus == 0 || fiGSStatus == 1 || fiGSStatus == 7 || fiKDStatus == 0 || fiKDStatus == 1 || fiKDStatus == 7">
                            <a href="javascript:void(0)" data-bind="click: $root.goEditHoSo"><i class="fa fa-edit"></i></a>
                            </div>
                        </td>
                        <td class="text-center">
                            <div data-bind="visible: fiGSStatus == 0 || fiKDStatus == 0">
                            <a href="javascript:void(0)" data-bind="click: $root.deleteHoso"><i class="fa fa-lg fa-close" style="color: red"></i></a>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col col-md-6">
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
            </div>
        </div>
    </div>
    <!-- xin rut modal -->
    <div id="modalXinRut" class="modal in modal-overflow container" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: xinRutHoSoVM">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.modal.notice"/></b>
        </div>
        <div class="modal-body">
            <div class="col-md-12" style="padding-bottom: 15px; padding-top: 10px;">
                <p><strong><spring:message code="mard.08.modal.xin_rut"/> <span data-bind="text: fiNSWFileCode"></span>?</strong></p>
            </div>
            <div data-bind="visible: fiGSStatus() == 1 || fiKDStatus() == 1" style="padding-top: 15px;"></div>
            <form role="form" class="form-horizontal" data-bind="visible: fiGSStatus() != 1 && fiKDStatus() != 1">
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
                <button class="btn green" data-bind="click: $root.requestCancelProfile">
                    <spring:message code="conmon.button.dong_y"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <%@include file="inc_view_giayphep.jsp"%>
    <%@include file="inc_view_cnkd.jsp"%>
    <%@include file="inc_view_cnvc.jsp"%>
    <%@include file="inc_view_thongbaoapphi.jsp"%>
    <%@include file="inc_view_lichsuXuly.jsp"%>
    <%@include file="inc_view_hoso.jsp"%>
    <%@include file="inc_view_lohangkhongdat.jsp"%>
</div>
<script type="text/javascript" src="<c:url value='/app/mard/07/init.js?v=${version}'/>"></script>
<script src="<c:url value='/app/mard/07/index.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/mard/07/FormVM.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/mard/07/LichSuXuLy.js?v=${version}' />" type="text/javascript"></script>
<style>
    .content {
        text-indent: 5%;
    }
</style>
