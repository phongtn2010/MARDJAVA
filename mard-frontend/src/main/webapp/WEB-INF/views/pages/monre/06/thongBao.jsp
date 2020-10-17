<%-- 
    Document   : thongBao
    Created on : Dec 23, 2017, 12:16:46 PM
    Author     : AnNguyen
--%>

<%@ page pageEncoding="UTF-8"%>
<%@include file="word.jsp" %>
<page size="A4" class="a4-padding">
    <p class="title" style="text-align: left;">
        <spring:message code="monre.06.thongbao" />
    </p>
    <table class="w100p tb-none-border">
        <tr>
            <td><label><spring:message code="monre.06.thongbao.tencoquancap" /></label></td>
            <td><input class="form-control" id="fiTenCqCap" name="fiTenCqCap" type="text" data-bind="value : fiTenCqCap" readonly="readonly"/></td>
            <td><label><spring:message code="monre.06.thongbao.sovanban" /></label></td>
            <td><input class="form-control" id="fiSoTb" name="fiSoTb" data-bind="value : fiSoTb" type="text" readonly/></td>
        </tr>
        <tr>
            <td><label><spring:message code="monre.06.thongbao.ngayky" /></label></td>
            <td><input class="form-control" id="fiNgayKy" name="fiNgayKy" type="text" data-bind="value : fiNgayKy" readonly="readonly"/></td>
            <td><label><spring:message code="monre.06.thongbao.nguoiky" /></label></td>
            <td><input class="form-control" id="fiNguoiKy" name="fiNguoiKy" data-bind="value : fiNguoiKy" type="text" readonly/></td>
        </tr>
        <tr>
            <td><label><spring:message code="monre.06.thongbao.file" /></label></td>
            <td colspan="3">
                <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> <span data-bind="text: fiTenTep"></span></a>
            </td>            
        </tr>
    </table>
    <p class="title" style="text-align: left;">
        <spring:message code="monre.06.thongbao.ttphelieu" />
    </p>
    <table class="tb-content w100p">
        <thead>
            <tr>
                <th class="text-center"><spring:message code="monre.06.thongbao.ttphelieu.tt" /></th>
                <th class="text-center"><spring:message code="monre.06.thongbao.ttphelieu.tenphelieu" /></th>
                <th class="text-center"><spring:message code="monre.06.thongbao.ttphelieu.mahs" /></th>
                <th class="text-center"><spring:message code="monre.06.thongbao.ttphelieu.tongkldcnhap" /></th>
                <th class="text-center"><spring:message code="monre.06.thongbao.ttphelieu.khoiluongdanhap" /></th>
                <th class="text-center"><spring:message code="monre.06.thongbao.ttphelieu.khoiluongnhaplannay" /></th>
            </tr>
        </thead>
        <tbody data-bind="template: { name: 'tbPLTmpl', foreach: lstLohangNk }">
        </tbody>
        <script id="tbPLTmpl" type="text/html">
        <tr>
            <td class="text-center" data-bind="text: $index() + 1">
            </td>   
            <td data-bind="text : fiTenLoaiPl">
            </td> 
            <td data-bind="text : fiMaHs">
            </td>
            <td class="text-center" data-bind="text : fiKlTong">
            </td>
            <td class="text-center" data-bind="text : fiKlNhap">
            </td>
            <td class="text-center" data-bind="text : fiKlDaNk">
            </td>
        </tr>                      
        </script>
    </table>
</page>
