<fieldset data-bind="with: thongtinChungVM">
    <legend><b><spring:message code="mard.tokhai.thong_tin_hs"/></b></legend>
    <form role="form" class="form-horizontal">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.tokhai.trang_thai_hs"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value : $parent.getProfileStatus(fiHSStatus())"
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.ma_so_thue"/><a class="nsw-require-field">*</a></label>
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
                            code="mard.tokhai.ngay_tao"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker: fiHSCreatedDate"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10" disabled/>
                </div>
                <div data-bind="visible: fiNSWFileCode()">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.tokhai.ma_ho_so"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                disabled
                                data-bind="value: fiNSWFileCode"
                                class="form-control"/>
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
                    <label><spring:message code="mard.tokhai.ten_dang_ky"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="value: fiImporterName"
                           disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.dia_chi_dk"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiImporterAddress"
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
                    <input
                            data-bind="trimedValue: fiImporterTel, enable: $root.isEditable()"
                            class="form-control" maxlength="50"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.fax_dk"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiImporterFax, enable: $root.isEditable()"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.tokhai.email_dk"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiImporterEmail, enable: $root.isEditable()"
                            class="form-control"/>
                </div>
            </div>
        </div>
    </form>
</fieldset>