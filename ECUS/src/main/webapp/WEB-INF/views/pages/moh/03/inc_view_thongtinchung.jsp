<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset id="dn03">
    <div data-bind="with: doanhnghiep03()">
        <legend style="color: dodgerblue;"><b><spring:message code="moh.03.hoso.thongtinchung"/></b></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.mahoso"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso"
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.trangthai"/></label>
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
                    <label><spring:message code="moh.03.hoso.thongtinchung.ngaytao"/></label>
                </div>
                <div class="col-md-4">
                    <input name="fiNgaytao" id="fiNgaytao"
                           class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                           type="text" value="" placeholder="dd/mm/yyyy" disabled="disabled" readonly="readonly"
                           data-bind="datepicker : fiNgaytao"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.masothue"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaSothue" name="fiMaSothue" maxlength="50"
                           data-bind="value : fiMaSothue"
                           type="text" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.tendoanhnghiep"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenDn" name="fiTenDn"
                           type="text" readonly="readonly" data-bind="value : fiTenDn" maxlength="255"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.nguoidaidien"/></label>
                </div>

                <div class="col-md-4">
                    <input class="form-control" id="fiNguoiDaidien" name="fiNguoiDaidien" maxlength="255"
                           type="text" data-bind="value : fiNguoiDaidien" disabled/>

                </div>

            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.diachi"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDiachi" name="fiDiachi" maxlength="255"
                           type="text" readonly="readonly" data-bind="value : fiDiachi" disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.chucvu"/></label>
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
                    <label><spring:message code="moh.03.hoso.thongtinchung.sodkkd"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoDkkd" name="fiSoDkkd" maxlength="255"
                           type="text" data-bind="value : fiSoDkkd" disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.ngaycapdkkd"/></label>
                </div>

                <div class="col-md-4">
                    <input name="fiNgaycapDk" id="fiNgaycapDk"
                           class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                           type="text" value="" placeholder="dd/mm/yyyy"
                           data-bind="datepicker : fiNgaycapDk" disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.sogsp"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoGsp" name="fiSoGsp" maxlength="255"
                           type="text" data-bind="value : fiSoGsp" disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.ngaycapgsp"/></label>
                </div>

                <div class="col-md-4">
                    <input name="fiNgaycapGsp" id="fiNgaycapGsp"
                           class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                           type="text" value="" placeholder="dd/mm/yyyy"
                           data-bind="datepicker : fiNgaycapGsp" disabled/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <span class="nsw-require-field">Chú ý: Nếu không có giấy chứng nhận GSP/ GCN-YDCT, vui lòng nhập "<b>Không có</b>" vào trường
                    <i class="bold">Số giấy chứng nhận GSP/ GCN-YDCT</i> và nhập vào ngày ra quyết định nghị quyết cấp giấy chứng nhận GSP/ GCN-YDCT
                vào trường <i class="bold">Ngày cấp GSP</i></span>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="moh.03.hoso.thongtinchung.mucdich"/></label>
                </div>
                <div class="col-md-10">
                    <textarea style="resize: vertical; resize: none; overflow-x: hidden;" class="form-control"
                              name="fiMucdichSd" data-bind="value: fiMucdichSd" maxlength="512" disabled></textarea>
                </div>
            </div>
        </div>
    </div>
</fieldset>



