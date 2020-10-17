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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="incLanguage.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="common.sua_thong_tin_ho_so" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default" id="pnl-import" style="display: ${hideImport}">
                            <div class="panel-heading">
                                <span class="caption-subject bold uppercase"><spring:message code="common.nhap_tu_excel" /> </span>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <p><a href="<c:url value='/templates/most/bm_most_02.xlsx'/>"><spring:message code="common.ban_khai_ho_so_mau" /></a></p>
                                    </div>
                                    <div class="col-md-8 ">
                                        <div class="fileinput fileinput-new" data-provides="fileinput">
                                            <span class="btn grey btn-file">
                                                <span class="fileinput-new"> <spring:message code="file.import.chon_file" /> </span>
                                                <span class="fileinput-exists"> <spring:message code="file.thay_doi" /> </span>
                                                <input value="" name="..." type="hidden"><input name="file-import-excel" type="file" id="file-import-excel"> </span>
                                            <span class="fileinput-filename"></span> &nbsp;
                                            <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                                        </div>
                                        <a href="javascript:;" class="btn blue" id="btnImport"><i class="fa fa-check"></i> <spring:message code="file.import.nhap_du_lieu" /></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                                    
                        <div class="clearfix"></div>
                        <form class="form-horizontal" id="form-ttc">
                            <c:if test="${hasReason}">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2">
                                        <label><spring:message code="most.02.hoso.lydosua" /></label><a class="nsw-require-field">*</a>
                                    </div>
                                    <div class="col-md-4">                                        
                                        <textarea require="true" class="form-control" maxlength="2000" cols="46" name ="fiLydoSua" id="fiLydoSua">${hosoData.fiLydoSua}</textarea>
                                    </div>
                                </div>
                            </div>
                            </c:if>

                            <div class="clearfix"></div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2">
                                        <label><spring:message code="most.02.hoso.coquanxuly" /></label><a class="nsw-require-field">*</a>
                                    </div>
                                    <div class="col-md-4">
                                        <c:choose>
                                            <c:when test = "${hosoData.fiTrangthai == 0}">
                                                <select class="form-control select2" id="fiMaCqCap" name="fiMaCqCap" require="true" field="most_02_coquanxuly" 
                                                        data="${hosoData.fiMaCqCap}">
                                                    <option value="-1"><spring:message code="common.chon" /></option>
                                                    <c:forEach items="${cqxl.data}" var="donvi">
                                                        <option value="${donvi.fiMa}">${donvi.fiTen}</option>
                                                    </c:forEach>
                                                </select>
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test = "${hosoData.fiTrangthai != 0}">
                                                <input type="text" value="${hosoData.fiTenCqCap}" class="form-control" readonly />
                                                <input type="hidden" name="fiMaCqCap" id="fiMaCqCap" value="${hosoData.fiMaCqCap}" />
                                                <input type="hidden" name="fiTenCqCap" id="fiTenCqCap" value="${hosoData.fiTenCqCap}" />
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>

                        </form>

                        <div class="clearfix"></div>
                        
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <div class="tab-content">
                                    <form class="form-horizontal" id="form-dn">
                                        <input type ="hidden" name="fiIdHoso" id="fiIdHoso" value="${hosoData.fiIdHoso}">
                                        <input type ="hidden" name="fiSoDkkt" id="fiSoDkkt" value="${hosoData.fiSoDkkt}">
                                        <input type ="hidden" name="fiHoatdong" id="fiHoatdong" value="${hosoData.fiHoatdong}">
                                        <input type ="hidden" name="fiNguoitao" id="fiNguoitao" value="${hosoData.fiNguoitao}">
                                        <input type ="hidden" name="fiLydoSua" id="fiLydoSua" value="${hosoData.fiLydoSua}">
                                        <input type ="hidden" name="fiTrangthai" id="fiTrangthai" value="${hosoData.fiTrangthai}">
                                        <input type ="hidden" name="fiTenTT" id="fiTenTT" value="${hosoData.fiTenTT}">
                                        <input type="hidden" name="fiTotalFileSize" id="fiTotalFileSize" value="0"/>
                                        <input type="date" id="fiNgaytao" name="fiNgaytao" value="<fmt:formatDate value="${hosoData.fiNgaytao}" pattern="yyyy-MM-dd" />" class="hidden"/>
                                        <c:if test="${!empty hosoData.fiMaHoso}">
                                            <input type="hidden" id="fiMaHoso" name="fiMaHoso" value="${hosoData.fiMaHoso}"/>
                                        </c:if>
                                        <c:if test="${!empty hosoData.fiNgayGui}">
                                            <input type="hidden" id="fiNgayGui" name="fiNgayGui" value="<fmt:formatDate value="${hosoData.fiNgayGui}" pattern="yyyy-MM-dd " />"/>
                                        </c:if>
                                            
                                    <fieldset>
                                        <legend><spring:message code="most.02.hoso.thongtindoanhnghiep" /></legend>
                                      
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.ma_so_thue" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" id="fiMstDn" name="fiMstDn" readonly maxlength="13" placeholder="<spring:message code="common.ma_so_thue" />"
                                                           field="most_02_hoso_masothue" value="${hosoData.fiMstDn}" type="text">
                                                </div>
                                                
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.diachi" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" id="fiDiachiDnNk" name="fiDiachiDnNk" readonly maxlength="255" field="most_02_hoso_diachi"
                                                           placeholder="<spring:message code="most.02.hoso.diachi" />" value="${hosoData.fiDiachiDnNk}" type="text" >
                                                </div>
                                                
                                            </div>  
                                        </div> 
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.tendoanhnghiep" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" id="fiTenDnNk" name="fiTenDnNk" readonly maxlength="255" field="most_02_hoso_tendoanhnghiep"
                                                           placeholder="<spring:message code="most.02.hoso.tendoanhnghiep" />" value="${hosoData.fiTenDnNk}" type="text" >
                                                </div>

                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.nguoidaidien" /></label><a class="nsw-require-field">*</a>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control form-control-inline" id="fiNguoiDd" readonly name="fiNguoiDd" field="most_02_hoso_nguoidaidien" maxlength="100"
                                                            placeholder="<spring:message code="most.02.hoso.nguoidaidien" />" value="${hosoData.fiNguoiDd}" type="text"  />
                                                </div>  
                                            </div>  
                                        </div> 
                                                
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.sodienthoai" /></label>
                                                </div>
                                                <div class="col-md-4">                                        
                                                    <input class="form-control form-control-inline" id="fiDtDnNk" readonly name="fiDtDnNk" maxlength="50" field="most_02_hoso_sodienthoai"
                                                            placeholder="<spring:message code="most.02.hoso.sodienthoai" />" value="${hosoData.fiDtDnNk}" type="text" />
                                                </div>
                                                <div class="col-md-2">
                                                    <label><spring:message code="most.02.hoso.fax" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control form-control-inline" id="fiFaxDnNk" readonly name="fiFaxDnNk" value="${hosoData.fiFaxDnNk}" 
                                                           placeholder="<spring:message code="most.02.hoso.fax" />" type="text" maxlength="50" />
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                    </form>
                                    <br> 
                                    <%@include file="tokhai.jsp" %>
                                    <%@include file="hanghoa.jsp" %>
                                    <%@include file="tailieudinhkem.jsp" %>
                                    <p class="nsw-text-center">
                                        <c:choose>
                                            <c:when test = "${hosoData.fiTrangthai == 0}">
                                               <a href="javascript:;" class="btn blue" id="btnLuu" style="display: ${IsView}"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                            </c:when>
                                        </c:choose>
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
        window.controller = new HoSoController();
        window.controller.init({
            data: data,
            isView:"${IsView}"
        });
    });
</script>


