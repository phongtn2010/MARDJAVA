<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
    <span><spring:message code="mard.14.TbdThuoc3.mucdich"></spring:message></span><span
        class="nsw-require-field">*</span>
</div>
<div class="">

    <div class="col-md-12">
        <div class=" form-group" style="padding: 0 30px;">
            <!-- ko foreach: $root.fiPurposes() -->
            <div class="col-md-4 row">
               <div class="form-group" style="margin-left:60px;">
                   <div class="checkbox">
                       <label>
                               <input id="fiPurposes" type="checkbox"
                                      data-bind="checked: ($root.fiPurposeSelecteds.indexOf($data) != -1), event:{ change: $root.checkBoxSelected}, enable: !isView"/>
                           <span  data-bind="text: ($index() + 1) + ' - ' + fiName()"></span>
                       </label>
                   </div>
               </div>
            </div>
            <!-- /ko -->
        </div>
    </div>
    <!-- ko if: ($root.checkDisplayGroup(['fiToxicityUsed']))-->
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.14.TbdThuoc3.toxicityUsed"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <input id="fiToxicityUsed" class="form-control"
                       placeholder="<spring:message code="mard.14.TbdThuoc3.toxicityUsed"/>"
                       data-bind="value: moduleThongTinChung.tbdHoSo14.fiToxicityUsed, enable: !isView">
            </div>
        </div>
    </div>
    <!-- /ko -->
    <!-- ko if: ($root.checkDisplayGroup(['fiTestingUsed']))-->
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.14.TbdThuoc3.testingUsed"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <input id="fiTestingUsed" class="form-control"
                       placeholder="<spring:message code="mard.14.TbdThuoc3.testingUsed"/>"
                       data-bind="value: moduleThongTinChung.tbdHoSo14.fiTestingUsed, enable: !isView" autocomplete="off">
            </div>
        </div>
    </div>
    <!-- /ko -->
    <!-- ko if: ($root.checkDisplayGroup(['fiPurposeOtherNote']))-->
    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.14.TbdThuoc3.purposeOtherNote"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <input id="fiPurposeOtherNote" class="form-control"
                       placeholder="<spring:message code="mard.14.TbdThuoc3.purposeOtherNote" />"
                       data-bind="value: moduleThongTinChung.tbdHoSo14.fiPurposeOtherNote, enable: !isView" autocomplete="off">
            </div>
        </div>
    </div>
    <!-- /ko -->

    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiGates"/><span
                    class="nsw-require-field">*</span></label>
            <div class="col-md-9">
                <textarea id="fiGates" class="form-control"
                          placeholder="<spring:message code="mard.14.TbdHoSo14.fiGates"/>"
                          data-bind="value: moduleThongTinChung.tbdHoSo14.fiGates, enable: !isView" autocomplete="off"></textarea>
            </div>
        </div>
    </div>

    <div class="">
        <div class="row form-group">
            <label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiImportTimeFrom"/></label>
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-6">
                        <div class="row form-group">
                            <div class="col-md-9">
                                <input onpaste="return false;"  id="fiImportTimeFrom" class="form-control date-picker"
                                       data-date-format="dd/mm/yyyy" size="16"
                                       placeholder="<spring:message code="mard.14.TbdHoSo14.fiImportTimeFrom"/>"
                                       data-bind="value: moduleThongTinChung.tbdHoSo14.fiImportTimeFrom, dateInput, enable: !isView" autocomplete="off">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row form-group">
                            <label class="col-md-3"><spring:message code="mard.14.TbdHoSo14.fiImportTimeTo"/><span
                                    class="nsw-require-field">*</span></label>
                            <div class="col-md-9">
                                <input onpaste="return false;"  id="fiImportTimeTo" class="form-control date-picker"
                                       data-date-format="dd/mm/yyyy" size="16"
                                       placeholder="<spring:message code="mard.14.TbdHoSo14.fiImportTimeTo"/>"
                                       data-bind="value: moduleThongTinChung.tbdHoSo14.fiImportTimeTo, dateInput, enable: !isView" autocomplete="off">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


</div>