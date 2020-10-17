<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fieldset data-bind="with: uploadFileVM">
    <legend><b><spring:message code="mard.08.tokhai.danh_sach_tai_lieu_dinh_kem"/></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="mt.hoso.dinhkem.stt"/></th>
                    <th class="text-center"><spring:message code="mt.hoso.dinhkem.tentep"/></th>
                    <th class="text-center"><spring:message code="mt.hoso.dinhkem.tepdinhkem"/></th>
                    <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mt.hoso.dinhkem.chucnang"/></th>
                </tr>
                </thead>
                <tbody data-bind="foreach: lstAtch">
                <tr>
                    <td data-bind="text: ($index() + 1)"></td>
                    <td>
                        <span data-bind="text : fiTenLoai()">
                        </span><a data-bind="visible: isRequired()" class="nsw-require-field">*</a>
                    </td>
                    <td>
                        <div class="text-center">
                        <a class="btn btn-info btn-xs" data-bind="click: $parent.addFiles, visible: $root.isEditable()"
                           data-target="#modal_addFile" data-toggle="modal">Đính kèm</a>
                        </div>
                        <table style="border: 0px !important; width: 100%;">
                            <tbody data-bind="foreach: lstFiles">
                            <td>
                                <a target="_blank" data-bind="text: 'Tệp ' + ($index() + 1), click: downloadFile, attr: {title: fiFileName}"></a>
                            </td>
                            </tbody>
                        </table>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>
                    </td>
                </tr>
                </tbody>
            </table>
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
                    <th data-bind="visible: $root.isEditable()" class="text-center"><spring:message code="mard.table.chuc_nang"/></th>
                </tr>
                </thead>
                <tbody data-bind="foreach: uploadedFiles">
                <tr>
                    <td data-bind="text: ($index() + 1)"></td>
                    <td data-bind="text: fiFileName"></td>
                    <td class="text-left" data-bind="text: fiFileTypeName"></td>
                    <td data-bind="visible: $root.isEditable()" class="text-center">
                        <a href="#" data-bind="click: $parent.removeFileUpload"><i class="fa fa-lg fa-trash"></i></a>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
            <label class="btn blue">
                <input type="file" id="btnfile3" style="display: none" data-bind="event: { change: fileChange}" accept=".pdf, .jpeg, .jpg, .tif"/>
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
