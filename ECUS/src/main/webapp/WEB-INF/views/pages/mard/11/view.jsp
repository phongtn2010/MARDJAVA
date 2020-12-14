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
<div class="row" id="mard11View">
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
                                        <a href="#tab_mard11_1" id="a-tab_mard11_1" data-toggle="tab"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_mard11_2" id="a-tab_mard11_2" data-toggle="tab"> <b>Tệp đính kèm</b></a>
                                    </li>
                                    <!-- ko with: gcn() -->
                                    <li>
                                        <a href="#tab_mard11_3" id="a-tab_mard11_3" data-toggle="tab"> <b>Giấy chứng nhận</b></a>
                                    </li>
                                    <!-- /ko -->
                                    <li>
                                        <a href="#tab_mard11_4" id="a-tab_mard11_4" data-toggle="tab"> <b>Lịch sử xử lý</b></a>
                                    </li>
                                </ul>

                                <div class="tab-content">
                                    <!-- ko with: hosoVM() -->
                                    <div class="tab-pane active" id="tab_mard11_1" >
                                        <%@include file="xemDonDangKy.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: fileVM() -->
                                    <div class="tab-pane" id="tab_mard11_2" >
                                        <%@include file="xemFileDinhKem.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: gcn() -->
                                    <div class="tab-pane" id="tab_mard11_3" >
                                        <!-- ko if : fiLoaiCt() == 1 -->
                                            <%@include file="xemGCN-1.jsp" %>
                                        <!-- /ko -->
                                        <!-- ko if : fiLoaiCt() == 2 -->
                                            <%@include file="xemGCN-2.jsp" %>
                                        <!-- /ko -->
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: lichsu11VM() -->
                                    <div class="tab-pane" id="tab_mard11_4" >
                                        <%@include file="lichsu.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <p class="nsw-text-center" id="mard11CreateFn">
                                        <br/>
                                        <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> Tải mẫu</a>
                                        <a data-bind="attr: { href: exportMauHref}, visible: exportMauVisible"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> Mẫu GCN</span></a>
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
<script src="<c:url value='/app/mard/11/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/11/view.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>