<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <page size="A4" class="a4-padding">
        <p class="title text-centers">
            <span style="font-size: medium">XÁC NHẬN CỦA CƠ QUAN KIỂM DỊCH ĐỘNG VẬT:</span>
        </p>
        <p class="content">
            Đồng ý đưa hàng hóa về địa điểm: <b data-bind="text : fiDiadiemKiemdich"></b>
        </p>
        <p class="content">
            để làm thủ tục kiểm dịch vào hồi <span data-bind="html : strThoigianKiemdich"></span>
        </p>
        <p class="text-right">
            Vào sổ số <b data-bind="text : fiSoVaoso"></b>, <span data-bind="html: strNgayKy"></span>
        </p>
        <table class="tb-content tb-none-border w100p">
            <tr>
                <td class="left ">
                </td>
                <td class="t-center pb-long">
                    <b data-bind="text : fiTenCqxl"></b><br/>
                    (Ký, đóng dấu, ghi rõ họ tên)<br/>
                </td>
            </tr>
            <tr>
                <td class="left "></td>
                <td class="t-center pb-long">
                    <b data-bind="text: fiNguoiky"></b>
                </td>
            </tr>
        </table>
    </page>
</fieldset>