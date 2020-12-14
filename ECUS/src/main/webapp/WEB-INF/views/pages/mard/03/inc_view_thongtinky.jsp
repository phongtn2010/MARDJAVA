<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend style="color: dodgerblue;"><b><spring:message code="mard.03.hoso.thongtinkydon"/></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-12 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinkydon.camket"/></label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinkydon.noiky"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoiKy" name="fiNoiKy" type="text" data-bind="value : fiNoiKy"
                       disabled/>
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinkydon.ngayky"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgayKy" name="fiNgayKy"
                       data-bind="datepicker : fiNgayKy" type="text" data-date-format="dd/mm/yyyy" readonly disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinkydon.nguoiky"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiKy" name="fiNguoiKy" type="text" data-bind="value : fiNguoiKy"
                       disabled/>
            </div>
        </div>
    </div>
</fieldset>

