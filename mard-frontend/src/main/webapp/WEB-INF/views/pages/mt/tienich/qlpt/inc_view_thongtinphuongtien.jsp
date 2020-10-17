<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>    
    <legend><b><spring:message code="mt.qlpt.phuongtien.thongtinphuongtien" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.biensoxe" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBksXe" name="fiBksXe" maxlength="255"  
                       type="text" data-bind="value : fiBksXe" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.sokhung" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoKhung" name="fiSoKhung" data-bind="value : fiSoKhung" type="text" readonly="readonly"/>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.somay" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoMay" name="fiSoMay" maxlength="255"  
                       type="text" data-bind="value : fiSoMay" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.namhsd" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" disabled id="fiNamHsd" name="fiNamHsd"  data-bind="datepicker : fiNamHsd" type="text" data-date-format="yyyy" readonly="readonly"/>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.namsx" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" disabled id="fiNamSx" name="fiNamSx"  data-bind="datepicker : fiNamSx" type="text" data-date-format="yyyy" readonly="readonly" />

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.nuocsx" /></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2 " disabled id="fiMaQgia" name="fiMaQgia" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenQgia, value : fiMaQgia, options : lstQuocgia, optionsText : 'name'" ></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.nhanhieu" /></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2 "disabled id="fiMaNhanhieu" name="fiMaQgia" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenNhanhieu, value : fiMaNhanhieu, options : lstNhanhieu, optionsText : 'name'"></select>
                
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.Loaihinh" /></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2 "disabled id="fiMaLoaixe" name="fiMaLoaixe" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenLoaixe, value : fiMaLoaixe, options : lstLoaixe, optionsText : 'name'"></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.soghe" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGhe" name="fiSoGhe" maxlength="255"  
                       type="text" data-bind="value : fiSoGhe" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.mauson" /></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2 "disabled id="fiMaMauson" name="fiMaLoaixe" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenMauson, value : fiMaMauson, options : lstMauson, optionsText : 'name'"></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.chuphuongtien" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenChuxe" name="fiTenChuxe" maxlength="255"  
                       type="text" data-bind="value : fiTenChuxe" readonly="readonly"/>
            </div>
        </div>  
    </div> 
</fieldset>
