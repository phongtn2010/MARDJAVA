<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div data-bind="with: regAnimalVM">
    <fieldset data-bind="with: productVM">
        <legend><b><spring:message code="mard.06.tokhai.thong_tin_hang_hoa"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addAnimal"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: fiProductList"></span>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%" class="text-center"><spring:message
                                    code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message code="mard.06.table.ten_thuong_mai"/></th>
                            <th class="text-center"><spring:message code="mard.06.table.ten_khoa_hoc"/></th>
                            <th class="text-center"><spring:message code="mard.06.table.kich_co_ca_the"/></th>
                            <th class="text-center"><spring:message code="mard.06.table.so_luong"/></th>
                            <th class="text-center"><spring:message code="mard.06.table.don_vi_tinh"/></th>
                            <th class="text-center"><spring:message code="mard.06.table.nuoc_xuat_xu"/></th>
                            <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                <spring:message code="mard.table.chuc_nang"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: fiProductList">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiProductBusinessName">
                            </td>
                            <td data-bind="text : fiProductScienceName">
                            </td>
                            <td data-bind="text : fiSizeOrType"></td>
                            <td class="text-right" data-bind="text : fiQuantity"></td>
                            <td data-bind="text : fiPackageUnitName"></td>
                            <td data-bind="text : fiOriginCountryName"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a href="javascript:void(0)"
                                   data-bind="click: $parent.openUpdateProduct.bind($data, $data, $index(), 1)">
                                    <i class="fa fa-lg fa-edit"></i>
                                </a>
                                <a href="javascript:void(0)" data-bind="click: $parent.removeProduct.bind($data, $index())">
                                    <i class="fa fa-lg fa-trash"></i>
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
<%--                                data-bind="event: { change: addProductFromExcel}"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/06/templates?type=product">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i>Mẫu dữ liệu nhập từ file excel--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </form>
    </fieldset>
    <fieldset data-bind="with: exporterVM ">
        <legend><b><spring:message code="mard.06.tokhai.thong_tin_cong_ty_xk"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addAnimalExporter"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: fiExporterCountryList"></span>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%" class="text-center"><spring:message
                                    code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center">
                                <spring:message
                                        code="mard.06.table.ten_cong_ty_xk"/></th>
                            <th class="text-center">
                                <spring:message
                                        code="mard.06.table.dia_chi_cong_ty_xk"/></th>
                            <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                <spring:message code="mard.table.chuc_nang"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: fiExporterCountryList">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiExporterCountryName"></td>
                            <td data-bind="text : fiExporterCountryAddress"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a href="javascript:void(0)"
                                   data-bind="click: $parent.openUpdateExporter.bind($data, $data, $index(), 1)">
                                    <i class="fa fa-lg fa-edit"></i>
                                </a>
                                <a href="javascript:void(0)" data-bind="click: $parent.removeExporter.bind($data, $index())">
                                    <i class="fa fa-lg fa-trash"></i>
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
<%--                        <label>Nhập danh sách công ty nước xuất khẩu theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: addExporterFromExcel}"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/06/templates?type=exporter">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i>Mẫu dữ liệu nhập từ file excel--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </form>
    </fieldset>
    <fieldset data-bind="with: productMfrVM">
        <legend><b><spring:message code="mard.06.tokhai.thong_tin_co_so_nuoi_trong"/></b>
            <a class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addAnimalProdMfr"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: fiProcessingList"></span>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%" class="text-center"><spring:message
                                    code="common.tokhai.hanghoa.stt"/></th>
                            <th style="width: 35%" class="text-center">
                                <spring:message
                                        code="mard.06.table.ten_cssx"/></th>
                            <th style="width: 35%" class="text-center">
                                <spring:message
                                        code="mard.06.table.dc_cssx"/></th>
                            <th class="text-center">
                                <spring:message
                                        code="mard.06.table.ma_so"/></th>
                            <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                <spring:message code="mard.table.chuc_nang"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: fiProcessingList">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiProcessingName"></td>
                            <td data-bind="text : fiProcessingAddress"></td>
                            <td data-bind="text : fiProcessingApprovalNumber"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a href="javascript:void(0)"
                                   data-bind="click: $parent.openUpdateProdMfr.bind($data, $data, $index(), 1)">
                                    <i class="fa fa-lg fa-edit"></i>
                                </a>
                                <a href="javascript:void(0)" data-bind="click: $parent.removeProductMfr.bind($data, $index())">
                                    <i class="fa fa-lg fa-trash"></i>
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
<%--                        <label>Nhập danh sách cơ sở theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: addProcessingFromExcel}"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/06/templates?type=processing">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i>Mẫu dữ liệu nhập từ file excel--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </form>
    </fieldset>
    <fieldset data-bind="with: isoLocationVM">
        <legend><b><spring:message code="mard.06.tokhai.thong_tin_noi_cach_ly"/></b>
            <a style="margin-left: 15px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addAnimalIsoLocation"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <span class="nsw-require-field" data-bind="validationMessage: fiLocationQuarantineList"></span>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%" class="text-center"><spring:message
                                    code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center">
                                <spring:message
                                        code="mard.06.table.ten_noi_cach_ly"/></th>
                            <th class="text-center">
                                <spring:message
                                        code="mard.06.table.dia_diem_cach_ly"/></th>
                            <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                <spring:message code="mard.table.chuc_nang"/></th>
                        </tr>
                        </thead>
                        <tbody id="isoLocationItems"
                               data-bind="foreach: fiLocationQuarantineList">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiLocationQuarantineName"></td>
                            <td data-bind="text : fiLocationQuarantineAddress"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a href="javascript:void(0)"
                                   data-bind="click: $parent.openUpdateIsoLocation.bind($data, $data, $index(), 1)">
                                    <i class="fa fa-lg fa-edit"></i>
                                </a>
                                <a href="javascript:void(0)"
                                   data-bind="click: $parent.removeIsoLocation.bind($data, $index())">
                                    <i class="fa fa-lg fa-trash"></i>
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
<%--                        <label>Nhập danh sách nơi cách ly kiểm dịch theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: addLocationQuaratineFromExcel }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/06/templates?type=location_quarantine">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i>Mẫu dữ liệu nhập từ file excel--%>
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
                            code="mard.06.tokhai.cua_khau_nhap"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiBordergateName, enable: $root.isEditable()"
                            class="form-control"
                    />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.06.tokhai.thoi_gian_thuc_hien"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="trimedValue: fiTimeQuarantine, enable: $root.isEditable()"
                            class="form-control" type="text"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.muc_dich_su_dung"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select
                            data-bind="options: lstPurpose,
                                                 optionsCaption: '<spring:message code="mard.08.tokhai.select_purpose"/>',
                                                 value: fiPurpose, enable: $root.isEditable()"
                            class="form-control"></select>
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
                            data-bind="trimedValue: fiRelatedDocuments, enable: $root.isEditable()"
                            class="form-control"/>
                </div>
            </div>
        </div>
    </form>
    <!-- modal -->
    <div id="modal_addAnimal" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_hang_hoa"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_thuong_mai"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProductBusinessName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_khoa_hoc"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProductScienceName"
                                class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.kich_co_ca_the"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiSizeOrType"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.so_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input type="number"
                               data-bind="value: fiQuantity"
                               class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.06.select.don_vi_tinh"/>',
                                                    value: fiPackageUnitCode" class="form-control"></select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.nuoc_xuat_xu"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstCountry,
                                                    optionsText: 'countryname',
                                                    optionsValue: 'countrycode',
                                                    optionsCaption: '<spring:message code="mard.06.select.country"/>',
                                                    value: fiOriginCountryCode" class="form-control"></select>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addProduct"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_editProduct1" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_hang_hoa"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_thuong_mai"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProductBusinessName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_khoa_hoc"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProductScienceName"
                                class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.kich_co_ca_the"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiSizeOrType"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.so_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input type="number"
                               data-bind="value: fiQuantity"
                               class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstUOMAnimal,
                                                    optionsText: 'unitname',
                                                    optionsValue: 'unitcode',
                                                    optionsCaption: '<spring:message code="mard.06.select.don_vi_tinh"/>',
                                                    value: fiPackageUnitCode" class="form-control"></select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.nuoc_xuat_xu"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstCountry,
                                                    optionsText: 'countryname',
                                                    optionsValue: 'countrycode',
                                                    optionsCaption: '<spring:message code="mard.06.select.country"/>',
                                                    value: fiOriginCountryCode" class="form-control"></select>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: updateProduct"
                >
                    <spring:message code="mard.button.cap_nhat"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div data-bind="with: exporterVM" id="modal_addAnimalExporter" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.06.tokhai.thong_tin_cong_ty_xk"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_cong_ty_xk"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiExporterCountryName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.dia_chi_cong_ty_xk"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiExporterCountryAddress"
                                class="form-control"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addExporter"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div data-bind="with: exporterVM" id="modal_editExporter1" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.06.tokhai.thong_tin_cong_ty_xk"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_cong_ty_xk"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiExporterCountryName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.dia_chi_cong_ty_xk"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiExporterCountryAddress"
                                class="form-control"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: updateExporter"
                >
                    <spring:message code="mard.button.cap_nhat"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_addAnimalProdMfr" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productMfrVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.06.tokhai.co_so_sx"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_cssx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProcessingName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.dc_cssx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProcessingAddress"
                                class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ma_so"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProcessingApprovalNumber"
                                class="form-control" value=""/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addProdMfr"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_editProdMfr1" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productMfrVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.06.tokhai.co_so_sx"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_cssx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProcessingName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.dc_cssx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProcessingAddress"
                                class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ma_so"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiProcessingApprovalNumber"
                                class="form-control" value=""/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: updateProdMfr"
                >
                    <spring:message code="mard.button.cap_nhat"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_addAnimalIsoLocation" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: isoLocationVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.06.tokhai.thong_tin_noi_cach_ly"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_noi_cach_ly"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiLocationQuarantineName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.dia_diem_cach_ly"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiLocationQuarantineAddress"
                                class="form-control"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addIsoLocation"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_editIsoLocation1" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: isoLocationVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.06.tokhai.thong_tin_noi_cach_ly"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.ten_noi_cach_ly"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiLocationQuarantineName"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.06.table.dia_diem_cach_ly"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiLocationQuarantineAddress"
                                class="form-control"/>
                    </div>
                </div>
            </form>
            <div class="text-center">
                <span class="nsw-require-field" data-bind="text: errorMsg"></span>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: updateIsoLocation"
                >
                    <spring:message code="mard.button.cap_nhat"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
</div>
