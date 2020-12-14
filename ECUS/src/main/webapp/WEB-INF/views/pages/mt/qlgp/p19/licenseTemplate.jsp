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
        max-width: 900px;
        max-height: 942px;
        padding: 60px;
        border-style: solid;
        border-width: 2px;
        box-shadow: 0 0 0.5cm rgba(0,0,0,0.5);
    }
</STYLE>
<div class="container">
    <div class="doc">
        <TABLE WIDTH=800 CELLPADDING=7 CELLSPACING=0 STYLE="page-break-before: always" class="table">
            <COL WIDTH=225>
            <COL WIDTH=315>
            <TR VALIGN=TOP>
                <TD WIDTH=225 HEIGHT=5 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in"><FONT SIZE=3><B>BỘ
                        GIAO THÔNG VẬN TẢI</B></FONT><FONT SIZE=3><BR>MINISTRY OF
                        TRANSPORT<BR></FONT><FONT SIZE=3><B>TỔNG CỤC ĐƯỜNG BỘ
                        VIỆT NAM</B></FONT><FONT SIZE=3><BR>DIRECTORATE FOR ROADS OF
                        VIET NAM</FONT><FONT SIZE=3><B><BR>-------</B></FONT></P>
                </TD>
                <TD WIDTH=315 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in"><FONT SIZE=3><B>CỘNG
                        HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM<BR></B></FONT><FONT SIZE=3>SOCIALIST
                        REPUBLIC OF VIET NAM</FONT><FONT SIZE=3><B><BR>Độc lập - Tự
                        do - Hạnh phúc <BR></B></FONT><FONT SIZE=3>Independence -
                        Freedom - Happiness</FONT><FONT SIZE=3><B><BR>---------------</B></FONT></P>
                </TD>
            </TR>
        </TABLE>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><BR>
        </P>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=3><B>GIẤY PHÉP VẬN TẢI ĐƯỜNG BỘ QUỐC TẾ
                VIỆT  - LÀO<BR>VIET - LAO INTERNATIONAL ROAD
                TRANSPORT LICENCE</B></FONT></P>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=3><B>Số Giấy phép (Licence No.): <i style="color: #0c91e5"
                                                           data-bind="text: giayphep.fiSoGiayphep"></i></B></FONT></P>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=3><B>Đăng ký lần đầu ngày <i style="color: #0c91e5"
                                                    data-bind="text: giayphep.fiNgaydangky()?giayphep.fiNgaydangky().getDate():''"></i>
                tháng <i style="color: #0c91e5"
                         data-bind="text: giayphep.fiNgaydangky()?(giayphep.fiNgaydangky().getMonth()+1):''"></i> năm <i
                        style="color: #0c91e5"
                        data-bind="text: giayphep.fiNgaydangky()?giayphep.fiNgaydangky().getFullYear():''"></i></B></FONT>
        </P>
        <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=2><B>First Registration date: <i style="color: #0c91e5"
                                                        data-bind="text: giayphep.fiNgaydangky()?giayphep.fiNgaydangky().getDate():''"></i>
                month <i style="color: #0c91e5"
                         data-bind="text: giayphep.fiNgaydangky()?(giayphep.fiNgaydangky().getMonth()+1):''"></i> year
                <i
                        style="color: #0c91e5"
                        data-bind="text: giayphep.fiNgaydangky()?giayphep.fiNgaydangky().getFullYear():''"></i></B></FONT>
        </P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><BR>
        </P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3>1.
            Tên công ty (Name of company): <i
                    style="color: #0c91e5"
                    data-bind="text: giayphep.fiTenDoanhnghiep"></i></FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3>2.
            Địa chỉ (Address): <i
                    style="color: #0c91e5"
                    data-bind="text: giayphep.fiDiachiDoanhnghiep"></i></FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3>
            <div style="width: 50%; float: left;">Điện
                thoại (Tel): <i
                        style="color: #0c91e5"
                        data-bind="text: giayphep.fiDienthoai"></i></div>
            <div style="width: 50%; float: right;">Fax: <i
                    style="color: #0c91e5"
                    data-bind="text: giayphep.fiFax"></i></div>
        </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3>
            <div style="width: 50%; float: left;">Email:
                <i
                        style="color: #0c91e5"
                        data-bind="text: giayphep.fiEmail"></i></div>
            <div style="width: 50%; float: right;">Website: <i
                    style="color: #0c91e5"
                    data-bind="text: giayphep.fiWebsite"></i></div>
        </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3>3.
            Loại hình hoạt động vận tải (Type of transport services): <i
                    style="color: #0c91e5"
                    data-bind="text: giayphep.fiLoaihinhvantai"></i></FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> </FONT></P>
        <P CLASS="western" STYLE="margin-left: 0.5in; text-indent: -0.5in; margin-top: 0.08in; margin-bottom: 0in">
            <FONT SIZE=3>4. Giấy phép có hiệu lực đến (This licence is
                valid until): Ngày <i style="color: #0c91e5"
                                      data-bind="text: giayphep.fiNgaycaphethan()?giayphep.fiNgaycaphethan().getDate():''"></i>
                tháng <i style="color: #0c91e5"
                         data-bind="text: giayphep.fiNgaycaphethan()?(giayphep.fiNgaycaphethan().getMonth()+1):''"></i>
                năm <i style="color: #0c91e5"
                       data-bind="text: giayphep.fiNgaycaphethan()?giayphep.fiNgaycaphethan().getFullYear():''"></i>.</FONT>
        </P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><FONT SIZE=3> Date <i style="color: #0c91e5"
                                                                                                data-bind="text: giayphep.fiNgaycaphethan()?giayphep.fiNgaycaphethan().getDate():''"></i>
            </i> month <i style="color: #0c91e5"
                          data-bind="text: giayphep.fiNgaycaphethan()?(giayphep.fiNgaycaphethan().getMonth()+1):''"></i>
            Year <i style="color: #0c91e5"
                    data-bind="text: giayphep.fiNgaycaphethan()?giayphep.fiNgaycaphethan().getFullYear():''"></i></FONT>
        </P>
        <P CLASS="western" STYLE="margin-top: 0.08in; margin-bottom: 0in"><BR>
        </P>
        <TABLE WIDTH=800 CELLPADDING=7 CELLSPACING=0>
            <COL WIDTH=281>
            <COL WIDTH=281>
            <TR VALIGN=TOP>
                <TD WIDTH=281 STYLE="border: none; padding: 0in">
                    <P CLASS="western" STYLE="margin-top: 0.08in"><BR>
                    </P>
                </TD>
                <TD WIDTH=281 STYLE="border: none; padding: 0in">
                    <P CLASS="western" ALIGN=CENTER STYLE="margin-top: 0.08in"><FONT SIZE=3>……,
                        ngày <i style="color: #0c91e5"
                                data-bind="text: giayphep.fiNgayky()?giayphep.fiNgayky().getDate():''"></i>
                        tháng <i style="color: #0c91e5"
                                 data-bind="text: giayphep.fiNgayky()?(giayphep.fiNgayky().getMonth()+1):''"></i>
                        năm <i style="color: #0c91e5"
                               data-bind="text: giayphep.fiNgayky()?giayphep.fiNgayky().getFullYear():''"></i>
                        <BR>……, issuing date <i style="color: #0c91e5"
                                                data-bind="text: giayphep.fiNgayky()?giayphep.fiNgayky().getDate():''"></i>
                        month <i style="color: #0c91e5"
                                 data-bind="text: giayphep.fiNgayky()?(giayphep.fiNgayky().getMonth()+1):''"></i>
                        year <i style="color: #0c91e5"
                                data-bind="text: giayphep.fiNgayky()?giayphep.fiNgayky().getFullYear():''"></i><BR>Cơ
                        quan cấp phép (Issuing Authority)<BR></FONT><FONT SIZE=3><I>(Ký
                        tên, đóng dấu/Signature, seal)</I></FONT></P>
                </TD>
            </TR>
            <tr></tr>
        </TABLE>
        <P CLASS="western" STYLE="margin-bottom: 0in"><BR>
        </P>
        <div class="form-group">
            <div class="col-md-12">
                <div>
                    <p style="font-size: 12pt;">Link giấy phép: <a target="_blank" data-bind="text: 'Giấy phép vận tải đường bộ quốc tế Việt Nam - Lào', attr: { href: giayphep.fiLinkGiayphep}"></a></p>
                </div>
            </div>
        </div>
    </div>
</div>