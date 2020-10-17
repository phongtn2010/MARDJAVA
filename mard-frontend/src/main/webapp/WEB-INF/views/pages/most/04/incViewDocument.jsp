<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="Most04Form">
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
                    <b data-bind="text: fiTenDn"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiMstDn"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.dienthoai" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiDtDn"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.Fax" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiFaxDn"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.diachi" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <b data-bind="text: fiDiachiDn"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.email" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiEmailDn"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.website" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiWebsiteDn"></b>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.04.hanghoa.hanghoa" /></b>
        <hr/>
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
                </tr>                      
            </script>
        </table>
        <span data-bind="text : errorHanghoaText" style="color:red;"> </span>        
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.nguoidaidien" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiNguoiDd"></b>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.04.dondangky.chucvunguoidaidien" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiChucVu"></b>
                </div>
            </div> 
        </div>
    </div>
</form>
