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
    <div id="modal_gcn_malay" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body" style="padding: 15px 3%">
            <div id="pageView" class="tab-content" style="display: flex">
                <div style="width: 50%">
                    <h4 style="font-weight: bold; text-align: center">
                        BỘ NÔNG NGHIỆP VÀ PHÁT TRIỂN NÔNG THÔN
                    </h4>
                    <h4 style="text-align: center">
                        MINISTRY OF AGRICULTURE & RURAL DEVELOPMENT
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        CỤC THÚ Y
                    </h4>
                    <h4 style="text-align: center">
                        DEPARTMENT OF ANIMAL HEALTH
                    </h4>
                    <h4 style="font-weight: bold; text-align: center; text-transform: uppercase" data-bind="text: fiDepartmentNameVni ">
                    </h4>
                    <h4 style="font-weight: bold; text-align: center; text-transform: uppercase" data-bind="text: fiDepartmentName ">
                    </h4>

                </div>
                <div id="hoso" class="tab-pane fade active in col-md-12" style="width: 50%">
                    <h4 style="font-weight: bold; text-align: center">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </h4>
                    <h4 style="text-align: center">
                        THE SOCIALIST REPUBLIC OF VIET NAM
                    </h4>
                    <h4 style="text-align: center">
                        ------------
                    </h4>
                </div>
            </div>
            <div>
                <div>
                    <span style="font-style: italic; text-align: left; padding-left: 2%">
                        No:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNoVni"></span>
                    </span>
                    <h4 style="font-weight: bold; text-align: center">
                        GIẤY CHỨNG NHẬN KIỂM DỊCH
                    </h4>
                    <h4 style="text-align: center">
                        INSPECTION CERTIFICATE
                    </h4>
<%--                    <p style="font-style: italic; text-align: center">--%>
<%--                        Số:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNoVni"></span>/CN-KDSPĐVXK--%>
<%--                    </p>--%>
<%--                    <p style="font-style: italic; text-align: center">--%>
<%--                        Number:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNoVni"></span>--%>
<%--                    </p>--%>
                </div>
                <div>
                    <div style="padding: 0 2%">
                        <p class="code">
                            Người gửi hàng: <span style="font-weight: bold" data-bind="text: fiConsignerName"></span>
                        </p>
                        <p class="code">
                            <span style="font-style: italic">Consigner: </span><span style="font-weight: bold" data-bind="text: fiConsignerAdress"></span>
                        </p>
                        <p class="code">
                            Người nhận hàng: <span style="font-weight: bold" data-bind="text: fiConsigneeNameAddress"></span>
                        </p>
                        <p class="code">
                            <span style="font-style: italic">Consignee: </span><span style="font-weight: bold" data-bind="text: fiConsigneeNameAddress"></span>
                        </p>
                    </div>
                    <br>
                    <h4 style="text-align: center; font-weight: bold">Thông tin hàng hoá</h4>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <tr class="">
                            <th class="text-center">
                                <p>Hàng hoá</p>
                                <p style="font-style: italic;">Commondity </p>
                            </th>
                            <th class="text-center">
                                <p>Số lượng </p>
                                <p style="font-style:italic;">Quantity </p>
                            </th>
                            <th class="text-center">
                                <p>Số mã hiệu </p>
                                <p style="font-style:italic;">Mark no </p>
                            </th>
                            <th class="text-center">
                                <p>Trọng lượng </p>
                                <p style="font-style:italic;">Net weight </p>
                                <p style="font-style:italic;">(kg) </p>
                            </th>
                        </tr>
                        <tbody data-bind="template: {foreach: fiAnimalProductList }">
                        <tr>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiCommodity"> </p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiQuantity"> </p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiMarkNo"></p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiNetWeight"><span data-bind="text: fiNetWeightUnitName"></span> </p>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div style="padding: 0 2%;">
                        <p class="code">
                            <span style="font-style: italic">Name and address of slaughterhouse: </span><span style="font-weight: bold" data-bind="text: fiSlaughterHouseNameAddress"></span>
                        </p>
                        <p>Tôi, bác sĩ thú y quốc gia ký tên dưới đây chứng nhận</p>
                        <p>I, the undersigned official veterinarian certify that</p>
                        <p>1. Thịt được chế biến từ những con vật đã được kiểm dịch sống và sau khi giết mổ không có bệnh lây, nhiễm trùng và ký sinh trùng phù hợp đối với người sử dụng.</p>
                        <p>&emsp;That the meat to which it relates was derived from animal inspected ante and post-mortem foundfree from any parasitic infectious and contagious disease and foundfit for human consumption</p>
                        <p>2. Tuân thủ mọi quy định cần thiết để đảm bảo an toàn về sức khoẻ trong chế biến, đóng gói và bảo quản.</p>
                        <p>&emsp;That all necessary precautions for prevention of danger to public health were taken in the dressing or preparing and packing of the meat.</p>
                        <p>3. Thịt có nguồn gốc từ vùng không có bệnh dịch tả lợn châu Phi và bệnh dịch tả trâu bò.</p>
                        <p>&emsp;The meal is originatedfrom an area which is duly free from African Swine Fever cold Rinderpest.</p>
                        <p>4, Gia súc lấy thịt được lấy từ những vùng không có triệu chứng lâm sàng về bệnh lở mồm long móng trong vòng 12 tháng trước khi giết mổ.</p>
                        <p>&emsp;The animal from which the meat derives originate from areas that have been free from clinical evidence offoot and mouth disease for 12 months prior to slaughter and.</p>
                        <p>5. Không có triệu chứng lâm sàng về bệnh lở mồm long móng trong vòng bán kính 100 km ở những vùng nói trong phần (4) trước khi giết mổ.</p>
                        <p>&emsp;There has been no clinical evidence of foot and mouth disease detected on any area within a 100 km radius of the areas mentioned be point (4) above prior to slaughter.</p>

                        <p style="font-weight: bold" data-bind="text: fiHealthCertificate"></p>
                    </div>
                    <br>
                    <div style="display: flex">
                        <div style="width: 50%;">
                            <p><span>Ngày ký: </span><span style="font-weight: bold" data-bind="date: fiSignResultDate"></span></p>
                            <p><span style="font-style: italic">Date of issue: </span><span style="font-weight: bold" data-bind="date: fiSignResultDate"></span></p>
                            <p><span>Giấy có giá trị đến: </span><span style="font-weight: bold" data-bind="date: fiHealthCertificateEndDate"></span></p>
                            <p><span style="font-style: italic">Valid up to: </span><span style="font-weight: bold" data-bind="date: fiHealthCertificateEndDate"></span></p>
                        </div>
                        <div style="width: 50%; text-align: center">
                            <p style="font-weight: bold">CƠ QUAN KIỂM DỊCH ĐỘNG VẬT KÝ TÊN VÀ ĐÓNG DẤU</p>
                            <p style="font-style: italic">Animal health organization signature and stamp</p>
                            </p>
                            <p style="font-weight: bold" data-bind="text: fiSignResultName"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <a class="btn green" data-bind="attr: {href: fiLinkFile}" download>
                    <span><spring:message code="mard.01.gcn.tai_file"/></span>
                </a>
                <a class="btn green" data-bind="click: $parent.yeuCauSuaGCN, visible: !hideEdit()">
                    <span><spring:message code="mard.01.gcn.xin_sua"/></span>
                </a>
                <a class="btn red" data-bind="click: $parent.yeuCauHuyGCN, visible: !hideCancel()">
                    <span><spring:message code="mard.01.gcn.xin_huy"/></span>
                </a>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.dong"/>
                </button>
            </div>
        </div>
    </div>
</div>
