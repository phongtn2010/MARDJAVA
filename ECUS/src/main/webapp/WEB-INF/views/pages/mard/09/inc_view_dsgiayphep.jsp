
<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 11/14/19
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div id="modal_dsGiayphep" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    <%--     data-bind="with: frmAddMfs"--%>
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Danh sách giấy phép của hồ sơ: <span data-bind="text: fiHSCode"></span></b>
        </div>
        <div class="modal-body">
            <div id="gvc">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th class="text-center" width="5%"><spring:message code="mard.xemgiayphep.stt" /></th>
                        <th class="text-center" width="35%"><spring:message code="mard.xemgiayphep.loaigiayphep" /></th>
                        <th class="text-center" width="20%"><spring:message code="mard.xemgiayphep.sogiaychungnhan" /></th>
                        <th class="text-center" width="10%"><spring:message code="mard.xemgiayphep.ngaycap" /></th>
                        <th class="text-center" width="10%"><spring:message code="mard.xemgiayphep.trangthai" /></th>
                        <th class="text-center" width="10%"><spring:message code="mard.xemgiayphep.xem" /></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: items">
                    <tr>
                        <td data-bind="text: $index() + 1"></td>
                        <td data-bind="text: fiCerType"></td>
                        <td data-bind="text: fiCertificateNo"></td>
                        <td data-bind="date: fiSignResultDate"></td>
                        <td data-bind="text: fiCertStatusString"></td>
                        <td class="text-center">
                            <a href="javascript:void(0)" class="fa fa-eye" style="text-decoration: none;" data-bind="click: $parent.xemGiayPhep.bind($data)"></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%@include file="inc_editcer.jsp"%>
</div>
