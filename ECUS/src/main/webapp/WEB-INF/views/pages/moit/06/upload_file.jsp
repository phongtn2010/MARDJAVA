<%@page import="com.nsw.moit.p06.model.HoSo6EditForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
		<thead>
			<tr class="nsw-tr tr-nsw1-bgcolor">
				<th class="text-center"><spring:message code="moit.06.form.38"></spring:message></th>
				<th class="text-center"><spring:message code="moit.06.form.46"></spring:message></th>
				<th class="text-center"><spring:message code="moit.06.form.47"></spring:message></th>
				<th class="text-center"><spring:message code="moit.06.form.42"></spring:message></th>
			</tr>
		</thead>
		<tbody>
			<!-- ko foreach: $root.danhMucTeps() -->
			<tr data-bind="if: loaiTep == $root.selectedTep()">
				<td class="text-center"><span data-bind="text: order"></span></td>
				<td><span data-bind="text: tenTep"></span><span data-bind="if: required" class="nsw-require-field">*</span></td>
				<td>
					<div>
						<span data-bind="if: (!$root.xemHoSo())"> <input type="file" class="form-group form-control" multiple="multiple" data-bind="attr: { 'id': 'fileUpload' + $index()}, event:{ change: $root.uploadFileChangeEvent.bind($data, maLoaiTep, $index()) }">
						</span>
						<div data-bind="foreach: { data: $root.teps()[$index()], as: 'item' }">
							<p>
								<i> <a data-bind="text: item.tenTepDinhKem, attr: { 'href':  item.link}" target="_blank"></a><span data-bind="if: (!$root.xemHoSo())"> <a href="javascript:;" data-bind="click: $root.xoaMotFile.bind($data, item, $parentContext.$index())" title='<spring:message code="moit.06.form.tiente.button.xoa"/>'> <i class="fa fa-lg fa-remove tooltips"></i>
									</a>
								</span>
								</i>
							</p>
						</div>
					</div>
				</td>
				<td class="text-center">
					<p>
						<span data-bind="if: ($root.teps()[$index()]().length > 0 && !$root.xemHoSo())"> <a style="padding: 16px; margin-bottom: 10px;" title="<spring:message code="moit.06.form.tiente.button.xoa" />" class="btn red bt-center" data-bind="click: $root.xoaTepTin.bind($data, $index())"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
					</p> </span>
				</td>
			</tr>
			<!-- /ko -->
		</tbody>
	</table>
	<div class="alert alert-danger">
		<strong><spring:message code="moit.06.label.tepDinhKemGhiChu"></spring:message></strong>
	</div>
</div>