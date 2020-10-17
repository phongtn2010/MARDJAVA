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
                <select class="form-control select2" id="fiMaTuyen" name="fiMaTuyen" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenTuyen, value : fiMaTuyen, options : lstTuyen, optionsText : 'name', event: {change: getTuyenInfoOnClick}"></select>
                
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
                <label><spring:message code="mt.hoso.tuyenkhaithac.tinhthanhphodi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiMaTinhDi" style="display: none" name="fiMaTinhDi" readonly="readonly" data-bind="value : fiMaTinhDi" maxlength="250" />
                <input class="form-control" type="text" id="fiTenTinhDi" name="fiTenTinhDi" data-bind="value : fiTenTinhDi" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.bendi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiBenDi" name="fiBenDi"  data-bind="value : fiBenDi" maxlength="250" />
            </div>
        </div>  
    </div>     
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.tinhthanhphoden" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaTinhDen" style="display: none" name="fiMaTinhDen" readonly="readonly" data-bind="value : fiMaTinhDen" type="text" maxlength="250"/>
                <input class="form-control" id="fiTenTinhDen" name="fiTenTinhDen" data-bind="value : fiTenTinhDen" type="text" maxlength="250"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="mt.hoso.tuyenkhaithac.benden" /><a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiBenDen" name="fiBenDen"  data-bind="value : fiBenDen" type="text" maxlength="250"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.culy" />(km)<a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiKhoangcach" name="fiKhoangcach" data-bind="value : fiKhoangcach" type="text" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.cuakhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaCkXn" name="fiMaCkXn" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCkXn, value : fiMaCkXn, options : lstCuaKhauDiDen, optionsText : 'name'"></select>
                
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
