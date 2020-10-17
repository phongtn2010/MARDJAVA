<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="moit.05.hoso.thongtinhanghoa" /></b><a style="margin-left: 10px" class="btn green bt-center" data-bind="click: addHangHoaOnClick" ><i class="fa fa-add fa-plus"></i></a></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.stt" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.loaiNguyenLieu" /><a class="nsw-require-field">*</a></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.tenNguyenlieu" /><a class="nsw-require-field">*</a></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.dangkyNamX1"/>
                            <a style="margin-right: 5px" data-bind="text : fiNamX1"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/>
                            <a class="nsw-require-field">*</a></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.soLuongCapnamX1"/>
                            <a style="margin-right: 5px" data-bind="text : fiNamX1"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/>
                            <a class="nsw-require-field">*</a></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.uocNKnamX1"/>
                            <a style="margin-right: 5px" data-bind="text : fiNamX1"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/>
                            <a class="nsw-require-field">*</a></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.dangKyNKnamX"/>
                            <a style="margin-right: 5px" data-bind="text : fiNamdkNk"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/>
                            <a class="nsw-require-field">*</a></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.chucnang"/></th>
                    </tr>
                </thead>                      
                <tbody data-bind="foreach: lstNguyenlieus">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td style="width: 220px">
                            <select class="form-control select2 fiLoaiNguyenlieu" data-bind="value: fiLoaiNguyenlieu,
                                attr: { id: 'fiLoaiNguyenlieu-' + fiStt() }, event:{change :  $parent.valueLoai.bind($parent)},
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name',                          
                                options : $parent.lstLoaiNguyenlieu"></select>
                            <span data-bind="attr: {'id': 'fiLoaiNguyenlieulb_' + fiStt()}" class="validationMessage" style="display: none;">Thông tin bắt buộc nhập</span>
                        </td>
                        <td>
                            <select class="form-control select2 fiMaNguyenlieu" data-bind="value: fiMaNguyenlieu,
                                attr: { id: 'fiMaNguyenlieu-' + fiStt() },event:{change :  $parent.valueLoai.bind($parent)},
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                selectedText2 : fiTenNguyenlieu,
                                options : $parent.lstTenNguyenlieu"></select> 
                            <span data-bind="attr: {'id': 'fiMaNguyenlieulb_' + fiStt()}" class="validationMessage" style="display: none;">Thông tin bắt buộc nhập</span>
                        </td>
                        <td>
                            <input class="form-control" style="text-align: right;" name="fiDangkyNhapkhauNamx1" data-bind="value : fiDangkyNhapkhauNamx1,event:{change :  $parent.valueLoai.bind($parent)}" minlength="3" min="0" maxlength="13"/>
                            <span data-bind="attr: {'id': 'fiDangkyNhapkhauNamx1lb_' + fiStt()}" class="validationMessage" style="display: none;">Thông tin bắt buộc nhập</span>
                        </td>
                        <td>
                            <input class="form-control" style="text-align: right;" name="fiSoluongCapX1" data-bind="value : fiSoluongCapX1,event:{change :  $parent.valueLoai.bind($parent)}" minlength="3" min="0" maxlength="13"/>
                            <span data-bind="attr: {'id': 'fiSoluongCapX1lb_' + fiStt()}" class="validationMessage" style="display: none;">Thông tin bắt buộc nhập</span>
                        </td>
                        <td>
                            <input class="form-control" style="text-align: right;" name="fiUocThuchienX1" data-bind="value : fiUocThuchienX1,event:{change :  $parent.valueLoai.bind($parent)}" minlength="3" min="0" maxlength="13"/>
                            <span data-bind="attr: {'id': 'fiUocThuchienX1lb_' + fiStt()}" class="validationMessage" style="display: none;">Thông tin bắt buộc nhập</span>
                        </td>
                        <td>
                            <input class="form-control" style="text-align: right;"  name="fiDangkyNhapkhauNamx" data-bind="value : fiDangkyNhapkhauNamx,event:{change :  $parent.valueLoai.bind($parent)}" minlength="3" min="0" maxlength="13" />
                            <span data-bind="attr: {'id': 'fiDangkyNhapkhauNamxlb_' + fiStt()}" class="validationMessage" style="display: none;">Thông tin bắt buộc nhập</span>
                        </td>

                        <td class="text-center">
                            <a class="btn red bt-center" data-bind="click: $parent.removeHangHoaOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
           <span class="validationMessage" style="display: none" id="lstNguyenlieus-lbl">* Chưa khai báo thông tin hàng hoá</span>
           <span class="validationMessage" style="display: none" id="lstNguyenlieus-lbl-1"></span><br>
            
            
        </div>
    </div>
</fieldset>