
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="inc_css.jsp" %>
<div class="row" id="ChargeBSVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"><spring:message code="mard.04.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <form role="form" class="form-horizontal">
                            <fieldset>
                                <legend><b><spring:message code="mard.04.hoso.thongbaophibosung" /></b></legend>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2 nsw-text-right">
                                            <label><spring:message code="mard.04.hoso.tongsotien" /></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input class="form-control" id="fiTongtien" name="fiTongtien" maxlength="255"
                                                   type="text" data-bind="value : fiTongtien" readonly="readonly"/>
                                        </div>
                                        <div class="col-md-2 nsw-text-right">
                                            <label><spring:message code="mard.04.hoso.noidung" /></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input class="form-control" id="fiNoidung" name="fiNoidung" maxlength="255"
                                                   type="text" data-bind="value : fiNoidung" readonly="readonly"/>
                                        </div>
                                    </div>  
                                </div> 
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2 nsw-text-right">
                                            <label><spring:message code="mard.04.hoso.tongtienchu" /></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input class="form-control" id="fiTongtienChu" name="fiTongtienChu" maxlength="255"
                                                   type="text" data-bind="value : fiTongtienChu" readonly="readonly"/>
                                        </div>
                                        <div class="col-md-2 nsw-text-right">
                                            <label><spring:message code="mard.04.hoso.donvixuly" /></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input class="form-control" id="fiDonviXuly" name="fiDonviXuly" maxlength="255"
                                                   type="text" data-bind="value : fiDonviXuly" readonly="readonly"/>
                                        </div>
                                    </div>  
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2 nsw-text-right">
                                            <label><spring:message code="mard.04.hoso.chuyenvienxuly" /></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input class="form-control" id="fiChuyenvienXuly" name="fiChuyenvienXuly" maxlength="255"
                                                   type="text" data-bind="value : fiChuyenvienXuly" readonly="readonly"/>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
            <p class="nsw-text-center">
                <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
            </p>
        </div>
    </div>
</div>
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/mard/04/ChargeBSVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/04/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
