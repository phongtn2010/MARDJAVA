<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b>Phần VI: THÔNG TIN TỆP ĐÍNH KÈM</b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moit.05.hoso.dinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.dinhkem.tentep" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.dinhkem.tepdinhkem" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.dinhkem.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind=" foreach: $data.formVM().lstTeptin05">
                    <tr>
                        <td data-bind="text: $index() + 1">
                        </td>  
                        <td>
                            <span data-bind="text : fiTenTailieu"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td> 
                        <td>
                            <input class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" accept=".pdf,.jpg,.tif"/>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiDuongDan}"></a>
                        </td>
                        <td class="text-center" style="min-width: 100px !important">
                            <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: fiDuongDan}"><i class="fa fa-download fa-lg"></i></a>
                            <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: canDelete, click: doDelete " src="" alt=""></i></a>
                        </td>  
                    </tr>  
                </tbody>

            </table>
            <span style="color:red;">Chú ý: Định dạng file đính kèm: PDF, TIF, JPG </span><br />
            <span data-bind="text : $data.formVM().errorDinhKemMessage" style="color:red;"> </span>
        </div>
    </div>
</fieldset>