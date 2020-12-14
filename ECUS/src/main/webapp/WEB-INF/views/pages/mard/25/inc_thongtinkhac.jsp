<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fieldset data-bind="with: thongtinChungVM">
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.khac.mau_ktra"/></b></div>
        <div class="panel-body">
            <form role="form" class="form-horizontal" name="thongTinCoQuanDangkyForm">
                <div class="form-group" style="margin-top: 15px">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.khac.mau_ktra_item_01"/></label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" data-bind="value : fiAddressGath" />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.khac.mau_ktra_item_02"/></label>
                        </div>
                        <div class="col-md-10">
                            <div class="row">
                                <div class="col-md-5 no-padding no-margin">
                                    <input
                                            type="text"
                                            class="form-control form-control-inline date-picker"
                                            data-date-format="dd/mm/yyyy"
                                            data-bind="datepicker2: fiRegSamFromDate, datepickerOptions: { endDate: fiRegSamToDate }"
                                    />
                                </div>
                                <div class="col-md-2 no-padding no-margin" style="text-align: center">-</div>
                                <div class="col-md-5 no-padding no-margin">
                                    <input
                                            type="text"
                                            class="form-control form-control-inline date-picker"
                                            data-date-format="dd/mm/yyyy"
                                            data-bind="datepicker2: fiRegSamToDate, datepickerOptions: { startDate: fiRegSamFromDate }"
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.khac.mau_ktra_item_03"/></label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" data-bind="value : fiAddressRegSample"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</fieldset>
<fieldset data-bind="with: thongtinChungVM">
    <div class="panel panel-primary">
        <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.25.tokhai.khac.lien_he"/></div>
        <div class="panel-body">
            <form role="form" class="form-horizontal">
                <div class="form-group" style="margin-top: 15px">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.khac.lien_he_item_name"/><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input data-bind="value: fiContactName" class="form-control"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.khac.lien_he_item_tel"/></label>
                        </div>
                        <div class="col-md-4">
                            <input data-bind="value: fiContactTel" class="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.khac.lien_he_item_address"/></label>
                        </div>
                        <div class="col-md-4">
                            <input data-bind="value: fiContactAddress" class="form-control"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.khac.lien_he_item_emal"/></label>
                        </div>
                        <div class="col-md-4">
                            <input data-bind="value: fiContactEmail" class="form-control"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</fieldset>