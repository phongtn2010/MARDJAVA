<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <div class="note note-info">
        <%@include file="authheader.jsp" %>
    </div>



    <button data-bind="click: $root.clickShowMenu.bind($data, 1)"  class="collapsible"><b>I. Nhóm các thủ tục Việt Nam - Lào</b>
        <span data-bind="if: !$root.showGroup1()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup1()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup1()" class="content">
        <li class="reference-item"> <span class="number-list"></span>  <a href="<c:url value='/mt/01/home/BGTVT0600001'/>">Cấp Giấy phép vận tải đường bộ quốc tế Việt - Lào cho doanh nghiệp, hợp tác xã của Việt Nam</a></li>
        <li class="reference-item"><span class="number-list"></span>  <a href="<c:url value='/mt/01/home/BGTVT0600002'/>">Cấp lại Giấy phép hoạt động vận tải đường bộ quốc tế Việt - Lào cho doanh nghiệp, hợp tác xã của Việt Nam do hết hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span> <a href="<c:url value='/mt/01/home/BGTVT0600003'/>">Cấp lại Giấy phép hoạt động vận tải đường bộ quốc tế Việt - Lào cho doanh nghiệp, hợp tác xã của Việt Nam do hư hỏng</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/01/home/BGTVT0600004'/>">Cấp lại Giấy phép hoạt động vận tải đường bộ quốc tế Việt - Lào cho doanh nghiệp, hợp tác xã của Việt Namdo mất mát</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/05/home/BGTVT0600005'/>">Cấp Giấy phép liên vận Việt - Lào cho phương tiện thương mại (áp dụng cho phương tiện kinh doanh vận tải)</a></li>
        <li class="reference-item">  <span class="number-list"></span><a href="<c:url value='/mt/05/home/BGTVT0600006'/>">Cấp lại Giấy phép liên vận Việt - Lào cho phương tiện thương mại áp dụng cho phương tiện kinh doanh vận tải) do hết hạn</a></li>
        <li class="reference-item"><span class="number-list"></span><a href="<c:url value='/mt/05/home/BGTVT0600007'/>">Cấp lại Giấy phép liên vận Việt - Lào cho phương tiện thương mại (áp dụng cho phương tiện kinh doanh vận tải) do hư hỏng</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/05/home/BGTVT0600008'/>">Cấp lại Giấy phép liên vận Việt - Lào cho phương tiện thương mại (áp dụng cho phương tiện kinh doanh vận tải) do mất mát</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/09/home/BGTVT0600009'/>">Cấp Giấy phép liên vận Việt -Lào cho phương tiện phi thương mại; phương tiện thương mại phục vụ các công trình, dự án hoặc hoạt động kinh doanh của doanh nghiệp, hợp tác xã trên lãnh thổ Lào</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/09/home/BGTVT0600010'/>">Cấp lại Giấy phép liên vận Việt-Lào cho phương tiện phi thương mại; phương tiện thương mại phục vụ các công trình, dự án hoặc hoạt động kinh doanh của doanh nghiệp, hợp tác xã trên lãnh thổ Lào do hết hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/09/home/BGTVT0600011'/>">Cấp lại Giấy phép liên vận Việt - Lào cho phương tiện phi thương mại; phương tiện thương mại phục vụ các công trình, dự án hoặc hoạt động kinh doanh của doanh nghiệp, hợp tác xã trên lãnh thổ Lào do hư hỏng</a></li>
        <li class="reference-item"> <span class="number-list"></span> <a href="<c:url value='/mt/09/home/BGTVT0600012'/>">Cấp lại Giấy phép liên vận Việt-Lào cho phương tiện phi thương mại; phương tiện thương mại phục vụ các công trình, dự án hoặc hoạt động kinh doanh của doanh nghiệp, hợp tác xã trên lãnh thổ Lào do mất mát</a></li>
        <li class="reference-item"><span class="number-list"></span><a href="<c:url value='/mt/13/home?maThuTuc=BGTVT0600013'/>">Thủ tục Chấp thuận khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Lào</a></li>
        <li class="reference-item"><span class="number-list"></span><a href="<c:url value='/mt/14/home?maThuTuc=BGTVT0600014'/>">Thủ tục Bổ sung phương tiện khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Lào</a></li>
        <li class="reference-item"><span class="number-list"></span><a href="<c:url value='/mt/15/home?maThuTuc=BGTVT0600015'/>">Thủ tục Thay thế phương tiện khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Lào</a></li>
        <li class="reference-item"><span class="number-list"></span><a href="<c:url value='/mt/16/home?maThuTuc=BGTVT0600016'/>">Thủ tục Ngừng khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Lào</a></li>
        <li class="reference-item"><span class="number-list"></span><a href="<c:url value='/mt/17/home?maThuTuc=BGTVT0600017'/>">Thủ tục Điều chỉnh tần suất chạy xe trên tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Lào</a></li>
    </div>
    <button data-bind="click: $root.clickShowMenu.bind($data, 2)" class="collapsible">  <b>II. Nhóm các thủ tục Việt Nam - Campuchia</b>
        <span data-bind="if: !$root.showGroup2()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup2()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup2()"  class="content">
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/19/home/BGTVT0600019'/>">Cấp Giấy phép hoạt động vận tải đường bộ quốc tế Việt Nam - Campuchia</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/19/home/BGTVT0600020'/>">Cấp lại Giấy phép hoạt động vận tải đường bộ quốc tế Việt Nam - Campuchia do hết hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/19/home/BGTVT0600021'/>">Cấp lại Giấy phép hoạt động vận tải đường bộ quốc tế Việt Nam - Campuchia do hư hỏng</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/19/home/BGTVT0600022'/>">Cấp lại Giấy phép hoạt động vận tải đường bộ quốc tế Việt Nam - Campuchia do mất mát</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/23/home/BGTVT0600023'/>">Cấp Giấy phép liên vận Việt Nam - Campuchia đối với phương tiện thương mại </a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/23/home/BGTVT0600024'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia cho phương tiện thương mại do hết hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/23/home/BGTVT0600025'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia cho phương tiện thương mại do hư hỏng</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/23/home/BGTVT0600026'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia cho phương tiện thương mại do mất mát</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/27/home/BGTVT0600027'/>">Cấp Giấy phép liên vận Việt Nam - Campuchia cho phương tiện phi thương mại</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/27/home/BGTVT0600028'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia cho phương tiện phi thương mại do hư hỏng</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/27/home/BGTVT0600029'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia cho phương tiện phi thương mại do mất mát</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/30/home?maThuTuc=BGTVT0600030'/>">Thủ tục Chấp thuận khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Campuchia</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/31/home?maThuTuc=BGTVT0600031'/>">Thủ tục Bổ sung phương tiện khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Campuchia</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/32/home?maThuTuc=BGTVT0600032'/>">Thủ tục Thay thế phương tiện khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Campuchia</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/33/home?maThuTuc=BGTVT0600033'/>">Thủ tục Ngừng khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Campuchia</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/34/home?maThuTuc=BGTVT0600034'/>">Thủ tục Điều chỉnh tần suất chạy xe trên tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Campuchia</a></li>
    </div>
    <button data-bind="click: $root.clickShowMenu.bind($data, 3)" class="collapsible"><b>III. Nhóm các thủ tục Việt Nam - Trung Quốc</b>
        <span data-bind="if: !$root.showGroup3()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup3()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup3()"  class="content">
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/36/home?maThuTuc=BGTVT0600036'/>">Thủ tục Cấp Giấy phép vận tải cho xe công vụ</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/37/home?maThuTuc=BGTVT0600037'/>">Thủ tục cấp GP vận tải loại A,E; loại B,C,F,G lần đầu trong năm</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/37/home?maThuTuc=BGTVT0600038'/>">Thủ tục cấp lại giấy phép vận tải loại A, E do hết hạn</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/37/home?maThuTuc=BGTVT0600039'/>">Thủ tục cấp lại giấy phép vận tải loại B, C, F, G do hết hạn</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/37/home?maThuTuc=BGTVT0600040'/>">Thủ tục cấp giấy phép vận tải loại B,C,F,G lần thứ hai trở đi trong năm</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/41/home?maThuTuc=BGTVT0600041'/>">Thủ tục cấp lại giấy phép vận tải loại A, D, E do hư hỏng mất mát</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/42/home?maThuTuc=BGTVT0600042'/>">Thủ tục cấp giấy giới thiệu giấy phép vận tải loại D đối với phương tiện của Việt Nam</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/43/home?maThuTuc=BGTVT0600043'/>">Thủ tục cấp giấy phép vận tải loại D đối với phương tiện vận tải của Trung Quốc</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/44/home?maThuTuc=BGTVT0600044'/>">Thủ tục chấp thuận khai thác tuyến vận tải hành khách định kỳ giữa Việt Nam và Trung Quốc</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/44/home?maThuTuc=BGTVT0600045'/>">Thủ tục chấp thuận bổ sung phương tiện khai thác tuyến vận tải hành khách định kỳ giữa Việt Nam và Trung Quốc</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/44/home?maThuTuc=BGTVT0600046'/>">Thủ tục chấp thuận thay thế phương tiện khai thác tuyến vận tải hành khách định kỳ giữa Việt Nam và Trung Quốc</a></li>
    </div>
    <button data-bind=" click: $root.clickShowMenu.bind($data, 4)" class="collapsible"><b>IV. Nhóm các thủ tục Việt Nam - Campuchia - Lào</b>
        <span data-bind="if: !$root.showGroup4()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup4()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div  data-bind="if: $root.showGroup4()" class="content">
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/48/home/BGTVT0600048'/>">Cấp Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện thương mại</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/48/home/BGTVT0600049'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện thương mại do hết hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/48/home/BGTVT0600050'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện thương mại do hư hỏng</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/48/home/BGTVT0600051'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện thương mại do mất mát</a></li>
                <%----%>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/52/home/BGTVT0600052'/>">Cấp Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện phi thương mại</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/52/home/BGTVT0600053'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện phi thương mại do hư hỏng</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/52/home/BGTVT0600054'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện phi thương mại do mất mát</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/52/home/BGTVT0600055'/>">Cấp lại Giấy phép liên vận Việt Nam - Campuchia - Lào cho phương tiện thương mại do hết hạn</a></li>
            <%----%>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/56/home/BGTVT0600056'/>">Chấp thuận khai thác tuyến vận tải hành khách cố định liên vận quốc tế giữa Việt Nam - Lào - Campuchia</a></li>
    </div>
    <button data-bind=" click: $root.clickShowMenu.bind($data, 5)" class="collapsible"><b>V. Nhóm các thủ tục GMS</b>
        <span data-bind="if: !$root.showGroup5()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup5()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div  data-bind="if: $root.showGroup5()" class="content">
        <li class="reference-item"><span class="number-list"></span><a href="<c:url value='/mt/58/home?maThuTuc=BGTVT0600058'/>">Cấp giấy phép hoạt động vận tải đường bộ quốc tế GMS</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/58/home?maThuTuc=BGTVT0600059'/>">Cấp lại giấy phép hoạt động vận tải đường bộ quốc tế GMS do hết hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/58/home?maThuTuc=BGTVT0600060'/>">Cấp lại giấy phép hoạt động vận tải đường bộ quốc tế GMS do bị mất</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/61/home?maThuTuc=BGTVT0600061'/>">Cấp giấy phép vận tải đường bộ GMS cho phương tiện (của doanh nghiệp, HTX đã được cấp giấy phép vận tải đường bộ quốc tế)</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/61/home?maThuTuc=BGTVT0600062'/>">Cấp lại giấy phép vận tải đường bộ GMS cho phương tiện (của doanh nghiệp, HTX đã được cấp giấy phép vận tải đường bộ quốc tế) do hết hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/61/home?maThuTuc=BGTVT0600063'/>">Cấp lại giấy phép vận tải đường bộ GMS cho phương tiện (của doanh nghiệp, HTX đã được cấp giấy phép vận tải đường bộ quốc tế) do hư hỏng</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/61/home?maThuTuc=BGTVT0600064'/>">Cấp lại giấy phép vận tải đường bộ GMS cho phương tiện (của doanh nghiệp, HTX đã được cấp giấy phép vận tải đường bộ quốc tế) do mất mát</a></li>
    </div>
    <button data-bind=" click: $root.clickShowMenu.bind($data, 6)" class="collapsible"><b>VI. Nhóm thủ tục gia hạn</b>
        <span data-bind="if: !$root.showGroup6()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup6()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div  data-bind="if: $root.showGroup6()" class="content">
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/18/home/BGTVT0600018'/>">Gia hạn giấy phép liên vận Việt - Lào và thời gian lưu hành tại Việt Nam cho phương tiện của Lào</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/18/home/BGTVT0600035'/>">Gia hạn giấy phép liên vận và thời gian lưu hành đối với phương tiện của Campuchia lưu trú tại Việt Nam</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/18/home/BGTVT0600057'/>">Gia hạn giấy phép liên vận CLV đối với phương tiện của Lào, Campuchia tại Việt Nam</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/18/home/BGTVT0600065'/>">Gia hạn giấy phép vận tải đường bộ GMS và thời gian lưu hành cho phương tiện của các nước thực hiện hiệp định GMS tại Việt Nam</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/47/home/BGTVT0600047'/>">Gia hạn giấy phép vận tải và thời gian lưu hành tại Việt Nam cho phương tiện của Trung Quốc</a></li>
    </div>
     <button data-bind=" click: $root.clickShowMenu.bind($data, 7)" class="collapsible"><b>VII. Nhóm tiện ích</b>
        <span data-bind="if: !$root.showGroup7()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup7()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div  data-bind="if: $root.showGroup7()" class="content">
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/qlhs/home'/>"></i>Tiện ích quản lý hồ sơ</a></li>
        <li class="reference-item"><span class="number-list"></span> <a href="<c:url value='/mt/qlgp/home'/>">Tiện ích quản lý giấy phép</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mt/qlpt/home'/>">Tiện ích quản lý phương tiện </a></li>
    </div>
    <button data-bind="click: $root.clickShowMenu.bind($data, 8)" class="collapsible"><b>VIII. Nhóm các thủ tục Bộ Nông nghiệp</b>
        <span data-bind="if: !$root.showGroup8()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup8()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup8()"  class="content">
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mard/12/home?maThuTuc=BNN&PTNT0200002'/>">Đề nghị kiểm tra giảm chất lượng thức ăn chăn nuôi có thời hạn</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mard/13/home?maThuTuc=BNN&PTNT0200003'/>">Đề nghị miễn kiểm tra chất lượng thức ăn chăn nuôi có thời hạn</a></li>
    </div>
    <button data-bind="click: $root.clickShowMenu.bind($data, 11)" class="collapsible"><b>IX. Nhóm các thủ tục Bộ Nông nghiệp Phase 3</b>
        <span data-bind="if: !$root.showGroup8()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup8()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup11()"  class="content">
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mard/01/home'/>">Cấp Giấy chứng nhận kiểm dịch động vật, sản phẩm động vật trên cạn xuất khẩu</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/'/>">Đăng ký kiểm dịch động vật, sản phẩm động vật trên cạn tạm nhập tái xuất, tạm xuất tái nhập, chuyển cửa khẩu, kho ngoại quan, quá cảnh lãnh thổ Việt Nam</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/'/>">Cấp Giấy chứng nhận kiểm dịch động vật, sản phẩm động vật trên cạn, tạm nhập tái xuất, tạm xuất tái nhập, chuyển cửa khẩu, quá cảnh lãnh thổ Việt Nam</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/'/>">Thủ tục Kiểm tra nhà nước về chất lượng thuốc thú y nhập khẩu</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/'/>">Thủ tục Cấp Giấy phép nhập khẩu thuốc thú y, nguyên liệu làm thuốc thú y</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mard/06/home'/>">Đăng ký kiểm dịch động vật, sản phẩm động vật thủy sản nhập khẩu</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mard/07/home'/>">Cấp giấy chứng nhận kiểm dịch động vật, sản phẩm động vật thủy sản nhập khẩu</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mard/08/home'/>">Đăng ký kiểm dịch động vật, sản phẩm động vật trên cạn nhập khẩu; đăng ký kiểm tra xác nhận chất lượng thức ăn chăn nuôi, thức ăn thủy sản có nguồn gốc động vật nhập khẩu</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/mard/09/home'/>">Cấp Giấy chứng nhận kiểm dịch động vật, sản phẩm động vật trên cạn nhập khẩu; kiểm tra xác nhận chất lượng thức ăn chăn nuôi, thức ăn thủy sản có nguồn gốc động vật nhập khẩu.</a></li>
    </div>
    <button data-bind="click: $root.clickShowMenu.bind($data, 9)" class="collapsible"><b>X. Nhóm các thủ tục Bộ Y Tế Phase 1</b>
        <span data-bind="if: !$root.showGroup9()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup9()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup9()"  class="content">
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
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/25/home?maThuTuc=BYTE0800012'/>">25-Cấp giấy phép xuất khẩu thuốc phóng xạ, thuốc độc, nguyên liệu độc làm thuốc, thuốc và dược chất trong danh mục thuốc, dược chất thuộc danh mục chất bị cấm sử dụng trong một số ngành, lĩnh vực cho mục đích thử lâm sàng, thử tương đương sinh học, đánh giá sinh khả dụng, làm mẫu kiểm nghiệm, nghiên cứu khoa học, làm mẫu đăng ký</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/36/home?maThuTuc=BYTE0800015'/>">36-Cấp giấy phép nhập khẩu thuốc dùng cho mục đích thử lâm sàng, thử tương đương sinh học, đánh giá sinh khả dụng tại Việt Nam, làm mẫu kiểm nghiệm, nghiên cứu khoa học</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/44/home?maThuTuc=BYTE0800022'/>">44-Cấp giấy phép nhập khẩu dược liệu không sử dụng làm mẫu kiểm nghiệm, nghiên cứu thuốc, tham gia trưng bày tại triển lãm, hội chợ, sản xuất thuốc xuất khẩu, sản xuất thuốc phục vụ yêu cầu quốc phòng, an ninh, phòng, chống dịch bệnh, khắc phục hậu quả thiên tai, thảm họa</a></li>
        
		<li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/11/home?maThuTuc=BYTE0400011'/>">Gia hạn số lưu hành đối với TTBYT thuộc loại B, C và D </a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/10/home?maThuTuc=BYTE0400010'/>">Cấp mới giấy phép nhập khẩu trang thiết bị y tế</a></li>
    </div>
    <button data-bind="click: $root.clickShowMenu.bind($data, 10)" class="collapsible"><b>XI. Nhóm các thủ tục Bộ Y Tế Phase 2</b>
        <span data-bind="if: !$root.showGroup10()"><span  class="glyphicon glyphicon-plus"></span></span>
        <span data-bind="if: $root.showGroup10()"><span  class="glyphicon glyphicon-minus"></span></span>
    </button>
    <div data-bind="if: $root.showGroup10()"  class="content">
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/01/home?maThuTuc=BYTE0600001'/>">01-Cấp giấy phép nhập khẩu chế phẩm diệt côn trùng, diệt khuẩn dùng trong lĩnh vực gia dụng và y tế nhập khẩu để nghiên cứu</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/01/home?maThuTuc=BYTE0600002'/>">02-Cấp giấy phép nhập khẩu chế phẩm diệt côn trùng, diệt khuẩn dùng trong lĩnh vực gia dụng và y tế nhập khẩu phục vụ mục đích viện trợ</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/01/home?maThuTuc=BYTE0600003'/>">03-Cấp giấy phép nhập khẩu chế phẩm diệt côn trùng, diệt khuẩn dùng trong lĩnh vực gia dụng và y tế nhập khẩu là quà biếu, cho, tặng</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/01/home?maThuTuc=BYTE0600004'/>">04-Cấp giấy phép nhập khẩu chế phẩm diệt côn trùng, diệt khuẩn dùng trong lĩnh vực gia dụng và y tế do trên thị trường không có sản phẩm và phương pháp sử dụng phù hợp</a></li>
		<li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/06/home'/>">Thủ tục công bố tiêu chuẩn áp dụng đối với trang thiết bị y tế thuộc loại A</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/07/home?maThuTuc=BYTE0400007'/>">07-Đề nghị cấp mới số lưu hành đối với TTBYT thuộc loại B,C và D</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/08/home?maThuTuc=BYTE0400009'/>">08-Cấp giấy phép lưu hành tự do(CFS) cho TTBYT</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/09/home?maThuTuc=BYTE0500009'/>">Kiểm tra nhà nước về an toàn thực phẩm đối với thực phẩm nhập khẩu theo phương thức kiểm tra thông thường</a></li>
        <li class="reference-item"> <span class="number-list"></span><a href="<c:url value='/moh/09/home?maThuTuc=BYTE0500010'/>">Kiểm tra nhà nước về an toàn thực phẩm đối với thực phẩm nhập khẩu theo phương thức kiểm tra chặt</a></li>
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
        self.showGroup2 = ko.observable(false);
        self.showGroup3 = ko.observable(false);
        self.showGroup4 = ko.observable(false);
        self.showGroup5 = ko.observable(false);
        self.showGroup6 = ko.observable(false);
        self.showGroup7 = ko.observable(false);
        self.showGroup8 = ko.observable(false);
        self.showGroup9 = ko.observable(false);
        self.showGroup10 = ko.observable(false);
        self.showGroup11 = ko.observable(false);

        self.clickShowMenu = function (groupPosition) {
            if (groupPosition == 1) {
                if (self.showGroup1() == true) {
                    self.showGroup1(false);
                } else {
                    self.showGroup1(true);
                }
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup10(false)
                self.showGroup11(false)
            } else if (groupPosition == 2) {
                if (self.showGroup2() == true) {
                    self.showGroup2(false);
                } else {
                    self.showGroup2(true);
                }
                self.showGroup1(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup10(false);
                self.showGroup11(false);
            } else if (groupPosition == 3) {
                if (self.showGroup3() == true) {
                    self.showGroup3(false);
                } else {
                    self.showGroup3(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup4(false);
                self.showGroup4(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup10(false);
                self.showGroup11(false);
            } else if (groupPosition == 4) {
                if (self.showGroup4() == true) {
                    self.showGroup4(false);
                } else {
                    self.showGroup4(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup5(false);

                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup10(false);
                self.showGroup11(false);
            } else if (groupPosition == 5) {
                if (self.showGroup5() == true) {
                    self.showGroup5(false);
                } else {
                    self.showGroup5(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup10(false);
                self.showGroup11(false);
            } else if (groupPosition == 6) {
                if (self.showGroup6() == true) {
                    self.showGroup6(false);
                } else {
                    self.showGroup6(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup10(false);
                self.showGroup11(false);
            } else if (groupPosition == 7) {
                if (self.showGroup7() == true) {
                    self.showGroup7(false);
                } else {
                    self.showGroup7(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup6(false);
                self.showGroup8(false);
                self.showGroup9(false);
            }else if (groupPosition == 8) {
                if (self.showGroup8() == true) {
                    self.showGroup8(false);
                } else {
                    self.showGroup8(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup9(false);
                self.showGroup10(false);
                self.showGroup11(false);
            }
            else if (groupPosition == 9) {
                if (self.showGroup9() == true) {
                    self.showGroup9(false);
                } else {
                    self.showGroup9(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup10(false);
                self.showGroup11(false);
            }
            else if (groupPosition == 10) {
                if (self.showGroup10() == true) {
                    self.showGroup10(false);
                } else {
                    self.showGroup10(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup11(false);
            }
            else if (groupPosition == 11) {
                if (self.showGroup11() == true) {
                    self.showGroup11(false);
                } else {
                    self.showGroup11(true);
                }
                self.showGroup1(false);
                self.showGroup2(false);
                self.showGroup3(false);
                self.showGroup4(false);
                self.showGroup5(false);
                self.showGroup6(false);
                self.showGroup7(false);
                self.showGroup8(false);
                self.showGroup9(false);
                self.showGroup10(false);
            }
        }
        self.qlhs = function (item) {
            location.href = app.appContext + '/mt/qlhs/home';
        }
        self.qlgp = function (item) {
            location.href = app.appContext + '/mt/qlgp/home';
        }
        self.qlpt = function (item) {
            location.href = app.appContext + '/mt/qlpt/home';
        }

    }
    var vm = new MenuViewModel();

    ko.applyBindings(vm, document.getElementById("groupMenu"));
</script>