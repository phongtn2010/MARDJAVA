<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<form role="form" class="form-horizontal" id="form-tths">
    <input type="hidden" id="fiIdHoso" name="fiIdHoso" value="${hoso.fiIdHoso}"/>
    <input type="hidden" id="fiNguoitao" name="fiNguoitao" value="${fn:escapeXml(hoso.fiMst)}"/>
    <c:if test="${!empty hoso.fiMaHoso}">
        <input type="hidden" id="fiMaHoso" name="fiMaHoso" value="${hoso.fiMaHoso}"/>
    </c:if>
    <input type="hidden" id="fiHoatdong" name="fiHoatdong" value="${hoso.fiHoatdong}"/>
    <input type="hidden" id="fiTrangthai" name="fiTrangthai" value="${hoso.fiTrangthai}"/>
    <input type="hidden" id="fiTentrangthai" name="fiTentrangthai" value="${fn:escapeXml(hoso.fiTentrangthai)}"/>
    <input type="hidden" id="fiNgaytao" name="fiNgaytao" value="<fmt:formatDate value="${hoso.fiNgaytao}" pattern="dd/MM/yyyy HH:mm:ss" />"/>
    <input type="hidden" id="fiLoaihinhdn" name="fiLoaihinhdn" value="${fn:escapeXml(hoso.fiLoaihinhdn)}"/>
    <input type="hidden" id="fiPhongbanquanly" name="fiPhongbanquanly" value="${fn:escapeXml(hoso.fiPhongbanquanly)}"/>
    <input type="hidden" id="fiTentienganhdn" name="fiTentienganhdn" value="${fn:escapeXml(hoso.fiTentienganhdn)}"/>
    <input type="hidden" id="fiTenviettatdn" name="fiTenviettatdn" value="${fn:escapeXml(hoso.fiTenviettatdn)}"/>
    <input type="hidden" id="fiSodkkd" name="fiSodkkd" value="${fn:escapeXml(hoso.fiSodkkd)}"/>
    <input type="hidden" id="fiNamthanhlap" name="fiNamthanhlap" value="${hoso.fiNamthanhlap}"/>
    <input type="hidden" id="fiWebsite" name="fiWebsite" value="${fn:escapeXml(hoso.fiWebsite)}"/>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">                
                <label><spring:message code="moh.typea.so_van_ban" /><a class="nsw-require-field">*</a></label>                
            </div>

            <div class="col-md-4">                                        
                <input class="form-control" id="fiSovanban" name="fiSovanban" maxlength="20" require="true" value="${fn:escapeXml(hoso.fiSovanban)}" 
                       field="moh_typea_sovanban"  type="text">
                <label class="input-invaild-text" id="message-fiSovanban"></label>
            </div>

            <div class="col-md-2">
                <label><spring:message code="moh.typea.don_vi_nhan_ho_so" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select name="fiMadv" id="fiMadv" require="true" field="moh_typea_don_vi_nhan_ho_so" maxlength="13" data="${hoso.fiMadv}"
                        class="form-control" placeholder="<spring:message code="moh.typea.don_vi_nhan_ho_so" />" />               
                <option value="-1"><spring:message code="common.chon" /></option>
                <c:forEach items="${donviList.data}" var="donvi">
                    <option value="${donvi.fiMadonvi}" provincecode="${donvi.fiMaDvhc}">${fn:escapeXml(donvi.fiTendonvi)}</option>
                </c:forEach>
                </select>   
                <label class="input-invaild-text" id="message-fiMadv"></label>
            </div>
        </div>  
    </div>
    </br>
    <div style="clear:both"></div>
    <fieldset>
        <legend><spring:message code="moh.typea.hoso.thong_tin_doanh_nghiep" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.ten_co_so" />
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTendn" name="fiTendn" maxlength="255"  
                           type="text" value = "${fn:escapeXml(hoso.fiTendn)}" readonly="readonly">
                    <label class="input-invaild-text" id="message-fiTendn"></label>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.email" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmaildn" name="fiEmaildn"  maxlength="50" 
                           placeholder="<spring:message code="moh.typea.hoso.email" />" value="${fn:escapeXml(hoso.fiEmaildn)}" type="text" readonly>
                      <label class="input-invaild-text" id="message-fiEmaildn"></label>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.mst" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMst" name="fiMst"  maxlength="50" 
                           field="moh_typea_hoso_ma_so_thue" value="${fn:escapeXml(hoso.fiMst)}" type="text" readonly>
                    
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.dien_thoai" /></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control form-control-inline" id="fiSodtdn" name="fiSodtdn" value="${fn:escapeXml(hoso.fiSodtdn)}" type="text" readonly/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.dia_chi" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDiachidn" name="fiDiachidn"  maxlength="250"  
                           placeholder="<spring:message code="moh.typea.hoso.dia_chi" />" value="${fn:escapeXml(hoso.fiDiachidn)}" type="text" readonly>
                </div>

                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.fax" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxdn" name="fiFaxdn" value="${fn:escapeXml(hoso.fiFaxdn)}" type="text" readonly />
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.tinh_thanh_pho" /><a class="nsw-require-field">*</a></label>                    
                </div>
                <div class="col-md-4">
                    <select id="fiMatinh" name="fiMatinh" class="form-control select2" require="true" field="moh_typea_tinh" 
                            required="true" data="${hoso.fiMatinh}">
                        <option value="-1"><spring:message code="common.chon"/></option>
                        <c:forEach items="${tinh.data}" var="tinh">
                            <option value="${fn:trim(tinh.fiMa)}" data="${tinh.fiId}">${fn:escapeXml(tinh.fiTen)}</option>
                        </c:forEach>
                    </select>
                    <label class="input-invaild-text" id="message-fiMatinh"></label>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.quan_huyen" /></label><a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-4">
                    <select id="fiMaquanhuyen" name="fiMaquanhuyen" class="form-control select2" field="moh_typea_quanhuyen" require="true" data="${hoso.fiMaquanhuyen}">
                        <option value="-1"><spring:message code="common.chon" /></option>
                    </select>
                    <label class="input-invaild-text" id="message-fiMaquanhuyen"></label>
                </div>
            </div>
        </div>
        <hr>
    </fieldset>

    <fieldset>
        <legend><spring:message code="moh.typea.hoso.thong_tin_nguoi_dai_dien" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.ho_ten" />
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTennguoidaidien" name="fiTennguoidaidien" maxlength="255" require="true" 
                           type="text" value = "${fn:escapeXml(hoso.fiTennguoidaidien)}" readonly="readonly">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.dien_thoai" /></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control form-control-inline" name="fiDienthoaicd" id="fiDienthoaicd" value="${fn:escapeXml(hoso.fiDienthoaicd)}" type="text" readonly/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.so_cmt" />
                    </label><a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiCmnd" name="fiCmnd" value="${fn:escapeXml(hoso.fiCmnd)}" maxlength="50" require="true" field="moh_typea_cmt" type="text">
                    <label class="input-invaild-text" id="message-fiCmnd"></label>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.di_dong" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiDienthoaidd" name="fiDienthoaidd" value="${fn:escapeXml(hoso.fiDienthoaidd)}" type="text" readonly />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.noi_cap" /></label> 
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoicap" name="fiNoicap" value="${fn:escapeXml(hoso.fiNoicap)}" maxlength="250"  type="text" >
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.ngay_cap" /></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline date-picker" id="fiNgaycap" name="fiNgaycap" value="<fmt:formatDate value="${hoso.fiNgaycap}" pattern="dd/MM/yyyy" />"
                           data-date-format="dd/mm/yyyy" type="text" require="true" field="moh_typea_ngaycap" >
                    <label class="input-invaild-text" id="message-fiNgaycap"></label>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
            </div>  
        </div>
        <hr>
    </fieldset>
</form>

<br>
<button id="btnAddEquipment" class="btn btn-primary">Khai báo trang thiết bị y tế</button>
<table class="table table-striped table-bordered table-hover table-checkable order-column vanban" id="sample_1">
    <thead>
        <tr>
            <th class="text-center"> <spring:message code="common.table.col.stt" /></th>
            <th class="text-center"> <spring:message code="moh.typea.thietbi.ten" /> </th>
            <th class="text-center"> <spring:message code="moh.typea.chitiettb.phan_nhom" /> </th>
            <th class="text-center"> <spring:message code="moh.typea.thietbi.ma_san_pham" /> </th>
            <th class="text-center"> <spring:message code="moh.typea.thietbi.ten_co_so_san_xuat" /> </th>
            <th class="text-center"> <spring:message code="moh.typea.thietbi.dia_chi_co_so" /> </th>
            <th class="text-center"> <spring:message code="moh.typea.thietbi.tieu_chuan_ap_dung" /> </th>
            <th class="text-center"> <spring:message code="common.table.col.xoa" /></th>
        </tr>

    </thead>
    <tbody id="list-container">
        <c:if test="${!empty hoso.thietBi}">
            <tr>      
                <td>1</td>
                <td>${fn:escapeXml(hoso.thietBi.fiTen)}</td>
                <td>
                    <display:column>
                        <c:choose>
                            <c:when test="${hoso.thietBi.fiPhannhom == 0}"><spring:message code="moh.06.chitiettb.phannhom.donle" /></c:when>
                            <c:when test="${hoso.thietBi.fiPhannhom == 1}"><spring:message code="moh.06.chitiettb.phannhom.vitro" /></c:when>
                            <c:when test="${hoso.thietBi.fiPhannhom == 2}"><spring:message code="moh.06.chitiettb.phannhom.ivd" /></c:when>
                            <c:when test="${hoso.thietBi.fiPhannhom == 3}"><spring:message code="moh.06.chitiettb.phannhom.cumttbytkhac" /></c:when>
                            <c:when test="${hoso.thietBi.fiPhannhom == 4}"><spring:message code="moh.06.chitiettb.phannhom.hethongttbyt" /></c:when>
                            <c:when test="${hoso.thietBi.fiPhannhom == 5}"><spring:message code="moh.06.chitiettb.phannhom.hottbyt" /></c:when>
                        </c:choose>
                    </display:column>
                </td>
                <td>${fn:escapeXml(hoso.thietBi.fiLoai)}</td>
                <td>${fn:escapeXml(hoso.thietBi.fiHangsx)}</td>  
                <td>${fn:escapeXml(hoso.thietBi.fiDiachisx)}</td>  
                <td>${fn:escapeXml(hoso.thietBi.fiTieuchuan)}</td>  
                <td><a><i class="fa fa-close fa-lg" doc="${hanghoa.fiHosoid}" style="display: ${IsView}"></i></a></td>                  
            </tr>
        </c:if>
    </tbody>
</table>