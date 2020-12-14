<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row" data-bind="with: registerAnimalVM">
    <div class="col-md-12" style="padding-left: 30px">
        <fieldset>
            <legend><b><spring:message
                    code="mard.01.table.title.thong_tin_dong_vat"/>&nbsp;</b>
                <button class="btn green" title=""
                        data-target="#modal_addAnimal"
                        data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                </button>
            </legend>
            <div class="panel-body">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <tr>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th style="width: 50px" valign="bottom" rowspan="2"><spring:message
                                code="mard.01.table.col.STT"/></th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.ten_loai_dong_vat"/><br>
                            <spring:message
                                    code="mard.01.table.col.ten_loai_dong_vat_eng"/><br>
                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.ma_hs"/><br>
                            <spring:message
                                    code="mard.01.table.col.ma_hs_eng"/>
                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.giong"/><br>
                            <spring:message
                                    code="mard.01.table.col.giong_eng"/>
                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.tuoi"/><br>
                            <spring:message
                                    code="mard.01.table.col.tuoi_eng"/>
                        </th>
                        <th class="text-center" colspan="2">
                            <spring:message
                                    code="mard.01.table.col.tinh_biet"/><br>
                            <spring:message
                                    code="mard.01.table.col.tinh_biet_eng"/>

                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.so_luong_con"/><br>
                            <spring:message
                                    code="mard.01.table.col.so_luong_con_eng"/>
                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.khoi_luong"/><br>
                            <spring:message
                                    code="mard.01.table.col.khoi_luong_eng"/>
                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.don_vi_tinh"/><br>
                            <spring:message
                                    code="mard.01.table.col.don_vi_tinh_eng"/>
                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.muc_dich_su_dung"/><br>
                            <spring:message
                                    code="mard.01.table.col.muc_dich_su_dung_eng"/>
                        </th>
                        <th class="text-center" rowspan="2">
                            <spring:message
                                    code="mard.01.table.col.gia_tri"/><br>
                            <spring:message
                                    code="mard.01.table.col.gia_tri_eng"/>
                        </th>
                        <th class="text-center" rowspan="2">Thao tác</th>

                    </tr>
                    <tr>
                        <th class="text-center"><spring:message
                                code="mard.01.table.col.duc"/></th>
                        <th class="text-center"><spring:message
                                code="mard.01.table.col.cai"/></th>
                    </tr>
                    </tr>
                    <tbody data-bind="template: {foreach: fiAnimalList }">
                    <tr>
                        <td class="text-center" data-bind="text: ($index() + 1)"></td>
                        <td class="text-center">
                            <p data-bind="text: fiAnimalTypeVni"></p>
                            <p style="font-style: italic" data-bind="text: fiAnimalType"></p>
                        </td>
                        <td class="text-center" data-bind="text: fiHSCode"></td>
                        <td class="text-center">
                            <p data-bind="text: fiBreedVni"></p>
                            <p style="font-style: italic" data-bind="text: fiBreed"></p>
                        </td>
                        <td class="text-center" data-bind="text: fiAge"></td>
                        <td class="text-center">
                            <div data-bind="visible: fiSex == '1'">
                                <input type="radio" value="1"
                                       checked="checked"
                                />
                            </div>
                        </td>
                        <td class="text-center">
                            <div data-bind="visible: fiSex == '2'">
                                <input type="radio" value="2"
                                       checked="checked"
                                />
                            </div>
                        </td>
                        <td class="text-center" data-bind="text: fiNumber"></td>
                        <td class="text-center" data-bind="text: fiAnimalNetWeight"></td>
                        <td class="text-center">
                            <p data-bind="text: fiAnimalUnitVni"></p>
                            <p style="font-style: italic" data-bind="text: fiAnimalUnit"></p>
                        </td>
                        <td class="text-center">
                            <p data-bind="text: fiPurposeVni"></p>
                            <p style="font-style: italic" data-bind="text: fiPurpose"></p>
                        </td>
                        <td class="text-center" data-bind="text: fiShipmentvalue"></td>
                        <td class="text-center">
                            <a style="margin-bottom: 5px;" title="Sửa" data-target="#modal_addAnimal"
                               data-toggle="modal"
                               data-bind="click: function(){$parent.onUpdateAnimal($data, $index())}">
                                <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"></i>
                            </a>
                            <a style="margin-bottom: 5px;" title="Xóa">
                                <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                   data-bind="click: function(){$parent.onDeleteAnimal($index())}"
                                ></i>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
<%--                <div class="row" style="margin-top: 20px">--%>
<%--                    <div class="col-md-2">--%>
<%--                        <label>Nhập danh sách động vật theo file</label>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-10">--%>
<%--                        <input--%>
<%--                                data-bind="event: { change: function(data, event){ addAnimalFromExcel(event) } }"--%>
<%--                                type="file"--%>
<%--                                class="form-control"--%>
<%--                                accept=".xlsx"--%>
<%--                        />--%>
<%--                        <div style="margin-top: 5px;">--%>
<%--                            <a style="font-style: italic" href="/mard/01/templates?type=animal">--%>
<%--                                <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <p id="fiAnimalList-validate" class="nsw-require-field validate" style="text-align: center"></p>

                <div style="margin-top: 20px">
                    <%--                <div class="row">--%>
                    <%--                    <div class="col-md-2"><spring:message--%>
                    <%--                            code="mard.01.tokhai.nhap_danh_sach_dong_vat_theo_file"/></div>--%>
                    <%--                    <div class="col-md-10">--%>
                    <%--                        <input id="fiTep" class="form-control" type="file"/>--%>
                    <%--                    </div>--%>
                    <%--                </div>--%>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.tongsosoluong"/><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10" style="display: flex;align-items: start">
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiTotalAnimalByCharVni" maxlength="1000"/>
                                <span id="fiTotalAnimalByCharVni-validate" class="nsw-require-field validate"></span>
                            </div>
                            <div style="width: 4%; text-align: center"><span>/</span></div>
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiTotalAnimalByChar" maxlength="1000"
                                    placeholder="<spring:message code="mard.01.tokhai.tongsosoluong"/> (Tiếng Anh)"
                                />
                                <span id="fiTotalAnimalByChar-validate" class="nsw-require-field validate"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.noi_xuat_phat"/><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10" style="display: flex;align-items: start">
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiDeparturePlaceOfAnimalVni"
                                       maxlength="250"/>
                                <span id="fiDeparturePlaceOfAnimalVni-validate"
                                      class="nsw-require-field validate"></span>
                            </div>
                            <div style="width: 4%; text-align: center"><span>/</span></div>
                            <div style="width: 48%">
                                <input class="form-control" data-bind="value: fiDeparturePlaceOfAnimal"
                                       maxlength="250"
                                    placeholder="<spring:message code="mard.01.tokhai.noi_xuat_phat"/> (Tiếng Anh)"
                                />
                                <span id="fiDeparturePlaceOfAnimal-validate" class="nsw-require-field validate"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.tinh_trang_suc_khoe"/><a
                                    class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" data-bind="value: fiAnimalHealthStatus" maxlength="200"/>
                            <span id="fiAnimalHealthStatus-validate" class="nsw-require-field validate"></span>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-2">
                            <label><spring:message
                                    code="mard.01.tokhai.so_dong_vat_tren_xuat_phat"/></label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" data-bind="value: fiDiseaseSafeName" maxlength="255"/>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px;padding-right: 0">
                        <div class="col-md-11" style="padding-left: 0; padding-right: 0">
                            <div class="col-md-4" style="padding-left: 0">
                                <div class="col-md-5">
                                    <label><spring:message
                                            code="mard.01.tokhai.theo_quyet_dinh_so"/></label>
                                </div>
                                <div class="col-md-7">
                                    <input class="form-control" data-bind="value: fiDecisionNo" maxlength="50"/>
                                </div>
                            </div>
                            <div class="col-md-3" style="padding-left: 0">
                                <div class="col-md-3" style="display: flex;justify-content: center">
                                    <label><spring:message
                                            code="mard.01.tokhai.ngay"/></label>
                                </div>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" data-date-format="dd/mm/yyyy"
                                           data-bind="datepicker: fiDecisionDate"/>
                                </div>
                            </div>
                            <div class="col-md-5" style="padding-left: 0; padding-right: 0">
                                <div class="col-md-3" style="display: flex;justify-content: center">
                                    <label><spring:message
                                            code="mard.01.tokhai.cua"/></label>
                                </div>
                                <div class="col-md-9">
                                    <input class="form-control" data-bind="value: fiDecisionDepartment"
                                           maxlength="100"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1">
                            <label><spring:message
                                    code="mard.01.tokhai.neu_co"/></label>
                        </div>
                    </div>
                    <div class="col-md-12" style="margin-top: 20px;padding-left: 0px">
                        <div class="col-md-12" style="padding-left: 0">
                            <span class="caption-subject bold uppercase"><spring:message
                                    code="mard.01.tokhai.so_dong_vat_tren_da_xet_nghiem"/>&nbsp;</span>
                            <button class="btn green" title=""
                                    data-target="#modal_addTest"
                                    data-toggle="modal"><i class="fa fa-plus btn-plus"></i>
                            </button>
                        </div>
                        <div class="col-md-12" style="margin-top: 10px; padding-left: 0">
                            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th style="width: 50px" class="text-center"><spring:message
                                            code="mard.01.table.col.STT"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.benh_xet_nghiem"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.ket_qua_xn_so"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.ngay_xn"/></th>
                                    <th class="text-center">Thao tác</th>
                                </tr>
                                <tbody data-bind="template: {foreach: fiTestList }">
                                <tr>
                                    <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                    <td class="text-center" data-bind="text: fiTestName"></td>
                                    <td class="text-center" data-bind="text: fiTestNumber"></td>
                                    <td class="text-center" data-bind="date: fiTestDate"></td>
                                    <td class="text-center">
                                        <a style="margin-bottom: 5px;" title="Sửa" data-target="#modal_addTest"
                                           data-toggle="modal"
                                           data-bind="click: function(){$parent.onUpdateTest($data, $index() )}">
                                            <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"></i>
                                        </a>
                                        <a style="margin-bottom: 5px;" title="Xóa">
                                            <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                               data-bind="click: function(){$parent.onDeleteTest($index())}"
                                            ></i>
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
<%--                    <div class="row" style="margin-top: 20px">--%>
<%--                        <div class="col-md-2">--%>
<%--                            <label>Nhập danh sách bệnh đã được xét nghiệm theo file</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-10">--%>
<%--                            <input--%>
<%--                                    data-bind="event: { change: function(data, event){ addTestFromExcel(event) } }"--%>
<%--                                    type="file"--%>
<%--                                    class="form-control"--%>
<%--                                    accept=".xlsx"--%>
<%--                            />--%>
<%--                            <div style="margin-top: 5px;">--%>
<%--                                <a style="font-style: italic" href="/mard/01/templates?type=test">--%>
<%--                                    <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="col-md-12" style="margin-top: 20px;padding-left: 0px">
                        <div class="col-md-12" style="padding-left: 0">
                            <span class="caption-subject bold uppercase"><spring:message
                                    code="mard.01.tokhai.so_dong_vat_trên_da_tiem_phong"/>&nbsp;</span>
                            <button class="btn green" title=""
                                    data-target="#modal_addVaccin"
                                    data-toggle="modal"
                            ><i class="fa fa-plus btn-plus"></i>
                            </button>
                        </div>
                        <div class="col-md-12" style="margin-top: 10px; padding-left: 0">
                            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th style="width: 50px" class="text-center"><spring:message
                                            code="mard.01.table.col.STT"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.tiem_phong_benh"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.ngay_tiem_phong"/></th>
                                    <th class="text-center">Thao tác</th>
                                </tr>
                                <tbody data-bind="template: {foreach: fiVaccinList }">
                                <tr>
                                    <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                    <td class="text-center" data-bind="text: fiVaccinationAgainstName"></td>
                                    <td class="text-center" data-bind="date: fiVaccinationAgainstDate"></td>
                                    <td class="text-center">
                                        <a style="margin-bottom: 5px;" title="Sửa"
                                           data-target="#modal_addVaccin"
                                           data-toggle="modal"
                                        >
                                            <i style="color: #337ab7;" class="fa fa-lg fa-edit" aria-hidden="true"
                                               data-bind="click: function(){$parent.onUpdateVaccin($data, $index())}"></i>
                                        </a>
                                        <a style="margin-bottom: 5px;" title="Xóa">
                                            <i style="color: #337ab7" class="fa fa-lg fa-trash-o" aria-hidden="true"
                                               data-bind="click: function(){$parent.onDeleteVaccin($index())}"
                                            ></i>
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
<%--                    </div>--%>
<%--                        <div class="row" style="margin-top: 20px">--%>
<%--                            <div class="col-md-2">--%>
<%--                                <label>Nhập danh sách bệnh đã được tiêm phòng theo file</label>--%>
<%--                            </div>--%>
<%--                            <div class="col-md-10">--%>
<%--                                <input--%>
<%--                                        data-bind="event: { change: function(data, event){ addVaccineFromExcel(event) } }"--%>
<%--                                        type="file"--%>
<%--                                        class="form-control"--%>
<%--                                        accept=".xlsx"--%>
<%--                                />--%>
<%--                                <div style="margin-top: 5px;">--%>
<%--                                    <a style="font-style: italic" href="/mard/01/templates?type=vaccine">--%>
<%--                                        <i class="fa fa-download" aria-hidden="true"></i><spring:message code="mard.title.mau_du_lieu_nhap"></spring:message>--%>
<%--                                    </a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                </div>--%>
            </div>
        </fieldset>
        <div data-bind="with: addAnimalVM">
            <div id="modal_addAnimal" class="modal container in modal-overflow"
                 data-backdrop="static" data-keyboard="false"
            >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                            data-bind="click: clearForm"></button>
                    <b class="modal-title"><spring:message
                            code="mard.01.table.title.thong_tin_dong_vat_tren_can"/></b>
                </div>
                <div class="modal-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.ten_loai_dong_vat"/> <a
                                        class="nsw-require-field">*</a><br>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="fiAnimalTypeVni" name="fiAnimalTypeVni"
                                       data-bind="value: fiAnimalTypeVni"
                                       maxlength="100"
                                />
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.ten_loai_dong_vat_eng"/> <a
                                        class="nsw-require-field">*</a><br>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="fiAnimalType" name="fiAnimalType"
                                       data-bind="value: fiAnimalType"
                                       maxlength="100"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.ma_hs"/></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="fiHSCode" name="fiHSCode"
                                       data-bind="value: fiHSCode"
                                       maxlength="50"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.giong"/> <a
                                        class="nsw-require-field">*</a><br>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="fiBreedVni" name="fiBreedVni"
                                       data-bind="value: fiBreedVni"
                                       maxlength="100"
                                />
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.giong_eng"/> <a
                                    class="nsw-require-field">*</a><br>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="fiBreed" name="fiBreed"
                                       data-bind="value: fiBreed"
                                       maxlength="100"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.tuoi"/> <a
                                        class="nsw-require-field">*</a><br>
                                    <spring:message code="mard.01.table.col.tuoi_eng"/>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <input
                                        class="form-control" id="fiAge" name="fiAge"
                                        data-bind="value: fiAge" type="text"
                                        maxlength="50"
                                />
                            </div>
                        </div>
                        <div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label><spring:message code="mard.01.table.col.tinh_biet"/> <a
                                            class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <div class="col-md-6 col-xs-6">
                                        <div class="form-check form-check-inline">
                                            <input type="radio" value="1" name="fiSex"
                                                   data-bind="checked: fiSex"
                                            />
                                            <label><spring:message
                                                    code="mard.01.radio.duc"/></label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-xs-6">
                                        <div class="form-check form-check-inline">
                                            <input type="radio" value="2" name="fiSex"
                                                   data-bind="checked: fiSex"
                                            />
                                            <label><spring:message
                                                    code="mard.01.radio.cai"/></label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.so_luong_con"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="fiNumber" name="fiNumber" type="number"
                                       data-bind="value: fiNumber"
                                       oninput="if(value.length>15)value=value.slice(0,15)"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.khoi_luong"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4" style="align-items: start">
                                <input class="form-control" id="fiAnimalNetWeight" name="fiAnimalNetWeight"
                                       data-bind="value: fiAnimalNetWeight" type="number"
                                       oninput="if(value.length>18)value=value.slice(0,18)"
                                />
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.don_vi_tinh"/> <a
                                        class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4" style="align-items: start">
                                <select
                                        disabled
                                        class="form-control"
                                        data-bind="optionsCaption: 'Chọn...', options: lstUOMWeight, value: fiAnimalUnitCode, optionsValue: 'fiUnitCode', optionsText : 'fiUnitNameVni'"></select>
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
                            <div class="col-md-10" style="display: flex;align-items: start">
                                <input class="form-control" id="fiShipmentvalue" type="number" name="fiShipmentvalue"
                                       data-bind="value: fiShipmentvalue"
                                       oninput="if(value.length>18)value=value.slice(0,18)"
                                />
                            </div>
                        </div>
                        <p id="add-animal-validate" class="nsw-require-field validate" style="text-align: center"></p>
                    </form>
                </div>
                <div class="modal-footer" style="">
                    <div class="text-center">
                        <button class="btn green" data-bind="click: addAnimal">
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
        <div data-bind="with: addVaccinVM">
            <div id="modal_addVaccin" class="modal container in modal-overflow" tabindex="-1"
                 data-backdrop="static" data-keyboard="false"
            >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                            data-bind="click: clearForm"></button>
                    <b class="modal-title"><spring:message code="mard.01.table.title.thong_tin_tiem_phong"/></b>
                </div>
                <div class="modal-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.tiem_phong_benh"/></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="value: fiVaccinationAgainstName"
                                       class="form-control" value=""
                                       maxlength="100"
                                />
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.ngay_tiem_phong"/></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control"
                                       data-bind="datepicker : fiVaccinationAgainstDate"
                                       class="form-control form-control-inline date-picker"
                                       data-date-format="dd/mm/yyyy" type="text" value=""
                                       maxlength="10"/>
                            </div>
                        </div>
                        <p id="add-vaccin-validate" class="nsw-require-field validate" style="text-align: center"></p>
                    </form>
                </div>
                <div class="modal-footer" style="">
                    <div class="text-center">
                        <button class="btn green" data-bind="click: addVaccin">
                            <spring:message code="common.button.luu"/>
                        </button>
                        <button class="btn" data-dismiss="modal" data-bind="click: clearForm">
                            <spring:message code="conmon.button.huy"/>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div data-bind="with: addTestVM">
            <div id="modal_addTest" class="modal container in modal-overflow" tabindex="-1"
                 data-backdrop="static" data-keyboard="false"
            >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <b class="modal-title"><spring:message code="mard.01.table.title.thong_tin_xet_nghiem"/></b>
                </div>
                <div class="modal-body">
                    <form role="form" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.benh_xet_nghiem"/></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="value: fiTestName"
                                       class="form-control" value=""
                                       maxlength="100"
                                />
                            </div>
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.ket_qua_xn_so"/></label>
                            </div>
                            <div class="col-md-4">
                                <input data-bind="value: fiTestNumber"
                                       class="form-control" value=""
                                       maxlength="50"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2">
                                <label><spring:message code="mard.01.table.col.ngay_xn"/></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control"
                                       data-bind="datepicker : fiTestDate"
                                       class="form-control form-control-inline date-picker"
                                       data-date-format="dd/mm/yyyy" type="text" value=""
                                       maxlength="10"/>
                            </div>
                        </div>
                        <p id="add-test-validate" class="nsw-require-field validate" style="text-align: center"></p>
                    </form>
                </div>
                <div class="modal-footer" style="">
                    <div class="text-center">
                        <button class="btn green" data-bind="click: addTest">
                            <spring:message code="conmon.button.them"/>
                        </button>
                        <button class="btn" data-dismiss="modal" data-bind="click: clearForm">
                            <spring:message code="conmon.button.huy"/>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- end modal -->
    </div>
</div>
