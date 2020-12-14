<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiApplicationNo"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input autocomplete="off" id="fiApplicationNo" class="form-control" placeholder="<spring:message code="mard.16.TbdHoSo16.fiApplicationNo"/>" data-bind="value: tbdHoSo16.fiApplicationNo, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiNameOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.16.TbdHoSo16.fiNameOfRegistration"/>" data-bind="value: tbdHoSo16.fiNameOfRegistration">
		</div>
	</div>
</div>

<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiAddressOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.16.TbdHoSo16.fiAddressOfRegistration"/>" data-bind="value: tbdHoSo16.fiAddressOfRegistration">
		</div>
	</div>
</div>

<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiPhone"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.16.TbdHoSo16.fiPhone"/>" data-bind="value: tbdHoSo16.fiPhone, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiFax"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.16.TbdHoSo16.fiFax"/>" data-bind="value: tbdHoSo16.fiFax, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiEmail"/></label>
		<div class="col-md-9">
			<input autocomplete="off" type="email" class="form-control" placeholder="<spring:message code="mard.16.TbdHoSo16.fiEmail"/>" data-bind="value: tbdHoSo16.fiEmail, enable: !isView">
		</div>
	</div>
</div>
