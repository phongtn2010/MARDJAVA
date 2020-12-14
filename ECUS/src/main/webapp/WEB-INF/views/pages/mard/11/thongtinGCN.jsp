<%-- 
    Document   : thongtinGCN
    Created on : Sep 12, 2017, 10:36:56 PM
    Author     : hieptran
--%>


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
<div class="row" id="gcn11Create">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <span class="caption-subject bold uppercase"> </span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="tabbable-custom ">
                                <ul class="nav nav-tabs ">
                                    <li class="active">
                                        <a href="#tab_mard11_1" data-toggle="tab" id="a-tab-mard11-1"> <b>Cung cấp thông tin CNKD </b></a>
                                    </li>
                                </ul>

                                <div class="tab-content" >
                                    <div class="tab-pane active" id="tab_mard11_1" >
                                    <form role="form" class="form-horizontal" id="mard10Form">
                                        <fieldset>
                                            <legend>Thông tin để cấp chứng thư</legend>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Loại chứng thư <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <select class="form-control" id="fiLoaiCt" name="fiLoaiCt" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenLoaiCt, value : fiLoaiCt, options : fiLoaiCtList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Gửi nước xuất khẩu <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <select class="form-control" id="fiManuocXk" name="fiManuocXk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTennuocXk, value : fiManuocXk, options : fiManuocXkList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>  
                                            </div> 
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Gửi nước quá cảnh (nếu có) <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <select class="form-control" id="fiManuocQc" name="fiManuocQc" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTennuocQc, value : fiManuocQc, options : fiManuocQcList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>  
                                            </div> 
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Số giấy CNKD <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiSoGcn" name="fiSoGcn" data-bind="value : fiSoGcn" type="text" required maxlength="50"/>
                                                    </div>
                                                </div>  
                                            </div> 
                                            
                                            <div class="form-group">
                                                <div class="col-md-12" style="text-align: center;">
                                                    DIỄN GIẢI VỀ LÔ HÀNG
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Tên người xuất khẩu <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiNguoiXk" name="fiNguoiXk" data-bind="value : fiNguoiXk" type="text" required maxlength="500"/>
                                                    </div>
                                                </div>  
                                            </div> 
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Địa chỉ người xuất khẩu <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiDiachiXk" name="fiDiachiXk" data-bind="value : fiDiachiXk" type="text" required maxlength="500"/>
                                                    </div>
                                                </div>  
                                            </div> 
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Tên người nhận <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiTenNn" name="fiTenNn" data-bind="value : fiTenNn" type="text" required maxlength="500"/>
                                                    </div>
                                                </div>  
                                            </div> 
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Địa chỉ người nhận <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiDiachiNn" name="fiDiachiNn" data-bind="value : fiDiachiNn" type="text" required maxlength="500"/>
                                                    </div>
                                                </div>  
                                            </div> 
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Số lượng <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="fiSoluong" name="fiSoluong" data-bind="value : fiSoluong" type="text" required maxlength="19"/>
                                                    </div>
                                                    <div class="col-md-2"> <a class="nsw-require-field">*</a>
                                                        <select style="width: 95%; float: right;" class="form-control" id="fiMabaobi" name="fiMabaobi" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenbaobi, value : fiMabaobi, options : fiMabaobiList, optionsText : 'name'"></select>
                                                    </div>
                                                    <div class="col-md-3">
                                                        Hiển thị lên giấy <a class="nsw-require-field">*</a>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input class="form-control" id="fiHienthi" name="fiHienthi" data-bind="value : fiHienthi" type="text" required maxlength="255"/>
                                                    </div>
                                                </div>  
                                            </div> 
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Quy cách đóng gói <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <select class="form-control" id="fiQuycachDg" name="fiQuycachDg" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQuycachDg, value : fiQuycachDg, options : fiQuycachDgList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Ký, mã hiệu <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiMakyhieu" name="fiMakyhieu" data-bind="value : fiMakyhieu" type="text" required maxlength="500"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Tên nhà sản xuất</label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiTenNsx" name="fiTenNsx" data-bind="value : fiTenNsx" type="text"  maxlength="35"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Địa chỉ nhà sản xuất</label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiDiachiNsx" name="fiDiachiNsx" data-bind="value : fiDiachiNsx" type="text"  maxlength="250"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Nước sản xuất <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <select class="form-control" id="fiManuocSx" name="fiManuocSx" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTennuocSx, value : fiManuocSx, options : fiManuocSxList, optionsText : 'name'" disabled="true"></select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label>Tỉnh/thành</label>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <select class="form-control" id="fiMatinh" name="fiMatinh" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTentinh, value : fiMatinh, options : fiMatinhList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Hình thức chuyên chở <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <select class="form-control" id="fiHtcc" name="fiHtcc" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenHtcc, value : fiHtcc, options : fiHtccList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Tên phương tiện chuyên chở <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiPtcc" name="fiPtcc" data-bind="value : fiPtcc" type="text" required  maxlength="250"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Số hiệu phương tiện</label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiSohieuPt" name="fiSohieuPt" data-bind="value : fiSohieuPt" type="text" maxlength="250"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Cửa khẩu nhập <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <input class="form-control" id="fiCkNhap" name="fiCkNhap" data-bind="value : fiCkNhap" required type="text" maxlength="250"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                        <fieldset>
                                            <legend>Thông tin để cấp chứng thư</legend>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Tên sản phẩm <a class="nsw-require-field">*</a></label>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input class="form-control" id="hh_fiTenHh" name="hh_fiTenHh" data-bind="value : hh_fiTenHh"  type="text" maxlength="500"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label>Tên khoa học</label>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input class="form-control" id="hh_iTenKh" name="hh_fiCkNhap" data-bind="value : hh_fiTenKh"  type="text" maxlength="500"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Số lượng</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="hh_fiSoluong" name="fiSoluong" data-bind="value : hh_fiSoluong"  type="text"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" id="hh_fiMadvSl" name="hh_fiMadvSl" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : hh_fiTendvSl, value : hh_fiMadvSl, options : hh_fiMadvSlList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Khối lượng tịnh</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="hh_fiKhoiluong" name="hh_fiKhoiluong" data-bind="value : hh_fiKhoiluong"  type="text"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" id="hh_fiMadvKl" name="hh_fiMadvKl" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : hh_fiTendvKl, value : hh_fiMadvKl, options : hh_fiMadvKlList, optionsText : 'name'"></select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label>Khối lượng cả bì</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="hh_fiKlbi" name="hh_fiKlbi" data-bind="value : hh_fiKlbi"  type="text"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" id="hh_fiMadvBi" name="hh_fiMadvBi" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : hh_fiTendvBi, value : hh_fiMadvBi, options : hh_fiMadvBiList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Thể tích tịnh</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="hh_fiThetich" name="hh_fiThetich" data-bind="value : hh_fiThetich"  type="text"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" id="hh_fiMadvTt" name="hh_fiMadvTt" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : hh_fiTendvTt, value : hh_fiMadvTt, options : hh_fiMadvTtList, optionsText : 'name'"></select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label>Thể tích cả bì</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="hh_fiThetichbi" name="hh_fiThetichbi" data-bind="value : hh_fiThetichbi"  type="text"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" id="hh_fiMadvTtbi" name="hh_fiMadvTtbi" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : hh_fiTendvTtbi, value : hh_fiMadvTtbi, options : hh_fiMadvTtbiList, optionsText : 'name'"></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                    </div>
                                                    <div class="col-md-10">                                        
                                                        <a href="javascript:void(0);" class="btn green" id="updateHanghoa" data-bind="click: updateHanghoaClick"><i class="fa fa-add"></i> Thêm/Cập nhật</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="tbdhhgcn11">
                                                        <thead>
                                                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                                                <th class="text-center">STT</th>
                                                                <th class="text-center">Tên sản phẩm</th>
                                                                <th class="text-center">Tên khoa học</th>
                                                                <th class="text-center">Số lượng</th>
                                                                <th class="text-center">Khối lượng tịnh</th>
                                                                <th class="text-center">Khối lượng cả bì</th>
                                                                <th class="text-center">Thể tích tịnh</th>
                                                                <th class="text-center">Thể tích cả bì</th>
                                                                <th class="text-center" style="width:30px">Sửa</th>
                                                                <th class="text-center" style="width:30px">Xóa</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody data-bind="template: { name: 'tbdhhgcn11Tmpl', foreach: tbdhhgcn11 }">
                                                        </tbody>
                                                        <script id="tbdhhgcn11Tmpl" type="text/html">
                                                            <tr>
                                                                <td data-bind="text : fiStt">
                                                                </td>  
                                                                <td data-bind="text : fiTenHh">
                                                                </td> 
                                                                <td data-bind="text : fiTenKh">
                                                                </td> 
                                                                <td>
                                                                    <span data-bind="text : fiSoluong"></span>&nbsp;
                                                                    <span data-bind="text : fiTendvSl"></span>
                                                                </td> 
                                                                <td >
                                                                    <span data-bind="text : fiKhoiluong"></span>&nbsp;
                                                                    <span data-bind="text : fiTendvKl"></span>
                                                                </td>  
                                                                <td >
                                                                    <span data-bind="text : fiKlbi"></span>&nbsp;
                                                                    <span data-bind="text : fiTendvBi"></span>
                                                                </td>  
                                                                <td >
                                                                    <span data-bind="text : fiThetich"></span>&nbsp;
                                                                    <span data-bind="text : fiTendvTt"></span>
                                                                </td>  
                                                                <td >
                                                                    <span data-bind="text : fiThetichbi"></span>&nbsp;
                                                                    <span data-bind="text : fiTendvTtbi"></span>
                                                                </td>  
                                                                <td class="text-center">
                                                                    <a href="javascript:void(0);"><i class="fa fa-edit" data-bind="visible: bSua, click: $parent.bSuaHhClick.bind($parent)" src="" alt=""/></a>
                                                                </td>  
                                                                <td  class="text-center">
                                                                    <a href="javascript:void(0);"><i class="fa fa-trash" data-bind="visible: bXoa, click: $parent.bXoaHhClick.bind($parent)" src="" alt=""/></a>
                                                                </td>
                                                            </tr>                      
                                                        </script>
                                                    </table>
                                                    <span data-bind="text : errorHanghoaText" style="color:red;"> </span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Tổng khối lượng/thể tích tịnh</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="fiTongkltinh" name="fiTongkltinh" data-bind="value : fiTongkltinh"  type="text"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" id="fiMadvKl" name="fiMadvKl" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTendvKl, value : fiMadvKl, options : fiMadvKlList, optionsText : 'name'"></select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label>Hiển thị lên giấy</label>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input class="form-control" id="fiHienthiKl" name="fiHienthiKl" data-bind="value : fiHienthiKl"  type="text"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Tổng khối lượng/thể tích cả bì</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input class="form-control" id="fiTongklbi" name="fiTongklbi" data-bind="value : fiTongklbi"  type="text"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" id="fiMadvBi" name="fiMadvBi" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTendvBi, value : fiMadvBi, options : fiMadvBiList, optionsText : 'name'"></select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label>Hiển thị lên giấy</label>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input class="form-control" id="fiHienthiBi" name="fiHienthiBi" data-bind="value : fiHienthiBi"  type="text"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group" style="">
                                                <div class="col-md-12">
                                                    <div class="col-md-2">
                                                        <label>Khai báo bổ sung</label>
                                                    </div>
                                                    <div class="col-md-10">
                                                        <textarea class="form-control" id="" name=""  type="text" data-bind="value : fiKbbs" maxlength="2000"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                    </form>
                                    </div>
                                    <p class="nsw-text-center" id="mard11CreateFn">
                                        <a data-bind="click : btnGuiClick"  href="javascript:void(0);" class="btn blue" id="btnGui"><i class="fa fa-send" ></i> Gửi thông tin</a>
                                        <a data-bind="click : btnTroLaiClick" href="javascript:void(0);" class="btn grey" id="btnTroLai"><i class="fa fa-backward"></i> <spring:message code="common.button.trolai" /></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>      
<%@include file="incScript.jsp" %>      
<script type="text/javascript" charset="UTF-8">
    var user = JSON.parse('${user}');
</script>
<script src="<c:url value='/app/mard/11/model.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/11/thongtinGCN.js?v=${version}' />" type="text/javascript" charset="utf-8"></script>