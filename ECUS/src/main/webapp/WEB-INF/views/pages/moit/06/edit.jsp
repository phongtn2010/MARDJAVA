<%@page import="com.nsw.moit.p06.util.Moit06Constants"%>
<%@page import="com.nsw.moit.p06.model.HoSo6EditForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>
<script type="text/javascript" src="<c:url value="/app/moit/06/knockout-validator-language/vi.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/knockout-validator-language/en-US.js"/>"></script>
<%
	HoSo6EditForm form = (HoSo6EditForm) request.getAttribute("form");
	String locale = request.getLocale().getLanguage();
%>
<script type="text/javascript">
	var xemHoSo = <%= form.isXemHoSo() %>;
	var idHoSo = <%= form.getIdHoSo() %>;
	var idHoSoGoc = <%= form.getIdHoSoGoc() %>;
	var requiredSign = <%= form.isSign() %>;
	var isYeuCauSua = <%= form.getIsChinhSua() %>;
	var saveFast = <%= form.isSaveFast() %>;
	ko.validation.locale('vi');
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
<spring:url value="<%=Moit06Constants.ApiUrls.ROOT + Moit06Constants.ApiUrls.SAVE %>" var="save"></spring:url>
<form id="form">
	<div class="row">
		<div class="col-md-12">
			<div class="portlet light ">
				<div class="portlet-title">
					<div class="caption font-dark">
						<i class="icon-settings font-dark"></i> <span class="caption-subject bold uppercase"><spring:message code="moit.06.tenthutuc" /></span>
					</div>
				</div>
				
				<div class="portlet-body" id="table-search">
					<div class="table-toolbar">
						<div >
						
							<div class="row">
								<div class="col-md-12">
									<div  id="ThongTinChungViewModel">
											<jsp:include page="thong_tin_chung.jsp"></jsp:include>
										</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="panel-heading">
											<span class="caption-subject bold uppercase"><spring:message code="moit.06.form.02"></spring:message> </span>
										</div>
										<div class="panel-body" id="ThongTinHangHoaViewModel">
											<jsp:include page="thong_tin_hang_hoa.jsp"></jsp:include>
										</div>
										<div class="panel-body" id="ChiTietHangHoaViewModel">
											<jsp:include page="chi_tiet_hang_hoa.jsp"></jsp:include>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										<span class="caption-subject bold uppercase"><spring:message code="moit.06.form.04"></spring:message> </span>
									</div>
									<div class="panel-body" id="ThongTinTepDinhKemViewModel">
										<jsp:include page="upload_file.jsp"></jsp:include>
									</div>
								</div>
							</div>
						</div>
						<div class="row"  id="XinSuaHoSoViewModel">
							<div class="col-md-12" data-bind="if: ($root.isYeuCauSua())">
								<div class="panel panel-default">
									<div class="panel-heading">
										<span class="caption-subject bold uppercase"><spring:message code="moit.06.form.xinSuaHoSo.01"></spring:message><span class="nsw-require-field">*</span></label></span>
									</div>
									<div class="panel-body" >
										<jsp:include page="xin_sua_ho_so.jsp"></jsp:include>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row table-responsive" id="GhiHoSoViewModel">
						<div class="btrow">
							<span data-bind="if: (!$root.xemHoSo())">
							<button type="button" class="btn green bt-center btwidth" data-bind="click: $root.ghiLai" id="btghiLai">
								<i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;
								<spring:message code="moit.06.form.06" />
							</button>
							<button type="button" class="btn green bt-center btwidth" id="btGuiHoSo" data-bind="click: guiHoSo">
								<i class="fa fa-paper-plane" aria-hidden="true"></i>&nbsp;
								<spring:message code="moit.06.form.07" />
							</button>
							</span>
							<a href="<c:url value="/moit/06/home" />" class="btn green bt-center btwidth" id="btDong"> <i class="fa fa-arrow-left" aria-hidden="true"></i></i>&nbsp; <spring:message code="moit.06.form.08" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="<c:url value="/app/moit/06/CAPlugin.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/vt-connector.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/models.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/thongtinchung.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/thongtinhanghoa.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/chitiethanghoa.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/tepdinhkem.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/xinsuahoso.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/moit/06/ghihoso.module.js?v=${version}"/>"></script>
