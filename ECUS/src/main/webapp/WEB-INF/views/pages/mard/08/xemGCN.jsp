<%--
    Document   : xemGCN
    Created on : Sep 22, 2017, 10:40:42 PM
    Author     : hieptran
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="modal-scrollable" style="z-index: 100051; display: none" id="gcn08View">
    <div class="modal fade in modal-overflow" tabindex="-1" data-width="1200"
         aria-hidden="false" style="display: block;width: 1200px;margin-left: -599px;margin-top: 0px;">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                    data-bind="click: closeModal"></button>
            <b class="modal-title"></b>
        </div>
        <div class="modal-body">
            <div>
                <div class="col-md-12">
                    <div class="panel">
                        <div class="tabbable-custom">
                            <ul class="nav nav-tabs">
                                <li class="active">
                                    <a href="#tab_cert_mard08_1" data-toggle="tab" aria-expanded="true"
                                       data-bind="click: showCV1"> <b>Xem Công văn VSTY</b></a>
                                </li>
                                <li class="">
                                    <a href="#tab_cert_mard08_2" data-toggle="tab" aria-expanded="false"
                                       data-bind="click: showCV2"> <b>Xem Công văn CNKD</b></a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-container tab-pane active" id="tab_cert_mard08_1" style="display: flex">
                                    <div style="margin-top: 15px;">
                                        <div class="col-md-4">
                                            <div style="margin-top: -15px; text-align: center">
                                                <h4 class="h4">BỘ NÔNG NGHIỆP</h4>
                                                <h4 class="h4">VÀ PHÁT TRIỂN NÔNG THÔN</h4>
                                                <h4 class="h4">CỤC THÚ Y</h4>
                                                <!--  -->
                                                <hr class="hr"
                                                    style="border-top: 1px solid #000; width: 100px; margin: auto">
                                                <h5 class="h5">
                                                    <span class="lbl">Số:&nbsp;<span class="inputrow w50"
                                                                                     data-bind="text: vsty.fiDispatchNo"></span></span>
                                                    <br/>
                                                    <span>V/v: <span data-bind="text: vsty.fiSummary"></span></span>
                                                </h5>
                                                <p></p>
                                            </div>
                                        </div>
                                        <div class="col-md-8" style="text-align: center">
                                            <h4 class="h4">CỘNG HOÀ XÃ HỘI CHỦ NGHĨA VIỆT NAM</h4>
                                            <h5 class="h5">Độc lập – Tự do – Hạnh phúc</h5>
                                            <hr class="hr"
                                                style="border-top: 1px solid #000;width: 100px; margin: auto">
                                            <div class="row" style="float: right;margin-top: 30px;margin-right: 30px;">
                                                <i><span class="dot" data-bind="text: vsty.fiSignConfirmAddress"></span></i>
                                                <i><span class="lbl"
                                                         data-bind="text: vsty.fiSignConfirmDate"></span></i>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="row">
                                                <p align="center" style="padding-bottom: 20px; margin-top:30px;">
                                                    <span>Kính gửi: <b data-bind="text: vsty.hosoCompanyName"></b></span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2">
                                            <div class="row">
                                                <p>
                                                    <span data-bind="text: vsty.fiPreamble"></span>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover order-column">
                                                    <thead class="nsw-tr tr-nsw1-bgcolor">
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Loại giống</th>
                                                        <th>Số lượng</th>
                                                        <th>Đơn vị</th>
                                                        <th>Ảnh gốc</th>
                                                        <th>Cửa khẩu nhập</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody data-bind="foreach: vsty.lstAnimal">
                                                    <tr>
                                                        <td data-bind="text: index"></td>
                                                        <td
                                                                data-bind="text: fiAnimalName"></td>
                                                        <td
                                                                data-bind="text: fiQty"></td>
                                                        <td
                                                                data-bind="text: fiUnitCode"></td>
                                                        <td>Ảnh gốc</td>
                                                        <td
                                                                data-bind="text: fiPortName"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover order-column">
                                                    <thead class="nsw-tr tr-nsw1-bgcolor">
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Tên công ty xuất khẩu</th>
                                                        <th>Địa chỉ công ty xuất khẩu</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody data-bind="foreach: vsty.lstCompany">
                                                    <tr>
                                                        <td data-bind="text: index"></td>
                                                        <td data-bind="text: fiExporterName"></td>
                                                        <td data-bind="text: fiExporterAddress"></td>
                                                    </tr>
                                                    <!-- /ko -->
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover order-column">
                                                    <thead class="nsw-tr tr-nsw1-bgcolor">
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Tên nơi cách ly kiểm dịch</th>
                                                        <th>Địa điểm nuôi cách ly kiểm dịch</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody data-bind="foreach: vsty.lstIsoLoc">
                                                    <tr>
                                                        <td data-bind="text: index"></td>
                                                        <td data-bind="text: fiIsoLocName"></td>
                                                        <td data-bind="text: fiIsoLocAddress"></td>
                                                    </tr>
                                                    <!-- /ko -->
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>


                                        <div class="col-md-8 col-md-offset-2">
                                            <div class="row form-group">
                                                <p>Thời gian thực hiện đến: &nbsp;<b
                                                        data-bind="date: vsty.fiExecutionTime"></b></p>
                                                <p>Mục đích sử dụng: &nbsp;<b data-bind="text: vsty.fiPurpose"></b></p>
                                            </div>
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="row form-group">
                                                <p>Cục Thú y có ý kiến như sau: &nbsp;</p>
                                                <div data-bind="html: vsty.fiContent"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2" style="padding-top: 50px;">
                                            <div class="col-md-4">
                                                <h5>
                                                    <b>Nơi nhận:</b><br>
                                                    <p data-bind="html: vsty.fiRecipient"></p>
                                                </h5>
                                            </div>
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4">
                                                <h5 align="center">
                                                    <b>CỤC TRƯỞNG</b><br>
                                                    <i>(Ký tên, đóng dấu)</i>
                                                </h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-container tab-pane" id="tab_cert_mard08_2" style="display: flex">
                                    <div style="margin-top: 15px;">
                                        <div class="col-md-4">
                                            <div style="margin-top: -15px; text-align: center">
                                                <h4 class="h4">BỘ NÔNG NGHIỆP</h4>
                                                <h4 class="h4">VÀ PHÁT TRIỂN NÔNG THÔN</h4>
                                                <h4 class="h4">CỤC THÚ Y</h4>
                                                <!--  -->
                                                <hr class="hr"
                                                    style="border-top: 1px solid #000; width: 100px; margin: auto">
                                                <h5 class="h5">
                                                    <span class="lbl">Số:&nbsp;<span class="inputrow w50"
                                                                                     data-bind="text: cnkd.fiQuarantineNo"></span></span>
                                                    <br/>
                                                    <span>V/v: <span data-bind="text: cnkd.fiSummary"></span></span>
                                                </h5>
                                                <p></p>
                                            </div>
                                        </div>
                                        <div class="col-md-8" style="text-align: center">
                                            <h4 class="h4">CỘNG HOÀ XÃ HỘI CHỦ NGHĨA VIỆT NAM</h4>
                                            <h5 class="h5">Độc lập – Tự do – Hạnh phúc</h5>
                                            <hr class="hr"
                                                style="border-top: 1px solid #000;width: 100px; margin: auto">
                                            <div class="row" style="float: right;margin-top: 30px;margin-right: 30px;">
                                                <i><span class="dot" data-bind="text: cnkd.fiSignConfirmAddress"></span></i>
                                                <i><span class="lbl"
                                                         data-bind="text: cnkd.fiSignConfirmDate"></span></i>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <div class="row">
                                                <p align="center" style="padding-bottom: 20px; margin-top:30px;">
                                                    <span>Kính gửi: <b data-bind="text: cnkd.hosoCompanyName"></b></span>
                                                </p>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2">
                                            <div class="row">
                                                <p>
                                                    <span data-bind="text: cnkd.fiPreamble"></span>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover order-column">
                                                    <thead class="nsw-tr tr-nsw1-bgcolor">
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Loại giống</th>
                                                        <th>Số lượng</th>
                                                        <th>Đơn vị</th>
                                                        <th>Nguồn gốc</th>
                                                        <th>Cửa khẩu nhập</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody data-bind="foreach: cnkd.lstProduct">
                                                    <tr>
                                                        <td data-bind="text: index"></td>
                                                        <td data-bind="text: fiProductName"></td>
                                                        <td data-bind="text: fiNumber"></td>
                                                        <td data-bind="text: fiUnitCode"></td>
                                                        <td data-bind="text: fiCountryOrigin"></td>
                                                        <td data-bind="text: fiPortName"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover order-column">
                                                    <thead class="nsw-tr tr-nsw1-bgcolor">
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Tên công ty xuất khẩu</th>
                                                        <th>Địa chỉ công ty xuất khẩu</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody data-bind="foreach: cnkd.lstCompany">
                                                    <tr>
                                                        <td data-bind="text: index"></td>
                                                        <td data-bind="text: fiExporterName"></td>
                                                        <td data-bind="text: fiExporterAddress"></td>
                                                    </tr>
                                                    <!-- /ko -->
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover order-column">
                                                    <thead class="nsw-tr tr-nsw1-bgcolor">
                                                    <tr>
                                                        <th>STT</th>
                                                        <th>Tên nhà máy sản xuất</th>
                                                        <th>Địa chỉ nhà máy sản xuất
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody data-bind="foreach: cnkd.lstMfr">
                                                    <tr>
                                                        <td data-bind="text: index"></td>
                                                        <td data-bind="text: fiFactoryName"></td>
                                                        <td data-bind="text: fiFactoryAddress"></td>
                                                    </tr>
                                                    <!-- /ko -->
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>


                                        <div class="col-md-8 col-md-offset-2">
                                            <div class="row form-group">
                                                <p>Thời gian thực hiện đến: &nbsp;<b
                                                        data-bind="date: cnkd.fiExecutionTime"></b></p>
                                                <p>Mục đích sử dụng: &nbsp;<b data-bind="text: cnkd.fiPurpose"></b></p>
                                            </div>
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">

                                            <div class="row form-group">
                                                <p data-bind="text: cnkd.fiReportInfo">.</p>
                                                <p>Cục Thú y có ý kiến như sau: &nbsp;</p>
                                                <div data-bind="html: cnkd.fiContent"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-8 col-md-offset-2" style="padding-top: 50px;">
                                            <div class="col-md-4">
                                                <h5>
                                                    <b>Nơi nhận:</b><br>
                                                    <p data-bind="html: cnkd.fiRecipient"></p>
                                                </h5>
                                            </div>
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4">
                                                <h5 align="center">
                                                    <b>CỤC TRƯỞNG</b><br>
                                                    <i>(Ký tên, đóng dấu)</i>
                                                </h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
    table th, td {
        text-align: center;
    }
</style>
<script src="<c:url value='/app/mard/08/xemGCN.js' />" type="text/javascript"></script>
