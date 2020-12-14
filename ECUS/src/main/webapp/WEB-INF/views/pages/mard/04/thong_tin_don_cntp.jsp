<%@ page pageEncoding="UTF-8" %>
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
            nơi cấp: <b><span data-bind="text : fiNoicap"></span></b>
        </p>
        <p class="content">
            Điện thoại: <b><span data-bind="text : fiDienthoai"></span></b>&nbsp;
            Fax/ Email: <b><span data-bind="text : fiEmail"></span></b>
        </p>
        <p class="content">
            Đề nghị quý cơ quan kiểm dịch và kiểm tra an toàn thực phẩm (ATTP) lô hàng nhập khẩu sau:
        </p>

        <p class="content">
            1. Tên, địa chỉ, điện thoại của tổ chức, cá nhân nhập khẩu:
            <b><span data-bind="text : fiTenNkCntp"></span></b>,&nbsp;
            <b><span data-bind="text : fiDiachiNkCntp"></span></b>,&nbsp;
            <b><span data-bind="text : fiDienthoaiNkCntp"></span></b>
        </p>

        <p class="content">
            2. Tên, địa chỉ, điện thoại của thương nhân chịu trách nhiệm về chất lượng hàng hóa:
            <b><span data-bind="text : fiTenTnCntp"></span></b>,&nbsp;
            <b><span data-bind="text : fiDiachiTnCntp"></span></b>,&nbsp;
            <b><span data-bind="text : fiDienthoaiTnCntp"></span></b>
        </p>

        <p class="content">
            3. Thông tin chi tiết lô hàng:
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="xacnhan1">
            <thead>
            <tr>
                <th style="text-align: center;vertical-align: middle;" class="w1p">Số TT</th>
                <th style="text-align: center;vertical-align: middle;" class="w32p">Tên mặt hàng</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Tên khoa học</th>
                <th style="text-align: center;vertical-align: middle;" class="w13p">Nhóm sản phẩm</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Tên và địa chỉ nhà sản xuất<br>
                    <i>(Mã số nếu có)</i>
                </th>
                <th style="text-align: center;vertical-align: middle;" class="w18p">Phương thức kiểm tra</th>
                <th style="text-align: center;vertical-align: middle;" class="w18p">Số văn bản xác nhận phương thức kiểm
                    tra
                </th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHanghoa">
            <tr>
                <td><span data-bind="text : $index() + 1"></span></td>
                <td>
                    <span class="content" data-bind="text : fiTenHang"></span>
                </td>
                <td><span data-bind="text : fiTenKhoahoc"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;"><span
                        data-bind="text : fiNhomSp"></span></td>
                <td><span data-bind="text : fiTenCosoSx"></span> - <span data-bind="text : fiDiachiCosoSx"></span>
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
            <b><span data-bind="text : fiSoHopdongCntp"></span></b>&nbsp;
            Số Bill:
            <b><span data-bind="text : fiSobillCntp"></span></b>
        </p>

        <p class="content">
            7. Tên, địa chỉ, điện thoại của thương nhân xuất khẩu:
            <b><span data-bind="text : fiTenXkCntp"></span></b>,&nbsp;
            <b><span data-bind="text : fiDiachiXkCntp"></span></b>,&nbsp;
            <b><span data-bind="text : fiDienthoaiXkCntp"></span></b>
        </p>

        <p class="content">
            8. Xuất xứ hàng hóa: <b><span data-bind="text : fiXuatxuCntp"></span></b>
        </p>

        <p class="content">
            9. Nước xuất khẩu: <b><span data-bind="text : fiTenNuocCntp "></span></b>
        </p>

        <p class="content">
            10. Thời gian nhập khẩu dự kiến:
            <b><span data-bind="date : fiNgaytuCntp"></span></b> - <b><span data-bind="date : fiNgaydenCntp"></span></b>
        </p>

        <p class="content">
            11. Cửa khẩu đi (cửa khẩu xuất): <b><span data-bind="text : fiTenCkxuatCntp"></span></b>
        </p>

        <p class="content">
            12. Cửa khẩu đến (cửa khẩu nhập): <b><span data-bind="text : fiTenCknhapCntp"></span></b>
        </p>

        <p class="content">
            13. Thời gian kiểm tra:
            <b><span data-bind="date : fiNgaykiemTuCntp"></span> - <span
                    data-bind="date : fiNgaykiemDenCntp"></span></b>
        </p>

        <p class="content">
            14. Địa điểm kiểm tra: <b><span data-bind="text : fiDiadiemCntp"></span></b>
        </p>

        <p class="content">
            15. Phương tiện vận chuyển: <b><span data-bind="text : fiTenPtienCntp"></span></b>
        </p>

        <p class="content">
            16. Mục đích sử dụng: <b><span data-bind="text : fiMucdichCntp"></span></b>
        </p>

        <p class="content">
            17. Giấy phép kiểm dịch thực vật nhập khẩu (nếu có): <b><span
                data-bind="text : fiGpKiemdichCntp"></span></b>
        </p>

        <p class="content">
            18. Số bản giấy chứng nhận kiểm dịch thực vật và kiểm tra ATTP cần cấp: <b><span
                data-bind="text : fiSobanCntp"></span></b>
        </p>


    </table>
</page>

<page size="A4" class="a4-padding">
    <table>
        <p class="content">
            19. Nơi hàng đến: <b><span data-bind="text : fiNoidenCntp"></span></b>
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
                    <b><span data-bind="text : fiChucdanh"></span></b><br/><br/>
                    <b><span data-bind="text : fiNguoiky"></span></b>
                </td>
            </tr>
        </table>

        <p class="text-center t-bold">
            Xác nhận của Cơ quan Kiểm dịch thực vật và kiểm tra an toàn thực phẩm
        </p>
        <p class="content" style="text-align: left">
            Đồng ý đưa hàng hóa về địa điểm: <b data-bind="text : fiDiadiem"></b><br/>
            để làm thủ tục kiểm dịch thực vật và kiểm tra ATTP (đối với phương thức kiểm tra chặt) vào hồi
            <span data-bind="html: samplingDateStr"></span>
            <br/>Lô hàng chỉ được thông quan sau khi có Giấy chứng nhận kiểm dịch
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td class="t-center pb-long">
                    Vào sổ số <br/> <b><span data-bind="text : fiSoXndon"></span></b>, <span
                        data-bind="html: signDateStr"></span><br/>
                    <b>Đại diện cơ quan kiểm tra</b><br/>
                    <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br/><br/>
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <b><span data-bind="text : fiNguoikyDon"></span></b>
                </td>
            </tr>
        </table>

        <p class="text-center t-bold">
            Xác nhận của Cơ quan Hải quan
        </p>
        <p class="content text-center"><i>(trong trường hợp lô hàng không được nhập khẩu)</i></p>
        <p class="content" style="text-align: left">
            Lô hàng không được nhập khẩu vào Việt Nam vì lý do: <br/>
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td class="t-center pb-long">
                    <%--                    <span data-bind="html: quarantineHourStr"></span><br/>--%>
                    <b>Hải quan cửa khẩu</b> <br/>
                    <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br>
                </td>
            </tr>
        </table>
    </table>
</page>
