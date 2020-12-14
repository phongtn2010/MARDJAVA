<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="Most03Form">    
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.dondangky.loaihoso" /></b>
        <hr/>
    </div>
    <div class="row-border">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.loaihoso2" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiLoaiHosoText"></b>
                </div>                
            </div>
        </div>            
    </div>
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.dondangky.thongtindoanhnghiep" /></b>
        <hr/>
    </div>
    <div class="row-border">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.tencoso" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiTenCoso"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.diachitruso" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiDiachiTsc"></b>                    
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.dienthoai" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiSdt"></b>                    
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.vanphonggiaodich" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiDiachiVpgg"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.email" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiEmail"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.Fax" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiFax"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.sodangkykinhdoanh" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiSoDkkd"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.ngaycap" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiNgaycapText"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.coquancap" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiCqCap"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.masothue" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiMstDn"></b>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.nguoidaidien" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiNguoiDaidien"></b>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.chucvunguoidd" /></label>
                </div>
                <div class="col-md-4">
                    <b data-bind="text: fiChucvuNguoidaidien"></b>
                </div>
            </div>
        </div>
    </div>
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.tokhai.tokhai" /></b>
        <hr/>
    </div>
    <div class="row-border">
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center w50"><spring:message code="most.03.tokhai.stt" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.sotokhai" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.ngaydangky" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.mahaiquan" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.xoa" /></th>
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'dstkTmpl', foreach: toKhaiHQs }">
            </tbody>
            <script id="dstkTmpl" type="text/html">
                <tr>
                    <td data-bind="text : stt"></td>                        
                    <td class="text-center" data-bind="text : fiSoTk"></td>
                    <td class="text-center" data-bind="text : fiNgayDKVN"></td> 
                    <td class="text-center" data-bind="text : fiMaHq"></td>
                    <td style="max-width: 200px;" class="text-center">
                        <a href="javascript:void(0)"><i class="fa fa-search" data-bind="click: $parent.onViewToKhaiClick.bind($parent)" src="" alt=""/></a>
                    </td> 
                </tr>                      
            </script>
        </table>
    </div>
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.hanghoa.hanghoa" /></b>
        <hr/>
        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center w50"><spring:message code="most.03.hanghoa.tt" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.tenphuongtiendo" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.hangsanxuat" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.nuocsanxuat" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.kyhieu" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.kieu" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.phamvido" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.capchinhxac" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.dactinhdoluong" /></th>
                    <th class="text-center"><spring:message code="most.03.hanghoa.ghichu" /></th>
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'hanghoaTmpl', foreach: hangHoas }">
            </tbody>
            <script id="hanghoaTmpl" type="text/html">
                <tr>
                    <td data-bind="text : stt"></td>                        
                    <td data-bind="text : fiTenHh"></td>
                    <td data-bind="text : fiTenNsx"></td> 
                    <td class="text-center" data-bind="text : fiTenQg"></td>
                    <td data-bind="text : fiKyhieu"></td>
                    <td data-bind="text : fiKieu"></td>
                    <td data-bind="text : fiPhamvido"></td>
                    <td data-bind="text : fiCapCx"></td>
                    <td data-bind="text : fiDactinhKt"></td>
                    <td data-bind="text : fiGhiChu"></td>
                </tr>                      
            </script>
        </table>
        <span data-bind="text : errorHanghoaText" style="color:red;"> </span>        
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.hanghoa.denghimiengiam" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiDnMienTnm"></b>                    
                </div>
            </div>
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.hanghoa.lydo" /></label>
                </div>
                <div class="col-md-8">
                    <b data-bind="text: fiLydoDnMien"></b>
                </div>
            </div> 
        </div>
    </div>
</form>
