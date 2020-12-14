<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend style="color: dodgerblue;">
        <b><spring:message code="moh.02.hoso.thongtindinhkem"/></b>
    </legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column"
                   style="margin-bottom: 5px !important;">
                <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center" style="width: 1%;vertical-align: middle;"><spring:message
                            code="moh.02.hoso.thongtindinhkem.stt"/></th>
                    <th class="text-center" style="width: 30%;vertical-align: middle;"><spring:message
                            code="moh.02.hoso.thongtindinhkem.tentep"/></th>
                    <th class="text-center" style="width: 15%;vertical-align: middle;"><spring:message
                            code="moh.02.hoso.thongtindinhkem.chontep"/></th>
                </tr>
                </thead>
                <tbody data-bind="template: { name: 'dinhKemTmpl', foreach: tbdDinhkem02List }">
                </tbody>
                <script id="dinhKemTmpl" type="text/html">
                    <tr>
                        <td style=" vertical-align: middle;word-wrap: break-word;" data-bind="text: $index() + 1">
                        </td>
                        <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 200px !important;">
                            <span data-bind="text : fiTenLoaiTl"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td>
                        <td style="width: 240px;text-align: left;word-wrap: break-word;max-width: 240px !important;vertical-align: middle;">
                            <ul data-bind=" foreach: lstFiles" class="dk-nav">
                                <li>
                                    <a class="dk_css" target="_blank"
                                       data-bind="text: fiTenTailieu, click: $parent.doDownloadFileItem"></a>
                                    <b>
                                        <span data-bind="text: fiSize"></span>
                                        <span data-bind="if: fiSize">(MB)</span>
                                    </b>
                                </li>
                            </ul>
                        </td>
                    </tr>
                </script>
            </table>
        </div>
    </div>
</fieldset>
