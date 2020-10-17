<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mt.41.hoso.thongtinchung" /></b></legend>
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
                <label><spring:message code="mt.41.hoso.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaCqxl" name="fiMaCqxl" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCqxl, value : fiMaCqxl, options : lstDonViXuLy, optionsText : 'name'"></select>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn  " maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiDiachiDn" name="fiDiachiDn" readonly="readonly" type="text" data-bind="value: fiDiachiDn" maxlength="250"/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.dienthoai" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly id="fiSdtDn" name="fiSdtDn" data-bind="value : fiSdtDn" type="text" maxlength="50"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.sogiayphepkinhdoanhvantai" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGpvt" name="fiSoGpvt" data-bind="value : fiSoGpvt" type="text" maxlength="250"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.ngaycap" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgcapGpvt" name="fiNgcapGpvt"  data-bind="datepicker : fiNgcapGpvt" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>  
    </div>  

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.coquancap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCqCapGpvt" name="fiCqCapGpvt" data-bind="value : fiCqCapGpvt" type="text" maxlength="250"/>
            </div>

        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.giaychungnhandangkykd" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGpDkkd" name="fiSoGpDkkd" data-bind="value : fiSoGpDkkd" type="text" maxlength="250"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.ngaycap" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgcapDkkd" name="fiNgcapDkkd"  data-bind="datepicker : fiNgcapDkkd" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>  
    </div>  

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.coquancap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCqCapDkkd" name="fiCqCapDkkd" data-bind="value : fiCqCapDkkd" type="text" maxlength="250"/>
            </div>

        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.nguoilienhe" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenNgLh" name="fiTenNgLh" data-bind="value : fiTenNgLh" type="text" maxlength="250"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.41.hoso.sodienthoainguoilienhe" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiSdtNgLh" name="fiSdtNgLh" data-bind="value : fiSdtNgLh" type="text" maxlength="250"/>
            </div>
        </div>  
    </div> 
</fieldset>
