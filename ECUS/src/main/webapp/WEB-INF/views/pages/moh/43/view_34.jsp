
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
                    <span class="caption-subject bold uppercase"> <spring:message code="moh.40.tenthutuc" /></span>
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
                                            <%@include file="inc_view_34_thongtinthuoc.jsp" %>
                                            <%@include file="inc_view_dinhkem.jsp" %>
                                            <!-- /ko -->
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_mt_2" data-bind="visible: showCert">
                                        <form role="form" class="form-horizontal">
                                            <!-- ko with: formVM() -->
                                            <%@include file="inc_view_thongtinchung.jsp" %>
                                            <%@include file="inc_view_34_thongtinthuoc.jsp" %>
                                            <!-- /ko -->
                                            <!-- ko with: resultVM() -->                                            
                                            <%@include file="../39/cert.jsp" %>
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
</script>
<script src="<c:url value='/app/moh/knockout.validation.extender.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/39/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/43/FormVM34.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/39/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/39/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/39/ViewVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

