<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="incLanguage.jsp"%>
<%@include file="inc_script.jsp"%>

<script type="text/javascript">
    var idHoSo = ${idHoSo};
</script>
<div id="mard08YCS">
    <div data-bind="visible: fiHSType() < 4">
        <div class="row" data-bind="with: kdnkVM">
            <div class="col-md-12">
                <div class="portlet light">
                    <div class="portlet-title">
                        <div class="caption font-dark" style="width: 100%">
                            <%--                    <i class="icon-settings font-dark"></i>--%>
                            <span class="caption-subject bold uppercase"><spring:message
                                    code="mard.08.title.them_ho_so"/></span>
                        </div>
                        <div style="margin-top: 5px;">
                            <a style="font-style: italic" href="/mard/08/hdsd">
                                <i class="fa fa-download" aria-hidden="true"></i><span>Tải hướng dẫn sử dụng</span>
                            </a>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel">
                                    <div class="tabbable-custom">
                                        <ul class="nav nav-tabs ">
                                            <li class="active">
                                                <a href="#tab_regform_1" data-toggle="tab"> <b><spring:message code="common.don_dang_ky"/></b></a>
                                            </li>
                                            <li>
                                                <a href="#tab_attachment_1" data-toggle="tab"> <b><spring:message code="common.tai_lieu_dinh_kem"/></b></a>
                                            </li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="tab_regform_1">
                                                <%@include file="inc_lydosua.jsp"%>
                                                <%@include file="inc_thongtinchung.jsp"%>
                                                <%@include file="inc_thongtinhanghoa.jsp"%>
                                                <%@include file="inc_thongtinkydon.jsp"%>
                                            </div>
                                            <div class="tab-pane" id="tab_attachment_1">
                                                <%@include file="inc_dinhkem.jsp"%>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="text-center">
                                                    <p><span class="nsw-require-field" data-bind="text: errorMsg"></span></p>
                                                    <button class="btn green" data-bind="click: $root.sendRegProfile">
                                                        <i class="fa fa-send"></i> <spring:message code="common.button.gui_ho_so"/>
                                                    </button>
                                                    <button class="btn green" data-bind="click: $root.goIndexPage">
                                                        Thoát
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div data-bind="visible: fiHSType() >= 4">
        <div class="row" data-bind="with: ktclVM">
            <div class="col-md-12">
                <div class="portlet light">
                    <div class="portlet-title">
                        <div class="caption font-dark" style="width: 100%">
                            <%--                    <i class="icon-settings font-dark"></i>--%>
                            <span class="caption-subject bold uppercase"><spring:message
                                    code="mard.08.title.them_ho_so_20a"/></span>
                        </div>
                        <div style="margin-top: 5px;">
                            <a style="font-style: italic" href="/mard/08/hdsd">
                                <i class="fa fa-download" aria-hidden="true"></i><span>Tải hướng dẫn sử dụng</span>
                            </a>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel">
                                    <div class="tabbable-custom">
                                        <ul class="nav nav-tabs ">
                                            <li class="active">
                                                <a href="#tab_regform_2" data-toggle="tab"> <b><spring:message code="common.don_dang_ky"/></b></a>
                                            </li>
                                            <li>
                                                <a href="#tab_attachment_2" data-toggle="tab"> <b><spring:message code="common.tai_lieu_dinh_kem"/></b></a>
                                            </li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="tab_regform_2">
                                                <%@include file="inc_lydosua.jsp"%>
                                                <%@include file="inc_thongtinchung.jsp"%>
                                                <%@include file="inc_benmuahang.jsp"%>
                                                <%@include file="inc_thongtinhanghoa20a.jsp"%>
                                                <%@include file="inc_thongtinkydon.jsp"%>
                                            </div>
                                            <div class="tab-pane" id="tab_attachment_2">
                                                <%@include file="inc_dinhkem.jsp"%>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12" style="padding-top: 10px;">
                                                <div class="text-center">
                                                    <p><span class="nsw-require-field" data-bind="text: errorMsg"></span></p>
                                                    <button class="btn green" data-bind="click: $root.sendRegProfile">
                                                        <i class="fa fa-send"></i> <spring:message code="common.button.gui_ho_so"/>
                                                    </button>
                                                    <button class="btn green" data-bind="click: $root.goIndexPage">
                                                        Thoát
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value='/app/mard/08/ycs.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/KiemDichNhapKhauVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/KiemTraChatLuongVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/KyHoSoVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/ThongTinChungVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/FormVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/08/init.js?v=${version}'/>"></script>
