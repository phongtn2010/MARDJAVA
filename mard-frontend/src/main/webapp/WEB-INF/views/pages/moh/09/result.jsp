
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="inc_css.jsp" %> 
<div class="row" id="ResultVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase" data-bind="text: propTitle"></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mt_1" data-toggle="tab" id="a-tab-mt-1"> <b>THÔNG BÁO KẾT QUẢ XÁC NHẬN THỰC PHẨM ĐẠT/KHÔNG ĐẠT YÊU CẦU NHẬP KHẨU </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >
                                    <div class="tab-pane active" id="tab_mt_1" >
                                        <form role="form" class="form-horizontal">
                                            <%@include file="inc_result.jsp" %>
                                            <p class="nsw-text-center">
                                                <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                                            </p>
                                        </form>
                                    </div>
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
    NSWLang["moh.BYTE0500009.tenthutuc"] = "<spring:message code="moh.BYTE0500009.tenthutuc" />";
    NSWLang["moh.BYTE0500010.tenthutuc"] = "<spring:message code="moh.BYTE0500010.tenthutuc" />";
    
    NSWLang["moh.BYTE0500009.phuongthuckt"] = "<spring:message code="moh.BYTE0500009.phuongthuckt" />";
    NSWLang["moh.BYTE0500010.phuongthuckt"] = "<spring:message code="moh.BYTE0500010.phuongthuckt" />";
</script>

<script src="<c:url value='/app/moh/knockout.validation.extender.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/09/NguoiTnVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/09/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

