<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>   
    <template id="popupxe-template">
        <form role="form" class="form-horizontal" id="popupxe-form">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mt.hoso.danhsachxe.biensoxe" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">                  
                        <select class="form-control select2 " data-bind="value: fiBksXe, selectedText2 : fiBksXe,                                   
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : lstBksXe,
                                event: {change: getPhuongtienOnClick}" style="width: 200px;"></select>              
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mt.hoso.danhsachxe.trongtai" /><a class="nsw-require-field">*</a><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" name="fiSoGhe" data-bind="value : fiSoGhe" maxlength="250" readonly/>  
                    </div>
                </div>  
            </div>       
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mt.hoso.danhsachxe.nguoisohuu" /><a class="nsw-require-field">*</a><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" name="fiTenChuxe" data-bind="value : fiTenChuxe" maxlength="250" readonly/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mt.hoso.danhsachxe.namsanxuat" /><a class="nsw-require-field">*</a><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control date-picker" placeholder="dd/mm/yyyy" name="fiNamSx" data-bind="value : fiNamSx" maxlength="250" disabled/>
                    </div>
                </div>  
            </div> 
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mt.hoso.danhsachxe.cuakhau" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2 fiMaCkXn" data-bind="value: fiMaCkXn,                                    
                                    optionsCaption: 'Chọn...', 
                                    optionsValue : 'id', 
                                    optionsText : 'name', 
                                    options : lstCuaKhauXuatNhap" style="width: 200px;"></select>

                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="mt.hoso.danhsachxe.loaixe" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2 fiMaLoaixe" data-bind="value: fiMaLoaixe,                                
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : lstLoaiXe"></select>
                    </div>
                </div>  
            </div> 

        </form>
    </template> 
</fieldset>