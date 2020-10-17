<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn  " maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiDn" name="fiDiachiDn" readonly="readonly" type="text" data-bind="value: fiDiachiDn" maxlength="250"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.tinhthanh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaTinh" disabled name="fiMaTinh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenTinh, value : fiMaTinh, options : lstTinhThanh, optionsText : 'name'"></select>
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.nguoidaidien" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiDd" name="fiNguoiDd" readonly data-bind="value : fiNguoiDd" type="text" maxlength="100"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="moh.hoso.chucvu" /><a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiChucvuNgDd" readonly name="fiChucvuNgDd" data-bind="value : fiChucvuNgDd" type="text" maxlength="100"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.mucdichnhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMucDichNk" disabled name="fiMucDichNk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiMucDichNk, options : lstMucDichNhapKhau, optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right" data-bind="visible: isThirdGroup">
                <label><spring:message code="moh.19.hoso.cukhaududinhnhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4" data-bind="visible: isThirdGroup">
                <select class="form-control select2 fiMaCuaKhau" id="fiMaCuaKhau" disabled name="fiMaCuaKhau"  
                        data-bind="value: fiMaCuaKhau, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstCuaKhauNhap, 
                                optionsText : 'name'"></select>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.hoso.tenthunghiemlamsang" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenDeTai" name="fiTenDeTai" readonly="readonly" data-bind="value : fiTenDeTai" type="text" maxlength="100"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="moh.19.hoso.soquyetdinh" />
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiSoQd" readonly="readonly" name="fiSoQd" data-bind="value : fiSoQd" type="text" maxlength="100"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.hoso.ngayky" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" readonly="readonly" id="fiNgayKyQd" name="fiNgayKyQd" type="text" data-bind="datepicker : fiNgayKyQd"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.hoso.tenquyetdinh" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenQd" name="fiTenQd" readonly="readonly" type="text" data-bind="value: fiTenQd" maxlength="250"/>
            </div>
        </div>  
    </div>    
</fieldset>
