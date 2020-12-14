<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="inc_css.jsp" %>
<div class="row" id="RegistrationVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="mard.04.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_1" data-toggle="tab" id="a-tab-1"> <b>Thông tin đơn đăng ký</b></a>
                                    </li>

                                </ul>
                                <div class="tab-content" >
                                    <div class="tab-pane active" id="tab_1">
                                        <form role="form" class="form-horizontal" >
                                            <!--ko if: isViewAttp -->
                                            <%@include file="thong_tin_don_attp.jsp" %>
                                            <!-- /ko -->
                                            <!--ko if: isViewCnkd -->
                                            <%@include file="thong_tin_don_cnkd.jsp" %>
                                            <!-- /ko -->
                                            <!--ko if: isViewCnkdAttp -->
                                            <%@include file="thong_tin_don_cntp.jsp" %>
                                            <!-- /ko -->
                                            <!--ko if: isViewCnkdXncl -->
                                            <%@include file="thong_tin_don_xncl.jsp" %>
                                            <!-- /ko -->
                                            <!--ko if: isViewCnkdXncl3 -->
                                            <%@include file="thong_tin_don_xncl_3.jsp" %>
                                            <!-- /ko -->
                                            <!--ko if: isViewCnkdXncl4 -->
                                            <%@include file="thong_tin_don_xncl_4.jsp" %>
                                            <!-- /ko -->
                                        </form>
                                    </div>

                                    <p class="nsw-text-center" style="margin-top: 20px;margin-bottom: -5px;">
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
<script src="<c:url value='/app/mard/04/RegistrationVM.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/mard/04/FormVM.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/mard/04/model.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/mard/04/FileVM.js?v=${version}'/>" type="text/javascript"></script>

