<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="incLanguage.jsp" %>

<div class="row">

    <div class="col-md-12">
        <div class="portlet light " id="contentBody">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i> <span
                        class="caption-subject bold uppercase">${titleLabel}</span>
                </div>
            </div>
            <form role="form" class="form-horizontal" id="detailForm">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">PHẦN I: <spring:message
                                code="mt.common.information"></spring:message></span>
                    </div>
                    <div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;" data-bind="visible: hoSoId>0">
                            <div class="col-md-12">
                                <div class="col-md-6">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Mã hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="visible: hoSoId>0,value: hoSoChiTiet.Tbdhoso.fiMaHoso"
                                           type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.unit"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiIdBophan ">
                                    <select name="trangThaiHoSo"
                                            class="form-control select2" data-bind="options: $root.danhSachDonVi,
                                             optionsText: 'fiTenCqxl',
                                             optionsValue: 'fiIdCqxl',
                                             value: hoSoChiTiet.Tbdhoso.fiIdBophan ,
                                             optionsCaption: '--Chọn đơn vị--',
                                             valueAllowUnset: true, enable: hoSoChiTiet.Tbdhoso.fiTrangthai() == null ||  hoSoChiTiet.Tbdhoso.fiTrangthai() == 0">
                                    </select>
                                </div>
                                <div class="col-md-2 label-text-right" data-bind="visible: hoSoId>0">
                                    <label>Trạng thái hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="visible: hoSoId>0,value: $root.getTenTrangthai(hoSoChiTiet.Tbdhoso.fiTrangthai())"
                                           type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.organization"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"><input class="form-control" disabled="true"
                                                             placeholder="Tên doanh nghiệp"
                                                             data-bind="value: hoSoChiTiet.Tbdhoso.fiTendoanhnghiep"
                                                             type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.tax"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="<spring:message code="sbv.01.form.27" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiManguoitao" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.address"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="<spring:message code="sbv.01.form.29" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDiachi" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.phone"></spring:message><span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="<spring:message code="sbv.01.form.30" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDienthoai" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.fax"></spring:message></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           placeholder="<spring:message code="sbv.01.form.31" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiFax" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.email"></spring:message></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           placeholder="Email"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiEmail" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label><spring:message
                                            code="mt.detail.website"></spring:message></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" data-bind="value: hoSoChiTiet.Tbdhoso.fiWebsite"
                                           placeholder="Website"
                                           type="text">
                                </div>
                            </div>
                        </div>
                       
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần II: Thông tin đề nghị gia hạn như sau <span
                                class="nsw-require-field">*</span></span>
                    </div>
                     <div class="panel-body">
                        
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
                                    <label>Loại giấy phép<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
<!--                                      data-bind="validationElement: hoSoChiTiet.TbdGiaHan.fiLoaiGiayPhep " -->
                                     
                                    <select name="trangThaiHoSo"
                                            class="form-control select2" data-bind="options: $root.loaiGiayPhep,
                                             optionsText: 'fiTenLoaiGiayPhep',
                                             optionsValue: 'fiMaLoaiGiayPhep',
                                             value: hoSoChiTiet.TbdGiaHan.fiLoaiGiayPhep ,
                                             optionsCaption: '--Chọn loại giấy phép--',
                                             valueAllowUnset: true">
                                    </select>
                                </div>
                                
                               
                                <div class="col-md-2 label-text-right" >
                                    <label>Số giấy phép<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
									<input class="form-control"
										data-bind="value: hoSoChiTiet.Tbdhoso.fiSochungchi"
										placeholder="Số giấy phép" type="text">
								</div>
                            </div>
                        </div>
                        
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
								<label>Ngày cấp<span class="nsw-require-field">*</span></label>
								</div>
								<div class="col-md-4">
<!-- 									data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiNgaycapphep "> -->
									<input name="ngayNopTuNgay" id="ngayNopTuNgay"
										field="common_tracuu_ngay_tao_tu"
										class="form-control form-control-inline date-picker"
										data-date-format="dd/mm/yyyy" size="16" type="text"
										placeholder="dd/mm/yyyy"
										data-bind="datepicker: hoSoChiTiet.Tbdhoso.fiNgaycapchungchi, dateInput" />
								</div>
                                <div class="col-md-2 label-text-right">
                                    <label>Cơ quan cấp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
									<input class="form-control"
										data-bind="value: hoSoChiTiet.Tbdhoso.fiCoquancapchungchi"
										placeholder="Cơ quan cấp" type="text">
								</div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
								<label>Thời gian gia hạn từ ngày<span class="nsw-require-field">*</span></label>
								</div>
								<div class="col-md-4">
<!-- 									data-bind="validationElement: hoSoChiTiet.TbdGiaHan.fiGiaHanTuNgay "> -->
									<input name="ngayNopTuNgay" id="ngayNopTuNgay"
										field="common_tracuu_ngay_tao_tu"
										class="form-control form-control-inline date-picker"
										data-date-format="dd/mm/yyyy" size="16" type="text"
										placeholder="dd/mm/yyyy"
										data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiGiaHanTuNgay, dateInput" />
								</div>
                                <div class="col-md-2  label-text-right">
								<label>đến ngày<span class="nsw-require-field">*</span></label>
								</div>
								<div class="col-md-4">
<!-- 									data-bind="validationElement: hoSoChiTiet.TbdGiaHan.fiGiaHanDenNGay " -->
									
									<input name="ngayNopTuNgay" id="ngayNopTuNgay"
										field="common_tracuu_ngay_tao_tu"
										class="form-control form-control-inline date-picker"
										data-date-format="dd/mm/yyyy" size="16" type="text"
										placeholder="dd/mm/yyyy"
										data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiGiaHanDenNGay, dateInput" />
								</div>
                            </div>
                        </div>
                      
						<div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
								<label>Thời gian hết hạn hoạt động tại Việt Nam<span class="nsw-require-field">*</span></label>
								</div>
								<div class="col-md-4">

									<input name="ngayNopTuNgay" id="ngayNopTuNgay"
										field="common_tracuu_ngay_tao_tu"
										class="form-control form-control-inline date-picker"
										data-date-format="dd/mm/yyyy" size="16" type="text"
										placeholder="dd/mm/yyyy"
										data-bind="datepicker: hoSoChiTiet.TbdGiaHan.fiNgayHetHanGPVT, dateInput" />
								</div>
                                <div class="col-md-2  label-text-right">
								<label>Số ngày gia hạn<span class="nsw-require-field">*</span></label>
								</div>
								 <div class="col-md-4">
									<input class="form-control"
										data-bind="value: hoSoChiTiet.TbdGiaHan.fiSoNgayGiaHan"
										placeholder="Số ngày gia hạn" type="text">
								</div>
                            </div>
                        </div>
                        
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12 row">
                                <div class="col-md-2  label-text-right">
								<label>Lý do đề nghị gia hạn <span class="nsw-require-field">*</span></label>
								</div>
								<div class="col-md-10">

									<input class="form-control"
										data-bind="value: hoSoChiTiet.TbdGiaHan.fiLyDoGiaHan"
										placeholder="Lý do đề nghị gia hạn" type="text">
								</div>
                                
                            </div>
                        </div>
                        
                        
                        </div>
                                                                                    
			<!--  thong tin tep dinh kem   -->  
                </div>
                
                
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: THÔNG TIN TỆP ĐÍNH KÈM</span>
                    </div>
                    <div class="panel-body">
                        <jsp:include page="upload_file_${procedureId}.jsp"></jsp:include>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần IV: Thông tin ký đơn</span>
                    </div>
                    <div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="form-group" style="margin-top: 15px;">
                                <div class="col-md-12">
                                    <div class="col-md-2 label-text-right">
                                        <label>Người ký<span class="nsw-require-field">*</span></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" type="text"
                                               data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiTenNguoiKy">
                                    </div>
                                    <div class="col-md-2 label-text-right">
                                        <label>Chức danh</label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" type="text"
                                               data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiChucdanh">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group" style="margin-top: 15px;">
                                <div class="col-md-12">
                                    <div class="col-md-2 label-text-right">
                                        <label>Địa điểm ký<span class="nsw-require-field">*</span></label>
                                    </div>
                                    <div class="col-md-4"><input class="form-control" type="text"
                                                                 data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiDiadiemKy">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group nsw-text-center">
                    <a href="javascript:;" class="btn green"
                       data-bind="click: $root.luuHoSo,visible: editMode"><i
                            class="fa fa-save"></i><spring:message
                            code="mt.btn.save"></spring:message></a>
                    <a href="javascript:;"
                       data-bind="click: $root.guiHoSo, visible: editMode"
                       class="btn green"><i
                            class="fa fa-send-o"></i><spring:message
                            code="mt.btn.send"></spring:message></a>
                    <a href="javascript:;"
                       data-bind="click: $root.dong"
                       class="btn green"><i
                            class="fa fa-close"></i>Trở lại</a>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    var hoSoId =${hoSoId};
</script>
<script>
    var userCustom = ${userCustom};
</script>
<script>
    var procedureId = '${procedureId}';
</script>
<script>
    var editMode = ${editMode};
</script>
<script>
    var titleLabel ='${titleLabel}';
</script>
<script type="text/javascript" src="<c:url value="/app/mt/lib/cmonfunc.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p47/edit.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p47/model.js?v=${ version }"/>"
        charset="utf-8"></script>