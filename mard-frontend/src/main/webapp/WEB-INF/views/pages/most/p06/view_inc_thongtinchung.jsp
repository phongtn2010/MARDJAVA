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
                <label><spring:message code="mt.danhsach.mahoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                       type="text" data-bind="value : fiMaHoso" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.36.hoso.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTrangThai" type="text" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.36.hoso.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgayTao" type="text" data-date-format="dd/mm/yyyy" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.36.hoso.donvixuly" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" id="fiTenCoQuan" name="fiTenCoQuan" maxlength="255"  
                       type="text" data-bind="value : fiTenCoQuan" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.tendoanhnghiep" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="tendoanhnghiep" maxlength="255"  
                       type="text" data-bind="value : fiTtcTenToChuc" readonly="readonly"/>
                
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.diachitruso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTt" name="diachitruso" data-bind="value : fiTtcDiaChi" type="text" readonly/>
                
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.dienthoai" /></label>
            </div>
            <div class="col-md-4">
                 <input class="form-control" id="fiTenTt" name="dienthoai" data-bind="value : fiTtcDienThoai" type="text" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.fax" /></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiTenDn" name="fiTtcFax"  data-bind="value : fiTtcFax" maxlength="250" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.email" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control" type="text" id="fiMst" name="email" data-bind="value : fiTtcEmail" maxlength="13" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.hotennguoidungdau" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiTsc" name="hotennguoidungdau" readonly="readonly" type="text" data-bind="value: fiNddHoTen" maxlength="250"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.chucvu" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdt" name="chucvu"  data-bind="value : fiNddChucVu" type="text" maxlength="50" readonly="readonly"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.socmndhochieu" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFax" name="socmndhochieu" data-bind="value : fiNddCmnd" type="text" maxlength="50" readonly="readonly"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.hinhthuccap" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" id="fiFax" name="socmndhochieu" data-bind="value : fiHinhThucCap" type="text"  readonly="readonly"/>
            </div>                
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.sogiayphep" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiWeb" name="sogiayphep" type="text" data-bind="value: fiSoGiayPhep" maxlength="250" readonly="readonly"/>
            </div>                
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.ngaycap" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaycapDk" name="fiNgaycapDk" data-bind="datepicker : fiNgayCap" type="text" data-date-format="dd/mm/yyyy" disabled=""/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="most.06.hoso.thongtinchung.lydocaplai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiLydo" name="fiLydo" type="text" data-bind="value: fiLydo" readonly="readonly"/>
            </div>
        </div>  
    </div>  
</fieldset>
