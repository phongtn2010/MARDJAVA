<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset data-bind="visible: isFirstGroup">
    <legend><b><spring:message code="moh.19.nguyenlieu" /></b><a class="nsw-require-field">*</a></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moh.19.nguyenlieu.stt" /></th>
                        <th class="text-center"><spring:message code="moh.19.nguyenlieu.tennguyenlieu" /></th>
                        <th class="text-center"><spring:message code="moh.19.nguyenlieu.loainguyenlieu" /></th>
                        <th class="text-center"><spring:message code="moh.19.nguyenlieu.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstNguyenLieus">
                    <tr>
                        <td data-bind="text : fiStt"></td>  
                        <td>
                            <select class="form-control select2 fiMaNglieu" data-bind="value: fiMaNglieu,
                                attr: { id: 'fiMaNglieu-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstNguyenLieu,
                                event : {change : $parent.fiMaNglieuChange}"></select>
                        </td>
                        <td data-bind="text: fiLoaiNglieu">
                            
                        </td> 
                        <td class="text-center">
                            <a class="btn red bt-center" data-bind="click: $parent.xoaNguyenLieuClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorNguyenLieuMessage" style="color:red;"> </span>
            <br />
            <a class="btn green bt-center" data-bind="click: themNguyenLieuClick"><i class="fa fa-add fa-lg"></i> Thêm</a>
        </div>
    </div>
</fieldset>