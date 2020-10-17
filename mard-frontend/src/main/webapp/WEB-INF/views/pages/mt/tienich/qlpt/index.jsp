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
                    <span class="caption-subject bold uppercase"> <spring:message code="mt.qlpt.tenthutuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i class="fa fa-gift"></i> <spring:message code="mt.qlpt.tracuu.timkiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mt.qlpt.tracuu.biensoxe" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="biensoxe" id="biensoxe" data-bind="value : biensoxe, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="<spring:message code="common.tracuu.biensoxe" />" type="text"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="mt.qlpt.tracuu.tenchuxe" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="tenchuxe" id="tenchuxe" data-bind="value : tenchuxe, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="<spring:message code="common.tracuu.tenchuxe" />" type="text"/>
                                                </div>
                                            </div>  
                                        </div> 

                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: searchPhuongTienClick"><i class="fa fa-search"></i> Tìm kiếm</a>
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
                            <th class="text-center"> <spring:message code="mt.qlpt.danhsach.stt" /></th>
                            <th class="text-center" style="max-width: 100px;"> <spring:message code="mt.qlpt.danhsach.biensoxe" /> </th>
                            <th class="text-center" style="max-width: 120px;"> <spring:message code="mt.qlpt.danhsach.tenchuxe" /> </th>
                            <th class="text-center" style="max-width: 200px;"> <spring:message code="mt.qlpt.danhsach.nhanhieuxe" /> </th>
                            <th class="text-center" style="max-width: 100px;"> <spring:message code="mt.qlpt.danhsach.loaihinhxe" /> </th>
                            <th class="text-center"> <spring:message code="mt.qlpt.danhsach.thaotac" /> </th>
                        </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT">
                            </td>  
                            <td class="text-left" >
                                <a href="javascript:void(0)" data-bind="text : fiBksXe, click: $parent.bXemClick.bind($parent)"></a>
                            </td>  
                            <td class="text-left" data-bind="text : fiTenChuxe">
                            </td>  
                            <td class="text-left" data-bind="text : fiTenNhanhieu">
                            </td>  
                            <td class="text-left" data-bind="text : fiTenLoaixe">
                            </td>  

                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-edit tooltips" data-original-title="Sửa hồ sơ" data-bind="visible: bXinSuaphuongtien, click: $parent.bSuaClick.bind($parent)" src="" alt=""/></a>                           
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-close tooltips" style="color:red" data-original-title="Xoá phương tiện" data-bind=" click: $parent.bXoaClick.bind($parent)" src="" alt=""/></a>
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


    <script src="<c:url value='/app/mt/tienich/qlpt/model.js?v=${version}'/>" type="text/javascript"></script>
    <script src="<c:url value='/app/mt/tienich/qlpt/index.js?v=${version}' />" type="text/javascript"></script>

    <template id="confirm-tmpl">
        <div class="row">
            <form role="form" class="form-horizontal" id="xoahoso-form">
                <div class="col-md-12">
                    <span data-bind="text: fiMsg"></span><b data-bind="text: fiMaHoso"></b>
                </div>
            </form>
        </div>
    </template>
