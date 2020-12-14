<%@page import="com.nsw.sbv.p01.model.HoSoNgoaiTeEditForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>
<%
HoSoNgoaiTeEditForm form = (HoSoNgoaiTeEditForm)request.getAttribute("form");
%>
<div class="table-responsive">
	<table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
		<thead>
			<tr class="nsw-tr tr-nsw1-bgcolor">
				<th class="text-center"><spring:message code="sbv.01.form.38"></spring:message></th>
				<th class="text-center"><spring:message code="sbv.01.form.46"></spring:message></th>
				<th class="text-center"><spring:message code="sbv.01.form.47"></spring:message></th>
				<th class="text-center"><spring:message code="sbv.01.form.42"></spring:message></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="text-center">1</td>
				<td><spring:message code="sbv.01.form.teptin.02"></spring:message> <span class="nsw-require-field">*</span></td>
				<td>
					<div>
						<input type="file" class="form-group form-control" multiple="multiple" id="loaiTep2a" data-bind="event:{ change: $root.uploadFileChangeEvent.bind($data, 1, 'loaiTep2a') }">
						<div>
							<div data-bind="foreach: { data: dsTepLoai1, as: 'item' }">
								<p>
									<i> <a data-bind="text: item.tenTepDinhKem, attr: { 'href':  item.link}" target="_blank"></a> <a href="javascript:;" data-bind="click: $root.xoaMotFile" title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'> <i class="fa fa-lg fa-remove tooltips"></i>
									</a>
									</i>
								</p>
							</div>
						</div>
					</div>
				</td>
				<td class="text-center">
					<p>
						<span data-bind="if: ($root.dsTepLoai1().length > 0)"> <a title="<spring:message code="sbv.01.form.tiente.button.xoa" />" class="btn red bt-center" data-bind="click: $root.xoaTepTin.bind($data, '1')"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td class="text-center">2</td>
				<td><spring:message code="sbv.01.form.teptin.03"></spring:message> <span class="nsw-require-field">*</span></td>
				<td>
					<div>
						<input type="file" class="form-group form-control" multiple="multiple" id="loaiTep2b" data-bind=" event:{ change: $root.uploadFileChangeEvent.bind($data, 2, 'loaiTep2b') }">
						<div>
							<div data-bind="foreach: { data: dsTepLoai2, as: 'item' }">
								<p>
									<i> <a data-bind="text: item.tenTepDinhKem, attr: { 'href':  item.link}" target="_blank"></a> <a href="javascript:;" data-bind="click: $root.xoaMotFile" title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'> <i class="fa fa-lg fa-remove tooltips"></i>
									</a>
									</i>
								</p>
							</div>
						</div>
					</div>
				</td>
				<td class="text-center">
					<p>
						<span data-bind="if: ($root.dsTepLoai2().length > 0)"> <a title="<spring:message code="sbv.01.form.tiente.button.xoa" />" class="btn red bt-center" data-bind="click: $root.xoaTepTin.bind($data, '2')"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td class="text-center">3</td>
				<td><spring:message code="sbv.01.form.teptin.04"></spring:message></td>
				<td>
					<div>
						<input type="file" class="form-group form-control" multiple="multiple" id="loaiTep2c" data-bind=" event:{ change: $root.uploadFileChangeEvent.bind($data, 3, 'loaiTep2c') }">
						<div>
							<div data-bind="foreach: { data: dsTepLoai3, as: 'item' }">
								<p>
									<i> <a data-bind="text: item.tenTepDinhKem, attr: { 'href':  item.link}" target="_blank"></a> <a href="javascript:;" data-bind="click: $root.xoaMotFile" title='<spring:message code="sbv.01.form.tiente.button.xoa"/>'> <i class="fa fa-lg fa-remove tooltips"></i>
									</a>
									</i>
								</p>
							</div>
						</div>
					</div>
				</td>
				<td class="text-center">
					<p>
						<span data-bind="if: ($root.dsTepLoai3().length > 0)"> <a title="<spring:message code="sbv.01.form.tiente.button.xoa" />" class="btn red bt-center" data-bind="click: $root.xoaTepTin.bind($data, '3')"> <i class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
					</p>
				</td>
			</tr>
		</tbody>
	</table>
</div>