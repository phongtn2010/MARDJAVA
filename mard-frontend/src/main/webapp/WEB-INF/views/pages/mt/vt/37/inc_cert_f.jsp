<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<template id="form-f-template">
   <div class="row">
    <form role="form" class="form-horizontal" id="form-f">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.sogiayphep" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.tendoanhnghiep" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiTenDn" readonly="readonly"/>
                </div>
            </div> 
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.diachi" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiDiachiDn" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.dienthoai" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiSdtDn" readonly="readonly"/>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.nguoiky" />: </label>
                </div>
                <div class="col-md-4">  
                    <input class="form-control" type="text" data-bind="value : fiTenNgKy" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.chucdanh" />: </label>
                </div>
                <div class="col-md-4">  
                    <input class="form-control" type="text" data-bind="value : fiChucDanh" readonly="readonly"/>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.diadiemky" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiDiaDiem" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.ngayky" />: </label>
                </div>
                <div class="col-md-4">  
                    <input class="form-control" type="text" data-bind="value : fiNgaykyText" readonly="readonly"/>
                </div>
            </div>            
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.giatritungay" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiGpTuNgayText" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.giatridenngay" />: </label>
                </div>
                <div class="col-md-4">  
                    <input class="form-control" type="text" data-bind="value : fiGpDenNgayText" readonly="readonly"/>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.biensoxe" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiBksXe" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.soghe" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiSoGhe" readonly="readonly"/>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.sokhung" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiSoKhung" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.somay" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiSoMay" readonly="readonly"/>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.mauson" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiMauSon" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.nhanhieu" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiTenHieu" readonly="readonly"/>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.tuyenvantaitu" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiTuyenDi" readonly="readonly"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.tuyenvantaiden" />: </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" data-bind="value : fiTuyenDen" readonly="readonly"/>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.hanhtrinh2" />: </label>
                </div>
                <div class="col-md-8">
                    <input class="form-control" type="text" data-bind="value : fiHanhtrinh" readonly="readonly"/>
                </div>
            </div>            
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="mt.37.giayphep.link" />: </label>
                </div>
                <div class="col-md-8">
                     <table class="tb-content tb-none-border w100p">
                        <tbody data-bind="foreach: lstDinhKem">
                            <tr>
                                <td class="left">
                                    <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiUrl}"></a>
                                </td>            
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </form>
</div>
</template>