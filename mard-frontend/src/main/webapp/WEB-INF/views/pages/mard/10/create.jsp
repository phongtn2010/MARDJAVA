<%-- 
    Document   : create
    Created on : Jul 31, 2017, 12:52:13 PM
    Author     : hieptran
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="incLanguage.jsp" %>
<div class="row" id="mard10Create">
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
                                        <p><a href="<c:url value='/templates/mard/bm_mard_10.xlsx'/>"><spring:message code="common.ban_khai_ho_so_mau" /></a></p>
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
                                        <a href="#tab_mard10_1" data-toggle="tab" id="a-tab-mard10-1"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_mard10_2" data-toggle="tab" id="a-tab-mard10-2"> <b>Tệp đính kèm</b></a>
                                    </li>
                                    <li  data-bind="visible: tabFiLydoSua">
                                        <a href="#tab_mard10_3" data-toggle="tab" id="a-tab-mard10-3"> <b>Đơn xin sửa hồ sơ</b></a>
                                    </li>
                                    <li  data-bind="visible: tabFiLydoHuy">
                                        <a href="#tab_mard10_4" data-toggle="tab"> <b>Đơn xin hủy hồ sơ</b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >
                                    <!-- ko with: mard10FormVM() -->
                                    <div class="tab-pane active" id="tab_mard10_1" >
                                        <%@include file="donDangKy.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <!-- ko with: mard10FilesVM() -->
                                    <div class="tab-pane" id="tab_mard10_2">
                                        <%@include file="fileDinhKem.jsp" %>
                                    </div>
                                    <!-- /ko -->
                                    <div class="tab-pane" id="tab_mard10_3" data-bind="visible: tabFiLydoSua">
                                        <fieldset>
                                            <legend>Đề nghị  xin chỉnh sửa hồ sơ với những nội dung sau đây:</legend>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <textarea class="form-control" data-bind="value : fiLydoSua" id="fiLydoSua" name="fiLydoSua" maxlength="2000"></textarea>
                                                </div>  
                                            </div> 
                                        </fieldset>
                                        <br/>
                                    </div>
                                    <div class="tab-pane" id="tab_mard10_4" data-bind="visible: tabFiLydoHuy">
                                        <fieldset>
                                            <legend>Đề nghị xin hủy hồ sơ vì lý do như sau:</legend>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <textarea class="form-control" data-bind="value : fiLydoHuy" id="fiLydoSua" name="fiLydoHuy" maxlength="2000"></textarea>
                                                </div>  
                                            </div> 
                                        </fieldset>
                                        <br/>
                                    </div>
                                    <p class="nsw-text-center" id="mard10CreateFn">
                                        <a data-bind="click : btnLuuClick, visible: btnLuu" href="javascript:void(0);" class="btn blue" id="btnLuu"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                        <a data-bind="click : btnGuiClick"  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                        <a data-bind="attr: { href: exportHref}, visible: btnTai"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> Tải mẫu</a>
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
<%@include file="incScript.jsp" %>      
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/mard/10/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/10/donDangKy.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/10/fileDinhKem.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/10/create.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>