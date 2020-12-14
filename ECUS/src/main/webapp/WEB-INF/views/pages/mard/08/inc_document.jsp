<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset data-bind="with: documentsVM">
    <legend><b><spring:message code="mard.08.thongtinhopdonghoadonphieudonggoi"/></b>
        <a href="javascript:void(0)" style="margin-left: 10px"
           class="btn green"
           title="<spring:message code="mard.08.button.them_moi"/>"
           data-bind="click: onAdd, visible: $root.isEditable()"
        ><i class="fa fa-plus btn-plus"></i></a>
    </legend>
    <form role="form" class="form-horizontal">
        <div class="form-group">
            <div class="col-md-12">
                <span class="nsw-require-field" data-bind="validationMessage: lstDocuments"></span>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" width="5%"><spring:message code="mard.08.documents.stt"/></th>
                        <th class="text-center" width="30%"><spring:message code="mard.08.documents.loaigiayto"/></th>
                        <th class="text-center" width="30%"><spring:message code="mard.08.documents.sogiayto"/></th>
                        <th class="text-center" width="25%"><spring:message code="mard.08.documents.ngaycap"/></th>
                        <th data-bind="visible: $root.isEditable()" class="text-center" width="10%"><spring:message code="mard.08.documents.chucnang"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstDocuments">
                    <td data-bind="text: $index() + 1"></td>
                    <td>
                        <select
                                class="form-control select2"
                                data-bind="value : fiTypeDoc,
                                        options : documentTypes,
                                        optionsValue : 'id',
                                        optionsCaption: 'Chọn...',
                                        optionsText : 'name', enable: $root.isEditable()">
                        </select>
                    </td>
                    <td>
                        <input class="form-control" maxlength="255" type="text"
                               data-bind="value: fiNumber, enable: $root.isEditable()"/>
                    </td>
                    <td>
                        <input class="form-control"
                               data-bind="datepicker : fiDate, enable: $root.isEditable()"
                               class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value=""
                               maxlength="10"/>
                    </td>
                    <td data-bind="visible: $root.isEditable()" style="text-align: center">
                        <a class="btn red bt-center"
                           data-bind="click: function(){$parent.onRemove($index())}, visible: $root.isEditable()">
                            <i class="fa fa-trash"></i> Xoá
                        </a>
                    </td>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</fieldset>
