<fieldset data-bind="with: kyHoSoVM">
    <legend><b><spring:message code="sbv.02.thong_tin_ky"/></b></legend>
    <form role="form" class="form-horizontal">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="sbv.02.nguoi_ky"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiNguoiKyHS, enable: $root.isEditable()"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="sbv.02.chuc_vu_ky"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value : fiChucVuKy, enable: $root.isEditable()"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="sbv.02.noi_ky"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value : fiNoiKy, enable: $root.isEditable()"
                            class="form-control"/>
                    </select>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="sbv.02.ngay_ky"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker: fiNgayKyHS , enable: $root.isEditable()"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10" />
                </div>
            </div>
        </div>
    </form>
</fieldset>