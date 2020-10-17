<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class='col-md-12' id="ThongTinKyViewModel">
    <div class='row'>

        <div class='col-md-6 form-group'>
            <div class='row'>
                <label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiTenNguoiKy'}}"></span><span class="nsw-require-field">*</span></label>
                <div class="col-md-9">
                    <input ${ isView ? " disabled " : ""}  id="fiTenNguoiKy" name="fiTenNguoiKy" class="form-control"  data-bind="value: tbdHoSo03.fiTenNguoiKy, i18n: {  placeholder: { key: 'TbdHoSo03.fiTenNguoiKy'}}">
                </div>
            </div>
        </div>

        <div class='col-md-6 form-group'>
            <div class='row'>
                <label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo03.fiChucDanh'}}"></span><span class="nsw-require-field"></span></label>
                <div class="col-md-9">
                    <input ${ isView ? " disabled " : ""}  id="fiChucDanh" name="fiChucDanh" class="form-control"  data-bind="value: tbdHoSo03.fiChucDanh, i18n: {  placeholder: { key: 'TbdHoSo03.fiChucDanh'}}">
                </div>
            </div>
        </div>

        <div class='col-md-6 form-group'>
            <div class='row'>
                <label class="col-md-3"><span  data-bind="i18n: {  html: { key: 'TbdHoSo03.fiDiaDiemKy'}}"></span><span class="nsw-require-field">*</span></label>
                <div class="col-md-9">
                    <select ${ isView ? " disabled " : ""} id="fiDiaDiemKy" name="fiDiaDiemKy" class="form-control select2 input-medium form-control-inline"
                            data-bind="options: $root.danhMucTinhTPs,  optionsText: 'fiName',  optionsValue: 'fiName' ,value: tbdHoSo03.fiDiaDiemKy"></select>
                    <p class='validationMessage' data-bind="validationMessage: tbdHoSo03.fiDiaDiemKy"></p>
                </div>
            </div>
        </div>
    </div>
</div>