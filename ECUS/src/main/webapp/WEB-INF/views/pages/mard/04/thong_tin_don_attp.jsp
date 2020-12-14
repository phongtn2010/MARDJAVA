<%@ page pageEncoding="UTF-8" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class="center t-center t-bold">
                        <b><span class="content text-uppercase" data-bind="text: fiChuhang"></span></b><br/>
                        --------------
                    </div>
                </td>
                <td>
                    <div class="center t-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br>
                        Độc lập - Tự do - Hạnh phúc
                        <br/>
                        -------------------------
                    </div>
                </td>
            </tr>
        </table>
        <p class="text-center t-bold">
            GIẤY ĐĂNG KÝ KIỂM TRA THỰC PHẨM NHẬP KHẨU
        </p>
        <p class="text-center ">
            Số: <b><span data-bind="text : fiSoDkTochuc"></span></b>
        </p>

        <p class="content">
            1. Tên, địa chỉ, điện thoại của chủ hàng:
            <b><span data-bind="text : fiTenTochuc"></span></b>,
            <b><span data-bind="text : fiDiachiTochuc"></span></b>,
            <b><span data-bind="text : fiDienthoai"></span></b>
        </p>
        <p class="content">
            2. Tên, địa chỉ, điện thoại của thương nhân chịu trách nhiệm về chất lượng hàng hóa:
            <b><span data-bind="text : fiTenTnAttp"></span></b>,
            <b><span data-bind="text : fiDiachiTnAttp"></span></b>,
            <b><span data-bind="text : fiDienthoaiTnAttp"></span></b>
        </p>
        <p class="content">
            3. Tên, địa chỉ, điện thoại của thương nhân xuất khẩu:
            <b><span data-bind="text : fiTenTnxkAttp"></span></b>,
            <b><span data-bind="text : fiDiachiTnxkAttp"></span></b>,
            <b><span data-bind="text : fiDienthoaiTnxkAttp"></span></b>
        </p>
        <p class="content">
            4. Thời gian nhập khẩu dự kiến:
            <b><span data-bind="date : fiNgaytuNKAttp"></span></b> - <b><span data-bind="date : fiNgaydenNKAttp"></span></b>
        </p>
        <p class="content">
            5. Cửa khẩu đi: <b><span data-bind="text : fiTenCuakhauDiAttp"></span></b>
        </p>

        <p class="content">
            6. Cửa khẩu đến:  <b><span data-bind="text : fiTenCuakhauDenAttp"></span></b>
        </p>

        <p class="content">
            7. Thời gian kiểm tra:
            <b><span data-bind="date : fiNgaytuAttp"></span></b> - <b><span data-bind="date : fiNgaydenAttp"></span></b>
        </p>

        <p class="content">
            8. Địa điểm kiểm tra:  <b><span data-bind="text : fiDiadiemKiemtraAttp"></span></b>
        </p>

        <p class="content">
            9. Dự kiến tên cơ quan kiểm tra: <b><span data-bind="text : fiCqKiemtraAttp"></span></b>
        </p>

        <p class="content">
            10. Thông tin chi tiết lô hàng:
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="xacnhan1">
            <thead>
            <tr>
                <th style="text-align: center;vertical-align: middle;" class="w1p">Số TT</th>
                <th style="text-align: center;vertical-align: middle;" class="w32p">Tên mặt hàng</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Nhóm sản phẩm (Theo QCVN hoặc Codex hoặc tiêu chuẩn sản phẩm của nhà sản xuất)</th>
                <th style="text-align: center;vertical-align: middle;" class="w13p">Tên và địa chỉ nhà sản xuất</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Phương thức kiểm tra</th>
                <th style="text-align: center;vertical-align: middle;" class="w18p">Số văn bản xác nhận phương thức kiểm tra*</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHanghoa">
            <tr>
                <td><span data-bind="text : $index() + 1"></span></td>
                <td>
                    <span class="content" data-bind="text : fiTenHang"></span>
                </td>
                <td><span data-bind="text : fiNhomSp"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ><span data-bind="text : fiTenCosoSx"></span> - <span data-bind="text : fiDiachiCosoSx"></span></td>
                <td><span data-bind="text : fiPhuongthucKt"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;"><span data-bind="text : fiSoVbPhuongthuc"></span></td>
            </tr>
            </tbody>
        </table>
        </p>
        <p class="content">
            * Số văn bản xác nhận phương thức kiểm tra là số thông báo của cơ quan có thẩm quyền thông báo mặt hàng được kiểm tra theo phương thức kiểm tra.
        </p>

        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="t-center pb-long ">
                    <span data-bind="html: signDateStr"></span><br/>
                    <span><b>Chủ hàng</b></span><br/>
                    <i>(Ký tên đóng dấu)</i><br/>
                    <br/>
                    <span><b>
                        <span data-bind="text: fiChucdanh"></span><br/><br/>
                        <span data-bind="text: fiNguoiky"></span>
                    </b></span>
                </td>

                <td class="t-center pb-long">
                    Vào sổ số <br/> <b><span data-bind="text : fiSoXndon"></span></b>, <span data-bind="html: signDateDepStr"></span><br/>
                    <b>Cơ quan kiểm tra nhà nước</b> <br>
                    <i>(Ký tên đóng dấu)</i><br/>
                    <br/>
                    <span><b>
                        <span data-bind="text: fiChucvu"></span><br/><br/>
                        <span data-bind="text: fiNguoikyDon"></span>
                    </b></span>
                </td>
            </tr>
        </table>
    </table>
</page>
