<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend style="color: dodgerblue;"><b><span id="sign17">Phần V: </span> <span id="sign18">Phần VI: </span> <spring:message code="mard.04.hoso.thongtinkydon" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinkydon.nguoiky" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="nguoiky" name="nguoiky" maxlength="250"  
                       type="text" data-bind="value : signName" />

            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinkydon.chucvu" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="chucvu" name="chucvu" data-bind="value : signLocation" type="text" maxlength="250" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinkydon.noiky" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="signAddress" name="signAddress" maxlength="250"  
                       type="text" data-bind="value : signAddress" />
            </div>
        </div>  
    </div> 
</fieldset>