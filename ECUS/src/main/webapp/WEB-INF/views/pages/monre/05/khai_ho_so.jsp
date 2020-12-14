<%@page import="com.nsw.monre.p05.constant.AppViewThuTuc05Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="import_package.jsp" %>
	<%@include file="incLanguage.jsp"%>
 <link href="<c:url value='/app/monre/01/monre_01.css?v=${version}' />" rel="stylesheet" type="text/css" />   
<%
TbdHSDeNghiCapGiayXn5 form = (TbdHSDeNghiCapGiayXn5)request.getAttribute("form");
int loaiThuTuc = AppCommon.getLoaiThuTucHienTai(request);
long idHoSo = form.getIdHS();
String uriContextPath = AppCommon.getUri(request);
%>
<script type="text/javascript">
	var idHoSo = <%= idHoSo %>;
	var loaiThuTuc = <%= loaiThuTuc %>;
	var uriContextPath = '<%= uriContextPath %>';
	var xemHoSo = <%= form.isXemHoSo() %>;
</script>

<spring:url value='<%= AppCommon.getUri(request) + "/send" %>' var="save"></spring:url>
<form:form commandName="form" action="${ save }?${_csrf.parameterName}=${_csrf.token}" id="form">


	<form:hidden path="idHS" cssClass="form-control" />
	<input type="hidden" id="contextPath" value="<%= request.getContextPath() + AppCommon.getUri(request) %>" >
	<input type="hidden" id="uriContextPath" value="<%= AppCommon.getUri(request) %>" >
	<input type="hidden" id="loaiThuTucHienTai" value="<%= AppCommon.getLoaiThuTucHienTai(request) %>" >

	<div class="row">
		<div class="col-md-12">
			<div class="portlet light ">
				<div class="portlet-title">
					<div class="caption font-dark">
						<i class="icon-settings font-dark"></i> <span
							class="caption-subject bold uppercase">${ TEN_THU_TUC }</span>
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
										<span class="caption-subject bold uppercase"><spring:message
												code="monre.01.label.thong-tin-chung"></spring:message> </span>
									</div>
									<div class="panel-body" id="thong_tin_chung">
										<jsp:include page="thong_tin_chung.jsp"></jsp:include>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row" id="GiayXacNhanViewModel">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<span class="caption-subject bold uppercase"><spring:message
											code="monre.01.khai-ho-so-thong-tin-gxn"></spring:message> </span>
								</div>
								<div class="panel-body" >
									<jsp:include page="thong_tin_giay_xac_nhan.jsp"></jsp:include>
								</div>
							</div>
						</div>
						</div>
						
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<span class="caption-subject bold uppercase"><spring:message
												code="monre.01.label.thong-tin-tep-dinh-kem"></spring:message>
										</span>
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
								<button type="button" class="btn green bt-center bt-width-130"
									data-bind="click: $root.ghiLai" id="btghiLai">
									<i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;
									<spring:message code="monre_01_button_title_ghi_lai" />
								</button>
							</c:if>
							<c:if test="<%= form != null && !form.isXemHoSo()  && form.getIdHS() > 0  %>">
								<button type="button" class="btn green bt-center bt-width-130" id="btGuiHoSo" data-bind="click: guiHoSo">
									<i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp;
									<spring:message code="monre_01_button_title_gui_ho_so" />
								</button>
							</c:if>
							<a href="<%= request.getContextPath() + AppCommon.getUri(request) + "/home" %>" class="btn green bt-center bt-width-130" id="btDong" >
								<i class="fa fa-arrow-left" aria-hidden="true"></i></i>&nbsp;
								<spring:message code="monre_01_button_title_quay_lai" />
							</a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>




</form:form>

<script type="text/javascript" src="<c:url value="/app/monre/05/models.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/05/thongtinchung.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/05/thongtingiayxacnhan.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/05/tepdinhkem.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/monre/05/ghihoso.module.js?v=${version}"/>"></script>

