<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset data-bind="with: thongtinChungVM">
<div class="panel panel-primary">
    <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.ben_ban_hang"/></div>
    <div class="panel-body">
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_ban_hang_item_001"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiSellName" class="form-control"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_ban_hang_item_002"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select id="fiSellCountryCode" name="fiSellCountryCode" class="form-control select2"
                                data-bind="value : fiSellCountryCode, , selectedText2 : fiSellCountryName, options : lstCountry, optionsValue : 'countryid',  optionsText : 'countryname'">
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_ban_hang_item_003"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiSellAddress" class="form-control"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_ban_hang_item_004"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiSellTel" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_ban_hang_item_005"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiSellFax" class="form-control"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_ban_hang_item_006"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiSellExport" class="form-control"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="panel panel-primary">
    <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.ben_mua_hang"/></div>
    <div class="panel-body">
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_mua_hang_item_001"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiImporterName" class="form-control"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_mua_hang_item_004"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiImporterTel" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_mua_hang_item_003"/><a  class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiImporterAddress" class="form-control"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_mua_hang_item_002"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiImporterFax" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_mua_hang_item_005"/><a  class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiPurchReci" class="form-control"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.25.tokhai.ben_mua_hang_item_006"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <div class="row">
                            <div class="col-md-5 no-padding no-margin">
                                <input
                                        type="text"
                                        class="form-control form-control-inline date-picker"
                                        data-date-format="dd/mm/yyyy"
                                        data-bind="datepicker2: fiPurchFromDate, datepickerOptions: { endDate: fiPurchToDate }"
                                />
                            </div>
                            <div class="col-md-2 no-padding no-margin" style="text-align: center">-</div>
                            <div class="col-md-5 no-padding no-margin">
                                <input
                                        type="text"
                                        class="form-control form-control-inline date-picker"
                                        data-date-format="dd/mm/yyyy"
                                        data-bind="datepicker2: fiPurchToDate , datepickerOptions: { startDate: fiPurchFromDate }"
                                />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</fieldset>

