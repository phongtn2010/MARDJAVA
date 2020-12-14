<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-group">
    <div class="col-md-12">
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center" style="width: 50px"><spring:message code="moh.07.xacnhannopphi.stt" /></th>
                    <th class="text-center"><spring:message code="moh.07.xacnhannopphi.loaiphi" /></th>
                    <th class="text-center"><spring:message code="moh.07.xacnhannopphi.nguoinop" /></th>
                    <th class="text-center" style="width: 100px"><spring:message code="moh.07.xacnhannopphi.sdt" /></th>
                    <th class="text-center" style="width: 200px"><spring:message code="moh.07.xacnhannopphi.ngaynop" /></th>
                    <th class="text-center"><spring:message code="moh.07.xacnhannopphi.sohoadon" /></th>
                    <th class="text-center"><spring:message code="moh.07.xacnhannopphi.tongtien" /></th>
                    <th class="text-center" style="width: 80px"><spring:message code="moh.07.xacnhannopphi.taitep" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: lstThanhToans">
                <tr>
                    <td data-bind="text : fiStt"></td>  
                    <td data-bind="text : fiLoaiPhiText"></td>  
                    <td data-bind="text : fiNguoiNop"></td>  
                    <td data-bind="text : fiSdt"></td>  
                    <td data-bind="text : fiNgayNopVn"></td>  
                    <td data-bind="text : fiSoHoadon"></td>  
                    <td data-bind="text : fiTongTien"></td>  
                    <td class="text-center">
                        <a target="_blank" href="javascript:void(0);" data-bind="attr: { href: fileUrl}"><i class="fa fa-download fa-lg"></i></a>
                    </td>  
                </tr>
            </tbody>
        </table>
    </div>
</div>


