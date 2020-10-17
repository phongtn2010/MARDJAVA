<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="incLanguage.jsp" %>
<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<div class="row" id="mard10">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"><span class="caption-subject bold uppercase"> <spring:message code="mard.10.ten_thu_tuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i class="fa fa-gift"></i> <spring:message code="common.tracuu.thong_tin_tim_kiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm06" id="searchForm06">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ma_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="fiMaHoso" id="fiMaHoso" data-bind="value : fiMaHoso, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.trang_thai_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="fiTrangthai" name="fiTrangthai" class="form-control select2" 
                                                            data-bind="value : fiTrangthai, options : fiTrangthaiList, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_tu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="fromFiNgaytao" id="fromFiNgaytao" data-bind="datepicker : fromFiNgaytao" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_den" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="toFiNgaytao" data-bind="datepicker : toFiNgaytao" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label >Tên hàng hóa</label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="fiTenHanghoa" id="fiTenHanghoa" data-bind="value : fiTenHanghoa" class="form-control form-control-inline"  type="text" value=""  />
                                                </div>

                                                <div class="col-md-2">
                                                    <label >Đơn vị thực hiện</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="fiMaDvkd" name="fiMaDvkd" class="form-control select2" 
                                                            data-bind="value : fiMaDvkd, options : fiMaDvkdList, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
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
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="mard10Items">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> STT</th>
                            <th class="text-center" style="width: 120px;"> Mã hồ sơ </th>
                            <th class="text-center" > Tên hàng hóa </th>
                            <th class="text-center" style="width: 200px;"> Đơn vị thực hiện </th>
                            <th class="text-center" style="width: 100px;"> Ngày tạo </th>
                            <th class="text-center" style="max-width: 200px;"> Trạng thái hồ sơ </th>
                            <th class="text-center" style="width: 25px;"> Xem </th>
                            <th class="text-center" style="width: 25px;"> Sửa </th>
                            <th class="text-center" style="width: 25px;"> Xin sửa </th>
                            <th class="text-center" style="width: 25px;"> Xoá </th>
                            <th class="text-center" style="width: 25px;"> Xin hủy </th>
                            <th class="text-center" style="width: 25px;"> Thông báo chuyển khoản </th>
                            <th class="text-center" style="width: 25px;"> Xin sửa GCN </th>
                        </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemsmard10Tmpl', foreach: mard10Items }">
                    </tbody>
                    <script id="itemsmard10Tmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT">
                            </td>  
                            <td class="text-center" data-bind="text : fiMaHoso">
                            </td> 
                            <td  data-bind="text : fiTenHanghoa">
                            </td>
                            <td data-bind="text : fiTenDvkd">
                                
                            </td> 
                            <td class="text-center" data-bind="date : fiNgaytao">
                            </td>  
                            <td style="max-width: 200px;">
                                <a href="javascript:void(0)" data-bind="text : fiTenTrangthai, event : {click : $parent.fiTrangThaiClick.bind($parent)}"></a>
                            </td> 
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-eye" data-bind="visible: true, click: $parent.bXemClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-edit" data-bind="visible: bSua, click: $parent.bSuaClick.bind($parent)" src="" alt=""/></a>
                            </td>  
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-edit" data-bind="visible: bXinSua, click: $parent.bXinSuaClick.bind($parent)" src="" alt=""/></a>
                            </td>   
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-close" data-bind="visible: bHuy, click: $parent.bHuyClick.bind($parent)" src="" alt=""/></a>
                            </td>  
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-edit" data-bind="visible: bXinHuy, click: $parent.bXinHuyClick.bind($parent)" src="" alt=""/></a>
                            </td>    
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-gift" data-bind="visible: bThongBaoCK, click: $parent.bThongBaoCKClick.bind($parent)" src="" alt=""/></a>
                            </td>  
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-edit" data-bind="visible: bXinSuaGCN, click: $parent.bXinSuaGCNClick.bind($parent)" src="" alt=""/></a>
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
<%@include file="incScript.jsp" %>

<script src="<c:url value='/app/mard/10/model.js?v=${version}'/>" type="text/javascript"></script>
<script src="<c:url value='/app/mard/10/index.js?v=${version}' />" type="text/javascript"></script>
<template id="gcn-template">
    <form role="form" class="form-horizontal" id="gcn-form">
        <div class="form-group">
            <div class="col-md-2">
                Chọn mẫu giấy chứng nhận: <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10">
                <select class="form-control" id="fiLoaiGcn1" name="fiLoaiGcn">
                    <option value="1">Mẫu 14a - Giấy chứng nhận vận chuyển động vật nhập khẩu về nơi cách ly kiểm dịch</option>
                    <option value="2">Mẫu 14b - Giấy chứng nhận vận chuyển sản phẩm động vật nhập khẩu về nơi cách ly kiểm dịch</option>
                    <option value="3">Mẫu 15a - Giấy chứng nhận kiểm dịch động vật nhập khẩu</option>
                    <option value="4">Mẫu 15b - Giấy chứng nhận vận chuyển sản phẩm động vật nhập khẩu không dùng làm thực phẩm</option>
                    <option value="5">Mẫu 15c - Giấy chứng nhận kiểm dịch và vệ sinh an toàn thực phẩm sản phẩm động vật nhập khẩu dùng làm thực phẩm</option>
                </select>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-2">
                Nội dung xin chỉnh sửa giấy Chứng nhận : <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10">
                <textarea rows="3" class="form-control" id="fiLydo" name="fiLydo" type="text" maxlength="2000"></textarea>
            </div>  
        </div>
    </form>
</template>

<template id="cancel-template">
    <form role="form" class="form-horizontal" id="cancel-form">
        <div class="form-group">
            <div class="col-md-2">
                Đề nghị xin hủy hồ sơ vì lý do như sau: <a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-10">
                <textarea rows="3" class="form-control" id="fiLydo" name="fiLydo" type="text" maxlength="2000"></textarea>
            </div>  
        </div>
    </form>
</template>

<template id="payment-template">
    <form role="form" class="form-horizontal" id="payment-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Tổng số tiền <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-8">                                        
                    <input class="form-control" id="fiSotienCk" name="fiSotienCk" data-bind="value : fiSotienCk" type="text" maxlength="19"></input>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Tổng số tiền (Bằng chữ) <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-8">                                        
                    <input class="form-control" id="fiNdSotien" name="fiNdSotien" data-bind="value : fiNdSotien" type="text" maxlength="250"></input>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Người nộp <a class="nsw-require-field">*</a></label>
                </div>

                <div class="col-md-8">
                    <input  class="form-control " id="fiNguoinop" name="fiNguoinop" data-bind="value : fiNguoinop"  type="text" maxlength="250"/>
                </div>
            </div>   
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Ngày nộp <a class="nsw-require-field">*</a></label>
                </div>

                <div class="col-md-8">
                    <input  class="form-control date-picker" id="fiNgaynop" name="fiNgaynop" data-bind="datepicker : fiNgaynop" data-date-format="dd/mm/yyyy" type="text" maxlength="8"/>
                </div>
            </div>   
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Số hóa đơn</label>
                </div>

                <div class="col-md-8">
                    <input  class="form-control" id="fiSohoadon" name="fiSohoadon" data-bind="value : fiSohoadon"  type="text" maxlength="250"/>
                </div>
            </div>   
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>File đính kèm</label>
                </div>
                <div class="col-md-8">
                    <input type="file" data-bind="event: {change: fileUpload}" accept=".pdf,.jpg,.tif"/>
                </div>
            </div>   
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Chú thích</label>
                </div>
                <div class="col-md-8">                                        
                    <textarea class="form-control" id="fiChuthich" name="fiChuthich" data-bind="value : fiChuthich" type="text" maxlength="500"></textarea>
                </div>
            </div>  
        </div>
    </form>
</template>   

<template id="alert-payment-template">
    <form role="form" class="form-horizontal" id="alert-payment-form">
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
                    <label>Tổng số tiền: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiTongTien">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Chú thích: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiChuthich">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Đơn vị xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiDvXl">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Người xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNguoiXl">  
                </div>
            </div> 
            
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Loại phí: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiLoaiphiText">  
                </div>
            </div> 
        </div>
    </form>
</template>

<template id="kqtd-template">
    <form role="form" class="form-horizontal" id="kqtd-form">
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
                    <label>Lý do: </label>
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
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Đơn vị xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiDvXl">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Chuyên viên xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiCvXl">  
                </div>
            </div>  
        </div>
    </form>
</template>

<template id="xacnhan-template">
    <form role="form" class="form-horizontal" id="xacnhan-form">
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
                    <label>Địa điểm kiểm dịch: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiXnDdkd">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Thời gian kiểm dịch: </label>
                </div>
                <div class="col-md-8" data-bind="date : fiXnTgkd">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Số vào sổ: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiSoVaoso">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Ngày ký (của BNN): </label>
                </div>
                <div class="col-md-8" data-bind="date : fiXnNgayky">  
                </div>
            </div>  
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Người ký (của BNN): </label>
                </div>
                <div class="col-md-8" data-bind="text : fiXnNguoiky">  
                </div>
            </div>  
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Nơi ký (của BNN): </label>
                </div>
                <div class="col-md-8" data-bind="text : fiXnNoiky">  
                </div>
            </div>  
        </div>
    </form>
</template>

<template id="kqxinrut-template">
    <form role="form" class="form-horizontal" id="kqxinrut-form">
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
                    <label>Nội dung từ chối: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiLydoBnn">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Ngày xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="date : fiNgayXl">  
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
                    <label>Cán bộ tiếp nhận: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNguoiXl">  
                </div>
            </div>  
        </div>
    </form>
</template>

<template id="kqxinsua-template">
    <form role="form" class="form-horizontal" id="kqxinsua-form">
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
                    <label>Nội dung từ chối: </label>
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
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Đơn vị xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiDonviXl">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Cán bộ tiếp nhận: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNguoiXl">  
                </div>
            </div>  
        </div>
    </form>
</template>

<template id="lohangxl-template">
    <form role="form" class="form-horizontal" id="lohangxl-form">
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
                    <label>Nội dung thông báo lô hàng cần xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNoidung">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Đơn vị xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiDvXl">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Chuyên viên xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNguoiXl">  
                </div>
            </div>  
        </div>
    </form>
</template>

<template id="kqxinsuagcn-template">
    <form role="form" class="form-horizontal" id="kqxinsuagcn-form">
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
                    <label>Nội dung từ chối: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiLydoBnn">  
                </div>
            </div>   
            <div class="col-md-12">
                <div class="col-md-4">
                    <label>Ngày xử lý: </label>
                </div>
                <div class="col-md-8" data-bind="date : fiNgayXl">  
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
                    <label>Cán bộ tiếp nhận: </label>
                </div>
                <div class="col-md-8" data-bind="text : fiNguoiTn">  
                </div>
            </div>  
        </div>
    </form>
</template>