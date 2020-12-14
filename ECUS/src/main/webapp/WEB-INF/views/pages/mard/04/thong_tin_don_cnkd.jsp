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
        <table class="tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center">
                        <b><span data-bind="text : fiDiadiemky"></span></b>, <span><i
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
            Điện thoại: <b><span data-bind="text : fiDienthoai"></span></b>&nbsp;&nbsp;&nbsp;
            Fax/ Email: <b><span data-bind="text : fiEmail"></span></b>
        </p>
        <p class="content">
            Số Giấy CMND: <b><span data-bind="text : fiCmnd"></span></b>&nbsp;&nbsp;
            Ngày cấp: <b><span data-bind="date : fiNgaycapCmnd"></span></b>&nbsp;&nbsp;
            Nơi cấp: <b><span data-bind="text : fiNoicap"></span></b>
        </p>
        <p class="content">
            Đề nghị quý cơ quan kiểm dịch lô hàng nhập khẩu sau (***):
        </p>

        <p class="content">
            1. Tên hàng:
            <span data-bind=" foreach: lstHanghoa">
                <b data-bind="text: fiTenHang"></b>
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
                <b data-bind="text: fiKhoiluongBaoBi"></b> (<b><span data-bind="text : fiTenDvKlBaobi"></span></b>)
                <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
            </span>
        </p>

        <p class="content">
            4. Số hợp đồng hoặc số chứng từ thanh toán (L/C, TTr...): <b><span data-bind="text : fiSoHopdongCnkd"></span></b>
        </p>

        <p class="content">
            5. Tổ chức, cá nhân xuất khẩu: <b><span data-bind="text : fiTochucCnkd"></span></b><br/>
            Địa chỉ: <b><span data-bind="text : fiDiachiTochucCnkd"></span></b>
        </p>

        <p class="content">
            6. Nước xuất khẩu: <b><span data-bind="text : fiTenNuocxkCnkd"></span></b>
        </p>

        <p class="content">
            7. Cửa khẩu xuất: <b><span data-bind="text : fiTenCuakhauXuatCnkd"></span></b>
        </p>

        <p class="content">
            8. Tổ chức, cá nhân nhập khẩu: <b><span data-bind="text : fiTochucNkCnkd"></span></b><br/>
            Địa chỉ: <b><span data-bind="text : fiDiachiNkCnkd"></span></b>
        </p>

        <p class="content">
            9. Cửa khẩu nhập: <b><span data-bind="text : fiTenCuakhauNhapCnkd"></span></b>
        </p>

        <p class="content">
            10. Phương tiện vận chuyển: <b><span data-bind="text : fiTenPhuongtienCnkd"></span></b>
        </p>

        <p class="content">
            11. Mục đích sử dụng: <b><span data-bind="text : fiMucdichCnkd"></span></b>
        </p>

        <p class="content">
            12. Giấy phép kiểm dịch nhập khẩu (nếu có): <b><span data-bind="text : fiGiayphepCnkd"></span></b>
        </p>

        <p class="content">
            13. Địa điểm kiểm dịch: <b><span data-bind="text : fiDiadiemKiemdichCnkd"></span></b>
        </p>

        <p class="content">
            14. Thời gian kiểm dịch: <b><span data-bind="date : fiNgayKiemdichCnkd"></span></b>
        </p>

        <p class="content">
            15. Số bản Giấy chứng nhận kiểm dịch cần cấp: <b><span data-bind="text : fiSobanCnkd"></span></b>
        </p>

        <p class="content">
            16. Nơi hàng đến: <b><span data-bind="text : fiNoidenCnkd"></span></b>
        </p>


    </table>
</page>
<page size="A4" class="a4-padding">
    <table>
        <p class="content">
            Chúng tôi xin cam kết: Bảo quản nguyên trạng hàng hóa nhập khẩu, đưa về đúng
            địa điểm, đúng thời gian được đăng ký và chỉ đưa hàng hóa ra lưu thông sau khi được quý Cơ quan cấp Giấy
            chứng nhận kiểm dịch (****).
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td class="t-center pb-long">
                    <b>Tổ chức cá nhân đăng ký</b> <br/>
                    <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br/><br/>
                    <b><span data-bind="text : fiChucdanh"></span></b><br/><br/>
                    <b><span data-bind="text : fiNguoiky"></span></b>
                </td>
            </tr>
        </table>

        <p class="text-center t-bold t-italic" style="font-size: 20px;">
            Xác nhận của Cơ quan Kiểm dịch

        </p>
        <p class="content" style="text-align: left">
            Đồng ý đưa hàng hóa về địa điểm: <b data-bind="text : fiDiadiem"></b>
            để làm thủ tục kiểm dịch vào hồi <span data-bind="html: samplingDateStr"></span>
            <br/>Lô hàng chỉ được thông quan sau khi có Giấy chứng nhận kiểm dịch
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td class="t-center pb-long">
                    Vào sổ số <br/>
                    <b><span data-bind="text : fiSoXndon"></span></b>, <span data-bind="html: signDateDepStr"></span><br/>
                    <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br/><br/>
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <b><span data-bind="text : fiNguoikyDon"></span></b>
                </td>
            </tr>
        </table>

        <p class="text-center t-bold">
            Xác nhận của Cơ quan Hải quan
        </p>
        <p class="content text-center"> <i>(trong trường hợp lô hàng không được nhập khẩu)</i></p>
        <p class="content" style="text-align: left">
            Lô hàng không được nhập khẩu vào Việt Nam vì lý do:
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td class="t-center pb-long">
<%--                    <span data-bind="html: quarantineHourStr"></span><br/>--%>
                    Chi cục Hải quan cửa khẩu <br/>
                    <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br>
<%--                    <b><span data-bind="text : fiTencq"></span></b>--%>
                </td>
            </tr>
        </table>
    </table>
</page>


