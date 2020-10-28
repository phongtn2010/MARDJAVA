<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<fieldset data-bind="with: thongtinChungVM">--%>
<%--    <div class="panel panel-primary">--%>
<%--        <div class="panel-heading"><b><spring:message code="mard.hoso.thongtinchung"/></b></div>--%>
<%--        <div class="panel-body">--%>
<%--            <form role="form" class="form-horizontal" name="thongTinCoQuanDangkyForm">--%>
<%--                <div class="form-group" style="margin-top: 15px">--%>
<%--                    <div class="col-md-12">--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label><spring:message code="mard.tokhai.ma_so_thue"/><a class="nsw-require-field">*</a></label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <input class="form-control"--%>
<%--                                   data-bind="value : fiTaxCode"--%>
<%--                                   disabled/>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label><spring:message code="mard.tokhai.ten_dang_ky"/><a class="nsw-require-field">*</a></label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <input class="form-control"--%>
<%--                                   data-bind="value: fiImporterName"--%>
<%--                                   disabled/>--%>
<%--                        </div>--%>

<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <div class="col-md-12">--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label><spring:message code="mard.tokhai.dia_chi_dk"/><a class="nsw-require-field">*</a></label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <input--%>
<%--                                    data-bind="value: fiImporterAddress"--%>
<%--                                    class="form-control"--%>
<%--                                    disabled/>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label><spring:message code="mard.tokhai.sdt_dk"/><a--%>
<%--                                    class="nsw-require-field">*</a></label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <input--%>
<%--                                    data-bind="trimedValue: fiImporterTel, enable: $root.isEditable()"--%>
<%--                                    class="form-control" maxlength="50"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <div class="col-md-12">--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label><spring:message code="mard.tokhai.fax_dk"/></label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <input--%>
<%--                                    data-bind="trimedValue: fiImporterFax, enable: $root.isEditable()"--%>
<%--                                    class="form-control"/>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label><spring:message code="mard.tokhai.email_dk"/><a class="nsw-require-field">*</a></label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <input--%>
<%--                                    data-bind="trimedValue: fiImporterEmail, enable: $root.isEditable()"--%>
<%--                                    class="form-control"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</fieldset>--%>
<fieldset data-bind="with: thongtinChungVM">
    <div class="panel panel-primary">
        <div class="panel-heading" style="font-weight: bold;"><spring:message code="mard.tokhai.thong_tin_hs"/></div>
        <div class="panel-body">
            <form role="form" class="form-horizontal">
                <div class="form-group" style="margin-top: 15px">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.tokhai.ma_ho_so"/><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input
                                    disabled
                                    data-bind="value: fiNSWFileCode"
                                    class="form-control"/>
                        </div>
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
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message
                                    code="mard.25.tokhai.thong_tin_loai"/><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control"  data-bind="options : lstHoSoType, optionsValue : 'fiCatType',
                                                                     selectedText:fiHSTypeName,
                                                                     optionsText : 'fiCatTypeName',
                                                    value: fiHSType, enable: $root.isEditable(), event: {change: changeHoSoType(fiHSType())}">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message
                                    code="mard.25.tokhai.thong_tin_hoso_thay_the"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control"  data-bind="value: fiNSWFileCodeReplace, enable: $root.isEditable()">
                            </select>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message
                                    code="mard.25.tokhai.thong_tin_giay_thay_the"/></label>
                        </div>
                        <div class="col-md-4">
                            <input
                                    data-bind="value: fiGDK"
                                    class="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right"></div>
                        <div class="col-md-4"></div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message
                                    code="mard.25.tokhai.thong_tin_giay_thay_the"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="file" data-bind="value: fiGDKFile"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label><b><spring:message code="mard.25.tokhai.thong_tin_ghi_chu"/>: </b></label><label><spring:message code="mard.25.tokhai.thong_tin_ghi_chu_noi_dung"/></label>
                    </div>
                </div>
            </form>
        </div>
    </div>
</fieldset>

