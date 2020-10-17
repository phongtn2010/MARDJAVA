<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal">
    <fieldset>
        <legend>Thông tin hồ sơ</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mã hồ sơ: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiMaHoso">
                </div>
                <div class="col-md-2">
                    <label>Trạng thái hồ sơ: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiTrangthaiText">
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Ngày tạo: </label>
                </div>
                <div class="col-md-4" data-bind="date : fiNgaytao">
                </div>
                <div class="col-md-2">
                    <label>Đơn vị kiểm dịch: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiTenDvkd">  
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Đơn khai báo số: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiDonkb">
                </div>
                <div class="col-md-2">
                    <label>Đơn vị kiểm dịch: </label>
                </div>
                <div class="col-md-4" data-bind="text :fiTenDvgs"> 
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số vận đơn: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiSoVandon">
                </div>
                <div class="col-md-2">
                    <label>Số tờ khai: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiSoTk">
                </div>
            </div>  
        </div>  
    </fieldset>
    <fieldset>
        <legend>Thông tin doanh nghiệp</legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tên tổ chức, cá nhân: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiTenCty">
                </div>

                <div class="col-md-2">
                    Điện thoại
                </div>
                <div class="col-md-4" data-bind="text : fiSdtCty">
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa chỉ: </label>                    
                </div>
                <div class="col-md-10" data-bind="text : fiDiachiCty">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Email: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiEmailCty">
                </div>

                <div class="col-md-2">
                    Fax
                </div>
                <div class="col-md-4" data-bind="text : fiFaxCty">
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
                        </tr>                      
                    </script>
                </table>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổ chức cá nhân xuất khẩu: </label>
                </div>
                <div class="col-md-10" data-bind="text : fiTenDtxk">      
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nước xuất khẩu: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiTenQgxk">    
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Cửa khẩu xuất: </label>
                </div>
                <div class="col-md-4" data-bind="text :fiTenCkxk">    
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Tổ chức cá nhân nhập khẩu: </label>
                </div>
                <div class="col-md-10" data-bind="text : fiTenDtnk">   
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Nước nhập khẩu: </label>
                </div>
                <div class="col-md-10" data-bind="text : fiTenQgnk">  
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Phương tiện vận chuyển: </label>
                </div>
                <div class="col-md-10" data-bind="text :fiPtvt">        
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Cửa khẩu nhập: </label>
                </div>
                <div class="col-md-4" data-bind="text :fiTenCknk">   
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Mục địch sử dụng: </label>
                </div>
                <div class="col-md-10" data-bind="text :fiMucdichSd">   
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Văn bản chấp thuận kiểm dịch của Cục Thú y (nếu có): </label>
                </div>
                <div class="col-md-10" data-bind="text : fiVbCtkd"> 
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm kiểm dịch: </label>
                </div>
                <div class="col-md-10" data-bind="text : fiDdkd">  
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Thời gian kiểm dịch: </label>
                </div>
                <div class="col-md-10" data-bind="text : fiTgkd">  
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Địa điểm giám sát (nếu có): </label>
                </div>
                <div class="col-md-10" data-bind="text : fiDdgs">  
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Thời gian giám sát: </label>
                </div>
                <div class="col-md-10" data-bind="text : fiTggs"> 
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Số bản giấy chứng nhận kiểm dịch cần cấp: </label>
                </div>
                <div class="col-md-10" data-bind="text : fiSobanGcn">    
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
                    <label>Nơi ký: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiNoiky">    
                </div>
                <div class="col-md-2">
                    <label>Ngày ký: </label>
                </div>

                <div class="col-md-4" data-bind="date : fiNgayky">
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>Người ký: </label>
                </div>
                <div class="col-md-4" data-bind="text : fiNguoiky"> 
                </div>
            </div>  
        </div> 
    </fieldset>
</form>