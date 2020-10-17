<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="Most04Form">
    <div class="row-border" data-bind="style: { display: (fiTrangthai() == 2 || fiTrangthai() == 6 || fiTrangthai() == 10 || fiTrangthai() == 11) ? '' : 'none' }">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.lydosuahoso" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <textarea id="fiLydoXinsua" name="fiLydoXinsua" data-bind="value: fiLydoXinsua"  maxlength="2000" class="form-control" placeholder="<spring:message code="most.04.dondangky.lydosuahoso" />"
                              height="200px"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.04.dondangky.thongtindoanhnghiep" /></b>
        <hr/>
    </div>
    <div class="row-border">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.tencongty" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenDn" name="fiTenDn" maxlength="100"  
                           type="text" data-bind="value : fiTenDn" placeholder="<spring:message code="most.04.dondangky.tencongty" />" readonly="true">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMstDn" name="fiMstDn" maxlength="100"  
                           type="text" data-bind="value : fiMstDn" placeholder="<spring:message code="most.04.dondangky.masothue" />" readonly="true">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.dienthoai" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDtDn" name="fiDtDn" maxlength="50"  
                           type="text" data-bind="value : fiDtDn" placeholder="<spring:message code="most.04.dondangky.dienthoai" />">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.Fax" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiFaxDn" name="fiFaxDn" maxlength="50"  
                           type="text" data-bind="value : fiFaxDn" placeholder="<spring:message code="most.04.dondangky.Fax" />">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.diachi" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input class="form-control" id="fiDiachiDn" name="fiDiachiDn" maxlength="100"  
                           type="text" data-bind="value : fiDiachiDn" placeholder="<spring:message code="most.04.dondangky.diachi" />" readonly="true">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.email" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailDn" name="fiEmailDn" maxlength="50"  
                           type="text" data-bind="value : fiEmailDn" placeholder="<spring:message code="most.04.dondangky.email" />">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.website" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiWebsiteDn" name="fiWebsiteDn" maxlength="50"  
                           type="text" data-bind="value : fiWebsiteDn" placeholder="<spring:message code="most.04.dondangky.website" />">
                </div>
            </div>
        </div>
    </div>
    
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.04.hanghoa.hanghoa" /></b>
        <hr/>
        <a href="javascript:void(0);" id="btnThemMoiHangHoa" data-bind="click: bThemMoiHangHoa" class="btn blue">
            <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
        </a>
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center w50"><spring:message code="most.04.hanghoa.tt" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.loaihanghoa" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.tenhang" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.sochungnhan" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.sohieutieuchuan" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.thanhphanhamluong" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.nuocnhapkhau" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.sua" /></th>
                    <th class="text-center"><spring:message code="most.04.hanghoa.xoa" /></th>
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'hanghoaTmpl', foreach: hangHoas }">
            </tbody>
            <script id="hanghoaTmpl" type="text/html">
                <tr>
                    <td data-bind="text : stt"></td>                        
                    <td data-bind="text : fiTenNhomHh"></td>
                    <td data-bind="text : fiTenHh"></td> 
                    <td data-bind="text : fiSoDk"></td>
                    <td data-bind="text : fiSoHieuTc"></td>
                    <td data-bind="text : fiTpHlHchat"></td>
                    <td class="text-center" data-bind="text : fiTenQgNk"></td>
                    <td style="max-width: 200px;" class="text-center">
                        <a href="javascript:void(0)"><i class="fa fa-edit" data-bind="click: $parent.bSuaHangHoaClick.bind($parent)" src="" alt=""/></a>
                    </td> 
                    <td style="max-width: 200px;" class="text-center">
                        <a href="javascript:void(0)"><i class="fa fa-remove" data-bind="click: $parent.bXoaHangHoaClick.bind($parent)" src="" alt=""/></a>
                    </td> 
                </tr>                      
            </script>
        </table>
        <span data-bind="text : errorHanghoaText" style="color:red;"> </span>        
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.nguoidaidien" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-8">
                    <input class="form-control" id="fiNguoiDd" name="fiNguoiDd" maxlength="100"  
                           type="text" data-bind="value : fiNguoiDd" placeholder="<spring:message code="most.04.dondangky.nguoidaidien" />">
                </div>
            </div>
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.chucvunguoidaidien" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-8">
                    <input class="form-control" id="fiChucVu" name="fiChucVu" maxlength="100"  
                           type="text" data-bind="value : fiChucVu" placeholder="<spring:message code="most.04.dondangky.chucvunguoidaidien" />">
                </div>
            </div> 
        </div>
    </div>
</form>
<template id="hanghoa-template">
    <form role="form" class="form-horizontal hanghoa-form" id="hanghoa-form">
        <div class="form-group">
            <div class="col-md-3">
                <label><spring:message code="most.04.hanghoa.loaihanghoa" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-9">                 
                <select class="form-control" id="fiMaNhomHh" name="fiMaNhomHh" 
                        data-bind="optionsCaption: '<spring:message code="common.chon" />', 
                            value : fiMaNhomHh, 
                            options : lstNhomHangHoa, 
                            optionsText: 'fiTen', 
                            optionsValue:'fiMa'"></select>
                <input type="hidden" id="fiIdHh" name="fiIdHh" data-bind="value : fiIdHh"/>
                <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-3">
                <label><spring:message code="most.04.hanghoa.tenhang" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-9">
                <input id="fiTenHh" name="fiTenHh" data-bind="value: fiTenHh" maxlength="250" class="form-control" placeholder="<spring:message code="most.04.hanghoa.tenhang" />" type="text" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-3">
                <label><spring:message code="most.04.hanghoa.sochungnhan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-9">
                <input id="fiSoDk" name="fiSoDk" data-bind="value: fiSoDk" maxlength="100" class="form-control" placeholder="<spring:message code="most.04.hanghoa.sochungnhan" />" type="text" />
            </div>
        </div>  
        <div class="form-group">
            <div class="col-md-3">
                <label><spring:message code="most.04.hanghoa.sohieutieuchuan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-9">
                <input id="fiSoHieuTc" name="fiSoHieuTc" data-bind="value: fiSoHieuTc" maxlength="100" class="form-control" placeholder="<spring:message code="most.04.hanghoa.sohieutieuchuan" />" type="text" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-3">
                <label><spring:message code="most.04.hanghoa.thanhphanhamluong" /></label>
            </div>
            <div class="col-md-9">
                <input id="fiTpHlHchat" name="fiTpHlHchat" data-bind="value: fiTpHlHchat" maxlength="50" class="form-control" placeholder="<spring:message code="most.04.hanghoa.thanhphanhamluong" />" type="text" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-3">
                <label><spring:message code="most.04.hanghoa.nuocnhapkhau" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-9">                 
                <select class="form-control" id="fiMaQgNk" name="fiMaQgNk" 
                        data-bind="optionsCaption: '<spring:message code="common.chon" />', value : fiMaQgNk, selectedText : fiTenQgNk, options : lstQuocGia, optionsText: 'name', optionsValue:'statecode'"></select>
            </div>
        </div>
    </form>
</template>  
