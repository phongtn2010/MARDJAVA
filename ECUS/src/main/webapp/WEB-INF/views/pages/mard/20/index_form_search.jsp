<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
</style>
<form role="form" class="form-horizontal " name="searchForm01" id="searchForm01">

	<div class="form-group" style="margin-top: 15px;">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="mard.20.formSearch.fiDocumentName"></spring:message> </label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" class="form-control form-control-inline" name="maHoSo" id="maHoSo" placeholder="<spring:message code="mard.20.formSearch.fiDocumentName" />" data-bind="value: searchForm.fiDocumentName" type="text">
			</div>
			<div class="col-md-2">
				<label><spring:message code="mard.20.formSearch.fiStatus"></spring:message></label>
			</div>
			<div class="col-md-4">
				<div>
					<select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2 form-control-inline" data-bind="options: $root.danhSachTrangThai,
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
				<label><spring:message code="mard.20.formSearch.fromFiSendDate"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" name="fromFiSendDate" id="fromFiSendDate" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.fromFiSendDate, dateInput" />
			</div>
			<div class="col-md-2">
				<label><spring:message code="mard.20.formSearch.toFiSendDate"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" name="toFiSendDate" id="toFiSendDate" field="common_tracuu_ngay_tao_den" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.toFiSendDate, dateInput" />
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="mard.20.formSearch.fromFiSignConfirmDate"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" name="fromFiSignConfirmDate" id="fromFiSignConfirmDate" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.fromFiSignConfirmDate, dateInput" />
			</div>
			<div class="col-md-2">
				<label><spring:message code="mard.20.formSearch.toFiSignConfirmDate"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" name="toFiSignConfirmDate" id="toFiSignConfirmDate" field="common_tracuu_ngay_tao_den" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.toFiSignConfirmDate, dateInput" />
			</div>
		</div>
	</div>

	<div class="form-group">
    		<div class="col-md-12">


    			<div class="col-md-2">
    				<label><spring:message code="mard.20.formSearch.fiDispatchNo"></spring:message></label>
    			</div>
    			<div class="col-md-4">
    				<input autocomplete="off" name="fiDispatchNo" id="fiDispatchNo" field="common_tracuu_ngay_tao_den" class="form-control form-control-inline " size="20" type="text" placeholder="<spring:message code="mard.20.formSearch.fiDispatchNo"></spring:message>" data-bind="value: searchForm.fiDispatchNo" />
    			</div>
    		</div>
    	</div>

	<div class="form-group nsw-text-center">
		<a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: $root.searchHoSo"><i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" /></a>
		<c:if test="${!isFcap}">
			<a href="javascript:;" data-bind="click: $root.themMoiHoSo" class="btn green" id="btnAddNew"><i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" /></a>
		</c:if>
	</div>
</form>
