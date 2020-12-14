<%@ page pageEncoding="UTF-8" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p">
            <tr>
                <td>
                    <div class=" t-center">
                        <b><span class="content text-uppercase" data-bind="text: fiTenCqxl"></span></b><br/>
                        <b><span class="content text-uppercase" data-bind="text: fiTenTochuc"></span></b>
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class=" text-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br>
                        Độc lập - Tự do - Hạnh phúc
                    </div>
                </td>
            </tr>
            <tr>
                <td class="w35p">
                    <div class=" t-center" >
                        --------------
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class=" text-center">
                        -------------------------
                    </div>
                </td>
            </tr>
            <tr>
                <td class="w35p">
                    <div class=" t-center" >
                        Số <b><span class="content text-uppercase" data-bind="text: fiSoXndon"></span></b><br/>
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center" style="margin-right: 17%; ">
                        <b><span data-bind="text: fiDiadiemky"></span>, <span data-bind="html: strNgayKy"></span></b><br/>
                    </div>
                </td>
            </tr>
        </table>
        <p class="content text-center t-bold">
            PHIẾU TIẾP NHẬN HỒ SƠ<br/>
            ĐĂNG KÝ KIỂM TRA CHẤT LƯỢNG HÀNG HÓA NHẬP KHẨU
        </p>


        <p class="content">

        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="xacnhan1">
            <thead>
            <tr>
                <th style="text-align: center;vertical-align: middle;" class="w1p">STT</th>
                <th style="text-align: center;vertical-align: middle;" class="w32p">HẠNG MỤC KIỂM TRA</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Có/Không (C/K)</th>
                <th style="text-align: center;vertical-align: middle;" class="w13p">Ghi chú</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>
                    Giấy đăng ký kiểm tra nhà nước về chất lượng hàng hóa nhập khẩu.
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiGiayDki) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiGiayDki) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>2</td>
                <td>
                    Hợp đồng (Contract) (bản photocopy).
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiHopdong) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiHopdong) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>3</td>
                <td>
                    Danh mục hàng hóa (Packing list) kèm theo hợp đồng (bản photocopy).
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiDanhmuc) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiDanhmuc) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>4</td>
                <td>
                    Bản sao có chứng thực giấy chứng chỉ chất lượng
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiBansao) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiBansao) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    4.1. Giấy chứng nhận hợp quy
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiGiayHopquy) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiGiayHopquy) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    4.2. Giấy giám định chất lượng lô hàng
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiGiayGiamdinh) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiGiayGiamdinh) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    4.3. Giấy chứng nhận chất lượng lô hàng
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiGiayChungnhan) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiGiayChungnhan) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    4.4. Giấy chứng nhận hệ thống quản lý chất lượng
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiGiayHethong) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiGiayHethong) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>5</td>
                <td>
                    Hóa đơn (Invoice)
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiHoadon) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiHoadon) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>6</td>
                <td>
                    Vận đơn (Bill of Lading)
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiVandon) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiVandon) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>7</td>
                <td>
                    Tờ khai hàng hóa nhập khẩu
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiTokhai) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiTokhai) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>8</td>
                <td>
                    Giấy chứng nhận xuất xứ (C/O-Certificate of Origin)
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiGiayXuatxu) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiGiayXuatxu) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>9</td>
                <td>
                    Ảnh hoặc bản mô tả hàng hóa
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiMotaHanghoa) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiMotaHanghoa) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>10</td>
                <td>
                    Giấy Chứng nhận lưu hành tự do CFS
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiGiayCfs) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiGiayCfs) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>11</td>
                <td>
                    Mẫu nhãn hàng nhập khẩu đã được gắn dấu hợp quy
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiMaunhan) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiMaunhan) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            <tr>
                <td>11</td>
                <td>
                    Nhãn phụ (nếu nhãn chính chưa đủ nội dung theo quy định).
                </td>
                <td style="text-align: center">
                    <span data-bind="if: ko.unwrap(fiNhanphu) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                    <span data-bind="if: ko.unwrap(fiNhanphu) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                </td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ></td>
            </tr>
            </tbody>
        </table>
        </p>
        <p class="text-center">
            <b>KẾT LUẬN</b>
        </p>

        <p class="content">
            <span data-bind="if: ko.unwrap(fiHosoDaydu) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(fiHosoDaydu) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Hồ sơ đầy đủ về số lượng: Tiếp nhận hồ sơ để kiểm tra các bước tiếp theo.
        </p>

        <p class="content">
            <span data-bind="if: ko.unwrap(fiHosoKdaydu) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(fiHosoKdaydu) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Hồ sơ không đầy đủ về số lượng: tiếp nhận hồ sơ nhưng cần bổ sung các mục: <span><b data-bind="text: ko.unwrap(fiHosoKdaydu) ===1 ? fiTiepnhan : ''"></b></span>
            trong thời gian 25 ngày. Sau khi hồ sơ đầy đủ thì kiểm tra các bước tiếp theo theo quy định.
        </p>


        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="t-center pb-long ">
                    <span><b>Người nộp hồ sơ </b></span><br/>
                    <br/>
                    <span><b>
                        <span data-bind="text: fiChucdanh"></span><br/><br/>
                        <span data-bind="text: fiNguoiky"></span>
                    </b></span>
                </td>

                <td class="t-center pb-long">
                    <span><b>Người kiểm tra </b></span><br/>
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


