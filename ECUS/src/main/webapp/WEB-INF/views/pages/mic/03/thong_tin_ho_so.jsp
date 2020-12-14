<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class='col-md-12'>
	<div class='row'>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" data-bind="i18n: {  html: { key: 'TbdHoSo03.fiDocumentName'}}"><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input disabled  class="form-control"  data-bind="value: tbdHoSo03.fiDocumentName, i18n: {  placeholder: { key: 'TbdHoSo03.fiDocumentName'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" data-bind="i18n: {  html: { key: 'TbdHoSo03.fiStatus'}}"><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input disabled  class="form-control"  data-bind="value: tbdHoSo03.fiStatusName, i18n: {  placeholder: { key: 'TbdHoSo03.fiStatus'}}">
				</div>
			</div>
		</div>

	</div>
</div>