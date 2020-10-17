<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="form-ddk">
    <input type="hidden" name="fiIdHoso" id="fiIdHoso" value="${hoso.fiIdHoso}"/>    
    <input type="hidden" name="fiTenTcht" id="fiTenTcht" value="${hoso.fiTenTcht}"/>
    <input type="hidden" name="fiTenTcdg" id="fiTenTcdg" value="${hoso.fiTenTcdg}"/>
    <input type="hidden" name="fiTrangThai" id="fiTrangThai" value="${hoso.fiTrangThai}"/>
    <input type="hidden" name="fiIdCqxl" id="fiIdCqxl" value="${hoso.fiIdCqxl}"/>
    <input type="hidden" name="fiMaHoSo" id="fiIdCqxl" value="${hoso.fiMaHoSo}"/>
    <input type="hidden" name="fiTotalFileSize" id="fiTotalFileSize" value="0"/>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.loaihoso" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select id="fiDocumenttype" name="fiDocumenttype" require="true" class="form-control select2" data="${hoso.fiDocumenttype}">                    
                    <option value="1">Loại 1</option>
                    <option value="2">Loại 2</option>
                </select>
            </div>
                <div class="col-md-6">
                    <b id="documenttype-note" style="color: red;"></b>
                </div>
        </div>    
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.ten_tc_kiem_tra_dukien" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                                        
                <select id="fiMaTckt" name="fiMaTckt" class="form-control select2" data="${hoso.fiMaTckt}" 
                        require="true" field="most_01_dondk_ten_tc_kiem_tra_dukien">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${tckts.data}" var="item">
                        <option value="${item.fiMa}">${item.fiTen}</option>
                    </c:forEach>
                </select>
                <label class="input-invaild-text" id="message-fiMaTckt"></label>
            </div>

            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.ma_so_thue" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input name="fiMst" id="fiMst" require="true" field="most_01_dondk_ma_so_thue" maxlength="13" 
                       readonly="true" class="form-control" placeholder="<spring:message code="most.01.dondk.ma_so_thue" />" value="${hoso.fiMst}" type="text" />
                <label class="input-invaild-text" id="message-fiMst"></label>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.nguoi_nhap_khau" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiNk" name="fiNguoiNk" maxlength="255" require="true" value="${hoso.fiNguoiNk}" 
                       readonly="true"  field="most_01_dondk_nguoi_nhap_khau" placeholder="<spring:message code="most.01.dondk.nguoi_nhap_khau" />" type="text">
                <label class="input-invaild-text" id="message-fiNguoiNk"></label>
            </div>
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.dia_chi_nguoi_nhap_khau" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiNnk" name="fiDiachiNnk" maxlength="255" require="true" value="${hoso.fiDiachiNnk}"  
                       readonly="true"  field="most_01_dondk_dia_chi_nguoi_nhap_khau" placeholder="<spring:message code="most.01.dondk.dia_chi_nguoi_nhap_khau" />" type="text">
                <label class="input-invaild-text" id="message-fiDiachiNnk"></label>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.dien_thoai_nguoi_nhap_khau" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDtNnk" name="fiDtNnk" value="${hoso.fiDtNnk}" maxlength="50" require="true" 
                       field="most_01_dondk_dien_thoai_nguoi_nhap_khau" placeholder="<spring:message code="most.01.dondk.dien_thoai_nguoi_nhap_khau" />" type="text">
                <label class="input-invaild-text" id="message-fiDtNnk"></label>
            </div>
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.fax_nguoi_nhap_khau" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiFaxNnk" name="fiFaxNnk" value="${hoso.fiFaxNnk}" maxlength="50" 
                       field="<spring:message code="most.01.dondk.fax_nguoi_nhap_khau" />"   placeholder="<spring:message code="most.01.dondk.fax_nguoi_nhap_khau" />" type="text">
                <label class="input-invaild-text" id="message-fiDtNnk"></label>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.nguoi_lien_he" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNguoiLh" name="fiNguoiLh" value="${hoso.fiNguoiLh}" maxlength="100" 
                       require="true" field="most_01_dondk_nguoi_lien_he" placeholder="<spring:message code="most.01.dondk.nguoi_lien_he" />" 
                       type="text">
                <label class="input-invaild-text" id="message-fiNguoiLh"></label>
            </div>
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.email" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiEmailNnk" name="fiEmailNnk" is="email" field="most_01_dondk_email" value="${hoso.fiEmailNnk}" maxlength="50" 
                       placeholder="<spring:message code="most.01.dondk.email" />" type="text">
                <label class="input-invaild-text" id="message-fiEmailNnk"></label>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.diachi_duahanghoa_vekhobaoquan" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiDiachiKho" name="fiDiachiKho" value="${hoso.fiDiachiKho}" maxlength="255" 
                       field="<spring:message code="most.01.dondk.diachi_duahanghoa_vekhobaoquan" />"  placeholder="<spring:message code="most.01.dondk.diachi_duahanghoa_vekhobaoquan" />" type="text">
                <label class="input-invaild-text" id="message-fiDiachiKho"></label>
            </div>
            <div class="col-md-2">
                <label><spring:message code="most.01.tracuu.ten_tc_danh_gia_phuhop" /></label>
            </div>
            <div class="col-md-4">
                <select id="fiMaTcdg" name="fiMaTcdg" class="form-control select2" data="${hoso.fiMaTcdg}" field="<spring:message code="most.01.tracuu.ten_tc_danh_gia_phuhop" />">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${tcdgs.data}" var="item">
                        <option value="${item.fiMa}">${item.fiTen}</option>
                    </c:forEach>
                </select>
                <label class="input-invaild-text" id="message-fiMaTcdg"></label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.thoigian_dukien_lohangnhapkhau_tungay" /></label>
            </div>
            <div class="col-md-4">                                        
                <input class="form-control form-control-inline input-medium date-picker" value="<fmt:formatDate value="${hoso.fiTuNgay}" pattern="dd/MM/yyyy" />" 
                       field="most_01_dondk_thoigian_dukien_lohangnhapkhau_tungay" id="fiTuNgay" name="fiTuNgay" data-date-format="dd/mm/yyyy" size="16" type="text" />
                <label class="input-invaild-text" id="message-fiTuNgay"></label>
            </div>

            <div class="col-md-2">
                <label><spring:message code="most.01.dondk.thoigian_dukien_lohangnhapkhau_denngay" /></label>
            </div>
            <div class="col-md-4">
                <input class="form-control form-control-inline input-medium date-picker" 
                       value="<fmt:formatDate value="${hoso.fiDenNgay}" pattern="dd/MM/yyyy" />" id="fiDenNgay" name="fiDenNgay" 
                       data-date-format="dd/mm/yyyy" size="16" type="text" field="most_01_dondk_thoigian_dukien_lohangnhapkhau_denngay"/>
                <label class="input-invaild-text" id="message-fiDenNgay"></label>
            </div>
        </div>  
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2">
                <label><spring:message code="common.quy_chuan_viet_nam" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <select id="fiMaQcvn" name="fiMaQcvn" class="form-control select2" data="${hoso.fiMaQcvn}"
                        require="true" field="most_01_dondk_qcnvn">
                    <option value="-1"><spring:message code="common.chon" /></option>
                    <c:forEach items="${qcvn.data}" var="item">
                        <option value="${item.fiMa}">${item.fiTen}</option>
                    </c:forEach>
                </select>
                <label class="input-invaild-text" id="message-fiMaQcvn"></label>
            </div>
            <div class="col-md-2">
                <label><spring:message code="common.ghichu" /></label>
            </div>
            <div class="col-md-4">
                <textarea id="fiGhichu" name="fiGhichu" maxlength="500" class="form-control" field="<spring:message code="common.ghichu" />" placeholder="<spring:message code="common.ghichu" />"
                          height="200px">${hoso.fiGhichu}</textarea>
                <label class="input-invaild-text" id="message-fiGhichu"></label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2" id="lb-qcvn-name">
                <label><spring:message code="common.ten_quy_chuan_viet_nam" /><a class="nsw-require-field">*</a></label>                
            </div>
            <div class="col-md-4" id="lb-qcvn-valname">
                <input class="form-control" id="fiTenQcvn" name="fiTenQcvn" maxlength="255" value="${hoso.fiTenQcvn}" 
                       field = "<spring:message code="common.ten_quy_chuan_viet_nam" />" type="text">                
                <label class="input-invaild-text" id="message-fiTenQcvn"></label>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-4"></div>
        </div>

    </div>
</form>