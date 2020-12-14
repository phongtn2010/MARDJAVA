<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-right">
            <label>Loại thanh toán<a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <select class="form-control select2 fiLoaiPhi" id="fiLoaiPhi" name="fiLoaiPhi"  
                        data-bind="value: fiLoaiPhi, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstLoaiPhi, 
                                optionsText : 'name'"></select>
        </div> 
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.hinhthuc" /><a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <select class="form-control select2 fiLoaiPhi" id="fiLoaiTtoan" name="fiLoaiTtoan"  
                        data-bind="value: fiLoaiTtoan, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstLoaiThanhToan, 
                                optionsText : 'name'"></select>
        </div>        
    </div>  
</div>
<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.nguoinop" /><a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" id="fiNguoiNop" name="fiNguoiNop" data-bind="value : fiNguoiNop" maxlength="250" />
        </div> 
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.dienthoai" /><a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" id="fiSdt" name="fiSdt" data-bind="value : fiSdt" maxlength="50" />
        </div> 
    </div>
    
</div>
<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.ngaynop" /><a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control form-control-inline date-picker" id="fiNgayNop" name="fiNgayNop" type="text" data-bind="datepicker : fiNgayNop"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            
        </div> 
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.sohoadon" /><a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" id="fiSoHoadon" name="fiSoHoadon" data-bind="value : fiSoHoadon" maxlength="50" />
        </div> 
    </div>  
</div>
<div class="form-group">
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.tongtien" /><a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" id="fiTongTien" name="fiTongTien" data-bind="value : fiTongTien" maxlength="10" />
        </div> 
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.ghichu" /><a data-bind="visible: isRequired" class="nsw-require-field">*</a></label>
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" id="fiGhiChu" name="fiGhiChu" data-bind="value : fiGhiChu" maxlength="250" />
        </div> 
    </div>
    
</div>

<div class="form-group">       
    <div class="col-md-12">
        <div class="col-md-2 nsw-text-right">
            <label><spring:message code="moh.01.xacnhannopphi.chungtu" /></label>
        </div>
        <div class="col-md-4">
            <a class="btn btn-info btn-xs" data-bind="click : doUpload, visible: showAttachBtn">Đính kèm</a>
            <a target="_blank" href="javascript:void(0);" data-bind="visible: showDownload, attr: { href: fiDuongDan}, text: fiTenTep"><i class="fa fa-download fa-lg" src="" alt=""></i></a>
            <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: showDownload, click: removeAttach" src="" alt=""></i></a>
        </div> 
    </div>
</div>

<div class="form-group">       
    <div class="col-md-12">
        <p class="nsw-text-center">
            <a data-bind="click : btnSavePaymentClick" href="javascript:void(0);" class="btn blue" id="btnSavePayment"><i class="fa fa-save" ></i> Cập nhật phí</a>
        </p>
    </div>
</div>

<div class="form-group">
    <div class="col-md-12">

        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center" style="width: 50px"><spring:message code="moh.01.xacnhannopphi.stt" /></th>
                    <th class="text-center">Loại thanh toán</th>
                    <th class="text-center">Hình thức thanh toán</th>
                    <th class="text-center"><spring:message code="moh.01.xacnhannopphi.nguoinop" /></th>
                    <th class="text-center" style="width: 100px"><spring:message code="moh.01.xacnhannopphi.sdt" /></th>
                    <th class="text-center" style="width: 200px"><spring:message code="moh.01.xacnhannopphi.ngaynop" /></th>
                    <th class="text-center"><spring:message code="moh.01.xacnhannopphi.sohoadon" /></th>
                    <th class="text-center"><spring:message code="moh.01.xacnhannopphi.tongtien" /></th>
                    <th class="text-center" style="width: 80px"><spring:message code="moh.01.xacnhannopphi.taitep" /></th>
                    <th class="text-center" style="width: 80px"><spring:message code="moh.01.xacnhannopphi.xoa" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: lstThanhToans">
                <tr>
                    <td data-bind="text : fiStt"></td>  
                    <td data-bind="text : fiLoaiPhiText"></td>  
                    <td data-bind="text : fiLoaiTtoanText"></td>  
                    <td data-bind="text : fiNguoiNop"></td>  
                    <td data-bind="text : fiSdt"></td>  
                    <td data-bind="text : fiNgayNopVn"></td>  
                    <td data-bind="text : fiSoHoadon"></td>  
                    <td data-bind="text : fiTongTien"></td>  
                    <td class="text-center">
                        <a title="Tải tệp" target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: fileUrl}"><i class="fa fa-download fa-lg"></i></a>
                    </td>  
                    <td class="text-center">
                        <a data-bind="click: $parent.onDeletePayment.bind($parent)"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>


