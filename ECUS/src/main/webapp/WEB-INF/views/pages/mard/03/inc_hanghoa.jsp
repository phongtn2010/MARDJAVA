<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>    
    <legend style="color: dodgerblue;">
        <b><spring:message code="mard.03.hoso.hanghoa" /></b>&nbsp;
        <a href="javascript:void(0);" class="btn blue" id="btnThemHH" data-bind="click : btnAddHangHoa03">
            <i class="fa fa-plus" ></i> <spring:message code="mard.03.hoso.hanghoa.btnthem" />
        </a>
    </legend>

    <%@include file="inc_hanghoa_1.jsp" %>
    <%@include file="inc_hanghoa_2.jsp" %>

</fieldset>

