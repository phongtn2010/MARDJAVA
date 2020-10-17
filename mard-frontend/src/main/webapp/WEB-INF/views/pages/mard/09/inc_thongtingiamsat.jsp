<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mard.hoso.coquangiamsat" /></b></legend>     
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.coquangiamsat.phiabac" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaCqgsBac" name="fiMaCqgsBac" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiCqgsBac, value : fiMaCqgsBac, options : lstCqgsBac, optionsText : 'name', event: {change: onCqgsMienBac}"></select>
                <input type="hidden" id="fiCqgsBac" name="fiCqgsBac" data-bind="value : fiCqgsBac"/>
            </div>
            <div class="col-md-2 nsw-text-right">

            </div>
            <div class="col-md-4">

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.coquangiamsat.phiatrung" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaCqgsTrung" name="fiMaCqgsTrung" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiCqgsTrung, value : fiMaCqgsTrung, options : lstCqgsTrung, optionsText : 'name', event: {change: onCqgsMienNam}"></select>
                <input type="hidden" id="fiCqgsTrung" name="fiCqgsTrung" data-bind="value : fiCqgsTrung"/>
            </div>
            <div class="col-md-2 nsw-text-right">

            </div>
            <div class="col-md-4">

            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.coquangiamsat.phianam" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaCqgsNam" name="fiMaCqgsNam" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiCqgsNam, value : fiMaCqgsNam, options : lstCqgsNam, optionsText : 'name', event: {change: onCqgsMienNam}"></select>
                <input type="hidden" id="fiCqgsNam" name="fiCqgsNam" data-bind="value : fiCqgsNam"/>
            </div>
            <div class="col-md-2 nsw-text-right">

            </div>
            <div class="col-md-4">

            </div>
        </div>  
    </div>

</fieldset>
