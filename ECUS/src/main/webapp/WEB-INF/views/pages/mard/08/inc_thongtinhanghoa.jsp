<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<hr/>
<form role="form" class="form-horizontal">
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="mard.08.tokhai.hinh_thuc_dang_ky"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <select class="form-control" data-bind="value: fiHSType, enable: $root.isEditable()">
                    <option value="1">
                        <spring:message code="mard.08.tokhai.radio_kiem_dich_dong_vat_label"/>
                    </option>
                    <option value="2">
                        <spring:message code="mard.08.tokhai.radio_kiem_dich_sp_dong_vat_label"/>
                    </option>
                    <option value="3">
                        <spring:message code="mard.08.tokhai.radio_kiem_dich_thuc_an"/>
                    </option>
                </select>
            </div>
        </div>
    </div>
</form>
<div data-bind="visible: fiHSType() == '1'">
    <%@include file="inc_thongtindongvat.jsp" %>
</div>
<div data-bind="visible: fiHSType() == '2'">
    <%@include file="inc_thongtinspdongvat.jsp" %>
</div>
<div data-bind="visible: fiHSType() == '3'">
    <%@include file="inc_thongtinbotthitxuong.jsp" %>
</div>
