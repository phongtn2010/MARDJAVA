<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br/><br/><span>Đề nghị miễn giảm kiểm tra có thời hạn chất lượng sản phẩm thức ăn chăn nuôi nhập khẩu sau đây</span><br/><br/>
<fieldset>

    <legend><b>Danh sách hàng hóa</b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center">Tên hàng hóa</th>
                        <th class="text-center">Mã hồ sơ TACN</th>
                        <th class="text-center">Mã số công nhận</th>
                        <th class="text-center">Hãng sản xuất</th>
                        <th class="text-center">Nước sản xuất</th>
                        <th class="text-center">Thành phần nguyên liệu</th>
                        <th class="text-center">Dạng màu sản phẩm</th>
                        <th class="text-center">Xóa</th>
                        <th class="text-center">Xem chi tiết</th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHanghoas">
                    <tr>
                        <td data-bind="text: fiStt"></td>  
                        <td>
                            <!-- ko if: rowSpan() > 0 -->
                                <span data-bind="text: fiTenHh"></span>
                            <!-- /ko -->
                        </td> 
                        <td data-bind="text: fiMahosoXncl"></td> 
                        <td data-bind="text: fiMsChungnhan"></td>                        
                        <td data-bind="text: fiMucChatluong"></td> 
                        <td data-bind="text: fiSodkXncl"></td>                         
                        <td data-bind="text: fiHangSx"></td> 
                        <td data-bind="text: fiNuocSx"></td> 
                        <td >
                            <span data-bind="text : fiNgaycapXnclText"></span>
                        </td> 
                        <td data-bind="text : fiSogiayXncl">
                        </td> 
                        <td class="text-center">
                            <!-- ko if: rowSpan() > 0 -->
                            <a class="btn red bt-center" data-bind="click: $parent.removeProductClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                            <!-- /ko -->
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHangHoaMessage" style="color:red;"> </span>
            <br />
            <a class="btn green bt-center" data-bind="click: addProductOnClick"><i class="fa fa-add fa-lg"></i> Thêm sản phẩm</a>
        </div>
    </div>
</fieldset>
<template id="thongtinhanghoa-tmpl">
    <div class="row">
        <div class="col-md-12">
            <form role="form" class="form-horizontal" id="thongtinhanghoa-form">
                <div class="row">                            
                    <div class="col col-md-6">
                        <spring:message code="common.tong" /> <b><a data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
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
                <label>Được phép chọn 1 hàng hóa trong danh sách hàng hóa được tính miễn giảm kiểm tra</label>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center">Tên hàng hóa</th>
                            <th class="text-center">Mã hồ sơ TACN</th>
                            <th class="text-center">Mã số công nhận</th>
                            <th class="text-center">Hãng sản xuất</th>
                            <th class="text-center">Nước sản xuất</th>
                            <th class="text-center">Thành phần nguyên liệu</th>
                            <th class="text-center">Dạng màu sản phẩm</th>
                            <th class="text-center">Xem</th>
                            <th class="text-center">Chọn</th>
                        </tr>
                    </thead>
                    <tbody data-bind="foreach: lstProdutList">
                        <tr>
                            <td data-bind="text: fiStt"></td>  
                            
                            <td>
                                <!-- ko if: rowSpan() > 0 -->
                                    <span data-bind="text: fiTenHh"></span>
                                <!-- /ko -->
                            </td> 
                            <td data-bind="text: fiMahosoXncl"></td> 
                            <td data-bind="text: fiMsChungnhan"></td>                        
                            <td data-bind="text: fiMucChatluong"></td> 
                            <td data-bind="text: fiSodkXncl"></td>                         
                            <td data-bind="text: fiHangSx"></td> 
                            <td data-bind="text: fiNuocSx"></td> 
                            <td >
                                <span data-bind="text : fiNgaycapXnclText"></span>
                            </td> 
                            <td>
                                <span data-bind="text: fiSogiayXncl"></span>
                            </td> 
                            <td class="text-center">
                                <!-- ko if: rowSpan() > 0 -->
                                <a class="btn red bt-center" data-bind="text: lable, click: $parent.onChange.bind($parent)"><i class="fa fa-trash"></i></a>
                                <!-- /ko -->
                            </td>
                        </tr>
                    </tbody>
                </table>        
            </form>
        </div>
    </div>
</template>
