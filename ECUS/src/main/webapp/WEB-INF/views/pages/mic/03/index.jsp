<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="incLanguage.jsp" %>

<div id="index" class="row">
    <div class="col-md-12">
        <div class="portlet light " id="contentBody">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i><b class="uppercase" data-bind="i18n: { 'html': 'nhomThuTuc' }"></b></span>
                </div>
            </div>

            <div class="portlet-body" id="table-search">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase" data-bind="i18n: { 'html': 'formTimKiem' }"></span>
                                </div>
                                <div class="panel-body">
                                    <jsp:include page="index_form_search.jsp"></jsp:include>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                </div>
            </div>
        </div>
    </div>
    <table-view params="titles:  $root.titles, rows: $root.dataTable, totalElements:  $root.totalElements, pageClick:  $root.pageClick, currentPage:  $root.currentPage, pageSize: 15"></table-view>
</div>


<script type="text/javascript" src="<c:url value="/app/mic/03/module/loadhoso.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/send.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/xoahoso.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/xinruthoso.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/history.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/xemhoso.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/xemgiayphep.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/xinsuagiayphep.module.js?v=${ version }"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/module/index.module.js?v=${ version }"/>"></script>