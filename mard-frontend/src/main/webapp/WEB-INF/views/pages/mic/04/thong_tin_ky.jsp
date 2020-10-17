<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class='col-md-12' id="ThongTinKyViewModel">
    <div class='row'>

        <div class='col-md-6 form-group'>
            <div class='row'>
                <label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiTenNguoiKy'}}"></span><span class="nsw-require-field">*</span></label>
                <div class="col-md-9">
                    <input ${ isView ? " disabled " : ""}  id="fiTenNguoiKy" name="fiTenNguoiKy" class="form-control"  data-bind="value: tbdHoSo04.fiTenNguoiKy, i18n: {  placeholder: { key: 'TbdHoSo04.fiTenNguoiKy'}}">
                </div>
            </div>
        </div>

        <div class='col-md-6 form-group'>
            <div class='row'>
                <label class="col-md-3" ><span data-bind="i18n: {  html: { key: 'TbdHoSo04.fiChucDanh'}}"></span><span class="nsw-require-field"></span></label>
                <div class="col-md-9">
                    <input ${ isView ? " disabled " : ""}  id="fiChucDanh" name="fiChucDanh" class="form-control"  data-bind="value: tbdHoSo04.fiChucDanh, i18n: {  placeholder: { key: 'TbdHoSo04.fiChucDanh'}}">
                </div>
            </div>
        </div>

    </div>
</div>