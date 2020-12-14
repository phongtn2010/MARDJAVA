<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-md-12 form-horizontal" style="padding-left: 0" data-bind="with: thongTinKhacVM">
    <fieldset>
        <legend><b><spring:message code="mard.01.title.cac_thong_tin_khac"/></b></legend>
        <div class="panel-body">
            <form role="form" class="form-horizontal" name="thongTinKhacForm">
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.ten_to_chu_nhap_khau"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10" style="display: flex;align-items: center">
                        <div style="width: 48%">
                            <input class="form-control" id="fiImporteNameVni" name="fiImporteNameAddressVni" data-bind="value: fiImporteNameAddressVni"
                                   maxlength="500"
                            />
                            <span class="nsw-require-field validate" id="fiImporteNameAddressVni-validate"></span>
                        </div>
                        <div style="width: 4%; text-align: center"><span>/</span></div>
                        <div style="width: 48%">
                            <input class="form-control" id="fiImporteName" name="fiImporteNameAddress" data-bind="value: fiImporteNameAddress"
                                   maxlength="500"
                                   placeholder="<spring:message code="mard.01.tokhai.ten_to_chu_nhap_khau"/> (Tiếng Anh)"
                            />
                            <span class="nsw-require-field validate" id="fiImporteNameAddress-validate"></span>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.email"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiImporterEmail" name="fiImporterEmail" data-bind="value: fiImporterEmail"
                               maxlength="250"
                               type="email"
                        />
                        <span class="nsw-require-field validate" id="fiImporterEmail-validate"></span>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.so_dien_thoai"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiImporterTel" name="fiImporterTel" data-bind="value: fiImporterTel"
                               maxlength="50"
                        />
                        <span class="nsw-require-field validate" id="fiImporterTel-validate"></span>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.fax"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiImporterFax" name="fiImporterFax" data-bind="value: fiImporterFax"
                               maxlength="50"
                        />
                        <span class="nsw-require-field validate" id="fiImporterFax-validate"></span>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.ten_cua_khau_xuat"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10" style="display: flex;align-items: center">
                        <div style="width: 48%">
                            <input class="form-control" data-bind="value: fiBordergateNameVni"
                                   maxlength="250"
                            />
                            <span class="nsw-require-field validate" id="fiBordergateNameVni-validate"></span>
                        </div>
                        <div style="width: 4%; text-align: center"><span>/</span></div>
                        <div style="width: 48%">
                            <input class="form-control" data-bind="value: fiBordergateName"
                                   maxlength="250"
                                   placeholder="<spring:message code="mard.01.tokhai.ten_cua_khau_xuat"/> (Tiếng Anh)"
                            />
                            <span class="nsw-require-field validate" id="fiBordergateName-validate"></span>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.phuong_tien_di_chuyen"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10" style="display: flex;align-items: center">
                        <div style="width: 48%">
                            <input class="form-control" id="fiMeansTransportNameVni" name="fiMeansTransportNameVni"
                                   data-bind="value: fiMeansTransportNameVni"
                                   maxlength="250"
                            />
                            <span class="nsw-require-field validate" id="fiMeansTransportNameVni-validate"></span>
                        </div>
                        <div style="width: 4%; text-align: center"><span>/</span></div>
                        <div style="width: 48%">
                            <input class="form-control" id="fiMeansTransportName" name="fiMeansTransportName"
                                   data-bind="value: fiMeansTransportName"
                                   maxlength="250"
                                   placeholder="<spring:message code="mard.01.tokhai.phuong_tien_di_chuyen"/> (Tiếng Anh)"
                            />
                            <span class="nsw-require-field validate" id="fiMeansTransportName-validate"></span>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.ngay_khoi_hanh"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               id="fiDepartureDateFrom"
                               name="fiDepartureDateFrom"
                               data-bind="datepicker: fiDepartureDateFrom"
                               class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value=""
                               maxlength="10"
                        />
                    </div>
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.thoi_gian_hang_den_cua_khau"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               id="fiExpectingDateFrom"
                               name="fiExpectingDateFrom"
                               data-bind="datepicker: fiExpectingDateFrom"
                               class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value=""
                               maxlength="10"
                        />
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.ten_quoc_gia_nhap_khau"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" data-bind="
                            optionsCaption: 'Chọn...',
                            options: lstCountry,
                            value: fiImporterCountryCode,
                            optionsValue: 'countrycode',
                            optionsText : 'countryname'"></select>
                        <span class="nsw-require-field validate" id="fiImporterCountry-validate"></span>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.quoc_gia_qua_canh"/></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" id="fiTransitCountryCode" name="fiTransitCountryCode"
                                data-bind="
                                optionsCaption: 'Chọn...',
                                options: lstCountry,
                                value: fiTransitCountryCode,
                                optionsValue: 'countrycode',
                                optionsText : 'countryname'"></select>
                        <span class="nsw-require-field validate" id="fiTransitCountryCode-validate"></span>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.dieu_kien_bao_quan"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiConditionsTransport" name="fiConditionsTransport"
                               data-bind="value: fiConditionsTransport"
                               maxlength="250"
                        />
                        <span class="nsw-require-field validate" id="fiConditionsTransport-validate"></span>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.cac_vat_dung_lien_quan"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" data-bind="value: fiOtherTransport"
                               maxlength="500"
                        />
                        <span class="nsw-require-field validate" id="fiOtherTransport-validate"></span>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.ho_so_giay_to_lien_quan"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10">
                        <input class="form-control" data-bind="value: fiTransportAttrachFile"
                               maxlength="500"
                        />
                        <span class="nsw-require-field validate" id="fiTransportAttrachFile-validate"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.dia_diem_cach_ly"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10" style="display: flex;align-items: center">
                        <div style="width: 48%">
                            <input class="form-control" id="fiLocationQuarantineVni" name="fiLocationQuarantineVni"
                                   data-bind="value: fiLocationQuarantineVni"
                                   maxlength="250"
                            />
                            <span class="nsw-require-field validate" id="fiLocationQuarantineVni-validate"></span>
                        </div>
                        <div style="width: 4%; text-align: center"><span>/</span></div>
                        <div style="width: 48%">
                            <input class="form-control" id="fiLocationQuarantine" name="fiLocationQuarantine"
                                   data-bind="value: fiLocationQuarantine"
                                   maxlength="250"
                                   placeholder="<spring:message code="mard.01.tokhai.dia_diem_cach_ly"/> (Tiếng Anh)"
                            />
                            <span class="nsw-require-field validate" id="fiLocationQuarantine-validate"></span>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.thoi_gian_kiem_dich"/><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="datepicker : fiTimeQuarantine"
                               class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value=""
                               maxlength="10"/>
                        <span class="nsw-require-field validate" id="fiTimeQuarantine-validate"></span>
                    </div>
                </div>
                <div style="margin-top: 20px">
                    <b><spring:message
                            code="mard.01.tokhai.bat_buoc_voi_sp_ga_va_sua"/></b>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.so_chi_cua_congtono"/></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiContaine" name="fiContaine" data-bind="value: fiContaine"
                               maxlength="500"
                        />
                    </div>
                </div>
                <div style="margin-top: 20px">
                    <b><spring:message
                            code="mard.01.tokhai.doi_voi_cua_khau_HK_TQ"/></b>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.ten_cua_nhap_khau"/></label>
                    </div>
                    <div class="col-md-10" style="display: flex;align-items: center">
                        <div style="width: 48%">
                            <input class="form-control" data-bind="value: fiEntryPointNameVni"
                                   maxlength="250"
                            />
                            <span class="nsw-require-field validate" id="fiEntryPointNameVni-validate"></span>
                        </div>
                        <div style="width: 4%; text-align: center"><span>/</span></div>
                        <div style="width: 48%">
                            <input class="form-control" data-bind="value: fiEntryPointName"
                                   maxlength="250"
                                   placeholder="<spring:message code="mard.01.tokhai.ten_cua_nhap_khau"/> (Tiếng Anh)"
                            />
                            <span class="nsw-require-field validate" id="fiEntryPointName-validate"></span>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 20px; margin-bottom: 20px;">
                    <div class="col-md-12">
                        <label><b><spring:message
                                code="mard.01.tokhai.toi_xin_cam_doan"/></b></label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label><spring:message
                                code="mard.01.tokhai.noi_dung_chung_nhan"/></label>
                    </div>
                    <div class="col-md-10">
                        <textarea class="form-control" data-bind="value: fiHealthCertificateContent"
                                  maxlength="5000"
                        ></textarea>
                    </div>
                </div>
<%--                <div class="row" style="margin-top: 10px">--%>
<%--                    <div class="col-md-2">--%>
<%--                        <label><spring:message--%>
<%--                                code="mard.01.tokhai.noi_dung_chung_nhan_tieng_anh" /></label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <textarea class="form-control" data-bind="value: fiHealthCertificateContent"></textarea>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <p class="nsw-require-field validate" id="fiHealthCertificateContentVni-validate" style="text-align: center"></p>
            </form>
        </div>
    </fieldset>
</div>
