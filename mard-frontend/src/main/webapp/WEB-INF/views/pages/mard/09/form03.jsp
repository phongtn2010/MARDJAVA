<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 11/2/19
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>

    <legend><b><spring:message code="mard.hoso.thongtinhanghoa" /></b></legend>

    <div class="form-group" style="padding-left: 15px; padding-right: 15px">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject uppercase">
                        <spring:message code="mard.hoso.thongtinhanghoa"/>&nbsp;
                    </span>
                    <button
                            data-bind="visible: $root.isEnableEdit"
                            class="btn green" title="" data-target="#modal_addGood03"
                            data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa3">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 5%"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.tenhanghoa" /></th>
                        <th class="text-center" data-bind="visible: isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.soluongduc" /></th>
                        <th class="text-center" data-bind="visible: isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.soluongcai" /></th>
                        <th class="text-center" data-bind="visible: isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.tuoi" /></th>
                        <th class="text-center" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.cachdonggoi" /></th>
                        <th class="text-center" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.soluongkhoiluong" /></th>
                        <th class="text-center" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.trongluongtinh" /></th>
                        <th class="text-center" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.trongluongtinhcabi" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.cuakhaunhap" /></th>
                        <th class="text-center" width="10%" data-bind="visible: $root.isEnableEdit"><spring:message code="mard.hoso.documents.chucnang" /></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstGood">
                    <tr>
                        <td style="width: 5%" data-bind="text: $index() + 1"></td>
                        <td data-bind="text: fiProductName"></td>
                        <td class="text-right" data-bind="text: fiQtyMale, visible: $parent.isAnimal()"></td>
                        <td class="text-right" data-bind="text: fiQtyFemale, visible: $parent.isAnimal()"></td>
                        <td class="text-right" data-bind="text: fiAge, visible: $parent.isAnimal()"></td>
                        <td data-bind="text: fiPackingType, visible: !$parent.isAnimal()"></td>
                        <td class="text-right" data-bind="text: fiNumber() + ' (' + fiUnitName() + ')', visible: !$parent.isAnimal()"></td>
                        <td class="text-right" data-bind="text: fiNetWeight() + ' (' + fiNWUnitName() + ')', visible: !$parent.isAnimal(), visible: !$parent.isAnimal()"></td>
                        <td class="text-right" data-bind="text: fiGrossWeight() + ' (' + fiGWUnitName() + ')', visible: !$parent.isAnimal(), visible: !$parent.isAnimal()"></td>
                        <td data-bind="text: fiPortName"></td>
                        <td class="text-center" data-bind="visible: $root.isEnableEdit">
                            <a style="margin-bottom: 5px;" title="Sửa" >
                                <i style="color: #337ab7;" class="fa fa-edit" aria-hidden="true" data-target="#modal_addGood03" data-toggle="modal" data-bind="click: function(){$parent.updateGoods03($index(), $data)}"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.onDeleteGoods($index())}"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="form-group" style="padding-left: 15px; padding-right: 15px">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject uppercase">
                        <label><spring:message code="mard.hoso.thongtincongtyxuatkhau" /> </label>
                    </span>
                    <button
                            data-bind="visible: $root.isEnableEdit"
                            class="btn green" title="" data-target="#modal_addCompany"
                            data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 5%"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.tencongtyxuatkhau" /></th>
                        <th class="text-center" width="10%" data-bind="visible: $root.isEnableEdit"><spring:message code="mard.hoso.documents.chucnang" /></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstCompany">
                    <tr>
                        <td data-bind="text: $index() + 1" style="width: 5%"></td>
                        <td data-bind="text: fiCompanyName"></td>
                        <td class="text-center" data-bind="visible: $root.isEnableEdit">
                            <a style="margin-bottom: 5px; display: none
" title="Sửa">
                                <i style="color: #337ab7; display: none" class="fa fa-edit" aria-hidden="true"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.onDeleteCompany($index())}"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="form-group" style="padding-left: 15px; padding-right: 15px" data-bind="visible: fiDispatchType() != 1">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject bold uppercase">
                        <label><spring:message code="mard.hoso.nhamaysanxuatchebien" /> </label>
                    </span>
                    <button
                            data-bind="visible: $root.isEnableEdit"
                            class="btn green" title="" data-target="#modal_addMfs"
                            data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 5%"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.tunhamaysanxuatchebien" /></th>
                        <th class="text-center" width="10%" data-bind="visible: $root.isEnableEdit"><spring:message code="mard.hoso.documents.chucnang" /></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstManufacture">
                    <tr>
                        <td data-bind="text: $index() + 1" style="width: 5%"></td>
                        <td data-bind="text: fiManufactureName"></td>
                        <td class="text-center" data-bind="visible: $root.isEnableEdit">
                            <a style="margin-bottom: 5px; display: none
" title="Sửa">
                                <i style="color: #337ab7; display: none" class="fa fa-edit" aria-hidden="true"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.onDeleteManufacture($index())}"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="form-group" style="padding-left: 15px; padding-right: 15px" data-bind="visible: fiDispatchType() == 1">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject bold uppercase">
                        <label><spring:message code="mard.hoso.thongtinnoicachlykiemdich" /> </label>
                    </span>
                    <button
                            data-bind="visible: $root.isEnableEdit"
                            class="btn green" title="" data-target="#modal_addIsoLocation"
                            data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 5%"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.tennoicachlykiemdichdongvat" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.diadiemnuoicachlykiemdichdongvatsanphamdongvatnhapkhau" /></th>
                        <th class="text-center" width="10%" data-bind="visible: $root.isEnableEdit"><spring:message code="mard.hoso.documents.chucnang" /></th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstQuarantine">
                    <tr>
                        <td data-bind="text: $index() + 1" style="width: 5%"></td>
                        <td data-bind="text: fiQuarantineName"></td>
                        <td data-bind="text: fiQuarantineAddress"></td>
                        <td class="text-center" data-bind="visible: $root.isEnableEdit">
                            <a style="margin-bottom: 5px; display: none" title="Sửa">
                                <i style="color: #337ab7; display: none" class="fa fa-edit" aria-hidden="true"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.onDeleteQuarantine($index())}"></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số vận đơn tàu<a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="50" type="text" data-bind="value: fiBillOfLadingNo, enable: $root.isEnableEdit"/>
            </div>
        </div>

    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Ngày tháng năm cấp vận đơn tàu<a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input
                        class="form-control"
                        maxlength="500" type="text"
                        class="form-control form-control-inline date-picker"
                        data-date-format="dd/mm/yyyy" type="text" value=""
                        data-bind="datepicker: fiBillOfLadingIssuedDate, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.mucdichsudung" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="500" type="text" data-bind="value: fiPurpose, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.tencuakhauxuat" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiExportPortDestName, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.nuocxuatkhau" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <select
                        id="fiMaNuocxuatkhau"
                        class="form-control select2"
                        data-bind="optionsCaption: 'Chọn...',
                            optionsValue : 'countrycode',
                            selectedText : fiExportCountryName,
                            value : fiExportCountryCode,
                            options : $parent.lstQuocgia,
                            optionsText : 'countryname',
                            event: {change: onNuocXuatKhauPick}, enable: $root.isEnableEdit"
                ></select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.nuocnhapkhau" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <select
                        id="fiMaNuocnhapkhau"
                        class="form-control select2"
                        data-bind="optionsCaption: 'Chọn...',
                            optionsValue : 'countrycode',
                            selectedText : fiImportCountryName,
                            value : fiImportCountryCode,
                            options : $parent.lstQuocgia,
                            optionsText : 'countryname',
                            event: {change: onNuocNhapKhauPick}, enable: $root.isEnableEdit"
                ></select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.phuongtienvanchuyen" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiTransportType, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.diadiemgiamsat" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiMonitoringLocName, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.thoigiangiamsattu" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" data-date-format="dd/mm/yyyy"  type="text" data-bind="datepicker: fiMonitoringLocTimeFrom, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.thoigiangiamsatden" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" data-date-format="dd/mm/yyyy"  type="text" data-bind="datepicker: fiMonitoringLocTimeTo, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Tên địa điểm kiểm dịch</label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiQuarantineName, enable: $root.isEnableEdit"/>
            </div>
        </div>

    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.thoigiankdtu" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control"
                       data-bind="datepicker2 : fiQuarantineTimeFrom, datepickerOptions: { endDate: fiQuarantineTimeTo }, enable: $root.isEnableEdit"
                       class="form-control form-control-inline date-picker"
                       data-date-format="dd/mm/yyyy" type="text" value=""
                       maxlength="10"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.thoigiankdden" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control"
                       data-bind="datepicker2 : fiQuarantineTimeTo, datepickerOptions: { startDate: fiQuarantineTimeFrom }, enable: $root.isEnableEdit"
                       class="form-control form-control-inline date-picker"
                       data-date-format="dd/mm/yyyy" type="text" value=""
                       maxlength="10"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.sobangiaychungnhancancap" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="15" data-bind="value: fiCertificateQuantity, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.sohopdong" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiContractNo, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.tochuccanhannhapkhau" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiImportContactPerson, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.tochuccanhanxuatkhau" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiExportContactPerson, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <!-- ko with: kyHoSoVM() -->
    <%@include file="inc_thongtinkydon.jsp"%>
    <!-- /ko -->

    <!-- modal -->
    <div id="modal_addGood03" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: frmAddGood"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.hoso.themhanghoa"/> </b>
        </div>
        <div class="modal-body" style="display: flex">
            <div class="col-md-12">
                <form role="form" class="form-horizontal">
                    <div class="col-md-12" style="display: inline-grid;">
                        <div class="form-group" style="margin-bottom: 16px">
                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.tenhanghoa"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <select
                                        id="frmMaHangHoa03"
                                        class="form-control select2"
                                        data-bind="optionsCaption: 'Chọn...',
                                        optionsValue : 'fiProductCode',
                                        value: fiProductCode,
                                        options : listGood,
                                        optionsText : 'fiProductName',
                                        event: {change: onChooseGood}"
                                ></select>
                            </div>
                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.mahanghoa"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        disabled
                                        name="fiProductCode"
                                        data-bind="value: fiProductCode"
                                        class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group" data-bind="visible: productType() == 1" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.soluongduc"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <div class="col-md-12" style="padding: 0; display: flex; align-items: center">
                                    <div class="col-md-6" style="padding: 0;">
                                        <input
                                                class="form-control"
                                                name="fiQtyMale"
                                                type="number"
                                                data-bind="value: fiQtyMale, max: fiQtyMaleFixed"
                                                value=""/>
                                    </div>
                                    <div class="col-md-6">
                                        <span>≤</span>
                                        <span data-bind="text: fiQtyMaleFixed"/>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.danhsachsanpham.soluongcai"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <div class="col-md-12" style="padding: 0; display: flex; align-items: center">
                                    <div class="col-md-6" style="padding: 0;">
                                        <input
                                                type="number"
                                                name="fiQtyFemale"
                                                data-bind="value: fiQtyFemale"
                                                class="form-control" value=""/>
                                    </div>
                                    <div class="col-md-6">
                                        <span>≤</span>
                                        <span data-bind="text: fiQtyFemaleFixed"/>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="form-group" style="margin-bottom: 16px" data-bind="visible: productType() == 1">
                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.tuoi"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10">
                                <input
                                        type="number"
                                        name="fiAge"
                                        data-bind="value: fiAge"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" data-bind="visible: productType() >= 2" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.cachdonggoi"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10">
                                <input
                                        name="fiPackingType"
                                        data-bind="value: fiPackingType"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" data-bind="visible: productType() >= 2" style="margin-bottom: 16px">
                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.danhsachsanpham.soluongkhoiluong"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <div class="col-md-12" style="padding: 0;">
                                    <div class="col-md-6" style="padding: 0;">
                                        <input
                                                type="number"
                                                name="fiNumber"
                                                data-bind="value: fiNumber"
                                                class="form-control" value=""/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.danhsachsanpham.donvitinh"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <select
                                        data-bind="options: $parent.lstUOMs,
                                                optionsText: 'unitname',
                                                optionsValue: 'unitcode',
                                                optionsCaption: 'Chọn',
                                                value: fiUnitCode" class="form-control"></select>
                            </div>
                        </div>
                        <div class="form-group" data-bind="visible: productType() >= 2" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.trongluongtinh"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <div class="col-md-12" style="padding: 0; display: flex; align-items: center">
                                    <div class="col-md-6" style="padding: 0;">
                                        <input
                                                type="number"
                                                name="fiNetWeight"
                                                data-bind="value: fiNetWeight"
                                                class="form-control" value=""/>
                                    </div>
                                    <div class="col-md-6">
                                        <span>≤</span>
                                        <span data-bind="text: fiNetWeightFixed"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.donvitinhtrongluongtinh"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        disabled
                                        name="fiNWUnitCode"
                                        data-bind="value: fiNWUnitName"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" data-bind="visible: productType() >= 2" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.trongluongtinhcabi"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <div class="col-md-12" style="padding: 0; display: flex; align-items: center">
                                    <div class="col-md-6" style="padding: 0;">
                                        <input
                                                type="number"
                                                name="fiGrossWeight"
                                                data-bind="value: fiGrossWeight"
                                                class="form-control" value=""/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.danhsachsanpham.donvitinhtrongluongtinhcabi"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        disabled
                                        name="fiGWUnitName"
                                        data-bind="value: fiGWUnitName"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.tencuakhaunhap"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        disabled
                                        name="fiPortName"
                                        data-bind="value: fiPortName"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                    </div>
                </form>

                <div class="text-center">
                    <span class="nsw-require-field" data-bind="text: errorMsg"></span>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addProduct, enable: !isDisableAddButton()"
                >
                    <spring:message code="conmon.button.themsua"/>
                </button>
                <button class="btn" data-dismiss="modal" data-target="#modal_addGood03" data-bind="click: onClose">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>

    <!--- modal add company -->
    <div id="modal_addCompany" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: frmAddCompany"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.hoso.themcongtyxuatkhau"/></b>
        </div>
        <div class="modal-body" style="display: flex">
            <div class="col-md-12">
                <div class="form-group" style="margin-bottom: 16px">
                    <div class="col-md-2">
                        <label><spring:message code="mard.hoso.danhsachsanpham.tencongtyxuatkhau"/> <a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                id="frmTenCongTyXuatKhau"
                                class="form-control select2"
                                data-bind="optionsCaption: 'Chọn...',
                                        optionsValue : 'fiExporterName',
                                        options : listCompany,
                                        optionsText : 'fiExporterName',
                                        event: {change: onChooseCompany}"
                        ></select>
                    </div>

                </div>
                <div class="text-center">
                    <span class="nsw-require-field" data-bind="text: errorMsg"></span>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addCompany"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal" data-target="#modal_addCompany" data-bind="click: onClose">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>

    <!--- modal add iso location -->
    <div id="modal_addIsoLocation" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: frmAddIsoLocation"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.hoso.themnoicachlykiemdich"/></b>
        </div>
        <div class="modal-body" style="display: flex">
            <div class="col-md-12">
                <div class="form-group" style="margin-bottom: 16px">
                    <div class="col-md-2">
                        <label><spring:message code="mard.hoso.danhsachsanpham.tennoicachlykiemdichdongvat"/> <a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                id="frmDiaDiemCachLyKiemDich"
                                class="form-control select2"
                                data-bind="optionsCaption: 'Chọn...',
                                        optionsValue : 'fiIsoLocName',
                                        options : listIsoLocation,
                                        optionsText : 'fiIsoLocName',
                                        event: {change: onChooseIsoLocation}"
                        ></select>
                    </div>
                    <div class="col-md-2">
                        <label>
                            <spring:message code="mard.hoso.danhsachsanpham.diadiemnuoicachlykiemdichdongvatsanphamdongvatnhapkhau"/>
                            <a class="nsw-require-field">*</a>
                        </label>
                    </div>
                    <div class="col-md-4">
                        <input
                                disabled
                                name="fiIsoLocAddress"
                                id="fiIsoLocAddress"
                                data-bind="value: fiIsoLocAddress"
                                class="form-control"/>
                    </div>
                </div>
                <div class="text-center">
                    <span class="nsw-require-field" data-bind="text: errorMsg"></span>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addIsoLocation"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal" data-target="#modal_addIsoLocation" data-bind="click: onClose">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>


    <!--- modal add mfs -->
    <div id="modal_addMfs" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: frmAddMfs"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.hoso.themnhamaysanxuatchebien"/></b>
        </div>
        <div class="modal-body" style="display: flex">
            <div class="col-md-12">
                <div class="form-group" style="margin-bottom: 16px">
                    <div class="col-md-2">
                        <label><spring:message code="mard.hoso.danhsachsanpham.tunhamaysanxuatchebien"/></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                id="frmCongTySanXuatCheBien"
                                class="form-control select2"
                                data-bind="optionsCaption: 'Chọn...',
                                        optionsValue : 'fiFactoryName',
                                        options : listMfs,
                                        optionsText : 'fiFactoryName',
                                        event: {change: onChooseMfs}"
                        ></select>
                    </div>
                </div>
                <div class="text-center">
                    <span class="nsw-require-field" data-bind="text: errorMsg"></span>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green"
                        data-bind="click: addMfs"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal" data-target="#modal_addMfs" data-bind="click: onClose">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
</fieldset>

