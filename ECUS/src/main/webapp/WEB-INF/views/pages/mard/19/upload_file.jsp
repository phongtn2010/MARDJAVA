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

			<th class="text-center"><spring:message code="mard.19.form.tepDinhKem.fileName"></spring:message></th>
			<th class="text-center"><spring:message code="mard.19.form.tepDinhKem.actionUpload"></spring:message></th>
			<th class="text-center"><spring:message code="mard.19.form.tepDinhKem.actionDelete"></spring:message></th>
		</tr>
		</thead>
		<tbody>

		<tr >

			<td><b>Các giấy tờ liên quan đến hồ sơ</b></td>
			<td>
				<div>
					<c:if test="${isView == false}">
							<span data-bind="if: (!$root.xemHoSo())"> <input id="fileUpload" type="file" class="form-group form-control" multiple="multiple" data-bind=" event:{ change: $root.uploadFileChangeEvent }">
							</span>
					</c:if>
					<div data-bind="foreach: { data: $root.teps(), as: 'item' }">
						<p>
							<i> <a data-bind="text: item.fiFileName, attr: { 'href':  item.fiPath}" target="_blank"></a>
								<c:if test="${isView == false}">
									<a href="javascript:;" data-bind="click: $root.xoaMotFile.bind($data, item )" title='<spring:message code="mard.19.form.tepDinhKem.actionDelete"/>'> <i class="fa fa-lg fa-remove tooltips"></i>
									</a>
								</c:if>
							</i>
						</p>
					</div>
				</div>
			</td>
			<td align="center">
				<c:if test="${isView == false}">
					<p>
						<span data-bind="if: ($root.teps().length > 0)"> <a style="" title="<spring:message code="mard.19.form.tepDinhKem.actionDelete" />" class="" data-bind="click: $root.xoaTepTin"> <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true"></i>&nbsp;
						</a>
						</span>
					</p> </span>
				</c:if>
			</td>
		</tr>
		<!-- /ko -->
		</tbody>
	</table>
	<div class="alert alert-danger" role="alert">
		<spring:message code="mard.19.uploadInfo"></spring:message>
	</div>

</div>
