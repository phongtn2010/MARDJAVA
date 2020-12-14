<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="import_package.jsp"%>
<%
	TbdHSDeNghiCapGiayXn1 form = (TbdHSDeNghiCapGiayXn1) request.getAttribute("form");
%>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-checkable order-column" id="pheLieuNhapKhau">
		<thead class="nsw-tr tr-nsw1-bgcolor">
			<th class="text-center thong-tin-phe-lieu-nhap-table-th1"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau.stt"></spring:message></th>
			<th class="text-center"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau.tenPheLieu"></spring:message></th>
			<th class="text-center"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau.maHS"></spring:message></th>
			<th class="text-center"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau.klCongSuat"></spring:message><span class="nsw-require-field">(*)</span></th>
			<th class="text-center thong-tin-phe-lieu-nhap-table-th5"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau.khoiLuong"></spring:message><span class="nsw-require-field">(*)</span></th>
			<c:if test="<%=AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04%>">
				<th class="text-center thong-tin-phe-lieu-nhap-table-th6"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau.toChuCaNhan"></spring:message><span class="nsw-require-field">(*)</span></th>
			</c:if>
			<th class="text-center thong-tin-phe-lieu-nhap-table-th7"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau.chucNang"></spring:message></th>
		</thead>
		<tbody id="pheLieuNhapKhauBody2" data-bind="foreach: { data: dsPheLieu, as: 'item' }">
			<tr data-bind="attr: { id: 'pheLieuNhapKhauBody2Tr' + item.index() }">
				<td style="text-align: center;" data-bind="text: item.soThuTu"></td>
				<td data-bind="attr: { id: 'pheLieuNhapKhauBody2Td0-' + item.index() }"><select class="form-control select3" data-bind="options: $root.danhSachPheLieu,  optionsText: 'tenPheLieu',  optionsValue: 'tenPheLieu2', value: item.tenPheLieu2, attr: { 'id': 'thongTinPheLieus' +  (item.index()) + 'tenPheLieu'},  event:{ change: $root.chonTenPheLieuChangeEvent.bind($data, 'thongTinPheLieus' +  (item.index()) + 'tenPheLieu', 'thongTinPheLieus' +  (item.index()) + 'maHS', 'pheLieuNhapKhauBody2Td1-' + item.index() ) }, enable: item.enable()"></select>
					<p class="validationMessage" data-bind="validationMessage: item.tenPheLieu2"></p></td>
				<td data-bind="attr: { id: 'pheLieuNhapKhauBody2Td1-' + item.index() }"><select class="form-control select4" disabled="disabled" data-bind="options: $root.danhSachPheLieu,  optionsText: 'maHS',  optionsValue: 'maHS2', value: item.maHS2, attr: {  'id': 'thongTinPheLieus' +  (item.index()) + 'maHS'}, event:{ change: $root.chonMaHSChangeEvent.bind($data, 'thongTinPheLieus' +  (item.index()) + 'tenPheLieu', 'thongTinPheLieus' +  (item.index()) + 'maHS', 'pheLieuNhapKhauBody2Td0-' + item.index() ) }, enable: item.enable()">
				</select></td>
				<%--<!-- ko if: item.khoiluong6 != null || item.khoiluong6 != '' -->
				<td align="right">
					<div class=" td-input-03">
						<input class="form-control text-right" type="text" data-bind="enable: item.enable(), value: item.khoiLuong6, attr: { }, valueUpdate: 'keypress', event: { keypress: $root.numberInputKeyPressEvent.bind($data, item.khoiLuong6()) }">
					</div>
				</td>
				<!-- /ko -->--%>
				<td align="right">
					<div class=" td-input-03">
						<input class="form-control text-right" type="text" data-bind="enable: item.enable(), value: item.klCongSuat, attr: { }, valueUpdate: 'keypress', event: { keypress: $root.numberInputKeyPressEvent.bind($data, item.klCongSuat()) }">
					</div>
				</td>
				<td align="right">
					<div class=" td-input-03">
						<input class="form-control text-right" style="text-align: right;" type="text" data-bind="value: item.khoiLuong, attr: { }, enable: item.enable(), valueUpdate: 'keypress', event: { keypress: $root.numberInputKeyPressEvent.bind($data, item.khoiLuong()) }">
					</div>
				</td>
				<c:if test="<%=AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04%>">
					<td>
						<div class=" td-input-03">
							<input class="form-control" type="text" data-bind="value: item.donViUyThac2, enable: item.enable()">
						</div>
					</td>
				</c:if>
				<td>
					<div class="pl-td-chuc-nang">
						<c:if test="<%=form != null && !form.isXemHoSo()%>">
							<span data-bind="if: item.enable() && $root.dsPheLieu().length - 1 != $index()">
								<button type="button" class="btn green bt-center" data-bind="click: $root.capNhatThongTinDongPheLieu" id="btCapNhatThongTinDongPheLieu">
									<i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;
									<spring:message code="monre_01_danh_muc_co_sx_button_luu_lai" />
								</button>
							</span>
							<span data-bind="if:  item.canUpdate() && !item.enable() && $root.dsPheLieu().length - 1 != $index()"> <a class="btn green bt-center" title="<spring:message code="monre_01_button_title_update" />" data-bind="click: $root.capNhatDongPheLieuNhapClick" id="btCapNhatDongPheLieu"> <i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp; <spring:message code="monre_01_button_title_update" />
							</a>
							</span>
							<span data-bind="if:  item.canDelete() && $root.dsPheLieu().length - 1 != $index()"> <a class="btn red bt-center" title="<spring:message code="monre_01_button_title_delete" />" data-bind="click: $root.xoaDongPheLieuNhapClick" id="btXoaDongPheLieu"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp; <spring:message code="monre_01_button_title_delete" />
							</a>
							</span>
							<span data-bind="if: $root.dsPheLieu().length - 1 == $index()">
								<button type="button" class="btn green bt-center" data-bind="click: $root.themDongNhapPheLieu" id="btThemDongPheLieu">
									<i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;
									<spring:message code="monre_01_danh_muc_co_sx_button_luu_lai" />
								</button>
							</span>
						</c:if>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>