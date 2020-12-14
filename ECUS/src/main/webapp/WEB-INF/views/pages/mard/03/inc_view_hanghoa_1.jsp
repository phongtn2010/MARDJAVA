<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--table--%>
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
            <a class="btn green bt-center" data-bind="click:  $parent.viewPopupHH.bind($parent)"><i class="fa fa-eye"></i> Xem</a>
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
            <a class="btn green bt-center" data-bind="click:  $parent.viewPopupHH.bind($parent)"><i class="fa fa-eye"></i> Xem</a>
        </td>
    </tr>
    </tbody>
</table>
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
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.maHS" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="fiHsCode" name="fiHsCode" data-bind="value: fiHsCode" disabled/>
                    </div>

                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.tenhang" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="productName" name="productName" data-bind="value: productName" disabled/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">

                    <div class="col-md-2 nsw-text-left">
                        <label>Nơi sản xuất</label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="productFrom" name="productFrom" data-bind="value: productFrom" disabled/>
                    </div>

                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.soluong" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="quantity" name="quantity" data-bind="value: quantity" disabled/>
                    </div>

                </div>
            </div>

            <div class="form-group">
                <div class="col-md-12">

                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.dvtinh" /></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="quantityUnitCode" name="quantityUnitCode"
                                data-bind="optionsCaption: 'Chọn đơn vị tính', optionsValue : 'id'
                        , selectedText2 : quantityUnitName
                        , value : quantityUnitCode
                        , options : lstDvt
                        , optionsText : 'name'" disabled>
                        </select>
                    </div>
                    <!--ko if: isViewByType -->
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.giong" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="animalBreed" name="animalBreed" data-bind="value: animalBreed" disabled/>
                    </div>
                    <!-- /ko -->
                    <!--ko if: isViewByType2 -->
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.trongluong" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="netWeight" name="netWeight" data-bind="value: netWeight" disabled/>
                    </div>
                    <!-- /ko -->
                </div>
            </div>
            <!--ko if: isViewByType -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.tinhbiet" /></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="animalMale" name="animalMale"
                                data-bind="optionsCaption: 'Chọn tinh biệt', optionsValue : 'id'
                        , selectedText2 : animalMaleName
                        , value : animalMale
                        , options : lstGiong
                        , optionsText : 'name'" disabled>
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.tuoi" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="animalAge" name="animalAge" data-bind="value: animalAge" disabled/>
                    </div>
                </div>
            </div>
            <!-- /ko -->

            <!--ko if: isViewByType2 -->
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.dvtinh" /></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="netWeightUnitCode" name="netWeightUnitCode"
                                data-bind="optionsCaption: 'Chọn đơn vị tính', optionsValue : 'id'
                        , selectedText2 : netWeightUnitName
                        , value : netWeightUnitCode
                        , options : lstDvt
                        , optionsText : 'name'" disabled>
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.trongluongbb" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="grossWeight" name="grossWeight" data-bind="value: grossWeight" disabled/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.dvtinh" /></label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control select2" id="grossWeightUnitCode" name="grossWeightUnitCode"
                                data-bind="optionsCaption: 'Chọn đơn vị tính', optionsValue : 'id'
                        , selectedText2 : grossWeightUnitName
                        , value : grossWeightUnitCode
                        , options : lstDvt
                        , optionsText : 'name'" disabled>
                        </select>
                    </div>
                    <div class="col-md-2 nsw-text-left">
                        <label><spring:message code="mard.03.popup.thongtinhanghoa.loaibb" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" id="packings" name="packings" data-bind="value: packings" disabled/>
                    </div>
                </div>
            </div>
            <!-- /ko -->

        </form>
    </fieldset>
</template>


