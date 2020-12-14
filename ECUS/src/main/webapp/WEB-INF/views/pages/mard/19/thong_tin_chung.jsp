<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiApplicationNo"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input autocomplete="off" id="fiApplicationNo" class="form-control" placeholder="<spring:message code="mard.19.TbdHoSo19.fiApplicationNo"/>" data-bind="value: tbdHoSo19.fiApplicationNo, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiNameOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.19.TbdHoSo19.fiNameOfRegistration"/>" data-bind="value: tbdHoSo19.fiNameOfRegistration">
		</div>
	</div>
</div>
</div>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiAddressOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.19.TbdHoSo19.fiAddressOfRegistration"/>" data-bind="value: tbdHoSo19.fiAddressOfRegistration">
		</div>
	</div>
</div>

<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiPhone"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.19.TbdHoSo19.fiPhone"/>" data-bind="value: tbdHoSo19.fiPhone, enable: !isView">
		</div>
	</div>
</div>
</div>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiFax"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.19.TbdHoSo19.fiFax"/>" data-bind="value: tbdHoSo19.fiFax, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiEmail"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.19.TbdHoSo19.fiEmail"/>" data-bind="value: tbdHoSo19.fiEmail, enable: !isView">
		</div>
	</div>
</div>
</div>
