<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><spring:message code="mt.37.giayphep.danhsach" /></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.37.giayphep.stt" /></th>
                        <th class="text-center"><spring:message code="mt.37.giayphep.lichsu" /></th>
                        <th class="text-center"><spring:message code="mt.37.giayphep.sogiayphep" /></th>
                        <th class="text-center"><spring:message code="mt.37.giayphep.loaigiayphep" /></th>
                        <th class="text-center"><spring:message code="mt.37.giayphep.ngaycapphep" /></th>
                        <th class="text-center"><spring:message code="mt.37.giayphep.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.37.giayphep.trangthai" /></th>
                        <th class="text-center"><spring:message code="mt.37.giayphep.xemgiayphep" /></th>
                        <th class="text-center"></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstGiayPhep">
                    <tr>
                        <td data-bind="text : STT"></td>  
                        <td class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-history" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""></i></a>
                        </td>
                        <td data-bind="text : fiSoGp"></td>
                        <td data-bind="text : fiLoaiGp"></td>
                        <td class="text-center" data-bind="text : fiGpTuNgayText"></td> 
                        <td data-bind="text : fiBksXe"></td>
                        <td data-bind="text : fiTenTt"></td>
                        <td class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Xem giấy phép" data-bind="click: $parent.bXemThongBaoClick.bind($parent)" src="" alt=""></i></a>
                        </td>
                        <td class="text-center">
                            <input type="checkbox" data-bind="checked: isChecked, disable: isDisable"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p class="nsw-text-center">
                <a data-bind="click : $parent.btnXinSuaCVClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-edit"></i> Xin sửa Giấy phép</a>
                <a data-bind="click : $parent.btnTraLaiCVClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-arrow-down"></i> Trả lại Giấy phép</a>
            </p>
        </div>
    </div>
</fieldset>
<%@include file="inc_cert_a.jsp" %>
<%@include file="inc_cert_b.jsp" %>
<%@include file="inc_cert_c.jsp" %>
<%@include file="inc_cert_e.jsp" %>
<%@include file="inc_cert_f.jsp" %>
<%@include file="inc_cert_g.jsp" %>
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
                    <th class="text-center"><b><spring:message code="mt.37.lichsu.stt" /></b></th>
                    <th><b><spring:message code="mt.37.lichsu.nguoixuly" /></b></th>
                    <th><b><spring:message code="mt.37.lichsu.donvixuly" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="mt.37.lichsu.noidung" /></b></th>
                    <th class="text-center"><b><spring:message code="mt.37.lichsu.thoigian" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="mt.37.lichsu.trangthaihoso" /></b></th>
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
