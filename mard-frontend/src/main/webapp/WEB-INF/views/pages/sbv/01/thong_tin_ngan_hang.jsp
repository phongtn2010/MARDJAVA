<%@page import="com.nsw.sbv.p01.model.HoSoNgoaiTeEditForm"%>
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
<%
HoSoNgoaiTeEditForm form = (HoSoNgoaiTeEditForm)request.getAttribute("form");
%>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label style="text-align: right;" for="inputPassword" class="col-sm-2 "><spring:message code="sbv.01.form.27"></spring:message></label>
			<div class="col-sm-10">
				<input disabled="disabled" class="form-control" data-bind="value: thongTinChungModel.maSoThue">
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label style="text-align: right;" for="inputPassword" class="col-sm-2 "><spring:message code="sbv.01.form.28"></spring:message></label>
			<div class="col-sm-10">
				<input disabled="disabled" class="form-control" data-bind="value: thongTinChungModel.tenNganHang">
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label style="text-align: right;" for="inputPassword" class="col-sm-2 "><spring:message code="sbv.01.form.29"></spring:message></label>
			<div class="col-sm-10">
				<input disabled="disabled" class="form-control" data-bind="value: thongTinChungModel.diaChi">
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="sbv.01.form.30"></spring:message></label>
					<div class="col-sm-8">
						<input disabled="disabled" class="form-control" data-bind="value: thongTinChungModel.dienThoai">
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="sbv.01.form.31"></spring:message></label>
					<div class="col-sm-8">
						<input disabled="disabled" class="form-control" data-bind="value: thongTinChungModel.fax">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
