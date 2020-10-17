
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="../../common/inc_css.jsp" %>
<div class="row" id="ViewVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="mt.14.tenthutuc" /></span>
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
                                            <%@include file="../../common/inc_view_thongtinchung.jsp" %>
                                            <%@include file="../../common/inc_view_tuyenkhaithac.jsp" %>
                                            <%@include file="../../common/inc_view_danhsachxe.jsp" %>
                                            <%@include file="../../common/inc_view_dinhkem.jsp" %>
                                            <%@include file="../../common/inc_view_thongtinkydon.jsp" %>
                                            <!-- /ko -->
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_mt_2" data-bind="visible: showCert">
                                        <form role="form" class="form-horizontal">
                                            <!-- ko with: resultVM() -->                                            
                                            <%@include file="../../vl/14/cert.jsp" %>
                                            <!-- /ko -->
                                        </form>
                                    </div>

                                    <p class="nsw-text-center">
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                                        <a data-bind="click : btnXinSuaCVClick, visible: showCert" href="javascript:void(0);" class="btn blue"><i class="fa fa-edit"></i> Xin sửa Công văn</a>
                                        <a data-bind="click : btnTraLaiCVClick, visible: showCert" href="javascript:void(0);" class="btn blue"><i class="fa fa-arrow-down"></i> Trả lại Công văn</a>
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
<%@include file="../../common/inc_script.jsp" %>
<template id="yeucau-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="ruthoso-form" id="ruthoso-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></label><b data-bind="text: fiMaHoso"></b></p>
            </div>
            <div class="col-md-2" data-bind="style: { display: fiTrangthai() <= 1 ? 'none' : '' }">
                <label><spring:message code="common.msg.ly_do" /></label>
                <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10" data-bind="style: { display: fiTrangthai() <= 1 ? 'none' : '' }">
                <textarea name="fiContent" id="fiContent" data-bind="value: fiContent" require="true" placeholder="<spring:message code="common.msg.ly_do" />" style="width: 90%; height: 150px;" maxlength="500"></textarea>
            </div>
        </form>
    </div>
</template>
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/mt/vl/13/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mt/vl/13/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mt/vl/13/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mt/vl/13/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mt/vl/13/ViewVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

