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
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHanghoas">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td style="width: 220px">
                            <select class="form-control select2 fiMaHs" disabled data-bind="value: fiMaHs,
                                attr: { id: 'fiMaHs-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstMaHS"></select>
                        </td>
                        <td>
                            <input class="form-control" name="fiTenHh" readonly data-bind="value : fiTenHh" maxlength="2000"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHHMessage" style="color:red;"> </span>
            <br />
        </div>
    </div>
</fieldset>