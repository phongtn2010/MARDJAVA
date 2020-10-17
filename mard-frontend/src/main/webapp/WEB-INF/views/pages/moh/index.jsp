<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<style>
    .collapsible {
        background-color: #eff3f8;
        color: black;
        cursor: pointer;
        /* padding: 12px; */
        width: 100%;
        text-align: left;
        outline: none;
        font-size: 16px;
        border: 1px solid #255b9f;
        margin :1px;
    }

    .collapsible:hover{
        background: #4996f4;
    }
    .collapsible b{
        font-weight: normal;
    }
    .collapsible span {
        float:right;
        padding:2px;
        color:blue;
    }
    .content {
        padding: 0px 15px;
        /*max-height: 0;*/
        display: block;
        overflow: hidden;
        transition: max-height 0.2s ease-out;
        background-color: #f1f1f1;
    }

    .reference-item{
        list-style-type: none;
        border: 1px solid #255b9f;
        padding: 2px;


    }
    .reference-item a{
        text-decoration: none;
        color: black;
    }

    .reference-item:hover{
        background:#4996f4;
    }

    .number-list {
        color:black;
    }
</style>
<div id="groupMenu">
    <button data-bind="click: $root.clickShowMenu.bind($data, 1)"  class="collapsible"><b>I. Nhóm các thủ tục Quản lý dược - Bộ Y tế</b>
        <span data-bind="if: !$root.showGroup1()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup1()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup1()" class="content">
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/38/home?maThuTuc=BYTE0800016'/>">Thủ tục Cấp giấy phép nhập khẩu thuốc phải kiểm soát đặc biệt có giấy đăng ký lưu hành thuốc tại Việt Nam</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/39/home?maThuTuc=BYTE0800017'/>">Thủ tục Cấp phép nhập khẩu nguyên liệu làm thuốc phải kiểm soát đặc biệt</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/40/home?maThuTuc=BYTE0800018'/>">Cấp phép nhập khẩu dược chất, bán thành phẩm thuốc, dược liệu, bán thành phẩm dược liệu để làm mẫu kiểm nghiệm, nghiên cứu thuốc, trừ nguyên liệu phải kiểm soát đặc biệt</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/41/home?maThuTuc=BYTE0800019'/>">Cấp phép nhập khẩu dược chất, bán thành phẩm thuốc, dược liệu, bán thành phẩm dược liệu để sản xuất thuốc xuất khẩu, trừ nguyên liệu phải kiểm soát đặc biệt</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/42/home?maThuTuc=BYTE0800020'/>">Cấp phép nhập khẩu dược chất, bán thành phẩm thuốc, dược liệu, bán thành phẩm dược liệu để sản xuất thuốc phục vụ yêu cầu quốc phòng, an ninh, phòng, chống dịch bệnh, khắc phục hậu quả thiên tai, thảm họa, trừ nguyên liệu phải kiểm soát đặc biệt</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/43/home?maThuTuc=BYTE0800021'/>">Cấp phép nhập khẩu tá dược, vỏ nang, bao bì tiếp xúc trực tiếp với thuốc, chất chuẩn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/19/home?maThuTuc=BYTE0800013'/>">19-Cấp giấy phép xuất khẩu thuốc phóng xạ; thuốc và dược chất trong danh mục thuốc, dược chất thuộc danh mục chất bị cấm sử dụng trong một số ngành, lĩnh vực; thuốc độc; nguyên liệu độc làm thuốc</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/21/home?maThuTuc=BYTE0800014'/>">21-Cấp giấy phép xuất khẩu thuốc phải kiểm soát đặc biệt để viện trợ, viện trợ nhân đạo</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/22/home?maThuTuc=BYTE0800010'/>">22-Cấp giấy phép xuất khẩu thuốc phải kiểm soát đặc biệt đã được cấp phép nhập khẩu để phục vụ hoạt động khám bệnh, chữa bệnh nhân đạo nhưng không sử dụng hết</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/23/home?maThuTuc=BYTE0800011'/>">23-Cấp giấy phép xuất khẩu thuốc phải kiểm soát đặc biệt để tham gia trưng bày tại triển lãm, hội chợ</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/25/home?maThuTuc=BYTE0800012'/>">25-Cấp giấy phép xuất khẩu thuốc phóng xạ, thuốc độc, nguyên liệu độc làm thuốc, thuốc và dược chất trong danh mục thuốc, dược chất thuộc danh mục chất bị cấm sử dụng trong </a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/36/home?maThuTuc=BYTE0800015'/>">36-Cấp giấy phép nhập khẩu thuốc dùng cho mục đích thử lâm sàng, thử tương đương sinh học, đánh giá sinh khả dụng tại Việt Nam, làm mẫu kiểm nghiệm, nghiên cứu khoa học</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/44/home?maThuTuc=BYTE0800022'/>">44-Cấp giấy phép nhập khẩu dược liệu không sử dụng làm mẫu kiểm nghiệm, nghiên cứu thuốc, tham gia trưng bày tại triển lãm, hội chợ, sản xuất thuốc xuất khẩu, sản xuất thuốc phục vụ yêu cầu quốc phòng, an ninh, phòng, chống dịch bệnh, khắc phục hậu quả thiên tai, thảm họa</a></li>
    </div>
</div>
<script>

    var i;
    var sum = 0;
    var listItem = document.getElementsByClassName("reference-item");
    var numberList = document.getElementsByClassName("number-list");

    for (i = 0; i < listItem.length; i++) {
        sum = sum + 1;
        numberList[i].innerHTML = " " + sum + " . ";
        if (i == 17) {
            sum = sum + 1;
            numberList[i].innerHTML = " " + sum + " . ";
        } else if (i == 33) {
            sum = sum + 1;
            numberList[i].innerHTML = " " + sum + " . ";
        } else if (i == 41) {
            sum = sum + 1;
            numberList[i].innerHTML = " " + sum + " . ";
        }
    }

    function MenuViewModel() {
        var self = this;
        self.showGroup1 = ko.observable(false);

        self.clickShowMenu = function (groupPosition) {
            if (groupPosition == 1) {
                if (self.showGroup1() == true) {
                    self.showGroup1(false);
                } else {
                    self.showGroup1(true);
                }
            } 
        }
    }
    var vm = new MenuViewModel();

    ko.applyBindings(vm, document.getElementById("groupMenu"));
</script>