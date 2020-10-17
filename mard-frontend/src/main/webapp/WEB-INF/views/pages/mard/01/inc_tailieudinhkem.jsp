<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset data-bind="with: uploadFileVM">
    <legend><b><spring:message code="mard.08.tokhai.danh_sach_tai_lieu_dinh_kem"/></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                <tr>
                    <th style="width: 50px" class="text-center"><spring:message code="mt.hoso.dinhkem.stt"/></th>
                    <th class="text-center"><spring:message code="mt.hoso.dinhkem.tentep"/></th>
                    <th class="text-center"><spring:message code="mt.hoso.dinhkem.tepdinhkem"/></th>
                    <th class="text-center"><spring:message code="mt.hoso.dinhkem.chucnang"/></th>
                </tr>
                </thead>
                <tbody data-bind="foreach: lstAtch">
                <tr>
                    <td data-bind="text: ($index() + 1)"></td>
                    <td class="text-left">
                        <span data-bind="text: fiAttachmentTypeName">
                        </span><a data-bind="visible: isRequired()" class="nsw-require-field">*</a>
                    </td>
                    <td>
                        <a class="btn btn-info btn-xs" data-bind="click: $parent.addFiles, visible: !$root.isView()"
                           data-target="#modal_addFile" data-toggle="modal">Đính kèm</a>
                        <table style="border: 0px !important; width: 100%;">
                            <tbody data-bind="foreach: lstFiles">
                            <td>
                                <a target="_blank" data-bind="text: 'Tệp ' + ($index() + 1), attr: { href: fiLinkFile(), title: fiFileName }, visible: true"></a>
                            </td>
                            </tbody>
                        </table>
                    </td>
                    <td class="text-center">
                        <a href="#" data-bind="click: $parent.doDelete"><i class="fa fa-lg fa-trash"></i></a>
                    </td>
                </tr>
                </tbody>
            </table>
            <p class="nsw-require-field validate" id="file-dinh-kem" style="text-align: center"></p>
        <%--            <span data-bind="text : errorMsg" style="color:red;"> </span>--%>
            <p style="color: red;"><b>Lưu ý : </b> </br>
                - Tệp đính kèm có định dạng PDF, TIF, JPG</br>
                - Dung lượng tối đa của mỗi tệp đính kèm: 50MB </br>
                - Tên tệp đính kèm không dấu, không chứa ký tự đặc biệt </br>
            </p>
        </div>
    </div>

    <div id="modal_addFile" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-bind="click: saveUpload" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="common.tai_len_tep"/></b>
        </div>
        <div class="modal-body">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="mard.table.stt"/></th>
                    <th class="text-center"><spring:message code="mard.table.da_tai_len"/></th>
                    <th class="text-center"><spring:message code="mard.table.ten_file"/></th>
                    <th data-bind="visible: !$root.isView()" class="text-center"><spring:message code="mard.table.chuc_nang"/></th>
                </tr>
                </thead>
                <tbody data-bind="foreach: uploadedFiles">
                <tr>
                    <td data-bind="text: ($index() + 1)"></td>
                    <td data-bind="text: fiFileName"></td>
                    <td data-bind="text: fiAttachmentTypeName"></td>
                    <td data-bind="visible: !$root.isView()" class="text-center">
                        <a href="#" data-bind="click: $parent.removeFileUpload"><i class="fa fa-lg fa-trash"></i></a>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
            <label class="btn blue">
                <input type="file" id="btnfile" style="display: none" accept=".jpg, .jpeg, .pdf, .tif" data-bind="event: { change: fileChange}"/>
                <i class="fa fa-plus upload-file"></i> <spring:message code="mard.button.them_moi"/>
            </label>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green" data-bind="click: saveUpload"
                ><i class="fa fa-save"></i> <spring:message code="common.button.dong"/></button>
            </div>
        </div>
    </div>
</fieldset>
