<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend style="color: dodgerblue;"><b><spring:message code="mard.03.hoso.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.mst" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoSo" name="fiMaHoSo" type="text" data-bind="value : fiMaHoSo" readonly="readonly"/>

            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.trangthai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTrangThai" name="fiTrangThai" data-bind="value : fiTrangThai" type="text" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.ngaytao" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgayTao" name="fiNgayTao"  data-bind="datepicker : fiNgayTao" type="text" data-date-format="dd/mm/yyyy" readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.coquanxly" /></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="departmentCode" name="departmentCode"
                        data-bind="optionsCaption: 'Chọn cơ quan xử lý', optionsValue : 'id'
                            , selectedText2 : fiTenCQ
                            , value : fiMaCQ
                            , options : lstCQXL
                            , optionsText : 'name'" disabled></select>
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.noidky" /></label>
            </div>

            <div class="col-md-4">
                <select class="form-control select2" id="regPlace" name="regPlace"
                        data-bind="optionsCaption: 'Chọn nơi đăng ký', optionsValue : 'id'
                            , selectedText2 : fiTenNoiDK
                            , value : fiMaNoiDK
                            , options : lstRegPlace
                            , optionsText : 'name'
                            ,event: {change: changeNoiDk}" disabled></select>
            </div>

            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.donkhaibaoso" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoDonKhaiBao" name="fiSoDonKhaiBao"  type="text" data-bind="value : fiSoDonKhaiBao" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.loaisp" /></label>
            </div>

            <div class="col-md-4">
                <select class="form-control select2" id="fiMaLoaiSp" name="fiMaLoaiSp"
                        data-bind="optionsCaption: 'Chọn loại sản phẩm', optionsValue : 'id'
                            , selectedText2 : fiTenLoaiSp
                            , value : fiMaLoaiSp
                            , options : lstLoaiSp
                            , optionsText : 'name'
                            , event: {change: changeLoaiSp}" disabled>
                </select>
            </div>
            <!--ko if: isView3 -->
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.socongvancap" /></label>
            </div>

            <div class="col-md-4">
                <input class="form-control" id="fiSoCongVanCap" name="fiSoCongVanCap" type="text" data-bind="value : fiSoCongVanCap" disabled/>
            </div>
            <!-- /ko -->
        </div>
    </div>
    <!--ko if: isView3 -->
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-left">
                <label><spring:message code="mard.03.hoso.thongtinchung.socnkiemdichnk" /></label>
            </div>

            <div class="col-md-4">
                <input class="form-control" id="fiSoGcnKdNk" name="fiSoGcnKdNk" type="text" data-bind="value : fiSoGcnKdNk" disabled/>
            </div>
        </div>
    </div>
    <!-- /ko -->
</fieldset>

