<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row" id="ResultVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> CÔNG VĂN ĐỒNG Ý KIỂM DỊCH</span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab_mt_1">
                                        <form role="form" class="form-horizontal">
                                            <!-- ko if: typeProduct() ===1 -->
                                            <%@include file="inc_giayPhep.jsp" %>
                                            <!-- /ko -->
                                            <!-- ko if: typeProduct() ===2 -->
                                            <%@include file="inc_giay_phep_18.jsp" %>
                                            <!-- /ko -->
                                        </form>
                                    </div>
                                    <p class="nsw-text-center" style="margin-top: 20px;margin-bottom: -5px;">
                                        <a data-bind="click : btnXinSuaCVClick, visible: btnGui"
                                           href="javascript:void(0);" class="btn blue" id="btnGui"><i
                                                class="fa fa-send"></i> Xin sửa CV</a>
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);"
                                           class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i>
                                            <spring:message code="common.button.trolai"/></a>
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
<%--<%@include file="inc_script.jsp" %>--%>
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/mard/02/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/02/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>

