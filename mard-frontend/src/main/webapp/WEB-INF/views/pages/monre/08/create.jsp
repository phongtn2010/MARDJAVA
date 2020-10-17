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
<div class="row" id="Monre08CreateVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="monre.08.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_monre08_1" data-toggle="tab" id="a-tab-monre08-1"> <b>Đơn đăng ký </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_monre08_1" >
                                        <!-- ko with: monre08FormVM() -->
                                        <%@include file="donDangKy.jsp" %>
                                        <!-- /ko -->
                                        <!-- ko with: monre08FilesVM() -->
                                        <%@include file="fileDinhKem.jsp" %>
                                        <!-- /ko -->
                                    </div>

                                    <p class="nsw-text-center" id="monre08CreateFn">
                                        <a data-bind="click : btnLuuClick, visible: btnLuu" href="javascript:void(0);" class="btn blue" id="btnLuu"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                        <a data-bind="click : btnGuiClick "  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                        <a href="<c:url value="/monre/08/home" />" class="btn blue" id="btDong"> <i class="fa fa-arrow-left" aria-hidden="true"></i></i>&nbsp; <spring:message code="common.button.trolai" />
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
<script src="<c:url value='/app/monre/08/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/monre/08/FormViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/monre/08/FileViewModel.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/monre/08/EditViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>