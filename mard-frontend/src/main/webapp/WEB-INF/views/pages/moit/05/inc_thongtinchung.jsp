<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="moit.05.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.danhsach.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMst" name="fiMst" readonly="readonly" data-bind="value : fiMst" maxlength="13" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiDiachiTsc" name="fiDiachiTsc" readonly="readonly" type="text" data-bind="value: fiDiachiTsc" maxlength="250"/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.dienthoai" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdt" name="fiSdt" readonly data-bind="value : fiSdt" type="text" maxlength="50"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.fax" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFax" name="fiFax" data-bind="value : fiFax" type="text" maxlength="50"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.Email" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiEmail" name="fiEmail" type="email" data-bind="value: fiEmail" maxlength="250"/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.soGCNdangKy" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGcnDk" name="fiSoGcnDk" data-bind="value : fiSoGcnDk" type="text" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.ngaycap" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaycapDk" name="fiNgaycapDk" data-bind="datepicker : fiNgaycapDk,event:{change:validDateCreate}" type="text" data-date-format="dd/mm/yyyy" readonly style="background-color: #fff !important"/>
                <span class="validationMessage" style="display: none;" id="fiNgaycapDk-lbl">Thông tin bắt buộc nhập</span>
                
            </div>
        </div>  
    </div>  
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.noicap" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoicapDk" name="fiNoicapDk" type="text" data-bind="value: fiNoicapDk" maxlength="250"/>
            </div>               
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.nguoiDaidien" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiDaidien" name="fiNguoiDaidien" type="text" data-bind="value: fiNguoiDaidien" maxlength="250"/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.nguoiLapbieu" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiLapbieu" name="fiNguoiLapbieu" type="text" data-bind="value: fiNguoiLapbieu" maxlength="250"/>
            </div>                

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.05.hoso.namDangkyNK" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <input style="text-align: right;" class="form-control" id="fiNamdkNk" name="fiNamdkNk" type="number" data-bind="value: fiNamdkNk , event: {change: setFiNamX}" min="1" max="9999" oninput="validity.valid||(value='');"/>
            </div>                
        </div>  
    </div>
</fieldset>
