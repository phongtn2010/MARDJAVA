<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>  
    <legend><b><spring:message code="most.05.hoso.phongXakin" /></b> <a href="javascript:;" class="btn green" id="btnAddNewClickPXK" data-bind="click :$data.formVM().btnAddNewClickPXK "><i class="fa fa-plus"></i></a></legend>
            <%@include file="inc_css.jsp" %>
    <form role="form" class="form-horizontal" name="searchForm">
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10"> 
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="most.05.hoso..phongXakin.stt" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.tenDVPhongXa" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.hoatDo" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.dơnViTinh" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.ngayXacDinh" /></th>
                    <th class="text-center"><spring:message code="most.05.hoso.phongXakin.chucNang" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: $data.formVM().lstTbdhsNkpxTtpnpxk05">
                <tr>
                    <td data-bind="text: $index() + 1">
                    </td>  
                    <td style="width: 220px" data-bind="text : fiTenDongViPhongXa">
                    </td>
                    <td style="width: 220px" data-bind="text : fiHangSanXuat">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiHoatDo">
                    </td>
                    <td style="width: 220px" data-bind="text : fiTenHoatDoDonVi">
                    </td>
                    <td style="width: 220px;text-align: center" data-bind="date : fiNgayXacDinhHoatDo">
                    </td>
                    <td style="width: 220px" class="text-center">                            
                        <a class="btn green bt-center" data-bind="click: $parent.formVM().btnEditClickPXK.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                        <a class="btn red bt-center" data-bind="click: $parent.formVM().removePXKOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
        <span data-bind="text : $data.formVM().errorlistpxkMessage" style="color:red;"> </span>
        <br/>
</fieldset>
<template id="phongXaKin-template">
    <div class="row" id="IdPhongXaKinVM" style="max-height: 68vh !important; overflow: auto;">
        <form role="form" class="" id="addPhongXaKin-form">
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.tenDVPhongXa" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-10">
                        <select class="form-control select2" id="fiTenDongViPhongXa" name="fiTenDongViPhongXa"  
                                data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiMaDongViPhongXa , selectedText2 : fiTenDongViPhongXa,
                                options : lstDongViPX, optionsText : 'name'"></select>
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.maHieu" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiMaHieu" name="fiMaHieu" data-bind="value: fiMaHieu" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.soSeri" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiSoSeri" name="fiSoSeri" data-bind="value: fiSoSeri" maxlength="50"/>
                    </div>
                </div>
            </div>    
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiHangSanXuat" name="fiHangSanXuat" data-bind="value: fiHangSanXuat " maxlength="500"/>
                    </div>
                </div>
            </div>    
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.hoatDo" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-2">
                        <input class="form-control" id="fiHoatDo" name="fiHoatDo" data-bind="value: fiHoatDo " type="text" /> 
                    </div>
                    <div class="col-md-2">
                        <select class="form-control select2" id="fiHoatDoDonVi" name="fiHoatDoDonVi" 
                                data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                                , value : fiHoatDoDonVi , options : lstHoatDoDonVi, optionsText : 'name'"></select>
                    </div>

                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.ngayXDhoatDo" /></label>
                    </div>
                    <div class="col-md-4">
                        <input name="fiNgayXacDinhHoatDo" readonly style="background: #fff" id="NgayXacDinhHoatDo" data-bind="datepicker : fiNgayXacDinhHoatDo" 
                               class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" placeholder="dd/mm/yyyy" />
                    </div>
                </div>
            </div> 
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.mucDichSuDung" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaMucDichSuDung" name="fiMaMucDichSuDung" multiple
                                data-bind=" optionsValue : 'id'
                                , selectedOptions : lstMucdichsudung
                                , options : lstNguonPXK, optionsText : 'name'
                                ,event: {change: mucdichAction}"></select>
                        <span id="fiMaMucDichSuDungEr" data-bind="text : errormucdicpxkMessage" style="color:red ; font-size: 12px"> </span>
                    </div>
                    <div class="col-md-2 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                        <label>
                            <spring:message code="most.05.hoso.phongXakin.ungDungKhac" />
                            <a class="nsw-require-field" id="lbl-pho-valid">*</a>
                        </label>
                    </div>
                    <div class="col-md-4 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                        <input class="form-control" id="fiMucDichSuDungKhac" name="fiMucDichSuDungKhac" maxlength="500"
                               data-bind="value : fiMucDichSuDungKhac,event: {change: changeUngDungKhacKin}" type="text" />
                        <span class="validationMessage" id="fiMucDichSuDungKhacKin-lbl" style="display: none">Thông tin bắt buộc nhập</span>
                    </div>
                </div><br/>
                <span style="color: red;float: left;margin-left: 15px">Lưu ý: Trường Mục đích sử dụng cho phép chọn nhiều. Trường Ứng dụng khác chỉ hiển thị khi chọn loại Mục đích sử dụng: Các ứng dựng khác (ghi rõ)</span>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-7 nsw-text-right">
                    <label><spring:message code="most.05.hoso.phongXakin.nguonCamKet" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-1">
                </div>
                 <div class="col-md-4">
                        <label class="col-md-4"> <input class="fiCamKetTraLaiNguon" name="fiCamKetTraLaiNguon"  id="rdKhong" type="radio" data-bind=" event: {change: camketTLN}">Không</label> 
                        <label class="col-md-4"> <input class="fiCamKetTraLaiNguon" name="fiCamKetTraLaiNguon" id="rdCo" type="radio" data-bind=" event: {change: camketTLN}">Có</label><br />
                        <span id ="valid_camketNguon" data-bind="text : errorradiopxkMessage" style="color:red; margin-left: -190px; float: left; font-size: 12px"> </span>
                    </div>
            </div>
                
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <label><b><spring:message code="most.05.hoso.phongXakin.label"/></b></label>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.maHieu" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiTbMaHieu" name="fiTbMaHieu" data-bind="value : fiTbMaHieu" type="text" maxlength="250"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.soSeri" /></label>
                    </div>
                    <div class="col-md-4 nsw-text-right">
                        <input class="form-control" id="fiTbSoSeri" name="fiTbSoSeri" data-bind="value : fiTbSoSeri" type="text" maxlength="50"/>
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiTbHangNuocSanXuat" name="fiTbHangNuocSanXuat" data-bind="value : fiTbHangNuocSanXuat" type="text" maxlength="500"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.namSanXuat" /></label>
                    </div>
                    <div class="col-md-4 nsw-text-right">
                        <input class="form-control" id="fiTbNamSanXuat" name="fiTbNamSanXuat" data-bind="value: fiTbNamSanXuat" type="number" max="9999" min="1" oninput="validity.valid||(value='');"/>
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-3 nsw-text-right">
                    <label><spring:message code="most.05.hoso.phongXakin.thietBi" /></label>
                </div>
                <div class="col-md-4">
                    <label class="col-md-4"><input class="fiTbDiDongCoDinh" name="fiTbDiDongCoDinh" id="rdDiDong" type="radio" >Di động</label> 
                    <label class="col-md-4"><input class="fiTbDiDongCoDinh" name="fiTbDiDongCoDinh" id="rdCoDinh" type="radio">Cố định</label>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-3 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.noiDat" /></label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" id="fiTbNoiDat" name="fiTbNoiDat" maxlength="1000"
                               data-bind="value : fiTbNoiDat" type="text" />
                    </div>
                </div>
            </div>
            <div class="form-group" style="margin-top: 15px;">
                <div class="col-md-12">
                    <div class="col-md-3 nsw-text-right">
                        <label><spring:message code="most.05.hoso.phongXakin.khoiLuong" /></label>
                    </div>
                    <div class="col-md-9">
                        <input class="form-control" id="fiTbKhoiLuongUrani" name="fiTbKhoiLuongUrani" data-bind="value : fiTbKhoiLuongUrani" type="text" maxlength="500"/>
                    </div>
                </div>
            </div>
    </div>
</template>