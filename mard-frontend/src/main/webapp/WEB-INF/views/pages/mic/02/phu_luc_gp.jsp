<%@ page pageEncoding="UTF-8"%>
<%@include file="inc_css.jsp" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p">
            <tr>
                <td >
                    <div class=" t-center t-bold">
                        <span class="content t-bold" style="white-space: nowrap" >BỘ THÔNG TIN VÀ TRUYỀN THÔNG</span>
                        <span class="content t-bold" style="white-space: nowrap;font-size: 14px" >CỤC XUẤT BẢN, IN VÀ PHÁT HÀNH</span>
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
                    <div class="t-center">
                        <p class="content">Số <b class="content" data-bind="text: fiSoGiayPhep"></b>/GP-CXBIPH</p>
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right t-center">
                        <b data-bind="text : fiNoiCapGp"></b> , <span data-bind="html: strNgayCapPhep"></span>
                    </div>
                </td>
            </tr>
        </table>
        <p class="title">
            DANH MỤC THIẾT BỊ NHẬP KHẨU

        </p>
        <p class="content" style="text-align: center">
            (Kèm theo giấy phép nhập khẩu số:<b data-bind="text : fiSoGiayPhep"></b>/GP-CXBIPH 
            <span data-bind="html: strNgayCapPhep"></span>)
        </p>
        <table style="margin-left: -1.5%;">
            <thead>
                <tr >
                    <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.stt" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.tenmay" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.kieuin" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.somauin" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.tenhangsx" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.modelMay" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.sodinhdanhmay" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.nuocSX" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.namSX" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.nhapkhau.soluong" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.chatluong" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.khuankhonin" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.donvitinhkkin" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.tocdophoto" /></th>
            <th class="text-center"><spring:message code="mic.02.hoso.popup.tbnk.donvitinhphoto" /></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstThietBiNk02">
                <tr>
                    <td style="text-align: center" data-bind="text: $index() + 1">
                    </td>  
                    <td style="width: 220px;text-align: left" data-bind="text : fiTenMay">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiKieuIn">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiSoMauIn">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiTenHangSx">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiModelMay">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiSoDinhDanhMay">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiNuocSx">
                    </td>
                    <td style="width: 220px;text-align: center" data-bind="text : fiNamSx">
                    </td>
                    <td style="width: 220px;text-align: right" data-bind="text : fiSoLuong">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiChatLuong">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiKhuanKhoBanIn">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiDonViTinhKhuonKho">
                    </td>
                    <td style="width: 220px;text-align: left " data-bind="text : fiTocDoIn">
                    </td>
                    <td style="width: 220px;text-align: left" data-bind="text : fiDonViTocDoIn">
                    </td>

                </tr>
            </tbody>

        </table>
    </table>
</page>