<%-- 
    Document   : incScript
    Created on : Aug 23, 2017, 3:50:51 PM
    Author     : phongnv
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript">     
    var CSRF_TOKEN_NAME = $('#csrfHeader').val();
    var CSRF_TOKEN_VALUE = $('#csrfToken').val();
    var userData = ${user};
    var hosoUsername = userData['username'];
    var hosoCompanyName = userData['companyName'];
    var hosoCompanyAddress = userData['companyAddress'];
    var hosoCompanyPhoneNumber = userData['companyPhoneNumber'];
    var hosoCompanyFax = userData['companyFax'];
    var hosoCompanyEmail = userData['companyEmail'];
</script>
<style type="text/css">
    .overlay {
        opacity:0.05;
        background-color:#ccc;
        position:fixed;
        width:100%;
        height:100%;
        top:0px;
        left:0px;
        z-index:1000;
    }
    #loading08{
        position: fixed;
        z-index: 1000000;
        width: 140px;
        background: white;
        right: 48%;
        bottom: 50%;
        border-radius: 5px;
        text-align: center;
        height: auto;
        padding: 5px;
        box-sizing: border-box;
        border: solid 1px #f0f0f0;
        display: none;
    }
    #loading08 img{
        display: block;
        margin: 0 auto;
        height: 32px;
        width: 32px;
    }
    #loading08 div{
        width: 100%;
        text-align: center;
        color : #3598dc;
    }
    fieldset {
        margin: 10px 0px;
    }
    a .fa {
        padding: 0px 5px;
    }
</style>
<div id="loading08">
    <div class="overlay"></div>
    <img src="data:image/gif;base64,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"/>
    <div>Đang thực hiện...</div>
</div>
<script src="<c:url value='/app/mard/moment-with-locales.min.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
