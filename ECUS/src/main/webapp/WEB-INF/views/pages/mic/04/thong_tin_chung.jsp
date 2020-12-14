<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class='col-md-12'>
	<div class='row'>
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiSoDonDeNghi'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  ${ isView ? " disabled " : ""} id="fiSoDonDeNghi" name="fiSoDonDeNghi" class="form-control"  data-bind="value: tbdHoSo04.fiSoDonDeNghi, i18n: {  placeholder: { key: 'TbdHoSo04.fiSoDonDeNghi'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiNoiDNCapPhep'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<select ${ isView ? " disabled " : ""} id="fiNoiDNCapPhep" name="fiNoiDNCapPhep" class="form-control select2 input-medium form-control-inline"
								data-bind="options: $root.danhMucTinhTPs,  optionsText: 'fiName',  optionsValue: 'fiName' ,value: tbdHoSo04.fiNoiDNCapPhep"></select>
					<p class='validationMessage' data-bind="validationMessage: tbdHoSo04.fiNoiDNCapPhep"></p>
				</div>
			</div>
		</div>


	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiTenTCCaNhan'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiTenTCCaNhan" disabled name="fiTenTCCaNhan" class="form-control"  data-bind="value: tbdHoSo04.fiTenTCCaNhan, i18n: {  placeholder: { key: 'TbdHoSo04.fiTenTCCaNhan'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiTenCQChuQuan'}}"></span><span class="nsw-require-field"></span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiTenCQChuQuan" name="fiTenCQChuQuan" class="form-control"  data-bind="value: tbdHoSo04.fiTenCQChuQuan, i18n: {  placeholder: { key: 'TbdHoSo04.fiTenCQChuQuan'}}">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiDiaChi'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiDiaChi" name="fiDiaChi" disabled class="form-control"  data-bind="value: tbdHoSo04.fiDiaChi, i18n: {  placeholder: { key: 'TbdHoSo04.fiDiaChi'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiSoDienThoai'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiSoDienThoai" disabled name="fiSoDienThoai" class="form-control"  data-bind="value: tbdHoSo04.fiSoDienThoai, i18n: {  placeholder: { key: 'TbdHoSo04.fiSoDienThoai'}}">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiFax'}}"></span><span class="nsw-require-field"></span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiFax" name="fiFax" class="form-control"  data-bind="value: tbdHoSo04.fiFax, i18n: {  placeholder: { key: 'TbdHoSo04.fiFax'}}">
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiEmail'}}"></span><span class="nsw-require-field">*</span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiEmail" name="fiEmail" class="form-control"  data-bind="value: tbdHoSo04.fiEmail, i18n: {  placeholder: { key: 'TbdHoSo04.fiEmail'}}">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiWebsite'}}"></span><span class="nsw-require-field"></span></label>
				<div class="col-md-9">
					<input ${ isView ? " disabled " : ""}  id="fiWebsite" name="fiWebsite" class="form-control"  data-bind="value: tbdHoSo04.fiWebsite, i18n: {  placeholder: { key: 'TbdHoSo04.fiWebsite'}}"></i>
				</div>
			</div>
		</div>

		<div class='col-md-6 form-group'>
			<div class='row'>
				<label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiNhapKhauSach'}}"></span><span class="nsw-require-field"></span></label>
				<div class="col-md-9">
					<select ${ isView ? " disabled " : ""} id="fiNhapKhauSach" class="form-control select2 input-medium form-control-inline"
														   data-bind="options: $root.danhMucCuaKhaus,  optionsText: 'fiName',  optionsValue: 'fiCode' ,value: tbdHoSo04.fiNhapKhauSach"></select>
					<p class='validationMessage' data-bind="validationMessage: tbdHoSo04.fiNhapKhauSach"></p>
				</div>
			</div>
		</div>

	</div>
</div>