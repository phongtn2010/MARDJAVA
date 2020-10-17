<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="page-header-top">
    <a href="<c:url value='/' />"><img src="<c:url value='/static/images/banner.png'/>" alt="CỔNG THÔNG TIN MỘT CỬA QUỐC GIA" style="border-width:0px;height: 92px;width: 100%;" /></a>
    <a href="javascript:;" class="menu-toggler"></a> 
    <c:if test="${loggedinuser != null}">
        <div class="top-menu nsw-profile">                    
            <p>
                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                    <img alt="" class="img-circle" src="<c:url value='/static/assets/layouts/layout3/img/avatar9.jpg' />" />
                    <span class="username username-hide-mobile nsw-color-w">[${loggedinuser}]</span>
                </a>
                <a href="<c:url value='/logout' />" class="nsw-color-w">
                    <i class="icon-key"></i> <spring:message code="nsw.account.logout" /> </a>
            </p>
            <p>
                <a href="https://vnsw.gov.vn/Register/ExternalUserEdit.aspx" class="nsw-color-w" target="_blank">
                    <i class="icon-user"></i> <spring:message code="nsw.account.update" />
                </a>

                <a href="https://vnsw.gov.vn/Register/ChangePassword.aspx?IsDlg=1" class="nsw-color-w" target="_blank">
                    <i class="icon-calendar"></i> <spring:message code="nsw.account.changepass" /> </a>
            </p>
        </div>
    </c:if> 
    <div class="nsw-lang-div">
        <a class="nsw-color-w" href="?lang=en">English</a> - <a class="nsw-color-w" href="?lang=vi">VI</a>
    </div>
</div>