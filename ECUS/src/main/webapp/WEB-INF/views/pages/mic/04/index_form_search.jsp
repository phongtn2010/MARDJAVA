<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form role="form" class="form-horizontal " name="searchForm04" id="searchForm04">

	<div class="form-group" style="margin-top: 15px;">
		<div class="col-md-12">
			<div class="col-md-2">
				<label data-bind="i18n: { 'html': 'fiDocumentName' }"></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" class="form-control input-medium form-control-inline"  data-bind="value: searchForm.fiDocumentName, i18n: {  placeholder: { key: 'fiDocumentName'} }" type="text">
			</div>
			<div class="col-md-2">
				<label data-bind="i18n: { 'html': 'fiStatus' }"></label>
			</div>
			<div class="col-md-4">
				<div class="input-medium">
					<select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2 input-medium form-control-inline" data-bind="options: $root.danhSachTrangThai,
                       optionsText: 'fiStatusName',
                       optionsValue: 'fiCode',
                       value: searchForm.fiStatus">
					</select>
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<div class="col-md-2">
				<label data-bind="i18n: { 'html': 'fromFiSendDate' }"></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" id="fiFromCreateDate"  class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.fiFromCreateDate, dateInput" />
			</div>
			<div class="col-md-2">
				<label data-bind="i18n: { 'html': 'toFiSendDate' }"></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" id="fiToCreateDate"  class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.fiToCreateDate, dateInput" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">

				<div class="col-md-2">
					<label data-bind="i18n: { 'html': 'fiTaxCode' }"></label>
				</div>
				<div class="col-md-4">
					<input name="fiTaxCode" id="fiTaxCode"  class="form-control form-control-inline input-medium" size="255" type="text"  data-bind="value: searchForm.fiTaxCode , i18n: {  placeholder: { key: 'fiTaxCode'} }" />
				</div>

			<div class="col-md-2">
				<label data-bind="i18n: { 'html': 'fiDispatchNo' }"></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" id="fiDispatchNo"  class="form-control form-control-inline input-medium" size="20" type="text" data-bind="value: searchForm.fiDispatchNo , i18n: {  placeholder: { key: 'fiDispatchNo'} }" />
			</div>

		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
            <div class="col-md-2">
				<label data-bind="i18n: { 'html': 'fromFiSignConfirmDate' }"></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" id="fiFromSignConfirmDate"  class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.fiFromSignConfirmDate, dateInput" />
			</div>			<div class="col-md-2">
				<label data-bind="i18n: { 'html': 'toFiSignConfirmDate' }"></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off"  id="fiToSignConfirmDate" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.fiToSignConfirmDate, dateInput" />
			</div>
		</div>
	</div>
	<div class="form-group nsw-text-center">
		<a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: $root.searchHoSo"><i class="fa fa-search"></i> <span data-bind="i18n: { 'html': 'search' }"></span></a>

	</div>
</form>