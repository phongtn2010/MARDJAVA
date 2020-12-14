<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-body">
                <div class="row">
                    <div class="col-md-12">
                        <form class="form-horizontal" id="form-np">
                            <div class ="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2">
                                        <span style ="color:red" >Thông tin thanh toán của đơn vị nhận hồ sơ</span>
                                    </div>
                                    <div class ="col col-md-6">
                                        <div id="ttthanhtoan"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col col-md-12">
                                    <div class="col-md-2 pull-left">
                                        <label><spring:message code="moh.typea.nopphi.loaiphi" /></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input type="hidden" name="fiLoaiphi" value="${loaiphi}" />
                                         <c:choose>
                                            <c:when test="${loaiphi == 1}"><spring:message code="moh.typea.nopphi.nop_moi" /></c:when>
                                            <c:when test="${loaiphi == 2}"><spring:message code="moh.typea.nopphi.nop_bo_xung" /></c:when>
                                        </c:choose>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2">
                                        <label><spring:message code="moh.typea.nopphi.nguoi_nop" />
                                            <a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiNguoinop" name="fiNguoinop" maxlength="250" require="true" 
                                               field="most_01_dondk_nguoi_nop" type="text" value = "">
                                        <label class="input-invaild-text" id="message-fiNguoinop"></label>
                                    </div>
                                    <div class="col-md-2">
                                        <label><spring:message code="moh.typea.hoso.dien_thoai" />
                                            <a class="nsw-require-field">*</a>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiSdt" name="fiSdt" maxlength="50" require="true"
                                               field="most_01_nopphi_dien_thoai" type="text" >
                                        <label class="input-invaild-text" id="message-fiSdt"></label>
                                    </div>
                                </div>  
                            </div> 
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2">
                                        <label><spring:message code="moh.typea.nopphi.ngay_nop" />
                                            <a class="nsw-require-field">*</a>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control form-control-inline date-picker" id="fiNgaynop" name="fiNgaynop" maxlength="250" require="true" 
                                               value="" data-date-format="dd/mm/yyyy" field="most_01_dondk_ngay_nop" type="text" size="40">
                                        <label class="input-invaild-text" id="message-fiNgaynop"></label>
                                    </div>
                                    <div class="col-md-2">
                                        <label><spring:message code="moh.typea.nopphi.so_hoa_don" />
                                            <a class="nsw-require-field">*</a>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiSohoadon" name="fiSohoadon" maxlength="50" require="true" 
                                               value="" field="most_01_nopphi_so_hoa_don" type="text" >
                                        <label class="input-invaild-text" id="message-fiSohoadon"></label>
                                    </div>
                                </div>  
                            </div> 
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2">
                                        <label><spring:message code="moh.typea.nopphi.tong_tien" /></label>
                                            <a class="nsw-require-field">*</a>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiTongtien" name="fiTongtien" maxlength="20" require="true" 
                                               value="" field="most_01_nopphi_tongtien" type="text"  is="number">
                                        <label class="input-invaild-text" id="message-fiTongtien"></label>
                                    </div>
                                    <div class="col-md-2">
                                        <label><spring:message code="moh.typea.nopphi.ghi_chu" />
                                    </div>
                                    <div class="col-md-4">
                                        <textarea class="form-control" name="fiGhichu" cols="46" maxlength="500"></textarea>
                                    </div>
                                </div>  
                            </div> 
                            <div class="form-group themNopPhi">
                                <div class="col-md-12">
                                    <div class="pull-left"><label><spring:message code="moh.typea.nopphi.tai_len_tep" /></label></div>
                                    <div class="col-lg-3">
                                    <button type='button' id="buttonNopphi" class="btn btn-file"><spring:message code="moh.typea.button.chon_tep" /></button>
                                    <label id='fileIdLabelframe3'></label>
                                   </div>
                                   
                                </div>
                            </div>
                            <div class="form-group themNopPhi">
                                <div class="col-lg-5"></div>
                                <button type="button" id="themNopPhi" class ="btn btn-success" style="margin:0 auto" > <spring:message code="moh.typea.button.them" /> </button>
                            </div>
                        </form>
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                        <thead>
                            <tr>
                                <th class="text-center"> <spring:message code="common.table.col.stt" /></th>
                                <th class="text-center"> <spring:message code="moh.typea.nopphi.loai" /> </th>
                                <th class="text-center"> <spring:message code="moh.typea.nopphi.nguoi_nop" /> </th>
                                <th class="text-center"> <spring:message code="moh.typea.hoso.dien_thoai" /> </th>
                                <th class="text-center"> <spring:message code="moh.typea.nopphi.ngay_nop" /> </th>
                                <th class="text-center"> <spring:message code="moh.typea.nopphi.so_hoa_don" /> </th>
                                <th class="text-center"> <spring:message code="moh.typea.nopphi.tong_tien" /> </th>
                                <th class="text-center"> <spring:message code="moh.typea.nopphi.ghi_chu" /> </th>
                                <th class="text-center"> <spring:message code="common.table.col.xoa" /> </th>
                                <th class="text-center"> <spring:message code="moh.typea.tepdinhkem.tai_ve" /> </th>
                            </tr>
                        </thead>
                        <tbody id="nopphi-container">
                           
                        </tbody>
                    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/app/most/01/detail.module.js?v=${version}' />" type="crazy"></script>
<script>
   
</script>


