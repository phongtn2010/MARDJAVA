<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="moit.04.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.danhsach.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" disabled id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.tendoanhnghiep" /></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.masothue" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMst" name="fiMst" readonly="readonly" data-bind="value : fiMst" maxlength="13" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.diachitruso" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiDiachiTsc" name="fiDiachiTsc" readonly="readonly" type="text" data-bind="value: fiDiachiTsc" maxlength="250"/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.dienthoai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdt" name="fiSdt" readonly data-bind="value : fiSdt" type="text" maxlength="50"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="moit.04.hoso.fax" />
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFax" name="fiFax" data-bind="value : fiFax" type="text" maxlength="50" readonly/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.Email" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiEmail" name="fiEmail" type="email" data-bind="value: fiEmail" maxlength="250" readonly/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.sovanban" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGcnDk" name="fiSoGcnDk" data-bind="value : fiSoGcnDk" type="text" maxlength="250" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.ngaycap" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" name="fiNgaycapDk" data-bind="datepicker : fiNgaycapDk" type="text" data-date-format="dd/mm/yyyy" readonly disabled/>

            </div>
        </div>  
    </div>  
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.noicap" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiNoicapDk" name="fiNoicapDk" type="text" data-bind="value: fiNoicapDk" maxlength="250" readonly/>
            </div>                
        </div>  
    </div>
</fieldset>
