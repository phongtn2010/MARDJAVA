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
                        <th class="text-center" style="width: 50px"><spring:message code="moh.01.tepdinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="moh.01.tepdinhkem.loaitep" /></th>                        
                        <th class="text-center" style="width: 150px"><spring:message code="moh.01.tepdinhkem.tailen" /></th>
                        <th class="text-center" style="width: 150px"><spring:message code="moh.01.tepdinhkem.chucnang" /></th>
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
                        <td class="text-center">
                            <a class="btn btn-info btn-xs" data-bind="visible: canUpload, click: doUpload">Đính kèm</a>
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiDuongDan}"></a>
                        </td>
                        <td class="text-center">
                            <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: fiDuongDan}"><i class="fa fa-download fa-lg" src="" alt=""/></a>
                            <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: canDelete, click: doDelete " src="" alt=""/></a>
                        </td>  
                    </tr>                      
                </script>
            </table>            
            <p style="color: red;"><b>Lưu ý : </b> </br>
                - Tệp đính kèm có định dạng PDF</br>
                - Dung lượng tối đa của mỗi file đính kèm: 15MB </br>
            </p>
            <div id="dialog" title="Hệ thống tải file môi trường y tế" style="display:none">
                <iframe frameborder="0" id='frame1' scrolling='no' width="500" height="250" /> 
                </iframe>
            </div>
        </div>
    </div>
</fieldset>

