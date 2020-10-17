<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ include file="import_package.jsp"%>
<%@include file="incLanguage.jsp"%>
<link href="<c:url value='/app/monre/01/monre_01.css?v=${version}' />" rel="stylesheet" type="text/css" />
<%
TbdHSDeNghiCapGiayXn1 form = (TbdHSDeNghiCapGiayXn1)request.getAttribute("form");
int loaiThuTuc = AppCommon.getLoaiThuTucHienTai(request);
long idHoSo = form.getIdHS();
String uriContextPath = AppCommon.getUri(request);
%>
<script type="text/javascript">
	var idHoSo = <%= idHoSo %>;
	var loaiThuTuc = <%= loaiThuTuc %>;
	var uriContextPath = '<%= uriContextPath %>';
	var xemHoSo = <%= form.isXemHoSo() %>;
	var maHoSo = "<%= form.getMaHoSo() %>";
	var yeuCauKySo =  ${yeuCauKySo};
</script>
<spring:url value='<%= AppCommon.getUri(request) + "/send" %>' var="save"></spring:url>
<form:form commandName="form" action="${ save }?${_csrf.parameterName}=${_csrf.token}" id="form">
	<form:hidden path="idHS" cssClass="form-control" />
	<form:hidden path="xmlBody" cssClass="form-control" />
	<form:hidden path="xmlEnvelop" cssClass="form-control" />
	<div class="row">
		<div class="col-md-12">
			<div class="portlet light ">
				<div class="portlet-title">
					<div class="caption font-dark">
						<i class="icon-settings font-dark"></i> <span class="caption-subject bold uppercase">${ tenThuTuc }</span>
					</div>
				</div>
				<c:if test="${ sendOkMessage != null && !sendOkMessage.isEmpty() }">
					<div class="alert alert-success fade in alert-dismissible toast-success" style="margin-top: 18px;">
						<strong style="color: #fff;">${ sendOkMessage }</strong>
					</div>
				</c:if>
				<c:if test="${ sendNotOkMessage != null && !sendNotOkMessage.isEmpty() }">
					<div class="alert alert-danger fade in alert-dismissible" style="margin-top: 18px;">
						<strong ">${ sendNotOkMessage }</strong>
					</div>
				</c:if>
				<div class="portlet-body" id="table-search">
					<div class="table-toolbar">
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<span class="caption-subject bold uppercase"><spring:message code="monre.01.label.thong-tin-chung"></spring:message> </span>
									</div>
									<div class="panel-body" id="thong_tin_chung">
										<jsp:include page="thong_tin_chung.jsp"></jsp:include>
									</div>
								</div>
							</div>
						</div>
						<div class="row" id="GiayXacNhanViewModel">
							<c:if test="<%= loaiThuTuc == AppKeyConstant.LoaiThuTuc.THU_TUC_02 || loaiThuTuc == AppKeyConstant.LoaiThuTuc.THU_TUC_04 %>">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-heading">
											<span class="caption-subject bold uppercase"><spring:message code="monre.01.khai-ho-so-thong-tin-gxn"></spring:message> </span>
										</div>
										<div class="panel-body">
											<jsp:include page="thong_tin_giay_xac_nhan.jsp"></jsp:include>
										</div>
									</div>
								</div>
							</c:if>
						</div>
						<div class="row" id="test">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<c:if test="${ !form.isXemHoSo() }">
											<span class="caption-subject bold uppercase"><spring:message code="monre.01.label.thong-tin-co-so-san-xuat-phe-lieu"></spring:message> <a><img id="btShowPopopDanhMucCoSoSX" data-bind="click: clickToShowPopup" alt="" src='<c:url value="/app/monre/01/Add.png" />' /></a> </span>
										</c:if>
									</div>
									<div class="panel-body" id="danh_mucco_so_san_xuat_theo_ho_so">
										<div id="">
											<jsp:include page="co_so_sx.jsp"></jsp:include>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<span class="caption-subject bold uppercase"><spring:message code="monre.01.label.thong-tin-phe-lieu-nhap-khau"></spring:message> </span>
									</div>
									<div class="panel-body" id="ThongTinPheLieuViewModel">
										<jsp:include page="phe_lieu_nhap_khau.jsp"></jsp:include>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<span class="caption-subject bold uppercase"><spring:message code="monre.01.label.thong-tin-tep-dinh-kem"></spring:message> </span>
									</div>
									<div class="panel-body" id="ThongTinTepDinhKemViewModel">
										<jsp:include page="upload_file.jsp"></jsp:include>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row" id="GhiHoSoViewModel">
						<div class="bt-row-button" style="width: 400px;">
							<c:if test="<%= form != null && !form.isXemHoSo() %>">
								<button type="button" class="btn green bt-center bt-width-130" data-bind="click: $root.ghiLai" id="btghiLai">
									<i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;
									<spring:message code="monre_01_button_title_ghi_lai" />
								</button>
							</c:if>
							<c:if test="<%= form != null && !form.isXemHoSo() && form.getIdHS() > 0 %>">
								<button type="button" class="btn green bt-center bt-width-130" id="btGuiHoSo" data-bind="click: guiHoSo">
									<i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp;
									<spring:message code="monre_01_button_title_gui_ho_so" />
								</button>
							</c:if>
							<a href="<%= request.getContextPath() + AppCommon.getUri(request) + "/home" %>" class="btn green bt-center bt-width-130" id="btDong"> <i class="fa fa-arrow-left" aria-hidden="true"></i></i>&nbsp; <spring:message code="monre_01_button_title_quay_lai" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>
<script type="text/javascript" src="<c:url value="/app/monre/01/CAPlugin.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/vt-connector.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/models.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/thongtinchung.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/cososx.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/thongtingiayxacnhan.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/thongtinphelieu.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/tepdinhkem.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/01/ghihoso.module.js?v=${version}"/>"></script>
