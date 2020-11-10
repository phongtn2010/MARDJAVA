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
    <fieldset>
    <div class="col-md-12 panel panel-primary">
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
                                                           data-bind="value : fiProName, hasFocus: true"
                                                           type="text"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>Trạng thái hồ sơ</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select class="form-control"  data-bind="options : lstProfileStatus, optionsValue : 'fiCatType',
                                                                     selectedText:fiHSTypeName,
                                                                     optionsText : 'fiCatTypeName',
                                                    value: fiHSStatus, enable: $root.isEditable(), event: {change: changeHoSoType(fiHSType())}">
                                                    </select>
                                                </div>

                                            </div>
                                            <div class="col-md-12 margin-top-20">
                                                <div class="form-group nsw-text-center">
                                                    <button class="btn green margin-right-10" id="searchHoSo"
                                                            data-bind="click: searchProduct"><i class="fa fa-search"></i> Tìm kiếm
                                                    </button><button class="btn green" data-bind="click: backBtn"
                                                                     data-bind=""><i class="fa fa-sign-out"></i> Thoát
                                                </button>
                                                </div>
                                            </div>

                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_stt"/></th>
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_ten"/></th>
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_nhomtacn"/></th>
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_macongnhan"/></th>
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_hangsanxuat"/></th>
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_nuocsanxuat"/></th>
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_khoiluong"/></th>
                            <th class="text-center"> <spring:message code="mard.25.tokhai.hang_hoa_grid_giatri"/></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.status"/></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.btn_xem_kqdgsph"/></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.btn_gui_sua"/></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.btn_xem_tbkqkt"/></th>
                            <th class="text-center"> <spring:message code="mard.25.hanghoa.btn_xem_lich_su"/></th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: mard25HangHoaItems">
                        <tr>
                            <td class="text-center" data-bind="text: $index() + 1"></td>
                            <td class="text-center" data-bind="text: fiProName"></td>
                            <td class="text-center" data-bind="text: $parent.getTenNhom(fiProIdNhom)"></td>
                            <td class="text-center" data-bind="text: fiProCode"></td>
                            <td class="text-center" data-bind="text: fiProMadeIn"></td>
                            <td class="text-center" data-bind="text: fiProCountryCode"></td>
                            <td class="text-center" data-bind="text: fiProductKL"></td>
                            <td class="text-center" data-bind="text: fiProValueUSD"></td>
                            <td class="text-center" data-bind="text: $parent.getTrangThaiHangHoa(fiTrangThaiHangHoa)"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-target="#modal_view"
                                   data-toggle="modal" data-bind="click: $parent.xemKQDGSPH.bind($data, $data, $index()),visible: $root.fiHSType()==3&&fiTrangThaiHangHoa>=28"><i
                                        class="fa fa-lg fa-eye tooltips"></i></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="click: $parent.guiSuaHangHoa.bind($data, $data, $index()),"><i
                                        class="fa fa-lg fa-send tooltips"></i></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="click: $parent.xemThongBao.bind($data, $data, $index()),visible: $root.fiHSType()==3&&fiTrangThaiHangHoa==44"><i
                                        class="fa fa-lg fa-file-word-o tooltips"></i></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="click: $root.showLSHH"><i
                                    class="fa fa-lg fa-history tooltips"></i></a>
                            </td>
                        </td>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </fieldset>
    <%@include file="inc_hanghoa_guisua.jsp"%>

    <%@include file="inc_hanghoa_thongbao_kqdgsph.jsp"%>
    <div id="modal_xemLichSuTacDong" class="modal container in modal-overflow"
         tabindex="-1"
         data-backdrop="static" data-keyboard="false">

    </div>
    <div id="modal_lichsuHangHoa" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: lichsuXuly"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Lịch sử hồ sơ: <span data-bind="text: fiHSCode"></span></b>
        </div>
        <div class="modal-body">
            <div class="tab-content" id="pageView">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th class="text-center" width="5%"><spring:message code="mard.xemgiayphep.stt" /></th>
                        <th class="text-center" width="10%">Đơn vị xử lý</th>
                        <th class="text-center" width="15%">Người xử lý</th>
                        <th class="text-center" width="10%">Thời gian</th>
                        <th class="text-center" width="30%">Nội dung</th>
                        <th class="text-center" width="15%">File đính kèm</th>
                        <th class="text-center" width="40%">Trạng thái</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: historyItems">
                    <tr>
                        <td data-bind="text: ($parent.historyPageingVM.currentPage() - 1)* $parent.historyPageingVM.pageSize() + $index() + 1"></td>
                        <td data-bind="text: fiNswSend"></td>
                        <td data-bind="text:'' "></td>
                        <td data-bind="datetime: fiNgayGui"></td>
                        <td data-bind="html: fiNoiDung"></td>
                        <td></td>
                        <td data-bind="text: $root.getProfileStatus(fiTrangThai())"></td>
                    </tr>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-md-12 nsw-text-right">
                        <div class="nsw-flr" data-bind="if: historyPageingVM.totalCount() > historyPageingVM.pageSize()">
                            <ul class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !historyPageingVM.firstPageActive() }" class="previous disabled"><a href="#" aria-label="First" data-bind="click: goToFirst">Trang đầu
                                </a></li>
                                <li data-bind="css: { disabled: !historyPageingVM.previousPageActive()  }" class="previous disabled"><a href="#" aria-label="Previous" data-bind="click: goToPrevious">Trang trước
                                </a></li>
                                <!-- ko foreach: historyPageingVM.getPages() -->
                                <li data-bind="css: { active: $data == $parent.historyPageingVM.currentPage() }"><a href="#" data-bind="text: $data, click: $parent.goToPage.bind($data)"></a></li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !historyPageingVM.nextPageActive() }" class="next"><a href="#" aria-label="Next" data-bind="click: goToNext">Trang sau
                                </a></li>
                                <li data-bind="css: { disabled: !historyPageingVM.lastPageActive() }" class="next"><a href="#" aria-label="Last" data-bind="click: goToLast">Trang cuối
                                </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="inc_thongbaoketqua.jsp" %>
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