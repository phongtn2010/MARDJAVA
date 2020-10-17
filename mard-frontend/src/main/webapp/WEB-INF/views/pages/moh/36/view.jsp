
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="inc_css.jsp" %>
<div class="row" id="ViewVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase" data-bind="text: title"></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mt_1" data-toggle="tab" id="a-tab-mt-1"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li data-bind="visible: showCert">
                                        <a href="#tab_mt_2" data-toggle="tab" id="a-tab-mt-2"> <b>Công văn </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >
                                    
                                    <div class="tab-pane active" id="tab_mt_1" >
                                        <form role="form" class="form-horizontal">  
                                            <!-- ko with: formVM() -->
                                            <%@include file="inc_view_thongtinchung.jsp" %>
                                            <%@include file="inc_view_thongtinthuoc.jsp" %>
                                            <%@include file="inc_view_nguyenlieuthuoc.jsp" %>
                                            <%@include file="inc_view_dinhkem.jsp" %> 
                                             <!-- /ko --> 
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_mt_2" data-bind="visible: showCert">
                                        <form role="form" class="form-horizontal">
                                            <!-- ko with: formVM() -->
                                            <%@include file="inc_view_thongtinchung.jsp" %>
                                            <%@include file="inc_view_thongtinthuoc.jsp" %>
                                            <%@include file="inc_view_nguyenlieuthuoc.jsp" %>
                                             <!-- /ko --> 
                                            <!-- ko with: resultVM() -->  
                                            <%@include file="cert.jsp" %>
                                            <!-- /ko --> 
                                        </form>
                                    </div>
                                          
                                    <p class="nsw-text-center">
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
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
<%@include file="inc_script.jsp" %>
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
    var uploadUrl ='${upload}';
    NSWLang["moh_21_tenthutuc"] = "<spring:message code="moh.21.tenthutuc" />";
    NSWLang["moh_22_tenthutuc"] = "<spring:message code="moh.22.tenthutuc" />";
    NSWLang["moh_23_tenthutuc"] = "<spring:message code="moh.23.tenthutuc" />";
    NSWLang["moh_25_tenthutuc"] = "<spring:message code="moh.25.tenthutuc" />";
    NSWLang["moh_36_tenthutuc"] = "<spring:message code="moh.36.tenthutuc" />";
    NSWLang["moh_44_tenthutuc"] = "<spring:message code="moh.44.tenthutuc" />";
</script>
<script src="<c:url value='/app/moh/knockout.validation.extender.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/36/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/36/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/36/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/36/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/36/ViewVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

