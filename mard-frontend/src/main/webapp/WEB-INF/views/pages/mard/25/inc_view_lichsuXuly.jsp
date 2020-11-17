
<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 11/14/19
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div id="modal_lichsuXuly" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
         data-bind="with: lichsuXuly"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Lịch sử hồ sơ: <span data-bind="text: fiHSCode"></span></b>
        </div>
        <div class="modal-body">
            <div class="tab-content" id="pageView">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                    <tr>
                        <th class="text-center" width="5%"><spring:message code="mard.xemgiayphep.stt" /></th>
                        <th class="text-center" width="15%">Đơn vị</th>
                        <th class="text-center" width="15%">Người xử lý</th>
                        <th class="text-center" width="15%">Ngày xử lý</th>
                        <th class="text-center" width="40%">Nội dung</th>
                        <th class="text-center" width="15%">File đính kèm</th>
                        <th class="text-center" width="10%">Trạng thái</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach: historyItems">
                    <tr>
                        <td data-bind="text: ($parent.historyPageingVM.currentPage() - 1)* $parent.historyPageingVM.pageSize() + $index() + 1"></td>
                        <td data-bind="text: fiSenderUnitName"></td>
                        <td data-bind="text: fiSenderName"></td>
                        <td data-bind="datetime: fiCreatedDate"></td>
                        <td data-bind="html: fiContent"></td>
                        <td></td>
                        <td data-bind="text: $root.getProfileStatus(fiStatus())"></td>
                    </tr>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-md-12 nsw-text-right">
                        <div class="nsw-flr" data-bind="if: historyPageingVM.totalCount() > historyPageingVM.pageSize()">
                            <ul class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !historyPageingVM.firstPageActive() }" class="previous disabled"><a href="#" aria-label="First" data-bind="click: goToFirst">Trang đầu
                                </a></li>
                                <li data-bind="css: { disabled: !historyPageingVM.previousPageActive()  }" class="previous disabled"><a href="#" aria-label="Previous" data-bind="click: goToPrevious">Trang trước
                                </a></li>
                                <!-- ko foreach: historyPageingVM.getPages() -->
                                <li data-bind="css: { active: $data == $parent.historyPageingVM.currentPage() }"><a href="#" data-bind="text: $data, click: $parent.goToPage.bind($data)"></a></li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !historyPageingVM.nextPageActive() }" class="next"><a href="#" aria-label="Next" data-bind="click: goToNext">Trang sau
                                </a></li>
                                <li data-bind="css: { disabled: !historyPageingVM.lastPageActive() }" class="next"><a href="#" aria-label="Last" data-bind="click: goToLast">Trang cuối
                                </a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

