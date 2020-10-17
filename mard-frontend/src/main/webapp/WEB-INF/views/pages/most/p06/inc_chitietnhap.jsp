<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="most.06.hoso.chitietnhapkhau" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.ngaydukienxuat" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly style="background:  #fff" id="fiNkcpxNgayDuKien" name="fiNkcpxNgayDuKien" data-bind="datepicker : fiNkcpxNgayDuKien,event: {change: ngayDukienXKValid}" type="text" data-date-format="dd/mm/yyyy" />
                <span class="validationMessage" id="fiNkcpxNgayDuKien-lbl" style="display: none">Thông tin bắt buộc nhập</span>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.thanhpho" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control" id="fiNkcpxMaTinh" name="fiNkcpxMaTinh"data-bind="optionsCaption: 'Chọn...'
                    , optionsValue : 'id', options : lstTinhThanh
                    ,value: fiNkcpxMaTinh
                    ,selectedText2 : fiNkcpxTenTinh
                    , optionsText : 'name'"></select>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.caukhaunhap" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                 <select name="cuaKhau" id="cuaKhau" class="form-control"data-bind="optionsCaption: 'Chọn...'
                    , optionsValue : 'id', options : lstCuaKhau
                    ,value: fiNkcpxMaCuaKhau
                    ,selectedText2 : fiNkcpxTenCuaKhau
                    , optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.chitietnhapkhau.ngaydukienden" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control date-picker" readonly style="background: #fff" placeholder="dd/mm/yyyy" id="fiNgaycapDk" name="fiNgayTiepnhan" data-bind="datepicker : fiNgayTiepnhan, event: {change: ngayDukienValid}" type="text" data-date-format="dd/mm/yyyy" />
                <span class="validationMessage" id="valid-ngayCapDk" style="display: none;">Thông tin bắt buộc nhập</span> 
            </div>
        </div>  
    </div> 
</fieldset>
