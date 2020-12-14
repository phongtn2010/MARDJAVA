<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>  
    <legend><b><spring:message code="most.05.hoso.chiTietNKPhongXa" /></b></legend>
    <%--<%@include file="inc_css.jsp" %>--%>
    <form role="form" class="form-horizontal" name="searchForm">
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.chiTietNKPhongXa.ngayDuKien" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">   
                    <input disabled name="ngayDuKien" id="ngayDuKien" data-bind="datepicker : $data.formVM().fiNkcpxNgayDuKien" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label ><spring:message code="most.05.hoso.chiTietNKPhongXa.tinhThanhPho" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select disabled class="form-control" id="fiNkcpxMaTinh" name="fiNkcpxMaTinh"data-bind="optionsCaption: 'Chọn...'
                    , optionsValue : 'id', options : $data.formVM().lstTinhThanh
                    ,value: $data.formVM().fiNkcpxMaTinh
                    ,selectedText2 : $data.formVM().fiNkcpxTenTinh
                    , optionsText : 'name'"></select>
                </div>
            </div>  
        </div>

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.chiTietNKPhongXa.cuakhau" />
                        <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select disabled name="fiNkcpxMaCuaKhau" id="fiNkcpxMaCuaKhau" class="form-control"data-bind="optionsCaption: 'Chọn...'
                    , optionsValue : 'id', options : $data.formVM().lstCuaKhau
                    ,value: $data.formVM().fiNkcpxMaCuaKhau
                    ,selectedText2 : $data.formVM().fiNkcpxTenCuaKhau
                    , optionsText : 'name'"></select>
                </div>
            </div>  
        </div>  
    </form>
</fieldset>