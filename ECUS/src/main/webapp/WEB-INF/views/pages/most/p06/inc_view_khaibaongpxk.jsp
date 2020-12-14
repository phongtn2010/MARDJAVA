<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="most.06.hoso.phieuphaibaopsk" /> </b></legend> 

    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstTbdhsPhieuKbNguonPxk06">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.stt" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.tendongvi" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.nuocsanxuat" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.hoatdo" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.donvitinh" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.ngay" /></th>
                        <th class="text-center"><spring:message code="most.06.hoso.phieuphaibaopsk.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstTbdhsPhieuKbNguonPxk06">
                    <tr>
                        <td data-bind="text : $index() + 1"></td>  
                        <td style="width: 220px" data-bind="text : fiMaDongViPhongXa"></td>
                        <td style="width: 220px" data-bind="text : fiHangSanXuat"></td>
                        <td style="width: 220px ;text-align:right" data-bind="text : fiHoatDo"></td>
                        <td style="width: 220px" data-bind="text : fiTenHoatDoDonVi"></td>
                        <td style="width: 220px ;text-align:center" data-bind="date : fiNgayXacDinhHoatDo"></td>
                        <td style="width: 220px" class="text-center">                            
                            <a  data-bind="click: $parent.addpxk.bind($parent)"><i style="font-size: 30px" class="fa fa-eye"></i></a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <!--<span data-bind="text : errorHHMessage" style="color:red;"> </span>-->
            <br />

        </div>
    </div>
</fieldset>
<template id="khaibaopxk-template">
    <div class="row" id="khaibaopxk-vm" style="max-height: 70vh !important; overflow: auto;">
        <div class="col-md-12">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.tendongvi" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <select disabled class="form-control select2" id="fiTenDongViPhongXa" sname="fiTenDongViPhongXa" 
                                    data-bind="optionsCaption: 'Chọn...', optionsValue : 'id',selectedText2 : fiTenDongViPhongXa, value : fiMaDongViPhongXa
                                    , options : lstDongViPX, optionsText : 'name'"></select>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mahieu" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiMaHieu" name="fiMaHieu" maxlength="255"  
                                   type="text" data-bind="value : fiMaHieu" />
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.soseri" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiSoSeri" name="fiSoSeri" maxlength="255"  
                                   type="text" data-bind="value : fiSoSeri" />
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.nuocsanxuat" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiHangSanXuat" name="fiHangSanXuat" maxlength="255"  
                                   type="text" data-bind="value : fiHangSanXuat" />
                        </div>                                          

                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.hoatdodv" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-2">                                        
                            <input disabled class="form-control" id="fiHoatDo" name="fiHoatDoDonVi" maxlength="255"  
                                   type="text" data-bind="value :  fiHoatDo" />
                        </div>                                          
                        <div class="col-md-2">                                        
                            <select disabled class="form-control select2" id="fiMaDongViPhongXa" name="fiMaDongViPhongXa" 
                                    data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiHoatDoDonVi
                                    , options : lstDongVi, optionsText : 'name'"></select>
                        </div>                                          
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.ngay" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgayXacDinhHoatDo" 
                                   name="fiNgayXacDinhHoatDo" data-bind="datepicker : fiNgayXacDinhHoatDo" type="text" data-date-format="dd/mm/yyyy" />
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mucdich" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <select class="form-control select2" id="fiMaMucDichSuDung" name="fiMaMucDichSuDung"  multiple disabled
                                    data-bind="optionsValue : 'id'
                                    , selectedOptions : lstMucdichsudung
                                    , options : lstMucDichKin, optionsText : 'name'"></select>

                        </div>

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.ungdungkhac" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiSoSeri" name="fiSoSeri" maxlength="255"  
                                   type="text" data-bind="value : fiMucDichSuDungKhac" />              
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <label style=" margin-left: 50px; color: red;font-size: 13px"><i>(Lưu ý: Trường Mục đích sử dụng cho phép chọn nhiều. Trường Ứng dụng khác chỉ hiển thị khi chọn loại Mục đích sử dụng: Các ứng dựng khác (ghi rõ))</i></label>
                </div>
                <div class="form-group" style="margin-top: 15px;">
                    <div class="col-md-6 nsw-text-right">
                        <label><spring:message code="most.06.hoso.phieuphaibaopsk.nguonCamKet" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-4">
                        <label class="col-md-4"> <input disabled class="fiCamKetTraNguon" name="fiCamKetTraNguon"  id="rdKhong" type="radio">không</label> 
                        <label class="col-md-4"> <input disabled class="fiCamKetTraNguon" name="fiCamKetTraNguon" id="rdCo" type="radio">có</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.xuatxu" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <select disabled id="fixuatxu" name="fixuatxu" class="form-control select2" data-bind="value: fiXuatXuNguon">
                                <option value="1">Nhập khẩu</option>
                                <option value="2">Nhận chuyển tổ chức/cá nhân khác</option>
                            </select>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.sigiayphep" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiSoSeri" name="fiSoSeri" maxlength="255"  
                                   type="text" data-bind="value : fiXuatXuNguonSgp" />

                        </div>

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.ngaycap" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiXuatXuNguonNgaycap" 
                                   name="fiXuatXuNguonNgaycap" data-bind="datepicker : fiXuatXuNguonNgaycap" type="text" data-date-format="dd/mm/yyyy" />
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <label style=" margin-left: 10px"><b>Thiết bị đi kèm sử dụng nguồn nói trên</b></label>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mahieu" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiTbMaHieu" name="fiTbMaHieu" maxlength="255"  
                                   type="text" data-bind="value : fiTbMaHieu" />
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.soseri" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiTbSoSeri" name="fiTbSoSeri" maxlength="255"  
                                   type="text" data-bind="value : fiTbSoSeri" />
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.nuocsanxuat" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiTbHangNuocSanXuat" name="fiTbHangNuocSanXuat" maxlength="255"  
                                   type="text" data-bind="value : fiTbHangNuocSanXuat" />
                        </div>                                          
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.namsanxuat" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input disabled class="form-control" id="fiTbNamSanXuat" name="fiTbNamSanXuat" maxlength="4"  max="4"
                                   type="number" data-bind="value : fiTbNamSanXuat" />
                        </div>                                          
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-3 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.noidat" /></label>
                        </div>
                        <div class="col-md-4">
                            <label class="col-md-4"><input disabled class="fiTbDiDongCoDinh" name="fiTbDiDongCoDinh" id="rdDiDong" type="radio" >Di động</label> 
                            <label class="col-md-4"><input disabled class="fiTbDiDongCoDinh" name="fiTbDiDongCoDinh" id="rdCoDinh" type="radio">Cố định</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-3 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.noidat" /></label>
                        </div>
                        <div class="col-md-9">                                        
                            <input disabled class="form-control" id="fiTbNoiDat" name="fiTbNoiDat" maxlength="255"  
                                   type="text" data-bind="value : fiTbNoiDat" />

                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-3 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.khoiluong" /></label>
                        </div>
                        <div class="col-md-9">                                        
                            <input disabled class="form-control" onchange="" id="fiTbKhoiLuongUrani" name="fiTbKhoiLuongUrani" maxlength="255"  
                                   type="text" data-bind="value : fiTbKhoiLuongUrani" />

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div> 
</template> 