<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 12/3/19
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
    <!-- ko with: fiRegistrationConfirm() -->
    <div id="modal_xemXacnhandon" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Xác nhận đơn</b>
        </div>
        <div class="modal-body">
            <div id="pageView" class="tab-content" style="display: flex">

                <div class="container" style="display: inline" data-bind="visible: type() == '20a'">
                    <p class="content">
                        Mã hồ sơ: <span style="font-weight: bold" data-bind="text: fiNSWFileCode"></span>
                    </p>
                    <p class="content">
                        Số tiếp nhận: <span style="font-weight: bold" data-bind="text: fiRegistrationComfirmNo"></span>
                    </p>
                    <p class="content">
                        Yêu cầu kiểm tra chỉ tiêu/Analytical parameters required:
                    </p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr>
                            <th rowspan="2">STT</th>
                            <th rowspan="2">Mã chỉ tiêu</th>
                            <th rowspan="2">Tên chỉ tiêu</th>
                            <th rowspan="2">Mô tả chỉ tiêu công bố</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: fiAnanyticalRequiredList">
                        <tr>
                            <td data-bind="text: $index() + 1"/>
                            <td data-bind="text: fiAnanyticalCode"/>
                            <td data-bind="text: fiAnanyticalName"/>
                            <td data-bind="text: fiRequired"/>
                        </tr>
                        </tbody>
                    </table>

                    <p class="content">
                        Chế độ kiểm tra chất lượng: <span style="font-weight: bold" data-bind="text: fiInspectionTypeStr"></span>
                        <i>Số văn bản xác nhận chế độ kiểm tra chất lượng trường hợp miễn/giảm: <span style="font-weight: bold" data-bind="text: fiNoticeOfExemptionFromInspectionNo"></span></i>
                    </p>
                    <p>
                        Thời gian kiểm tra/Date of testing: từ <span style="font-weight: bold" data-bind="date: fiDateOfTestingFrom"></span> đến <span style="font-weight: bold" data-bind="date: fiDateOfTestingTo"></span>
                    </p>
                    <p>
                        Đơn vị thực hiện kiểm tra: <span style="font-weight: bold" data-bind="text: fiUnitOfTesting"></span>
                    </p>


                    <p class="content">
                        Đối với hàng nhập khẩu, giấy này có giá trị để làm thủ tục hải quan. Sau đó doanh nghiệp phải xuất trình toàn bộ hồ sơ và hàng hóa đã hoàn thành thủ tục hải quan cho cơ quan kiểm tra để được kiểm tra chất lượng theo quy định/This registration is used for customs clearance in term of imported goods. Consigner is required to submit to the inpection body, afterward, all related document of the imported goods
                    </p>
                    <p class="content">
                        Chúng tôi xin cam kết: Bảo đảm nguyên trạng hàng hóa nhập khẩu, đưa về đúng địa điểm, đúng thời gian được đăng ký và chỉ đưa hàng hóa ra lưu thông/sử dụng sau khi được quý cơ quan cấp Giấy chứng nhận kiểm dịch và Giấy xác nhận chất lượng
                    </p>

                    <h4 class="code" style="font-weight: bold" data-bind="visible: isCTYAccept">
                        Xác nhận của cơ quan kiểm dịch và kiểm tra chất lượng:
                    </h4>
                    <p>
                        <span data-bind="visible: isCTYAccept"> Đồng ý đưa hàng hóa về địa điểm: <span style="font-weight: bold" data-bind="text: fiLocationOfSamplingConfirm"></span> để làm thủ tục kiểm dịch và lấy mẫu kiểm tra chất lượng vào hồi <span style="font-weight: bold" data-bind="text: fiTimeOfSamplingConfirm"></span>  giờ, ngày <span style="font-weight: bold" data-bind="date: fiDateOfSamplingConfirm"></span>
                        Sau khi có Giấy chứng nhận vận chuyển hoặc Giấy chứng nhận kiểm dịch động vật lô hàng có thể được đưa về kho bảo quản (trừ hàng hóa phải kiểm tra ADN của loài nhai lại) trong khi chờ kết quả kiểm tra nhà nước về chất lượng thức ăn chăn nuôi, thủy sản nhập khẩu theo quy định pháp luật về hải quan (đối với chế độ kiểm tra thông thường, kiểm tra chặt)</span>
                    </p>
                    <p>
                        Lô hàng chỉ được phép thông quan sau khi có Giấy chứng nhận kiểm dịch và Giấy xác nhận chất lượng thức ăn chăn nuôi, thủy sản nhập khẩu (đối với chế độ kiểm tra giảm có thời hạn, thông thường, kiểm tra chặt).
                    </p>
                    <div data-bind="visible: isCTYAccept">
                        <div style="float: right; text-align: center">
                            <p><i>Cấp tại: <span data-bind="text: fiSignConfirmAddress"></span>, ngày: <span data-bind="date: fiSignConfirmDate"></span></i></p>
                            <p><b>Đại diện cơ quan kiểm tra</b></p>
                            <p><i>(Ký, đóng dấu, ghi rõ họ tên)</i></p>
                            <span data-bind="text: fiSignConfirmName"></span>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <h4 class="code" style="font-weight: bold" data-bind="visible: isHQAccept">
                        Xác nhận của Cơ quan Hải Quan:
                    </h4>
                    <span data-bind="visible: isHQAccept"> Lô hàng không được nhập khẩu vào Việt Nam vì lý do:  <span style="font-weight: bold" data-bind="text: fiRejectionReason"></span> </span>
                    <div class="col-md-12" data-bind="visible: isHQAccept">
                        <div style="float: right; text-align: center">
                            <p><i>Cấp tại: <span data-bind="text: fiSignConfirmAddressOfCustoms"></span>, ngày: <span data-bind="date: fiSignConfirmDateOfCustoms"></span></i></p>
                            <p><b>Đại diện cơ quan kiểm tra</b></p>
                            <p><i>(Ký, đóng dấu, ghi rõ họ tên)</i></p>
                            <span data-bind="text: fiSignConfirmNameOfCustoms"></span>
                        </div>
                    </div>
                </div>
                <div class="container" style="display: inline" data-bind="visible: type() == '03'">
                    <p class="content">
                        Mã hồ sơ: <span style="font-weight: bold" data-bind="text: fiNSWFileCode"></span>
                    </p>

                    <h4 class="code" style="font-weight: bold">
                        XÁC NHẬN CỦA CƠ QUAN KIỂM DỊCH ĐỘNG VẬT:
                    </h4>
                    <p>
                        Địa điểm kiểm dịch: <span style="font-weight: bold" data-bind="text: fiQuarantineLocationName"></span>
                        Thời gian kiểm dịch: từ ngày <span style="font-weight: bold" data-bind="date: fiMonitoringLocationTimeFrom"></span> đến ngày <span style="font-weight: bold" data-bind="date: fiMonitoringLocationTimeTo"></span>
                    </p>
                    <div>
                        <div style="float: right; text-align: center">
                            <p>Vào sổ số: <span data-bind="text: fiRegistrationComfirmNo"></span>, ngày <span data-bind="date: fiSignConfirmDate"></span></p>
                            <p><i>(Ký, đóng dấu, ghi rõ họ tên)</i></p>
                            <span data-bind="text: fiSignConfirmName"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <a data-bind="attr: {href: fiLinkFile}, visible: type() == '03'" class="btn green" target="_blank">
                Xuất word
            </a>
            <button class="btn" data-dismiss="modal">
                <span>Đóng</span>
            </button>
        </div>
    </div>
    <!-- /ko -->
</div>

