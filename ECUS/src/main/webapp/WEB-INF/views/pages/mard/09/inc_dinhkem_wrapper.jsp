<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 1/15/20
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
    <div data-bind="visible: loaiHoso() == 1">
        <!-- ko with: form03VM() -->
        <%@include file="inc_dinhkem.jsp"%>
        <!-- /ko -->
    </div>
    <div data-bind="visible: loaiHoso() == 2">
        <!-- ko with: form20VM() -->
        <%@include file="inc_dinhkem20a.jsp"%>
        <!-- /ko -->
    </div>
</fieldset>
