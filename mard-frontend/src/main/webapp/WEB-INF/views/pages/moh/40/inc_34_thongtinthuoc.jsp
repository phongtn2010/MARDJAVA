<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.hoso.40.thongtinthuoc" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.loaidonhang" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiLoaiDon" name="fiLoaiDon" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiLoaiDon, options : lstLoaiDonHang, optionsText : 'name'"></select>
            </div>  
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.sodangkyluuhanh" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiSoDk" name="fiSoDk" data-bind="value : fiSoDk" maxlength="255" />
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.tenduoclieuvn" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiTenHang" name="fiTenHang" data-bind="value : fiTenHang" maxlength="255" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.bophandung" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiBoPhanDung" name="fiBoPhanDung" data-bind="value : fiBoPhanDung" maxlength="255" />
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.tenkhoahoc" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenKhac" name="fiTenKhac" type="text" data-bind="value: fiTenKhac" maxlength="250"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.tieuchuanchatluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTccl" name="fiTccl" type="text" data-bind="value: fiTccl" maxlength="250"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.soluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoLuong" name="fiSoLuong" data-bind="value : fiSoLuong" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.donvitinh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaDvtinh" name="fiMaDvtinh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenDvtinh, value : fiMaDvtinh, options : lstDonViTinh, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>    
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.cososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoSx" name="fiTenCoSoSx" data-bind="value : fiTenCoSoSx" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.nuocsanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgSx" name="fiMaQgSx" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgSx, value : fiMaQgSx, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.cosocungcap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoCc" name="fiTenCoSoCc" data-bind="value : fiTenCoSoCc" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.nuoccungcap" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgCc" name="fiMaQgCc" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgCc, value : fiMaQgCc, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.ghichu" /> </label>
            </div>
            <div class="col-md-10">
                <textarea class="form-control" data-bind="value : fiGhiChu" id="fiGhiChu" name="fiGhiChu" maxlength="2000"></textarea>
            </div>
        </div> 
    </div>
</fieldset>
