<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<input type="hidden" value="${ IS_SIGN_KEY }" id="kySo"/>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light " id="contentBody">
            <div class="panel-heading">
                <span class="caption-subject bold uppercase">Cấp Giấy phép liên vận Việt - Lào cho phương tiện thương mại</span>
            </div>

            <table class="table table-striped table-bordered table-hover table-checkable order-column"
                   id="sample_1">
                <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message
                            code="mt.header.order"></spring:message></th>
                    <th class="text-center">Số giấy phép</th>
                    <th class="text-center">Ngày cấp phép</th>
                    <th class="text-center">Biển số xe</th>
                    <th class="text-center">Trọng tải (ghế )</th>
                    <th class="text-center">Năm sản xuất</th>
                    <th class="text-center">Nhãn hiệu</th>
                    <th class="text-center">Số khung</th>
                    <th class="text-center">Số máy</th>
                    <th class="text-center">Màu sơn</th>
                    <th class="text-center">Trạng thái</th>
                    <th class="text-center">Xem giấy phép</th>
                </tr>
                </thead>
                <tbody id="list-container"
                       data-bind="foreach: { data: $root.danhsachgiayphep, as: 'item'}">
                <tr>
                    <td class="text-center"
                        data-bind="text:($root.pagingVM.currentPage()-1) * 10 + $index() + 1"></td>
                    <td class="text-center" data-bind="text: item&&item?item.fiSoGiayphep:''"></td>
                    <td class="text-center"
                        data-bind="text:item&&item.fiCappheptungay()?moment(item.fiCappheptungay()).format('DD/MM/YYYY'):''"></td>
                    <td class="text-center"
                        data-bind="text:  item?item.fiBienso:''"></td>
                    <td class="text-center"
                        data-bind="text: item?item.fiKhoihang:''"></td>
                    <td class="text-center"
                        data-bind="text: item?item.fiNamsanxuat:''"></td>
                    <td class="text-center" data-bind="text: item?item.fiTenNhanhieu:''"></td>
                    <td class="text-center" data-bind="text: item?item.fiSokhung:''"></td>
                    <td class="text-center" data-bind="text: item?item.fiSomay:''"></td>
                    <td class="text-center" data-bind="text: item?item.fiMausac:''"></td>
                    <td class="text-center" data-bind="text: $root.getTenTrangthai(item.fiTrangthai())"></td>
                    <td class="text-center"><a
                            href="javascript:;"
                            data-bind="click: $root.xemChiTietGiayPhep">
                        <i class="fa fa-eye"></i>
                    </a></td>

                </tr>
                </tbody>
                <tbody id="loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d">
                <tr>
                    <td style="height: 50px; position: relative; zoom: 1;" colspan="15"
                        id="td_c4e6a343-dd41-b5c5-1ef9-75eeebba032d">
                        <div class="blockUI" style="display: none"></div>
                        <div class="blockUI blockOverlay"
                             style="z-index: 1000; border: none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color: rgb(85, 85, 85); opacity: 0.1; cursor: wait; position: absolute;"></div>
                        <div class="blockUI blockMsg blockElement"
                             style="z-index: 1011; position: absolute; padding: 0px; margin: 0px; width: 30%; top: 4px; left: 528.5px; text-align: center; color: rgb(0, 0, 0); border: 0px; cursor: wait;">
                            <div class="loading-message ">
                                <img src="<c:url value="/static/assets/global/img/loading-spinner-grey.gif" />"
                                     align=""><span>&nbsp;&nbsp;LOADING...</span>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-12 nsw-text-right">
                    <div class="nsw-flr" data-bind="if: totalData() > 10">
                        <ul class="flip pull-left pagination pagination-sm">
                            <li data-bind="css: { disabled: !pagingVM.firstPageActive() }" class="previous disabled">
                                <a href="#" aria-label="First" data-bind="click: goToFirst">
                                    Trang đầu tiên
                                </a>
                            </li>
                            <li data-bind="css: { disabled: !pagingVM.previousPageActive()  }" class="previous disabled">
                                <a href="#" aria-label="Previous" data-bind="click: goToPrevious">
                                    Trang trước
                                </a>
                            </li>
                            <!-- ko foreach: $root.pagingVM.getPages() -->
                            <li data-bind="css: { active: $data == $root.pagingVM.currentPage() }">
                                <a href="#" data-bind="text: $data, click: $root.goToPage.bind($data)">

                                </a>
                            </li>
                            <!-- /ko -->
                            <li data-bind="css: { disabled: !pagingVM.nextPageActive() }" class="next">
                                <a href="#" aria-label="Next" data-bind="click: goToNext">
                                    Trang sau
                                </a>
                            </li>
                            <li data-bind="css: { disabled: !pagingVM.lastPageActive() }" class="next">
                                <a href="#" aria-label="Last" data-bind="click: goToLast">
                                    Trang cuối
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group nsw-text-center">
        <a href="javascript:;"
           data-bind="click: $root.dong" class="btn red bt-center btwidth" id="btDong"> <i
                class="fa fa-times" aria-hidden="true"></i></i>&nbsp;
            Đóng </a>
    </div>
</div>
<script type="text/javascript"
        src="<c:url value="/app/mt/qlgp/p05/license.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/qlgp/p05/model.js?v=${ version }"/>"
        charset="utf-8"></script>

<script>
    var giayPhepId = "${giayPhepId}";
</script>
<script>
    if(giayPhepId){
        var procedureId = '${procedureId}';
    }
</script>