<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.sohdchungtu" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiSoHopDongCt" name="fiSoHopDongCt" type="text" data-bind="value : fiSoHopDongCt" />
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.giatrilo" /></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiGiaTriLoHang" name="fiGiaTriLoHang" type="text" data-bind="value : fiGiaTriLoHang"/>

        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.giaycn" /></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiGcnXk" name="fiGcnXk" data-bind="value : fiGcnXk" type="text"/>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.ngaycap" /></label>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgayCapGcnXk" name="fiNgayCapGcnXk"  data-bind="datepicker : fiNgayCapGcnXk" type="text" data-date-format="dd/mm/yyyy" readonly style="background-color: #fff;"/>
                <a class="input-group-addon" style="background: #fff !important;" href="javascript:void(0)" data-bind="event : {click : clearNgayCapGcnXk}">
                    <i class="fa fa-close"></i>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.tochucxuatkhau" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiToChucXk" name="fiToChucXk" data-bind="value : fiToChucXk" type="text"/>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.nuocxkhau" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <select class="form-control select2" id="fiNuocXk" name="fiNuocXk"
                    data-bind="optionsCaption: 'Chọn nước xuất khẩu', optionsValue : 'id'
                        , selectedText2 : fiTenNuocXk
                        , value : fiMaNuocXk
                        , options : lstQuocGia
                        , optionsText : 'name'">
            </select>
        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.cuakhauxuat" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <select class="form-control select2" id="fiCuaKhauXuat" name="fiCuaKhauXuat"
                    data-bind="optionsCaption: 'Chọn của khẩu xuất khẩu', optionsValue : 'id'
                        , selectedText2 : fiTenCuaKhauXuat
                        , value : fiMaCuaKhauXuat
                        , options : lstCuaKhau
                        , optionsText : 'name'">
            </select>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.tochucnhapkhau" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiToChucNk" name="fiToChucNk" type="text" data-bind="value : fiToChucNk"/>

        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.nuocnhapkhau" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <select class="form-control select2" id="fiNuocNk" name="fiNuocNk"
                    data-bind="optionsCaption: 'Chọn của khẩu xuất khẩu', optionsValue : 'id'
                        , selectedText2 : fiTenNuocNk
                        , value : fiMaNuocNk
                        , options : lstQuocGia
                        , optionsText : 'name'">
            </select>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.phuongtienvchuyen" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiPtVanChuyen" name="fiPtVanChuyen" type="text" data-bind="value : fiPtVanChuyen"/>

        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.cuakhaunhap" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <select class="form-control select2" id="fiCuaKhauNhap" name="fiCuaKhauNhap"
                    data-bind="optionsCaption: 'Chọn của khẩu xuất khẩu', optionsValue : 'id'
                        , selectedText2 : fiTenCuaKhauNhap
                        , value : fiMaCuaKhauNhap
                        , options : lstCuaKhau
                        , optionsText : 'name'">
            </select>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.mucdichsdung" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiMucDichSuDung" name="fiMucDichSuDung" type="text" data-bind="value : fiMucDichSuDung"/>

        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.vbchapthuan" /></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiVbChapThuanKiemDich" name="fiVbChapThuanKiemDich" data-bind="value : fiVbChapThuanKiemDich" type="text"/>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.diadiemkiemdich" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiDiaDiemKiemDich" name="fiDiaDiemKiemDich" type="text" data-bind="value : fiDiaDiemKiemDich"/>

        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.tgiankiemdichtu" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiTgKiemDichTu" name="fiTgKiemDichTu"  data-bind="datepicker : fiTgKiemDichTu" type="text" data-date-format="dd/mm/yyyy" readonly style="background-color: #fff;"/>
                <a class="input-group-addon" style="background: #fff !important;" href="javascript:void(0)" data-bind="event : {click : clearTgKiemDichTu}">
                    <i class="fa fa-close"></i>
                </a>
            </div>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.tgiankiemdichden" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiTgKiemDichDen" name="fiTgKiemDichDen"  data-bind="datepicker : fiTgKiemDichDen" type="text" data-date-format="dd/mm/yyyy" readonly style="background-color: #fff;"/>
                <a class="input-group-addon" style="background: #fff !important;" href="javascript:void(0)" data-bind="event : {click : clearTgKiemDichDen}">
                    <i class="fa fa-close"></i>
                </a>
            </div>
        </div>

    </div>
</div>
<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.diadiemgs" /></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiDiaDiemGs" name="fiDiaDiemGs" type="text" data-bind="value : fiDiaDiemGs"/>

        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.sobangiaycnhan" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" id="fiSoGcnKiemDich" name="fiSoGcnKiemDich" type="text" data-bind="value : fiSoGcnKiemDich"/>
        </div>
    </div>
</div>
<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.tgiangsattu" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiTgGsTu" name="fiTgGsTu"  data-bind="datepicker : fiTgGsTu" type="text" data-date-format="dd/mm/yyyy" readonly style="background-color: #fff;"/>
                <a class="input-group-addon" style="background: #fff !important;" href="javascript:void(0)" data-bind="event : {click : clearTgGsTu}">
                    <i class="fa fa-close"></i>
                </a>
            </div>
        </div>
        <div class="col-md-2 nsw-text-left">
            <label><spring:message code="mard.03.hoso.hanghoa.tgiangsatden" /><a class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiTgGsDen" name="fiTgGsDen"  data-bind="datepicker : fiTgGsDen" type="text" data-date-format="dd/mm/yyyy" readonly style="background-color: #fff;"/>
                <a class="input-group-addon" style="background: #fff !important;" href="javascript:void(0)" data-bind="event : {click : clearTgGsDen}">
                    <i class="fa fa-close"></i>
                </a>
            </div>
        </div>
    </div>
</div>
