<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="bca.02.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.donvixuly" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select disabled class="form-control select2" id="fiMaCoquan" name="fiMaCoquan" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCoquan, value : fiMaCoquan, options : lstCqxl, optionsText : 'name'"></select>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.tendn" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input disabled class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input disabled class="form-control" type="text" id="fiMst" name="fiMst" readonly="readonly" data-bind="value : fiMst" maxlength="13" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.dcchuso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiDiachiDn" name="fiDiachiDn" readonly="readonly" type="text" data-bind="value: fiDiachiDn" maxlength="250"/>
            </div>  
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.dienthoai" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiSdt" name="fiSdt" readonly data-bind="value : fiSdt" type="text" maxlength="50"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.sodondk" /></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiSoDondk" name="fiSoDondk" data-bind="value : fiSoDondk" type="text" maxlength="50"/>
            </div>
        </div> 
    </div>


    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.uynhiem" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiNguoiDaidien" name="fiNguoiDaidien" type="text" data-bind="value: fiNguoiDaidien" maxlength="250"/>
            </div>     
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.chucvu" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiChucvuDaidien" name="fiChucvuDaidien" type="text" data-bind="value: fiChucvuDaidien" maxlength="250"/>
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.mangso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiSoCmnd" name="fiSoCmnd" type="text" data-bind="value: fiSoCmnd" maxlength="250"/>
            </div>     
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.ngaycap" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaycapCmnd" name="fiNgaycapCmnd"  data-bind="datepicker : fiNgaycapCmnd" type="text" data-date-format="dd/mm/yyyy"/>
            </div> 
        </div>  
    </div>


    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.noicap" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiNoicapCmnd" name="fiNoicapCmnd" type="text" data-bind="value: fiNoicapCmnd" maxlength="250"/>
            </div>         
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.theohoadon" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiHoadonSo" name="fiHoadonSo" type="text" data-bind="value: fiHoadonSo" maxlength="250"/>
            </div>     
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.ngayhoadon" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiHoadonNgay" name="fiHoadonNgay"  data-bind="datepicker : fiHoadonNgay" type="text" data-date-format="dd/mm/yyyy" />
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinchung.cqcaphoadon" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiHoadonTencqc" name="fiHoadonTencqc" type="text" data-bind="value: fiHoadonTencqc" maxlength="250"/>
            </div>         
        </div>  
    </div>
</fieldset>
