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
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"><span class="caption-subject bold uppercase"> <spring:message code="moh.typea.ten_thu_tuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i class="fa fa-gift"></i> <spring:message code="common.tracuu.thong_tin_tim_kiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm06" id="searchForm06">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ma_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text">
                                                </div>
                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.trang_thai_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2">
                                                        <option value=" "><spring:message code="common.tatca" /></option>
                                                        <option value="0"><spring:message code="moh.06.hoso.trangthai.taomoi" /></option>
                                                        <option value="1"><spring:message code="moh.06.hoso.trangthai.choxacnhan" /></option>
                                                        <option value="2"><spring:message code="moh.06.hoso.trangthai.noplaiphi" /></option>
                                                        <option value="3"><spring:message code="moh.06.hoso.trangthai.dangxuly" /></option>
                                                        <option value="4"><spring:message code="moh.06.hoso.trangthai.traketqua" /></option>
                                                        <option value="5"><spring:message code="moh.06.hoso.trangthai.thuhoi" /></option>
                                                    </select>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="form-group">
                                            <div class="col-md-12">                                               

                                                
                                            </div>  
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_tu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" />
                                                </div>

                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_den" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="ngayTaoDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo"><i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" /></a>
                                            <a href="javascript:;" class="btn green" id="btnAddNew"><i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" /></a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">                            
                    <div class="col col-md-12">
                        <spring:message code="common.tong" /> <b><a id="lbTotalRecords" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th> <spring:message code="common.table.col.stt" /></th>
                            <th> <spring:message code="common.table.col.lich_su_tac_dong" /> </th>
                            <th> <spring:message code="common.table.col.ma_ho_so" /> </th>
                            <th> <spring:message code="common.table.col.so_van_ban_doanh_nghiep" /> </th>
                            <th> <spring:message code="common.table.col.trang_thai_ho_so" /> </th>
                            <th> <spring:message code="common.table.col.ngay_tao" /> </th>
                            <th> <spring:message code="common.table.col.sua" /> </th>
                            <th> <spring:message code="common.table.col.xoa" /> </th>
                            <th> <spring:message code="moh.typea.table.col.gui" /> </th>
                            <th> <spring:message code="moh.typea.table.col.phieu_tiep_nhan" /> </th>
                        </tr>
                    </thead>
                    <tbody id="list-container">
                       
                    </tbody>
                </table>
                <div class="row">                            
                    <div class="col col-md-6">

                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager"> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/app/moh/typea/index.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/moh/typea/HandlebarsHelpers.js' />" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        $.fn.select2.defaults.set("theme", "bootstrap");
         var controller = new IndexController();
        controller.init({
            container: 'list-container',
            form: 'searchForm06',
            pager: 'list-pager'
        }); 
      
    });

</script>
