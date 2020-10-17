<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="incLanguage.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"> <spring:message code="most.01.ten_thu_tuc" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><spring:message code="common.tracuu.thong_tin_tim_kiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm01" id="searchForm01">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ma_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text">
                                                </div>
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.trang_thai_ho_so" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2">
                                                        <option value=" "><spring:message code="common.tatca" /></option>
                                                        <option value="0">Mới tạo</option>
                                                        <option value="1">Chờ tiếp nhận</option>
                                                        <option value="15">Đang xử lý</option>
                                                        <option value="2">Đã tiếp nhận</option>
                                                        <option value="3">Từ chối tiếp nhận</option>
                                                        <option value="4">Đã rút hồ sơ</option>
                                                        <option value="5">Yêu cầu bổ sung hồ sơ</option>
                                                        <option value="6">Đã bổ sung hồ sơ theo yêu cầu</option>
                                                        <option value="7">Yêu cầu xin rút hồ sơ</option>
                                                        <option value="8">Đồng ý yêu cầu rút</option>
                                                        <option value="9">Xin sửa hồ sơ</option>
                                                        <option value="10">Đồng ý yêu cầu xin sửa</option>
                                                        <option value="11">Yêu cầu xin lùi hạn hoàn thiện hồ sơ</option>
                                                        <option value="12">Đồng ý yêu cầu lùi hạn hoàn thiện hồ sơ</option>
                                                        <option value="13">Đã có kết quả kiểm tra</option>
                                                        <option value="14">Đã thu hồi thông báo kết quả kiểm tra</option>
                                                    </select>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label ><spring:message code="most.01.tracuu.ten_tc_kiem_tra_dukien" /></label>
                                                </div>
                                                <div class="col-md-4">                                        
                                                    <select id="toChucKT" name="toChucKT" class="form-control select2">
                                                        <option value=" "><spring:message code="common.tatca" /></option>
                                                        <c:forEach items="${tckts.data}" var="item">
                                                            <option value="${item.fiMa}">${item.fiTen}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                                <div class="col-md-2">
                                                    <label ><spring:message code="most.01.tracuu.ten_tc_danh_gia_phuhop" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="toChucDanhGia" name="toChucDanhGia" class="form-control select2">
                                                        <option value=" "><spring:message code="common.tatca" /></option>
                                                        <c:forEach items="${tcdgs.data}" var="item">
                                                            <option value="${item.fiMa}">${item.fiTen}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label ><spring:message code="common.tracuu.ngay_tao_tu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" field="common_tracuu_ngay_tao_tu" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                                                </div>

                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ngay_tao_den" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="ngayTaoDenNgay" field="common_tracuu_ngay_tao_den" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ngay_gui_tu" /></label>
                                                </div>
                                                <div class="col-md-4">                                        
                                                    <input name="ngayGuiTuNgay" id="ngayGuiTuNgay" field="common_tracuu_ngay_gui_tu" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                                                </div>

                                                <div class="col-md-2">
                                                    <label><spring:message code="common.tracuu.ngay_gui_den" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayGuiDenNgay" id="ngayGuiDenNgay" field="common_tracuu_ngay_gui_den" class="form-control form-control-inline input-medium date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo"><i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" /></a>
                                            <a href="javascript:;" class="btn green" id="btnAddNew"><i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" /></a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">                            
                    <div class="col col-md-12">
                        <spring:message code="common.tong" /> <b><a id="lbTotalRecords" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"><spring:message code="common.table.col.stt" /></th>
                            <th class="text-center"><spring:message code="common.table.col.lich_su_tac_dong" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.ma_ho_so" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.loai_ho_so" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.ngay_tao" /> </th>
                            <th class="text-center"><spring:message code="most.01.table.col.cqxl" /> </th>                            
                            <th class="text-center"><spring:message code="common.table.col.ngay_gui" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.trang_thai_ho_so" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.sua_doi_bo_sung" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.yeu_cau_lui_han" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.xin_sua" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.yeu_cau_huy" /> </th>
                            <th class="text-center"><spring:message code="most.01.table.col.gcn_phu_hop" /> </th>
                            <th class="text-center"><spring:message code="most.01.table.col.xem_kq_kiem_tra_chat_luong" /> </th>
                            <th class="text-center"><spring:message code="common.table.col.xoa" /> </th>
                        </tr>
                    </thead>
                    <tbody id="list-container">

                    </tbody>
                </table>
                <div class="row">                            
                    <div class="col col-md-12 nsw-text-right">
                        <div id="list-pager"> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/app/most/01/handlebarsHelper.js?v=${version}' />" type="text/javascript"></script>
<script src="<c:url value='/app/most/01/index.module.js?v=${version}' />" type="text/javascript"></script>

