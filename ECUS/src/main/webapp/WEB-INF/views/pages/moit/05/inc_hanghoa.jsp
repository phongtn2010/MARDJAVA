<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="moit.05.hoso.thongtinhanghoa" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.stt" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.loaiNguyenLieu" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.tenNguyenlieu" /></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.dangkyNamX1"/><a style="margin-right: 5px" data-bind="text : fiNamX1"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.soLuongCapnamX1"/><a style="margin-right: 5px" data-bind="text : fiNamX1"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.uocNKnamX1"/><a style="margin-right: 5px" data-bind="text : fiNamX1"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.dangKyNKnamX"/><a style="margin-right: 5px" data-bind="text : fiNamdkNk"></a><spring:message code="moit.05.hoso.thongtinhanghoa.dvtinh"/></th>
                        <th class="text-center"><spring:message code="moit.05.hoso.thongtinhanghoa.chucnang"/></th>
                    </tr>
                </thead>                      
                <tbody data-bind="foreach: lstNguyenlieus">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td style="width: 220px">
                            <select class="form-control select2 fiLoaiNguyenlieu" data-bind="value: fiLoaiNguyenlieu,
                                attr: { id: 'fiLoaiNguyenlieu-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name',                          
                                options : $parent.lstLoaiNguyenlieu"></select>
                        </td>
                        <td>
                            <select class="form-control select2 fiMaNguyenlieu" data-bind="value: fiMaNguyenlieu,
                                attr: { id: 'fiMaNguyenlieu-' + fiStt() },
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                selectedText2 : fiTenNguyenlieu,
                                options : $parent.lstTenNguyenlieu"></select>                       
                        </td>
                        <td>
                            <input class="form-control" type="number" name="fiDangkyNhapkhauNamx1" data-bind="value : fiDangkyNhapkhauNamx1" minlength="3" maxlength="12"/>
                        </td>
                        <td>
                            <input class="form-control" type="number" name="fiSoluongCapX1" data-bind="value : fiSoluongCapX1" minlength="3" maxlength="12"/>
                        </td>
                        <td>
                            <input class="form-control" type="number" name="fiUocThuchienX1" data-bind="value : fiUocThuchienX1" minlength="3" maxlength="12"/>
                        </td>
                        <td>
                            <input class="form-control" type="number" name="fiDangkyNhapkhauNamx" data-bind="value : fiDangkyNhapkhauNamx" minlength="3" maxlength="12"/>
                        </td>

                        <td class="text-center">
                            <a class="btn red bt-center" data-bind="click: $parent.removeHangHoaOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHHMessage" style="color:red;"> </span>
            <br />
            <a class="btn green bt-center" data-bind="click: addHangHoaOnClick"><i class="fa fa-add fa-lg"></i> Thêm Hàng hoá</a>
        </div>
    </div>
</fieldset>