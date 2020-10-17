<%@page import="com.nsw.monre.p01.model.TbdHSDeNghiCapGiayXn1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
TbdHSDeNghiCapGiayXn1 form = (TbdHSDeNghiCapGiayXn1)request.getAttribute("form");
%>
<table class="table table-striped table-bordered table-hover table-checkable order-column" id="danhSachCSSX">
	<thead class="nsw-tr tr-nsw1-bgcolor">
		<th class="text-center thong-tin-phe-lieu-nhap-table-th1"><spring:message code="monre.01.label.thong-tin-co-so-san-xuat-phe-lieu.stt"></spring:message></th>
		<th class="text-center"><spring:message code="monre.01.label.thong-tin-co-so-san-xuat-phe-lieu.tenCoSo"></spring:message></th>
		<th class="text-center"><spring:message code="monre.01.label.thong-tin-co-so-san-xuat-phe-lieu.diaChiTruSo"></spring:message></th>
		<th class="text-center monre-01-table-th-150"><spring:message code="monre.01.label.thong-tin-co-so-san-xuat-phe-lieu.chucNang"></spring:message></th>
	</thead>

	<tbody id="khaiSuaHoSoDSCSSXBodySecond" data-bind="foreach: { data: dsCoSoSXTheoHS, as: 'item'} ">


		<tr data-bind="attr: { 'id': 'khaiSuaHoSoDSCSSXBodySecond' + item.index() }">

			<td class="text-center" data-bind="text: soThuTu"></td>

			<td data-bind="text: tenCoSo"></td>

			<td data-bind="text: diaChiCoSo"></td>

			<td class="text-center"><c:if test="<%= form != null && !form.isXemHoSo() %>">
					<a class="btn red bt-center" title="<spring:message code="monre_01_button_title_delete" />" data-bind="click: $root.xoaCoSoSXTheoHS" id="btLuuLai"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp; <spring:message code="monre_01_button_title_delete" />
					</a>
				</c:if></td>
		</tr>
	</tbody>

</table>