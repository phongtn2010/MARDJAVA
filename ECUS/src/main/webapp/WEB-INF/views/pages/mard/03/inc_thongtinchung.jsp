<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend style="color: dodgerblue;"><b><spring:message code="mard.03.hoso.thongtindoahnghiep" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtindoahnghiep.tendoanhnghiep" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenDn" name="fiTenDn" type="text" data-bind="value : fiTenDn" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtindoahnghiep.mast" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMstDn" name="fiMstDn" data-bind="value : fiMstDn" type="text" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtindoahnghiep.diachi" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiaChiDn" name="fiDiaChiDn" type="text" data-bind="value : fiDiaChiDn" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtindoahnghiep.sodienthoai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtDn" name="fiSdtDn" type="text" data-bind="value : fiSdtDn" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtindoahnghiep.fax" /></label>
            </div>

            <div class="col-md-4">
                <input class="form-control" id="fiFaxDn" name="fiFaxDn" type="text" data-bind="value : fiFaxDn" />
            </div>

            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtindoahnghiep.email" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiEmailDn" name="fiEmailDn" type="text" data-bind="value : fiEmailDn" />
            </div>
        </div>
    </div> 
</fieldset>

