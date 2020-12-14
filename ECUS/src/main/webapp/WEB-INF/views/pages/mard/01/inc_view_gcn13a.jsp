<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 12/18/19
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div id="modal_13a" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body" style="padding: 15px 3%">
            <div id="pageView" class="tab-content" style="display: flex">
                <div style="width: 50%">
                    <h4 style="font-weight: bold; text-align: center; text-transform: uppercase" data-bind="text: fiDepartmentParentNameVni">
                    </h4>
                    <h4 style="text-align: center; text-transform: uppercase" data-bind="text: fiDepartmentParentName">
                    </h4>
                    <h4 style="font-weight: bold; text-align: center; text-transform: uppercase" data-bind="text: fiDepartmentChildNameVni">
                    </h4>
                    <h4 style="text-align: center; text-transform: uppercase" data-bind="text: fiDepartmentChildName">
                    </h4>
                </div>
                <div id="hoso" class="tab-pane fade active in col-md-12" style="width: 50%">
                    <h4 style="font-weight: bold; text-align: center">
                        NƯỚC CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </h4>
                    <h4 style="text-align: center">
                        THE SOCIALIST REPUBLIC OF VIET NAM
                    </h4>
                    <h4 style="text-align: center">
                        ------------
                    </h4>

                </div>

            </div>
            <div style="">
                <span style="font-weight: bold; float: right; border: 1px solid; padding: 3px"> Mẫu 13a</span>
                <%--                    <p style="text-align: right; font-style: italic">Form:</p>--%>
            </div>
            <div>
                <h4 style="font-weight: bold; text-align: center">
                    GIẤY CHỨNG NHẬN KIỂM DỊCH ĐỘNG VẬT XUẤT KHẨU
                </h4>
                <h4 style="text-align: center">
                    ANIMAL HEATH CERTIFICATE FOR EXPORT
                </h4>
                <p style="font-style: italic; text-align: center">
                    Số:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNo"></span>
                </p>
                <p style="font-style: italic; text-align: center">
                    Number:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNo"></span>
                </p>
            </div>
            <div>
                <div style="padding: 0 2%;">
                    <p class="code">
                        Tên, địa chỉ người xuất hàng: <span style="font-weight: bold" data-bind="text: fiExporterNameVni"></span>, <span style="font-weight: bold" data-bind="text: fiExporterAdressVni"></span>
                    </p>
                    <p class="code">
                        <span style="font-style: italic">Name and address of exporter: </span>
                        <span style="font-weight: bold" data-bind="text: fiExporterName"></span>,
                        <span style="font-weight: bold" data-bind="text: fiExporterAdress"></span>
                    </p>
                    <p class="code" style="display: flex">
                        <span style="width: 30%">Tel: <span style="font-weight: bold" data-bind="text: fiExporterTel"></span>&emsp;</span>
                        <span style="width: 30%">Fax: <span style="font-weight: bold" data-bind="text: fiExporterFax"></span>&emsp;</span>
                        <span style="width: 30%">Email: <span style="font-weight: bold" data-bind="text: fiExporterEmail"></span>&emsp;</span>
                    </p>
                    <p class="code">
                        Nơi xuất phát của động vật: <span style="font-weight: bold" data-bind="text: fiDeparturePlaceVni"></span>
                    </p>
                    <p class="code">
                        <span style="font-style: italic">Place of origin of the animal/s: </span><span style="font-weight: bold" data-bind="text: fiDeparturePlace"></span>
                    </p>
                </div>
                <div>
                    <h4 style="font-weight: bold; text-align: center">
                        I. MÔ TẢ CHI TIẾT HÀNG
                    </h4>
                    <h4 style="text-align: center">
                        IDENTIFICATION OF THE ANIMAL/S
                    </h4>

                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <tr class="">
                        <th class="text-center">
                            <p>Loài động vật</p>
                            <p style="font-style: italic;">Type of Animal</p>
                        </th>
                        <th class="text-center">
                            <p>Số hiệu</p>
                            <p style="font-style:italic;">Official mark</p>
                        </th>
                        <th class="text-center">
                            <p>Giống</p>
                            <p style="font-style:italic;">Breed</p>
                        </th>
                        <th class="text-center">
                            <p>Tinh biệt</p>
                            <p style="font-style:italic;">Sex</p>
                        </th>
                        <th class="text-center">
                            <p>Tuổi</p>
                            <p style="font-style:italic;">Age</p>
                        </th>
                    </tr>
                    <tbody data-bind="template: {foreach: fiAnimalList }">
                    <tr>
                        <td class="text-center">
                            <p data-bind="text: fiAnimalTypeVni"></p>
                            <p data-bind="text: fiAnimalType" style="font-style: italic"></p>
                        </td>
                        <td class="text-center" data-bind="text: fiOfficialMark">
                        </td>
                        <td class="text-center">
                            <p data-bind="text: fiBreedVni"></p>
                            <p data-bind="text: fiBreed" style="font-style: italic"></p>
                        </td>
                        <td class="text-center">
                            <p data-bind="visible: fiSex() == 1"> Đực </p>
                            <p data-bind="visible: fiSex() == 1" style="font-style: italic"> Male </p>
                            <p data-bind="visible: fiSex() == 2"> Cái </p>
                            <p data-bind="visible: fiSex() == 2" style="font-style: italic"> Female </p>

                        </td>
                        <td class="text-center" data-bind="text: fiAge">
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div style="padding: 0 2%;">
                    <p class="code">
                        Tổng số: <span style="font-weight: bold" data-bind="text: fiTotalVni"></span>
                    </p>
                    <p class="code">
                        <span style="font-style: italic">Total: </span><span style="font-weight: bold" data-bind="text: fiTotal"></span>
                    </p>
                    <div>
                        <h4 style="font-weight: bold; text-align: center">
                            II. XUẤT ĐI
                        </h4>
                        <h4 style="text-align: center">
                            DESTINATION OF THE ANIMAL/S
                        </h4>
                    </div>
                    <div style="display: flex">

                    <div style="width: 50%">
                        <p class="code">
                            Nước nhập hàng: <span style="font-weight: bold" data-bind="text: fiDestinationCountryNameVni"></span>&emsp;
                        </p>
                        <p>
                            <span style="font-style: italic">Country of destination: </span><span style="font-weight: bold" data-bind="text: fiDestinationCountryName"></span>&emsp;
                        </p>
                    </div>
                        <div style="width: 50%">
                            <p>
                                Phương tiện vận chuyển: <span style="font-weight: bold" data-bind="text: fiMeansTransportVni"></span>
                            </p>
                            <p class="code">
                                <span style="font-style: italic">Means of transport: </span><span style="font-weight: bold"
                                    data-bind="text: fiMeansTransport"></span>
                            </p>
                        </div>
                    </div>

                <p class="code">
                    Tên, địa chỉ người nhận hàng: <span style="font-weight: bold" data-bind="text: fiConsigneeNameAddressVni"></span>
                </p>
                <p class="code">
                    <span style="font-style: italic">Name and address of consignee: </span><span style="font-weight: bold"
                        data-bind="text: fiConsigneeNameAddress"></span>
                </p>
                <div>
                    <h4 style="font-weight: bold; text-align: center">
                        CHỨNG NHẬN KIỂM DỊCH
                    </h4>
                    <h4 style="text-align: center">
                        HEALTH CERTIFICATE
                    </h4>
                </div>
                <p class="code">
                    Tôi, bác sĩ thú y ký tên dưới đây chứng nhận số động vật trên đã được kiểm tra:
                </p>
                <p class="code">
                    I, the undersigned official Veterinarian certify that the animal/s described above was/were
                    examined:
                </p>
                <p>
                    a/ Không có biểu hiện lâm sàng bệnh truyền nhiễm trong ngày xuất phát.
                </p>
                <p style="font-style: italic">
                    Showed no clinical sign of contagious diseases on the day of shipment.
                </p>
                <p>
                    b/ Đáp ứng được các yêu cầu sau:
                </p>
                <p style="font-style: italic">
                    Satisfies / satisfy the following requirements:
                </p>
                    <p>
                        <span style="font-weight: bold" data-bind="text: fiHealthCertificate"></span>
                    </p>
                <p class="code" data-bind="visible: fiAttachmentID() == null">
                    <span style="font-weight: bold" data-bind="text: fiHealthCertificate"></span>
                </p>
                <p class="code" data-bind="visible: fiAttachmentID() != null">
                    <span>Nội dung trong đính kèm: </span><a data-bind="attr: {href: fiLinkDownContent}" download>Tải về</a>
                </p>
                </div>
                <div style="display: flex; margin-top: 20px">
                    <div style="width: 50%; padding-left: 10%">
                        <p>Giấy có giá trị đến: <span style="font-weight: bold" data-bind="date: fiHealthCertificateEndDate"></span></p>
                        <p><span style="font-style: italic">Valid up to:</span> <span style="font-weight: bold"
                                data-bind="date: fiHealthCertificateEndDate"></span></p>
                    </div>
                    <div style="width: 50%; padding-left: 10%">
                        <p>Giấy này làm tại: <span style="font-weight: bold" data-bind="text: fiSignResultPlaceVni"></span> ngày: <span
                                style="font-weight: bold" data-bind="date: fiSignResultDate"></span></p>
                        <p><span style="font-style: italic">Issued at: </span><span style="font-weight: bold"
                                data-bind="text: fiSignResultPlace"></span> on: <span style="font-weight: bold"
                                data-bind="date: fiSignResultDate"></span></p>
                    </div>
                </div>
                <div style="display: flex">
                    <div style="width: 50%; text-align: center">
                        <p><span style="font-weight: bold">Bác sĩ thú y </span><span style="font-style: italic">(Ký, ghi rõ họ tên)</span></p>
                        <p><span style="font-weight: bold">Veterinarian </span><span style="font-style: italic">(Signature, full name)</span></p>
                        <p style="font-weight: bold" data-bind="text: fiExpertName"></p>
                    </div>
                    <div style="width: 50%; text-align: center">
                        <p><span style="font-weight: bold">THỦ TRƯỞNG CƠ QUAN </span><span style="font-style: italic">(Ký, đóng dấu, ghi rõ họ tên)</span></p>
                        <p><span style="font-weight: bold">DIRECTOR </span><span style="font-style: italic">(Signature, stamp, full name)</span></p>
                        <p style="font-weight: bold" data-bind="text: fiSignResultName"></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <a class="btn green" data-bind="attr: {href: fiLinkDownGCN}" download>
                    <span><spring:message code="mard.01.gcn.tai_file"/></span>
                </a>
<%--                <a class="btn green" data-bind="click: $parent.yeuCauSuaGCN, visible: !hideEdit()">--%>
<%--                    <span><spring:message code="mard.01.gcn.xin_sua"/></span>--%>
<%--                </a>--%>
<%--                <a class="btn red" data-bind="click: $parent.yeuCauHuyGCN, visible: !hideCancel()">--%>
<%--                    <span><spring:message code="mard.01.gcn.xin_huy"/></span>--%>
<%--                </a>--%>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.dong"/>
                </button>
            </div>
        </div>
    </div>
</div>
