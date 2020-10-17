<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table class="tb-none-border w100p">
        <tr>
            <td >
                <div class=" t-center t-bold">
                    <p >BỘ GIAO THÔNG VẬN TẢI</p>
                    <span class="content t-bold" style="white-space: nowrap" >TỔNG CỤC ĐƯỜNG BỘ VIỆT NAM</span>
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
                <div class="left t-center">
                    <p class="content">Số <b class="content" data-bind="text: fiSoVanban"></b>/TCĐBVN-VT</p>
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
        CHẤP THUẬN KHAI THÁC TUYẾN VẬN TẢI HÀNH KHÁCH TUYẾN CỐ ĐỊNH BẰNG XE Ô TÔ GIỮA VIỆT NAM VÀ LÀO
    </p>
    <p class="code">
        Tuyến: <b data-bind="text : fiTuyenDi"></b> đi <b data-bind="text : fiTuyenDen"></b> và ngược lại.
    </p>    
    <p class="code">
        Giữa: Bến xe <b data-bind="text : fiBenDi"></b> và Bến xe <b data-bind="text : fiBenDen"></b>
    </p>
    <p class="content">
        Tổng cục Đường bộ Việt Nam nhận được công văn số <b data-bind="text : fiSoCvanDn"></b>
        <b data-bind="vnDateText: fiNgayCvDn"></b> và hồ sơ kèm theo của doanh nghiệp (hợp tác xã) <b data-bind="text : fiTenDn"></b> về việc đăng ký khai thác tuyến vận tải hành khách tuyến cố định bằng xe ô tô giữa Việt Nam và Lào;
    </p>
    <p class="content">	
        Thực hiện Điều <b data-bind="text : fiDieuSo"></b> Thông tư số <b data-bind="text : fiSoThongtu"></b>/TT-BGTVT 
        <b data-bind="vnDateShort: fiNgThongtu"></b> của Bộ trưởng Bộ Giao thông vận tải hướng dẫn thực hiện một số Điều của Hiệp định và Nghị định thư thực hiện Hiệp định tạo điều kiện thuận lợi cho phương tiện cơ giới đường bộ qua lại biên giới giữa Chính phủ nước CHXHCN Việt Nam và Chính phủ nước CHDCND Lào, Tổng cục ĐBVN thông báo như sau:
    </p>
    <p class="content">
        Chấp thuận cho phép doanh nghiệp (hợp tác xã)<b data-bind="text : fiTenDn"></b> được khai thác tuyến vận tải hành khách tuyến cố định bằng xe ô tô giữa Việt Nam và Lào. 
    </p>
    <p class="content">
        Tên tuyến: <b data-bind="text : fiTuyenDi"></b> đi <b data-bind="text : fiTuyenDen"></b> và ngược lại.
    </p>
    <p class="content">
        Bến đi: Bến xe <b data-bind="text : fiBenDi"></b> - <b data-bind="text : fiTenTinhDi"></b> (tên tỉnh đi).
    </p>
    <p class="content">
        Bến đến: Bến xe <b data-bind="text : fiBenDen"></b> - <b data-bind="text : fiTenTinhDen"></b> (tên tỉnh đến).
    </p>
    <p class="content">
        Hành trình: <b data-bind="text : fiHanhtrinh"></b> cửa khẩu đi/cửa khẩu đến. 
    </p>
    <p class="content">
        Số xe tham gia khai thác: <b data-bind="text : fiSoxeTgVt"></b>
    </p>
    <p class="content">
        Thời hạn tham gia khai thác: Theo thời hạn quy định của Giấy phép vận tải đường bộ quốc tế Việt - Lào.
    </p>
    <p class="content">
        Trong thời gian 60 ngày, kể từ ngày ký văn bản này doanh nghiệp (hợp tác xã) phải đưa phương tiện vào triển khai thực hiện, doanh nghiệp (hợp tác xã) phải ký hợp đồng khai thác với bến xe hai đầu tuyến, báo cáo về Tổng cục Đường bộ Việt Nam và Sở Giao thông vận tải <b data-bind="text : fiSoGtvtVn"></b>. Quá thời hạn nêu trên, văn bản chấp thuận không còn hiệu lực.
    </p>
    <p class="content pt-10">
        Tổng cục Đường bộ Việt Nam trân trọng đề nghị Cục Vận tải Lào và Sở Công chính và Vận tải <b data-bind="text : fiSoCcvtLao"></b> bố trí cho phương tiện theo danh sách nêu trên của doanh nghiệp (hợp tác xã) <b data-bind="text : fiTenDn"></b> được hoạt động tại Bến xe <b data-bind="text : fiBenXe"></b> (tỉnh <b data-bind="text : fiTentinhLao"></b> - CHDCND Lào).	
    </p>
    <p class="content">
        Tổng cục Đường bộ Việt Nam yêu cầu doanh nghiệp (hợp tác xã) <b data-bind="text : fiTenDn"></b> tổ chức hoạt động vận tải hành khách trên tuyến theo đúng các quy định hiện hành.
    </p>
    <table class="tb-content tb-none-border w100p">
        <tr>
            <td class="left ">
                <span><b>Nơi Nhận:</b></span><br/>
                <span>- Như trên;</span><br/>
                <span>- Cục Vận tải Lào;</span><br/>
                <span>- Sở GTVT liên quan;</span><br/>
                <span>- Bến xe hai đầu tuyến;</span><br/>
                <span>- Lưu: </span><br/>
            </td>
            <td class="t-center pb-long">
                <span class="t-bold">Đại diện Tổng cục Đường bộ Việt Nam</span><br/>
                (Ký, đóng dấu, ghi rõ họ tên)<br/>                
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

