<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="incLanguage.jsp"%>

<div class="col-md-12">
	<div class="row">
		<div class="form-group">
			<textarea rows="3" id="xinSuaHoSoModel_LyDoSua" class="form-control form-control-inline " data-bind="value: xinSuaHoSoModel.lyDoSua, enable: !$root.xemHoSo()"></textarea>
		</div>
	</div>
</div>