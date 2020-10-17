
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="row" id="EditVM">
    <div class="col-md-12">
        <form role="form" class="form-horizontal">
            <!-- ko with: fiBuyer() -->
            <%@include file="inc_benmuahang.jsp" %>
            <!-- /ko -->
            <%@include file="inc_benbanhang.jsp" %>
            <%@include file="inc_thongtinhanghoa.jsp" %>

            <!-- ko with: documentsVM() -->
            <%@include file="inc_documents.jsp"%>
            <!-- /ko -->

            <!-- ko with: kyHoSoVM() -->
            <%@include file="inc_thongtinkydon.jsp"%>
            <!-- /ko -->
        </form>
    </div>
</div>
