<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 50px"><spring:message code="moh.07.tepdinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="moh.07.tepdinhkem.loaitep" /></th>                        
                        <th class="text-center"><spring:message code="moh.07.tepdinhkem.tailen" /></th>
                        <th class="text-center" style="width: 150px"><spring:message code="moh.07.tepdinhkem.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="template: { name: 'dinhKemTmpl', foreach: lstDinhKems }">
                </tbody>
                <script id="dinhKemTmpl" type="text/html">
                    <tr>
                        <td data-bind="text: $index() + 1"></td>  
                        <td>
                            <span data-bind="text : fiTenLoaiTep"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td> 
                        <td class="text-left">
                            <a class="btn btn-info btn-xs" data-bind="visible: canUpload, click: doUpload">Đính kèm</a>
                            <table style="border: 0px !important; width: 100%; ">
                                <tbody data-bind="foreach: files">
                                    <td class="text-left">
                                        <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiDuongDan}"></a>
                                    </td>
                                </tbody>
                            </table>
                        </td>
                        <td class="text-center">
                            <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: fiDuongDan}"><i class="fa fa-download fa-lg" src="" alt=""/></a>
                        </td>  
                    </tr>                      
                </script>
            </table>            
        </div>
    </div>
</fieldset>

