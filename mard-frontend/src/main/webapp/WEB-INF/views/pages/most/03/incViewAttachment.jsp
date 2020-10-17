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
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstDinhkem10">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="w50 text-center"><spring:message code="most.03.dinhkem.stt" /></th>
                            <th class="w250 text-center"><spring:message code="most.03.dinhkem.loaitep" /></th>
                            <th class="w250 text-center"><spring:message code="most.03.dinhkem.tentep" /></th>
                            <th class="w250 text-center"><spring:message code="most.03.dinhkem.ngayguimau" /></th>
                            <th class="w250 text-center"><spring:message code="most.03.dinhkem.donvithunghiem" /></th>
                            <th class="w250 text-center"><spring:message code="most.03.dinhkem.ngaynhanketqua" /></th>
                            <th class="w250 text-center" style="width: 30px;">Tải về</th>
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
                            <td data-bind="text: fiTenTep"></td>
                            <td data-bind="text: fiNgayguiMauText"></td>
                            <td data-bind="text: fiDvThunghiem"></td>
                            <td data-bind="text: fiNgaynhanKqText"></td>
                            <td class="text-center" >
                                <a target="_blank" data-bind="visible: true, attr: { href: downloadUrl, title: fiTenTep }"><i class="fa fa-download" /></a>
                            </td>
                        </tr>                      
                    </script>
                </table>
                <span data-bind="text : errorDinhkemText" style="color:red;"> </span>
            </div>
        </div>
    </div>
</form>