<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend style="color: dodgerblue;"><b>Thông tin chung</b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Mã hồ sơ</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaHoso" name="fiMaHoso" data-bind="value : fiMaHoso" type="text"
                       readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Trạng thái hồ sơ</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTrangthai" name="fiTenTrangthai" maxlength="255"
                       type="text" data-bind="value : fiTenTrangthai" readonly="readonly"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Ngày tạo</label>
            </div>
            <div class="col-md-4">
                <input name="fiNgaytao" id="fiNgaytao"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" disabled="disabled" readonly="readonly"
                       data-bind="datepicker : fiNgaytao"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Trạng thái phí</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTrangthaiphi" name="fiTenTrangthaiphi" maxlength="255"
                       type="text" data-bind="value : fiTenTrangthaiphi" readonly="readonly"/>
            </div>
            <%--            <div class="col-md-2 nsw-text-right">--%>
            <%--                <label>Số xác nhận đăng ký (của BNN)</label>--%>
            <%--            </div>--%>
            <%--            <div class="col-md-4">--%>
            <%--                <input class="form-control" id="fiSoXnDk" name="fiSoXnDk" data-bind="value : fiSoXnDk" type="text"--%>
            <%--                       maxlength="255"/>--%>
            <%--            </div>--%>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><!--ko if: isViewThongtinDn -->
                    Tên tổ chức, cá nhân đăng ký
                    <!-- /ko -->
                    <!--ko if: isView4 -->
                    Tên chủ hàng
                    <!-- /ko --></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenTochuc" name="fiTenTochuc" maxlength="255"
                       type="text" data-bind="value : fiTenTochuc" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><!--ko if: isViewThongtinDn -->
                    Địa chỉ tổ chức, cá nhân đăng ký
                    <!-- /ko -->
                    <!--ko if: isView4 -->
                    Địa chỉ chủ hàng
                    <!-- /ko --></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiTochuc" name="fiDiachiTochuc" maxlength="1000"
                       type="text" data-bind="value : fiDiachiTochuc" readonly="readonly"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số điện thoại đăng ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtTochuc" name="fiSdtTochuc" maxlength="50"
                       type="text" data-bind="value : fiSdtTochuc" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Mã số thuế</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMst" name="fiMst" maxlength="14"
                       type="text" data-bind="value : fiMst" readonly="readonly"/>
            </div>
        </div>
    </div>

    <!--ko if: isView123 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Email/ Fax</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiFaxEmail" name="fiFaxEmail" maxlength="255"
                       type="text" data-bind="value : fiFaxEmail" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Cơ quan xử lý</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaCqxl" name="fiMaCqxl"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenCqxl
                            , value : fiMaCqxl
                            , options : lstCqxl
                            , optionsText : 'name'" disabled>
                </select>
            </div>
        </div>
    </div>
    <!-- /ko -->

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Loại đơn đăng ký</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaLoaidon" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenLoaidon
                            , value : fiMaLoaidon
                            , options : lstLoaidon
                            , optionsText : 'name'" disabled></select>
            </div>
            <!--ko if: isView13 -->
            <div class="col-md-2 nsw-text-right">
                <label>Số CMND đăng ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCmnd" name="fiCmnd" maxlength="255"
                       type="text" data-bind="value : fiCmnd" disabled/>
            </div>
            <!-- /ko -->
            <!--ko if: isView2 -->
            <div class="col-md-2 nsw-text-right">
                <label>Số đăng ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoDkTochuc" name="fiSoDkTochuc" maxlength="50"
                       type="text" data-bind="value : fiSoDkTochuc" disabled/>

            </div>
            <!-- /ko -->
        </div>
    </div>

    <!--ko if: isView13 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Ngày cấp</label>
            </div>
            <div class="col-md-4">
                <input name="fiNgaycapCmnd" id="fiNgaycapCmnd"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiNgaycapCmnd"
                       disabled readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Nơi cấp</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoicapCmnd" name="fiNoicapCmnd" maxlength="255"
                       type="text" data-bind="value : fiNoicapCmnd" disabled/>
            </div>
        </div>
    </div>
    <!-- /ko -->

    <!--ko if: isView3 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Tên tổ chức, cá nhân nhập khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTochucNhap" name="fiTochucNhap" maxlength="255"
                       type="text" data-bind="value : fiTochucNhap" disabled/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ tổ chức, cá nhân nhập khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiNhap" name="fiDiachiNhap" maxlength="1000"
                       type="text" data-bind="value : fiDiachiNhap" disabled/>

            </div>
        </div>
    </div>
    <!-- /ko -->

    <!--ko if: isView34 -->
    <div class="form-group">
        <div class="col-md-12">
            <!--ko if: isView3 -->
            <div class="col-md-2 nsw-text-right">
                <label>Điện thoại của tổ chức, cá nhân nhập khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtTochucNhap" name="fiSdtTochucNhap" maxlength="255"
                       type="text" data-bind="value : fiSdtTochucNhap" disabled/>

            </div>
            <!-- /ko -->
            <div class="col-md-2 nsw-text-right">
                <label>Tên của thương nhân chịu trách nhiệm về chất lượng hàng hóa</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTochucNhapTrachnhiem" name="fiTochucNhapTrachnhiem" maxlength="255"
                       type="text" data-bind="value : fiTochucNhapTrachnhiem" disabled/>

            </div>
            <!--ko if: isView4 -->
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ của thương nhân chịu trách nhiệm về chất lượng hàng hóa</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiNhapTrachnhiem" name="fiDiachiNhapTrachnhiem" maxlength="255"
                       type="text" data-bind="value : fiDiachiNhapTrachnhiem" disabled/>

            </div>
            <!-- /ko -->
        </div>
    </div>
    <!-- /ko -->

    <div class="form-group">
        <div class="col-md-12">
            <!--ko if: isView3 -->
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ của thương nhân chịu trách nhiệm về chất lượng hàng hóa</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiNhapTrachnhiem" name="fiDiachiNhapTrachnhiem" maxlength="255"
                       type="text" data-bind="value : fiDiachiNhapTrachnhiem" disabled/>

            </div>
            <!-- /ko -->
            <!--ko if: isView34 -->
            <div class="col-md-2 nsw-text-right">
                <label>Điện thoại của thương nhân chịu trách nhiệm về chất lượng hàng hóa</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtNhapTrachnhiem" name="fiSdtNhapTrachnhiem" maxlength="255"
                       type="text" data-bind="value : fiSdtNhapTrachnhiem" disabled/>

            </div>
            <!-- /ko -->
            <!--ko if: isView4 -->
            <div class="col-md-2 nsw-text-right">
                <label>Tên của thương nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenThuongnhanXk" name="fiTenThuongnhanXk" maxlength="255"
                       type="text" data-bind="value : fiTenThuongnhanXk" disabled/>

            </div>
            <!-- /ko -->
        </div>
    </div>

    <!--ko if: isView4 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ của thương nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiThuongnhanXk" name="fiDiachiThuongnhanXk" maxlength="1000"
                       type="text" data-bind="value : fiDiachiThuongnhanXk" disabled/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Điện thoại của thương nhân xuất khẩu</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtThuongnhanXk" name="fiSdtThuongnhanXk" maxlength="1000"
                       type="text" data-bind="value : fiSdtThuongnhanXk" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian nhập khẩu dự kiến từ ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiThoigianNkTu" id="fiThoigianNkTu"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy"
                       data-bind="datepicker : fiThoigianNkTu"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian nhập khẩu dự kiến đến ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiThoigianNkDen" id="fiThoigianNkDen"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy"
                       data-bind="datepicker : fiThoigianNkDen"
                       readonly disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian kiểm tra từ ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiTgKiemtraTu" id="fiTgKiemtraTu"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy"
                       data-bind="datepicker : fiTgKiemtraTu"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian kiểm tra đến ngày</label>
            </div>
            <div class="col-md-4">
                <input name="fiTgKiemtraDen" id="fiTgKiemtraDen"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy"
                       data-bind="datepicker : fiTgKiemtraDen"
                       readonly disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Địa điểm kiểm tra</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiadiemKt" name="fiDiadiemKt" maxlength="255"
                       type="text" data-bind="value : fiDiadiemKt" disabled/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Dự kiến tên cơ quan kiểm tra</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDukienCqKt" name="fiDukienCqKt" maxlength="255"
                       type="text" data-bind="value : fiDukienCqKt" disabled/>

            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Cửa khẩu đi</label>
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
                <label>Cửa khẩu đến</label>
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
    <!-- /ko -->

    <%--    thông tin chứng nhận kiểm dịch và kiểm tra chất lượng--%>
    <!--ko if: isView2 -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Loại thức ăn</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaLoaiThucan" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenLoaiThucan
                            , value : fiMaLoaiThucan
                            , options : lstLoaiThucan
                            , optionsText : 'name'" disabled></select>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Loại kiểm tra</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMaLoaiKiemtra" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTenLoaiKiemtra
                            , value : fiMaLoaiKiemtra
                            , options : lstLoaiKiemtra
                            , optionsText : 'name'" disabled></select>
            </div>
        </div>
    </div>
    <!--ko if: isViewSoCvMiengiam -->
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số công văn miễn giảm</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoTbMiengiam" name="fiSoTbMiengiam" maxlength="255"
                       type="text" data-bind="value : fiSoTbMiengiam" disabled/>
            </div>
        </div>
    </div>
    <!-- /ko -->
    <legend style="color: dodgerblue;"><b>Bên bán hàng</b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Bên bán hàng (hãng, nước)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiHang" name="fiHang" maxlength="255"
                       type="text" data-bind="value : fiHang" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ bên bán</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiBenban" name="fiDiachiBenban" maxlength="255"
                       type="text" data-bind="value : fiDiachiBenban" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số điện thoại bên bán</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtBenban" name="fiSdtBenban" maxlength="50"
                       type="text" data-bind="value : fiSdtBenban" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số fax bên bán</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiFaxBenban" name="fiFaxBenban" maxlength="50"
                       type="text" data-bind="value : fiFaxBenban" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Nơi xuất hàng</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoiXuathang" name="fiNoiXuathang" maxlength="255"
                       type="text" data-bind="value : fiNoiXuathang" disabled/>
            </div>
        </div>
    </div>
    <legend style="color: dodgerblue;"><b>Bên mua hàng</b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Bên mua hàng</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBenMuahang" name="fiBenMuahang" maxlength="255"
                       type="text" data-bind="value : fiBenMuahang" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số CMND bên mua hàng (nếu là cá nhân)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCmndBenmua" name="fiCmndBenmua" maxlength="50"
                       type="text" data-bind="value : fiCmndBenmua" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Ngày cấp CMND bên mua hàng (nếu là cá nhân)</label>
            </div>
            <div class="col-md-4">
                <input name="fiNgaycapCmndBenmua" id="fiNgaycapCmndBenmua"
                       class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"
                       type="text" value="" placeholder="dd/mm/yyyy" data-bind="datepicker : fiNgaycapCmndBenmua"
                       readonly disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Nơi cấp CMND bên mua hàng (nếu là cá nhân)</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoicapCmndBenmua" name="fiNoicapCmndBenmua" maxlength="255"
                       type="text" data-bind="value : fiNoicapCmndBenmua" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ bên mua</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiBenmua" name="fiDiachiBenmua" maxlength="255"
                       type="text" data-bind="value : fiDiachiBenmua" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số điện thoại bên mua</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSdtBenmua" name="fiSdtBenmua" maxlength="50"
                       type="text" data-bind="value : fiSdtBenmua" disabled/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số fax bên mua</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiFaxBenmua" name="fiFaxBenmua" maxlength="50"
                       type="text" data-bind="value : fiFaxBenmua" disabled/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Nơi nhận hàng</label>
            </div>
            <div class="col-md-4">
                <select class="form-control select2" id="fiMacangNoinhan" name="id"
                        data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : fiTencangNoinhan
                            , value : fiMacangNoinhan
                            , options : lstCangnhan
                            , optionsText : 'name'" disabled></select>
            </div>
        </div>
    </div>
    <!-- /ko -->
</fieldset>

<script type="text/javascript">
    $('.date-picker').datepicker({autoclose: true, format: "dd/mm/yyyy", startDate: new Date(0, 0, 0, 0, 0, 0, 0)});
</script>