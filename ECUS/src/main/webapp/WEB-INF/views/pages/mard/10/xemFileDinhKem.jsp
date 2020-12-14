<%-- 
    Document   : xemFileDinhKem
    Created on : Aug 1, 2017, 10:37:19 AM
    Author     : hieptran
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal">
    <fieldset>
        <legend>Danh sách tài liệu</legend> 
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstDinhkem10">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th>STT</th>
                            <th class="text-center">Loại file đính kèm</th>
                            <th class="text-center">Tên file đính kèm</th>
                            <th class="text-center" style="width: 30px;">Xem</th>
                            <th class="text-center" style="width: 30px;">Tải về</th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'lstDinhkem10Tmpl', foreach: lstDinhkem10 }">
                    </tbody>
                    <script id="lstDinhkem10Tmpl" type="text/html">
                        <tr>
                            <td data-bind="text: STT">
                            </td>  
                            <td data-bind="text: fiTenLoai">
                            </td> 
                            <td data-bind="text: fiTenTep">
                            </td>
                            <td class="text-center" style="width: 30px">
                                <a target="_blank" data-bind="visible: true, attr: { href: viewUrl, title: fiTenTep }"><i class="fa fa-eye"/></a>
                            </td>                                  
                            <td class="text-center" style="width: 30px">
                                <a target="_blank" data-bind="visible: true, attr: { href: downloadUrl, title: fiTenTep }"><i class="fa fa-download" /></a>
                            </td>
                        </tr>                      
                    </script>
                </table>
            </div>
        </div>
    </fieldset>
</form>