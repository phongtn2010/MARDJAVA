<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row" data-bind="with: registerAnimalProductVM">
    <div class="col-md-12" style="padding-left: 30px">
        <fieldset>
            <legend><b><spring:message
                    code="mard.01.table.title.thong_tin_sp_dong_vat"/></b>
                <button class="btn green" title=""
                        data-target="#modal_addAnimalProduct"
                        data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                </button>
            </legend>
            <div data-bind="with: addAnimalProductVM">
                <div id="modal_addAnimalProduct" class="modal container in modal-overflow"
                     data-backdrop="static" data-keyboard="false"
                >
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                        <b class="modal-title"><spring:message
                                code="mard.01.table.title.thong_tin_sp_dong_vat_tren_can"/></b>
                    </div>
                    <div class="modal-body">
                        <form role="form" class="form-horizontal">
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.ten_hang"/> <a
                                            class="nsw-require-field">*</a><br>
                                    </label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" id="fiProductNameVni" name="fiProductNameVni"
                                           data-bind="value: fiProductNameVni"
                                           maxlength="250"
                                    />
                                </div>
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.ten_hang_eng"/> <a
                                            class="nsw-require-field">*</a><br>
                                    </label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" id="fiProductName" name="fiProductName"
                                           data-bind="value: fiProductName"
                                           maxlength="250"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.ma_hs"/></label>
                                    <span><i> (bắt buộc với sản phẩm xuất sang Trung Quốc)</i></span>
                                </div>
                                <div class="col-md-4" style="display: flex;align-items: start">
                                        <input class="form-control" id="fiHSCode" name="fiHSCode"
                                               data-bind="value: fiHSCode"
                                               maxlength="50"
                                        />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.quy_cach_dong_goi"/> <a
                                            class="nsw-require-field">*</a><br>
                                    </label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" id="fiPackageTypeVni" name="fiPackageTypeVni"
                                           data-bind="value: fiPackageTypeVni"
                                           maxlength="250"
                                    />
                                </div>
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.quy_cach_dong_goi_eng"/> <a
                                            class="nsw-require-field">*</a><br>
                                    </label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" id="fiPackageType" name="fiPackageType"
                                           data-bind="value: fiPackageType"
                                           maxlength="250"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.so_luong"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" type="number" id="fiNumber" name="fiNumber"
                                           data-bind="value: fiNumber"
                                           oninput="if(value.length>15)value=value.slice(0,15)"
                                    />

                                </div>
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.don_vi_tinh_so_luong"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <select class="form-control" id="2"
                                            data-bind="optionsCaption: 'Chọn...',
                                                value: fiUnitCode,
                                                options: lstUOMWeight,
                                                optionsValue: 'fiUnitCode',
                                                optionsText : 'fiUnitNameVni'"></select>

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.khoi_luong"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" id="fiNetWeight" type="number" name="fiNetWeight"
                                           data-bind="value: fiNetWeight"
                                           oninput="if(value.length>18)value=value.slice(0,18)"
                                    />

                                </div>
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.don_vi_tinh_khoi_luong"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <select
                                            disabled
                                            class="form-control" id="1" name="fiMaDvkd"
                                            data-bind="optionsCaption: 'Chọn...', value: fiNetWeightUnitCode, options: lstUOMWeight, optionsValue: 'fiUnitCode', optionsText : 'fiUnitNameVni'"></select>

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.ngay_san_xuat_tu"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           data-bind="datepicker : fiFromDateProduct"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" type="text" value=""
                                           maxlength="10"/>

                                </div>
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.ngay_san_xuat_den"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           data-bind="datepicker : fiToDateProduct"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" type="text" value=""
                                           maxlength="10"/>

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.muc_dich_su_dung"/> <a
                                            class="nsw-require-field">*</a>
                                    </label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" id="fiPurposeVni" name="fiPurposeVni"
                                           data-bind="value: fiPurposeVni"
                                           maxlength="250"
                                    />
                                </div>
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.muc_dich_su_dung_eng"/> <a
                                            class="nsw-require-field">*</a>
                                    </label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" id="fiPurpose" name="fiPurpose"
                                           data-bind="value: fiPurpose"
                                           maxlength="250"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.gia_tri"/>
                                    </label>
                                </div>
                                <div class="col-md-10">
                                    <input type="number" class="form-control" id="fiShipmentvalue"
                                           name="fiShipmentvalue"
                                           data-bind="value: fiShipmentvalue"
                                           oninput="if(value.length>18)value=value.slice(0,18)"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.mark_no"/>/<spring:message code="mard.01.table.col.mark_no_eng"/>
                                    </label>
                                </div>
                                <div class="col-md-10">
                                    <input type="text" class="form-control" id="fiMarkNo" name="fiMarkNo"
                                           data-bind="value: fiMarkNo"
                                           maxlength="50"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.so_dinh_danh"/>
                                        <a class="nsw-require-field">*</a>
                                    </label>
                                </div>
                                <div class="col-md-10">
                                    <input class="form-control" id="fiLotIdentificationNo"
                                           name="fiLotIdentificationNo"
                                           data-bind="value: fiLotIdentificationNo"
                                           maxlength="100"
                                    />
                                </div>
                            </div>
                            <p id="add-animal-product-validate" class="nsw-require-field validate"
                               style="text-align: center"></p>

                        </form>
                    </div>
                    <div class="modal-footer" style="">
                        <div class="text-center">
                            <button class="btn green" data-bind="click: addAnimalProduct">
                                <spring:message code="common.button.luu"/>
                            </button>
                            <button class="btn" data-dismiss="modal" data-bind="click: clearForm">
                                <spring:message code="conmon.button.dong"/>
                            </button>
                        </div>
                    </div>
                    </form>
                </div>

            </div>
            <!-- end modal -->
            <div class="panel-body">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <tr>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th style="width: 50px" class="text-center"><spring:message code="mard.01.table.col.STT"/></th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.ten_san_pham"/><br>
                            <spring:message
                                    code="mard.01.table.col.ten_san_pham_eng"/><br>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.ma_hs"/><br>
                            <spring:message
                                    code="mard.01.table.col.ma_hs_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.quy_cach_dong_goi"/><br>
                            <spring:message
                                    code="mard.01.table.col.quy_cach_dong_goi_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.so_luong"/><br>
                            <spring:message
                                    code="mard.01.table.col.so_luong_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.don_vi_tinh"/><br>
                            <spring:message
                                    code="mard.01.table.col.don_vi_tinh_eng"/>

                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.khoi_luong"/><br>
                            <spring:message
                                    code="mard.01.table.col.khoi_luong_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.don_vi_tinh_khoi_luong"/><br>
                            <spring:message
                                    code="mard.01.table.col.don_vi_tinh_khoi_luong_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.muc_dich_su_dung"/><br>
                            <spring:message
                                    code="mard.01.table.col.muc_dich_su_dung_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.gia_tri"/><br>
                            <spring:message
                                    code="mard.01.table.col.gia_tri_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.mark_no"/><br>
                            <spring:message
                                    code="mard.01.table.col.mark_no_eng"/>
                        </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.ngay_san_xuat"/><br>
                            <spring:message
                                    code="mard.01.table.col.ngay_san_xuat_eng"/>
                        </th>
                    <th class="text-center">
                        <spring:message
                                code="mard.01.table.col.ngay_san_xuat_den"/><br>
                        <spring:message
                                code="mard.01.table.col.ngay_san_xuat_den_eng"/>
                    </th>
                        <th class="text-center">
                            <spring:message
                                    code="mard.01.table.col.so_dinh_danh"/><br>
                            <spring:message
                                    code="mard.01.table.col.so_dinh_danh_eng"/>
                        </th>
                        <th class="text-center">Thao tác</th>
                    </tr>
                    </tr>
                    <tbody data-bind="foreach: fiAnimalProductList">
                    <tr>
                        <td class="text-center" data-bind="text: $index() + 1"></td>
                        <td class="text-center">
                            <p data-bind="text: fiProductNameVni"></p>
                            <span data-bind="text: fiProductName" style="font-style: italic"></span>
                        </td>
                        <td class="text-center" data-bind="text: fiHSCode"></td>
                        <td class="text-center">
                            <p data-bind="text: fiPackageTypeVni"></p>
                            <span data-bind="text: fiPackageType" style="font-style: italic"></span>
                        </td>
                        <td class="text-right" data-bind="text: fiNumber"></td>
                        <td class="text-center">
                            <p data-bind="text: fiUnitVni"></p>
                            <span data-bind="text: fiUnit" style="font-style: italic"></span>
                        </td>
                        <td class="text-right" data-bind="text: fiNetWeight"></td>
                        <td class="text-right">
                            <p data-bind="text: fiNetWeightUnitVni"></p>
                            <span data-bind="text: fiNetWeightUnit" style="font-style: italic"></span>
                        </td>
                        <td class="text-center">
                            <p data-bind="text: fiPurposeVni"></p>
                            <span data-bind="text: fiPurpose" style="font-style: italic"></span>
                        </td>
                        <td class="text-right" data-bind="text: fiShipmentvalue"></td>
                        <td class="text-right" data-bind="text: fiMarkNo"></td>
                        <td class="text-center" data-bind="date: fiFromDateProduct"></td>
                        <td class="text-center" data-bind="date: fiToDateProduct"></td>
                        <td class="text-center" data-bind="text: fiLotIdentificationNo"></td>
                        <td class="text-center">
                            <a style="margin-bottom: 5px; " data-target="#modal_addAnimalProduct"
                               data-toggle="modal" title="Sửa"
                               data-bind="click: function(){$parent.onUpdateAnimalProduct($data, $index())}">
                                <i style="color: #337ab7; " class="fa fa-lg fa-edit" aria-hidden="true"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                   data-bind="click: function(){$parent.onDeleteProductAnimal($index())}"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
<%--                <div class="row" style="margin-top: 20px">--%>
<%--                    <div class="col-md-2">--%>
<%--                        <label>Nhập danh sách sản phẩm động vật theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: function(data, event){ addAnimalProductFromExcel(event) } }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/01/templates?type=animal_product">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <p class="nsw-require-field validate" id="fiAnimalProductList-validate" style="text-align: center"></p>

                <div style="margin-top: 20px">
                    <%--                    <div class="row">--%>
                    <%--                        <div class="col-md-2"><spring:message--%>
                    <%--                                code="mard.01.tokhai.nhap_danh_sach_dong_vat_theo_file"/></div>--%>
                    <%--                        <div class="col-md-10">--%>
                    <%--                            <input id="fiTep" class="form-control" type="file"/>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.tongsokhoiluong"/><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10" style="display: flex;align-items: start">
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiTotalAnimalProductByCharVni" maxlength="1000"/>
                                <span class="nsw-require-field validate"
                                      id="fiTotalAnimalProductByCharVni-validate"></span>
                            </div>
                            <div style="width: 4%; text-align: center"><span>/</span></div>
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiTotalAnimalProductByChar" maxlength="1000"
                                    placeholder="<spring:message code="mard.01.tokhai.tongsokhoiluong"/> (Tiếng Anh)"
                                />
                                <span class="nsw-require-field validate"
                                      id="fiTotalAnimalProductByChar-validate"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.so_san_pham_dong_vat_da_xet_nghiem_thu_y"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="value: fiAnimalProductTestNo" maxlength="250"/>
                        </div>
                        <div class="col-md-2" style="display: flex">
                            <label><spring:message
                                    code="mard.01.tokhai.ngay"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="datepicker: fiAnimalProductTestDate" type="text"
                                   data-date-format="dd/mm/yyyy"/>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.ten_co_quan_tra_ket_qua"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="value: fiAnimalProductTestDepartment" maxlength="250"/>
                        </div>
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.ten_nhiet_do_san_pham"/></label>
                        </div>
                        <div class="col-md-4">
                            <select
                                    class="form-control"
                                    data-bind="optionsCaption: 'Chọn...', options:  lstTemperatureProductName, optionsText : 'name', value: fiTemperatureProductName, optionsValue: 'id'"></select>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.ten_dia_chi_nha_may_san_xuat"/><a
                                    class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10" style="display: flex;align-items: start">
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiProcessingNameAddressVni" maxlength="500"/>
                                <span class="nsw-require-field validate"
                                      id="fiProcessingNameAddressVni-validate"></span>
                            </div>
                            <div style="width: 4%; text-align: center"><span>/</span></div>
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiProcessingNameAddress" maxlength="500"
                                    placeholder="<spring:message code="mard.01.tokhai.ten_dia_chi_nha_may_san_xuat"/> (Tiếng Anh)"
                                />
                                <span class="nsw-require-field validate" id="fiProcessingNameAddress-validate"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.dien_thoai_processing"/><a
                                    class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="value: fiProcessingTel" maxlength="50"/>
                            <span class="nsw-require-field validate" id="fiProcessingTel-validate"></span>
                        </div>
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.fax_processing"/><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="value: fiProcessingFax" maxlength="50"/>
                            <span class="nsw-require-field validate" id="fiProcessingFax-validate"></span>
                        </div>
                    </div>
                    <div style="margin-top: 20px">
                        <b><spring:message
                                code="mard.01.tokhai.bat_buoc_voi_sp_ga_va_sua"/></b>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.ten_cang_xep_hang"/></label>
                        </div>
                        <div class="col-md-10" style="display: flex;align-items: start">
                            <div style="width: 46%">
                                <input class="form-control" data-bind="value: fiPortShipmentNameVni" maxlength="100"/>
                            </div>
                            <div style="width: 8%; text-align: center"><span>/</span></div>
                            <div style="width: 46%">
                                <input class="form-control" data-bind="value: fiPortShipmentName" maxlength="100"
                                    placeholder="<spring:message code="mard.01.tokhai.ten_cang_xep_hang"/> (Tiếng Anh)"
                                />
                            </div>
                        </div>
                    </div>
                    <div style="margin-top: 20px">
                        <b><spring:message
                                code="mard.01.tokhai.bat_buoc_voi_sp_thit_lon_va_thit_ga"/></b>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.so_dang_ky_nha_may_san_xuat"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="value: fiProcessingNumberRegistration" maxlength="15"/>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.ten_dia_chi_nha_may_giet_mo"/></label>
                        </div>
                        <div class="col-md-10" style="display: flex;align-items: start">
                            <div style="width: 46%">
                                <input class="form-control" data-bind="value: fiSlaughterHouseNameAddressVni" maxlength="500"/>
                            </div>
                            <div style="width: 8%; text-align: center"><span>/</span></div>
                            <div style="width: 46%">
                                <input class="form-control" data-bind="value: fiSlaughterHouseNameAddress" maxlength="500"
                                    placeholder="<spring:message code="mard.01.tokhai.ten_dia_chi_nha_may_giet_mo"/> (Tiếng Anh)"
                                />
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2">
                            <label><spring:message code="mard.01.tokhai.so_dien_thoai_nha_may_giet_mo"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="value: fiSlaughterHouseTel" maxlength="50"/>
                        </div>
                        <div class="col-md-2">
                            <label><spring:message code="mard.01.tokhai.so_fax_nha_may_giet_mo"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" data-bind="value: fiSlaughterHouseFax" maxlength="50"/>
                        </div>
                    </div>
                    <div style="margin-top: 20px">
                        <b><spring:message code="mard.01.tokhai.doi_voi_sp_thit_ga"/></b>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2">
                            <label><spring:message code="mard.01.tokhai.ngay_giet_mo"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-date-format="dd/mm/yyyy"
                                   data-bind="datepicker: fiSlaughterHouseDate"/>
                        </div>
                        <div class="col-md-2">
                            <label><spring:message code="mard.01.tokhai.ngay_pha_loc"/></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-date-format="dd/mm/yyyy"
                                   data-bind="datepicker: fiProcesssingDate"/>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>
</div>
