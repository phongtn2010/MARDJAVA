<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>  
    <legend><b><spring:message code="most.05.hoso.phongXakin" /></b></legend>
            <%@include file="inc_css.jsp" %>
    <form role="form" class="form-horizontal" name="searchForm">
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10"> 
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="most.05.hoso..phongXakin.stt" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.tenDVPhongXa" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.hoatDo" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.dơnViTinh" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.ngayXacDinh" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.chucNang" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: $data.formVM().lstTbdhsNkpxTtpnpxk05">
                <tr>
                    <td data-bind="text : $index() + 1">
                    </td>  
                    <td data-bind="text : fiTenDongViPhongXa">
                    </td>
                    <td style="width: 220px" data-bind="text : fiHangSanXuat">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiHoatDo">
                    </td>
                    <td style="width: 220px" data-bind="text : fiTenHoatDoDonVi">
                    </td>
                    <td style="width: 220px;text-align: center" data-bind="date : fiNgayXacDinhHoatDo">
                    </td>
                    <td style="width: 220px" class="text-center">                            
                        <a data-bind="click: $parent.formVM().btnUpdatePXK.bind($parent)"><i style="font-size: 30px" class="fa fa-eye"></i></a>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</fieldset>
<template id="phongXaKin-template">
    <div class="row" id="IdPhongXaKinVM" style="max-height: 70vh !important; overflow: auto;">
        <form role="form" class="" id="addPhongXaKin-form">
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.tenDVPhongXa" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10">
                        <select disabled class="form-control select2" id="fiTenDongViPhongXa" name="fiTenDongViPhongXa"  
                                data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiMaDongViPhongXa , selectedText2 : fiTenDongViPhongXa,
                                options : lstDongViPX, optionsText : 'name'"></select>
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.maHieu" /></label>
                    </div>
                    <div class="col-md-4">
                        <input disabled class="form-control" id="fiMaHieu" name="fiMaHieu" data-bind="value: fiMaHieu"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.soSeri" /></label>
                    </div>
                    <div class="col-md-4">
                        <input disabled class="form-control" id="fiSoSeri" name="fiSoSeri" data-bind="value: fiSoSeri"/>
                    </div>
                </div>
            </div>    
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input disabled class="form-control" id="fiHangSanXuat" name="fiHangSanXuat" data-bind="value: fiHangSanXuat "/>
                    </div>
                </div>
            </div>    
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.hoatDo" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-2">
                        <input disabled class="form-control" id="fiHoatDo" name="fiHoatDo" data-bind="value: fiHoatDo "/> 
                    </div>
                    <div class="col-md-2">
                        <select disabled class="form-control select2" id="fiHoatDoDonVi" name="fiHoatDoDonVi" 
                                data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                                , value : fiHoatDoDonVi , options : lstHoatDoDonVi, optionsText : 'name'"></select>
                    </div>

                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.ngayXDhoatDo" /></label>
                    </div>
                    <div class="col-md-4">
                        <input disabled name="fiNgayXacDinhHoatDo" id="NgayXacDinhHoatDo" data-bind="datepicker : fiNgayXacDinhHoatDo" 
                               class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" placeholder="dd/mm/yyyy" />
                    </div>
                </div>
            </div> 
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.mucDichSuDung" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" disabled id="fiMaMucDichSuDung" name="fiMaMucDichSuDung" multiple
                                data-bind=" optionsValue : 'id'
                                , selectedOptions : lstMucdichsudung
                                , options : lstNguonPXK, optionsText : 'name'"></select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.ungDungKhac" /></label>
                    </div>
                    <div class="col-md-4 nsw-text-right">
                        <input disabled class="form-control" id="fiMucDichSuDungKhac" name="fiMucDichSuDungKhac" 
                               data-bind="value : fiMucDichSuDungKhac" type="text" />
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-6 nsw-text-right">
                    <label><spring:message code="most.05.hoso.phongXakin.nguonCamKet" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-2">
                </div>
                <div class="col-md-4">
                    <label class="col-md-4"> <input disabled class="fiCamKetTraNguon" name="fiCamKetTraNguon"  id="rdKhong" type="radio">không</label> 
                    <label class="col-md-4"> <input disabled class="fiCamKetTraNguon" name="fiCamKetTraNguon" id="rdCo" type="radio">có</label>
                </div>
            </div>
            <label><b><spring:message code="most.05.hoso.phongXakin.label"/></b></label>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.maHieu" /></label>
                    </div>
                    <div class="col-md-4">
                        <input disabled class="form-control" id="fiTbMaHieu" name="fiTbMaHieu" data-bind="value : fiTbMaHieu" type="text" />
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.soSeri" /></label>
                    </div>
                    <div class="col-md-4 nsw-text-right">
                        <input disabled class="form-control" id="fiTbSoSeri" name="fiTbSoSeri" data-bind="value : fiTbSoSeri" type="text" />
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /></label>
                    </div>
                    <div class="col-md-4">
                        <input disabled class="form-control" id="fiTbHangNuocSanXuat" name="fiTbHangNuocSanXuat" data-bind="value : fiTbHangNuocSanXuat" type="text" />
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.namSanXuat" /></label>
                    </div>
                    <div class="col-md-4 nsw-text-right">
                        <input disabled class="form-control" id="fiTbNamSanXuat" name="fiTbNamSanXuat" data-bind="value: fiTbNamSanXuat" type="number"/>
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-3 nsw-text-right">
                    <label><spring:message code="most.06.hoso.phieuphaibaopsk.thietbididonghoaccodanh" /></label>
                </div>
                <div class="col-md-4">
                    <label class="col-md-4"><input disabled class="fiTbDiDongCoDinh" name="fiTbDiDongCoDinh" id="rdDiDong" type="radio" >Di động</label> 
                    <label class="col-md-4"><input disabled class="fiTbDiDongCoDinh" name="fiTbDiDongCoDinh" id="rdCoDinh" type="radio">Cố định</label>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-3 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.noiDat" /></label>
                    </div>
                    <div class="col-md-9">
                        <input disabled class="form-control" id="fiTbNoiDat" name="fiTbNoiDat"
                               data-bind="value : fiTbNoiDat" type="text" />
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-3 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.khoiLuong" /></label>
                    </div>
                    <div class="col-md-9">
                        <input disabled class="form-control" id="fiTbKhoiLuongUrani" name="fiTbKhoiLuongUrani" data-bind="value : fiTbKhoiLuongUrani" type="text" />
                    </div>
                </div>
            </div>
    </div>
</template>