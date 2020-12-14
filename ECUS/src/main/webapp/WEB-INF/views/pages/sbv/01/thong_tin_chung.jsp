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
<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<label style="text-align: right;" for="inputPassword" class="col-sm-2 "><spring:message code="sbv.01.form.24"></spring:message><span class="nsw-require-field">*</span></label>
			<div class="col-sm-10">
				<select id="maChiNhanh" class="form-control select2" data-bind="options: dsChiNhanh,  optionsText: 'tenChiNhanh',  optionsValue: 'maChiNhanh', event: { change: $root.change }, value: thongTinChungModel.maCoQuan">
				</select>
			</div>
		</div>
	</div>
</div>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="sbv.01.form.25"></spring:message></label>
					<div class="col-sm-8">
						<input id="ngayTao" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.ngayTao" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 "><spring:message code="sbv.01.form.26"></spring:message></label>
					<div class="col-sm-8">
						<input id="tenTrangThai" readonly="true" class="form-control form-control-inline " data-bind="value: thongTinChungModel.tenTrangThai" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
