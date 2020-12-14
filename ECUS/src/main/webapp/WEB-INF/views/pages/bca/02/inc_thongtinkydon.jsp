<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="bca.01.hoso.thongtinkydon" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinkydon.nguoiky" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" id="fiNguoiky" name="fiNguoiky" data-bind="value : fiNguoiky" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinkydon.diadiemky" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">     
                <input class="form-control" id="fiDiadiemky" name="fiDiadiemky" data-bind="value : fiDiadiemky" maxlength="250"/>
            </div>
        </div>  
    </div> 
</fieldset>