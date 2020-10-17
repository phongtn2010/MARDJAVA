<fieldset data-bind="with: kyHoSoVM">
    <legend><b><spring:message code="mard.08.table.title.thong_tin_ky_ho_so"/></b></legend>
    <form role="form" class="form-horizontal" name="thongTinHsForm">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.nguoi_ky"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiSignedBy, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.chuc_vu_ky"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiSignedByTitle, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.dang_ky_tai"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select
                            data-bind="options: lstProvince,
                                                optionsText: 'provinceName',
                                                optionsValue: 'provinceName',
                                                optionsCaption: '<spring:message code="mard.08.tokhai.select_sign_location"/>',
                                                value: fiSigningLocation, enable: $root.isEditable()" class="form-control"></select>
                </div>
            </div>
        </div>
    </form>
</fieldset>