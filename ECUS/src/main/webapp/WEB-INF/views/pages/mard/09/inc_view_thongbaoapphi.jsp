
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
    <div id="modal_thongbaoApphi" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: thongbaoApphi"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Thông báo áp phí: <span data-bind="text: fiHSCode"></span></b>
        </div>
        <div class="modal-body">
            <div class="tab-content" id="pageView">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th class="text-center" width="5%"><spring:message code="mard.xemgiayphep.stt" /></th>
                        <th class="text-center" width="15%">Đơn vị</th>
                        <th class="text-center" width="15%">Người tạo</th>
                        <th class="text-center" width="15%">Số tiền</th>
                        <th class="text-center" width="15%">Số tiền bằng chữ</th>
                        <th class="text-center" width="40%">Nội dung</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: apphiItems">
                    <tr>
                        <td data-bind="text: $index() + 1"></td>
                        <td data-bind="text: fiCreaterName"></td>
                        <td data-bind="text: fiDepartment"></td>
                        <td class="text-right" data-bind="text: formatCurrency(fiTotalFee())"></td>
                        <td data-bind="text: fiAmountInWords"></td>
                        <td data-bind="html: fiNote"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal">
                <spring:message code="conmon.button.dong"/>
            </button>
        </div>
    </div>
</div>
