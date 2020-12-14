<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>

    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiExperimentName"/><span
                    class="nsw-require-field">*</span></label>

            <div class="col-md-9">
                <select id="trungTamKN" name="trungTamKN" class="form-control select2 form-control-inline" data-bind="options: $root.danhSachTrungTamKN,
                       optionsText: 'fiName',
                       optionsValue: 'fiCode',
                       value: moduleThongTinChung.tbdHoSo18.fiExperimentCode, enable: !isView">
                </select>
            </div>
        </div>
    </div>
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiGates"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <textarea id="fiGates" class="form-control"
                          placeholder="<spring:message code="mard.18.TbdHoSo18.fiGates"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo18.fiGates, enable: !isView" autocomplete="off"></textarea>
            </div>
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiContractNo"/><span
                class="nsw-require-field">*</span></label>
        <div class="col-md-9">
            <input id="fiContractNo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiContractNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiContractNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>

<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiGoodListNo"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiGoodListNo" class="form-control"
                          placeholder="<spring:message code="mard.18.TbdHoSo18.fiGoodListNo"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo18.fiGoodListNo, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>

<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiSignDate"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
            <input onpaste="return false;"  id="fiSignDate" class="form-control date-picker"
                   data-date-format="dd/mm/yyyy" size="16"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiSignDate"/>"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiSignDate, dateInput, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div>
<span><spring:message code="mard.18.tbdHoSo18.fiCertificateType"></spring:message></span><span
        class="nsw-require-field">*</span>
</div>
<!-- select option -->
<div class="col-md-12">
    <div class=" form-group" style="padding: 0 30px;">
        <!-- ko foreach: $root.fiCertificateType() -->
        <div class="col-md-4 row">
            <div class="form-group" style="margin-left:60px;">
                <div class="checkbox">
                    <label>
                        <input id="fiCertificateType" type="checkbox"
                               data-bind="checked: ($root.fiCertificateTypeSelecteds.indexOf($data) != -1), event:{ change: $root.checkBoxCTSelected}, enable: !isView"/>
                        <span  data-bind="text: ($index() + 1) + ' - ' + fiName()"></span>
                    </label>
                </div>
            </div>
        </div>
        <!-- /ko -->
    </div>
</div>

<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCQNo"/>
        </label>
        <div class="col-md-9">
            <input id="fiCQNo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCQNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCQNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCQOrganization"/>
        </label>
        <div class="col-md-9">
            <input id="fiCQOrganization" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCQOrganization" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCQOrganization, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCQDate"/>
        </label>

        <div class="col-md-9">
            <input onpaste="return false;"  id="fiCQDate" class="form-control date-picker"
                   data-date-format="dd/mm/yyyy" size="16"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCQDate"/>"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCQDate, dateInput, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCQIssueBy"/>
        </label>
        <div class="col-md-9">
            <input id="fiCQIssueBy" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCQIssueBy" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCQIssueBy, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCMSNo"/></label>
        <div class="col-md-9">
            <input id="fiCMSNo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCMSNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCMSNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCMSOrganization"/></label>
        <div class="col-md-9">
            <input id="fiCMSOrganization" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCMSOrganization" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCMSOrganization, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCMSDate"/></label>

        <div class="col-md-9">
            <input onpaste="return false;"  id="fiCMSDate" class="form-control date-picker"
                   data-date-format="dd/mm/yyyy" size="16"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCMSDate"/>"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCMSDate, dateInput, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCMSIssueBy"/></label>
        <div class="col-md-9">
            <input id="fiCMSIssueBy" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCMSIssueBy" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCMSIssueBy, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiInvoiceNo"/><span
                class="nsw-require-field">*</span></label>
        <div class="col-md-9">
            <input id="fiInvoiceNo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiInvoiceNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiInvoiceNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiBillNo"/><span
                class="nsw-require-field">*</span></label>
        <div class="col-md-9">
            <input id="fiBillNo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiBillNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiBillNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiDeclarationNo"/></label>
        <div class="col-md-9">
            <input id="fiDeclarationNo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiDeclarationNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiDeclarationNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCONo"/></label>
        <div class="col-md-9">
            <input id="fiCONo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCONo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCONo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiCFSNo"/></label>
        <div class="col-md-9">
            <input id="fiCFSNo" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiCFSNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiCFSNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiTechRegul"/></label>
        <div class="col-md-9">
            <input id="fiTechRegul" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiTechRegul" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiTechRegul, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiApplyRegul"/></label>
        <div class="col-md-9">
            <input id="fiApplyRegul" class="form-control"
                   placeholder="<spring:message code="mard.18.TbdHoSo18.fiApplyRegul" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo18.fiApplyRegul, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>

<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiSenderNumber"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiSenderNumber" class="form-control"
                          placeholder="<spring:message code="mard.18.TbdHoSo18.fiSenderNumber"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo18.fiSenderNumber, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.18.TbdHoSo18.fiReceiptWritingAddress"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiReceiptWritingAddress" class="form-control"
                          placeholder="<spring:message code="mard.18.TbdHoSo18.fiReceiptWritingAddress"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo18.fiReceiptWritingAddress, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>
</div>



