
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="inc_css.jsp" %> 
<div class="row" id="ResultVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase">GIẤY PHÉP NHẬP KHẨU</span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mt_1" data-toggle="tab" id="a-tab-mt-1"> <b>Thông tin giấy phép </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >
                                    <div class="tab-pane active" id="tab_mt_1">                                       
                                        <div class="row">
                                            <div class="col-md-12">
                                                <form role="form" class="form-horizontal" id="trangthietbi-form">
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Số giấy phép nhập khẩu</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiSoChungnhan" readonly="true" />
                                                            </div> 
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Đơn vị cấp phép</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiDonviKy" readonly="true" />
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Người ký</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiNguoiKy" readonly="true" />
                                                            </div> 
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Ngày ký</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiNgayKyText" readonly="true" />
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Số văn bản đề nghị</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiSoVbDn" readonly="true" />
                                                            </div> 
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Ngày văn bản đề nghị</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiNgayVbDnText" readonly="true" />
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Mục đich nhập khẩu</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiTenMdichNk" readonly="true" />
                                                            </div> 
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Loại trang thiết bị y tế</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiLoaiTtb" readonly="true" />
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Tên trang thiết bị y tế</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiTenTtb" readonly="true" />
                                                            </div> 
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Số lượng nhập khẩu</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiSoluongNk" readonly="true" />
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    
                                                    <b>Danh sách chủng loại/ mã sản phẩm chi tiết</b>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                                                <thead>
                                                                    <tr class="nsw-tr tr-nsw1-bgcolor">
                                                                        <th class="text-center" style="width: 50px">STT</th>
                                                                        <th class="text-center">Chủng loại/Mã sản phẩm</th>
                                                                        <th class="text-center">Tên cơ sở sản xuất</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody data-bind="foreach: lstHangHoas">
                                                                    <tr>
                                                                        <td class="text-center" data-bind="text : $index() + 1"></td>  
                                                                        <td class="text-center" data-bind="text : fiChungloai"></td>  
                                                                        <td class="text-center" data-bind="text : fiTenCssx"></td>  
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    
                                                    <b>File đính kèm</b> 
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                                                <tbody>
                                                                    <tr>
                                                                        <td style="width: 30%;">File giấy chứng nhận đăng ký lưu hành</td>  
                                                                        <td style="width: 20%">
                                                                            <a data-bind="attr: {href: downloadUrl}" target="_blank">Tải về</a>
                                                                        </td>  
                                                                        <td style="width: 30%;text-align: right">Link download file</td>  
                                                                        <td style="width: 20%">
                                                                            <a data-bind="attr: {href: fiDuongDan}, text: fiDuongDan" target="_blank"></a>
                                                                        </td>  
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div> 
                                                </form>
                                            </div>
                                        </div>
                                     
                                    </div>
                                    <p class="nsw-text-center">
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
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
<%@include file="inc_script.jsp" %>      
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
    var PROCEDUCE = {
        MOH_07: 'BYTE0400007',
        MOH_08: 'BYTE0400009'
    };
    var uploadUrl ='${upload}';
</script>
<script src="<c:url value='/app/moh/knockout.validation.extender.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/10/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/10/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
