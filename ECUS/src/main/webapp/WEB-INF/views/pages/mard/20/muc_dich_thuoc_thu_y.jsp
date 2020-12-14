<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>




<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiSignDate"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
            <input onpaste="return false;"  id="fiSignDate" class="form-control date-picker"
                   data-date-format="dd/mm/yyyy" size="16"
                   placeholder="<spring:message code="mard.20.TbdHoSo20.fiSignDate"/>"
                   data-bind="value: moduleThongTinChung.tbdHoSo20.fiSignDate, dateInput, enable: !isView" autocomplete="off">
        </div>
    </div>
</div>


   <span><spring:message code="mard.20.tbdHoSo20.fiCertificateType"></spring:message></span><span
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
        <label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiSenderNumber"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiSenderNumber" class="form-control"
                          placeholder="<spring:message code="mard.20.TbdHoSo20.fiSenderNumber"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo20.fiSenderNumber, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>
<div class="">
    <div class="row form-group">
        <label class="col-md-3"><spring:message code="mard.20.TbdHoSo20.fiReceiptWritingAddress"/><span
                class="nsw-require-field">*</span></label>

        <div class="col-md-9">
                <textarea id="fiReceiptWritingAddress" class="form-control"
                          placeholder="<spring:message code="mard.20.TbdHoSo20.fiReceiptWritingAddress"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo20.fiReceiptWritingAddress, enable: !isView" autocomplete="off"></textarea>
        </div>
    </div>
</div>
</div>

</div>



