<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <table class="tb-none-border w100p">
        <tr>
            <td class="w35p">
                <div class="t-center t-bold">
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
                <div class="left t-center"  style="white-space: nowrap">
                    <p class="content">Số <b class="content" data-bind="text: fiSoVanban"></b>/TCĐBVN-VT</p>
                </div>
            </td>
            <td style="vertical-align: text-top;">
                <div class="right t-center" >
                    <b data-bind="text : fiDiaDiem"></b>, <b data-bind="vnDateText: fiNgayky"></b>
                </div>
            </td>
        </tr>
    </table>
    <p class="title">
        CHẤP THUẬN NGỪNG KHAI THÁC TUYẾN VẬN TẢI HÀNH KHÁCH TUYẾN CỐ ĐỊNH BẰNG XE Ô TÔ GIỮA VIỆT NAM VÀ LÀO
    </p>
    <p class="t-center">
        Kính gửi: <b data-bind="text : fiTenDn"></b>
    </p>
    <p class="content">
        Căn cứ các quy định hiện hành về tổ chức, quản lý hoạt động vận tải hành khách theo tuyến cố định bằng xe ô tô giữa Việt Nam và Lào:
    </p>
    <p class="content">	
        Tổng cục Đường bộ Việt Nam chấp thuận cho doanh nghiệp, HTX ngừng khai thác tuyến vận tải hành khách tuyến cố định bằng xe ô tô giữa Việt Nam và Lào.
    </p>
    <p class="content">
        Tên tuyến: <b data-bind="text : fiTuyenDi"></b> đi <b data-bind="text : fiTuyenDen"></b> và ngược lại
    </p>
    <p class="content">
        Bến đi: Bến xe <b data-bind="text : fiBenDi"></b> - <b data-bind="text : fiTenTinhDi"></b> (tên tỉnh đi).
    </p>
    <p class="content">
        Bến đến: Bến xe <b data-bind="text : fiBenDen"></b> - <b data-bind="text : fiTenTinhDen"></b> (tên tỉnh đến).
    </p>
    <table class="tb-content tb-none-border w100p">
        <tr>
            <td class="left w50p">
                <span><b>Nơi nhận:</b></span><br/>
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

