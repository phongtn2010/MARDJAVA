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
                        <span class="caption-subject bold uppercase">PHẦN I: Thông tin chung</span>
                    </div>
                    <div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;" data-bind="visible: hoSoId>0">
                            <div class="col-md-12">
                                <div class="col-md-6">
                                </div>
                                <div class="col-md-2 label-text-right" >
                                    <label>Mã hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="visible: hoSoId>0,value: hoSoChiTiet.Tbdhoso.fiMaHoso" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Đơn vị xử lý<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiIdBophan ">
                                    <select name="trangThaiHoSo"
                                            class="form-control select2" data-bind="options: $root.danhSachDonVi,
                                             optionsText: 'fiTenCqxl',
                                             optionsValue: 'fiIdCqxl',
                                             value: hoSoChiTiet.Tbdhoso.fiIdBophan ,
                                             optionsCaption: '--Chọn đơn vị--',
                                             valueAllowUnset: true, enable:  hoSoChiTiet.Tbdhoso.fiTrangthai() == null || hoSoChiTiet.Tbdhoso.fiTrangthai() == 0">
                                    </select>
                                </div>
                                <div class="col-md-2 label-text-right" data-bind="visible: hoSoId>0">
                                    <label>Trạng thái hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="visible: hoSoId>0,value: $root.getTenTrangthai(hoSoChiTiet.Tbdhoso.fiTrangthai())" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Tên doanh nghiệp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="Tên doanh nghiệp"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiTendoanhnghiep" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Mã số thuế<span class="nsw-require-field">*</span></label>
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
                                    <label>Địa chỉ trụ sở<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="<spring:message code="sbv.01.form.29" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDiachi" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Điện thoại<span class="nsw-require-field">*</span></label>
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
                                    <label>Fax</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           placeholder="<spring:message code="sbv.01.form.31" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiFax" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Email</label>
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
                                    <label>Website</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" data-bind="value: hoSoChiTiet.Tbdhoso.fiWebsite"
                                           placeholder="Website"
                                           type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Số giấy phép kinh doanh vận tải bằng xe ô tô (hoặc giấy chứng nhận đăng ký
                                        kinh
                                        doanh)<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           placeholder="Số giấy phép kinh doanh vận tải bằng xe ô tô"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiGiayphepkinhdoanh" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Ngày cấp<span class="nsw-require-field">*</span> </label>
                                </div>
                                <div class="col-md-4">
                                    <input name="ngayNopTuNgay" id="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: hoSoChiTiet.Tbdhoso.fiNgaydangky"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Cơ quan cấp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           placeholder="Đơn vị cấp"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiCoquancapphep" type="text">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần II: Thông tin đề nghị cấp Giấy phép vận tải đường bộ quốc tế Việt Nam - Cam như sau<span
                                class="nsw-require-field">*</span></span>
                    </div>
                    <div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Loại hình hoạt động</label>
                                </div>
                                <div class="col-md-10">
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <div id="u280" class="ax_default checkbox">
                                                    <label for="u280_input" style="position: absolute; left: 0px;">
                                                        <div id="u280_text" class="text ">
                                                            <p>
                                                                <span>Vận tải hành khách bằng ô tô theo tuyến cố định</span>
                                                            </p>
                                                        </div>
                                                    </label>
                                                    <input id="u280_input" type="checkbox" value="checkbox"
                                                           data-bind="checked:hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport"/>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div id="u281" class="ax_default checkbox">
                                                    <label for="u281_input" style="position: absolute; left: 0px;">
                                                        <div id="u281_text" class="text ">
                                                            <p><span>Vận tải hành khách theo hợp đồng</span></p>
                                                        </div>
                                                    </label>
                                                    <input id="u281_input" type="checkbox" value="checkbox"
                                                           data-bind="checked: hoSoChiTiet.Tbsloaihinhvantai.contractRoadTransport"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <div id="u285" class="ax_default checkbox">
                                                    <label for="u285_input" style="position: absolute; left: 0px;">
                                                        <div id="u285_text" class="text ">
                                                            <p><span>Vận tải khách du lịch bằng xe ô tô</span></p>
                                                        </div>
                                                    </label>
                                                    <input id="u285_input" type="checkbox" value="checkbox"
                                                           data-bind="checked: hoSoChiTiet.Tbsloaihinhvantai.passengerTransport"/>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div id="u286" class="ax_default checkbox">
                                                    <label for="u286_input" style="position: absolute; left: 0px;">
                                                        <div id="u286_text" class="text ">
                                                            <p><span>Vận tải hàng hóa bằng xe ô tô</span></p>
                                                        </div>
                                                    </label>
                                                    <input id="u286_input" type="checkbox" value="checkbox"
                                                           data-bind="checked: hoSoChiTiet.Tbsloaihinhvantai.cargoTransport"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <div id="u289" class="ax_default checkbox">
                                                    <label for="u289_input" style="position: absolute; left: 0px;">
                                                        <div id="u289_text" class="text ">
                                                            <p><span>Vận tải khách du lịch bằng xe taxi</span></p>
                                                        </div>
                                                    </label>
                                                    <input id="u289_input" type="checkbox" value="1"
                                                           data-bind="checked: hoSoChiTiet.Tbsloaihinhvantai.passengerTaxi"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Loại hình đề nghị cấp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <select data-bind="value:hoSoChiTiet.Tbdhoso.fiLoaihinh" disabled="true"
                                            class="form-control select2">
                                        <option>---Chọn---</option>
                                        <option value="1">Cấp mới</option>
                                        <option value="2">Cấp lại do bị hết hạn</option>
                                        <option value="3">Cấp lại do bị hư hỏng</option>
                                        <option value="4">Cấp lại do bị mất</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;"
                             data-bind="visible: hoSoChiTiet.Tbdhoso.fiLoaihoso()!='BGTVT0600019'">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Lý do<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-10">
                        <textarea class="col-md-10" rows="3"
                                  data-bind="value:hoSoChiTiet.Tbdhoso.fiLydocaplai"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
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
                       data-bind="click: $root.luuHoSo, visible: editMode"><i
                            class="fa fa-save"></i>Ghi lại</a>
                    <a href="javascript:;"
                       data-bind="click: $root.guiHoSo, visible: editMode"
                       class="btn green"><i
                            class="fa fa-send-o"></i>Gửi hồ sơ</a>
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
</script><script>
    var titleLabel = "${titleLabel}";
</script>
<script type="text/javascript" src="<c:url value="/app/mt/p19/edit.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p19/model.js?v=${ version }"/>"
        charset="utf-8"></script>