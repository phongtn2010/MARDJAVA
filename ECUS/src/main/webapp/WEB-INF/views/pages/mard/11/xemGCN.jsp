<%-- 
    Document   : xemGCN
    Created on : Sep 22, 2017, 10:40:42 PM
    Author     : hieptran
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<form role="form" class="form-horizontal" id="gcn11View">
<fieldset>
    <legend>Thông tin để cấp chứng thư</legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Loại chứng thư </label>
            </div>
            <div class="col-md-10">
                <span id="fiLoaiCt" name="fiLoaiCt" data-bind="text : fiTenLoaiCt"></span>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Gửi nước xuất khẩu </label>
            </div>
            <div class="col-md-10">
                <span id="fiManuocXk" name="fiManuocXk" data-bind="text : fiTennuocXk"></span>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Gửi nước quá cảnh (nếu có) </label>
            </div>
            <div class="col-md-10">
                <span id="fiManuocQc" name="fiManuocQc" data-bind="text : fiManuocQc"></span>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Số giấy CNKD </label>
            </div>
            <div class="col-md-10">
                <span id="fiSoGcn" name="fiSoGcn" data-bind="text : fiSoGcn"   />
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
                <label>Tên người xuất khẩu </label>
            </div>
            <div class="col-md-10">
                <span id="fiNguoiXk" name="fiNguoiXk" data-bind="text : fiNguoiXk"   />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Địa chỉ người xuất khẩu </label>
            </div>
            <div class="col-md-10">
                <span id="fiDiachiXk" name="fiDiachiXk" data-bind="text : fiDiachiXk"   />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Tên người nhận </label>
            </div>
            <div class="col-md-10">
                <span id="fiTenNn" name="fiTenNn" data-bind="text : fiTenNn"   />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Địa chỉ người nhận </label>
            </div>
            <div class="col-md-10">
                <span id="fiDiachiNn" name="fiDiachiNn" data-bind="text : fiDiachiNn"   />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Số lượng </label>
            </div>
            <div class="col-md-2">
                <span id="fiSoluong" name="fiSoluong" data-bind="text : fiSoluong"   maxlength="19"/>
            </div>
            <div class="col-md-2"> 
                <span style="width: 95%; float: right;" id="fiMabaobi" name="fiMabaobi" data-bind="text : fiTenbaobi"></span>
            </div>
            <div class="col-md-3">
                Hiển thị lên giấy 
            </div>
            <div class="col-md-3">
                <span id="fiHienthi" name="fiHienthi" data-bind="text : fiHienthi"   />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Quy cách đóng gói </label>
            </div>
            <div class="col-md-10">
                <span id="fiQuycachDg" name="fiQuycachDg" data-bind="text: fiTenQuycachDg"></span>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Ký, mã hiệu </label>
            </div>
            <div class="col-md-10">
                <span id="fiMakyhieu" name="fiMakyhieu" data-bind="text : fiMakyhieu"   />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Tên nhà sản xuất</label>
            </div>
            <div class="col-md-10">
                <span id="fiTenNsx" name="fiTenNsx" data-bind="text : fiTenNsx"   />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Địa chỉ nhà sản xuất</label>
            </div>
            <div class="col-md-10">
                <span id="fiDiachiNsx" name="fiDiachiNsx" data-bind="text : fiDiachiNsx"   />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Nước sản xuất </label>
            </div>
            <div class="col-md-4">
                <span id="fiManuocSx" name="fiManuocSx" data-bind="text : fiTennuocSx" ></span>
            </div>
            <div class="col-md-2">
                <label>Tỉnh/thành</label>
            </div>
            <div class="col-md-4">
                <span id="fiMatinh" name="fiMatinh" data-bind="text : fiTentinh"></span>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Hình thức chuyên chở </label>
            </div>
            <div class="col-md-10">
                <span id="fiHtcc" name="fiHtcc" data-bind="text : fiTenHtcc"></span>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Tên phương tiện chuyên chở </label>
            </div>
            <div class="col-md-10">
                <span id="fiPtcc" name="fiPtcc" data-bind="text : fiPtcc"    />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Số hiệu phương tiện</label>
            </div>
            <div class="col-md-10">
                <span id="fiSohieuPt" name="fiSohieuPt" data-bind="text : fiSohieuPt"  />
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label>Cửa khẩu nhập </label>
            </div>
            <div class="col-md-10">
                <span id="fiCkNhap" name="fiCkNhap" data-bind="text : fiCkNhap"   />
            </div>
        </div>
    </div>
</fieldset>
<fieldset>
    <legend>Thông tin để cấp chứng thư</legend>
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
                    </tr>                      
                    </script>
                </table>

            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổng khối lượng/thể tích tịnh</label>
                </div>
                <div class="col-md-2">
                    <span id="fiTongkltinh" name="fiTongkltinh" data-bind="text : fiTongkltinh"  />
                </div>
                <div class="col-md-2">
                    <span id="fiMadvKl" name="fiMadvKl" data-bind="text : fiTendvKl"></span>
                </div>
                <div class="col-md-2">
                    <label>Hiển thị lên giấy</label>
                </div>
                <div class="col-md-4">
                    <span id="fiHienthiKl" name="fiHienthiKl" data-bind="text : fiHienthiKl"  />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổng khối lượng/thể tích cả bì</label>
                </div>
                <div class="col-md-2">
                    <span id="fiTongklbi" name="fiTongklbi" data-bind="text : fiTongklbi"  />
                </div>
                <div class="col-md-2">
                    <span id="fiMadvBi" name="fiMadvBi" data-bind="text : fiTendvBi"></span>
                </div>
                <div class="col-md-2">
                    <label>Hiển thị lên giấy</label>
                </div>
                <div class="col-md-4">
                    <span id="fiHienthiBi" name="fiHienthiBi" data-bind="text : fiHienthiBi"  />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Khai báo bổ sung</label>
                </div>
                <div class="col-md-10">
                    <span  id="fiKbbs" name="fiKbbs" data-bind="text : fiKbbs"  ></span>
                </div>
            </div>
        </div>
    </fieldset>
</form>
