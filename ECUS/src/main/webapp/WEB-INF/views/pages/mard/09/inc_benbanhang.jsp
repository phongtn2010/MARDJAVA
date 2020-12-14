<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mard.hoso.benbanhang" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject bold uppercase">
                        <label><spring:message code="mard.hoso.danhsachbenbanhang" /> </label>
                    </span>
                    <button
                            data-bind="visible: $root.isEnableEdit"
                            class="btn green"
                            title=""
                            data-target="#modal_addExporter"
                            data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 5%"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.hang" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.nuocbenbanhang" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.dienthoai" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.fax" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.diachi" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.noixuathang" /></th>
                        <th class="text-center" data-bind="visible: $root.isEnableEdit">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstSeller">
                    <tr>
                        <td data-bind="text: STT" style="width: 5%"></td>
                        <td data-bind="text: fiExporterName"></td>
                        <td data-bind="text: fiExporterCountry"></td>
                        <td data-bind="text: fiExporterPhone"></td>
                        <td data-bind="text: fiExporterFax"></td>
                        <td data-bind="text: fiExporterAddress"></td>
                        <td data-bind="text: fiPortOfDepartureName"></td>
                        <td class="text-center" data-bind="visible: $root.isEnableEdit">
                            <a style="margin-bottom: 5px;display: none" title="Sửa">
                                <i style="color: #337ab7;"
                                   class="fa fa-edit"
                                   data-target="#modal_addExporter"
                                   data-toggle="modal"
                                   aria-hidden="true" data-bind="click: function(){$parent.onUpdateSeller($index(), $data)}"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.onDeleteSeller($index())}"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--- modal add exporter -->
    <div id="modal_addExporter" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: frmAddExporter"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Thêm bên bán hàng</b>
        </div>
        <div class="modal-body" style="display: flex">
            <div class="form-horizontal" >
                <div class="col-md-12">
                    <div class="form-group" style="margin-bottom: 16px">
                        <div class="col-md-2">
                            <label>Hãng<a
                                    class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select
                                    id="frmBenBanHang"
                                    class="form-control select2"
                                    data-bind="optionsCaption: 'Chọn...',
                                            optionsValue : 'fiExporterName',
                                            options : listCompany,
                                            value: fiSellerName,
                                            optionsText : 'fiExporterName',
                                            event: {change: onChooseExporter}"
                            ></select>
                        </div>
                        <div class="col-md-2">
                            <label>
                                Nước bên bán hàng
                                <a class="nsw-require-field">*</a>
                            </label>
                        </div>
                        <div class="col-md-4">
                            <select
                                    id="selectNuocXuatHang"
                                    class="form-control select2"
                                    data-bind="optionsCaption: 'Chọn...',
                                            options : $parent.lstCountry,
                                            value: fiSellerState,
                                            optionsText : 'countryname'"></select>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group" style="margin-bottom: 16px">
                        <div class="col-md-2">
                            <label>Điện thoại</label>
                        </div>
                        <div class="col-md-4">
                            <input
                                    maxlength="50"
                                    name="fiSellerPhone"
                                    id="fiSellerPhone"
                                    data-bind="value: fiSellerPhone"
                                    class="form-control"/>
                        </div>
                        <div class="col-md-2">
                            <label>
                                Fax
                            </label>
                        </div>
                        <div class="col-md-4">
                            <input
                                    maxlength="50"
                                    name="fiSellerFax"
                                    id="fiSellerFax"
                                    data-bind="value: fiSellerFax"
                                    class="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group" style="margin-bottom: 16px">
                        <div class="col-md-2">
                            <label>Địa chỉ <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <input
                                    disabled
                                    name="fiSellerAddress"
                                    id="fiSellerAddress"
                                    data-bind="value: fiSellerAddress"
                                    class="form-control"/>
                        </div>
                    </div>

                </div>
                <div class="col-md-12">
                    <div class="form-group" style="margin-bottom: 16px">
                        <div class="col-md-2">
                            <label>Nơi xuất hàng <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <input
                                    maxlength="255"
                                    name="fiPortOfDepartureName"
                                    data-bind="value: fiPortOfDepartureName"
                                    class="form-control"/>
                        </div>
                    </div>
                    <div class="text-center">
                        <span class="nsw-require-field" data-bind="text: errorMsg"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addExporter"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal" data-target="#modal_addExporter" data-bind="click: onClose">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
</fieldset>
