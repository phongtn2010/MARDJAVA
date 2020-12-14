<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mt.42.hoso.danhsachxe" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.stt" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.trongtai" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.mauson" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.nhanhieu" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.sokhung" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.somay" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.loaihang" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.thoigiandenghi1" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.thoigiandenghi2" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.tuyenduong" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.hanhtrinh" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.diemdung" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.thoigiandukien" /></th>
                        <th class="text-center"><spring:message code="mt.42.hoso.danhsachxe.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstXe">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td style="width: 220px">
                            <input class="form-control" name="fiBksXe" data-bind="value : fiBksXe" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control" name="fiSoGhe" data-bind="value : fiSoGhe" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control" name="fiMauSon" data-bind="value : fiMauSon" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaLoaixe" data-bind="value: fiMaNhanhieu,
                                attr: { id: 'fiMaNhanhieu-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoaiXe"></select>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control" name="fiSoKhung" data-bind="value : fiSoKhung" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control" name="fiSoMay" data-bind="value : fiSoMay" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control" name="fiLoaihang" data-bind="value : fiLoaihang" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control date-picker" id="fiDncpTuNg" name="fiDncpTuNg" data-bind="datepicker : fiDncpTuNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td style="width: 220px">
                            <input class="form-control date-picker" id="fiDncpDenNg" name="fiDncpDenNg" data-bind="datepicker : fiDncpDenNg" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaTuyen" data-bind="value: fiMaTuyen,
                                    attr: { id: 'fiMaTuyen-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstTuyen" style="width: 200px;"></select>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control" name="fiHanhtrinh" data-bind="value : fiHanhtrinh" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control" name="fiDiemDung" data-bind="value : fiDiemDung" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <input class="form-control date-picker" id="fiDkKhoihanh" name="fiDkKhoihanh" data-bind="datepicker : fiDkKhoihanh" type="text" data-date-format="dd/mm/yyyy" />
                        </td>
                        <td class="text-center">
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