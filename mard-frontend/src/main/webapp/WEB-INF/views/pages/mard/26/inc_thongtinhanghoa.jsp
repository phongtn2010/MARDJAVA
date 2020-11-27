<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br/><br/><span>Đề nghị miễn giảm kiểm tra có thời hạn chất lượng sản phẩm thức ăn chăn nuôi nhập khẩu sau đây</span><br/><br/>
<fieldset data-bind="with: form26VM">
    <legend><b>Danh sách hàng hóa</b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.stt"/></th>
                    <th class="text-center">Tên hàng hóa</th>
                    <th class="text-center">Mã hồ sơ TACN</th>
                    <th class="text-center">Mã số công nhận</th>
                    <th class="text-center">Hãng sản xuất</th>
                    <th class="text-center">Nước sản xuất</th>
                    <th class="text-center">Thành phần nguyên liệu</th>
                    <th class="text-center">Dạng màu sản phẩm</th>
                    <th class="text-center">Xóa</th>
                </tr>
                </thead>
                <tbody data-bind="foreach: lstHanghoa">
                <tr>
                    <td data-bind="text: ($index() + 1)"></td>
                    <td data-bind="text: fiProName"></td>
                    <td data-bind="text: fiNSWFileCode"></td>
                    <td data-bind="text: fiProCode"></td>
                    <td data-bind="text: fiProMadeIn"></td>
                    <td data-bind="text: fiProCountryName"></td>
                    <td data-bind="text: fiProThanhPhan"></td>
                    <td data-bind="text: fiProColor"></td>
                    <td class="text-center">
                        <a class="btn red bt-center" data-bind="click: $parent.removeProductClick"><i
                                class="fa fa-trash"></i> Xoá</a>
                    </td>
                </tr>

                </tbody>
            </table>
            <span data-bind="text : errorHangHoaMessage" style="color:red;"> </span>
            <br/>
            <a class="btn green bt-center" data-target="#modal_add_hanghoa"
               data-toggle="modal" data-bind="click: addProductOnClick"><i class="fa fa-add fa-lg"></i> Thêm sản
                phẩm</a>
        </div>
    </div>
</fieldset>

<div id="modal_add_hanghoa" class="modal container in modal-overflow" tabindex="-1"
     data-backdrop="static" data-keyboard="false"
     data-bind="with: form26VM"
     >
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>

    </div>
    <div class="modal-body" data-bind="with: hangHoa26VM">
        <div class="row">
            <div class="col-md-12">
                <form role="form" class="form-horizontal" id="thongtinhanghoa-form">
<%--                    <div class="row">--%>
<%--                        <div class="col col-md-6">--%>
<%--                            <spring:message code="common.tong"/> <b><a data-bind="text: totalCount"--%>
<%--                                                                       href="javascript:void(0);"></a>--%>
<%--                        </b><spring:message code="common.pager.ban_ghi"/>--%>
<%--                        </div>--%>
<%--                        <div class="col col-md-6 nsw-text-right">--%>
<%--                            <div class="nsw-flr">--%>
<%--                                <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">--%>
<%--                                    <li data-bind="css: { disabled: !firstPageActive() }">--%>
<%--                                        <a data-bind="click: goToFirst">Trang đầu</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !previousPageActive() }">--%>
<%--                                        <a data-bind="click: goToPrevious">Trang trước</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { active: $parent.currentPage === $data }">--%>
<%--                                        <a data-bind="click: $parent.goToPage, text: $data"></a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !nextPageActive() }">--%>
<%--                                        <a data-bind="click: goToNext">Trang sau</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !lastPageActive() }">--%>
<%--                                        <a data-bind="click: goToLast">Trang cuối</a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="row">--%>
<%--                        <div class="col col-md-6">--%>
<%--                            <!-- ko with: pagination -->--%>
<%--                            <spring:message code="common.tong"/> <b data-bind="text: totalCount()"></b> <spring:message--%>
<%--                                code="common.pager.ban_ghi"/>--%>
<%--                            <!-- /ko -->--%>
<%--                        </div>--%>
<%--                        <div class="col col-md-6 nsw-text-right">--%>
<%--                            <div class="nsw-flr">--%>
<%--                                <!-- ko with: pagination -->--%>
<%--                                <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">--%>
<%--                                    <li data-bind="css: { disabled: !firstPageActive() }">--%>
<%--                                        <a data-bind="click: goToFirst">Trang đầu</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !previousPageActive() }">--%>
<%--                                        <a data-bind="click: goToPrevious">Trang trước</a>--%>
<%--                                    </li>--%>
<%--                                    <!-- ko foreach: getPages() -->--%>
<%--                                    <li data-bind="css: { active: $parent.currentPage() === $data }">--%>
<%--                                        <a data-bind="click: $parent.goToPage, text: $data"></a>--%>
<%--                                    </li>--%>
<%--                                    <!-- /ko -->--%>
<%--                                    <li data-bind="css: { disabled: !nextPageActive() }">--%>
<%--                                        <a data-bind="click: goToNext">Trang sau</a>--%>
<%--                                    </li>--%>
<%--                                    <li data-bind="css: { disabled: !lastPageActive() }">--%>
<%--                                        <a data-bind="click: goToLast">Trang cuối</a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                                <!-- /ko -->--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <label>Được phép chọn 1 hàng hóa trong danh sách hàng hóa được tính miễn giảm kiểm tra</label>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center">STT</th>
                            <th class="text-center">Tên hàng hóa</th>
                            <th class="text-center">Mã hồ sơ TACN</th>
                            <th class="text-center">Mã số công nhận</th>
                            <th class="text-center">Hãng sản xuất</th>
                            <th class="text-center">Nước sản xuất</th>
                            <th class="text-center">Thành phần nguyên liệu</th>
                            <th class="text-center">Dạng màu sản phẩm</th>
                            <th class="text-center">Thao tác</th>
                        </tr>
                        </thead>
                        <tbody data-bind="foreach: lstProductList">
                        <tr>
                            <td data-bind="text: ($index() + 1)"></td>
                            <td data-bind="text: fiProName"></td>
                            <td data-bind="text: fiNSWFileCode"></td>
                            <td data-bind="text: fiSoGCN"></td>
                            <td data-bind="text: fiProMadeIn"></td>
                            <td data-bind="text: fiProCountryName"></td>
                            <td data-bind="text: fiProThanhPhan"></td>
                            <td data-bind="text: fiProColor"></td>
                            <td class="text-center">
                                <a data-bind="text: label,click: $parent.onChoose"><i class="fa fa-check-circle-o"></i></a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
        <div class="text-center">
            <span class="nsw-require-field" data-bind="text: errorMsg"></span>
        </div>
    </div>
    <div class="modal-footer" style="" >
        <div class="text-center">
            <button class="btn green" data-bind="click: addHangHoa">
                <spring:message code="conmon.button.them"/>
            </button>
            <button class="btn" data-bind="click: closePopup">
                <spring:message code="conmon.button.huy"/>
            </button>
        </div>
    </div>
</div>

