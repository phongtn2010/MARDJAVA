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
    <!-- ko with: currentQuarantineCert() -->
    <div id="modal_xemCNKDDV" class="modal container in modal-overflow" tabindex="-1"
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
                    <b>Mẫu 15a</b>
                </div>

                <div class="col-md-12">
                    <br/>
                    <br/>
                </div>

                <h4 class="code" style="font-weight: bold; text-align: center">
                    <p>GIẤY CHỨNG NHẬN KIỂM DỊCH ĐỘNG VẬT NHẬP KHẨU</p>
                </h4>
                <p style="text-align: center; font-weight: bold; font-style: italic">
                    <i>Số: <span data-bind="text: fiCertificateNo"/></i>
                </p>
                <p class="code" >
                    Họ tên chủ hàng (hoặc người đại diện): <span style="font-weight: bold" data-bind="text: fiNameOfRegistration"/>
                </p>
                <p class="content">
                    Địa chỉ giao dịch: <span style="font-weight: bold" data-bind="text: fiAddressOfRegistration"/>
                </p>
                <p class="content">
                    Số chứng minh nhân dân/Số Hộ chiếu/Số định danh cá nhân: <span style="font-weight: bold" data-bind="text: fiIdentityNo"/> Cấp ngày: <span style="font-weight: bold" data-bind="date: fiIssueDate"/> tại <span style="font-weight: bold" data-bind="text: fiIssuePlace"/>
                </p>
                <p class="content">
                    Điên thoại: <span style="font-weight: bold" data-bind="text: fiPhoneOfRegistration"/> Fax: <span style="font-weight: bold" data-bind="text: fiFaxOfRegistration"/> Email: <span style="font-weight: bold" data-bind="text: fiEmailOfRegistration"/></span>
                </p>

                <p class="content">
                    Nhập khẩu số động vật như sau:
                </p>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th class="text-center" style="width: 5%" rowspan="2">STT</th>
                        <th class="text-center" rowspan="2">Loại động vật</th>
                        <th class="text-center" rowspan="2">Tuổi</th>
                        <th class="text-center" colspan="2">Tính biệt</th>
                        <th class="text-center" rowspan="2">Số lượng (con)</th>
                        <th class="text-center" rowspan="2">Mục đích sử dụng</th>
                    </tr>
                    <tr>
                        <th class="text-center">Đực</th>
                        <th class="text-center">Cái</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstGood">
                    <tr>
                        <td class="text-center" style="width: 5%" data-bind="text: $index() + 1"/>
                        <td data-bind="text: fiProductName"/>
                        <td class="text-center" data-bind="text: fiAge"/>
                        <td class="text-center" data-bind="text: fiIncludeMale() == 1 ? '*' : ''"/>
                        <td class="text-center" data-bind="text: fiIncludeFemale() == 1 ? '*' : ''"/>
                        <td class="text-center" data-bind="text: fiNumber"/>
                        <td class="text-center" data-bind="text: fiPurposeUse"/>
                    </tr>
                    </tbody>
                </table>

                <div class="col-md-12">
                    <br/>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Tổng số (viết bằng chữ): </span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold" data-bind="text: fiTotalQuantityOrVolumnByText"/>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Tên, địa chỉ tổ chức, cá nhân xuất khẩu: </span>
                    </div>
                    <div class="col-md-4">
                        <span><span data-bind="text: fiNameOfExporter"/> - <span data-bind="text: fiAddressOfExporter"/></span>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Nước xuất khẩu:</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold" data-bind="text: fiOriginationExport"/>
                    </div>
                    <div class="col-md-2">
                        <span>Nước quá cảnh(nếu có):</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold" data-bind="text: fiOriginationTransit"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Nơi chuyển đến: </span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold" data-bind="text: fiPortOfDestinationAddress"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Các vật dụng khác có liên quan:</span>
                    </div>
                    <div class="col-md-10">
                        <span style="font-weight: bold" data-bind="text: fiOtherItems"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Hồ sơ giấy tờ có liên quan:</span>
                    </div>
                    <div class="col-md-10">
                        <span style="font-weight: bold" data-bind="text: fiDocumentAttach"/>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2">
                        <span>Phương tiện vận chuyển:</span>
                    </div>
                    <div class="col-md-4">
                        <span style="font-weight: bold" data-bind="text: fiTransportType"/>
                    </div>
                </div>

                <div class="col-md-12">
                    <br/>
                </div>

                <h5 class="code" style="font-weight: bold; text-align: center">
                    <p>CHỨNG NHẬN KIỂM DỊCH</p>
                </h5>

                <p>Tôi kiểm dịch viên động vật ký tên dưới đây chứng nhận số động vật nêu trên:</p>
                <p>1. Có đầy đủ giấy tờ hợp lệ.</p>
                <p>2. Đã được kiểm tra và không có triệu chứng lâm sàng của bệnh truyền nhiễm khi nhập khẩu.</p>
                <p>3. Số động vật trên đã được tiêm phòng và có miễn dịch với các bệnh:</p>
                <!-- ko foreach: lstImmunes -->
                <p>- <span style="font-weight: bold" data-bind="text: fiDiseaseName"></span> Tiêm phòng ngày <span style="font-weight: bold" data-bind="date: fiVaccinationDate"></span></p>
                <!-- /ko -->
                <p>4. Phương tiện vận chuyển, các vật dụng khác có liên quan kèm theo bảo đảm yêu cầu vệ sinh thú y, đã được khử trùng tiêu độc bằng <span style="font-weight: bold" data-bind="text: fiTransportTypeOfAntiseptic"></span> nồng độ <span style="font-weight: bold" data-bind="text: fiTransportTypeOfConcentration"></span></p>


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
            <a data-bind="attr: {href: fiLinkFile}" class="btn green" target="_blank">
                Xuất word
            </a>
        </div>
    </div>
    <!-- /ko -->
</div>
