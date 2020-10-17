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
                    <span class="caption-subject bold uppercase"><span class="caption-subject bold uppercase"> <spring:message code="mard.12.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i class="fa fa-gift"></i> <spring:message code="mard.tracuu.timkiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.mahoso" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.trangthaihoso" /></label>
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
                                                    <label><spring:message code="mard.tracuu.ngaynoptu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" data-bind="datepicker : ngayTaoTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label ><spring:message code="mard.tracuu.ngaynopden" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="ngayTaoDenNgay" data-bind="datepicker : ngayTaoDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.ngaycappheptu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayCapTuNgay" id="ngayCapTuNgay" data-bind="datepicker : ngayCapTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.ngaycapphepden" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayCapDenNgay" id="ngayCapDenNgay" data-bind="datepicker : ngayCapDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group"> 
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.sovanban" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="soCongVan" id="soCongVan" data-bind="value : soCongVan, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="Số giấy phép được cấp" type="text">
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mard.tracuu.masothue" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maSoThue" id="maSoThue" data-bind="value : maSoThue, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="Mã doanh nghiệp" type="text">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: searchHoSoClick"><i class="fa fa-search"></i> Tìm kiếm</a>
                                            <a href="javascript:;" class="btn green" id="btnAddNew" data-bind="click : btnAddNewClick"><i class="fa fa-edit"></i> Thêm mới</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">                            
                    <div class="col col-md-6">
                        <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager" class="nsw-flr"> 
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
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="monre06Items">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 25px;"> <spring:message code="mard.danhsach.stt" /></th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="mard.danhsach.lichsuxuly" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="mard.danhsach.mahoso" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="mard.danhsach.ngaygui" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="mard.danhsach.ngaycapphep" /> </th>
                            <th class="text-center"> <spring:message code="mard.danhsach.tenhanghoa" /> </th>
                            <th class="text-center"> <spring:message code="mard.danhsach.trangthai" /> </th>
                            <th class="text-center" style="width: 25px;"> <spring:message code="mard.danhsach.sua" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="mard.danhsach.xemcongvan" /> </th>
                            <th class="text-center" style="width: 25px;"> <spring:message code="mard.danhsach.xoa" /> </th>
                        </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT">
                            </td>  
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-history" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="text : fiMaHoso, click: $parent.bXemClick.bind($parent)"></a>
                            </td> 
                            <td class="text-center" data-bind="text : fiNgayguiText"></td>                           
                            <td class="text-center" data-bind="text : fiNgaycapCvText"></td> 
                            <td data-bind="text: fiTenHanghoa"></td>
                            <td>
                                <a href="javascript:void(0)" data-bind="text : fiTenTt, event : {click : $parent.fiTrangThaiClick.bind($parent)}"></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-edit tooltips" data-original-title="Sửa hồ sơ" data-bind="visible: bSuaHoSo, click: $parent.bSuaClick.bind($parent)" src="" alt=""/></a>
                            </td> 
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Xem thông báo" data-bind="visible: bXemThongBao, click: $parent.bXemThongBaoClick.bind($parent)" src="" alt=""/></a>
                            </td>                            
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-close tooltips" style="color:red" data-original-title="Xoá hồ sơ" data-bind="visible: bXoaHoSo, click: $parent.bXoaClick.bind($parent)" src="" alt=""/></a>
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
                </div>
            </div>
        </div>
    </div>
    <%@include file="inc_script.jsp" %>

    <script src="<c:url value='/app/mard/12/model.js?v=${version}'/>" type="text/javascript"></script>
    <script src="<c:url value='/app/mard/12/index.js?v=${version}' />" type="text/javascript"></script>

    <template id="confirm-tmpl">
        <div class="row">
            <form role="form" class="form-horizontal" id="xoahoso-form">
                <div class="col-md-12">
                    <span data-bind="text: fiMsg"></span><b data-bind="text: fiMaHoso"></b>
                </div>
            </form>
        </div>
    </template>
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
                        <th class="text-center"><b><spring:message code="mard.lichsu.stt" /></b></th>
                        <th><b><spring:message code="mard.lichsu.nguoixuly" /></b></th>
                        <th><b><spring:message code="mard.lichsu.donvixuly" /></b></th>
                        <th style="max-width: 200px;"><b><spring:message code="mard.lichsu.noidung" /></b></th>
                        <th class="text-center"><b><spring:message code="mard.lichsu.thoigian" /></b></th>
                        <th style="max-width: 200px;"><b><spring:message code="mard.lichsu.trangthaihoso" /></b></th>
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
    <template id="kqxl-template">
        <form role="form" class="form-horizontal" id="kqxl-form">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-4">
                        <label>Mã hồ sơ: </label>
                    </div>
                    <div class="col-md-8" data-bind="text : fiMaHoso">  
                    </div>
                </div>  
                <div class="col-md-12">
                    <div class="col-md-4">
                        <label>Nội dung: </label>
                    </div>
                    <div class="col-md-8" data-bind="text : fiLydo">  
                    </div>
                </div>   
                <div class="col-md-12">
                    <div class="col-md-4">
                        <label>Ngày xử lý: </label>
                    </div>
                    <div class="col-md-8" data-bind="date : fiNgayXl">  
                    </div>
                </div>   
                
                <div class="col-md-12" data-bind="if: fiNgaytraKq">
                    <div class="col-md-4">
                        <label>Ngày trả kết quả: </label>
                    </div>
                    <div class="col-md-8" data-bind="date : fiNgaytraKq">  
                    </div>
                </div>   
                
                <div class="col-md-12">
                    <div class="col-md-4">
                        <label>Đơn vị xử lý: </label>
                    </div>
                    <div class="col-md-8" data-bind="text : fiDonviXl">  
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-4">
                        <label>Người xử lý: </label>
                    </div>
                    <div class="col-md-8" data-bind="text : fiNguoiXl">  
                    </div>
                </div>
                <div class="col-md-12" data-bind="visible: visibleFile">
                    <div class="col-md-4">
                        <label>Tệp đính kèm: </label>
                    </div>
                    <div class="col-md-8">
                        <a target="_blank" href="javascript:void(0);" data-bind="attr: { href: downloadUrl}, text: fiTenTep"></a>
                    </div>
                </div>
            </div>
        </form>
    </template> 