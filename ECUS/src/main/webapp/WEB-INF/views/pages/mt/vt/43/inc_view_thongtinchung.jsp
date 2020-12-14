<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mt.43.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.danhsach.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao" data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaCqxl" name="fiMaCqxl" disabled data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCqxl, value : fiMaCqxl, options : lstDonViXuLy, optionsText : 'name'"></select>
                <input type="hidden" id="fiTenCqxl" name="fiTenCqxl" data-bind="value : fiTenCqxl"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn  " maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiDiachiDn" name="fiDiachiDn" readonly="readonly" type="text" data-bind="value: fiDiachiDn" maxlength="250"/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.dienthoai" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtDn" name="fiSdtDn" readonly="readonly" data-bind="value : fiSdtDn" type="text" maxlength="50"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.email" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" readonly id="fiEmailDn" name="fiEmailDn" data-bind="value : fiEmailDn" type="text" maxlength="50"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="mt.hoso.fax" /><a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" readonly id="fiFaxDn" name="fiFaxDn" data-bind="value : fiFaxDn" type="text" maxlength="50"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.sogiayphepvietnamcap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGpvtVn" readonly name="fiSoGpvtVn" data-bind="value : fiSoGpvtVn" type="text" maxlength="250"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.ngaycapvietnamcap" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly id="fiNgayGpvtVn" name="fiNgayGpvtVn"  data-bind="datepicker : fiNgayGpvtVn" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>  
    </div>  

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.coquancapvietnamcap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCqcapGpVn" readonly name="fiCqcapGpVn" data-bind="value : fiCqcapGpVn" type="text" maxlength="250"/>
            </div>

        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.sogiaypheptrungquoccap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGpvtTq" readonly name="fiSoGpvtTq" data-bind="value : fiSoGpvtTq" type="text" maxlength="250"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.ngaycaptrungquoccap" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgayGpvtTq" readonly name="fiNgayGpvtTq"  data-bind="datepicker : fiNgayGpvtTq" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>  
    </div>  

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.coquancaptrungquoccap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCqcapGpTq" name="fiCqcapGpTq" data-bind="value : fiCqcapGpTq" type="text" maxlength="250"/>
            </div>

        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.nguoilienhe" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenNgLh" name="fiTenNgLh" readonly="readonly" data-bind="value : fiTenNgLh" type="text" maxlength="250"/>

            </div>

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.43.hoso.sodienthoainguoilienhe" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiSdtNgLh" readonly="readonly" name="fiSdtNgLh" data-bind="value : fiSdtNgLh" type="text" maxlength="250"/>
            </div>
        </div>  
    </div>    
</fieldset>
