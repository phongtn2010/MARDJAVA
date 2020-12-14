
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="inc_css.jsp" %> 
<div class="row" id="EditVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase" data-bind="text: propTitle"></span>
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
                                    <li>
                                        <a href="#tab_mt_2" data-toggle="tab" id="a-tab-mt-2"> <b>Tài liệu đính kèm </b></a>
                                    </li>
                                    <li>
                                        <a href="#tab_mt_3" data-toggle="tab" id="a-tab-mt-2"> <b>Xác nhận nộp phí </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_mt_1" >
                                        <form role="form" class="form-horizontal">
                                            <!-- ko with: formVM() -->
                                            <%@include file="inc_thongtindoanhnghiep.jsp" %>
                                            <%@include file="inc_thongtinnguoidaidien.jsp" %>                                            
                                            <%@include file="inc_danhsachtrangthietbi.jsp" %>
                                            <!-- /ko -->
                                            <p class="nsw-text-center">
                                                <a data-bind="click : btnLuuClick, visible: btnLuu" href="javascript:void(0);" class="btn blue" id="btnLuu"><i class="fa fa-save" ></i> <spring:message code="common.button.luu" /></a>
                                                <a data-bind="click : btnGuiClick, visible: btnGui"  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                                <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                                            </p>
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_mt_2" >
                                        <form role="form" class="form-horizontal">
                                            <!-- ko with: fileVM() -->
                                            <%@include file="inc_tailieudinhkem.jsp" %>
                                            <!-- /ko -->
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_mt_3" >
                                        <form role="form" class="form-horizontal">
                                            <!-- ko with: paymentVM() -->
                                            <%@include file="inc_xacnhannopphi.jsp" %>
                                            <!-- /ko -->
                                        </form>
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
<%@include file="inc_script.jsp" %>      
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
    NSWLang["moh_BYTE0400011_tenthutuc"] = "<spring:message code="moh.BYTE0400011.tenthutuc" />";   
    var uploadUrl ='${upload}';
</script>
<script src="<c:url value='/static/lib/jquery-ui.js' />" type="text/javascript"></script>
<script src="<c:url value='/app/moh/knockout.validation.extender.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/11/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/11/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/11/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/11/PaymentVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/moh/11/EditVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

