<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row" id="EditVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="mard.04.tenthutuc"/></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mt_1" data-toggle="tab" id="a-tab-mt-1"> <b>Thông tin đơn</b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_2" data-toggle="tab" id="a-tab-2"> <b>Tài liệu đính kèm</b></a>
                                    </li>
                                </ul>

                                <div class="tab-content">

                                    <div class="tab-pane active" id="tab_mt_1">
                                        <form role="form" class="form-horizontal" data-bind="with: formVM()">
                                            <%@include file="inc_view_thongtinchung.jsp" %>
                                            <%@include file="inc_view_thongtinhanghoa.jsp" %>
                                            <%@include file="inc_view_thongtinkydon.jsp" %>
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_2">
                                        <form role="form" class="form-horizontal" data-bind="with: formVM()">
                                            <%@include file="inc_view_dinhkem.jsp" %>
                                        </form>
                                    </div>

                                    <p class="nsw-text-center" style="margin-top: 20px;margin-bottom: -5px;">
                                        <!-- ko with: formVM() -->
                                        <a data-bind="click : btnViewPageClick, visible: btnViewGiay"
                                           href="javascript:void(0);" class="btn blue" id="btnView"><i
                                                class="fa fa-file-word-o"></i> Xem trước</a>
                                        <!-- /ko -->
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);"
                                           class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i>
                                            <spring:message code="common.button.trolai"/></a>
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
<script src="<c:url value='/app/mard/04/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/04/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/04/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/04/EditVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

<template id="viewXndTam-template">
    <fieldset>
        <form role="form" class="form-horizontal" id="viewXndTam-vm">
            <!--ko if: isViewXndTamKdtv -->
            <%@include file="xemtruockdtv.jsp" %>
            <!-- /ko -->

            <!--ko if: isViewXndTamXncl -->
            <%@include file="xemtruocxncl.jsp" %>
            <!-- /ko -->

            <!--ko if: isViewXndTamKdtvAttp -->
            <%@include file="xemtruockdtv_attp.jsp" %>
            <!-- /ko -->

            <!--ko if: isViewXndTamAttp -->
            <%@include file="xemtruocattp.jsp" %>
            <!-- /ko -->
        </form>
    </fieldset>
</template>

