<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mic.02.hoso.dinhkem" /></b></legend>
    <div class="form-group">
        <div class="col-md-12" style="padding: 0px !important;">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" style="width: 100%;table-layout: fixed;">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 5%;"><spring:message code="mic.02.hoso.dinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="mic.02.hoso.dinhkem.tentep" /></th>
                        <th class="text-center"><spring:message code="mic.02.hoso.dinhkem.tepdinhkem" /></th>
                    </tr>
                </thead>
                <tbody data-bind=" foreach: $data.formVM().lstTeptin02">
                    <tr>
                        <td data-bind="text: $index() + 1" style=" width: 1%;vertical-align: middle; word-wrap: break-word;">
                        </td>  
                        <td style="vertical-align: middle;width: 30% !important;word-wrap: break-word;">
                            <span data-bind="text : fiTenDinhKem"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td> 
                        <td style=" width: 15%;word-wrap: break-word;word-wrap: break-word;">
                            <ul data-bind=" foreach: lstFiles" class="dk-nav">
                                <li>
                                    <a class="dk_css" target="_blank" data-bind="text: fiTenTepTin,click: $parent.doDownloadFileItem"></a>
                                </li>
                            </ul>
                        </td>
                    </tr>  
                </tbody>
                <style>
                    .dk-nav{float: left;width: 100%;margin: 0px;padding: 0px}
                    .dk-nav li{float: left;padding: 10px;list-style: none;max-width: 100% !important}
                    .dk_css:hover{cursor: pointer}
                </style>
            </table>
        </div>
    </div>
</fieldset>