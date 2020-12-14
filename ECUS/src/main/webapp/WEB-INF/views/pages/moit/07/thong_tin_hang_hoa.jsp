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
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label for="inputPassword" class="col-sm-4 text-right"><spring:message code="moit.06.form.thongtinhanghoa.01"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<textarea rows="3" id="thongTinHangHoaModel_mucDich" class="form-control form-control-inline " data-bind="value: thongTinHangHoaModel.mucDich, enable: !thongTinHangHoaModel.xemHoSo()"></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 text-right"><spring:message code="moit.06.form.thongtinhanghoa.02"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-8">
				<div class="row" data-bind="foreach: { data: thongTinHangHoaModel.cuaKhaus, as: 'item' }">
					<div class="form-group">
						<div class="col-sm-6">
							<select class="form-control select5" data-bind="options: $root.cuaKhaus,  optionsText: 'tenCuaKhau',  optionsValue: 'maCuaKhau',value: item.maCuaKhau, attr: { 'id': 'thongTinHangHoa_cuaKhau_' + $index()},event: { change: $root.selectCuaKhauChangeEvent.bind($data, item, $index())}, valueAllowUnset: true, enable: !$root.thongTinHangHoaModel.xemHoSo()"></select>
						</div>
						<div class="col-sm-1">
							<div class="row" data-bind="if:(!$root.thongTinHangHoaModel.xemHoSo())">
								<span data-bind="if: (( item.idCuaKhau() > -1))"> 
								<a data-bind="click: $root.deleteCuaKhau"><img src='<c:url value="/app/moit/06/icon/xbutton.png"  />' /></a>
								</span> <span data-bind="if: ($root.thongTinHangHoaModel.cuaKhaus().length - 1 == $index())"> <a data-bind="click: $root.addCuaKhau"><img src='<c:url value="/app/moit/06/icon/Add.png"  />' /></a>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 text-right"><spring:message code="moit.06.form.thongtinhanghoa.03"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-8">
				<div class="row" data-bind="foreach: { data: thongTinHangHoaModel.phuongTiens, as: 'item' }">
					<div class="form-group">
						<div class="col-sm-6">
							<select class="form-control select5" data-bind="options: $root.phuongTiens,  optionsText: 'tenPhuongTien',  optionsValue: 'idPhuongTien',value: item.loaiPhuongTien, attr: { 'id': 'thongTinHangHoa_phuongTien_' + $index()}, event: { change: $root.selectPhuongTienChangeEvent.bind($data, item, $index())}, enable: !$root.thongTinHangHoaModel.xemHoSo()"></select>
						</div>
						<div class="col-sm-1">
							<div class="row" data-bind="if:(!$root.thongTinHangHoaModel.xemHoSo())">
								<span data-bind="if: ((item.idPhuongTien() > -1))"> <a data-bind="click: $root.deletePhuongTien"><img src='<c:url value="/app/moit/06/icon/xbutton.png"  />' /></a>
								</span> <span data-bind="if: ($root.thongTinHangHoaModel.phuongTiens().length - 1 == $index())"> <a data-bind="click: $root.addPhuongTien"><img src='<c:url value="/app/moit/06/icon/Add.png"  />' /></a>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-4">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-6 "><spring:message code="moit.07.form.thongtinhanghoa.04"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-6">
						<input id="thongTinHangHoaModel_xuatNhapKhauTuNgay" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" data-bind="value: thongTinHangHoaModel.xuatNhapKhauTuNgay, enable: !$root.thongTinHangHoaModel.xemHoSo()" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-6 "><spring:message code="moit.07.form.thongtinhanghoa.05"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-6">
						<input id="thongTinHangHoaModel_xuatNhapKhauDenNgay" class="form-control form-control-inline  date-picker" data-date-format="dd/mm/yyyy" size="16" data-bind="value: thongTinHangHoaModel.xuatNhapKhauDenNgay, enable: !$root.thongTinHangHoaModel.xemHoSo()" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-6 "><spring:message code="moit.07.form.thongtinhanghoa.06"></spring:message><span class="nsw-require-field"></span></label>
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
			<label for="inputPassword" class="col-sm-2 text-right"><spring:message code="moit.07.form.thongTinChung.noiLamTT"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-8">
				<div class="row" data-bind="foreach: { data: thongTinHangHoaModel.haiQuans, as: 'item' }">
					<div class="form-group">
						<div class="col-sm-6">
							<select class="form-control select5" data-bind="options: $root.haiQuans,  optionsText: 'tenHaiQuan',  optionsValue: 'maHaiQuan',value: item.maHaiQuan, attr: { 'id': 'thongTinHangHoa_haiQuan_' + $index()}, event: { change: $root.selectHaiQuanChangeEvent.bind($data, item, $index())}, enable: !$root.thongTinHangHoaModel.xemHoSo()"></select>
						</div>
						<div class="col-sm-2">
							<div class="row" data-bind="if:(!$root.thongTinHangHoaModel.xemHoSo())">
								<span data-bind="if: ((item.idHaiQuan() > -1))"> <a data-bind="click: $root.deleteHaiQuan"><img src='<c:url value="/app/moit/06/icon/xbutton.png"  />' /></a>
								</span> <span data-bind="if: ($root.thongTinHangHoaModel.haiQuans().length - 1 == $index())"> <a data-bind="click: $root.addHaiQuan"><img src='<c:url value="/app/moit/06/icon/Add.png"  />' /></a>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
