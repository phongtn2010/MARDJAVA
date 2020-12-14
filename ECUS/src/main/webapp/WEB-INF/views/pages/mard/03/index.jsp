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
                    <span class="caption-subject bold uppercase">
                        <spring:message code="mard.03.tenthutuc"/>
                    </span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i
                                            class="fa fa-gift"></i> <spring:message code="mard.03.hoso.tracuu.timkiem"/> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchFormMic">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-left">
                                                    <label><spring:message code="mard.03.hoso.tracuu.mahoso"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo"
                                                           data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'"
                                                           placeholder="<spring:message code="common.tracuu.ma_ho_so" />"
                                                           type="text" maxlength="12"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-left">
                                                    <label><spring:message
                                                            code="mard.03.hoso.tracuu.trangthaihoso"/></label>
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
                                                <div class="col-md-2 nsw-text-left">
                                                    <label><spring:message
                                                            code="mard.03.hoso.tracuu.ngaynoptu"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="input-group">
                                                        <input name="ngayGuiTuNgay" id="ngayGuiTuNgay"
                                                               data-bind="datepicker : ngayGuiTuNgay"
                                                               class="form-control form-control-inline date-picker"
                                                               data-date-format="dd/mm/yyyy" type="text" value=""
                                                               maxlength="10" placeholder="dd/mm/yyyy" readonly
                                                               style="background: transparent !important"/>
                                                        <a class="input-group-addon"
                                                           style="background: #fff !important;"
                                                           href="javascript:void(0)"
                                                           data-bind="event : {click : clearfiNgayGuiTu}">
                                                            <i class="fa fa-close"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col-md-2 nsw-text-left">
                                                    <label><spring:message
                                                            code="mard.03.hoso.tracuu.ngaynopden"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="input-group">
                                                        <input name="ngayGuiDenNgay" id="ngayGuiDenNgay"
                                                               data-bind="datepicker : ngayGuiDenNgay"
                                                               class="form-control form-control-inline date-picker"
                                                               data-date-format="dd/mm/yyyy" type="text" value=""
                                                               maxlength="10" placeholder="dd/mm/yyyy" readonly
                                                               style="background: transparent !important"/>
                                                        <a class="input-group-addon"
                                                           style="background: #fff !important;"
                                                           href="javascript:void(0)"
                                                           data-bind="event : {click : clearfiNgayGuiDen}">
                                                            <i class="fa fa-close"></i>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-left">
                                                    <label><spring:message
                                                            code="mard.03.hoso.tracuu.hanghoa"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="tenHangHoa" id="tenHangHoa"
                                                           placeholder="Số tiếp nhận" data-bind="value : tenHangHoa"
                                                           type="text" maxlength="50"/>
                                                </div>

                                                <div class="col-md-2 nsw-text-left">
                                                    <label><spring:message
                                                            code="mard.03.hoso.tracuu.dvthuchien"/></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select class="form-control select2" id="maCqKiemtra"
                                                            name="maCqKiemtra"
                                                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                                                        , value : toChucKiemTra
                                                        , options : fiCQKTList
                                                        , optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSoClick"
                                               data-bind="click: searchHoSoClick"><i
                                                    class="fa fa-search"></i> <spring:message
                                                    code="mard.03.hoso.timkiem"/></a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-6">
                        <spring:message code="mard.03.hoso.tracuu.ketquatimkiem"/>
                        <b> <a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a>
                        </b><spring:message code="common.pager.ban_ghi"/>
                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager" class="nsw-flr">
                            <!-- ko with:paging()-->
                            <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !firstPageActive() }">
                                    <a data-bind="click: goToFirst"><spring:message code="mard.03.hoso.trangdau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !previousPageActive() }">
                                    <a data-bind="click: goToPrevious"><spring:message
                                            code="mard.03.hoso.trangtruoc"/></a>
                                </li>
                                <!-- ko foreach: getPages() -->
                                <li data-bind="css: { active: $parent.currentPage() === $data }">
                                    <a data-bind="click: $parent.goToPage, text: $data"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !nextPageActive() }">
                                    <a data-bind="click: goToNext"><spring:message code="mard.03.hoso.trangsau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !lastPageActive() }">
                                    <a data-bind="click: goToLast"><spring:message code="mard.03.hoso.trangcuoi"/></a>
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
                                code="mard.03.hoso.danhsach.stt"/></th>
                        <th class="text-center" style="width: 3%;vertical-align: middle;"><spring:message
                                code="mard.03.hoso.danhsach.lichsuxuly"/></th>
                        <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                                code="mard.03.hoso.danhsach.mahoso"/></th>
                        <th class="text-center" style="width: 15%;vertical-align: middle;"><spring:message
                                code="mard.03.hoso.danhsach.cqxl"/></th>
                        <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                                code="mard.03.hoso.danhsach.trangthai"/></th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                                code="mard.03.hoso.danhsach.ngaygui"/></th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                                code="mard.03.hoso.danhsach.giaychungnhan"/></th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;">Đơn khai báo kiểm dịch</th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;">Xin chuyển cửa khẩu</th>
                        <th class="text-center" style="width: 5%;vertical-align: middle;">Công văn chuyển cửa khẩu</th>
                    </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT" style="vertical-align: middle;"></td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-history"
                                                                data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"
                                   data-bind="text : fiMaHoSo, click: $parent.bXemClick.bind($parent)"></a>
                            </td>
                            <td class="text-left" data-bind="text : fiTenCQ" style="vertical-align: middle;"></td>
                            <td class="text-left" style="vertical-align: middle;">
                                <a href="javascript:void(0)"
                                   data-bind="text : fiTrangThai, click: $parent.bTrangthaiClick.bind($parent)"></a>
                            </td>
                            <td class="text-center" data-bind="text : sendDateText"
                                style="vertical-align: middle;"></td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-file-pdf-o tooltips"
                                                                data-original-title="Xem xác nhận chất lượng"
                                                                data-bind="visible: bGiayCnhan, click: $parent.bGiayChungnhanlick.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-eye tooltips"
                                                                data-original-title="Xem đơn khai báo kiểm dịch"
                                                                data-bind="visible: bDonkhaibao, click: $parent.bXemDonkhaibao.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-send tooltips"
                                                                data-original-title="Chuyển cửa khẩu xuất"
                                                                data-bind="visible: bChuyenCkhau, click: $parent.bChuyenCkXuat.bind($parent)"
                                                                src="" alt=""/></a>
                            </td>
                            <td class="text-center" style="vertical-align: middle;">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-file tooltips"
                                                                data-original-title="Công văn chuyển cửa khẩu"
                                                                data-bind="visible: bCvChuyenCk, click: $parent.bCVChuyenCkClick.bind($parent)"
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
                                        <spring:message code="mard.03.hoso.trangdau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !previousPageActive() }">
                                    <a data-bind="click: goToPrevious">
                                        <spring:message code="mard.03.hoso.trangtruoc"/></a>
                                </li>
                                <!-- ko foreach: getPages() -->
                                <li data-bind="css: { active: $parent.currentPage() === $data }">
                                    <a data-bind="click: $parent.goToPage, text: $data"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !nextPageActive() }">
                                    <a data-bind="click: goToNext">
                                        <spring:message code="mard.03.hoso.trangsau"/></a>
                                </li>
                                <li data-bind="css: { disabled: !lastPageActive() }">
                                    <a data-bind="click: goToLast">
                                        <spring:message code="mard.03.hoso.trangcuoi"/></a>
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
<script src="<c:url value='/app/mard/03/model.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/mard/03/index.js?v=${version}'/>" type="text/javascript"></script>

<template id="confirm-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" id="xoahoso-form">
            <div class="col-md-12">
                <span data-bind="text: fiMsg"></span><b data-bind="text: nswfileCode"></b>
            </div>
        </form>
    </div>
</template>
<template id="ruthoso-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="ruthoso-form" id="ruthoso-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></label> <b data-bind="text: fiMaHoso"></b></p>
            </div>
            <div class="col-md-12"
                 data-bind="style: { display: ( fiMaTrangThai() !== 1  && fiMaTrangThai() !== 3) ? '' : 'none' }">
                <div class="col-md-2">
                    <label><spring:message code="common.msg.ly_do"/></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-10">
                        <textarea name="Reason" onblur="this.value = removeSpaces(this.value);" id="fiNoidungYc"
                                  data-bind="value: fiNoidungYc" require="true"
                                  placeholder="<spring:message code="common.msg.ly_do" />"
                                  style="width: 90%; height: 150px;resize: none;overflow-x: hidden;"
                                  maxlength="500"></textarea>
                </div>
            </div>
        </form>
    </div>
</template>
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
                            <a data-bind="click: goToFirst"> <spring:message code="mard.03.hoso.trangdau"/>
                            </a>
                        </li>
                        <li data-bind="css: { disabled: !previousPageActive() }">
                            <a data-bind="click: goToPrevious">
                                <spring:message code="mard.03.hoso.trangtruoc"/></a>
                        </li>
                        <!-- ko foreach: getPages() -->
                        <li data-bind="css: { active: $parent.currentPage() === $data }">
                            <a data-bind="click: $parent.goToPage, text: $data"></a>
                        </li>
                        <!-- /ko -->
                        <li data-bind="css: { disabled: !nextPageActive() }">
                            <a data-bind="click: goToNext"><spring:message code="mard.03.hoso.trangsau"/>
                            </a>
                        </li>
                        <li data-bind="css: { disabled: !lastPageActive() }">
                            <a data-bind="click: goToLast"><spring:message code="mard.03.hoso.trangcuoi"/></a>
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
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.thoigian"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.noidung"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.trangthaihoso"/></b></th>
                <th style="text-align: center;"><b><spring:message code="mard.04.hoso.lichsu.link"/></b></th>
            </tr>
            </thead>
            <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
            </tbody>
            <script id="historyItemTmpl" type="text/html">
                <tr>
                    <td data-bind="text : STT"></td>
                    <td class="text-left" style="max-width: 220px;vertical-align: middle;word-wrap: break-word;"
                        data-bind="text : fiDonviXuly"></td>
                    <td class="text-left" style="max-width: 220px;vertical-align: middle;word-wrap: break-word;"
                        data-bind="text : fiNguoiXuly"></td>
                    <td class="text-center" style="max-width: 220px;vertical-align: middle;word-wrap: break-word;"
                        data-bind="text : fiNgaytao"></td>
                    <td class="text-left" style="max-width: 220px;vertical-align: middle;word-wrap: break-word;"
                        data-bind="text : fiNoidung"></td>
                    <td class="text-left" style="width: 15%;" data-bind="text : fiTenTrangthai"></td>
                    <td class="text-left" style="width: 20%;">
                        <a target="_blank"
                           data-bind="visible: true, attr: { href: fiLinkDowload, title: fiLinkDowload }"><p
                                data-bind="text : fiLinkDowload"></p></a>
                    </td>
                </tr>
            </script>
        </table>
    </form>
</template>

<%--form thong bao ap phi--%>
<template id="thongtinapphi-template">
    <form role="form" class="form-horizontal" id="thongtinapphi-form">
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
                    <label>Số tiền cần nộp: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiTongSotien"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Bằng chữ: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiTongTienBangchu"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Chú thích: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiChuthich"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
        </div>
    </form>
</template>
<%--end form thong bao ap phi--%>

<%--form thong bao xac nhan phi--%>
<template id="thongbaoXnPhi-template">
    <form role="form" class="form-horizontal" id="thongbaoXnPhi-form">
        <u><b>Thông báo áp phí</b></u>
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
                    <label>Tổng: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiTongsoTienTt"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Bằng chữ: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiTongtienChu"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
        </div>
        <u><b>Thông tin thanh toán</b></u>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Hình thức: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiTenLoaiTt"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Người nộp: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNguoiNopphi"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Ngày nộp: </label>
                </div>
                <div class="col-md-8" data-bind="date : fiNgayNopphi"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Số hóa đơn: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiSoHoadon"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Nội dung: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNoidung"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
        </div>
    </form>
</template>
<%--end form thong bao xac nhan phi--%>

<%--form lo hang can xu ly--%>
<template id="lohangxl-template">
    <form role="form" class="form-horizontal" id="lohangxl-form">
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
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Nội dung xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNoidungXl"
                     style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;">
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Tên tệp tin: </label>
                </div>
                <a class="col-md-8" href="javascript:void(0)"
                   style="width: 400px;text-align: left;word-wrap: break-word;max-width: 400px !important;vertical-align: middle;"
                   data-bind="text : fiTenTeptin"></a>
            </div>
        </div>
    </form>
</template>
<%--end form lo hang can xu ly--%>