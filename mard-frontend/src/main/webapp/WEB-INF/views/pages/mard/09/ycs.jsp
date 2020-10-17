
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="row" id="EditVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> Cấp Giấy chứng nhận kiểm dịch động vật, sản phẩm động vật trên cạn nhập khẩu; kiểm tra xác nhận chất lượng thức ăn chăn nuôi, thức ăn thủy sản có nguồn gốc động vật nhập khẩu.	</span>
                </div>
                <div style="margin-top: 5px;">
                    <a style="font-style: italic" href="/mard/09/hdsd">
                        <i class="fa fa-download" aria-hidden="true"></i><span>Tải hướng dẫn sử dụng</span>
                    </a>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mt_1" data-toggle="tab" id="a-tab-mt-1"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li data-bind="visible: showDinhKemTab">
                                        <a href="#tab_mt_2" data-toggle="tab" id="a-tab-mt-2"> <b>Danh sách tệp đính kèm</b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_mt_1" >
                                        <form role="form" class="form-horizontal">
                                            <%@include file="inc_xin_sua.jsp" %>
                                            <!-- ko with: thongtinChungVM() -->
                                            <%@include file="inc_thongtinchung.jsp" %>
                                            <!-- /ko -->

                                            <!-- ko with: donViXuLyVM() -->
                                            <%@include file="inc_chonDonViXuLy.jsp"%>
                                            <!-- /ko -->

                                            <%@include file="inc_chongiaykdnk.jsp" %>

                                            <div id="Form03" style="display: none">
                                                <!-- ko with: form03VM() -->
                                                <%@include file="form03.jsp"%>
                                                <!-- /ko -->
                                            </div>

                                            <div id="Form20a" style="display: none">
                                                <!-- ko with: form20VM() -->
                                                <%@include file="form20a.jsp"%>
                                                <!-- /ko -->
                                            </div>

                                        </form>
                                    </div>

                                    <div class="tab-pane" id="tab_mt_2">
                                        <%@include file="inc_dinhkem_wrapper.jsp"%>
                                    </div>

                                    <p class="nsw-text-center">
                                        <!-- <a data-bind="click : btnLuuClick, visible: btnLuu" href="javascript:void(0);" class="btn blue" id="btnLuu"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a> -->
                                        <a data-bind="click : btnGuiClick, visible: btnGui"  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i> Thoát</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="inc_script.jsp" %>
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
    var idHoSo = ${idHoSo};
    var ycs = true;
    var disabled= false;
    var mapQuocgia = {};
</script>
<script src="<c:url value='/app/mard/09/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/Form03VM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/DocumentsVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/EditVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/DonViXuLyVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/KyHoSoVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/ThongTinChungVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/AddGoodVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/AddCompanyVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/AddIsoLocationVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/AddMfsVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/AddExporter20VM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/AddGood20VM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/09/Utils.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

