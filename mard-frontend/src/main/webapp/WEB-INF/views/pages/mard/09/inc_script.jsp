<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript">     
    var RAW_HS_STATUS = null;
    var CSRF_TOKEN_NAME = $('#csrfHeader').val();
    var CSRF_TOKEN_VALUE = $('#csrfToken').val();
    var getCategory = function(key, id, callback){
        return $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/12/danhmuc" + "?key=" + key + "&id=" + (id ? id : ""),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
            },
            success: function (res) {
                callback(res);
            }
        });
    };
</script>
<script src="<c:url value='/app/mard/knockout.validation.extender.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/knockout-file-bindings.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value='/app/mard/moment-with-locales.min.js?v=${version}'/>" type="text/javascript" charset="utf-8"></script>