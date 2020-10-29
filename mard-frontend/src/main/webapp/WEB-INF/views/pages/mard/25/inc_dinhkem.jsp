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
                                <span data-bind="text : fiFileName"></span>
                            </td>
                            <td data-bind="visible: $root.isEditable" class="text-center">
                                <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                                <a href="#" data-bind="click: $parent.removeLstHD.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                                <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                            </td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                        <td></td>
                        <td>
                            <input id="fiFileHD" class="form-control" data-bind="value: fiFileHD"/>
                        </td>
                        <td>
                            <input id="fiFileHDDate" data-bind="datepicker: fiFileHDDate" class="form-control form-control-inline date-picker"
                                    data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" />
                        </td>
                        <td>
                            <input id="file-HD" class="form-control" type="file" data-bind="value: fiFileHDPath"/>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click:  addFile.bind($data,'1'), visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                            <span data-bind="text : fiFileHD"></span>
                        </td>
                        <td><span data-bind="text : fiFileHDDate"></span>
                        <td>
                            <span data-bind="text : fiFileName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.removeLstHoaDon.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input id="fiFileHoaDon" class="form-control" data-bind="value: fiFileHoaDon"/>
                    </td>
                    <td>
                        <input id="fiFileHoaDonDate" data-bind="datepicker: fiFileHoaDonDate" class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" />
                    </td>
                    <td>
                        <input id="file-HoaDon" class="form-control" type="file" data-bind="value: fiFileHoaDonPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFile.bind($data,'2'), visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                            <span data-bind="text : fiFileHD"></span>
                        </td>
                        <td><span data-bind="text : fiFileHDDate"></span>
                        <td>
                            <span data-bind="text : fiFileName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.removeLstPhieu.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input id="fiFilePhieu" class="form-control" data-bind="value: fiFilePhieu"/>
                    </td>
                    <td>
                        <input id="fiFilePhieuDate" data-bind="datepicker: fiFilePhieuDate" class="form-control form-control-inline date-picker"
                               data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" />
                    </td>
                    <td>
                        <input id="file-Phieu" class="form-control" type="file" data-bind="value: fiFilePhieuPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFile.bind($data,'3'), visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                            <span data-bind="text : fiFileHD"></span>
                        </td>
                        <td>
                            <span data-bind="text : fiFileName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.removeLstKQ.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input id="fiFileKQ" class="form-control" data-bind="value: fiFileKQ"/>
                    </td>
                    <td>
                        <input id="file-KQ"  class="form-control" type="file" data-bind="value: fiFileKQPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFile.bind($data,'4'), visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                            <span data-bind="text : fiFileHD">
                        </td>
                        <td>
                            <span data-bind="text : fiFileName">
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.removeLstTC.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input id="fiFileTC" class="form-control" data-bind="value: fiFileTC"/>
                    </td>
                    <td>
                        <input id="file-TC"  class="form-control" type="file" data-bind="value: fiFileTCPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFile.bind($data,'5'), visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                            <span data-bind="text : fiFileHD"></span>
                        </td>
                        <td>
                            <span data-bind="text : fiFileName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.removeLstCNLH.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input id="fiFileCNLH" class="form-control" data-bind="value: fiFileCNLH"/>
                    </td>
                    <td>
                        <input id="file-CNLH"  class="form-control" type="file" data-bind="value: fiFileCNLHPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFile.bind($data,'6'), visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                            <span data-bind="text : fiFileHD"></span>
                        </td>
                        <td>
                            <span data-bind="text :  fiFileName"></span>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-edit"></i></a>&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.removeLstCNPT.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                    <td></td>
                    <td>
                        <input id="fiFileCNPT" class="form-control" data-bind="value: fiFileCNPT"/>
                    </td>
                    <td>
                        <input id="file-CNPT"  class="form-control" type="file" data-bind="value: fiFileCNPTPath"/>
                    </td>
                    <td data-bind="visible: $root.isEditable" class="text-center">
                        <a href="#" data-bind="click: addFile.bind($data,'7'), visible: $root.isEditable()"><i class="fa fa-lg fa-plus"></i></a>
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
                                <select class="form-control select2"
                                        data-bind="value : fiFileKhacID, , selectedText2 : fiFileKhacName,
                                        options : lstLoaiFileDinhKemKhac, optionsValue : 'fiCatType',  optionsText : 'fiCatTypeName'">
                                </select>
                        </div>
                        <div class="col-md-6">
                            <input  id="file-Khac"  class="form-control form-control-inline date-picker" type="file" data-bind="value: fiFilePath"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style="padding-top: 10px;">
                    <div class="text-center">
                        <p><span class="nsw-require-field" data-bind="text: errorMsg"></span></p>
                        <button class="btn btn-primary" data-bind="click: addFile.bind($data,'8')"><i class="fa fa-save"></i> <spring:message code="mard.25.tokhai.file.khac_themmoi"/></button>
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
<%--                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.khac_xem"/></th>--%>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.khac_tai"/></th>
                        <th data-bind="visible: $root.isEditable" class="text-center"><spring:message code="mard.25.tokhai.file.khac_xoa"/></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstAtch">
                    <tr>
                        <td data-bind="text: ($index() + 1)"></td>
                        <td>
                            <span data-bind="text : fiFileTypeName"></span>
                        </td>
<%--                        <td data-bind="visible: $root.isEditable" class="text-center">--%>
<%--                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-eye"></i></a>--%>
<%--                        </td>--%>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.doDelete, visible: $root.isEditable()"><i class="fa fa-lg fa-download"></i></a>
                        </td>
                        <td data-bind="visible: $root.isEditable" class="text-center">
                            <a href="#" data-bind="click: $parent.removeLstAtch.bind($data, $index()), visible: $root.isEditable()"><i class="fa fa-lg fa-trash"></i></a>
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



</fieldset>
