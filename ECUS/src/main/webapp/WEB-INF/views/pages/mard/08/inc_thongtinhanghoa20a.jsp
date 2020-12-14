<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div data-bind="with: regQltVM">
    <fieldset data-bind="with: exporterVM">
        <legend><b><spring:message code="mard.08.tokhai.ben_ban_hang"/></b>
            <a href="javacript:void(0)" style="margin-left: 10px;" class="btn green"
               title="<spring:message code="mard.08.button.them_moi"/>"
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addQltExporter"
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
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.hang_nuoc"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_ben_ban_hang"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.dien_thoai"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.fax"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.dia_chi"/></th>
                            <th class="text-center" data-bind="visible: $root.isEditable()"><spring:message
                                    code="mard.08.table.col.thaotac"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstExporter">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiExporterName">
                            </td>
                            <td data-bind="text : $parent.getCountryName(fiCountryOrigin)"></td>
                            </td>
                            <td data-bind="text : fiExporterTel"></td>
                            <td data-bind="text : fiExporterFax"></td>
                            <td data-bind="text : fiExporterAddress"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px" title="Sửa" data-target="#modal_addQltExporter"
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
                    <b><spring:message code="common.tong"/>: </b><span
                        data-bind="text: lstExporter().length"></span><br/>
                    <form role="form" class="form-horizontal">
<%--                        <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                            <div class="col-md-12">--%>
<%--                                <div class="col-md-2 nsw-text-right">--%>
<%--                                    <label>Nhập danh sách bên bán hàng theo file</label>--%>
<%--                                </div>--%>
<%--                                <div class="col-md-10">--%>
<%--                                    <input--%>
<%--                                            data-bind="event: { change: function(data, event){ addExportFromExcel(event, 'buyer') } }"--%>
<%--                                            type="file"--%>
<%--                                            class="form-control"--%>
<%--                                            accept=".xlsx"--%>
<%--                                    />--%>
<%--                                    <div style="margin-top: 5px;">--%>
<%--                                        <a style="font-style: italic" href="/mard/08/templates?type=buyer">--%>
<%--                                            <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                                        </a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="form-group" style="padding-top: 10px;">
                            <div class="col-md-12">
                                <div class="col-md-2 nsw-text-right">
                                    <label><spring:message code="mard.08.table.col.noi_xuat_hang"/><a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input data-bind="trimedValue: $parent.fiSrcPortName, enable: $root.isEditable()"
                                           class="form-control" type="text"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </form>
    </fieldset>
    <fieldset>
        <legend><b><spring:message code="mard.08.table.title.thong_tin_hang_hoa"/></b>
            <a data-bind="visible: $root.isEditable() && $parent.fiHSType() == '4'" style="margin-left: 10px;"
               class="btn green" title="<spring:message code="mard.08.button.them_moi"/>"
               data-target="#modal_addQltAnimalProduct"
               data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
            </a>
            <a data-bind="visible: $root.isEditable() && $parent.fiHSType() == '5'" style="margin-left: 10px;"
               class="btn green" title="<spring:message code="mard.08.button.them_moi"/>"
               data-target="#modal_addQltProduct"
               data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
            </a>
        </legend>
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.tokhai.select_loai_hang_hoa"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10">
                        <select class="form-control" data-bind="value: $parent.fiHSType, enable: $root.isEditable()">
                            <option value="4">
                                <spring:message code="mard.08.tokhai.radio_dong_vat"/>
                            </option>
                            <option value="5">
                                <spring:message code="mard.08.tokhai.radio_sp_dong_vat"/>
                            </option>
                        </select>
                    </div>
                </div>
            </div>
        </form>
        <div data-bind="visible: $parent.fiHSType() == '4', with: animalProductVM">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <span class="nsw-require-field" data-bind="validationMessage: lstProduct"></span>
                        <table class="table table-striped table-bordered table-hover order-column">
                            <thead>
                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                <th style="width: 5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.ten_hang"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.ten_khoa_hoc"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.so_luong"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.nuoc_xuat_xu"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.so_cong_nhan_tacn"/></th>
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
                                <td data-bind="text : fiProductScienceName">
                                </td>
                                <td class="text-right" data-bind="text : fiNumber"></td>
                                <td data-bind="text : $parent.getCountryName(fiCountryOrigin)"></td>
                                <td data-bind="text : fiCirculateNo"></td>
                                <td class="text-center" data-bind="visible: $root.isEditable()">
                                    <a style="margin-bottom: 5px" title="Sửa" data-target="#modal_addQltAnimalProduct"
                                       data-toggle="modal">
                                        <i style="color: #337ab7" class="fa fa-lg fa-edit" aria-hidden="true"
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
                        <b><spring:message code="common.tong"/>: </b><span
                            data-bind="text: lstProduct().length"></span><br/>
                    </div>
                </div>
<%--                <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                    <div class="col-md-12">--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label>Nhập danh sách hàng hóa theo file</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-10">--%>
<%--                            <input--%>
<%--                                    data-bind="event: { change: function(data, event){ addProductFromExcel(event, 'animal_20a') } }"--%>
<%--                                    type="file"--%>
<%--                                    class="form-control"--%>
<%--                                    accept=".xlsx"--%>
<%--                            />--%>
<%--                            <div style="margin-top: 5px;">--%>
<%--                                <a style="font-style: italic" href="/mard/08/templates?type=animal_20a">--%>
<%--                                    <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </form>
        </div>
        <div data-bind="visible: $parent.fiHSType() == '5', with: productVM">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <span class="nsw-require-field" data-bind="validationMessage: lstProduct"></span>
                        <table class="table table-striped table-bordered table-hover order-column">
                            <thead>
                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                <th style="width: 5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.ten_hang"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.ten_khoa_hoc"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.so_luong"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.loai_bao_bi"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.cach_dong_goi"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.khoi_luong_tinh"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.don_vi_tinh_khoi_luong_tinh"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.khoi_luong_ca_bi"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.don_vi_tinh_khoi_luong_ca_bi"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.nuoc_xuat_xu"/></th>
                                <th class="text-center"><spring:message
                                        code="mard.08.table.col.so_cong_nhan_tacn"/></th>
                                <th style="width: 10%" class="text-center" data-bind="visible: $root.isEditable()"><spring:message
                                        code="mard.08.table.col.thaotac"/></th>
                            </tr>
                            </thead>
                            <tbody
                                    data-bind="foreach: lstProduct">
                            <tr>
                                <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                <td data-bind="text : fiProductName">
                                </td>
                                <td data-bind="text : fiProductScienceName">
                                </td>
                                <td class="text-right" data-bind="text : fiNumber"></td>
                                <td data-bind="text : $parent.getUnitName(fiUnitCode)"></td>
                                <td data-bind="text : fiPackingType"></td>
                                <td class="text-right" data-bind="text : fiNetWeight"></td>
                                <td data-bind="text : $parent.getUnitName(fiNWUnitCode)"></td>
                                <td class="text-right" data-bind="text : fiGrossWeight"></td>
                                <td data-bind="text : $parent.getUnitName(fiGWUnitCode)"></td>
                                <td data-bind="text : $parent.getCountryName(fiCountryOrigin)"></td>
                                <td data-bind="text : fiCirculateNo"></td>
                                <td class="text-center" data-bind="visible: $root.isEditable()">
                                    <a style="margin-bottom: 5px" title="Sửa">
                                        <i style="color: #337ab7" class="fa fa-lg fa-edit" data-toggle="modal"
                                           data-target="#modal_addQltProduct" aria-hidden="true"
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
                        <b><spring:message code="common.tong"/>: </b><span
                            data-bind="text: lstProduct().length"></span><br/>
                    </div>
                </div>
<%--                <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                    <div class="col-md-12">--%>
<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label>Nhập danh sách hàng hóa theo file</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-10">--%>
<%--                            <input--%>
<%--                                    data-bind="event: { change: function(data, event){ addProductFromExcel(event, 'animal_product_20a') } }"--%>
<%--                                    type="file"--%>
<%--                                    class="form-control"--%>
<%--                                    accept=".xlsx"--%>
<%--                            />--%>
<%--                            <div style="margin-top: 5px;">--%>
<%--                                <a style="font-style: italic" href="/mard/08/templates?type=animal_product_20a">--%>
<%--                                    <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </form>
        </div>
    </fieldset>
    <fieldset data-bind="with: productMfrVM">
        <legend><b><spring:message code="mard.08.table.title.thong_tin_cssx"/></b>
            <a style="margin-left: 10px" class="btn green" title="<spring:message code="mard.08.button.them_moi"/>"
               data-bind="visible: $root.isEditable()"
               data-target="#modal_addQltProdMfr"
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
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.co_so_sx"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.dia_chi_cssx"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_sx"/></th>
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
                            <td data-bind="text : $parent.getCountryName(fiMfrCountryrigin)"></td>
                            <td class="text-center" data-bind="visible: $root.isEditable()">
                                <a style="margin-bottom: 5px" title="Sửa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-edit" data-toggle="modal"
                                       data-target="#modal_addQltProdMfr" aria-hidden="true"
                                       data-bind="click: function(){$parent.update($index())}"></i>
                                </a>
                                <a style="margin-bottom: 5px;" title="Xóa">
                                    <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                       data-bind="click: function(){$parent.removeProductMfr($index())}"></i>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <b><spring:message code="common.tong"/></b>: <span
                        data-bind="text: lstProdMfr().length"></span>
                    <br/>
                </div>
            </div>
<%--            <div class="form-group" data-bind="visible: $root.isEditable()">--%>
<%--                <div class="col-md-12">--%>
<%--                    <div class="col-md-2 nsw-text-right">--%>
<%--                        <label>Nhập danh sách cơ sở sản xuất theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: function(data, event){ addProdMfrFromExcel(event) } }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/08/templates?type=prodmfr_20a">--%>
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
                            code="mard.08.tokhai.dia_diem_tap_ket_hang"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="trimedValue: fiStorageLocation, enable: $root.isEditable()"
                           maxlength="250"
                    />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.dia_diem_dang_ky_lay_mau"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="trimedValue: fiSamplingLocation, enable: $root.isEditable()"
                           maxlength="250"
                    />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.ngay_dk_lay_mau_tu"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="datepicker2 : fiSamplingDateFrom, datepickerOptions: { endDate: fiSamplingDateTo }, enable: $root.isEditable()"
                           class="form-control form-control-inline date-picker"
                           data-date-format="dd/mm/yyyy" type="text" value=""
                           maxlength="10"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.ngay_dk_lay_mau_den"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="datepicker2 : fiSamplingDateTo, datepickerOptions: { startDate: fiSamplingDateFrom }, enable: $root.isEditable()"
                           class="form-control form-control-inline date-picker"
                           data-date-format="dd/mm/yyyy" type="text" value=""
                           maxlength="10"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.thong_tin_nguoi_lien_he"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="trimedValue: fiContactName, enable: $root.isEditable()"
                           maxlength="250"
                    />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.table.col.dien_thoai"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="trimedValue: fiContactTel, enable: $root.isEditable()"
                           maxlength="15"
                    />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.table.col.email"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="trimedValue: fiContactEmail, enable: $root.isEditable()" type="email"
                           maxlength="50"
                    />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.address"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="trimedValue: fiContactAddress, enable: $root.isEditable()"
                           maxlength="250"
                    />
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
                    <input class="form-control"
                           data-bind="trimedValue: fiIntendedPurpose, enable: $root.isEditable()"
                           maxlength="500"
                    />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.08.tokhai.van_ban_chap_thuan_kd_dvnk"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control"
                           data-bind="trimedValue: fiProvidedDocument, enable: $root.isEditable()"
                           maxlength="250"
                    />
                </div>
            </div>
        </div>
    </form>
    <%@include file="inc_document.jsp" %>
    <!-- modal -->
    <div id="modal_addQltExporter" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: exporterVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message
                    code="mard.08.table.title.thong_tin_ben_ban_hang"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.hang_nuoc"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiExporterName"
                               class="form-control" value="" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.nuoc_ben_ban_hang"/><a
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
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dien_thoai"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiExporterTel"
                               class="form-control" maxlength="50"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.fax"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiExporterFax"
                               class="form-control" maxlength="50"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dia_chi"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiExporterAddress"
                               class="form-control" maxlength="250"/>
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
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_addQltProduct" class="modal container in modal-overflow" tabindex="-1"
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
                        <label><spring:message code="mard.08.table.col.ten_khoa_hoc"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiProductScienceName"
                               class="form-control" maxlength="250"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.so_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiNumber"
                               class="form-control" value="" type="number"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.loai_bao_bi"/><a
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
                        <label><spring:message code="mard.08.table.col.cach_dong_goi"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiPackingType"
                               class="form-control" value="" type="text" maxlength="255"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.khoi_luong_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiNetWeight"
                               class="form-control" value="" type="number"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.don_vi_tinh_khoi_luong_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                disabled
                                data-bind="options: lstUOMs,
                                                optionsText: 'unitname',
                                                optionsValue: 'unitcode',
                                                optionsCaption: '<spring:message code="mard.08.tokhai.select_don_vi"/>',
                                                value: fiNWUnitCode" class="form-control"></select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.khoi_luong_ca_bi"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiGrossWeight"
                               class="form-control" value="" type="number"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.don_vi_tinh_khoi_luong_ca_bi"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                disabled
                                data-bind="options: lstUOMs,
                                                optionsText: 'unitname',
                                                optionsValue: 'unitcode',
                                                optionsCaption: '<spring:message code="mard.08.tokhai.select_don_vi"/>',
                                                value: fiGWUnitCode" class="form-control"></select>
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
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.so_cong_nhan_tacn"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiCirculateNo"
                               class="form-control" maxlength="250"/>
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
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_addQltAnimalProduct" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: animalProductVM"
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
                        <label><spring:message code="mard.08.table.col.ten_khoa_hoc"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiProductScienceName"
                               class="form-control" maxlength="250"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.so_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="value: fiNumber"
                               class="form-control" value="" type="number"/>
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
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.so_cong_nhan_tacn"/></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiCirculateNo"
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
                <button class="btn green" data-bind="click: addProduct">
                    <span data-bind="visible: !isEdit()"><spring:message code="conmon.button.them"/></span>
                    <span data-bind="visible: isEdit()"><spring:message code="common.button.sua"/></span>
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_addQltProdMfr" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false" data-bind="with: productMfrVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.08.table.title.thong_tin_cssx"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.co_so_sx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiMfrName"
                               class="form-control" value="" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.dia_chi_cssx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input data-bind="trimedValue: fiMfrAddress"
                               class="form-control" maxlength="500"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.08.table.col.nuoc_sx"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                data-bind="options: lstCountry,
                                                optionsText: 'countryname',
                                                optionsValue: 'countrycode',
                                                optionsCaption: '<spring:message code="mard.08.tokhai.select_country"/>',
                                                value: fiMfrCountryrigin" class="form-control"></select>
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
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
</div>
<script>
    // $(".numeric").live("keypress keyup", function (event) {
    //     //    console.log('numeric = '+$(this).val());
    //     $(this).val($(this).val().replace(/[^0-9\,\.]/g, ''));
    //
    //     if (event.which != 8 && (event.which != 44 || $(this).val().indexOf(',') != -1) && (event.which < 48 || event.which > 57)) {
    //         event.preventDefault();
    //     }
    // });
</script>
