<%@ page pageEncoding="UTF-8"%>
<%@include file="inc_css.jsp" %>
<page size="A4" class="a4-padding">
    <table style="margin-top: 30px;">
        <table class="tb-none-border w100p" style="width: 100%;table-layout: fixed;">
            <tr>
                <td style="word-wrap: break-word;">
                    <div class=" t-center t-bold">
                        <span class="content t-bold" style="white-space: nowrap" >BỘ THÔNG TIN VÀ TRUYỀN THÔNG</span>
                        <span class="content t-bold" style="white-space: nowrap;font-size: 14px" >CỤC XUẤT BẢN, IN VÀ PHÁT HÀNH</span>
                    </div>
                </td>
                <td style="vertical-align: text-top;word-wrap: break-word;">
                    <div class="right t-center t-bold">
                        CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM
                        <br/>
                        Độc lập - Tự do - Hạnh phúc
                    </div>
                </td>
            </tr>
            <tr>
                <td class="w35p" style="word-wrap: break-word;">
                    <div class="t-center">
                        <p class="content">Số <b class="content" data-bind="text: fiSoGiayPhep"></b></p>
                    </div>
                </td>
                <td style="vertical-align: text-top;word-wrap: break-word;">
                    <div style="text-align: right;">
                        <b data-bind="text : fiNoiCapGp"></b> , <span data-bind="html: strNgayCapPhep"></span>
                    </div>
                </td>
            </tr>
        </table>
        <p class="title">
            DANH MỤC THIẾT BỊ NHẬP KHẨU

        </p>
        <p class="content" style="text-align: center">
            (Kèm theo giấy phép nhập khẩu số:<b data-bind="text : fiSoGiayPhep"></b>
            <span data-bind="html: strNgayCapPhep"></span>)
        </p>

        <div style="float:left;width: 100%;">
            <table style="float: left;width: 100%;table-layout: fixed;">
                <thead>
                    <tr>
                        <th style="width: 5%;" class="text-center"><spring:message code="mic.02.hoso.nhapkhau.stt" /></th>
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
                        <td style="text-align: center;word-wrap: break-word;" data-bind="text: $index() + 1"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiTenMay"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiKieuIn"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiSoMauIn"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiTenHangSx"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiModelMay"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiSoDinhDanhMay"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiNuocSx"></td>
                        <td style="text-align: center;word-wrap: break-word;" data-bind="text : fiNamSx"></td>
                        <td style="text-align: right;word-wrap: break-word;" data-bind="text : fiSoLuong"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiChatLuong"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiKhuanKhoBanIn"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiDonViTinhKhuonKho"></td>
                        <td style="text-align: left;word-wrap: break-word; " data-bind="text : fiTocDoIn"></td>
                        <td style="text-align: left;word-wrap: break-word;" data-bind="text : fiDonViTocDoIn"></td>
                    </tr>
                </tbody>

            </table>

        </div>


    </table>
</page>