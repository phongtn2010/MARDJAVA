<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div>
    <div id="mard08ViewHSModal" data-bind="with: selectedHoSo" class="modal container in modal-overflow" tabindex="-1">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        </div>
        <div class="modal-body container" style="display: flex">
            <page size="a4" class="a4 col-md-12">
                <div class="text-center">
                    <h4 style="font-weight: bold;">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    </h4>
                    <h5 style="font-weight: bold">
                        Độc lập - Tự do - Hạnh phúc
                    </h5>

                    <div style="border-top: #000000 solid 1px; margin: auto; width: 160px"></div>
                </div>
                <div class="text-right" style="padding-top: 10px">
                    <h5 data-bind="visible: fiHSType == 1 || fiHSType == 2" class="text-border"
                        style="font-weight: bold">Mẫu 19</h5>
                    <h5 data-bind="visible: fiHSType == 3" class="text-border" style="font-weight: bold">Mẫu 20</h5>
                    <h5 data-bind="visible: fiHSType == 4 || fiHSType == 5" class="text-border"
                        style="font-weight: bold">Mẫu 20a</h5>
                </div>
                <div class="text-center" style="padding-top: 15px;" id="tenThuTuc">
                    <h4 data-bind="visible: fiHSType == 1 || fiHSType == 2" class="uppercase" style="font-weight: bold">
                        Đơn đăng ký kiểm dịch động vật, sản phẩm động vật nhập khẩu</h4>
                    <h4 data-bind="visible: fiHSType == 3" class="uppercase" style="font-weight: bold">Đơn đăng ký kiểm
                        dịch nhập khẩu bột thịt xương</h4>
                    <h4 data-bind="visible: fiHSType == 4 || fiHSType == 5" class="uppercase" style="font-weight: bold">
                        Đơn đăng ký kiểm tra xác nhận chất lượng thức ăn chăn nuôi, thức ăn thủy sản có nguồn gốc động
                        vật nhập khẩu</h4>
                    <h5 class="code" style="font-weight: bold">Kính gửi: Cục Thú y</h5>
                </div>
                <p class="content" style="margin-top: 15px;">
                    <span>Tên tổ chức, cá nhân: </span><b data-bind="text: fiImporterName"></b>
                </p>
                <p class="content">
                    <span>Địa chỉ: </span><b data-bind="text: fiImporterAddress"></b>
                </p>
                <p class="content">
                    <span>Số điện thoại: </span><b data-bind="text: fiImporterTel"></b>
                </p>
                <p class="content">
                    <span>Fax: </span><b data-bind="text: fiImporterFax"></b>
                </p>
                <p class="content">
                    <span>Email: </span><b data-bind="text: fiImporterEmail"></b>
                </p>
                <div data-bind="visible: fiHSType == 4 || fiHSType == 5">
                    <p class="content">
                        Thông tin bên bán hàng:
                    </p>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr>
                            <th width="5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.hang_nuoc"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_ben_ban_hang"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.dien_thoai"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.fax"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.dia_chi"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstExporter">
                        <tr>
                            <td data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiExporterName">
                            </td>
                            <td data-bind="text : $root.getCountryName(fiCountryOrigin)"></td>
                            </td>
                            <td data-bind="text : fiExporterTel"></td>
                            <td data-bind="text : fiExporterFax"></td>
                            <td data-bind="text : fiExporterAddress"></td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="content">
                        Nơi xuất hàng: <span data-bind="text: fiSrcPortName"></span>
                    </p>
                    <p class="content">
                        Bên mua hàng: <b data-bind="text: fiBuyerName"></b>
                    </p>
                    <p class="content">
                        Điện thoại bên mua: <b data-bind="text: fiBuyerTel"></b> / Địa chỉ: <b
                            data-bind="text: fiBuyerAddress"></b>
                    </p>
                    <p class="content">
                        Nơi nhận hàng: <b data-bind="text: fiDstPortName"></b>
                    </p>
                    <p class="content">
                        Thời gian nhập khẩu dự kiến từ: <b data-bind="date: fiImportingDateFrom"></b> / Đến: <b
                            data-bind="date: fiImportingDateTo"></b>
                    </p>
                </div>
                <div data-bind="visible: fiHSType == 1">
                    <p class="content">
                        Đề nghị Cục Thú y hướng dẫn Công ty kiểm dịch nhập khẩu lô hàng:
                    </p>
                    <p class="content">
                        Thông tin động vật:
                    </p>
                    <table class="table table-striped table-bordered table-hover  order-column">
                        <thead>
                        <tr>
                            <th width="5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.ten_loai_dong_vat"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong_duc"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong_cai"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.don_vi_tinh"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_xuat_xu"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.cua_nhap_khau"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstProduct">
                        <tr>
                            <td data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiProductName">
                            </td>
                            <td class="text-right" data-bind="text : fiQtyMale">
                            </td>
                            <td class="text-right" data-bind="text : fiQtyFemale"></td>
                            <td data-bind="text : $root.getUnitName(fiUnitCode)"></td>
                            <td data-bind="text : $root.getCountryName(fiCountryOrigin)"></td>
                            <td data-bind="text : fiPortName"></td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="content">
                        Từ công ty: <span data-bind="foreach: lstExporter"><b data-bind="text: fiExporterName"></b>; </span>
                    </p>
                    <p class="content">
                        Địa điểm nuôi cách ly kiểm dịch: <span data-bind="foreach: lstIsolatedLocation"><b data-bind="text: fiIsoLocName"></b> (<b data-bind="text: fiIsoLocAddress"></b>); </span>
                    </p>
                    <p class="content">
                        Thời gian thực hiện: <b data-bind="text: fiProcessingDate"></b>
                    </p>
                    <p class="content">
                        Mục đích sử dụng: <b data-bind="text: fiIntendedPurpose"></b>
                    </p>
                    <p class="content">
                        Giấy tờ kèm theo: <b data-bind="text: fiProvidedDocument"></b>
                    </p>
                </div>
                <div data-bind="visible: fiHSType == 2">
                    <p class="content">
                        Đề nghị Cục Thú y hướng dẫn Công ty kiểm dịch nhập khẩu lô hàng:
                    </p>
                    <p class="content">
                        Thông tin sản phẩm động vật:
                    </p>
                    <table class="table table-striped table-bordered table-hover  order-column">
                        <thead>
                        <tr>
                            <th width="5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.ten_sp_dong_vat"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.don_vi_tinh"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_xuat_xu"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.cua_nhap_khau"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstProduct">
                        <tr>
                            <td data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiProductName"></td>
                            <td class="text-right" data-bind="text : fiNumber"></td>
                            <td data-bind="text : $root.getUnitName(fiUnitCode)"></td>
                            <td data-bind="text : $root.getCountryName(fiCountryOrigin)"></td>
                            <td data-bind="text : fiPortName"></td>
                        </tr>
                        </tbody>
                    </table>
                    <div data-bind="visible: lstExporter.length > 0">
                        <p class="content">
                            Từ công ty: <span data-bind="foreach: lstExporter"><b data-bind="text: fiExporterName"></b>; </span>
                        </p>
                    </div>
                    <div data-bind="visible: lstProdMfr.length > 0">
                    <p class="content">
                        Từ Nhà máy sản xuất, chế biến: <span data-bind="foreach: lstProdMfr"><b data-bind="text: fiMfrName"></b>; </span>
                    </p>
                    </div>
                    <p class="content">
                        Thời gian thực hiện: <b data-bind="text: fiProcessingDate"></b>
                    </p>
                    <p class="content">
                        Mục đích sử dụng: <b data-bind="text: fiIntendedPurpose"></b>
                    </p>
                    <p class="content">
                        Giấy tờ kèm theo: <b data-bind="text: fiProvidedDocument"></b>
                    </p>
                </div>
                <div data-bind="visible: fiHSType == 3">
                    <p class="content">
                        Đề nghị Cục Thú y hướng dẫn Công ty kiểm dịch nhập khẩu lô hàng:
                    </p>
                    <p class="content">
                        Thông tin hàng hóa:
                    </p>
                    <table class="table table-striped table-bordered table-hover  order-column">
                        <thead>
                        <tr>
                            <th width="5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.ten_hang"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.don_vi_tinh"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_xuat_xu"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.cua_nhap_khau"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstProduct">
                        <tr>
                            <td data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiProductName"></td>
                            <td class="text-right" data-bind="text : fiNumber"></td>
                            <td data-bind="text : $root.getUnitName(fiUnitCode)"></td>
                            <td data-bind="text : $root.getCountryName(fiCountryOrigin)"></td>
                            <td data-bind="text : fiPortName"></td>
                        </tr>
                        </tbody>
                    </table>
                    <div data-bind="visible: lstExporter.length > 0">
                        <p class="content">
                            Từ công ty: <span data-bind="foreach: lstExporter"><b data-bind="text: fiExporterName"></b>; </span>
                        </p>
                    </div>
                    <div data-bind="visible: lstProdMfr.length > 0">
                        <p class="content">
                            Từ Nhà máy sản xuất, chế biến: <span data-bind="foreach: lstProdMfr"><b data-bind="text: fiMfrName"></b>; </span>
                        </p>
                    </div>
                    <div data-bind="visible: lstMfgFactory.length > 0">
                    <p class="content">
                        Địa điểm nhà máy sản xuất thức ăn chăn nuôi của Công ty: <span data-bind="foreach: lstMfgFactory"><b data-bind="text: fiFactoryName"></b> (<b data-bind="text: fiFactoryAddress"></b>); </span>
                    </p>
                    </div>
                    <p class="content">
                        Thời gian thực hiện: <b data-bind="text: fiProcessingDate"></b>
                    </p>
                    <p class="content">
                        Mục đích sử dụng: <b data-bind="text: fiIntendedPurpose"></b>
                    </p>
                    <p class="content">
                        Giấy tờ kèm theo: <b data-bind="text: fiProvidedDocument"></b>
                    </p>
                </div>
                <div data-bind="visible: fiHSType == 4 || fiHSType == 5">
                    <p class="content">
                        Thông tin hàng hóa:
                    </p>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr>
                            <th width="5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.ten_hang"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.ten_khoa_hoc"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_luong"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.loai_bao_bi"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.cach_dong_goi"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.khoi_luong_tinh"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.don_vi_tinh_khoi_luong_tinh"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.khoi_luong_ca_bi"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.don_vi_tinh_khoi_luong_ca_bi"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_xuat_xu"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.so_cong_nhan_tacn"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstProduct">
                        <tr>
                            <td data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiProductName">
                            </td>
                            <td data-bind="text : fiProductScienceName">
                            </td>
                            <td class="text-right" data-bind="text : fiNumber"></td>
                            <td data-bind="text : $root.getUnitName(fiUnitCode)"></td>
                            <td data-bind="text : fiPackingType"></td>
                            <td class="text-right" data-bind="text : fiNetWeight"></td>
                            <td data-bind="text : $root.getUnitName(fiNWUnitCode)"></td>
                            <td class="text-right" data-bind="text : fiGrossWeight"></td>
                            <td data-bind="text : $root.getUnitName(fiGWUnitCode)"></td>
                            <td data-bind="text : $root.getCountryName(fiCountryOrigin)"></td>
                            <td data-bind="text : fiCirculateNo"></td>
                        </tr>
                        </tbody>
                    </table>
                    <div data-bind="visible: lstProdMfr.length > 0">
                    <p class="content">
                        Thông tin cơ sở sản xuất:
                    </p>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr>
                            <th width="5%"><spring:message code="common.tokhai.hanghoa.stt"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.co_so_sx"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.dia_chi_cssx"/></th>
                            <th class="text-center"><spring:message
                                    code="mard.08.table.col.nuoc_sx"/></th>
                        </tr>
                        </thead>
                        <tbody
                                data-bind="foreach: lstProdMfr">
                        <tr>
                            <td class="text-center" data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text : fiMfrName"></td>
                            <td data-bind="text : fiMfrAddress"></td>
                            <td data-bind="text : $root.getCountryName(fiMfrCountryrigin)"></td>
                        </tr>
                        </tbody>
                    </table>
                    </div>
                    <p class="content">
                        Địa điểm tập kết hàng: <b data-bind="text: fiStorageLocation"></b>
                    </p>
                    <p class="content">
                        Ngày đăng ký lấy mẫu kiểm tra từ: <b data-bind="date: fiSamplingDateFrom"></b> / Đến: <b
                            data-bind="date: fiSamplingDateTo"></b>
                    </p>
                    <p class="content">
                        Địa điểm đăng ký lấy mẫu kiểm tra: <b data-bind="text: fiSamplingLocation"></b>
                    </p>
                    <p class="content">
                        Người liên hệ: <b data-bind="text: fiContactName"></b> Địa chỉ: <b
                            data-bind="text: fiContactAddress"></b> Email: <b data-bind="text: fiContactEmail"></b>
                    </p>
                    <p class="content">
                        Số điện thoại người liên hệ: <b data-bind="text: fiContactTel"></b>
                    </p>
                    <p class="content">
                        Mục đích sử dụng: <b data-bind="text: fiIntendedPurpose"></b>
                    </p>
                    <p class="content">
                        Văn bản chấp thuận kiểm dịch động vật nhập khẩu (nếu có): <b
                            data-bind="text: fiProvidedDocument"></b>
                    </p>
                </div>
                <div data-bind="visible: lstDocument.length > 0">
                    <p class="content">
                        Thông tin hợp đồng, hóa đơn, phiếu đóng gói:
                    </p>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr>
                            <th class="text-center" width="5%"><spring:message code="mard.08.documents.stt"/></th>
                            <th class="text-center" width="30%"><spring:message
                                    code="mard.08.documents.loaigiayto"/></th>
                            <th class="text-center" width="30%"><spring:message code="mard.08.documents.sogiayto"/></th>
                            <th class="text-center" width="25%"><spring:message code="mard.08.documents.ngaycap"/></th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstDocument">
                        <tr>
                            <td data-bind="text: $index() + 1"></td>
                            <td data-bind="text: $root.getDocName(fiTypeDoc)"></td>
                            <td data-bind="text: fiNumber"></td>
                            <td data-bind="date: fiDate"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <p class="content" data-bind="visible: fiHSType == 1 || fiHSType == 2">
                    Chúng tôi cam kết chấp hành nghiêm Pháp luật về Thú y.
                </p>
                <p class="content" data-bind="visible: fiHSType == 3">
                    Chúng tôi cam kết chỉ sử dụng bột thịt xương nhập khẩu của Công ty để sản xuất thức ăn cho loại động
                    vật nêu trên tại Nhà máy của Công ty và không sử dụng bột thịt xương để sản xuất thức ăn cho loài
                    nhai lại và cam kết chấp hành nghiêm Pháp luật về Thú y.
                </p>
                <p class="content" data-bind="visible: fiHSType == 4 || fiHSType == 5">
                    Chúng tôi xin cam kết: Bảo đảm nguyên trạng hàng hóa nhập khẩu, đưa về đúng địa điểm, đúng thời gian
                    được đăng ký và chỉ đưa hàng hóa ra lưu thông/sử dụng sau khi được quý cơ quan cấp giấy Chứng nhận
                    kiểm dịch và Giấy xác nhận chất lượng.
                </p>
                <div class="row">
                    <div class="col-md-6"></div>
                    <div class="col-md-6 text-center">
                        <h4 style="font-weight: bold" data-bind="text: fiSignedByTitle"></h4>
                        <h5 style="font-weight: bold" data-bind="text: fiSignedBy"></h5>
                    </div>
                </div>
            </page>
        </div>
        <div class="modal-footer">
            <div class="text-center">
                <a class="btn green" data-bind="click: function() { $root.taiMauHoSo($data) }">
                    <spring:message code="common.button.tai_ve"/>
                </a>
                <a class="btn" href="javascript:void(0)" data-dismiss="modal">
                    &nbsp;<spring:message code="conmon.button.dong"/>
                </a>
            </div>
        </div>
    </div>
</div>
<style>
    .text-border {
        border: 1px solid;
        display: inline;
        padding: 5px;
    }

    #tenThuTuc h4 {
        line-height: 1.5;
    }
</style>
