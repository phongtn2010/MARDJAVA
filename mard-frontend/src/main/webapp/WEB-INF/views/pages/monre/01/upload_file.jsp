<%@ include file="import_package.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.a {
	font-weight: bold;
	font-size: 12px;
	color: #000;
	text-decoration: none;
}

a.a:hover {
	color: #f00;
}
</style>
<div class="table-responsive" id="thongTinTepDinhKem">
	<table class="table table-striped table-bordered table-hover table-checkable order-column" width="100%">
		<thead>
			<tr class="nsw-tr tr-nsw1-bgcolor">
				<th class="text-center thong-tin-phe-lieu-nhap-table-th1"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.stt"></spring:message></th>
				<th class="text-center"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.tenTep"></spring:message></th>
				<th width="300px" class="text-center"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.tenTep"></spring:message></th>
				<th width="100px"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem.chucNang"></spring:message></th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="<%= AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_01 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_03 %>">
				<%@ include file="tep_tin_thu_tuc_01_03.jsp"%>
			</c:when>
			<c:when test="<%= AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_02 || AppCommon.getLoaiThuTucHienTai(request) == AppKeyConstant.LoaiThuTuc.THU_TUC_04 %>">
				<%@ include file="tep_tin_thu_tuc_02_04.jsp"%>
			</c:when>
		</c:choose>
	</table>
	<div class="alert alert-danger">
	  <strong><spring:message code="monre.01.label.tepDinhKemGhiChu"></spring:message></strong>
	</div>
	
</div>
