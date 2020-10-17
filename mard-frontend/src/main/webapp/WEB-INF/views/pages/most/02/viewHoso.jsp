<%-- 
    Document   : edit
    Created on : Mar 28, 2017, 1:32:29 PM
    Author     : PhongNguyen
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="incLanguage.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="common.sua_thong_tin_ho_so" /> ${hosoData.fiMaHoso}</span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">                                    
                        <div class="clearfix"></div>
                        <div class="col-md-12 col-lg-12">
                            <div class="col col-lg-2 pull-right">
                                <a href = " ${pageContext.request.contextPath}/most/02/hosofile/${hosoData.fiIdHoso}"><i class="fa fa-print fa-lg"></i> In hồ sơ</a>
                            </div>
                            <div class="col-md-2 col-lg-2 pull-left">
                            <spring:message code="most.02.hoso.coquanxuly" /><a class="nsw-require-field">*</a> 
                            </div>
                            <div class="col col-lg-3 col-md-4">
                                <input type="text" value="${hosoData.fiTenCqCap}" class="form-control" readonly>
                            </div>
                        </div>
                                
                        <div class="clearfix"></div>
                        
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <div class="tab-content">
                                    <form class="form-horizontal" id="form-dn">
                                    <fieldset>
                                        <legend><spring:message code="most.02.hoso.thongtindoanhnghiep" /></legend>
                                      
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.ma_so_thue" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" value="${hosoData.fiMstDn}" class="form-control" readonly>
                                                </div>
                                                
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.diachi" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" value="${hosoData.fiDiachiDnNk}" class="form-control" readonly>
                                                    
                                                </div>
                                                
                                            </div>  
                                        </div> 
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.tendoanhnghiep" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" value="${hosoData.fiTenDnNk}" class="form-control" readonly>
                                                </div>

                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.nguoidaidien" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" value="${hosoData.fiNguoiDd}" class="form-control" readonly>
                                                </div>  
                                            </div>  
                                        </div> 
                                                
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.sodienthoai" /></label>
                                                </div>
                                                <div class="col-md-4">                       
                                                    <input type="text" value="${hosoData.fiDtDnNk}" class="form-control" readonly>
                                                </div>
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.fax" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" value="${hosoData.fiFaxDnNk}" class="form-control" readonly>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                    </form>
                                    <br> 
                                    <%@include file="viewTokhai.jsp" %>
                                    <%@include file="viewHanghoa.jsp" %>
                                    <%@include file="viewTailieudinhkem.jsp" %>
                                    <p class="nsw-text-center">
                                        <a href="javascript:;" class="btn blue" id="btnLuu" style="display: ${IsView}"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                        <a href="javascript:;" class="btn blue" id="btnGui" style="display: ${IsView}"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                        <a href="javascript:;" class="btn grey" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/app/most/02/handlebarsHelper.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/hanghoa.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/dmhanghoa.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/tailieukhac.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/chungnhanxuatxu.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/hopdong.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/hoso.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/tokhai.module.js?v=${version}' />" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        var data = ${hosoJson};
        var controller = new HoSoController();
        controller.init({
            data: data,
            isView:"${IsView}"
        });
    });
</script>


