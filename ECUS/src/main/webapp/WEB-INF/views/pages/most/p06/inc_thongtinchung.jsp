<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="most.06.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.tracuu.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTrangthai" type="text" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgayTao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.donvixuly" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select class="form-control select2" id="fiMaCqxl" name="fiMaCqxl" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText2 : fiTenCoQuan, value : fiMaCoQuan, options : lstDonViXuLy, optionsText : 'name'"></select>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="tendoanhnghiep" maxlength="255"  
                       type="text" data-bind="value : fiTtcTenToChuc" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.diachitruso" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="diachitruso" data-bind="value : fiTtcDiaChi" type="text" readonly/>

            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.dienthoai" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="dienthoai" data-bind="value : fiTtcDienThoai" type="text" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.fax" /></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTtcFax"  data-bind="value : fiTtcFax" maxlength="250" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">

            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.email" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="email" id="fiMst" name="email" data-bind="value : fiTtcEmail" maxlength="250" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.hotennguoidungdau" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiTsc" name="hotennguoidungdau"type="text" data-bind="value: fiNddHoTen" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.chucvu" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdt" name="chucvu"  data-bind="value : fiNddChucVu" type="text" maxlength="50"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.socmndhochieu" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFax" name="socmndhochieu" data-bind="value : fiNddCmnd" type="text" maxlength="50"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.hinhthuccap" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fihinhthucCap" name="fihinhthucCap" 
                        data-bind="optionsCaption: 'Chọn...'
                        , optionsValue : 'id'
                        , value : fiHinhThucCap
                        , options : lstHinhthucCap
                        ,optionsText : 'name', 
                        event:{change:getLstTeptin}"></select>
            </div>                
            <div class="col-md-2 nsw-text-right">
                <label>
                    <spring:message code="most.06.hoso.thongtinchung.sogiayphep" />
                    <a id="sogiaypheplabel" class="nsw-require-field">*</a>
                </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGiayPhep" name="sogiayphep" type="text" data-bind="value: fiSoGiayPhep, event: {change: validHTC}" maxlength="250"/>
                <span class="validationMessage" id="valid-soGiayPhep" style="display: none">Thông tin bắt buộc nhập</span>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label>
                    <spring:message code="most.06.hoso.thongtinchung.ngaycap" />
                    <a id="ngaycaplabel" class="nsw-require-field">*</a>
                </label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaycapDk" name="fiNgaycapDk" data-bind="datepicker : fiNgayCap, event: {change: validHTC}" type="text" data-date-format="dd/mm/yyyy" />
                <span class="validationMessage" id="valid-ngayCap" style="display: none">Thông tin bắt buộc nhập</span>
                <span data-bind="text : errorNc" style="color:red; margin-top: 10px;"> </span>  
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>
                    <spring:message code="most.06.hoso.thongtinchung.lydocaplai" />
                    <a id="lydocaplailabel" class="nsw-require-field">*</a>
                </label>
            </div>
            <div class="col-md-4">
                <select class="form-control" id="fiLydocaplai" name="fiLydocaplai" data-bind="optionsCaption: 'Chọn...'
                    , optionsValue : 'id',value : fiLydocaplai , options : lstLyDoDN
                    , optionsText : 'name'
                        , event: {change: validHTC}"></select>
                <span class="validationMessage" id="valid-fiLydocaplai" style="display: none">Thông tin bắt buộc nhập</span>
            </div>
        </div>  
    </div>  
</fieldset>
