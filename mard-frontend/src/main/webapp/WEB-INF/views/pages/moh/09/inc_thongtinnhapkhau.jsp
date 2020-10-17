<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend><b><spring:message code="moh.09.thongtinnhapkhau" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.thoigiantungay" /><a class="nsw-require-field" data-bind="visible: isKtChat"> (*)</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control form-control-inline date-picker" name="fiNgayNkTu" type="text" data-bind="datepicker : fiNgayNkTu"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.thoigiandenngay" /><a class="nsw-require-field" data-bind="visible: isKtChat"> (*)</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" name="fiNgayNkDen" type="text" data-bind="datepicker : fiNgayNkDen"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div> 
        </div>  
    </div>            
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.cuakhaudi" /><a class="nsw-require-field"> (*)</a></label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiMaCkDi" id="fiMaCkDi" name="fiMaCkDi"  
                        data-bind="value: fiMaCkDi, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstCuaKhau, 
                                optionsText : 'name',
                                event: {change: onFiMaCkDiChange}"></select>
                <input type="hidden" name="fiTenCkDi" data-bind="value : fiTenCkDi"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.cuakhauden" /><a class="nsw-require-field"> (*)</a> </label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2 fiMaCkDen" id="fiMaCkDen" name="fiMaCkDen"  
                        data-bind="value: fiMaCkDen, 
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                options : lstCuaKhau, 
                                optionsText : 'name',
                                event: {change: onFiMaCkDenChange}"></select>
                <input type="hidden" name="fiTenCkDen" data-bind="value : fiTenCkDen"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.kiemtratungay" /><a class="nsw-require-field" data-bind="visible: isKtChat"> (*)</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control form-control-inline date-picker" name="fiNgayKtTu" type="text" data-bind="datepicker : fiNgayKtTu"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.kiemtradenngay" /><a class="nsw-require-field" data-bind="visible: isKtChat"> (*)</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" name="fiNgayKtDen" type="text" data-bind="datepicker : fiNgayKtDen"  data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.diadiemkiemtra" /><a class="nsw-require-field" data-bind="visible: isKtChat"> (*)</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" name="fiDiadiemKt" data-bind="value : fiDiadiemKt" maxlength="500" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.sotokhai" /> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" name="fiSoTkhq" data-bind="value : fiSoTkhq" maxlength="255" />
                <br /><a style="color: red;">(Để có số tờ khai, DN thực hiện khai báo nghiệp vụ IDA trên hệ thống Hải Quan)</a>
            </div>
        </div>  
    </div>
    
</fieldset>
<fieldset>
    <legend><b><spring:message code="moh.09.chitietlohang" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <a class="btn green bt-center" data-bind="click: onKhaiBaoLoHang"><i class="fa fa-edit fa-lg"></i> Thêm mặt hàng</a>
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.stt" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.tenmathang" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.socongbo" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.nhomsanpham" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.tennhasanxuat" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.phuongthuckiemtra" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.sovanban" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.hanhdong" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHangHoas">
                    <tr>
                        <td data-bind="text : fiStt"></td>  
                        <td>
                            <a class="green" data-bind="click: $parent.onXemChiTietHang.bind($parent), text : fiTenHh"><i class="fa fa-search"></i></a>
                        </td>  
                        <td data-bind="text : fiSoCongbo"></td>  
                        <td data-bind="text : fiTenNhomHh"></td>  
                        <td data-bind="text : fiTenNsx"></td>  
                        <td data-bind="text : fiTenPtkt"></td>  
                        <td data-bind="text : fiSoVbxnPtkt"></td>  
                        <td style="text-align: center;">
                            <a class="green" data-bind="click: $parent.onEditHangHoa.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                            <br />
                            <a class="red" data-bind="click: $parent.onXoaChiTietHang.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table> 
            <span data-bind="text : hangHoaErrorMsg" style="color:red;"> </span>
            <br />         
        </div>
    </div>
</fieldset>
<fieldset>
    <legend><b><spring:message code="moh.09.thongtinkydon" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinkydon.nguoiky" /><a class="nsw-require-field"> (*)</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" name="fiNguoiKy" data-bind="value : fiNguoiKy" maxlength="100" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinkydon.ngayky" /><a class="nsw-require-field"> (*)</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline date-picker" name="fiNgayKy" type="text" data-bind="datepicker : fiNgayKy" data-date-format="dd/mm/yyyy" maxlength="10"/>
            </div>
        </div>  
    </div>    
</fieldset>
                    
<template id="chitiethanghoa-template">
    <div class="row">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="chitiethanghoa-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.tenmathang" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="fiTenHh" data-bind="value : fiTenHh" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.socongbo" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="fiSoCongbo" data-bind="value : fiSoCongbo" maxlength="255" />
                        </div> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.nhomsanpham" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiMaNhomHh" id="fiMaNhomHh" name="fiMaNhomHh"  
                                    data-bind="value: fiMaNhomHh, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstNhomSanPham, 
                                            optionsText : 'name',
                                            event: {change: onFiMaNhomHhChange}"></select>
                            <input type="hidden" id="fiTenNhomHh" name="fiTenNhomHh" data-bind="value : fiTenNhomHh"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label>Thương nhân chịu trách nhiệm về chất lượng hàng hoá<a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiIdNguoiTn" id="fiIdNguoiTn" name="fiIdNguoiTn"  
                                    data-bind="value: fiIdNguoiTn, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstNguoiChiuTrachNhiems, 
                                            optionsText : 'name',
                                            event: {change: onFiIdNguoiTnChange}"></select>
                            <input type="hidden" name="fiTenNgTn" data-bind="value : fiTenNgTn"/>
                        </div>
                    </div>   
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label>Xuất xứ<a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiIdNguoiTn" id="fiMaQgXuatxu" name="fiMaQgXuatxu"  
                                    data-bind="value: fiMaQgXuatxu, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstQuocGia, 
                                            optionsText : 'name',
                                            event: {change: onFiMaQgXuatxuChange}"></select>
                            <input type="hidden" name="fiTenQgXuatxu" data-bind="value : fiTenQgXuatxu"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.tennhasanxuat" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiTenNsx" name="fiTenNsx" data-bind="value : fiTenNsx" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.diachi" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiDiachiNsx" name="fiDiachiNsx" data-bind="value : fiDiachiNsx" maxlength="255" />
                        </div> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.phuongthuckiemtra" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" readonly="true" data-bind="value: tenPtKt" />
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.sovanban" /> <a class="nsw-require-field" data-bind="visible: isKtChat"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiSoVbxnPtkt" name="fiSoVbxnPtkt" data-bind="value : fiSoVbxnPtkt" maxlength="255" />
                        </div> 
                    </div>
                </div>
                <div class="form-group">       
                    <div class="col-md-12">
                        <div class="col-md-6 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.tepdinhkem" /></label>
                        </div>
                        <div class="col-md-6">
                            <a class="btn btn-info btn-xs" data-bind="click : doUpload, visible: canUpload">Đính kèm</a>
                            <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: fiDuongDan}, text: fiTenTep"><i class="fa fa-download fa-lg"></i></a>
                            <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: canDownload, click: doDelete"></i></a>
                        </div> 
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>
                        
<template id="thuongnhantn-template">
    <div class="row">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="chitietthuongnhan-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.thuongnhanchatluong.ten" /><a class="nsw-require-field"> (*)</a></label>
                        </div>  
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="fiTenNgTn" data-bind="value : fiTenNgTn" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.thuongnhanchatluong.sodienthoai" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="fiSdtNgTn" data-bind="value : fiSdtNgTn" maxlength="50" />
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.thuongnhanchatluong.diachi" /><a class="nsw-require-field"> (*)</a></label>
                        </div>
                        <div class="col-md-10">                
                            <input class="form-control" type="text" name="fiDiachiNgTn" data-bind="value : fiDiachiNgTn" maxlength="255" />
                        </div> 

                    </div>  
                </div>            
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.thuongnhanchatluong.fax" /></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="fiFaxNgTn" data-bind="value : fiFaxNgTn" maxlength="50" />
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.thuongnhanchatluong.email" /> </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" name="fiEmailNgTn" data-bind="value : fiEmailNgTn" maxlength="50" />
                        </div>
                    </div>  
                </div>
            </form>
        </div>
    </div>
</template>                       
