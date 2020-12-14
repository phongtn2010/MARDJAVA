<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="inc_css_btnDonhang.jsp" %>

<!--ko if: isView1 -->
<table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa">
    <thead>
    <tr class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center" style="width: 1%;vertical-align: middle;">STT</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Tên hàng hóa</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Nhóm hàng hóa</th>
        <%--        <th class="text-center" style="width: 8%;vertical-align: middle;">Tên khoa học</th>--%>
        <th class="text-center" style="width: 5%;vertical-align: middle;">Số lượng</th>
        <th class="text-center" style="width: 5%;vertical-align: middle;">Đơn vị tính (SL)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Khối lượng tịnh</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (KLT)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Khối lượng cả bì</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (CB)</th>
        <th class="text-center" style="width: 10%;vertical-align: middle;">Chức năng</th>
    </tr>
    </thead>
    <tbody data-bind="foreach: currentPageRecordsLstHanghoa">
    <tr>
        <td style="vertical-align: middle;width: 2%" data-bind="text : $index() + 1">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenchitietHanghoa">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : nhomHangHtml">
        </td>
        <%--        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenKhoahoc">--%>
        <%--        </td>--%>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiSoluong">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenBaobi">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiKhoiluongTinh">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvKlTinh">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiKhoiluongBaoBi">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvKlBaobi">
        </td>
        <td class="text-center" style="vertical-align: middle; width: 7%;">
            <a class="btn green bt-center" data-bind="click: $parent.viewHhOnClick.bind($parent)"><i
                    class="fa fa-eye"></i> Xem</a>
        </td>
    </tr>
    </tbody>
</table>
<!-- /ko -->

<!--ko if: isView2 -->
<table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa">
    <thead>
    <tr class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center" style="width: 1%;vertical-align: middle;">STT</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Tên hàng hóa</th>
        <th class="text-center" style="width: 5%;vertical-align: middle;">Tên khoa học</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Số lượng</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (SL)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Khối lượng tịnh</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (KLT)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Khối lượng cả bì</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (CB)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Xuất xứ</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Giá trị</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tiền tệ</th>
        <th class="text-center" style="width: 10%;vertical-align: middle;">Chức năng</th>
    </tr>
    </thead>
    <tbody data-bind="foreach: currentPageRecordsLstHanghoa">
    <tr>
        <td style="vertical-align: middle;width: 2%" data-bind="text : $index() + 1">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text: fiTenchitietHanghoa">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenKhoahoc">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiSoluong">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenBaobi">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiKhoiluongTinh">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvKlTinh">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiKhoiluongBaoBi">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvKlBaobi">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiNuocXuatxu">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiGiatriHh">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvTiente">
        </td>
        <td class="text-center" style="vertical-align: middle; width: 7%;">
            <a class="btn green bt-center" data-bind="click: $parent.viewHhOnClick.bind($parent)"><i
                    class="fa fa-eye"></i> Xem</a>
        </td>
    </tr>
    </tbody>
</table>
<!-- /ko -->

<!--ko if: isView3 -->
<table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa">
    <thead>
    <tr class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center" style="width: 1%;vertical-align: middle;">STT</th>
        <th class="text-center" style="width: 7%;vertical-align: middle;">Tên hàng hóa</th>
        <th class="text-center" style="width: 7%;vertical-align: middle;">Tên khoa học</th>
        <th class="text-center" style="width: 5%;vertical-align: middle;">Nhóm sản phẩm</th>
        <th class="text-center" style="width: 5%;vertical-align: middle;">Số lượng</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (SL)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Khối lượng tịnh</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (KLT)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Khối lượng cả bì</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Đơn vị tính (CB)</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Tên nhà sản xuất</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Phương thức kiểm tra</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Số văn bản xác nhận phương thức kiểm tra
        </th>
        <th class="text-center" style="width: 10%;vertical-align: middle;">Chức năng</th>
    </tr>
    </thead>
    <tbody data-bind="foreach: currentPageRecordsLstHanghoa">
    <tr>
        <td style="vertical-align: middle;width: 2%" data-bind="text : $index() + 1">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenchitietHanghoa">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenKhoahoc">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiNhomSp">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiSoluong">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenBaobi">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiKhoiluongTinh">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvKlTinh">
        </td>
        <td class="text-right" style="vertical-align: middle;" data-bind="text : fiKhoiluongBaoBi">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvKlBaobi">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenCosoSx">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiPhuongthucKt">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiSoVbPhuongthuc">
        </td>
        <td class="text-center" style="vertical-align: middle; width: 7%;">
            <a class="btn green bt-center" data-bind="click: $parent.viewHhOnClick.bind($parent)"><i
                    class="fa fa-eye"></i> Xem</a>
        </td>
    </tr>
    </tbody>
</table>
<!-- /ko -->

<!--ko if: isView4 -->
<table class="table table-striped table-bordered table-hover table-checkable order-column"
       id="lstHanghoa">
    <thead>
    <tr class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center" style="width: 1%;vertical-align: middle;">STT</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Tên hàng hóa</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Nhóm sản phẩm(Theo QCVN hoặc Codex hoặc tiêu
            chuẩn sản phẩm của nhà sản xuất)
        </th>
        <th class="text-center" style="width: 5%;vertical-align: middle;">Tên nhà sản xuất</th>
        <th class="text-center" style="width: 5%;vertical-align: middle;">Địa chỉ nhà sản xuất</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Phương thức kiểm tra</th>
        <th class="text-center" style="width: 8%;vertical-align: middle;">Số văn bản xác nhận phương thức
            kiểm tra
        </th>
        <th class="text-center" style="width: 10%;vertical-align: middle;">Chức năng</th>
    </tr>
    </thead>
    <tbody data-bind="foreach: currentPageRecordsLstHanghoa">
    <tr>
        <td style="vertical-align: middle;width: 2%" data-bind="text : $index() + 1">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenchitietHanghoa">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiNhomSp">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenCosoSx">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiDiachiCosoSx">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiPhuongthucKt">
        </td>
        <td class="text-left" style="vertical-align: middle;" data-bind="text : fiSoVbPhuongthuc">
        </td>
        <td class="text-center" style="vertical-align: middle; width: 7%;">
            <a class="btn green bt-center" data-bind="click: $parent.viewHhOnClick.bind($parent)"><i
                    class="fa fa-eye"></i> Xem</a>
        </td>
    </tr>
    </tbody>
</table>
<!-- /ko -->

<template id="hanghoa-template">
    <fieldset>
        <form role="form" class="form-horizontal" id="hanghoa-vm">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Tên hàng hóa</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaHang" name="fiMaHang"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMaHanghoa',
                                    selectedText2 : fiTenHang,
                                    value : fiMaHang,
                                    options : lstHanghoa,
                                    optionsText : 'fiTenHanghoa'" disabled>
                        </select>
                    </div>
                    <!--ko if: isViewHanghoakhac -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Tên hàng hóa khác</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiTenhangKhac"
                               name="fiTenhangKhac"
                               data-bind="value : fiTenhangKhac" maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Tên chi tiết hàng hóa</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiTenchitietHanghoa"
                               name="fiTenchitietHanghoa"
                               data-bind="value : fiTenchitietHanghoa" maxlength="255" disabled/>
                    </div>
                    <!--ko if: isViewHH123 -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Tên khoa học</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiTenKhoahoc"
                               name="fiTenKhoahoc"
                               data-bind="value : fiTenKhoahoc" maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                    <!--ko if: isViewHH4 -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Mã HS</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiMaHs"
                               name="fiMaHs" data-bind="value : fiMaHs"
                               maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                </div>
            </div>

            <!--ko if: isViewHH12 -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhóm hàng hóa</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaNhomHh" name="fiMaNhomHh"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMaLoaihang',
                                    selectedText2 : fiTenNhomHh,
                                    value : fiMaNhomHh,
                                    options : lstLoaihang,
                                    optionsText : 'fiTenLoaihang'" disabled>
                        </select>
                    </div>
                    <!--ko if: isViewNhomHanghoakhac -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhóm hàng hóa khác</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiTenNhomHhKhac"
                               name="fiTenNhomHhKhac"
                               data-bind="value : fiTenNhomHhKhac" maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                </div>
            </div>
            <!-- /ko -->

            <!--ko if: isViewHH23 -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Bộ phận sử dụng</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaBophanSd" name="fiMaBophanSd"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'maBpSudung',
                                    selectedText2 : fiTenBophanSd,
                                    value : fiMaBophanSd,
                                    options : lstBophandung,
                                    optionsText : 'tenBpSudung'" disabled>
                        </select>
                    </div>
                    <!--ko if: isViewHH2 -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Mã số công nhận thức ăn chăn nuôi, thủy sản</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiMasoThucan"
                               name="fiMasoThucan" data-bind="value : fiMasoThucan"
                               maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                </div>
            </div>
            <!-- /ko -->

            <!--ko if: isViewHH34 -->
            <div class="form-group">
                <div class="col-md-12">
                    <!--ko if: isViewHH3 -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhóm sản phẩm</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaNhomSp" name="fiMaNhomSp"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMaLoaihang',
                                    selectedText2 : fiNhomSp,
                                    value : fiMaNhomSp,
                                    options : lstLoaihang,
                                    optionsText : 'fiTenLoaihang'" disabled>
                        </select>
                    </div>
                    <!-- /ko -->
                    <!--ko if: isViewHH4 -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhóm sản phẩm (Theo QCVN hoặc Codex hoặc tiêu chuẩn sản phẩm của nhà sản xuất)</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaNhomSp" name="fiMaNhomSp"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMaLoaihang',
                                    selectedText2 : fiNhomSp,
                                    value : fiMaNhomSp,
                                    options : lstNhomSp,
                                    optionsText : 'fiTenLoaihang'" disabled>
                        </select>
                    </div>
                    <!-- /ko -->
                    <!--ko if: isViewNhomSpkhac -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Nhóm sản phẩm khác</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiNhomSpKhac"
                               name="fiNhomSpKhac"
                               data-bind="value : fiNhomSpKhac" maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                </div>
            </div>
            <!-- /ko -->

            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Số lượng</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control text-right"
                               id="fiSoluong"
                               name="fiSoluong"
                               data-bind="value : fiSoluong" maxlength="15" disabled/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label>Đơn vị tính (SL)</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaBaobi" name="fiMaBaobi"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMabaobi',
                                    selectedText2 : fiTenBaobi,
                                    value : fiMaBaobi,
                                    options : lstBaobi,
                                    optionsText : 'fiTenBaobi'" disabled>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Khối lượng tịnh</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control text-right"
                               id="fiKhoiluongTinh"
                               name="fiKhoiluongTinh"
                               data-bind="value : fiKhoiluongTinh"
                               maxlength="31" disabled/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label>Đơn vị tính (KLT)</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaDvKlTinh" name="fiMaDvKlTinh"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMaDonvitinh',
                                    selectedText2 : fiTenDvKlTinh,
                                    value : fiMaDvKlTinh,
                                    options : lstDvTinhKlt,
                                    optionsText : 'fiTenDonvitinh'" disabled>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Khối lượng cả bì</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control text-right"
                               id="fiKhoiluongBaoBi"
                               name="fiKhoiluongBaoBi"
                               data-bind="value : fiKhoiluongBaoBi"
                               maxlength="31" disabled/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label>Đơn vị tính (CB)</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaDvKlBaobi" name="fiMaDvKlBaobi"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMaDonvitinh',
                                    selectedText2 : fiTenDvKlBaobi,
                                    value : fiMaDvKlBaobi,
                                    options : lstDvTinhKlbb,
                                    optionsText : 'fiTenDonvitinh'" disabled>
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>
                            <!--ko if: isViewHH12 -->
                            Tên cơ sở sản xuất
                            <!-- /ko -->
                            <!--ko if: isViewHH34 -->
                            Tên nhà sản xuất
                            <!-- /ko --></label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiTenCosoSx"
                               name="fiTenCosoSx" data-bind="value : fiTenCosoSx"
                               maxlength="255" disabled/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><!--ko if: isViewHH12 -->
                            Địa chỉ cơ sở sản xuất
                            <!-- /ko -->
                            <!--ko if: isViewHH34 -->
                            Địa chỉ nhà sản xuất
                            <!-- /ko --></label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiDiachiCosoSx"
                               name="fiDiachiCosoSx" data-bind="value : fiDiachiCosoSx"
                               maxlength="500" disabled/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <!--ko if: isViewHH13 -->
                    <div class="col-md-2 nsw-text-right">
                        <label><!--ko if: isViewHH1 -->
                            Mã số cơ sở sản xuất (nếu có)
                            <!-- /ko -->
                            <!--ko if: isViewHH3 -->
                            Mã số nhà sản xuất (nếu có)
                            <!-- /ko -->
                        </label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiMasoNhasanxuat"
                               name="fiMasoNhasanxuat" data-bind="value : fiMasoNhasanxuat"
                               maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                    <!--ko if: isViewHH123 -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Mã HS</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiMaHs"
                               name="fiMaHs" data-bind="value : fiMaHs"
                               maxlength="255" disabled/>
                    </div>
                    <!-- /ko -->
                    <!--ko if: isViewHH2 -->
                    <div class="col-md-2 nsw-text-right">
                        <label>Xuất xứ</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaNuocXx" name="fiMaNuocXx"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'maQuocgia',
                                    selectedText2 : fiNuocXuatxu,
                                    value : fiMaNuocXx,
                                    options : lstNuocXuatxu,
                                    optionsText : 'tenQuocgia'" disabled>
                        </select>
                    </div>
                    <!-- /ko -->
                </div>
            </div>

            <!--ko if: isViewHH34 -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Phương thức kiểm tra</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaPhuongthucKt" name="fiMaPhuongthucKt"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'maPhuongthuc',
                                    selectedText2 : fiPhuongthucKt,
                                    value : fiMaPhuongthucKt,
                                    options : lstPhuongthucKt,
                                    optionsText : 'tenPhuongthuc'" disabled>
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label>Số văn bản xác nhận phương thức kiểm tra</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control"
                               id="fiSoVbPhuongthuc"
                               name="fiSoVbPhuongthuc"
                               data-bind="value : fiSoVbPhuongthuc"
                               maxlength="255" disabled/>
                    </div>
                </div>
            </div>
            <!-- /ko -->

            <!--ko if: isViewHH2 -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label>Giá trị hàng hóa</label>
                    </div>
                    <div class="col-md-4">
                        <input onblur="this.value=removeSpaces(this.value);" class="form-control text-right"
                               id="fiGiatriHh"
                               name="fiGiatriHh" data-bind="value : fiGiatriHh"
                               maxlength="16" disabled/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label>Đơn vị tiền tệ</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="fiMaDvTiente" name="fiMaDvTiente"
                                data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'fiMaDvTiente',
                                    selectedText2 : fiTenDvTiente,
                                    value : fiMaDvTiente,
                                    options : lstDvTiente,
                                    optionsText : 'fiTenDvTiente'" disabled>
                        </select>
                    </div>
                </div>
            </div>
            <!-- /ko -->
        </form>
    </fieldset>
</template>