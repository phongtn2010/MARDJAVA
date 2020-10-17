<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mt.hoso.danhsachxe" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.stt" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.nguoisohuu" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.loaixe" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.trongtai" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.namsanxuat" /></th>
                        <th class="text-center" style="max-width: 200px;"><spring:message code="mt.hoso.danhsachxe.cuakhau" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstXe">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td>
                            <input class="form-control" readonly name="fiBksXe" data-bind="value : fiBksXe" maxlength="250"/>
                        </td> 
                        <td>
                            <input class="form-control" readonly name="fiTenChuxe" data-bind="value : fiTenChuxe" maxlength="250"/>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaLoaixe" disabled data-bind="value: fiMaLoaixe,
                                attr: { id: 'fiMaLoaixe-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoaiXe"></select>
                        </td>
                        <td>
                            <input class="form-control" readonly name="fiSoGhe" data-bind="value : fiSoGhe" maxlength="250"/>
                        </td>
                        <td>
                            <input class="form-control" readonly name="fiNamSx" data-bind="value : fiNamSx" maxlength="250"/>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaCkXn" disabled data-bind="value: fiMaCkXn,
                                    attr: { id: 'fiMaCkXn-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstCuaKhauXuatNhap" style="width: 100%;"></select>
                        </td>
                        <td style="width: 220px" class="text-center">                            
                            <a class="btn green bt-center" data-bind="click: $parent.editCarOnClick.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                            <a class="btn red bt-center" data-bind="click: $parent.removeCarOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorXeMessage" style="color:red;"> </span>
            <br />
            <a class="btn green bt-center" data-bind="click: addCarOnClick"><i class="fa fa-add fa-lg"></i> Thêm xe</a>
        </div>        
    </div>   
    <%--<%@include file="inc_popup_danhsachxe.jsp" %>--%>
</fieldset>
<template id="thongtinxe-template">
    <div class="row" id="thongtinxe-vm">
        <div class="col-md-12">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.hoso.danhsachxe.biensoxe" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiBksXe" id="fiBksXe-New" name="fiBksXe" data-bind="optionsCaption: 'Chọn...', 
                                    optionsValue : 'fiIdXe', 
                                    value : fiId, options : lstXe, 
                                    optionsText : 'fiBksXe',
                                    event: {change: getDetailXe}"></select>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.hoso.danhsachxe.trongtai" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiSoGhe" name="fiSoGhe" maxlength="255"  
                                   type="text" data-bind="value : fiSoGhe" readonly="readonly"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.hoso.danhsachxe.nguoisohuu" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiTenChuxe" name="fiTenChuxe" maxlength="255"  
                                   type="text" data-bind="value : fiTenChuxe" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.hoso.danhsachxe.namsanxuat" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiNamSx" name="fiNamSx" maxlength="255"  
                                   type="text" data-bind="value : fiNamSx" readonly="readonly"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.hoso.danhsachxe.cuakhau" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiMaCkXn" id="fiMaCkXn-New" name="fiMaCkXn" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCkXn, value : fiMaCkXn, options : lstCuaKhauXuatNhap, optionsText : 'name'"></select>
                            
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.hoso.danhsachxe.loaixe" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4"> 
                            <select class="form-control select2 fiMaLoaixe" id="fiMaLoaixe-New" name="fiMaLoaixe" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenLoaixe, value : fiMaLoaixe, options : lstLoaiXe, optionsText : 'name'"></select>
                            
                        </div>
                    </div>  
                </div>
            </form>
        </div>
    </div>
</template>                    