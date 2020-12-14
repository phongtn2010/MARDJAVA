<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend style="color: dodgerblue;"><b><spring:message code="mard.04.hoso.thongtinkydon.dkkd"/></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Người ký </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiky" name="fiNguoiky" maxlength="255"
                       type="text" data-bind="value : fiNguoiky" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Ngày ký </label>
            </div>
            <div class="col-md-4">
                <input name="fiNgayky" id="fiNgayky"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiNgayky"
                       disabled readonly/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Chức vụ người ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiChucvu" name="fiChucvu" maxlength="255"
                       type="text" data-bind="value : fiChucvu" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Nơi ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoiky" name="fiNoiky" maxlength="255"
                       type="text" data-bind="value : fiNoiky" disabled/>

            </div>
        </div>
    </div>
</fieldset>