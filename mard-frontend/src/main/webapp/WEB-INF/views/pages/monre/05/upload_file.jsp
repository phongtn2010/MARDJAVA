<%@ include file="import_package.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
	.a{
		font-weight: bold;
		font-size: 12px;
		color: #000;
		text-decoration: none;
	}
	a.a:hover {
		color: #f00;
	}
</style>
            
<div data-bind="foreach: { data: $root.dsTepTinThemMoiHS, as: 'item'}">
	
	<input type="hidden" data-bind="attr: { 'value': item.id, 'name': 'tepTin1s['+ item.index()+'].id'}" >
	
	<input type="hidden" data-bind="attr: { 'value': item.tenTepTin, 'name': 'tepTin1s['+ item.index()+'].tenTepTin'}" >
	
	<input type="hidden" data-bind="attr: { 'value': item.loaiTepTin, 'name': 'tepTin1s['+ item.index()+'].loaiTepTin'}" >
	
	<input type="hidden" data-bind="attr: { 'value': item.tenTepTinId, 'name': 'tepTin1s['+ item.index()+'].tenTepTinId'}" >
	
	<input type="hidden" data-bind="attr: { 'value': item.tenLoaiTep, 'name': 'tepTin1s['+ item.index()+'].tenLoaiTep'}" >
	
	
</div>
<div class="table-responsive" id="thongTinTepDinhKem">
	<table  class="table table-striped table-bordered table-hover table-checkable order-column" width="100%">
		<thead>
			<tr class="nsw-tr tr-nsw1-bgcolor">
				<th class="text-center thong-tin-phe-lieu-nhap-table-th1"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.stt"></spring:message></th>
				<th  class="text-center"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.tenTep"></spring:message></th>
				<th  class="text-center"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.tenTep"></spring:message></th>
				<th class="text-center monre-01-table-th-150"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.chucNang"></spring:message></th>
				</tr>
		</thead>
		<%@ include file="tep_dinh_kem_thu_tuc_05.jsp" %>
		
	</table>
		<div class="alert alert-danger">
		  <strong><spring:message code="monre.01.label.tepDinhKemGhiChu"></spring:message></strong>
		</div>
</div>
