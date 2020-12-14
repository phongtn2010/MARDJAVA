<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b> <spring:message code="most.06.hoso.phieuphaibaopxh" /> </b> <a class="btn green bt-center" data-bind="click: addpxhClick"> <i class="fa fa-add fa-lg"></i> Thêm</a></legend> 

    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.stt" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.tendongvi" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.nuocsanxuat" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.hoatdo" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.donvitinh" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstTbdhsPhieuKbNguonPxh06">
                    <tr>
                        <td data-bind="text: $index() + 1"></td>  
                        <td data-bind="text : fiTenDongViPhongXa"></td>
                        <td style="width: 220px" data-bind="text : fiHangNuocSanXuat"></td>
                        <td style="width: 220px;text-align:right" data-bind="text : fiHoatDo"></td>
                        <td style="width: 220px" data-bind="text : fiTenHoatDoDonVi"></td>
                        <td style="width: 220px" class="text-center">                            
                            <a class="btn green bt-center" data-bind="click: $parent.editpxhClick.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                            <a class="btn red bt-center" data-bind="click: $parent.removepxh.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorlistpxhoMessage" style="color:red;"> </span>
            <br />

        </div>
    </div>
</fieldset>
<template id="khaibaopxh-template">
    <div class="row" id="khaibaopxh-vm">
        <div class="col-md-12">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.tendongvi" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <select class="form-control select2" id="fiMaDongViPhongXa" name="fiMaDongViPhongXa" 
                                    data-bind="optionsCaption: 'Chọn...', optionsValue : 'id',selectedText2 : fiTenDongViPhongXa, value : fiMaDongViPhongXa
                                    , options : lstDongViPX, optionsText : 'name'"></select>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.nuocsanxuat" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">                                        
                            <input class="form-control" id="fiHangSanXuat" name="fiHangSanXuat" maxlength="255"   
                                   type="text" data-bind="value : fiHangNuocSanXuat" />
                        </div>                                          

                    </div>  
                </div>

                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.hoatdodv" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-2">                                        
                            <input class="form-control" id="fiHoatDo" name="fiHoatDo" maxlength="255"  
                                   type="number" data-bind="value : fiHoatDo" />
                        </div>                                          
                        <div class="col-md-2" style="padding-left: 0px;">                                        
                            <select class="form-control select2" id="fiHoatDoDonVi" name="fiHoatDoDonVi" 
                                    data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiHoatDoDonVi
                                    , options : lstDongVi, optionsText : 'name'"></select>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mahieu" /></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiMaHieu" name="fiMaHieu" type="text" data-bind="value: fiMaHieu"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group" style="margin-top: 15px;">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.05.hoso.chiTietNKPhongXa.congThucHoaHoc" /></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiCongThucHoaHoc" name="fiCongThucHoaHoc" data-bind="value: fiCongThucHoaHoc"/> 
                        </div>

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.05.hoso.chiTietNKPhongXa.trangThaiVatLy" /></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiTrangThaiVatLy" name="fiTrangThaiVatLy" type="text" data-bind="value: fiTrangThaiVatLy"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mucdich" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <select class="form-control select2" id="fiMaMucDichSuDung" name="fiMaMucDichSuDung" multiple
                                    data-bind=" optionsValue : 'id', selectedOptions : lstMucdichsudungho
                                    , options : lstMucDichHo, optionsText : 'name'
                                    ,event: {change: mucdichhoAction}"></select>
                            <!--<span data-bind="text : errormucdicpxhMessage" style="color:red ; font-size: 12px;"> </span>-->
                        </div>
                        <div class="col-md-2 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.ungdungkhac" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4 fiMucDichSuDungKhac" style="display: none">                                        
                            <input class="form-control" id="fiSoSeri" name="fiSoSeri" maxlength="255"  
                                   type="text" data-bind="value : fiMucDichSuDungKhac" />              
                        </div>
                    </div>  
                </div>
            </form>
        </div>
    </div> 
</template> 