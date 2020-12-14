<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<input type="hidden" value="${ IS_SIGN_KEY }" id="kySo"/>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="caption-subject bold uppercase">Xem giấy phép</span>
            </div>
            <jsp:include page="../p56/licenseTemplate.jsp"/>
        </div>
    </div>

    <div class="form-group nsw-text-center">
        <a href="javascript:;"
           data-bind="click: $root.dong" class="btn red bt-center btwidth" id="btDong"> <i
                class="fa fa-times" aria-hidden="true"></i></i>&nbsp;
            <spring:message code="common.button.dong"/> </a>
    </div>
</div>
<script type="text/javascript"
        src="<c:url value="/app/mt/qlgp/p56/license.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript"
        src="<c:url value="/app/mt/qlgp/p56/model.js?v=${ version }"/>"
        charset="utf-8"></script>
<script>
    var giayPhepId = "${giayPhepId}";
</script>
<script>
    if (giayPhepId) {
        var procedureId = '${procedureId}';
    }
</script>
<script>
    var type = "${type}";
</script>