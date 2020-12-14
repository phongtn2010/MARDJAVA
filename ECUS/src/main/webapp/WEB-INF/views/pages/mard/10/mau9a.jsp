<%-- 
    Document   : mau9
    Created on : Aug 7, 2017, 4:02:03 PM
    Author     : hieptran
--%>

<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">

    <table class="tb-none-border w100p">
        <tr>
            <td class="w40p">
                <div class="left t-center t-bold">
                    <p class="content t-bold">CỤC THÚ Y</p>
                    <span data-bind="text : fiTenCqkddv"></span>
                    <p class="t-normal">-------</p>
                    <p class="code t-normal" data-bind="text : fiSocvDi"></p>
                </div>
            </td>
            <td>
                <div class="right t-center t-bold">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    <br/>
                    Độc lập - Tự do - Hạnh phúc<br/>
                    <p class="t-normal">---------------</p>
                    <p class="code t-normal">
                        ..............., ngày <span data-bind="dateDate : fiNgayBb"></span> tháng <span data-bind="dateMonth: fiNgayBb"></span> năm <span data-bind="dateYear: fiNgayBb"></span>
                    </p>
                </div>
            </td>
        </tr>
    </table>
    <p class="title">
        QUYẾT ĐỊNH<br/>
        Xử lý vệ sinh thú y đối với động vật/sản phẩm động vật <br/>không bảo đảm yêu cầu vệ sinh thú y<br/>
        <span data-bind="text:fiTenCqkddv"></span>
    </p>
    <p class="content">
        Căn cứ Luật Thú y số 79/2015/QH13 ngày 19 tháng 6 năm 2015;
    </p>
    <p class="content">
        Căn cứ Quyết định số <span data-bind="text :fiCancuQd"></span> ngày <span data-bind="dateDate : fiNgayQd"></span> tháng <span data-bind="dateMonth: fiNgayQd"></span> năm <span data-bind="dateYear: fiNgayQd"></span>  của <span data-bind="text: fiDonviQd"></span> quy định chức năng, nhiệm vụ, quyền hạn, cơ cấu tổ chức của <span data-bind="text:fiDonviBb"></span>;
    </p>
    <p class="content">
        Căn cứ Biên bản ghi nhận tình trạng vệ sinh thú y hàng động vật, sản phẩm động vật số <span data-bind="text:foSoBb"></span> ngày <span data-bind="text : fiNgayBb"></span> của <span data-bind="text : fiDonviBb"></span>
    </p>	
    <p class="content t-bold t-center">
        QUYẾT ĐỊNH:
    <p class="content">
        <span class="t-bold">Điều 1.</span> Quyết định xử lý vệ sinh thú y đối với số hàng sau:
    </p>
    <p class="content" data-bind="template: { name: 'lstHanghoa9aTmpl', foreach: lstHanghoa9a }">
    </p>
    <script id="lstHanghoa9aTmpl" type="text/html">
        <span data-bind="text:fiStt"></span>/ &nbsp;&nbsp;&nbsp;<span data-bind="text:fiTenhang"></span>&nbsp;&nbsp;&nbsp;Số lượng: <span data-bind="text: fiSoluong"></span> &nbsp;&nbsp;&nbsp;Khối lượng: <span data-bind="text: fiKhoiluong"></span>
        <br/>
    </script>
    	
    <p class="content">	
        Của ông bà: <span data-bind="text:fiTenCh"></span> là chủ hàng (hoặc người đại diện)
    </p>
    <p class="content">
        Địa chỉ giao dịch: <span data-bind="text:fiDiachiCh"></span>
    <p class="content">
        Điện thoại: <span data-bind="text: fiDienthoaiCh"></span> Fax: <span data-bind="text: fiFaxCh"></span> Email: <span data-bind="text: fiEmailCh"></span> 
    </p>	
    <p class="content">
        Chứng minh nhân dân số: <span data-bind="text: fiCmndCh"></span> Cấp ngày: <span data-bind="date : fiNgaycapCmnd"></span>.Nơi cấp: <span data-bind="text : fiNoicapCmnd"></span>
    </p>
    <p class="content">	
        Số hàng trên đây không bảo đảm yêu cầu vệ sinh thú y theo quy định như sau:
    </p>
    <p class="content">
        Các vật dụng (phương tiện, dụng cụ, bao bì chứa đựng, thức ăn, chất độn, chất thải) có liên quan:
    </p>
    <p class="content">
        <span class="t-bold">Điều 2.</span> Biện pháp xử lý đối với số hàng trên và các vật dụng có liên quan: <span data-bind="text: fiDieu2"></span>	
    </p>
    <p class="content">
        <span class="t-bold">Điều 3.</span> Địa điểm tiến hành xử lý vệ sinh thú y: <span data-bind="text: fiDieu3"></span>	
    </p>
    <p class="content">
        <span class="t-bold">Điều 4.</span> Tên, địa chỉ tổ chức, cá nhân thực hiện xử lý hàng: <span data-bind="text: fiDieu4"></span>	
    </p>
    <p class="content">
        <span class="t-bold">Điều 5.</span> Thời gian tiến hành xử lý vệ sinh thú y đối với lô hàng: <span data-bind="text: fiDieu5"></span>	
    </p>
    <p class="content">
        <span class="t-bold">Điều 6.</span> Nơi xử lý hàng phải được vệ sinh, khử trùng tiêu độc theo quy định.
    </p>
    <p class="content">
        <span class="t-bold">Điều 7.</span> Quy định về việc sử dụng hàng sau khi đã xử lý vệ sinh thú y:  <span data-bind="text: fiDieu7"></span>	
    </p>
    <p class="content">	
        Quyết định này lập thành 03 bản: 01 bản do cơ quan kiểm dịch động vật giữ, 01 bản do chủ hàng hoặc người đại diện giữ, 01 bản do tổ chức, cá nhân thực hiện xử lý hàng giữ.
    </p>
    
    <table class="tb-none-border w100p">
        <tr>
            <td class="t-center  w50p pb-long">
                <span class="t-bold">Nơi nhận</span><br/>
                <span data-bind="text : fiNoinhan"></span>
            </td>
            <td class="t-center pb-long">
                <span class="t-bold">THỦ TRƯỞNG CƠ QUAN</span><br/>
                (Ký, đóng dấu, ghi rõ họ tên)<br/>
                <span class="t-bold" data-bind="text : fiNguoiky"></span>
            </td>
        </tr>
    </table>
</page>
