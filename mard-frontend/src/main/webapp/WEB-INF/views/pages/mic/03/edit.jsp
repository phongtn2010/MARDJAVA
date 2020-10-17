<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="incLanguage.jsp" %>
<form id="form">
    <div class="row">
        <div class="col-md-12">
            <div class="portlet light ">
                <div class="portlet-title">
                    <div class="caption font-dark">
                        <i class="icon-settings font-dark"></i> <span
                            class="caption-subject bold uppercase"><b data-bind="i18n: { 'html': 'nhomThuTuc' }"></b></span>
                    </div>
                </div>

                <div class="portlet-body" id="table-search">
                    <div class="table-toolbar">
                        <div id="ThongTinChungViewModel">
                            <div class="row">
                                <div class="col-md-12" data-bind="visible: action == 2">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <span class="caption-subject bold uppercase"><b data-bind="i18n: { 'html': 'thongTinChung' }"></b> </span>
                                        </div>
                                        <div class="panel-body">
                                            <div class="col-md-12">
                                                <div class="row form-group">
                                                    <label class="col-md-1"><b data-bind="i18n: { 'html': 'thongTinHS' }"></b><span
                                                            class="nsw-require-field">*</span></label>
                                                    <div class="col-md-11">
                                                        <input id="fiReasonCorrection" class="form-control"
                                                               placeholder="" />"
                                                               data-bind="value: tbdHoSo14.fiReasonCorrection">
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <span class="caption-subject bold uppercase"><b data-bind="i18n: { 'html': 'thongTinHS' }"></b> </span>
                                        </div>
                                        <div class="panel-body">
                                            <jsp:include page="thong_tin_ho_so.jsp"></jsp:include>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <span class="caption-subject bold uppercase"><b data-bind="i18n: { 'html': 'thongTinChung' }"></b> </span>
                                        </div>
                                        <div class="panel-body">
                                            <jsp:include page="thong_tin_chung.jsp"></jsp:include>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <span class="caption-subject bold uppercase"><b data-bind="i18n: { 'html': 'danhSachTB' }"></b> </span>
                                            <c:if test="${isView == false}">
                                                    <a
                                                       class="btn green bt-center"
                                                       data-bind="click: $root.addNew, i18n: {  title: { key: 'TbdThietBi03.themMoi'}}"> <i class="fa fa-plus ic-plus" aria-hidden="true"></i>
                                                    </a>
                                            </c:if>
                                        </div>
                                        <div class="panel-body" id="">
                                            <jsp:include page="thong_tin_thietbi.jsp"></jsp:include>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default" >
                                    <div class="panel-heading">
                                        <span class="caption-subject bold uppercase"><b data-bind="i18n: { 'html': 'danhSachTaiLieu' }"></b></span>
                                    </div>
                                    <div class="panel-body" id="ThongTinTepDinhKemViewModel">
                                        <jsp:include page="upload_file.jsp"></jsp:include>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <span class="caption-subject bold uppercase"><b data-bind="i18n: { 'html': 'thongTinKy' }"></b> </span>
                                    </div>
                                    <div class="panel-body" id="ThongTinKyViewModel">
                                        <jsp:include page="thong_tin_ky.jsp"></jsp:include>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>


                    <div class="row table-responsive" id="GhiHoSoViewModel">
                        <div class="col-md-12" align="center">
                            <c:if test="${isView == false}">
                                <button type="button" class="btn green"
                                        data-bind="click: $root.ghiLai" id="btghiLai">
                                    <i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;
                                    <span data-bind="i18n: { 'html': 'btSave' }"></span>
                                </button>
                                <button type="button" class="btn green" id="btGuiHoSo"
                                        data-bind="click: guiHoSo">
                                    <i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp;
                                    <span data-bind="i18n: { 'html': 'btSend' }"></span>
                                </button>
                            </c:if>
                            <a href="<c:url value="/mic/03/home" />" class="btn green" id="btDong">
                                <i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;</i><span data-bind="i18n: { 'html': 'btBack' }"></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript" src="<c:url value="/app/mic/03/module/send.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/thongtinthietbi.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/tokhaithietbi.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/tepdinhkem.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/ghihoso.module.js?v=${version}"/>"></script>
