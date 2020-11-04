<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="mard.hoso.danhsachsanpham" /></b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.stt" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.tensanpham" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.mahs" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.macongnhan" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.mucchatluong" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.giaydangky" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.hangsanxuat" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.nuocsanxuat" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.ngaycapxncl" /></th>
                        <th class="text-center"><spring:message code="mard.hoso.danhsachsanpham.giayxncl" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHanghoas">
                    <tr>
                        <td data-bind="text: fiStt"></td>  
                        <td>
                            <!-- ko if: rowSpan() > 0 -->
                                <span data-bind="text: fiTenHh"></span>
                            <!-- /ko -->
                        </td> 
                        <td data-bind="text: fiMahosoXncl"></td> 
                        <td data-bind="text: fiMsChungnhan"></td>                        
                        <td data-bind="text: fiMucChatluong"></td> 
                        <td data-bind="text: fiSodkXncl"></td>                         
                        <td data-bind="text: fiHangSx"></td> 
                        <td data-bind="text: fiNuocSx"></td> 
                        <td >
                            <span data-bind="text : fiNgaycapXnclText"></span>
                        </td> 
                        <td data-bind="text: fiSogiayXncl"></td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHangHoaMessage" style="color:red;"> </span>
            <br />
        </div>
    </div>
</fieldset>