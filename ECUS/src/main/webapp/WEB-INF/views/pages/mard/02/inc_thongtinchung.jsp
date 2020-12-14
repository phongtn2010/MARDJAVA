<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend style="color: dodgerblue;"><b><spring:message code="mard.02.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.mahs" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="nswFilecode" name="nswFilecode" data-bind="value : nswFilecode" type="text" readonly/>
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.ngaytao" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="createDate" name="createDate" maxlength="255"  
                       type="text" data-bind="value : createDateText" disabled readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.trangthai" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="nameStatus" name="nameStatus" maxlength="255"
                       type="text" data-bind="value : nameStatus" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-left">
                <label>Số đăng kí doanh nghiệp<a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="noOfRegistration" name="noOfRegistration" maxlength="255"
                       type="text" data-bind="value : noOfRegistration"/>
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.tendn" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="nameOfRegistration" name="nameOfRegistration" maxlength="250"  
                       type="text" data-bind="value : nameOfRegistration" readonly="readonly" />
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.dienthoaidn" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="tel" name="tel" maxlength="250"  
                       type="text" data-bind="value : tel" readonly="readonly" />
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.diachidn" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="addressOfRegistration" name="addressOfRegistration" maxlength="250"  
                       type="text" data-bind="value : addressOfRegistration" readonly="readonly" />
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.email" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="email" name="email" maxlength="250"  
                       type="text" data-bind="value : email" />
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.loaisanpham" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="typeProduct" name="typeProduct" 
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : typeProduct
                            , value : typeProduct
                            , options : lstLoaiSP
                            , optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.fax" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fax" name="fax" maxlength="250"  
                       type="text" data-bind="value : fax" />
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.loaidon" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="templateType" name="templateType" 
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : templateType
                            , value : templateType
                            , options : lstLoaiDon
                            , event :{change : changeTypeRegis}
                            , optionsText : 'name'"></select>
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.02.hoso.thongtinchung.tenctyDK" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="companyName" name="companyName" maxlength="250"  
                       type="text" data-bind="value : companyName" />
            </div>
        </div>  
    </div> 
</fieldset>



