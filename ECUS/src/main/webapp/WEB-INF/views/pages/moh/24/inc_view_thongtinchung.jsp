<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.hoso.loaidonhang" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" disabled id="fiMaLoaidon" name="fiMaLoaidon" 
                        data-bind="optionsCaption: 'Chọn...', 
                            optionsValue : 'id', 
                            value : fiMaLoaidon, 
                            options : lstLoaiDonHang, optionsText : 'name'"></select>
            </div>            
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.hoso.cukhaududinhnhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiMaCuaKhau" disabled id="fiMaCuaKhau" name="fiMaCuaKhau" multiple="multiple" 
                        data-bind="selectedOptions: lstCuaKhaus, 
                                chosen: {},
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstCuaKhauNhap, 
                                optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.hoso.cukhaududinhnhapkhau_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" readonly="readonly" id="fiTenCkhauEn" name="fiTenCkhauEn" data-bind="value : fiTenCkhauEn" type="text" maxlength="255"/>
                
            </div>
            
        </div>  
    </div>
