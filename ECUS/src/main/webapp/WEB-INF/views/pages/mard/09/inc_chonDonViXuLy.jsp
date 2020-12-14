<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mard.hoso.chondonvixuly" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.donvikiemdich" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <select
                        id="fiMaDvkd"
                        class="form-control select2"
                        data-bind="optionsCaption: 'Chọn...',
                            optionsValue : 'id',
                            value : fiQuarantineDepartmentNameCode,
                            options : lstTramThuY,
                            optionsText : 'name',
                            event: {change: onDvkd}, enable: $root.isEnableEdit"></select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.donvigiamsat" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <select
                        id="fiMaDvgs"
                        class="form-control select2"
                        data-bind="optionsCaption: 'Chọn...',
                            optionsValue : 'id',
                            value : fiMonitoringDepartmentNameCode,
                            options : lstTramThuY,
                            optionsText : 'name',
                            event: {change: onDvgs}, enable: $root.isEnableEdit"></select>
            </div>
        </div>
    </div>
</fieldset>
