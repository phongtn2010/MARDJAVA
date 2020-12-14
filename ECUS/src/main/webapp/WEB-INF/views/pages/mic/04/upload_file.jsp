<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<div class="col-md-12 table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead>
				<tr class="nsw-tr tr-nsw1-bgcolor">
					<th class="text-center" data-bind="i18n: { 'html': 'TbdDinhKem04.fiId' }"></th>
					<th class="text-center" data-bind="i18n: { 'html': 'TbdDinhKem04.fiFileName' }"></th>
					<th class="text-center" data-bind="i18n: { 'html': 'TbdDinhKem04.fiFileCode' }"></th>
					<th class="text-center" data-bind="i18n: { 'html': 'TbdDinhKem04.fiFileByte' }"></th>
				</tr>
				</thead>
				<tbody>
				<!-- ko foreach: $root.danhMucTepDuocChon() -->
				<tr >
					<td class="text-center"><span data-bind="text: $index() + 1"></span></td>
					<td><span data-bind="text: tenTep"></span><span data-bind="if: required" class="nsw-require-field">*</span></td>
					<td>
						<div class="col-md-12">
							<span data-bind="if: (!$root.xemHoSo())">
							<input ${ isView ? " disabled " : ""}   type="file" class="form-group form-control" multiple="multiple" data-bind="attr: { 'id': 'fileUpload' + $index()}, event:{ change: $root.uploadFileChangeEvent.bind($data, maLoaiTep, $index(), $data) }">
						</span>
						</div>
						<div data-bind="if: $root.groupFileIndexSelected() != undefined">
							<div data-bind="foreach: { data: $root.groupFileSelected()[$root.groupFileIndexSelected()]()[$index()], as: 'item' }">
								<p>
									<i>
										<a data-bind="text: item.fiFileName, attr: { 'href':  item.link}" target="_blank"></a>
										<span data-bind="if: (!$root.xemHoSo())">
										<a style="color: red; font-weight: bold;" href="javascript:;" data-bind="click: $root.delete.bind($data, item, $parentContext.$index())" title=''> <i class="fa fa-lg fa-remove tooltips"></i>	</a>
									</span>
									</i>
								</p>
							</div>
						</div>

					</td>
					<td align="center">
						<p data-bind="if: $root.groupFileIndexSelected() != undefined">
						<span data-bind="if: ($index() < $root.groupFileSelected()[$root.groupFileIndexSelected()]().length && $root.groupFileSelected()[$root.groupFileIndexSelected()]()[$index()]().length > 0 && !$root.xemHoSo())">
							<a style="color: red; font-weight: bold;" title=''  data-bind="click: $root.delete.bind($data, null, $index())">
								<i class="fa fa-lg fa-close tooltips" aria-hidden="true"></i>
						</a>
						</span>
						</p>
					</td>
				</tr>
				<!-- /ko -->
				</tbody>
			</table>
			<div class="col-md-12 alert alert-danger">
				<strong data-bind="i18n: { 'html': 'TbdDinhKem04.ghiChu' }"></strong>
			</div>
		</div>