<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="most.06.hoso.phieuphaibaopskqxd" /> </b><a class="btn green bt-center" data-bind="click: addPxkQsdClick"><i class="fa fa-add fa-lg"></i> Thêm</a></legend> 
    
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstTbdhsPhieuNguonPxkQsd06">
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
                <tbody data-bind="foreach: lstTbdhsPhieuNguonPxkQsd06">
                    <tr>
                        <td style="width: 30px" data-bind="text: $index() + 1"></td>  
                        <td style="width: 220px" data-bind="text : fiTenDongViPhongXa"></td>
                        <td style="width: 220px" data-bind="text : fiHangSanXuat"></td>
                        <td style="width: 220px;text-align:right" data-bind="text : fiHoatDo"></td>
                        <td style="width: 220px" data-bind="text : fiTenHoatDoDonVi"></td>
                        <td style="width: 220px ;text-align:center" data-bind="date : fiNgayXacDinhHoatDo"></td>
                        <td style="width: 220px" class="text-center">                            
                            <a class="btn green bt-center" data-bind="click: $parent.editPxkQsdClick.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                            <a class="btn red bt-center" data-bind="click: $parent.removePxkQsd.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorlistpxkqsdMessage" style="color:red;"> </span>
            <br />
            
        </div>
    </div>
</fieldset>
<template id="khaibaopxkqsd-template">
    <div class="row" id="khaibaopxkqsd-vm" style="max-height: 70vh !important ; overflow: auto;">
        <div class="col-md-12">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.tendongvi" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                           <select class="form-control select2" id="fiMaDongViPhongXa" name="fiMaDongViPhongXa" 
                                    data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiMaDongViPhongXa
                                    ,selectedText2 : fiTenDongViPhongXa, options : lstDongViPX, optionsText : 'name'"></select>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mahieu" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiMaHieu" name="fiMaHieu" maxlength="255"  
                                   type="text" data-bind="value : fiMaHieu" />
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.soseri" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiSoSeri" name="fiSoSeri" maxlength="255"  
                                   type="text" data-bind="value : fiSoSeri" />
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.nuocsanxuat" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiHangSanXuat" name="fiHangSanXuat" maxlength="255"  
                                   type="text" data-bind="value : fiHangSanXuat" />
                        </div>                                          
                        
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label>
                                <spring:message code="most.06.hoso.phieuphaibaopsk.hoatdodv" />
                                <a class="nsw-require-field">*</a>
                            </label>
                        </div>
                        <div class="col-md-2">                                        
                            <input class="form-control" id="fiHoatDo" name="fiHoatDo" maxlength="255"  
                                   type="text" data-bind="value : fiHoatDo" />
                        </div>                                          
                        <div class="col-md-2">                                        
                            <select class="form-control select2" id="fiHoatDoDonVi" name="fiHoatDo" 
                                    data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiHoatDoDonVi
                                    , options : lstDongVi, optionsText : 'name'"></select>
                        </div>                                          
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.ngay" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgayXacDinhHoatDo" readonly style="background: #fff" name="fiNgayXacDinhHoatDo" data-bind="datepicker : fiNgayXacDinhHoatDo , event: {change: ngayXacDinhHDQSDValid}" type="text" data-date-format="dd/mm/yyyy" />
                            <span class="validationMessage" id="valid-NgayXacDinhHDQSD" style="display: none;">Thông tin bắt buộc nhập</span>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mucdich" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">                                        
                            <select class="form-control select2" id="fiMaMucDichSuDungqsd" name="fiMaMucDichSuDung" multiple
                                    data-bind=" optionsValue : 'id'
                                    , selectedOptions : lstMucdichsudungqsd
                                    , options : lstMucDichKinQsd , optionsText : 'name'
                                    ,event: {change: mucdichqsdAction}"></select>
                            <span id="lstMDsudungQsd" style="display: none" class="validationMessage">Thông tin bắt buộc nhập</span>
                        </div>

                        <div class="col-md-2 nsw-text-right fiMucDichSuDungKhac" style="display: none">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.ungdungkhac" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4 fiMucDichSuDungKhac" style="display: none">                                        
                            <input class="form-control" id="fiSoSeri" name="fiSoSeri" maxlength="255"  
                                   type="text" data-bind="value : fiMucDichSuDungKhac" />              
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <label style=" margin-left: 50px; color: red;font-size: 13px"><i>(Lưu ý: Trường Mục đích sử dụng cho phép chọn nhiều. Trường Ứng dụng khác chỉ hiển thị khi chọn loại Mục đích sử dụng: Các ứng dựng khác (ghi rõ))</i></label>
                </div>
                <div class="form-group">
                    
                </div>
                <div class="form-group">
                    <label style=" margin-left: 10px"><b>Thiết bị/Container đi kèm sử dụng nguồn nói trên</b></label>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.mahieu" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiTbMaHieu" name="fiTbMaHieu" maxlength="255"  
                                   type="text" data-bind="value : fiTbMaHieu" />
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.soseri" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiTbSoSeri" name="fiTbSoSeri" maxlength="255"  
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
                            <input class="form-control" id="fiHangSanXuat" name="fiHangSanXuat" maxlength="255"  
                                   type="text" data-bind="value : fiTbHangSanXuat" />
                        </div>                                          
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopsk.namsanxuat" /></label>
                        </div>
                        <div class="col-md-4">                                        
                            <input class="form-control" id="fiTbNamSanXuat" name="fiTbNamSanXuat"  max="9999" min="1" oninput="validity.valid||(value='');"
                                   type="number" data-bind="value: fiTbNamSanXuat" />
                        </div>                                          
                    </div>  
                </div><!--
-->                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopskqxd.mota" /></label>
                        </div>
                        <div class="col-md-10">                                        
                            <input class="form-control" id="fiTbMoTaHienTrang" name="fiTbMoTaHienTrang" maxlength="255"  
                                   type="text" data-bind="value : fiTbMoTaHienTrang" />
                        </div>                                          
                    </div>  
                </div>
                <div class="form-group">
                   <label style=" margin-left: 10px"><b>Xử lý trước khi lưu giữ</b></label>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopskqxd.bienphap" /></label>
                        </div>
                        <div class="col-md-10">                                        
                             <input class="form-control" id="fiTbNoiDat" name="fiTbNoiDat" maxlength="255"  
                                   type="text" data-bind="value : fiXlBienPhapXuLy" />

                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">                       
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="most.06.hoso.phieuphaibaopskqxd.diadiem" /></label>
                        </div>
                        <div class="col-md-10">                                        
                            <input class="form-control" onchange="" id="fiTbKhoiLuongUrani" name="fiTbKhoiLuongUrani" maxlength="255"  
                                   type="text" data-bind="value : fiXlDiaDiemLuuGiu" />

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div> 
</template> 