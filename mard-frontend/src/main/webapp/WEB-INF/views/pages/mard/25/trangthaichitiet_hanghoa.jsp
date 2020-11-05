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
                                                           data-bind="value : fiHSCode, hasFocus: true"
                                                           type="text"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <label>Trạng thái hồ sơ</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control"
                                                           data-bind="value : fiHSStatus, hasFocus: true"
                                                           type="text"/>
                                                </div>

                                            </div>
                                            <div class="col-md-12 margin-top-20">
                                                <div class="form-group nsw-text-center">
                                                    <button class="btn green margin-right-10" id="searchHoSo"
                                                            data-bind=""><i class="fa fa-search"></i> Tìm kiếm
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
                            <td class="text-center" data-bind="text: fiTrangThaiHangHoa"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-target="#modal_view"
                                   data-toggle="modal" data-bind="click: $parent.xemKQDGSPH.bind($data, $data, $index()),visible: $root.fiHSType()==3&&fiTrangThaiHangHoa()==28"><i
                                        class="fa fa-lg fa-eye tooltips"></i></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="click: $parent.guiSuaHangHoa.bind($data, $data, $index()),"><i
                                        class="fa fa-lg fa-send tooltips"></i></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="visible: $root.fiHSType()==3"><i
                                        class="fa fa-lg fa-file-word-o tooltips"></i></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind=""><i
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