<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.10.nguoidaidien" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nguoidaidien.hovaten" /></label>
            </div>  
            <div class="col-md-10">
                <label><b data-bind="text: fiTenNdd"></b></label>
            </div>            
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nguoidaidien.socmt" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly="true" id="fiSoCmndNdd" name="fiSoCmndNdd" data-bind="value : fiSoCmndNdd" maxlength="255" />
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nguoidaidien.ngaycap" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" readonly="true" id="fiNgaycapCmnd" name="fiNgaycapCmnd" type="text" data-bind="datepicker : fiNgaycapCmnd"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div> 
        </div>  
    </div>            
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nguoidaidien.noicap" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiNoiCapCmnd" readonly="true" name="fiNoiCapCmnd" data-bind="value : fiNoiCapCmnd" maxlength="255" />
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nguoidaidien.email" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiSdtDd" readonly="true" name="fiSdtDd" data-bind="value : fiSdtDd" maxlength="255" />
            </div> 
        </div>  
    </div>
    
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nguoidaidien.sodienthoai" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiSdtCodinh" readonly="true" name="fiSdtCodinh" data-bind="value : fiSdtCodinh" maxlength="255" />
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.10.nguoidaidien.didong" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiSdtDd" readonly="true" name="fiSdtDd" data-bind="value : fiSdtDd" maxlength="255" />
            </div> 
        </div>  
    </div>  
</fieldset>
