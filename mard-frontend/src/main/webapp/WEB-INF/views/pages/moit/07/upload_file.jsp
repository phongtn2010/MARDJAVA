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
			<!-- ko foreach: $root.danhMucTepDuocChon() -->
			<tr >
				<td class="text-center"><span data-bind="text: $index() + 1"></span></td>
				<td><span data-bind="text: tenTep"></span><span data-bind="if: required" class="nsw-require-field">*</span></td>
				<td>
						<span data-bind="if: (!$root.xemHoSo())">
							<input type="file" class="form-group form-control" multiple="multiple" data-bind="attr: { 'id': 'fileUpload' + $index()}, event:{ change: $root.uploadFileChangeEvent.bind($data, maLoaiTep, $index()) }">
						</span>
						<div data-bind="if: $root.groupFileIndexSelected() != undefined">
							<div data-bind="foreach: { data: $root.groupFileSelected()[$root.groupFileIndexSelected()]()[$index()], as: 'item' }">
								<p>
									<i>
										<a data-bind="text: item.tenTepDinhKem, attr: { 'href':  item.link}" target="_blank"></a>
										<span data-bind="if: (!$root.xemHoSo())">
										<a style="color: red; font-weight: bold;" href="javascript:;" data-bind="click: $root.delete.bind($data, item, $parentContext.$index())" title='<spring:message code="moit.06.form.tiente.button.xoa"/>'> <i class="fa fa-lg fa-remove tooltips"></i>	</a>
									</span>
									</i>
								</p>
							</div>
						</div>

				</td>
				<td align="center">
					<p data-bind="if: $root.groupFileIndexSelected() != undefined">
						<span data-bind="if: ($index() < $root.groupFileSelected()[$root.groupFileIndexSelected()]().length && $root.groupFileSelected()[$root.groupFileIndexSelected()]()[$index()]().length > 0 && !$root.xemHoSo())">
							<a style="color: red; font-weight: bold;" title='<spring:message code="moit.06.form.tiente.button.xoa" />'  data-bind="click: $root.delete.bind($data, null, $index())">
								<i class="fa fa-lg fa-close tooltips" aria-hidden="true"></i>
						</a>
						</span>
					</p>
				</td>
			</tr>
			<!-- /ko -->
		</tbody>
	</table>
	<div class="alert alert-danger">
		<strong><spring:message code="moit.07.label.tepDinhKemGhiChu"></spring:message></strong>
	</div>
</div>