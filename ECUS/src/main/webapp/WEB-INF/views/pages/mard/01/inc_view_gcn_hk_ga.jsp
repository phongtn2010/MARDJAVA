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
    <div id="modal_gcn_hk_ga" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body" style="padding: 15px 3%">
            <div id="pageView" class="tab-content" style="display: flex">
                <div style="width: 50%">
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
                    <h4 style="font-weight: bold; text-align: center">
                        GIẤY CHỨNG NHẬN KIỂM DỊCH THỊT GÀ VÀ SẢN PHẨM THỊT GÀ ĐÃ CHẾ BIẾN NHIỆT XUẤT KHẨU TỪ VIỆT NAM
                        SANG HONG KONG

                    </h4>
                    <h4 style="text-align: center">
                        HEALTH CERTIFICATE FOR HEAT – PROCESSED POULTRY MEAT AND MEAT PRODUCTS TO BE EXPORTED FROM VIET
                        NAM TO HONG KONG

                    </h4>
                    <p style="font-style: italic; text-align: center">
                        Số:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNo"></span>
                    </p>
                    <p style="font-style: italic; text-align: center">
                        Number:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNo"></span>
                    </p>
                </div>
                <div>
                    <div style="padding: 0 2%">
                    <p class="code">
                        Tên, địa chỉ người xuất hàng: <span style="font-weight: bold" data-bind="text: fiExportName"></span>,
                        <span style="font-weight: bold" data-bind="text: fiExportAdress"></span>
                    </p>
                    <p class="code">
                        <span style="font-style: italic">Name and address of exporter: </span><span style="font-weight: bold" data-bind="text: fiExportName"></span>,
                        <span style="font-weight: bold" data-bind="text: fiExportAdress"></span>
                    </p>
                    <p class="code" style="display: flex;">
                        <span style="width: 30%">Tel: <span style="font-weight: bold" data-bind="text: fiExporterTel"></span> </span>
                        <span style="width: 30%">Fax: <span style="font-weight: bold" data-bind="text: fiExporterFax"></span> </span>
                        <span style="width: 30%">Email: <span style="font-weight: bold" data-bind="text: fiExporterEmail"></span> </span>
                    </p>
                    <p class="code">
                        Tên, địa chỉ người nhận hàng: <span style="font-weight: bold" data-bind="text: fiConsigneeNameAddress"></span>
                    </p>
                    <p class="code">
                        <span style="font-style: italic">Name and address of consignee: </span><span style="font-weight: bold" data-bind="text: fiConsigneeNameAddress"></span>
                    </p>
                    <p class="code"  style="display: flex;">
                        <span style="width: 30%">Tel: <span style="font-weight: bold" data-bind="text: fiConsigneeTel"></span> </span>
                        <span style="width: 30%">Fax: <span style="font-weight: bold" data-bind="text: fiConsigneeFax"></span> </span>
                        <span style="width: 30%">Email: <span style="font-weight: bold" data-bind="text: fiConsigneeEmail"></span> </span>
                    </p>
                    </div>
                    <h4 style="text-align: center; font-weight: bold">Thông tin hàng hoá</h4>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <tr class="">
                            <th class="text-center">
                                <p>Loại sản phẩm</p>
                                <p style="font-style: italic;">Type of products </p>
                            </th>
                            <th class="text-center">
                                <p>Quy cách đóng gói </p>
                                <p style="font-style:italic;">Type of package </p>
                            </th>
                            <th class="text-center">
                                <p>Số kiện hàng </p>
                                <p style="font-style:italic;">Number of package </p>
                            </th>
                            <th class="text-center">
                                <p>Khối lượng </p>
                                <p style="font-style:italic;">Net weight </p>
                                <p style="font-style:italic;">(kg) </p>
                            </th>
                        </tr>
                        <tbody data-bind="template: {foreach: fiAnimalProductList }">
                        <tr>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiTypeProduct"></p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiPackageType"></p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiNumberPackage"><span data-bind="text: fiUnit"></span> </p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiNetWeight"><span data-bind="text: fiNetWeightUnitName"></span> </p>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div style="padding: 0 2%">
                        <div class="code">
                            <p>Tên, địa chỉ nhà máy giết mổ, pha lóc: <span style="font-weight: bold" data-bind="text: fiSlaughterHouseNameAddress"></span></p>
                            <p class="code">
                                <span style="font-style: italic">Name and address of the slaughterhouse and the processing facility: </span>
                                <span style="font-weight: bold" data-bind="text: fiSlaughterHouseNameAddress"></span>
                            </p>
                        </div>
                        <div style="display: flex">
                            <p style="width: 50%">Tel: <span style="font-weight: bold" data-bind="text: fiSlaughterHouseTel"></span></p>
                            <p style="width: 50%">Fax: <span style="font-weight: bold" data-bind="text: fiSlaughterHouseFax"></span></p>
                        </div>
                        <div class="code">
                            <p>Tên, địa chỉ nhà máy chế biến: <span style="font-weight: bold" data-bind="text: fiProcessingNameAddress"></span></p>
                            <p class="code">
                                <span style="font-style: italic">Name and address of the designed heat-processing facility: </span>
                                <span style="font-weight: bold" data-bind="text: fiProcessingNameAddress"></span>
                            </p>
                        </div>
                        <div style="display: flex">
                            <p style="width: 50%">Tel: <span style="font-weight: bold" data-bind="text: fiProcessingTel"></span></p>
                            <p style="width: 50%">Fax: <span style="font-weight: bold" data-bind="text: fiProcessingFax"></span></p>
                        </div>
                        <div style="display: flex">
                            <div class="code" style="width: 50%;">
                                <p>Ngày giết mổ: <span style="font-weight: bold" data-bind="date: fiDateSlaughter"></span></p>
                                <p class="code">
                                    <span style="font-style: italic">Date of slaughter: </span>
                                    <span style="font-weight: bold" data-bind="date: fiDateSlaughter"></span>
                                </p>
                            </div>
                            <div class="code" style="width: 50%;">
                                <p>Ngày pha lóc: <span style="font-weight: bold" data-bind="date: fiDateSProcessing"></span></p>
                                <p class="code">
                                    <span style="font-style: italic">Date of processing: </span>
                                    <span style="font-weight: bold" data-bind="date: fiDateSProcessing"></span>
                                </p>
                            </div>
                        </div>
                        <div style="display: flex">
                            <div class="code" style="width: 50%;">
                                <p>Ngày chế biến nhiệt: <span style="font-weight: bold" data-bind="date: fiDateHeatProcessing"></span></p>
                                <p class="code">
                                    <span style="font-style: italic">Date of heat - processing: </span>
                                    <span style="font-weight: bold" data-bind="date: fiDateHeatProcessing"></span>
                                </p>
                            </div>
                            <div class="code" style="width: 50%;">
                                <p>Hạn sử dụng: <span style="font-weight: bold" data-bind="date: fiDateExpiry"></span></p>
                                <p class="code">
                                    <span style="font-style: italic">Date of expiry: </span>
                                    <span style="font-weight: bold" data-bind="date: fiDateExpiry"></span>
                                </p>
                            </div>
                        </div>
                        <div style="display: flex">
                            <div class="code" style="width: 50%;">
                                <p>Tên cảng xếp hàng: <span style="font-weight: bold" data-bind="text: fiPortShipmentName"></span></p>
                                <p class="code">
                                    <span style="font-style: italic">Name of the port of shipment: </span>
                                    <span style="font-weight: bold" data-bind="text: fiPortShipmentName"></span>
                                </p>
                            </div>
                            <div class="code" style="width: 50%;">
                                <p>Ngày khởi hành: <span style="font-weight: bold" data-bind="date: fiDateDeparture"></span></p>
                                <p class="code">
                                    <span style="font-style: italic">Date of departure: </span>
                                    <span style="font-weight: bold" data-bind="date: fiDateDeparture"></span>
                                </p>
                            </div>
                        </div>
                        <div style="display: flex">
                            <div class="code" style="width: 50%;">
                                <p>Phương tiện vận chuyển: <span style="font-weight: bold" data-bind="text: fiMeansTransportName"></span></p>
                            </div>
                            <div class="code" style="width: 50%;">
                                <p>Cửa khẩu nhập tại Hong Kong: <span style="font-weight: bold" data-bind="text: fiEntryPointName"></span></p>
                                <p class="code">
                                    <span style="font-style: italic">Entry point in Hong Kong: </span>
                                    <span style="font-weight: bold" data-bind="text: fiEntryPointName"></span>
                                </p>
                            </div>
                        </div>
                        <div class="code">
                            <p>Số chì của công-tơ-nơ: <span style="font-weight: bold" data-bind="text: fiContaine"></span></p>
                            <p class="code">
                                <span style="font-style: italic">Identification number of the seal of the containers: </span>
                                <span style="font-weight: bold" data-bind="text: fiContaine"></span>
                            </p>
                        </div>
                    </div>
                    <div style="display: inline-block; width: 100%">
                        <div style="text-align: center; width: 100%">
                            <h4>CHỨNG NHẬN KIỂM DỊCH</h4>
                            <h4 style="font-weight: bold">HEALTH CERTIFICATE</h4>
                        </div>

                        <p>Tôi, bác sĩ thú y ký tên dưới đây chứng nhận số sản phẩm động vật nêu trên đáp ứng được các yêu
                            cầu sau:</p>
                        <p style="font-weight: bold; font-style: italic">I, the undersigned official Veterinarian certify
                            that the products described above satisfy the following requirements: </p>
                        <p>1. Thịt gia cầm và các sản phẩm từ thịt gia cầm đã qua chế biến nhiệt được lấy từ gia cầm/
                            <span style="font-weight: bold; font-style: italic">The heat-processed poultry meat and meat products are derived from poultry which are: </span></p>
                        <p>&emsp;(a) Được sinh ra và nuôi tại Việt Nam/
                            <span style="font-weight: bold; font-style: italic">Born and raised only in Viet Nam. </span></p>
                        <p>&emsp;(b) Được nuôi tại các trang trại được khẳng định không có ổ dịch cums gia cầm trước ngày giết mổ ít nhất 21 ngày
                            <span style="font-weight: bold; font-style: italic">/Raised at farms where no outbreak Avian Influenza has been confirmed for at least 21 days before the slaughter date.</span></p>
                        <p>&emsp;(c) Được giết mổ, pha lóc và chế biến tại cơ sở được Cơ quan thú y thẩm quyền của Việt Nam kiểm tra, giám sát và chấp thuận/
                            <span style="font-weight: bold; font-style: italic">Slaughtered, cut and processed at the facility which is supervised, inspected and approved by  Veterinary Competent Authority of Viet Nam. </span></p>
                        <p>&emsp;(d) Được kiểm dịch viên của Chính phủ kiểm tra trước và sau giết mổ tại cơ sở giết mổ đã được chấp thuận và khẳng định không có bất kỳ một bệnh truyền nhiễm nào của gia cầm/
                            <span style="font-weight: bold; font-style: italic">Confirmed to be free from any poultry infectious diseases as a consequence of ante-mortem and post-mortem inspection conducted by official inspectors of the Government at approved slaughter facility.</span></p>
                        <p>2. Thịt gia cầm và các sản phẩm từ thịt gia cầm đã qua chế biến nhiệt được bao gói bằng vật liệu hoặc dụng cụ chứa đựng sạch, vệ sinh và được vận chuyển bằng phương pháp nhằm tránh ô nhiễm với các tác nhân gây bệnh truyền nhiễm ở động vật trước khi xuất hàng/
                            <span style="font-weight: bold; font-style: italic">Heat-processed poultry meat or meat products are stored in clean and sanitary wrappings and/or containers and handled in a way to prevent contamination with pathogens of any animal infectious diseases prior to shipment. </span></p>
                        <p>3. Sản phẩm phù hợp cho người tiêu dùng/
                            <span style="font-weight: bold; font-style: italic">The products are fit for human consumption</span>.</p>
                        <p style="font-weight: bold" data-bind="text: fiHealthCertificate"></p>
                    </div>
                    <br>
                    <div style="display: flex">
                        <div style="width: 50%;">
                            <p><span style="font-weight: bold">Giấy có giá trị đến:  </span>
                                <span style="font-weight: bold" data-bind="date: fiHealthCertificateEndDate"></span>
                            </p>
                            <p><span style="font-weight: bold">Valid up to </span>
                                <span style="font-weight: bold" data-bind="date: fiHealthCertificateEndDate"></span>
                            </p>
                        </div>
                        <div style="width: 50%;">
                            <p><span style="font-weight: bold">Giấy này làm tại:  </span>
                                <span style="font-weight: bold" data-bind="text: fiSignResultPlace"></span>
                                <span>Ngày</span>
                                <span style="font-weight: bold" data-bind="date: fiSignResultDate"></span>
                            </p>
                            <p><span style="font-weight: bold">Issued at </span>
                                <span style="font-weight: bold" data-bind="text: fiSignResultPlace"></span>
                                <span>on</span>
                                <span style="font-weight: bold" data-bind="date: fiSignResultDate"></span>
                            </p>
                        </div>
                    </div>
                    <br>
                    <div style="display: flex">
                        <div style="width: 50%; text-align: center">
                            <p><span style="font-weight: bold">Bác sĩ thú y </span><span style="font-style: italic">(Ký, ghi rõ họ tên)</span>
                            </p>
                            <p><span style="font-weight: bold">Veterinarian </span><span style="font-style: italic">(Signature, full name)</span>
                            </p>
                            <p style="font-weight: bold" data-bind="text: fiExpertName"></p>
                        </div>
                        <div style="width: 50%; text-align: center">
                            <p><span style="font-weight: bold">THỦ TRƯỞNG CƠ QUAN </span><span
                                    style="font-style: italic">(Ký, đóng dấu, ghi rõ họ tên)</span></p>
                            <p><span style="font-weight: bold">DIRECTOR </span><span style="font-style: italic">(Signature, stamp, full name)</span>
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
