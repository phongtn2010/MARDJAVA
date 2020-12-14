<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="bca.01.hoso.dinhkem" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="bca.01.hoso.dinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="bca.01.hoso.dinhkem.tentep" /></th>
                        <th class="text-center"><spring:message code="bca.01.hoso.dinhkem.tepdinhkem" /></th>
                    </tr>
                </thead>
                <tbody data-bind=" foreach:  $data.formVM().lstDinhKem()">
                    <tr>
                        <td data-bind="text: $index() + 1">
                        </td>  
                        <td>
                            <span data-bind="text : fiTenTailieu"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td> 
                        <td>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: downloadUrl}"></a>
                        </td>
                    </tr>  
                </tbody>
                <!--                <script id="dinhKemTmpl" type="text/html">
                                                        
                                    </script>-->
            </table>
            <span data-bind="text : $data.formVM().errorDinhKemMessage;" style="color:red;"> </span>
        </div>
    </div>
</fieldset>