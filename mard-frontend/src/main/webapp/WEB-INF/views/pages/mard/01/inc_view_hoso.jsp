<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 12/18/19
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div id="modal_xemhoso" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body">
            <div id="pageView" class="tab-content" style="display: flex">
                <div id="hoso" class="tab-pane fade active in col-md-12">
                    <h4 style="font-weight: bold; text-align: center">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        Độc lập - Tự do - Hạnh phúc
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        ------------
                    </h4>
                    <h4 style="font-weight: bold; text-align: center">
                        ĐƠN ĐĂNG KÝ KIỂM DỊCH ĐỘNG VẬT, SẢN PHẨM ĐỘNG VẬT XUẤT KHẨU
                    </h4>
                    <p class="code" style="font-weight: bold; text-align: center">
                        Số: <span data-bind="text: fiRegistrationNo"></span><b> /ĐK-KD</b>
                    </p>
                    <p class="code" style="font-weight: bold; text-align: center">
                        Kính gửi: <span data-bind="text: fiDepartmentNameVni"></span>
                    </p>
                    <p class="content">
                        Họ tên chủ hàng <span style="font-style: italic">(hoặc người đại diện)</span>: <span style="font-weight: bold" data-bind="text: fiExporterNameVni"></span>/
                        <span style="font-weight: bold" data-bind="text: fiExporterName"></span>
                    </p>
                    <p class="content">
                        Địa chỉ giao dịch: <span style="font-weight: bold" data-bind="text: fiExporterAdressVni"></span> /
                        <span style="font-weight: bold" data-bind="text: fiExporterAdress"></span>
                    </p>
                    <p class="content">
                        Chứng minh nhân dân số: <span style="font-weight: bold" data-bind="text: fiIdentityNumber"></span>
                        &emsp;Cấp ngày: <span style="font-weight: bold" data-bind="date: fiIdentityIssueDate"></span>
                        &emsp;Tại: <span style="font-weight: bold" data-bind="text: fiIdentityIssueAdress"></span>
                    </p>
                    <p class="content" style="display: flex">
                        <span style="width: 30%">Điên thoại: <span style="font-weight: bold" data-bind="text: fiExporterTel"></span> </span>
                        <span style="width: 30%">Fax: <span style="font-weight: bold" data-bind="text: fiExporterFax"></span> </span>
                        <span style="width: 30%">Email: <span style="font-weight: bold" data-bind="text: fiExporterEmail"></span></span>
                    </p>
                    <p class="content">
                        Đề nghị được làm thủ tục kiểm dịch số hàng sau:
                    </p>
                    <div data-bind="visible: fiObjectType() == 1">
                        <h3 style="font-size: 20px; font-weight: bold;">I/ ĐỘNG VẬT</h3>
                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <tr>
                            <tr class=" ">
                                <th valign="bottom" rowspan="2"><spring:message code="mard.01.table.col.STT"/></th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.ten_loai_dong_vat"/><br>
                                <spring:message
                                        code="mard.01.table.col.ten_loai_dong_vat_eng"/><br>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.ma_hs"/><br>
                                <spring:message
                                        code="mard.01.table.col.ma_hs_eng"/>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.giong"/><br>
                                <spring:message
                                        code="mard.01.table.col.giong_eng"/>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.tuoi"/><br>
                                <spring:message
                                        code="mard.01.table.col.tuoi_eng"/>
                            </th>
                            <th class="text-center" colspan="2">
                                <spring:message
                                        code="mard.01.table.col.tinh_biet"/><br>
                                <spring:message
                                        code="mard.01.table.col.tinh_biet_eng"/>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.so_luong_con"/><br>
                                <spring:message
                                        code="mard.01.table.col.so_luong_con_eng"/>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.khoi_luong"/><br>
                                <spring:message
                                        code="mard.01.table.col.khoi_luong_eng"/>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.don_vi_tinh"/><br>
                                <spring:message
                                        code="mard.01.table.col.don_vi_tinh_eng"/>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.muc_dich_su_dung"/><br>
                                <spring:message
                                        code="mard.01.table.col.muc_dich_su_dung_eng"/>
                            </th>
                            <th class="text-center" rowspan="2">
                                <spring:message
                                        code="mard.01.table.col.gia_tri"/><br>
                                <spring:message
                                        code="mard.01.table.col.gia_tri_eng"/>
                            </th>
                            </tr>
                            <tr>
                                <th class="text-center"><spring:message code="mard.01.table.col.duc"/></th>
                                <th class="text-center"><spring:message code="mard.01.table.col.cai"/></th>
                            </tr>
                            </tr>
                            <tbody data-bind="foreach: fiAnimalList">
                            <tr>
                                <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                <td class="text-center">
                                    <p data-bind="text: fiAnimalTypeVni"></p>
                                    <p style="font-style: italic" data-bind="text: fiAnimalType"></p>
                                </td>
                                <td class="text-center" data-bind="text: fiHSCode"></td>
                                <td class="text-center">
                                    <p data-bind="text: fiBreedVni"></p>
                                    <p style="font-style: italic" data-bind="text: fiBreed"></p>
                                </td>
                                <td class="text-center" data-bind="text: fiAge"></td>
                                <td class="text-center">
                                    <div data-bind="visible: fiSex() == '1'" style="display: inline">
                                        <input type="radio" value="1"
                                               checked="checked"
                                        />
                                    </div>
                                </td>
                                <td class="text-center">
                                    <div data-bind="visible: fiSex() == '2'" style="display: inline">
                                        <input type="radio" value="2"
                                               checked="checked"
                                        />
                                    </div>
                                </td>
                                <td class="text-center" data-bind="text: fiNumber"></td>
                                <td class="text-center" data-bind="text: fiAnimalNetWeight"></td>
                                <td class="text-center">
                                    <p data-bind="text: fiAnimalUnitVni"></p>
                                    <p style="font-style: italic" data-bind="text: fiAnimalUnit"></p>
                                </td>
                                <td class="text-center">
                                    <p data-bind="text: fiPurposeVni"></p>
                                    <p style="font-style: italic" data-bind="text: fiPurpose"></p>
                                </td>
                                <td class="text-center" data-bind="text: fiShipmentvalue"></td>
                            </tr>
                            </tbody>
                        </table>
                        <p class="content">
                            Tổng số<span style="font-style: italic">(viết bằng chữ)</span>: <span style="font-weight: bold" data-bind="text: fiTotalAnimalByCharVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiTotalAnimalByChar"></span>
                        </p>
                        <p class="content">
                            Nơi xuất phát: <span style="font-weight: bold" data-bind="text: fiDeparturePlaceOfAnimalVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiDeparturePlaceOfAnimal"></span>
                        </p>
                        <p class="content">
                            Tình trạng sức khoẻ động vật: <span style="font-weight: bold" data-bind="text: fiAnimalHealthStatus"></span>
                        </p>
                        <p class="content">
                            Số động vật trên xuất phát từ vùng/cơ sở an toàn với bệnh: <span style="font-weight: bold" data-bind="text: fiDiseaseSafeName"></span>
                            theo Quyết định số: <span style="font-weight: bold" data-bind="text: fiDecisionNo"></span>
                            Ngày: <span style="font-weight: bold" data-bind="date: fiDecisionDate"></span>
                            <span data-bind="visible: fiDecisionDepartment()">Của: <span style="font-weight: bold" data-bind="text: fiDecisionDepartment"></span></span>
                        </p>

                        <div data-bind="visible: fiTestList().length > 0">
                            <p class="content">
                                Số động vật trên đã được xét nghiệm các bệnh sau
<%--                                <span style="font-style: italic">(nếu có)</span>:--%>
                            </p>
                            <table  class="table table-striped table-bordered table-hover table-checkable order-column">
                                <tr class="">
                                    <th style="width: 50px;" class="text-center"><spring:message
                                            code="mard.01.table.col.STT"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.benh_xet_nghiem"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.ket_qua_xn_so"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.ngay_xn"/></th>
                                </tr>
                                <tbody data-bind="template: {foreach: fiTestList }">
                                <tr>
                                    <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                    <td class="text-center" data-bind="text: fiTestName"></td>
                                    <td class="text-right" data-bind="text: fiTestNumber"></td>
                                    <td class="text-center" data-bind="date: fiTestDate"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div data-bind="visible: fiVaccinList().length > 0">
                            <p class="content">
                                Số động vật trên đã được tiêm phòng vắc xin với các bệnh sau <span style="font-style: italic">(loại vắc xin, nơi sản xuất)</span>:
                            </p>
                            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                <tr class="">
                                    <th style="width: 50px;" class="text-center"><spring:message
                                            code="mard.01.table.col.STT"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.tiem_phong_benh"/></th>
                                    <th class="text-center"><spring:message
                                            code="mard.01.table.col.ngay_tiem_phong"/></th>
                                </tr>
                                <tbody data-bind="template: {foreach: fiVaccinList }">
                                <tr>
                                    <td class="text-center" data-bind="text: ($index() + 1)"></td>
                                    <td class="text-center" data-bind="text: fiVaccinationAgainstName"></td>
                                    <td class="text-center" data-bind="date: fiVaccinationAgainstDate"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div data-bind="visible: fiObjectType() == 2">
                        <h3 style="font-size: 20px; font-weight: bold;">I/ SẢN PHẨM ĐỘNG VẬT:</h3>
                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <tr class="">
                                <th style="width: 50px" class="text-center"><spring:message code="mard.01.table.col.STT"/></th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.ten_san_pham"/><br>
                                    <spring:message
                                            code="mard.01.table.col.ten_san_pham_eng"/><br>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.ma_hs"/><br>
                                    <spring:message
                                            code="mard.01.table.col.ma_hs_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.quy_cach_dong_goi"/><br>
                                    <spring:message
                                            code="mard.01.table.col.quy_cach_dong_goi_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.so_luong"/><br>
                                    <spring:message
                                            code="mard.01.table.col.so_luong_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.don_vi_tinh"/><br>
                                    <spring:message
                                            code="mard.01.table.col.don_vi_tinh_eng"/>

                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.khoi_luong"/><br>
                                    <spring:message
                                            code="mard.01.table.col.khoi_luong_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.don_vi_tinh_khoi_luong"/><br>
                                    <spring:message
                                            code="mard.01.table.col.don_vi_tinh_khoi_luong_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.muc_dich_su_dung"/><br>
                                    <spring:message
                                            code="mard.01.table.col.muc_dich_su_dung_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.gia_tri"/><br>
                                    <spring:message
                                            code="mard.01.table.col.gia_tri_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.mark_no"/><br>
                                    <spring:message
                                            code="mard.01.table.col.mark_no_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.ngay_san_xuat"/><br>
                                    <spring:message
                                            code="mard.01.table.col.ngay_san_xuat_eng"/>
                                </th>
                                <th class="text-center">
                                    <spring:message
                                            code="mard.01.table.col.so_dinh_danh"/><br>
                                    <spring:message
                                            code="mard.01.table.col.so_dinh_danh_eng"/>
                                </th>
                            </tr>
                            <tbody data-bind="foreach: fiAnimalProductList">
                            <tr>
                                <td class="text-center" data-bind="text: $index() + 1"></td>
                                <td class="text-center">
                                    <p data-bind="text: fiProductNameVni"></p>
                                    <span data-bind="text: fiProductName" style="font-style: italic"></span>
                                </td>
                                <td class="text-center" data-bind="text: fiHSCode"></td>
                                <td class="text-center">
                                    <p data-bind="text: fiPackageTypeVni"></p>
                                    <span data-bind="text: fiPackageType" style="font-style: italic"></span>
                                </td>
                                <td class="text-right" data-bind="text: fiNumber"></td>
                                <td class="text-center">
                                    <p data-bind="text: fiUnitVni"></p>
                                    <span data-bind="text: fiUnit" style="font-style: italic"></span>
                                </td>
                                <td class="text-right" data-bind="text: fiNetWeight"></td>
                                <td class="text-right">
                                    <p data-bind="text: fiNetWeightUnitVni"></p>
                                    <span data-bind="text: fiNetWeightUnit" style="font-style: italic"></span>
                                </td>
                                <td class="text-center">
                                    <p data-bind="text: fiPurposeVni"></p>
                                    <span data-bind="text: fiPurpose" style="font-style: italic"></span>
                                </td>
                                <td class="text-right" data-bind="text: fiShipmentvalue"></td>
                                <td class="text-right">
                                    <p data-bind="visible: fiMarkNo"><span data-bind="text: fiMarkNo"></span></p>
                                </td>
                                <td class="text-center" data-bind="date: fiFromDateProduct"></td>
                                <td class="text-center" data-bind="text: fiLotIdentificationNo"></td>
                            </tr>
                            </tbody>
                        </table>
                        <p class="content">
                            Tổng số<span style="font-style: italic">(viết bằng chữ)</span>: <span style="font-weight: bold" data-bind="text: fiTotalAnimalProductByCharVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiTotalAnimalProductByChar"></span>
                        </p>
                        <p class="content">
                            Số sản phẩm động vật trên đã được xét nghiệm các chỉ tiêu vệ sinh thú y theo kết quả xét nghiệm số:
                            <span style="font-weight: bold" data-bind="text: fiAnimalProductTestNo"></span>
                            Ngày: <span style="font-weight: bold" data-bind="date: fiAnimalProductTestDate"></span>
                            Của: <span style="font-weight: bold" data-bind="text: fiAnimalProductTestDepartment"></span><span style="font-style: italic">(nếu có).</span>
                        </p>
                        <div>
                            <p>
                                Nhiệt độ sản phẩm:
                                <span>
                                    <span>Nhiệt độ phòng</span>
                                    <i data-bind="visible: fiTemperatureProductName() == 1" class="fa fa-check-square-o"></i>
                                    <i data-bind="visible: fiTemperatureProductName() != 1" class="fa fa-square-o"></i>
                                </span>
                                <span>
                                    Làm mát
                                    <i data-bind="visible: fiTemperatureProductName() == 2" class="fa fa-check-square-o"></i>
                                    <i data-bind="visible: fiTemperatureProductName() != 2" class="fa fa-square-o"></i>
                                </span>
                                <span>
                                    Đông lạnh
                                    <i data-bind="visible: fiTemperatureProductName() == 3" class="fa fa-check-square-o"></i>
                                    <i data-bind="visible: fiTemperatureProductName() != 3" class="fa fa-square-o"></i>
                                </span>
                            </p>
                        </div>

                        <p class="content" data-bind="visible: fiProcessingNameAddressVni()">
                            Tên, địa chỉ nhà máy sản xuất, chế biến hàng: <span style="font-weight: bold" data-bind="text: fiProcessingNameAddressVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiProcessingNameAddress"></span>
                        </p>
                        <p class="content" style="display: flex">
                            <span style="width: 50%">Điện thoại: <span style="font-weight: bold" data-bind="text: fiProcessingTel"></span></span>
                            <span style="width: 50%">Fax: <span style="font-weight: bold" data-bind="text: fiProcessingFax"></span></span>
                        </p>
                        <p class="content" data-bind="visible: fiPortShipmentNameVni()">
                            Tên cảng xếp hàng: <span style="font-weight: bold" data-bind="text: fiPortShipmentNameVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiPortShipmentName"></span>
                        </p>
                        <p class="content" data-bind="visible: fiProcessingNumberRegistration()">
                            Số đăng ký của nhà máy sản xuất, chế biến hàng: <span style="font-weight: bold" data-bind="text: fiProcessingNumberRegistration"></span>
                        </p>
                        <p class="content" data-bind="visible: fiSlaughterHouseNameAddressVni()" >
                            Tên, địa chỉ nhà máy giết mổ, pha lóc: <span style="font-weight: bold" data-bind="text: fiSlaughterHouseNameAddressVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiSlaughterHouseNameAddress"></span>
                        </p>
                        <p class="content" style="display: flex"  data-bind="visible: fiSlaughterHouseNameAddressVni()">
                            <span style="width: 50%">Điện thoại: <span style="font-weight: bold" data-bind="text: fiSlaughterHouseTel"></span></span>
                            <span style="width: 50%">Fax: <span style="font-weight: bold" data-bind="text: fiSlaughterHouseFax"></span></span>
                        </p>
                        <p class="content" style="display: flex"  data-bind="visible: fiSlaughterHouseDate()">
                            <span style="width: 50%">Ngày giết mổ: <span style="font-weight: bold" data-bind="date: fiSlaughterHouseDate"></span></span>
                            <span style="width: 50%">Ngày pha lóc: <span style="font-weight: bold" data-bind="date: fiProcesssingDate"></span></span>
                        </p>

                    </div>
                    <div>
                        <h3 style="font-size: 20px; font-weight: bold;">II/ CÁC THÔNG TIN KHÁC:</h3>
                        <p class="content">
                            Tên, địa chỉ tổ chức, cá nhân nhập khẩu: <span style="font-weight: bold" data-bind="text: fiImporteNameAddressVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiImporteNameAddress"></span>
                        </p>
                        <p class="content" style="display: flex">
                            <span style="width: 30%">Điện thoại: <span style="font-weight: bold" data-bind="text: fiImporterTel"></span></span>
                            <span style="width: 30%">Fax: <span style="font-weight: bold" data-bind="text: fiImporterFax"></span></span>
                            <span style="width: 30%">Email: <span style="font-weight: bold" data-bind="text: fiImporterEmail"></span></span>
                        </p>
                        <p class="content">
                            Cửa khẩu xuất: <span style="font-weight: bold" data-bind="text: fiBordergateNameVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiBordergateName"></span>
                        </p>
                        <p class="content">
                            Thời gian hàng đến cửa khẩu xuất: <span style="font-weight: bold" data-bind="date: fiExpectingDateFrom"></span>
                            &emsp;Ngày khởi hành: <span style="font-weight: bold" data-bind="date: fiDepartureDateFrom"></span>
                        </p>
                        <p class="content" data-bind="visible: fiEntryPointNameVni()">
                            Cửa khẩu nhập: <span style="font-weight: bold" data-bind="text: fiEntryPointNameVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiEntryPointName"></span>
                        </p>
                        <p class="content">
                            Phương tiện vận chuyển: <span style="font-weight: bold" data-bind="text: fiMeansTransportNameVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiMeansTransportName"></span>
                        </p>
                        <p class="content" data-bind="visible: fiContaine()">
                            Số chì của công – tơ – nơ: <span style="font-weight: bold" data-bind="text: fiContaine"></span>
                        </p>
                        <p class="content">
                            Nước nhập khẩu: <span style="font-weight: bold" data-bind="text: fiImporterCountryNameVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiImporterCountryName"></span>
                            Nước quá cảnh<span style="font-style: italic">(nếu có)</span>: <span style="font-weight: bold" data-bind="text: fiTransitCountryNameVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiTransitCountryName"></span>
                        </p>
                        <p class="content">
                            Điều kiện bảo quản hàng trong vận chuyển: <span style="font-weight: bold" data-bind="text: fiConditionsTransport"></span>
                        </p>
                        <p class="content">
                            Các vật dụng khác có liên quan kèm theo trong vận chuyển: <span style="font-weight: bold" data-bind="text: fiOtherTransport"></span>
                        </p>
                        <p class="content">
                            Hồ sơ giấy tờ liên quan đến hàng vận chuyển gồm: <span style="font-weight: bold" data-bind="text: fiTransportAttrachFile"></span>
                        </p>
                        <p class="content">
                            Địa điểm cách ly kiểm dịch: <span style="font-weight: bold" data-bind="text: fiLocationQuarantineVni"></span> /
                            <span style="font-weight: bold" data-bind="text: fiLocationQuarantine"></span>
                        </p>
                        <p class="content">
                            Thời gian tiến hành kiểm dịch: <span style="font-weight: bold" data-bind="date: fiTimeQuarantine"></span>
                        </p>
                        <p class="content" data-bind="visible: fiEntryPointNameVni">
                            Tên cửa khẩu nhập: <span style="font-weight: bold" data-bind="text: fiEntryPointNameVni"></span>
                            <span style="font-weight: bold" data-bind="text: fiEntryPointName"></span>
                        </p>
                        <p class="content">
                            Nội dung chứng nhận kiểm dịch: <span style="font-weight: bold" data-bind="text: fiHealthCertificateContent"></span>
                        </p>
                        <p>Tôi xin cam đoan việc khai báo trên hoàn toàn đúng sự thật và cam kết chấp hành đúng pháp luật thú y.</p>
                    </div>
                    <div style="display: flex">
                        <div style="width: 50%; text-align: center" >
                            <div data-bind="visible: fiCheckPlace">
                                <h4 style="font-weight: bold">Ý KIẾN CỦA CƠ QUAN KIỂM DỊCH</h4>
                                <p>
                                    Đồng ý kiểm dịch tại địa điểm: <span style="font-weight: bold" data-bind="text: fiCheckPlace"></span>
                                </p>
                                <p>
                                    <span>Ngày: </span><span style="font-weight: bold" data-bind="date: fiCheckTime"></span>
                                </p>
                                <p>
                                    <span>Vào sổ đăng ký số: </span><span style="font-weight: bold" data-bind="text: fiRegistrationNo">   </span>
                                    <span>Ngày: </span><span style="font-weight: bold" data-bind="date: fiRegistrationDate">   </span>
                                </p>
                                <h5 style="font-weight: bold">KIỂM DỊCH VIÊN ĐỘNG VẬT</h5>
                                <p style="font-style: italic">(Ký, ghi rõ họ tên)</p>
                                <p style="font-weight: bold"
                                   data-bind="text: fiCreaterName"
                                ></p>
                            </div>
                        </div>
                        <div style="width: 50%; text-align: center">
                            <p>Đăng ký tại: <span style="font-weight: bold" data-bind="text: fiSignAddress"></span></p>
                            <p style="font-style:italic;"> Ngày <span data-bind="date: fiSignDate"></span></p>
                            <h5 style="font-weight: bold">TỔ CHỨC/CÁ NHÂN ĐĂNG KÝ</h5>
                            <p style="font-style: italic">(Ký, đóng dấu, ghi rõ họ tên)</p>
                            <p style="font-weight: bold" data-bind="text: fiExporterNameVni"></p>
                            <p style="font-style: italic" data-bind="text: fiExporterName"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer" style="">
            <div class="text-center">
                <button class="btn green" data-bind="click: function(){
                    $parent.downloadHS($data)
                }">
                    Tải xuống
                </button>
                <button class="btn" data-dismiss="modal">
                    <spring:message code="conmon.button.dong"/>
                </button>
            </div>
        </div>
    </div>
</div>
