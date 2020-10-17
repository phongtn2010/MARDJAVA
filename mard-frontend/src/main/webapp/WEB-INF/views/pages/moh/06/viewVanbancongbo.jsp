<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<form role="form" class="form-horizontal" id="form-tths">
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">                
                <label><spring:message code="moh.typea.so_van_ban" /><a class="nsw-require-field">*</a></label>                
            </div>

            <div class="col-md-4">                                        
                <input class="form-control" value="${hoso.fiSovanban}" type="text" readonly="readonly">
            </div>

            <div class="col-md-2">
                <label><spring:message code="moh.typea.don_vi_nhan_ho_so" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline" value="${hoso.fiTendv}" type="text" readonly /> 
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
                    <input class="form-control" type="text" value = "${hoso.fiTendn}" readonly="readonly">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.email" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" value="${hoso.fiEmaildn}" type="text" readonly>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.mst" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" value="${hoso.fiMst}" type="text" readonly>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.dien_thoai" /></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control form-control-inline" value="${hoso.fiSodtdn}" type="text" readonly/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.dia_chi" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" value="${hoso.fiDiachidn}" type="text" readonly>
                </div>

                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.fax" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" value="${hoso.fiFaxdn}" type="text" readonly />
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.tinh_thanh_pho" /><a class="nsw-require-field">*</a></label>                    
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" value="${hoso.fiTentinh}" type="text" readonly />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.quan_huyen" /></label><a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-4">
                     <input class="form-control form-control-inline" value="${hoso.fiTenquanhuyen}" type="text" readonly />
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
                    <input type="text" class="form-control" value = "${hoso.fiTennguoidaidien}" readonly="readonly">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.dien_thoai" /></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control form-control-inline" value="${hoso.fiDienthoaicd}" type="text" readonly/>
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
                    <input class="form-control" value="${hoso.fiCmnd}" type="text" readonly>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.di_dong" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" value="${hoso.fiDienthoaidd}" type="text" readonly />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.noi_cap" /></label> 
                </div>
                <div class="col-md-4">
                    <input class="form-control" value="${hoso.fiNoicap}" readonly type="text" >
                </div>
                <div class="col-md-2">
                    <label><spring:message code="moh.typea.hoso.ngay_cap" /></label>
                    <a class="nsw-require-field">*</a>
                </div>
                <div class="col-md-4">
                    <input class="form-control" value="<fmt:formatDate value="${hoso.fiNgaycap}" pattern="dd/MM/yyyy" />" 
                           data-date-format="dd/mm/yyyy" type="text" readonly>
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
        </tr>

    </thead>
    <tbody id="list-container">
        <c:if test="${!empty hoso.thietBi}">
            <tr>      
                <td>1</td>
                <td>${hoso.thietBi.fiTen}</td>
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
                <td>${hoso.thietBi.fiLoai}</td>
                <td>${hoso.thietBi.fiHangsx}</td>  
                <td>${hoso.thietBi.fiDiachisx}</td>  
                <td>${hoso.thietBi.fiTieuchuan}</td>                
            </tr>
        </c:if>
    </tbody>
</table>