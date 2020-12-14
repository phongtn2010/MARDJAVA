<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<form role="form" class="form-horizontal" id="mard10Form">
    <fieldset>
        <legend>Thêm mới hồ sơ</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mã hồ sơ</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                </div>
                <div class="col-md-2">
                    <label>Trạng thái hồ sơ</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTrangthaiText" name="fiTrangthaiText" data-bind="value : fiTrangthaiText" type="text" readonly/>
                    <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Ngày tạo</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2">
                    <label>Đơn vị kiểm dịch <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control" id="fiMaDvkd" name="fiMaDvkd" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenDvkd, value : fiMaDvkd, options : fiMaDvkdList, optionsText : 'name'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Đơn khai báo số</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiDonkb" name="fiSoTk" data-bind="value : fiDonkb" maxlength="250" />
                </div>
                <div class="col-md-2">
                    <label>Đơn vị giám sát</label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control" id="fiMaDvgs" name="fiMaDvgs" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenDvgs, value : fiMaDvgs, options : fiMaDvgsList, optionsText : 'name'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số vận đơn <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoVandon" name="fiSoVandon" type="text" data-bind="value:fiSoVandon" maxlength="35"/>
                </div>
                <div class="col-md-2">
                    <label>Số tờ khai</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoTk" name="fiSoTk" placeholder="" data-bind="value: fiSoTk" type="text" maxlength="13"/>
                </div>
            </div>  
        </div>  
    </fieldset>
    <fieldset>
        <legend>Thông tin doanh nghiệp</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tên tổ chức, cá nhân <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenCty" name="fiTenCty" data-bind="value : fiTenCty" type="text" required maxlength="250"/>
                </div>

                <div class="col-md-2">
                    Điện thoại
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSdtCty" name="fiSdtCty" data-bind="value : fiSdtCty" type="text" maxlength="50"/>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ <a class="nsw-require-field">*</a></label>                    
                </div>
                <div class="col-md-10">
                    <input class="form-control form-control-inline" id="fiDiachiCty" name="fiDiachiCty" data-bind="value : fiDiachiCty" type="text" maxlength="500"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Email </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailCty" name="fiEmailCty" data-bind="value : fiEmailCty" type="text" maxlength="50"/>
                </div>

                <div class="col-md-2">
                    Fax
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxCty" name="fiFaxCty" data-bind="value : fiFaxCty" type="text" maxlength="50"/>
                </div>
            </div>  
        </div> 
    </fieldset>

    <fieldset>
        <legend>Mô tả hàng hóa</legend>
        
        <div class="form-group">
            <div class="col-md-12">
                <label>Đề nghị quý cơ quan kiểm dịch nhập khẩu lô hàng nhập khẩu</label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tên hàng <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenHh" name="fiTenHh" data-bind="value : fiTenHh" maxlength="250"></input>
                    <input type="hidden" id="fiIdHh" name="fiIdHh" data-bind="value : fiIdHh"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nơi sản xuất <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiNoiSx" name="fiNoiSx" data-bind="value : fiNoiSx" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số lượng <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiSoluong" name="fiSoluong" data-bind="value : fiSoluong" maxlength="9"></input>
                </div>
                <div class="col-md-2">
                    <label>Đơn vị tính <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">        
                    <select class="form-control" id="fiMdvSl" name="fiMdvSl" data-bind="optionsCaption: 'Chọn...', value : fiMdvSl, selectedText : fiTendvSl, options : fiMdvSlList, optionsText: 'name', optionsValue:'id'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Trọng lượng tịnh</label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiTlTinh" name="fiTlTinh" data-bind="value : fiTlTinh" maxlength="19"></input>
                </div>
                <div class="col-md-2">
                    <label>Đơn vị tính</label>
                </div>
                <div class="col-md-4">        
                    <select class="form-control" id="fiMaTlTinh" name="fiMaTlTinh" data-bind="optionsCaption: 'Chọn...',value : fiMaTlTinh, selectedText : fiTentlTinh, options : fiMaTlTinhList, optionsText : 'name', optionsValue:'id'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Trọng cả bì</label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiTlBi" name="fiTlBi" data-bind="value : fiTlBi"  maxlength="19"></input>
                </div>
                <div class="col-md-2">
                    <label>Đơn vị tính</label>
                </div>
                <div class="col-md-4">        
                    <select class="form-control" id="fiMaTlBi" name="fiMaTlBi" data-bind="optionsCaption: 'Chọn...', value : fiMaTlBi, selectedText : fiTenTlBi, options : fiMaTlBiList, optionsText : 'name', optionsValue:'id'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Loại bao bì</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiLoaiBb" name="fiLoaiBb" data-bind="value : fiLoaiBb" maxlength="255"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số hợp đồng, chứng từ</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiSoHd" name="fiLoaiBb" data-bind="value : fiSoHd" maxlength="50"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                </div>
                <div class="col-md-10">                                        
                    <a href="javascript:void(0);" class="btn green" id="updateHanghoa" data-bind="click: updateHanghoaClick"><i class="fa fa-add"></i> Thêm/Cập nhật</a>
                    <a href="javascript:void(0);" class="btn green" id="chooseDocument" data-bind="click: chooseDocumentClick"><i class="fa fa-add"></i> Chọn từ văn bản chấp thuận của Cục Thú y</a>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center">STT</th>
                            <th class="text-center">Tên hàng</th>
                            <th class="text-center">Nơi sản xuất</th>
                            <th class="text-center">Số lượng</th>
                            <th class="text-center">Trọng lượng tịnh</th>
                            <th class="text-center">Trọng lượng cả bì</th>
                            <th class="text-center">Loại bao bì</th>
                            <th class="text-center">Số hợp đồng, chứng từ</th>
                            <th class="text-center" style="width:30px">Sửa</th>
                            <th class="text-center" style="width:30px">Xóa</th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'tbdhanghoaTmpl', foreach: lstHanghoa10 }">
                    </tbody>
                    <script id="tbdhanghoaTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : fiStt">
                            </td>  
                            <td data-bind="text : fiTenHh">
                            </td> 
                            <td data-bind="text : fiNoiSx">
                            </td>
                            <td>
                                <span data-bind="text : fiSoluong"></span>
                                <span data-bind="text : fiTendvSl"></span>
                            </td> 
                            <td >
                                <span data-bind="text : fiTlTinh"></span>
                                <span data-bind="text : fiTentlTinh"></span>
                            </td>  
                            <td >
                                <span data-bind="text : fiTlBi"></span>
                                <span data-bind="text : fiTenTlBi"></span>
                            </td>    
                            <td data-bind="text : fiLoaiBb">
                            </td>    
                            <td data-bind="text : fiSoHd">
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
                    <label>Tổ chức cá nhân xuất khẩu <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenDtxk" name="fiTenDtxk" data-bind="value : fiTenDtxk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nước xuất khẩu <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control" id="fiMaQgxk" name="fiMaQgxk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenQgxk, value : fiMaQgxk, options : fiMaQgxkList, optionsText : 'name', event : {change : fiMaQgxkChange}"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Cửa khẩu xuất <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control" id="fiMaCkxk" name="fiMaCkxk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenCkxk, value : fiMaCkxk, options : fiMaCkxkList, optionsText : 'name'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổ chức cá nhân nhập khẩu <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenDtnk" name="fiTenDtnk" data-bind="value : fiTenDtnk"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nước nhập khẩu <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenQgnk" name="fiTenQgnk" data-bind="value : fiTenQgnk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Phương tiện vận chuyển <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiPtvt" name="fiPtvt" data-bind="value : fiPtvt" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Cửa khẩu nhập <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control" id="fiMaCknk" name="fiMaCknk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenCknk, value : fiMaCknk, options : fiMaCknkList, optionsText : 'name'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mục địch sử dụng <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiMucdichSd" name="fiMucdichSd" data-bind="value : fiMucdichSd" maxlength="500"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Văn bản chấp thuận kiểm dịch của Cục Thú y (nếu có)</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiVbCtkd" name="fiVbCtkd" data-bind="value : fiVbCtkd" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm kiểm dịch <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDdkd" name="fiDdkd" data-bind="value : fiDdkd" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Thời gian kiểm dịch <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTgkd" name="fiTgkd" data-bind="value : fiTgkd" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm giám sát (nếu có)</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDdgs" name="fiDdgs" data-bind="value : fiDdgs" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Thời gian giám sát</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTggs" name="fiTggs" data-bind="value : fiTggs" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số bản giấy chứng nhận kiểm dịch cần cấp</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiSobanGcn" name="fiSobanGcn" data-bind="value : fiSobanGcn" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        
    </fieldset>
    <fieldset>
        <legend>Thông tin ký hồ sơ (cá nhân/tổ chức)</legend>
        <div class="form-group">
            <div class="col-md-12">
               Chúng tôi xin cam kết: bảo đảm nguyên trạng hàng hóa nhập khẩu, đưa về đúng địa điểm, đúng thời gian được đăng ký và chỉ đưa hàng hóa ra lưu thông sau khi được quý Cơ quan cấp Giấy chứng nhận kiểm dịch 
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nơi ký <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiNoiky" name="fiNoiky" data-bind="value : fiNoiky" maxlength="250"></input>
                </div>
                <div class="col-md-2">
                    <label>Ngày ký <a class="nsw-require-field">*</a></label>
                </div>

                <div class="col-md-4">
                    <input  class="form-control date-picker" id="fiNgayky" name="fiNgayky" data-bind="datepicker : fiNgayky" type="text" data-date-format="dd/mm/yyyy">
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Người ký <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiNguoiky" name="fiNguoiky" data-bind="value : fiNguoiky" maxlength="250"></input>
                </div>
            </div>  
        </div> 
    </fieldset>
</form>

<template id="select-document-template">
    <div id="select-document">
        <input placeholder="Chọn, hoặc nhập mã văn bản để tìm kiếm" class="form-control" id="select-document-input" list="documents" data-bind="datalist: {
            options: documents, 
            optionsValue: 'id', 
            optionsText: 'name', 
            value: selected}" />
    </div>
</template>   