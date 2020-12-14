<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
    .plDiaglog{
        z-index: 2147483647 !important;
    }
</style>
<%-- 
    Document   : edit
    Created on : Mar 28, 2017, 1:32:29 PM
    Author     : PhongNguyen
--%>

<%@include file="incLanguage.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"> <spring:message code="moh.typea.them_moi_ho_so" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_5_1" data-toggle="tab"> <b><spring:message code="common.van_ban_cong_bo" /> </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_5_2" data-toggle="tab"> <b><spring:message code="common.tai_lieu_dinh_kem" /></b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_5_3" data-toggle="tab"> <b><spring:message code="common.xac_nhan_nop_phi" /></b></a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab_5_1">
                                        <c:choose>
                                            <c:when test="${IsView != 'none'}"><p><%@include file="vanbancongbo.jsp" %></p></c:when>
                                            <c:when test="${IsView == 'none'}"><p><%@include file="viewVanbancongbo.jsp" %></p></c:when>
                                        </c:choose>
                                    </div>
                                    <div class="tab-pane" id="tab_5_2">
                                         <c:choose>
                                            <c:when test="${IsView != 'none'}"><p><%@include file="tailieudinhkem.jsp" %></p></c:when>
                                            <c:when test="${IsView == 'none'}"><p><%@include file="viewTailieudinhkem.jsp" %></p></c:when>
                                         </c:choose>
                                    </div>
                                    <div class="tab-pane" id="tab_5_3">
                                        <c:choose>
                                            <c:when test="${IsView != 'none'}"><p><%@include file="xacnhannopphi.jsp" %></p></c:when>
                                            <c:when test="${IsView == 'none'}"><p><%@include file="viewXacnhannopphi.jsp" %></p></c:when>
                                        </c:choose>
                                    </div>

                                    <p class="nsw-text-center">
                                        <c:choose>
                                            <c:when test="${IsView != 'none'}">
                                                <a href="javascript:;" class="btn blue" id="btnLuu" style="display: ${IsView}"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                                <a href="javascript:;" class="btn blue" id="btnGui" style="display: ${IsView}"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                            </c:when>
                                        </c:choose>
                                        <a href="javascript:;" class="btn grey" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/app/moh/typea/themmoi.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/moh/typea/themthietbi.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/moh/typea/nopphi.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/moh/typea/dinhkem.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/moh/typea/HandlebarsHelpers.js?v=${version}' />" type="text/javascript"></script>


<script>
    $(document).ready(function () {
        var data = '${data}';
        console.log(data);
        var controller = new addController();
        controller.init({
            data: ${data},
            uploadDialog: "${uploadDialog}",
            countries: ${countries},
            isView:"${IsView}"
        });
    });
</script>
<script src="<c:url value='/static/lib/jquery-ui.js' />" type="text/javascript"></script>


