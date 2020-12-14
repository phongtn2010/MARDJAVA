<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="row-border">
    <div class="col col-lg-10 col-md-10">
        <div class="row-border">
          
            <label><spring:message code="moh.typea.tepdinhkem.loai_tep" /></label><a class="nsw-require-field">*</a>
                <select id="fiLoai" name="fiLoai" class="form-control select2">
                    <option value="1"><spring:message code="moh.typea.tepdinhkem.loaitep.banphanloaittbyte" /></option>
                    <option value="2"><spring:message code="moh.typea.tepdinhkem.loaitep.phieutiepnhan" /></option>
                    <option value="3"><spring:message code="moh.typea.tepdinhkem.loaitep.giayuyquyen" /></option>
                    <option value="4"><spring:message code="moh.typea.tepdinhkem.loaitep.giayxacnhandudkbaohanh" /></option>
                    <option value="5"><spring:message code="moh.typea.tepdinhkem.loaitep.tailieumotakythuat" /></option>
                    <option value="6"><spring:message code="moh.typea.tepdinhkem.loaitep.giaychungnhanhopchuan" /></option>
                    <option value="7"><spring:message code="moh.typea.tepdinhkem.loaitep.tailieuhdsd" /></option>
                    <option value="8"><spring:message code="moh.typea.tepdinhkem.loaitep.maunhansudung" /></option>
                </select>

            
        </div>
    </div>
    <div class = "col-md-5"></div>
    <div style="clear:both"></div>
    <br>
    <div class="col-md-6" id="uploadButton">
        <button type='button' id="upload" class="btn btn-file"><spring:message code="moh.typea.button.chon_tep" /></button>
        <label id='fileIdLabelframe1'></label>
    </div>
    <div style="clear:both"></div>
    <hr>
    <div class="col-md-5"></div>
     <div class="col-lg-3" >
         <button id="btnThem" class="btn btn-info"><spring:message code="moh.typea.button.them_tep" /></button>
    </div>
    <div style="clear:both"></div>
    <br>    
    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
        <thead>
            <tr>
                <th> <spring:message code="common.table.col.stt" /></th>
                <th> <spring:message code="moh.typea.tepdinhkem.ten_tep" /> </th>
                <th> <spring:message code="moh.typea.tepdinhkem.loai_tep" /> </th>
                <th> <spring:message code="moh.typea.tepdinhkem.tai_ve" /> </th>
                <th> <spring:message code="common.table.col.xoa" /> </th>
            </tr>
        </thead>
        <tbody id="listDinhKem">
         
        </tbody>
    </table>
</div>
 <div id="dialog" title="Hệ thống tải file trang thiết bị y tế" style="display:none">
 <iframe frameborder="0" id='frame1' scrolling='no' width="500" height="250" /> 
    </iframe>
</div>        
                