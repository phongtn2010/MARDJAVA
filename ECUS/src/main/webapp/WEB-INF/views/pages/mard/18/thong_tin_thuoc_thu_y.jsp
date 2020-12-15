<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
    .margin-icon{
        margin-top: 20px;
    }
</style>

<c:if test="${isView == false}">
    <div class="panel-heading" style="margin-left:-15px;margin-top:-15px;margin-right:-15px">

    <span class="caption-subject bold uppercase"><spring:message
            code="mard.18.form.thongTinThuoc"></spring:message> </span>

        <a
                title="<spring:message code="mard.16.TbdThuoc3.buttonThem" />" class="btn green bt-center"
                data-bind="click: $root.addHangHoa"> <i class="fa fa-plus ic-plus" aria-hidden="true"></i>
        </a>
    </div>
</c:if>
<div class="table-re" style="padding-top: 15px;">
    <table class="table table-striped table-bordered table-hover table-checkable order-column">
        <thead class="nsw-tr tr-nsw1-bgcolor">
        <th class="text-center" width="50px"><spring:message
                code="mard.18.TbdThuoc3.stt"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiProductType"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiNameOfGoods"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiCirculationNo"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiSerialNo"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiManufacturerName"></spring:message></th>
        <th class="text-center" width="100px"><spring:message
                code="mard.18.TbdThuoc18.fiCountryName"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiTypeOfPackage"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiWeightUnitName"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiWeight"></spring:message></th>

        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiWeightKG"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiWeightML"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiDocumentNo"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiGate"></spring:message></th>
        <th class="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiImportTime"></spring:message></th>
        <th class ="text-center" ><spring:message
                code="mard.18.TbdThuoc18.fiLicenseFileNo"></spring:message></th>
        <th class ="text-center" ><spring:message
                code="mard.18.TbdThuoc18.tepDinhKemThuoc"></spring:message></th>
        <th class="text-center" width="120px"><spring:message
                code="mard.14.TbdThuoc3.chucnang"></spring:message></th>

        </thead>
        <tbody data-bind="foreach: { data: $root.customPagination.pageData(), as: 'item' }">
        <tr>
            <td align="center" data-bind="text:  (($root.customPagination.currentPage() - 1) * 5 + $index() + 1)"></td>
            <td data-bind="foreach: { data: $root.fiProductTypes, as: 'item2' }">
                <!-- ko if: (item2.fiCode === item.fiProductType()) -->
                <span data-bind="text: item2.fiName"></span>
                <!-- /ko -->
            </td>
            <td data-bind="text: item.fiNameOfGoods()"></td>
            <td data-bind="text: item.fiCirculationNo()"></td>
            <td data-bind="text: item.fiSerialNo()"></td>
            <td data-bind="text: item.fiManufacturerName()"></td>
            <td data-bind="text: item.fiCountryName()"></td>
            <td data-bind="text: item.fiTypeOfPackage()"></td>
            <td data-bind="text: item.fiWeightUnitName()"></td>
            <td data-bind="text: item.fiWeight()"></td>
            <td data-bind="text: item.fiWeightKG()"></td>
            <td data-bind="text: item.fiWeightML()"></td>
            <td data-bind="text: item.fiDocumentNo()"></td>
            <td data-bind="text: item.fiGate()"></td>
            <td ><p data-bind="text: item.fiImportTimeFrom()"></p>&nbsp;-&nbsp;<p data-bind="text: item.fiImportTimeTo()"></p></td>
            <td data-bind="text: item.fiLicenseFileNo()"></td>
            <td>
                <div>
                    <c:if test="${isView == false}">
                        <a style="margin-bottom: 5px;"
                           title="<spring:message code="mard.18.TbdThuoc3.buttonSua" />"
                           data-bind="click: $root.editTepDinhKemThuoc"> <i style="color: #337ab7" class="fa fa-upload" aria-hidden="true"></i>
                        </a>
                    </c:if>
                    <a style="margin-bottom: 5px;"
                       title="<spring:message code="mard.18.TbdThuoc3.buttonXem" />"
                       data-bind="click: $root.viewTepDinhKemThuoc"> <i style="color: #337ab7" class="fa fa-eye margin-icon" aria-hidden="true"></i>
                    </a>
                </div>
            </td>
            <td align="center">
                <c:if test="${isView == false}">
                    <a style="margin-bottom: 5px;"
                       title="<spring:message code="mard.18.TbdThuoc3.buttonSua" />"
                       data-bind="click: $root.editHangHoa"> <i style="color: #337ab7" class="fa fa-edit" aria-hidden="true"></i>
                    </a>
                    &nbsp;&nbsp;&nbsp;
                    <a style="margin-bottom: 5px;"
                       title="<spring:message code="mard.18.TbdThuoc3.buttonXoa" />"
                       data-bind="click: $root.deleteHangHoa"> <i style="color: #337ab7" class="fa fa-trash-o" aria-hidden="true"></i>
                    </a>
                </c:if>
            </td>
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
<c:if test="${isView == false}">
    <div class="col-md-12">
        <label class="col-md-3"><spring:message code="mard.18.nhapFileExcel"/></label>
        <div class="col-md-9">
            <input id="fileUploadExcel" type="file" class="form-group form-control" data-bind=" event:{ change: $root.uploadFileChangeEvent }">
           <a style="font-style: italic;" href="<c:url value="/mard/api/18/downloadTemplate/excel" />" title="<spring:message code="mard.18.capNhatDuLieuTuFile"/>"><i class="fa fa-download" aria-hidden="true"></i>&nbsp;</span>&nbsp;<spring:message code="mard.18.capNhatDuLieuTuFile"/></a>

        </div>
    </div>

</c:if>
