<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="moh.07.trangthietbi" /></b><a class="nsw-require-field">*</a></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <a class="btn green bt-center" data-bind="click: onKhaiBaoTrangThietBi, visible: showAddProduct"><i class="fa fa-add fa-lg"></i> Khai báo trang thiết bị y tế</a>
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moh.07.trangthietbi.stt" /></th>
                        <th class="text-center"><spring:message code="moh.07.trangthietbi.tenttb" /></th>
                        <th class="text-center"><spring:message code="moh.07.trangthietbi.phannhom" /></th>
                        <th class="text-center"><spring:message code="moh.07.trangthietbi.loaittb" /></th>
                        <th class="text-center"><spring:message code="moh.07.trangthietbi.chungloai" /></th>
                        <th class="text-center"><spring:message code="moh.07.trangthietbi.tenchusohuu" /></th>
                        <th class="text-center"><spring:message code="moh.07.trangthietbi.xoa" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: hangHoa">
                    <tr>
                        <td data-bind="text : fiStt">1</td>  
                        <td data-bind="text : fiTenTtb"></td>  
                        <td data-bind="text : fiTenPhannhom"></td>  
                        <td data-bind="text : fiTenLoaiTtb"></td>  
                        <td style="text-align: center;">
                            <a class="btn green bt-center" data-bind="click: $parent.onXemTrangThietBi.bind($parent)"><i class="fa fa-search"></i> Xem</a>
                        </td>  
                        <td data-bind="text : fiTenCsh"></td>  
                        <td class="text-center">
                            <a class="btn red bt-center" data-bind="click: $parent.onXoaTrangThietBi.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table> 
            <span data-bind="text : hangHoaErrorMsg" style="color:red;"> </span>
            <br />         
        </div>
    </div>
</fieldset>
<template id="trangthietbi-template">
    <div class="row">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="trangthietbi-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.tenttb" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiTenTtb" name="fiTenTtb" data-bind="value : fiTenTtb" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.loaittb" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiLoaiTtb" id="fiLoaiTtb" name="fiLoaiTtb"  
                                    data-bind="value: fiLoaiTtb, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstLoaiTtb, 
                                            optionsText : 'name'"></select>
                        </div> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.phannhom" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiPhannhom" id="fiPhannhom" name="fiPhannhom"  
                                    data-bind="value: fiPhannhom, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstPhanNhomTtb, 
                                            optionsText : 'name'"></select>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.nhom" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiNhomTtb" id="fiNhomTtb" name="fiNhomTtb"  
                                    data-bind="value: fiNhomTtb, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstNhomTtb, 
                                            optionsText : 'name'"></select>
                        </div>
                    </div>   
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.quycachdonggoi" /></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiDongGoi" name="fiDongGoi" data-bind="value : fiDongGoi" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.cososanxuat" /> <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiNhieuCssx" id="fiNhieuCssx" name="fiNhieuCssx"  
                                    data-bind="value: fiNhieuCssx, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstCoSoSanXuatTtb, 
                                            optionsText : 'name'"></select>
                        </div> 
                    </div>
                </div>
                <div class="form-group">  
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.tenchusohuu" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiTenCsh" name="fiTenCsh" data-bind="value : fiTenCsh" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.nuocchusohuu" /><a class="nsw-require-field">*</a> </label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiMaQaCsh" id="fiMaQaCsh" name="fiMaQaCsh"  
                                    data-bind="value: fiMaQaCsh, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : lstQuocGia, 
                                            optionsText : 'name'"></select>
                        </div> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.diachi" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiDiachiCsh" name="fiDiachiCsh" data-bind="value : fiDiachiCsh" maxlength="255" />
                        </div> 

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.trangthietbi.tieuchuan" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiTieuchuan" name="fiTieuchuan" data-bind="value : fiTieuchuan" maxlength="255" />
                        </div> 
                    </div>
                </div>
                <div class="form-group" data-bind="visible: isShowSoDKLH">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label>Số đăng ký lưu hành BCD/ Số công bố tiêu chuẩn TTBYT Loại<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiSoDklh" name="fiSoDklh" data-bind="value : fiSoDklh" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            
                        </div>
                        <div class="col-md-4">
                            <input type="checkbox" id="fibDaCoDklh" name="fibDaCoDklh" data-bind="checked : fibDaCoDklh" />
                            <label>Đã có số đăng ký trên 1 cửa</label>
                        </div>
                    </div>
                </div>
                <b><spring:message code="moh.07.danhsachchungloai" /></b>
                <div class="form-group">
                    <div class="col-md-12">
                        <a class="btn green bt-center" data-bind="click: onKhaiBaoChungLoai"><i class="fa fa-plus fa-lg"></i></a>
                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center" style="width: 50px"><spring:message code="moh.07.chungloai.stt" /></th>
                                    <th class="text-center"><spring:message code="moh.07.chungloai.masanpham" /></th>
                                    <th class="text-center"><spring:message code="moh.07.chungloai.quycachdonggoi" /></th>
                                    <th class="text-center"><spring:message code="moh.07.chungloai.hanhdong" /></th>
                                </tr>
                            </thead>
                            <tbody data-bind="foreach: lstLoaiHangHoas">
                                <tr>
                                    <td class="text-center" data-bind="text : fiStt"></td>  
                                    <td class="text-center" data-bind="text : fiMaSpCl"></td>  
                                    <td class="text-center" data-bind="text : fiDongGoiCl"></td>  
                                    <td class="text-center">
                                        <a data-bind="click: $parent.onSuaChungLoaiHangHoa.bind($parent)"><i class="fa fa-pencil"></i></a>
                                        <a data-bind="click: $parent.onXoaChungLoaiHangHoa.bind($parent)"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <b data-bind="visible: isShowCSBH"><spring:message code="moh.07.cosobaohanh" /></b> 
                <div class="form-group" data-bind="visible: isShowCSBH">
                    <div class="col-md-12">
                        <a class="btn green bt-center" data-bind="click: onKhaiBaoCoSoBaoHanh"><i class="fa fa-plus fa-lg"></i></a>
                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center" style="width: 50px"><spring:message code="moh.07.cosobaohanh.stt" /></th>
                                    <th class="text-center"><spring:message code="moh.07.cosobaohanh.tencoso" /></th>
                                    <th class="text-center"><spring:message code="moh.07.cosobaohanh.diachi" /></th>
                                    <th class="text-center"><spring:message code="moh.07.cosobaohanh.dienthoaicodinh" /></th>
                                    <th class="text-center"><spring:message code="moh.07.cosobaohanh.didong" /></th>
                                    <th class="text-center"><spring:message code="moh.07.cosobaohanh.hanhdong" /></th>
                                </tr>
                            </thead>
                            <tbody data-bind="foreach: lstBaoHanhHangHoas">
                                <tr>
                                    <td data-bind="text : fiStt"></td>  
                                    <td data-bind="text : fiTenCsbh"></td>  
                                    <td data-bind="text : fiDiachiCsbh"></td>  
                                    <td data-bind="text : fiSdtCdCsbh"></td>  
                                    <td data-bind="text : fiSdtDdCsbh"></td>  
                                    <td class="text-center">
                                        <a data-bind="click: $parent.onXoaCoSoBaoHanh.bind($parent)"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div> 
                <div class="form-group">
                    <div class="col-md-12">
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>
                    </div>
                </div> 
            </form>
        </div>
    </div>
</template>

<template id="chungloai-template">
    <div class="row">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="chungloai-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-3 nsw-text-right">
                            <label><spring:message code="moh.07.chungloai.masanpham" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-9">
                            <input class="form-control" type="text" id="fiMaSpCl" name="fiMaSpCl" data-bind="value : fiMaSpCl" maxlength="255" />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-3 nsw-text-right">
                            <label><spring:message code="moh.07.chungloai.quycachdonggoi" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-9">
                            <input class="form-control" type="text" id="fiDongGoiCl" name="fiDongGoiCl" data-bind="value : fiDongGoiCl" maxlength="255" />
                        </div>
                    </div>
                </div>
                <b>Thông tin cơ sở sản xuất</b>
                <div class="form-group">
                    <div class="col-md-12">
                        <a class="btn green bt-center" data-bind="click: onThemMoiCSSX"><i class="fa fa-plus"></i></a>
                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center" style="width: 50px"><spring:message code="moh.07.tepdinhkem.stt" /></th>
                                    <th class="text-center">Tên cơ sở sản xuất</th>
                                    <th class="text-center">Địa chỉ cơ sở sản xuất</th>
                                    <th class="text-center" style="width: 140px">Nước sản xuất</th>
                                    <th class="text-center" style="width: 50px">#</th>
                                </tr>
                            </thead>
                            <tbody data-bind="foreach: lstCssxHangHoas">
                                <tr>
                                    <td data-bind="text : fiStt"></td>  
                                    <td>
                                        <input class="form-control" name="fiTenCssx" data-bind="value : fiTenCssx" maxlength="250"/>
                                    </td>  
                                    <td>
                                        <input class="form-control" name="fiDiachiCssx" data-bind="value : fiDiachiCssx" maxlength="250"/>
                                    </td>
                                    <td style="width: 120px">
                                        <select class="form-control select2 fiMaQgSx" id="fiMaQgSx" name="fiMaQgSx"  
                                            data-bind="value: fiMaQgSx, 
                                            optionsCaption: 'Chọn...', 
                                            optionsValue : 'id',
                                            options : $parent.lstQuocGia, 
                                            optionsText : 'name'"></select>                                       
                                    </td>
                                    <td class="text-center">
                                        <a data-bind="click: $parent.onXoaCoSoSanXuat.bind($parent)"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <span data-bind="visible: errorCssxMessage" style="color:red;">Thông tin Cơ sở sản xuất phải được nhập đầy đủ.</span>
                    </div>
                </div>        
                <b><spring:message code="moh.07.tepdinhkem" /></b>
                <div class="form-group">
                    <div class="col-md-12">

                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center" style="width: 50px"><spring:message code="moh.07.tepdinhkem.stt" /></th>
                                    <th class="text-center"><spring:message code="moh.07.tepdinhkem.tentep" /></th>
                                    <th class="text-center" style="width: 150px"><spring:message code="moh.07.tepdinhkem.tailen" /></th>
                                    <th class="text-center" style="width: 150px"><spring:message code="moh.07.tepdinhkem.chucnang" /></th>
                                </tr>
                            </thead>
                            <tbody data-bind="foreach: lstDinhKemHangHoas">
                                <tr>
                                    <td class="text-center" data-bind="text: $index() + 1"></td>
                                    <td data-bind="text : fiTenLoaiTep"></td>  
                                    <td class="text-center">
                                        <a class="btn btn-info btn-xs" data-bind="visible: canUpload, click: doUpload">Đính kèm</a>
                                        <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiDuongDan}"></a>
                                    </td>
                                    <td class="text-center">                                        
                                        <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" data-bind="visible: canDelete, click: doDelete "></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <span data-bind="visible: errorCssxFile" style="color:red;">Thông tin đính kèm phải được nhập đầy đủ.</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>
<template id="cosobaohanh-template">
    <div class="row">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="cosobaohanh-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.cosobaohanh.masothue" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiMst" name="fiMst" readonly data-bind="value : fiMst" maxlength="50" />
                        </div>
                    </div>                    
                </div>
                        
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.cosobaohanh.tencoso" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" type="text" id="fiTenCsbh" name="fiTenCsbh" data-bind="value : fiTenCsbh" maxlength="255" />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.cosobaohanh.diachi" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" type="text" id="fiDiachiCsbh" name="fiDiachiCsbh" data-bind="value : fiDiachiCsbh" maxlength="255" />
                        </div> 
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.cosobaohanh.dienthoaicodinh" /></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiSdtCdCsbh" name="fiSdtCdCsbh" data-bind="value : fiSdtCdCsbh" maxlength="255" />
                        </div> 
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.07.cosobaohanh.didong" /></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" id="fiSdtDdCsbh" name="fiSdtDdCsbh" data-bind="value : fiSdtDdCsbh" maxlength="255" />
                        </div>
                    </div>
                </div>
                <div class="form-group">       
                    <div class="col-md-12">
                        <p class="nsw-text-center">
                            <a data-bind="click : onLuuCoSoBaoHanh" href="javascript:void(0);" class="btn blue" id="btnSaveCsbh"><i class="fa fa-save" ></i> Cập nhật</a>
                        </p>
                    </div>
                </div>        
                <b>Danh sách cơ sở bảo hành</b>
                <div class="form-group">
                    <div class="col-md-12">

                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center" style="width: 50px"><spring:message code="moh.07.tepdinhkem.stt" /></th>
                                    <th class="text-center" style="width: 50px">#</th>
                                    <th class="text-center"><spring:message code="moh.07.cosobaohanh.tencoso" /></th>
                                    <th class="text-center"><spring:message code="moh.07.cosobaohanh.diachi" /></th>
                                    <th class="text-center" style="width: 150px"><spring:message code="moh.07.cosobaohanh.dienthoaicodinh" /></th>
                                    <th class="text-center" style="width: 150px"><spring:message code="moh.07.cosobaohanh.didong" /></th>
                                    <th class="text-center" style="width: 80px"><spring:message code="moh.07.tepdinhkem.chucnang" /></th>
                                </tr>
                            </thead>
                            <tbody data-bind="foreach: lstBaoHanh">
                                <tr>
                                    <td data-bind="text : fiStt"></td>  
                                    <td style="text-align: center">
                                        <input type="checkbox" data-bind="checked: fiDaChon, click: $parent.onChecked"/>
                                    </td>  
                                    <td data-bind="text : fiTenCsbh"></td>  
                                    <td data-bind="text : fiDiachiCsbh"></td>  
                                    <td data-bind="text : fiSdtCdCsbh"></td>  
                                    <td data-bind="text : fiSdtDdCsbh"></td>  
                                    <td class="text-center">
                                        <a data-bind="click: $parent.onSuaCoSoBaoHanh.bind($parent)"><i class="fa fa-pencil"></i></a>
                                        <a data-bind="click: $parent.onXoaCoSoBaoHanh.bind($parent)"><i class="fa fa-trash"></i></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row">                            
                            <div class="col col-md-6">
                            </div>
                            <div class="col col-md-6 nsw-text-right">
                                <div id="list-pager" class="nsw-flr"> 
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
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>
