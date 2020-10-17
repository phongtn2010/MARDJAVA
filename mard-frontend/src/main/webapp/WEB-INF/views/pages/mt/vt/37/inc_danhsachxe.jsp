<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mt.37.hoso.danhsachxe" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12" style="overflow-x: auto">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.stt" /></th>
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.trongtai" /></th>
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.nhanhieu" /></th>
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.thoigiandenghi1" /></th>
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.thoigiandenghi2" /></th>
                        <th class="text-center" style="max-width: 200px;"><spring:message code="mt.37.hoso.danhsachxe.hinhthuchoatdong" /></th>
                        <th class="text-center" style="max-width: 200px;"><spring:message code="mt.37.hoso.danhsachxe.tuyenduong" /></th>
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.diemdung" /></th>
                        <th class="text-center"><spring:message code="mt.37.hoso.danhsachxe.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstXe">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td>
                            <input class="form-control" style="width: max-content" name="fiBksXe" data-bind="value : fiBksXe" maxlength="250" readonly/>
                        </td>
                        <td>
                            <input class="form-control" style="width: max-content" name="fiSoGhe" data-bind="value : fiSoGhe" maxlength="250" readonly/>
                        </td>
                        <td >
                            <select class="form-control select2 fiMaLoaixe" style="width: max-content" disabled data-bind="value: fiMaNhanhieu,
                                attr: { id: 'fiMaNhanhieu-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoaiXe"></select>
                        </td>
                        <td>
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy" style="width: max-content" disabled id="fiDncpTuNg" name="fiDncpTuNg" data-bind="datepicker : fiDncpTuNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td>
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy"style="width: max-content" disabled id="fiDncpDenNg" name="fiDncpDenNg" data-bind="datepicker : fiDncpDenNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td style="width: 150px">
                            <select class="form-control select2 fiHinhthuc"style="width: max-content" disabled data-bind="value: fiHinhthuc,
                                    attr: { id: 'fiHinhthuc-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstHinhThuc" style="width: 200px;"></select>
                        </td>
                        <td style="width: 150px">
                            <select class="form-control select2 fiMaTuyen" style="width: min-content"disabled data-bind="value: fiMaTuyen,
                                    attr: { id: 'fiMaTuyen-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    selectedText2:fiTenTuyen,
                                    options : $parent.lstTuyen" ></select>
                        </td>
                        <td>
                            <input class="form-control" style="width: max-content" name="fiDiemDung" data-bind="value : fiDiemDung" maxlength="250" readonly/>
                        </td>
                        <td style="min-width: 220px"  class="text-center">
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
</fieldset>
<template id="thongtinxe-template">
    <div class="row" id="thongtinxe-vm">
        <div class="col-md-12">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.biensoxe" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiBksXe" id="fiBksXe-New" name="fiBksXe" data-bind="optionsCaption: 'Chọn...', 
                                    optionsValue : 'fiIdXe', 
                                    value : fiId, options : lstXe, 
                                    optionsText : 'fiBksXe',
                                    event: {change: getDetailXe}"></select>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.nhanhieu" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiTenHieu" name="fiTenHieu" maxlength="255"  
                                   type="text" data-bind="value : fiTenHieu" readonly="readonly"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.trongtai" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiSoGhe" name="fiSoGhe" maxlength="255"  
                                   type="text" data-bind="value : fiSoGhe" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.hinhthuchoatdong" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <select class="form-control select2 fiHinhthuc" id="fiHinhthuc-New" name="fiHinhthuc" data-bind=" value : fiHinhthuc,
                                    optionsCaption: '...Chọn...', 
                                    optionsValue : 'id', 
                                    options : lstHinhThuc, 
                                    optionsText : 'name'"></select>   
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.thoigiandenghi1" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiDncpTuNg" name="fiDncpTuNg" data-bind="datepicker : fiDncpTuNg" type="text" data-date-format="dd/mm/yyyy" />
                        </div>                                          
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.thoigiandenghi2" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiDncpDenNg" name="fiDncpDenNg" data-bind="datepicker : fiDncpDenNg" type="text" data-date-format="dd/mm/yyyy" />
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.tuyenduong" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <select class="form-control select2 fiMaTuyen" id="fiMaTuyen-New" name="fiMaTuyen" data-bind="optionsCaption: '...Chọn...', 
                                    optionsValue : 'id', 
                                    value : fiMaTuyen, options : lstTuyen, 
                                    optionsText : 'name'"></select>              
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.37.hoso.danhsachxe.diemdung" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" name="fiDiemDung" data-bind="value : fiDiemDung" maxlength="250"/>

                        </div>
                    </div>  
                </div>
            </form>
        </div>
    </div>
</template>