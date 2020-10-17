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
                        <th class="text-center"><spring:message code="bca.01.hoso.dinhkem.chucnang" /></th>
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
                            <input class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" accept=".pdf,.jpg,.tif"/>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: downloadUrl}"></a>
                        </td>
                        <td class="text-center">
                            <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: downloadUrl}"><i class="fa fa-add fa-lg"></i></a>
                            <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: canDelete, click: doDelete " src="" alt=""/>
                        </td>  
                    </tr>  
                </tbody>
                <!--                <script id="dinhKemTmpl" type="text/html">
                                                        
                                    </script>-->
            </table>
            <span id="errorDKMessage"   style="color:red;display: none">* Cần bổ sung thêm file đính kèm!</span>

            <p style="color: red;"><b>Lưu ý : </b> </br>
                - Tổng dung lượng các file đính kèm nhỏ hơn 2MB </br>
                - Tên file đính kèm không chứa ký tự có dấu. Ví dụ: dinhkem.jpg,dinhkem.pdf,dinhkem.tif....
            </p>
        </div>
    </div>
</fieldset>