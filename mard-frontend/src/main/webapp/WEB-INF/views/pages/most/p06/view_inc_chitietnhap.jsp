<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="most.06.hoso.chitietnhapkhau" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.ngaydukienxuat" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNkcpxNgayDuKien" name="fiNkcpxNgayDuKien" data-bind="datepicker : fiNkcpxNgayDuKien" type="text" data-date-format="dd/mm/yyyy" disabled="disabled"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.thanhpho" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNkcpxTenTinh" name="fiNkcpxTenTinh"  
                       type="text" data-bind="value : fiNkcpxTenTinh" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.caukhaunhap" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNkcpxTenCuaKhau" name="fiNkcpxTenCuaKhau"  
                       type="text" data-bind="value : fiNkcpxTenCuaKhau" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.ngaydukienden" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaycapDk" name="fiNgayTiepnhan" data-bind="datepicker : fiNgayTiepnhan" type="text" data-date-format="dd/mm/yyyy" disabled="disabled">
            </div>
        </div>  
    </div> 
</fieldset>
