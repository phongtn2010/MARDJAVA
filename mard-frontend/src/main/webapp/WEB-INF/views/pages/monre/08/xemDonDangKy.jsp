<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<form role="form" class="form-horizontal" id="monre08Form">
    <fieldset>
        <legend><spring:message code="monre.08.hoso.thongtinchung" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.danhsach.mahoso" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                    <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso"/>
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.danhsach.trangthai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                    <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.ngaytao" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao" disabled="true" data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaCoQuan" name="fiMaCoQuan" disabled="true" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', selectedText : fiTenCoQuan, value : fiMaCoQuan, options : lstDonViXuLy, optionsText : 'name'"></select>
                    <input type="hidden" id="fiTenCoQuan" name="fiTenCoQuan" data-bind="value : fiTenCoQuan"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiMaSoThue" name="fiMaSoThue" readonly="readonly" data-bind="value : fiMaSoThue" maxlength="13" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTruSoChinh" name="fiTruSoChinh" readonly="readonly" type="text" data-bind="value: fiTruSoChinh" maxlength="250"/>
                </div>  
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.common.nguoi.dai.dien" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNguoiDaiDien" name="fiNguoiDaiDien" readonly="readonly" type="text" data-bind="value: fiNguoiDaiDien" maxlength="250"/>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.dienthoai" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSdtDn" name="fiSdtDn" readonly="readonly" data-bind="value : fiSdtDn" type="text" maxlength="50"/>
                </div>

                <div class="col-md-2" style="text-align: right">
                    <spring:message code="monre.08.hoso.fax" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxDn" readonly="readonly" name="fiFaxDn" data-bind="value : fiFaxDn" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.email" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailDn" name="fiEmailDn" readonly="readonly" data-bind="value : fiEmailDn" type="text" maxlength="50"/>
                </div>

                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.sodkkd" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSoGcnDkkd" readonly="readonly" name="fiSoGcnDkkd" data-bind="value : fiSoGcnDkkd" type="text" maxlength="250"/>
                </div>
            </div>  
        </div>         
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.ngaycap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapGcnDkkd" disabled="true" name="fiNgaycapGcnDkkd" data-bind="datepicker : fiNgaycapGcnDkkd" type="text" data-date-format="dd/mm/yyyy" />
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.noicap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoicapGcnDkkd" name="fiNoicapGcnDkkd" readonly="readonly" data-bind="value : fiNoicapGcnDkkd" type="text" maxlength="250"/>
                </div>
            </div>  
        </div>        
    </fieldset>
    <fieldset>
        <legend><spring:message code="monre.08.hoso.thongtingxn" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.08.hoso.thongtingxn.sogxn" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoGxn" name="fiSoGxn" readonly="readonly" data-bind="value : fiSoGxn" type="text" maxlength="100"/>
                </div>

                <div class="col-md-2" style="text-align: right">
                    <spring:message code="monre.08.hoso.thongtingxn.ngaycap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapGxn" disabled="true" name="fiNgaycapGxn"  data-bind="datepicker : fiNgaycapGxn" type="text" data-date-format="dd/mm/yyyy" />
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <spring:message code="monre.08.hoso.thongtingxn.coquancap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiCoquancapGxn" readonly="readonly" name="fiCoquancapGxn" data-bind="value : fiCoquancapGxn" type="text" maxlength="250"/>
                </div>
            </div> 
        </div>         
    </fieldset> 
    
    <fieldset>
        <legend><spring:message code="monre.08.hoso.thongtinphelieu" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 50px;"><spring:message code="monre.08.hoso.thongtinphelieu.tt" /></th>
                            <th class="text-center"><spring:message code="monre.08.hoso.thongtinphelieu.tenphelieu" /></th>
                            <!--<th class="text-center" style="width: 210px;"><spring:message code="monre.08.hoso.thongtinphelieu.mahs" /></th>-->
                            <th class="text-center" style="width: 180px; text-align: right;"><spring:message code="monre.08.hoso.thongtinphelieu.khoiluog" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'tbdphelieuTmpl', foreach: lstPheLieu }">
                    </tbody>
                    <script id="tbdphelieuTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : stt">
                            </td>
                            <td data-bind="text : fiTenPhelieu">
                            </td>
                            <!--<td data-bind="text : fiMaHs"></td>-->
                            <td class="text-center" data-bind="text : fiKhoiLuong">
                            </td>
                        </tr>                      
                        </script>
                    </table>
                <span data-bind="text : errorPheLieuMessage" style="color:red;"> </span>    
            </div>
        </div>
    </fieldset>        
</form>

     