<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class=" t-center t-bold">
                        <span class="content t-bold" style="white-space: nowrap" >BỘ THÔNG TIN VÀ TRUYỀN THÔNG</span>
                        <span class="content t-bold" style="white-space: nowrap;font-size: 14px" >CỤC XUẤT BẢN, IN VÀ PHÁT HÀNH</span>
                    </div>
                </td>
                <td style="vertical-align: text-top;word-wrap: break-word;">
                    <div class="right t-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br/>
                        Độc lập - Tự do - Hạnh phúc
                    </div>
                </td>
            </tr>
            <tr>
                <td class="w35p" style="word-wrap: break-word;">
                    <div class="t-center">
                        <p class="content">Số <b class="content" data-bind="text: fiSoGiayPhep"></b></p>
                    </div>
                </td>
                <td style="vertical-align: text-top;word-wrap: break-word;">
                    <div style="text-align: right">
                        <b data-bind="text : fiNoiCapGp"></b>, <span data-bind="html: strNgayCapPhep"></span>
                    </div>
                </td>
            </tr>
        </table>
        <p class="title" style="margin-bottom: 0px;">
            GIẤY PHÉP NHẬP KHẨU THIẾT BỊ IN
        </p>
        <p class="title" style="margin-top: -60px;margin-bottom: -40px;">
            _____________________
        </p>
        <p class="title"  style="padding-bottom: 0px;" >
            CỤC TRƯỞNG CỤC XUẤT BẢN, IN VÀ PHÁT HÀNH
        </p>


        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;Căn cứ Nghị định số 60/2014/NĐ-CP ngày 19/06/2014; Nghị định số 25/2018/NĐ-CP ngày 28/02/2018 về sửa đổi, bổ sung một số điều của Nghị định số 60/2014/NĐ-CP của Chính phủ quy định về hoạt động in;
        </p>
        <p class="content" style="word-wrap: break-word;">	
            &nbsp;&nbsp;&nbsp;Căn cứ Quyết định số 2479/QĐ-BTTTT ngày 29/12/2017 của Bộ trưởng Bộ Thông tin và Truyền thông về việc Quy định chức năng, nhiệm vụ, quyền hạn và cơ cấu tổ chức của Cục Xuất bản, In và Phát hành;
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;Xét đơn đề nghị cấp giấy phép nhập khẩu thiết bị in số:  <b data-bind="text : fiSoDonDeNghi"></b>
            <span data-bind="html : strNgayDeNghi"></span> của <b data-bind="text : fiTenToChuc"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
        <p style="text-align: center"><b>CHO PHÉP:</b></p>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;1. Tên tổ chức, cá nhân đề nghị cấp phép nhập khẩu: <b data-bind="text : fiTenToChuc"></b>
            &nbsp;Địa chỉ: <b data-bind="text : fiDiaChiTc"></b> được làm thủ tục nhập khẩu thiết bị sau: (theo danh mục đính kèm)
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;2. Mục đích nhập khẩu: <b data-bind="text : fiMdNhapKhau"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;3. Địa chỉ đặt máy lần đầu: <b data-bind="text : fiDiaChiDatMay"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;4. Thiết bị in chỉ được sử dụng để sản xuất, kinh doanh khi có đủ các điều kiện về hoạt động in và máy photocopy màu, máy in có chức năng photocopy màu phải thực hiện đăng ký sử dụng máy trước khi hoạt động theo quy định của pháp luật về hoạt động in.
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;Giấy phép này có giá trị đến khi thực hiện xong thủ tục thông quan.
        </p>
        <table class="tb-content tb-none-border w100p" style="margin-top: 50px;width: 100%;table-layout: fixed;">
            <tr>
                <td class="t-center pb-long" style="padding-left: 600px;padding-bottom: 0px;word-wrap: break-word;">
                    <span class="t-bold" data-bind="text : fiChucDanh"></span><br/>
                    (Ký, đóng dấu, ghi rõ họ tên)<br/>                
                </td>
            </tr>
            <tr>
                <td class="t-center pb-long" style="padding-left: 600px;word-wrap: break-word;">
                    <span class="t-bold" data-bind="text : fiTenNguoiKy"></span>
                </td>
            </tr>
        </table>
        <p style="word-wrap: break-word;">Link giấy phép: <a target="_blank" data-bind="text: strLinkGP, attr: { href: fiLinkGiayphep}" ></a></p>
    </table>
</page>


