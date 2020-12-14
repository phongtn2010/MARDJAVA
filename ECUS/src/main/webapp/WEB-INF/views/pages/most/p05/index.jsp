<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<div class="row" id="mt-container">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"> <spring:message code="most.05.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i class="fa fa-gift"></i> <spring:message code="most.05.hoso.tracuu.timkiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.05.hoso.tracuu.mahoso" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.05.hoso.tracuu.trangthaihoso" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2" 
                                                            data-bind="value : trangThaiHoSo, options : fiTrangthaiList, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>  
                                        </div> 

                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.05.hoso.tracuu.ngaynoptu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input placeholder="dd/mm/yyyy" name="ngayTaoTuNgay" id="ngayTaoTuNgay" data-bind="datepicker : ngayTaoTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="most.05.hoso.tracuu.ngaynopden" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input placeholder="dd/mm/yyyy" name="ngayTaoDenNgay" id="ngayTaoDenNgay" data-bind="datepicker : ngayTaoDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>  
                                        </div>

                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.05.hoso.tracuu.ngaycappheptu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input placeholder="dd/mm/yyyy" name="ngayCapTuNgay" id="ngayCapTuNgay" data-bind="datepicker : ngayCapTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.05.hoso.tracuu.ngaycapphepden" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input placeholder="dd/mm/yyyy" name="ngayCapDenNgay" id="ngayCapDenNgay" data-bind="datepicker : ngayCapDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSoClick" data-bind="click: searchHoSoClick"><i class="fa fa-search"></i><spring:message code="most.05.hoso.timkiem" /></a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">                            
                    <div class="col col-md-6">
                        <spring:message code="most.05.hoso.tracuu.ketquatimkiem"/>
                        <b> <a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager" class="nsw-flr"> 
                            <!-- ko with:paging()-->
                            <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !firstPageActive() }">
                                    <a data-bind="click: goToFirst"><spring:message code="most.05.hoso.trangdau" /></a>
                                </li>
                                <li data-bind="css: { disabled: !previousPageActive() }">
                                    <a data-bind="click: goToPrevious"><spring:message code="most.05.hoso.trangtruoc" /></a>
                                </li>
                                <!-- ko foreach: getPages() -->
                                <li data-bind="css: { active: $parent.currentPage() === $data }">
                                    <a data-bind="click: $parent.goToPage, text: $data"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !nextPageActive() }">
                                    <a data-bind="click: goToNext"><spring:message code="most.05.hoso.trangsau" /></a>
                                </li>
                                <li data-bind="css: { disabled: !lastPageActive() }">
                                    <a data-bind="click: goToLast"><spring:message code="most.05.hoso.trangcuoi" /></a>
                                </li>
                            </ul>
                            <!-- /ko -->
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="monre06Items">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> <spring:message code="most.05.hoso.danhsach.stt" /></th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="most.05.hoso.danhsach.lichsuxuly" /> </th>
                            <th class="text-center" style="width: 120px;"> <spring:message code="most.05.hoso.danhsach.mahoso" /> </th>
                            <th class="text-center" style="max-width: 200px;"> <spring:message code="most.05.hoso.danhsach.tendoanhnghiep" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="most.05.hoso.danhsach.ngaygui" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="most.05.hoso.danhsach.ngaycapphep" /> </th>
                            <th class="text-center"> <spring:message code="most.05.hoso.danhsach.trangthai" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="most.05.hoso.danhsach.xemketqua" /> </th>
                        </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">4
                        <tr>
                            <td data-bind="text : STT">
                            </td>  
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-history" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="text : fiMaHoso, click: $parent.bXemClick.bind($parent)"></a>
                            </td> 
                            <td  data-bind="text : fiTtcTenToChuc"></td>                           
                            <td class="text-center" data-bind="text : fiNgayguiText"></td> 
                            <td class="text-center" data-bind="date : fiNgayCap"></td> 
                            <td style="max-width: 200px;">
                                <a href="javascript:void(0)" data-bind="text : fiTenTrangthai, event : {click : $parent.fiTrangThaiClick.bind($parent)}"></a>
                            </td> 
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Xem thông báo" data-bind="visible: bXemThongBao, click: $parent.bXemThongBaoClick.bind($parent)" src="" alt=""/></a>
                            </td>
                        </tr>                      
                        </script>
                    </table>
                    <div class="row">                            
                        <div class="col col-md-6">
                        </div>
                        <div class="col col-md-6 nsw-text-right">
                            <div id="list-pager" class="nsw-flr"> 
                                <!-- ko with:paging()-->
                                <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                                    <li data-bind="css: { disabled: !firstPageActive() }">
                                        <a data-bind="click: goToFirst">
                                            <spring:message code="most.05.hoso.trangdau" /></a>
                                    </li>
                                    <li data-bind="css: { disabled: !previousPageActive() }">
                                        <a data-bind="click: goToPrevious">
                                            <spring:message code="most.05.hoso.trangtruoc" /></a>
                                    </li>
                                    <!-- ko foreach: getPages() -->
                                    <li data-bind="css: { active: $parent.currentPage() === $data }">
                                        <a data-bind="click: $parent.goToPage, text: $data"></a>
                                    </li>
                                    <!-- /ko -->
                                    <li data-bind="css: { disabled: !nextPageActive() }">
                                        <a data-bind="click: goToNext">
                                            <spring:message code="most.05.hoso.trangsau" /></a>
                                    </li>
                                    <li data-bind="css: { disabled: !lastPageActive() }">
                                        <a data-bind="click: goToLast">
                                            <spring:message code="most.05.hoso.trangcuoi" /></a>
                                    </li>
                                </ul>
                                <!-- /ko -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value='/app/most/05/model.js?v=${version}'/>" type="text/javascript"></script>
    <script src="<c:url value='/app/most/05/index.js?v=${version}'/>" type="text/javascript"></script>
    <template id="confirm-tmpl">
        <div class="row">
            <form role="form" class="form-horizontal" id="xoahoso-form">
                <div class="col-md-12">
                    <span data-bind="text: fiMsg"></span><b data-bind="text: fiMaHoso"></b>
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
                                <a data-bind="click: goToFirst"> <spring:message code="most.05.hoso.trangdau" />
                                </a>
                            </li>
                            <li data-bind="css: { disabled: !previousPageActive() }">
                                <a data-bind="click: goToPrevious">
                                    <spring:message code="most.05.hoso.trangtruoc" /></a>
                            </li>
                            <!-- ko foreach: getPages() -->
                            <li data-bind="css: { active: $parent.currentPage() === $data }">
                                <a data-bind="click: $parent.goToPage, text: $data"></a>
                            </li>
                            <!-- /ko -->
                            <li data-bind="css: { disabled: !nextPageActive() }">
                                <a data-bind="click: goToNext"><spring:message code="most.05.hoso.trangsau" />
                                </a>
                            </li>
                            <li data-bind="css: { disabled: !lastPageActive() }">
                                <a data-bind="click: goToLast"><spring:message code="most.05.hoso.trangcuoi" /></a>
                            </li>
                        </ul>
                        <!-- /ko -->
                    </div>
                </div>
            </div>
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr>
                        <th class="text-center"><b><spring:message code="most.05.hoso.lichsu.stt" /></b></th>
                        <th style="text-align: center;"><b><spring:message code="most.05.hoso.lichsu.donvixuly" /></b></th>
                        <th style="text-align: center;"><b><spring:message code="most.05.hoso.lichsu.noidung" /></b></th>
                        <th style="text-align: center;"><b><spring:message code="most.05.hoso.lichsu.link" /></b></th>
                        <th style="text-align: center;"><b><spring:message code="most.05.hoso.lichsu.thoigian" /></b></th>
                        <th style="text-align: center;"><b><spring:message code="most.05.hoso.lichsu.trangthaihoso" /></b></th>
                    </tr>
                </thead>
                <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
                </tbody>
                <script id="historyItemTmpl" type="text/html">
                    <tr>
                        <td data-bind="text : STT"></td>
                        <td class="text-left" data-bind="text : fiDonvixuly"></td> 
                        <td class="text-left" data-bind="text : fiNoidung"></td> 
                        <td class="text-left"> 
                         <a target="_blank" data-bind="visible: true, attr: { href: fiLink, title: fiLink }"><p data-bind="text : fiLink" ></p></a>
                        </td>
                        <td class="text-center" data-bind="text : fiNgaytao"></td> 
                        <td class="text-left" data-bind="text : fiTenTrangthai"></td>                     
                    </tr>                      
                    </script>
                </table> 
            </form>
        </template>
                    <template id="ruthoso-tmpl">
            <div class="row">
                <form role="form" class="form-horizontal" name="ruthoso-form" id="ruthoso-form">
                    <div class="col-md-12">
                        <p><label data-bind="text: fiMsg"></label><b data-bind="text: fiMaHoso"></b></p>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="most.05.common.msg.lydo" /></label>
                    </div>
                    <div class="col-md-10">
                        <textarea name="fiNoiDung" id="fiNoiDung" data-bind="value: fiContent" require="true" placeholder="<spring:message code="most.05.common.msg.lydo" />" style="width: 90%; height: 150px;" maxlength="2000"></textarea>
                    </div>
                </form>
            </div>
        </template>
        <template id="tbphithamdinh-template">
            <form role="form" class="form-horizontal" id="tbphithamdinh-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4 text-right">
                            <label>Phí thẩm định: </label>
                        </div>
                        <div class="col-md-8" data-bind="text : fiPhiThamdinh">  
                        </div>
                    </div>  
                    <div class="col-md-12">
                        <div class="col-md-4 text-right">
                            <label>Nội dung: </label>
                        </div>
                        <div class="col-md-8" data-bind="text : fiNoiDung">  
                        </div>
                    </div> 
                    <div class="col-md-12">
                        <div class="col-md-4 text-right">
                            <label>Link thông báo phí: </label>
                        </div>
                        <div class="col-md-8">  
                            <a target="_blank" data-bind="text: fiLinkThongbaophi, attr: { href: fiLinkThongbaophi}"></a>
                        </div>
                    </div>
                </div>
            </form>
        </template>
                    <template id="kqxl-template">
            <form role="form" class="form-horizontal" id="kqxl-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4" style="text-align: right;">
                            <label>Mã hồ sơ: </label>
                        </div>
                        <div class="col-md-8" data-bind="text : fiMaHoso">  
                        </div>
                    </div>  
                    <div class="col-md-12">
                        <div class="col-md-4" style="text-align: right;">
                            <label>Link công văn: </label>
                        </div>
                        <div class="col-md-8">  
                            <a target="_blank" data-bind="text: fiLinkCongvan, attr: { href: fiLinkCongvan}"></a>
                        </div>
                    </div>   
                </div>
            </form>
        </template> 