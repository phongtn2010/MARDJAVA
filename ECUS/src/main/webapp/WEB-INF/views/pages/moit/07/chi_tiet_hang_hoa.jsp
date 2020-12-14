<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<span><b><spring:message code="moit.07.form.thongtinhanghoa.danhsachhanghoa"></spring:message></b></span> <a data-bind="click: $root.addHangHoa.bind($data, null)"><img src='<c:url value="/app/moit/06/icon/Add.png"  />' /></a>
</div>
<style>
	.t300 {
		width: 300px;
	}
</style>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-checkable order-column">
		<thead class="nsw-tr tr-nsw1-bgcolor">
			<th class="text-center" ><spring:message code="moit.07.form.thongtinhanghoa.danhsachhanghoa.table.th01"></spring:message></th>
			<th class="text-center t300"><spring:message code="moit.07.form.cthanghoa.maCSA"></spring:message></th>
			<th class="text-center t300" ><spring:message code="moit.07.form.cthanghoa.maHSChat"></spring:message></th>
			<th class="text-center t300" ><spring:message code="moit.07.form.cthanghoa.tenChatTV"></spring:message></th>
			<th class="text-center t300" ><spring:message code="moit.07.form.cthanghoa.tenChatTA"></spring:message></th>
			<th class="text-center t300" ><spring:message code="moit.07.form.cthanghoa.tenKhoaHoc"></spring:message></th>
			<th class="text-center t300"><spring:message code="moit.07.form.cthanghoa.tenTM"></spring:message></th>
			<th class="text-center t300" ><spring:message code="moit.07.form.cthanghoa.maHHC"></spring:message></th>
			<th class="text-center t300" ><spring:message code="moit.07.form.cthanghoa.congThucHH"></spring:message></th>
			<th class="text-center t300"><spring:message code="moit.07.form.cthanghoa.hamLuong"></spring:message></th>
			<th  class="text-center t300"><spring:message code="moit.07.form.cthanghoa.trangT"></spring:message></th>
			<th class="text-center t300"><spring:message code="moit.07.form.cthanghoa.soLuongHH"></spring:message></th>
			<th  class="text-center t300"><spring:message code="moit.07.form.cthanghoa.donVT"></spring:message></th>
			<th class="text-center t300"><spring:message code="moit.07.form.cthanghoa.moTaHH"></spring:message></th>
			<th class="text-center"><spring:message code="moit.07.form.cthanghoa.sua"></spring:message></th>
			<th class="text-center"><spring:message code="moit.07.form.cthanghoa.xoa"></spring:message></th>
		</thead>
		<tbody data-bind="foreach: { data: hangHoas, as: 'item' }">
			<tr>
				<td class="text-center" data-bind="text: $index() + 1"></td>
				<td class="text-center" data-bind="text: item.maCAS"></td>
				<td class="text-center" data-bind="text: item.maHS"></td>
				<td class="text-center" data-bind="text: item.tenTiengViet"></td>
				<td class="text-center" data-bind="text: item.tenTiengAnh"></td>
				<td class="text-center" data-bind="text: item.tenKhoaHoc"></td>
				<td class="text-center" data-bind="text: item.tenThuongMai"></td>
				<td class="text-center" data-bind="text: item.maHonHop"></td>
				<td class="text-center" data-bind="text: item.congThucHoaHoc"></td>
				<td class="text-center" data-bind="text: item.hamLuong"></td>
				<td class="text-center" data-bind="text: item.tenTrangThaiHangHoa"></td>
				<td class="text-center" data-bind="text: item.soLuong"></td>
				<td class="text-center" data-bind="text: item.donViTinh"></td>
				<td class="text-center" data-bind="text: item.moTa"></td>
				<td class="text-center" data-bind="if: !$root.xemHoSo()"><a  data-bind="click: $root.addHangHoa.bind($data, item)"><span><i class="fa fa-edit" title="<spring:message code="moit.07.form.cthanghoa.sua"></spring:message>"></i></span></a></td>
				<td class="text-center" data-bind="if: !$root.xemHoSo()"><a data-bind="click: $root.deleteHangHoa"><span><i class="fa fa-remove" title="<spring:message code="moit.07.form.cthanghoa.xoa"></spring:message>"></i></span></a></td>
			</tr>
		</tbody>
	</table>
</div>