<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                            <thead>
                                <tr>
                                    <th class="text-center"> <spring:message code="common.table.col.stt" /></th>
                                    <th class="text-center"> <spring:message code="moh.typea.nopphi.loai" /> </th>
                                    <th class="text-center"> <spring:message code="moh.typea.nopphi.nguoi_nop" /> </th>
                                    <th class="text-center"> <spring:message code="moh.typea.hoso.dien_thoai" /> </th>
                                    <th class="text-center"> <spring:message code="moh.typea.nopphi.ngay_nop" /> </th>
                                    <th class="text-center"> <spring:message code="moh.typea.nopphi.so_hoa_don" /> </th>
                                    <th class="text-center"> <spring:message code="moh.typea.nopphi.tong_tien" /> </th>
                                    <th class="text-center"> <spring:message code="moh.typea.nopphi.ghi_chu" /> </th>
                                    <th class="text-center"> <spring:message code="common.table.col.xoa" /> </th>
                                    <th class="text-center"> <spring:message code="moh.typea.tepdinhkem.tai_ve" /> </th>
                                </tr>
                            </thead>
                            <tbody id="nopphi-container">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/app/most/01/detail.module.js?v=${version}' />" type="crazy"></script>
<script>

</script>


