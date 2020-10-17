<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="form-horizontal" >
<fieldset>
    <legend><b><spring:message code="mard.hoso.thongtinkyhoso" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.thongtinkyhoso.nguoiky" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiSignedBy" name="fiSignedBy"  maxlength="255" data-bind="value: fiSignedBy, enable: $root.isEnableEdit"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.thongtinkyhoso.diadiem" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select
                        class="form-control select2"
                        data-bind="value : fiSigningLocation,
                                        options : lstProvince,
                                        optionsValue : 'provinceName',
                                        optionsCaption: 'Chọn...',
                                        optionsText : 'provinceName', enable: $root.isEnableEdit">
                </select>
<%--                <input class="form-control" id="fiSigningLocation" name="fiSigningLocation" data-bind="value : fiSigningLocation" maxlength="250"/>--%>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.chucvunguoiky" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSignedByTitle" name="fiSignedByTitle" data-bind="value : fiSignedByTitle, enable: $root.isEnableEdit" maxlength="255"/>
            </div>
        </div>  
    </div>
</fieldset>
</div>