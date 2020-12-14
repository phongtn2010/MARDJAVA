<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.19.thongtindonhang" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.hoso.loaidonhang" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiLoaiDon" name="fiLoaiDon" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiLoaiDon, options : lstLoaiDonHang, optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tenthuoc" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiTenHang" name="fiTenHang" data-bind="value : fiTenHang" maxlength="255" />
            </div>

        </div>  
    </div>     
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.quycachdonggoi" /><a class="nsw-require-field" >*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiDongGoi" name="fiDongGoi" data-bind="value : fiDongGoi" type="text" maxlength="100"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.dangbaoche" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBaoChe" name="fiBaoChe" type="text" data-bind="value: fiBaoChe" maxlength="250"/>
            </div>
        </div>  
    </div>
    <div class="form-group" data-bind="visible: isFirstGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.hoatchat" />  <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiHoatChat" name="fiHoatChat" type="text" data-bind="value: fiHoatChat" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.hamluongnongdo" />  <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiHamLuong" name="fiHamLuong" data-bind="value : fiHamLuong" type="text" maxlength="100"/>
            </div>            
        </div> 
    </div>
    <div class="form-group" data-bind="visible: isSecondGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.hoso.ttt.tenduoclieuvn" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiTenKhac" name="fiTenKhac" data-bind="value : fiTenKhac" maxlength="255" />
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
                <label><spring:message code="moh.19.donhang.soluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoLuong" name="fiSoLuong" data-bind="value : fiSoLuong" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.donvitinh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaDvtinh" name="fiMaDvtinh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenDvtinh, value : fiMaDvtinh, options : lstDonViTinh, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>    
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.handung" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenKhac" name="fiTenKhac" type="text" data-bind="value: fiTenKhac" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tieuchuanchatluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTccl" name="fiTccl" type="text" data-bind="value: fiTccl" maxlength="250"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.chidinh" />  <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiChiDinh" name="fiChiDinh" type="text" data-bind="value: fiChiDinh" maxlength="250"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.nuocsanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgSx" name="fiMaQgSx" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgSx, value : fiMaQgSx, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tencososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoSx" name="fiTenCoSoSx" data-bind="value : fiTenCoSoSx" type="text" maxlength="100"/>
            </div>                            
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.diachicososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <textarea class="form-control" data-bind="value : fiDiachiCssx" id="fiDiachiCssx" name="fiDiachiCssx" maxlength="2000"></textarea>
            </div>
        </div> 
    </div>
    <div class="form-group"  data-bind="visible: isThirdGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.nuocxuatkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgXk" name="fiMaQgXk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgXk, value : fiMaQgXk, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tencosoxuatkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoNk" name="fiTenCoSoXk" data-bind="value : fiTenCoSoXk" type="text" maxlength="250"/>
            </div>
                            
        </div>  
    </div>
    <div class="form-group"  data-bind="visible: isThirdGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.diachicosoxuatkhau" /> <a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <textarea class="form-control" data-bind="value : fiDiachiCsXk" id="fiDiachiCsXk" name="fiDiachiCsXk" maxlength="2000"></textarea>
            </div>
        </div> 
    </div>
    <div class="form-group" data-bind="visible: isThirdGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right" >
                <label><spring:message code="moh.19.donhang.tencssohuugiayphep" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCsSh" name="fiTenCsSh" data-bind="value : fiTenCsSh" type="text" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right" >
                <label><spring:message code="moh.19.donhang.tennuoccapgiaysohuu" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgSh" name="fiMaQgSh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgSh, value : fiMaQgSh, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>       
        </div>  
    </div>
</fieldset>
