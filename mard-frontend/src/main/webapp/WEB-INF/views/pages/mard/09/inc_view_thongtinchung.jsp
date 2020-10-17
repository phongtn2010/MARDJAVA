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
                <input class="form-control" type="text" id="fiNameOfRegistration" name="fiNameOfRegistration" readonly="readonly" data-bind="value : fiNameOfRegistration" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.diachitruso" /> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiAddressOfRegistration" name="fiAddressOfRegistration" readonly="readonly" type="text" data-bind="value: fiAddressOfRegistration"/>
            </div>                
        </div>  
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.dienthoai" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiPhone" name="fiPhone" data-bind="value : fiPhone" type="tel" maxlength="50" readonly="readonly"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="mard.hoso.fax" />
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFax" name="fiFax" data-bind="value : fiFax" type="tel" maxlength="50" readonly="readonly"/>
            </div>
        </div> 
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.email" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiEmail" name="fiEmail" readonly="readonly" data-bind="value : fiEmail" type="text" maxlength="255"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.masothue" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiCreatorRegistrationNo" name="fiCreatorRegistrationNo" readonly="readonly" data-bind="value : fiCreatorRegistrationNo" maxlength="13" />
                <input type="hidden" id="fiLoaiDon" name="fiLoaiDon" data-bind="value : fiLoaiDon"/>
            </div>
        </div>  
    </div> 
</fieldset>
