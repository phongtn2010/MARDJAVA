<%@ page pageEncoding="UTF-8" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p">
            <tr>
                <td>
                    <div class=" t-center">
                        <b><span class="content text-uppercase" data-bind="text: fiCqChuquan"></span></b>
                        <br/>
                        <b><span class="content text-uppercase" data-bind="text: fiTencq"></span></b><br/>
                        ----------------
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br>
                        Độc lập - Tự do - Hạnh phúc<br/>
                        <br/>
                        <br/>
                        ---------------------------
                    </div>
                </td>
            </tr>
            <tr>
                <td class="w28p">
                    <div class=" t-center">
                        <p class="content">Số: <b><span class="content" data-bind="text: fiSochungnhan"></span></b></p>
                    </div>
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
            THÔNG BÁO <br/>
            Kết quả kiểm tra nhà nước về chất lượng hàng hóa nhập khẩu
            <br/>
            ----------------

        </p>
        <p class="content" style="margin-left: 10%">
            <span class="content fa fa-circle" style="font-size:10px"></span>
            <span>Cửa khẩu nhập: <b data-bind="text : fiCkNhap"></b></span>
        </p>
        <p class="content" style="margin-left: 10%">
            <span class="content fa fa-circle" style="font-size:10px"></span>
            <span>Thời gian nhập khẩu: <b data-bind="date : fiNgaynhapTu"></b>-<b data-bind="date : fiNgaynhapDen"></b></span>
        </p>
        <p class="content" style="margin-left: 10%">
            <span class="content fa fa-circle" style="font-size:10px"></span>
            <span>Thuộc lô hàng có các chứng từ sau: </span> <br/>
            <span style="margin-left: 10%">- Hợp đồng số: <b data-bind="text : fiSohopdong"></b></span> <br/>
            <span style="margin-left: 10%">- Danh mục hàng hóa số: <b data-bind="text : fiDanhmuc"></b></span> <br/>
            <span style="margin-left: 10%">- Hóa đơn số: <b data-bind="text : fiHoadon"></b></span> <br/>
            <span style="margin-left: 10%">- Vận đơn số: <b data-bind="text : fiVandon"></b></span> <br/>
            <span style="margin-left: 10%">- Tờ khai hàng nhập khẩu số: <b data-bind="text : fiTokhainhap"></b></span>
            <br/>
            <span style="margin-left: 10%">- Giấy chứng nhận xuất xứ số (C/O): <b
                    data-bind="text : fiGiayXuatxu"></b></span> <br/>
            <span style="margin-left: 10%">- Giấy chứng nhận lưu hành tự do CFS: <b
                    data-bind="text : fiGiayLuuhanh"></b></span> <br/>
        </p>
        <p class="content" style="margin-left: 10%">
            <span class="content fa fa-circle" style="font-size:10px"></span>
            <span>Người khẩu nhập: <b data-bind="text : fiNguoinhap"></b></span>
        </p>
        <p class="content" style="margin-left: 10%">
            <span class="content fa fa-circle" style="font-size:10px"></span>
            <span>Giấy đăng ký kiểm tra số: <b data-bind="text : fiGiaydk"></b></span> <span><span
                data-bind="html: strNgayDangKy"></span></span>
        </p>
        <p class="content" style="margin-left: 10%">
            <span class="content fa fa-circle" style="font-size:10px"></span>
            <span>Căn cứ kiểm tra: </span> <br/>
            <span style="margin-left: 15%">Tiêu chuẩn công bố áp dụng: <b data-bind="text : fiTieuchuan"></b></span>
            <br/>
            <span style="margin-left: 15%">Quy chuẩn kỹ thuật: <b data-bind="text : fiTieuchuanKthuat"></b></span> <br/>
            <span style="margin-left: 15%">Quy định khác: <b data-bind="text : fiQuydinh"></b></span> <br/>
        </p>
        <p class="content">
            <span class="content fa fa-circle" style="font-size:10px"></span>
            <span>Giấy chứng nhận hợp quy hoặc Giấy chứng nhận/giám định chất lượng lô hàng hóa nhập khẩu <br/>
                số: <b data-bind="text : fiGiayChungnhan"></b></span> do tổ chức <span><b
                data-bind="text : fiTochuccap"></b></span>
            cấp ngày <span><b data-bind="date : fiNgaycap"></b></span> tại <span><b
                data-bind="text : fiNoicap"></b></span>
        </p>
        <p class="content text-center" style="word-wrap: break-word;">
            <b> KẾT QUẢ KIỂM TRA</b>
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="xacnhan1">
            <thead>
            <tr>
                <th style="text-align: center;vertical-align: middle;" class="w1p">STT</th>
                <th style="text-align: center;vertical-align: middle;" class="w28p">Tên hàng hóa, nhãn hiệu, kiểu loại
                </th>
                <th style="text-align: center;vertical-align: middle;" class="w10p">Đặc tính kỹ thuật</th>
                <th style="text-align: center;vertical-align: middle;" class="w13p">Xuất xứ, Nhà sản xuất</th>
                <th style="text-align: center;vertical-align: middle;" class="w15p">Khối lượng/ số lượng</th>
                <th style="text-align: center;vertical-align: middle;" class="w15p">Đơn vị tính</th>
                <th style="text-align: center;vertical-align: middle;" class="w20p">Kết quả kiểm tra (Ghi kết quả từ
                    1-5)
                </th>
                <th style="text-align: center;vertical-align: middle;" class="w20p">Ghi chú</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa04">
            <tr>
                <td><span data-bind="text : $index() + 1"></span></td>
                <td>
                    <span class="content" data-bind="text : fiTenHanghoaChitiet"></span>
                </td>
                <td><span data-bind="text : fiDactinh"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;"><span
                        data-bind="text : fiTenCssx"></span></td>
                <td class="text-right">
                    <span data-bind="text : fiKltinh"></span>
                    <span>/</span>
                    <span data-bind="text : fiSoluong"></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;">
                    <span data-bind="text : fiTenDvtinh"></span>
                    <span>/</span>
                    <span data-bind="text : fiTenBaobi"></span>
                </td>
                <td><span data-bind="text : fiKetqua"></span></td>
                <td><span data-bind="text : fiGhichu"></span></td>
            </tr>
            </tbody>
        </table>
        </p>

        <i class="content">
            <span class="content"></span>
            <span>Ghi một trong các nội dung: </span> <br/>

            <p class="content" style="word-wrap: break-word;margin-left: 10%">
                <span>- Đáp ứng yêu cầu chất lượng hàng hóa nhập khẩu</span>
            </p>
            <p class="content" style="word-wrap: break-word;margin-left: 10%">
                <span>- Không đáp ứng yêu cầu chất lượng hàng hóa nhập khẩu thì nêu lý do và các yêu cầu khác nếu có</span>
            </p>
            <p class="content" style="word-wrap: break-word;margin-left: 10%">
                <span>- Hoặc Lô hàng không hoàn thiện đầy đủ hồ sơ</span>
            </p>
            <p class="content" style="word-wrap: break-word;margin-left: 10%">
                <span>- Lô hàng đề nghị đánh giá sự phù hợp lại tại ...</span>
            </p>
            <p class="content" style="word-wrap: break-word;margin-left: 10%">
                <span>- Lô hàng chờ CQKT tiến hành lấy mẫu và thử nghiệm</span>
            </p>
        </i>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="left ">
                    <span><b><i>Nơi nhận:</i></b></span><br/>
                    <span>- Người nhập khẩu;</span>;</span><br/>
                    <span>- Hải quan cửa khẩu;</span>;</span><br/>
                    <span>- Lưu: VT, (<b><span data-bind="text: fiTencq"></span></b>)</span>;</span><br/>
                </td>

                <td class="t-center pb-long">
                    <span>CƠ QUAN KIỂM TRA</span> <br>
                    <i>(ký tên đóng dấu)</i><br/>
                    <br/>
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <b><span id="fiNguoiky" name="fiNguoiky" data-bind="text: fiNguoiky"></span></b>
                </td>
            </tr>
        </table>
    </table>
</page>
