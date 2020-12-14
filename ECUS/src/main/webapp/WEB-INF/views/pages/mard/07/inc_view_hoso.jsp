<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="modal_viewHoso" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
     data-bind="with: selectedHoSo"
>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body container" style="display: flex">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h4 style="font-weight: bold;">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </h4>
                    <h5 style="font-weight: bold">
                        Độc lập - Tự do - Hạnh phúc
                    </h5>

                    <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                    <div class="text-right" style="padding-top: 10px">
                        <h5 class="text-border" style="font-weight: bold">Mẫu 03TS</h5>
                    </div>
                    <div style="padding-top: 15px;"></div>
                    <p><span style="font-weight: bold"></span> <span style="font-weight: bold"></span></p>
                    <h4 style="font-weight: bold">ĐƠN KHAI BÁO KIỂM DỊCH ĐỘNG VẬT, SẢN PHẨM ĐỘNG VẬT THỦY SẢN XUẤT KHẨU,
                        NHẬP KHẨU</h4>
                    <p>Số: <span style="font-weight: bold" data-bind="text: fiNSWFileCode"></span></p>
                    <p>Kính gửi: <span style="font-weight: bold" data-bind="text: fiDepartmentofQuarantineName"></span>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style="text-align: justify">
                    <p class="content">Tên tổ chức, cá nhân khai báo: <span style="font-weight: bold"
                                                            data-bind="text: fiNameOfRegistration"></span></p>
                    <p class="content">Địa chỉ <span style="font-weight: bold" data-bind="text: fiAddressOfRegistration"></span></p>
                    <p class="content">Điện thoại: <span style="font-weight: bold" data-bind="text: fiPhoneOfRegistration"></span> Fax:
                        <span style="font-weight: bold" data-bind="text: fiFaxOfRegistration"></span> Email: <span
                                style="font-weight: bold" data-bind="text: fiEmailOfRegistration"></span></p>
                    <p class="content">Số CMND: <span style="font-weight: bold" data-bind="text: fiIdentityNumber"></span> Ngày cấp:
                        <span style="font-weight: bold" data-bind="date: fiIdentityIssueDate"></span> Tại: <span
                                style="font-weight: bold" data-bind="text: fiIdentityIssueAddress"></span></p>
                </div>
            </div>
            <div class="row">

                <div class="col-md-12">
                    <p class="content">Đề nghị quý Cơ quan kiểm dịch<a
                            class="nsw-require-field">*</a></p>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-10 form-group">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="1">Xuất khẩu</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="2">Kho ngoại quan</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="3">Tạm xuất tái nhập</label>
                </div>


                <div class="col-md-2"></div>
                <div class="col-md-10 form-group">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled data-bind="checked: fiSelectedRequestOptions" value="4">Nhập khẩu</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="5">Quá cảnh</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled data-bind="checked: fiSelectedRequestOptions" value="6">Nhập
                        khẩu làm nguyên liệu chế biến xuất khẩu</label>
                </div>

                <div class="col-md-2"></div>
                <div class="col-md-10 form-group">
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="7">Tạm nhập tái xuất</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="8">Chuyển khẩu</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled value="9">Hàng mẫu</label>
                    <label class="radio-inline request-checkbox">
                        <input type="checkbox" disabled data-bind="checked: fiSelectedRequestOptions" value="10"><span class="content">Khác: <span style="font-weight: bold"
                                                                                                                                                data-bind="text: fiOptionOther"></span></span></label>
                </div>
            </div>
            <div class="row">
<%--                <div class="col-md-12">--%>
<%--                    <p class="content">Khác: <span style="font-weight: bold"--%>
<%--                                                                            data-bind="text: fiOptionOther"></span></p>--%>
<%--                </div>--%>
            </div>
            <div class="row">
                <div class="col-md-12" style="text-align: justify">
                    <p class="content">Thông tin hàng hóa:</p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <td style="width: 5%">STT</td>
                            <td>Tên thương mại</td>
                            <td>Tên khoa học</td>
                            <td>Kích cỡ cá thể/Dạng sản phẩm</td>
                            <td>Số lượng/Trọng lượng</td>
                            <td>Đơn vị tính</td>
                            <td>Nước xuất xứ</td>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: fiGoodsList">
                        <tr>
                            <td style="text-align: center" data-bind="text: $index() + 1"></td>
                            <td data-bind="text: fiNameOfGoods"></td>
                            <td data-bind="text: fiNameSicenceOfGoods"></td>
                            <td data-bind="text: fiSizeOrShape"></td>
                            <td style="text-align: left" data-bind="text: fiQuantityOrWeight"></td>
                            <td data-bind="text: fiQuantityOrWeightUnitName"></td>
                            <td data-bind="text: fiOriginationName"></td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="content">Nơi sản xuất: <span style="font-weight: bold" data-bind="text: fiProcessingName"></span>/<span style="font-weight: bold" data-bind="text: fiProcessingAddress"></span>
                    </p>
                    <p class="content">Loại bao bì, quy cách đóng gói: <span style="font-weight: bold"
                                                             data-bind="text: fiPackage"></span></p>
                    <p class="content">Số hợp đồng hoặc số chứng từ thanh toán: <span style="font-weight: bold"
                                                                      data-bind="text: fiContractsNo"></span></p>
                    <p class="content">Tổ chức, cá nhân xuất khẩu/nhập khẩu: <span style="font-weight: bold"
                                                                   data-bind="text: fiExporter"></span>/<span style="font-weight: bold"
                              data-bind="text: fiExporterCountryAddress"></span>
                    </p>
                    <p class="content">Nước xuất khẩu/nhập khẩu: <span style="font-weight: bold"
                                                       data-bind="text: fiOriginationImport"></span></p>
                    <p class="content">Nước quá cảnh (nếu có): <span style="font-weight: bold"
                                                     data-bind="text: fiOriginationTransit"></span></p>
                    <p class="content">Cửa khẩu xuất: <span style="font-weight: bold" data-bind="text: fiPortOfDepartureName "></span>
                    </p>
                    <p class="content">Cửa khẩu nhập: <span style="font-weight: bold" data-bind="text: fiPortOfDestinationName"></span>
                    </p>
                    <p class="content">Phương tiện vận chuyển: <span style="font-weight: bold"
                                                     data-bind="text: fiTransportType "></span></p>
                    <p class="content">Mục đích sử dụng: <span style="font-weight: bold" data-bind="text: fiPurposeUse "></span></p>
                    <p class="content">Văn bản chấp thuận kiểm dịch của Cục Thú y: Số <span style="font-weight: bold"
                                                                            data-bind="text: fiLicenseNo"></span> ngày
                        <span style="font-weight: bold" data-bind="date: fiLicenseDate "></span></p>
                    <p class="content">Địa điểm cách ly kiểm dịch: <span style="font-weight: bold"
                                                         data-bind="text: fiLocationOfQuarantine"></span></p>
                    <p class="content">Địa điểm nuôi trồng (nếu có): <span style="font-weight: bold"
                                                           data-bind="text: fiLocationOfGrow"></span></p>
                    <p class="content">Thời gian kiểm dịch: <span style="font-weight: bold"
                                                  data-bind="date: fiDateOfQuarantineFrom"></span> đến <span
                            style="font-weight: bold" data-bind="date: fiDateOfQuarantineTo "></span></p>
                    <p class="content">Địa điểm giám sát (nếu có): <span style="font-weight: bold"
                                                         data-bind="text: fiLocationOfMonitor"></span></p>
                    <p class="content">Thời gian giám sát: <span style="font-weight: bold" data-bind="date: fiDateOfMonitorFrom"></span>
                        đến <span style="font-weight: bold" data-bind="date: fiDateOfMonitorTo"></span></p>
                    <p class="content">Số bản Giấy chứng nhận kiểm dịch cần cấp: <span style="font-weight: bold"
                                                                       data-bind="text: fiQuantityLicense"></span></p>

                    <div
                            data-bind="visible: fiTransshipmentGoods() == 1"
                    >
                        <p class="content">Đối với hàng nhập khẩu trực tiếp từ tàu đánh bắt hải sản nước ngoài khai báo thêm các thông
                            tin
                            sau:</p>
                        <p class="content">- Mã số đăng ký của cơ sở nhập khẩu: <b data-bind="text: fiBusinessNumberofRegistration"></b></p>
                        <p class="content">- Tên người đại diện: <b data-bind="text: fiNameOfRepresentRegistration"></b></p>
                        <p class="content">- Khối lượng: <b data-bind="text: fiTotalOfGoodsWeight"></b></p>
                        <p class="content">- Tên tàu đánh bắt: <b data-bind="text: fiNameOfFishingShip"></b></p>
                        <p class="content">- Số đăng ký tàu đánh bắt: <b data-bind="text: fiCodeOfFishingShip"></b></p>
                        <p class="content">- Quốc gia treo cờ của tàu đánh bắt: <b data-bind="text: fiOriginationOfFishingShip"></b></p>
                        <p class="content">- Tên tàu vận chuyển: <b data-bind="text: fiNameOfTransferShip"></b></p>
                        <p class="content">- Số đăng ký tàu vận chuyển: <b data-bind="text: fiCodeOfTransferShip"></b></p>
                        <p class="content">- Quốc gia treo cờ của tàu vận chuyển: <b data-bind="text: fiOriginationOfTransferShip"></b></p>
                        <p class="content">- Tên tàu vận chuyển container: <b data-bind="text: fiNameOfContainerShip"></b></p>
                        <p class="content">- Số đăng ký tàu vận chuyển container <b data-bind="text: fiCodeOfContainerShip"></b></p>
                        <p class="content">- Quốc gia treo cờ của tàu vận chuyển container: <b data-bind="text: fiOriginationOfContainerShip"></b></p>
                        <p class="content">- Thời gian bốc dỡ từ: <b data-bind="date: fiLoadingUnLoadingTimeFrom"></b> đến <b data-bind="date: fiLoadingUnLoadingTimeTo"></b></p>
                        <p class="content">- Địa điểm bốc dỡ: <b data-bind="text: fiLoadingUnloadingPlace"></b></p>
                    </div>
                    <p class="content">Thời gian đánh bắt: <span style="font-weight: bold"
                                                                   data-bind="date: fiDateOfCatchFrom"></span>
                        đến <span style="font-weight: bold" data-bind="date: fiDateOfCatchTo"></span></p>
                    <p class="content">Khu vực đánh bắt: <span style="font-weight: bold"
                                                                 data-bind="text: fiLocationOfCatch"></span>
                    </p>
                    <p class="content">Phương pháp đánh bắt: <span style="font-weight: bold"
                                                                     data-bind="text: fiMethodCatch"></span>
                    </p>
                    <p class="content">Chúng tôi xin cam kết: đảm bảo nguyên trạng hàng hóa, đưa hàng về đúng địa điểm, đúng thời gian
                        được khai báo và chỉ sử dụng hàng hóa đúng mục đích khai báo sau khi được quý Cơ quan cấp Giấy
                        chứng nhận kiểm dịch.</p>

                </div>
            </div>
            <div class="row">
                <div class="col-md-6"></div>
                <div class="col-md-6 text-center">
                    <h4 style="font-weight: bold">TỔ CHỨC/CÁ NHÂN KHAI BÁO</h4>
                    <p><span style="font-weight: bold" data-bind="text: fiSignPosition"></span></p>
                    <p><span style="font-weight: bold" data-bind="text: fiSignName"></span></p>
                </div>
            </div>
            <div
                    data-bind="visible: fiRegistrationConfirm"
            >
<%--                <div style="border-top: #000000 solid 1px; margin: auto; width: 100%"></div>--%>
                <div class="row" style="padding-top: 15px">
                    <div class="col-md-12 text-center">
                        <h4 style="font-weight: bold">XÁC NHẬN CỦA CƠ QUAN KIỂM DỊCH ĐỘNG VẬT</h4>
                    </div>

                    <div class="col-md-12">
                        <p class="content">Thời gian kiểm dịch từ <b data-bind="date: fiRegistrationConfirm.fiCheckTimeFrom"></b> đến <b data-bind="date: fiRegistrationConfirm.fiCheckTimeTo"></b></p>
                        <p class="content">Đồng ý đưa hàng hóa về địa điểm <b data-bind="text: fiRegistrationConfirm.fiCheckPlace"></b> để làm thủ tục kiểm dịch</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6"></div>
                    <div class="col-md-6 text-center">
                        <p style="font-style: italic">Vào sổ số <b data-bind="text: fiRegistrationConfirm.fiRegistrationComfirmNo"></b> ngày <b data-bind="date: fiRegistrationConfirm.fiCreatedDate"></b></p>
                        <h4 style="font-weight: bold">CƠ QUAN KIỂM DỊCH ĐỘNG VẬT</h4>
                        <h5 style="font-weight: bold" data-bind="text: fiRegistrationConfirm.fiCreaterName"></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <div class="text-center">
            <button class="btn green" data-bind="click: $parent.downloadDonDK">
                Tải xuống
            </button>
            <button class="btn" data-dismiss="modal">
                Đóng
            </button>
        </div>
    </div>
</div>
<style>
    .request-checkbox {
        float: left;
        width: calc(100% / 3);
        margin-left: 0px !important;
    }

    input[type="checkbox"] {
        margin-right: 5px;
    }
     .text-border {
         border: 1px solid;
         display: inline;
         padding: 5px;
     }
</style>
