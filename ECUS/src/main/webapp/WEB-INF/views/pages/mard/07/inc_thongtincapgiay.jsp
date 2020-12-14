<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fieldset data-bind="visible: fiCongVan(), with: ttnkVM">
    <legend><b><spring:message code="mard.07.tokhai.thong_tin_nhap_khau"/></b></legend>
    <div data-bind="with: productVM">
        <span class="nsw-require-field" data-bind="validationMessage: fiGoodsList"></span>
    </div>
    <div class="panel panel-default" style="margin-top: 15px;" data-bind="with: productVM">
        <div class="panel-heading">
            <span class="caption-subject bold uppercase">
                        <label><spring:message code="mard.07.tokhai.thong_tin_hang_hoa"/> </label>
                    </span>
            <button
                    data-bind="visible: $root.isEditable()"
                    class="btn green"
                    title=""
                    data-target="#modal_addProduct"
                    data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
            </button>
        </div>
        <table class="table table-striped table-bordered table-hover order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th><spring:message code="mard.table.stt"/></th>
                <th><spring:message code="mard.07.table.ten_hang_hoa"/></th>
                <th><spring:message code="mard.07.table.ten_khoa_hoc"/></th>
                <th><spring:message code="mard.07.table.ma_hs_hang_hoa"/></th>
                <th><spring:message code="mard.07.table.loai"/></th>
                <th><spring:message code="mard.07.table.tri_gia"/></th>
                <th><spring:message code="mard.07.table.danh_muc_hang_hoa"/></th>
                <th><spring:message code="mard.07.table.phan_loai"/></th>
                <th><spring:message code="mard.07.table.phuong_thuc_bao_quan"/></th>
                <th><spring:message code="mard.07.table.kich_co_ca_the"/></th>
                <th><spring:message code="mard.07.table.so_luong_trong_luong"/></th>
                <th><spring:message code="mard.07.table.don_vi_tinh"/></th>
                <th><spring:message code="mard.07.table.nuoc_xuat_xu"/></th>
                <th data-bind="visible: $root.isEditable()"><spring:message code="mard.table.chuc_nang"/></th>
            </tr>
            </thead>
            <tbody
                    data-bind="foreach: fiGoodsList">
            <tr>
                <td data-bind="text: ($index() + 1)"></td>
                <td data-bind="text : fiNameOfGoods">
                </td>
                <td data-bind="text : fiNameSicenceOfGoods">
                </td>
                <td data-bind="text : fiHSCodeOfGoods"></td>
                <td data-bind="text : fiSpecies"></td>
                <td data-bind="text : fiValueOfGoods"></td>
                <td data-bind="text : fiCategoryOfGoods"></td>
                <td data-bind="text : fiClassification"></td>
                <td data-bind="text : fiPreservation"></td>
                <td data-bind="text : fiSizeOrShape"></td>
                <td data-bind="text : fiQuantityOrWeight"></td>
                <td data-bind="text : fiQuantityOrWeightUnitName"></td>
                <td data-bind="text : fiOriginationName"></td>
                <td data-bind="visible: $root.isEditable()" class="text-center">
                    <a href="javascript:void(0)" data-bind="click: $parent.openUpdateModal.bind($data, $data, $index())">
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
    <form role="form" class="form-horizontal" style="padding-top: 10px; padding-bottom: 10px;">
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.to_chuc_ca_nhan_xnk"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea data-bind="value: fiExporter, enable: $root.isEditable()" class="form-control" rows="5"></textarea>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.dia_chi_ctyxk"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea
                        data-bind="value: fiExporterCountryAddress, enable: $root.isEditable()"
                        class="form-control"
                        rows="5"
                ></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.ten_cssx"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea data-bind="value: fiProcessingName, enable: $root.isEditable()"
                          rows="5"
                          class="form-control"
                ></textarea>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.dia_chi_cssx"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea
                        data-bind="value: fiProcessingAddress, enable: $root.isEditable()"
                        class="form-control"
                        rows="5"
                ></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.loai_bao_bi"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiPackage, enable: $root.isEditable()"
                        class="form-control"
                        maxlength="255"
                >
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.so_hd_ct"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiContractsNo, enable: $root.isEditable()"
                        class="form-control"
                        maxlength="255"
                >
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.nuoc_xk"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select data-bind="options: lstCountry,
                                        optionsValue: 'countryname',
                                        optionsText: 'countryname',
                                        optionsCaption: '<spring:message code="mard.07.select.nuoc"/>',
                                        value: fiOriginationImport, enable: $root.isEditable()"
                        class="form-control">
                </select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.nuoc_qua_canh"/></label>
            </div>
            <div class="col-md-4">
                <select data-bind="options: lstCountry,
                                        optionsValue: 'countryname',
                                        optionsText: 'countryname',
                                        optionsCaption: '<spring:message code="mard.07.select.nuoc"/>',
                                        value: fiOriginationTransit, enable: $root.isEditable()"
                        class="form-control">
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.cua_khau_xuat"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiPortOfDepartureName, enable: $root.isEditable(),"
                        class="form-control"
                        maxlength="255"
                >
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.cua_khau_nhap"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiPortOfDestinationName, enable: $root.isEditable(),"
                        class="form-control"
                        maxlength="50"
                >
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.phuong_tien_van_chuyen"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiTransportType, enable: $root.isEditable()"
                        class="form-control"
                        maxlength="255"
                >
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.muc_dich_su_dung"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input
                        disabled
                        data-bind="value: fiPurposeUse"
                        class="form-control"
                >
            </div>
        </div>
        <div class="form-group" >
            <div data-bind="visible: $parent.fiCongVan() && $parent.fiCongVan().fiProductType == 1">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.dia_diem_kiem_dich"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select data-bind="options: lstCVLocationQuaratine,
                                        optionsText: 'fiLocationQuarantineName',
                                        optionsValue: 'fiIdQuarLoc',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiLocationOfQuarantineId, enable: $root.isEditable()"
                            class="form-control">
                    </select>
                </div>
            </div>
            <div data-bind="visible: $parent.fiCongVan() && $parent.fiCongVan().fiProductType == 2">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.dia_diem_kiem_dich"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiLocationOfQuarantine, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.dia_diem_nuoi_trong"/></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiLocationOfGrow, enable: $root.isEditable()"
                        class="form-control"
                        maxlength="255"
                >
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.thoi_gian_kd_tu"/></label>
            </div>
            <div class="col-md-4">
                <input
                        data-bind="datepicker2: fiDateOfQuarantineFrom, datepickerOptions: { endDate: fiDateOfQuarantineTo }, enable: $root.isEditable()"
                        class="form-control form-control-inline date-picker"
                        data-date-format="dd/mm/yyyy" type="text" value=""
                        maxlength="10"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.thoi_gian_kd_den"/></label>
            </div>
            <div class="col-md-4">
                <input
                        data-bind="datepicker2: fiDateOfQuarantineTo, datepickerOptions: { startDate: fiDateOfQuarantineFrom }, enable: $root.isEditable()"
                        class="form-control form-control-inline date-picker"
                        data-date-format="dd/mm/yyyy" type="text" value=""
                        maxlength="10"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.dia_diem_giam_sat"/></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiLocationOfMonitor, enable: $root.isEditable()"
                        class="form-control"
                        maxlength="255"
                >
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.thoi_gian_giam_sat_tu"/></label>
            </div>
            <div class="col-md-4">
                <input
                        data-bind="datepicker2: fiDateOfMonitorFrom, datepickerOptions: { endDate: fiDateOfMonitorTo }, enable: $root.isEditable()"
                        class="form-control form-control-inline date-picker"
                        data-date-format="dd/mm/yyyy" type="text" value=""
                        maxlength="10"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.thoi_gian_giam_sat_den"/></label>
            </div>
            <div class="col-md-4">
                <input
                        data-bind="datepicker2: fiDateOfMonitorTo, datepickerOptions: { startDate: fiDateOfMonitorFrom }, enable: $root.isEditable()"
                        class="form-control form-control-inline date-picker"
                        data-date-format="dd/mm/yyyy" type="text" value=""
                        maxlength="10"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.so_ban_gcn_can_cap"/><a
                        class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input
                        maxlength="2"
                        data-bind="value: fiQuantityLicense, enable: $root.isEditable()"
                        type="number"
                        class="form-control"
                >
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.thoi_gian_danh_bat_tu"/></label>
            </div>
            <div class="col-md-4">
                <input
                        data-bind="datepicker2: fiDateOfCatchFrom, datepickerOptions: { endDate: fiDateOfCatchTo }, enable: $root.isEditable()"
                        class="form-control form-control-inline date-picker"
                        data-date-format="dd/mm/yyyy" type="text" value=""
                        maxlength="10"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.thoi_gian_danh_bat_den"/></label>
            </div>
            <div class="col-md-4">
                <input
                        data-bind="datepicker2: fiDateOfCatchTo, datepickerOptions: { startDate: fiDateOfCatchFrom }, enable: $root.isEditable()"
                        class="form-control form-control-inline date-picker"
                        data-date-format="dd/mm/yyyy" type="text" value=""
                        maxlength="10"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.khu_vuc_danh_bat"/></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiLocationOfCatch, enable: $root.isEditable()"
                        class="form-control"
                        maxlength="255"
                >
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message
                        code="mard.07.tokhai.phuong_phap_danh_bat"/></label>
            </div>
            <div class="col-md-4">
                <input
                        type="text"
                        data-bind="value: fiMethodCatch, enable: $root.isEditable()"
                        class="form-control"
                        maxlength="255"
                >
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2"></div>
            <div class="col-md-10">
                <input class="form-check-input" type="checkbox" id="checkHangTC"
                       data-bind="checked: fiTransshipmentGoods, enable: $root.isEditable()">
                <label class="form-check-label" for="checkHangTC">
                    <spring:message code="mard.07.select.hang_trung_chuyen"/>
                </label><br/>
                <label data-bind="visible: fiTransshipmentGoods()" class="nsw-require-field">Tất cả các trường dưới đây là bắt buộc khi chọn hàng trung
                    chuyển. Trường hợp nhập khẩu trực tiếp từ tàu đánh bắt (không có thông tin tàu vận chuyển) thì điền thông tin tàu vận chuyển giống với thông tin tàu đánh bắt.</label>
            </div>
        </div>
        <div data-bind="visible: fiTransshipmentGoods()">
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.ma_so_dk_csnk"/></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiBusinessNumberofRegistration, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.ten_nguoi_dai_dien"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiNameOfRepresentRegistration, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.khoi_luong"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="number"
                            data-bind="value: fiTotalOfGoodsWeight, enable: $root.isEditable()"
                            class="form-control"
                    >
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.don_vi_khoi_luong"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control" data-bind="options: lstUOM,
                            optionsText: 'unitname',
                            optionsValue: 'unitcode',
                            optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                            value: fiTotalOfGoodsWeightUnitCode, enable: $root.isEditable()"></select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.ten_tau_danh_bat"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiNameOfFishingShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.so_dk_tau_danh_bat"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiCodeOfFishingShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.quoc_gia_treo_co_tau_db"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiOriginationOfFishingShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.ten_tau_van_chuyen"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiNameOfTransferShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.so_dk_tau_van_chuyen"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiCodeOfTransferShip, enable: $root.isEditable(),"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.quoc_gia_treo_co_tau_vc"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiOriginationOfTransferShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.ten_tau_container"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiNameOfContainerShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.so_dk_tau_container"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiCodeOfContainerShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.quoc_gia_treo_co_tau_container"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiOriginationOfContainerShip, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.thoi_gian_boc_do_tu"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker2: fiLoadingUnLoadingTimeFrom, datepickerOptions: { endDate: fiLoadingUnLoadingTimeTo }, enable: $root.isEditable()"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.thoi_gian_boc_do_den"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker2: fiLoadingUnLoadingTimeTo, datepickerOptions: { startDate: fiLoadingUnLoadingTimeFrom }, enable: $root.isEditable()"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="mard.07.tokhai.dia_diem_boc_do"/><a
                            class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            type="text"
                            data-bind="value: fiLoadingUnloadingPlace, enable: $root.isEditable()"
                            class="form-control"
                            maxlength="255"
                    >
                </div>
            </div>
        </div>
    </form>
    <!-- modal -->
    <div id="modal_addProduct" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.07.tokhai.thong_tin_hang_hoa"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.ten_hang_hoa"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstCVProduct,
                                        optionsText: 'fiProductBusinessName',
<%--                                        optionsValue: 'fiProductBusinessName',--%>
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiSelectedGoods, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.ten_khoa_hoc"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="value: fiNameSicenceOfGoods"
                                class="form-control"
                                disabled
                        />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.ma_hs_hang_hoa"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="text"
                                data-bind="value: fiHSCodeOfGoods"
                                class="form-control" value="" maxlength="20"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.loai"/></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstSpecies,
                                        optionsValue: 'fiName',
                                        optionsText: 'fiName',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiSpecies, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.tri_gia"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="text"
                                data-bind="value: fiValueOfGoods"
                                class="form-control" value="" maxlength="255"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.danh_muc_hang_hoa"/></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstCategory,
                                        optionsValue: 'fiName',
                                        optionsText: 'fiName',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiCategoryOfGoods, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.phan_loai"/></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstClassification,
                                        optionsValue: 'fiName',
                                        optionsText: 'fiName',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiClassification, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.phuong_thuc_bao_quan"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="text"
                                data-bind="value: fiPreservation"
                                class="form-control" maxlength="500"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.kich_co_ca_the"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="value: fiSizeOrShape"
                                disabled
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.so_luong_trong_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="number"
                                data-bind="value: fiQuantityOrWeight"
                                class="form-control"
                        />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value: fiQuantityOrWeightUnitName"
                               disabled
                        >
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.nuoc_xuat_xu"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"
                               data-bind="value: fiOriginationName"
                               disabled
                        >
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
                <button class="btn" data-dismiss="modal" data-bind="click: clearForm">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
    <!-- modal -->
    <div id="modal_editProduct" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: productVM"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.07.tokhai.thong_tin_hang_hoa"/></b>
        </div>
        <div class="modal-body">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.ten_hang_hoa"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstCVProduct,
                                        optionsText: 'fiProductBusinessName',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiSelectedGoods, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.ten_khoa_hoc"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="value: fiNameSicenceOfGoods"
                                class="form-control"
                                disabled
                        />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.ma_hs_hang_hoa"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="text"
                                data-bind="value: fiHSCodeOfGoods"
                                class="form-control" value="" maxlength="20"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.loai"/></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstSpecies,
                                        optionsValue: 'fiName',
                                        optionsText: 'fiName',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiSpecies, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.tri_gia"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="text"
                                data-bind="value: fiValueOfGoods"
                                class="form-control" value="" maxlength="255"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.danh_muc_hang_hoa"/></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstCategory,
                                        optionsValue: 'fiName',
                                        optionsText: 'fiName',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiCategoryOfGoods, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.phan_loai"/></label>
                    </div>
                    <div class="col-md-4">
                        <select data-bind="options: lstClassification,
                                        optionsValue: 'fiName',
                                        optionsText: 'fiName',
                                        optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                                        value: fiClassification, enable: $root.isEditable()"
                                class="form-control">
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.phuong_thuc_bao_quan"/></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="text"
                                data-bind="value: fiPreservation"
                                class="form-control" maxlength="500"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.kich_co_ca_the"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                data-bind="value: fiSizeOrShape"
                                disabled
                                class="form-control" value=""/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.so_luong_trong_luong"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input
                                type="number"
                                data-bind="value: fiQuantityOrWeight"
                                class="form-control"
                        />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.don_vi_tinh"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" data-bind="options: lstUOM,
                            optionsText: 'unitname',
                            optionsValue: 'unitcode',
                            optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                            value: fiQuantityOrWeightUnitCode" disabled></select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mard.07.table.nuoc_xuat_xu"/><a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" data-bind="options: lstCountry,
                            optionsText: 'countryname',
                            optionsValue: 'countrycode',
                            optionsCaption: '<spring:message code="mard.07.select.chon"/>',
                            value: fiOriginationCode" disabled></select>
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
                <button class="btn" data-dismiss="modal" data-bind="click: clearForm">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!-- end modal -->
</fieldset>
