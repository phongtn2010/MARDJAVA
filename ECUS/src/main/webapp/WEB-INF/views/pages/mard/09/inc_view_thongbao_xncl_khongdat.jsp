<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 11/21/19
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
    <div id="modal_xemTBXNCLKhongDat" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Thông báo kết quả XNCL không đạt</b>
        </div>
        <div class="modal-body container">
            <div>
                <p class="content">
                    Đơn vị xử lý: <span style="font-weight: bold" data-bind="text: fiDepartment"/>
                </p>
                <p class="content">
                    Chuyên viên xử lý: <span style="font-weight: bold" data-bind="text: fiCreatorName"/>
                </p>
                <p class="content">
                    Ngày xử lý: <span style="font-weight: bold" data-bind="date: fiRequestDate"/>
                </p>
                <p class="content">
                    Nội dung ghi chú: <span style="font-weight: bold" data-bind="text: fiDescription"/>
                </p>
                <p class="content">
                    Kết quả xác nhận chất lượng: <span style="font-weight: bold" data-bind="text: fiQualityResult"/>
                </p>
                <p class="content">
                    Danh sách hàng hóa không đạt:
                </p>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th rowspan="2" width="10%">STT</th>
                        <th rowspan="2" width="70%">Tên hàng hóa</th>
                        <th rowspan="2" width="20%">Số lượng/khối lượng</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: fiGoodsList">
                    <tr>
                        <td data-bind="text: $index() + 1"></td>
                        <td data-bind="text: fiNameOfGoods"></td>
                        <td style="text-align: right" data-bind="text: fiQuantityOrVolumn"></td>
                    </tr>
                    </tbody>
                </table>

                <p class="content">
                    Danh sách tệp đính kèm:
                </p>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th rowspan="2" width="10%">STT</th>
                        <th rowspan="2" width="70%">Tên tập tin</th>
                        <th rowspan="2" width="20%">Tải về</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: fiAttachmentList">
                    <tr>
                        <td data-bind="text: $index() + 1"></td>
                        <td data-bind="text: fiTenTep"></td>
                        <td><a data-bind="attr: {href: fiDuongDan}" target="_blank">Tải về</a></td>
                    </tr>
                    </tbody>
                </table>
                <br/>
                <br/>


                <br/>
                <br/>
            </div>
        </div>
        <div class="modal-footer">
        </div>
    </div>
</div>