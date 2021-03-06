<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mard.hoso.thongtinchung" /></b></legend>
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
                <label><spring:message code="mard.hoso.trangthai" /></label>
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
                <label><spring:message code="mard.hoso.tendoanhnghiep" /></label>
            </div>  
            <div class="col-md-10">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn  " />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.diachitruso" /> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiDiachiDn" name="fiDiachiDn" readonly="readonly" type="text" data-bind="value: fiDiachiDn"/>
            </div>                
        </div>  
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.dienthoai" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtDn" name="fiSdtDn" data-bind="value : fiSdtDn" type="number" maxlength="12" readonly="readonly"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="mard.hoso.fax" />
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFaxDn" name="fiFaxDn" data-bind="value : fiFaxDn" type="number" maxlength="12" readonly="readonly"/>
            </div>
        </div> 
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.email" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiEmailDn" name="fiEmailDn" readonly="readonly" data-bind="value : fiEmailDn" type="text" maxlength="50"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.masothue" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
                <input type="hidden" id="fiLoaiDon" name="fiLoaiDon" data-bind="value : fiLoaiDon"/>
            </div>
        </div>  
    </div> 
</fieldset>
