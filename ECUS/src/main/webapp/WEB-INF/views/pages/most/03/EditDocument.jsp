<%-- 
    Document   : create
    Created on : Sep 5, 2017, 3:55:19 PM
    Author     : QUANGNV18
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="incLanguages.jsp" %>

<div class="row" id="Most03CreateVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="common.sua_thong_tin_ho_so" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default" id="pnl-import" style="display: ${hideImport}">
                            <div class="panel-heading">
                                <span class="caption-subject bold uppercase"><spring:message code="common.nhap_tu_excel" /> </span>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <p><a href="<c:url value='/templates/most/bm_most_03.xlsx'/>"><spring:message code="common.ban_khai_ho_so_mau" /></a></p>
                                    </div>
                                    <div class="col-md-8 ">
                                        <div class="fileinput fileinput-new" data-provides="fileinput">
                                            <span class="btn grey btn-file">
                                                <span class="fileinput-new"> <spring:message code="file.import.chon_file" /> </span>
                                                <span class="fileinput-exists"> <spring:message code="file.thay_doi" /> </span>
                                                <input name="file-import-excel" type="file" id="file-import-excel" data-bind="event : {change : fileUpload}" accept=".xlsx"/>
                                            </span>
                                            <a href="javascript:void(0);" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                                        </div>
                                        <a href="javascript:void(0);" class="btn blue" id="btnImport" data-bind="event: {click : btnImportClick}"><i class="fa fa-check"></i> <spring:message code="file.import.nhap_du_lieu" /></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_1" data-toggle="tab" id="a-tab-1"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_2" data-toggle="tab" id="a-tab-2"> <b>Tệp đính kèm</b></a>
                                    </li>                                    
                                </ul>

                                <div class="tab-content" >
                                    <!-- ko with: most03FormVM() -->
                                    <div class="tab-pane active" id="tab_1" >
                                        <%@include file="incDocument.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: most03FilesVM() -->
                                    <div class="tab-pane" id="tab_2">
                                         <%@include file="incAttachment.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <p class="nsw-text-center" id="Mard02CreateFn">
                                        <a data-bind="click : btnLuuClick, visible: visibleBtnLuu" href="javascript:void(0);" class="btn blue" id="btnLuu"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                        <a data-bind="click : btnGuiClick"  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
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
<script src="<c:url value='/app/most/03/Model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/03/FormViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/03/FileViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/03/EditViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>                                    
<script src="<c:url value='/static/lib/knockout.validation.rules.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>                                    

