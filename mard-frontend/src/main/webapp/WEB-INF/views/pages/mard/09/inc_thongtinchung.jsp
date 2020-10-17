<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mard.hoso.thongtinhoso" /></b></legend>
    <div class="form-group">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.trangthai" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTt" name="fiTenTt" maxlength="255"
                           type="text" data-bind="value : fiTenTt" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTaxCode" name="fiTaxCode" readonly="readonly" data-bind="value : fiTaxCode" maxlength="13" />
                    <input type="hidden" id="fiLoaiDon" name="fiLoaiDon" data-bind="value: fiLoaiDon"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.ngaytao" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiHSCreatedDate" name="fiHSCreatedDate" maxlength="255" data-date-format="dd/mm/yyyy"
                           type="text" data-bind="datepicker : fiHSCreatedDate" readonly="readonly"/>
                </div>
            </div>
        </div>
    </div>
    <legend><b><spring:message code="mard.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.sodondangky" /></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiRegistrationNo" name="fiHSCode" maxlength="255"
                       type="text" data-bind="value : fiHSCode"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiNameOfRegistration" name="fiNameOfRegistration" readonly="readonly" data-bind="value: fiNameOfRegistration" />
            </div>

        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.diachitochuccanhan" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input
                        class="form-control"
                        id="fiAddressOfRegistration"
                        name="fiAddressOfRegistration"
                        readonly="readonly"
                        type="text"
                        data-bind="value: fiAddressOfRegistration, enable: $root.isEnableEdit"/>
            </div>
        </div>  
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.dienthoai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiPhone" name="fiPhone" data-bind="value : fiPhone, enable: $root.isEnableEdit" type="text" maxlength="50"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <spring:message code="mard.hoso.fax" />
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFax" name="fiFax" data-bind="value : fiFax, enable: $root.isEnableEdit" type="text" maxlength="50"/>
            </div>
        </div> 
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.email" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiEmail" name="fiEmail" data-bind="value : fiEmail, enable: $root.isEnableEdit" type="text" maxlength="50"/>
            </div>
        </div>
    </div>
</fieldset>
