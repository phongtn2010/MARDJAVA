<%-- 
    Document   : thongBao
    Created on : Dec 23, 2017, 12:16:46 PM
    Author     : AnNguyen
--%>

<%@ page pageEncoding="UTF-8"%>
<%@include file="word.jsp" %>
<page size="A4" class="a4-padding">
    <p class="title" style="text-align: left;">
        <spring:message code="monre.07.thongbao" />
    </p>
    <table class="w100p tb-none-border">
        <tr>
            <td><label><spring:message code="monre.07.thongbao.tencoquancap" /></label></td>
            <td><input class="form-control" id="fiTenCqCap" name="fiTenCqCap" type="text" data-bind="value : fiTenCqCap" readonly="readonly"/></td>
            <td><label><spring:message code="monre.07.thongbao.sovanban" /></label></td>
            <td><input class="form-control" id="fiSoVanban" name="fiSoVanban" data-bind="value : fiSoVanban" type="text" readonly/></td>
        </tr>
        <tr>
            <td><label><spring:message code="monre.07.thongbao.ngayky" /></label></td>
            <td><input class="form-control" id="fiNgayKy" name="fiNgayKy" type="text" data-bind="value : fiNgayKy" readonly="readonly"/></td>
            <td><label><spring:message code="monre.07.thongbao.nguoiky" /></label></td>
            <td><input class="form-control" id="fiNguoiKy" name="fiNguoiKy" data-bind="value : fiNguoiKy" type="text" readonly/></td>
        </tr>
        <tr>
            <td><label><spring:message code="monre.07.thongbao.file" /></label></td>
            <td colspan="3">
                <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> <span data-bind="text: fiTenTep"></span></a>
            </td>            
        </tr>
    </table>
</page>
