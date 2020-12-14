<%@ page pageEncoding="UTF-8" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class=" t-center">
                        <span class="content t-bold" style="white-space: nowrap;text-transform: uppercase;"><b
                                data-bind="text : fiTenCqCaptren"></b></span>
                        <br/>
                        <span class="content t-bold" style="white-space: nowrap;text-transform: uppercase;" data-bind="text : fiTenCqCaptrenEn"></span>
                        <br/>
                        <span class="content t-bold"
                              style="white-space: nowrap;font-size: 14px;text-transform: uppercase;"><b
                                data-bind="text : fiTenCqKdtv"></b></span>
                        <br/>
                        <span class="content t-bold"
                              style="white-space: nowrap;font-size: 14px;text-transform: uppercase;" data-bind="text : fiTenCqKdtvEn"></span>
                    </div>
                </td>
                <td>
                    <div class="center t-center">
                        <b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b><br/>
                        Socialist Republic of Vietnam
                        <br/>
                        <b>Độc lập - Tự do - Hạnh phúc</b><br>
                        <u>Independence - Freedom - Happiness</u>
                    </div>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td class="w35p" style="word-wrap: break-word;">--%>
<%--                    <div class="t-center">--%>
<%--                        <p class="" style="text-align: center">--%>
<%--                            -------------------%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </td>--%>
<%--            </tr>--%>
        </table>
        <br/>
        <p class="content text-center t-bold">
            Lệnh giữ lại và xử lý vật thể thuộc diện kiểm dịch thực vật<br/>
            Unloaded ceasing and treating order of the regulated article
        </p>
        <p class="content" style="word-wrap: break-word;text-align: right;">
            <b>Số: <b data-bind="text : fiSoChungnhan"></b>/KDTV</b>
            <br/>No: <b data-bind="text : fiSoChungnhan"></b>
        </p>
        <p class="content" style="word-wrap: break-word;text-align: center;">
            <b> Kính gửi: <span data-bind="text : fiKinhgui"></span></b>
            <br/>To: <span data-bind="text : fiKinhguiEn"></span></b>
        </p>

        <p class="content" style="word-wrap: break-word;">
            Căn cứ vào Luật Bảo vệ và Kiểm dịch thực vật của nước Cộng hoà Xã hội chủ nghĩa Việt Nam và tình trạng nhiễm
            sinh vật gây hại của vật thể dưới đây:
            <br/>According to the Law on Plant Protection and Quarantine of the Socialist Republic of Vietnam and the pest - infested
            state of the under discribed regulated article:
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;- Tên vật thể bị nhiễm sinh vật gây hại (hàng hoá, kho hoặc phương tiện chuyên chở) (1):
            <span data-bind=" foreach: lstHangHoa04">
                <b data-bind="text: fiTenHanghoaChitiet"></b>
                <b data-bind="if: $index() < $parent.lstHangHoa04().length -1">; </b>
            </span>
            <br/>
                - Name of regulated article (commodity, store or means of conveyance ) (1):
            <span data-bind=" foreach: lstHangHoa04">
                <b data-bind="text: fiTenHanghoaEn"></b>
                <b data-bind="if: $index() < $parent.lstHangHoa04().length -1">; </b>
            </span>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp; - Số lượng:
            <span data-bind=" foreach: lstHangHoa04">
                <b data-bind="text: fiSoluong"></b>(<b data-bind="text: fiTenBaobi"></b>)
                <b data-bind="if: $index() < $parent.lstHangHoa04().length -1">; </b>
            </span>
            <br/>
                - Quantity:
            <span data-bind=" foreach: lstHangHoa04">
                <b data-bind="text: fiSoluong"></b>(<b data-bind="text: fiTenBaobi"></b>)
                <b data-bind="if: $index() < $parent.lstHangHoa04().length -1">; </b>
            </span>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;- Khối lượng:
            <span data-bind=" foreach: lstHangHoa04">
                <b data-bind="text: fiKltinh"></b>(<b data-bind="text: fiTenDvtinh"></b>)
                <b data-bind="if: $index() < $parent.lstHangHoa04().length -1">; </b>
            </span>
            <br/>
                - Weight:
            <span data-bind=" foreach: lstHangHoa04">
                <b data-bind="text: fiKltinh"></b>(<b data-bind="text: fiTenDvtinh"></b>)
                <b data-bind="if: $index() < $parent.lstHangHoa04().length -1">; </b>
            </span>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;- Tên và địa chỉ chủ hàng : <b data-bind="text : fiTenChuhang"></b> - <b
                data-bind="text : fiDcChuhang"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;(Người xuất khẩu, thủ kho hoặc chủ phương tiện chuyên chở) (2)
        </p>
        <p class="content" style="word-wrap: break-word;">
            Name and adress of Owners of regulated  : <b data-bind="text : fiTenChuhangEn"></b> - <b
                data-bind="text : fiDcChuhangEn"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;(Exporter, store-keeper or owner of means of conveyance) (2):
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;- Tên và địa chỉ người nhận : <b data-bind="text : fiTenNgnhan"></b> - <b
                data-bind="text : fiDcNgnhan"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Name and address of consignee : <b data-bind="text : fiTenNgnhanEn"></b> - <b
                data-bind="text : fiDcNgnhanEn"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;- Phương tiện chuyên chở <b data-bind="text : fiTenPtien"></b> Quốc tịch: <b
                data-bind="text : fiTenQuoctich"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Means of conveyance <b data-bind="text : fiTenPtienEn"></b> Nationality: <b
                data-bind="text : fiTenQuoctichEn"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;- Bị nhiễm sinh vật gây hại thuộc đối tượng kiểm dịch thực vật của nước Cộng hoà Xã hội
            chủ nghĩa Việt
            Nam, đối tượng phải kiểm soát hoặc sinh vật gây hại lạ, cụ thể là: <b data-bind="text : fiDichhai"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Infested by regulated pests of the Socialist Republic of Vietnam and other dangerous pests, concretely as follow(s): <b data-bind="text : fiDichhai"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            &nbsp;&nbsp;&nbsp;- Nay quyết định biện pháp xử lý lô vật thể đó như sau:
        </p>
        <p class="content" style="word-wrap: break-word;">
            Treatment measures must be applied to the regulated article as follow:
        </p>
        <table>
            <p class="content" style="word-wrap: break-word;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span data-bind="if: ko.unwrap(fumigation) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
                <span data-bind="if: ko.unwrap(fumigation) ===0"><i class="fa fa-square-o"
                                                                    aria-hidden="true"></i></span>
                Xông hơi khử trùng (Fumigation):
            </p>
            <p class="content" style="word-wrap: break-word;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thuốc khử trùng và nồng độ (Fumigant and concentration): <b
                    data-bind="text : ko.unwrap(fumigation) === 1 ? fumigant : ''  "></b>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Địa điểm khử trùng (Place of fumigation): <b
                    data-bind="text : ko.unwrap(fumigation) === 1 ? place : ''  "></b>
            </p>
            <p class="content" style="word-wrap: break-word;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thời gian:
                <br/> Duration of exposure
                <b
                    data-bind="text : ko.unwrap(fumigation) === 1 ? fumigationDateFrom : ''  "></b>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quy định sau khử trùng (Regulations after fumigation): <b
                    data-bind="text : ko.unwrap(fumigation) === 1 ? regulations : ''  "></b>
            </p>
            <p class="content" style="word-wrap: break-word;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span data-bind="if: ko.unwrap(reexPort) ===1"><i class="fa fa-check-square-o"
                                                                  aria-hidden="true"></i></span>
                <span data-bind="if: ko.unwrap(reexPort) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                Tái xuất (Re-export):
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thời gian: từ ngày <b><span
                    data-bind="text:  ko.unwrap(reexPort) === 1 ? reexportDateFrom : '' "></span></b> – đến ngày <b><span
                    data-bind="text:  ko.unwrap(reexPort) === 1 ? reexportDateTo : '' "></span></b>
            </p>
            <p class="content" style="word-wrap: break-word;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span data-bind="if: ko.unwrap(destroy) ===1"><i class="fa fa-check-square-o"
                                                                 aria-hidden="true"></i></span>
                <span data-bind="if: ko.unwrap(destroy) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
                Tiêu hủy (Destroy):
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thời gian: từ ngày <b><span
                    data-bind="text:  ko.unwrap(destroy) === 1 ? destroyDateFrom : '' "></span></b> – đến ngày <b><span
                    data-bind="text:  ko.unwrap(destroy) === 1 ? destroyDateTo : '' "></span></b>
            <p class="content" style="word-wrap: break-word;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span data-bind="if: ko.unwrap(otherMeasures) ===1"><i class="fa fa-check-square-o"
                                                                       aria-hidden="true"></i></span>
                <span data-bind="if: ko.unwrap(otherMeasures) ===0"><i class="fa fa-square-o"
                                                                       aria-hidden="true"></i></span>
                Biện pháp khác (Other):
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Thời gian: từ ngày <b><span
                data-bind="text:  ko.unwrap(otherMeasures) === 1 ? otherMeasuresFrom : '' "></span></b> – đến ngày <b><span
                data-bind="text:  ko.unwrap(otherMeasures) === 1 ? otherMeasuresTo : '' "></span></b>
            </p>
        </table>
        <table class="tb-content tb-none-border w100p" style="margin-top: 50px;width: 100%;table-layout: fixed;">
            <tr>
                <td>
                    <p class="content" style="word-wrap: break-word;">
                        Nơi nhận : <b data-bind="text: fiNoinhan"></b>
                    </p>
                    <p class="content" style="word-wrap: break-word;">
                        To : <b data-bind="text: fiNoinhan"></b>
                    </p>
                </td>
                <td class="t-center pb-long">
                    Ngày: <b data-bind="date: fiNgayky"></b><br/>
                    Date: <b data-bind="date: fiNgayky"></b><br/>
                    <b>Thủ trưởng cơ quan kiểm dịch thực vật</b><br/>
                    <b>Chief of Plant Quarantine Service</b><br/>
                    (Ký tên, đóng dấu)<br/>
                    (Name, signature, stamp)<br/>
                </td>
            </tr>
            <tr>
                <td>

                </td>
                <td class="t-center pb-long">
                    <span class="t-bold" data-bind="text : fiNguoiky"></span>
                </td>
            </tr>
        </table>
    </table>
</page>


