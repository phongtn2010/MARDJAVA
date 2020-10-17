<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .select2-container .select2-selection--single {
        box-sizing: border-box;
        cursor: pointer;
        display: block;
        height: 34px;
        user-select: none;
        -webkit-user-select: none;
    }
    .select2-container .select2-selection--single .select2-selection__rendered {
        display: block;
        padding-left: 8px;
        padding-right: 20px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        padding-top: 3px;
    }
    .input-medium {
        width: 100% !important;
    }
</style>
<script type="text/javascript">
    var idHoSo = ${idHoSo};
    if (idHoSo === undefined || idHoSo === null) idHoSo = 0;
    var isSign = ${isSign};
    var isDevTest = ${isDevTest};
    var isView = ${isView};
    var action = ${action};
    var locale = "${locale}";
    var documentType = "${documentType}";
    var taxCode = "${taxCode}";
    var complieTemplateMinistryCode = "${complieTemplateMinistryCode}";
    var complieTemplateCode = "${complieTemplateCode}";
    var pathAPI = "${pathAPI}";
    var uploadUsername = "${uploadUsername}";
    var uploadPassword = "${uploadPassword}";
    var urlUpload = "${urlUpload}";
    var urlDownload = "${urlDownload}";
    var isFcap = ${isFcap};

    var language = {'en': {'translation': {}}, 'vi': {'translation': {}}};

    if (isDevTest) {
        console.log("idHoSo: " + idHoSo);
        console.log("isDevTest: " + isDevTest);
        console.log('locale: ' + locale);
    }
    var TABLE_COLUMN_DISPLAY_TEXT = 0;
    var TABLE_COLUMN_DISPLAY_LINK = 1;
    var TABLE_COLUMN_DISPLAY_BUTTON = 2;
    var TABLE_COLUMN_DISPLAY_DATE = 3;
    var TABLE_COLUMN_DISPLAY_LINK_BLANK = 4;
    var TABLE_COLUMN_DISPLAY_LINK_LIST_BLANK = 5;

</script>
<script type="text/javascript" src="<c:url value="/app/mic/03/comp/table-comp.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/comp/cmonFunc.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/comp/validate-message-en.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/comp/validate-message-vi.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/comp/i18next-ko.bundle.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/comp/language.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mic/03/comp/upload.js"/>"></script>

<script type="text/javascript">
    ko.validation.locale(locale);
    var sstLabel = 'STT';
    if (locale == 'en') sstLabel = 'No';
</script>
<template id="table-view-template">
    <div class="">
        <div  class="col-md-12">
            <div class="row">
                <div style="padding-top: 25px;" class="col-md-4" data-bind="if: pagingUI()">
                    <label data-bind=" i18n: { key: 'pagination.display', options: { fromIndex: displayFrom(), toIndex: displayTo(), totalItem: pagingVM.totalCount() == '[object Object]' ? '0' : pagingVM.totalCount(), interpolation: { escapeValue: false } } }"></label>
                </div>
                <div class="col-md-8 nsw-text-right" data-bind="if: pagingUI()">
                    <div class="nsw-flr" data-bind="if: pagingVM.totalCount() > pageSize()">
                        <ul class="flip pull-left pagination pagination-sm">
                            <li data-bind="css: { disabled: !pagingVM.firstPageActive() }" class="previous disabled"><a href="javascript: void(0)" aria-label="First" data-bind="click: goToFirst, i18n: {  title: { key: 'pagination.first'}, html: { key: 'pagination.first'} }">goToFirst</a></li>
                            <li data-bind="css: { disabled: !pagingVM.previousPageActive()  }" class="previous disabled"><a href="javascript: void(0)" aria-label="Previous" data-bind="click: goToPrevious, i18n: {  title: { key: 'pagination.previous'}, html: { key: 'pagination.previous'} }">goToPrevious
                            </a></li>
                            <!-- ko foreach: pagingVM.getPages() -->
                            <li data-bind="css: { active: $data == $parent.pagingVM.currentPage() }"><a href="#" data-bind="text: $data, click:  $parent.goToPage"></a> </li>
                            <!-- /ko -->
                            <li data-bind="css: { disabled: !pagingVM.nextPageActive() }" class="next"><a href="javascript: void(0)" aria-label="Next" data-bind="click: goToNext, i18n: {  title: { key: 'pagination.next'},  html: { key: 'pagination.next'} }">goToNext </a></li>

                            <li data-bind="css: { disabled: !pagingVM.lastPageActive() }" class="next"><a href="javascript: void(0)" aria-label="Last" data-bind="click: goToLast, i18n: {  title: { key: 'pagination.last'}, html: { key: 'pagination.last'} }">goToLast</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-12 table-responsive">
            <table style="margin-bottom: 0px" id="table-view" class="table table-striped table-bordered table-hover table-checkable order-column table-hover" id="sample_1">
                <thead class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center" data-bind="text: sstLabel"></th>
                <!-- ko foreach: { data: $root.titles, as: 'titleItem' } -->
                <!-- ko if: titleItem.required -->
                <th class="text-center" data-bind="attr: {width: $parent.widths()[$index()] != '0%' ? $parent.widths()[$index()] :'' }" ><span data-bind="text: titleItem.value"></span><span class="nsw-require-field">(*)</span></th>
                <!-- /ko -->
                <!-- ko ifnot: titleItem.required -->
                <th class="text-center" data-bind="text: titleItem.value, attr: {width: $parent.widths()[$index()] != '0%' ? $parent.widths()[$index()] :'' }"></th>
                <!-- /ko -->
                <!-- /ko -->
                </thead>
                <tbody data-bind="foreach: { data: rows, as: 'rowItem' }">
                <tr>
                    <td align="center" data-bind="text: (($parent.pagingVM.currentPage() - 1) * $parent.pagingVM.pageSize() +$index() + 1)"></td>
                    <!-- ko foreach: { data: $root.titles, as: 'titleItem' } -->


                    <!-- ko if: titleItem.columnType == 0 && titleItem.key -->
                    <td data-bind="text: rowItem[titleItem.key], attr: {align: titleItem.align}"></td>
                    <!-- /ko -->

                    <!-- ko if: titleItem.columnType == 1 -->
                    <td data-bind="attr: {align: titleItem.align}, if: rowItem[titleItem.key + 'Enable']">
                        <a data-bind="attr:{href: rowItem[titleItem.key](), title: rowItem[titleItem.key]()}, if: rowItem[titleItem.key]()">
                            <!-- ko if: titleItem.icon-->
                            <i data-bind="attr:{'class': titleItem.icon}"></i>
                            <!-- /ko -->
                            <!-- ko ifnot: titleItem.icon -->
                            <span data-bind="text: rowItem[titleItem.key]()"></span>
                            <!-- /ko -->
                        </a>
                    </td>
                    <!-- /ko -->

                    <!-- ko if: titleItem.columnType == 2 -->
                    <td align="center" data-bind="if: rowItem[titleItem.key + 'Enable']">
                        <a href="javascript: void(0)" data-bind="attr: { 'title': titleItem.value, 'style': titleItem.style }, click: function(){return titleItem.action(rowItem);}">
                            <!-- ko if: titleItem.icon-->
                            <i data-bind="attr:{'class': titleItem.icon}"></i>
                            <!-- /ko -->
                            <!-- ko ifnot: titleItem.icon -->
                            <span data-bind="text: rowItem[titleItem.key]()"></span>
                            <!-- /ko -->
                        </a>

                    </td>
                    <!-- /ko -->

                    <!-- ko if: titleItem.columnType == 3 -->
                    <td align="center">
                        <!-- ko if: rowItem[titleItem.key]() -->
                        <span  data-bind="text:  moment(rowItem[titleItem.key]()).format(titleItem.dateFormat), attr: {align: titleItem.align}"></span>
                        <!-- /ko -->
                    </td>
                    <!-- /ko -->

                    <!-- ko if: titleItem.columnType == 5 -->
                    <td align="center">
                        <!-- ko if: rowItem[titleItem.key]() -->
                        <!-- ko foreach: { data: rowItem[titleItem.key](), as: 'tdItem' } -->
                        <p>
                             <span>
                                 <a target="_blank" data-bind="attr:{href: tdItem, title: tdItem}">
                                    <!-- ko if: titleItem.icon-->
                                    <i data-bind="attr:{'class': titleItem.icon}"></i>
                                         <!-- /ko -->
                                         <!-- ko ifnot: titleItem.icon -->
                                    <span data-bind="text: tdItem"></span>
                                         <!-- /ko -->
                                </a>
                            </span>
                        </p>
                        <!-- /ko -->
                        <!-- /ko -->
                    </td>
                    <!-- /ko -->

                    <!-- ko if: titleItem.columnType == 4 -->
                    <td data-bind="attr: {align: titleItem.align}">
                        <span data-bind="if: rowItem[titleItem.key]()">
                             <a target="_blank" data-bind="attr:{href: rowItem[titleItem.key](), title: rowItem[titleItem.key]()}">
                            <!-- ko if: titleItem.icon-->
                            <i data-bind="attr:{'class': titleItem.icon}"></i>
                                 <!-- /ko -->
                                 <!-- ko ifnot: titleItem.icon -->
                            <span data-bind="text: rowItem[titleItem.key]()"></span>
                                 <!-- /ko -->
                        </a>
                        </span>
                    </td>
                    <!-- /ko -->

                    <!-- /ko -->
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-12 nsw-text-right" data-bind="if: pagingUI()">
            <div class="nsw-flr" data-bind="if: pagingVM.totalCount() > pageSize()">
                <ul class="flip pull-left pagination pagination-sm">
                    <li data-bind="css: { disabled: !pagingVM.firstPageActive() }" class="previous disabled"><a href="javascript: void(0)" aria-label="First" data-bind="click: goToFirst, i18n: {  title: { key: 'pagination.first'}, html: { key: 'pagination.first'} }">goToFirst</a></li>
                    <li data-bind="css: { disabled: !pagingVM.previousPageActive()  }" class="previous disabled"><a href="javascript: void(0)" aria-label="Previous" data-bind="click: goToPrevious, i18n: {  title: { key: 'pagination.previous'}, html: { key: 'pagination.previous'} }">goToPrevious
                    </a></li>
                    <!-- ko foreach: pagingVM.getPages() -->
                    <li data-bind="css: { active: $data == $parent.pagingVM.currentPage() }"><a href="#" data-bind="text: $data, click:  $parent.goToPage"></a> </li>
                    <!-- /ko -->
                    <li data-bind="css: { disabled: !pagingVM.nextPageActive() }" class="next"><a href="javascript: void(0)" aria-label="Next" data-bind="click: goToNext, i18n: {  title: { key: 'pagination.next'},  html: { key: 'pagination.next'} }">goToNext </a></li>

                    <li data-bind="css: { disabled: !pagingVM.lastPageActive() }" class="next"><a href="javascript: void(0)" aria-label="Last" data-bind="click: goToLast, i18n: {  title: { key: 'pagination.last'}, html: { key: 'pagination.last'} }">goToLast</a></li>
                </ul>
            </div>
        </div>
    </div>
</template>
