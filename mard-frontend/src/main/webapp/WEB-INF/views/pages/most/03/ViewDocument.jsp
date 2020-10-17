<%-- 
    Document   : view
    Created on : Sep 5, 2017, 4:04:27 PM
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
                                        <%@include file="incViewDocument.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: most03FilesVM() -->
                                    <div class="tab-pane" id="tab_2">
                                         <%@include file="incViewAttachment.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <p class="nsw-text-center" id="Mard02CreateFn">
                                        <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download" ></i> Xuất đơn đăng ký</a>
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
<template id="tokhai-tmpl">
    <form role="form" class="form-horizontal" id="tokhai-form">
        <p><b class="nsw-text-underline"><spring:message code="common.tokhai.thongtinchung" /></b></p>
        <div class="panel-body"> 
            <div class="row">
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.sotokhai" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiSoTk"></b>
                </div>
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.mahaiquan" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiMaHq"></b>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.ngaydangky" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiNgayDKVN"></b>
                </div>        
            </div>
        </div>
        <p><b class="nsw-text-underline"><spring:message code="common.tokhai.nnk" /></b></p>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.nnk.tencongty" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiTenDvNk"></b>
                </div>
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.nnk.diachi" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiDiachiDvNk"></b>
                </div>        
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.nnk.dienthoai" /></label>
                </div>
                <div class="col-md-3">
                    <b></b>
                </div>        
            </div>
        </div>
        <p><b class="nsw-text-underline"><spring:message code="common.tokhai.nxk" /></b></p>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.nxk.tencongty" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiTenDvXk"></b>
                </div>

                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.nxk.nuoc" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiNuocXk"></b>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label><spring:message code="common.tokhai.nxk.diachi" /></label>
                </div>
                <div class="col-md-3">
                    <b data-bind="text: fiDiachiDvXk"></b>
                </div>        
            </div>
        </div>
        <p><b class="nsw-text-underline"><spring:message code="common.tokhai.hanghoa" /></b></p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th class="text-center"><b><spring:message code="most.03.tokhai.form.mahs" /></b></th>
                    <th><b><spring:message code="most.03.tokhai.form.tenhanghoa" /></b></th>
                    <th class="text-center"><b><spring:message code="most.03.tokhai.form.soluong" /></b></th>
                    <th class="text-center"><b><spring:message code="most.03.tokhai.form.donvitinh" /></th>
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'hanghoaTKSearchTmpl', foreach: toKhaiHQDs }">
            </tbody>
            <script id="hanghoaTKSearchTmpl" type="text/html">
                <tr>
                    <td class="text-center" data-bind="text : fiMaHs"></td> 
                    <td data-bind="text : fiTenHh"></td>
                    <td class="text-center" data-bind="text : fiKlSl"></td>
                    <td class="text-center" data-bind="text : fiTenDv"></td>
                </tr>                      
            </script>
        </table>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <label><spring:message code="common.tokhai.soluong" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiSoluong"></b>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <label><spring:message code="common.tokhai.tongtrongluong" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiTong"></b>
                </div>
            </div>
        </div>
        <p><b class="nsw-text-underline"><spring:message code="common.tokhai.vdhd" /></b></p>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <label><spring:message code="common.tokhai.vdhd.sohoadon" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiSoHoadon"></b>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <label><spring:message code="common.tokhai.vdhd.ngaycaphoadon" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiNgayCapHoaDon"></b>
                </div>
            </div>    
        </div>
    </form>
</template>
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>                                    
<script src="<c:url value='/app/most/03/Model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/03/FormViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/03/FileViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/most/03/DocumentViewModel.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
