<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fieldset data-bind="with: uploadFileVM">
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.hop_dong"/></b></div>
        <div class="panel-body">
            <div class="form-group">
                <div class="col-md-12">
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"><spring:message code="mard.25.tokhai.file.hop_dong_stt"/></th>
                            <th class="text-center"><spring:message code="mard.25.tokhai.file.hop_dong_hd"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                            <th class="text-center"><spring:message code="mard.25.tokhai.file.hop_dong_ngay"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                            <th class="text-center"><spring:message code="mard.25.tokhai.file.hop_dong_file"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                            <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.hop_dong_thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstHD">
                        <tr>
                            <td data-bind="text: ($index() + 1)"></td>
                            <td>
                                <span data-bind="text : fiFileHD"></span>
                            </td>
                            <td><span data-bind="text : fiFileHDDate"></span>
                            <td>
                                <span data-bind="text : fiFileHDName"></span>
                            </td>
                            <td data-bind="visible: $root.isEditable" class="text-center">
                                <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                                <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                                <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                            </td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                        <td></td>
                        <td>
                            <input class="form-control" data-bind="value: fiFileHD"/>
                        </td>
                        <td>
                            <input data-bind="datepicker: fiFileHDDate" class="form-control form-control-inline date-picker"
                                    data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" />
                        </td>
                        <td>
                            <input id="file-hd" class="form-control" type="file" data-bind="value: fiFileHDPath"/>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="event: { click: uploadFileHD}, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                        </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.hoa_don"/></b></div>
        <div class="panel-body">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.hoa_don_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.hoa_don_hd"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.hoa_don_ngay"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.hoa_don_file"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.hoa_don_thaotac"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstHoaDon">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFileHoaDon"></span>
                        </td>
                        <td><span data-bind="text : fiFileHoaDonDate"></span>
                        <td>
                            <span data-bind="text : fiFileHoaDonName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input class="form-control" data-bind="value: fiFileHoaDon"/>
                    </td>
                    <td>
                        <input data-bind="datepicker: fiFileHoaDonDate" class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" />
                    </td>
                    <td>
                        <input class="form-control" type="file" data-bind="value: fiFileHoaDonPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFileHoaDon, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                    </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.phieu"/></b></div>
        <div class="panel-body">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.phieu_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.phieu_phieu"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.phieu_ngay"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.phieu_file"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.phieu_thaotac"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstPhieu">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFilePhieu"></span>
                        </td>
                        <td><span data-bind="text : fiFilePhieuDate"></span>
                        <td>
                            <span data-bind="text : fiFilePhieuName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-eye"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input class="form-control" data-bind="value: fiFilePhieu"/>
                    </td>
                    <td>
                        <input data-bind="datepicker: fiFilePhieuDate" class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" />
                    </td>
                    <td>
                        <input class="form-control" type="file" data-bind="value: fiFilePhieuPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFilePhieu, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                    </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.ket_qua"/></b></div>
        <div class="panel-body">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.ket_qua_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.ket_qua_name"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.ket_qua_file"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.ket_qua_thaotac"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstKQ">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFileKQ"></span>
                        </td>
                        <td>
                            <span data-bind="text : fiFileKQName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-eye"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input class="form-control" data-bind="value: fiFileKQ"/>
                    </td>
                    <td>
                        <input class="form-control" type="file" data-bind="value: fiFileKQPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFileKQ, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                    </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.tieu_chuan"/></b></div>
        <div class="panel-body">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.tieu_chuan_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.tieu_chuan_name"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.tieu_chuan_file"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.tieu_chuan_thaotac"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstTC">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFileTC">
                        </td>
                        <td>
                            <span data-bind="text : fiFileTCName">
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-eye"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input class="form-control" data-bind="value: fiFileTC"/>
                    </td>
                    <td>
                        <input class="form-control" type="file" data-bind="value: fiFileTCPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFileTC, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                    </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.chung_nhan_luu_hanh"/></b></div>
        <div class="panel-body">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_luu_hanh_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_luu_hanh_name"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_luu_hanh_file"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_luu_hanh_thaotac"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstCNLH">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFileCNLH"></span>
                        </td>
                        <td>
                            <span data-bind="text : fiFileCNLHName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-eye"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input class="form-control" data-bind="value: fiFileCNLH"/>
                    </td>
                    <td>
                        <input class="form-control" type="file" data-bind="value: fiFileCNLHPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFileCNLH, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                    </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.chung_nhan_phan_tich"/></b></div>
        <div class="panel-body">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_phan_tich_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_phan_tich_name"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_phan_tich_file"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.chung_nhan_phan_tich_thaotac"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstCNPT">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFileCNPT"></span>
                        </td>
                        <td>
                            <span data-bind="text :  fiFileCNPTName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-eye"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input class="form-control" data-bind="value: fiFileCNPT"/>
                    </td>
                    <td>
                        <input class="form-control" type="file" data-bind="value: fiFileCNPTPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFileCNPT, visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
                    </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading"><b><spring:message code="mard.25.tokhai.file.khac"/></b></div>
        <div class="panel-body">
            <div class="row">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mard.25.tokhai.file.khac_type"/><a class="nsw-require-field">*</a></label>
                        </div>
                            <div class="col-md-4">
                                <select class="form-control" data-bind="value: fiFileType, enable: $root.isEditable()">
                                    <option value="1">
                                        <spring:message code="mard.25.tokhai.loai_hinh_thuc_2a"/>
                                    </option>
                                    <option value="2">
                                        <spring:message code="mard.25.tokhai.loai_hinh_thuc_2b"/>
                                    </option>
                                    <option value="3">
                                        <spring:message code="mard.25.tokhai.loai_hinh_thuc_2c"/>
                                    </option>
                                    <option value="4">
                                        <spring:message code="mard.25.tokhai.loai_hinh_thuc_2d"/>
                                    </option>
                                </select>

                        </div>
                        <div class="col-md-6">
                            <input class="form-control form-control-inline date-picker" type="file" data-bind="value: fiFilePath"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style="padding-top: 10px;">
                    <div class="text-center">
                        <p><span class="nsw-require-field" data-bind="text: errorMsg"></span></p>
                        <button class="btn btn-primary" data-bind="click: addFiles"><i class="fa fa-save"></i> <spring:message code="mard.25.tokhai.file.khac_themmoi"/></button>
                    </div>
                </div>
            </div>
            <br><br>
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.khac_stt"/></th>
                        <th class="text-center"><spring:message code="mard.25.tokhai.file.khac_type"/><a data-bind="visible: isRequired()" class="nsw-require-field">(*)</a></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.khac_xem"/></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.khac_tai"/></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.khac_xoa"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstAtchment">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFileName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-eye"></i></a>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <p style="color: red;"><b>Lưu ý : </b> </br>
        - Tệp đính kèm có định dạng PDF, TIF, JPG</br>
        - Dung lượng tối đa của mỗi tệp đính kèm: 50MB </br>
        - Tên tệp đính kèm không dấu, không chứa ký tự đặc biệt </br>
    </p>


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
                <input type="file" id="btnfile3" style="display: none" data-bind="" accept=".pdf, .jpeg, .jpg, .tif"/>
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
