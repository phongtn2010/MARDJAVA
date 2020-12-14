<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<div class="row" id="mt-container">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"> <spring:message code="most.06.xemKetQua.title" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.06.xemKetQua.tenCQ" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" data-bind="value: fiTenCoQuan " type="text" readonly="readonly"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.06.xemKetQua.sogp" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" data-bind="value: fiSoGiayphep " type="text" readonly="readonly"/>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.06.xemKetQua.ngayky" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" data-bind="datepicker : ngayTaoTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" disabled="disabled"/>
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="most.06.xemKetQua.nguoiky" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo"  type="text" readonly="readonly"/>
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.06.xemKetQua.ngayHLTu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayCapTuNgay" id="ngayCapTuNgay"  class="form-control form-control-inline date-picker" 
                                                           data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" disabled="disabled"/>
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.06.xemKetQua.ngayHLDen" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayCapDenNgay" id="ngayCapDenNgay" class="form-control form-control-inline date-picker" 
                                                           data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" disabled="disabled"/>
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>File văn bản cho phép <a href="#">giayphepNKBX.pdf</a></label>
                                                </div>

                                               
                                            </div>  
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="caption font-dark" style="margin-bottom: 30px">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"><b>CÁC ĐẶC TRƯNG CỦA NGUỒN BỨC XẠ TRONG CÔNG VIỆC BỨC XẠ ĐƯỢC CẤP GIẤY PHÉP</b></span>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="monre06Items">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> <spring:message code="most.06.hoso.danhsach.stt" /></th>
                            <th class="text-center" style="width: 200px;"> <spring:message code="most.06.xemKetQua.tenDV" /> </th>
                            <th class="text-center" style="width: 150px;"> <spring:message code="most.06.xemKetQua.dangnguon" /> </th>
                            <th class="text-center" style="width: 150px;"> <spring:message code="most.06.xemKetQua.mahieu" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="most.06.xemKetQua.hang" /> </th>
                            <th class="text-center" style="width: 150px;"> <spring:message code="most.06.xemKetQua.trangthaivl" /> </th>
                            <th class="text-center" style="width: 150px;"> <spring:message code="most.06.xemKetQua.hoatdo" /> </th>
                            <th class="text-center" style="width: 150px;"> <spring:message code="most.06.xemKetQua.cvbucxa" /> </th>
                            <th class="text-center" style="width: 300px;"> <spring:message code="most.06.xemKetQua.thietbi" /> </th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                    </table>
                    <div class="form-group nsw-text-center">
                            <a  class="btn blue"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value='/app/most/06/ViewVM.js?v=${version}' />" type="text/javascript"></script>