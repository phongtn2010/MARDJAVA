<%@ include file="import_package.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
TbdHSDeNghiCapGiayXn5 form = (TbdHSDeNghiCapGiayXn5)request.getAttribute("form");
%>
<div class="col-md-12">
	<div class="row">
		<div class="col-md-6">
			<div class="row">
				<div class="form-group row">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 col-form-label"><spring:message code="monre.01.label.thong-tin-giay-xac-nhan.soGXNDaCap"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<table width="100%">
							<tr>
								<td ><input id="soGXNDaCap" class="form-control" data-bind="value: giayXacNhanModel.soGXNDaCap, enable: !$root.xemHoSo()" /></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group row">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 col-form-label"><spring:message code="monre.01.label.thong-tin-giay-xac-nhan.hieuLucTuNgayTextFormat"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<input id="ngayCap"  data-date-format="dd/mm/yyyy"  class="form-control date-picker" data-bind="value: giayXacNhanModel.ngayCap, enable: !$root.xemHoSo()" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group row">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 col-form-label"><spring:message code="monre.01.label.thong-tin-giay-xac-nhan.hieuLucDenNgayTextFormat"></spring:message><span class="nsw-require-field"></span></label>
					<div class="col-sm-8">
						<input id="ngayHetHan"  data-date-format="dd/mm/yyyy" class="form-control date-picker" data-bind="value: giayXacNhanModel.ngayHetHan, enable: !$root.xemHoSo()" />
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="form-group row">
					<label style="text-align: right;" for="inputPassword" class="col-sm-4 col-form-label"><spring:message code="monre.01.label.thong-tin-giay-xac-nhan.lyDo"></spring:message><span class="nsw-require-field">*</span></label>
					<div class="col-sm-8">
						<textarea id="lyDo" class="form-control" style="min-height: 100px;" data-bind="value: giayXacNhanModel.lyDo, enable: !$root.xemHoSo()"></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>