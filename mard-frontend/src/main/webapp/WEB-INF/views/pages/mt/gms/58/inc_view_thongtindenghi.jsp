<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mt.58.hoso.denghi" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.loaihinhhd" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-6">                            
                            <label><input style="margin: 5px" disabled type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtTuyencodinh"/><spring:message code="mt.58.hoso.loaihinhhd.tuyencodinh"/></label><br/>
                            <label><input style="margin: 5px" disabled type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtHkDulich"/><spring:message code="mt.58.hoso.loaihinhhd.dulich"/></label>
                        </div>
                        <div class="col-md-6">
                            <label><input style="margin: 5px" disabled type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtHkHopdong" /><spring:message code="mt.58.hoso.loaihinhhd.hopdong"/></label><br/>
                            <label><input style="margin: 5px" disabled type="checkbox" name="checkLoaihinhhd" class="checkLoaihinhhd" id="fiVtHanghoa" /><spring:message code="mt.58.hoso.loaihinhhd.hanghoa"/></label>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.loaihinhdenghi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" disabled id="fiLoaihinhDn" name="fiLoaihinhDn" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiLoaihinhDn, options : lstloaihinhDn, optionsText : 'name'"></select>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.hoso.denghi.lydo" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-10">
                <textarea class="form-control" readonly name="lyDo" data-bind="value: fiLydo" maxlength="2000"></textarea>
            </div>            
        </div>  
    </div> 
</fieldset>
