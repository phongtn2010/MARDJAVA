<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="modal_viewGiayPhep" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body">
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Loại giấy phép</th>
                    <th>Số giấy chứng nhận</th>
                    <th>Ngày cấp</th>
                    <th>Xem</th>
                    <th>Xin sửa</th>
                </tr>
            </thead>
            <tbody data-bind="foreach: lstGP">
            <tr>
                <td class="text-center" data-bind="text: $index() + 1"></td>
                <td data-bind="text: fiCertName"></td>
                <td data-bind="text: fiCertificateNo"></td>
                <td data-bind="date: fiSignConfirmDate"></td>
                <td>
                    <a href="javascript:void(0)" data-bind="click: $root.viewGiayPhep"><i class="fa fa-eye"></i></a>
                </td>
                <td>
                    <a data-bind="click: $root.xinSuaGCN, visible: fiEditStatus != 1 && fiEditStatus != 3" href="javascript:void(0)"><i class="fa fa-lg fa-edit"></i></a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<!-- ko with: editGCNVM() -->
<%@include file="inc_edit_cert.jsp"%>
<!-- /ko -->