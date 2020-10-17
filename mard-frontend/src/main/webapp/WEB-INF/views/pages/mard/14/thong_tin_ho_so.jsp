<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-6" data-bind="visible: idHoSo>0">
	<div class="row form-group" >
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiDocumentName"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiDocumentName"/>" data-bind="value: tbdHoSo14.fiDocumentName">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiStatus"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiStatus"/>" data-bind="value: tbdHoSo14.fiStatusName">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiTaxCode"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiTaxCode"/>" data-bind="value: tbdHoSo14.fiTaxCode">
		</div>
	</div>
</div>
<div class="col-md-6">
	<div class="row form-group">
		<label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiCreateDate"/><span class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<input disabled class="form-control" placeholder="<spring:message code="mard.14.TbdHoSo14.fiCreateDate"/>" data-bind="value: tbdHoSo14.fiCreateDate">
		</div>
	</div>
</div>
