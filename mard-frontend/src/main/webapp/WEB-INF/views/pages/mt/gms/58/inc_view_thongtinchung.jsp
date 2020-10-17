<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mt.58.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.danhsach.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" disabled id="fiMaCqxl" name="fiMaCqxl" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCqxl, value : fiMaCqxl, options : lstDonViXuLy, optionsText : 'name'"></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn  " maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiDn" name="fiDiachiDn" readonly="readonly" type="text" data-bind="value: fiDiachiDn" maxlength="250"/>
            </div>  
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.dienthoai" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtDn" name="fiSdtDn" data-bind="value : fiSdtDn" type="text" maxlength="50" readonly/>
            </div>
        </div>  
    </div>   
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.fax" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly id="fiFaxDn" name="fiFaxDn"type="text" data-bind="value: fiFaxDn" maxlength="250"/>
            </div>  
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.email" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control"readonly id="fiEmailDn" name="fiEmailDn" data-bind="value : fiEmailDn" type="text" maxlength="50" />
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.website" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly id="fiWebDn" name="fiWebDn"  type="text" data-bind="value: fiWebDn" maxlength="250"/>
            </div>  
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.ngaycap" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly id="fiNgaycapGp" name="fiNgaycapGp" data-bind="datepicker : fiNgaycapGp" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.sogpkinhdoanh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly id="fiSoGpVtdb" name="fiSoGpVtdb"  type="text" data-bind="value: fiSoGpVtdb" maxlength="250"/>
            </div>  
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.coquancap" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly id="fiCqCap" name="fiCqCap" data-bind="value : fiCqCap" type="text" maxlength="50" />
            </div>
        </div>  
    </div>
</fieldset>
