
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
                    <span class="caption-subject bold uppercase"> <spring:message code="most.05.tenthutuc" /></span>
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
                                        <a href="#tab_mt_2" data-toggle="tab" id="a-tab-mt-2"> <b>Văn bản chấp thuận </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_mt_1" >
                                        <form role="form" class="form-horizontal" data-bind="with: formVM">
                                            <%@include file="inc_view_thongtinchung.jsp" %>
                                            <%@include file="inc_view_thongtinbentiepnhan.jsp" %>
                                            <%@include file="inc_view_chitietviecnhapkhau.jsp" %>
                                            <%@include file="inc_view_phieuphongxakin.jsp" %>
                                            <%@include file="inc_view_phieuphongxaho.jsp" %>
                                            <%@include file="inc_view_dinhkem.jsp" %>
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_mt_2" data-bind="visible: showCert">
                                        <form role="form" class="form-horizontal">
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
</script>
<script src="<c:url value='/app/most/05/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/05/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/05/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/05/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/05/ViewVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

