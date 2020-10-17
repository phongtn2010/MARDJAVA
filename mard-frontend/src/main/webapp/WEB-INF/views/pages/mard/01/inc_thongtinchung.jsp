<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row" data-bind="with: thongtinChungVM">
    <div class="col-md-12" style="padding-left: 30px">
        <fieldset>
            <legend style="margin-left: -10px"><b><spring:message
                    code="common.thong_tin_ho_so"/></b>
            </legend>
            <div class="panel-body">
                <form role="form" class="form-horizontal" name="thongTinHsForm">
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message
                                        code="common.tracuu.trang_thai_ho_so"/></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="1" data-bind="value: fiHSStatus" disabled/>
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.ma_so_thue"/></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control"
                                       data-bind="value : fiTaxCode"
                                       disabled/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">

                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.ngaytao"/></label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        data-bind="datepicker: fiHSCreatedDate"
                                        class="form-control form-control-inline date-picker"
                                        data-date-format="dd/mm/yyyy" type="text" value=""
                                        maxlength="10" disabled/>
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.ten_co_quan_cap"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select class="form-control"
                                        data-bind="optionsCaption: 'Chọn...', options: lstTranThuY, optionsText : 'name', value: fiDepartment,
                                        enable: fiHSStatus() !='Yêu cầu sửa đổi bổ sung' && fiHSStatus() != 'Đã tiếp nhận'"></select>
                                <span class="nsw-require-field validate" id="fiDepartment-validate"></span>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </fieldset>
    </div>
</div>
<div class="row" data-bind="with: thongtinChungVM">
    <fieldset class="col-md-12" style="padding-left: 30px">
        <fieldset>
            <legend style="margin-left: -10px"><b><spring:message
                    code="mard.01.tokhai.thong_tin_ca_nhan"/></b>
            </legend>
            <div class="panel-body">
                <form role="form" class="form-horizontal" name="thongTinCoQuanDangkyForm">
                    <div class="form-group" style="margin-top: 15px" data-bind="visible: fiNSWFileCode()">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.so_don"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10">
                                <input
                                        disabled
                                        data-bind="value: fiNSWFileCode"
                                        class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.ma_so_thue_nguoi_tao"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10">
                                <input
                                        data-bind="value: fiTaxCode"
                                        class="form-control" disabled/>
                                <span class="nsw-require-field validate" id="fiTaxCode-validate"></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.ho_ten_chu_hang"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10" style="display: flex;align-items: center">
                                <div style="width: 46%">
                                    <input
                                            data-bind="value: fiExporterNameVni"
                                            class="form-control"
                                            maxlength="250"
                                    />
                                    <span class="nsw-require-field validate" id="fiExporterNameVni-validate"></span>
                                </div>
                                <div style="width: 8%; text-align: center"><span>/</span></div>
                                <div style="width: 46%">
                                    <input
                                            data-bind="value: fiExporterName"
                                            class="form-control"
                                            maxlength="250"
                                            placeholder="<spring:message code="mard.01.tokhai.ho_ten_chu_hang"/> (Tiếng Anh)"
                                    />
                                    <span class="nsw-require-field validate" id="fiExporterName-validate"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.dia_chi_gd"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10" style="display: flex;align-items: center">
                                <div style="width: 46%">
                                    <input
                                            data-bind="value: fiExporterAdressVni"
                                            class="form-control"
                                            maxlength="250"
                                    />
                                    <span class="nsw-require-field validate" id="fiExporterAdressVni-validate"></span>
                                </div>
                                <div style="width: 8%; text-align: center"><span>/</span></div>
                                <div style="width: 46%">
                                    <input
                                            data-bind="value: fiExporterAdress"
                                            class="form-control"
                                            maxlength="250"
                                            placeholder="<spring:message code="mard.01.tokhai.dia_chi_gd"/> (Tiếng Anh)"
                                    />
                                    <span class="nsw-require-field validate" id="fiExporterAdress-validate"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.so_cmnd"/></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control"
                                       data-bind="value: fiIdentityNumber"
                                       maxlength="13"
                                />
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.ngay_cap"/></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control"
                                       data-bind="datepicker: fiIdentityIssueDate"
                                       class="form-control form-control-inline date-picker"
                                       data-date-format="dd/mm/yyyy" type="text" value=""
                                       maxlength="10"
                                />
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.cap_tai"/></label>
                            </div>
                            <div class="col-md-10">
                                <input class="form-control"
                                       data-bind="value: fiIdentityIssueAdress"
                                       maxlength="250"
                                />
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.sdt_to_chuc_xh"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        data-bind="value: fiExporterTel"
                                        class="form-control"
                                        maxlength="50"
                                />
                                <span class="nsw-require-field validate" id="fiExporterTel-validate"></span>
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.so_fax_to_chuc_xh"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        data-bind="value: fiExporterFax"
                                        class="form-control"
                                        maxlength="50"
                                />
                                <span class="nsw-require-field validate" id="fiExporterFax-validate"></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.tokhai.hop_thu_to_chuc_xh"/> <a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        data-bind="value: fiExporterEmail"
                                        class="form-control"
                                        maxlength="250"
                                />
                                <span class="nsw-require-field validate" id="fiExporterEmail-validate"></span>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
    </fieldset>
</div>
