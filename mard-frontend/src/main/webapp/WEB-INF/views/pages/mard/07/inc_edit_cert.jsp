<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="modal_req_edit_cert" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <b class="modal-title"><span data-bind="text: title"></span></b>
    </div>
    <div class="modal-body container">
        <div class="col-md-12">
            <div class="form-group" style="margin-bottom: 16px">
                <div class="col-md-2">
                    Nội dung xin sửa GCN<a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-10">
                    <textarea rows="3" data-bind="value: fiReason" class="form-control" id="fiLydo" name="fiLydo" type="text" maxlength="2000"></textarea>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <br/>
        </div>
    </div>
    <div class="modal-footer" style="">
        <div class="text-center">
            <button class="btn green"
                    data-bind="click: onSend"
            >
                Gửi
            </button>
            <button class="btn" data-dismiss="modal" data-target="#modal_addCompany">
                <spring:message code="conmon.button.huy"/>
            </button>
        </div>
    </div>
</div>