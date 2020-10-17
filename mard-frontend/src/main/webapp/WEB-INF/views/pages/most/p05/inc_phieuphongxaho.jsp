<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>  
    <legend><b><spring:message code="most.05.hoso.phongXaHo" /></b>  <a href="javascript:;" class="btn green" id="btnAddNewClickPXH" 
                                                                        data-bind="click :$data.formVM().btnAddNewClickPXH"><i class="fa fa-plus"></i></a></legend>
            <%--<%@include file="inc_css.jsp" %>--%>
    <form role="form" class="form-horizontal" name="searchForm">
        <table class="table table-striped table-bordered table-hover table-checkable order-column" >
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="most.05.hoso..phongXakin.stt" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXaho.tendvpx" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXaho.hangncsx" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXaho.cthoahoc" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXaho.hoatdo" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXaho.dctinh" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXaho.chucnang" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: $data.formVM().lstTbdhsTtpPxh05">
                <tr>
                    <td data-bind="text: $index() + 1">
                    </td>  
                    <td style="width: 220px" data-bind="text : fiTenDongViPhongXa">
                    </td>
                    <td style="width: 220px" data-bind="text : fiHangSanXuat">
                    </td>
                    <td style="width: 220px" data-bind="text : fiCongThucHoaHoc">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiTongHoatDoTrongNam">
                    </td>
                    <td style="width: 220px" data-bind="text : fiTenHoatDoDonVi">
                    </td>
                    <td style="width: 220px" class="text-center">                            
                        <a class="btn green bt-center" data-bind="click: $parent.formVM().btnEditClickPXH.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                        <a class="btn red bt-center" data-bind="click: $parent.formVM().removePXHOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
                 <span data-bind="text : $data.formVM().errorlistpxhoMessage" style="color:red;"> </span>
</fieldset>
<template id="phongXahHo-template">
    <div class="row" id="phongXahHo-vm" style="margin-left: 0px !important;margin-right: 0px !important;">
        <form role="form" class="form-horizontal" id="addPhongXaHo-form">
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.tenDVPhongXa" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10">
                        <select class="form-control select2" id="fiTenDongViPhongXa" name="fiTenDongViPhongXa" 
                                data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiMaDongViPhongXa
                                ,selectedText2 : fiTenDongViPhongXa
                                ,options : lstDongViPX, optionsText : 'name'"></select>
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /><a class="nsw-require-field">*</a></label>
                        
                    </div>
                    <div class="col-md-10">
                        <input class="form-control" id="fiHangSanXuat" name="fiHangSanXuat" data-bind="value: fiHangSanXuat" maxlength="250"/>
                    </div>
                    
                </div>
            </div>    
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.chiTietNKPhongXa.congThucHoaHoc" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiCongThucHoaHoc" name="fiCongThucHoaHoc" data-bind="value: fiCongThucHoaHoc" maxlength="2000"/> 
                    </div>

                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.chiTietNKPhongXa.trangThaiVatLy" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiTrangThaiVatLy" name="fiTrangThaiVatLy" type="text" data-bind="value: fiTrangThaiVatLy" maxlength="250"/>
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.tonghoatDo" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-2">
                        <input class="form-control" id="fiTongHoatDoTrongNam" name="fiTongHoatDoTrongNam" data-bind="value: fiTongHoatDoTrongNam" type="text"/> 
                    </div>
                    <div class="col-md-2">
                        <select class="form-control select2" id="fiHoatDoDonVi" name="fiHoatDoDonVi" 
                                data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                                , value : fiHoatDoDonVi , options : lstHoatDoDonVi, optionsText : 'name'"></select>
                    </div>
                </div>
            </div> 
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class= "col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.mucDichSuDung" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="validate[required]" id="fiMaMucDichSuDung" name="fiMaMucDichSuDung" multiple
                                data-bind="optionsValue : 'id', selectedOptions : lstMucdichsudungho
                                , options : lstNguonPXK, optionsText : 'name'
                                ,event: {change: mucdichhoAction}"></select>
                        <span id="fiMaMucDichSuDungHo" style="display: none" class="validationMessage">Thông tin bắt buộc nhập</span>
                    </div>
                    <div class="col-md-2 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                        <label>
                            <spring:message code="most.05.hoso.phongXakin.ungDungKhac" />
                            <a class="nsw-require-field" id="lbl-pho-valid">*</a>
                        </label>
                    </div>
                    <div class="col-md-4 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                        <input class="form-control" id="fiMucDichSuDungKhac" name="fiMucDichSuDungKhac"  type="text" data-bind="value: fiMucDichSuDungKhac,event: {change: changeUngDungKhacHo}" maxlength="500"/>
                        <span class="validationMessage" id="fiMucDichSuDungKhacHo-lbl" style="display: none">Thông tin bắt buộc nhập</span>
                    </div><br/>
                    <span style="color: red;float: left;margin-left: 15px">Lưu ý: Trường Mục đích sử dụng cho phép chọn nhiều. Trường Ứng dụng khác chỉ hiển thị khi chọn loại Mục đích sử dụng: Các ứng dựng khác (ghi rõ)</span>
                    
                </div>
            </div>
                    
        </form>
    </div>
</template>