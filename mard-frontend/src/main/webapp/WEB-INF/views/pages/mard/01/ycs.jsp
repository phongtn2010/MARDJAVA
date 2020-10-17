<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="inc_script.jsp" %>

<div id="mard01RequestEdit">
    <div class="col-md-12">
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption font-dark" style="width: 100%">
                    <span class="caption-subject bold uppercase"><spring:message
                            code="mard.01.title.them_ho_so"/></span>

                </div>
                <div style="margin-top: 5px;">
                    <a style="font-style: italic" href="/mard/01/hdsd">
                        <i class="fa fa-download" aria-hidden="true"></i><span>Tải hướng dẫn sử dụng</span>
                    </a>
                </div>
            </div>
            <div class="portlet-body">
                <div class="panel">
                    <div class="tabbable-custom">
                        <ul class="nav nav-tabs ">
                            <li class="active">
                                <a href="#tab_regform" data-toggle="tab"> <b><spring:message code="mard.tokhai.don_dang_ky"/></b></a>
                            </li>
                            <li>
                                <a href="#tab_attachment" data-toggle="tab"> <b><spring:message code="mard.tokhai.tai_lieu_dinh_kem"/></b></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_regform">
                                <%@include file="inc_lydosua.jsp"%>
                                <%@include file="inc_thongtinchung.jsp"%>
                                <div class="row">
                                    <div class="col-md-12" style="padding-bottom: 20px">
                                        <b>
                                            Loại đối tượng
                                            <a class="nsw-require-field">*</a>
                                        </b>
                                        <div class="row-md-3">
                                            <div class="col-md-12">
                                                <form role="form" class="form-horizontal" style="margin-top: 10px">
                                                    <div class="col-md-6 col-xs-6">
                                                        <div class="form-check form-check-inline" style="display: flex">
                                                            <input  type="radio" value="1"
                                                                    data-bind="checked: fiObjectType"
                                                            />
                                                            <label style="padding-left: 5px"><spring:message code="mard.01.radio.dong_vat"/></label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-xs-6">
                                                        <div class="form-check form-check-inline" style="display: flex">
                                                            <input  type="radio" value="2"
                                                                    data-bind="checked: fiObjectType"
                                                            ><label style="padding-left: 5px"> <spring:message code="mard.01.radio.san_pham_dong_vat"/></label></input>

                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                    <div data-bind="visible: fiObjectType() == 1" style="padding-top: 20px">
                                        <%@include file="inc_thongtindongvat.jsp"%>
                                    </div>

                                    <div data-bind="visible: fiObjectType() == 2" style="padding-top: 20px">
                                        <%@include file="inc_thongtinspdongvat.jsp"%>
                                    </div>
                                    <div class="col-md-12">
                                        <%@include file="inc_thongtinkhac.jsp"%>
                                    </div>
                                    <div class="col-md-12">
                                        <!-- ko with: noiDungKyVM() -->
                                        <%@include file="inc_noidungky.jsp"%>
                                        <!-- /ko -->
                                    </div>

                                </div>
                            </div>
                            <div class="tab-pane" id="tab_attachment">
                                <%@include file="inc_tailieudinhkem.jsp"%>
                            </div>
                        </div>
                        <div data-bind="text: errorMsg"></div>
                        <div class="row" style="margin-top: 20px">
                            <div class="col-md-12">
                                <div class="text-center">
                                    <button class="btn green" data-bind="click: $root.bGuiHoSoClick">
                                        <spring:message code="common.button.gui_ho_so"/>
                                    </button>
                                    <button class="btn green" data-bind="click: $root.btnBack">
                                        <spring:message code="common.button.thoat"/>
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
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
    var idHoSo = ${idHoSo};
    var ycs = true;
    var mapQuocgia = {};
</script>
<script type="text/javascript" src="<c:url value='/app/mard/01/init.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/create.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/ThongTinChungVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/RegisterAnimalVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/RegisterAnimalProductVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/ThongTinKhacVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/KyHoSoVM.js?v=${version}'/>"></script>
<script type="text/javascript" src="<c:url value='/app/mard/01/FileVM.js?v=${version}'/>"></script>
