<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <div class="form-group">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject bold uppercase">
                        <label><spring:message code="mard.hoso.thongtinhopdonghoadonphieudonggoi" /> </label>
                    </span>
                    <button
                            class="btn green"
                            title=""
                            data-bind="click: onAdd, visible: $root.isEnableEdit"
                            ><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" width="5%"><spring:message code="mard.hoso.documents.stt" /></th>
                        <th class="text-center" width="30%"><spring:message code="mard.hoso.documents.loaigiayto" /></th>
                        <th class="text-center" width="30%"><spring:message code="mard.hoso.documents.sogiayto" /></th>
                        <th class="text-center" width="25%"><spring:message code="mard.hoso.documents.ngaycap" /></th>
                        <th class="text-center" width="10%" data-bind="visible: $root.isEnableEdit"><spring:message code="mard.hoso.documents.chucnang" /></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstDocuments">
                        <td data-bind="text: $index() + 1"></td>
                        <td>
                            <select
                                    class="form-control select2"
                                    data-bind="value : typeId,
                                        options : documentTypes,
                                        optionsValue : 'id',
                                        optionsCaption: 'Chọn...',
                                        optionsText : 'name', enable: $root.isEnableEdit">
                            </select>
                        </td>
                        <td>
                            <input class="form-control" maxlength="50" type="text" data-bind="value: number, enable: $root.isEnableEdit"/>
                        </td>
                        <td>
                            <input class="form-control" maxlength="255" type="text" data-date-format="dd/mm/yyyy" data-bind="datepicker: date, enable: $root.isEnableEdit"/>
                        </td>
                        <td style="text-align: center" data-bind="visible: $root.isEnableEdit">
                            <a class="btn red bt-center" data-bind="click: function(){$parent.onRemove($index())}">
                                <i class="fa fa-trash"></i> Xoá
                            </a>
                        </td>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</fieldset>
