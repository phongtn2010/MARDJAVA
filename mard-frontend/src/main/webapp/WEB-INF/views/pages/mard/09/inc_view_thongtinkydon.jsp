<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="form-horizontal" >
    <fieldset>
        <legend><b><spring:message code="mard.hoso.thongtinkyhoso" /></b></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.thongtinkyhoso.nguoiky" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNguoiKy" name="fiNguoiKy" readonly data-bind="value : fiNguoiKy" maxlength="100"></input>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.thongtinkyhoso.ngayky" /> </label>
                </div>

                <div class="col-md-4">
                    <input name="fiNgayKy" id="fiNgayKy" data-bind="datepicker : fiNgayKy" readonly class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.hoso.thongtinkyhoso.diadiem" /> </label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiDiadiemKy" name="fiDiadiemKy" readonly data-bind="value : fiDiadiemKy" maxlength="250"></input>
                </div>
            </div>
        </div>
    </fieldset>
</div>