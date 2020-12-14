<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mard.hoso.danhsachsanpham" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject bold uppercase">
                        <label><spring:message code="mard.hoso.danhsachsanpham" /> </label>
                    </span>
                    <button
                            data-bind="visible: $root.isEnableEdit"
                            class="btn green"
                            title=""
                            data-target="#modal_addGood"
                            data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 5%"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                            <th class="text-center" width="15%"><spring:message code="mard.hoso.danhsachsanpham.tenhanghoa" /></th>
                            <th class="text-center" width="10%"><spring:message code="mard.hoso.danhsachsanpham.tenkhoahoc" /></th>
                            <th class="text-center" width="10%" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.cachdonggoi" /></th>
                            <th class="text-center" width="5%" data-bind="visible: isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.soluongduc" /></th>
                            <th class="text-center" width="5%" data-bind="visible: isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.soluongcai" /></th>
                            <th class="text-center" width="5%" data-bind="visible: isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.tuoi" /></th>
                            <th class="text-center" width="5%" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.soluongkhoiluong" /></th>
                            <th class="text-center" width="10%" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.tenloaibaobi" /></th>
                            <th class="text-center" width="5%" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.trongluongtinh" /></th>
                            <th class="text-center" width="5%" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.donvitinhtrongluongtinh" /></th>
                            <th class="text-center" width="5%" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.trongluongtinhcabi" /></th>
                            <th class="text-center" width="5%" data-bind="visible: !isAnimal()"><spring:message code="mard.hoso.danhsachsanpham.donvitinhtrongluongtinhcabi" /></th>
                            <th class="text-center" width="10%"><spring:message code="mard.hoso.danhsachsanpham.nuocxuatxu" /></th>
                            <th class="text-center" width="10%"><spring:message code="mard.hoso.danhsachsanpham.masotacn" /></th>
                            <th class="text-center" width="5%" data-bind="visible: $root.isEnableEdit">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody data-bind="foreach: lstGood">
                    <tr>
                        <td data-bind="text: $index() + 1" style="width: 5%"></td>
                        <td data-bind="text: fiProductName" width="15%"></td>
                        <td data-bind="text: fiProductScienceName" width="10%"></td>
                        <td data-bind="text: fiPackingType, visible: !$parent.isAnimal()"></td>
                        <td class="text-right" data-bind="text: fiQtyMale, visible: $parent.isAnimal()" width="5%"></td>
                        <td class="text-right" data-bind="text: fiQtyFemale, visible: $parent.isAnimal()" width="5%"></td>
                        <td class="text-right" data-bind="text: fiAge, visible: $parent.isAnimal()" width="5%"></td>
                        <td class="text-right" data-bind="text: fiNumber, visible: !$parent.isAnimal()" width="5%"></td>
                        <td data-bind="text: fiUnitName, visible: !$parent.isAnimal()" width="10%"></td>
                        <td class="text-right" data-bind="text: fiNetWeight, visible: !$parent.isAnimal()" width="5%"></td>
                        <td data-bind="text: fiNWUnitName, visible: !$parent.isAnimal()" width="5%"></td>
                        <td class="text-right" data-bind="text: fiGrossWeight, visible: !$parent.isAnimal()" width="5%"></td>
                        <td data-bind="text: fiGWUnitName, visible: !$parent.isAnimal()" width="5%"></td>
                        <td data-bind="text: fiCountryOriginName" width="10%"></td>
                        <td data-bind="text: fiCirculateNo" width="10%"></td>
                        <td class="text-center" data-bind="visible: $root.isEnableEdit">
                            <a style="margin-bottom: 5px;" title="Sửa" >
                                <i style="color: #337ab7;" class="fa fa-edit" aria-hidden="true" data-target="#modal_addGood" data-toggle="modal" data-bind="click: function(){$parent.updateGoods20($index(), $data)}"></i>
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
    <div class="form-group">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="caption-subject bold uppercase">
                        <label><spring:message code="mard.hoso.nhamaysanxuatchebien" /> </label>
                    </span>
                    <button
                            data-bind="visible: $root.isEnableEdit"
                            class="btn green" title="" data-target="#modal_addMfs20a"
                            data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                    </button>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center" style="width: 5%"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.tunhamaysanxuatchebien" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.diachinhamay" /></th>
                        <th class="text-center" width="5%" data-bind="visible: $root.isEnableEdit">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstProdMfr">
                    <tr>
                        <td data-bind="text: STT" style="width: 5%"></td>
                        <td data-bind="text: fiManufactureName"></td>
                        <td data-bind="text: fiManufactureAddress"></td>
                        <td class="text-center" data-bind="visible: $root.isEnableEdit">
                            <a style="margin-bottom: 5px; display: none
" title="Sửa">
                                <i style="color: #337ab7; display: none" class="fa fa-edit" aria-hidden="true"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true" data-bind="click: function(){$parent.onDeleteProdMfr($index())}"></i>
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
                <label><spring:message code="mard.hoso.danhsachsanpham.mucdichsudung" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="500" type="text" data-bind="value: fiPurpose, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.diadiemtapkethang" /><a class="nsw-require-field">*</a>  </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiStorageLocation, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.dangkylaymaukiemtratungay" /><a class="nsw-require-field">*</a>  </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-date-format="dd/mm/yyyy" data-bind="datepicker: fiSamplingDateFrom, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.dangkylaymaukiemtradenngay" /><a class="nsw-require-field">*</a>  </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-date-format="dd/mm/yyyy" data-bind="datepicker: fiSamplingDateTo, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.diadiemdangkylaymaukiemtra" /><a class="nsw-require-field">*</a>  </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiSamplingLocation, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.tennguoilienhe" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiContactName, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.diachinguoilienhe" /> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="255" type="text" data-bind="value: fiContactAddress, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mard.hoso.danhsachsanpham.sodienthoainguoilienhe" /><a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <input class="form-control" maxlength="50" type="text" data-bind="value: fiContactTel, enable: $root.isEnableEdit"/>
            </div>
        </div>
    </div>


    <!-- modal -->
    <div id="modal_addGood" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: frmAddGood"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title"><spring:message code="mard.hoso.themhanghoa"/></b>
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
                                        id="frmMaHangHoa"
                                        class="form-control select2"
                                        data-bind="optionsCaption: 'Chọn...',
                                        optionsValue : 'fiProductCode',
                                        value: fiProductCode,
                                        options : listGood,
                                        optionsText : 'fiProductName',
                                        event: {change: $data.onChooseGood.bind($data)}"
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
                                        id="fiProductCode"
                                        data-bind="value: fiProductCode"
                                        class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group" style="margin-bottom: 16px">
                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.tenkhoahoc"/>
                            </div>
                            <div class="col-md-10">
                                <input
                                        disabled
                                        name="fiProductScienceName"
                                        id="fiProductScienceName"
                                        data-bind="value: fiProductScienceName"
                                        class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group"style="margin-bottom: 16px" data-bind="visible: productType() == 1">

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
                                                id="fiQtyMale"
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
                                                id="fiQtyFemale"
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
                                        disabled
                                        name="fiAge"
                                        id="fiAge"
                                        type="number"
                                        data-bind="value: fiAge"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" data-bind="visible: productType() == 2" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.cachdonggoi"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        name="fiPackingType"
                                        id="fiPackingType"
                                        data-bind="value: fiPackingType"
                                        class="form-control" value=""/>
                            </div>
                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.danhsachsanpham.soluongkhoiluong"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <div class="col-md-12" style="padding: 0; display: flex; align-items: center">
                                    <div class="col-md-6" style="padding: 0;">
                                        <input
                                                type="number"
                                                name="fiNumber"
                                                id="fiNumber"
                                                data-bind="value: fiNumber"
                                                class="form-control" value=""/>
                                    </div>
                                    <div class="col-md-6">
                                        <span>≤</span>
                                        <span data-bind="text: fiNumberFixed"/>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="form-group" data-bind="visible: productType() == 2" style="margin-bottom: 16px">
                            <div class="col-md-2">
                                <label>
                                    <spring:message code="mard.hoso.danhsachsanpham.tenloaibaobi"/>
                                    <a class="nsw-require-field">*</a>
                                </label>
                            </div>
                            <div class="col-md-10">
                                <input
                                        disabled
                                        name="fiUnitName"
                                        id="fiUnitName"
                                        data-bind="value: fiUnitName"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" data-bind="visible: productType() == 2" style="margin-bottom: 16px">

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
                                                id="fiNetWeight"
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
                                        id="fiNWUnitCode"
                                        data-bind="value: fiNWUnitCode"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" data-bind="visible: productType() == 2" style="margin-bottom: 16px">

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
                                                id="fiGrossWeight"
                                                data-bind="value: fiGrossWeight"
                                                class="form-control" value=""/>
                                    </div>
                                    <div class="col-md-6">
                                        <span>≤</span>
                                        <span data-bind="text: fiGrossWeightFixed"/>
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
                                        id="fiGWUnitName"
                                        data-bind="value: fiGWUnitName"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.xuatxu"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        disabled
                                        name="fiCountryOriginName"
                                        id="fiCountryOriginName"
                                        data-bind="value: fiCountryOriginName"
                                        class="form-control" value=""/>
                            </div>
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
                                        id="fiPortName"
                                        data-bind="value: fiPortName"
                                        class="form-control" value=""/>
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom: 16px">

                            <div class="col-md-2">
                                <label><spring:message code="mard.hoso.danhsachsanpham.masotacn"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-10">
                                <input
                                        maxlength="255"
                                        value=""
                                        name="fiCirculateNo"
                                        id="fiCirculateNo"
                                        data-bind="value: fiCirculateNo"
                                        class="form-control"/>
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
                <button class="btn" data-dismiss="modal" data-target="#modal_addGood" data-bind="click: onClose">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
    <!--- modal add mfs -->
    <div id="modal_addMfs20a" class="modal container in modal-overflow" tabindex="-1"
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
                        <label><spring:message code="mard.hoso.danhsachsanpham.tunhamaysanxuatchebien"/> <a
                                class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select
                                id="frmCongTySanXuatCheBien20a"
                                class="form-control select2"
                                data-bind="optionsCaption: 'Chọn...',
                                        optionsValue : 'fiFactoryName',
                                        options : listMfs,
                                        optionsText : 'fiFactoryName',
                                        event: {change: onChooseMfs}"
                        ></select>
                    </div>
                    <div class="col-md-2">
                        <label>
                            <spring:message code="mard.hoso.danhsachsanpham.diachinhamay"/>
                            <a class="nsw-require-field">*</a>
                        </label>
                    </div>
                    <div class="col-md-4">
                        <input
                                disabled
                                name="fiFactoryAddress"
                                data-bind="value: fiFactoryAddress"
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
                        data-bind="click: addMfs"
                >
                    <spring:message code="conmon.button.them"/>
                </button>
                <button class="btn" data-dismiss="modal" data-target="#modal_addMfs20a" data-bind="click: onClose">
                    <spring:message code="conmon.button.huy"/>
                </button>
            </div>
        </div>
    </div>
</fieldset>
