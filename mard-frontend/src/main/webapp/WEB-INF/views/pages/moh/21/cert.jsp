<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="moh.hoso.dinhkem" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table style="border: 0">                
                <tbody data-bind="template: { name: 'resultAttachTmpl', foreach: lstDinhKems }">
                </tbody>
                <script id="resultAttachTmpl" type="text/html">
                    <tr>
                        <td>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: downloadUrl}"></a>
                        </td>
                        <td class="text-center">
                            <a target="_blank" href="javascript:void(0);" data-bind="attr: { href: downloadUrl}"><i class="fa fa-download fa-lg" src="" alt=""/></a>
                        </td>  
                    </tr>                      
                </script>
            </table>                
        </div>
    </div>
</fieldset>