<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mt.hoso.thongtinkyhoso" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.thongtinkyhoso.nguoiky" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" id="fiTenNgKy" name="fiTenNgKy" data-bind="value : fiTenNgKy" maxlength="250"></input>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.thongtinkyhoso.chucdanh" /> <a class="nsw-require-field">*</a></label>
            </div>

            <div class="col-md-4">
                <input class="form-control" id="fiChucDanh" name="fiChucDanh" data-bind="value : fiChucDanh" maxlength="250"></input>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.hoso.thongtinkyhoso.diadiem" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">     
                <input class="form-control" id="fiDiaDiem2" name="fiDiaDiem2" data-bind="value : fiDiaDiem2" maxlength="250"></input>
            </div>
        </div>  
    </div> 
</fieldset>