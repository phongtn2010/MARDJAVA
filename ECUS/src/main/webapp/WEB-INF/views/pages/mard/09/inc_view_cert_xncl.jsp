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
    <!-- ko with: currentQualityCert() -->
    <div id="modal_xemXNCL" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body container" style="display: flex">
            <page size="A4" class="a4-padding col-md-12">
                <h4 style="font-weight: bold; text-align: center">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                </h4>
                <h5 style="text-align: center">
                    Độc lập - Tự do - Hạnh phúc
                </h5>
                <h4 style="font-weight: bold; text-align: center">
                    The Socialist Republic of Vietnam
                </h4>
                <h5 style="text-align: center">
                    Independent - Freedom - Happiness
                </h5>

                <div style="width: 100px; height: 50px; border: solid 1px; display: flex; align-items: center; justify-content: center; position: absolute; top: 10px; right: 0px">
                    <b>Mẫu 19</b>
                </div>

                <div style="border-top: #000000 solid 1px; margin: auto; width: 320px"></div>
                <br/>
                <br/>
                <p class="code" >
                    Cơ quan cấp xác nhận chất lượng/Department issue the quality certificate: <span style="font-weight: bold" data-bind="text: fiDepartmentName"></span>
                </p>
                <p class="content">
                    Địa chỉ/Address: <span style="font-weight: bold" data-bind="text: fiDepartmentAddress"></span>
                </p>
                <p class="content">
                    Điên thoại/Tel: <span style="font-weight: bold" data-bind="text: fiDepartmentPhone"></span> Fax: <span style="font-weight: bold" data-bind="text: fiDepartmentFax"></span></span>
                </p>
                <h4 class="code" style="font-weight: bold; text-align: center">
                    <p>GIẤY XÁC NHẬN CHẤT LƯỢNG</p>
                    QUALITY CERTIFICATE
                </h4>
                <div style="width: 100%" class="col-md-12">
                    <div style="border: #000000 solid 1px; float: right; padding: 8px">
                        <span>Số/No: <span data-bind="text: fiQuanlityCerNo"/></span>
                    </div>
                </div>
                <div class="col-md-12">
                    <br/>
                </div>
                <div style="border: #000000 solid 1px" class="col-md-12">
                    <p><i><b>Bên bán hàng/Seller:</b></i></p>
                    <div class="col-md-6">
                        <p>Hãng/Nước/Country: <span style="font-weight: bold" data-bind="text: fiSellerStateName"/></p>
                    </div>
                    <div class="col-md-6">
                        <p>Địa chỉ/Address: <span style="font-weight: bold" data-bind="text: fiSellerAddress"/></p>
                    </div>
                    <div class="col-md-12">
                        <p>Điện thoại: <span style="font-weight: bold" data-bind="text: fiSellerPhone"/></p>
                    </div>
                    <div class="col-md-12">
                        <p><b>Nơi xuất hàng</b>/Port of departure: <span style="font-weight: bold" data-bind="text: fiPortOfDepartureName"/></p>
                    </div>
                </div>
                <div class="col-md-12">
                    <br/>
                </div>
                <div style="border: #000000 solid 1px" class="col-md-12">
                    <p><i><b>Bên mua hàng/Buyer:</b></i></p>
                    <div class="col-md-6">
                        <p>Tên bên mua hàng/Name: <span style="font-weight: bold" data-bind="text: fiBuyerName"/></p>
                    </div>
                    <div class="col-md-6">
                        <p>Địa chỉ/Address: <span style="font-weight: bold" data-bind="text: fiBuyerAddress"/></p>
                    </div>
                    <div class="col-md-12">
                        <p>Điện thoại: <span style="font-weight: bold" data-bind="text: fiBuyerPhone"/></p>
                    </div>
                    <div class="col-md-12">
                        <p><b>Nơi nhận hàng</b>/Port of destination: <span style="font-weight: bold" data-bind="text: fiPortOfDestinationName"/></p>
                    </div>
                </div>

                <div class="col-md-12">
                    <br/>
                </div>

                <p class="content">
                    <u><b>Hàng hóa/Goods</b></u>
                </p>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th style="width: 5%" rowspan="2">STT</th>
                        <th rowspan="2">Tên hàng hóa</th>
                        <th rowspan="2">Số lượng/khối  lượng</th>
                        <th rowspan="2">Đơn vị tính số lượng/khối lượng</th>
                        <th rowspan="2">Mô tả hàng hóa</th>
                        <th rowspan="2">Kết quả</th>
                        <th rowspan="2">Lý do</th>

                    </tr>
                    </thead>
                    <tbody data-bind="foreach: lstGood">
                    <tr>
                        <td style="width: 5%" data-bind="text: $index() + 1"></td>
                        <td data-bind="text: fiProductName"></td>
                        <td data-bind="text: fiNumber"></td>
                        <td class="text-right" data-bind="text: fiUnitName"></td>
                        <td data-bind="text: fiDescriptionOfGoods"></td>
                        <td data-bind="text: fiResult() == 0 ? 'Không  đạt' : 'Đạt' "></td>
                        <td data-bind="text: fiReason"></td>
                    </tr>
                    </tbody>
                </table>

                <div class="col-md-12">
                    <br/>
                </div>

                <div>
                    <p>Căn cứ vào giấy đăng ký kiểm tra xác nhận chất lượng số <span style="font-weight: bold" data-bind="text: fiRegistrationComfirmNo"></span> và kết quả phân tích chất lượng số <span style="font-weight: bold" data-bind="text: $parent.fiCriteriaAnalysisNoText"></span></p>
                </div>

                <div class="col-md-12">
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                </div>

                <div style="float: right; text-align: center">
                    <p><span data-bind="text: fiSignResultAddress"></span>, ngày <span data-bind="date: fiSignResultDate"></span></p>
                    <p><i><b>ĐẠI DIỆN CƠ QUAN KIỂM TRA</b></i></p>
                    <p><i>Representative of inspection body</i></p>
                    <p><i>(Ký tên, đóng dấu)</i></p>
                    <span data-bind="text: fiSignResultName"></span>
                </div>

            </page>
        </div>
        <div class="modal-footer">
<%--            <a class="btn green" data-bind="attr: {href: fiLinkFile}" target="_blank">--%>
<%--                Tải file--%>
<%--            </a>--%>
        </div>
    </div>
    <!-- /ko -->
</div>
