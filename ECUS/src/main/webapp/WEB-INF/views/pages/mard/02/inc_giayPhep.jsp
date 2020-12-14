<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <page size="A4" class="a4-padding">
        <table class="tb-none-border w100p">
            <tr>
                <td>
                    <div class="t-center">
                        <span class="content" style="white-space: nowrap">BỘ NÔNG NGHIỆP <br>VÀ PHÁT TRIỂN NÔNG THÔN</span>
                        <p><b>CỤC THÚ Y</b><br>
                            --------------
                        </p>

                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right text-center">
                        <b>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</b>
                        <br/>
                        <b>Độc lập - Tự do - Hạnh phúc</b>
                        <br/>
                        --------------------------
                    </div>
                </td>
            </tr>
            <tr>
                <td class="">
                    <div class="left t-center">
                        <span>Số: 1474/TY-KDĐV <br> V/v: KD tạm nhập tái xuất</span>
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right text-center">
                        <i><span data-bind="text : signConfirmAddress"></span>
                            , ngày
                            <span data-bind="text : rsDay"></span> tháng
                            <span data-bind="text : rsMonth"></span> năm
                            <span data-bind="text : rsYear"></span> </i>
                    </div>
                </td>
            </tr>
        </table>
        <p class="text-center">
            <span style="font-size: medium">
                Kính gửi: <span data-bind="text : companyname"></span>
            </span>
        </p>

        <p class="text-justify">
            Trả lời Công văn số <span data-bind="text : dispatchNo"></span> ngày <span data-bind="text : rsDateFormat"></span>  của <span data-bind="text : companyname"></span> về việc đăng ký kiểm dịch tạm nhập tái xuất (TNTX):
            <!-- ko foreach: hanghoa -->
            &nbsp;<span data-bind="text : quantity"></span>&nbsp;<span data-bind="text : quantityUnitName"></span>
            &nbsp;<span data-bind="text : goodName"></span>
            &nbsp;có nguồn gốc từ:&nbsp;<span data-bind="text : exporterState"></span>,
            <!-- /ko -->
        </p>
        <p>
            <ul>
                <li>Cửa khẩu nhập vào Việt Nam: <span data-bind="text : importGate"></span></li>
                <li>Cửa khẩu xuất: <span data-bind="text : exportGate"></span></li>
                <li>Thời gian thực hiện: <span data-bind="text : executionTime"></span></li>
            </ul>
        </p>
        <p class="text-justify">
            Cục Thú y có ý kiến như sau: <span data-bind="text : responseContent"></span>
        </p>
ns
        <table class="tb-none-border w100p">
            <tr>
                <td>
                    <div class="text-left">
                        <span class="content" style="white-space: nowrap">
                            <b><i>Nơi nhận:</i></b><br>
                            - Như trên;<br>
                            - Lưu VP,KD
                        </span>
                    </div>
                </td>
                <td style="vertical-align: text-top;">
                    <div class="right text-center">
                        <b>KT. CỤC TRƯỞNG <br>
                            PHÓ CỤC TRƯỞNG <br>
                            Đã ký <br><br>
                            <span data-bind="text : signConfirmName"></span>
                        </b>
                    </div>
                </td>
            </tr>
        </table>

    </page>

</fieldset>
<template id="suaCV-tmpl">
    <div class="row">
        <form role="form" class="form-horizontal" name="ruthoso-form" id="suaCV-form">
            <div class="col-md-12">
                <p><label data-bind="text: fiMsg"></p>
            </div>
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="common.msg.ly_do"/></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-10">
                    <textarea name="Reason" id="fiNoidungYc" data-bind="value: fiNoidungYc" require="true"
                              placeholder="<spring:message code="common.msg.ly_do" />"
                              style="width: 90%; height: 150px;resize: none;"
                              maxlength="500"></textarea>
                </div>
            </div>
        </form>
    </div>
</template>





