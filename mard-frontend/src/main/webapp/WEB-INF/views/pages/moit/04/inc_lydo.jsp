<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset data-bind="visible: visibleLyDoXinSua">
    <legend><b><spring:message code="moit.04.hoso.lydo"/></b><a class="nsw-require-field">*</a></legend>
    <div class="form-group">
        <div class="col-md-12">
            <textarea style="resize: vertical;" class="form-control" name="lyDo" data-bind="value: lyDo , event:{change: Lydo} " maxlength="2000"></textarea>
        </div>
    </div>
    <span class="validationMessage" id="lyDo-lbl" style="display: none;">Thông tin bắt buộc nhập</span>
</fieldset>