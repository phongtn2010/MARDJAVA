<%-- 
    Document   : incResultDocument
    Created on : Sep 15, 2017, 9:12:07 AM
    Author     : QUANGNV18
--%>
<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table class="tb-none-border w100p">
        <tr>
            <td class="w50pc">
                <div class="left t-center">
                    BỘ KHOA HỌC VÀ CÔNG NGHỆ<br/>
                    <b>TỔNG CỤC TIÊU CHUẨN</b> <br/> <b>ĐO LƯỜNG CHẤT LƯỢNG</b>
                    <br/><span>Số: </span><span data-bind="text : fiSoQd"></span>
                </div>
            </td>
            <td>
                <div class="right t-center">
                    <b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b>
                    <br/>
                    <b>Độc lập - Tự do - Hạnh phúc</b>
                    <br/>
                    <br/><i>Hà Nội, ngày 10 tháng 02 năm 2017</i>
                    <br/>
                </div>
            </td>
        </tr>
    </table>
    <p class="title">
        QUYẾT ĐỊNH
        <br/>
        <b style="text-transform: lowercase">Về việc phê duyệt mẫu phương tiện đo</b>
    </p>
    <p class="title">
        TỔNG CỤC TRƯỞNG 
        <br/>
        TỔNG CỤC TIÊU CHUẨN ĐO LƯỜNG CHẤT LƯỢNG
    </p>
    <p class="content">
        Căn cứ luật đo lường ngày 11 tháng 11 năm 2011;
    </p>
    <p class="content">
        Căn cứ Quyết định số 27/2014/QĐ-TTg ngày 04/4/2014 của Thủ tướng Chính phủ quy định chức năng, nhiệm vụ, quyền hạn và cơ cấu tổ chức của Tổng cục Tiêu chuẩn Đo lường Chất lượng;
    </p>
    <p class="content">
        Căn cứ Thông tư số 23/2013/TT-BKHCN ngày 26/9/2013 của Bộ trường Bộ Khoa học và Công nghệ quy định về đo lường đối với phương tiện đo nhóm 2;
    </p>
    <p class="content">
        Xét đề nghị của Vụ trường Vụ Đo lường;
    </p>
    <p class="title">
        QUYẾT ĐỊNH
    </p>
    <p class="content">
        <b>Điều 1.</b> Phê duyệt <b data-bind="text: fiSoLuongMau"></b> mẫu phương tiện đo gồm: <b data-bind="text: fiThongTinHangHoa"></b>, do công ty <b data-bind="text: fiThongTinCongTy"></b> nhập khẩu có đặc tính kỹ thuật đo lường chính được ghi trong Phụ lục kèm theo Quyết định này.
    </p>
    <p class="content">
        <b>Điều 2.</b> Phương tiện đo nhập khẩu phù hợp với mẫu đã được phê duyệt phải mang ký hiệu phê duyệt mẫu như sau(Xem ở phụ lục đính kèm):
    </p>
    <table class="tb-content w100p">
        <thead>
            <tr>
                <th>TT</th>
                <th>Kiểu</th>
                <!--<th>Số sản xuất</th>-->
                <th>Ký hiệu phê duyệt mẫu</th>
            </tr>
        </thead>
        <tbody data-bind="template: { name: 'lstHanghoaTmpl', foreach: lstHanghoa }">
        </tbody>
        <script id="lstHanghoaTmpl" type="text/html">
            <tr>
                <td data-bind="text : fiTenHh"></td>
                <td data-bind="text : fiKieu"></td>
                <!--<td data-bind="text : fiSoSx"></td>-->
                <td data-bind="text : fiKyhieu"></td>
            </tr>
        </script>		
    </table>
    <p class="content">
        <b>Điều 3.</b> <b data-bind="text: fiTenCongTy"></b> chịu trách nhiệm:
    </p>
    <p class="content">
        1.Thực hiện các biện pháp ngăn ngừa, phòng chống tác động làm thay đổi đặc tính kỹ thuật đo lường chính của phương tiện trong quá trình sử dụng.
    </p>
    <p class="content">
        2.Thực hiệc việc kiểm định ban đầu đối với các phượng tiện đo theo quy định
    </p>
    <p class="content">
        <b>Điều 4.</b> Quyết định này có hiệu lực đến ngày <b data-bind="text: fiNgayHetHanText"></b>
    </p>
    <p class="content">
        <b>Điều 5.</b> Vụ trưởng Vụ Đo lường, <b data-bind="text: fiTenCongTy"></b> chịu trách nhiệm thi hành Quyết định này ./.
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
                (Ký, đóng dấu, ghi rõ họ tên)<br/>
                <span data-bind="text : fiNguoiKyQD"></span>
            </td>
        </tr>
    </table>
</page>
