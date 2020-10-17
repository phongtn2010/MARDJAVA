<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@include file="inc_css.jsp" %>
<div class="row" id="ViewVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> <spring:message code="mic.02.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_1" data-toggle="tab" id="a-tab-1"> <b>Đơn đăng ký </b></a>
                                    </li>
                                    <li data-bind="visible: showCert">
                                        <a href="#tab_2" data-toggle="tab" id="a-tab-2"> <b>Giấy Phép</b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >

                                    <div class="tab-pane active" id="tab_1">
                                        <form role="form" class="form-horizontal" data-bind="with: formVM">
                                            <%@include file="inc_view_thongtinchung.jsp" %>
                                            <%@include file="inc_view_thietbiNK.jsp" %>
                                            <%@include file="inc_view_dinhkem.jsp" %>
                                            <%@include file="inc_view_thongtinkydon.jsp" %>
                                        </form>
                                    </div>
                                    <div class="tab-pane" id="tab_2" data-bind="visible: showCert">
                                        <form role="form" class="form-horizontal">
                                            <!--ko with: resultVM()-->                                             
                                            <%@include file="cert.jsp" %>
                                            <!--/ko--> 
                                        </form>
                                    </div>

                                    <p class="nsw-text-center" style="margin-top: 20px;margin-bottom: -5px;">
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
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
</script>
<script src="<c:url value='/app/mic/02/md5.min.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/FormVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/FileVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/ResultVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mic/02/ViewVM.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>



                <template id="dsthietbiGP-template">
    <form role="form" class="form-horizontal" id="dstbGP-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tenmay" /><a class="nsw-require-field">*</a></label>
                </div>
               <div class="col-md-4">
                   <input class="form-control" id="fiTenMay" name="fiTenMay" data-bind="value: fiTenMay"readonly="readonly" />
                    
                </div>
                
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.kieuin" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiKieuIn" name="fiKieuIn" data-bind="value: fiKieuIn"  readonly="readonly"/>
                    
                </div>
            </div>  
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.somauin" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoMauIn" name="fiSoMauIn" data-bind="value: fiSoMauIn" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tenhangsx" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenHangSx" name="fiTenHangSx" data-bind="value: fiTenHangSx"  readonly="readonly"/>
                </div>

            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.modelmay" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiModelMay" name="fiModelMay" data-bind="value: fiModelMay" readonly="readonly"/>
                </div>
            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.sodinhdanhmay" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-10">
                    <textarea class="form-control" id="fiSoDinhDanhMay" name="fiSoDinhDanhMay" data-bind="value: fiSoDinhDanhMay" readonly="readonly"/></textarea>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.nuocsx" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNuocSx" name="fiNuocSx" data-bind="value: fiNuocSx"readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.namsx" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNamSx" name="fiNamSx" data-bind="value: fiNamSx" readonly="readonly"/>
                </div>

            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.soluong" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoLuong" name="fiSoLuong" data-bind="value: fiSoLuong" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.chatluong" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiChatLuong" name="fiChatLuong" data-bind="value: fiChatLuong" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.khuankhonin" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiKhuanKhoBanIn" name="fiKhuanKhoBanIn" data-bind="value: fiKhuanKhoBanIn" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.donvitinhkkin" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDonViTinhKhuonKho" name="fiDonViTinhKhuonKho" data-bind="value: fiDonViTinhKhuonKho" readonly="readonly"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tocdophoto" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTocDoIn" name="fiTocDoIn" data-bind="value: fiTocDoIn" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.donvitinhphoto" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDonViTocDoIn" name="fiDonViTocDoIn" data-bind="value: fiDonViTocDoIn" readonly="readonly"/>
                </div>
            </div>

        </div>
       
    </form>
</template> 