<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class=" t-center t-bold">
                        <span class="content t-bold" style="white-space: nowrap;text-transform: uppercase;" ><b data-bind="text : fiCqCaptren"></b></span>
                        <br>
                        <span class="content t-bold" style="white-space: nowrap;font-size: 14px;text-transform: uppercase;" ><b data-bind="text : fiCqKdtv"></b></span>
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
            <tr>
                <td class="w35p" style="word-wrap: break-word;">
                   
                </td>
                <td style="vertical-align: text-top;word-wrap: break-word;">
                    <div style="text-align: right">
                        <b data-bind="text : fiNoiky"></b>, <span data-bind="html: signConfirmDateStr"></span>
                    </div>
                </td>

            </tr>
        </table>
        <br/>
        <p class="content text-center t-bold">
            GIẤY CHỨNG NHẬN KIỂM DỊCH THỰC VẬT
            NHẬP KHẨU, QUÁ CẢNH VÀ VẬN CHUYỂN NỘI ĐỊA
        </p>
        <p class="content" style="word-wrap: break-word;text-align: right;">
            Số:<b data-bind="text : fiSochungnhan"></b>/KDTV
        </p>
        <p class="content" style="word-wrap: break-word;">
            Cấp cho: <b data-bind="text : fiTenChuhang"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Địa chỉ: <b data-bind="text : fiDcCuahang"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Điện thoại: <b data-bind="text : fiDienthoai"></b>
        </p>
        <p class="title" style=" margin-top: -50px; text-align: left">
            CĂN CỨ CẤP GIẤY:
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(licenseOfPhytosanitary) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(licenseOfPhytosanitary) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Giấy phép kiểm dịch thực vật (KDTV) nhập khẩu số <b><span data-bind="text:  ko.unwrap(licenseOfPhytosanitary) === 1 ? licenseOfPhytosanitaryNo : '' "></span></b> ngày <b data-bind="date : fiNgayky"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(registrationCertificate) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(registrationCertificate) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Giấy đăng ký KDTV;	
            <span data-bind="if: ko.unwrap(certificatePhytosanitary) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(certificatePhytosanitary) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Giấy chứng nhận KDTV của nước xuất khẩu;
        </p>

        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(laboratoryAnalysis) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(laboratoryAnalysis) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Kết quả kiểm tra, phân tích giám định trong phòng thí nghiệm;	
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(processedWoodExport) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(processedWoodExport) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Dấu xử lý vật liệu đóng gói bằng gỗ của nước xuất khẩu;
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(otherBase) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(otherBase) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Căn cứ khác:  <span data-bind="if: ko.unwrap(otherBase) ===1"><b data-bind="text: otherBaseContent"></b></span>
        </p>
        <p class="title" style=" margin-top: -50px; text-align: left">
            CHỨNG NHẬN:
        </p>
        <p class="content" style="word-wrap: break-word;">
            Những vật thể thuộc diện KDTV (vật thể) sau đây: <b data-bind="text: fiTenHanghoaText"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Số lượng: 
            <span>
                <b data-bind="text: fiSoluongText"></b>
            </span>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Khối lượng: <span><b data-bind="text : fiKltinhText"></b>
        </span>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Phương tiện vận chuyển: <b data-bind="text: fiTenPtien"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Nơi đi: <b data-bind="text: fiNoidi"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            Nơi đến: <b data-bind="text: fiNoiden"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(undiscovered) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(undiscovered) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Chưa phát hiện đối tượng kiểm dịch thực vật, đối tượng phải kiểm soát của Việt Nam; 		
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(objectsPhytosanitary) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(objectsPhytosanitary) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Phát hiện loài <span><b data-bind="text: objectsPhytosanitaryContent"></b></span> là đối tượng kiểm dịch thực vật, đối tượng phải kiểm soát của Việt Nam.
            Lô vật thể đã được xử lý đảm bảo tiêu diệt triệt để sinh vật gây hại trên; 		
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(detectingOrganisms) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(detectingOrganisms) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Phát hiện sinh vật gây hại lạ. Lô vật thể đã được xử lý đảm bảo tiêu diệt triệt để sinh vật gây hại lạ trên;		
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(locationAllow) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(locationAllow) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô vật thể trên được phép chở tới: <span><b data-bind="text: locationAllowContent"></b></span>
        </p>
        <p class="title" style=" margin-top: -50px; text-align: left">
            QUY ĐỊNH MỘT SỐ ĐIỀU KIỆN TRONG KHI GỬI VÀ NHẬN HÀNG:
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(allowPlanting) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(allowPlanting) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô vật thể được phép gieo trồng, sử dụng tại địa điểm quy định trên;		
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(allowTransit) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(allowTransit) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô vật thể được phép quá cảnh lãnh thổ Việt Nam
            theo lộ trình trên và phải tuân thủ mọi quy định về KDTV quá cảnh của Việt Nam;		
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(notify) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(notify) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Báo ngay cho cơ quan KDTV/Bảo vệ thực vật nơi gần nhất khi phát hiện đối tượng kiểm dịch thực vật,
            đối tượng phải kiểm soát của Việt Nam (trong quá trình bốc dỡ, vận chuyển, sử dụng, gieo trồng,...);		
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(otherRule) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(otherRule) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Điều kiện khác: <span><b data-bind="text: ko.unwrap(otherRule) ===1 ? otherRegulation : ''"></b></span>
        </p>
        <table class="tb-content tb-none-border w100p" style="margin-top: 50px;width: 100%;table-layout: fixed;">
            <tr>
                <td class="t-center pb-long" style="padding-left: 600px;padding-bottom: 0px;word-wrap: break-word;">

                </td>
            </tr>
            <td class="t-center pb-long" style="padding-left: 600px;padding-bottom: 0px;word-wrap: break-word;"><br/>
                THỦ TRƯỞNG CƠ QUAN <br>
                (Ký, đóng dấu, ghi rõ họ tên)<br/>                
            </td>
            </tr>
            <tr>
                <td class="t-center pb-long" style="padding-left: 600px;word-wrap: break-word;">
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <span class="t-bold" data-bind="text : fiNguoiky"></span>
                </td>
            </tr>
        </table>
        <p class="content" style="word-wrap: break-word;">
            Ghi chú: Chủ vật thể không được chở lô vật thể đến địa điểm khác nếu không được phép của cơ quan KDTV. 		
        </p>
    </table>
</page>


