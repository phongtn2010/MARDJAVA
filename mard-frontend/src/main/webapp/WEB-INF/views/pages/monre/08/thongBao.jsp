<%-- 
    Document   : thongBao
    Created on : Dec 23, 2017, 12:16:46 PM
    Author     : AnNguyen
--%>

<%@ page pageEncoding="UTF-8"%>
<%@include file="word.jsp" %>
<page size="A4" class="a4-padding">
    <p class="title" style="text-align: left;">
        <spring:message code="monre.08.thongbao" />
    </p>
    <table class="w100p tb-none-border">
        <tr>
            <td style="text-align: right;"><label><spring:message code="monre.08.thongbao.tencoquancap" /></label></td>
            <td><input class="form-control" id="fiCoQuanCap" name="fiCoQuanCap" type="text" data-bind="value : fiCoQuanCap" readonly="readonly"/></td>
            <td style="text-align: right;"><label><spring:message code="monre.08.thongbao.sovanban" /></label></td>
            <td><input class="form-control" id="fiSoVanBan" name="fiSoVanBan" data-bind="value : fiSoVanBan" type="text" readonly/></td>
        </tr>
        <tr>
            <td style="text-align: right;"><label><spring:message code="monre.08.thongbao.ngayky" /></label></td>
            <td><input class="form-control" id="fiNgayKy" name="fiNgayKy" type="text" data-bind="value : fiNgayKy" readonly="readonly"/></td>
            <td style="text-align: right;"><label><spring:message code="monre.08.thongbao.nguoiky" /></label></td>
            <td><input class="form-control" id="fiNguoiKy" name="fiNguoiKy" data-bind="value : fiNguoiKy" type="text" readonly/></td>
        </tr>
        <tr>
            <td style="text-align: right;"><label><spring:message code="monre.08.thongbao.file" /></label></td>
            <td colspan="3">
                <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> <span data-bind="text: fiTenTepTin"></span></a>
            </td>            
        </tr>
    </table>
    <fieldset>
        <legend>Phần II: THÔNG TIN PHẾ LIỆU NHẬP KHẨU</legend>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 50px;"><spring:message code="monre.08.hoso.thongtinphelieu.tt" /></th>
                            <th class="text-center"><spring:message code="monre.08.hoso.thongtinphelieu.tenphelieu" /></th>
                            <!--<th class="text-center" style="width: 210px;"><spring:message code="monre.08.hoso.thongtinphelieu.mahs" /></th>-->
                            <th class="text-center" style="width: 180px;"><spring:message code="monre.08.hoso.thongtinphelieu.khoiluog" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'tbdphelieuTmpl', foreach: lstPheLieu }">
                    </tbody>
                    <script id="tbdphelieuTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : stt">
                            </td>
                            <td data-bind="text : fiTenPhelieu">
                            </td>
                            <!--<td data-bind="text : fiMaHoso"></td>-->
                            <td class="text-center" data-bind="text : fiKhoiLuong">
                            </td>
                        </tr>                      
                    </script>
                    </table>
                <span data-bind="text : errorPheLieuMessage" style="color:red;"> </span>    
            </div>
        </div>
    </fieldset>  
</page>
