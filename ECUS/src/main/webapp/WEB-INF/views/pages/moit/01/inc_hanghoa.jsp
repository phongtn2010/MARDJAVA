<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="moit.01.hoso.thongtinhanghoa" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moit.01.hoso.thongtinhanghoa.stt" /></th>
                        <th class="text-center"><spring:message code="moit.01.hoso.thongtinhanghoa.mahs" /></th>
                        <th class="text-center"><spring:message code="moit.01.hoso.thongtinhanghoa.motahanghoa" /></th>
                        <th class="text-center"><spring:message code="moit.01.hoso.thongtinhanghoa.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHanghoas">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaHs" data-bind="value: fiMaHs,
                                attr: { id: 'fiMaHs-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'id', 
                                options : $parent.lstMaHS"></select>
                        </td>
                        <td>
                            <input class="form-control" name="fiTenHh" data-bind="value : fiTenHh" maxlength="2000"/>
                        </td>
                        <td class="text-center">
                            <a class="btn red bt-center" data-bind="click: $parent.removeHangHoaOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHHMessage" style="color:red;"> </span>
            <br />
            <a class="btn green bt-center" data-bind="click: addHangHoaOnClick"><i class="fa fa-add fa-lg"></i> Thêm Hàng hoá</a>
        </div>
    </div>
</fieldset>