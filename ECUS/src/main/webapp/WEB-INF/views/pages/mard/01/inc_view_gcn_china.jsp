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
    <div id="modal_gcn_china" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body" style="padding: 15px 3%;">
            <div id="pageView" class="tab-content" style="display: flex">
                <div style="width: 50%">
                    <h4 style="font-weight: bold; text-align: center">
                        BỘ NÔNG NGHIỆP VÀ PHÁT TRIỂN NÔNG THÔN
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        CỤC THÚ Y
                    </h4>
                    <h4 style="text-align: center">
                        MINISTRY OF AGRICULTURE & RURAL DEVELOPMENT
                    </h4>
                    <h4 style="text-align: center">
                        DEPARTMENT OF ANIMAL HEALTH
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        农业和农村发展部
                    </h4>
                    <h4 style="text-align: center">
                        兽医局
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
                        越南社会主义共和国
                    </h4>
                </div>
            </div>
            <div>
                <div>
                    <h4 style="font-weight: bold; text-align: center">
                        GIẤY CHỨNG NHẬN KIỂM DỊCH SỮA VÀ SẢN PHẨM SỮA XUẤT KHẨU TỪ VIỆT NAM SANG TRUNG QUỐC
                    </h4>
                    <h4 style="text-align: center">
                        HEALTH CERTIFICATE FOR MILK AND MILK PRODUCTS TO BE EXPORTED FROM VIET NAM TO CHINA
                    </h4>
                    <h4 style="text-align: center">
                        越南输华牛奶和牛奶制品卫生证书
                    </h4>
                    <p style="font-style: italic; text-align: center">
                        Số:<span style="font-weight: bold" data-bind="text: fiHealthCertificateNoVni"></span>
                    </p>
                    <p style="font-style: italic; text-align: center">
                        Number/证书编号 :<span style="font-weight: bold" data-bind="text: fiHealthCertificateNoVni"></span>
                    </p>
                </div>
                <div>
                    <div style="padding: 0 2%">
                        <p class="code">
                            Tên cơ quan kiểm dịch động vật/
                            <span style="font-style: italic">Name of animal quarantine organization</span>
                            /动物检疫机构名称: <span style="font-weight: bold" data-bind="text: fiAnimalQuarantineOrganizationName"></span>
                        </p>
                        <p class="code">
                            Tên địa chỉ người xuất hàng/
                            <span style="font-style: italic">Name and address of consignor</span>
                            /发货人名称和地址: <span style="font-weight: bold" data-bind="text: fiExportName"></span>/ <span style="font-weight: bold" data-bind="text: fiExportAdress"></span>
                        </p>
                        <div class="code" style="display: flex">
                            <p style="width: 30%">Tel/电话: <span style="font-weight: bold" data-bind="text: fiExporterTel"></span></p>
                            <p style="width: 30%">Fax/传真: <span style="font-weight: bold" data-bind="text: fiExporterFax"></span></p>
                            <p style="width: 30%">Email/电子邮件: <span style="font-weight: bold" data-bind="text: fiExporterEmail"></span></p>
                        </div>
                        <p class="code">
                            Tên địa chỉ người nhận hàng/
                            <span style="font-style: italic">Name and address of consignee</span>
                            /收货人名称和地址: <span style="font-weight: bold" data-bind="text: fiConsigneeNameAddress"></span>
                        </p>
                        <div class="code" style="display: flex">
                            <p style="width: 30%">Tel/电话: <span style="font-weight: bold" data-bind="text: fiConsigneeTel"></span></p>
                            <p style="width: 30%">Fax/传真: <span style="font-weight: bold" data-bind="text: fiConsigneeFax"></span></p>
                            <p style="width: 30%">Email/电子邮件: <span style="font-weight: bold" data-bind="text: fiConsigneeEmail"></span></p>
                        </div>
                    </div>

                    <h4 style="text-align: center; font-weight: bold">Thông tin hàng hoá</h4>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <tr class="">
                            <th class="text-center">
                                <p>Loại sản phẩm</p>
                                <p style="font-style: italic;">Type of products </p>
                                <p>产品类型</p>
                            </th>
                            <th class="text-center">
                                <p>Số lô sản xuất </p>
                                <p style="font-style:italic;">Batch number</p>
                                <p>批号</p>
                            </th>
                            <th class="text-center">
                                <p>Quy cách đóng gói</p>
                                <p style="font-style:italic;">Type of package</p>
                                <p>包装类型</p>
                            </th>
                            <th class="text-center">
                                <p>Số kiện hàng</p>
                                <p style="font-style:italic;">Number of package</p>
                                <p>件数</p>
                            </th>
                            <th class="text-center">
                                <p>Khối lượng </p>
                                <p style="font-style:italic;">Net weight </p>
                                <p>净重</p>
                                <p>(kg)</p>
                            </th>
                            <th class="text-center">
                                <p>Mã HS của sản phẩm</p>
                                <p style="font-style:italic;">Commodity (HS) code</p>
                                <p>商品HS编码</p>
                            </th>
                        </tr>
                        <tbody data-bind="template: {foreach: fiAnimalProductList }">
                        <tr>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiTypeProduct"></p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiBactchNumber"></p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiPackageType"> </p>
                            </td>
                            <td class="text-right">
                                <p style="font-weight: bold" data-bind="text: fiNumberPackage"></p>
                            </td>
                            <td class="text-right">
                                <p style="font-weight: bold" data-bind="text: fiNetWeight"><span data-bind="text: fiNetWeightUnitName"></span> </p>
                            </td>
                            <td class="text-center">
                                <p style="font-weight: bold" data-bind="text: fiHSCode"></p>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div style="padding: 0 2%">
                        <p class="code">
                            Nhiệt độ sản phẩm/
                            <span style="font-style: italic">Temperature of product</span>
                            <span>/产品储存温度:</span>
                        </p>
                        <div style="margin-left: 20px">
                            <p style="font-size: 12px">
                                <span>Nhiệt độ phòng/</span>
                                <span style="font-style: italic">Ambient</span>
                                /常温 :
                                <i data-bind="visible: fiTemperatureProductName() == 1" class="fa fa-check-square-o"></i>
                                <i data-bind="visible: fiTemperatureProductName() != 1" class="fa fa-square-o"></i>
                            </p>
                            <p style="font-size: 12px">
                                Làm mát/
                                <span style="font-style: italic">Chilled</span>
                                /冷藏 :
                                <i data-bind="visible: fiTemperatureProductName() == 2" class="fa fa-check-square-o"></i>
                                <i data-bind="visible: fiTemperatureProductName() != 2" class="fa fa-square-o"></i>
                            </p>
                            <p style="font-size: 12px">
                                Đông lạnh/
                                <span style="font-style: italic">Frozen</span>
                                /冷冻 :
                                <i data-bind="visible: fiTemperatureProductName() == 3" class="fa fa-check-square-o"></i>
                                <i data-bind="visible: fiTemperatureProductName() != 3" class="fa fa-square-o"></i>
                            </p>
                        </div>

                        <p class="code">
                            Tên, địa chỉ, số đăng ký của nhà máy sản xuất/
                            <span style="font-style: italic">Name, address and registration number of the processing facility</span>
                            /生产企业名称、地址和注册编号: <span style="font-weight: bold" data-bind="text: fiProcessingNameAddress"></span> /
                            <span style="font-weight: bold" data-bind="text: fiProcessingNumberRegistration"></span>
                        </p>
                        <div class="code" style="display: flex">
                            <p style="width: 50%">Tel/电话: <span style="font-weight: bold" data-bind="text: fiProcessingTel"></span></p>
                            <p style="width: 50%">Fax/传真: <span style="font-weight: bold" data-bind="text: fiProcessingFax"></span></p>
                        </div>
                        <div class="code" style="display: flex">
                            <p class="code" style="width: 50%">
                                Ngày sản xuất/
                                <span style="font-style: italic">Date of production </span>
                                /生产日期: <span style="font-weight: bold" data-bind="date: fiDateProduct"></span>
                            </p>
                            <p class="code"  style="width: 50%">
                                Ngày hết hạn/
                                <span style="font-style: italic">Expiry date</span>
                                /保质期: <span style="font-weight: bold" data-bind="date: fiDateExpiry"></span>
                            </p>
                        </div>
                        <div class="code" style="display: flex">
                            <p class="code"  style="width: 50%">
                                Tên cảng xếp hàng/
                                <span style="font-style: italic">Means of transport</span>
                                /运输工具: <span style="font-weight: bold" data-bind="text: fiPortShipmentName"></span>
                            </p>
                            <p class="code"  style="width: 50%">
                                Ngày khởi hành/
                                <span style="font-style: italic">Date of departure</span>
                                /启运日期: <span style="font-weight: bold" data-bind="date: fiDateDeparture"></span>
                            </p>
                        </div>
                        <div class="code" style="display: flex">
                            <div style="width: 50%">
                                <p class="code" >
                                    Phương tiện vận chuyển /
                                    <span style="font-style: italic">Means of transport</span>
                                    /运输工具:
                                </p>
                                <div style="font-size: 12px; margin-left: 20px">
                                    <p class="code">
                                        Hàng không /
                                        <span style="font-style: italic">Aeroplane </span>
                                        /飞机 :
                                        <i data-bind="visible: fiMeansTransportName() == 1" class="fa fa-check-square-o"></i>
                                        <i data-bind="visible: fiMeansTransportName() != 1" class="fa fa-square-o"></i>
                                    </p>
                                    <p class="code">
                                        Đường sắt /
                                        <span style="font-style: italic">Railway Wagon </span>
                                        /铁路货车 :
                                        <i data-bind="visible: fiMeansTransportName() == 2" class="fa fa-check-square-o"></i>
                                        <i data-bind="visible: fiMeansTransportName() != 2" class="fa fa-square-o"></i>
                                    </p>
                                    <p class="code">
                                        Đường bộ /
                                        <span style="font-style: italic">Road vehicle </span>
                                        /公路车辆 :
                                        <i data-bind="visible: fiMeansTransportName() == 3" class="fa fa-check-square-o"></i>
                                        <i data-bind="visible: fiMeansTransportName() != 3" class="fa fa-square-o"></i>
                                    </p>
                                    <p class="code">
                                        Đường thủy /
                                        <span style="font-style: italic">Ship</span>
                                        /船舶 :
                                        <i data-bind="visible: fiMeansTransportName() == 4" class="fa fa-check-square-o"></i>
                                        <i data-bind="visible: fiMeansTransportName() != 4" class="fa fa-square-o"></i>
                                    </p>
                                    <p class="code">
                                        Phương tiện khác /
                                        <span style="font-style: italic">Other</span>
                                        /其他 :
                                        <i data-bind="visible: fiMeansTransportName() == 5" class="fa fa-check-square-o"></i>
                                        <i data-bind="visible: fiMeansTransportName() != 5" class="fa fa-square-o"></i>
                                    </p>
                                </div>
                            </div>
                            <p class="code" style="width: 50%">
                                Cửa khẩu nhập tại Trung Quốc/
                                <span style="font-style: italic">Entry point in China</span>
                                /中国入境口岸: <span style="font-weight: bold" data-bind="text: fiEntryPointName"></span>
                            </p>

                        </div>
                        <p class="code">
                            Số chì của công-tơ-nơ/
                            <span style="font-style: italic">Identification number of the seal of the containers</span>
                            /集装箱铅封号: <span style="font-weight: bold" data-bind="text: fiContaine"></span>
                        </p>
                        <div style="text-align: center">
                            <h4>CHỨNG NHẬN KIỂM DỊCH/ HEALTH CERTIFICATE/ 卫生证明 </h4>
                        </div>
                        <p>Tôi, bác sĩ thú y, ký tên dưới đây chứng nhận/ I, the undersigned official veterinarian, certify
                            that/ 本人作为签发卫生证书的官方兽医证明</p>
                        <p>
                            Các sản phẩm sữa nêu trên đáp ứng các yêu cầu nêu trong Nghị định thư giữa Tổng cục Hải quan của Cộng hòa Nhân dân Trung Hoa và Bộ Nông nghiệp và Phát triển Nông thôn của Cộng hòa Xã hội Chủ nghĩa Việt Nam về các yêu cầu thú y và sức khỏe cộng đồng đối với các sản phẩm sữa được xuất khẩu từ Cộng hòa Xã hội Chủ nghĩa Việt Nam sang Cộng hòa Nhân dân Trung Hoa, và bảo đảm an toàn, phù hợp cho người tiêu dùng/
                            <span style="font-style: italic">The dairy products mentioned above comply with requirements laid down in the Protocol between the General Administration of Customs of the People’s Republic of China and the Ministry of Agriculture and Rural Development of the Socialist Republic of Viet Nam on veterinary and public health requirements for dairy products to be exported from the Socialist Republic of Viet Nam to the People’s Republic of China, and is safe, wholesome, and fit for human consumption/ </span>
                            <span>上述输华乳品符合《中华人民共和国海关总署和越南社会主义共和国农业与农村发展部关于越南社会主义共和国输华乳品动物卫生和公共卫生条件议定书》的要求，是安全、卫生的，适合人类食用。 </span>
                        </p>
                        <p style="font-weight: bold" data-bind="text: fiHealthCertificate"></p>
                    </div>
                    <div style="display: flex">
                        <div style="width: 50%">
                            <p>Giấy có giá trị đến: <span style="font-weight: bold" data-bind="date: fiHealthCertificateEndDate"></span></p>
                            <p><span style="font-style: italic">Valid up to:</span> <span style="font-weight: bold" data-bind="date: fiHealthCertificateEndDate"></span></p>
                        </div>
                        <div style="width: 50%">
                            <p>Giấy này làm tại: <span style="font-weight: bold" data-bind="text: fiSignResultPlace"></span> ngày: <span style="font-weight: bold" data-bind="date: fiSignResultDate"></span></p>
                            <p><span style="font-style: italic">Issued at: </span><span style="font-weight: bold" data-bind="text: fiSignResultPlace"></span> on: <span style="font-weight: bold" data-bind="date: fiSignResultDate"></span></p>
                        </div>
                    </div>
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
