<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="incLanguage.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light " id="contentBody">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i> <span class="caption-subject bold uppercase"><spring:message
                        code="mard.16.title"/></span>
                </div>
            </div>

            <div class="portlet-body" id="table-search">
                <div class="table-toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><spring:message
                                            code="common.tracuu.thong_tin_tim_kiem"/> </span>
                                </div>
                                <div class="panel-body">
                                    <jsp:include page="index_form_search.jsp"></jsp:include>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
 <!-- pagination -->
                <div class="row">
                    <div class="col-md-12 nsw-text-right">
                        <div class="nsw-flr" data-bind="if: pagingVM.totalCount() > $root.pagingVM.pageSize()">
                            <ul class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !pagingVM.firstPageActive() }"
                                    class="previous disabled"><a href="#" aria-label="First"
                                                                 data-bind="click: goToFirst"> <spring:message
                                        code="mard.16.trang-dau-tien"></spring:message>
                                </a></li>
                                <li data-bind="css: { disabled: !pagingVM.previousPageActive()  }"
                                    class="previous disabled"><a href="#" aria-label="Previous"
                                                                 data-bind="click: goToPrevious"> <spring:message
                                        code="mard.16.trang-truoc"></spring:message>
                                </a></li>
                                <!-- ko foreach: $root.pagingVM.getPages() -->
                                <li data-bind="css: { active: $data == $root.pagingVM.currentPage() }"><a href="#"
                                                                                                          data-bind="text: $data, click: $root.goToPage.bind($data)"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !pagingVM.nextPageActive() }" class="next"><a href="#"
                                                                                                              aria-label="Next"
                                                                                                              data-bind="click: goToNext">
                                    <spring:message code="mard.16.trang-sau"></spring:message>
                                </a></li>
                                <li data-bind="css: { disabled: !pagingVM.lastPageActive() }" class="next"><a href="#"
                                                                                                              aria-label="Last"
                                                                                                              data-bind="click: goToLast">
                                    <spring:message code="mard.16.trang-cuoi"></spring:message>
                                </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col col-md-12">
                        <spring:message code="common.tong"/>
                        <b><a id="lbTotalRecords" href="javascript:void(0);"></a> </b>
                        <spring:message code="common.pager.ban_ghi"/>
                        <span>: <b data-bind="text: pagingVM.totalCount()"></b></span>

                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column"
                       id="sample_1">
                    <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.16.index.table.th.01"></spring:message></th>
                        <th class="text-center"><spring:message code="mard.16.index.table.th.02"></spring:message></th>
                        <th class="text-center"><spring:message
                                code="mard.16.HoSo3DTO.fiNameOfRegistration"></spring:message></th>
                        <th class="text-center"><spring:message
                                code="mard.16.HoSo3DTO.fiDocumentName"></spring:message></th>
                        <th class="text-center"><spring:message
                                code="mard.16.TbdGiayPhep16.fiDispatchNo"></spring:message></th>
                        <th class="text-center"><spring:message
                                code="mard.16.TbdGiayPhep16.fiSignConfirmDate"></spring:message></th>
                        <th class="text-center"><spring:message
                                code="mard.16.HoSo3DTO.fiCreateDate"></spring:message></th>
                        <th class="text-center"><spring:message code="mard.16.HoSo3DTO.fiStatus"></spring:message></th>
                        <th class="text-center"><spring:message code="mard.16.index.table.th.08"></spring:message></th>
                        <th class="text-center"><spring:message code="mard.16.index.table.th.13"></spring:message></th>
                        <c:if test="${!isFcap}">
                            <th class="text-center"><spring:message
                                    code="mard.16.index.table.xinSuaGiayPhep"></spring:message></th>
                            <th class="text-center"><spring:message
                                    code="mard.16.index.table.th.09"></spring:message></th>
                            <th class="text-center"><spring:message
                                    code="mard.16.index.table.th.12"></spring:message></th>
                            <th class="text-center"><spring:message
                                    code="mard.16.index.table.th.10"></spring:message></th>

                            <th class="text-center"><spring:message
                                    code="mard.16.index.table.th.11"></spring:message></th>
                        </c:if>

                    </tr>
                    </thead>
                    <tbody id="list-container" data-bind="foreach: { data: $root.danhSachHoSo, as: 'item'}">
                    <tr>
                        <td class="text-center"
                            data-bind="text: (($root.pagingVM.currentPage() - 1) * $root.pagingVM.pageSize() + 1 + $index())"></td>
                        <td class="text-center"><a href="#"
                                                   data-bind="attr: { 'title': item.fiDocumentName }, click: $root.xemLichSu">
                            <i class="fa fa-lg fa-history tooltips"></i>
                        </a></td>
                        <td class="text-center" data-bind="text: item.fiNameOfRegistration"></td>
                        <td class="text-center"><a data-bind="click: $root.xemChiTietHoSo, text: item.fiDocumentName"
                                                   href="#"></a></td>
                        <td class="text-center" data-bind="text: item.fiDispatchNo"></td>
                        <td class="text-center" data-bind="text: item.fiSignConfirmDate"></td>
                        <td class="text-center" data-bind="text: item.fiSendDate"></td>
                        <td class="text-center" data-bind="text: item.fiStatusName"></td>

                        <td class="text-center"><a href="#"
                                                   data-bind="attr: { 'title': item.fiDocumentName }, click: $root.xemHoSo">
                            <i class="fa fa-eye"></i>
                        </a></td>
                        <td class="text-center" data-bind="if: (item.showButtonXemGXN())"><a href="#"
                                                                                             data-bind="attr: { 'title': item.fiDocumentName }, click: $root.xemGiayXacNhanClick">
                            <i class="fa fa-eye"></i>
                        </a></td>
                        <c:if test="${!isFcap}">
                            <td class="text-center" data-bind="if: (item.showButtonXinSuaGiayPhep())"><a
                                    href="#"
                                    data-bind="attr: { 'title': item.fiDocumentName }, click: $root.xinSuaGiayPhep"> <i
                                    class="fa fa-paper-plane" aria-hidden="true"></i>
                            </a></td>
                            <td class="text-center" data-bind="if: (item.showButtonXinSuaHoSo())"><a href="#"
                                                                                                     data-bind="attr: { 'title': item.fiDocumentName }, click: $root.xinSua">
                                <i class="fa fa-lg fa-edit request-cancel tooltips"></i>
                            </a></td>
                            <td class="text-center" data-bind="if: (item.showButtonXinRut())"><a   href="#"
                                                                                                 data-bind="attr: { 'title': item.fiDocumentName }, click: $root.huyHoSo">
                                <i class="fa fa-lg fa-arrow-circle-o-down"></i>
                            </a></td>
                            <td class="text-center" data-bind="if: (item.showButtonEdit())"><a href="#"
                                                                                               data-bind="attr: { 'title': item.fiDocumentName }, click: $root.chinhSuaHoSo">
                                <i class="fa fa-lg fa-edit request-cancel tooltips"></i>
                            </a></td>

                            <td class="text-center"
                                data-bind="if: (item.showButtonDelete())"><a href="#" style="color: red; font-weight: bold;"
                                                                             data-bind="attr: { 'title': item.fiDocumentName }, click: $root.xoaHoSo">
                                <i class="fa fa-lg fa-close tooltips" aria-hidden="true"></i>
                            </a></td>
                        </c:if>

                    </tr>
                    </tbody>
                    <tbody id="showLoadingIcon">
                    <tr>
                        <td style="height: 50px; position: relative; zoom: 1;" colspan="16">
                            <div class="blockUI" style="display: none"></div>
                            <div class="blockUI blockOverlay"
                                 style="z-index: 1000; border: none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color: rgb(85, 85, 85); opacity: 0.1; cursor: wait; position: absolute;"></div>
                            <div class="blockUI blockMsg blockElement"
                                 style="z-index: 1011; position: absolute; padding: 0px; margin: 0px; width: 30%; top: 4px; left: 528.5px; text-align: center; color: rgb(0, 0, 0); border: 0px; cursor: wait;">
                                <div class="loading-message ">
                                    <img src="<c:url value="/static/assets/global/img/loading-spinner-grey.gif" />"
                                         align=""><span>&nbsp;&nbsp;LOADING...</span>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <!-- pagination -->
                <div class="row">
                    <div class="col-md-12 nsw-text-right">
                        <div class="nsw-flr" data-bind="if: pagingVM.totalCount() > $root.pagingVM.pageSize()">
                            <ul class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !pagingVM.firstPageActive() }"
                                    class="previous disabled"><a href="#" aria-label="First"
                                                                 data-bind="click: goToFirst"> <spring:message
                                        code="mard.16.trang-dau-tien"></spring:message>
                                </a></li>
                                <li data-bind="css: { disabled: !pagingVM.previousPageActive()  }"
                                    class="previous disabled"><a href="#" aria-label="Previous"
                                                                 data-bind="click: goToPrevious"> <spring:message
                                        code="mard.16.trang-truoc"></spring:message>
                                </a></li>
                                <!-- ko foreach: $root.pagingVM.getPages() -->
                                <li data-bind="css: { active: $data == $root.pagingVM.currentPage() }"><a href="#"
                                                                                                          data-bind="text: $data, click: $root.goToPage.bind($data)"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !pagingVM.nextPageActive() }" class="next"><a href="#"
                                                                                                              aria-label="Next"
                                                                                                              data-bind="click: goToNext">
                                    <spring:message code="mard.16.trang-sau"></spring:message>
                                </a></li>
                                <li data-bind="css: { disabled: !pagingVM.lastPageActive() }" class="next"><a href="#"
                                                                                                              aria-label="Last"
                                                                                                              data-bind="click: goToLast">
                                    <spring:message code="mard.16.trang-cuoi"></spring:message>
                                </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value="/app/mard/14/i18n/en.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/14/i18n/vi.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/14/cmonFunc.js"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/models.module.js?v=${version}"/>"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/loadhoso.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/xinsuagiayphep.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/xoahoso.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/xinruthoso.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/history.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/xemhoso.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/xemgiayphep.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mard/16/index.module.js?v=${ version }"/>"
        charset="utf-8"></script>