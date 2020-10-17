<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<span><b><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa"></spring:message></b></span>
</div>
<div class="table-re">
	<table class="table table-striped table-bordered table-hover table-checkable order-column">
		<thead class="nsw-tr tr-nsw1-bgcolor">
			<th class="text-center" width="5%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th01"></spring:message><span class="nsw-require-field"></span></th>
			<th class="text-center" width="15%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th02"></spring:message><span class="nsw-require-field">*</span></th>
			<th class="text-center" width="10%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th03"></spring:message><span class="nsw-require-field">*</span></th>
			<th class="text-center" width="10%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th04"></spring:message>(%)<span class="nsw-require-field">*</span></th>
			<th class="text-center" width="10%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th05"></spring:message><span class="nsw-require-field">*</span></th>
			<th class="text-center" width="10%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th06"></spring:message><span class="nsw-require-field">*</span></th>
			<th class="text-center" width="10%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th07"></spring:message><span class="nsw-require-field">*</span></th>
			<th class="text-center" width="10%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th08"></spring:message><span class="nsw-require-field">*</span></th>
			<th width="10%" class="text-center" width="20%"><spring:message code="moit.06.form.thongtinhanghoa.danhsachhanghoa.table.th09"></spring:message></th>
		</thead>
		<tbody data-bind="foreach: { data: hangHoas, as: 'item' }">
			<tr>
				<td align="center" data-bind="text: $index() + 1"></td>
				<td><input class="form-control" type="text" data-bind="value: item.tenHangHoa, attr: { 'id': 'hangHoa_tenHangHoa_' + $index()}, enable: item.enable()"></td>
				<td><select class="form-control select5" data-bind="options: $root.tienChats,  optionsText: 'name',  optionsValue: 'congThucHoaHoc',value: item.tenTCTN, attr: { 'id': 'hangHoa_tenTCTN_' + $index()}, enable: item.enable()"></select></td>
				<td><input class="form-control" type="text" data-bind="value: item.hamLuong, attr: { 'id': 'hangHoa_hamLuong_' + $index()}, enable: item.enable(), valueUpdate: 'afterkeydown', event: { keypress: $root.hamLuongNumberInputKeyPressEvent.bind($data, item.hamLuong()), keydown: $root.keypressdownHamLuong }"></td>
				<td><select class="form-control select5" data-bind="options: $root.trangThaiHangHoas,  optionsText: 'name',  optionsValue: 'value', value: item.trangThai, attr: {'id': 'hangHoa_trangThai_' + $index()}, enable: item.enable()"></select></td>
				<td><input class="form-control" type="text" data-bind="value: item.chiTiet, attr: { 'id': 'hangHoa_chiTiet_' + $index()}, enable: item.enable()">
				
				</td>
				<td><input class="form-control" type="text" data-bind="value: item.soLuong, attr: { 'id': 'hangHoa_soLuong_' + $index()}, enable: item.enable(), valueUpdate: 'afterkeydown', event: { keypress: $root.soLuongNumberInputKeyPressEvent.bind($data, item.soLuong()) , keydown: $root.keypressdownSoLuong }"></td>
				<td><select class="form-control select5" data-bind="options: $root.donViTinhs,  optionsText: 'name',  optionsValue: 'value', value: item.donViTinh, attr: {'id': 'hangHoa_donViTinh_' + $index()}, enable: item.enable()"></select></td>
				<td align="center" data-bind="if:(!$root.xemHoSo())">
					<span data-bind="if: (item.update())">
						<a   data-bind="click: $root.updateHangHoa"> <i class="fa fa-save" aria-hidden="true"></i>
							</a>
					</span>
					<span data-bind="if: (!item.enable() && $root.hangHoas().length - 1 != $index() && $root.saveFast())">

						&nbsp;&nbsp;&nbsp;
						<a    data-bind="click: $root.editHangHoa"> <i class="fa fa-edit" aria-hidden="true"></i>
							</a>
						&nbsp;&nbsp;&nbsp;
						<a style="color: red; font-weight: bold;"  title="<spring:message code="moit.06.form.tiente.button.xoa" />"  data-bind="click: $root.deleteHangHoa">
						<i class="fa fa-lg fa-close tooltips" aria-hidden="true"></i>
							</a>
					</span>
					<span data-bind="if: ($root.hangHoas().length - 1 == $index())"> 
						<a   data-bind="click: $root.addHangHoa"> <i class="fa fa-plus ic-plus" aria-hidden="true"></i>
							</a>
					</span>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="alert alert-danger">
		<strong>Ghi chú: Cột thông tin <u>Chi tiết</u> nhập số hợp đồng hoặc đơn đặt hàng hoặc hóa đơn và ngày tháng năm!</strong>
	</div>
</div>