<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--17-->
<fieldset style="display: none" id="regis17">
    <!--<fieldset style="display: none">-->
    <div data-bind="with : banKhai17()">
        <legend style="color: dodgerblue;">
            <b><spring:message code="mard.02.hoso.thongtinhanghoa"/></b>
        </legend>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa17.stt"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa17.tenhang"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa17.soluong"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa17.donvitinh"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa17.xuatxu"/></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa17">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">

                </td>
                <td>
                    <input class="form-control" id="goodName" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : goodName" disabled readonly/>
                </td>
                <td>
                    <input class="form-control" id="quantily" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : quantily, event: {change: $parent.countSoluongHH.bind($parent)}" disabled readonly/>
                </td>
                <td>
                    <select class="form-control select2 quantityUnitCode" data-bind="
                                                                        value: quantityUnitCode,
                                                                        selectedText2 : quantityUnitName,
                                                                        attr: {'id': 'quantityUnitCode-' + goodSort()},
                                                                        optionsCaption: 'Chọn...',
                                                                        optionsValue : 'id',
                                                                        optionsText : 'name',
                                                                        options : $parent.lstDvTinh()" disabled readonly></select>
                </td>
                <td>
                    <input class="form-control" id="exporterState" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : exporterState" disabled readonly/>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.hinhthuc"/></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="registrationType" name="registrationType"
                            data-bind="optionsCaption: 'Chọn...', optionsValue : 'id'
                            , selectedText2 : testMethod
                            , value : testMethod
                            , options : $parent.lstHinhThucKT
                            , optionsText : 'name'" readonly disabled></select>
                </div>
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.tongsoluong"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="totalQuantity17" name="totalQuantity17" maxlength="250"
                           type="text" data-bind="value : totalQuantity" readonly disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.cuakhaunhap"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="importGate17" name="importGate17" maxlength="250"
                           type="text" data-bind="value : importGate" readonly disabled/>
                </div>
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.cuakhauxuat"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="exportGate17" name="exportGate17" maxlength="250"
                           type="text" data-bind="value : exportGate" readonly disabled/>
                </div>
            </div>
        </div>
        <legend style="color: dodgerblue;">
            <b><spring:message code="mard.02.hoso.tuCty17"/></b>
        </legend>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.stt"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.tuCty17.tencty"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.tuCty17.diachi"/></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: ctyTu17">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">

                </td>
                <td>
                    <input class="form-control" id="fromCompanyName17" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : fromCompanyName" disabled readonly/>
                </td>
                <td>
                    <input class="form-control" id="fromCompanyAddress17"
                           onblur="this.value = removeSpaces(this.value);" data-bind="value : fromCompanyAddress" disabled readonly/>
                </td>
            </tr>
            </tbody>
        </table>
        <%--        <div data-bind="with : ctyTu17">--%>
        <%--            <div class="form-group" style="margin-top: 15px;">--%>
        <%--                <div class="col-md-12">--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.tuCty17.tencty" /><a class="nsw-require-field">*</a></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="fromCompanyName17" name="fromCompanyName17" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : fromCompanyName" />--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.tuCty17.diachi" /><a class="nsw-require-field">*</a></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="fromCompanyAddress17" name="fromCompanyAddress17" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : fromCompanyAddress" />--%>
        <%--                    </div>--%>
        <%--                </div>  --%>
        <%--            </div>--%>
        <%--        </div>--%>
        <legend style="color: dodgerblue;">
            <b><spring:message code="mard.02.hoso.CtyTiepNhan17"/></b>
        </legend>

        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.stt"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.tuCty17.tencty"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.tuCty17.diachi"/></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: ctyDen17">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">

                </td>
                <td>
                    <input class="form-control" id="toCompanyName17" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : toCompanyName" disabled readonly/>
                </td>
                <td>
                    <input class="form-control" id="toCompanyAddress17" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : toCompanyAddress" disabled readonly/>
                </td>
            </tr>
            </tbody>
        </table>

        <%--        <div data-bind="with : ctyDen17">--%>
        <%--            <div class="form-group" style="margin-top: 15px;">--%>
        <%--                <div class="col-md-12">--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.CtyTiepNhan17.tencty" /></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="toCompanyName17" name="toCompanyName17" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : toCompanyName" />--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.CtyTiepNhan17.diachi" /></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="toCompanyAddress17" name="toCompanyAddress17" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : toCompanyAddress" />--%>
        <%--                    </div>--%>
        <%--                </div>  --%>
        <%--            </div>--%>
        <%--        </div>--%>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.thoigianTH"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="executionTime17" name="executionTime17" maxlength="250"
                           type="text" data-bind="value : executionTime" readonly disabled/>
                </div>
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.thoigianluu"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="stayTime17" name="stayTime17" maxlength="250"
                           type="text" data-bind="value : stayTime" readonly disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.lotrinh"/></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="route" name="route" maxlength="250"
                           type="text" data-bind="value : route" readonly disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan17.giaytoLQ"/></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="attachedDoc" name="attachedDoc" maxlength="250"
                           type="text" data-bind="value : attachedDoc" disabled readonly/>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<!--end 17-->

<!--18-->
<fieldset id="regis18" style="display: none">
    <div data-bind="with : banKhai18()">
        <legend style="color: dodgerblue">
            <b><spring:message code="mard.02.hoso.thongtinhanghoa"/></b>
        </legend>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.stt"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.tenhang"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.soluong"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.donvitinh"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.xuatxu"/></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstHangHoa18">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">

                </td>
                <td>
                    <input class="form-control" id="goodName18" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : goodName" disabled readonly/>
                </td>
                <td>
                    <input class="form-control" id="quantily18" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : quantily, event: {change: $parent.countSoluongHH18.bind($parent)}" disabled readonly/>
                </td>
                <td>
                    <select class="form-control select2 quantityUnitCode" data-bind="
                                                                        value: quantityUnitCode,
                                                                        selectedText2 : quantityUnitName,
                                                                        attr: {'id': 'quantityUnitCode-' + goodSort()},
                                                                        optionsCaption: 'Chọn...',
                                                                        optionsValue : 'id',
                                                                        optionsText : 'name',
                                                                        options : $parent.lstDvTinh()" disabled readonly></select>
                </td>
                <td>
                    <input class="form-control" id="exporterState18" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : exporterState" disabled readonly/>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan18.cuakhaunhap"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="importGate18" name="importGate18" maxlength="250"
                           type="text" data-bind="value : importGate" disabled readonly/>
                </div>
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan18.tongsoluong"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="totalQuantity18" name="totalQuantity18" maxlength="250"
                           type="text" data-bind="value : totalQuantity" disabled readonly/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan18.cuakhauxuat"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="exportGate18" name="exportGate18" maxlength="250"
                           type="text" data-bind="value : exportGate" disabled readonly/>
                </div>
            </div>
        </div>
        <legend style="color: dodgerblue;">
            <b><spring:message code="mard.02.hoso.tuCty18"/></b>
        </legend>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.stt"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.tuCty18.tencty"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.tuCty18.diachi"/></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: ctyTu18">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">

                </td>
                <td>
                    <input class="form-control" id="fromCompanyName18" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : fromCompanyName" disabled readonly/>
                </td>
                <td>
                    <input class="form-control" id="fromCompanyAddress" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : fromCompanyAddress" disabled readonly/>
                </td>
            </tr>
            </tbody>
        </table>
        <%--        <div data-bind="with: ctyTu18">--%>
        <%--            <div class="form-group" style="margin-top: 15px;">--%>
        <%--                <div class="col-md-12">--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.tuCty17.tencty" /></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="fromCompanyName18" name="fromCompanyName18" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : fromCompanyName" />--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.tuCty17.diachi" /></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="fromCompanyAddress18" name="fromCompanyAddress18" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : fromCompanyAddress" />--%>
        <%--                    </div>--%>
        <%--                </div>  --%>
        <%--            </div>--%>
        <%--        </div>--%>
        <legend style="color: dodgerblue;">
            <b><spring:message code="mard.02.hoso.khoNgoai18"/>
            </b>
        </legend>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.stt"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.tenDiachi"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.GPso"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.ngaycap"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.thoihan"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.soHD"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.ngayHD"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.khoNgoai18.THhopDong"/></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: lstNgoaiQuan18">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">
                </td>
                <td>
                    <input class="form-control" id="bondedName" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : bondedName" disabled readonly/>
                </td>
                <td>
                    <input class="form-control" id="certificateNo" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : certificateNo" disabled readonly/>
                </td>
                <td>
                    <input class="form-control date-picker text-center" placeholder="dd/mm/yyyy" name="certificateDate"
                           data-bind="datepicker : certificateDate" type="text" data-date-format="dd/mm/yyyy" readonly disabled
                           />
                </td>
                <td>
                    <input class="form-control date-picker text-center" placeholder="dd/mm/yyyy"
                           name="certificateDateValid" data-bind="datepicker : certificateDateValid" type="text"
                           data-date-format="dd/mm/yyyy" readonly disabled/>
                </td>
                <td>
                    <input class="form-control" id="contractNo" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : contractNo" disabled readonly/>
                </td>
                <td>
                    <input class="form-control date-picker text-center" placeholder="dd/mm/yyyy" name="contractDate"
                           data-bind="datepicker : contractDate" type="text" data-date-format="dd/mm/yyyy" readonly
                           disabled/>
                </td>
                <td>
                    <input class="form-control date-picker text-center" placeholder="dd/mm/yyyy"
                           name="contractDateValid" data-bind="datepicker : contractDateValid" type="text"
                           data-date-format="dd/mm/yyyy" readonly disabled=""/>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan18.thoigianTH"/></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="executionTime18" name="executionTime18" maxlength="250"
                           type="text" data-bind="value : executionTime" disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.khoNgoai18.purpose"/></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="purpose" name="purpose" maxlength="500"
                           type="text" data-bind="value : purpose" disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-left">
                    <label><spring:message code="mard.02.hoso.CtyTiepNhan18.giaytoLQ"/></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="attachedDoc18" name="attachedDoc18" maxlength="250"
                           type="text" data-bind="value : attachedDoc" disabled/>
                </div>
            </div>
        </div>

        <legend style="color: dodgerblue;">
            <b><spring:message code="mard.02.hoso.CtyTiepNhan18"/></b>
        </legend>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="mard.02.hoso.thongtinhanghoa18.stt"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.CtyTiepNhan18.tencty"/></th>
                <th class="text-center"><spring:message code="mard.02.hoso.CtyTiepNhan18.diachi"/></th>
            </tr>
            </thead>
            <tbody data-bind="foreach: ctyDen18">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">

                </td>
                <td>
                    <input class="form-control" id="toCompanyName" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : toCompanyName" disabled/>
                </td>
                <td>
                    <input class="form-control" id="toCompanyAddress" onblur="this.value = removeSpaces(this.value);"
                           data-bind="value : toCompanyAddress" disabled/>
                </td>
            </tr>
            </tbody>
        </table>
        <%--        <div data-bind="with : ctyDen18">--%>
        <%--            <div class="form-group" style="margin-top: 15px;">--%>
        <%--                <div class="col-md-12">--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.CtyTiepNhan18.tencty" /></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="toCompanyName17" name="toCompanyName17" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : toCompanyName" />--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-2 nsw-text-left">--%>
        <%--                        <label><spring:message code="mard.02.hoso.CtyTiepNhan18.diachi" /></label>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-md-4">--%>
        <%--                        <input class="form-control" id="toCompanyAddress17" name="toCompanyAddress17" maxlength="250"  --%>
        <%--                               type="text" data-bind="value : toCompanyAddress" />--%>
        <%--                    </div>--%>
        <%--                </div>  --%>
        <%--            </div>--%>
        <%--        </div>--%>

        <!--        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center"><spring:message code="mard.02.hoso.CtyTiepNhan18.stt" /></th>
                    <th class="text-center"><spring:message code="mard.02.hoso.CtyTiepNhan18.tencty" /></th>
                    <th class="text-center"><spring:message code="mard.02.hoso.CtyTiepNhan18.diachi" /></th>
                    <th class="text-center"><spring:message code="mard.02.hoso.CtyTiepNhan18.chucnang" /></th>
                </tr>
            </thead>
            <tbody data-bind="foreach: ctyDen18">
                <tr>
                    <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">
                    </td>  
                    <td style="width: 150px;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : toCompanyName">
                    </td>
                    <td style="width: 150px;word-wrap: break-word;max-width: 150px !important;vertical-align: middle;" data-bind="text : toCompanyAddress">
                    </td>
                    <td style="width: 220px;vertical-align: middle;" class="text-center">                            
                        <a class="btn green bt-center" data-bind="click:  $parent.editPopupHH.bind($parent)"><i class="fa fa-eye"></i> Sửa</a>
                        <a class="btn red bt-center" data-bind="click: $parent.removePopupHH.bind($parent)"><i class="fa fa-trash"></i> Xóa</a>
                    </td>
                </tr>
            </tbody>
        </table>-->

</fieldset>
<!--end 18-->
