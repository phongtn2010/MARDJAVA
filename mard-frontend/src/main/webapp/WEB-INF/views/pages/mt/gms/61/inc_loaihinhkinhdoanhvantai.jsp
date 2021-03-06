<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mt.61.hoso.loaihinhkdvt" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.61.hoso.loaihinhhd" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-5">                            
                <label><input style="margin: 5px" type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtTuyencodinh"/><spring:message code="mt.61.hoso.loaihinhhd.tuyencodinh"/></label><br/>
                <label><input style="margin: 5px" type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtHkDulich"/><spring:message code="mt.61.hoso.loaihinhhd.dulich"/></label>
            </div>
            <div class="col-md-5">
                <label><input style="margin: 5px" type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtHkHopdong" /><spring:message code="mt.61.hoso.loaihinhhd.hopdong"/></label><br/>
                <label><input style="margin: 5px" type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtHanghoa" /><spring:message code="mt.61.hoso.loaihinhhd.hanghoa"/></label>
            </div>
            <span data-bind="text : errorCheckBoxmessage" style="color:red;"> </span>
        </div>
    </div> 

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.61.hoso.loaihinhdenghi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiLoaihinhDn" id="fiLoaihinhDn" name="fiLoaihinhDn" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiLoaihinhDn, options : lstloaihinhDn, optionsText : 'name'" disabled></select>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.61.hoso.denghi.lydo" /><a class="nsw-require-field" data-bind="visible: isRequire">*</a></label>
            </div>  
            <div class="col-md-10">
                <textarea class="form-control" name="lyDo" data-bind="value: fiLydo" maxlength="2000"></textarea>
            </div>            
        </div>  
    </div>
    <div data-bind="visible: tuyencodinh">
        <b><spring:message code="mt.61.hoso.loaihinhkdvt.ghichu" /></b>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.tuyenvantai" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaTuyen" name="fiMaTuyen" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenTuyen, value : fiMaTuyen
                , options : lstTuyen, optionsText : 'name', event: {change: getTuyenInfoOnClick}" ></select>
                </div>            
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.tinhthanhphodi" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTenTinhDi" name="fiTenTinhDi" data-bind="value : fiTenTinhDi" maxlength="250" />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.bendi" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiBenDi" name="fiBenDi"  data-bind="value : fiBenDi" maxlength="250" />
                </div>
            </div>  
        </div>     
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.tinhthanhphoden" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTinhDen" name="fiTenTinhDen" data-bind="value : fiTenTinhDen" type="text" maxlength="250"/>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <spring:message code="mt.61.hoso.loaihinhkdvt.benden" /><a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiBenDen" name="fiBenDen"  data-bind="value : fiBenDen" type="text" maxlength="250"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.culy" />(km)<a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiCuly" name="fiCuly" data-bind="value : fiCuly" type="text" maxlength="250"/>
                </div>   
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.hanhtrinh" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiHanhtrinh" name="fiHanhtrinh" readonly="readonly" type="text" data-bind="value: fiHanhtrinh" maxlength="250"/>
                </div> 
            </div>  
        </div>         
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.socv" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSoCv" name="fiSoCv" data-bind="value : fiSoCv" type="text" maxlength="250"/>
                </div>   
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.61.hoso.loaihinhkdvt.ngaycap" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaycapCv" name="fiNgaycapCv"  data-bind="datepicker : fiNgaycapCv" type="text" data-date-format="dd/mm/yyyy" />
                </div> 
            </div>  
        </div>  
    </div>  
</fieldset>
