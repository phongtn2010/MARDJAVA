<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.10.nhomttb" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nhomttb.loaittbyt" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiLoaiTtb" id="fiLoaiTtb" name="fiLoaiTtb"  
                        data-bind="value: fiLoaiTtb, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstLoaiTtb, 
                                optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Mục đích nhập khẩu<a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiMaMdichNk" id="fiMaMdichNk" name="fiMaMdichNk"  
                        data-bind="value: fiMaMdichNk, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstMucDichNhapKhau, 
                                optionsText : 'name',
                                event: {change: onFiMaMdichNkChange}"></select>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.nhomttb.loaihoso" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiLoaiHsTtb" id="fiLoaiHsTtb" name="fiLoaiHsTtb"  
                        data-bind="value: fiLoaiHsTtb, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstLoaiHsTtb, 
                                optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Đơn vị sử dụng<a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiDonviSd" name="fiDonviSd" data-bind="value : fiDonviSd" maxlength="255" />
            </div>
        </div>  
    </div>
</fieldset>
