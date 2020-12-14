<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
	<div class=" form-group">
		<label class="col-md-3"><spring:message code="mard.15.TbdHoSo15.fiTotalQuantity"/><span
				class="nsw-require-field">*</span></label>
		<div class="col-md-9">
			<textarea id="fiTotalQuantity" class="form-control"
					  placeholder="<spring:message code="mard.15.TbdHoSo15.fiTotalQuantity"/>"
					  data-bind="value: moduleThongTinChung.tbdHoSo15.fiTotalQuantity, enable: !isView" autocomplete="off"></textarea>
		</div>
	</div>
</div>

<div>
	<span><spring:message code="mard.15.TbdThuoc3.mucdich"></spring:message></span><span
		class="nsw-require-field">*</span>
</div>
<div class="row">

	<div class="col-md-12">
		<div class=" form-group" style="padding: 0 30px">
			<!-- ko foreach: $root.fiPurposes() -->
			<div class="col-md-4 row form-group" style="margin-left:60px;">
				<div class="checkbox">
				<label>
					<input id="fiPurposes" type="checkbox"
						   data-bind="checked: ($root.fiPurposeSelecteds.indexOf($data) != -1), event:{ change: $root.checkBoxSelected}, click: $root.radioButtonClick, enable: !isView"/>
					<span data-bind="text: ($index() + 1) + ' - ' + fiName()"></span>
				</label>
				</div>
			</div>
			<!-- /ko -->
		</div>
	</div>
	
	<!-- ko if: ($root.checkDisplayGroup(['fiOtherPurposeDetail']))-->
	<div class="col-md-12">
		<div class="row form-group">
			<label class="col-md-3"><spring:message code="mard.15.TbdThuoc3.purposeOtherNote"/><span
					class="nsw-require-field">*</span></label>
			<div class="col-md-9">
				<input id="fiOtherPurposeDetail" class="form-control"
					   placeholder="<spring:message code="mard.15.TbdThuoc3.purposeOtherNote" />"
					   data-bind="value: moduleThongTinChung.tbdHoSo15.fiOtherPurposeDetail, enable: !isView" autocomplete="off">
			</div>
		</div>
	</div>
	<!-- /ko -->



	<div class="col-md-12">
		<div class="row form-group">
			<label class="col-md-3"><spring:message code="mard.15.TbdHoSo15.fiOrganizationReceiving"/><span
					class="nsw-require-field">*</span></label>
			<div class="col-md-9">
                <textarea id="fiOrganizationReceiving" class="form-control"
						  placeholder="<spring:message code="mard.15.TbdHoSo15.fiOrganizationReceiving"/>"
						  data-bind="value: moduleThongTinChung.tbdHoSo15.fiOrganizationReceiving, enable: !isView" autocomplete="off"></textarea>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<div class="row form-group">
			<label class="col-md-3"><spring:message code="mard.15.TbdHoSo15.fiSummaryOfNumber"/><span
					class="nsw-require-field">*</span></label>
			<div class="col-md-9">
                <textarea id="fiSummaryOfNumber" class="form-control"
						  placeholder="<spring:message code="mard.15.TbdHoSo15.fiSummaryOfNumber"/>"
						  data-bind="value: moduleThongTinChung.tbdHoSo15.fiSummaryOfNumber, enable: !isView" autocomplete="off"></textarea>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<div class="row form-group">
			<label class="col-md-3"><spring:message code="mard.15.TbdHoSo15.fiImportTimeFrom"/></label>
			<div class="col-md-9">
				<div class="row">
					<div class="col-md-6">
						<div class="row form-group">
							<div class="col-md-9">
								<input onpaste="return false;" autocomplete="off" id="fiTimeImport" class="form-control date-picker"
									   data-date-format="dd/mm/yyyy" size="16"
									   placeholder="<spring:message code="mard.15.TbdHoSo15.fiImportTimeFrom"/>"
									   data-bind="value: moduleThongTinChung.tbdHoSo15.fiTimeImport, dateInput, enable: !isView" autocomplete="off">
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>


</div>