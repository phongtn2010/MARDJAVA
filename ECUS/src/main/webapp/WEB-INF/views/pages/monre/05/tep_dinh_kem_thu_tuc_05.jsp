<%@ include file="import_package.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
TbdHSDeNghiCapGiayXn5 form = (TbdHSDeNghiCapGiayXn5)request.getAttribute("form");
%>
<tbody>
	<%
	int p = 1;
		for (int i = 8; i <= 8; i++) {
			
			String code = "monre.01.label.tep-dinh-kem.tt01.tep-loai-01-03-" + i;
			
	%>
	<tr>
		<td align="center"><label class="label-control"><%= String.valueOf(p) %></label></td>
		<td class="td-left"><label class="label-control"><spring:message code="<%= code %>"></spring:message><c:if test="<%= i < 8 %>"><span class="nsw-require-field">(*)</span></c:if></label></td>
		<td class="td-left">
				<c:if test="<%= form != null && !form.isXemHoSo() && form.getIdHS() > 0 %>">
					<input type="file" id="fileUpload<%= i %>" multiple="multiple" accept=".jpg, .pdf, .doc, .tif"   data-bind=" event:{ change: $root.uploadFileChangeEvent.bind($data, <%= -1 %>, 'fileUpload<%= i %>') }"></div>
				</c:if>
			<div data-bind="visiable: false, foreach: { data: tepTinModel.tepLoai<%= i %>(), as: 'item' }">
				
				<p style="margin-top: 15px;" data-bind="if: item.tenTepTin != null" >
				
					<a class="a" data-bind="attr: { 'href': item.link, 'title': item.tenTepTin }"><b><i><span data-bind="text: item.name"></span></i></b></a>
					<c:if test="<%= form != null && !form.isXemHoSo() %>">
						<a href="javascript:;" data-bind="click: $root.xoaMotFile">
							<i class="fa fa-lg fa-remove tooltips" ></i>
						</a>
					</c:if>
				</p>
			</div>
		</td>
		<td align="center">
			<c:if test="<%= form != null && !form.isXemHoSo() %>">
				<p style="border: 0px solid;" align="center"><p data-bind="if: tepTinModel.tepLoai<%= i %>().length > 0">
				<a  class="btn red bt-center" title="<spring:message code="monre_01_button_title_delete" />"
						data-bind="click: xoaTepTin.bind($data, <%= -1 %>)">
						<i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;
						<spring:message code="monre_01_button_title_delete" />
					</a>
				</p>
			</c:if>
		</td>
	</tr>
	<% p++; } %>
</tbody>