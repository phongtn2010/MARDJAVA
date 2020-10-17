<%@page import="com.nsw.sbv.p01.model.HoSoNgoaiTeEditForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.form-group {
	margin-bottom: 15px;
	float: left;
	width: 100%;
}

.ic-plus {
	padding: 4px 3px;
}
</style>
<%
	HoSoNgoaiTeEditForm form = (HoSoNgoaiTeEditForm) request.getAttribute("form");
%>
<p>
	<b><spring:message code="sbv.01.form.51"></spring:message></b>
</p>
<div class="col-md-12 ">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label  for="inputPassword" class="col-sm-4 "><spring:message code="sbv.01.form.32"></spring:message></label>
					<div class="col-sm-8">
						<spring:message code='sbv.01.message.nhapkhau' var="nhapkhau" />
						<label class="radio-inline"> <input type="radio" name=hinhThucXNK value="1" data-bind="checked: $root.thongTinNgoaiTeModel.hinhThucXNK"> <spring:message code='sbv.01.message.nhapkhau' />
						</label>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label for="inputPassword" class="col-sm-4 "></label>
					<div class="col-sm-8">
						<label class="radio-inline"> <input type="radio" name="hinhThucXNK" value="2" data-bind="checked: $root.thongTinNgoaiTeModel.hinhThucXNK"> <spring:message code='sbv.01.message.xuatkhau' />
						</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label  for="inputPassword" class="col-sm-2 "><spring:message code="sbv.01.form.33"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-10">
				<select id="maCuaKhau" class="form-control select2" data-bind="options: dsCuaKhau,  optionsText: 'tenCuaKhau',  optionsValue: 'maCuaKhau',value: thongTinNgoaiTeModel.maCuaKhau"></select>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label  for="xuatNhapKhauTuNgay" class="col-sm-4 "><spring:message code="sbv.01.form.34"></spring:message></label>
					<div class="col-sm-8">
						<input autocomplete="off" id="xuatNhapKhauTuNgay" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: thongTinNgoaiTeModel.xuatNhapKhauTuNgay, dateInput" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label  for="xuatNhapKhauDenNgay" class="col-sm-4"><spring:message code="sbv.01.form.44"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input  autocomplete="off" id="xuatNhapKhauDenNgay" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: thongTinNgoaiTeModel.xuatNhapKhauDenNgay, dateInput" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<div class="col-md-4">
					<div class="checkbox">
							<label><input autocomplete="off"  id="capGiayPhepLanDau" name="capGiayPhepLanDau" value="true" type="radio" data-bind=" checked: $root.thongTinNgoaiTeModel.capGiayPhepLanDau, event:{ change: $root.capGiayPhepLanDauClick}"> <spring:message code="sbv.01.form.35"></spring:message></label>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="checkbox">
							<label><input autocomplete="off"  id="capGiayPhepLanDau" name="capGiayPhepLanDau" value="false" type="radio" data-bind=" checked: thongTinNgoaiTeModel.capGiayPhepLanDau, event:{ change: $root.capGiayPhepLanDauClick}"> <spring:message code="sbv.01.form.35b"></spring:message></label>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label  for="inputPassword" class="col-sm-4 "><spring:message code="sbv.01.form.36"></spring:message><span class="nsw-require-field"></span></label>
					<div class="col-sm-8">
							<input id="soGiayPhepDaCap" autocomplete="off"  class="form-control form-control-inline input-medium " type="text" data-bind="value: thongTinNgoaiTeModel.soGiayPhepDaCap, enable: $root.thongTinNgoaiTeModel.capGiayPhepLanDau() == 'false' ? true:false" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label  for="inputPassword" class="col-sm-2 "><spring:message code="sbv.01.form.37"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-10">
				<input id="doiTacXuatNhapKhau" 
					class="form-control form-control-inline" autocomplete="off"  data-bind="textInput: thongTinNgoaiTeModel.doiTacXuatNhapKhau, valueAllowUnset: true, valueUpdate: afterkeydown" />
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label  for="inputPassword" class="col-sm-2 ">Ngoại tệ nhờ thu</label>
			<div class="col-sm-10">
				<textarea id="ghiChu" 
				 rows="3"	class="form-control form-control-inline" autocomplete="off"  data-bind="textInput: thongTinNgoaiTeModel.ghiChu, valueAllowUnset: true, valueUpdate: afterkeydown" ></textarea>
			</div>
		</div>
	</div>
</div>
<p>
	<b><spring:message code="sbv.01.form.45"></spring:message></b> <span class="nsw-require-field">*</span>
</p>
<div class="col-md-12">
	<div class="row table-responsive">
		<table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
			<thead>
				<tr class="nsw-tr tr-nsw1-bgcolor">
					<th class="text-center"><spring:message code="sbv.01.form.38"></spring:message></th>
					<th class="text-center" ><spring:message code="sbv.01.form.39"></spring:message></th>
					<th class="text-center"><spring:message code="sbv.01.form.40"></spring:message></th>
					<th class="text-center" ><spring:message code="sbv.01.form.41"></spring:message></th>
					<th class="text-center" width="20%"><spring:message code="sbv.01.form.42"></spring:message></th>
				</tr>
			</thead>
			<tbody data-bind="foreach: { data: danhSachTienTe, as: 'item' }">
				<tr>
					<input type="hidden" data-bind="value: item.idTienTe,attr: { 'name': 'tienTes['+ (item.soThuTu() - 1) +'].idTienTe'}">
					<td class="text-center" data-bind="text: item.soThuTu"></td>
					<td width="20%"><input autocomplete="off" name="soLuongNgoaiTeBangSo" class="form-control form-control-inline text-right" data-bind="valueUpdate: 'afterkeydown', textInput: item.soLuongNgoaiTeBangSo, attr: { 'id': 'tienTes_'+ (item.soThuTu() - 1) +'_soLuongNgoaiTeBangSo'}, valueUpdate: 'keypress', event: { keypress: $root.numberInputKeyPressEvent.bind($data, item, item.soLuongNgoaiTeBangSo()),  keyup: $root.numberInputKeyUpEvent.bind($data, item, item.soLuongNgoaiTeBangSo()) }, numberFormatInput"></td>
					<td><textarea rows="1" autocomplete="off" name="soLuongNgoaiTeBangChu" id="soLuongNgoaiTeBangChu" class="form-control form-control-inline " data-bind="value: item.soLuongNgoaiTeBangChu, attr: { 'id': 'tienTes_'+ (item.soThuTu() - 1) +'_soLuongNgoaiTeBangChu'}, textFormatInput"></textarea></td>
					<td><select class="form-control  select5" data-bind="options: $root.dsLoaiTienTe,  optionsText: 'tenLoaiTienTe', optionsValue: 'maLoaiTienTe', value: item.maLoaiTienTe, attr: { 'id': 'tienTes_'+ (item.soThuTu() - 1) +'_maLoaiTienTe'}">
					</select></td>
					<td class="text-center"><span data-bind="if: ($root.showButtonAdd() && ($root.danhSachTienTe().length == $index() + 1))"> <a title="<spring:message code="sbv.01.form.tiente.button.them" />" class="btn green bt-center" data-bind="click: $root.saveItem.bind($data, item)"> <i class="fa fa-plus ic-plus" aria-hidden="true"></i>
						</a>
					</span><span data-bind="if: item.isDelete() === true"> <a title="<spring:message code="sbv.01.form.tiente.button.xoa" />" class="btn red bt-center" data-bind="click: $root.deleteItem.bind($data, item)"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
					</span></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	
</div>
