<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="Most03Files">
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.dinhkem.dinhkem" /></b>
        <hr/>
    </div>
    <div class="row-border">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dinhkem.loaitep" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control" data-bind="optionsCaption: 'Chọn...', 
                        options: lstLoaiFile,
                        optionsText : 'name',
                        optionsValue : 'id',
                        selectedText : fiTenLoai,
                        value: fiMaLoai"></select>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="file.import.chon_file" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input id="fiTep" class="form-control" type="file" data-bind="event: {change: fileUpload}"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    
                </div>
                <div class="col-md-4">
                    
                </div>
                <div class="col-md-2">
                    <a href="javascript:void(0);" class="btn green" id="upload" data-bind="click: uploadClick"><i class="fa fa-upload"></i> Tải lên</a>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstDinhkem10">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="w50 text-center"><spring:message code="most.03.dinhkem.stt" /></th>
                            <th class="w250 text-center"><spring:message code="most.03.dinhkem.loaitep" /></th>
                            <th><spring:message code="most.03.dinhkem.tentep" /></th>
                            <th class="w250 text-center" style="width: 30px;">Tải về</th>
                            <th class="w100 text-center" style="width: 30px;">Xóa</th>
                        </tr>
                    </thead>
                    <tbody id="file-container" data-bind="template: { name: 'dinhkemTmpl', foreach: tepDinhKems }">
                    </tbody>
                    <script id="dinhkemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text: $index() + 1">
                            </td>  
                            <td data-bind="text: fiTenLoai">
                            </td> 
                            <td data-bind="text: fiTenTep">
                            </td>
                            <td class="text-center" >
                                <a target="_blank" data-bind="visible: true, attr: { href: downloadUrl, title: fiTenTep }"><i class="fa fa-download fa-lg" /></a>
                            </td>
                            <td class="text-center" >
                                <a href="javascript:void(0);"><i class="fa fa-remove fa-lg" data-bind="visible: bXoa, click: $parent.bXoaClick.bind($parent)"/></a>
                            </td>  
                        </tr>                      
                    </script>
                </table>
                <span data-bind="text : errorDinhkemText" style="color:red;"> </span>
            </div>
        </div>
    </div>
</form>