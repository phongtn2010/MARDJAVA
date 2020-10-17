<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>  
    <legend>
        <b><spring:message code="mic.02.hoso.dsnhapkhau" /></b> 
        <a href="javascript:;" class="btn green" id="btnAddNewClickPXK" data-bind="click :$data.formVM().btnAddNewNKClick ">
            <i class="fa fa-plus"></i>
        </a>
    </legend>
    <div class="form-group" style="float: left;width: 100%;">
            <div class="col-md-12">
                <div class="col-md-2" style="width: 25%">
                    <label style="margin-top: 10px;"><spring:message code="mic.02.hoso.tbnk.excel.title" /></label>
                </div>
                <div class="col-md-3">
                    <input class="form-control" id="fileTemp" type="file" accept=".xls,.xlsx" data-bind="visible: $data.formVM().canTemp,event: {change: $data.formVM().btnUploadTemp}"/>
                    <span data-bind="text: $data.formVM().fiTepTemp" style="float: left;margin-top: 10px;"></span>
                    <a href="javascript:void(0);" class="fa fa-cloud-upload" style="margin-top: 10px;float: left;margin-left: 10px;color:#337ab7" data-bind="visible: $data.formVM().canDeleteTemp, click: $data.formVM().doDeleteTemp ">
                        &nbsp;&nbsp;Tải tệp mới
                    </a>
                    
                </div>
                <div class="col-md-4 nsw-text-left">
                    <a class="fa fa-cloud-download" href="javascript:void(0);" data-bind="click: $data.formVM().doDownloadTemp " aria-hidden="true" style="margin-top: 10px;">&nbsp;&nbsp;<spring:message code="mic.02.hoso.tbnk.excel.template" /></a>
            </div>  
        </div>
    <div class="form-group">
        <form role="form" class="form-horizontal" name="searchForm" >
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="" style="max-height: 300px;overflow-y: scroll;"> 
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.stt" /></th>
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
                    <td data-bind="text: $index() + 1">
                    </td>  
                    <td style="width: 220px" data-bind="text : fiTenMay">
                    </td>
                    <td style="width: 220px" data-bind="text : fiTenHangSx">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiModelMay">
                    </td>
                    <td style="width: 220px" data-bind="text : fiNuocSx">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiNamSx">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiSoLuong">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiGiaThietBi">
                    </td>
                    <td style="width: 220px" class="text-center">   
                        <ul class="nav-tbnk">
                            <li><a class="btn green bt-center" data-bind="click: $parent.formVM().btnEditOnClick.bind($parent)"><i class="fa fa-edit"></i> Sửa</a></li>
                            <li><a class="btn red bt-center" data-bind="click: $parent.formVM().btnRemoveOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a></li>
                        </ul>
                    </td>
            <style>
                .nav-tbnk{float: left;width: 100%;margin: 0;padding: 0;}
                .nav-tbnk li{float: left;list-style: none}
            </style>
                </tr>
            </tbody>
        </table>
    </form>
   <span id="valid-tbnk" style="display: none;color:red">Bạn cần thêm thông tin thiết bị nhập khẩu</span>
    <br/>
    </div>
</fieldset>
<template id="dsthietbi-template">
    <form role="form" class="form-horizontal" id="dstb-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tenmay" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="fiMaTenTv" name="fiMaTenTv" 
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaTenTv',
                              selectedText2 : fiTenMay
                            , value : fiMaTv
                            , options : lstDMTenTV
                            , optionsText : 'fiDmTenmayTv'"></select>
                </div>
                
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.kieuin" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                     <select class="form-control select2" id="fiMaKieuIn" name="fiMaKieuIn" 
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaKieuIn',
                              selectedText2 : fiKieuIn
                            , value : fiMaKieuIn
                            , options : lstDMKieuIn
                            , optionsText : 'fiDmKieuIn'"></select>
                </div>
            </div>  
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.somauin" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoMauIn" name="fiSoMauIn" data-bind="value: fiSoMauIn" maxlength="9"  type="text" pattern="^[0-9]+$" oninput="validity.valid||(value='');"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tenhangsx" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenHangSx" name="fiTenHangSx" data-bind="value: fiTenHangSx" maxlength="250"/>
                </div>

            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.modelmay" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiModelMay" name="fiModelMay" data-bind="value: fiModelMay" maxlength="250"/>
                </div>
            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.sodinhdanhmay" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-10">
                    <textarea class="form-control" id="fiSoDinhDanhMay" name="fiSoDinhDanhMay" data-bind="value: fiSoDinhDanhMay" maxlength="250"/></textarea>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.nuocsx" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNuocSx" name="fiNuocSx" data-bind="value: fiNuocSx" maxlength="250"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.namsx" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNamSx" name="fiNamSx" data-bind="value: fiNamSx" maxlength="250"/>
                </div>

            </div>
        </div> 
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.soluong" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoLuong" name="fiSoLuong" data-bind="value: fiSoLuong" maxlength="9"type="text" oninput="validity.valid||(value='');" pattern="^[0-9]+$"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.chatluong" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="fiMaChatLuong" name="fiMaChatLuong"  
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaChatLuong', value : fiMaChatLuong , selectedText2 : fiChatLuong,
                            options : lstDMChatLuong, optionsText : 'fiDmChatLuong'"></select>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.khuankhonin" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiKhuanKhoBanIn" name="fiKhuanKhoBanIn" data-bind="value: fiKhuanKhoBanIn" maxlength="250"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.donvitinhkkin" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="fiMaKT" name="fiMaKT"  
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaKT', value : fiMaKichThuoc , selectedText2 : fiDonViTinhKhuonKho,
                            options : lstDMDvKhuankho, optionsText : 'fiDvKichthuoc'"></select>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.tocdophoto" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTocDoIn" name="fiTocDoIn" data-bind="value: fiTocDoIn" maxlength="250"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.donvitinhphoto" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">

                    <select class="form-control select2" id="fiMaTocDo" name="fiMaTocDo"  
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaTocDo', value : fiMaTocdo , selectedText2 : fiDonViTocDoIn,
                                options : lstDMDvTocDo, optionsText : 'fiDvTocdo'"></select>
                </div>
            </div>

        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mic.02.hoso.popup.tbnk.giaTBi" /><a class="nsw-require-field">*</a></label>

                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiGiaThietBi" name="fiGiaThietBi" data-bind="value: fiGiaThietBi" maxlength="250" />
                </div>
            </div>
        </div> 
    </form>
</template> 
