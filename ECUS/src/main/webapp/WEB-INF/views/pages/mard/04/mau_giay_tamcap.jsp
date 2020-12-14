<%@ page pageEncoding="UTF-8" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class="center t-center t-bold">
                        <span class="content t-bold" style="white-space: nowrap;text-transform: uppercase;"><b
                                data-bind="text : departmentSuperiorName"></b></span>
                        <br/><br/>
                        <span class="content t-bold"
                              style="white-space: nowrap;font-size: 14px;text-transform: uppercase;"><b
                                data-bind="text : departmentLisenceName"></b></span><br/>
                        -----------------
                    </div>
                </td>
                <td>
                    <div class="right text-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br/>
                        Độc lập - Tự do - Hạnh phúc<br>
                        -----------------
                    </div>
                </td>
            </tr>
        </table>
        <table class="tb-none-border w100p">
            <tr>
                <td class="w35p">
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right text-center">
                        <b><span data-bind="text: signConfirmAddress"></span></b>, <span><i
                            data-bind="html: ngayKyStr"></i></span>
                    </div>
                </td>
            </tr>
        </table>
        <br/>
        <p class="content text-center t-bold">
            GIẤY TẠM CẤP KẾT QUẢ KIỂM DỊCH THỰC VẬT
        </p>
        <p class="content" style="word-wrap: break-word;text-align: right;">
            Số:<b data-bind="text : dispatchNo"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Cấp cho: <b data-bind="text : importer"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Địa chỉ: <b data-bind="text : importerAddress"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Tên vật thể thuộc diện kiểm dịch thực vật:
            <span data-bind=" foreach: lstHangHoa">
                <b data-bind="text: fiTenHanghoaChitiet"></b>:
                <b data-bind="text: fiSoluong"></b>(<b data-bind="text: fiTenDvi"></b>),
                <b data-bind="text: fiKhoiluong"></b>(<b data-bind="text: fiTenKhoiluong"></b>)
                <b data-bind="if: $index() < $parent.lstHangHoa().length -1">; </b>
            </span>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Số lượng: <b data-bind="text: totalQuantity"></b>
            </span></b> (<b data-bind="text : totalQuantityByChar"></b>)
        </p>
        <p class="content" style="word-wrap: break-word;">
            Khối lượng: <b data-bind="text : totalGrossWeight"></b> (<b data-bind="text : totalGrossWeightByChar"></b>)
        </p>
        <p class="content" style="word-wrap: break-word;">
            Địa điểm để hàng: <b data-bind="text : locationOfStorage"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Ngày kiểm tra: <b data-bind="date : inspectionDate"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Kết quả kiểm dịch thực vật (KDTV): <b data-bind="text : quarantineResults"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            <b>1. Vật thể nhập khẩu:</b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(undiscovered) ===1"><i class="fa fa-check-square-o"
                                                                  aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(undiscovered) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Chưa phát hiện đối tượng kiểm dịch thực vật, đối tượng phải kiểm soát của Việt Nam hoặc sinh vật gây hại lạ.
            Lô vật thể được phép bốc dỡ và vận chuyển đến <span data-bind="if: ko.unwrap(undiscovered) ===1"><b data-bind="text: undiscoveredContent"></b></span>;
            Trong quá trình bốc dỡ và vận chuyển, nếu phát hiện đối tượng kiểm dịch thực vật,
            đối tượng phải kiểm soát của Việt Nam hoặc sinh vật gây hại lạ thì chủ vật thể phải thực hiện ngay các biện
            pháp xử lý theo quy định về KDTV;
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(checkOutside) ===1"><i class="fa fa-check-square-o"
                                                                  aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(checkOutside) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Kiểm tra bên ngoài lô hàng, chưa phát hiện đối tượng kiểm dịch thực vật, đối tượng phải kiểm soát của Việt
            Nam hoặc sinh vật gây hại lạ.
            Lô vật thể được phép vận chuyển đến <span data-bind="if: ko.unwrap(checkOutside) ===1"><b data-bind="text: checkOutsideContent"></b></span>;<br/>
            Chủ vật thể phải báo ngay cho Chi cục KDTV vùng <b data-bind="text: notifyDepartmentName"></b>
            để hoàn tất thủ tục KDTV;
        </p>
        <p class="content" style="word-wrap: break-word;">
            <b>2. Vật thể xuất khẩu:</b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            □ Lô vật thể đã được kiểm dịch và đủ điều kiện xuất khẩu;
        </p>
        <p class="content" style="word-wrap: break-word;">
            □ Được phép vận chuyển lên tàu.
        </p>
        <p class="content" style="word-wrap: break-word;">
            Chủ vật thể phải nộp Giấy chứng nhận KDTV chính thức cho cơ quan Hải quan
            để thay thế cho Giấy tạm cấp này ngay sau khi được cơ quan KDTV cấp.
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span>Có giá trị từ ngày <b data-bind="date : effectiveDateFrom"></b> đến ngày <b
                    data-bind="date : effectiveDateTo"></b></span>
        </p>
        <table class="tb-content tb-none-border w100p" style="margin-top: 50px;width: 100%;table-layout: fixed;">
            <td class="t-center pb-long" style="padding-left: 600px;padding-bottom: 0px;word-wrap: break-word;">
                THỦ TRƯỞNG CƠ QUAN<br/>
                (Ký tên, đóng dấu)<br/><br/>
            </td>
            </tr>
            <tr>
                <td class="t-center pb-long" style="padding-left: 600px;word-wrap: break-word;">
<%--                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>--%>
                    <span class="t-bold" data-bind="text :signConfirmName "></span>
                </td>
            </tr>
        </table>
        <%--         <p style="word-wrap: break-word;">Link giấy phép: <a target="_blank" data-bind="text: linkFile, attr: { href: linkFile}" ></a></p>--%>
</page>


