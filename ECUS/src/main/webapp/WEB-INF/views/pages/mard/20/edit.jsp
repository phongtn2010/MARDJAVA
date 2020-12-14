<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .btrow {
        width: 650px;
        display: block;
        margin: auto;
    }

    .btwidth {
        width: 200px;
        display: block;
        float: left;
        margin-right: 15px;
    }
</style>
<form id="form">
    <div class="row">
        <div class="col-md-12">
            <div class="portlet light ">
                <div class="portlet-title">
                    <div class="caption font-dark">
                        <i class="icon-settings font-dark"></i> <span
                            class="caption-subject bold uppercase">Đơn xin cấp công văn miễn kiểm tra Nhà nước về chất lượng thuốc thú y nhập khẩu</span>
                    </div>
                </div>

                <div class="portlet-body" id="table-search">
                    <div class="table-toolbar">
                        <div id="ThongTinChungViewModel">
                            <div class="row">
                                <div class="col-md-12" data-bind="visible: action == 2">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <span class="caption-subject bold uppercase"><spring:message
                                                    code="mard.20.form.lydoxinsua"></spring:message> </span>
                                        </div>
                                        <div class="panel-body">
                                            <div class="col-md-12">
                                                <div class="row form-group">
                                                    <label class="col-md-1"><spring:message
                                                            code="mard.20.form.lydoxinsua"/><span
                                                            class="nsw-require-field">*</span></label>
                                                    <div class="col-md-11">
                                                        <input id="fiReasonCorrection" class="form-control"
                                                               placeholder="<spring:message code="mard.20.form.lydoxinsua" />"
                                                               data-bind="value: tbdHoSo20.fiReasonCorrection">
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
                                            <span class="caption-subject bold uppercase"><spring:message
                                                    code="mard.20.form.thongTinHoSo"></spring:message> </span>
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
                                            <span class="caption-subject bold uppercase"><spring:message
                                                    code="mard.20.form.thongTinChung"></spring:message> </span>
                                        </div>
                                        <div class="panel-body" id="">
                                            <jsp:include page="thong_tin_chung.jsp"></jsp:include>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default" id="ChiTietThuocViewModel">

                                    <div class="panel-body">
                                        <jsp:include page="thong_tin_thuoc_thu_y.jsp"></jsp:include>
                                    </div>

                                   <div class="panel-body">
                                        <jsp:include page="muc_dich_thuoc_thu_y.jsp"></jsp:include>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <span class="caption-subject bold uppercase"><spring:message
                                                code="mard.20.form.thongTinDinhKem"></spring:message> </span>
                                    </div>
                                    <div class="panel-body" id="ThongTinTepDinhKemViewModel">
                                        <jsp:include page="upload_file.jsp"></jsp:include>
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
                                    <spring:message code="mard.20.form.save"/>
                                </button>
                                <button type="button" class="btn green" id="btGuiHoSo"
                                        data-bind="click: guiHoSo">
                                    <i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp;
                                    <spring:message code="mard.20.form.send"/>
                                </button>
                            </c:if>
                            <a href="<c:url value="/mard/20/home" />" class="btn green" id="btDong">
                                <i class="fa fa-arrow-left" aria-hidden="true"></i></i>&nbsp; <spring:message
                                    code="mard.20.form.close"/>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="<c:url value="/app/mard/20/i18n/en.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/i18n/vi.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/cmonFunc.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/models.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/thongtinchung.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/chitietthuoc.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/tokhaithuoc.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/tepdinhkem.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/send.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/tepdinhkemthuoc.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/tepdinhkemthuoc.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/20/ghihoso.module.js?v=${version}"/>"></script>
