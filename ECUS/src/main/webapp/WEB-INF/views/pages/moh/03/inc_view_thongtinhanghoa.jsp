<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend style="color: dodgerblue;">
        <b><spring:message code="moh.03.hoso.thongtinhanghoa"/></b>
    </legend>
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa">
        <thead class="blockTables">
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center" style="width: 1%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.stt"/></th>
            <th class="text-center" style="width: 11%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.tenduoclieu"/></th>
            <th class="text-center" style="width: 7%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.maHS"/></th>
            <th class="text-center" style="width: 7%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.bophandung"/></th>
            <th class="text-center" style="width: 11%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.tenkhoahoc"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
            code="moh.03.hoso.thongtinhanghoa.soluong"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.donvitinh"/></th>
            <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.tieuchuanchatluong"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.tennuocsanxuat"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.tencssx"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.tennuoccungcap"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.tencscc"/></th>
            <th class="text-center" style="width: 10%;vertical-align: middle;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.ghichu"/></th>
            <th class="text-center" style="vertical-align: middle;width: 13%;"><spring:message
                    code="moh.03.hoso.thongtinhanghoa.chucnang"/></th>
        </tr>
        </thead>
        <tbody data-bind="foreach: lstDonhang03" class="blockTables scrollTable">
        <tr>
            <td style="vertical-align: middle;width: 1%" data-bind="text : $index() + 1">
            </td>
            <td class="text-center" style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 130px !important; width: 11%;" data-bind="text : fiTextTenDl">
            </td>
            <td class="text-center" style="vertical-align: middle; width: 7%" data-bind="text : fiMaHs">
            </td>
            <td class="text-center" style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 130px !important; width: 7%" data-bind="text : fiBophanDung">
            </td>
            <td class="text-center" style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 130px !important; width: 11%" data-bind="text : fiTenKh">
            </td>
            <td class="text-right" style="vertical-align: middle; width: 5%" data-bind="text : fiSoluong">
            </td>
            <td class="text-left" style="vertical-align: middle; width: 5%" data-bind="text : fiTenDvTinh">
            </td>
            <td class="text-center" style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 160px !important; width: 10%" data-bind="text : fiTextTccl">
            </td>
            <td class="text-left" style="vertical-align: middle; width: 5%" data-bind="text : fiTenQgSx">
            </td>
            <td class="text-center" style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 160px !important; width: 5%" data-bind="text : fiCosoSx">
            </td>
            <td class="text-left" style="vertical-align: middle; width: 5%" data-bind="text : fiTenQgCc">
            </td>
            <td class="text-center" style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 160px !important; width: 5%" data-bind="text : fiCosoCc">
            </td>
            <td class="text-center" style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 200px !important; width: 10%" data-bind="text : fiGhichu">
            </td>
            <td class="text-center" style="vertical-align: middle;width: 13%;">
                <a class="btn green bt-center" data-bind="click: $parent.viewDonHangClick.bind($parent)"><i
                        class="fa fa-eye"></i> Xem</a>
            </td>
        </tr>
        </tbody>
    </table>
</fieldset>
<%@include file="inc_css_btnDonhang.jsp" %>

<template id="thongtinhanghoa-template">
    <div class="row" id="thongtinhanghoa-vm">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="hanghoa-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tenduoclieu"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaDuoclieu" name="fiMaDuoclieu"
                                    data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'id',
                                    selectedText2 : fiTenDuoclieu,
                                    value : fiMaDuoclieu,
                                    options : lstDuoclieu,
                                    optionsText : 'fiTenDuoclieu'" disabled></select>
                        </div>
                        <!--ko if: isViewTenDuoclieuKhac -->
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tenduoclieukhac"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiTenKhac" name="fiTenKhac"
                                   data-bind="value : fiTenKhac" maxlength="255" disabled/>
                        </div>
                        <!-- /ko -->
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.maHS"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiMaHs" name="fiMaHs" readonly="readonly"
                                   data-bind="value : fiMaHs" maxlength="20"/>
                        </div>
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.bophandung"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiBophanDung" name="fiBophanDung"
                                   data-bind="value : fiBophanDung" maxlength="255" readonly/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tenkhoahoc"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiTenKh" name="fiTenKh"
                                   data-bind="value : fiTenKh" maxlength="255" readonly/>
                        </div>

                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.soluong"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiSoluong" name="fiSoluong" data-bind="value : fiSoluong" maxlength="10" disabled/>
                        </div>

                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.donvitinh"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaDvTinh" name="fiMaDvTinh"
                                    data-bind="optionsCaption: 'Chọn đơn vị tính'
                                        , optionsValue : 'code'
                                        , selectedText2 : fiTenDvTinh
                                        , value : fiMaDvTinh
                                        , options : lstDvt
                                        , optionsText : 'name'" disabled>
                            </select>
                        </div>
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tieuchuanchatluong"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaTccl" name="fiMaTccl"
                                    data-bind="optionsCaption: 'Chọn...'
                                        , optionsValue : 'id'
                                        , selectedText2 : fiTccl
                                        , value : fiMaTccl
                                        , options : lstTccl
                                        , optionsText : 'name'" disabled>
                            </select>
                        </div>
                    </div>
                </div>
                <!--ko if: isViewTenTcclKhac -->
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tentcclkhac"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiTcclKhac" name="fiTcclKhac"
                                   data-bind="value : fiTcclKhac" maxlength="255" disabled/>
                        </div>
                    </div>
                </div>
                <!-- /ko -->
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tennuocsanxuat"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaQgSx" name="fiMaQgSx"
                                    data-bind="optionsCaption: 'Chọn...'
                                        , optionsValue : 'fiMaQg'
                                        , selectedText2 : fiTenQgSx
                                        , value : fiMaQgSx
                                        , options : lstQuocgia
                                        , optionsText : 'fiTenQg'" disabled>
                            </select>
                        </div>

                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tencssx"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiCosoSx" name="fiCosoSx" data-bind="value : fiCosoSx" maxlength="512" disabled/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tennuoccungcap"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaQgCc" name="fiMaQgCc"
                                    data-bind="optionsCaption: 'Chọn...'
                                        , optionsValue : 'fiMaQg'
                                        , selectedText2 : fiTenQgCc
                                        , value : fiMaQgCc
                                        , options : lstQuocgia
                                        , optionsText : 'fiTenQg'" disabled>
                            </select>
                        </div>
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.tencscc"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiCosoCc" name="fiCosoCc" data-bind="value : fiCosoCc" maxlength="512" disabled/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-left">
                            <label><spring:message code="moh.03.hoso.thongtinhanghoa.ghichu"/></label>
                        </div>
                        <div class="col-md-10">
                            <textarea onblur="this.value=removeSpaces(this.value);" style="resize: vertical; resize: none; overflow-x: hidden;" class="form-control"
                                      name="fiGhichu" data-bind="value: fiGhichu" maxlength="3000" disabled></textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>
