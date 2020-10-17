<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mt.61.hoso.danhsachxe" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12" style="overflow-x: auto">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.61.hoso.danhsachxe.stt" /></th>
                        <th class="text-center"><spring:message code="mt.61.hoso.danhsachxe.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.61.hoso.danhsachxe.trongtai" /></th>
                        <th class="text-center"><spring:message code="mt.61.hoso.danhsachxe.thoigiandenghi1" /></th>
                        <th class="text-center"><spring:message code="mt.61.hoso.danhsachxe.thoigiandenghi2" /></th>
                        <th class="text-center"><spring:message code="mt.61.hoso.danhsachxe.hinhthuchoatdong" /></th>
                        <th class="text-center"><spring:message code="mt.61.hoso.danhsachxe.ckxn" /></th>
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
                        <td >
                            <select class="form-control select2 fiMaCkXn" style="width: max-content"disabled data-bind="value: fiMaCkXn,
                                    attr: { id: 'fiMaCkXn-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstCuaKhauXuatNhap"style="width: max-content" style="width: 200px;"></select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorXeMessage" style="color:red;"> </span>
            <br />
        </div>
    </div>
</fieldset>