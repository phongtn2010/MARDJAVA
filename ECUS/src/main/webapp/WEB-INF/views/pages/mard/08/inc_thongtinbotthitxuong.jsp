<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div data-bind="with : regBoneMealVM">
    <fieldset data-bind="with: productVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_hang_hoa"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addBoneMealProduct"
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
                                    code="mard.08.table.col.ten_hang"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong"/></th>
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
                            <td class="text-right" data-bind="text : fiNumber"></td>
                            <td data-bind="text : $parent.getUnitName(fiUnitCode)"></td>
                            <td data-bind="text : $parent.getCountryName(fiCountryOrigin)"></td>
                            <td data-bind="text : fiPortName"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px;" data-target="#modal_addBoneMealProduct" data-toggle="modal" title="Sửa" data-bind="click: function(){$parent.updateProduct($index())}">
                                    <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.removeProduct($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
<%--            <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                <div class="col-md-12">--%>
<%--                    <div class="col-md-2 nsw-text-right">--%>
<%--                        <label>Nhập danh sách hàng hóa theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: function(data, event){ addProductFromExcel(event, 'animal_product') } }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/08/templates?type=animal_product">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </form>
    </fieldset>
    <fieldset data-bind="with: exporterVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_cong_ty"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addBoneMealExporter"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: lstExporter"></span>
                    <table class="table table-striped table-bordered table-hover  order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center" style="width: 40%"><spring:message
                                    code="mard.08.table.col.ten_cong_ty_xk"/></th>
                            <th class="text-center" style="width: 45%"><spring:message
                                    code="mard.08.table.col.dia_chi_cong_ty_xk"/></th>
                            <th class="text-center" data-bind="visible: $root.isEditable()"><spring:message
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
                                <a style="margin-bottom: 5px;" title="Sửa" data-target="#modal_addBoneMealExporter" data-toggle="modal" data-bind="click: function(){$parent.update($index())}">
                                    <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.removeExporter($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
<%--            <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                <div class="col-md-12">--%>
<%--                    <div class="col-md-2 nsw-text-right">--%>
<%--                        <label>Nhập danh sách công ty xuất khẩu theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: function(data, event){ addExportFromExcel(event, 'exporter') } }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/08/templates?type=exporter">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </form>
    </fieldset>
    <fieldset data-bind="with: productMfrVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_nha_may_che_bien"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addBoneMealProdMfr"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: lstProdMfr"></span>
                    <table class="table table-striped table-bordered table-hover  order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center" style="width: 40%"><spring:message
                                    code="mard.08.table.col.ten_nha_may_che_bien"/></th>
                            <th class="text-center" style="width: 45%"><spring:message
                                    code="mard.08.table.col.dia_chi_nha_may_che_bien"/></th>
                            <th class="text-center" data-bind="visible: $root.isEditable()"><spring:message
                                    code="mard.08.table.col.thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstProdMfr">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiMfrName"></td>
                            <td data-bind="text : fiMfrAddress"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px;" title="Sửa" data-target="#modal_addBoneMealProdMfr" data-toggle="modal" data-bind="click: function(){$parent.update($index())}">
                                    <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.removeProductMfr($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
<%--            <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                <div class="col-md-12">--%>
<%--                    <div class="col-md-2 nsw-text-right">--%>
<%--                        <label>Nhập danh sách nhà máy sản xuất, chế biến theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: function(data, event){ addProdMfrFromExcel(event) } }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/08/templates?type=prodmfr">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </form>
    </fieldset>
    <fieldset data-bind="with: mfgFactoryVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_nha_may_sx"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addBoneMealMfgFactory"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: lstMfgFactory"></span>
                    <table class="table table-striped table-bordered table-hover  order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center" style="width: 40%"><spring:message
                                    code="mard.08.table.col.ten_nha_may_sx"/></th>
                            <th class="text-center" style="width: 45%"><spring:message
                                    code="mard.08.table.col.dia_chi_nha_may_sx"/></th>
                            <th class="text-center" data-bind="visible: $root.isEditable()"><spring:message
                                    code="mard.08.table.col.thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody id="listProductFactory"
                               data-bind="foreach: lstMfgFactory">
                        <tr>
                            <td class="text-right" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiFactoryName"></td>
                            <td data-bind="text : fiFactoryAddress"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px" title="Sửa" data-target="#modal_addBoneMealMfgFactory" data-toggle="modal" >
                                    <i style="color: #337ab7" class="fa fa-lg fa-edit" aria-hidden="true" data-bind="click: function(){$parent.update($index())}"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.removeMfgFactory($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
<%--            <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                <div class="col-md-12">--%>
<%--                    <div class="col-md-2 nsw-text-right">--%>
<%--                        <label>Nhập danh sách nhà máy sản xuất tacn theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: function(data, event){ addMfgFactoryFromExcel(event) } }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/08/templates?type=mfgfactory">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </form>
    </fieldset>
    <form role="form" class="form-horizontal">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.thoi_gian_thuc_hien"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiProcessingDate, enable: $root.isEditable()"
                            class="form-control"
                            type="text"
                            maxlength="250"
                    />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.muc_dich_su_dung"/></label>
                </div>
                <div class="col-md-10">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" data-bind="checked: fiIntendedPurpose, enable: $root.isEditable()" value="Nguyên liệu sản xuất thức ăn cho lợn">Nguyên liệu sản xuất thức ăn cho lợn</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" data-bind="checked: fiIntendedPurpose, enable: $root.isEditable()" value="Nguyên liệu sản xuất thức ăn cho gia cầm">Nguyên liệu sản xuất thức ăn cho gia cầm</label>
<%--                    <input class="form-control" data-bind="trimedValue: fiIntendedPurpose, enable: $root.isEditable()">--%>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2"></div>
                <div class="col-md-10">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" data-bind="checked: fiIntendedPurpose, enable: $root.isEditable()"  value="Nguyên liệu sản xuất thức ăn cho thủy sản">Nguyên liệu sản xuất thức ăn cho thủy sản</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" data-bind="checked: fiIntendedPurpose, enable: $root.isEditable()" value="Nguyên liệu sản xuất thức ăn cho động vật cảnh">Nguyên liệu sản xuất thức ăn cho động vật cảnh</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.muc_dich_khac"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiOtherPurpose, enable: $root.isEditable()" class="form-control" maxlength="250"/>
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
                            data-bind="trimedValue: fiProvidedDocument, enable: $root.isEditable()" class="form-control" maxlength="250"/>
                </div>
            </div>
        </div>
    </form>
    <!-- modal -->
    <div id="modal_addBoneMealProduct" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: productVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_hang_hoa"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.ten_hang"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiProductName"
                               class="form-control" value="" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                disabled
                                data-bind="options: lstUOMs,
                                                optionsText: 'unitname',
                                                optionsValue: 'unitcode',
                                                optionsCaption: '<spring:message code="mard.08.tokhai.select_don_vi"/>',
                                                value: fiUnitCode" class="form-control"></select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.so_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value: fiNumber" type="number" min="0" />
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.cua_nhap_khau"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input type="text"
                               data-bind="trimedValue: fiPortName" class="form-control" maxlength="255">
                    </div>
                </div>
                <div class="form-group">
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
    <!-- moda -->
    <div id="modal_addBoneMealExporter" class="modal container in modal-overflow" tabindex="-1"
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
                        <input data-bind="trimedValue: fiExporterName"
                               class="form-control" value="" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dia_chi_cong_ty_xk"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiExporterAddress"
                               class="form-control" maxlength="500"/>
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
    <!-- modal -->
    <div id="modal_addBoneMealProdMfr" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: productMfrVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_nha_may_che_bien"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.ten_nha_may_che_bien"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiMfrName"
                               class="form-control" value="" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dia_chi_nha_may_che_bien"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiMfrAddress"
                               class="form-control" maxlength="500"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green" data-bind="click: addProdMfr">
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
    <!-- modal -->
    <div id="modal_addBoneMealMfgFactory" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: mfgFactoryVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_nha_may_sx"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.ten_nha_may_sx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiFactoryName"
                               class="form-control" value="" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dia_chi_nha_may_sx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiFactoryAddress"
                               class="form-control" maxlength="500"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green" data-bind="click: addMfgFactory">
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
<style>
    .request-checkbox {
        float: left;
        width: calc(100% / 2);
        margin-left: 0px !important;
    }

    input[type="checkbox"] {
        margin-right: 5px;
    }
</style>



