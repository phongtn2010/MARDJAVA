<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="import_package.jsp"%>
<form role="form" class="form-horizontal" name="searchForm01" id="searchForm01">
	<div class="form-group" style="margin-top: 15px;">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="common.tracuu.ma_ho_so"></spring:message> </label>
			</div>
			<div class="col-md-4">
				<input class="form-control" name="maHoSo" id="maHoSo" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" data-bind="value: searchForm.maHoSo" type="text">
			</div>
			<div class="col-md-2">
				<label><spring:message code="monre.01.label.index.tt01.trang-thai-hs"></spring:message></label>
			</div>
			<div class="col-md-4">
				<select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2" data-bind="options: $root.danhSachTrangThai,
                       optionsText: 'tenTrangThai',
                       optionsValue: 'idTrangThai',
                       value: searchForm.trangThai">
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="monre.01.label.index.tt01.ngay-cap-hs-tu"></spring:message> </label>
			</div>
			<div class="col-md-4">
				<input name="ngayGuiTuNgay" id="ngayGuiTuNgay" field="common_tracuu_ngay_gui_tu" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" data-bind="value: searchForm.ngayGuiTuNgay" />
			</div>
			<div class="col-md-2">
				<label><spring:message code="monre.01.label.index.tt01.ngay-cap-hs-den"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input name="ngayGuiDenNgay" id="ngayGuiDenNgay" field="common_tracuu_ngay_gui_den" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" data-bind="value: searchForm.ngayGuiDenNgay" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="monre.01.label.index.tt01.ngay-tao-hs"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input name="maSoThue" id="maSoThue" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline"  type="text" data-bind="value: searchForm.maSoThue" />
			</div>
			<div class="col-md-2">
				<label><spring:message code="monre.01.label.index.tt01.ngay-tao-hs-den"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input name=soGiayXN id="soGiayXN" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline"  type="text" data-bind="value: searchForm.soGiayXN" />
			</div>
		</div>
	</div>
	<div class="form-group nsw-text-center">
		<a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: $root.searchHoSo"><i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" /></a> 

	</div>
</form>