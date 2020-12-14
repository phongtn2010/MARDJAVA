<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>  
    <legend><b><spring:message code="most.05.hoso.thongTinNhanVN" /></b></legend>
    <form role="form" class="form-horizontal" name="searchForm">
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongTinNhanVN.tenDoanhNghiep" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtBenCungCapTen" name="fiTtcTenToChuc" maxlength="255" data-bind="value: $data.formVM().fiTtBenCungCapTen"/>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongTinNhanVN.diachi" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcDiaChi" name="fiTtcDiaChi" type="text" data-bind="value: $data.formVM().fiTtBenCungCapDiaChi"/>
                </div>
            </div>
        </div>  
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongTinNhanVN.dienthoai" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcDienThoai" name="fiTtcDienThoai" maxlength="255" type="text" data-bind="value: $data.formVM().fiTtBenCungCapDienThoai"/>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongTinNhanVN.fax" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTtcFax" name="fiTtcFax" maxlength="255" type="text" data-bind="value: $data.formVM().fiTtBenCungCapFax"/>
                </div>
            </div>  
        </div>
        <div class="form-group" style="margin-top: 15px;">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="most.05.hoso.thongTinNhanVN.email" /><a class="nsw-require-field">*</a></label>
                </div>

                <div class="col-md-4">
                    <input class="form-control" type="email" id="fiTtcEmail" name="fiTtcEmail" maxlength="250" data-bind="value: $data.formVM().fiTtBenCungCapEmail" />
                </div>

            </div>
        </div>
    </form>
</fieldset>