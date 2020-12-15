<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="incLanguage.jsp" %>
<%@include file="inc_script.jsp" %>
<%@include file="inc_view_lichsuXuly.jsp" %>
<div class="row" id="mard25">
    <div class="col-md-12">
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="mard.25.ten_thu_tuc"/></span>
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
                                                    <label>Mã hồ sơ</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control"
                                                           data-bind="value : fiHSCode, hasFocus: true"
                                                           type="text"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>Số giấy đăng ký</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control"
                                                           data-bind="value : fiSoXacNhanDon, hasFocus: true"
                                                           type="text"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" style="...">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label>Loại hồ sơ</label>
                                                </div>
                                                <div class="col-md-4">
<%--                                                    <input class="form-control"--%>
<%--                                                           data-bind="value : fiProName, hasFocus: true"--%>
<%--                                                           type="text"/>--%>
                                                    <select id="fiTrangthai" name="fiTrangthai" class="form-control select2"
                                                            data-bind="value : fiHSType, options : lstHoSoType, optionsValue : 'fiCatType',
                                                                                                             optionsCaption: 'Tất cả...', optionsText : 'fiCatTypeName'">
                                                    </select>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>Trạng thái hồ sơ</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="fiTrangthai" name="fiTrangthai" class="form-control select2"
                                                            data-bind="value : fiHSStatus, options : lstProfileStatus, optionsValue : 'fiCatType',
                                                             optionsCaption: 'Tất cả...', optionsText : 'fiCatTypeName'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label>Ngày tạo</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="row">
                                                        <div class="col-md-5 no-padding no-margin">
                                                            <input
                                                                    type="text"
                                                                    class="form-control form-control-inline date-picker"
                                                                    data-date-format="dd/mm/yyyy"
                                                                    data-bind="datepicker2: sentStartDate, datepickerOptions: { endDate: sentEndDate }"
                                                            />
                                                        </div>
                                                        <div class="col-md-2 no-padding no-margin" style="text-align: center;">-</div>
                                                        <div class="col-md-5 no-padding no-margin">
                                                            <input
                                                                    type="text"
                                                                    class="form-control form-control-inline date-picker"
                                                                    data-date-format="dd/mm/yyyy"
                                                                    data-bind="datepicker2: sentEndDate, datepickerOptions: { startDate: sentStartDate }"
                                                            />
                                                        </div>
                                                    </div>
                                                </div>

<%--                                                <div class="col-md-2">--%>
<%--                                                    <label>Nước sản xuất</label>--%>
<%--                                                </div>--%>
<%--                                                <div class="col-md-4">--%>
<%--                                                    <select id="fiCountry" name="fiCountry" class="form-control select2"--%>
<%--                                                            data-bind="value : fiCounttry, options : lstCountry, optionsValue : 'countryid', optionsCaption: 'Tất cả...', optionsText : 'countryname'">--%>
<%--                                                    </select>--%>
<%--                                                </div>--%>
                                            </div>
                                        </div>
<%--                                        <div class="form-group">--%>
<%--                                            <div class="col-md-12">--%>
<%--                                                <div class="col-md-2">--%>
<%--                                                    <label>Hãng sản xuất</label>--%>
<%--                                                </div>--%>
<%--                                                <div class="col-md-10">--%>
<%--                                                    <input class="form-control"--%>
<%--                                                           data-bind="value : fiHSCode, hasFocus: true"--%>
<%--                                                           type="text"/>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
                                        <div class="form-group nsw-text-center">
                                            <button class="btn green" id="searchHoSo"
                                                    data-bind="click: btnSearch"
                                            ><i class="fa fa-search"></i> Tìm kiếm
                                            </button>

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
                            <th class="text-center"> Ngày tạo</th>
                            <th class="text-center"> Số giấy đăng ký</th>
                            <th class="text-center"> Tên doanh nghiệp</th>
<%--                            <th class="text-center"> Hãng sản xuất</th>--%>
<%--                            <th class="text-center"> Nước sản xuất</th>--%>
                            <th class="text-center"> Trạng thái hồ sơ</th>
                            <th class="text-center"> Loại hình thức kiểm tra</th>
                            <th class="text-center"> Xem giấy đăng ký</th>
                            <th class="text-center"> Trạng thái XNCL hàng hóa</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: mard25Items">
                        <tr>
                            <td class="text-center" data-bind="text: $index() + 1"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="click: $root.showLSXL"><i
                                        class="fa fa-lg fa-history tooltips"></i></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"
                                   data-bind="click: $root.viewHoSo, text: fiNSWFileCode"></a>
                            </td>
                            <td class="text-center" data-bind="datetime: fiCreatedDate"></td>
                            <td class="text-center">
                                <span data-bind="text: fiSoXacNhanDon"></span>
                            </td>
                            <td class="text-center" data-bind="text: fiImporterName"></td>
<%--                            <td class="text-left" data-bind="text: fiProductList.fiProMadeIn"></td>--%>
<%--                            <td class="text-left" data-bind="text: fiProductList.fiProCountryName"></td>--%>
                            <td class="text-center" data-bind="text: $parent.getProfileStatus(fiHSStatus)"></td>
                            <td class="text-center" data-bind="text: $parent.getHoSoType(fiHSType)"></td>

                            <td class="text-center">
                                <div>
                                    <a href="javascript:void(0)" data-bind="click: $root.viewHoSo"><i
                                            class="fa fa-file-word-o"></i></a>
                                </div>
                            </td>
                            <td class="text-center">
                                <div data-bind="visible: fiHSStatus ==26">
                                    <a href="javascript:void(0)" data-bind="click: $root.viewHangHoaStatus"><i
                                            class="fa fa-eye-slash"></i></a>
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
    <div id="modal_view_chuyen" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false">
        <div class="modal-header" style="background: #337ab7; color: #fff;">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" data-bind="click: closeViewChuyen"></button>
        </div>
        <div class="modal-body">
            <div class="panel panel-primary" id="model-congvan">
                <ul class="nav nav-tabs ">
                    <li class="active">
                        <a href="#tab_tccd" data-toggle="tab"> <b><spring:message code="mard.25.tccd.panel_chuyen_title"/></b></a>
                    </li>
                    <li>
                        <a href="#tab_chitieu" data-toggle="tab"> <b><spring:message code="mard.25.tccd.panel_xem_title"/></b></a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active"id="tab_tccd">
                        <div class="row margin-bottom-15">
                            <div class="col-md-2 nsw-text-right">
                                <label><spring:message code="mard.25.tccd.panel_chuyen_ten_tccd"/><a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                               <select data-bind="options: lstDVXL,
                                                    optionsText: 'fiPUName',
                                                    optionsValue: 'fiPUCode',
                                                    selectedText: fiNameTCCD,
                                                    value: fiIdTCCD" class="form-control"></select>
                            </div>
                        </div>
                        <div class="row margin-bottom-15">
                            <div class="form-group nsw-text-center">
                                <button class="btn green"
                                        data-bind="click: chuyenChiTieu"
                                ><i class="fa fa-send"></i> <spring:message code="mard.25.tccd.panel_chuyen_btn"/>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab_chitieu">
                        <table class="table table-striped table-bordered table-hover order-column">
                            <thead>
                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                <th style="width: 3%" class="text-center"><spring:message code="mard.25.tccd.panel_xem_grid_stt"/></th>
                                <th class="text-center"><spring:message code="mard.25.tccd.panel_xem_grid_ten_tacn"/></th>
                                <th class="text-center"><spring:message code="mard.25.tccd.panel_xem_grid_chi_tieu"/></th>
                                <th class="text-center"><spring:message code="mard.25.tccd.panel_xem_grid_hinh_thuc"/></th>
                                <th class="text-center"><spring:message code="mard.25.tccd.panel_xem_grid_ham_luong"/></th>
                                <th class="text-center"><spring:message code="mard.25.tccd.panel_xem_grid_dvt"/></th>
                                <th class="text-center"><spring:message code="mard.25.tccd.panel_xem_grid_ghi_chu"/></th>

                            </tr>
                            </thead>
                            <tbody data-bind="foreach: filstChiTieu">
                            <tr>
                                <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                <td class="text-left" data-bind=""><label data-bind="text : fiTenHangHoa"/></td>
                                <td class="text-left" data-bind=""><label data-bind="text : fiTenChiTieu"/></td>
                                <td class="text-left" data-bind=""><label data-bind="text : fiHinhThucCB"/></td>
                                <td class="text-left" data-bind=""><label data-bind="text : fiHamLuong"/></td>
                                <td class="text-left" data-bind=""><label data-bind="text : fiTenDVT"/></td>
                                <td class="text-left" data-bind=""><label data-bind="text : fiGhiChu"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="modal_gui_bao_cao" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: guiBaoCaoHS2dVM">
        <div class="modal-header" style="background: #337ab7; color: #fff;">

            <b class="modal-title"><spring:message code="mard.25.tccd.bao_cao_title"/></b>
        </div>
        <div class="modal-body">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="form-group">
                        <div class="row form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.25.tccd.bao_cao_mahs"/><a  class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <label data-bind="text: fiHSCode"></label>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.25.tccd.bao_cao_ten_file"/><a  class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10">
                                <input class="form-control"
                                       data-bind="value: fiTenFile"
                                       type="text"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.25.tccd.bao_cao_file"/><a  class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10">
                                <input class="form-control" id="file-baocao"  type="file" data-bind="value: fiFile"/>
                            </div>
                        </div>
                        <div class="nsw-text-center form-group">
                            <button class="btn green"
                                    data-bind="click: themMoiFileBaoCao"
                            ><i class="fa fa-plus"></i><spring:message code="mard.25.tccd.bao_cao_btn"/></button>
                        </div>
                        <div class="row form-group">
                            <table class="table table-striped table-bordered table-hover order-column">
                                <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center"> <spring:message code="mard.25.tccd.bao_cao_stt"/></th>
                                    <th class="text-center"> <spring:message code="mard.25.tccd.bao_cao_ten_file"/>
                                    <th class="text-center"> <spring:message code="mard.25.tccd.bao_cao_file"/>
                                    <th class="text-center"> <spring:message code="mard.25.tccd.bao_cao_thao_tac"/></th>
                                </tr>
                                </thead>
                                <tbody data-bind="foreach: fiListAttach">
                                <tr>
									<td class="text-center" data-bind="text: $index()+1"></td>
									<td class="text-center" data-bind="text: fiFileHD"></td>
									<td class="text-center"> File </td>
									<td class="text-center">
										<a data-bind="click: $parent.onDeleteFile"><i class="fa fa-trash"></i></a>
									</td>
                                </tr>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn btn-primary" data-bind="click: guiBaoCao"><i class="fa fa-send"></i> <spring:message code="common.button.gui"/></button>
                <button class="btn btn-danger" data-bind="click: thoatOnClick"><i class="fa fa-sign-out"></i><spring:message code="common.button.thoat"/></button>
            </div>
        </div>
    </div>


    <div id="modal_xin_rut" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: xinRutHoSoVM">
        <div class="modal-header" style="background: #337ab7; color: #fff;">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.25.form.xinrut.title"/></b>
        </div>
        <div class="modal-body">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-2">
                                <label><spring:message code="mard.25.tccd.bao_cao_mahs"/><a  class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <label data-bind="text: fiNSWFileCode"></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2">
                                <label><spring:message code="mard.25.form.xinrut.lydo"/><a  class="nsw-require-field">*</a></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <textarea class="form-control" type="text" data-bind="trimedValue: fiReason"  rows="5"></textarea>
                            </div>
                        </div>
                    </div></div>
                        <div class="panel-body">
                        <div class="form-group">
                            <div class="tile-body"><b><u><spring:message code="mard.25.form.xinrut.tt"/></u></b></div>
                        <div class="row">
                            <div class="col-md-2">
                                <label><spring:message code="mard.25.form.xinrut.nguoiky"/><a  class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" type="text" data-bind="trimedValue: fiSigner"/>
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.25.form.xinrut.ngayky"/><a  class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <label data-bind="date: fiRequestedDate"></label>
                            </div>
                        </div>

                    </div>
                            <div class="modal-footer">
                                <div class="text-center">
                                    <button class="btn green" data-bind="click: $root.requestCancelProfile">
                                        <spring:message code="conmon.button.dong_y"/>
                                    </button>
                                    <button class="btn red" data-dismiss="modal">
                                        <spring:message code="conmon.button.huy"/>
                                    </button>
                                </div>
                            </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="inc_view_hoso.jsp" %>
</div>
<style>
    .content {
        text-indent: 5%;
    }
</style>
<script type="text/javascript" src="<c:url value='/app/mard/25/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/index.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/FormVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/LichSuXuLy.js?v=${version}'/>"></script>