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
            <jsp:include page="../p19/licenseTemplate.jsp"/>
        </div>
    </div>

    <div class="form-group nsw-text-center">
        <a class="btn green bt-center btwidth" id="btSua"
           data-bind="click: $root.suaGiayPhep,visible : type == 1"> <i
                class="fa fa-edit" aria-hidden="true"></i> &nbsp;
            Xin sửa giấy phép </a>
        <a class="btn blue bt-center btwidth" id="btTra"
           data-bind="click: $root.traGiayPhep,visible : type == 1"> <i
                class="fa fa-undo" aria-hidden="true"></i>&nbsp;
            Trả lại giấy phép </a>
        <a href="javascript:;"
           data-bind="click: $root.dong" class="btn red bt-center btwidth" id="btDong"> <i
                class="fa fa-times" aria-hidden="true"></i></i>&nbsp;
            <spring:message code="common.button.dong"/> </a>
    </div>
</div>
<script type="text/javascript"
        src="<c:url value="/app/mt/p19/license.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript"
        src="<c:url value="/app/mt/p19/model.js?v=${ version }"/>"
        charset="utf-8"></script>
<script>
    var giayPhepId = "${giayPhepId}";
</script>
<script>
    var type = "${type}";
</script>
<script>
    if (giayPhepId) {
        var procedureId = '${procedureId}';
    }
</script>