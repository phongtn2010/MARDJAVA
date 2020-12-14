<%@ page pageEncoding="UTF-8" %>
<%@include file="inc_css.jsp" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td>
                    <div class="content text-center t-bold">
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
        <p class="title" style="margin-bottom: -40px; margin-top: -50px;">
            GIẤY ĐĂNG KÝ
        </p>

        <p class="title" style="padding-bottom: 0px;">
            KIỂM DỊCH THỰC VẬT VÀ KIỂM TRA XÁC NHẬN CHẤT LƯỢNG THỨC ĂN CHĂN NUÔI, THỨC ĂN THỦY SẢN CÓ NGUỒN
            GỐC THỰC VẬT
            NHẬP KHẨU
        </p>
        <div style="width: 50%;float: left ">
            <table style="width: 100%;">
                <tr>
                    <td>
                        <p class="content">Số/No:<b data-bind="text : fiSoDkTochuc"></b></p>
                        <p class="content"><i>(Dành cho tổ chức, cá nhân đăng ký kiểm tra ghi)</i></p>
                    </td>
                </tr>
            </table>
        </div>
        <div style="width: 50%;float: left">
            <table style="width: 100%;">
                <tr>
                    <td>
                        <p class="content">Số/No: </p>
                        <p class="content"><i>(Dành cho cơ quan kiểm tra ghi)</i></p>
                    </td>
                </tr>
            </table>
        </div>
        <br/>
        <p class="content" style="word-wrap: break-word;">
            Kính gửi: <b data-bind="text : fiTenCqxl"></b>
        </p>
        <table style="width: 100%;">
            <tr>
                <td>
                    <p class="content">1. Bên bán hàng/Seller: (hãng, nước):<b
                            data-bind="text : fiHang"></b>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">2. Địa chỉ, Điện thoại, Fax/Address, Phone:
                        <b data-bind="text : fiDiachiBenban"></b>; &nbsp;
                        <b data-bind="text : fiSdtBenban"></b>; &nbsp;
                        <b data-bind="text : fiFaxBenban"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">3. Nơi xuất hàng/Port of departure: <b
                            data-bind="text : fiNoiXuathang"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">4. Bên mua hàng/Buyer: <b data-bind="text : fiBenMuahang"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">Số CMND/căn cước (đối với cá nhân):<b
                            data-bind="text : fiCmndBenmua"></b>, ngày cấp
                        <b data-bind="date : fiNgaycapCmndBenmua"></b>, nơi cấp:<b
                                data-bind="text : fiNoicapCmndBenmua"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">5. Địa chỉ, Điện thoại, Fax/Address, Phone:
                        <b data-bind="text : fiDiachiBenmua"></b>; &nbsp;
                        <b data-bind="text : fiSdtBenmua"></b>; &nbsp;
                        <b data-bind="text : fiFaxBenmua"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">6. Nơi nhận hàng/Port of Destination: <b
                            data-bind="text : fiTencangNoinhan"></b>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">7. Thời gian nhập khẩu dự kiến/Importing date: từ ngày <b
                            data-bind="date : fiThoigianNhaptu"></b> đến ngày <b
                            data-bind="date : fiThoigianNhapden"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content" style="text-align: center"><b>MÔ TẢ HÀNG HÓA/DESCRIPTION OF GOODS
                        (Theo danh
                        sách)</b></p>
                </td>
            </tr>

            <tr>

                <td>
                    <p class="content">8. Tên hàng hóa/Name of goods:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiTenchitietHanghoa"></b>
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">Tên khoa học (nếu có):
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiTenKhoahoc"></b>
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">9. Số lượng, khối lượng/ Quantity, Volume:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiSoluong"></b>
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">Số lượng và loại bao bì:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiSoluong"></b> (<b data-bind="text: fiTenBaobi"></b>)
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">Trọng lượng tịnh:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiKhoiluongTinh"></b> (<b
                                data-bind="text: fiTenDvKlTinh"></b>)
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                        Trọng lượng cả bì:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiKhoiluongBaoBi"></b> (<b
                                data-bind="text: fiTenDvKlBaobi"></b>)
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">10. Xuất xứ hàng hóa:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiNuocXuatxu"></b>
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">11. Mục đích sử dụng:
                        <b data-bind="text: fiMucdichSd"></b>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">12. Mã số công nhận thức ăn chăn nuôi, thủy sản được cấp phép lưu
                        hành tại Việt
                        Nam/ Registration number:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiMasoThucan"></b>
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">13. Giấy phép kiểm dịch thực vật nhập khẩu (nếu có):
                        <b data-bind="text: fiGiayphepKd"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">14. Cơ sở sản xuất/Manufacturer:
                        <span data-bind=" foreach: lstHanghoa">
                                        <b data-bind="text: fiTenCosoSx"></b>
                                        <b data-bind="if: $index() < $parent.lstHanghoa().length -1">; </b>
                                    </span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">15. Địa điểm tập kết hàng/Location of storage:
                        <b data-bind="text: fiDiadiemTapket"></b>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">16. Thời gian đăng ký lấy mẫu kiểm tra/Date for sampling: từ ngày <b
                            data-bind="date: fiNgayDangkyTu"></b> đến ngày <b
                            data-bind="date: fiNgayDangkyDen"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">17. Địa điểm đăng ký lấy mẫu kiểm tra/Location for sampling: <b
                            data-bind="text: fiDiadiemLaymau"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">18. Thông tin người liên hệ/Contactperson: <b
                            data-bind="text: fiNguoiLienhe"></b></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">19. Hợp đồng mua bán/Contract:
                        <span data-bind="html: fiHopdongMuabanText"></span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">20. Hóa đơn mua bán/Invoice:
                        <span data-bind="html: fiHoadonMuabanText"></span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">21. Phiếu đóng gói/Packing list:
                        <span data-bind="html: fiPhieudongText"></span>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content t-bold" style="text-align: center">DÀNH CHO CƠ QUAN KIỂM TRA</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">22. Yêu cầu kiểm tra chi tiêu/Analytical parameters required:
                        <%--                        <b data-bind="text: fiYcKtra"></b>--%>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">23. Chế độ kiểm tra chất lượng:
                        <b data-bind="text : fiLoaiThucanText"></b>
                        (Chọn Loại thức ăn (chăn nuôi hoặc thủy sản), sau đó chọn 4 loại: thường, chặt,
                        miễn, giảm)
                        <b data-bind="text : fiLoaiKtText"></b>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">(Số văn bản xác nhận chế độ kiểm tra chất lượng trường hợp
                        miễn/giảm/chặt)</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">24. Thời gian kiểm tra/Date of testing: (không nhập)
                        <b data-bind="date: fiThoigianKd"></b>
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p class="content">25. Đơn vị thực hiện kiểm tra:
                        <b data-bind="text: fiTenCqxl"></b>
                    </p>
                </td>
            </tr>
        </table>
</page>
<page size="A4" class="a4-padding">
    <table>
        <tr>
            <td>
                <p class="content">Đối với hàng nhập khẩu, Giấy này có giá trị để làm thủ tục hải quan.
                    Sau đó doanh
                    nghiệp phải xuất trình toàn bộ hồ sơ và hàng hóa đã hoàn thành thủ tục hải quan cho
                    cơ quan kiểm
                    tra để được kiểm tra chất lượng theo quy định/
                    This registration is used for customs clearance in term of imported goods. Consigner
                    is required
                    to submit to the inpection body, afterward, all related document of the imported
                    goods</p>
            </td>
        </tr>
        <tr>
            <td>
                <p class="content">Chúng tôi xin cam kết: Bảo đảm nguyên trạng hàng hóa nhập khẩu, đưa
                    về đúng địa
                    điểm, đúng thời gian được đăng ký và chỉ đưa hàng hóa ra lưu thông/
                    sử dụng sau khi được quý cơ quan cấp Giấy chứng nhận kiểm dịch và Giấy xác nhận chất
                    lượng.</p>
            </td>
        </tr>
    </table>
    <table class="tb-content tb-none-border w100p"
           style="margin-top: 50px;width: 100%;table-layout: fixed;margin-bottom: -90px">
        <tr>
            <td class="w35p">
            </td>
            <td class="t-center pb-long">
                <span class="t-bold" data-bind="text : fiNoiky"></span>, <span data-bind="html : strNgayKy"></span><br/>
                <b>Đại diện tổ chức, cá nhân</b><br/>
                <i>(Ký, đóng dấu, ghi rõ họ tên)</i> <br/><br/>
                <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                <b><span data-bind="text : fiNguoiky"></span></b>
            </td>
        </tr>
    </table>
    </table>
</page>