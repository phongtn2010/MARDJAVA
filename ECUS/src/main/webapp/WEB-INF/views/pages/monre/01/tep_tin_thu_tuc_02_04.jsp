<%@ include file="import_package.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
TbdHSDeNghiCapGiayXn1 form = (TbdHSDeNghiCapGiayXn1)request.getAttribute("form");
%>
<tbody>
	<%
		for (int i = 1; i <= 3; i++) {
			
			String code = "monre.01.label.tep-dinh-kem.tt01.tep-loai-thuc-tuc-02-04-" + i;
			
			int loaiTepTin = 1;
			
			if (i == 2 ) loaiTepTin = 6;
			else if (i == 3) loaiTepTin = 8;
			
	%>
	<tr>
		<td align="center"><label class="label-control"><%= String.valueOf(i) %></label></td>
		<td class="td-left"><label class="label-control"><spring:message code="<%= code %>"></spring:message> <c:if test="<%= i < 3 %>">
					<span class="nsw-require-field">(*)</span>
				</c:if></label></td>
		<td class="td-left"><c:if test="<%= form != null && !form.isXemHoSo() && form.getIdHS() > 0 %>">
				<input type="file" id="fileUpload<%= loaiTepTin %>" multiple="multiple" accept=".jpg, .pdf, .doc, .tif" data-bind=" event:{ change: $root.uploadFileChangeEvent.bind($data, <%= loaiTepTin == 8 ? -1 : loaiTepTin %>, 'fileUpload<%= loaiTepTin %>') }">
				</div>
			</c:if>
			<div data-bind="visiable: false, foreach: { data: tepTinModel.tepLoai<%= loaiTepTin %>(), as: 'item' }">
				<p style="margin-top: 15px;" data-bind="if: item.tenTepTin != null">
					<a class="a" data-bind="attr: { 'href': item.link, 'title': item.tenTepTin }"><b><i><span data-bind="text: item.name"></span></i></b></a>
					<c:if test="<%= form != null && !form.isXemHoSo() %>">
						<a href="javascript:;" data-bind="click: $root.xoaMotFile"> <i class="fa fa-lg fa-remove tooltips"></i>
						</a>
					</c:if>
				</p>
			</div></td>
		<td align="center"><c:if test="<%= form != null && !form.isXemHoSo() %>">
				<p style="border: 0px solid;" align="center">
				<p data-bind="if: tepTinModel.tepLoai<%= loaiTepTin %>().length > 0">
					<a class="btn red bt-center" title="<spring:message code="monre_01_button_title_delete" />" data-bind="click: xoaTepTin.bind($data, <%= loaiTepTin == 8 ? -1 : loaiTepTin %>)"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp; <spring:message code="monre_01_button_title_delete" />
					</a>
				</p>
			</c:if></td>
	</tr>
	<% } %>
</tbody>