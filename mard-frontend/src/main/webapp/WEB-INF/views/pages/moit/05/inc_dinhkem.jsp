<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="moit.05.hoso.dinhkem" /></b></legend>
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
                <tbody data-bind="template: { name: 'dinhKemTmpl', foreach: lstDinhkems }">
                </tbody>
                <script id="dinhKemTmpl" type="text/html">
                    <tr>
                        <td data-bind="text: $index() + 1">
                        </td>  
                        <td>
                            <span data-bind="text : fiTenLoaiTl"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td> 
                        <td>
                            <input class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" accept=".pdf,.jpg,.tif"/>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: downloadUrl}"></a>
                        </td>
                        <td class="text-center">
                            <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: downloadUrl}"><i class="fa fa-download fa-lg" src="" alt=""/></a>
                            <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: canDelete, click: doDelete " src="" alt=""/></a>
                        </td>  
                    </tr>                      
                    </script>
                </table>
                <span data-bind="text : errorDinhKemMessage" style="color:red;"> </span>
                <p style="color: red;"><b>Lưu ý : </b> </br>
                    - Tệp đính kèm có dung lượng nhỏ hơn 1MB và có định dạng JPG, PDF, TIF </br>
                    - Tổng dung lượng các file đính kèm nhỏ hơn 3MB </br>
                    - Tên file đính kèm không chứa ký tự có dấu. Ví dụ: dinhkem.jpg,dinhkem.tif,dinhkem.pdf,...
                </p>
            </div>
        </div>
    </fieldset>