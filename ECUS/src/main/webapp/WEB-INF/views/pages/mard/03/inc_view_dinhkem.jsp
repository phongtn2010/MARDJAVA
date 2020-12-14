<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <div class="form-group">
        <div class="col-md-12" >
            <table class="table table-striped table-bordered table-hover table-checkable order-column" style="margin-bottom: 5px !important;">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 1%"><spring:message code="mard.03.hoso.dinhkem.stt" /></th>
                        <th class="text-center"><spring:message code="mard.03.hoso.dinhkem.tentep" /></th>
                        <th class="text-center" style="width: 40%"><spring:message code="mard.03.hoso.dinhkem.tepdinhkem" /></th>
                        <th class="text-center" style="width: 5%"><spring:message code="mard.03.hoso.dinhkem.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind=" foreach: lstTepTin03">
                    <tr>
                        <td data-bind="text: $index() + 1" style=" width: 1%;vertical-align: middle;">
                        </td>  
                        <td>
                            <span data-bind="text : fileName"></span>
                            <span data-bind="visible: isRequired" style="color: red">(*)</span>
                        </td>
                        <td>
                            <input class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" accept=".pdf,.jpg,.tif"/>
                            <a target="_blank" data-bind="text: fileNameUpload, attr: { href: linkfile}"></a>
                        </td>
                        <td class="text-center">
                            <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: linkfile}"><i class="fa fa-download fa-lg"></i></a>
                        </td>
                         
                    </tr>  
                </tbody>
                <style>
                    /*.dk_css{display: inline !important;padding: 10px 0px !important;}*/
                    .dk-nav{float: left;width: 100%;margin: 0px;padding: 0px}
                    .dk-nav li{float: left;padding: 10px;list-style: none;}
                    .dk_css:hover{cursor: pointer}
                </style>
            </table>
        </div>
    </div>
</fieldset>