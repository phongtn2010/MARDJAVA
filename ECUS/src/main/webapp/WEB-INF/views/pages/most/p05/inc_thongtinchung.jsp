<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="most.05.hoso.thongtinchung" /></b></legend>
    <form role="form" class="form-horizontal" name="searchForm">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.mahoso" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>

                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.trangthai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTrangthai" name="fiTenTrangthai" data-bind="value : fiTenTrangthai" type="text" readonly/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.ngaytao" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.donvixuly" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaCoQuan" name="fiMaCoQuan" 
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenCoQuan
                            , value : fiMaCoQuan
                            , options : lstCQXL
                            , optionsText : 'name'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
                </div>

                <div class="col-md-4">
                    <input class="form-control" id="fiTtcTenToChuc" name="fiTtcTenToChuc" maxlength="255"  
                           type="text" data-bind="value : fiTtcTenToChuc" readonly="readonly"/>

                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.diachi" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcDiaChi" name="fiTtcDiaChi" data-bind="value : fiTtcDiaChi" type="text" readonly/>

                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.dienthoai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcDienThoai" name="fiTtcDienThoai" maxlength="255"  
                           type="text" data-bind="value : fiTtcDienThoai" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.fax" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcFax" name="fiTtcFax" maxlength="255"  
                           type="text" data-bind="value : fiTtcFax" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.email" /><a class="nsw-require-field">*</a></label>
                </div>  
                <div class="col-md-4">
                    <input class="form-control" type="email" id="fiTtcEmail" name="fiTtcEmail" data-bind="value : fiTtcEmail" maxlength="250" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.tennguoidungdau" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNddHoTen" name="fiNddHoTen" type="text" data-bind="value: fiNddHoTen" maxlength="250"/>
                </div>  
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.chucvu" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNddChucVu" name="fiNddChucVu"  data-bind="value : fiNddChucVu" type="text" maxlength="50"/>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.soCMND" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNddCmnd" name="fiNddCmnd" data-bind="value : fiNddCmnd" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.hinhthuc" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="fiHinhThucCap" name="fiHinhThucCap" data-bind="optionsCaption: 'Chọn...',
                    optionsValue : 'id', value : fiHinhThucCap,
                    options : lstHinhThuccap,
                    optionsText : 'name',
                    event: {change: getLstTeptin}"></select>
                </div>  

                <div class="col-md-2 nsw-text-right">
                    <label>
                        <spring:message code="most.05.hoso.thongtinchung.sogiayphep" />
                        <a id="sogiaypheplabel" class="nsw-require-field">*</a>
                    </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control " id="soGiayPhep" type="text" maxlength="50" data-bind="value: fiSoGiayPhep,event: {change: validHTC}"/>
                    <span class="validationMessage" id="valid-soGiayPhep" style="display: none">Thông tin bắt buộc nhập</span>
                </div>
            </div>  
        </div>

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.ngaycap" /><a id="ngaycaplabel" class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="ngayCap" type="text" maxlength="50" data-bind="datepicker : fiNgayCap,event: {change: validHTC}"
                           placeholder="dd/mm/yyyy"  data-date-format="dd/mm/yyyy" />
                    <span class="validationMessage" id="valid-ngayCap" style="display: none">Thông tin bắt buộc nhập</span>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongtinchung.lydocaplai" /><a id="lydocaplailabel" class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control" id="fiLydocaplai" name="fiLydocaplai" data-bind="optionsCaption: '--- Chọn ---'
                    , optionsValue : 'id',value : fiLydocaplai , options : lstLyDoDN
                    , optionsText : 'name'
                    , event: {change: validHTC}"></select>
                    
                    <span class="validationMessage" id="valid-fiLydocaplai" style="display: none">Thông tin bắt buộc nhập</span>
                </div>
            </div> 
        </div>
    </form>
</fieldset>
