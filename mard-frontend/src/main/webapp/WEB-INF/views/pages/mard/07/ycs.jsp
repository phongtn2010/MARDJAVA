<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="incLanguage.jsp"%>
<%@include file="inc_script.jsp" %>
<script type="text/javascript">
    var idHoSo = ${idHoSo};
</script>
<div id="mard07YCS">
    <div class="row" style="padding-top: 15px; padding-bottom: 15px" data-bind="with: kdnkVM">
        <div class="col-md-12">
            <div class="portlet light">
                <div class="portlet-title">
                    <div class="caption font-dark" style="width: 100%">
                        <span class="caption-subject bold uppercase"><spring:message code="mard.07.ten_thu_tuc"/></span>
                    </div>
                    <div style="margin-top: 5px;">
                        <a style="font-style: italic" href="/mard/07/hdsd">
                            <i class="fa fa-download" aria-hidden="true"></i><span>Tải hướng dẫn sử dụng</span>
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel">
                                <div class="tabbable-custom">
                                    <ul class="nav nav-tabs ">
                                        <li class="active">
                                            <a href="#tab_regform" data-toggle="tab"> <b><spring:message
                                                    code="mard.tokhai.don_dang_ky"/></b></a>
                                        </li>
                                        <li>
                                            <a href="#tab_attachment" data-toggle="tab"> <b><spring:message
                                                    code="mard.tokhai.tai_lieu_dinh_kem"/></b></a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_regform">
                                            <%@include file="inc_lydosua.jsp"%>
                                            <%@include file="inc_thongtinchung.jsp" %>
                                            <%@include file="inc_mucdichsudung.jsp"%>
                                            <%@include file="inc_coquankiemdich.jsp"%>
                                            <div data-bind="visible: fiRegType() == 1">
                                                <%@include file="inc_chon_hoso.jsp"%>
                                                <%@include file="inc_thongtincapgiay.jsp"%>
                                            </div>
                                            <div data-bind="visible: fiRegType() == 2">
                                                <%@include file="inc_thongtincapgiay2.jsp"%>
                                            </div>
                                            <%@include file="inc_thongtinkydon.jsp"%>
                                        </div>
                                        <div class="tab-pane" id="tab_attachment">
                                            <%@include file="inc_dinhkem.jsp"%>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12" style="padding-top: 10px;">
                                            <div class="text-center">
                                                <p><span class="nsw-require-field" data-bind="text: errorMsg"></span></p>
                                                <button class="btn green"
                                                        data-bind="click: $root.sendRegProfile"
                                                >
                                                    <i class="fa fa-send"></i> <spring:message
                                                        code="common.button.gui_ho_so"/>
                                                </button>
                                                <button class="btn green" data-bind="click: $root.goIndexPage"
                                                >
                                                    Thoát
                                                </button>
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
<script type="text/javascript" src="<c:url value='/app/mard/07/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/07/ycs.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/07/KiemDichNhapKhauVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/07/ThongTinChungVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/07/KyHoSoVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/07/FormVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/07/ThongTinNhapKhauVM.js?v=${version}'/>"></script>
