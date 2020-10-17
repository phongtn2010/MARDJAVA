<%-- 
    Document   : fileDinhKem
    Created on : Jul 28, 2017, 11:08:56 PM
    Author     : hieptran
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="mard10Files">
    <fieldset>
        <legend>Danh sách tài liệu</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Chọn file <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input id="fiTep" class="form-control" type="file" data-bind="event: {change: fileUpload}" accept=".pdf,.jpg,.tif"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tên tệp đính kèm <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTep" name="fiTenTep" data-bind="value : fiTenTep" type="text"/>
                </div>
                <div class="col-md-2">
                    <a href="javascript:void(0);" class="btn green" id="upload" data-bind="click: uploadClick"><i class="fa fa-upload"></i> Tải lên</a>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstDinhkem11">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width:30px;">STT</th>
                            <th class="text-center">Tên file đính kèm</th>
                            <th class="text-center" style="width: 60px;">Xem</th>
                            <th class="text-center" style="width: 60px;">Tải về</th>
                            <th class="text-center" style="width: 60px;">Xóa</th>
                        </tr>
                    </thead>
                    <tbody id="file-container" data-bind="template: { name: 'lstDinhkem11Tmpl', foreach: lstDinhkem11 }">
                    </tbody>
                    <script id="lstDinhkem11Tmpl" type="text/html">
                        <tr>
                            <td data-bind="text: STT" style="width:30px;">
                            </td>  
                            <td data-bind="text: fiTenTep">
                            </td>
                            <td class="text-center" >
                                <a target="_blank" data-bind="visible: true, attr: { href: viewUrl, title: fiTenTep }"><i class="fa fa-eye"/></a>
                            </td>                                  
                            <td class="text-center" >
                                <a target="_blank" data-bind="visible: true, attr: { href: downloadUrl, title: fiTenTep }"><i class="fa fa-download" /></a>
                            </td>
                            <td class="text-center" >
                                <a href="javascript:void(0);"><i class="fa fa-edit" data-bind="visible: bXoa, click: $parent.bXoaClick.bind($parent)"/></a>
                            </td>  
                        </tr>                      
                    </script>
                </table>
                <span data-bind="text : errorDinhkemText" style="color:red;"> </span>
            </div>
        </div>
    </fieldset>
</form>

<template id="select-attach-template">
    <form role="form" class="form-horizontal" id="select-attach">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Chọn Số công văn đã cấp mẫu 14a,b  <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-8">                                        
                    <select class="form-control" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : selected, options : attachments, optionsText : 'name'">
                        
                    </select>
                </div>
            </div>  
        </div>
    </form>
</template>   