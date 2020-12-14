<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--table--%>
<%--<div class="form-group" style="margin-top: 15px;">--%>
<%--    <div class="col-md-12">--%>
<%--        <a href="javascript:void(0);" class="btn blue" id="btnThemHH" data-bind="click : btnAddHangHoa03">--%>
<%--            <i class="fa fa-plus" ></i> <spring:message code="mard.03.hoso.hanghoa.btnthem" />--%>
<%--        </a>--%>
<%--        <a href="javascript:void(0);" class="btn blue" id="btnChonTuVB">--%>
<%--            <i class="fa fa-file-text-o" ></i> <spring:message code="mard.03.hoso.hanghoa.btnvanbanchapthuan" />--%>
<%--        </a>--%>
<%--    </div>--%>
<%--</div>--%>
<!--ko if: isView1 -->
<table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
    <thead>
    <tr class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.stt" /></th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.mahs" /></th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.tenhang" /></th>
        <th class="text-center">Nơi sản xuất</th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.soluong" /></th>
        <th class="text-center">Đơn vị tính</th>
        <th class="text-center">Giống</th>
        <th class="text-center">Tinh biệt</th>
        <th class="text-center">Tuổi</th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.chucnang" /></th>
    </tr>
    </thead>
    <tbody data-bind="foreach: lstHangHoa03">
    <tr>
        <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : fiHsCode"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : productName"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : productFrom"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : quantity"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : quantityUnitName"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : animalBreed"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : animalMaleName"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : animalAge"></td>
        <td style="width: 220px;vertical-align: middle;" class="text-center">
            <a class="btn green bt-center" data-bind="click:  $parent.editPopupHH.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
            <a class="btn red bt-center" data-bind="click: $parent.removePopupHH.bind($parent)"><i class="fa fa-trash"></i> Xóa</a>
        </td>
    </tr>
    </tbody>
</table>
<!-- /ko -->
<!--ko if: isView2 -->
<table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
    <thead>
    <tr class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.stt" /></th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.mahs" /></th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.tenhang" /></th>
        <th class="text-center">Nơi sản xuất</th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.soluong" /></th>
        <th class="text-center">Đơn vị tính</th>
        <th class="text-center">Trọng lượng tính</th>
        <th class="text-center">Đơn vị tính</th>
        <th class="text-center">Trọng lượng cả bao bì</th>
        <th class="text-center">Đơn vị tính</th>
        <th class="text-center">Loại bao bì</th>
        <th class="text-center"><spring:message code="mard.03.hoso.hanghoa.table.chucnang" /></th>
    </tr>
    </thead>
    <tbody data-bind="foreach: lstHangHoa03">
    <tr>
        <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : fiHsCode"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : productName"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : productFrom"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : quantity"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : quantityUnitName"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : netWeight"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : netWeightUnitName"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : grossWeight"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : grossWeightUnitName"></td>
        <td style="word-wrap: break-word;vertical-align: middle;" data-bind="text : packings"></td>
        <td style="width: 220px;vertical-align: middle;" class="text-center">
            <a class="btn green bt-center" data-bind="click:  $parent.editPopupHH.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
            <a class="btn red bt-center" data-bind="click: $parent.removePopupHH.bind($parent)"><i class="fa fa-trash"></i> Xóa</a>
        </td>
    </tr>
    </tbody>
</table>
<span id="hanghoa_valid"  style="display: none;color: red"> Chưa khai báo thông tin hàng hóa</span>
<!-- /ko -->
<%--end table--%>
<template id="hanghoa-template">
    <fieldset>
        <legend style="color: dodgerblue;">
            <b>Thông tin hàng hóa</b>
        </legend>
        <form role="form" class="form-horizontal" id="hanghoa-form">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.maHS" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiHsCode" name="fiHsCode" data-bind="value: fiHsCode" />
                    </div>

                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.tenhang" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="productName" name="productName" data-bind="value: productName" />
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">

                    <div class="col-md-2 nsw-text-left">
                        <label>Nơi sản xuất<a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="productFrom" name="productFrom" data-bind="value: productFrom" />
                    </div>

                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.soluong" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="quantity" name="quantity" data-bind="value: quantity" />
                    </div>

                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">

                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.dvtinh" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="quantityUnitCode" name="quantityUnitCode"
                                data-bind="optionsCaption: 'Chọn đơn vị tính', optionsValue : 'id'
                        , selectedText2 : quantityUnitName
                        , value : quantityUnitCode
                        , options : lstDvt
                        , optionsText : 'name'">
                        </select>
                    </div>
                    <!--ko if: isViewByType -->
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.giong" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="animalBreed" name="animalBreed" data-bind="value: animalBreed"/>
                    </div>
                    <!-- /ko -->
                    <!--ko if: isViewByType2 -->
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.trongluong" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="netWeight" name="netWeight" data-bind="value: netWeight"/>
                    </div>
                    <!-- /ko -->
                </div>
            </div>
            <!--ko if: isViewByType -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.tinhbiet" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="animalMale" name="animalMale"
                                data-bind="optionsCaption: 'Chọn tinh biệt', optionsValue : 'id'
                        , selectedText2 : animalMaleName
                        , value : animalMale
                        , options : lstGiong
                        , optionsText : 'name'">
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.tuoi" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="animalAge" name="animalAge" data-bind="value: animalAge" />
                    </div>
                </div>
            </div>
            <!-- /ko -->

            <!--ko if: isViewByType2 -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.dvtinh" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="netWeightUnitCode" name="netWeightUnitCode"
                                data-bind="optionsCaption: 'Chọn đơn vị tính', optionsValue : 'id'
                        , selectedText2 : netWeightUnitName
                        , value : netWeightUnitCode
                        , options : lstDvt
                        , optionsText : 'name'">
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.trongluongbb" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="grossWeight" name="grossWeight" data-bind="value: grossWeight"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.dvtinh" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="grossWeightUnitCode" name="grossWeightUnitCode"
                                data-bind="optionsCaption: 'Chọn đơn vị tính', optionsValue : 'id'
                        , selectedText2 : grossWeightUnitName
                        , value : grossWeightUnitCode
                        , options : lstDvt
                        , optionsText : 'name'">
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.loaibb" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="packings" name="packings" data-bind="value: packings"/>
                    </div>
                </div>
            </div>
<%--            <div class="form-group">--%>
<%--                <div class="col-md-12">--%>
<%--                    --%>
<%--                </div>--%>
<%--            </div>--%>
            <!-- /ko -->

        </form>
    </fieldset>
</template>
