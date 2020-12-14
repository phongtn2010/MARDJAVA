
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="inc_css.jsp" %>
<div class="row" id="ChargeVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="bca.02.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <form role="form" class="form-horizontal">
                            <fieldset>
                                <legend><b><spring:message code="bca.02.hoso.thongbaophi" /></b></legend>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.hoso.thongbaophi.tongsotien" /></label>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control" id="fiTongSotien" name="fiTongSotien" maxlength="255"  
                                                   type="text" data-bind="value : fiTongSotien" readonly="readonly"/>
                                        </div>
                                    </div>  
                                </div> 
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.hoso.thongbaophi.noidung" /></label>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control" id="fiNoidungTB" name="fiNoidungTB" maxlength="255"  
                                                   type="text" data-bind="value : fiNoidungTB" readonly="readonly"/>
                                        </div>
                                    </div>  
                                </div> 
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.hoso.thongbaophi.ngaythongbao" /></label>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control date-picker" disabled placeholder="dd/mm/yyyy" id="fiNgayXl" name="fiNgayXl" maxlength="255"  
                                                   type="text" data-bind="datepicker : fiNgayXl" data-date-format="dd/mm/yyyy" readonly="readonly"/>
                                        </div>
                                    </div>  
                                </div> 
                            </fieldset>
                            <fieldset>
                                <legend><b><spring:message code="bca.02.thanhtoanphi" /></b></legend>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.thanhtoanphi.nguoinop" /><a class="nsw-require-field">*</a></label>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control" id="fiNguoinop" name="fiNguoinop" maxlength="255"  
                                                   type="text" data-bind="value : fiNguoinop" />
                                        </div>
                                    </div>  
                                </div> 
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.thanhtoanphi.ngaynop" /><a class="nsw-require-field">*</a></label>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control date-picker" placeholder="dd/mm/yyyy" id="fiNgaynop" name="fiNgaynop" maxlength="255"  readonly style="background: #FFF"
                                                   type="text" data-bind="datepicker : fiNgaynop,event: {change: validHTC}"  data-date-format="dd/mm/yyyy"/>
                                            <span class="validationMessage" id="fiNgaynopLbl" style="display: none">Thông tin bắt buộc nhập</span>

                                        </div>
                                    </div>  
                                </div> 
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.thanhtoanphi.sotienthanhtoan" /><a class="nsw-require-field">*</a></label>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control" id="fiSotien" name="fiSotien" maxlength="255"  
                                                   type="text" data-bind="value : fiSotien" />
                                        </div>
                                    </div>  
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.thanhtoanphi.noidung" /></label>
                                        </div>
                                        <div class="col-md-6">
                                            <input class="form-control" id="fiNoidung" name="fiNoidung" maxlength="255"  
                                                   type="text" data-bind="value : fiNoidung" />
                                        </div>
                                    </div>  
                                </div> 
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-4 nsw-text-right">
                                            <label><spring:message code="bca.02.thanhtoanphi.filedinhkem" /></label>
                                        </div>
                                        <div class="col-md-6">
                                            <table class="tb-content tb-none-border w100p">
                                                <tbody data-bind="foreach: lstDinhkem">
                                                    <tr>
                                                        <td style="width: 300%;">
                                                            <input style="width: 103%;margin-left: -6px"class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" accept=".jpg,.tif"/>
                                                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: downloadUrl}"></a>
                                                        </td> 
                                                        <td class="right">
                                                            <a class="fa fa-trash red fa-lg" style="color: red;"data-bind="visible: canDeleteFile, event: {click: deleteFile }"></a>
                                                        </td>  
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>  
                                </div> 
                                <p class="nsw-text-center">
                                    <a data-bind="click : btnGuiClick"  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> <spring:message code="common.button.luuvagui" /></a>
                                    <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                                </p>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/bca/02/ChargeVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/bca/02/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
