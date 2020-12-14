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
                           type="text" data-bind="value : fiMaHoso" readonly="readonly" />
                </div>
                <div class="col-md-2">
                    <label>Trạng thái hồ sơ</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTrangthaiText" name="fiTrangthaiText" data-bind="value : fiTrangthaiText" type="text" readonly />
                    <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Ngày tạo</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly />
                </div>
                <div class="col-md-2">
                    <label>Đơn vị kiểm dịch <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control" id="fiMadvXl" name="fiMadvXl" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTendvXl, value : fiMadvXl, options : fiMadvXlList, optionsText : 'name'"></select>
                </div>
            </div>  
        </div> 
    </fieldset>
    <fieldset>
        <legend>Thông tin doanh nghiệp</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tên tổ chức, cá nhân <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiDtDangky" name="fiDtDangky" data-bind="value : fiDtDangky" type="text" required maxlength="250"/>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ <a class="nsw-require-field">*</a> </label>                    
                </div>
                <div class="col-md-10">
                    <input class="form-control form-control-inline" id="fiDiachi" name="fiDiachi" data-bind="value : fiDiachi" type="text" maxlength="500"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Email/Fax </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmail" name="fiEmail" data-bind="value : fiEmail" type="text" maxlength="250"/>
                </div>
                <div class="col-md-2">
                    Điện thoại
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSodt" name="fiSodt" data-bind="value : fiSodt" type="text" maxlength="250"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số CMND </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSocmnd" name="fiEmailCty" data-bind="value : fiSocmnd" type="text" maxlength="250"/>
                </div>

                <div class="col-md-2">
                    Ngày cấp CMND
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycmnd" name="fiNgaycmnd" data-bind="datepicker : fiNgaycmnd" type="text" maxlength="10"  data-date-format="dd/mm/yyyy"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nơi cấp CMND </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoicmnd" name="fiNoicmnd" data-bind="value : fiNoicmnd" type="text" maxlength="50"/>
                </div>
            </div>  
        </div>
    </fieldset>

    <fieldset>
        <legend>Mô tả hàng hóa</legend>
        
        <div class="form-group">
            <div class="col-md-12">
                <label></label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tên hàng <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiTenHh" name="fiTenHh" data-bind="value : fiTenHh" maxlength="250"></input>
                    <input type="hidden" id="fiIdHanghoa" name="fiIdHanghoa" data-bind="value : fiIdHanghoa"/>
                </div>
                <div class="col-md-2">
                    <label>Tên khoa học</label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiTenKh" name="fiTenKh" data-bind="value : fiTenKh" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Cơ sở sản xuất <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiCososx" name="fiCososx" data-bind="value : fiCososx" maxlength="250"></input>
                </div>
                <div class="col-md-2">
                    <label>Mã số (nếu có)</label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiMaCososx" name="fiTenHh" data-bind="value : fiMaCososx" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDiachiCssx" name="fiDiachiCssx" data-bind="value : fiDiachiCssx" maxlength="500"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số lượng </label>
                </div>
                <div class="col-md-2">                                        
                    <input class="form-control" id="fiSoluong" name="fiSoluong" data-bind="value : fiSoluong" maxlength="19"></input>
                </div>
                <div class="col-md-2">        
                    <select class="form-control" id="fiMadvSl" name="fiMadvSl" data-bind="optionsCaption: 'Chọn...', value : fiMadvSl, selectedText : fiTendvSl, options : fiMadvSlList, optionsText: 'name', optionsValue:'id'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Khối lượng tịnh</label>
                </div>
                <div class="col-md-2">                                        
                    <input class="form-control" id="fiKlTinh" name="fiKlTinh" data-bind="value : fiKlTinh" maxlength="19"></input>
                </div>
                <div class="col-md-2">        
                    <select class="form-control" id="fiMadvKlt" name="fiMadvKlt" data-bind="optionsCaption: 'Chọn...',value : fiMadvKlt, selectedText : fiTendvKlt, options : fiMadvKltList, optionsText : 'name', optionsValue:'id'"></select>
                </div>
                <div class="col-md-2">
                    <label>Khối lượng cả bì</label>
                </div>
                <div class="col-md-2">                                        
                    <input class="form-control" id="fiKlBi" name="fiKlBi" data-bind="value : fiKlBi" maxlength="19"></input>
                </div>
                <div class="col-md-2">        
                    <select class="form-control" id="fiMadvBi" name="fiMadvBi" data-bind="optionsCaption: 'Chọn...',value : fiMadvBi, selectedText : fiTendvBi, options : fiMadvBiList, optionsText : 'name', optionsValue:'id'"></select>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Ký mã hiệu, số hợp đồng hoặc LC</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiSohd" name="fiSohd" data-bind="value : fiSohd" maxlength="255"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mã HS <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiMahs" name="fiMahs" data-bind="value : fiMahs" maxlength="12"></input>
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
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa11">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center">STT</th>
                            <th class="text-center">Tên hàng hóa</th>
                            <th class="text-center">Tên khoa học</th>
                            <th class="text-center">Số lượng</th>
                            <th class="text-center">Khối lượng tịnh</th>
                            <th class="text-center">Khối lượng cả bì</th>
                            <th class="text-center">Cơ sở sản xuất</th>
                            <th class="text-center">Mã số</th>
                            <th class="text-center">Địa chỉ</th>
                            <th class="text-center">Số hợp đồng / chứng từ</th>
                            <th class="text-center">Mã HS</th>
                            <th class="text-center" style="width:30px">Sửa</th>
                            <th class="text-center" style="width:30px">Xóa</th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'tbdhanghoaTmpl', foreach: lstHanghoa11 }">
                    </tbody>
                    <script id="tbdhanghoaTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : fiStt">
                            </td>  
                            <td data-bind="text : fiTenHh">
                            </td> 
                            <td data-bind="text : fiTenKh">
                            </td> 
                            <td>
                                <span data-bind="text : fiSoluong"></span>
                                <span data-bind="text : fiTendvSl"></span>
                            </td> 
                            <td >
                                <span data-bind="text : fiKlTinh"></span>
                                <span data-bind="text : fiTendvKlt"></span>
                            </td>  
                            <td >
                                <span data-bind="text : fiKlBi"></span>
                                <span data-bind="text : fiTendvBi"></span>
                            </td>    
                            <td data-bind="text : fiCososx">
                            </td>
                            <td data-bind="text : fiMaCososx">
                            </td>
                            <td data-bind="text : fiDiachiCssx">
                            </td>
                            
                            <td data-bind="text : fiSohd">
                            </td>    
                            <td data-bind="text : fiMahs">
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
    </fieldset>
    
    <fieldset>
        <legend>Thông tin xuất khẩu</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổ chức cá nhân xuất khẩu <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDtXk" name="fiDtXk" data-bind="value : fiDtXk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDiachidtxk" name="fiTenDtxk" data-bind="value : fiDiachidtxk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Cửa khẩu xuất <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control" id="fiMackXk" name="fiMackXk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenckXk, value : fiMackXk, options : fiMackXkList, optionsText : 'name'"></select>
                </div>
                
                <div class="col-md-2">
                    <label>Phương tiện chuyên chở <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiPtCc" name="fiPtCc" data-bind="value : fiPtCc" maxlength="250"></input>
                </div>
            </div>  
        </div> 
    </fieldset>
    
    <fieldset>
        <legend>Thông tin nhập khẩu</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổ chức cá nhân nhập khẩu <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDtNk" name="fiDtNk" data-bind="value : fiDtNk"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDiachidtnk" name="fiDiachidtnk" data-bind="value : fiDiachidtnk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nước nhập khẩu <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-4">                              
                    <select class="form-control" id="fiMaqgNk" name="fiMaqgNk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenqgNk, value : fiMaqgNk, options : fiMaqgNkList, optionsText : 'name', event : {change : fiMaqgNkChange}"></select>
                </div>
                <div class="col-md-2">
                    <label>Cửa khẩu nhập <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-4">                                                
                    <select class="form-control" id="fiMackNk" name="fiMackNk" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenckNk, value : fiMackNk, options : fiMackNkList, optionsText : 'name'"></select>  
                </div>
            </div>  
        </div> 
    </fieldset>
    
    <fieldset>
        <legend>Thông tin khác</legend>

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mục địch sử dụng <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiMucdichsd" name="fiMucdichsd" data-bind="value : fiMucdichsd" maxlength="500"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm kiểm dịch <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDiadiemdk" name="fiDiadiemdk" data-bind="value : fiDiadiemdk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Thời gian kiểm dịch <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control  date-picker" id="fiThoigiandk" name="fiThoigiandk" data-bind="datepicker : fiThoigiandk" maxlength="10"  data-date-format="dd/mm/yyyy"></input>                                        
                    <input  data-bind="value : fiThoigiandk" maxlength="10" style="height: 0;width: 0;padding: 0;margin: 0;border: none;"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm/Thời gian giám sát (nếu có)</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiDdTgGs" name="fiDdTgGs" data-bind="value : fiDdTgGs" maxlength="250"></input>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số bản giấy chứng nhận kiểm dịch cần cấp</label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiSobangcn" name="fiSobangcn" data-bind="value : fiSobangcn" maxlength="250"></input>
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
                    <label>Nơi ký <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiNoiky" name="fiNoiky" data-bind="value : fiNoiky" maxlength="250"></input>
                </div>
                <div class="col-md-2">
                    <label>Ngày ký <a class="nsw-require-field">*</a> </label>
                </div>

                <div class="col-md-4">
                    <input  class="form-control date-picker" id="fiNgayky" name="fiNgayky" data-bind="datepicker : fiNgayky" type="text" data-date-format="dd/mm/yyyy" maxlength="10"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Người ký <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiNguoiky" name="fiNguoiky" data-bind="value : fiNguoiky" maxlength="250"></input>
                </div>
            </div>  
        </div> 
    </fieldset>
</form>