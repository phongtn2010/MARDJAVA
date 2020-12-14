<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiApplicationNo"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input autocomplete="off" id="fiApplicationNo" class="form-control" placeholder="<spring:message code="mard.20.TbdHoSo20.fiApplicationNo"/>" data-bind="value: tbdHoSo20.fiApplicationNo, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiNameOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.20.TbdHoSo20.fiNameOfRegistration"/>" data-bind="value: tbdHoSo20.fiNameOfRegistration">
		</div>
	</div>
</div>
</div>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiAddressOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.20.TbdHoSo20.fiAddressOfRegistration"/>" data-bind="value: tbdHoSo20.fiAddressOfRegistration">
		</div>
	</div>
</div>

<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiPhone"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.20.TbdHoSo20.fiPhone"/>" data-bind="value: tbdHoSo20.fiPhone, enable: !isView">
		</div>
	</div>
</div>
</div>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiFax"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.20.TbdHoSo20.fiFax"/>" data-bind="value: tbdHoSo20.fiFax, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiEmail"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.20.TbdHoSo20.fiEmail"/>" data-bind="value: tbdHoSo20.fiEmail, enable: !isView">
		</div>
	</div>
</div>
</div>
