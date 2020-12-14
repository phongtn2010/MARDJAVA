<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset style="margin-top: 15px" id="ld02">
    <div data-bind="with : tbdLydo02">
        <legend>
            <b style="color: dodgerblue;"><spring:message code="moh.02.hoso.lydo"/></b>
        </legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="moh.02.hoso.lydo.mucdich"/></label>
                </div>
                <div class="col-md-10">
                    <textarea style="resize: vertical; resize: none; overflow-x: hidden;" class="form-control" name="fiMucdichSd" data-bind="value: fiMucdichSd" maxlength="512" disabled></textarea>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="moh.02.hoso.lydo.tendanhsach"/></label>
                </div>
                <div class="col-md-10">
                    <textarea style="resize: vertical; resize: none; overflow-x: hidden;" class="form-control" name="fiTenTlDk" data-bind="value: fiTenTlDk" maxlength="512" disabled></textarea>
                </div>
            </div>
        </div>
    </div>
</fieldset>
