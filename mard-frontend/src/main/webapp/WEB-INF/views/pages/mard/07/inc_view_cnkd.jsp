<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="modal_viewCNKD" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
     data-bind="with: currentCNKDCert"
>
    <div class="modal-header">
        <b><span>Mã hồ sơ: </span><span data-bind="text: fiNSWFileCode"></span></b>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body container" style="display: flex">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-6">
                    <div style="text-align: center">
                        <h4 style="font-weight: bold" class="uppercase" data-bind="text: (!fiParentDepartmentName() || fiParentDepartmentName() == '') ? 'CỤC THÚ Y' : fiParentDepartmentName()"></h4>
                        <h4 style="font-weight: bold" class="uppercase" data-bind="text: fiDepartmentLisenceName">
                        </h4>

                        <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                    </div>

                </div>
                <div class="col-md-6">
                    <div style="text-align: center">
                        <h4 style="font-weight: bold;">
                            CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        </h4>
                        <h5 style="text-align: center">
                            Độc lập - Tự do - Hạnh phúc
                        </h5>

                        <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                    </div>
                    <div class="text-right" style="font-weight: bold; margin-top: 10px;">
                        <p style="border: 1px solid; margin-right: 15px; display: inline">Mẫu 10 TS</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <h4 style="font-weight: bold">
                        GIẤY CHỨNG NHẬN KIỂM DỊCH ĐỘNG VẬT,SẢN PHẨM ĐỘNG VẬT THUỶ SẢN NHẬP KHẨU
                    </h4>
                    <div style="font-style: italic">
                        Số: <span data-bind="text: fiCertificateNo"></span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style="text-align: justify; margin-top: 20px;">
                    <p>Họ tên chủ hàng (hoặc người đại diện): <span data-bind="text: fiNameOfRegistration"></span></p>
                    <p>Địa chỉ giao dịch: <span data-bind="text: fiAddressOfRegistration"></span></p>
                    <p>Điện thoại: <span data-bind="text: fiPhoneOfRegistration"></span></p>
                    <p>Fax: <span data-bind="text: fiFaxOfRegistration"></span></p>
                    <p>Email: <span data-bind="text: fiEmailOfRegistration"></span></p>
                    <p>Thông tin động vật thủy sản, sản phẩm động vật thủy sản:</p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th rowspan="2">STT</th>
                            <th rowspan="2">Tên thương mại</th>
                            <th rowspan="2">Tên khoa học</th>
                            <th rowspan="2">Kích thước cá thể/Dạng sản phẩm</th>
                            <th rowspan="2">Số lượng/Trọng lượng</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: fiGoodsList">
                        <tr>
                            <td class="text-center" data-bind="text: $index() + 1"></td>
                            <td data-bind="text: fiNameOfGoods"></td>
                            <td data-bind="text: fiNameSicenceOfGoods"></td>
                            <td data-bind="text: fiSizeOrShape"></td>
                            <td><span data-bind="text: fiQuantityOrWeight"></span> (<span data-bind="text: fiQuantityOrWeightUnitName"></span>)</td>
                        </tr>
                        <tr data-bind="visible: ($index() + 1) == $parent.fiGoodsList().length">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td style="font-weight: bold;">Tổng số</td>
                            <td><span data-bind="text: $parent.fiTotalQuantityOrWeight"></span> (<span data-bind="text: $parent.fiTotalUnitName"></span>)</td>
                        </tr>
                        </tbody>
                    </table>
                    <p>Mục đích sử dụng: <span data-bind="text: fiPurposeUse"></span></p>
                    <p>Quy cách đóng gói/bảo quản: <span data-bind="text: fiPackage"></span></p>
                    <p>Số lượng bao gói: <span data-bind="text: fiQuantityPackage"></span></p>
                    <p>Tên tổ chức, cá nhân xuất khẩu: <span data-bind="text: fiNameOfExporter"></span></p>
                    <p>Địa chỉ tổ chức, cá nhân xuất khẩu: <span data-bind="text: fiAddressOfExporter"></span></p>
                    <p>Tên cơ sở sản xuất: <span data-bind="text: fiNameOfProduce"></span></p>
                    <p>Địa chỉ cơ sở sản xuất: <span data-bind="text: fiAddressOfProduce"></span></p>
                    <p>Vùng/nước xuất khẩu: <span data-bind="text: fiOriginationExport"></span></p>
                    <p>Nước quá cảnh: <span data-bind="text: fiOriginationTransit"></span></p>
                    <p>Cửa nhập khẩu vào Việt Nam: <span data-bind="text: fiPortOfDestinationName"></span></p>
                    <p>Thời gian nhập: <span data-bind="date: fiImportDate"></span></p>
                    <p>Nơi chuyển đến: <span data-bind="text: fiLocationOfQuarantine"></span></p>
                    <p>Hồ sơ giấy tờ liên quan:
                        <span data-bind="text: fiDocumentAttch"></span>
                    </p>
                    <div class="text-center" style="width: 100%">
                        <h4 class="uppercase" style="font-weight: bold">CHỨNG NHẬN KIỂM DỊCH</h4>
                    </div>
                    <p>Tôi, kiểm dịch viên động vật ký tên dưới đây chứng nhận số động vật thủy sản/sản phẩm động vật
                        thủy sản trên</p>
                    <p data-bind="visible: fiIncludeCertificateItems().indexOf('1') > -1">1. Có đầy đủ hồ sơ, giấy tờ hợp lệ khi nhập khẩu. <span data-bind="visible: fiNotesForItemNo1(), text: '(' + fiNotesForItemNo1() + ')'"></span></p>
                    <p data-bind="visible: fiIncludeCertificateItems().indexOf('2') > -1">2. Động vật thủy sản không có triệu chứng lâm sàng của bệnh truyền nhiễm/Sản phẩm động vật thủy
                        sản không có biểu hiện biến đổi, mang mầm bệnh; được bao gói, bảo quản đảm bảo yêu cầu vệ sinh
                        thú y theo quy định.</p>
                    <p data-bind="visible: fiIncludeCertificateItems().indexOf('3') > -1">3. Số hàng trên đã được lấy mẫu kiểm tra, xét nghiệm theo kết quả xét nghiệm số:
                        <span data-bind="text: fiTestResultNo"></span>
                        ngày <span data-bind="date: fiDateOfTestResult"></span>
                        của <span data-bind="text: fiDepartmentOfTestResult"></span>
                    </p>
                    <p data-bind="visible: fiIncludeCertificateItems().indexOf('4') > -1">4. Số hàng trên đáp ứng các yêu cầu sau: <span data-bind="text: fiMeetRequirements"></span>
                    </p>
                    <p data-bind="visible: fiIncludeCertificateItems().indexOf('5') > -1">5. Phương tiện vận chuyển, các vật dụng khác có liên quan kèm theo đảm bảo yêu cầu vệ sinh
                        thú y,
                        đã được khử trùng tiêu độc bằng <span data-bind="text: fiNameOfAntiseptic"></span> nồng độ
                        <span data-bind="text: fiConcentrationOfAntiseptic"></span>
                    </p>
                </div>
            </div>
            <div class="row" style="margin-top: 15px;">
                <div class="col-md-6 text-center">
                    <p style="font-style: italic" data-bind="visible: fiExpireDate() != null && fiNoExpireDate() == 1">
                        Giấy có giá trị đến <span data-bind="date: fiExpireDate"></span></p>
                    <p style="font-style: italic"
                       data-bind="visible: fiExpireDate() != null && fiNoExpireDate() == 0"></p>
                    <p style="font-weight: bold">Kiểm dịch viên động vật</p>
                    <p style="font-weight: bold" data-bind="text: fiCreaterName"></p>
                </div>
                <div class="col-md-6 text-center">
                    <p style="font-style: italic">Cấp tại <span data-bind="text: fiSignConfirmAddress"></span> ngày
                        <span data-bind="date: fiSignConfirmDate"></span></p>
                    <p style="font-weight: bold" data-bind="text: fiSignConfirmTitle"></p>
                    <p style="font-weight: bold" data-bind="text: fiSignConfirmName"></p>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <div class="text-center">
            <button class="btn green" data-bind="click: function(){
                $parent.downloadCNKD($data)
            }">
                Tải xuống
            </button>
            <button class="btn" data-dismiss="modal">
                Đóng
            </button>
        </div>
    </div>
</div>
