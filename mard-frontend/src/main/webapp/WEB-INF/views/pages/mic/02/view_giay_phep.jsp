<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="inc_css.jsp" %>
<div class="row" id="ViewVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="mic.02.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_1" data-toggle="tab" id="a-tab-1"> <b>Thông tin giấy phép</b></a>
                                    </li>
                                    <li data-bind="visible: showCert">
                                        <a href="#tab_2" data-toggle="tab" id="a-tab-2"> <b>Danh mục thiết bị in</b></a>
                                    </li>

                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_1">
                                        <form role="form" class="form-horizontal"  >
                                            <!--ko with: resultVM()-->     
                                            <%@include file="thong_tin_gp.jsp" %>
                                            <!--/ko--> 
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_2" >
                                        <form role="form" class="form-horizontal">
                                            <!--ko with: resultVM()-->  
                                            <%@include file="phu_luc_gp.jsp" %>
                                            <!--/ko--> 
                                        </form>
                                    </div>



                                    <p class="nsw-text-center" style="margin-top: 20px;margin-bottom: -5px;">
                                        <a data-bind="click : $data.resultVM().btnXinSuaClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-edit"></i> Xin sửa giấy phép</a>
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
<script src="<c:url value='/app/mic/02/md5.min.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/ViewVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<template id="suaGp-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="suaGp-form" id="suaGp-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></label><b data-bind="text: fiSoGiayPhep"></b></p>
            </div>
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right;">
                    <label><spring:message code="common.msg.ly_do" /></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-10"  >
                    <textarea style="max-width: 700px;max-height: 200px;width: 695px;height: 150px;" name="Reason" id="fiNoidungYc" data-bind="value: fiNoidungYc" require="true" placeholder="<spring:message code="common.msg.ly_do" />" style="width: 90%; height: 150px;" maxlength="500"></textarea>
                </div>
            </div>

            <div class="col-md-12" style="margin-top: 10px;">
                <div class="col-md-2" style="text-align: right;margin-top: 10px;">
                    <label>File đính kèm</label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-9">
                    <input class="form-control" type="file" data-bind="visible: $data.fileDK.canUpload,event: {change: $data.fileDK.doUploadSingle }" accept=".pdf,.jpg,.tif"/>
                    <a target="_blank" data-bind="text: $data.fileDK.fiTenTepTin, attr: { href: $data.fileDK.fiDuongDan}" style="margin-top: 10px; float: left;"></a>
                    <a href="javascript:void(0);" style="margin-top:12px; float: left;margin-left: 10px;"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: $data.fileDK.canDeleteSingle, click: $data.fileDK.doDeleteNoPopup " src="" alt=""></i></a>
                    <span class="validationMessage" id="valid-file" style="display: none">Thông tin bắt buộc nhập</span>
                </div>

            </div>
            <div class="col-md-12" style="margin-top: 15px;">
                <span style="color:red;">Chú ý: Định dạng tệp đính kèm: PDF, TIF, JPG và tổng dung lượng tối đa không quá 100MB </span>
            </div>
        </form>
    </div>
</template>
