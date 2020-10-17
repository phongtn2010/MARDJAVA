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
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaCqCap" name="fiMaCqCap" data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMa', selectedText : fiTenCqCap, value : fiMaCqCap, options : lstDonViXuLy, optionsText : 'fiTen'"></select>
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
                    <input class="form-control" id="fiSdtDn" name="fiSdtDn" data-bind="value : fiSdtDn" type="text" maxlength="50"/>
                </div>

                <div class="col-md-2">
                    <spring:message code="monre.07.hoso.fax" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxDn" name="fiFaxDn" data-bind="value : fiFaxDn" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.email" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailDn" name="fiEmailDn" data-bind="value : fiEmailDn" type="text" maxlength="50"/>
                </div>

                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.sodkkd" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSoDkkd" name="fiSoDkkd" data-bind="value : fiSoDkkd" type="text" maxlength="250"/>
                </div>
            </div>  
        </div>         
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.ngaycap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapDkkd" name="fiNgaycapDkkd" data-bind="datepicker : fiNgaycapDkkd" type="text" data-date-format="dd/mm/yyyy" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.noicap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoicapDkkd" name="fiNoicapDkkd" data-bind="value : fiNoicapDkkd" type="text" maxlength="250"/>
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
                    <input class="form-control" id="fiSoGxn" name="fiSoGxn" data-bind="value : fiSoGxn" type="text" maxlength="100"/>
                </div>

                <div class="col-md-2">
                    <spring:message code="monre.07.hoso.thongtingxn.ngaycap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapGxn" name="fiNgaycapGxn"  data-bind="datepicker : fiNgaycapGxn" type="text" data-date-format="dd/mm/yyyy" />
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <spring:message code="monre.07.hoso.thongtingxn.coquancap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiCqCapGxn" name="fiCqCapGxn" data-bind="value : fiCqCapGxn" type="text" maxlength="250"/>
                </div>
            </div> 
        </div>         
    </fieldset> 
    <fieldset>
        <legend>
            <spring:message code="monre.07.hoso.thongtincssx" />
            <a href="javascript:void(0);" class="btn green" data-bind="event: {click: bThemCoSoSxClick}"><i class="fa fa-search-plus"></i>Thêm</a>
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
                                <a href="javascript:void(0);"><i class="fa fa-trash fa-lg" data-bind="click: $parent.bXoaCoSoSxClick.bind($parent)" src="" alt=""/></a>
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
                            <th class="text-center" style="width: 200px;"><spring:message code="monre.07.hoso.thongtinphelieu.chucnang" /></th>
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
                            <td data-bind="text : fiKhoiluong">
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0);"><i class="fa fa-lg fa-edit" data-bind="click: $parent.bSuaPhelieuClick.bind($parent)" src="" alt=""/></a>
                                <a href="javascript:void(0);"><i class="fa fa-lg fa-trash" data-bind="click: $parent.bXoaPhelieuClick.bind($parent)" src="" alt=""/></a>
                            </td>
                        </tr>                      
                        </script>
                        <tfoot>
                            <tr>
                                <td>

                                </td>
                                <td>
                                    <input class="form-control" id="fiTenPl" name="fiTenPl" data-bind="value : fiTenPl" maxlength="250"></input>
                                </td>
                                <td style="width: 210px;">
                                    <input class="form-control" id="fiMaHs" name="fiMaHs" data-bind="value : fiMaHs" type="text" maxlength="250">
                                </td>
                                <td style="width: 180px;">
                                    <input class="form-control" id="fiKhoiluong" name="fiKhoiluong" data-bind="value : fiKhoiluong" style="text-align: center;"></input>
                                </td>
                                <td style="width: 200px;">
                                    <a href="javascript:void(0);" class="btn blue" data-bind="event: {click: btnThemPhelieuClick}"><i class="fa fa-save"></i> Lưu</a>
                                    <a href="javascript:void(0);" class="btn blue" data-bind="event: {click: bResetClick}"><i class="fa fa-recycle"></i> Nhập lại</a>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                <span data-bind="text : errorPheLieuMessage" style="color:red;"> </span>    
            </div>
        </div>
    </fieldset>        
</form>
<template id="cssx-tmpl">
    <form role="form" class="form-horizontal" id="cssx-form">
        <p> <b><spring:message code="monre.07.hoso.cssx" /></b></p>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.ten" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiTenCssx" name="fiTenCssx" type="text" data-bind="value: fiTenCssx, hasFocus: true" maxlength="250"/>
                </div>                
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.diachits" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiDiachiCssx" name="fiDiachiCssx" type="text" data-bind="value: fiDiachiCssx" maxlength="250"/>
                </div>                
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.dienthoai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiSdtCssx" name="fiSdtCssx" data-bind="value : fiSdtCssx" maxlength="50" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.fax" /></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiFaxCssx" name="fiFaxCssx" data-bind="value : fiFaxCssx" maxlength="50" />
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.email" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailCssx" name="fiEmailCssx"  data-bind="value : fiEmailCssx" type="text" maxlength="50" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.tinh" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaTinh" name="fiMaTinh" data-bind="optionsCaption: 'Chọn...', selectedText : fiTenTinh, options : lstTinhThanh, optionsValue : 'fiMa', value : fiMaTinh, optionsText : 'fiTen', event : {change : fiTinhThanhChange}"></select>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.huyen" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control select2" id="fiMaHuyen" name="fiMaHuyen" data-bind="optionsCaption: 'Chọn...', selectedText : fiTenHuyen, options : lstQuanHuyen, optionsValue : 'fiMa', optionsText : 'fiTen', value : fiMaHuyen, event : {change : fiQuanHuyenChange}"></select>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.07.hoso.cssx.xa" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaXaphuong" name="fiMaXaphuong" data-bind="optionsCaption: 'Chọn...', selectedText : fiTenXaphuong, optionsValue : 'fiMa', value : fiMaXaphuong, options : lstXaPhuong, optionsText : 'fiTen'"></select>
                </div>
            </div>  
        </div> 
        <p class="nsw-text-center">
            <a data-bind="click : btnLuuCSSXClick" href="javascript:void(0);" class="btn blue" id="btnLuu"><i class="fa fa-lg fa-save" ></i> <spring:message code="common.button.luu" /></a>
            <a data-bind="click : btnResetClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-lg fa-recycle" ></i> Nhập lại</a>
        </p>
        <p> <b><spring:message code="monre.07.hoso.cssx.ds" /></b></p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th class="text-center"><b><spring:message code="monre.07.hoso.cssx.ds.tt" /></b></th>
                    <th></th>
                    <th><b><spring:message code="monre.07.hoso.cssx.ds.tencs" /></b></th>
                    <th><b><spring:message code="monre.07.hoso.cssx.ds.diachi" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="monre.07.hoso.cssx.ds.dienthoai" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="monre.07.hoso.cssx.ds.fax" /></b></th>
                    <th class="text-center"><b><spring:message code="monre.07.hoso.cssx.ds.email" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="monre.07.hoso.cssx.ds.tinh" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="monre.07.hoso.cssx.ds.huyen" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="monre.07.hoso.cssx.ds.xa" /></b></th>
                    <th style="max-width: 150px;"><b><spring:message code="monre.07.hoso.cssx.ds.chucnang" /></b></th>
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'cssxItemTmpl', foreach: lstItems }">
            </tbody>
            <script id="cssxItemTmpl" type="text/html">
                <tr>
                    <td data-bind="text : stt"></td>
                    <td>
                        <input type="checkbox" data-bind="checked: fiIsSelected, click: $parent.toggleAssociation.bind($parent)" />
                    </td>
                    <td class="text-left" data-bind="text : fiTenCssx"></td> 
                    <td class="text-left" data-bind="text : fiDiachiCssx"></td> 
                    <td class="text-left" data-bind="text : fiSdtCssx"></td> 
                    <td class="text-center" data-bind="text : fiFaxCssx"></td> 
                    <td class="text-left" data-bind="text : fiEmailCssx"></td>                     
                    <td class="text-left" data-bind="text : fiTenTinh"></td>                     
                    <td class="text-left" data-bind="text : fiTenHuyen"></td>                     
                    <td class="text-left" data-bind="text : fiTenXaphuong"></td>
                    <td class="text-center">
                        <a href="javascript:void(0);"><i class="fa fa-edit" data-bind="click: $parent.bSuaCSSXClick.bind($parent)" src="" alt=""/></a>
                        <a href="javascript:void(0);"><i class="fa fa-trash" data-bind="click: $parent.bXoaCSSXClick.bind($parent)" src="" alt=""/></a>
                    </td>
                </tr>                      
            </script>
        </table>  
        <div class="row">                            
            <div class="col col-md-6">
                <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
            </div>
            <div class="col col-md-6 nsw-text-right">
                <div class="nsw-flr"> 
                    <!-- ko with:paging()-->
                    <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                        <li data-bind="css: { disabled: !firstPageActive() }">
                            <a data-bind="click: goToFirst">Trang đầu</a>
                        </li>
                        <li data-bind="css: { disabled: !previousPageActive() }">
                            <a data-bind="click: goToPrevious">Trang trước</a>
                        </li>
                        <!-- ko foreach: getPages() -->
                        <li data-bind="css: { active: $parent.currentPage() === $data }">
                            <a data-bind="click: $parent.goToPage, text: $data"></a>
                        </li>
                        <!-- /ko -->
                        <li data-bind="css: { disabled: !nextPageActive() }">
                            <a data-bind="click: goToNext">Trang sau</a>
                        </li>
                        <li data-bind="css: { disabled: !lastPageActive() }">
                            <a data-bind="click: goToLast">Trang cuối</a>
                        </li>
                    </ul>
                    <!-- /ko -->
                </div>
            </div>
        </div>
    </form>
</template>
