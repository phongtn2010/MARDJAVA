<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div data-bind="with: regAnimalVM">
    <fieldset data-bind="with: productVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_dong_vat"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addAnimal"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: lstProduct"></span>
                    <table class="table table-striped table-bordered table-hover  order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.ten_loai_dong_vat"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong_duc"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong_cai"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.don_vi_tinh"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_xuat_xu"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.cua_nhap_khau"/></th>
                            <th class="text-center" data-bind="visible: $root.isEditable()"><spring:message
                                    code="mard.08.table.col.thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstProduct">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiProductName">
                            </td>
                            <td class="text-right" data-bind="text : fiQtyMale">
                            </td>
                            <td class="text-right" data-bind="text : fiQtyFemale"></td>
                            <td data-bind="text : $parent.getUnitName(fiUnitCode)"></td>
                            <td data-bind="text : $parent.getCountryName(fiCountryOrigin)"></td>
                            <td data-bind="text : fiPortName"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px" title="Sửa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-edit" data-target="#modal_addAnimal"
                                       data-toggle="modal" aria-hidden="true"
                                       data-bind="click: function(){$parent.updateProduct($index())}"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                       data-bind="click: function(){$parent.removeProduct($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="form-group" data-bind="visible: $root.isEditable()">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhập danh sách động vật theo file</label>
                    </div>
                    <div class="col-md-10">
                        <input
                                data-bind="event: { change: function(data, event){ addProductFromExcel(event, 'animal') } }"
                                type="file"
                                class="form-control"
                                accept=".xlsx"
                        />
                        <div style="margin-top: 5px;">
                            <a style="font-style: italic" href="/mard/08/templates?type=animal">
                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </fieldset>
    <fieldset data-bind="with: exporterVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_cong_ty"/></b>
            <a style="margin-left: 10px;" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addAnimalExporter"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: lstExporter"></span>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center" style="width: 40%">
                                <spring:message
                                        code="mard.08.table.col.ten_cong_ty_xk"/></th>
                            <th class="text-center" style="width: 45%">
                                <spring:message
                                        code="mard.08.table.col.dia_chi_cong_ty_xk"/></th>
                            <th class="text-center" style="width: 10%" data-bind="visible: $root.isEditable()">
                                <spring:message
                                        code="mard.08.table.col.thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstExporter">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiExporterName"></td>
                            <td data-bind="text : fiExporterAddress"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px;" title="Sửa" data-target="#modal_addAnimalExporter"
                                   data-toggle="modal" data-bind="click: function(){$parent.update($index())}">
                                    <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                       data-bind="click: function(){$parent.removeExporter($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="form-group" data-bind="visible: $root.isEditable()">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhập danh sách công ty xuất khẩu theo file</label>
                    </div>
                    <div class="col-md-10">
                        <input
                                data-bind="event: { change: function(data, event){ addExportFromExcel(event, 'exporter') } }"
                                type="file"
                                class="form-control"
                                accept=".xlsx"
                        />
                        <div style="margin-top: 5px;">
                            <a style="font-style: italic" href="/mard/08/templates?type=exporter">
                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </fieldset>
    <fieldset data-bind="with: isoLocationVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_noi_kiem_dich"/></b>
            <a style="margin-left: 10px;" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addIsoLocation"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: lstIsolatedLocation"></span>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center" style="width: 40%">
                                <spring:message
                                        code="mard.08.table.col.ten_noi_cach_ly_kd"/></th>
                            <th class="text-center" style="width: 45%">
                                <spring:message
                                        code="mard.08.table.col.dia_diem_noi_cach_ly_kd"/></th>
                            <th class="text-center" data-bind="visible: $root.isEditable()"><spring:message
                                    code="mard.08.table.col.thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstIsolatedLocation">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiIsoLocName"></td>
                            <td data-bind="text : fiIsoLocAddress"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px" title="Sửa" data-target="#modal_addIsoLocation"
                                   data-toggle="modal" data-bind="click: function(){$parent.update($index())}">
                                    <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                       data-bind="click: function(){$parent.removeIsoLocation($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="form-group" data-bind="visible: $root.isEditable()">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhập danh sách địa điểm cách ly kiểm dịch theo file</label>
                    </div>
                    <div class="col-md-10">
                        <input
                                data-bind="event: { change: function(data, event){ addLocationQuaratineFromExcel(event) } }"
                                type="file"
                                class="form-control"
                                accept=".xlsx"
                        />
                        <div style="margin-top: 5px;">
                            <a style="font-style: italic" href="/mard/08/templates?type=quaratine">
                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </fieldset>
    <form role="form" class="form-horizontal">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.tu_trang_trai"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value: fiAnimalFarm, enable: $root.isEditable()" maxlength="250">
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.dia_chi_trang_trai"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value: fiAnimalFarmAddress, enable: $root.isEditable()" maxlength="500">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.thoi_gian_thuc_hien"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiProcessingDate, enable: $root.isEditable()"
                            class="form-control"
                            type="text"
                            maxlength="250"
                    />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.muc_dich_su_dung"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" data-bind="trimedValue: fiIntendedPurpose, enable: $root.isEditable()" maxlength="250">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.giay_to_kem_theo"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiProvidedDocument, enable: $root.isEditable()"
                            class="form-control" maxlength="250"/>
                </div>
            </div>
        </div>
    </form>
    <!-- add animal modal -->
    <div id="modal_addAnimal" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: productVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_dong_vat"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.ten_loai_dong_vat"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiProductName, enable: $root.isEditable(), hasFocus: true"
                               class="form-control" type="text" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstUOMs,
                                                optionsText: 'unitname',
                                                optionsValue: 'unitcode',
                                                optionsCaption: '<spring:message code="mard.08.tokhai.select_don_vi"/>',
                                                value: fiUnitCode" class="form-control"></select>

                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.so_luong_duc"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control numeric"
                               data-bind="value: fiQtyMale, enable: $root.isEditable()" type="number" min="0"
                               />
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.so_luong_cai"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control numeric"
                               data-bind="value: fiQtyFemale, enable: $root.isEditable()" type="number" min="0"
                               />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.cua_nhap_khau"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiPortName" class="form-control" type="text" maxlength="255">
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.nuoc_xuat_xu"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstCountry,
                                                optionsText: 'countryname',
                                                optionsValue: 'countrycode',
                                                optionsCaption: '<spring:message code="mard.08.tokhai.select_country"/>',
                                                value: fiCountryOrigin" class="form-control"></select>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green" data-bind="click: addProduct">
                    <span data-bind="visible: !isEdit()"><spring:message code="conmon.button.them"/></span>
                    <span data-bind="visible: isEdit()"><spring:message code="common.button.sua"/></span>
                </button>
                <button class="btn" data-dismiss="modal" data-bind="click: closeForm">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- add exporter modal -->
    <div id="modal_addAnimalExporter" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: exporterVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_cong_ty"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.ten_cong_ty_xk"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiExporterName, enable: $root.isEditable()"
                               class="form-control" value="" type="text" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dia_chi_cong_ty_xk"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiExporterAddress, enable: $root.isEditable()"
                               class="form-control" type="text" maxlength="500"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green" data-bind="click: addExporter">
                    <span data-bind="visible: !isEdit()"><spring:message code="conmon.button.them"/></span>
                    <span data-bind="visible: isEdit()"><spring:message code="common.button.sua"/></span>
                </button>
                <button class="btn" data-dismiss="modal" data-bind="click: closeForm">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- add isolocation modal -->
    <div id="modal_addIsoLocation" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: isoLocationVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_noi_kiem_dich"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.ten_noi_cach_ly_kd"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiIsoLocName, enable: $root.isEditable()"
                               class="form-control" value="" maxlength="255"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dia_diem_noi_cach_ly_kd"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiIsoLocAddress, enable: $root.isEditable()"
                               class="form-control" type="text" maxlength="500"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green" data-bind="click: addIsoLocation, visible: $root.isEditable()">
                    <span data-bind="visible: !isEdit()"><spring:message code="conmon.button.them"/></span>
                    <span data-bind="visible: isEdit()"><spring:message code="common.button.sua"/></span>
                </button>
                <button class="btn" data-dismiss="modal" data-bind="click: closeForm">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
</div>

