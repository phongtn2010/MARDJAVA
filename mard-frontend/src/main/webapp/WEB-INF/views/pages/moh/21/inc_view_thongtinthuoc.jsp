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
                <label><spring:message code="moh.19.donhang.xuatxuhanghoa" /> <a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <select class="form-control select2 fiXuatXu" id="fiXuatXu" disabled data-bind="value: fiXuatXu,                                
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : lstXuatXuHangHoa"></select>
            </div>
            <div class="col-md-2 nsw-text-right" data-bind="visible: visibleTenThuoc">
                <label><spring:message code="moh.19.donhang.tenthuoc" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4" data-bind="visible: visibleTenThuoc">                                        
                <input class="form-control" type="text" id="fiTenThuoc" readonly="readonly" name="fiTenThuoc" data-bind="value : fiTenThuoc" maxlength="255" />
            </div>

        </div>  
    </div>  
    <div class="form-group" data-bind="visible: visibleTenNguyenLieu">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tennguyenlieu" />
                    <a class="nsw-require-field">*</a>
                </label>
            </div>
            <div class="col-md-10">         
                <select class="form-control select2 fiMaHang" id="fiMaHang" disabled data-bind="value: fiMaHang,                                
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : lstNguyenLieu"></select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.dangbaoche" /> <a class="nsw-require-field" data-bind="visible: visibleNhomThuocTinhThuoc">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBaoChe" name="fiBaoChe" readonly="readonly" type="text" data-bind="value: fiBaoChe" maxlength="250"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.quycachdonggoi" /><a class="nsw-require-field" data-bind="visible: visibleNhomThuocTinhThuoc">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiDongGoi" readonly="readonly" name="fiDongGoi" data-bind="value : fiDongGoi" type="text" maxlength="100"/>
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.hoatchat" />  <a class="nsw-require-field"data-bind="visible: visibleNhomThuocTinhThuoc">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiHoatChat" name="fiHoatChat" readonly="readonly" type="text" data-bind="value: fiHoatChat" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.hamluongnongdo" />  <a class="nsw-require-field" data-bind="visible: visibleNhomThuocTinhThuoc">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiHamLuong" name="fiHamLuong" readonly="readonly" data-bind="value : fiHamLuong" type="text" maxlength="100"/>
            </div>            
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.sogiayphepluuhanh" /> <a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoDk" name="fiSoDkLh" type="text" readonly="readonly" data-bind="value: fiSoDkLh" maxlength="250"/>
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.sogiayphepnhapkhau" /><a class="nsw-require-field" data-bind="visible: visibleFiSoGpNkVn">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGpNkVn" name="fiSoGpNkVn" readonly="readonly" type="text" data-bind="value: fiSoGpNkVn" maxlength="250"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.ngaycap" /><a class="nsw-require-field" data-bind="visible: visibleFiSoGpNkVn">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" readonly="readonly" id="fiNgayGpNkVn" name="fiNgayGpNkVn" type="text" data-bind="datepicker : fiNgayGpNkVn"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div>
        </div>  
    </div>
    <div class="form-group" data-bind="visible: visibleFiSoGpNkNn">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.sogiayphepnhapkhau_nn" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGpNkNn" name="fiSoGpNkNn" readonly="readonly" type="text" data-bind="value: fiSoGpNkNn" maxlength="250"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.ngaycap" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" readonly="readonly" id="fiNgayGpNkNn" name="fiNgayGpNkNn" type="text" data-bind="datepicker : fiNgayGpNkNn"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div>
        </div>  
    </div>
    <div class="form-group" data-bind="visible: visibleFiSoGpNkNn">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.coquancap" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoicapGpNn" name="fiNoicapGpNn" readonly="readonly" type="text" data-bind="value: fiNoicapGpNn" maxlength="250"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.ngayhethieuluc" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" readonly="readonly" id="fiHieulucGpNn" name="fiHieulucGpNn" type="text" data-bind="datepicker : fiHieulucGpNn"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.soluong" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoLuong" name="fiSoLuong" readonly="readonly" data-bind="value : fiSoLuong" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.donvitinh" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaDvtinh" disabled name="fiMaDvtinh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenDvtinh, value : fiMaDvtinh, options : lstDonViTinh, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>    
    <div class="form-group" data-bind="visible: visibleFiTccl">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tieuchuanchatluong" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTccl" name="fiTccl" readonly="readonly" type="text" data-bind="value: fiTccl" maxlength="250"/>
            </div>
        </div>  
    </div>     
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tencososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoSx" name="fiTenCoSoSx" readonly="readonly" data-bind="value : fiTenCoSoSx" type="text" maxlength="100"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.nuocsanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgSx" name="fiMaQgSx" disabled data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgSx, value : fiMaQgSx, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.diachicososanxuat" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <textarea class="form-control" data-bind="value : fiDiachiCssx" readonly="readonly" id="fiDiachiCssx" name="fiDiachiCssx" maxlength="2000"></textarea>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.tencosonhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoSoNk" name="fiTenCoSoNk" readonly="readonly" data-bind="value : fiTenCoSoNk" type="text" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.nuocnhapkhau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaQgNk" name="fiMaQgNk" disabled data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgNk, value : fiMaQgNk, options : ltsNuocSanXuat, optionsText : 'name'"></select>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.diachicosonhapkhau" /> <a class="nsw-require-field">*</a> </label>
            </div>
            <div class="col-md-10">
                <textarea class="form-control" data-bind="value : fiDiachiCsNk" readonly="readonly" id="fiDiachiCsNk" name="fiDiachiCsNk" maxlength="2000"></textarea>
            </div>
        </div> 
    </div>
    <div class="form-group" data-bind="visible: isFirstGroup">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.19.donhang.cosodenghi" /></label>
            </div>
            <div class="col-md-10">         
                <select class="form-control select2 fiCosoCppFsc" id="fiCosoCppFsc" disabled data-bind="value: fiCosoCppFsc,                                
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : lstCoSoDeNghiCap"></select>
            </div>
        </div>
    </div>
</fieldset>
