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
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label class="col-sm-2 text-right"><spring:message code="moit.06.form.thongtinhanghoa.01"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-10">
				<textarea rows="3"  id="thongTinHangHoaModel_mucDich" class="form-control form-control-inline " data-bind="value: thongTinHangHoaModel.mucDich, enable: !thongTinHangHoaModel.xemHoSo()"></textarea>
			</div>
		</div>
	</div>
</div>
 <%-- <div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label  class="col-sm-2 text-right"><spring:message code="moit.06.form.thongtinhanghoa.02"></spring:message><span class="nsw-require-field">*</span></label>
		
			<div class="col-sm-10">
					<select multiple="multiple" id="cuaKhaus" class="form-control select5" data-bind="options: $root.cuaKhaus(),  optionsText: 'tenCuaKhau',  optionsValue: 'maCuaKhau', selectedOptions: $root.cuaKhausSelected" ></select>
			</div>
		</div>
	</div>
</div> --%> 
	<!-- khanh note -->
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label  class="col-sm-2 text-right"><spring:message code="moit.06.form.thongtinhanghoa.02"></spring:message><span class="nsw-require-field">*</span></label>
			<!-- khanh note -->
			<div class="col-sm-10">
				<table class="col-sm-12 row">
						<td class="col-md-11"><input id="cuaKhaus" class="col-md-12" type ="text" disabled="disabled" data-bind="value: dsCKsText"></td> 
						<td class="col-md-1 text-center">				
							<button  class="btn green" data-bind="click: $root.show , enable: !thongTinHangHoaModel.xemHoSo()" >Chọn
							
							</button>															
						</div>	
						<!-- 	<a href="javascript:;" data-bind=" click: $root.show"> <i class="fa fa-plus ic-plus"></i></a> -->						
						</td>						
				</table>			
					<!-- <select multiple="multiple" id="cuaKhaus" class="form-control select5" data-bind="options: $root.cuaKhaus(),  optionsText: 'tenCuaKhau',  optionsValue: 'maCuaKhau', selectedOptions: $root.cuaKhausSelected" ></select> -->
			</div>
		</div>
	</div>
</div>

<div class="col-md-12">
	<div class="row">
		<div class="col-md-4">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;"  class="col-sm-6 "><spring:message code="moit.07.form.thongtinhanghoa.04"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-6">
						<input id="thongTinHangHoaModel_xuatNhapKhauTuNgay" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" data-bind="value: thongTinHangHoaModel.xuatNhapKhauTuNgay, enable: !$root.thongTinHangHoaModel.xemHoSo(), dateInput" autocomplete="off" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;"  class="col-sm-6 "><spring:message code="moit.07.form.thongtinhanghoa.05"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-6">
						<input id="thongTinHangHoaModel_xuatNhapKhauDenNgay" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" data-bind="value: thongTinHangHoaModel.xuatNhapKhauDenNgay, enable: !$root.thongTinHangHoaModel.xemHoSo(), dateInput" autocomplete="off" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;"  class="col-sm-6 "><spring:message code="moit.07.form.thongtinhanghoa.06"></spring:message><span class="nsw-require-field"></span></label>
					<div class="col-sm-6">
						<input id="thongTinHangHoaModel_soLanThucHien" class="form-control form-control-inline " data-bind="value: thongTinHangHoaModel.soLanThucHien, enable: !$root.thongTinHangHoaModel.xemHoSo()" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label  class="col-sm-2 text-right"><spring:message code="moit.06.form.thongtinhanghoa.03"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-10" id="phuongTiens">
				<select multiple="multiple"  class="form-control select5" data-bind="options: $root.phuongTiens(),  optionsText: 'tenPhuongTien',  optionsValue: 'loaiPhuongTien', selectedOptions: $root.phuongTiensSelected,  enable: !thongTinHangHoaModel.xemHoSo()" ></select>
			</div>
		</div>
	</div>
</div>

<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label  class="col-sm-2 text-right"><spring:message code="moit.07.form.thongTinChung.noiLamTT"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-10" id="haiQuans" >
				<select multiple="multiple"  class="form-control select5" data-bind="options: $root.haiQuans(),  optionsText: 'tenHaiQuan',  optionsValue: 'maHaiQuan', selectedOptions: $root.haiQuansSelected, enable: !thongTinHangHoaModel.xemHoSo()" ></select>
			</div>
		</div>
	</div>
</div>



