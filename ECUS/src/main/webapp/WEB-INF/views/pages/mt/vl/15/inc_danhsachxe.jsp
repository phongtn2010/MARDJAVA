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
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.xengung" /></th>
                        <th class="text-center"><spring:message code="mt.hoso.danhsachxe.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstXe">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td>
                            <input class="form-control" name="fiBksXe" data-bind="value : fiBksXe" maxlength="250"></input>
                        </td> 
                        <td>
                            <input class="form-control" name="fiTenChuxe" data-bind="value : fiTenChuxe" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2" data-bind="value: fiMaLoaixe,
                                attr: { id: 'fiMaLoaixe-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoaiXe"></select>
                        </td>
                        <td>
                            <input class="form-control" name="fiSoGhe" data-bind="value : fiSoGhe" maxlength="250"></input>
                        </td>
                        <td>
                            <input class="form-control" name="fiNamSx" data-bind="value : fiNamSx" maxlength="250"></input>
                        </td>
                        <td style="width: 220px">
                            <select class="form-control select2" data-bind="value: fiMaCkXn,
                                    attr: { id: 'fiMaCkXn-' + fiStt() },
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : $parent.lstCuaKhauXuatNhap" style="width: 200px;"></select>
                        </td>
                        <td>
                            <input class="form-control" name="fiBksXeKoHd" data-bind="value : fiBksXeKoHd" maxlength="50"></input>
                        </td>
                        <td class="text-center">
                            <a class="btn red bt-center" data-bind="click: $parent.removeCarOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorXeMessage" style="color:red;"> </span>
            <a class="btn green bt-center" data-bind="click: addCarOnClick"><i class="fa fa-add fa-lg"></i> Thêm xe</a>
        </div>
    </div>
</fieldset>