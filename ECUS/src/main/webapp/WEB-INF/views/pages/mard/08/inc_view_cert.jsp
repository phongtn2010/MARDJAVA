<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="modal_viewGiayPhep" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
     data-bind="with: giayPhepVM"
>
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    </div>
    <div class="modal-body container">
        <div class="panel">
            <ul class="nav nav-tabs">
                <li id="title_tab_vsty" data-bind="visible: vsty()">
                    <a href="#tab_vsty" data-toggle="tab"><b>Công văn VSTY</b></a>
                </li>
                <li id="title_tab_kdnk" data-bind="visible: cnkd()">
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
                                <div>Số: <b data-bind="text: fiDispatchNo"></b></div>
                                <div>V/v: <b data-bind="text: fiSummary"></b></div>
                            </div>
                            <div class="col-md-6 text-center" style="margin-top: 15px;">
                                <div style="font-style: italic"><b
                                        data-bind="text: fiSignConfirmAddress"></b><span>,</span>
                                    <b
                                            data-bind="formattedTime: fiSignConfirmDate"></b></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12" style="text-align: justify; margin-top: 20px;">
                                <p class="text-center">Kính gửi: <b data-bind="text: $parent.companyName"></b></p>
                                <p class="content" data-bind="text: fiPreamble"></p>
                                <p class="content">Thông tin hàng hóa:</p>
                                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                    <thead>
                                    <tr>
                                        <th rowspan="2">STT</th>
                                        <th rowspan="2">Loại giống</th>
                                        <th rowspan="2">Số lượng</th>
                                        <th rowspan="2">Nguồn gốc/Xuất xứ</th>
                                        <th rowspan="2">Cửa khẩu nhập</th>
                                    </tr>
                                    </thead>
                                    <tbody data-bind="foreach: lstAnimal">
                                    <tr>
                                        <td data-bind="text: $index() + 1"></td>
                                        <td data-bind="text: fiAnimalName"></td>
                                        <td><span data-bind="text: (fiQtyMale + fiQtyFemale)"></span> con</td>
                                        <td data-bind="text: fiCountryOrigin"></td>
                                        <td data-bind="text: fiPortName"></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div data-bind="visible: lstCompany.length > 0">
                                    <p class="content">
                                        Từ công ty: <span data-bind="foreach: lstCompany"><b data-bind="text: fiExporterName"></b>; </span>
                                    </p>
                                </div>
                                <div data-bind="visible: lstIsoLoc.length > 0">
                                    <p class="content">
                                        Địa điểm nuôi cách ly kiểm dịch: <span data-bind="foreach: lstIsoLoc"><b data-bind="text: fiIsoLocName"></b> (<b data-bind="text: fiIsoLocAddress"></b>); </span>
                                    </p>
                                </div>
                                <p class="content">Thời gian thực hiện: <b data-bind="text: fiExecutionTime"></b></p>
                                <p class="content">Mục đích sử dụng: <b data-bind="text: fiPurpose"></b></p>
                                <p style="margin-left: 5%" data-bind="html: fiContent"></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 text-center">
                                <p>Nơi nhận</p>
                                <p data-bind="html: fiRecipient"></p>
                            </div>
                            <div class="col-md-6 text-center">
                                <p style="font-weight: bold" data-bind="visible: (fiSignConfirmTitle && fiSignConfirmTitle.trim().toLowerCase() != 'cục trưởng')">KT. CỤC TRƯỞNG</p>
                                <h5 style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignConfirmTitle"></h5>
                                <p style="font-weight: bold">Đã ký</p>
                                <h5 style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignConfirmName"></h5>
                            </div>
                        </div>
                    </div>
                    <div class="text-center" style="margin-top: 15px;">
                        <button class="btn green" data-bind="click: function() { taiGiayPhep($data, 'vsty') }">
                            <spring:message code="common.button.tai_ve"/>
                        </button>
                        <button class="btn" data-dismiss="modal">
                            Đóng
                        </button>
                    </div>
                </div>
                <div class="tab-pane" id="tab_cnkd">
                    <div class="col-md-12" data-bind="with: cnkd" style="margin-bottom: 15px;">
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
                                <div>Số: <b data-bind="text: fiQuarantineNo"></b></div>
                                <div>V/v: <b data-bind="text: fiSummary"></b></div>
                            </div>
                            <div class="col-md-6 text-center" style="margin-top: 15px;">
                                <div style="font-style: italic"><b
                                        data-bind="text: fiSignConfirmAddress"></b><span>,</span>
                                    <b
                                            data-bind="formattedTime: fiSignConfirmDate"></b></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12" style="text-align: justify; margin-top: 20px;">
                                <p class="text-center">Kính gửi: <b data-bind="text: $parent.companyName"></b></p>
                                <p class="content" data-bind="text: fiPreamble"></p>
                                <div>
                                    <p class="content">Thông tin hàng hóa:</p>
                                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                        <thead>
                                        <tr>
                                            <th rowspan="2" style="width: 5%">STT</th>
                                            <th rowspan="2">Tên hàng hóa</th>
                                            <th rowspan="2">Số lượng/Khối lượng</th>
                                            <th rowspan="2">Nguồn gốc/Nước xuất</th>
                                            <th rowspan="2">Cửa khẩu nhập</th>
                                        </tr>
                                        </thead>
                                        <tbody data-bind="foreach: lstProduct">
                                        <tr>
                                            <td style="width: 5%" data-bind="text: $index() + 1"></td>
                                            <td data-bind="text: fiProductName"></td>
                                            <td>
                                                <div><span data-bind="text: fiNumberOrigin"></span> <span data-bind="text: fiUnitName"></span></div>
                                            </td>
                                            <td data-bind="text: fiCountryOriginName"></td>
                                            <td data-bind="text: fiPortName"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <p class="content">
                                    Từ công ty: <span data-bind="foreach: lstCompany"><b data-bind="text: fiExporterName"></b>; </span>
                                </p>
                                <div data-bind="visible: lstIsoLoc.length > 0">
                                    <p class="content">
                                        Địa điểm nuôi cách ly kiểm dịch: <span data-bind="foreach: lstIsoLoc"><b data-bind="text: fiIsoLocName"></b> (<b data-bind="text: fiIsoLocAddress"></b>); </span>
                                    </p>
                                </div>
                                <div data-bind="visible: lstMfr.length > 0">
                                    <p class="content">
                                        Nhà máy sản xuất: <span data-bind="foreach: lstMfr"><b data-bind="text: fiFactoryName"></b>; </span>
                                    </p>
                                </div>
                                <p class="content">Thời gian thực hiện: <b data-bind="text: fiExecutionTime"></b></p>
                                <p class="content">Mục đích sử dụng: <b data-bind="text: fiPurpose"></b></p>
                                <p style="margin-left: 5%" data-bind="html: fiContent"></p>
                            </div>
                        </div>
                        <div class="row" style="margin-top: 15px;">
                            <div class="col-md-6 text-center">
                                <p>Nơi nhận</p>
                                <p data-bind="html: fiRecipient"></p>
                            </div>
                            <div class="col-md-6 text-center">
                                <p style="font-weight: bold" data-bind="visible: (fiSignConfirmTitle && fiSignConfirmTitle.trim().toLowerCase() != 'cục trưởng')">KT. CỤC TRƯỞNG</p>
                                <h5 style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignConfirmTitle"></h5>
                                <p style="font-weight: bold">Đã ký</p>
                                <h5 style="font-weight: bold; text-transform: uppercase" data-bind="text: fiSignConfirmName"></h5>
                            </div>
                        </div>
                    </div>
                    <div class="text-center" style="margin-top: 15px;">
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
<%--        <div class="text-center">--%>
<%--&lt;%&ndash;            <button class="btn green">&ndash;%&gt;--%>
<%--&lt;%&ndash;                Tải file&ndash;%&gt;--%>
<%--&lt;%&ndash;            </button>&ndash;%&gt;--%>
<%--            <button class="btn" data-dismiss="modal">--%>
<%--                Đóng--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>
<style>
    .content {
        text-indent: 5%;
    }
</style>
