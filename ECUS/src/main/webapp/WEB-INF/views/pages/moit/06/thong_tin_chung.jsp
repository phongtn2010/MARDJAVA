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
</style>
<div class="row">
	<div class="col-md-12">
		<div class="panel-heading">
			<span class="caption-subject bold uppercase"><spring:message code="moit.06.label.thongTinHoSo"></spring:message> </span>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
				<div class="col-md-6">
						<div class="row">
							<div class="form-group">
								<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.maHoSo"></spring:message><span class="nsw-require-field"></span>:</label>
								<div class="col-sm-8">
										<lable><b data-bind="text: $root.maHoSo()"></b></lable>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="row">
							<div class="form-group">
								<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.tenTrangThai"></spring:message><span class="nsw-require-field"></span>:</label>
								<div class="col-sm-8">
									<lable><b data-bind="text: $root.trangThaiHoSo()"></b></lable>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="panel-heading">
			<span class="caption-subject bold uppercase"><spring:message code="moit.06.form.01"></spring:message> </span>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.01"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_tenDoanhNghiep" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.tenDoanhNghiep" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.02"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_maSoThue" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.maSoThue" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4"><spring:message code="moit.06.form.thongtinchung.03"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_diaChiDoanhNghiep" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.diaChiDoanhNghiep" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.04"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_dienThoai" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.dienThoai" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.05"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_fax" class="form-control form-control-inline " data-bind="value: thongTinChungModel.fax, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.06"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_email" class="form-control form-control-inline " data-bind="value: thongTinChungModel.email, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.noiCapCNKD"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_noiCapGiayChungNhanDKKD"  class="form-control form-control-inline " data-bind="value: thongTinChungModel.noiCapGiayChungNhanDKKD" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.tenNguoiDD"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_tenNguoiDaiDien" class="form-control form-control-inline"  type="text"  data-bind="value: thongTinChungModel.tenNguoiDaiDien, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.nguoiDDChucVu"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_daiDienChucVu" class="form-control form-control-inline " data-bind="value: thongTinChungModel.daiDienChucVu" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.nguoiDDNgaySinh"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_daiDienNamSinh" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" placeholder="dd/mm/yyyy" data-bind="value: thongTinChungModel.daiDienNamSinh, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.nguoiDDGioiTinh"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_daiDienGioiTinh" class="form-control select2" data-bind="options: gioiTinhs,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.daiDienGioiTinh, enable: !thongTinChungModel.xemHoSo()"></select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.nguoiDDDiaChiTT"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_daiDienDiaChi" class="form-control form-control-inline"  type="text"  data-bind="value: thongTinChungModel.daiDienDiaChi, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.07"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_soGiayChungNhanDKKD" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.soGiayChungNhanDKKD" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.08"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_ngayCapGiayChungNhan" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: thongTinChungModel.ngayCapGiayChungNhan, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.09"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_loaiHinh" class="form-control select2" data-bind="options: loaiHinhs,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.loaiHinh, enable: !thongTinChungModel.xemHoSo()"></select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.nguoiDDTinhTP"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_maTinh" class="form-control select2" data-bind="options: provinces,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.maTinhTP, enable: !thongTinChungModel.xemHoSo()"></select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="row">
						<div class="form-group">
							<label style="text-align: right;" for="inputPassword" class="col-sm-2 "><spring:message code="moit.06.form.thongtinchung.10"></spring:message><span class="nsw-require-field">*</span></label>
							<div class="col-sm-10">
								<input id="thongTinChungModel_diaChiSanXuat" class="form-control form-control-inline " data-bind="value: thongTinChungModel.diaChiSanXuat, enable: !thongTinChungModel.xemHoSo()" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.11"></spring:message><span class="nsw-require-field"></span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_soGiayPhepTCTN" class="form-control form-control-inline " data-bind="value: thongTinChungModel.soGiayPhepTCTN, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.12a"></spring:message><span class="nsw-require-field"></span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_ngayCapGiayPhepTCTN" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: thongTinChungModel.ngayCapGiayPhepTCTN, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.form.thongtinchung.13"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_loaiGiayPhep" class="form-control select2" data-bind="options: loaiHoSos,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.loaiGiayPhep, enable: !thongTinChungModel.xemHoSo(), alueUpdate: afterkeydown"></select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
