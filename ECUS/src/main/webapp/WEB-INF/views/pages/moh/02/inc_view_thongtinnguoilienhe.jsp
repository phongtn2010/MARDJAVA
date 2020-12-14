<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset style="margin-top: 15px" id="ngLH02">
    <div data-bind="with : tbdNguoilienhe02">
        <legend>
            <b style="color: dodgerblue;"><spring:message code="moh.02.hoso.thongtinlienhe"/></b>
        </legend>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="moh.02.hoso.thongtinlienhe.tennguoilienhe"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenNgLienhe" name="fiTenNgLienhe" maxlength="100"
                           type="text" data-bind="value : fiTenNgLienhe" disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="moh.02.hoso.thongtinlienhe.sdt"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoDt" name="fiSoDt" maxlength="50"
                           type="text" data-bind="value : fiSoDt" disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="moh.02.hoso.thongtinlienhe.email"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmail" name="fiEmail" maxlength="100"
                           type="text" data-bind="value : fiEmail" disabled/>
                </div>
            </div>
        </div>
    </div>
</fieldset>
