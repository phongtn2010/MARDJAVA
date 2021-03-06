<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>
<input type="hidden" value="${ IS_SIGN_KEY }" id="kySo" />
<script>
var coKySo = ${ IS_SIGN_KEY };
</script>
<div class="row">
	<div class="col-md-12">
		<div class="portlet light " id="contentBody">
			<div class="portlet-title">
				<div class="caption font-dark">
					<i class="icon-settings font-dark"></i> <span class="caption-subject bold uppercase"><spring:message code="sbv.01.tenthutuc" /></span>
				</div>
			</div>
			<c:if test="${ ACTION_ERROR != null }">
				<div class="col-md-12">
					<div class="row">
						<div class="alert alert-danger">
							<strong>${ ACTION_ERROR }</strong>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${ ACTION_SUCCESS != null }">
				<div class="col-md-12">
					<div class="row">
						<div class="alert alert-success">
							<strong>${ ACTION_SUCCESS }</strong>
						</div>
					</div>
				</div>
			</c:if>
			<div class="col-md-12" data-bind="if: showActionError()">
				<div class="row">
					<div class="" data-bind="attr: { 'class': showActionError() ? 'alert alert-danger': '' }">
						<strong data-bind="text: errorMessage"></strong>
					</div>
				</div>
			</div>
			<div class="col-md-12" data-bind="if: showActionSuccess()">
				<div class="row">
					<div class="" data-bind="attr: { 'class': showActionSuccess() ? 'alert alert-success toast-success': '' }">
						<strong style="color: #fff;"><spring:message code="sbv.01.action.success"></spring:message> </strong>
					</div>
				</div>
			</div>
			<div class="portlet-body" id="table-search">
				<div class="table-toolbar">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<span class="caption-subject bold uppercase"><spring:message code="common.tracuu.thong_tin_tim_kiem" /> </span>
								</div>
								<div class="panel-body">
									<jsp:include page="index_form_search.jsp"></jsp:include>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col col-md-12">
						<spring:message code="common.tong" />
						<b><a id="lbTotalRecords" href="javascript:void(0);"></a> </b>
						<spring:message code="common.pager.ban_ghi" />
						<span><b data-bind="text: tongSoHoSo"></b></span>
					</div>
				</div>
				<table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
					<thead>
						<tr class="nsw-tr tr-nsw1-bgcolor">
							<th class="text-center"><spring:message code="sbv.01.index.table.th.01"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.02"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.03"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.04"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.05"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.06"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.07"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.08"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.09"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.10"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.11"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.12"></spring:message></th>
							<th class="text-center"><spring:message code="sbv.01.index.table.th.13"></spring:message></th>
						</tr>
					</thead>
					<tbody id="list-container" data-bind="foreach: { data: $root.danhSachHoSo, as: 'item'}">
						<tr>
							<td class="text-center" data-bind="text: item.soThuTu"></td>
							<td class="text-center"><a href="javascript:;" data-bind="attr: { 'title': item.maHoSo }, click: $root.xemLichSu"> <i class="fa fa-lg fa-history tooltips"></i>
							</a></td>
							<td class="text-center" data-bind="text: item.maHoSo"></td>
							<td class="text-center" data-bind="text: item.tenNganHang"></td>
							<td class="text-center" data-bind="text: item.ngayTao"></td>
							<td class="text-center" data-bind="text: item.tenTrangThai"></td>
							<td class="text-center" data-bind="text: item.hinhThucXNK"></td>
							<td class="text-center"><a href="javascript:;" data-bind="attr: { 'title': item.maHoSo }, click: $root.xemHoSoClick"> <i class="fa fa-eye"></i>
							</a></td>
							<td class="text-center" data-bind="if: (item.showButtonSend())"><a href="javascript:;" data-bind="attr: { 'title': item.maHoSo }, click: $root.guiHoSo"> <i class="fa fa-paper-plane" aria-hidden="true"></i>
							</a></td>
							<td class="text-center" data-bind="if: (item.showButtonEdit())"><a href="javascript:;" data-bind="attr: { 'title': item.maHoSo }, click: $root.chinhSuaHoSo"> <i class="fa fa-lg fa-edit request-cancel tooltips"></i>
							</a></td>
							<td class="text-center" data-bind="if: (item.showButtonDelete())"><a href="javascript:;" data-bind="attr: { 'title': item.maHoSo }, click: $root.xoaHoSo"> <i class="fa fa-trash" aria-hidden="true"></i>
							</a></td>
							<td class="text-center" data-bind="if: (item.showButtonXinRut())"><a href="javascript:;" data-bind="attr: { 'title': item.maHoSo }, click: $root.huyHoSo"> <i class="fa fa-lg fa-remove tooltips"></i>
							</a></td>
							<td class="text-center" data-bind="if: (item.showButtonXemGXN())"><a href="javascript:;" data-bind="attr: { 'title': item.maHoSo }, click: $root.xemGiayXacNhanClick"> <i class="fa fa-eye"></i>
							</a></td>
						</tr>
					</tbody>
					<tbody id="loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d">
						<tr>
							<td style="height: 50px; position: relative; zoom: 1;" colspan="15" id="td_c4e6a343-dd41-b5c5-1ef9-75eeebba032d"><div class="blockUI" style="display: none"></div>
								<div class="blockUI blockOverlay" style="z-index: 1000; border: none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color: rgb(85, 85, 85); opacity: 0.1; cursor: wait; position: absolute;"></div>
								<div class="blockUI blockMsg blockElement" style="z-index: 1011; position: absolute; padding: 0px; margin: 0px; width: 30%; top: 4px; left: 528.5px; text-align: center; color: rgb(0, 0, 0); border: 0px; cursor: wait;">
									<div class="loading-message ">
										<img src="<c:url value="/static/assets/global/img/loading-spinner-grey.gif" />" align=""><span>&nbsp;&nbsp;LOADING...</span>
									</div>
								</div></td>
						</tr>
					</tbody>
				</table>
				<!-- pagination -->
				<div class="row">
					<div class="col-md-12 nsw-text-right">
						<div class="nsw-flr" data-bind="if: totalData() > 15">
							<ul class="flip pull-left pagination pagination-sm">
								<li data-bind="css: { disabled: !pagingVM.firstPageActive() }" class="previous disabled"><a href="#" aria-label="First" data-bind="click: goToFirst"> <spring:message code="sbv.01.trang-dau-tien"></spring:message>
								</a></li>
								<li data-bind="css: { disabled: !pagingVM.previousPageActive()  }" class="previous disabled"><a href="#" aria-label="Previous" data-bind="click: goToPrevious"> <spring:message code="sbv.01.trang-truoc"></spring:message>
								</a></li>
								<!-- ko foreach: $root.pagingVM.getPages() -->
								<li data-bind="css: { active: $data == $root.pagingVM.currentPage() }"><a href="#" data-bind="text: $data, click: $root.goToPage.bind($data)"></a></li>
								<!-- /ko -->
								<li data-bind="css: { disabled: !pagingVM.nextPageActive() }" class="next"><a href="#" aria-label="Next" data-bind="click: goToNext"> <spring:message code="sbv.01.trang-sau"></spring:message>
								</a></li>
								<li data-bind="css: { disabled: !pagingVM.lastPageActive() }" class="next"><a href="#" aria-label="Last" data-bind="click: goToLast"> <spring:message code="sbv.01.trang-cuoi"></spring:message>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/app/sbv/01/CAPlugin.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/vt-connector.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/models.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/index.module.js?v=${ version }"/>" charset="utf-8"></script>
