<fieldset>
    <legend><b><spring:message code="mard.07.tokhai.co_quan_kiem_dich"/></b></legend>
    <form role="form" class="form-horizontal">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message
                            code="mard.07.tokhai.co_quan_kd_cua_khau"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <select data-bind="options: lstDepartment,
                                        optionsText: 'name',
                                        optionsValue: 'id',
                                        optionsCaption: '<spring:message code="mard.07.select.co_quan_kd"/>',
                                        value: fiDepartmentofQuarantineCode, enable: $root.isEditable()"
                            class="form-control">
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message
                            code="mard.07.tokhai.co_quan_kd_noi_cach_ly"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <select data-bind="options: lstDepartment,
                                        optionsText: 'name',
                                        optionsValue: 'id',
                                        optionsCaption: '<spring:message code="mard.07.select.co_quan_kd"/>',
                                        value: fiDepartmentofMonitorCode, enable: $root.isEditable()"
                            class="form-control">
                    </select>
                </div>
            </div>
        </div>
    </form>
</fieldset>