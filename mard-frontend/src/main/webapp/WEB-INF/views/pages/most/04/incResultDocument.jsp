<%-- 
    Document   : incResultDocument
    Created on : Sep 15, 2017, 9:12:07 AM
    Author     : QUANGNV18
--%>
<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table class="tb-none-border w100p">
        <tr>
            <td>
                <div class="t-center">
                    GIẤY CHỨNG NHẬN LƯU HÀNH TỰ DO<br/>
                    <b>CERTIFICATE OF FREE SALE</b> <br/>
                    <span>Số/Ref.No: </span><span data-bind="text : fiSoGp"></span>
                </div>
            </td>
        </tr>
    </table>    
    <p class="content">
        Kính gửi các bên liên quan, 
    </p>
    <p class="content">
        <i>To Whom It May Concern,</i>
    </p>
    <p class="content">
        Chứng nhận sản phẩm được liệt kê trong danh mục dưới đây:/<i>This is to certify that the product listed below is:</i>
    </p>
    <p class="content">
        - Được sản xuất bởi/manufactured by: <b data-bind="text: fiTenDn"></b> 
    </p>
    <p class="content">
        - Tại địa chỉ/ at address: <b data-bind="text: fiDiachiDn"></b>   
    </p>
    <p class="content">
        - Điện thoại/tel: <b data-bind="text: fiDtDn"></b>                      Fax: <b data-bind="text: fiFaxDn"></b>     
    </p>
    <p class="content">
        Danh mục sản phẩm bao gồm/<i>List of the products includes:</i>
    </p>
    <table class="tb-content w100p">
        <thead>
            <tr>
                <th>TT/No</th>
                <th>Tên sản phẩm/Name of product</th>
                <th>Loại, nhóm/Category</th>
            </tr>
        </thead>
        <tbody data-bind="template: { name: 'lstHanghoaTmpl', foreach: hangHoas }">
        </tbody>
        <script id="lstHanghoaTmpl" type="text/html">
            <tr>
                <td data-bind="text : $index()+1 "></td>
                <td data-bind="text : fiTenHh"></td>
                <td data-bind="text : fiTenNhomHh"></td>
            </tr>
        </script>		
    </table>
    <p class="content">
        Giấy chứng nhận này có giá trị đến ngày/<i>This certification is valid until:</i> <b data-bind="text: fiNgayHetHanText"></b>
    </p>
    <table class="tb-content w100p tb-none-border">
        <tr>
            <td class="t-center w50p t-italic"></td>
            <td class="t-center w50p t-italic"></td>
        </tr>
        <tr>
            <td class="t-center  w50p pb-long">
                
            </td>
            <td class="t-center pb-long">
                <span class="t-bold">TỔNG CỤC TRƯỞNG</span><br/>                
                DIRECTOR GENERAL<br/>
                <span data-bind="text : fiNguoiKy"></span>
            </td>
        </tr>
    </table>
</page>
