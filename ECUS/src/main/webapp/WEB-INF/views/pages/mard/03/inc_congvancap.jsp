<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <page size="A4" class="a4-padding">
        <table class="tb-none-border w100p">
            <tr>
                <td>
                    <div class="t-center">
                        <p><b data-bind="text: fiTenDn"></b></p>
                        ---------------------------
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center">
                        <b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b>
                        <br/>
                        Độc lập - Tự do - Hạnh phúc <br/>
                        --------------------------
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="left t-center">
                        <p>Số: <b data-bind="text: fiSoCongVanCap"></b></p>
                        <span class="t-italic">"V/v xin chuyển cửa khẩu"</span>
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center">
                        <b data-bind="text : fiNoiKy"></b>, <span data-bind="html: strNgayKy"></span>
                    </div>
                </td>
            </tr>
        </table>
        <p class="title">
            <span style="font-size: medium">ĐƠN XIN CHUYỂN CỬA KHẨU</span>
            <br/>
            <span style="font-size: small" class="t-italic">(Đối với hàng tạm nhập tái xuất)</span>
        </p>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-right">
                    <span>Kính gửi: </span> <br/>
                </div>
                <div class="col-md-9">
                    <b data-bind="text : fiTenCQ"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-right">
                    <span>Tên doanh nghiệp: </span> <br/>
                </div>
                <div class="col-md-9">
                    <b data-bind="text: fiTenDn"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-3 nsw-text-right">
                    <span>Địa chỉ: </span>
                </div>
                <div class="col-md-9">
                    <b data-bind="text: fiDiaChiDn"></b>
                </div>
            </div>
        </div>
        <p class="content">
            Công ty chúng tôi có lô hàng, nhập tại cảng <b data-bind="text: fiTenCuaKhauNhap"></b> và đăng ký xuất đi
            tại cửa khẩu
            <b data-bind="text: fiTenCuaKhauNhap"></b>. Tại thời điểm hiện tại, lô hàng đã đến cửa khẩu <b
                data-bind="text: fiTenCuaKhauXuat"></b>, dưới sự giám sát của
            quý Cơ quan <b data-bind="text: fiTenCQ"></b>. Do gặp khó khăn trong việc nhận hàng và muốn thay đổi cửa
            khẩu nhận hàng sang
            cửa khẩu <b data-bind="text: fiTenCuaKhauXuatChuyen"></b>.
        </p>
        <b>I. Thông tin lô hàng tại cửa khẩu nhập</b> <br/> <br/>
        <p class="content">
            1. Số GCN kiểm dịch <b data-bind="text: fiSoGcnKdNk"></b> &nbsp;&nbsp; Ngày cấp: <b
                data-bind="date: fiNgayCapGcnXk"></b> &nbsp;Giấy có giá trị đến ngày: <b
                data-bind="date: fiTgKiemDichDen"></b>
        </p>
        <p class="content">
            2. Cửa khẩu nhập: <b data-bind="text: fiTenCuaKhauNhap"></b>
        </p>
        <p class="content">
            3. Đơn vị cấp giấy CNKD: <b data-bind="text: fiTenCQ"></b>
        </p>
        <p class="content">
            4. Thông tin lô hàng Tạm nhập tái xuất:
        </p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center">Tên hàng</th>
                <th class="text-center">Số lượng (kiện)</th>
                <th class="text-center">Khối lượng (kg)</th>
                <th class="text-center">Phương tiện vận chuyển/ Container</th>
                <th class="text-center">Số niêm phong kẹp chì</th>
                <th class="text-center">Cửa khẩu xuất</th>
                <th class="text-center">Đơn vị xử lý tại Cửa khẩu xuất</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa03">
            <tr>
                <td data-bind="text : fiTenHang"></td>
                <td data-bind="text : fiSoluong" class="text-right"></td>
                <td data-bind="text : fiKhoiluong" class="text-right"></td>
                <td data-bind="text : ptCu"></td>
                <td data-bind="text : soNiemphong"></td>
                <td data-bind="text : ckx"></td>
                <td data-bind="text : dvxl"></td>
            </tr>
            </tbody>
        </table>
        <b>II. Thông tin lô hàng chuyển khẩu tại cửa khẩu xuất</b> <br/> <br/>
        <p class="content">
            1. Thông tin lô hàng đã xuất một phần.
        </p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa2">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center">Tên hàng</th>
                <th class="text-center">Số lượng (kiện)</th>
                <th class="text-center">Khối lượng (kg)</th>
                <th class="text-center">Ngày xuất</th>
                <th class="text-center">Phương tiện vận chuyển/ Container</th>
                <th class="text-center">Số niêm phong kẹp chì</th>
                <th class="text-center">Cửa khẩu xuất</th>
                <th class="text-center">Đơn vị xử lý tại Cửa khẩu xuất</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa03">
            <tr>
                <td data-bind="text : fiTenHang"></td>
                <td data-bind="text : fiSoluong" class="text-right"></td>
                <td data-bind="text : fiKhoiluong" class="text-right"></td>
                <td data-bind="date : fiNgaytao"></td>
                <td data-bind="text : ptCu"></td>
                <td data-bind="text : soNiemphong"></td>
                <td data-bind="text : ckx"></td>
                <td data-bind="text : dvxl"></td>
            </tr>
            </tbody>
        </table>
        <p class="content">
            2. Thông tin lô hàng xin chuyển cửa khẩu
        </p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa3">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center">Tên hàng</th>
                <th class="text-center">Số lượng (kiện)</th>
                <th class="text-center">Khối lượng (kg)</th>
                <th class="text-center">Phương tiện vận chuyển/ Container cũ</th>
                <th class="text-center">Phương tiện vận chuyển/ Container mới</th>
                <th class="text-center">Số niêm phong kẹp chì</th>
                <th class="text-center">Cửa khẩu xuất</th>
                <th class="text-center">Đơn vị xử lý tại Cửa khẩu xuất</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa03">
            <tr>
                <td data-bind="text : fiTenHang"></td>
                <td data-bind="text : fiSoluong" class="text-right"></td>
                <td data-bind="text : fiKhoiluong" class="text-right"></td>
                <td data-bind="text : ptCu"></td>
                <td data-bind="text : ptMoi"></td>
                <td data-bind="text : soNiemphong"></td>
                <td data-bind="text : ckx"></td>
                <td data-bind="text : dvxl"></td>
            </tr>
            </tbody>
        </table>
        <p class="content">
            Nhằm tạo uy tín với khách hàng, với mong muốn nhanh chóng giải phóng hàng hóa,
            tránh để tồn đọng. Công ty chúng tôi làm đơn này kính đề nghị quý
            Cơ quan <b data-bind="text : fiTenCQ"></b> kiểm tra lại tình trạng của lô hàng, kẹp lại chì kiểm dịch
            và cho phép công ty chúng tôi thay đổi cửa khẩu tái xuất lô hàng trên đến cửa khẩu <b
                data-bind="text: fiTenCuaKhauXuat"></b>.
        </p>
        <p class="content">
            Trong quá trình vận chuyển lô hàng đến địa điểm tái xuất mới, công ty chúng tôi xin
            cam kết bảo quản nguyên trạng hàng hóa đúng quy định. Nếu sai công ty xin chịu hoàn toàn trách nhiệm
            trước pháp luật. Kính mong Quý Cơ quan quan tâm giải quyết.
        </p>
        <p class="content">
            Xin trân trọng cảm ơn!
        </p>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <span>Nơi ký: </span>
                </div>
                <div class="col-md-4">
                    <b data-bind="text : fiNoiKy"></b>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <span>Ngày ký: </span>
                </div>
                <div class="col-md-4">
                    <b data-bind="date : fiNgayky"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <span>Người ký: </span>
                </div>
                <div class="col-md-4">
                    <b data-bind="text : fiNguoiKy"></b>
                </div>
            </div>
        </div>
    </page>
</fieldset>

<template id="xinrutcv-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="xinrutcv-form" id="xinrutcv-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></label></p>
            </div>
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="common.msg.ly_do"/></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-10">
                    <textarea name="noidung" id="noidung" data-bind="value: noidung" require="true"
                              placeholder="<spring:message code="common.msg.ly_do" />"
                              style="width: 90%; height: 150px;resize: none;"
                              maxlength="2000"></textarea>
                </div>
            </div>
        </form>
    </div>
</template>