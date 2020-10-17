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
<%@include file="incLanguage.jsp" %>
<div class="row" id="Monre09ResultVM">
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
                                        <!-- ko with: monre09FormVM() -->
                                        <a href="#tab_monre09_1" data-toggle="tab" id="a-tab-monre09-1"> <b>Đơn đăng ký </b></a>
                                        <!-- /ko -->
                                    </li>
                                    <li data-bind="visible: thongBaoVisible">
                                        <a href="#tab_monre09_2" data-toggle="tab" id="a-tab-monre09-2"> <b>Thông báo </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_monre09_1" >
                                        <!-- ko with: monre09FormVM() -->
                                        <%@include file="xemDonDangKy.jsp" %>
                                        <!-- /ko -->
                                        <!-- ko with: monre09FilesVM() -->
                                        <%@include file="xemFileDinhKem.jsp" %>
                                        <!-- /ko -->
                                    </div>
                                    <div class="tab-pane" id="tab_monre09_2" data-bind="visible: thongBaoVisible">
                                        <!-- ko with: monre09ThongBao() -->
                                        <%@include file="thongBao.jsp" %>
                                        <!-- /ko -->
                                    </div>

                                    <p class="nsw-text-center" id="monre09CreateFn">
                                        <a href="<c:url value="/monre/09/home" />" class="btn blue" id="btDong"> <i class="fa fa-arrow-left" aria-hidden="true"></i></i>&nbsp; <spring:message code="common.button.trolai" />
							</a>
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
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/monre/09/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/monre/09/FileViewModel.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/monre/09/FormViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/monre/09/ResultViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/monre/09/DocumentViewModel.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
