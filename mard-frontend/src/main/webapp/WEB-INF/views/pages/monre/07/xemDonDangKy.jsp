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
<form role="form" class="form-horizontal" id="monre07Form">
    <fieldset>
        <legend><spring:message code="monre.07.hoso.thongtinchung" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.danhsach.mahoso" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                    <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso"/>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.danhsach.trangthai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                    <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.ngaytao" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao" disabled="true" data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaCqCap" name="fiMaCqCap" disabled="true" data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMa', selectedText : fiTenCqCap, value : fiMaCqCap, options : lstDonViXuLy, optionsText : 'fiTen'"></select>
                    <input type="hidden" id="fiTenCqCap" name="fiTenCqCap" data-bind="value : fiTenCqCap"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiDiachiTsc" name="fiDiachiTsc" readonly="readonly" type="text" data-bind="value: fiDiachiTsc" maxlength="250"/>
                </div>                
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.dienthoai" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSdtDn" name="fiSdtDn" readonly="readonly" data-bind="value : fiSdtDn" type="text" maxlength="50"/>
                </div>

                <div class="col-md-2">
                    <spring:message code="monre.07.hoso.fax" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxDn" readonly="readonly" name="fiFaxDn" data-bind="value : fiFaxDn" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.email" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailDn" name="fiEmailDn" readonly="readonly" data-bind="value : fiEmailDn" type="text" maxlength="50"/>
                </div>

                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.sodkkd" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSoDkkd" readonly="readonly" name="fiSoDkkd" data-bind="value : fiSoDkkd" type="text" maxlength="250"/>
                </div>
            </div>  
        </div>         
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.ngaycap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapDkkd" disabled="true" name="fiNgaycapDkkd" data-bind="datepicker : fiNgaycapDkkd" type="text" data-date-format="dd/mm/yyyy" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.noicap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoicapDkkd" name="fiNoicapDkkd" readonly="readonly" data-bind="value : fiNoicapDkkd" type="text" maxlength="250"/>
                </div>
            </div>  
        </div>        
    </fieldset>
    <fieldset>
        <legend><spring:message code="monre.07.hoso.thongtingxn" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.thongtingxn.sogxn" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoGxn" name="fiSoGxn" readonly="readonly" data-bind="value : fiSoGxn" type="text" maxlength="100"/>
                </div>

                <div class="col-md-2">
                    <spring:message code="monre.07.hoso.thongtingxn.ngaycap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapGxn" disabled="true" name="fiNgaycapGxn"  data-bind="datepicker : fiNgaycapGxn" type="text" data-date-format="dd/mm/yyyy" />
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <spring:message code="monre.07.hoso.thongtingxn.coquancap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiCqCapGxn" readonly="readonly" name="fiCqCapGxn" data-bind="value : fiCqCapGxn" type="text" maxlength="250"/>
                </div>
            </div> 
        </div>         
    </fieldset> 
    <fieldset>
        <legend>
            <spring:message code="monre.07.hoso.thongtincssx" />
        </legend>
        
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 50px;"><spring:message code="monre.07.hoso.thongtincssx.tt" /></th>
                            <th class="text-center"><spring:message code="monre.07.hoso.thongtincssx.tencssx" /></th>
                            <th class="text-center"><spring:message code="monre.07.hoso.thongtincssx.diachi" /></th>
                            <th class="text-center" style="width: 150px;"><spring:message code="monre.07.hoso.thongtincssx.chucnang" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'cssxTmpl', foreach: lstCosoSx }">
                    </tbody>
                    <script id="cssxTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : stt">
                            </td>
                            <td data-bind="text : fiTenCssx">
                            </td>
                            <td data-bind="text : fiDiachiCssx">
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0);"><i class="fa fa-search fa-lg" data-bind="click: $parent.bXemCoSoSxClick.bind($parent)" src="" alt=""/></a>
                            </td>
                        </tr>                      
                        </script>
                    </table>
                <span data-bind="text : errorCSSXMessage" style="color:red;"> </span>    
            </div>
        </div>
    </fieldset> 
    <fieldset>
        <legend><spring:message code="monre.07.hoso.thongtinphelieu" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 50px;"><spring:message code="monre.07.hoso.thongtinphelieu.tt" /></th>
                            <th class="text-center"><spring:message code="monre.07.hoso.thongtinphelieu.tenphelieu" /></th>
                            <th class="text-center" style="width: 210px;"><spring:message code="monre.07.hoso.thongtinphelieu.mahs" /></th>
                            <th class="text-center" style="width: 180px;"><spring:message code="monre.07.hoso.thongtinphelieu.khoiluog" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'tbdphelieuTmpl', foreach: lstPheLieu }">
                    </tbody>
                    <script id="tbdphelieuTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : stt">
                            </td>
                            <td data-bind="text : fiTenPl">
                            </td>
                            <td data-bind="text : fiMaHs">
                            </td>
                            <td class="text-center" data-bind="text : fiKhoiluong">
                            </td>
                        </tr>                      
                        </script>
                    </table>
                <span data-bind="text : errorPheLieuMessage" style="color:red;"> </span>    
            </div>
        </div>
    </fieldset>        
</form>
<template id="cssx-tmpl">
    <form role="form" class="form-horizontal" id="cssx-form">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.ten" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiTenCssx" name="fiTenCssx" type="text" readonly="readonly" data-bind="value: fiTenCssx, hasFocus: true" maxlength="250"/>
                </div>                
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.diachits" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiDiachiCssx" name="fiDiachiCssx" readonly="readonly" type="text" data-bind="value: fiDiachiCssx" maxlength="250"/>
                </div>                
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.dienthoai" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiSdtCssx" name="fiSdtCssx" readonly="readonly" data-bind="value : fiSdtCssx" maxlength="50" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.fax" /></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiFaxCssx" name="fiFaxCssx" readonly="readonly" data-bind="value : fiFaxCssx" maxlength="50" />
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.email" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailCssx" name="fiEmailCssx" readonly="readonly" data-bind="value : fiEmailCssx" type="text" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.tinh" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                       
                    <input class="form-control" id="fiTenTinh" name="fiTenTinh" readonly="readonly" data-bind="value : fiTenTinh" type="text" />
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.huyen" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenHuyen" name="fiTenHuyen" readonly="readonly" data-bind="value : fiTenHuyen" type="text" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.xa" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" id="fiTenXaphuong" name="fiTenXaphuong" readonly="readonly" data-bind="value : fiTenXaphuong" type="text" />
                </div>
            </div>  
        </div> 
    </form>
</template>
     