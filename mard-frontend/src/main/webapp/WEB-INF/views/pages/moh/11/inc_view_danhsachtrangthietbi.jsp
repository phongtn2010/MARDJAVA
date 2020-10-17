<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b>Thông tin số đăng ký đã cấp</b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Số đăng ký lưu hành BCD <a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-10">
                <input class="form-control" readonly type="text" id="fiSoDklh" name="fiSoDklh" data-bind="value : fiSoDklh" maxlength="50" />
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
            </div>
            <div class="col-md-10">
                <input type="checkbox" disabled id="fiDacoSoDklh" name="fiDacoSoDklh" 
                       data-bind="checked: fiDacoSoDklh" /><label> Đã có số đăng ký trên 1 cửa</label>
            </div>
        </div>  
    </div>
</fieldset>
