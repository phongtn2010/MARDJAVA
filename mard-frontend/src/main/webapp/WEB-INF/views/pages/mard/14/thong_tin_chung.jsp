<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiApplicationNo"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input autocomplete="off" id="fiApplicationNo" class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiApplicationNo"/>" data-bind="value: tbdHoSo14.fiApplicationNo, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiNameOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiNameOfRegistration"/>" data-bind="value: tbdHoSo14.fiNameOfRegistration">
		</div>
	</div>
</div>
</div>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiAddressOfRegistration"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiAddressOfRegistration"/>" data-bind="value: tbdHoSo14.fiAddressOfRegistration">
		</div>
	</div>
</div>

<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiPhone"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiPhone"/>" data-bind="value: tbdHoSo14.fiPhone, enable: !isView">
		</div>
	</div>
</div>
</div>
<div class="col-md-12">
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiFax"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiFax"/>" data-bind="value: tbdHoSo14.fiFax, enable: !isView">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiEmail"/></label>
		<div class="col-md-9">
			<input autocomplete="off" class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiEmail"/>" data-bind="value: tbdHoSo14.fiEmail, enable: !isView">
		</div>
	</div>
</div>
</div>
