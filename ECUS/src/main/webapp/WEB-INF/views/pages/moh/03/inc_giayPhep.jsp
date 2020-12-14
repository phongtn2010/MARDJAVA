<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend style="color: dodgerblue;"><b><spring:message code="moh.03.giayphep.thongtinchung" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.coquancap" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCqCap" name="fiCqCap" data-bind="value : fiCqCap" type="text" readonly/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.socongvan" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoCongvan" name="fiSoCongvan"
                       type="text" data-bind="value : fiSoCongvan" readonly="readonly"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.ngayky" /></label>
            </div>
            <div class="col-md-4">
                <input name="fiNgayky" id="fiNgayky" class="form-control form-control-inline date-picker"
                       data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" placeholder="dd/mm/yyyy"
                       disabled="disabled" readonly
                       data-bind="datepicker : fiNgayky"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.nguoiky" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiky" name="fiNguoiky"
                       type="text" data-bind="value : fiNguoiky" readonly="readonly"/>
            </div>
        </div>  
    </div> 
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.tencongvan" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCongvan" name="fiTenCongvan"
                       type="text" data-bind="value : fiTenCongvan" readonly="readonly"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.ngayhieuluc" /></label>
            </div>
            <div class="col-md-4">
                <input name="fiNgayHetHl" id="fiNgayHetHl" class="form-control form-control-inline date-picker"
                       data-date-format="dd/mm/yyyy" type="text" value="" maxlength="10" placeholder="dd/mm/yyyy"
                       disabled="disabled" readonly
                       data-bind="datepicker : fiNgayHetHl"/>
            </div>
        </div>  
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.noidung" /></label>
            </div>
            <div class="col-md-10">
                <a target="_blank" data-bind="text: fiNoidungCv, attr: { href: downloadUrlNdCv}"></a>
            </div>
        </div>
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.noidungdonhang" /></label>
            </div>
            <div class="col-md-10">
                <a target="_blank" data-bind="text: fiNoidungTeptin, attr: { href: downloadUrlNdTt}"></a>
            </div>
        </div>
    </div>
    <div class="form-group" style="margin-top: 15px;">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moh.03.giayphep.thongtinchung.fileScan" /></label>
            </div>
            <div class="col-md-10">
                <a target="_blank" data-bind="text: fiFileScan, attr: { href: downloadUrlFileScan}"></a>
            </div>
        </div>
    </div>
    <legend style="color: dodgerblue">
        <b><spring:message code="moh.03.giayphep.donhang" />  </b>
    </legend>
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstGpHanghoa">
        <thead>
            <tr class="nsw-tr tr-nsw1-bgcolor">
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.stt" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.tenduoclieu" /></th>
<%--                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.mahs" /></th>--%>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.bpdung" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.tenkh" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.soluong" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.dvtinh" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.tccl" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.qgsx" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.cssx" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.qgcc" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.cscc" /></th>
                <th class="text-center"><spring:message code="moh.03.giayphep.donhang.ghichu" /></th>
            </tr>
        </thead>
        <tbody data-bind="foreach: lstHanghoa">
            <tr>
                <td data-bind="text: $index() + 1" style="vertical-align: middle;width: 2%">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiTenDuoclieu">
                </td>
<%--                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 30px !important;" data-bind="text : fiMaHs">--%>
<%--                </td>--%>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiBophanDung">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiTenKhoahoc">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 30px !important;" class="text-right" data-bind="text : fiSoluong">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiTenDvTinh">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 50px !important;" data-bind="text : fiTccl">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiTenQgSx">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiCosoSx">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiTenQgCc">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiCosoCc">
                </td>
                <td style="vertical-align: middle;text-align: left;word-wrap: break-word;max-width: 100px !important;" data-bind="text : fiGhichu">
                </td>
            </tr>
        </tbody>
    </table>

</fieldset>





