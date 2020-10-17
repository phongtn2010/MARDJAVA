<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>

<div class="row">
	<div class="col-md-12">
		<div class="portlet light " id="contentBody">
			<div class="portlet-title">
				<div class="caption font-dark">
					<i class="icon-settings font-dark"></i> <span class="caption-subject bold uppercase">Quản lý hồ sơ</span>
				</div>
			</div>
			<div class="portlet-body" id="table-search">
				<div class="table-toolbar">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<span class="caption-subject bold uppercase"><spring:message code="mt.search.grid.title"></spring:message></span>
								</div>
								<div class="panel-body">
									<form role="form" class="form-horizontal " name="searchForm01" id="searchForm01">
										<div class="form-group" style="margin-top: 15px;">
											<div class="col-md-12">
												<div class="col-md-2 label-text-right">
													<label>Thủ tục</label>
												</div>
												<div class="col-md-10">
													<select id="fiMaThutuc" name="fiMaThutuc" class="form-control select2" data-bind="options: $root.danhSachThutuc,
                                                            optionsText: 'fiTenThutuc',
                                                            optionsValue: 'fiMaThutuc',
                                                            valueAllowUnset: true,
                                                                value: searchForm.fiMaThutuc">
													</select>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-2 label-text-right">
													<label><spring:message code="mt.search.mahoso"></spring:message> </label>
												</div>
												<div class="col-md-4">
													<input class="form-control" name="maHoSo" id="maHoSo" placeholder="<spring:message code="sbv.01.mahoso" />" data-bind="value: searchForm.fiMaHoso" type="text">
												</div>
												<div class="col-md-2 label-text-right">
													<label>Số giấy phép</label>
												</div>
												<div class="col-md-4">
													<input class="form-control" placeholder="Số giấy phép" data-bind="value: searchForm.fiSoGiayphep" type="text">
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-2 label-text-right">
													<label><spring:message code="mt.search.nop.tungay"></spring:message></label>
												</div>
												<div class="col-md-4">
													<input name="ngayNopTuNgay" id="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="datepicker: searchForm.fiNgaygui.FROM" />
												</div>
												<div class="col-md-2 label-text-right">
													<label><spring:message code="mt.search.nop.denngay"></spring:message></label>
												</div>
												<div class="col-md-4">
													<input name="ngayNopDenNgay" id="ngayNopDenNgay" field="common_tracuu_ngay_tao_den" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="datepicker: searchForm.fiNgaygui.TO" />
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-2 label-text-right">
													<label><spring:message code="mt.search.capphep.tungay"></spring:message></label>
												</div>
												<div class="col-md-4">
													<input name="ngayCapPhepTuNgay" id="ngayCapPhepTuNgay" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="datepicker: searchForm.fiNgaycapphep.FROM" />
												</div>
												<div class="col-md-2 label-text-right">
													<label><spring:message code="mt.search.capphep.denngay"></spring:message></label>
												</div>
												<div class="col-md-4">
													<input name="ngayCapPhepDenNgay" id="ngayCapPhepDenNgay" field="common_tracuu_ngay_tao_den" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" placeholder="dd/mm/yyyy" data-bind="datepicker:searchForm.fiNgaycapphep.TO" />
												</div>
											</div>
										</div>
										<div class="col-md-2 label-text-right">
											<label>Trạng thái</label>
										</div>
										<div class="col-md-4" style="margin-bottom: 15px;">
												<select name="trangThaiHoSo" class="form-control select2" data-bind="options: $root.danhSachTrangThai,
                                                               optionsText: 'fiTenTrangthai',
                                                               optionsValue: 'fiTrangthaiId',
                                                               value: searchForm.fiTrangthai">
											</select>
										</div>

										<div class="col-md-12">
											<div class="form-group">
												<div class=" nsw-text-center">
													<a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: $root.searchHoSo"><i class="fa fa-search"></i> <spring:message code="mt.btn.search" /></a>
												</div>
											</div>
										</div>

									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="portlet-body" id="table-content">
				<div class="table-toolbar">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<span class="caption-subject bold uppercase"><spring:message code="mt.search.table.title"></spring:message></span>
								</div>
								<div class="">
									<div class="col col-md-12" style="padding-bottom: 7px;padding-top: 7px;">
										<b><a id="lbTotalRecords" href="javascript:void(0);"></a> </b>
										Tổng hồ sơ
										<span>: <b data-bind="text: pagingVM.totalCount()"></b></span>
										<span>&nbsp;|&nbsp;Trang:&nbsp;<b data-bind="text: pagingVM.currentPage()"></b></span>
									</div>
								</div>
								<div class="panel-body">
									<table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
										<thead>
											<tr class="nsw-tr tr-nsw1-bgcolor">
												<th class="text-center" width="64px">STT</th>
												<th class="text-center">Mã hồ sơ</th>
												<th class="text-center">Tên thủ tục hành chính</th>
												<th class="text-center">Tên doanh nghiệp</th>
												<th class="text-center">Ngày nộp</th>
												<th class="text-center">Ngày cấp phép</th>
												<th class="text-center"><spring:message code="mt.header.trangthai"></spring:message></th>
												<th class="text-center"><spring:message code="mt.header.view.lincense"></spring:message></th>
											</tr>
										</thead>
										<tbody id="list-container" data-bind="foreach: { data: $root.danhSachHoSo, as: 'item'}">
											<tr>
												<td class="text-center" data-bind="text:($root.pagingVM.currentPage()-1) * 10 + $index() + 1"></td>
												<td class="text-center" data-bind="text: item.fiMaHoso"></td>
												<td><a href="javascript:;" data-bind="attr: { 'title': item.fiTenThutuc },
                                                    click: $root.xemHoSo,text: $root.getTenThuTuc(item.fiMaThutuc())"> </a></td>
												<td data-bind="text: item.fiTenDoanhnghiep"></td>
												<td class="text-center" data-bind="text: item.fiNgaygui()?moment(item.fiNgaygui()).format('hh:mm:ss DD/MM/YYYY'):''"></td>
												<td class="text-center" data-bind="text: item.fiNgaycapphep()?moment(item.fiNgaycapphep()).format('hh:mm:ss DD/MM/YYYY'):''"></td>
												<td data-bind="text: item.fiTenTrangThai()"></td>
												<td class="text-center" data-bind="if: item.fiTrangthai()==7"><a href="javascript:;" data-bind="click: $root.xemGiayPhep"><i class="fa fa-list-alt" aria-hidden="true"></i> </a></td>
											</tr>
										</tbody>
										<tbody id="loadingBlock">
											<tr>
												<td style="height: 50px; position: relative; zoom: 1;" colspan="15" id="td_c4e6a343-dd41-b5c5-1ef9-75eeebba032d">
													<div class="blockUI" style="display: none"></div>
													<div class="blockUI blockOverlay" style="z-index: 1000; border: none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color: rgb(85, 85, 85); opacity: 0.1; cursor: wait; position: absolute;"></div>
													<div class="blockUI blockMsg blockElement" style="z-index: 1011; position: absolute; padding: 0px; margin: 0px; width: 30%; top: 4px; left: 528.5px; text-align: center; color: rgb(0, 0, 0); border: 0px; cursor: wait;">
														<div class="loading-message ">
															<img src="<c:url value="/static/assets/global/img/loading-spinner-grey.gif" />" align=""><span>&nbsp;&nbsp;LOADING...</span>
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
									<div class="row">
										<div class="col-md-12 nsw-text-right">
											<div class="nsw-flr" data-bind="if: totalData() > 10">
												<ul class="flip pull-left pagination pagination-sm">
													<li data-bind="css: { disabled: !pagingVM.firstPageActive() }" class="previous disabled"><a href="#" aria-label="First" data-bind="click: goToFirst"> <spring:message code="monre.01.trang-dau-tien"></spring:message>
													</a></li>
													<li data-bind="css: { disabled: !pagingVM.previousPageActive()  }" class="previous disabled"><a href="#" aria-label="Previous" data-bind="click: goToPrevious"> <spring:message code="monre.01.trang-truoc"></spring:message>
													</a></li>
													<!-- ko foreach: $root.pagingVM.getPages() -->
													<li data-bind="css: { active: $data == $root.pagingVM.currentPage() }"><a href="#" data-bind="text: $data, click: $root.goToPage.bind($data)"></a></li>
													<!-- /ko -->
													<li data-bind="css: { disabled: !pagingVM.nextPageActive() }" class="next"><a href="#" aria-label="Next" data-bind="click: goToNext"> <spring:message code="monre.01.trang-sau"></spring:message>
													</a></li>
													<li data-bind="css: { disabled: !pagingVM.lastPageActive() }" class="next"><a href="#" aria-label="Last" data-bind="click: goToLast"> <spring:message code="monre.01.trang-cuoi"></spring:message>
													</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	var userCustom = $
	{
		userCustom
	};
</script>
<script type="text/javascript" src="<c:url value="/app/mt/utility/qlhs/index.module.js?v=${ version }"/>" charset="utf-8"></script>
