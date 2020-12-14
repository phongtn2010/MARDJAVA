<%-- 
    Document   : create
    Created on : Jul 31, 2017, 12:52:13 PM
    Author     : hieptran
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="incLanguage.jsp" %>
<%@include file="word.jsp" %>
<div class="row" id="mard10View">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="common.sua_thong_tin_ho_so" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mard10_1" data-toggle="tab"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_mard10_2" data-toggle="tab"> <b>Tệp đính kèm</b></a>
                                    </li>
                                    <!-- ko with: mau14aVM() -->
                                    <li>
                                        <a href="#tab_mard10_3" data-toggle="tab" id="a-tab_mard10_3"> <b>Giấy 14a</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <!-- ko with: mau14bVM() -->
                                    <li>
                                        <a href="#tab_mard10_4" data-toggle="tab"  id="a-tab_mard10_4"> <b>Giấy 14b</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <!-- ko with: mau15aVM() -->
                                    <li>
                                        <a href="#tab_mard10_5" data-toggle="tab"  id="a-tab_mard10_5"> <b>Giấy 15a</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <!-- ko with: mau15bVM() -->
                                    <li>
                                        <a href="#tab_mard10_6" data-toggle="tab"  id="a-tab_mard10_6"> <b>Giấy 15b</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <!-- ko with: mau15bv2VM() -->
                                    <li>
                                        <a href="#tab_mard10_15bv2" data-toggle="tab"  id="a-tab_mard10_15bv2"> <b>Giấy 15b</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <!-- ko with: mau15cVM() -->
                                    <li>
                                        <a href="#tab_mard10_7" data-toggle="tab"   id="a-tab_mard10_7"> <b>Giấy 15c</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <!-- ko with: mau9aVM() -->
                                    <li>
                                        <a href="#tab_mard10_8" data-toggle="tab"  id="a-tab_mard10_8"> <b>Giấy 9a</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <li>
                                        <a href="#tab_mard10_9" data-toggle="tab"> <b>Lịch sử xử lý</b></a>
                                    </li>
                                </ul>

                                <div class="tab-content">
                                    <!-- ko with: hosoVM() -->
                                    <div class="tab-pane active" id="tab_mard10_1" >
                                        <%@include file="xemDonDangKy.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: fileVM() -->
                                    <div class="tab-pane" id="tab_mard10_2" >
                                        <%@include file="xemFileDinhKem.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: mau14aVM() -->
                                    <div class="tab-pane word-bg" id="tab_mard10_3" >
                                        <%@include file="mau14a.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: mau14bVM() -->
                                    <div class="tab-pane word-bg" id="tab_mard10_4" >
                                        <%@include file="mau14b.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: mau15aVM() -->
                                    <div class="tab-pane word-bg" id="tab_mard10_5" >
                                        <%@include file="mau15a.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: mau15bVM() -->
                                    <div class="tab-pane word-bg" id="tab_mard10_6" >
                                        <%@include file="mau15b.jsp" %>
                                    </div>
                                    
                                    <!-- /ko -->
                                    <!-- ko with: mau15bv2VM() -->
                                    <div class="tab-pane word-bg" id="tab_mard10_15bv2" >
                                        <%@include file="mau15b_2019.jsp" %>
                                    </div>
                                    
                                    
                                    <!-- /ko -->
                                    <!-- ko with: mau15cVM() -->
                                    <div class="tab-pane word-bg" id="tab_mard10_7" >
                                        <%@include file="mau15c.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: mau9aVM() -->
                                    <div class="tab-pane word-bg" id="tab_mard10_8" >
                                        <%@include file="mau9a.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: lichsu02VM() -->
                                    <div class="tab-pane" id="tab_mard10_9" >
                                        <%@include file="lichsu.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <p class="nsw-text-center" id="mard10CreateFn">
                                        <br/>
                                        <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> Tải mẫu</a>
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn grey" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
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
<%@include file="incScript.jsp" %>
<script src="<c:url value='/static/lib/jquery.history.js' />" type="text/javascript"></script>
<script src="<c:url value='/static/lib/knockout-3.4.2.js' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/static/lib/knockout.binding.js' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/static/lib/knockout.mapping.js' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/10/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/10/view.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>