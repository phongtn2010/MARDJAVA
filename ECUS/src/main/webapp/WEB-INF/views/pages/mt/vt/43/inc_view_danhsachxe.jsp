<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mt.43.hoso.danhsachxe" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12" style="overflow-x: auto">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.stt" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.trongtai" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.mauson" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.nhanhieu" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.sokhung" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.somay" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.loaihang" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.thoigiandenghi1" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.thoigiandenghi2" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.tuyenduong" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.hanhtrinh" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.diemdung" /></th>
                        <th class="text-center"><spring:message code="mt.43.hoso.danhsachxe.thoigiandukien" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstXe">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td>
                            <input class="form-control"  style="width: max-content" name="fiBksXe" data-bind="value : fiBksXe" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <input class="form-control"style="width: max-content" name="fiSoGhe" data-bind="value : fiSoGhe" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <input class="form-control"style="width: max-content"name="fiMauSon" data-bind="value : fiMauSon" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <select class="form-control select2 fiMaLoaixe"style="width: max-content" disabled data-bind="value: fiMaNhanhieu,
                                attr: { id: 'fiMaNhanhieu-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoaiXe"></select>
                        </td>
                        <td>
                            <input class="form-control"style="width: max-content" name="fiSoKhung" data-bind="value : fiSoKhung" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <input class="form-control"style="width: max-content" name="fiSoMay" data-bind="value : fiSoMay" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <input class="form-control"style="width: max-content" name="fiLoaihang" data-bind="value : fiLoaihang" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy"style="width: max-content" disabled id="fiDncpTuNg" name="fiDncpTuNg" data-bind="datepicker : fiDncpTuNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td>
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy"style="width: max-content" disabled id="fiDncpDenNg" name="fiDncpDenNg" data-bind="datepicker : fiDncpDenNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td>
                            <select class="form-control select2 fiMaTuyen"style="width: max-content" disabled data-bind="value: fiMaTuyen,
                                    attr: { id: 'fiMaTuyen-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstTuyen" ></select>
                        </td>
                        <td>
                            <input class="form-control"style="width: max-content" name="fiHanhtrinh" data-bind="value : fiHanhtrinh" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <input class="form-control"style="width: max-content" name="fiDiemDung" data-bind="value : fiDiemDung" maxlength="250" readonly></input>
                        </td>
                        <td>
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy"style="width: max-content" disabled id="fiDkKhoihanh" name="fiDkKhoihanh" data-bind="datepicker : fiDkKhoihanh" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorXeMessage" style="color:red;"> </span>
        </div>
    </div>
</fieldset>