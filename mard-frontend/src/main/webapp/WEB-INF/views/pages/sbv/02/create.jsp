<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="incLanguage.jsp"%>
<%@include file="inc_script.jsp" %>

<div id="sbv02Create">
    <div class="row" style="padding-top: 15px; padding-bottom: 15px;" data-bind="with: kdnkVM">
        <div class="col-md-12">
            <div class="portlet light">
                <div class="portlet-title">
                    <div class="caption font-dark" style="width: 100%">
                        <%--                    <i class="icon-settings font-dark"></i>--%>
                        <span class="caption-subject bold uppercase"><spring:message code="sbv.02.tenthutuc"/></span>

                    </div>
                </div>
                <div class="portlet-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel">
                                <div class="tabbable-custom">
                                    <ul class="nav nav-tabs ">
                                        <li class="active">
                                            <a href="#tab_regform" data-toggle="tab"> <b><spring:message code="sbv.02.tokhai.don_de_nghi"/></b></a>
                                        </li>
                                        <li>
                                            <a href="#tab_attachment" data-toggle="tab"> <b><spring:message code="sbv.02.tokhai.tai_lieu_dinh_kem"/></b></a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane active"id="tab_regform">
                                            <%@include file="inc_thongtindoanhnghiep.jsp"%>
                                            <%@include file="inc_thongtinhanghoa.jsp" %>
                                            <%@include file="inc_thongtinkydon.jsp" %>
                                        </div>
                                        <div class="tab-pane" id="tab_attachment">
<%--                                            <%@include file="inc_dinhkem.jsp" %>--%>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12" style="padding-top: 10px;">
                                            <div class="text-center">
                                                <p><span class="nsw-require-field" data-bind="text: errorMsg"></span></p>
                                                <button class="btn green" data-bind="click: $root.saveRegProfile">
                                                    <i class="fa fa-save"></i> <spring:message code="common.button.luu"/>
                                                </button>
                                                <button class="btn green"
                                                        data-bind="click: $root.sendRegProfile"
                                                >
                                                    <i class="fa fa-send"></i> <spring:message code="common.button.gui_ho_so"/>
                                                </button>
                                                <button class="btn green"
                                                        data-bind="click: $root.goIndexPage"
                                                >
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
<%--<script type="text/javascript" src="<c:url value='/app/mard/06/init.js?v=${version}'/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value='/app/mard/06/create.js?v=${version}'/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value='/app/mard/06/FormVM.js?v=${version}'/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value='/app/mard/06/KyHoSoVM.js?v=${version}'/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value='/app/mard/06/ThongTinChungVM.js?v=${version}'/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value='/app/mard/06/KiemDichNhapKhauVM.js?v=${version}'/>"></script>--%>
