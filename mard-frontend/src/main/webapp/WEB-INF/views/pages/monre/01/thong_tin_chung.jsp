<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="import_package.jsp"%>
<style>
.form-group {
	margin-bottom: 15px;
	float: left;
	width: 100%;
}
</style>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.maCoQuan"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<select id="maCoQuan" class="form-control select2" data-bind="options: danhSachCoQuanXuLy, optionsText: 'tenCoQuan',  optionsValue: 'maCoQuan', value: thongTinChungModel.maCoQuan, enable: thongTinChungModel.enable(), event:{ change: $root.chonCoQuanXuLyChangeEvent }">
						</select>
						<p class="validationMessage" data-bind="validationMessage: thongTinChungModel.tenCoQuan"></p>
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.tenDN"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="tenDN" disabled="disabled" class="form-control" name="tenDN" data-bind="value: thongTinChungModel.tenDN" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.truSoChinh"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="truSoChinh" disabled="disabled" class="form-control" name="truSoChinh" data-bind="value: thongTinChungModel.truSoChinh" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.soDTNguoiDaiDien"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="soDTNguoiDaiDien" disabled="disabled" class="form-control" name="soDTNguoiDaiDien" data-bind="value: thongTinChungModel.soDTNguoiDaiDien" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.emailNguoiDaiDien"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="emailNguoiDaiDien" class="form-control" name="emailNguoiDaiDien" data-bind="value: thongTinChungModel.emailNguoiDaiDien, enable: !$root.xemHoSo()" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.ngayCapGCNDKKD"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input data-date-format="dd/mm/yyyy" id="ngayCapGCNDKKD" class="form-control date-picker" name="ngayCap" data-bind="value: thongTinChungModel.ngayCapGCNDKKD, enable: !$root.xemHoSo()" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.maSoThue"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="maSoThue" disabled="disabled" class="form-control" name="maSoThue" data-bind="value: thongTinChungModel.maSoThue" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.nguoiDaiDien"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="nguoiDaiDien" class="form-control" name="nguoiDaiDien" data-bind="value: thongTinChungModel.nguoiDaiDien, enable: !$root.xemHoSo()" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.faxNguoiDaiDien"></spring:message><span class="nsw-require-field"></span></label>
					<div class="col-sm-8">
						<input id="faxNguoiDaiDien" class="form-control" name="faxNguoiDaiDien" data-bind="value: thongTinChungModel.faxNguoiDaiDien, enable: !$root.xemHoSo()" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.soGCNDKKD"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="soGCNDKKD" disabled="disabled" class="form-control" name="soGCNDKKD" data-bind="value: thongTinChungModel.soGCNDKKD" />
					</div>
				</div>
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="monre.01.label.thong-tin-chung.noiCapGCNDKKD"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="noiCapGCNDKKD" class="form-control" name="noiCapGCNDKKD" data-bind="value: thongTinChungModel.noiCapGCNDKKD, enable: !$root.xemHoSo()" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
