<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="incLanguage.jsp" %>
<%@include file="inc_script.jsp" %>
<script type="text/javascript">
    var idHoSo = ${idHoSo};
    console.log('id ho so', idHoSo);
</script>
<div class="row" id="mardHangHoa25">
    <div class="col-md-12">
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="mard.25.ten_thu_tuc"/></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><spring:message
                                            code="common.tracuu.thong_tin_tim_kiem"/> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label>Tên hàng hóa</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control"
                                                           data-bind="value : fiHSCode, hasFocus: true"
                                                           type="text"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>Trạng thái hồ sơ</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control"
                                                           data-bind="value : fiTrangThaiHangHoa, hasFocus: true"
                                                           type="text"/>
                                                </div>

                                            </div>
                                            <div class="col-md-12 margin-top-20">
                                                <div class="form-group nsw-text-center">
                                                    <button class="btn green" id="searchHoSo"
                                                            data-bind=""><i class="fa fa-search"></i> Tìm kiếm
                                                    </button>
                                                </div>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
<%--                    <div class="row">--%>
<%--                        <div class="col col-md-6">--%>
<%--                            <!-- ko with: pagination -->--%>
<%--                            <spring:message code="common.tong"/> <b data-bind="text: totalCount()"></b> <spring:message--%>
<%--                                code="common.pager.ban_ghi"/>--%>
<%--                            <!-- /ko -->--%>
<%--                        </div>--%>
<%--                        <div class="col col-md-6 nsw-text-right">--%>
<%--                            <div class="nsw-flr">--%>
<%--                                <!-- ko with: pagination -->--%>
<%--                                <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">--%>
<%--                                    <li data-bind="css: { disabled: !firstPageActive() }">--%>
<%--                                        <a data-bind="click: goToFirst">Trang đầu</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !previousPageActive() }">--%>
<%--                                        <a data-bind="click: goToPrevious">Trang trước</a>--%>
<%--                                    </li>--%>
<%--                                    <!-- ko foreach: getPages() -->--%>
<%--                                    <li data-bind="css: { active: $parent.currentPage() === $data }">--%>
<%--                                        <a data-bind="click: $parent.goToPage, text: $data"></a>--%>
<%--                                    </li>--%>
<%--                                    <!-- /ko -->--%>
<%--                                    <li data-bind="css: { disabled: !nextPageActive() }">--%>
<%--                                        <a data-bind="click: goToNext">Trang sau</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !lastPageActive() }">--%>
<%--                                        <a data-bind="click: goToLast">Trang cuối</a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                                <!-- /ko -->--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> STT</th>
                            <th class="text-center"> Tên hàng hóa</th>
                            <th class="text-center"> Nhóm hàng hóa</th>
                            <th class="text-center"> Mã công nhận</th>
                            <th class="text-center"> Hãng sản xuất</th>
                            <th class="text-center"> Nước sản xuất</th>
                            <th class="text-center"> Khối lượng</th>
                            <th class="text-center"> Giá trị hàng hóa</th>
                            <th class="text-center"> Trạng thái hàng hóa</th>
                            <th class="text-center"> Xem KQĐGSPH (2c)</th>
                            <th class="text-center"> Gửi sửa</th>
                            <th class="text-center"> Xem  thông báo kết quả kiểm tra (2c)</th>
                            <th class="text-center"> Lịch sử tác động</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: mard25HangHoaItems">
                        <tr>
                            <td class="text-center" data-bind="text: $index() + 1"></td>
                            <td class="text-center" data-bind="text: fiProName"></td>
                            <td class="text-center" data-bind="text: fiProIdNhom"></td>
                            <td class="text-center" data-bind="text: fiProCode"></td>
                            <td class="text-center" data-bind="text: fiProMadeIn"></td>
                            <td class="text-center" data-bind="text: fiProCountryCode"></td>
                            <td class="text-center" data-bind="text: fiProductKL"></td>
                            <td class="text-center" data-bind="text: fiProValueUSD"></td>
                            <td class="text-center" data-bind="text: fiTrangThaiHangHoa"></td>
                            <td>
                                <a href="javascript:void(0)" data-bind=""><i
                                        class="fa fa-lg fa-send tooltips"></i></a>
                            </td>
                            <td>
                                <a href="javascript:void(0)" data-bind=""><i
                                        class="fa fa-lg fa-eye tooltips"></i></a>
                            </td>
                            <td>
                                <a href="javascript:void(0)" data-bind=""><i
                                        class="fa fa-lg fa-file-word-o tooltips"></i></a>
                            </td>
                            <td>
                                <a href="javascript:void(0)" data-bind=""><i
                                        class="fa fa-lg fa-history tooltips"></i></a>
                            </td>
                        </td>

                        </tr>
                        </tbody>
                    </table>
<%--                    <div class="row">--%>
<%--                        <div class="col col-md-6">--%>
<%--                            <!-- ko with: pagination -->--%>
<%--                            <spring:message code="common.tong"/> <b data-bind="text: totalCount()"></b> <spring:message--%>
<%--                                code="common.pager.ban_ghi"/>--%>
<%--                            <!-- /ko -->--%>
<%--                        </div>--%>
<%--                        <div class="col col-md-6 nsw-text-right">--%>
<%--                            <div class="nsw-flr">--%>
<%--                                <!-- ko with: pagination -->--%>
<%--                                <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">--%>
<%--                                    <li data-bind="css: { disabled: !firstPageActive() }">--%>
<%--                                        <a data-bind="click: goToFirst">Trang đầu</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !previousPageActive() }">--%>
<%--                                        <a data-bind="click: goToPrevious">Trang trước</a>--%>
<%--                                    </li>--%>
<%--                                    <!-- ko foreach: getPages() -->--%>
<%--                                    <li data-bind="css: { active: $parent.currentPage() === $data }">--%>
<%--                                        <a data-bind="click: $parent.goToPage, text: $data"></a>--%>
<%--                                    </li>--%>
<%--                                    <!-- /ko -->--%>
<%--                                    <li data-bind="css: { disabled: !nextPageActive() }">--%>
<%--                                        <a data-bind="click: goToNext">Trang sau</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !lastPageActive() }">--%>
<%--                                        <a data-bind="click: goToLast">Trang cuối</a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                                <!-- /ko -->--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
    .content {
        text-indent: 5%;
    }
</style>
<script type="text/javascript" src="<c:url value='/app/mard/25/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/viewHangHoa.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/FormVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/25/LichSuXuLy.js?v=${version}'/>"></script>