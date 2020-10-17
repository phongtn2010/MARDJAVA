<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.hanghoa" /></b><a class="nsw-require-field">*</a></p>
    </div>
    <div class="row-border">
        <a href="javascript:void(0);" id="btnThemMoiHangHoa" class="btn grey" data-toggle="modal" style="display: ${IsView}">
            <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
        </a>
        <table class="table table-striped table-bordered table-hover table-checkable order-column table_hanghoa" id="sample_1">
            <thead>
                <tr>
                    <th class="nsw-text-center"><spring:message code="common.table.col.stt" /></th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.nhomhanghoa" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.tenhanghoa" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.kyhieu_kieuloai" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.nhanhieu" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.nhasanxuat" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.nuocxuatxu" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.soluong_khoiluong" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.donvitinh" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.thongsokythuat" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.maHS" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.da_co_gcn" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.doituong_mienkiem" /> </th>
                    <th class="nsw-text-center"><spring:message code="most.01.hanghoa.ghichu" /> </th>
                    <th class="nsw-text-center" style="display: ${IsView}"> <spring:message code="common.button.sua" /> </th>
                    <th class="nsw-text-center" style="display: ${IsView}"> <spring:message code="common.button.xoa" /> </th>                    
                </tr>
            </thead>
            <tbody id="hanghoa-container">

            </tbody>
        </table>
        <div class="row">                            
            <div class="col col-md-6">

            </div>
            <div class="col col-md-6 nsw-text-right">
                <div id="hanghoa-pager"></div>
            </div>
        </div>
    </div>
</div>

<div id="hanghoa-tmpl" style="display: none;">
    <form role="form" class="form-horizontal hanghoa-form">
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.nhomhanghoa" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <select id="fiManhom" name="fiManhom" class="form-control select2" require="true" field="most_01_hanghoa_nhomhanghoa"  data="{{fixSelectData fiManhom}}">
                    
                </select>
                <input id="fiNhomHhOther" value="{{fiNhomHh}}" placeholder="Nhập tên nhóm" maxlength="255" class="form-control" type="text" style="display: none" />   
                <label class="input-invaild-text" id="message-fiManhom"></label>    
                <input type="hidden" name="fiNhomHh" id="fiNhomHh" value="{{fiNhomHh}}" field="<spring:message code="most.01.hanghoa.nhomhanghoa" />"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.maHS" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <input id="fiMaHs" name="fiMaHs" value="{{fiMaHs}}" require="true" maxlength="12" field="most_01_hanghoa_maHS" class="form-control" placeholder="<spring:message code="most.01.hanghoa.maHS" />" type="text">
                <label class="input-invaild-text" id="message-fiMaHs"></label>  
            </div>
        </div>  
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.tenhanghoa" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <input id="fiTenHh" name="fiTenHh"  value="{{fiTenHh}}" require="true" maxlength="255" field="most_01_hanghoa_tenhanghoa" class="form-control" placeholder="<spring:message code="most.01.hanghoa.tenhanghoa" />" type="text">
                <label class="input-invaild-text" id="message-fiTenHh"></label>  
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.nhanhieu" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <input id="fiNhanHh" name="fiNhanHh" value="{{fiNhanHh}}" maxlength="255" require="true" field="most_01_hanghoa_nhanhieu" class="form-control" placeholder="<spring:message code="most.01.hanghoa.nhanhieu" />" type="text">
                <label class="input-invaild-text" id="message-fiNhanHh"></label>  
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.kyhieu_kieuloai" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <input id="fiKyhieu" name="fiKyhieu" value="{{fiKyhieu}}" maxlength="255" require="true" field="most_01_hanghoa_kyhieu_kieuloai" class="form-control" placeholder="<spring:message code="most.01.hanghoa.kyhieu_kieuloai" />" type="text">
                <label class="input-invaild-text" id="message-fiKyhieu"></label>  
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.thongsokythuat" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <input id="fiThongsoKt" name="fiThongsoKt" value="{{fiThongsoKt}}" maxlength="255" require="true" field="most_01_hanghoa_thongsokythuat" class="form-control" placeholder="<spring:message code="most.01.hanghoa.thongsokythuat" />" type="text">
                <label class="input-invaild-text" id="message-fiThongsoKt"></label>  
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.nuocxuatxu" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <select id="fiMaQg" name="fiMaQg" require="true" field="most_01_hanghoa_nuocxuatxu" class="form-control select2" data="{{fixSelectData fiMaQg}}">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${quocgia.data}" var="item">
                        <option value="${item.statecode}">${item.name}</option>
                    </c:forEach>
                </select>
                <label class="input-invaild-text" id="message-fiMaQg"></label>  
                <input type="hidden" name="fiTenQg" id="fiTenQg" value="{{fiTenQg}}" field="<spring:message code="most.01.hanghoa.nuocxuatxu" />"/>
            </div>
        </div> 
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.nhasanxuat" /></label>
            </div>
            <div class="col-md-7">
                <input id="fiTenNsx" name="fiTenNsx" value="{{fiTenNsx}}" maxlength="255" class="form-control" placeholder="<spring:message code="most.01.hanghoa.nhasanxuat" />" type="text">
                <label class="input-invaild-text" id="message-fiTenNsx"></label>  
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.soluong_khoiluong" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-7">
                <input id="fiKlSl" name="fiKlSl" value="{{fiKlSl}}" maxlength="17" is="float" nguyen="12" thapphan="3" require="true" field="most_01_hanghoa_soluong_khoiluong" class="form-control" placeholder="<spring:message code="most.01.hanghoa.soluong_khoiluong" />" type="text">
                <label class="input-invaild-text" id="message-fiKlSl"></label> 
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.donvitinh" /></label><a class="nsw-require-field">*</a>
            </div>
            <div class="col-md-7">
                <select id="fiMaDv" name="fiMaDv" require="true" field="most_01_hanghoa_donvitinh" class="form-control select2" data="{{fixSelectData fiMaDv}}">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${dvt.data}" var="item">
                        <option value="${item.unitcode}">${item.name}</option>
                    </c:forEach>
                </select>
                <label class="input-invaild-text" id="message-fiMaDv"></label> 
                <input type="hidden" name="fiTenDv" id="fiTenDv" value="{{fiTenDv}}" field="<spring:message code="most.01.hanghoa.donvitinh" />"/>
            </div>
        </div> 
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.doituong_mienkiem" /></label>
            </div>
            <div class="col-md-7">
                <select id="fiMaMk" name="fiMaMk" class="form-control select2" data="{{fixSelectData fiMaMk}}" field="<spring:message code="most.01.hanghoa.doituong_mienkiem" />">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${mienkiem.data}" var="item">
                        <option value="${item.fiMa}">${item.fiTen}</option>
                    </c:forEach>
                </select>
                <label class="input-invaild-text" id="message-fiMaMk"></label>
                <input type="hidden" name="fiLoaiMk" id="fiLoaiMk" value="{{fiLoaiMk}}" field="<spring:message code="most.01.hanghoa.doituong_mienkiem" />"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <label><spring:message code="most.01.hanghoa.ghichu" /></label>
            </div>
            <div class="col-md-7">
                <textarea id="fiGhiChu" name="fiGhiChu" value="{{fiGhiChu}}" maxlength="500" class="form-control" placeholder="<spring:message code="most.01.hanghoa.ghichu" />"
                          field="<spring:message code="most.01.hanghoa.ghichu" />"  height="200px">{{fiGhiChu}}</textarea>
                <label class="input-invaild-text" id="message-fiGhiChu"></label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-5">
                <spring:message code="most.01.hanghoa.da_co_gcn" />
            </div>
            <div class="col-md-7">
                <label class="mt-checkbox mt-checkbox-outline"> 
                    <input id="fiCoGcn" name="fiCoGcn" type="checkbox" field="<spring:message code="most.01.hanghoa.da_co_gcn" />" data="{{fiCoGcn}}">
                    <span></span>
                </label>
            </div>
        </div>                    
        <input type="hidden" id="fiIdDinhkem" name="fiIdDinhkem" value="{{fiIdDinhkem}}" />
        <input type="hidden" id="fiIdTk" name="fiIdTk" value="{{fiIdTk}}" />
        <input type="hidden" id="fiSoTk" name="fiSoTk" value="{{fiSoTk}}" />
        <input type="hidden" id="fiMaql" name="fiMaql" value="{{fiMaql}}" />
    </form>
</div>