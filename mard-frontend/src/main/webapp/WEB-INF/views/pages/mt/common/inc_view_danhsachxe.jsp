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
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstXe">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td>
                            <input class="form-control" name="fiBksXe" readonly="readonly" data-bind="value : fiBksXe" maxlength="250"/>
                        </td> 
                        <td>
                            <input class="form-control" name="fiTenChuxe" readonly="readonly" data-bind="value : fiTenChuxe" maxlength="250"/>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2" disabled data-bind="value: fiMaLoaixe,
                                attr: { id: 'fiMaLoaixe-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoaiXe"></select>
                        </td>
                        <td>
                            <input class="form-control" name="fiSoGhe" readonly="readonly" data-bind="value : fiSoGhe" maxlength="250"/>
                        </td>
                        <td>
                            <input class="form-control" name="fiNamSx" readonly="readonly" data-bind="value : fiNamSx" maxlength="250"/>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2" disabled data-bind="value: fiMaCkXn,
                                    attr: { id: 'fiMaCkXn-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstCuaKhauXuatNhap" style="width: 200px;"></select>
                        </td>                        
                    </tr>
                </tbody>
            </table>        
            <span data-bind="text : errorXeMessage" style="color:red;"> </span>         
        </div>
    </div>
</fieldset>