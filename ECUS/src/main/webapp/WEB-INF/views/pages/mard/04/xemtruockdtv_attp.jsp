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
        <p class="text-center t-bold">
            GIẤY ĐĂNG KÝ <br/>
            KIỂM DỊCH THỰC VẬT VÀ KIỂM TRA AN TOÀN THỰC PHẨM HÀNG HÓA CÓ <br/>
            NGUỒN GỐC THỰC VẬT NHẬP KHẨU

        </p>
        <p class="text-center ">
            Kính gửi: <b><span data-bind="text : fiTenCqxl"></span></b>
        </p>

        <p class="content">
            Tên tổ chức, cá nhân đăng ký: <b><span data-bind="text : fiTenTochuc"></span></b>
        </p>
        <p class="content">
            Địa chỉ: <b><span data-bind="text : fiDiachiTochuc"></span></b>
        </p>
        <p class="content">
            Số CMND/căn cước (đối với cá nhân): <b><span data-bind="text : fiCmnd"></span></b>,&nbsp;
            ngày cấp: <b><span data-bind="date : fiNgaycapCmnd"></span></b>,&nbsp;
            nơi cấp: <b><span data-bind="text : fiNoicapCmnd"></span></b>
        </p>
        <p class="content">
            Điện thoại: <b><span data-bind="text : fiSdtTochuc"></span></b>&nbsp;
            Fax/ Email: <b><span data-bind="text : fiFaxEmail"></span></b>
        </p>
        <p class="content">
            Đề nghị quý cơ quan kiểm dịch và kiểm tra an toàn thực phẩm (ATTP) lô hàng nhập khẩu sau:
        </p>

        <p class="content">
            1. Tên, địa chỉ, điện thoại của tổ chức, cá nhân nhập khẩu:
            <b><span data-bind="text : fiTochucNhap"></span></b>,&nbsp;
            <b><span data-bind="text : fiDiachiNhap"></span></b>,&nbsp;
            <b><span data-bind="text : fiSdtTochucNhap"></span></b>
        </p>

        <p class="content">
            2. Tên, địa chỉ, điện thoại của thương nhân chịu trách nhiệm về chất lượng hàng hóa:
            <b><span data-bind="text : fiTochucNhapTrachnhiem"></span></b>,&nbsp;
            <b><span data-bind="text : fiDiachiNhapTrachnhiem"></span></b>,&nbsp;
            <b><span data-bind="text : fiSdtNhapTrachnhiem"></span></b>
        </p>

        <p class="content">
            3. Thông tin chi tiết lô hàng:
        <table class="table table-striped table-bordered table-hover table-checkable order-column"
               id="xacnhan3">
            <thead>
            <tr>
                <th style="text-align: center;vertical-align: middle;" class="w1p">Số TT</th>
                <th style="text-align: center;vertical-align: middle;" class="w32p">Tên mặt hàng</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Tên khoa học</th>
                <th style="text-align: center;vertical-align: middle;" class="w13p">Nhóm sản phẩm</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Tên và địa chỉ nhà sản
                    xuất<br>
                    <i>(Mã số nếu có)</i>
                </th>
                <th style="text-align: center;vertical-align: middle;" class="w18p">Phương thức kiểm tra
                </th>
                <th style="text-align: center;vertical-align: middle;" class="w18p">Số văn bản xác nhận
                    phương thức kiểm
                    tra
                </th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHanghoa">
            <tr>
                <td><span data-bind="text : $index() + 1"></span></td>
                <td>
                    <span class="content" data-bind="text : fiTenchitietHanghoa"></span>
                </td>
                <td><span data-bind="text : fiTenKhoahoc"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;"><span
                        data-bind="text : fiNhomSp"></span></td>
                <td><span data-bind="text : fiTenCosoSx"></span> - <span
                        data-bind="text : fiDiachiCosoSx"></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;"><span
                        data-bind="text : fiPhuongthucKt"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;"><span
                        data-bind="text : fiSoVbPhuongthuc"></span></td>
            </tr>
            </tbody>
        </table>
        </p>

        <p class="content">
            4. Số lượng và loại bao bì:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiSoluong"></b> -
                            <b data-bind="text: fiTenBaobi"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
        </p>

        <p class="content">
            5. Trọng lượng tịnh:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiKhoiluongTinh"></b> - <b data-bind="text: fiTenDvKlTinh"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span><br/>
            Trọng lượng cả bì:
            <span data-bind=" foreach: lstHanghoa">
                            <b data-bind="text: fiKhoiluongBaoBi"></b> - <b data-bind="text: fiTenDvKlBaobi"></b>
                            <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                        </span>
        </p>

        <p class="content">
            6. Số hợp đồng hoặc số chứng từ thanh toán (L/C, TTr):
            <b><span data-bind="text : fiSoHopdong"></span></b>&nbsp;
            Số Bill:
            <b><span data-bind="text : fiSoBill"></span></b>
        </p>

        <p class="content">
            7. Tên, địa chỉ, điện thoại của thương nhân xuất khẩu:
            <b><span data-bind="text : fiTenThuongnhanXk"></span></b>,&nbsp;
            <b><span data-bind="text : fiDiachiThuongnhanXk"></span></b>,&nbsp;
            <b><span data-bind="text : fiSdtThuongnhanXk"></span></b>
        </p>

        <p class="content">
            8. Xuất xứ hàng hóa: <b><span data-bind="text : fiXuatxuHh"></span></b>
        </p>

        <p class="content">
            9. Nước xuất khẩu: <b><span data-bind="text : fiTennuocXk "></span></b>
        </p>

        <p class="content">
            10. Thời gian nhập khẩu dự kiến:
            <b><span data-bind="date : fiThoigianNkTu"></span></b> - <b><span
                data-bind="date : fiThoigianNkDen"></span></b>
        </p>

        <p class="content">
            11. Cửa khẩu đi (cửa khẩu xuất): <b><span data-bind="text : fiTenCuakhauXuat"></span></b>
        </p>

        <p class="content">
            12. Cửa khẩu đến (cửa khẩu nhập): <b><span data-bind="text : fiTenCuakhauNhap"></span></b>
        </p>

        <p class="content">
            13. Thời gian kiểm tra:
            <b><span data-bind="date : fiTgKiemtraTu"></span> - <span
                    data-bind="date : fiTgKiemtraDen"></span></b>
        </p>

        <p class="content">
            14. Địa điểm kiểm tra: <b><span data-bind="text : fiDiadiemKt"></span></b>
        </p>

        <p class="content">
            15. Phương tiện vận chuyển: <b><span data-bind="text : fiTenPhuongtien"></span></b>
        </p>

        <p class="content">
            16. Mục đích sử dụng: <b><span data-bind="text : fiMucdichSd"></span></b>
        </p>

        <p class="content">
            17. Giấy phép kiểm dịch thực vật nhập khẩu (nếu có): <b><span
                data-bind="text : fiGiayphepKd"></span></b>
        </p>

        <p class="content">
            18. Số bản giấy chứng nhận kiểm dịch thực vật và kiểm tra ATTP cần cấp: <b><span
                data-bind="text : fiSoGcn"></span></b>
        </p>

        <p class="content">
            19. Nơi hàng đến: <b><span data-bind="text : fiNoihangDen"></span></b>
        </p>

        <p class="content">
            Chúng tôi xin cam kết: Bảo đảm nguyên trạng hàng hóa nhập khẩu, đưa về đúng địa
            điểm, đúng thời gian được đăng ký và chỉ đưa hàng hóa ra lưu thông/sử dụng sau khi
            được quý cơ quan cấp Giấy chứng nhận kiểm dịch và kiểm tra ATTP theo quy định.
        </p>

        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td class="t-center pb-long">
                    <b>Đại diện tổ chức, cá nhân đăng ký
                    </b> <br/>
                    <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br/><br/>
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <b><span data-bind="text : fiNguoiky"></span></b>
                </td>
            </tr>
        </table>
    </table>
</page>