<%@page import="com.nsw.sbv.p01.util.SBV01Constants"%>
<%@page import="com.nsw.sbv.p01.model.HoSoNgoaiTeEditForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>
<%
	HoSoNgoaiTeEditForm form = (HoSoNgoaiTeEditForm) request.getAttribute("form");
%>
<script type="text/javascript">
	var xemHoSo = <%= form.isXemHoSo() %>;
	var idHoSo = <%= form.getIdHoSo() %>;
	var requiredSign = <%= form.isSign() %>;
</script>
<style>
.btrow {
	width: 650px;
	display: block;
	margin: auto;
}

.btwidth {
	width: 200px;
	display: block;
	float: left;
	margin-right: 15px;
}
</style>
<spring:url value="<%=SBV01Constants.ApiUrls.ROOT + SBV01Constants.ApiUrls.SAVE%>" var="save"></spring:url>
<form id="form">
	<div class="row">
		<div class="col-md-12">
			<div class="portlet light ">
				<div class="portlet-title">
					<div class="caption font-dark">
						<i class="icon-settings font-dark"></i> <span class="caption-subject bold uppercase"><spring:message code="sbv.01.tenthutuc" /></span>
					</div>
				</div>
				
				<div class="portlet-body" id="table-search">
					<div class="table-toolbar">
						<div id="ThongTinNgoaiTeViewModel">
							<div class="row">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-body" id="thong_tin_chung">
											<jsp:include page="thong_tin_chung.jsp"></jsp:include>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-heading">
											<span class="caption-subject bold uppercase"><spring:message code="sbv.01.form.02"></spring:message> </span>
										</div>
										<div class="panel-body" id="ThongTinNganHangViewModel">
											<jsp:include page="thong_tin_ngan_hang.jsp"></jsp:include>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-heading">
											<span class="caption-subject bold uppercase"><spring:message code="sbv.01.form.03"></spring:message> </span>
										</div>
										<div class="panel-body">
											<jsp:include page="thong_tin_ngoai_te.jsp"></jsp:include>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<span class="caption-subject bold uppercase"><spring:message code="sbv.01.form.04"></spring:message> <i style="color: red;"><spring:message code="sbv.01.form.05"></spring:message></i> </span>
									</div>
									<div class="panel-body" id="ThongTinTepDinhKemViewModel">
										<jsp:include page="upload_file.jsp"></jsp:include>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row table-responsive" id="GhiHoSoViewModel">
						<div class="btrow">
							<button type="button" class="btn green bt-center btwidth" data-bind="click: $root.ghiLai" id="btghiLai">
								<i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;
								<spring:message code="sbv.01.form.06" />
							</button>
							<button type="button" class="btn green bt-center btwidth" id="btGuiHoSo" data-bind="click: guiHoSo">
								<i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp;
								<spring:message code="sbv.01.form.07" />
							</button>
							<a href="<c:url value="/sbv/01/home" />" class="btn green bt-center btwidth" id="btDong"> <i class="fa fa-arrow-left" aria-hidden="true"></i></i>&nbsp; <spring:message code="sbv.01.form.08" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="<c:url value="/app/sbv/01/CAPlugin.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/vt-connector.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/docso.module.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/vi.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/models.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/thongtinngoaite.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/tepdinhkem.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/sbv/01/ghihoso.module.js?v=${version}"/>"></script>
