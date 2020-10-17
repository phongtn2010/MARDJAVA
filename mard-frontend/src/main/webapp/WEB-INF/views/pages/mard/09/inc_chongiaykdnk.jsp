<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mard.hoso.choncongvankiemdichnhapkhau" /></b></legend>
    <div class="form-group">
        <!-- ko with: chooseLicenseVM() -->
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.socongvankiemdichnhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">

                <select
                        id="fiMaKdnk"
                        class="form-control select2"
                        data-bind="optionsCaption: optionsCaption,
                            optionsValue : 'fiQuarantineNo',
                            selectedText : fiMaKdnk,
                            disable: isDisable,
                            value : fiMaKdnk,
                            options : lstKdnk,
                            optionsText : 'fiQuarantineNo',
                            event: {change: onPickKdnk}"></select>

            </div>
        </div>
        <div class="col-md-12" data-bind="visible: fiIsPicked">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.ngaycapcv" /> </label>
            </div>
            <div class="col-md-10">
                <input disabled class="form-control" maxlength="255" type="text" data-bind="datepicker: fiNgayCap" data-date-format="dd/mm/yyyy"/>
            </div>
        </div>
        <!-- /ko -->
    </div>
</fieldset>
<script src="<c:url value='/app/mard/09/ChooseLicenseTT8VM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>