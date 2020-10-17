<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 11/15/19
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <!-- ko with: currentTransportCert() -->
    <div id="modal_xemGVCSPDV" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body container" style="display: flex">
            <page size="A4" class="a4-padding col-md-12">
                <div class="col-md-12">
                    <div style="float: left">
                        <h4 style="text-align: center; font-weight: bold" class="uppercase" data-bind="text: (!fiParentDepartmentName() || fiParentDepartmentName() == '') ? 'CỤC THÚ Y' : fiParentDepartmentName()"></h4>
                        <h5 style="text-align: center" data-bind="text: fiDepartmentLicenseName">
                        </h5>

                        <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                    </div>
                    <div style="float: right">
                        <h4 style="font-weight: bold; text-align: center">
                            CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        </h4>
                        <h5 style="text-align: center">
                            Độc lập - Tự do - Hạnh phúc
                        </h5>

                        <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                    </div>
                </div>
                <div style="width: 100px; height: 50px; border: solid 1px; display: flex; align-items: center; justify-content: center; position: absolute; top: 100px; right: 0px">
                    <b>Mẫu 14B</b>
                </div>

                <div class="col-md-12">
                    <br/>
                    <br/>
                </div>

                <h4 class="code" style="font-weight: bold; text-align: center">
                    <p>GIẤY CHỨNG NHẬN VẬN CHUYỂN SẢN PHẨM</p>
                    ĐỘNG VẬT VỀ NƠI CÁCH LY KIỂM DỊCH
                </h4>
                <p style="text-align: center">
                    <i>Số: <span data-bind="text: fiCertificateNo"></span></i>
                </p>
                <p class="code" >
                    Họ tên chủ hàng (hoặc người đại diện):  <span  style="font-weight: bold" data-bind="text: fiNameOfRegistration"></span>
                </p>
                <p class="content">
                    Địa chỉ giao dịch: <span style="font-weight: bold" data-bind="text: fiAddressOfRegistration"></span>
                </p>
                <p class="content">
                    Số chứng minh nhân dân/Số Hộ chiếu/Số định danh cá nhân: <span data-bind="text: fiIdentityNo"></span> Cấp ngày: <span data-bind="date: fiIssueDate"></span> tại <span data-bind="text: fiIssuePlace"></span>
                </p>
                <p class="content">
                    Điên thoại: <span style="font-weight: bold" data-bind="text: fiPhoneOfRegistration"></span> Fax: <span style="font-weight: bold" data-bind="text: fiFaxOfRegistration"></span> Email: <span style="font-weight: bold" data-bind="text: fiEmailOfRegistration"></span></span>
                </p>

                <p class="content">
                    Nhập khẩu số động vật như sau:
                </p>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th style="width: 5%" rowspan="2">STT</th>
                        <th rowspan="2">Loại hàng</th>
                        <th rowspan="2">Quy cách đóng gói</th>
                        <th rowspan="2">Số lượng</th>
                        <th rowspan="2">Trọng lượng(kg)</th>
                        <th rowspan="2">Mục đích sử dụng</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstGood">
                    <tr>
                        <td style="width: 5%" style="width: 5%" data-bind="text: $index() + 1"/>
                        <td data-bind="text: fiProductName"/>
                        <td data-bind="text: fiPackingWay"/>
                        <td class="text-right" data-bind="text: fiNumber"/>
                        <td class="text-right" data-bind="text: fiNetWeight"/>
                        <td data-bind="text: fiPurposeUse"/>
                    </tr>
                    </tbody>
                </table>

                <div class="col-md-12">
                    <br/>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Tổng số: </span>
                    </div>
                    <div class="col-md-10">
                        <span style="font-weight: bold"  data-bind="text: fiTotalQuantityOrVolumnByText"></span>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Tên, địa chỉ tổ chức, cá nhân xuất khẩu: </span>
                    </div>
                    <div class="col-md-10">
                        <span>
                            <span style="font-weight: bold"  data-bind="text: fiNameOfExporter"></span>
                            <span style="font-weight: bold"  data-bind="text: fiAddressOfExporter"></span>
                        </span>
                    </div>
                </div>


                <div class="col-md-12">
                    <br/>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Nước xuất khẩu:</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold"  data-bind="text: fiOriginationExport"></span>
                    </div>
                    <div class="col-md-2">
                        <span>Nước quá  cảnh(nếu có):</span>
                    </div>
                    <div class="col-md-4">
                        <span  style="font-weight: bold" data-bind="text: fiOriginationTransit"></span>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Cửa nhập khẩu vào Việt Nam:</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold"  data-bind="text: fiPortOfDestinationName"></span>
                    </div>
                    <div class="col-md-2">
                        <span>Thời gian nhập:</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold"  data-bind="date: fiImportDate"></span>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Các vật dụng khác có liên quan:</span>
                    </div>
                    <div class="col-md-10">
                        <span style="font-weight: bold"  data-bind="text: fiOtherItems"></span>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Hồ sơ giấy tờ có liên quan:</span>
                    </div>
                    <div class="col-md-10">
                        <span style="font-weight: bold"  data-bind="text: fiDocumentAttach"></span>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Phương tiện vận chuyển:</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold"  data-bind="text: fiTransportType"></span>
                    </div>
                    <div class="col-md-2">
                        <span>Biển kiểm sát:</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold"  data-bind="text: fiLicensePlate"></span>
                    </div>
                </div>

                <div class="col-md-12">
                    <br/>
                </div>

                <h5 class="code" style="font-weight: bold; text-align: center">
                    <p>CHỨNG NHẬN KIỂM DỊCH</p>
                </h5>

                <p>Tôi kiểm dịch viên động vật ký tên dưới đây chứng nhận:</p>
                <p>1. Lô hàng nhập khẩu có đầy đủ giấy tờ hợp lệ.</p>
                <p>2. Sản phẩm động vật đảm bảo yêu cầu vệ sinh thú ly khi nhập khẩu.</p>
                <p>3. Sản phẩm động vật được bao gói, bảo quản theo quy định.</p>
                <p>4. Phương tiện vận chuyển, các vật dụng khác có liên quan kèm theo bảo đảm yêu cầu vệ sinh thú y, đã được khử trùng tiêu độc bằng <span style="font-weight: bold" data-bind="text: fiAnimalOfAntiseptic"></span> nồng độ <span style="font-weight: bold" data-bind="text: fiAnimalOfConcentration"></span></p>

                <div class="col-md-12">
                    <br/>
                </div>

                <h5 class="code" style="font-weight: bold; text-align: center">
                    <p>YÊU CẦU KHI VẬN CHUYỂN</p>
                </h5>

                <p>Tôi kiểm dịch viên động vật ký tên dưới đây chứng nhận:</p>
                <p>1. Số sản phẩm động vật trên phải được chuyển đến nơi cách ly kiểm dịch trước ngày <span style="font-weight: bold" data-bind="date: fiTransportDate"></span> để kiểm dịch tại địa điểm: <span style="font-weight: bold" data-bind="text: fiTransportPlace"></span></p>
                <p>2. Chỉ được vận chuyển theo lộ trình: <span style="font-weight: bold" data-bind="text: fiTransportStreet"/></p>
                <p>3. Nghiêm cấm vứt sản phẩm động vật, chất thải, bao bì chứa đựng trong quá trình vận chuyển</p>
                <p>4. Chỉ được phép đưa sản phẩm động vật về nơi cách ly kiểm dịch tại địa điểm nêu trên và đúng thời gian quy định để nuôi cách ly kiểm dịch.</p>
                <p>Giấy có giá trị đến: <b><span data-bind="date: fiEffectiveDate"/></b></p>
                <div class="col-md-12">
                    <br/>
                    <br/>
                </div>

                <div class="col-md-12">
                    <div style="float: left; text-align: center">
                        <p><b>Kiểm dịch viên động vật</b></p>
                        <p><i>(Ký, ghi  rõ họ tên)</i></p>
                        <span data-bind="text: fiCreaterName"></span>
                    </div>
                    <div style="float: right; text-align: center">
                        <p><i>Cấp tại: <span data-bind="text: fiSignConfirmAddress"></span>, ngày: <span data-bind="date: fiSignConfirmDate"></span></i></p>
                        <p><b>THỦ TRƯỞNG CƠ QUAN</b></p>
                        <p><i>(Ký, đóng dấu, ghi rõ họ tên)</i></p>
                        <span data-bind="text: fiSignConfirmName"></span>
                    </div>
                </div>

                <div class="col-md-12">
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                </div>

            </page>
        </div>
        <div class="modal-footer">
            <a class="btn green" data-bind="attr: {href: fiLinkFile}" target="_blank">
                Xuất word
            </a>
        </div>
    </div>
    <!-- /ko -->
</div>
