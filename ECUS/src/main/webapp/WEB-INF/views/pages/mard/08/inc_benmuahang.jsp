<fieldset data-bind="with: buyerVM">
    <legend><b><spring:message code="mard.08.tokhai.ben_mua_hang"/></b></legend>
    <form role="form" class="form-horizontal" name="thongTinHsForm">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.ten_ben_mua_hang"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiBuyerName, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.cmt"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiBuyerIdentityNumber, enable: $root.isEditable"
                            class="form-control" maxlength="50"/>
                </div>
            </div>

        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.ngay_cap"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="datepicker : fiBuyerIdentityDate, enable: $root.isEditable"
                           class="form-control form-control-inline date-picker"
                           data-date-format="dd/mm/yyyy" type="text" value=""
                           maxlength="10"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.noi_cap"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiBuyerIdentityPlace, enable: $root.isEditable"
                            class="form-control" maxlength="250"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.dien_thoai_ben_mua"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiBuyerTel, enable: $root.isEditable()"
                            class="form-control" maxlength="50"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.fax"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiBuyerFax, enable: $root.isEditable()"
                            class="form-control" maxlength="50"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.dia_chi_ben_mua"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiBuyerAddress, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.noi_nhan_hang"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiDstPortName, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.thoi_gian_nk_du_kien_tu"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="datepicker2 : fiImportingDateFrom, datepickerOptions: { endDate: fiImportingDateTo }, enable: $root.isEditable()"
                           class="form-control form-control-inline date-picker"
                           data-date-format="dd/mm/yyyy" type="text" value=""
                           maxlength="10"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mard.08.tokhai.thoi_gian_nk_du_kien_den"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="datepicker2 : fiImportingDateTo, datepickerOptions: { startDate: fiImportingDateFrom }, enable: $root.isEditable()"
                           class="form-control form-control-inline date-picker"
                           data-date-format="dd/mm/yyyy" type="text" value=""
                           maxlength="10"/>
                </div>
            </div>
        </div>
    </form>
</fieldset>