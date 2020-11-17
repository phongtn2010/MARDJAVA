<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div data-bind="with: thongtinHangHoa">
    <fieldset data-bind="with: productVM">
        <legend><b><spring:message code="sbv.02.thongtin_hanghoa"/></b>
            <a style="margin-left: 10px" class="btn green" title=""
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addProduct"
               data-toggle="modal"><i class="fa fa-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
<%--                    <span class="nsw-require-field" data-bind="validationMessage: fiProductList"></span>--%>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th style="width: 5%" class="text-center"><spring:message
                                    code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message code="sbv.02.dien_giai"/></th>
                            <th class="text-center"><spring:message code="sbv.02.ham_luong"/></th>
                            <th class="text-center"><spring:message code="sbv.02.khoi_luong"/></th>
                            <th class="text-center"><spring:message code="sbv.02.gia_tri_uoc_tinh"/></th>
                            <th style="width: 8%" class="text-center" data-bind="visible: $root.isEditable()">
                                <spring:message code="sbv.02.thao_tac"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: fiProductList">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiDienGiai">
                            </td>
                            <td data-bind="text : fiHamLuong">
                            </td>
                            <td data-bind="text : fiKhoiLuong"></td>
                            <td class="text-right" data-bind="text : fiGiaTriUocTinh"></td>
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
        </form>
    </fieldset>
    <form role="form" class="form-horizontal">
        <div class="form-group" data-bind="visible: $root.isEditable()">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>Nhập danh sách hàng hóa theo file</label>
                </div>
                <div class="col-md-10">
                    <input
                            data-bind="event: { change: function(data, event){ addProductFromExcel(data, event, 'animal') } }"
                            type="file"
                            class="form-control"
                            accept=".xlsx"
                    />
                    <div style="margin-top: 5px;">
                        <a style="font-style: italic" href="">
                            <i class="fa fa-download" aria-hidden="true"></i>Mẫu dữ liệu nhập từ file excel
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="sbv.02.cua_nhap_khau"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select
                            data-bind="options: lstCuaKhau,
                                                    optionsText: 'fiTenCuaKhau',
                                                    optionsValue: 'fiIdCuaKhau',
                                                    value: fiIdCuaKhau" class="form-control"></select>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="sbv.02.thoi_gian_nhap"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker: fiThoiGianXNK , enable: $root.isEditable()"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                </div>
                <div class="col-md-4 nsw-text-right">
                    <input name="CapLanDau" type="radio" value="1" data-bind="checked: fiCapLanDau">
                    <label><spring:message code="sbv.02.cap_lan_dau"/></label>
                    <input name="CapLanDau" type="radio" value="0" data-bind="checked: fiCapLanDau">
                    <label><spring:message code="sbv.02.cap_tiep"/></label>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="sbv.02.so_giay_phep"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input data-bind="value: fiSoGiayDaCap"
                            class="form-control">
                    </input>
                </div>
            </div>
        </div>
    </form>
    <!-- modal -->
    <div id="modal_addProduct" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="sbv.02.thongtin_hanghoa"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.dien_giai"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiDienGiai"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.ham_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiHamLuong"
                                class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.khoi_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiKhoiLuong"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstDVT,
                                                    optionsText: 'fiDonViTinh',
                                                    optionsValue: 'fiIdDonViTinh',
                                                    value: fiIdDonViTinh" class="form-control"></select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.gia_tri_uoc_tinh"/><a
                                class="nsw-require-field"></a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="value: fiGiaTriUocTinh"
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
            <b class="modal-title"><spring:message code="sbv.02.thongtin_hanghoa"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.dien_giai"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiDienGiai"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.ham_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiHamLuong"
                                class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.khoi_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="trimedValue: fiKhoiLuong"
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="value: fiDonViTinh"
                                class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="sbv.02.gia_tri_uoc_tinh"/><a
                                class="nsw-require-field"></a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="value: fiGiaTriUocTinh"
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
                        data-bind="click: updateProduct"
                >
                    <spring:message code="common.button.sua_hang_hoa"/>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
</div>

