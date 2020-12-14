<%-- 
    Document   : xemFileDinhKem
    Created on : Dec 1, 2019, 10:39:19 AM
    Author     : AnNguyen
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="monre09Files">
    <fieldset>
        <legend><spring:message code="monre.09.hoso.dinhkem" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 50px;"><spring:message code="monre.09.hoso.dinhkem.stt" /></th>
                            <th class="text-center"><spring:message code="monre.09.hoso.dinhkem.tentep" /></th>
                            <th class="text-center"><spring:message code="monre.09.hoso.dinhkem.tepdinhkem" /></th>
                            <th class="text-center" style="width: 150px;"><spring:message code="monre.09.hoso.dinhkem.chucnang" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'dinhKemTmpl', foreach: lstDinhKem9 }">
                    </tbody>
                    <script id="dinhKemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text: $index() + 1">
                            </td>  
                            <td data-bind="text : fiTenLoaiTep">
                            </td> 
                            <td>
                                <a target="_blank" data-bind="text: fiTenTep, attr: { href: viewUrl}"></a>
                            </td>
                            <td class="text-center">
                                <a target="_blank" href="javascript:void(0);" data-bind="visible: bView, attr: { href: viewUrl}"><i class="fa fa-lg fa-search" src="" alt=""/></a>
                            </td>
                        </tr>                      
                    </script>
                </table>
            </div>
        </div>
    </fieldset>
</form>