<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.hoso.39.thongtinthuoc" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Tên nguyên liệu <a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <select class="form-control select2 fiMaHang" disabled id="fiMaHang" data-bind="value: fiMaHang,                                
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : lstNguyenLieu"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.sodangkyluuhanh" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiSoDk" readonly="readonly" name="fiSoDk" data-bind="value : fiSoDk" maxlength="255" />
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.tenthuongmai" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" readonly="readonly" name="fiTenKhac" data-bind="value : fiTenKhac" maxlength="255" />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.sodangkyluuhanh" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoDk" readonly="readonly" type="text" data-bind="value: fiSoDk" maxlength="250"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.tieuchuanchatluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiTccl" readonly="readonly" type="text" data-bind="value: fiTccl" maxlength="250"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.soluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoLuong" readonly="readonly" data-bind="value : fiSoLuong" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.donvitinh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaDvtinh" disabled name="fiMaDvtinh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenDvtinh, value : fiMaDvtinh, options : lstDonViTinh, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>    
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.cososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiTenCoSoSx" readonly="readonly" data-bind="value : fiTenCoSoSx" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.nuocsanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgSx" name="fiMaQgSx" disabled data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgSx, value : fiMaQgSx, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.ghichu" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <textarea class="form-control" data-bind="value : fiGhiChu" readonly="readonly" name="fiGhiChu" maxlength="2000"></textarea>
            </div>
        </div> 
    </div>
</fieldset>
