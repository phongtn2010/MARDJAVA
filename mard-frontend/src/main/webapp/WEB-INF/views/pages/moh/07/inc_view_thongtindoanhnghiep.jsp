<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.07.thongtindon.sovanban" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" readonly="true" id="fiSoVbDn" name="fiSoVbDn" data-bind="value : fiSoVbDn" maxlength="255" />
        </div> 
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.07.thongtindon.donvinhan" /> </label>
        </div>
        <div class="col-md-4">
            <select class="form-control select2 fiMaDvNhan" disabled id="fiMaDvNhan" name="fiMaDvNhan"  
                        data-bind="value: fiMaDvNhan, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstDonViNhan, 
                                optionsText : 'name',
                                event: {change: onFiMaDvNhanChange}"></select>
            <input type="hidden" id="fiTenDvNhan" name="fiTenDvNhan" data-bind="value : fiTenDvNhan"/>
        </div> 
    </div>  
</div>
            
<fieldset>
    <legend><b><spring:message code="moh.07.doanhnghiep" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.tencoso" /></label>
            </div>  
            <div class="col-md-10">
                <label><b data-bind="text: fiTenDn"></b></label>
            </div>            
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.masothue" /></label>
            </div>
            <div class="col-md-4">                
                <label><b data-bind="text: fiMstDn"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.email" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly="true" type="text" id="fiEmailDn" name="fiEmailDn" data-bind="value : fiEmailDn" maxlength="255" />
            </div> 
        </div>  
    </div>            
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.diachi" /></label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiDiachiDn"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.web" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly="true" type="text" id="fiWebDn" name="fiWebDn" data-bind="value : fiWebDn" maxlength="255" />
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.tinhthanh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiMaTinh" disabled id="fiMaTinh" name="fiMaTinh"  
                        data-bind="value: fiMaTinh, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstTinhThanh, 
                                optionsText : 'name',
                                event: {change: onFiMaTinhChange}"></select>
                <input type="hidden" id="fiTenTinh" name="fiTenTinh" data-bind="value : fiTenTinh"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.quanhuyen" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiMaQuan" disabled id="fiMaQuan" name="fiMaQuan"  
                        data-bind="value: fiMaQuan, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstQuanHuyen, 
                                optionsText : 'name',
                                event: {change: onFiMaQuanChange}"></select>
                <input type="hidden" id="fiTenQuan" name="fiTenQuan" data-bind="value : fiTenQuan"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.sodienthoai" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly="true" id="fiSdtDn" name="fiSdtDn" data-bind="value : fiSdtDn" maxlength="255" />
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.07.doanhnghiep.fax" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly="true" id="fiFaxDn" name="fiFaxDn" data-bind="value : fiFaxDn" maxlength="255" />
            </div> 
        </div>  
    </div>  
</fieldset>
