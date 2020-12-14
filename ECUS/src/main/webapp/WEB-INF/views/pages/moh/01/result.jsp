
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
                    <span class="caption-subject bold uppercase" data-bind="text: propTitle"></span>
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
                                                                <label>Số giấy phép</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="true" />
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
                                                                <label>Ngày hết hạn</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiNgayHethanText" readonly="true" />
                                                            </div> 
                                                            
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Tên chủ sở hữu giấy phép</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiTenCsh" readonly="true" />
                                                            </div> 
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Mã số thuế Doanh nghiệp</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiMstCsh" readonly="true" />
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="display: none">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Loại chế phẩm</label>
                                                            </div>
                                                            <div class="col-md-4">
                                                                <input class="form-control" type="text" data-bind="value : fiLoaiCp" readonly="true" />
                                                            </div> 
                                                            
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <div class="col-md-2 nsw-text-right">
                                                                <label>Mục đích nhập khẩu</label>
                                                            </div>
                                                            <div class="col-md-10">
                                                                <input class="form-control" type="text" data-bind="value : fiTenMdichNk" readonly="true" />
                                                            </div> 
                                                        </div>
                                                    </div>
                                                    <b>Thông tin nhập khẩu chế phẩm</b>
                                                    <div class="form-group">
                                                        <div class="col-md-12">
                                                            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                                                <thead>
                                                                    <tr class="nsw-tr tr-nsw1-bgcolor">
                                                                        <th class="text-center"><spring:message code="moh.01.hanghoa.stt" /></th>
                                                                        <th class="text-center"><spring:message code="moh.01.hanghoa.tenttb" /></th>
                                                                        <th class="text-center"><spring:message code="moh.01.hanghoa.hamluonghc" /></th>
                                                                        <th class="text-center"><spring:message code="moh.01.hanghoa.tacdungcuachepham" /></th>
                                                                        <th class="text-center"><spring:message code="moh.01.hanghoa.donvitinh" /></th>
                                                                        <th class="text-center"><spring:message code="moh.01.hanghoa.soluong" /></th>
                                                                        <th class="text-center"><spring:message code="moh.01.hanghoa.tendiachinsx" /></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody data-bind="foreach: lstItems">
                                                                    <tr>
                                                                        <td data-bind="text : $index() + 1"></td>  
                                                                        <td data-bind="text : fiTenCp"></td>  
                                                                        <td data-bind="text : fiHamLuong"></td>  
                                                                        <td data-bind="text : fiTacDungCp"></td>  
                                                                        <td data-bind="text : fiDviTinh"></td>  
                                                                        <td data-bind="text : fiSoLuong"></td>  
                                                                        <td data-bind="text : fiTenNsx"></td>  
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
                                                                        <td style="width: 30%">File giấy chứng nhận đăng ký lưu hành</td>  
                                                                        <td style="width: 20%">
                                                                            <a data-bind="attr: {href: downloadUrl}" target="_blank">Xem</a>
                                                                        </td>  
                                                                        <td style="width: 30%">Link download file</td>  
                                                                        <td style="width: 20%">
                                                                            <a data-bind="attr: {href: fiDuongDan}" target="_blank">
                                                                                <i class="fa fa-save fa-lg"></i>
                                                                            </a>
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
    var uploadUrl ='${upload}';
    NSWLang["moh_BYTE0600001_tenthutuc"] = "<spring:message code="moh.BYTE0600001.tenthutuc" />";
    NSWLang["moh_BYTE0600002_tenthutuc"] = "<spring:message code="moh.BYTE0600002.tenthutuc" />";
    NSWLang["moh_BYTE0600003_tenthutuc"] = "<spring:message code="moh.BYTE0600003.tenthutuc" />";
    NSWLang["moh_BYTE0600004_tenthutuc"] = "<spring:message code="moh.BYTE0600004.tenthutuc" />";
</script>
<script src="<c:url value='/app/moh/knockout.validation.extender.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/01/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/01/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
