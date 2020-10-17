<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mt.36.hoso.danhsachxe" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.36.hoso.danhsachxe.stt" /></th>
                        <th class="text-center"><spring:message code="mt.36.hoso.danhsachxe.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.36.hoso.danhsachxe.trongtai" /></th>
                        <th class="text-center"><spring:message code="mt.36.hoso.danhsachxe.nhanhieu" /></th>
                        <th class="text-center"><spring:message code="mt.36.hoso.danhsachxe.thoigiandenghi1" /></th>
                        <th class="text-center"><spring:message code="mt.36.hoso.danhsachxe.thoigiandenghi2" /></th>
                        <th class="text-center" style="max-width: 200px;"><spring:message code="mt.36.hoso.danhsachxe.cuakhau" /></th>
                        <th class="text-center" style="max-width: 200px;"><spring:message code="mt.36.hoso.danhsachxe.tuyenduong" /></th>
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
                            <input class="form-control" readonly name="fiSoGhe" data-bind="value : fiSoGhe" maxlength="250"/>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaNhanhieu" disabled data-bind="value: fiMaNhanhieu,
                                attr: { id: 'fiMaNhanhieu-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoaiXe"></select>
                        </td>
                        <td>
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly id="fiDncpTuNg" name="fiDncpTuNg" data-bind="datepicker : fiDncpTuNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td>
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly id="fiDncpDenNg" name="fiDncpDenNg" data-bind="datepicker : fiDncpDenNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaCkXn" disabled data-bind="value: fiMaCkXn,
                                    attr: { id: 'fiMaCkXn-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstCuaKhauXuatNhap" style="width: 200px;"></select>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaTuyen" disabled data-bind="value: fiMaTuyen,
                                    attr: { id: 'fiMaTuyen-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstTuyen" style="width: 200px;"></select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorXeMessage" style="color:red;"> </span>
        </div>
    </div>
</fieldset>