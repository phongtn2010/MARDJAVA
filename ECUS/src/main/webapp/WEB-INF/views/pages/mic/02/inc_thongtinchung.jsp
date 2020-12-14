<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend><b><spring:message code="mic.02.hoso.thongtinchung" /></b></legend>
    <form role="form" class="form-horizontal" name="CreateForm">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.mahoso" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoSo" readonly="readonly"/>

                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.trangthai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTrangThai" name="fiTenTrangThai" data-bind="value : fiTenTrangThai" type="text" readonly/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.ngaytao" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgayTao" name="fiNgayTao"  data-bind="datepicker : fiNgayTao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.noidenghicap" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="fiNoiCapGpMa" name="fiNoiCapGpMa" 
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiNoiCapGpTen
                            , value : fiNoiCapGpMa
                            , options : lstNoiCP
                            , optionsText : 'name'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.tendoanhnghiep" /></label>
                </div>

                <div class="col-md-4">
                    <input class="form-control" id="fiTtcTenToChuc" name="fiTtcTenToChuc" maxlength="255"  
                           type="text" data-bind="value : fiTtcTenToChuc" readonly="readonly"/>

                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.dienthoai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcDienThoai" name="fiTtcDienThoai" maxlength="255"  
                           type="text" data-bind="value : fiTtcDienThoai" readonly="readonly"/>
                </div>

            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.diachi" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcDiaChi" name="fiTtcDiaChi" data-bind="value : fiTtcDiaChi" type="text" readonly/>

                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.MST" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcMst" name="fiTtcMst" data-bind="value : fiTtcMst" type="text" readonly/>

                </div>


            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.sodondenghi" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoDonDeNghi" name="fiSoDonDeNghi" maxlength="255"  
                           type="text" data-bind="value : fiSoDonDeNghi" />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.email" /><a class="nsw-require-field">*</a></label>
                </div>  
                <div class="col-md-4">
                    <input class="form-control" type="email" id="fiTtcEmail" name="fiTtcEmail" data-bind="value : fiTtcEmail" maxlength="50" />
                </div>

            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.soCMND" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiCmnd" name="fiCmnd" data-bind="value : fiCmnd" type="text" maxlength="50"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.fax" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcFax" name="fiTtcFax" maxlength="50"  
                           type="text" data-bind="value : fiTtcFax" />
                </div>

            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.ngaycap" /></label>
                </div>
                <div class="col-md-4">
                    <div class="input-group">
                        <input class="form-control date-picker" id="ngayCap" type="text" maxlength="50" data-bind="datepicker : fiNgayCapCmnd" placeholder="dd/mm/yyyy"  data-date-format="dd/mm/yyyy" readonly style="background-color: #fff;"/>
                        <a class="input-group-addon" style="background: #fff !important;" href="javascript:void(0)" data-bind="event : {click : clearDate}">
                            <i class="fa fa-close"></i>
                        </a>

                    </div>
                    <span class="validationMessage" id="valid-ngayCap" style="display: none">Thông tin bắt buộc nhập</span>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.noicap" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoiCapCmnd" name="fiNoiCapCmnd" data-bind="value : fiNoiCapCmnd" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>
                        <spring:message code="mic.02.hoso.thongtinchung.TTLienhe" />

                    </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control " id="" type="text" maxlength="255" data-bind="value: fiNguoiLienHe "/>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <label>
                        <spring:message code="mic.02.hoso.thongtinchung.diachidatmay" />
                        <a id="sogiaypheplabel" class="nsw-require-field">*</a>
                    </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control " id="" type="text" maxlength="500" data-bind="value: fiDcDatMayLanDau"/>
                </div>
            </div>  
        </div>

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.thongtinchung.mucdichNK" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="fiMucDichNk" name="fiMucDichNk" 
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'name'
                            , selectedText2 : fiMucDichNk
                            , value : fiMucDichNk
                            , options : lstMucDich
                            , optionsText : 'name'
                            ,event: {change: mucdichAction}"></select>
                    <span id="" style="display: none" class="validationMessage">Thông tin bắt buộc nhập</span>
                </div>
                <div class="col-md-2 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                    <label>
                        <spring:message code="mic.02.hoso.thongtinchung.mucdichNKkhac" />
                        <a class="nsw-require-field" id="lbl-pho-valid">*</a>
                    </label>
                </div>
                <div class="col-md-4 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                    <input class="form-control" id="fiMucDichSuDungKhac" name="fiMucDichSuDungKhac"  type="text" data-bind="value: fiMucDichNkKhac,event: {change: validateMD}" maxlength="500"/>
                    <span class="validationMessage" id="fiMucDichSuDungKhac-lbl" style="display: none">Thông tin bắt buộc nhập</span>
                </div>

            </div>

        </div> 
    </form>
</fieldset>
