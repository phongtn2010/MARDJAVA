<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.tokhai" /></b><a class="nsw-require-field">*</a></p>
    </div>
    <div class="row-border">
        <a href="javascript:void(0);" id="btnThemMoiToKhai" class="btn grey" data-toggle="modal" style="display: ${IsView}">
            <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
        </a>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th><spring:message code="common.table.col.stt" /></th>
                    <th><spring:message code="most.01.tokhai.hanghoa_nhapkhau_so" /> </th>
                    <th><spring:message code="most.01.tokhai.ngay_dang_ky" /> </th>
                    <th><spring:message code="most.01.tokhai.ma_hai_quan" /> </th>
                    <th style="display: ${IsView}"> # </th>
                    <th style="display: ${IsView}"> <spring:message code="common.button.sua" /> </th>
                    <th style="display: ${IsView}"> <spring:message code="common.button.xoa" /> </th>
                </tr>
            </thead>
            <tbody id="tokhai-container">

            </tbody>
        </table>
    </div>
</div>
<div id="tokhai-tmpl" style="display: none;">
    <form role="form" class="form-horizontal tokhai-form">
        <p><b class="nsw-text-underline">{{ _lang "most_01_tokhai_thongtintimkiem" }}</b></p>
        <div class="form-group">
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.01.tokhai.hanghoa_nhapkhau_so" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input id="fiSoTk" value="{{fiSoTk}}" name="fiSoTk" require="true" field="most_01_tokhai_hanghoa_nhapkhau_so" class="form-control" placeholder="<spring:message code="most.01.tokhai.hanghoa_nhapkhau_so" />" type="text">
            </div>            
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.01.tokhai.namdangky" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input id="fiNamdk" name="fiNamdk" require="true" field="most_01_tokhai_namdangky" class="form-control" placeholder="<spring:message code="most.01.tokhai.namdangky" />" type="text" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2">
                <label class="control-label"><spring:message code="most.01.tokhai.ma_hai_quan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input id="fiMaHq" name="fiMaHq" value="{{fiMaHq}}" require="true" field="most_01_tokhai_ma_hai_quan" class="form-control" placeholder="<spring:message code="most.01.tokhai.ma_hai_quan" />" type="text">                
            </div>
            <div class="col-md-6">
                <select id="fiDVHQ" class="form-control select2" data="{{fixSelectData fiMaHq}}">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${danhsachdonvihq.data.haiQuan}" var="item">
                        <option value="${item.ma_HQ}">${item.ten_HQ}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12 nsw-text-center">
                <a href="javascript:;" class="btn blue" id="btnToKhaiSearch" style="display: ${IsView}"><i class="fa fa-search" ></i> <spring:message code="common.button.tim_kiem" /></a>
            </div>
        </div>
        <p><b class="nsw-text-underline red">{{ _lang "most_01_tokhai_ketquatimkiem" }}</b></p>
        <hr />    
        <p><b class="nsw-text-underline">{{ _lang "common_tokhai_thongtinchung" }}</b></p>
        <div class="panel-body"> 
            <div class="row">
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_sotokhai"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKSo"></b>
                </div>
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_mahaiquan"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKMaHq"></b>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <label>{{_lang "common_tokhai_ngaydangky"}}</label>
                </div>
                <div class="col-md-3">
                    <b id="lbTKNgayDK"></b>
                </div>        
            </div>
        </div>
        <p><b class="nsw-text-underline">{{ _lang "common_tokhai_hanghoa" }}</b></p>
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr>
                    <th><b>{{_lang "common_tokhai_hanghoa_stt"}}</b></th>
                    <th class="nsw-text-center"><input id="cbAllProducts" data="0" type="checkbox" name="cbAllProducts"/></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_mahs"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_tenhanghoa"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_klsl"}}</b></th>
                    <th><b>{{_lang "common_tokhai_hanghoa_donvitinh"}}</th>
                </tr>
            </thead>
            <tbody class="tokhai-hanghoa-container">

            </tbody>
        </table>
        <div class="row">                            
            <div class="col col-md-6">
            </div>
            <div class="col col-md-6 nsw-text-right">
                <div class="tokhai-hanghoa-pager"></div>
            </div>
        </div> 
    </form>

</div>