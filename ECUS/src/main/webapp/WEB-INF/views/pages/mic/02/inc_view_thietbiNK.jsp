<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>  
    <legend>
        <b><spring:message code="mic.02.hoso.dsnhapkhau" /></b> 
    </legend>
    <%@include file="inc_css.jsp" %>
    <form role="form" class="form-horizontal" name="searchForm">
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10" style="table-layout: fixed;"> 
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center" style="width: 5%;"><spring:message code="mic.02.hoso.nhapkhau.stt" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.tenmay" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.tenhangsx" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.modelMay" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.nuocSX" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.namSX" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.soluong" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.giatri" /></th>
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.chucNang" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: $data.formVM().lstThietBiNk02">
                <tr>
                   <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">
                    </td>  
                    <td style="width: 150px;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : fiTenMay">
                    </td>
                    <td style="width: 150px;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : fiTenHangSx">
                    </td>
                    <td style="width: 150px;text-align: left;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : fiModelMay">
                    </td>
                    <td style="width: 150px;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : fiNuocSx">
                    </td>
                    <td style="width: 150px;text-align: right;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : fiNamSx">
                    </td>
                    <td style="width: 150px;text-align: right;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : fiSoLuong">
                    </td>
                    <td style="width: 150px;text-align: right;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : fiGiaThietBiStr">
                    </td>
                    <td style="width: 200px;vertical-align: middle;" class="text-center">                            
                        <a class="btn green bt-center" data-bind="click: $parent.formVM().viewPopupTBNK.bind($parent)"><i class="fa fa-eye"></i> Xem</a>
                    </td>
                </tr>
            </tbody>
        </table>
        <span data-bind="text : $data.formVM().errorlistpxkMessage" style="color:red;"> </span>
        <br/>
    </form>

</fieldset>
<template id="dsthietbi-template">
    <form role="form" class="form-horizontal" id="dstb-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tenmay" /></label>
                </div>
                <div class="col-md-4">
                    <select disabled class="form-control select2" id="fiMaTenTv" name="fiMaTenTv" 
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaTenTv',
                              selectedText2 : fiTenMay
                            , value : fiMaTv
                            , options : lstDMTenTV
                            , optionsText : 'fiDmTenmayTv'"></select>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.kieuin" /></label>
                </div>
                <div class="col-md-4">
<!--                    <select disabled class="form-control select2" id="fiDmKieuIn" name="fiDmKieuIn" 
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaKieuIn',
                              selectedText2 : fiKieuIn
                            , value : fiMaKieuIn
                            , options : lstDMKieuIn
                            , optionsText : 'fiDmKieuIn'"></select>-->
                    <input class="form-control" id="fiKieuIn" name="fiKieuIn" data-bind="value: fiKieuIn" maxlength="250"  type="text" readonly="readonly" />

                </div>
            </div>  
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.somauin" /></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoMauIn" name="fiSoMauIn" data-bind="value: fiSoMauIn" maxlength="250" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tenhangsx" /></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenHangSx" name="fiTenHangSx" data-bind="value: fiTenHangSx" maxlength="250" readonly="readonly"/>
                </div>

            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.modelmay" /></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiModelMay" name="fiModelMay" data-bind="value: fiModelMay" maxlength="250" readonly="readonly"/>
                </div>
            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.sodinhdanhmay" /></label>

                </div>
                <div class="col-md-10">
                    <textarea class="form-control" id="fiSoDinhDanhMay" name="fiSoDinhDanhMay" data-bind="value: fiSoDinhDanhMay" maxlength="250" readonly="readonly"/></textarea>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.nuocsx" /></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNuocSx" name="fiNuocSx" data-bind="value: fiNuocSx" maxlength="250" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.namsx" /></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNamSx" name="fiNamSx" data-bind="value: fiNamSx" maxlength="250" readonly="readonly"/>
                </div>

            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.soluong" /></label>

                </div>
                <div class="col-md-4">
                    <input style="text-align: right" class="form-control" id="fiSoLuong" name="fiSoLuong" data-bind="value: fiSoLuong" maxlength="250"readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.chatluong" /></label>

                </div>
                <div class="col-md-4">
                    <select disabled class="form-control select2" id="fiMaChatLuong" name="fiMaChatLuong"  
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaChatLuong', value : fiMaChatLuong , selectedText2 : fiChatLuong,
                            options : lstDMChatLuong, optionsText : 'fiDmChatLuong'"></select>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.khuankhonin" /></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiKhuanKhoBanIn" name="fiKhuanKhoBanIn" data-bind="value: fiKhuanKhoBanIn" maxlength="250" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.donvitinhkkin" /></label>

                </div>
                <div class="col-md-4">
                    <select disabled class="form-control select2" id="fiMaKT" name="fiMaKT"  
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaKT', value : fiMaKichThuoc , selectedText2 : fiDonViTinhKhuonKho,
                            options : lstDMDvKhuankho, optionsText : 'fiDvKichthuoc'"></select>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tocdophoto" /></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTocDoIn" name="fiTocDoIn" data-bind="value: fiTocDoIn" maxlength="250" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.donvitinhphoto" /></label>

                </div>
                <div class="col-md-4">

                    <select disabled class="form-control select2" id="fiMaTocDo" name="fiMaTocDo"  
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaTocDo', value : fiMaTocdo , selectedText2 : fiDonViTocDoIn,
                                options : lstDMDvTocDo, optionsText : 'fiDvTocdo'"></select>
                </div>
            </div>

        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.giaTBi" /></label>

                </div>
                <div class="col-md-4" >
                    <input style="text-align: right" class="form-control" id="fiGiaThietBi" name="fiGiaThietBi" data-bind="value: fiGiaThietBi" maxlength="250" readonly="readonly"/>
                </div>
            </div>
        </div> 
    </form>
</template> 
