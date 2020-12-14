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

.search-item-hover:hover {
	background: #dccece;
	cursor: pointer;
}
</style>
<div class="row">
	<div class="col-md-12">
		<div class="panel-heading">
			<span class="caption-subject bold uppercase"><spring:message code="moit.07.label.thongTinHoSo"></spring:message> </span>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-6">
						<div class="row">
							<div class="form-group">
								<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.label.thongTinHoSo.maHoSo"></spring:message><span class="nsw-require-field"></span>:</label>
								<div class="col-sm-8">
									<lable>
									<b data-bind="text: $root.maHoSo()"></b></lable>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="row">
							<div class="form-group">
								<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.tenTrangThai"></spring:message><span class="nsw-require-field"></span>:</label>
								<div class="col-sm-8">
									<lable>
									<b data-bind="text: $root.trangThaiHoSo()"></b></lable>
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
			<span class="caption-subject bold uppercase"><spring:message code="moit.07.form.01"></spring:message> </span>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.01"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_tenDoanhNghiep" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.tenDoanhNghiep" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.02"></spring:message><span class="nsw-require-field">*</span></label>
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4"><spring:message code="moit.07.form.thongtinchung.03"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_diaChiDoanhNghiep" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.diaChiDoanhNghiep" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.04"></spring:message><span class="nsw-require-field">*</span></label>
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.05"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_fax" class="form-control form-control-inline " data-bind="value: thongTinChungModel.fax, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.06"></spring:message><span class="nsw-require-field">*</span></label>
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.07"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_soGiayChungNhanDKKD" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.soGiayChungNhanDKKD" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.noiCap"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_noiCapGDKKD" class="form-control form-control-inline " data-bind="value: thongTinChungModel.noiCapGDKKD" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.08"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_ngayCapGiayChungNhan" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="value: thongTinChungModel.ngayCapGiayChungNhan, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.09"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_loaiHinh" class="form-control select2" data-bind="options: loaiHinhs,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.loaiHinh, enable: !thongTinChungModel.xemHoSo()"></select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="row">
						<div class="form-group">
							<label style="text-align: right;" for="inputPassword" class="col-sm-2 "><spring:message code="moit.07.form.thongtinchung.10"></spring:message><span class="nsw-require-field">*</span></label>
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.diaChiNSX"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_dienThoaiNoiSanXuat" class="form-control form-control-inline " data-bind="value: thongTinChungModel.dienThoaiNoiSanXuat, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.faxNSX"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_faxNoiSanXuat" class="form-control form-control-inline " data-bind="value: thongTinChungModel.faxNoiSanXuat, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.13"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_loaiGiayPhep" class="form-control select2" data-bind="options: loaiHoSos,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.loaiGiayPhep, enable: $root.changeLoaiHoSo() && !thongTinChungModel.xemHoSo()"></select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.hinhThuxXNK"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_hinhThucXNK" class="form-control select2" data-bind="options: hinhThucXNKs,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.hinhThucXNK, enable: !thongTinChungModel.xemHoSo(), event: {change: $root.selectLoaiHoSoChangeEvent}"></select>
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.tenNguoiDD"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_tenNguoiDaiDien" class="form-control form-control-inline " data-bind="value: thongTinChungModel.tenNguoiDaiDien, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.tenNguoiLH"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_tenNguoiLienHe" class="form-control form-control-inline " data-bind="value: thongTinChungModel.tenNguoiLienHe, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.dienThoaiNLH"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_dienThoaiNguoiLienHe" class="form-control form-control-inline " data-bind="value: thongTinChungModel.dienThoaiNguoiLienHe, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongTinChung.emailNLH"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_emailNguoiLienHe" class="form-control form-control-inline " data-bind="value: thongTinChungModel.emailNguoiLienHe, enable: !thongTinChungModel.xemHoSo()" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12" data-bind="attr: {'style': ($root.thongTinChungModel.loaiGiayPhep() =='2') ? 'display:block;' : 'display:none;'}">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.14"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_soGiayPhepDaCap" name="maSoGP" class="form-control form-control-inline" type="text" data-bind="value: thongTinChungModel.soGiayPhepDaCap,  valueUpdate: 'afterkeydown', enable: $root.editSoGP() && !thongTinChungModel.xemHoSo()" />
										<div class="" style="background: #f4f4f5; box-shadow: 1px 1px 1px #98a0af;">
											<div style="display: none" data-bind="attr:{ 'style': $root.searching() ? 'display:block;' : 'display: none'}">
												<div class="" data-bind="foreach: { data: $root.findGPs, as: 'item' }">
													<p class="search-item-hover" style="display: block; padding: 10px; border-bottom: 1px solid #c1b6b6;" data-bind="text:item, click: $root.searchItemClick"></p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="form-group">
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.07.form.thongtinchung.15"></spring:message><span class="nsw-require-field"></span></label>
									<div class="col-sm-8">
										<input id="thongTinChungModel_lyDoGiaHan" class="form-control form-control-inline " data-bind="value: thongTinChungModel.lyDoGiaHan, enable: !thongTinChungModel.xemHoSo()" />
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
									<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="moit.06.label.thongTinHoSo.nguoiDDTinhTP"></spring:message><span class="nsw-require-field">*</span></label>
									<div class="col-sm-8">
										<select id="thongTinChungModel_maTinh" class="form-control select2" data-bind="options: provinces,  optionsText: 'name',  optionsValue: 'value',value: thongTinChungModel.maTinhTP, enable: !thongTinChungModel.xemHoSo()"></select>
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
