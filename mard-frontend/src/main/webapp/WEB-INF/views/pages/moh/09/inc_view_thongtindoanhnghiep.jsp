<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.09.thongtindon.coquankiemtra" /><a class="nsw-require-field">*</a> </label>
        </div>
        <div class="col-md-10">
            <select class="form-control select2 fiMaTckt" disabled id="fiMaTckt" name="fiMaTckt"  
                        data-bind="value: fiMaTckt, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstCoQuanKiemTra, 
                                optionsText : 'name',
                                event: {change: onFiMaDvNhanChange}"></select>
            <input type="hidden" id="fiTenTckt" name="fiTenTckt" data-bind="value : fiTenTckt"/>
        </div> 
    </div>  
</div>
            
<fieldset>
    <legend><b><spring:message code="moh.09.chuhang" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.tenchuhang" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-10">
                <label><b data-bind="text: fiTenCh"></b></label>
            </div>            
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.diachi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <label><b data-bind="text: fiDiachiCh"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.sodienthoai" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly name="fiSdtCh" data-bind="value : fiSdtCh" maxlength="255" />
            </div> 
        </div>  
    </div>             
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.fax" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly name="fiFaxCh" data-bind="value : fiFaxCh" maxlength="255" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.email" /> <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly name="fiEmailCh" data-bind="value : fiEmailCh" maxlength="255" />
            </div>
        </div>  
    </div>  
</fieldset>
            
<fieldset>
    <legend><b><spring:message code="moh.09.thuongnhanchatluong" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.stt" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.ten" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.diachi" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.sodienthoai" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.fax" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.email" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstNguoiChiuTrachNhiems">
                    <tr>
                        <td data-bind="text : fiStt"></td>  
                        <td>
                            <a class="green" data-bind="click: $parent.onXemChiTietThuongNhan.bind($parent), text : fiTenNgTn"><i class="fa fa-search"></i></a>
                        </td>  
                        <td data-bind="text : fiDiachiNgTn"></td>  
                        <td data-bind="text : fiSdtNgTn"></td>  
                        <td data-bind="text : fiFaxNgTn"></td>  
                        <td data-bind="text : fiEmailNgTn"></td>  
                    </tr>
                </tbody>
            </table> 
            <span data-bind="text : thuongNhanTnErrorMsg" style="color:red;"> </span>
            <br />         
        </div>
    </div>  
</fieldset>
            
<fieldset>
    <legend><b><spring:message code="moh.09.thuongnhanxuatkhau" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.ten" /><a class="nsw-require-field">*</a></label>
            </div>  
            <div class="col-md-4">
                <input class="form-control" type="text" readonly name="fiTenNgXk" data-bind="value : fiTenNgXk" maxlength="255" />
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.sodienthoai" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly name="fiSdtNgXk" data-bind="value : fiSdtNgXk" maxlength="255" />
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.diachi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">                
                <input class="form-control" type="text" readonly name="fiDiachiNgXk" data-bind="value : fiDiachiNgXk" maxlength="255" />
            </div> 
        </div>  
    </div>            
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.fax" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly name="fiFaxNgXk" data-bind="value : fiFaxNgXk" maxlength="255" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.email" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly name="fiEmailNgXk" data-bind="value : fiEmailNgXk" maxlength="255" />
            </div>
        </div>  
    </div>  
</fieldset>
  