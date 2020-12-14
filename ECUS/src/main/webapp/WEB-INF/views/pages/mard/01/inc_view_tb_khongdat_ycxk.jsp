<%--
  Created by IntelliJ IDEA.
  User: hungtran
  Date: 1/13/20
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
    <div id="modal_xem_tb_khongdat_ycxk" class="modal container in modal-overflow" tabindex="-1"
         data-backdrop="static" data-keyboard="false"
    >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <b class="modal-title">Công văn thông báo kết quả không đạt yêu cầu xuất khẩu</b>
        </div>
        <div class="modal-body container">
            <div>
                <p class="content">
                    Mã hồ sơ: <span style="font-weight: bold" data-bind="text: fiNSWFileCode"></span>
                </p>
                <p class="content">
                    Chuyên viên xử lý: <span style="font-weight: bold" data-bind="text: fiCreaterName"></span>
                </p>
                <p class="content">
                    Nội dung thông báo: <span style="font-weight: bold" data-bind="text: fiDispatchContent"></span>
                </p>

                <p class="content" data-bind="visible: fileAvailable">
                    Tải công văn: <a data-bind="attr: {href: downloadLink}" download>Tải xuống</a>
                </p>
                <br/>
                <br/>
            </div>
        </div>
        <div class="modal-footer">
        </div>
    </div>
</div>
