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
                    <span class="caption-subject bold uppercase"> <spring:message code="mard.03.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mt_1" data-toggle="tab" id="a-tab-mt-1"> <b>Đơn đăng ký</b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_2" data-toggle="tab" id="a-tab-2"> <b>Tài liệu đính kèm</b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_mt_1" >
                                        <form role="form" class="form-horizontal" data-bind="with: formVM()">
                                            <%@include file="inc_thongtinhoso.jsp" %>
                                            <%@include file="inc_thongtinchung.jsp" %>
                                            <%@include file="inc_hanghoa.jsp" %>
                                            <%@include file="inc_thongtinky.jsp" %>

                                            <fieldset>
                                                <div class="form-group">
                                                    <div class="col-md-12">
                                                        <div class="col-md-2"
                                                             data-bind="style: { display: (fiTrangThaiMa() === 2 || fiTrangThaiMa() === 12 || fiTrangThaiMa() === 13 || fiTrangThaiMa() === 7) ? '' : 'none' }">
                                                            <label><spring:message code="common.msg.ly_do" /></label>
                                                            <a class="nsw-require-field">*</a>
                                                        </div>
                                                        <div class="col-md-10" data-bind="style: { display: (fiTrangThaiMa() === 2 || fiTrangThaiMa() === 12 || fiTrangThaiMa() === 13 || fiTrangThaiMa() === 7) ? '' : 'none' }" >
                                                            <textarea name="Reason" id="Reason" data-bind="value: reason" require="true" placeholder="<spring:message code="common.msg.ly_do" />" style="width: 100%; height: 100px;resize: none;" maxlength="500"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </fieldset>

                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_2" >
                                        <form role="form" class="form-horizontal" data-bind="with: formVM()">
                                            <%@include file="inc_dinhkem.jsp" %>
                                        </form>
                                    </div>

                                    <p class="nsw-text-center" style="margin-top: 20px;">
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
<%@include file="inc_script.jsp" %>      
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/mard/03/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/03/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/03/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/03/EditVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/03/XNDONVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

