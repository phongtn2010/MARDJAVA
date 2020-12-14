<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
    .word-bg {
        background: rgb(204,204,204); 
        padding-top: 10px;
        padding-bottom: 1px;
    }
    page {
        background: white;
        display: block;
        margin: 0 auto;
        margin-bottom: 0.5cm;
        box-shadow: 0 0 0.5cm rgba(0,0,0,0.5);
    }
    page[size="A4"] {  
        width: 21cm;
        min-height: 29.7cm; 
        height: auto;
        font-family: "Time";
        font-size: 11pt !important;
    }
    @media print {
        body, page {
            margin: 0;
            box-shadow: 0;
        }
    }
    
    .a4-padding{
        padding: 1.5cm 1.5cm 1.5cm 1.5cm;
        box-sizing: border-box;
    }
    .t-center{
        text-align: center;
    }
    .t-bold{
        font-weight: bold;
    }
    .t-normal{
        font-weight: normal;
    }
    .t-italic{
        font-style: italic;
    }
    .left{
        float: left;
    }
    .right{
        float: right;
    }
    .w35p{
        width: 35%;
        max-width: 35%;
        min-width: 35%;
    }
    .w40p{
        width: 40%;
        max-width: 40%;
        min-width: 40%;
    }
    .w60p{
        width: 60%;
        max-width: 60%;
        min-width: 60%;
    }
    .w50p{
        width: 50%;
        max-width: 50%;
        min-width: 50%;
    }
    .w100p{
        width: 100%;
        max-width: 100%;
        min-width: 100%;
    }
    
    .tb-none-border{
        border: none !important;
    }
    .tb-none-border td, tr{
        border: none !important;
    }
    p.title{
        width: 100%;
        font-weight: bold;
        text-transform: uppercase;
        text-align: center;
        padding-top: 1.2cm;
    }
    p.code{
        font-size: 90%;
        font-style: italic;
        width: 100%;
        text-align: center;
    }
    p.content{
        width: 100%;
    }
    .tb-content {
        border-collapse: collapse;
        border: 1px solid black;
    }

    .tb-content th, td {
        border: 1px solid black;
        padding: 5px;
    }
    .tb-content th{
        text-align: center;
        font-weight: bold;
    }
    .pb-long{
        padding-bottom: 100px;
    }
    .pt-10{
        padding-top: 10px;
    }

</style>
    <fieldset>
        <legend><b>Thông tin chung</b> </legend>
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
    </fieldset>
    <fieldset>
        <legend><b><spring:message code="moh.09.chuhang" /></b> </legend>
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
    </fieldset>
    <fieldset>
        <legend><b><spring:message code="moh.09.thuongnhanchatluong" /></b> </legend>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.ten" /></th>
                            <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.diachi" /></th>
                            <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.sodienthoai" /></th>
                            <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.fax" /></th>
                            <th class="text-center"><spring:message code="moh.09.thuongnhanchatluong.email" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="foreach: lstNguoiChiuTrachNhiems">
                        <tr>                            
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
    </fieldset>
    <fieldset>
        <legend><b><spring:message code="moh.09.thuongnhanxuatkhau" /></b> </legend>
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
    </fieldset>
    <fieldset>
        <legend><b><spring:message code="moh.09.thongtinnhapkhau" /></b> </legend>
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
                    <label><b data-bind="text: fiTenCkDen"></b></label>
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
                <div class="col-md-4">
                    <label><b data-bind="text: fiDiadiemKt"></b></label>
                </div> 
            </div>  
        </div>
    </fieldset>
    <div class="form-group">
        <div class="col-md-12">
        <fieldset>
            <legend><b><spring:message code="moh.09.chitietlohang" /></b> </legend>
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
            </fieldset>
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
                            <a data-bind="attr: {href: fiDuongDan}" target="_blank">Xem</a>
                        </td>  
                        <td style="width: 30%">Link download file</td>  
                        <td style="width: 20%">
                            <a data-bind="attr: {href: fiDuongDan}" target="_blank">Tải về</a>
                        </td>  
                    </tr>
                </tbody>
            </table>
        </div>
    </div>