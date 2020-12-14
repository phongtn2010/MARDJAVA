<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class=" t-center t-bold">
                        Cơ quan kiểm tra nhà nước
                        <br/>
                        <span class="content t-bold" style="white-space: nowrap;font-size: 14px;text-transform: uppercase;" ><b data-bind="text : fiTencq"></b></span>
                    </div>
                </td>
                <td>
                    <div class="center t-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br/>
                        Độc lập - Tự do - Hạnh phúc


                    </div>
                </td>
            </tr>
            <tr>
                <td class="w35p" style="word-wrap: break-word;">
                    <div class="t-center">
                        <p class="" style="text-align: center" >
                            -----------------
                        </p>
                    </div>
                </td>
                <td class="w35p" style="word-wrap: break-word;">
                    <div class="t-center">
                        <p class="" style="text-align: center" >
                            -----------------
                        </p>
                    </div>
                </td>

            </tr>
        </table>
        <p class="content text-center t-bold">
            THÔNG BÁO KẾT QUẢ XÁC NHẬN THỰC PHẨM ĐẠT/
            KHÔNG ĐẠT YÊU CẦU NHẬP KHẨU
        </p>
        <p class="content text-center">
            Số:<b data-bind="text : fiSochungnhan"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            1. Tên, địa chỉ, điện thoại của chủ hàng:
            <b data-bind="text : fiTenTochuc"></b>,
            <b data-bind="text : fiDcTochuc"></b>,
            <b data-bind="text : fiDthoaiTochuc"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            2. Tên, địa chỉ, điện thoại của thương nhân chịu trách nhiệm về chất lượng hàng hóa:
            <b data-bind="text : fiTentnTochuc"></b>,
            <b data-bind="text : fiDctnTochuc"></b>,
            <b data-bind="text : fiDthoaitnTochuc"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            3. Tên, địa chỉ, điện thoại của thương nhân xuất khẩu:
            <b data-bind="text : fiTenXk"></b>,
            <b data-bind="text : fiDcXk"></b>,
            <b data-bind="text : fiDthoaiXk"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            4. Số tờ khai hải quan:
            <b data-bind="text : fiSotokhai"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            5. Cửa khẩu đi:
            <b data-bind="text : fiCuakhauDi"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            6. Cửa khẩu đến:
            <b data-bind="text : fiCuakhauDen"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            7. Thời gian kiểm tra:
            <b data-bind="date : fiNgaytu"></b> -
            <b data-bind="date : fiNgayden"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            8. Địa điểm kiểm tra:
            <b data-bind="text : fiDiadiem"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            9. Thông tin chi tiết lô hàng:
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="xacnhan1">
            <thead>
            <tr>
                <th style="text-align: center;vertical-align: middle;" class="w1p">TT</th>
                <th style="text-align: center;vertical-align: middle;" class="w32p">Tên mặt hàng</th>
                <th style="text-align: center;vertical-align: middle;" class="w13p">Nhóm sản phẩm</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Tên và địa chỉ nhà sản xuất</th>
                <th style="text-align: center;vertical-align: middle;" class="w18p">Phương thức kiểm tra</th>
                <th style="text-align: center;vertical-align: middle;" class="w26p">Xác nhận đạt/không đạt yêu cầu</th>
                <th style="text-align: center;vertical-align: middle;" class="w26p">Lý do không đạt</th>
                <th style="text-align: center;vertical-align: middle;" class="w26p">Các biện pháp xử lý mặt hàng không đạt yêu cầu</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa04">
            <tr>
                <td><span data-bind="text : $index() + 1"></span></td>
                <td>
                    <span class="content" data-bind="text : fiTenHanghoaChitiet"></span>
                </td>
                <td><span data-bind="text : fiNhomsp"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ><span data-bind="text : fiTenSx"></span>-<span data-bind="text : fiDiachiSx"></span></td>
                <td><span data-bind="text : fiPthucKtra"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;">
                    <span data-bind="if : fiKetqua == 0"> Không đạt</span>
                    <span data-bind="if : fiKetqua == 1"> Đạt</span>
                </td>
                <td><span data-bind="text : fiLydo"></span></td>
                <td><span data-bind="text : fiBienphap"></span></td>
            </tr>
            </tbody>
        </table>
        </p>


        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="left ">
                    <span><b>Nơi nhận:</b></span><br/>
                    <span>- Chủ hàng:  <b><span data-bind="text : fiTenTochuc"></span></b>;</span><br/>
                    <span>- Hải quan cửa khẩu: <b><span data-bind="text : fiCuakhauDi"></span></b>;</span><br/>
                </td>

                <td class="t-center pb-long">
                    <span data-bind="html: signConfirmDateStr"></span><br/>
                    CƠ QUAN KIỂM TRA NHÀ NƯỚC<br/>
                    (Ký tên đóng dấu)<br/>
                    <br/>
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <b><span id="fiNguoiky" name="fiNguoiky" data-bind="text: fiNguoiky"></span></b>
                </td>
            </tr>
        </table>

    </table>
</page>


