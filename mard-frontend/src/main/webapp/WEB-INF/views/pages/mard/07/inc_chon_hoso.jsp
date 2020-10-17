<fieldset>
    <legend><b><spring:message code="mard.07.select.so_ho_so"/></b></legend>
    <form role="form" class="form-horizontal" style="margin-top: 15px;">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.van_ban_ctkd"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <select data-bind="options: lstCongVan,
                                        optionsText: 'fiDispatchNo',
                                        optionsCaption: '<spring:message code="mard.07.select.van_ban_chap_thuan_kd"/>',
                                        value: fiCongVan, enable: thongtinChungVM().fiHSStatus() == 0 && $root.isEditable()"
                            class="form-control">
                    </select>
                </div>
            </div>
        </div>
    </form>
</fieldset>
