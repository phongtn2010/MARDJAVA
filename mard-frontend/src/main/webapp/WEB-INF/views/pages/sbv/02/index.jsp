<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>
<div class="row" id="sbv02">
    <div class="col-md-12">
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="sbv.02.tenthutuc"/></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><spring:message
                                            code="common.tracuu.thong_tin_tim_kiem"/> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ma_ho_so"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control"
                                                           data-bind="value : fiHSCode, hasFocus: true"
                                                           type="text"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <label><spring:message
                                                            code="common.tracuu.trang_thai_ho_so"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="fiTrangthai" name="fiTrangthai" class="form-control select2"
                                                            data-bind="value : fiHSStatus, options : lstProfileStatus, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ngay_gui_tu"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: sentStartDate, datepickerOptions: { endDate: sentEndDate }"
                                                    />
                                                </div>

                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ngay_tao_den"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: sentEndDate, datepickerOptions: { startDate: sentStartDate }"
                                                    />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message
                                                            code="common.tracuu.ngay_cap_giay_phep_tu"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: licenseStartDate, datepickerOptions: { endDate: licenseEndDate }"
                                                    />
                                                </div>

                                                <div class="col-md-2">
                                                    <label><spring:message
                                                            code="common.tracuu.ngay_cap_giay_phep_den"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input
                                                            type="text"
                                                            class="form-control form-control-inline date-picker"
                                                            data-date-format="dd/mm/yyyy"
                                                            data-bind="datepicker2: licenseEndDate, datepickerOptions: { startDate: licenseStartDate }"
                                                    />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <button class="btn green" id="searchHoSo"
                                                    data-bind="click: btnSearch"
                                            ><i class="fa fa-search"></i> Tìm kiếm
                                            </button>
                                            <a href="/sbv/02/create" class="btn green" id="btnAddNew"><i
                                                    class="fa fa-edit"></i> Thêm mới</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col col-md-6">
                            <!-- ko with: pagination -->
                            <spring:message code="common.tong"/> <b data-bind="text: totalCount()"></b> <spring:message
                                code="common.pager.ban_ghi"/>
                            <!-- /ko -->
                        </div>
                        <div class="col col-md-6 nsw-text-right">
                            <div class="nsw-flr">
                                <!-- ko with: pagination -->
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
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> STT</th>
                            <th class="text-center"> Lịch sử tác động</th>
                            <th class="text-center"> Mã hồ sơ</th>
                            <th class="text-center"> Tên doanh nghiệp</th>
                            <th class="text-center"> Ngày gửi hồ sơ</th>
                            <th class="text-center"> Ngày tie</th>
                            <th class="text-center"> Trạng thái</th>
                            <th class="text-center"> Xem đơn khai báo</th>
                            <th class="text-center"> Xem giấy phép</th>
                            <th class="text-center"> Xin sửa</th>
                            <th class="text-center"> Xin rút</th>
                            <th class="text-center"> Sửa</th>
                            <th class="text-center"> Xóa</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: mard06Items">
                        <tr>
                            <td class="text-center" data-bind="text: $index() + 1"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="click: $root.viewLichSu"><i
                                        class="fa fa-lg fa-history tooltips"></i></a>
                            </td>
                            <td class="text-center" data-bind="text: fiImporterName"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)"
                                   data-bind="click: $root.goViewHoSo, text: fiNSWFileCode"></a>
                            </td>
                            <td class="text-center">
                                <span
                                        data-bind="text: fiCertNo"></span>
                            </td>
                            <td class="text-center" data-bind="datetime: fiCreatedDate"></td>
                            <td class="text-center" data-bind="text: $parent.getProfileStatus(fiHSStatus)"></td>
                            <td class="text-center">
                                <div>
                                    <a href="javascript:void(0)" data-bind="click: $root.viewHoSo"><i
                                            class="fa fa-eye"></i></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 14 || fiHSStatus == 15 || fiHSStatus == 16">
                                    <a href="javascript:void(0)" data-bind="click: $root.viewGiayPhep"><i
                                            class="fa fa-eye"></i></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 3 || fiHSStatus == 10 || fiHSStatus == 12 || fiHSStatus == 13 || fiHSStatus == 9">
                                    <a href="javascript:void(0)" data-bind="click: $root.goYCSHoSo"><i
                                            class="fa fa-edit"></i></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 3 || fiHSStatus == 1 || fiHSStatus == 7 || fiHSStatus == 9 || fiHSStatus == 10 || fiHSStatus == 12 || fiHSStatus == 13">
                                    <a href="javascript:void(0)" data-bind="click: $root.goYCRHoSo"><i
                                            class="fa fa-download"></i></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 0 || fiHSStatus == 1 || fiHSStatus ==7">
                                    <a href="javascript:void(0)" data-bind="click: $root.goEditHoSo"><i
                                            class="fa fa-edit" src="" alt=""></i></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus == 0 || fiHSStatus == 2">
                                    <a href="javascript:void(0)" data-bind="click: $root.deleteHoso"><i
                                            class="fa fa-lg fa-close" style="color: red"></i></a>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col col-md-6">
                            <!-- ko with: pagination -->
                            <spring:message code="common.tong"/> <b data-bind="text: totalCount()"></b> <spring:message
                                code="common.pager.ban_ghi"/>
                            <!-- /ko -->
                        </div>
                        <div class="col col-md-6 nsw-text-right">
                            <div class="nsw-flr">
                                <!-- ko with: pagination -->
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
</div>
<style>
    .content {
        text-indent: 5%;
    }
</style>

<script type="text/javascript" src="<c:url value='/app/sbv/02/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/sbv/02/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/sbv/02/index.js?v=${version}'/>"></script>


