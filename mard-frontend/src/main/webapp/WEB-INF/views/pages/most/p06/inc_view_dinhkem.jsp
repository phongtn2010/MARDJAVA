<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="most.06.hoso.teptin" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moit.05.hoso.dinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.dinhkem.tentep" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.dinhkem.tepdinhkem" /></th>
                    </tr>
                </thead>
                <tbody data-bind=" foreach: lstTbdhsTeptin06">
                    <tr>
                        <td data-bind="text: $index() + 1">
                        </td>  
                        <td>
                            <span data-bind="text : fiTenTailieu"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td> 
                        <td>
                            <input disabled class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" accept=".pdf,.jpg,.tif"/>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiDuongDan}"></a>
                        </td>
                    </tr>  
                </tbody>

            </table>
            <span data-bind="text : errorDinhKemMessage" style="color:red;"> </span>
        </div>
    </div>
</fieldset>