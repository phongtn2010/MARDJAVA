<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="mic.02.hoso.thongtinkydon" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mic.02.hoso.thongtinkydon.nguoiky" /> </label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" id="fiNguoiky" name="fiNguoiky" data-bind="value : $data.formVM().fiNguoiKy" maxlength="250" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mic.02.hoso.thongtinkydon.fiChucDanh" /> </label>
            </div>
            <div class="col-md-4">     
                <input class="form-control" id="fiChucDanh" name="fiChucDanh" data-bind="value : $data.formVM().fiChucDanh" maxlength="250" readonly="readonly"/>
            </div>
        </div>  
    </div> 
</fieldset>