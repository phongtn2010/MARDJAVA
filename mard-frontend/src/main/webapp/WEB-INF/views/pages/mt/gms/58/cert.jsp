<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.countrycode" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCountryCode" name="fiCountryCode" maxlength="255"  
                       type="text" data-bind="value : fiCountryCode" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.permitnumber" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiPermitNumber" name="fiPermitNumber" data-bind="value : fiPermitNumber" type="text" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.barcode" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBarCode" name="fiBarCode" maxlength="255"  
                       type="text" data-bind="value : fiBarCode" readonly="readonly"/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.signname" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenNgKy" name="fiTenNgKy" maxlength="255"  
                       type="text" data-bind="value : fiTenNgKy" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.signtile" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiChucDanh" name="fiChucDanh" data-bind="value : fiChucDanh" type="text" readonly/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.signplace" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiaDiem" name="fiDiaDiem" maxlength="255"  
                       type="text" data-bind="value : fiDiaDiem" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.signdate" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNgayky" name="fiNgayky" data-bind="value : fiNgayky" type="text" readonly/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.type" /></label>
            </div>
            <div class="col-md-10">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label> <input type="checkbox" disabled class="fiScheduledPassenger" name="fiScheduledPassenger"/><spring:message code="mt.58.giayphep.scheduledpassenger"/></label>
                        </div>
                        <div class="col-md-4">
                            <label> <input type="checkbox" disabled class="fiCargo" name="fiCargo"/><spring:message code="mt.58.giayphep.cargo"/></label>
                        </div>
                        <div class="col-md-4">
                            <label> <input type="checkbox" disabled class="fiNonscheduledPassenger" name="fiNonscheduledPassenger"/><spring:message code="mt.58.giayphep.nonscheduledpassenger"/></label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
    <label><b><spring:message code="mt.58.giayphep.issuingauthority"/></b></label></br>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.name1" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiIauthorityName" name="fiIauthorityName" maxlength="255"  
                       type="text" data-bind="value : fiIauthorityName" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.contactdata1" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiIauthorityContact" name="fiIauthorityContact" data-bind="value : fiIauthorityContact" type="text" readonly/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.address1" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiIauthorityAddress" name="fiIauthorityAddress" maxlength="255"  
                       type="text" data-bind="value : fiIauthorityAddress" readonly="readonly"/>
            </div>            
        </div>  
    </div>
    <label><b><spring:message code="mt.58.giayphep.beneficiaryofthepermit"/></b></label></br>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.name2" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBeneficiaryName" name="fiBeneficiaryName" maxlength="255"  
                       type="text" data-bind="value : fiBeneficiaryName" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.contactdata2" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiBeneficiaryContact" name="fiBeneficiaryContact" data-bind="value : fiBeneficiaryContact" type="text" readonly/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.address2" /></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" id="fiBeneficiaryAddress" name="fiBeneficiaryAddress" maxlength="255"  
                       type="text" data-bind="value : fiBeneficiaryAddress" readonly="readonly"/>
            </div>

        </div>  
    </div>
    <label><b><spring:message code="mt.58.giayphep.particularsforscheduledpassengertransportoperationsonly"/></b></label>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.ltinerary" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiIntinerary" name="fiIntinerary" maxlength="255"  
                       type="text" data-bind="value : fiIntinerary" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.maxiumcapacity" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiMaximumCapacity" name="fiMaximumCapacity" data-bind="value : fiMaximumCapacity" type="text" readonly/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.frequencyofoperationsforthebeneficiar" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiFrequencyOperations" name="fiFrequencyOperations" maxlength="255"  
                       type="text" data-bind="value : fiFrequencyOperations" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.otherrestrictions" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiOtherRestrictions" name="fiOtherRestrictions" data-bind="value : fiOtherRestrictions" type="text" readonly/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><b><spring:message code="mt.58.giayphep.periodofvalidityfrom" /></b></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiPeriodvalidityFrom" name="fiPeriodvalidityFrom" maxlength="255"  
                       type="text" data-bind="value : fiPeriodvalidityFrom" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="mt.58.giayphep.until" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiPeriodvalidityTo" name="fiPeriodvalidityTo" data-bind="value : fiPeriodvalidityTo" type="text" readonly/>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><b><spring:message code="mt.58.giayphep.allocatedvehicleregistrationnumber" /></b></label>
            </div>
            <div class="col-md-10">
                <div class="form-group">
                    <div class="col-md-12">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center"><spring:message code="mt.58.giayphep.Order" /></th>
                                    <th class="text-center"><spring:message code="mt.58.giayphep.VehicleType" /></th>
                                    <th class="text-center"><spring:message code="mt.58.giayphep.allocatedno" /></th>
                                </tr>
                            </thead>
                            <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: lsAllocatedNumber58 }">
                            </tbody>
                            <script id="itemTmpl" type="text/html">
                                <tr>
                                    <td class="text-center" style="padding: 8px">
                                        <input class="form-control" readonly name="fiOrder" data-bind="value : fiOrder"/>
                                    </td>
                                    <td>
                                        <input class="form-control" readonly name="fiVehicleType" data-bind="value : fiVehicleType"/>
                                    </td>
                                    <td>
                                        <input class="form-control" readonly name="fiAllocatedNo" data-bind="value : fiAllocatedNo"/>
                                    </td>
                                </tr>
                                </script>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>   
        <p class="content">
            <label><spring:message code="mt.58.giayphep.linkgiayphep" /></label>
        </p>
        <table class="tb-content tb-none-border w100p">
            <tbody data-bind="foreach: lstDinhKem">
                <tr>
                    <td class="left">
                        <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiUrl}"></a>
                    </td>            
                </tr>
            </tbody>
        </table>
        <p class="nsw-text-center">
            <a data-bind="click : $parent.btnXinSuaCVClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-edit"></i> Xin sửa Giấy phép</a>
            <a data-bind="click : $parent.btnTraLaiCVClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-arrow-down"></i> Trả lại Giấy phép</a>
        </p>
    </fieldset>