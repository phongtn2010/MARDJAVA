<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<b style="border-bottom: 1px solid #0b4d3f">Thông tin chung</b>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Tên cơ quan kiểm tra</label>
            </div>
            <div class="col-md-4">                
                <label><b data-bind="text: fiTenTckt"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label>Số thông báo</label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiSoChungnhan"></b></label>
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Người ký</label>
            </div>
            <div class="col-md-4">                
                <label><b data-bind="text: fiNguoiKy"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label>Ngày ký</label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiNgayKyText"></b></label>
            </div> 
        </div>  
    </div>
    <b style="border-bottom: 1px solid #0b4d3f"><spring:message code="moh.09.chuhang" /></b>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.tenchuhang" /></label>
            </div>  
            <div class="col-md-10">
                <label><b data-bind="text: fiTenCh"></b></label>
            </div>            
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.diachi" /></label>
            </div>
            <div class="col-md-4">                
                <label><b data-bind="text: fiDiachiCh"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.sodienthoai" /></label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiSdtCh"></b></label>
            </div> 
        </div>  
    </div>            
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.fax" /></label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiFaxCh"></b></label>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.chuhang.email" /> </label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiEmailCh"></b></label>
            </div>
        </div>  
    </div>  
    <b style="border-bottom: 1px solid #0b4d3f"><spring:message code="moh.09.thuongnhanchatluong" /></b>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.stt" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.ten" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.diachi" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.sodienthoai" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.fax" /></th>
                        <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.email" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstNguoiChiuTrachNhiems">
                    <tr>
                        <td data-bind="text : fiStt"></td> 
                        <td data-bind="text : fiTenNgTn"></td>
                        <td data-bind="text : fiDiachiNgTn"></td>  
                        <td data-bind="text : fiSdtNgTn"></td>  
                        <td data-bind="text : fiFaxNgTn"></td>  
                        <td data-bind="text : fiEmailNgTn"></td>  
                    </tr>
                </tbody>
            </table> 
            <br />         
        </div>
    </div>   
    <b style="border-bottom: 1px solid #0b4d3f"><spring:message code="moh.09.thuongnhanxuatkhau" /></b>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.ten" /></label>
            </div>  
            <div class="col-md-4">
                <label><b data-bind="text: fiTenNgXk"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.sodienthoai" /></label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiSdtNgXk"></b></label>
            </div> 
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.diachi" /></label>
            </div>
            <div class="col-md-10">                
                <label><b data-bind="text: fiDiachiNgXk"></b></label>
            </div> 
        </div>  
    </div>            
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.fax" /></label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiFaxNgXk"></b></label>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thuongnhanxuatkhau.email" /> </label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiEmailNgXk"></b></label>
            </div>
        </div>  
    </div>  
    <b style="border-bottom: 1px solid #0b4d3f"><spring:message code="moh.09.thongtinnhapkhau" /></b>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.sotokhai" /> </label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiSoTkhq"></b></label>
            </div>
        </div>  
    </div>         
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.cuakhaudi" /></label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiTenCkDi"></b></label>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.cuakhauden" /> </label>
            </div>
            <div class="col-md-4">
                <label><b data-bind="text: fiMaCkDen"></b></label>
            </div>
        </div>  
    </div>
    
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Thời gian kiểm tra</label>
            </div>
            <div class="col-md-4">                
                <label><b data-bind="text: fiNgayNkTuText"></b></label> - <label><b data-bind="text: fifiNgayNkDenText"></b></label>
            </div> 
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.09.thongtinnhapkhau.diadiemkiemtra" /></label>
            </div>
            <div class="col-md-10">
                <label><b data-bind="text: fiDiadiemKt"></b></label>
            </div> 
        </div>  
    </div>
    <b style="border-bottom: 1px solid #0b4d3f"><spring:message code="moh.09.chitietlohang" /></b> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.stt" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.tenmathang" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.nhomsanpham" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.tennhasanxuat" /></th>
                        <th class="text-center"><spring:message code="moh.09.chitietlohang.phuongthuckiemtra" /></th>
                        <th class="text-center">Xác nhận đạt/không đạt yêu cầu</th>
                        <th class="text-center">Lý do không đạt</th>
                        <th class="text-center">Các biện pháp xử lý mặt hàng không đạt yêu cầu</th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHangHoas">
                    <tr>
                        <td data-bind="text : fiStt"></td>  
                        <td data-bind="text : fiTenHh"></td>  
                        <td data-bind="text : fiTenNhomHh"></td> 
                        <td>
                            <span data-bind="text : fiTenNsx"></span>
                            <span data-bind="text : fiDiachiNsx"></span>
                        </td> 
                        <td data-bind="text : fiTenPtkt"></td>
                        <td data-bind="text : resultLable"></td>
                        <td data-bind="text : fiLydoKodat"></td>  
                        <td data-bind="text : fiTenBpXl"></td>  
                    </tr>
                </tbody>
            </table> 
            <br />         
        </div>
    </div>
    <b style="border-bottom: 1px solid #0b4d3f">File đính kèm</b> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <tbody>
                    <tr>
                        <td style="width: 30%">File thông báo kêt quả</td>  
                        <td style="width: 20%">
                            <a data-bind="attr: {href: downloadUrl}, text: fiTenTep" target="_blank">Xem</a>
                        </td>  
                        <td style="width: 30%">Link download file</td>  
                        <td style="width: 20%">
                            <a data-bind="attr: {href: fiDuongDan}, text: fiDuongDan" target="_blank"></a>
                        </td>  
                    </tr>
                </tbody>
            </table>
        </div>
    </div>