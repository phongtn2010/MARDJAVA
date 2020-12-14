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
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.hoso.dinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.dinhkem.tentep" /></th>                        
                        <th class="text-center"><spring:message code="mt.hoso.dinhkem.tepdinhkem" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.dinhkem.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstGroupDinhKems">
                    <tr>
                        <td data-bind="text: $index() + 1"></td>  
                        <td>
                            <span data-bind="text : fiTenLoaiTep"></span>
                            <span data-bind="visible: isRequire" style="color: red">(*)</span>
                        </td> 
                        <td>
                            <a class="btn btn-info btn-xs" data-bind="visible: canUpload, click: doUpload">Đính kèm</a>
                            <table style="border: 0px !important">
                                <tbody data-bind="foreach: files">
                                    <td>
                                        <a target="_blank" data-bind="text: 'Tệp ' + ($index() + 1), attr: { href: Url}"></a>
                                    </td>
                                </tbody>
                            </table>                            
                        </td>
                        <td class="text-center">                            
                            <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: canDelete, click: doDelete " src="" alt=""></i></a>
                        </td>  
                    </tr>   
                </tbody>
            </table>
            <span data-bind="text : errorDinhKemMessage" style="color:red;"> </span>
            <p style="color: green;"><b>Lưu ý : </b> </br>
                - Tệp đính kèm có định dạng PDF</br>
                - Dung lượng tối đa của mỗi file đính kèm: 15MB </br>
            </p>
        </div>
    </div>
</fieldset>

