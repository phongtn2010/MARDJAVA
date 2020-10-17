<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:if test="${isView == false}">
<div class="panel-heading" style="margin-left:-15px;margin-top:-15px;margin-right:-15px">
        <span class="caption-subject bold uppercase"><spring:message
                                                        code="mard.16.form.toKhaiKyThuat"></spring:message> </span>
        <a
           title="<spring:message code="mard.16.TbdThuoc3.buttonThem" />" class="btn green bt-center"
           data-bind="click: $root.addHangHoa"> <i class="fa fa-plus ic-plus" aria-hidden="true"></i>
        </a>
    </div>
</c:if>
<div class="table-re" style="padding-top: 15px;">
    <table class="table table-striped table-bordered table-hover table-checkable order-column small-table">
        <thead class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center"><spring:message code="mard.16.TbdThuoc3.stt"></spring:message></th>
        <th class="text-center"><spring:message
                code="TbdToKhaiKyThuat16_fiNameOfGoodsDeclaration"></spring:message></th>
        <th class="text-center"><spring:message
                code="TbdToKhaiKyThuat16_fiNameSicenceOfGoodsDeclaration"></spring:message></th>
        <th class="text-center"><spring:message code="TbdToKhaiKyThuat16_fiPartUsed"></s pring:message></th>
        <th class="text-center"><spring:message code="TbdToKhaiKyThuat16_fiUsingValue"></spring:message></th>
        <th class="text-center"><spring:message code="TbdToKhaiKyThuat16_fiRequiredEcological"></spring:message></th>
        <th class="text-center"><spring:message code="TbdToKhaiKyThuat16_fiPlantingSeason"></spring:message></th>
        <th class="text-center"><spring:message code="TbdToKhaiKyThuat16_fiDensity"></spring:message></th>
        <th class="text-center"><spring:message code="TbdToKhaiKyThuat16_fiMainDiseases"></spring:message></th>
        <th class="text-center"><spring:message code="TbdToKhaiKyThuat16_fiWarnings"></spring:message></th>
        <th class="text-center" width="120px"><spring:message
                code="mard.16.TbdThuoc3.chucnang"></spring:message></th>
        </thead>
        <tbody data-bind="foreach: { data: $root.customPagination.pageData(), as: 'item' }">
        <tr>
            <td align="center" data-bind="text:  (($root.customPagination.currentPage() - 1) * 5 + $index() + 1)"></td>
            <td  data-bind="text:  item.fiNameOfGoodsDeclaration"></td>
            <td  data-bind="text:  item.fiNameSicenceOfGoodsDeclaration"></td>
            <td  data-bind="foreach: { data: $root.tbsBoPhan16s, as: 'item2' }">
                <!-- ko if: item.fiPartUsed() != undefined && item.fiPartUsed() != null && item.fiPartUsed().split(';').includes(item2.fiCode()) -->
                <span data-bind="text: item2.fiName"></span>&nbsp;<b>;</b>
                <!-- /ko -->
            </td>
            <td  data-bind="foreach: { data: $root.tbsGiaTriSuDung16s, as: 'item2' }">
                <!-- ko if: item.fiUsingValue() != undefined && item.fiUsingValue() != null && item.fiUsingValue().split(';').includes(item2.fiCode()) -->
                <span data-bind="text: item2.fiName"></span>&nbsp;<b>;</b>&nbsp;
                <!-- /ko -->
            </td>
            <td  data-bind="text:  item.fiRequiredEcological()"></td>
            <td data-bind="text:  item.fiPlantingSeason()"></td>
            <td  data-bind="text:  item.fiDensity()"></td>
            <td  data-bind="text:  item.fiMainDiseases()"></td>
            <td  data-bind="text:  item.fiWarnings()"></td>
            <td align="center">
                <c:if test="${isView == false}">
                    <a style="margin-bottom: 5px;"
                       title="<spring:message code="mard.16.TbdThuoc3.buttonSua" />"
                       data-bind="click: $root.editHangHoa"> <i style="color: #337ab7" class="fa fa-edit"
                                                                aria-hidden="true"></i>
                    </a>&nbsp;&nbsp;&nbsp;
                    <a style="margin-bottom: 5px;"
                       title="<spring:message code="mard.16.TbdThuoc3.buttonXoa" />"
                       data-bind="click: $root.deleteHangHoa"> <i style="color: #337ab7" class="fa fa-trash-o"
                                                                  aria-hidden="true"></i>
                    </a>
                </c:if>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="col-md-12">
        <div class="nsw-flr" data-bind="if: $root.customPagination.totalPage() > 1">
            <ul class="flip pull-left pagination pagination-sm">
                <!-- ko foreach: $root.customPagination.pageChilds() -->
                <li data-bind="css: { active: $data == $root.customPagination.currentPage() }">
                    <a href="#"
                       data-bind="text: $data, click: $root.customPagination.goToPage.bind($data)"></a>
                </li>
                <!-- /ko -->
            </ul>
        </div>
    </div>
</div>
