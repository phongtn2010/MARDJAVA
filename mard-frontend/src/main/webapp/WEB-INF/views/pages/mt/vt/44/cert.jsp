<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table class="tb-none-border w100p">
        <tr>
            <td class="w35p">
                <div class="left t-center t-bold">
                    <p>BỘ GIAO THÔNG VẬN TẢI</p>
                    <span class="content t-bold" style="white-space: nowrap">TỔNG CỤC ĐƯỜNG BỘ VIỆT NAM</span>
                </div>
            </td>
            <td style="vertical-align: text-top;">
                <div class="right t-center t-bold">
                    CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                    <br/>
                    Độc lập - Tự do - Hạnh phúc
                </div>
            </td>
        </tr>
        <tr>
            <td class="w35p">
                <div class="left t-center" style="white-space: nowrap">
                    <p class="content">Số <b class="content" data-bind="text: fiSoVb"></b>/TCĐBVN-VT</p>
                </div>
            </td>
            <td style="vertical-align: text-top;">
                <div class="right t-center">
                    <b data-bind="text : fiDiaDiem"></b>, <b data-bind="vnDateText: fiNgayky"></b>
                </div>
            </td>
        </tr>
    </table>
    <p class="title">
        CHẤP THUẬN KHAI THÁC TUYẾN VẬN TẢI HÀNH KHÁCH ĐỊNH KỲ VIỆT - TRUNG
    </p>
    <p class="code">
        Tuyến: <b data-bind="text : fiTuyenDi"></b> đi <b data-bind="text : fiTuyenDen"></b> và ngược lại
    </p>    
    <p class="code">
        Giữa: Bến xe <b data-bind="text : fiBenDi"></b> và Bến xe <b data-bind="text : fiBenDen"></b>
    </p>
    <p class="code">
        Kính gửi: <b data-bind="text : fiTenDn"></b>
    </p>
    <p class="content">
        Tổng cục ĐBVN (Sở Giao thông vận tải <b data-bind="text : fiSoGtvtVn"></b>) nhận được công văn số <b data-bind="text : fiSoCvanDn"></b> ngày <b data-bind="text : fiNgayCvDn"></b> của <b data-bind="text : fiTenDn"></b> về việc đăng ký khai thác vận tải hành khách định kỳ giữa Việt Nam và Trung Quốc;
    </p>
    <p class="content">	
        Thực hiện Điều <b data-bind="text : fiDieuSo"></b> Thông tư số <b data-bind="text : fiSoThongtu"></b>/2012/TT-BGTVT ngày <b data-bind="text : fiNgThongtu"></b> của Bộ GTVT hướng dẫn thực hiện Hiệp định, Nghị định thư và Thỏa thuận về tổ chức, quản lý hoạt động vận tải đường bộ giữa hai nước Việt - Trung.
    </p>
    <p class="content">	
        Tổng cục ĐBVN (Sở Giao thông vận tải <b data-bind="text : fiSoGtvtVn"></b>) thông báo như sau:
    </p>
    <p class="content">
        Chấp thuận cho phép doanh nghiệp <b data-bind="text : fiTenDn"></b> được khai thác tuyến vận tải hành khách định kỳ Việt - Trung. 
    </p>
    <p class="content">
        Tên tuyến: <b data-bind="text : fiTuyenDi"></b> đi <b data-bind="text : fiTuyenDen"></b> và ngược lại.
    </p>
    <p class="content">
        Bến đi: Bến xe <b data-bind="text : fiBenDi"></b> - <b data-bind="text : fiTenTinhDi"></b>
    </p>
    <p class="content">
        Bến đến: Bến xe <b data-bind="text : fiBenDen"></b> - <b data-bind="text : fiTenTinhDen"></b>
    </p>
    <p class="content">
        Số xe tham gia khai thác: <b data-bind="text : fiSoxeTgVt"></b>
    </p>
    <p class="content">
        Thời hạn tham gia khai thác: 05 (năm) năm kể từ ngày ký văn bản chấp thuận.
    </p>
    <p class="content">
        Trong thời gian 60 ngày, kể từ ngày ký văn bản này, <b data-bind="text : fiTenDn"></b> phải đưa phương tiện vào triển khai thực hiện, quá thời hạn nêu trên giấy chấp thuận không còn hiệu lực.
    </p>
    <p class="content pt-10">
        Tổng cục ĐBVN (Sở Giao thông vận tải <b data-bind="text : fiSoGtvtVn"></b>) trân trọng đề nghị Vụ Vận tải đường bộ - Bộ GTVT Trung Quốc và Ty Giao thông vận tải <b data-bind="text : fiSoGtvtTq"></b> bố trí cho phương tiện theo danh sách nêu trên của <b data-bind="text : fiTenDn"></b> được hoạt động tại Bến xe <b data-bind="text : fiBenXe"></b>.	
    </p>
    <p class="content">
        Tổng cục ĐBVN (Sở Giao thông vận tải <b data-bind="text : fiSoGtvtVn"></b>) yêu cầu <b data-bind="text : fiTenDn"></b> ký hợp đồng khai thác với bến xe cho xe đã được Tổng cục ĐBVN (Sở Giao thông vận tải) chấp thuận ở trên và tổ chức hoạt động vận tải khách trên tuyến theo đúng các quy định hiện hành./.
    </p>
    <table class="tb-content tb-none-border w100p">
        <tr>
            <td class="left w50p">
                <span><b>Nơi nhận:</b></span><br/>
                <span>- Như trên;</span><br/>
                <span>- Sở GTVT liên quan;</span><br/>
                <span>- Bến xe hai đầu tuyến;</span><br/>
                <span>- Lưu: </span><br/>
            </td>
            <td class="t-center pb-long">
                <span class="t-bold">Thủ trưởng đơn vị</span><br/>
                (Ký tên, đóng dấu)<br/>                
            </td>
        </tr>
    </table>
    <p class="content" style="padding: 5px">
        Link công văn
    </p>
    <table class="tb-content tb-none-border w100p">
        <tbody data-bind="foreach: lstDinhKem">
            <tr>
                <td class="left">
                    <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiUrl}"></a>
                </td>            
            </tr>
        </tbody>
    </table>
</page>