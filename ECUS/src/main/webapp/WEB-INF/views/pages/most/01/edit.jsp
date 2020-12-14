<%-- 
    Document   : edit
    Created on : Mar 28, 2017, 1:32:29 PM
    Author     : PhongNguyen
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="incLanguage.jsp" %>

<div class="row">
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
                                        <p><a href="<c:url value='/templates/most/bm_most_01.xlsx'/>"><spring:message code="common.ban_khai_ho_so_mau" /></a></p>
                                    </div>
                                    <div class="col-md-8 ">
                                        <div class="fileinput fileinput-new" data-provides="fileinput">
                                            <span class="btn grey btn-file">
                                                <span class="fileinput-new"> <spring:message code="file.import.chon_file" /> </span>
                                                <span class="fileinput-exists"> <spring:message code="file.thay_doi" /> </span>
                                                <input value="" name="..." type="hidden"><input name="file-import-excel" type="file" id="file-import-excel"> </span>
                                            <span class="fileinput-filename"></span> &nbsp;
                                            <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                                        </div>
                                        <a href="javascript:;" class="btn blue" id="btnImport"><i class="fa fa-check"></i> <spring:message code="file.import.nhap_du_lieu" /></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_5_1" data-toggle="tab"> <b><spring:message code="common.don_dang_ky" /> </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_5_2" data-toggle="tab"> <b><spring:message code="common.tai_lieu_khac" /></b></a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab_5_1">
                                        <p><%@include file="dondangky.jsp" %></p>
                                        <p><%@include file="tokhai.jsp" %></p>
                                        <p><%@include file="hanghoa.jsp" %></p>
                                        <p><%@include file="tailieu.jsp" %></p>                                        
                                    </div>
                                    <div class="tab-pane" id="tab_5_2">
                                        <p><%@include file="tailieukhac.jsp" %></p>
                                    </div>
                                    <p class="nsw-text-center">
                                        <a href="javascript:;" class="btn blue" id="btnLuu" style="display: ${IsView}"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                        <a href="javascript:;" class="btn blue" id="btnGui" style="display: ${IsView}"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                        <a href="javascript:;" class="btn grey" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
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
<script src="<c:url value='/app/most/01/handlebarsHelper.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/hopdong.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/vandon.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/hoadon.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/dmhanghoa.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/tokhai.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/hanghoa.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/gcnhanghoa.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/giaychungnhan.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/tailieukhac.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/detail.module.js?v=${version}' />" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        var data = ${hosoJson};
        console.log(data);
        window.detailDocument = new DetailController();        
        data.IsView = '${IsView}';
        window.detailDocument.init(data);
    });
</script>


