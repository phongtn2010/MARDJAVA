<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="panel-body">
<div >
	<div class="row form-group">
		<label class="col-md-3"><span><spring:message code="mard.16.TbdHoSo16.fiTotalQuantity"/></span><span
				class="nsw-require-field">*</span></label>
		<div class="col-md-9">
                <textarea id="fiTotalQuantity" class="form-control"
						  placeholder="<spring:message code="mard.16.TbdHoSo16.fiTotalQuantity"/>"
						  data-bind="value: moduleThongTinChung.tbdHoSo16.fiTotalQuantity, enable: !isView" autocomplete="off"></textarea>
		</div>
	</div>
</div>

<div>
	<span><spring:message code="mard.16.TbdThuoc3.mucdich"></spring:message><span
		class="nsw-require-field">*</span>
</div>
<div >

	<div class="col-md-12">
		<div style="padding: 0 30px;">
			<!-- ko foreach: $root.fiPurposes() -->
			<div class="col-md-4 row form-group">
				<div class="checkbox" style="margin-left:60px;">
					<label >
						<input id="fiPurposes" type="checkbox"
							   data-bind="checked: ($root.fiPurposeSelecteds.indexOf($data) != -1), event:{ change: $root.checkBoxSelected.bind($data, $data, $root.fiPurposeSelecteds)}, click: $root.radioButtonClick, enable: !isView"/>
						<span data-bind="text: ($index() + 1) + ' - ' + fiName()"></span>
					</label>
				</div>
			</div>
			<!-- /ko -->
		</div>
	</div>
	
	<!-- ko if: ($root.checkDisplayGroup($root.fiPurposeSelecteds, ['fiOtherPurposesValue']))-->
	<div >
		<div class="row form-group">
			<label class="col-md-3"><spring:message code="mard.16.TbdThuoc3.purposeOtherNote"/><span
					class="nsw-require-field">*</span></label>
			<div class="col-md-9">
				<input id="fiOtherPurposesValue" class="form-control"
					   placeholder="<spring:message code="mard.16.TbdThuoc3.purposeOtherNote" />"
					   data-bind="value: moduleThongTinChung.tbdHoSo16.fiOtherPurposesValue, enable: !isView" autocomplete="off">
			</div>
		</div>
	</div>
	<!-- /ko -->


	<div >
		<div class="row form-group">
			<div class="col-md-6">
				<div class="row">
					<label class="col-md-6"><spring:message code="mard.16.TbdHoSo16.fiOrganizationReceiving"/><span
							class="nsw-require-field">*</span></label>
					<div class="col-md-6">
						<input onpaste="return false;" id="fiImportTime" class="form-control"
							   placeholder="<spring:message code="mard.16.TbdHoSo16.fiOrganizationReceiving"/>"
							   data-bind="value: moduleThongTinChung.tbdHoSo16.fiImportTime, numberFormatInput: function(){ return '5'}, enable: !isView" autocomplete="off">
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="row">
					<label class="col-md-6"><span style="text-align: right;display: block;"><spring:message code="mard.16.TbdHoSo16.fiImportTimeFrom"/></span></label>
					<div class="col-md-6">
							<input onpaste="return false;" autocomplete="off" id="fiDeadlineImport" class="form-control date-picker"
								   data-date-format="dd/mm/yyyy" size="16"
								   placeholder="<spring:message code="mard.16.TbdHoSo16.fiImportTimeFrom"/>"
								   data-bind="value: moduleThongTinChung.tbdHoSo16.fiDeadlineImport, dateInput, enable: !isView" autocomplete="off">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div >
		<spring:message code="mard.16.thongTinKhac"/>
	</div>

	<div >
		<div class="row form-group">
			<label class="col-md-3" style="padding-left: 30px"><spring:message code="mard.16.TbdHoSo16.fiSummaryOfNumber"/><span
					class="nsw-require-field"></span></label>
			<div class="col-md-9">
                <input id="fiScale" class="form-control"
						  placeholder="<spring:message code="mard.16.TbdHoSo16.fiSummaryOfNumber"/>"
						  data-bind="value: moduleThongTinChung.tbdHoSo16.fiScale, enable: !isView" autocomplete="off">
			</div>
		</div>
	</div>

	<div >
		<div class="row form-group">
			<label style="padding-left: 30px" class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiLocation"/><span
					class="nsw-require-field"></span></label>
			<div class="col-md-9">
                <input id="fiLocation" class="form-control"
						  placeholder="<spring:message code="mard.16.TbdHoSo16.fiLocation"/>"
						  data-bind="value: moduleThongTinChung.tbdHoSo16.fiLocation, enable: !isView" autocomplete="off">
			</div>
		</div>
	</div>

	<div >
		<div class="row form-group">
			<label  class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiDocument"/><span
					class="nsw-require-field">*</span></label>
			<div class="col-md-9">
			</div>
		</div>
	</div>

	<div class="col-md-12">
		<div class=" form-group" style="padding: 0 30px;">
			<!-- ko foreach: $root.fiDocument() -->
			<div class="col-md-4 row">
				<div class="form-group">
					<div class="checkbox">
						<label>
							<input id="fiDocument" type="checkbox"
								   data-bind="checked: ($root.fiDocumentSelecteds.indexOf($data) != -1), event:{ change: $root.checkBoxSelected.bind($data, $data, $root.fiDocumentSelecteds)}, enable: !isView"/>
							<span  data-bind="text: fiCode() + ' - ' + fiName()"></span>
						</label>
					</div>
				</div>

			</div>
			<!-- /ko -->
		</div>
	</div>
	<!-- ko if: ($root.checkDisplayGroup($root.fiDocumentSelecteds, ['fiOtherPaperValue']))-->
	<div class="col-md-12">
		<div class="row form-group">
			<label class="col-md-3"><spring:message code="mard.16.TbdHoSo16.fiOtherPaperValue"/><span
					class="nsw-require-field">*</span></label>
			<div class="col-md-9">
                <textarea id="fiOtherPaperValue" class="form-control"
						  placeholder="<spring:message code="mard.16.TbdHoSo16.fiOtherPaperValue"/>"
						  data-bind="value: moduleThongTinChung.tbdHoSo16.fiOtherPaperValue, enable: !isView" autocomplete="off"></textarea>
			</div>
		</div>
	</div>
	<!-- /ko -->
</div>
</div>
</div>