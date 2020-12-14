<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-md-6">
	        <div class="row form-group">
	            <label class="col-md-3"><spring:message code="mard.16.TbdThongTinKy.fiSignAddress"/><span class="nsw-require-field">*</span></label>
	            <div class="col-md-9">
	                <input autocomplete="off" id="fiSignAddress" class="form-control" placeholder="<spring:message code="mard.16.TbdThongTinKy.fiSignAddress"/>" data-bind="value: moduleThongTinChung.tbdHoSo16.fiSignAddress, enable: !isView">
	            </div>
	        </div>
    </div>
    <div class="col-md-6">
	        <div class="row form-group">
	            <label class="col-md-3"><spring:message code="mard.16.TbdThongTinKy.fiSignDate"/><span class="nsw-require-field">*</span></label>
	            <div class="col-md-9">
	               
	                <input onpaste="return false;" autocomplete="off" id="fiSignDate" class="form-control date-picker" data-date-format="dd/mm/yyyy" size="16" placeholder="<spring:message code="mard.16.TbdThongTinKy.fiSignDate"/>" data-bind="value: moduleThongTinChung.tbdHoSo16.fiSignDate, dateInput, enable: !isView">
	            </div>
	        </div>
    </div>
    <div class="col-md-6">
	        <div class="row form-group">
	            <label class="col-md-3"><spring:message code="mard.16.TbdThongTinKy.fiSignName"/><span class="nsw-require-field">*</span></label>
	            <div class="col-md-9">
	                <input autocomplete="off" id="fiSignName" class="form-control" placeholder="<spring:message code="mard.16.TbdThongTinKy.fiSignName"/>" data-bind="value: moduleThongTinChung.tbdHoSo16.fiSignName, enable: !isView">
	            </div>
	        </div>
    </div>
    <div class="col-md-6">
	        <div class="row form-group">
	            <label class="col-md-3"><spring:message code="mard.16.TbdThongTinKy.fiSignerPosition"/><span class="nsw-require-field">*</span></label>
	            <div class="col-md-9">
	              
	                  <input autocomplete="off" id="fiSignerPosition" class="form-control" placeholder="<spring:message code="mard.16.TbdThongTinKy.fiSignerPosition"/>" data-bind="value: moduleThongTinChung.tbdHoSo16.fiSignerPosition, enable: !isView">
	            </div>
	        </div>
    </div>