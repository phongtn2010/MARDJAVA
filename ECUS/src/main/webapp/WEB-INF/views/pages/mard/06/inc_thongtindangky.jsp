<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <spring:message code="mard.06.select.dong_vat_thuy_san"/>
                    </option>
                    <option value="2">
                        <spring:message code="mard.06.select.san_pham_dv_thuy_san"/>
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