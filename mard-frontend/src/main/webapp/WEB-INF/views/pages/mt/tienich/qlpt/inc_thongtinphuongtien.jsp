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
                <label><spring:message code="mt.qlpt.phuongtien.biensoxe" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBksXe" name="fiBksXe" maxlength="255"  
                       type="text" data-bind="value : fiBksXe"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.sokhung" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoKhung" name="fiSoKhung" data-bind="value : fiSoKhung" type="text" />

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.somay" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoMay" name="fiSoMay" maxlength="255"  
                       type="text" data-bind="value : fiSoMay"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.namhsd" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control " id="fiNamHsd" name="fiNamHsd"  data-bind="value:  fiNamHsd" type="number"  />

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.namsx" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNamSx" name="fiNamSx"  data-bind="value : fiNamSx" type="number" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.nuocsx" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaQgia" name="fiMaQgia" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenQgia, value : fiMaQgia, options : lstQuocgia, optionsText : 'name'"></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.nhanhieu" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaNhanhieu" name="fiMaQgia" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenNhanhieu, value : fiMaNhanhieu, options : lstNhanhieu, optionsText : 'name'"></select>
                
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.Loaihinh" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaLoaixe" name="fiMaLoaixe" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenLoaixe, value : fiMaLoaixe, options : lstLoaixe, optionsText : 'name'"></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.soghe" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGhe" name="fiSoGhe" maxlength="255"  
                       type="text" data-bind="value : fiSoGhe"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.mauson" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaMauson" name="fiMaMauson" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenMauson, value : fiMaMauson, options : lstMauson, optionsText : 'name'"></select>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.qlpt.phuongtien.chuphuongtien" /><a class="nsw-require-field"> *</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenChuxe" name="fiTenChuxe" maxlength="255"  
                       type="text" data-bind="value : fiTenChuxe"/>
            </div>
        </div>  
    </div> 
    <span data-bind="text : errorDinhKemMessage" style="color:red;"> </span>

    <p style="color: red;"><b>Lưu ý : </b> </br>
        - Biển số xe không được trùng lặp </br>     
    </p>
</fieldset>
