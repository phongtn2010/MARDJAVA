<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class=" t-center t-bold">
                        <span class="content t-bold" style="white-space: nowrap;font-size: 14px;text-transform: uppercase;" ><b data-bind="text : fiTenCqktra"></b></span>
                        <br>
                        <span class="content t-bold" style="white-space: nowrap;text-transform: uppercase;" ><b data-bind="text : fiTencq"></b></span>
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
            GIẤY CHỨNG NHẬN
            <br/>
            KIỂM DỊCH THỰC VẬT VÀ KIỂM TRA AN TOÀN THỰC PHẨM HÀNG HÓA
            <br/>
            CÓ NGUỒN GỐC THỰC VẬT NHẬP KHẨU

        </p>
        <p class="content text-center">
            Số:<b data-bind="text : fiSochungnhan"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            1. Tên, địa chỉ, điện thoại của tổ chức, cá nhân nhập khẩu:
            <b data-bind="text : fiTenTochuc"></b>, <b data-bind="text : fiDcTochuc"></b>, <b data-bind="text : fiDthoaiTochuc"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            2. Tên, địa chỉ, điện thoại của thương nhân chịu trách nhiệm về chất lượng hàng hóa:
            <b data-bind="text : fiTenNk"></b>,
            <b data-bind="text : fiDchiNk"></b>,
            <b data-bind="text : fiDthoaiNk"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            3. Tên, địa chỉ, điện thoại của thương nhân xuất khẩu:
            <b data-bind="text : fiTenXk"></b>,
            <b data-bind="text : fiDchiXk"></b>,
            <b data-bind="text : fiDthoaiXk"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            4. Số tờ khai hải quan (nếu có):
            <b data-bind="text : fiSotokhai"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            5. Nước xuất khẩu:
            <b data-bind="text : fiNuocXk"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            6. Tên, địa chỉ nhà sản xuất:
            <b data-bind="text : fiTenSx"></b>,
            <b data-bind="text : fiDchiSx"></b>
            Mã số (nếu có): <b data-bind="text : fiMaSx"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            7. Cửa khẩu đi (cửa khẩu xuất):
            <b data-bind="text : fiCkDi"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            8. Cửa khẩu đến (cửa khẩu nhập):
            <b data-bind="text : fiCkDen"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            9. Thời gian kiểm tra:
            <b data-bind="date : fiNgaytu"></b> -
            <b data-bind="date : fiNgayden"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            10. Địa điểm kiểm tra:
            <b data-bind="text : fiDchiKtra"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            11. Phương thức kiểm tra an toàn thực phẩm (ATTP):
            <b data-bind="text : fiPthucKtra"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            12. Thông tin chi tiết lô hàng:
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="xacnhan1">
            <thead>
            <tr>
                <th style="text-align: center;vertical-align: middle;" class="w1p">TT</th>
                <th style="text-align: center;vertical-align: middle;" class="w32p">Tên mặt hàng</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Tên khoa học</th>
                <th style="text-align: center;vertical-align: middle;" class="w13p">Nhóm sản phẩm</th>
                <th style="text-align: center;vertical-align: middle;" class="w5p">Số lượng/ trọng lượng</th>
                <th style="text-align: center;vertical-align: middle;" class="w18p">Phương tiện vận chuyển</th>
                <th style="text-align: center;vertical-align: middle;" class="w26p">Nơi đi</th>
                <th style="text-align: center;vertical-align: middle;" class="w26p">Nơi đến</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa04">
            <tr>
                <td><span data-bind="text : $index() + 1"></span></td>
                <td>
                    <span class="content" data-bind="text : fiTenHanghoaChitiet"></span>
                </td>
                <td><span data-bind="text : fiTenKhoahoc"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;" ><span data-bind="text : fiNhomsp"></span></td>
                <td><span data-bind="text : fiSoluong"></span> /<span data-bind="text : fiKhoiluong"></span></td>
                <td style="text-align: left;word-wrap: break-word;max-width: 50px !important;"><span data-bind="text : fiPtien"></span></td>
                <td><span data-bind="text : fiNoidi"></span></td>
                <td><span data-bind="text : fiNoiden"></span></td>
            </tr>
            </tbody>
        </table>
        </p>

        <p class="title text-center" style=" margin-top: -50px; text-align: center">
            CHỨNG NHẬN:
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(undiscovered) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(undiscovered) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô hàng trên đã được kiểm tra và chưa phát hiện đối tượng kiểm dịch thực vật, đối tượng phải kiểm soát của Việt Nam hoặc sinh vật gây hại lạ.
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(objectsPhytosanitary) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(objectsPhytosanitary) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô hàng đã được kiểm tra và phát hiện loài <span data-bind="text : objectsPhytosanitaryContent"></span> là đối tượng kiểm dịch thực vật,
            đối tượng phải kiểm soát của Việt Nam. Lô hàng đã được xử lý đảm bảo tiêu diệt triệt để sinh vật gây hại trên.
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(detectingOrganisms) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(detectingOrganisms) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô hàng trên đã được kiểm tra và phát hiện sinh vật gây hại lạ. Lô hàng đã được xử lý đảm bảo tiêu diệt triệt để sinh vật gây hại.
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(allowSafety) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(allowSafety) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô hàng trên đáp ứng yêu cầu về an toàn thực phẩm (ATTP).
        </p>

        <p class="title" style=" margin-top: -50px; text-align: center">
            QUY ĐỊNH MỘT SỐ ĐIỀU KIỆN TRONG KHI GỬI VÀ NHẬN HÀNG:
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(allowUse) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(allowUse) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Lô hàng được phép sử dụng tại địa điểm quy định trên;
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(notify) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(notify) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Báo ngay cho cơ quan kiểm dịch thực vật (KDTV)/bảo vệ thực vật (BVTV) nơi gần nhất khi phát hiện đối tượng KDTV,
            đối tượng phải kiểm soát của Việt Nam (trong quá trình bốc dỡ, vận chuyển, sử dụng...)
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(otherRule) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(otherRule) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Điều kiện khác: <span><b data-bind="text: ko.unwrap(otherRule) ===1 ? otherRegulation : ''"></b></span>
        </p>


        <p class="title" style=" margin-top: -50px; text-align: left; font-size: 15px">
            Giấy này được cấp căn cứ vào:
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(licenseOfPhytosanitary) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(licenseOfPhytosanitary) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Giấy phép kiểm dịch thực vật (KDTV) nhập khẩu số <b><span data-bind="text:  ko.unwrap(licenseOfPhytosanitary) === 1 ? licenseOfPhytosanitaryNo : '' "></span></b> ngày <b data-bind="date : licenseDate"></b>
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(registrationCertificate) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(registrationCertificate) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Giấy đăng ký kiểm dịch thực vật và kiểm tra ATTP hàng hóa có nguồn gốc thực vật nhập khẩu;
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(certificatePhytosanitary) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(certificatePhytosanitary) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Giấy chứng nhận KDTV của nước xuất khẩu;
        </p>

        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(laboratoryAnalysis) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(laboratoryAnalysis) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Kết quả kiểm tra, phân tích giám định trong phòng thí nghiệm KDTV;
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(foodSafetyAnalysis) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(foodSafetyAnalysis) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Kết quả phân tích chỉ tiêu ATTP của tổ chức đánh giá sự phù hợp được chỉ định (trường hợp kiểm tra chặt);
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(processedWoodExport) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(processedWoodExport) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Dấu xử lý vật liệu đóng gói của nước xuất khẩu;
        </p>
        <p class="content" style="word-wrap: break-word;">
            <span data-bind="if: ko.unwrap(otherBase) ===1"><i class="fa fa-check-square-o" aria-hidden="true"></i></span>
            <span data-bind="if: ko.unwrap(otherBase) ===0"><i class="fa fa-square-o" aria-hidden="true"></i></span>
            Căn cứ khác:  <span data-bind="if: ko.unwrap(otherBase) ===1"><b data-bind="text: otherBaseContent"></b></span>	
        </p>

        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="left ">
                    <span><b>Nơi nhận:</b></span><br/>
                    <span>- Chủ hàng:.......;</span><br/>
                    <span>- Hải quan cửa khẩu:.......;</span><br/>
                    <span>- Lưu hồ sơ kiểm tra;</span><br/>
                </td>

                <td class="t-center pb-long">
                    <span data-bind="html: signConfirmDateStr"></span><br/>
                    THỦ TRƯỞNG CƠ QUAN <br>
                    (Ký, đóng dấu, ghi rõ họ tên)<br/>
                    <br/>
                    <b><span data-bind="text : fiChucvu"></span></b><br/><br/>
                    <b><span id="fiNguoiky" name="fiNguoiky" data-bind="text: fiNguoiky"></span></b>
                </td>
            </tr>
        </table>


        <p class="content" style="word-wrap: break-word;">
            Ghi chú: Nghiêm cấm chở hàng đến địa điểm khác nếu không được phép của cơ quan kiểm dịch thực vật và kiểm tra ATTP.
        </p>
    </table>
</page>


