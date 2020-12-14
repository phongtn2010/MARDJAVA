<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="row-border">
    <div class="row-border">
        <form role="form" class="form-horizontal" id="tlk-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w50"> <spring:message code="common.table.col.stt" /></th>
                        <th class="w150"> <spring:message code="most.01.tailieukhac.loaitailieu" /></th>
                        <th class="w150 nsw-text-center"> <spring:message code="most.01.tailieukhac.ngay" /></th>
                        <th> <spring:message code="most.01.tailieukhac.file" /></th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.tailieukhac.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="tlk-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="tlk-tmpl">
                        <td></td>
                        <td class="w400">
                            <select id="fiMaLoai" name="fiMaLoai" class="form-control select2" require="true" field="most_01_tailieukhac_loaitailieu">
                                <option value="-1"><spring:message code="common.chon" /></option>
                                <c:forEach items="${loaidinhkem.data}" var="item">
                                    <option value="${item.fiMa}">${item.fiTen}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="fiTenLoai" value="" id="fiTenLoai"/>
                        </td>
                        <td class="w150">
                            <input name="fiNgayCap" id="txtNgayTLK" require="true" field="most_01_tailieukhac_ngay" value="" 
                                   class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="tailieukhac-ip" type="file"> </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>                        
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.tailieukhac.command.luu" />" 
                                  data-container="body" id="btnThemMoiTLK"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</div>