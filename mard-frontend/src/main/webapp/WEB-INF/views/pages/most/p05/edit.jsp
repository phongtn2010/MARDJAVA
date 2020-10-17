<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="row" id="EditVM">
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
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_mt_1" >
                                        <form role="form" class="form-horizontal" data-bind="with: formVM()">
                                            <%@include file="inc_thongtinchung.jsp" %>
                                            <%@include file="inc_thongtinbentiepnhan.jsp" %>
                                            <%@include file="inc_chitietviecnhapkhau.jsp" %>
                                            <%@include file="inc_phieuphongxakin.jsp" %>
                                            <%@include file="inc_phieuphongxaho.jsp" %>
                                            <%@include file="inc_dinhkem.jsp" %>
                                        </form>
                                    </div>

                                    <p class="nsw-text-center">
                                        <a data-bind="click : btnLuuClick, visible: btnLuu" href="javascript:void(0);" class="btn blue" id="btnLuu"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                        <a data-bind="click : btnGuiClick, visible: btnGui"  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
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
<script src="<c:url value='/app/most/05/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/05/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/05/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/05/EditVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

