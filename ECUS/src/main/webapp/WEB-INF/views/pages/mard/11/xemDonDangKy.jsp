<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form role="form" class="form-horizontal" id="mard10Form">
    <fieldset>
        <legend>Thông tin hồ sơ</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mã hồ sơ</label>
                </div>
                <div class="col-md-4">
                    <span class="" id="fiMaHoso" name="fiMaHoso"  
                           type="text" data-bind="text : fiMaHoso" />
                </div>
                <div class="col-md-2">
                    <label>Trạng thái hồ sơ</label>
                </div>
                <div class="col-md-4">
                    <span class="" id="fiTrangthaiText" name="fiTrangthaiText" data-bind="text : fiTrangthaiText" type="text"  />
                    <span class="" id="fiTrangthai" name="fiTrangthai" data-bind="text : fiTrangthai" type="text"  style="display:none;" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Ngày tạo</label>
                </div>
                <div class="col-md-4">
                    <span class=" " id="fiNgaytao" name="fiNgaytao"  data-bind="date : fiNgaytao" type="text"   />
                </div>
                <div class="col-md-2">
                    <label>Đơn vị kiểm dịch </label>
                </div>
                <div class="col-md-4">                                        
                    <span class="" id="fiMadvXl" name="fiMadvXl" data-bind="text : fiTendvXl"></span>
                </div>
            </div>  
        </div> 
    </fieldset>
    <fieldset>
        <legend>Thông tin doanh nghiệp</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tên tổ chức, cá nhân  </label>
                </div>
                <div class="col-md-10">
                    <span class="" id="fiDtDangky" name="fiDtDangky" data-bind="text : fiDtDangky" type="text" required />
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ  </label>                    
                </div>
                <div class="col-md-10">
                    <span class=" -inline" id="fiDiachi" name="fiDiachi" data-bind="text : fiDiachi" type="text" />
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Email/Fax </label>
                </div>
                <div class="col-md-4">
                    <span class="" id="fiEmail" name="fiEmail" data-bind="text : fiEmail" type="text" />
                </div>
                <div class="col-md-2">
                    Điện thoại
                </div>
                <div class="col-md-4">
                    <span class=" -inline" id="fiSodt" name="fiSodt" data-bind="text : fiSodt" type="text" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số CMND </label>
                </div>
                <div class="col-md-4">
                    <span class="" id="fiSocmnd" name="fiEmailCty" data-bind="text : fiSocmnd" type="text" />
                </div>

                <div class="col-md-2">
                    Ngày cấp CMND
                </div>
                <div class="col-md-4">
                    <span class=" " id="fiNgaycmnd" name="fiNgaycmnd" data-bind="date : fiNgaycmnd" type="text"   />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nơi cấp CMND </label>
                </div>
                <div class="col-md-4">
                    <span class="" id="fiNoicmnd" name="fiNoicmnd" data-bind="text : fiNoicmnd" type="text" />
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
                        </tr>                      
                    </script>
                </table>
            </div>
        </div>
    </fieldset>
    
    <fieldset>
        <legend>Thông tin xuất khẩu</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổ chức cá nhân xuất khẩu  </label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiDtXk" name="fiDtXk" data-bind="text : fiDtXk" ></span>
                </div>
            </div>  
        </div> 
        
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ </label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiDiachidtxk" name="fiTenDtxk" data-bind="text : fiDiachidtxk" ></span>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Cửa khẩu xuất  </label>
                </div>
                <div class="col-md-4">                                        
                    <span class="" id="fiMackXk" name="fiMackXk" data-bind="text : fiTenckXk"></span>
                </div>
                
                <div class="col-md-2">
                    <label>Phương tiện chuyên chở </label>
                </div>
                <div class="col-md-4">                                        
                    <span class="" id="fiPtvt" name="fiPtCc" data-bind="text : fiPtCc" ></span>
                </div>
            </div>  
        </div> 
    </fieldset>
    
    <fieldset>
        <legend>Thông tin nhập khẩu</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổ chức cá nhân nhập khẩu  </label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiDtNk" name="fiDtNk" data-bind="text : fiDtNk"></span>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ  </label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiDiachidtnk" name="fiTenDtnk" data-bind="text : fiDiachidtnk" ></span>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nước nhập khẩu  </label>
                </div>
                <div class="col-md-4">                              
                    <span class="" id="fiMaqgNk" name="fiMaqgNk" data-bind="text : fiTenqgNk"></span>
                </div>
                <div class="col-md-2">
                    <label>Cửa khẩu nhập  </label>
                </div>
                <div class="col-md-4">                                                
                    <span class="" id="fiMackNk" name="fiMackNk" data-bind="text : fiTenckNk"></span>  
                </div>
            </div>  
        </div> 
    </fieldset>
    
    <fieldset>
        <legend>Thông tin khác</legend>

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mục địch sử dụng  </label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiMucdichsd" name="fiMucdichsd" data-bind="text : fiMucdichsd" ></span>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm kiểm dịch  </label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiDiadiemdk" name="fiDiadiemdk" data-bind="text : fiDiadiemdk" ></span>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Thời gian kiểm dịch  </label>
                </div>
                <div class="col-md-10">                                        
                    <span class="  " id="fiThoigiandk" name="fiThoigiandk" data-bind="date : fiThoigiandk"   ></span>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm/Thời gian giám sát (nếu có)</label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiDdTgGs" name="fiDdTgGs" data-bind="text : fiDdTgGs" ></span>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số bản giấy chứng nhận kiểm dịch cần cấp</label>
                </div>
                <div class="col-md-10">                                        
                    <span class="" id="fiSobangcn" name="fiSobangcn" data-bind="text : fiSobangcn" ></span>
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
                    <label>Nơi ký  </label>
                </div>
                <div class="col-md-4">                                        
                    <span class="" id="fiNoiky" name="fiNoiky" data-bind="text : fiNoiky" ></span>
                </div>
                <div class="col-md-2">
                    <label>Ngày ký  </label>
                </div>

                <div class="col-md-4">
                    <span  class=" " id="fiNgayky" name="fiNgayky" data-bind="date : fiNgayky" type="text" >
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Người ký  </label>
                </div>
                <div class="col-md-4">                                        
                    <span class="" id="fiNguoiky" name="fiNguoiky" data-bind="text : fiNguoiky" ></span>
                </div>
            </div>  
        </div> 
    </fieldset>
</form>