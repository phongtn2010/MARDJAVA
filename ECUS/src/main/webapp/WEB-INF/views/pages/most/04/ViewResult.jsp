<%-- 
    Document   : ResultView
    Created on : Sep 15, 2017, 9:04:24 AM
    Author     : QUANGNV18
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="css.jsp" %>
<div class="row" id="Most04View">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> Kết quả cấp giấy chứng nhận</span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_most04_1" data-toggle="tab"> <b>Thông tin Quyết định </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content">
                                    <div class="tab-pane active word-bg" id="tab_most04_1" >
                                        <%@include file="incResultDocument.jsp" %>
                                    </div>
                                    <p class="nsw-text-center">
                                        <br/>
                                        <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> Tải mẫu</a>
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn grey" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
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
<script src="<c:url value='/app/most/04/Model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/04/ResultViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>