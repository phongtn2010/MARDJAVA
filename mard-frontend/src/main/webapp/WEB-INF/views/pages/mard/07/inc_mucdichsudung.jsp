<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fieldset>
    <legend><b>Đề nghị kiểm dịch</b></legend>
    <form role="form" class="form-horizontal">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>Đề nghị quý Cơ quan kiểm dịch<a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="1">Xuất khẩu</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="2">Kho ngoại quan</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="3">Tạm xuất tái nhập</label>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2"></div>
                <div class="col-md-10">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" data-bind="checked: fiSelectedRequestOptions, enable: $root.isEditable()" value="4">Nhập khẩu</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="5">Quá cảnh</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" data-bind="checked: fiSelectedRequestOptions, enable: $root.isEditable()" value="6">Nhập khẩu
                        làm nguyên liệu chế biến xuất khẩu</label>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2"></div>
                <div class="col-md-10">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="7">Tạm nhập tái xuất</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="8">Chuyển khẩu</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="9">Hàng mẫu</label>
                    <label class="radio-inline  request-checkbox" >
                        <input type="checkbox" data-bind="checked: fiSelectedRequestOptions, enable: $root.isEditable()" value="10">Khác</label>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2"></div>
                <div class="col-md-10">
                    <span class="nsw-require-field validationMessage"
                          style="padding-top: 5px;"
                          data-bind="validationMessage: fiRequestOption"></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.tokhai.khac"/> (đề nghị ghi rõ)</label>
                </div>
                <div class="col-md-4">
                    <input type="text" data-bind="value: fiOptionOther, enable: $root.isEditable()" class="form-control">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.muc_dich_su_dung"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select data-bind="options: lstPurpose,
                                        optionsValue: 'name',
                                        optionsText: 'name',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiPurposeUse, enable: thongtinChungVM().fiHSStatus() == 0 && $root.isEditable()"
                            class="form-control">
                    </select>
                </div>
            </div>
        </div>
    </form>
    <style>
        .request-checkbox {
            float: left;
            width: calc(100% / 3);
            margin-left: 0px !important;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }
    </style>
</fieldset>
