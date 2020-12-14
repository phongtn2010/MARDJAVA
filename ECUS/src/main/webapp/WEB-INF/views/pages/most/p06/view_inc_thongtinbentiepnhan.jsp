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
                <input class="form-control" id="fiMaHoso" name="tendoanhnghiep" maxlength="255"  
                       type="text" data-bind="value : fiTtTiepNhanTen" readonly="readonly"/>
                
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinnhanhanghoa.dcchuso" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="diachitruso" data-bind="value : fiTtTiepNhanDiaChi" readonly="readonly"/>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.dienthoai" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                 <input class="form-control" id="fiTenTt" name="dienthoai" data-bind="value : fiTtTiepNhanDienThoai" type="text" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.fax" /></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fax"  data-bind="value : fiTtcFax" maxlength="250" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.email" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMst" name="email"  data-bind="value : fiTtTiepNhanEmail" maxlength="250" readonly="readonly"/>
            </div>
        </div>  
    </div> 
</fieldset>
