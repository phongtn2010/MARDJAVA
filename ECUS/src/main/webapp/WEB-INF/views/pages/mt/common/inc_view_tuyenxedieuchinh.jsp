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
            <div class="col-md-4 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.tentuyen" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-8">                                        
                <select class="form-control select2" id="fiMaTuyen" name="fiMaTuyen" disabled data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenTuyen, value : fiMaTuyen, options : lstTuyen, optionsText : 'name'"></select>
                <input type="hidden" id="fiTenTuyen" name="fiTenTuyen" data-bind="value : fiTenTuyen"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-4 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.ngaybatdautanggiam" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiNgayDchinh" name="fiNgayDchinh" readonly data-bind="value : fiNgayDchinh" maxlength="250" />
            </div>
        </div>  
    </div>  
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-4 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.tansuat" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-8">
                <input class="form-control" type="text" id="fiMaTinhDi" name="fiMaTinhDi" readonly data-bind="value : fiTenTinhDi" maxlength="250" />
            </div>
        </div>  
    </div>
</fieldset>
