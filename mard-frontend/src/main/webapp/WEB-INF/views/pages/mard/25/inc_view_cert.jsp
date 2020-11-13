<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="modal_viewGiayPhep" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
     data-bind="with: giayPhepVM"
>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body container">
        <div>
            <ul class="nav nav-tabs">
                <li class="active" id="title_tab_vsty">
                    <a href="#tab_vsty" data-toggle="tab"><b>Công văn VSTY</b></a>
                </li>
                <li id="title_tab_kdnk">
                    <a href="#tab_cnkd" data-toggle="tab"><b>Công văn KDNK</b></a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="tab_vsty">
                    <div class="col-md-12" data-bind="with: vsty" style="margin-bottom: 15px;">
                        <div class="row">
                            <div class="col-md-6">
                                <div style="text-align: center">
                                    <h4 style="font-weight: bold">
                                        BỘ NÔNG NGHIỆP VÀ PHÁT TRIỂN NÔNG THÔN
                                    </h4>
                                    <h4 style="font-weight: bold">
                                        CỤC THÚ Y
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
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 text-center" style="margin-top: 15px;">
                                <div>Số: <span style="font-weight: bold" data-bind="text: fiDispatchNo"></span></div>
                                <div>V/v: <span style="font-weight: bold">Kiểm tra VSTY nơi nuôi cách ly kiểm dịch nhập khẩu động vật thủy sản</span></div>
                            </div>
                            <div class="col-md-6 text-center" style="margin-top: 15px;">
                                <div style="font-style: italic"><span
                                        data-bind="text: fiSignConfirmAddress"></span><span>,</span>
                                    <span
                                            data-bind="formattedTimeVN: fiDispatchDate"></span></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12" style="text-align: justify; margin-top: 20px;">
                                <p class="text-center">Kính gửi: <b data-bind="text: $parent.companyName"></b></p>
                                <p class="content" data-bind="html: fiPreamble"></p>
                                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                    <thead>
                                    <tr>
                                        <th rowspan="2" style="width: 5%">STT</th>
                                        <th rowspan="2">Tên thương mại</th>
                                        <th rowspan="2">Tên khoa học</th>
                                        <th rowspan="2">Kích cỡ</th>
                                        <th rowspan="2">Số lượng</th>
                                        <th rowspan="2">Nước xuất xứ</th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach: fiTbdHanghoa26List">
                                    <tr>
                                        <td data-bind="text: $index() + 1"></td>
                                        <td style="text-align: center" data-bind="text: fiProductBusinessName"></td>
                                        <td style="text-align: center; font-style: italic" data-bind="text: fiProductScienceName"></td>
                                        <td style="text-align: center" data-bind="text: fiSizeOrType"></td>
                                        <td style="text-align: right" data-bind="text: fiQuantity"><span data-bind="text: fiQuantity"></span> (<span data-bind="text: fiPackageUnitName"></span>)</td>
                                        <td style="text-align: center" data-bind="text: fiOriginCountryName"></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <p class="content">
                                    Từ công ty: <span data-bind="foreach: fiExporterCountryList"><b data-bind="text: fiExporterCountryName"></b>; </span>
                                </p>
                                <p class="content">
                                    Từ cơ sở sản xuất/thu gom: <span data-bind="foreach: fiProcessingList"><b data-bind="text: fiProcessingName"></b>; </span>
                                </p>
                                <div data-bind="visible: fiLocationQuarantineList.length > 0">
                                    <p class="content">Địa điểm nuôi cách ly kiểm dịch: <span data-bind="foreach: fiLocationQuarantineList"><b data-bind="text: fiLocationQuarantineName"></b> (<b data-bind="text: fiLocationQuarantineAddress"></b>); </span></p>
                                </div>
                                <p class="content">Cửa khẩu nhập: <span data-bind="text: fiBordergateName"></span></p>
                                <p class="content">Thời gian thực hiện: <span data-bind="text: fiTimeQuarantine"></span>
                                </p>
                                <p class="content">Mục đích sử dụng: <span data-bind="text: fiPurpose"></span></p>
                                <p style="margin-left: 5%" data-bind="html: fiResponseContent"></p>

                            </div>
                        </div>
                        <div class="row" style="margin-top: 15px;">
                            <div class="col-md-1"></div>
                            <div class="col-md-5 text-left">
                                <p>Nơi nhận</p>
                                <p>Như trên</p>
                                <p data-bind="html: fiRecipient"></p>
                                <p>Lưu VP, KD</p>
                            </div>
                            <div class="col-md-6 text-center">
                                <p style="font-weight: bold" data-bind="visible: (fiSignPosition && fiSignPosition.trim().toLowerCase() != 'cục trưởng')">KT. CỤC TRƯỞNG</p>
                                <p style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignPosition"></p>
                                <p style="font-weight: bold">Đã ký</p>
                                <p style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignConfirmName"></p>
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <button class="btn green" data-bind="click: function() { taiGiayPhep($data, 'vsty') }">
                            <spring:message code="common.button.tai_ve"/>
                        </button>
                        <button class="btn" data-dismiss="modal">
                            Đóng
                        </button>
                    </div>
                </div>
                <div class="tab-pane" id="tab_cnkd">
                    <div class=" col-md-12" data-bind="with: cnkd" style="margin-bottom: 15px;">
                        <div class="row">
                            <div class="col-md-6">
                                <div style="text-align: center">
                                    <h4 style="font-weight: bold">
                                        BỘ NÔNG NGHIỆP VÀ PHÁT TRIỂN NÔNG THÔN
                                    </h4>
                                    <h4 style="font-weight: bold">
                                        CỤC THÚ Y
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
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 text-center" style="margin-top: 15px;">
                                <div>Số: <span data-bind="text: fiDispatchNo"></span></div>
                                <div>V/v: <span data-bind="text: fiProductType != 1 ? 'kiểm dịch nhập khẩu sản phẩm động vật thủy sản' : 'kiểm dịch nhập khẩu động vật thủy sản'"></span></div>
                            </div>
                            <div class="col-md-6 text-center" style="margin-top: 15px;">
                                <div style="font-style: italic"><span
                                        data-bind="text: fiSignConfirmAddress"></span><span>,</span>
                                    <span
                                            data-bind="formattedTimeVN: fiDispatchDate"></span></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12" style="text-align: justify; margin-top: 20px;">
                                <p class="text-center">Kính gửi: <b data-bind="text: $parent.companyName"></b></p>
                                <p class="content" data-bind="html: fiPreamble"></p>
                                <table data-bind="visible: fiProductType == 1" class="table table-striped table-bordered table-hover table-checkable order-column">
                                    <thead>
                                    <tr>
                                        <th rowspan="2" style="width: 5%">STT</th>
                                        <th rowspan="2">Tên thương mại</th>
                                        <th rowspan="2">Tên khoa học</th>
                                        <th rowspan="2">Kích cỡ</th>
                                        <th rowspan="2">Số lượng</th>
                                        <th rowspan="2">Nước xuất xứ</th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach: fiTbdHanghoa26List">
                                    <tr>
                                        <td data-bind="text: $index() + 1"></td>
                                        <td style="text-align: center" data-bind="text: fiProductBusinessName"></td>
                                        <td style="text-align: center; font-style: italic" data-bind="text: fiProductScienceName"></td>
                                        <td style="text-align: center" data-bind="text: fiSizeOrType"></td>
                                        <td style="text-align: right"><span data-bind="text: fiQuantity"></span> (<span data-bind="text: fiPackageUnitName"></span>)</td>
                                        <td style="text-align: center" data-bind="text: fiOriginCountryName"></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table data-bind="visible: fiProductType != 1" class="table table-striped table-bordered table-hover table-checkable order-column">
                                    <thead>
                                    <tr>
                                        <th rowspan="2" style="width: 5%">STT</th>
                                        <th rowspan="2" >Loại sản phẩm</th>
                                        <th rowspan="2">Số lượng (Kilogram)</th>
                                        <th rowspan="2">Nước xuất xứ</th>
                                        <th rowspan="2">Cửa khẩu nhập</th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach: fiTbdHanghoa26List">
                                    <tr>
                                        <td data-bind="text: $index() + 1"></td>
                                        <td style="text-align: center" data-bind="text: fiProductBusinessName"></td>
                                        <td style="text-align: right" data-bind="text: fiQuantity"></td>
                                        <td style="text-align: center" data-bind="text: fiOriginCountryName"></td>
                                        <td style="text-align: center" data-bind="text: $parent.fiBordergateName"></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <p class="content">
                                    Từ công ty: <span data-bind="foreach: fiExporterCountryList"><b data-bind="text: fiExporterCountryName"></b>; </span>
                                </p>
                                <p data-bind="visible: fiProductType == 1" class="content">
                                    Từ cơ sở sản xuất/thu gom: <span data-bind="foreach: fiProcessingList"><b data-bind="text: fiProcessingName"></b>; </span>
                                </p>
                                <p data-bind="visible: fiProductType != 1" class="content">
                                    Nhà sản xuất: <span data-bind="foreach: fiProcessingList"><b data-bind="text: fiProcessingName"></b>; </span>
                                </p>
                                <div data-bind="visible: fiLocationQuarantineList.length > 0">
                                    <p class="content">Địa điểm nuôi cách ly kiểm dịch: <span data-bind="foreach: fiLocationQuarantineList"><b data-bind="text: fiLocationQuarantineName"></b> (<b data-bind="text: fiLocationQuarantineAddress"></b>); </span></p>
                                </div>
                                <p class="content">Cửa khẩu nhập: <span data-bind="text: fiBordergateName"></span></p>
                                <p class="content">Thời gian thực hiện: <span data-bind="text: fiTimeQuarantine"></span>
                                </p>
                                <p class="content">Mục đích sử dụng: <span data-bind="text: fiPurpose"></span></p>
                                <p class="content" data-bind="html: fiBaseOnReport"></p>
                                <p style="margin-left: 5%" data-bind="html: fiResponseContent"></p>

                            </div>
                        </div>
                        <div class="row" style="margin-top: 15px;">
                            <div class="col-md-1"></div>
                            <div class="col-md-5 text-left">
                                <p>Nơi nhận</p>
                                <p>Như trên;</p>
                                <p data-bind="html: fiRecipient"></p>
                                <p>Lưu VP, KD.</p>
                            </div>
                            <div class="col-md-6 text-center">
                                <p style="font-weight: bold" data-bind="visible: (fiSignPosition && fiSignPosition.trim().toLowerCase() != 'cục trưởng')">KT. CỤC TRƯỞNG</p>
                                <p style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignPosition"></p>
                                <p style="font-weight: bold">Đã ký</p>
                                <p style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignConfirmName"></p>
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <button class="btn green" data-bind="click: function() { taiGiayPhep($data, 'kdnk') }">
                            <spring:message code="common.button.tai_ve"/>
                        </button>
                        <button class="btn" data-dismiss="modal">
                            Đóng
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </div>
<%--    <div class="modal-footer">--%>
<%--        --%>
<%--    </div>--%>
</div>
