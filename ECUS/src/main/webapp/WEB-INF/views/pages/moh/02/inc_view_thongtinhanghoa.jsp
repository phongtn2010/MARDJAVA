<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <legend style="color: dodgerblue;">
        <b><spring:message code="moh.02.hoso.thongtinhanghoa"/></b>
    </legend>
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHangHoa">
        <thead>
        <tr class="nsw-tr tr-nsw1-bgcolor">
            <th class="text-center" style="width: 1%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.stt"/></th>
            <th class="text-center" style="width: 8%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.loaimaubenhpham"/></th>
            <th class="text-center" style="width: 8%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.nguongoc"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.soluong"/></th>
            <th class="text-center" style="width: 5%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.donvitinh"/></th>
            <th class="text-center" style="width: 8%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.hinhthuc"/></th>
            <th class="text-center" style="width: 8%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.noigui"/></th>
            <th class="text-center" style="width: 8%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.noinhan"/></th>
            <th class="text-center" style="width: 8%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.duongvanchuyen"/></th>
            <th class="text-center" style="width: 8%;vertical-align: middle;"><spring:message
                    code="moh.02.hoso.thongtinhanghoa.chucnang"/></th>
        </tr>
        </thead>
        <tbody data-bind="foreach: tbdDonhang02List">
        <tr>
            <td style="vertical-align: middle;width: 2%" data-bind="text : $index() + 1">
            </td>
            <td class="text-left" style="vertical-align: middle;" data-bind="text : fiLoaimau">
            </td>
            <td class="text-left" style="vertical-align: middle;" data-bind="text : fiNguongoc">
            </td>
            <td class="text-right" style="vertical-align: middle;" data-bind="text : fiSoluong">
            </td>
            <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenDvTinh">
            </td>
            <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenHinhthuc">
            </td>
            <td class="text-left" style="vertical-align: middle;" data-bind="html : strQG">
            </td>
            <td class="text-left" style="vertical-align: middle;" data-bind="text : fiNoiNhan">
            </td>
            <td class="text-left" style="vertical-align: middle;" data-bind="text : fiTenVanchuyen">
            </td>
            <td class="text-center" style="vertical-align: middle; width: 7%;">
                <a class="btn green bt-center" data-bind="click: $parent.viewDonHangClick.bind($parent)"><i
                        class="fa fa-eye"></i> Xem</a>
            </td>
        </tr>
        </tbody>
    </table>
</fieldset>


<template id="thongtinhanghoa-template">
    <div class="row" id="thongtinhanghoa-vm">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="hanghoa-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.loaimau"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiLoaimau" name="fiLoaimau" data-bind="value : fiLoaimau" maxlength="255" disabled/>
                        </div>

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.nguongoc"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiNguongoc" name="fiNguongoc"
                                   data-bind="value : fiNguongoc" maxlength="255" disabled/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.soluong"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiSoluong" name="fiSoluong" data-bind="value : fiSoluong" disabled maxlength="10"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.donvitinh"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaDvTinh" name="fiMaDvTinh"
                                    data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'code',
                                    selectedText2 : fiTenDvTinh,
                                    value : fiMaDvTinh,
                                    options : lstDvTinh,
                                    optionsText : 'name'" disabled></select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.hinhthuc"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaHinhthuc" name="fiMaHinhthuc"
                                    data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'code',
                                    selectedText2 : fiTenHinhthuc,
                                    value : fiMaHinhthuc,
                                    options : lstHinhthuc,
                                    optionsText : 'name'" disabled></select>
                        </div>

<%--                        <div class="col-md-2 nsw-text-right">--%>
<%--                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.noigui"/></label>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiNoigui" name="fiNoigui" data-bind="value : fiNoigui" disabled maxlength="255"/>--%>
<%--                        </div>--%>

                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.quocgia"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaQuocgia" name="fiMaQuocgia"
                                    data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'quocgiaCode',
                                    selectedText2 : fiTenQuocgia,
                                    value : fiMaQuocgia,
                                    options : lstQuocgia,
                                    optionsText : 'quocgiaName'" disabled></select>
                        </div>

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.noigui"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiNoigui"
                                   name="fiNoigui" data-bind="value : fiNoigui" maxlength="255" disabled/>
                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.noinhan"/></label>
                        </div>
                        <div class="col-md-4">
                            <input onblur="this.value=removeSpaces(this.value);" class="form-control" id="fiNoiNhan" name="fiNoiNhan" data-bind="value : fiNoiNhan" disabled maxlength="255"/>
                        </div>

                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="moh.02.hoso.thongtinhanghoa.duongvanchuyen"/></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2" id="fiMaVanchuyen" name="fiMaVanchuyen"
                                    data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'code',
                                    selectedText2 : fiTenVanchuyen,
                                    value : fiMaVanchuyen,
                                    options : lstVanchuyen,
                                    optionsText : 'name'" disabled></select>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>
