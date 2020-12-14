<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b>Thông tin đề nghị được nhập khẩu chế phẩm dùng trong lĩnh vực gia dụng và y tế như sau</b></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moh.01.hanghoa.stt" /></th>
                        <th class="text-center"><spring:message code="moh.01.hanghoa.tenttb" /></th>
                        <th class="text-center"><spring:message code="moh.01.hanghoa.hamluonghc" /></th>
                        <th class="text-center"><spring:message code="moh.01.hanghoa.tacdungcuachepham" /></th>
                        <th class="text-center"><spring:message code="moh.01.hanghoa.donvitinh" /></th>
                        <th class="text-center"><spring:message code="moh.01.hanghoa.soluong" /></th>
                        <th class="text-center"><spring:message code="moh.01.hanghoa.tendiachinsx" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHangHoas">
                    <tr>
                        <td data-bind="text: fiStt"></td>  
                        <td data-bind="text: fiTenCp"></td>  
                        <td data-bind="text: fiHamLuong"></td>  
                        <td data-bind="text: fiTacDungCp"></td>  
                        <td data-bind="text: fiDviTinh"></td>  
                        <td data-bind="text: fiSoLuong"></td>  
                        <td data-bind="text: fiTenNsx"></td>  
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHangHoaMessage" style="color:red;"> </span>
            <br />                       
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label>Mục đích nhập khẩu </label>
            </div>
            <div class="col-md-10">
                <select class="form-control select2 fiMaMdichNk" disabled id="fiMaMdichNk" name="fiMaMdichNk" 
                        data-bind="value: fiMaMdichNk,
                                optionsCaption: 'Chọn...', 
                                optionsValue : 'id',
                                optionsText : 'name',
                                options : lstMucDichNhapKhau"></select>
                <input type="hidden" id="fiTenDvNhan" name="fiTenMdichNk" data-bind="value : fiTenMdichNk"/>
            </div>
        </div>  
    </div>
</fieldset>
