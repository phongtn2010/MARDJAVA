<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fieldset data-bind="with: thongtinChungVM">
    <legend><b><spring:message code="mard.tokhai.thong_tin_hs"/></b></legend>
    <form role="form" class="form-horizontal">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.tokhai.trang_thai_hs"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value : $parent.getProfileStatus(fiHSStatus())"
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.ma_so_thue"/><a
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
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.tokhai.ngay_tao"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker: fiHSCreatedDate"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10" disabled/>
                </div>
                <div class="col-md-2 nsw-text-right" data-bind="visible: fiNSWFileCode()">
                    <label><spring:message code="mard.tokhai.ma_ho_so"/> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4" data-bind="visible: fiNSWFileCode()">
                    <input
                            disabled
                            data-bind="value: fiNSWFileCode"
                            class="form-control"/>
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
                    <label><spring:message code="mard.tokhai.ten_dang_ky"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="value: fiNameOfRegistration"
                           disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.dia_chi_dk"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiAddressOfRegistration"
                            class="form-control"
                            disabled/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.sdt_dk"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input type="text"
                            data-bind="value: fiPhoneOfRegistration, enable: $root.isEditable()"
                            class="form-control" maxlength="50"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.phone_number"/></label>
                </div>
                <div class="col-md-4">
                    <input type="text"
                            data-bind="value: fiNumberOfRegistration, enable: $root.isEditable()"
                            class="form-control" maxlength="15"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.fax_dk"/></label>
                </div>
                <div class="col-md-4">
                    <input type="text"
                            data-bind="value: fiFaxOfRegistration, enable: $root.isEditable()"
                            class="form-control" maxlength="50"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.email_dk"/></label>
                </div>
                <div class="col-md-4">
                    <input type="text"
                            data-bind="value: fiEmailOfRegistration, enable: $root.isEditable()"
                            class="form-control" maxlength="100"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.so_cmt"/> (Bắt buộc với cá nhân đăng ký)</label>
                </div>
                <div class="col-md-4">
                    <input type="text"
                            data-bind="value: fiIdentityNumber, enable: $root.isEditable()"
                            class="form-control" maxlength="13"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.noi_cap"/> (Bắt buộc với cá nhân đăng ký)</label>
                </div>
                <div class="col-md-4">
                    <input type="text"
                            data-bind="value: fiIdentityIssueAddress, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.ngay_cap"/> (Bắt buộc với cá nhân đăng ký)</label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker: fiIdentityIssueDate, enable: $root.isEditable()"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10"/>
                </div>
            </div>
        </div>
    </form>
</fieldset>