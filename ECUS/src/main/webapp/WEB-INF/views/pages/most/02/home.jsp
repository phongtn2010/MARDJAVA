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
                    <span class="caption-subject bold uppercase"><span class="caption-subject bold uppercase"> <spring:message code="most.02.title.index" /></span>
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
                                    <form role="form" class="form-horizontal" name="searchForm02" id="searchForm02">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="common.tracuu.ma_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text">
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="common.tracuu.trang_thai_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2">
                                                        <option value=" "><spring:message code="common.tatca" /></option>
                                                        <option value="0"><spring:message code="most.02.trangthai.taomoi" /></option>
                                                        <option value="1"><spring:message code="most.02.trangthai.chotiepnhan" /></option>
                                                        <option value="2"><spring:message code="most.02.trangthai.datiepnhan" /></option>
                                                        <option value="3"><spring:message code="most.02.trangthai.daruthoso" /></option>
                                                        <option value="4"><spring:message code="most.02.trangthai.yeucauboxung" /></option>
                                                        <option value="5"><spring:message code="most.02.trangthai.daboxung" /></option>
                                                        <option value="6"><spring:message code="most.02.trangthai.thongbaokiemtra" /></option>
                                                        <option value="7"><spring:message code="most.02.trangthai.dacokqkiemtra" /></option>
                                                        <option value="8"><spring:message code="most.02.trangthai.dasuahoso" /></option>
                                                    </select>
                                                </div>
                                            </div>  
                                        </div> 
                                       <div class="form-group"> 
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Số thông báo</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="soThongBao" id="soThongBao" placeholder="Số giấy phép được cấp" type="text">
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Mã doanh nghiệp</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="nguoiTao" id="nguoiTao" placeholder="Tên tài khoản đăng nhập hệ thống 1 Cửa" type="text">
                                                </div> 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_tu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_den" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="ngayTaoDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo"><i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" /></a>                                            
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
                            <th class="text-center"> <spring:message code="common.table.col.stt" /></th>
                            <th class="text-center"> <spring:message code="common.table.col.lich_su_tac_dong" /> </th>
                            <th class="text-center"> <spring:message code="common.table.col.ma_ho_so" /> </th>
                            <th class="text-center"> <spring:message code="common.table.col.co_quan_xu_ly" /> </th>
                            <th class="text-center"> <spring:message code="common.table.col.ngay_tao" /> </th>
                            <th class="text-center"> <spring:message code="common.table.col.trang_thai_ho_so" /> </th>
                            <th class="text-center"> <spring:message code="most.02.table.col.thongbaoketquakiemtra" /> </th>                            
                        </tr>
                    </thead>
                    <tbody id="list-container">
                       
                    </tbody>
                </table>
                <div class="row">                            
                    <div class="col col-md-12 nsw-text-right">
                        <div id="list-pager"> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/app/most/02/index.module.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/02/handlebarsHelper.js?v=${version}' />" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        $.fn.select2.defaults.set("theme", "bootstrap");
         var controller = new IndexController();
        controller.init({
            container: 'list-container',
            form: 'searchForm02',
            pager: 'list-pager'
        }); 
      
    });

</script>
