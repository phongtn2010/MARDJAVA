<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.07.nhomttb" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.nhomttb.nhomttbyt" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiNhomTtb" disabled id="fiNhomTtb" name="fiNhomTtb"  
                        data-bind="value: fiNhomTtb, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstNhomTtb, 
                                optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.nhomttb.loaittbyt" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiLoaiTtb" disabled id="fiLoaiTtb" name="fiLoaiTtb"  
                        data-bind="value: fiLoaiTtb, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstLoaiTtb, 
                                optionsText : 'name',
                                event: {change: onFiLoaiTtbChange}"></select>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.nhomttb.loaihoso" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiLoaiHsTtb" disabled id="fiLoaiHsTtb" name="fiLoaiHsTtb"  
                        data-bind="value: fiLoaiHsTtb, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstLoaiHsTtb, 
                                optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right" data-bind="visible: showInvitro">
                <label>Loại trang thiết bị y tế Invitro<a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4" data-bind="visible: showInvitro">
                <select class="form-control select2 fiLoaiInvitro"
                        id="fiLoaiInvitro" name="fiLoaiInvitro" disabled 
                        data-bind="value: fiLoaiInvitro, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstLoaiInvitro, 
                                optionsText : 'name'"></select>
            </div>
        </div>  
    </div>
    <div class="form-group" data-bind="visible: showQtxlNhanh">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Quy trình xử lý nhanh <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiQtxlNhanh" id="fiQtxlNhanh" name="fiQtxlNhanh"  
                        data-bind="value: fiQtxlNhanh, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstQtxlNhanh, 
                                optionsText : 'name'"></select>
            </div>
        </div>
    </div>        
</fieldset>
