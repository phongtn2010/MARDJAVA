<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="modal_viewLHKD" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false" data-bind="with: loHangKD"
>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <b class="modal-title">Thông báo lô hàng không đạt</b>
    </div>
    <div class="modal-body container" style="display: flex">
        <div class="col-md-12">
            <div class="row">
                <p class="content">Cơ quan: <b data-bind="text: fiSignConfirmAddress"></b></p>
                <p class="content">Chuyên viên: <b data-bind="text: fiSignConfirmName"></b></p>
                <p class="content">Ngày thông báo: <b data-bind="date: 1579088557044"></b></p>
                <p class="content">Nội dung: <b data-bind="text: fiReason"></b></p>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <div class="text-center">
            <button class="btn" data-dismiss="modal">
                Đóng
            </button>
        </div>
    </div>
</div>
