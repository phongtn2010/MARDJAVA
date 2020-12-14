<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mt.hoso.tuyenkhaithac" /></b></legend>     
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.tuyenvantai" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaTuyen" disabled name="fiMaTuyen" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenTuyen, value : fiMaTuyen, options : lstTuyen, optionsText : 'name'"></select>
                <input type="hidden" id="fiTenTuyen" name="fiTenTuyen" data-bind="value : fiTenTuyen"/>
            </div>
            <div class="col-md-2">
                
            </div>
            <div class="col-md-4">
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.tinhthanhphodi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenTinhDi" name="fiTenTinhDi" readonly="readonly" data-bind="value : fiTenTinhDi" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.bendi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiBenDi" name="fiBenDi" readonly="readonly" data-bind="value : fiBenDi" maxlength="250" />
            </div>
        </div>  
    </div>     
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.tinhthanhphoden_vt" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTinhDen" name="fiTenTinhDen" readonly="readonly" data-bind="value : fiTenTinhDen" type="text" maxlength="250"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="mt.hoso.tuyenkhaithac.benden_vt" /><a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFaxDn" name="fiBenDen" readonly="readonly" data-bind="value : fiBenDen" type="text" maxlength="250"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.culy" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiKhoangcach" readonly="readonly" name="fiKhoangcach" data-bind="value : fiKhoangcach" type="text" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.diemdung" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control form-control-inline" id="fiDiemDung" readonly="readonly" name="fiDiemDung" data-bind="value : fiDiemDung" type="text" maxlength="250"/>
            </div>
        </div>  
    </div>         
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.hanhtrinh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiHanhtrinh" name="fiHanhtrinh" readonly="readonly" type="text" data-bind="value: fiHanhtrinh" maxlength="250"/>
            </div>                
        </div>  
    </div>            
</fieldset>
