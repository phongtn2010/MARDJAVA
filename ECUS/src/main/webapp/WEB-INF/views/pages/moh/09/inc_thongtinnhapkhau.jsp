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
                <input class="form-control" type="text" readonly="true" name="fiTenCkDi" data-bind="value : fiTenCkDi"/>
                <a class="btn green bt-center" data-bind="click: onAddCKDi"><i class="fa fa-plus fa-lg"></i> </a>
                <input type="hidden" name="fiMaCkDi" data-bind="value : fiMaCkDi"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.cuakhauden" /><a class="nsw-require-field"> (*)</a> </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" readonly="true" name="fiTenCkDen" data-bind="value : fiTenCkDen"/>
                <a class="btn green bt-center" data-bind="click: onAddCKDen"><i class="fa fa-plus fa-lg"></i> </a>
                <input type="hidden" name="fiMaCkDen" data-bind="value : fiMaCkDen"/>
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
                <label><spring:message code="moh.09.thongtinnhapkhau.sotokhai" /> <a class="nsw-require-field"> (*)</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" name="fiSoTkhq" data-bind="value : fiSoTkhq" maxlength="11" />
                <br /><a style="color: red;font-size: 8pt">(Số tờ khai chính thức)</a>
            </div>
        </div>  
    </div>
    
</fieldset>
<fieldset>
    <legend><b><spring:message code="moh.09.chitietlohang" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <a class="btn green bt-center" data-bind="click: onKhaiBaoLoHang, visible: showAddProductBtn"><i class="fa fa-edit fa-lg"></i> Thêm mặt hàng</a>
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
                            <a class="green" data-bind="click: $parent.onSuaLoHang.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
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
<template id="cuakhau-tmpl">
    <form role="form" class="form-horizontal" id="cuakhau-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>Mã cửa khẩu</label>
                </div>  
                <div class="col-md-4">
                    <input class="form-control" type="text" name="fiMaCuakhau" data-bind="value : fiMaCuakhau" maxlength="255" />
                </div> 
                <div class="col-md-2 nsw-text-right">
                    <label>Tên cửa khẩu</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" name="fiTenCuakhau" data-bind="value : fiTenCuakhau" maxlength="50" />
                </div>
            </div>  
            
            
        </div>
        <div class="form-group">
            <div class="col-md-12 nsw-text-center">
                <a class="btn btn-info" data-bind="click: doSearch">Tìm kiếm</a>
            </div>
        </div>
        <div class="row">            
            <div class="col col-md-12 nsw-text-right">
                <div class="nsw-flr"> 
                    <!-- ko with:paging()-->
                    <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                        <li data-bind="css: { disabled: !firstPageActive() }">
                            <a data-bind="click: goToFirst">Trang đầu</a>
                        </li>
                        <li data-bind="css: { disabled: !previousPageActive() }">
                            <a data-bind="click: goToPrevious">Trang trước</a>
                        </li>
                        <!-- ko foreach: getPages() -->
                        <li data-bind="css: { active: $parent.currentPage() === $data }">
                            <a data-bind="click: $parent.goToPage, text: $data"></a>
                        </li>
                        <!-- /ko -->
                        <li data-bind="css: { disabled: !nextPageActive() }">
                            <a data-bind="click: goToNext">Trang sau</a>
                        </li>
                        <li data-bind="css: { disabled: !lastPageActive() }">
                            <a data-bind="click: goToLast">Trang cuối</a>
                        </li>
                    </ul>
                    <!-- /ko -->
                </div>
            </div>
            <div class="col col-md-12">
                <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th class="text-center"><b><spring:message code="mt.lichsu.stt" /></b></th>
                    <th><b>Mã cửa khẩu</b></th>
                    <th><b>Tên cửa khẩu</b></th>                    
                    <th>#</th>
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'cuaKhauTmpl', foreach: lstItems }">
            </tbody>
            <script id="cuaKhauTmpl" type="text/html">
                <tr>
                    <td data-bind="text : $index() + 1"></td>
                    <td class="text-left" data-bind="text : fiMaCuakhau"></td> 
                    <td class="text-left" data-bind="text : fiTenCuakhau"></td>                     
                    <td>
                        <a class="btn btn-info btn-xs" data-bind="click: $parent.doSelect.bind($parent)">Chọn</a> 
                    </td>                     
                </tr>                      
            </script>
        </table>        
    </form>
</template>
                    
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
                            <label><spring:message code="moh.09.chitietlohang.diachi" /><a class="nsw-require-field">(*)</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiDiachiNsx" name="fiDiachiNsx" data-bind="value : fiDiachiNsx" maxlength="255" />
                        </div> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.09.chitietlohang.phuongthuckiemtra" /><a class="nsw-require-field">(*)</a></label>
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
                            <label>- Nhãn sản phẩm bắt buộc <a class="nsw-require-field" data-bind="visible: isKtChat"> (*)</a></label>
                            <br />
                            <label>- Bản tiêu chuẩn sản phẩm (nếu có )</label>
                        </div>
                        <div class="col-md-6">
                            <a class="btn btn-info btn-xs" data-bind="click : doUpload, visible: canUpload">Đính kèm</a>
                            <br /><a style="color:red; font-size: 8pt" data-bind="visible: fileError">(Yêu cầu phải đính kèm tài liệu bản công bố)</a>
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
