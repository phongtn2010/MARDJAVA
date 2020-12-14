<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<STYLE TYPE="text/css">
    .container {
        justify-content: center;
        width: 100%;
        display: flex;
    }

    .doc {
        width: 900px;
        height: 1100px;
        padding: 60px;
        border-style: solid;
        border-width: 2px;
    }
</STYLE>
<div class="container">
    <div class="doc">
        <TABLE WIDTH=780 CELLPADDING=7 CELLSPACING=0 STYLE="page-break-before: always">
            <COL WIDTH=225>
            <COL WIDTH=315>
            <TR VALIGN=TOP>
                <TD WIDTH=250 HEIGHT=5 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in"><FONT SIZE=2>BỘ
                        GIAO THÔNG VẬN TẢI</FONT><FONT SIZE=2>
                        <BR></FONT><FONT SIZE=2><B>TỔNG CỤC ĐƯỜNG BỘ VIỆT NAM</B></FONT><FONT SIZE=2><B><BR>-------</B></FONT></P>
                </TD>
                <TD WIDTH=250 HEIGHT=5 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=LEFT STYLE="margin-top: 0.08in">
                    </P>
                </TD>
                <TD WIDTH=330 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in"><FONT SIZE=2><B>CỘNG
                        HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM<BR></B></FONT><FONT SIZE=2><B>Độc lập - Tự
                        do - Hạnh phúc <BR></B></FONT><FONT SIZE=2><B>---------------</B></FONT></P>
                </TD>
            </TR>
        </TABLE>
        <TABLE WIDTH=780 CELLPADDING=7 CELLSPACING=0 STYLE="page-break-before: always">
            <COL WIDTH=225>
            <COL WIDTH=315>
            <TR VALIGN=TOP>
                <TD WIDTH=250 HEIGHT=5 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=LEFT STYLE="margin-top: 0.08in">
                        <FONT SIZE=2>Số <i style="color: #0c91e5"
                                           data-bind="text: hoso.fiSoCongVan"></i>/TCĐBVN-VT </FONT>
                    </P>
                </TD>
                <TD WIDTH=250 HEIGHT=5 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=LEFT STYLE="margin-top: 0.08in">
                    </P>
                </TD>
                <TD WIDTH=330 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in">
                        <FONT SIZE=2>
                            Hà Nội, ngày       tháng     năm
                        </FONT>
                    </P>
                </TD>
            </TR>
        </TABLE>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><BR>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=2><B>CHẤP THUẬN<BR>KHAI THÁC TUYẾN VẬN TẢI HÀNH KHÁCH TUYẾN CỐ ĐỊNH BẰNG<BR>
                XE Ô TÔ GIỮA VIỆT NAM VÀ LÀO</B></FONT></P>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=2><B>Tuyến: <i style="color: #0c91e5" data-bind="text: hoso.fiTenTinhDi"></i>. đi <i style="color: #0c91e5" data-bind="text: hoso.fiTenTinhDen"></i>. và ngược lại</B></FONT></P>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=2><B>Giữa: Bến xe <i style="color: #0c91e5" data-bind="text: hoso.fiBenDi"></i>. và Bến xe <i style="color: #0c91e5" data-bind="text: hoso.fiBenDen"></i></B></FONT>
        </P>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=2>Kính gửi:<i style="color: #0c91e5" data-bind="text: hoso.fiKinhGui"></i>.</FONT>
        </P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><BR>
        </P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Tổng cục Đường bộ Việt Nam nhận được công văn số <i style="color: #0c91e5" data-bind="text: hoso.fiKinhGui"></i>. ngày <i style="color: #0c91e5" data-bind="text: hoso.fiNgayCapCongVan()?hoso.fiNgayCapCongVan().getDate():''"></i> tháng <i style="color: #0c91e5"  data-bind="text: hoso.fiNgayCapCongVan()?(hoso.fiNgayCapCongVan().getMonth()+1):''"></i> năm <i style="color: #0c91e5" data-bind="text: hoso.fiNgayCapCongVan()?hoso.fiNgayCapCongVan().getFullYear():''"></i> và hồ sơ kèm theo của doanh nghiệp (hợp tác xã) <i style="color: #0c91e5" data-bind="text: hoso.fiTenDoanhNghiep"></i> về việc đăng ký khai thác tuyến vận tải hành khách tuyến cố định bằng xe ô tô giữa Việt Nam và Lào;</FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Thực hiện Điều .... Thông tư số.../2014/TT-BGTVT ngày .../.../2014 của Bộ trưởng Bộ Giao thông vận tải hướng dẫn thực hiện một số Điều của Hiệp định và Nghị định thư thực hiện Hiệp định tạo điều kiện thuận lợi cho phương tiện cơ giới đường bộ qua lại biên giới giữa Chính phủ nước CHXHCN Việt Nam và Chính phủ nước CHDCND Lào, Tổng cục ĐBVN thông báo như sau:</FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>
            Chấp thuận cho phép doanh nghiệp (hợp tác xã)... được khai thác tuyến vận tải hành khách tuyến cố định bằng xe ô tô giữa Việt Nam và Lào.
        </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Tên tuyến: <i style="color: #0c91e5" data-bind="text: hoso.fiTenTinhDi"></i>.. đi <i style="color: #0c91e5" data-bind="text: hoso.fiTenTinhDen"></i> và ngược lại</FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Bến đi: Bến xe <i style="color: #0c91e5" data-bind="text: hoso.fiBenDi"></i>. (tên tỉnh đi).</FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Bến đến: Bến xe <i style="color: #0c91e5" data-bind="text: hoso.fiBenDen"></i>. (tên tỉnh đến).</FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Hành trình: <i style="color: #0c91e5" data-bind="text: hoso.fiHanhTrinh"></i> cửa khẩu đi/cửa khẩu đến </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Số xe tham gia khai thác:</FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Thời hạn tham gia khai thác: Theo thời hạn quy định của Giấy phép vận tải đường bộ quốc tế Việt - Lào.</FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Trong thời gian 60 ngày, kể từ ngày ký văn bản này doanh nghiệp (hợp tác xã) phải đưa phương tiện vào triển khai thực hiện, doanh nghiệp (hợp tác xã) phải ký hợp đồng khai thác với bến xe hai đầu tuyến, báo cáo về Tổng cục Đường bộ Việt Nam và Sở Giao thông vận tải …… Quá thời hạn nêu trên, văn bản chấp thuận không còn hiệu lực. </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Tổng cục Đường bộ Việt Nam trân trọng đề nghị Cục Vận tải Lào và Sở Công chính và Vận tải ……… bố trí cho phương tiện theo danh sách nêu trên của doanh nghiệp (hợp tác xã) <i style="color: #0c91e5" data-bind="text: hoso.fiTenDoanhNghiep"></i>. được hoạt động tại Bến xe ………… (tỉnh …………. - CHDCND Lào). </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2>Tổng cục Đường bộ Việt Nam yêu cầu doanh nghiệp (hợp tác xã) <i style="color: #0c91e5" data-bind="text: hoso.fiTenDoanhNghiep"></i>. tổ chức hoạt động vận tải hành khách trên tuyến theo đúng các quy định hiện hành./. </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=2> </FONT></P>


        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><BR>
        </P>
        <TABLE WIDTH=780 CELLPADDING=7 CELLSPACING=0 STYLE="page-break-before: always">
            <COL WIDTH=225>
            <COL WIDTH=315>
            <TR VALIGN=TOP>
                <TD WIDTH=290 HEIGHT=5 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=LEFT STYLE="margin-top: 0.08in">
                        <FONT SIZE=2>
                            <B>Nơi nhận<BR></B>
                            <BR>
                            - Như trên;<BR>
                            - Cục Vận tải Lào;<BR>
                            - Sở GTVT liên quan;<BR>
                            - Bến xe hai đầu tuyến;<BR>
                            - Lưu:<BR>
                        </FONT>
                    </P>
                </TD>
                <TD WIDTH=100 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in">

                    </P>

                </TD>
                <TD WIDTH=290 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in">
                        <FONT SIZE=2>
                            <B>Đại diện Tổng cục Đường bộ Việt Nam<BR></B>
                            <I>(Ký tên, đóng dấu)</I>
                        </FONT>
                    </P>

                </TD>
            </TR>
        </TABLE>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3>Link công văn: <a target="_blank" data-bind="text: 'Chấp thuận khai thác tuyến vận tải hành khách tuyến cố định bằng xe ô tô giữa Việt Nam Lào Campuchia', attr: { href: giayphep.fiLinkGiayphep}"></a> </FONT></P>
        <P CLASS="western" STYLE="margin-bottom: 0in"><BR></P>
        <P CLASS="western" STYLE="margin-bottom: 0in"><BR></P>

    </div>

</div>