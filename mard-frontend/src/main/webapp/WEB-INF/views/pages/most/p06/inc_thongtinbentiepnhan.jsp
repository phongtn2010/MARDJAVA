<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="most.06.hoso.thongtinnhanhanghoa" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinnhanhanghoa.tendn" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTtTiepNhanTen" name="fiTtTiepNhanTen" maxlength="250"  
                       type="text" data-bind="value : fiTtTiepNhanTen" />

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinnhanhanghoa.dcchuso" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTtTiepNhanDiaChi" name="fiTtTiepNhanDiaChi" data-bind="value : fiTtTiepNhanDiaChi" maxlength="250"/>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.dienthoai" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTtTiepNhanDienThoai" name="fiTtTiepNhanDienThoai" data-bind="value : fiTtTiepNhanDienThoai" type="text" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.fax" /></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTtTiepNhanFax" name="fiTtTiepNhanFax"  data-bind="value : fiTtTiepNhanFax" maxlength="250" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.email" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="email" id="fiTtTiepNhanEmail" name="fiTtTiepNhanEmail"  data-bind="value : fiTtTiepNhanEmail" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.quocgia" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiTtTiepNhanQuocgia" name="fiTtTiepNhanQuocgia" data-bind="optionsCaption: 'Chọn...'
                , optionsValue : 'name'
                , value: fiTtTiepNhanQuocgia
                , options : lstQuocgia
                , optionsText : 'name'"></select>
            </div>
        </div>  
    </div> 
</fieldset>
