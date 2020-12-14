<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>

    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiExperimentName"/><span
                    class="nsw-require-field">*</span></label>

            <div class="col-md-9">
                <select id="trungTamKN" name="trungTamKN" class="form-control select2 form-control-inline" data-bind="options: $root.danhSachTrungTamKN,
                       optionsText: 'fiName',
                       optionsValue: 'fiCode',
                       value: moduleThongTinChung.tbdHoSo19.fiExperimentCode, enable: !isView">
                </select>
            </div>
        </div>
    </div>
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiGates"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <textarea id="fiGates" class="form-control"
                          placeholder="<spring:message code="mard.19.TbdHoSo19.fiGates"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo19.fiGates, enable: !isView" autocomplete="off"></textarea>
            </div>
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiContractNo"/><span
                class="nsw-require-field">*</span></label>
        <div class="col-md-9">
            <input id="fiContractNo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiContractNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiContractNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>

<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiGoodListNo"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiGoodListNo" class="form-control"
                          placeholder="<spring:message code="mard.19.TbdHoSo19.fiGoodListNo"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo19.fiGoodListNo, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>

<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiSignDate"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
            <input onpaste="return false;"  id="fiSignDate" class="form-control date-picker"
                   data-date-format="dd/mm/yyyy" size="16"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiSignDate"/>"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiSignDate, dateInput, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div>
    <span><spring:message code="mard.19.tbdHoSo19.fiCertificateType"></spring:message></span><span
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
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCQNo"/>
        </label>
        <div class="col-md-9">
            <input id="fiCQNo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCQNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCQNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCQOrganization"/>
        </label>
        <div class="col-md-9">
            <input id="fiCQOrganization" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCQOrganization" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCQOrganization, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCQDate"/>
        </label>

        <div class="col-md-9">
            <input onpaste="return false;"  id="fiCQDate" class="form-control date-picker"
                   data-date-format="dd/mm/yyyy" size="16"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCQDate"/>"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCQDate, dateInput, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCQIssueBy"/>
        </label>
        <div class="col-md-9">
            <input id="fiCQIssueBy" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCQIssueBy" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCQIssueBy, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCMSNo"/></label>
        <div class="col-md-9">
            <input id="fiCMSNo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCMSNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCMSNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCMSOrganization"/></label>
        <div class="col-md-9">
            <input id="fiCMSOrganization" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCMSOrganization" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCMSOrganization, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCMSDate"/></label>

        <div class="col-md-9">
            <input onpaste="return false;"  id="fiCMSDate" class="form-control date-picker"
                   data-date-format="dd/mm/yyyy" size="16"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCMSDate"/>"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCMSDate, dateInput, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCMSIssueBy"/></label>
        <div class="col-md-9">
            <input id="fiCMSIssueBy" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCMSIssueBy" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCMSIssueBy, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiInvoiceNo"/><span
                class="nsw-require-field">*</span></label>
        <div class="col-md-9">
            <input id="fiInvoiceNo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiInvoiceNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiInvoiceNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiBillNo"/><span
                class="nsw-require-field">*</span></label>
        <div class="col-md-9">
            <input id="fiBillNo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiBillNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiBillNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiDeclarationNo"/></label>
        <div class="col-md-9">
            <input id="fiDeclarationNo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiDeclarationNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiDeclarationNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCONo"/></label>
        <div class="col-md-9">
            <input id="fiCONo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCONo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCONo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiCFSNo"/></label>
        <div class="col-md-9">
            <input id="fiCFSNo" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiCFSNo" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiCFSNo, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiTechRegul"/></label>
        <div class="col-md-9">
            <input id="fiTechRegul" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiTechRegul" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiTechRegul, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiApplyRegul"/></label>
        <div class="col-md-9">
            <input id="fiApplyRegul" class="form-control"
                   placeholder="<spring:message code="mard.19.TbdHoSo19.fiApplyRegul" />"
                   data-bind="value: moduleThongTinChung.tbdHoSo19.fiApplyRegul, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>

<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiSenderNumber"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiSenderNumber" class="form-control"
                          placeholder="<spring:message code="mard.19.TbdHoSo19.fiSenderNumber"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo19.fiSenderNumber, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.19.TbdHoSo19.fiReceiptWritingAddress"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiReceiptWritingAddress" class="form-control"
                          placeholder="<spring:message code="mard.19.TbdHoSo19.fiReceiptWritingAddress"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo19.fiReceiptWritingAddress, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>
</div>



