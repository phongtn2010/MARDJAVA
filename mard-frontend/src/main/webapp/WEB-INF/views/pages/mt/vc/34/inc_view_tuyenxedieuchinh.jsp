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
                <select class="form-control select2" disabled id="fiMaTuyen" name="fiMaTuyen" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenTuyen, value : fiMaTuyen, options : lstTuyen, optionsText : 'name'"></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-4 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.ngaybatdautanggiam" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" disabled  placeholder="dd/mm/yyyy" id="fiNgayDchinh" name="fiNgayDchinh" data-bind="datepicker : fiNgayDchinh" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>  
    </div>  
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-4 nsw-text-right">
                <label><spring:message code="mt.hoso.tuyenkhaithac.tansuat" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-8">
                <input class="form-control" type="text" readonly id="fiSoChuyen" name="fiSoChuyen" data-bind="value : fiSoChuyen" maxlength="250" />
            </div>
        </div>  
    </div>
</fieldset>
