<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.18.thongtindonhang" /></b></legend>
    <div class="form-group" data-bind="visible: isFirstGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tenthuoc" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">                                        
                <input class="form-control" type="text" id="fiTenHang" name="fiTenHang" data-bind="value : fiTenHang" maxlength="255" />
            </div>

        </div>  
    </div>
    <div class="form-group" data-bind="visible: isFirstGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.dangbaoche" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBaoChe" name="fiBaoChe" type="text" data-bind="value: fiBaoChe" maxlength="255"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.dangbaoche_en" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiBaoCheEn" name="fiBaoCheEn" data-bind="value : fiBaoCheEn" type="text" maxlength="255"/>
            </div> 
        </div>  
    </div>
    <div class="form-group" data-bind="visible: isFirstGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.quycachdonggoi" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" id="fiDongGoi" name="fiDongGoi" type="text" data-bind="value: fiDongGoi" maxlength="1000"></textarea>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.quycachdonggoi_en" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control form-control-inline" id="fiDongGoiEn" name="fiDongGoiEn" data-bind="value : fiDongGoiEn" type="text" maxlength="1000"></textarea>
            </div> 
        </div>  
    </div>
    <div class="form-group" data-bind="visible: isFirstGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.hoatchat" />  <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" id="fiHoatChat" name="fiHoatChat" type="text" data-bind="value: fiHoatChat" maxlength="1000"/></textarea>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.hamluongnongdo" />  <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiHamLuong" name="fiHamLuong" data-bind="value : fiHamLuong" type="text" maxlength="255"/>
            </div>            
        </div> 
    </div>
    <div class="form-group" data-bind="visible: isSecondGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tennguyenlieu" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">         
                <select class="form-control select2 fiMaNglieu" id="fiMaNglieu" data-bind="value: fiMaNglieu,                                
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : lstNguyenLieu"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Tên nguyên liệu (nhà sản xuất) <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenNglieuNsx" name="fiTenNglieuNsx" data-bind="value : fiTenNglieuNsx" type="text" maxlength="255"/>
            </div>
        </div>
    </div>
    <div class="form-group" data-bind="visible: isSecondGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tieuchuanchatluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTccl" name="fiTccl" type="text" data-bind="value: fiTccl" maxlength="255"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tieuchuanchatluong_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTcclEn" name="fiTcclEn" type="text" data-bind="value: fiTcclEn" maxlength="255"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.sogiayphepluuhanh" /> <a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoDk" name="fiSoDkLh" type="text" data-bind="value: fiSoDkLh" maxlength="255"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.soluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoLuong" name="fiSoLuong" data-bind="value : fiSoLuong" type="text" maxlength="21"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.donvitinh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaDvtinh" name="fiMaDvtinh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenDvtinh, value : fiMaDvtinh, options : lstDonViTinh, optionsText : 'name'"></select>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.donvitinh_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenDvtinhEn" name="fiTenDvtinhEn" type="text" data-bind="value: fiTenDvtinhEn" maxlength="255"/>
            </div> 
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tencososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" id="fiTenCoSoSx" name="fiTenCoSoSx" data-bind="value : fiTenCoSoSx" type="text" maxlength="500"></textarea>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tencososanxuat_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" id="fiTenCoSoSxEn" name="fiTenCoSoSxEn" data-bind="value : fiTenCoSoSxEn" type="text" maxlength="500"></textarea>
            </div>
        </div>
    </div>    
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.diachicososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" data-bind="value : fiDiachiCssx" id="fiDiachiCssx" name="fiDiachiCssx" maxlength="1000"></textarea>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.diachicososanxuat_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" data-bind="value : fiDiachiCssxEn" id="fiDiachiCssxEn" name="fiDiachiCssxEn" maxlength="1000"></textarea>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.nuocsanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgSx" name="fiMaQgSx" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgSx, value : fiMaQgSx, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>    
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.nuocsanxuat_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenQgSxEn" name="fiTenQgSxEn" data-bind="value : fiTenQgSxEn" type="text" maxlength="255"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tencosonhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoNk" name="fiTenCoSoNk" data-bind="value : fiTenCoSoNk" type="text" maxlength="500"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.tencosonhapkhau_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoNkEn" name="fiTenCoSoNkEn" data-bind="value : fiTenCoSoNkEn" type="text" maxlength="500"/>
            </div>                            
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.diachicosonhapkhau" /> <a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" data-bind="value : fiDiachiCsNk" id="fiDiachiCsNk" name="fiDiachiCsNk" maxlength="1000"></textarea>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.diachicosonhapkhau_en" /> <a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <textarea class="form-control" data-bind="value : fiDiachiCsNkEn" id="fiDiachiCsNkEn" name="fiDiachiCsNkEn" maxlength="1000"></textarea>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.nuocnhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgNk" name="fiMaQgNk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgNk, value : fiMaQgNk, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.18.donhang.nuocnhapkhau_en" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenQgNkEn" name="fiTenQgNkEn" data-bind="value : fiTenQgNkEn" type="text" maxlength="255"/>
            </div>
        </div>
    </div>
</fieldset>
