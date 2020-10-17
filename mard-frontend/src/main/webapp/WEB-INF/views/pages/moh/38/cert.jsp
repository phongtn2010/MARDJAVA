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
            <table class="table table-striped table-bordered table-hover table-checkable order-column">                
                <tbody data-bind="template: { name: 'dinhKemTmpl', foreach: lstDinhKems }">
                </tbody>
                <script id="dinhKemTmpl" type="text/html">
                    <tr>
                        <td>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiDuongDan}"></a>
                        </td>
                        <td class="text-center">
                            <a target="_blank" href="javascript:void(0);" data-bind="attr: { href: fiDuongDan}"><i class="fa fa-download fa-lg" src="" alt=""/></a>
                        </td>  
                    </tr>                      
                </script>
            </table>                
        </div>
    </div>
</fieldset>