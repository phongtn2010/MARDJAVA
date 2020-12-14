<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset data-bind="with: thongtinChungVM">
    <legend><b><spring:message code="mard.hoso.thongtinhoso"/></b></legend>
    <form role="form" class="form-horizontal" name="thongTinHsForm">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="common.tracuu.trang_thai_ho_so"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value : $parent.getProfileStatus(fiHSStatus())"
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.ma_so_thue"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="value : fiTaxCode"
                           disabled/>
                </div>
            </div>

        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right ">
                    <label><spring:message code="mard.08.tokhai.ngaytao"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker: fiHSCreatedDate"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10" disabled/>
                </div>
                <div data-bind="visible: fiHSCode">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.tokhai.ma_ho_so"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value : fiHSCode"
                               disabled/>
                    </div>
                </div>
            </div>
        </div>
    </form>
</fieldset>
<fieldset data-bind="with: thongtinChungVM">
    <legend><b><spring:message code="mard.hoso.thongtinchung"/></b></legend>
    <form role="form" class="form-horizontal" name="thongTinCoQuanDangkyForm">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.ten_cong_ty"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="value: fiImporterName"
                           disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.cmt"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiIdentityNumber, enable: $root.isEditable()"
                            class="form-control" maxlength="50"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.dia_chi"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiImporterAddress"
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.dien_thoai"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiImporterTel, enable: $root.isEditable()"
                            class="form-control" maxlength="15"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.so_fax"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiImporterFax, enable: $root.isEditable()"
                            class="form-control" maxlength="15"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.email"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiImporterEmail, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
            </div>
        </div>
    </form>
</fieldset>