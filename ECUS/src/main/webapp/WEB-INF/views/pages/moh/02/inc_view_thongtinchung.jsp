<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset id="dn02">
    <div data-bind="with: tbdDoanhnghiep02()">
        <legend style="color: dodgerblue;"><b><spring:message code="moh.02.hoso.thongtinchung"/></b></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.mahoso"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.trangthai"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTt" name="fiTenTt" type="text" data-bind="value : fiTenTt"
                           readonly/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.ngaytao"/></label>
                </div>
                <div class="col-md-4">
                    <input name="fiNgaytao" id="fiNgaytao" class="form-control form-control-inline date-picker"
                           data-date-format="dd/mm/yyyy" type="text" value="" placeholder="dd/mm/yyyy"
                           disabled="disabled" readonly="readonly"
                           data-bind="datepicker : fiNgaytao"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.masothue"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaSothue" name="fiMaSothue" maxlength="50"
                           type="text" readonly="readonly" data-bind="value : fiMaSothue"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.tendoanhnghiep"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenDoanhnghiep" name="fiTenDoanhnghiep" maxlength="255"
                           type="text" readonly="readonly" data-bind="value : fiTenDoanhnghiep"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.nguoidaidien"/></label>
                </div>

                <div class="col-md-4">
                    <input class="form-control" id="fiNguoiDaidien" name="fiNguoiDaidien" maxlength="255"
                           data-bind="value : fiNguoiDaidien"
                           type="text" disabled/>

                </div>

            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.diachi"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDiachi" name="fiDiachi" maxlength="255"
                           data-bind="value : fiDiachi"
                           type="text" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.chucvu"/></label>
                </div>

                <div class="col-md-4">
                    <input class="form-control" id="fiChucvu" name="fiChucvu" maxlength="255"
                           data-bind="value : fiChucvu"
                           type="text" disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.socongvan"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoCongvan" name="fiSoCongvan" maxlength="10"
                           data-bind="value : fiSoCongvan"
                           type="text" disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.02.hoso.thongtinchung.noidung"/></label>
                </div>

                <div class="col-md-4">
                    <input class="form-control" id="fiNoidungCongvan" name="fiNoidungCongvan" maxlength="255"
                           data-bind="value : fiNoidungCongvan"
                           type="text" disabled/>
                </div>
            </div>
        </div>
    </div>
</fieldset>



