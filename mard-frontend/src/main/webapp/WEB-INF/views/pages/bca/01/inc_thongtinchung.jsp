<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="bca.01.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.donvixuly" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaCoquan" name="fiMaCoquan" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCoquan, value : fiMaCoquan, options : lstCqxl, optionsText : 'name'"></select>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMst" name="fiMst" readonly="readonly" data-bind="value : fiMst" maxlength="13" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.diachitruso" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiDn" name="fiDiachiDn" readonly="readonly" type="text" data-bind="value: fiDiachiDn" maxlength="250"/>
            </div>  
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.dienthoai" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdt" name="fiSdt" readonly data-bind="value : fiSdt" type="text" maxlength="50"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.01.hoso.thongtinchung.sodangky" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoDondk" name="fiSoDondk" data-bind="value : fiSoDondk" type="text" maxlength="50"/>
            </div>

            <div class="col-md-2 nsw-text-right">
                <label> <spring:message code="bca.01.hoso.thongtinchung.soluongdoan"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSoluongDoan" name="fiSoluongDoan" data-bind="value : fiSoluongDoan" type="number" min="0" maxlength="2" oninput="validity.valid||(value='');"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="bca.01.hoso.thongtinchung.thongtindoan" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiThongtinDoan" name="fiThongtinDoan" type="text" data-bind="value: fiThongtinDoan" maxlength="500"/>
                </div>                
            </div>  
        </div>
    </fieldset>
