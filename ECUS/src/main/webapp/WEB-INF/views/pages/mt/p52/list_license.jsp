<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="incLanguage.jsp" %>

<div class="row">
    <div class="col-md-12">
        <div class="portlet light " id="contentBody">
            <div class="panel-heading">
				<span class="caption-subject bold uppercase">Danh sách Giấy
					phép liên vận CLV đối với phương tiện phi thương mại</span>
            </div>

            <table
                    class="table table-striped table-bordered table-hover table-checkable order-column"
                    id="sample_1">
                <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message
                            code="mt.header.order"></spring:message></th>
                    <th class="text-center" data-bind="visible : type == 1">Lịch sử giấy phép</th>
                    <th class="text-center">Số giấy phép</th>
                    <th class="text-center">Ngày cấp phép</th>
                    <th class="text-center">Biển số xe</th>
                    <th class="text-center">Năm sản xuất</th>
                    <th class="text-center">Nhãn hiệu</th>
                    <th class="text-center">Số khung</th>
                    <th class="text-center">Số máy</th>
                    <th class="text-center">Màu sơn</th>
                    <th class="text-center">Trạng thái</th>
                    <th class="text-center">Xem giấy phép</th>
                    <th class="text-center" data-bind="visible : type == 1">Chọn</th>
                </tr>
                </thead>
                <tbody id="list-container"
                       data-bind="foreach: { data: $root.danhsachgiayphep, as: 'item'}">
                <tr data-bind="css: {'selected':$root.hasItem(item)}">
                    <td class="text-center"
                        data-bind="text:($root.pagingVM.currentPage()-1) * 10 + $index() + 1"></td>
                    <td class="text-center" data-bind="visible : type == 1"><a href="javascript:;"
                                               data-bind="click: $root.xemLichSu"> <i
                            class="fa fa-lg fa-history tooltips"></i>
                    </a></td>
                    <td class="text-center"
                        data-bind="text: item&&item?item.fiSoGiayPhep:''"></td>
                    <td class="text-center"
                        data-bind="text:item&&item.fiNgayKy()?moment(item.fiNgayKy()).format('DD/MM/YYYY'):''"></td>
                    <td class="text-center" data-bind="text:item&&item?item.fiSoDangKy:''"></td>
                    <td class="text-center"
                        data-bind="text:item&&item?item.fiNamSanXuat:''"></td>
                    <td class="text-center"
                        data-bind="text: item?item.fiTenNhanHieu:''"></td>
                    <td class="text-center" data-bind="text: item?item.fiSoKhung:''"></td>
                    <td class="text-center" data-bind="text: item?item.fiSoMay:''"></td>
                    <td class="text-center" data-bind="text: item?item.fiMauSon:''"></td>
                    <td class="text-center"
                        data-bind="text: $root.getTenTrangthai(item.fiIdTrangThai())"></td>
                    <td class="text-center"><a href="javascript:;"
                                               data-bind="click: $root.xemChiTietGiayPhep"> <i
                            class="fa fa-eye"></i>
                    </a></td>
                    <td class="text-center" data-bind="visible : type == 1"><input type="checkbox"  data-bind="click: $root.selectItem, checked:  $root.hasItem(item)"/>
                    </td>
                </tr>
                </tbody>
                <tbody id="loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d">
                <tr>
                    <td style="height: 50px; position: relative; zoom: 1;"
                        colspan="15" id="td_c4e6a343-dd41-b5c5-1ef9-75eeebba032d">
                        <div class="blockUI" style="display: none"></div>
                        <div class="blockUI blockOverlay"
                             style="z-index: 1000; border: none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color: rgb(85, 85, 85); opacity: 0.1; cursor: wait; position: absolute;"></div>
                        <div class="blockUI blockMsg blockElement"
                             style="z-index: 1011; position: absolute; padding: 0px; margin: 0px; width: 30%; top: 4px; left: 528.5px; text-align: center; color: rgb(0, 0, 0); border: 0px; cursor: wait;">
                            <div class="loading-message ">
                                <img
                                        src="<c:url value="/static/assets/global/img/loading-spinner-grey.gif" />"
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
                            <li data-bind="css: { disabled: !pagingVM.firstPageActive() }"
                                class="previous disabled"><a href="#" aria-label="First"
                                                             data-bind="click: goToFirst"> <spring:message
                                    code="monre.01.trang-dau-tien"></spring:message>
                            </a></li>
                            <li
                                    data-bind="css: { disabled: !pagingVM.previousPageActive()  }"
                                    class="previous disabled"><a href="#" aria-label="Previous"
                                                                 data-bind="click: goToPrevious"> <spring:message
                                    code="monre.01.trang-truoc"></spring:message>
                            </a></li>
                            <!-- ko foreach: $root.pagingVM.getPages() -->
                            <li
                                    data-bind="css: { active: $data == $root.pagingVM.currentPage() }">
                                <a href="#"
                                   data-bind="text: $data, click: $root.goToPage.bind($data)"></a>
                            </li>
                            <!-- /ko -->
                            <li data-bind="css: { disabled: !pagingVM.nextPageActive() }"
                                class="next"><a href="#" aria-label="Next"
                                                data-bind="click: goToNext"> <spring:message
                                    code="monre.01.trang-sau"></spring:message>
                            </a></li>
                            <li data-bind="css: { disabled: !pagingVM.lastPageActive() }"
                                class="next"><a href="#" aria-label="Last"
                                                data-bind="click: goToLast"> <spring:message
                                    code="monre.01.trang-cuoi"></spring:message>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group nsw-text-center">
        <a class="btn green bt-center btwidth" id="btSua"
           data-bind="click: $root.suaGiayPhep,visible : type == 1"> <i class="fa fa-edit"  aria-hidden="true"></i> &nbsp; Xin sửa giấy phép
        </a> <a class="btn blue bt-center btwidth" id="btTra"
                data-bind="click: $root.traGiayPhep,visible : type == 1"> <i class="fa fa-undo"
                                                                             aria-hidden="true"></i></i>&nbsp; Trả lại
        giấy phép
    </a> <a href="javascript:;" data-bind="click: $root.dong"
            class="btn red bt-center btwidth" id="btDong"> <i
            class="fa fa-times" aria-hidden="true"></i></i>&nbsp; <spring:message
            code="common.button.dong"/>
    </a>
    </div>
</div>
<script>
    var giayPhepId = "${giayPhepId}";
</script>
<script>
    var procedureId = '${procedureId}';
</script>
<script>
    var type = "${type}";
</script>
<script type="text/javascript" src="<c:url value="/app/mt/p52/license.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p52/model.js?v=${ version }"/>" charset="utf-8"></script>
