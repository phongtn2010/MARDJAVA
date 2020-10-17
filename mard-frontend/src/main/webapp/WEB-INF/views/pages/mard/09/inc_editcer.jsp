<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 12/9/19
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div id="modal_req_edit_cert" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
>
    <!-- ko with: editGCNVM() -->
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
        <div class="col-md-12">
            <div class="form-group">
                <div class="col-md-12">
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th class="text-center"><spring:message code="mt.hoso.dinhkem.stt"/></th>
                            <th class="text-center"><spring:message code="mt.hoso.dinhkem.tentep"/></th>
                            <th class="text-center"><spring:message code="mt.hoso.dinhkem.tepdinhkem"/></th>
                            <th class="text-center"><spring:message code="mt.hoso.dinhkem.chucnang"/></th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstAtch">
                            <tr>
                                <td data-bind="text: ($index() + 1)"></td>
                                <td><input data-bind="value: fiTenTep"/></td>
                                <td>
                                    <input type="file" data-bind="event: { change: $parent.fileChange($data, $element.files[0]) } "/>
                                </td>
                                <td class="text-center">
                                    <a href="#" data-bind="click: function(){ $parent.onDelete($index()) }"><i class="fa fa-lg fa-trash"></i></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <label class="btn blue" data-bind="click: onAddFile">
                        <i class="fa fa-plus upload-file"></i> <spring:message code="mard.button.them_moi"/>
                    </label>
                    <p style="color: red;"><b>Lưu ý : </b> </br>
                        - Tệp đính kèm có định dạng PDF, TIF, JPG</br>
                        - Dung lượng tối đa của mỗi file đính kèm: 50MB </br>
                    </p>
                </div>
            </div>
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
    <!-- /ko -->
</div>
