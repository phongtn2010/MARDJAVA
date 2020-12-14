<%-- 
    Document   : view
    Created on : Sep 5, 2017, 4:04:27 PM
    Author     : QUANGNV18
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="incLanguages.jsp" %>

<div class="row" id="Most04CreateVM">
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
                                        <a href="#tab_1" data-toggle="tab" id="a-tab-1"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_2" data-toggle="tab" id="a-tab-2"> <b>Tệp đính kèm</b></a>
                                    </li>                                    
                                </ul>

                                <div class="tab-content" >
                                    <!-- ko with: most04FormVM() -->
                                    <div class="tab-pane active" id="tab_1" >
                                        <%@include file="incViewDocument.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: most04FilesVM() -->
                                    <div class="tab-pane" id="tab_2">
                                         <%@include file="incViewAttachment.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <p class="nsw-text-center" id="Mard02CreateFn">
                                        <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download" ></i> Xuất đơn đăng ký</a>
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

<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>                                    
<script src="<c:url value='/app/most/04/Model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/04/FormViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/04/FileViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/04/DocumentViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
