<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="bca.02.hoso.thongtinhanghoa" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinhanghoa.tenhh" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiTenHanghoa" name="fiTenHanghoa" maxlength="255"  
                       type="text" data-bind="value : fiTenHanghoa"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinhanghoa.vctu" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiHanhtrinhvcTu" name="fiHanhtrinhvcTu" maxlength="255"  
                       type="text" data-bind="value : fiHanhtrinhvcTu"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinhanghoa.qua" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiHanhtrinhvcQua" name="fiHanhtrinhvcQua" maxlength="255"  
                       type="text" data-bind="value : fiHanhtrinhvcQua"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinhanghoa.den" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control" id="fiHanhtrinhvcDen" name="fiHanhtrinhvcDen" maxlength="255"  
                       type="text" data-bind="value : fiHanhtrinhvcDen"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinhanghoa.thoigianvctungay" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiThoigianvcTu" name="fiThoigianvcTu"  data-bind="datepicker : fiThoigianvcTu" type="text" data-date-format="dd/mm/yyyy" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.hoso.thongtinhanghoa.denngay" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input disabled class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiThoigianvcDen" name="fiThoigianvcDen"  data-bind="datepicker : fiThoigianvcDen" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div>
    </div>

    <b><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach"/></b>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.stt" /></th>
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.loai" /></th>
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.hoten" /></th>
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.so" /></th>
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.bks" /></th>
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.dvtinh" /></th>
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.khoiluongvc" /></th>
                        <th class="text-center"><spring:message code="bca.02.hoso.thongtinhanghoa.danhsach.chichu" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstNguoiDieukhien">
                    <tr>
                        <td data-bind="text : STT">
                        </td>  
                        <td style="width: 220px">
                            <select disabled class="form-control select2 fiLoai" data-bind="value: fiLoai,
                                 optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstLoainguoi"></select>
                        </td>
                        <td>
                            <input disabled class="form-control" name="fiTenNguoidk" data-bind="value : fiTenNguoidk" maxlength="2000">
                        </td>
                        <td>
                            <input disabled class="form-control" name="fiSocmndNguoidk" data-bind="value : fiSocmndNguoidk" maxlength="2000">
                        </td>
                        <td>
                            <input disabled class="form-control" name="fiBksPhuongtien" data-bind="value : fiBksPhuongtien" maxlength="2000">
                        </td>
                        <td>
                            <select disabled class="form-control select2 fiTenDv" data-bind="value: fiTenDv,
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id', 
                                optionsText : 'name', 
                                options : $parent.lstDonvi"></select>
                        </td>
                        <td>
                            <input disabled class="form-control" name="fiKhoiluongVc" data-bind="value : fiKhoiluongVc" maxlength="2000">
                        </td>
                        <td>
                            <input disabled class="form-control" name="fiGhichu" data-bind="value : fiGhichu" maxlength="2000">
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHHMessage" style="color:red;"> </span>
            <br />
        </div>
    </div>
    <span data-bind="text : $data.errorNguoiDkMessage();" style="color:red;"> </span>
</fieldset>