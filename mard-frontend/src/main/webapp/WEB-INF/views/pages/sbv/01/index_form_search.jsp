<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form role="form" class="form-horizontal " name="searchForm01" id="searchForm01">
	<div class="form-group" style="margin-top: 15px;">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="sbv.01.mahoso"></spring:message> </label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" class="form-control" name="maHoSo" id="maHoSo" placeholder="<spring:message code="sbv.01.mahoso" />" data-bind="value: searchForm.maHoSo, valueUpdate: 'keypress', enterkey" type="text">
			</div>
			<div class="col-md-2">
				<label><spring:message code="sbv.01.trangthai"></spring:message></label>
			</div>
			<div class="col-md-4">
				<select  name="trangThaiHoSo" class="form-control select2" data-bind="options: $root.danhSachTrangThai,
                       optionsText: 'tenTrangThai',
                       optionsValue: 'giaTri',
                       value: searchForm.trangThai">
				</select>
			</div>
		</div>
	</div>
	<div class="form-group" style="margin-top: 15px;">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="sbv.01.loaihinhxnk"></spring:message> </label>
			</div>
			<div class="col-md-4">
				<select id="hinhThucXNK" name="hinhThucXNK" class="form-control select2" data-bind="options: $root.danhSachhinhThucXNK,
                       optionsText: 'tenHinhThuc',
                       optionsValue: 'giaTri',
                       value: searchForm.hinhThucXNK">
				</select>
			</div>
			<div class="col-md-2">
				<label><spring:message code="sbv.01.cuakhauxnk"></spring:message></label>
			</div>
			<div class="col-md-4">
				<select id="trangThaiHoSo" name="cuaKhau" class="form-control select2" data-bind="options: $root.danhSachCuaKhau,
                       optionsText: 'tenCuaKhau',
                       optionsValue: 'maCuaKhau',
                       value: searchForm.maCuaKhau">
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<div class="col-md-2">
				<label><spring:message code="sbv.01.ngaytaohosotungay"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" name="ngayTaoTuNgay" id="ngayTaoTuNgay" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.ngayTaoTuNgay, dateInput" />
			</div>
			<div class="col-md-2">
				<label><spring:message code="sbv.01.ngaytaohosodenngay"></spring:message></label>
			</div>
			<div class="col-md-4">
				<input autocomplete="off" name="ngayTaoDenNgay" id="ngayTaoDenNgay" field="common_tracuu_ngay_tao_den" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: searchForm.ngayTaoDenNgay, dateInput" />
			</div>
		</div>
	</div>
	<div class="form-group nsw-text-center">
		<a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: $root.searchHoSo"><i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" /></a> <a href="javascript:;" data-bind="click: $root.themMoiHoSo" class="btn green" id="btnAddNew"><i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" /></a>
	</div>
</form>