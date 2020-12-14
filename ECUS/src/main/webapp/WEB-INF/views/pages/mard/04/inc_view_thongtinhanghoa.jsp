<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend style="color: dodgerblue;">
        <b>Thông tin lô hàng</b>&nbsp;
    </legend>

    <!--ko if: isViewExcel -->
    <%--    Phân trang cho danh sách lô hàng--%>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col col-md-6">
                Tổng số: <b data-bind="text: recordCount"></b> bản ghi
            </div>
            <div class="col col-md-6 nsw-text-right">
                <div>
                    <a href="#"
                       data-bind="click: moveFirst, enable: currentPageIndex()> 0">Trang đầu</a> |
                    <a href="#" data-bind="click: movePrevious, enable: currentPageIndex()> 0">Trang trước</a> |
                    Trang <span data-bind="text: currentPageIndex() + 1"></span> trong <span
                        data-bind="text: maxPageIndex() + 1"></span>
                    <select data-bind="options: pageSizeOptions, value: currentPageSize, event: { change: onPageSizeChange }">
                    </select>
                    | <a href="#"
                         data-bind="click: moveNext, enable: currentPageIndex() < maxPageIndex()">Trang sau</a> |
                    <a href="#"
                       data-bind="click: moveLast, enable: currentPageIndex() < maxPageIndex()">Trang cuối</a>
                </div>
            </div>
        </div>
    </div>
    <%--    Kết thúc phân trang cho danh sách lô hàng--%>
    <!-- /ko -->

    <%@include file="inc_view_table_hanghoa.jsp" %>

    <!--ko if: isView1 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số hợp đồng hoặc số chứng từ (L/C, TTr,...)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoHopdong" name="fiSoHopdong"
                       data-bind="value : fiSoHopdong" maxlength="255"
                       type="text" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Tổ chức, cá nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTochucXk" name="fiTochucXk"
                       data-bind="value : fiTochucXk" maxlength="255"
                       type="text" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ tổ chức, cá nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiXk" name="fiDiachiXk"
                       data-bind="value : fiDiachiXk" maxlength="1000"
                       type="text" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Nước xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiManuocXk" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTennuocXk
                            , value : fiManuocXk
                            , options : lstNuocXuatkhau
                            , optionsText : 'name'" disabled></select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Cửa khẩu xuất</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaCuakhauXuat" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenCuakhauXuat
                            , value : fiMaCuakhauXuat
                            , options : lstCuakhauXuat
                            , optionsText : 'name'" disabled></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Tên tổ chức, cá nhân nhập khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTochucNhap" name="fiTochucNhap" maxlength="255"
                       type="text" data-bind="value : fiTochucNhap" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ tổ chức, cá nhân nhập khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiNhap" name="fiDiachiNhap" maxlength="1000"
                       type="text" data-bind="value : fiDiachiNhap" disabled/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Cửa khẩu nhập</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaCuakhauNhap" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenCuakhauNhap
                            , value : fiMaCuakhauNhap
                            , options : lstCuakhauNhap
                            , optionsText : 'name'" disabled></select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Phương tiên vận chuyển</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaPhuongtien" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenPhuongtien
                            , value : fiMaPhuongtien
                            , options : lstPhuongtien
                            , optionsText : 'name'" disabled></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Mục đích sử dụng</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMucdichSd" name="fiMucdichSd" maxlength="255"
                       type="text" data-bind="value : fiMucdichSd" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Giấp phép kiểm dịch thực vật nhập khẩu (nếu có)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiGiayphepKd" name="fiGiayphepKd" maxlength="255"
                       type="text" data-bind="value : fiGiayphepKd" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Địa điểm kiểm dịch</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiadiemKd" name="fiDiadiemKd"
                       data-bind="value : fiDiadiemKd" maxlength="255"
                       type="text" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian kiểm dịch</label>
            </div>
            <div class="col-md-4">
                <input name="fiThoigianKd" id="fiThoigianKd"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiThoigianKd"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số bản giấy chứng nhận kiểm dịch cần cấp</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGcn" name="fiSoGcn" maxlength="50"
                       type="text" data-bind="value : fiSoGcn" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Nơi hàng đến</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoihangDen" name="fiNoihangDen" maxlength="1000"
                       type="text" data-bind="value : fiNoihangDen" disabled/>

            </div>
        </div>
    </div>
    <!-- /ko -->

    <!--ko if: isView2 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Mục đích sử dụng</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMucdichSd" name="fiMucdichSd" maxlength="255"
                       type="text" data-bind="value : fiMucdichSd" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Giấp phép kiểm dịch thực vật nhập khẩu (nếu có)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiGiayphepKd" name="fiGiayphepKd" maxlength="255"
                       type="text" data-bind="value : fiGiayphepKd" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian nhập khẩu dự kiến từ ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiThoigianNhaptu" id="fiThoigianNhaptu"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiThoigianNhaptu"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian nhập khẩu dự kiến đến ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiThoigianNhapden" id="fiThoigianNhapden"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiThoigianNhapden"
                       readonly disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Địa điểm tập kết hàng</label>
            </div>
            <div class="col-md-4">
                <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiDiadiemTapket"
                       name="fiDiadiemTapket"
                       data-bind="value : fiDiadiemTapket" maxlength="255" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Địa điểm đăng ký lấy mẫu kiểm tra</label>
            </div>
            <div class="col-md-4">
                <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiDiadiemLaymau"
                       name="fiDiadiemLaymau"
                       data-bind="value : fiDiadiemLaymau" maxlength="255" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Ngày đăng ký lấy mẫu kiểm tra từ ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiNgayDangkyTu" id="fiNgayDangkyTu"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiNgayDangkyTu"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Ngày đăng ký lấy mẫu kiểm tra đến ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiNgayDangkyDen" id="fiNgayDangkyDen"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiNgayDangkyDen"
                       readonly disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thông tin người liên hệ</label>
            </div>
            <div class="col-md-4">
                <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiNguoiLienhe"
                       name="fiNguoiLienhe"
                       data-bind="value : fiNguoiLienhe" maxlength="255" disabled/>
            </div>
        </div>
    </div>
    <legend style="color: dodgerblue;">
        <b>Thông tin hợp đồng, hóa đơn, phiếu đóng gói</b>
    </legend>
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHopdongKtcl">
        <thead>
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center" style="width: 3%">STT</th>
            <th class="text-center">Loại giấy tờ</th>
            <th class="text-center">Số hợp đồng</th>
            <th class="text-center">Ngày cấp</th>
        </tr>
        </thead>
        <tbody data-bind="foreach: lstHopdong04">
        <tr>
            <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">
            </td>
            <td>
                <select class="form-control select2 fiMaLoaigiayto" data-bind="
                                                                        value: fiMaLoaigiayto,
                                                                        selectedText2 : fiLoaigiayto,
                                                                        attr: {'id': 'fiMaLoaigiayto-' + fiIdHd()},
                                                                        optionsCaption: 'Chọn...',
                                                                        optionsValue : 'id',
                                                                        optionsText : 'name',
                                                                        options : $parent.lstLoaiGiayto()"
                        disabled></select>
            </td>
            <td>
                <input class="form-control text-right" id="fiSoHopdong" onblur="this.value = removeSpaces(this.value);"
                       data-bind="value : fiSoHopdong" disabled/>
            </td>
            <td>
                <input class="form-control date-picker text-center" placeholder="dd/mm/yyyy" id="fiNgaycapGiayto"
                       name="fiNgaycapGiayto"
                       data-bind="datepicker : fiNgaycapGiayto"
                       type="text"
                       data-date-format="dd/mm/yyyy" readonly disabled/>
            </td>
        </tr>
        </tbody>
    </table>
    <!-- /ko -->

    <!--ko if: isView3 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số hợp đồng hoặc số chứng từ thanh toán (L/C, TTr,...)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoHopdong" name="fiSoHopdong"
                       data-bind="value : fiSoHopdong" maxlength="255"
                       type="text" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số bill</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoBill" name="fiSoBill"
                       data-bind="value : fiSoBill" maxlength="255"
                       type="text" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Tên của thương nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenThuongnhanXk" name="fiTenThuongnhanXk" maxlength="255"
                       type="text" data-bind="value : fiTenThuongnhanXk" disabled/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ của thương nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiThuongnhanXk" name="fiDiachiThuongnhanXk" maxlength="1000"
                       type="text" data-bind="value : fiDiachiThuongnhanXk" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Điện thoại của thương nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtThuongnhanXk" name="fiSdtThuongnhanXk" maxlength="1000"
                       type="text" data-bind="value : fiSdtThuongnhanXk" disabled/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Xuất xứ hàng hóa</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiXuatxuHh" name="fiXuatxuHh"
                       data-bind="value : fiXuatxuHh" maxlength="255"
                       type="text" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Nước xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiManuocXk" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTennuocXk
                            , value : fiManuocXk
                            , options : lstNuocXuatkhau
                            , optionsText : 'name'" disabled></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian nhập khẩu dự kiến từ ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiThoigianNkTu" id="fiThoigianNkTu"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiThoigianNkTu"
                       readonly disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian nhập khẩu dự kiến đến ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiThoigianNkDen" id="fiThoigianNkDen"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiThoigianNkDen"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Cửa khẩu xuất (Đi)</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaCuakhauXuat" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenCuakhauXuat
                            , value : fiMaCuakhauXuat
                            , options : lstCuakhauXuat
                            , optionsText : 'name'" disabled></select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Cửa khẩu nhập (Đến)</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaCuakhauNhap" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenCuakhauNhap
                            , value : fiMaCuakhauNhap
                            , options : lstCuakhauNhap
                            , optionsText : 'name'" disabled></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian kiểm tra từ ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiTgKiemtraTu" id="fiTgKiemtraTu"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiTgKiemtraTu"
                       readonly disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian kiểm tra đến ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiTgKiemtraDen" id="fiTgKiemtraDen"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiTgKiemtraDen"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Địa điểm kiểm tra</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiadiemKt" name="fiDiadiemKt" maxlength="255"
                       type="text" data-bind="value : fiDiadiemKt" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Phương tiên vận chuyển</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaPhuongtien" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenPhuongtien
                            , value : fiMaPhuongtien
                            , options : lstPhuongtien
                            , optionsText : 'name'" disabled></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Mục đích sử dụng</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMucdichSd" name="fiMucdichSd" maxlength="255"
                       type="text" data-bind="value : fiMucdichSd" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Giấp phép kiểm dịch thực vật nhập khẩu (nếu có)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiGiayphepKd" name="fiGiayphepKd" maxlength="255"
                       type="text" data-bind="value : fiGiayphepKd" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số bản giấy chứng nhận kiểm dịch thực vật và kiểm tra ATTP cần cấp</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGcn" name="fiSoGcn" maxlength="50"
                       type="text" data-bind="value : fiSoGcn" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Nơi hàng đến</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoihangDen" name="fiNoihangDen" maxlength="1000"
                       type="text" data-bind="value : fiNoihangDen" disabled/>

            </div>
        </div>
    </div>
    <!-- /ko -->
</fieldset>