<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset style="margin-top: 15px">
    <legend>
        <b style="color: dodgerblue;"><spring:message code="moh.03.hoso.thongtincuakhau"/></b>
    </legend>
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstCuakhau">
        <thead>
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center" style="width: 1%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtincuakhau.stt"/></th>
            <th class="text-center" style="width: 50%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtincuakhau.tencuakhau"/></th>
            <th class="text-center" style="width: 20%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtincuakhau.macuakhau"/></th>
        </tr>
        </thead>
        <tbody data-bind="foreach: lstCuakhau03">
        <tr>
            <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%"></td>
            <td>
                <select class="form-control select2 fiMaCuakhau" data-bind="
                                                                        value: fiMaCuakhau,
                                                                        selectedText2 : fiTenCuakhau,
                                                                        attr: {'id': 'fiMaCuakhau-' + fiIdCuakhau()},
                                                                        optionsCaption: 'Chọn...',
                                                                        optionsValue : 'id',
                                                                        optionsText : 'name',
                                                                        options : $parent.lstDmCuakhau()" disabled></select>
            </td>
            <td data-bind="text : fiMaCuakhau"></td>
        </tr>
        </tbody>
    </table>
</fieldset>