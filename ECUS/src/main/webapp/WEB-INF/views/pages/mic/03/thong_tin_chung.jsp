<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class='col-md-12'>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiSoDonDeNghi'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiSoDonDeNghi" name="fiSoDonDeNghi" class="form-control"  data-bind="value: tbdHoSo03.fiSoDonDeNghi, i18n: {  placeholder: { key: 'TbdHoSo03.fiSoDonDeNghi'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiNoiDNCapPhep'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<select ${ isView ? " disabled " : ""} id="fiNoiDNCapPhep" name="fiNoiDNCapPhep" class="form-control select2 input-medium form-control-inline"
														   data-bind="options: $root.danhMucTinhTPs,  optionsText: 'fiName',  optionsValue: 'fiName' ,value: tbdHoSo03.fiNoiDNCapPhep"></select>
					<p class='validationMessage' data-bind="validationMessage: tbdHoSo03.fiNoiDNCapPhep"></p>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiTenTCCaNhan'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiTenTCCaNhan" disabled name="fiTenTCCaNhan" class="form-control"  data-bind="value: tbdHoSo03.fiTenTCCaNhan, i18n: {  placeholder: { key: 'TbdHoSo03.fiTenTCCaNhan'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiTenCQChuQuan'}}"></span><span class="nsw-require-field"></span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiTenCQChuQuan" name="fiTenCQChuQuan" class="form-control"  data-bind="value: tbdHoSo03.fiTenCQChuQuan, i18n: {  placeholder: { key: 'TbdHoSo03.fiTenCQChuQuan'}}">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiDiaChi'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiDiaChi" name="fiDiaChi" disabled class="form-control"  data-bind="value: tbdHoSo03.fiDiaChi, i18n: {  placeholder: { key: 'TbdHoSo03.fiDiaChi'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiSoDienThoai'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiSoDienThoai" disabled name="fiSoDienThoai" class="form-control"  data-bind="value: tbdHoSo03.fiSoDienThoai, i18n: {  placeholder: { key: 'TbdHoSo03.fiSoDienThoai'}}">
				</div>
			</div>
		</div>

	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiTongSoXBPham'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  disabled id="fiTongSoXBPham" name="fiTongSoXBPham" class="form-control"  data-bind="value: fullDataTable().length, i18n: {  placeholder: { key: 'TbdHoSo03.fiTongSoXBPham'}}, numberFormatDecimalInput: function(){return '9.0';}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiTongSoBangDia'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiTongSoBangDia" name="fiTongSoBangDia" class="form-control"  data-bind="value: tbdHoSo03.fiTongSoBangDia, i18n: {  placeholder: { key: 'TbdHoSo03.fiTongSoBangDia'}}, numberFormatDecimalInput: function(){return '9.0';}">
				</div>
			</div>
		</div>

	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiXuatXu'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<textarea ${ isView ? " disabled " : ""} rows="3" id="fiXuatXu" name="fiXuatXu" class="form-control"  data-bind="value: tbdHoSo03.fiXuatXu, i18n: {  placeholder: { key: 'TbdHoSo03.fiXuatXu'}}"></textarea>
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiTenNhaCC'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<textarea ${ isView ? " disabled " : ""} rows="3" id="fiTenNhaCC" name="fiTenNhaCC" class="form-control"  data-bind="value: tbdHoSo03.fiTenNhaCC, i18n: {  placeholder: { key: 'TbdHoSo03.fiTenNhaCC'}}"></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class='row'>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiCuaKhauNhap'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<textarea ${ isView ? " disabled " : ""} rows="3" id="fiCuaKhauNhap" name="fiCuaKhauNhap" class="form-control"  data-bind="value: tbdHoSo03.fiCuaKhauNhap, i18n: {  placeholder: { key: 'TbdHoSo03.fiCuaKhauNhap'}}"></textarea>
				</div>
			</div>
		</div>

	</div>
</div>