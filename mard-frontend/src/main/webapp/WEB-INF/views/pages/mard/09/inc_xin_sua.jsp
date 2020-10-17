<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mard.hoso.lydosua" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <textarea class="form-control" name="fiLydo" data-bind="value: fiModifyReason" maxlength="2000"></textarea>
            <span id="fiLydo_" class="validationMessage" style="display: none" >Thông tin bắt buộc nhập</span>
        </div>
    </div>
</fieldset>