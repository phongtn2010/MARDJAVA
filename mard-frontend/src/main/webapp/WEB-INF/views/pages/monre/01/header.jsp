<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="import_package.jsp" %>
     
<style>
	.monre-menu-item {
		width:100%;
	    text-decoration: none;
	    border: 1px solid;
	    margin-bottom: 10px;
	    margin-top: 10px;
	    color: #000;
	    padding: 10px 10px;
	    font-weight: bold;
	    font-size: small;
	    display: block;
	    text-align: center;
	    vertical-align: middle;
	    display: inline-block
	}
	a.monre-menu-item-active {
		background: #b58282;
		color: #FFF !important;
	}
	
	a.monre-menu-item {
		text-decoration: none !important;
	}
	a.monre-menu-item:hover {
		border-color: #b58282;
		color: #b58282;
	}
	@media only screen and (max-width: 1080px) {
    	
    	.monre-menu-item {
	
	    	min-height: 60px;
		}
	}
	
	.select2-container {
	    width: 100%;
	}
	
</style>


<div class="col-md-12">
		<div class="col-md-3">
				<a href="<c:url value="/monre/01/home"/>" class='monre-menu-item <%= AppCommon.getLoaiThuTuc(request).equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_01_CAP_GIAY_XAC_NHAN_TRUC_TIEP) ? "monre-menu-item-active" : "" %>'>Cấp giấy xác nhận Trực tiếp</a>
		</div>
		<div class="col-md-3">
				<a href="<c:url value="/monre/02/home"/>" class='monre-menu-item <%= AppCommon.getLoaiThuTuc(request).equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_02_GIA_HAN_CAP_GIAY_XAC_NHAN_TRUC_TIEP) ? "monre-menu-item-active" : "" %>'>Gia hạn giấy xác nhận Trực tiếp</a>
		</div>
		<div class="col-md-3">
				<a href="<c:url value="/monre/03/home"/>" class='monre-menu-item <%= AppCommon.getLoaiThuTuc(request).equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_03_CAP_GIAY_XAC_NHAN_UY_THAC) ? "monre-menu-item-active" : "" %>'>Cấp giấy xác nhận Ủy thác</a>
		</div>
		<div class="col-md-3">
				<a href="<c:url value="/monre/04/home"/>" class='monre-menu-item <%= AppCommon.getLoaiThuTuc(request).equals(AppKeyConstant.LoaiThuTuc.MA_THU_TUC_04_GIA_HAN_CAP_GIAY_XAC_NHAN_UY_THAC) ? "monre-menu-item-active" : "" %>'>Gia hạn giấy xác nhận Ủy thác</a>
		</div>
</div>

