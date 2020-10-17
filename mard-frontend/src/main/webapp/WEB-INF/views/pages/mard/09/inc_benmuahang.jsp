<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mard.hoso.benmuahang" /></b></legend>
    <div class="form-group">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.tenbenmuahang" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" maxlength="255" type="text" data-bind="value: fiBuyerName, enable: $root.isEnableEdit"/>
                </div>

            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.socmt" /> </label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" maxlength="255" type="number" data-bind="value: fiBuyerIdentityNo, enable: $root.isEnableEdit"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.noicap" /> </label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" maxlength="255" type="text" data-bind="value: fiBuyerPlaceOfIdentity, enable: $root.isEnableEdit"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.ngaycap" /> </label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" maxlength="255" data-date-format="dd/mm/yyyy"  type="text" data-bind="datepicker: fiBuyerDateOfIdentity, enable: $root.isEnableEdit"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.dienthoai" /><a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" maxlength="50" type="text" data-bind="value: fiBuyerTel, enable: $root.isEnableEdit"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.fax" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" maxlength="50" type="text" data-bind="value: fiBuyerFax, enable: $root.isEnableEdit"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.diachi" /><a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" maxlength="255" type="text" data-bind="value: fiBuyerAddress, enable: $root.isEnableEdit"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.noinhanhang" /><a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" maxlength="255" type="text" data-bind="value: fiPortOfDestinationName, enable: $root.isEnableEdit"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.nhapkhaudukientungay" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" maxlength="255" data-date-format="dd/mm/yyyy"  type="text" data-bind="datepicker: fiImportingDateFrom, enable: $root.isEnableEdit"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.nhapkhaudukiendenngay" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" maxlength="255" data-date-format="dd/mm/yyyy" type="text" data-bind="datepicker: fiImportingDateTo, enable: $root.isEnableEdit"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.sovandontau" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" maxlength="50" type="text" data-bind="value: fiLadingBill, enable: $root.isEnableEdit"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.ngaythangnamcapvandontau" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" maxlength="255" data-date-format="dd/mm/yyyy" type="text" data-bind="datepicker: fiLadingBillDate, enable: $root.isEnableEdit"/>
                </div>
            </div>
        </div>
    </div>
</fieldset>
