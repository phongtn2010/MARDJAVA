<%@ page pageEncoding="UTF-8" %>
<%@include file="inc_css.jsp" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td>
                    <div class="text-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br/>
                        Độc lập - Tự do - Hạnh phúc
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="" style="text-align: center">
                        -----------------
                    </p>
                </td>
            </tr>
        </table>
        <table class="tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td style="vertical-align: text-top;">
                    <div class="text-right">
                        <b><span data-bind="text : fiNoiky"></span></b>, <span><i
                            data-bind="html: strNgayKy"></i></span>
                    </div>
                </td>
            </tr>
        </table>
        <p class="content text-center t-bold">
            GIẤY ĐĂNG KÝ KIỂM DỊCH THỰC VẬT (*)
        </p>
        <p class="content text-center ">
            Kính gửi: <b><span data-bind="text : fiTenCqxl"></span>(**)</b>
        </p>

        <p class="content">
            Tên tổ chức, cá nhân đăng ký: <b><span data-bind="text : fiTenTochuc"></span></b>
        </p>
        <p class="content">
            Địa chỉ: <b><span data-bind="text : fiDiachiTochuc"></span></b>
        </p>
        <p class="content">
            Điện thoại: <b><span data-bind="text : fiSdtTochuc"></span></b>&nbsp;&nbsp;&nbsp;
            Fax/ Email: <b><span data-bind="text : fiFaxEmail"></span></b>
        </p>
        <p class="content">
            Số Giấy CMND: <b><span data-bind="text : fiCmnd"></span></b>&nbsp;&nbsp;
            Ngày cấp: <b><span data-bind="date : fiNgaycapCmnd"></span></b>&nbsp;&nbsp;
            Nơi cấp: <b><span data-bind="text : fiNoicapCmnd"></span></b>
        </p>
        <p class="content">
            Đề nghị quý cơ quan kiểm dịch lô hàng nhập khẩu sau (***):
        </p>

        <p class="content">
            1. Tên hàng:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiTenchitietHanghoa"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
            <br/>
            Tên khoa học:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiTenKhoahoc"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
            <br/>
            Cơ sở sản xuất:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiTenCosoSx"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
            <br/>
            Mã số (nếu có):
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiMasoNhasanxuat"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
            <br/>
            Địa chỉ:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiDiachiCosoSx"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
            <br/>
        </p>

        <p class="content">
            2. Số lượng và loại bao bì:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiSoluong"></b> (<b><span data-bind="text : fiTenBaobi"></span></b>)
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
        </p>

        <p class="content">
            3. Khối lượng tịnh:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiKhoiluongTinh"></b> (<b><span data-bind="text : fiTenDvKlTinh"></span></b>)
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
            Khối lượng cả bì:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiKhoiluongBaoBi"></b> (<b><span
                    data-bind="text : fiTenDvKlBaobi"></span></b>)
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
        </p>

        <p class="content">
            4. Số hợp đồng hoặc số chứng từ thanh toán (L/C, TTr...): <b><span
                data-bind="text : fiSoHopdong"></span></b>
        </p>

        <p class="content">
            5. Tổ chức, cá nhân xuất khẩu: <b><span data-bind="text : fiTochucXk"></span></b><br/>
            Địa chỉ: <b><span data-bind="text : fiDiachiXk"></span></b>
        </p>

        <p class="content">
            6. Nước xuất khẩu: <b><span data-bind="text : fiTennuocXk"></span></b>
        </p>

        <p class="content">
            7. Cửa khẩu xuất: <b><span data-bind="text : fiTenCuakhauXuat"></span></b>
        </p>

        <p class="content">
            8. Tổ chức, cá nhân nhập khẩu: <b><span data-bind="text : fiTochucNhap"></span></b><br/>
            Địa chỉ: <b><span data-bind="text : fiDiachiNhap"></span></b>
        </p>

        <p class="content">
            9. Cửa khẩu nhập: <b><span data-bind="text : fiTenCuakhauNhap"></span></b>
        </p>

        <p class="content">
            10. Phương tiện vận chuyển: <b><span data-bind="text : fiTenPhuongtien"></span></b>
        </p>

        <p class="content">
            11. Mục đích sử dụng: <b><span data-bind="text : fiMucdichSd"></span></b>
        </p>

        <p class="content">
            12. Giấy phép kiểm dịch nhập khẩu (nếu có): <b><span
                data-bind="text : fiGiayphepKd"></span></b>
        </p>

        <p class="content">
            13. Địa điểm kiểm dịch: <b><span data-bind="text : fiDiadiemKd"></span></b>
        </p>

        <p class="content">
            14. Thời gian kiểm dịch: <b><span data-bind="date : fiThoigianKd"></span></b>
        </p>

        <p class="content">
            15. Số bản Giấy chứng nhận kiểm dịch cần cấp: <b><span
                data-bind="text : fiSoGcn"></span></b>
        </p>

        <p class="content">
            16. Nơi hàng đến: <b><span data-bind="text : fiNoihangDen"></span></b>
        </p>

        <p class="content">
            Chúng tôi xin cam kết: Bảo quản nguyên trạng hàng hóa nhập khẩu, đưa về đúng
            địa điểm, đúng thời gian được đăng ký và chỉ đưa hàng hóa ra lưu thông sau khi được quý Cơ quan
            cấp Giấy
            chứng nhận kiểm dịch (****).
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td class="t-center pb-long">
                    <b>Tổ chức cá nhân đăng ký</b> <br/>
                    <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br/><br/>
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <b><span data-bind="text : fiNguoiky"></span></b>
                </td>
            </tr>
        </table>

    </table>
</page>