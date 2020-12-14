<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<table-view params="titles:  $root.titles, rows: $root.dataTable, totalElements:  $root.totalElements, pageClick:  $root.pageClick, currentPage:  $root.currentPage, pageSize: 10, pagingUI: true"></table-view>

<c:if test="${isView == false}">
    <div class="col-md-12" style="padding-top: 15px;" >
        <div class="row">
            <div class="col-md-2"><label  style="text-align: right" data-bind="i18n: {  html: { key: 'nhap_excel'}}"></label></div>
            <div class="col-md-10">
                <input  ${ isView ? " disabled " : ""}  id="fileUploadExcel" type="file" class="form-group form-control"
                                                        data-bind=" event:{ change: $root.uploadFileExcelChangeEvent }">
                <a style="font-style: italic;"
                   href="<c:url value="/mic/api/03/downloadTemplate/excel" />"
                   data-bind="i18n: { title: { key: 'mau_excel'}}"><i class="fa fa-download" aria-hidden="true"></i>&nbsp;<span data-bind="i18n: {  html: { key: 'mau_excel'}}"></span></a>
            </div>
        </div>
    </div>

</c:if>