<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><spring:message code="mt.61.giayphep.danhsach" /></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.61.giayphep.stt" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.lichsu" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.sogiayphep" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.ngaycapphep" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.namsx" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.nhanhieu" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.sokhung" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.somay" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.mauson" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.trangthai" /></th>
                        <th class="text-center"><spring:message code="mt.61.giayphep.xemgiayphep" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstGiayPhep">
                    <tr>
                        <td data-bind="text : STT"></td>  
                        <td class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-history" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""></i></a>
                        </td>
                        <td data-bind="text : fiSoGp"></td>
                        <td class="text-center" data-bind="text : fiGpTuNgayText"></td> 
                        <td data-bind="text : fiSoDkpt"></td>
                        <td data-bind="text : fiNamSx"></td>
                        <td data-bind="text : fiTenHieu"></td>
                        <td data-bind="text : fiSoKhung"></td>
                        <td data-bind="text : fiSoMay"></td>
                        <td data-bind="text : fiMauSon"></td>
                        <td data-bind="text : fiTenTt"></td>
                        <td class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Xem giấy phép" data-bind="click: $parent.bXemThongBaoClick.bind($parent)" src="" alt=""></i></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</fieldset>
<%@include file="inc_cert.jsp" %>
<template id="lichsu-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" id="lichsu-form">
            <div class="form-group">

            </div>
        </form>
    </div>
</template>
<template id="history-tmpl">
    <form role="form" class="form-horizontal" id="history-form">
        <p><spring:message code="common.history.mahoso" /> <b data-bind="text: fiMaHoso"></b></p>
        <div class="row">                            
            <div class="col col-md-6">
                <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
            </div>
            <div class="col col-md-6 nsw-text-right">
                <div class="nsw-flr"> 
                    <!-- ko with:paging()-->
                    <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                        <li data-bind="css: { disabled: !firstPageActive() }">
                            <a data-bind="click: goToFirst">Trang đầu</a>
                        </li>
                        <li data-bind="css: { disabled: !previousPageActive() }">
                            <a data-bind="click: goToPrevious">Trang trước</a>
                        </li>
                        <!-- ko foreach: getPages() -->
                        <li data-bind="css: { active: $parent.currentPage() === $data }">
                            <a data-bind="click: $parent.goToPage, text: $data"></a>
                        </li>
                        <!-- /ko -->
                        <li data-bind="css: { disabled: !nextPageActive() }">
                            <a data-bind="click: goToNext">Trang sau</a>
                        </li>
                        <li data-bind="css: { disabled: !lastPageActive() }">
                            <a data-bind="click: goToLast">Trang cuối</a>
                        </li>
                    </ul>
                    <!-- /ko -->
                </div>
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th class="text-center"><b><spring:message code="mt.61.lichsu.stt" /></b></th>
                    <th><b><spring:message code="mt.61.lichsu.nguoixuly" /></b></th>
                    <th><b><spring:message code="mt.61.lichsu.donvixuly" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="mt.61.lichsu.noidung" /></b></th>
                    <th class="text-center"><b><spring:message code="mt.61.lichsu.thoigian" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="mt.61.lichsu.trangthaihoso" /></b></th>
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
            </tbody>
            <script id="historyItemTmpl" type="text/html">
                <tr>
                    <td data-bind="text : STT"></td>
                    <td class="text-left" data-bind="text : fiTenNggui"></td> 
                    <td class="text-left" data-bind="text : fiTenDvgui"></td> 
                    <td class="text-left" data-bind="text : fiNoidung"></td> 
                    <td class="text-center" data-bind="text : fiNgaytao"></td> 
                    <td class="text-left" data-bind="text : fiTenTt"></td>                     
                </tr>                      
                </script>
            </table>        
        </form>
    </template>