<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend style="color: dodgerblue;"><b><spring:message code="moh.02.giayphep.thongtinchung" /></b></legend>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
<%--                <span data-bind="text : fiTendoanhnghiep"></span>--%>
                <input class="form-control" id="fiTendoanhnghiep" name="fiTendoanhnghiep" data-bind="value : fiTendoanhnghiep"
                       maxlength="255" type="text" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.masothue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
<%--                <span data-bind="text : fiMst"></span>--%>
                <input class="form-control" id="fiMst" name="fiMst" maxlength="50"
                       type="text" data-bind="value : fiMst" readonly="readonly"/>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.coquancap" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
<%--                <span data-bind="text : fiCqCap"></span>--%>
                <input class="form-control" id="fiCqCap" name="fiCqCap" data-bind="value : fiCqCap" type="text" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.socongvan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
<%--                <span data-bind="text : fiSoCongvan"></span>--%>
                <input class="form-control" id="fiSoCongvan" name="fiSoCongvan" maxlength="50"
                       type="text" data-bind="value : fiSoCongvan" readonly="readonly"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.ngayky" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
<%--                <span data-bind="date : fiNgayky"></span>--%>
                <input name="fiNgayky" id="fiNgayky" class="form-control form-control-inline date-picker"
                       data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" placeholder="dd/mm/yyyy"
                       disabled="disabled" readonly
                       data-bind="datepicker : fiNgayky"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.nguoiky" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
<%--                <span data-bind="text : fiNguoiky"></span>--%>
                <input class="form-control" id="fiNguoiky" name="fiNguoiky" maxlength="250"
                       type="text" data-bind="value : fiNguoiky" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.tencongvan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
<%--                <span data-bind="text : fiTenCongvan"></span>--%>
                <input class="form-control" id="fiTenCongvan" name="fiTenCongvan" maxlength="250"
                       type="text" data-bind="value : fiTenCongvan" readonly="readonly"/>
            </div>
        </div>  
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.02.giayphep.thongtinchung.noidung" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <a target="_blank" data-bind="text: fiTenCongvan, attr: { href: downloadUrlNdCv}"></a>
            </div>
        </div>
    </div>
    <legend style="color: dodgerblue">
        <b><spring:message code="moh.02.giayphep.donhang" />  </b>
    </legend>
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstGpHanghoa">
        <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.stt" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.loaimau" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.nguongoc" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.soluong" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.dvtinh" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.hinhthuc" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.noigui" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.noinhan" /></th>
                <th class="text-center"><spring:message code="moh.02.giayphep.donhang.vanchuyen" /></th>
            </tr>
        </thead>
        <tbody data-bind="foreach: lstHanghoa">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">
                </td>
                <td  data-bind="text : fiLoaimau">
                </td>
                <td data-bind="text : fiNguongoc">
                </td>
                <td class="text-right" data-bind="text : fiSoluong">
                </td>
                <td data-bind="text : fiDonviTinh">
                </td>
                <td data-bind="text : fiHinhthuc">
                </td>
                <td data-bind="text : fiNoigui">
                </td>
                <td data-bind="text : fiNoiNhan">
                </td>
                <td data-bind="text : fiDuongVanchuyen">
                </td>
            </tr>
        </tbody>
    </table>

</fieldset>





