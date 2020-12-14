<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                                           data-bind="visible: hoSoId>0,value: hoSoChiTiet.Tbdhoso.fiMaHoSo" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Đơn vị xử lý<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiIdBophan ">
                                    <select name="trangThaiHoSo"
                                            class="form-control select2" data-bind="options: $root.danhSachDonVi,
                                             optionsText: 'fiTenCqxl',
                                             optionsValue: 'fiIdCqxl',
                                             value: hoSoChiTiet.Tbdhoso.fiIdBophan ,
                                             optionsCaption: '--Chọn đơn vị--',
                                             valueAllowUnset: true">
                                    </select>
                                </div>
                                <div class="col-md-2 label-text-right" data-bind="visible: hoSoId>0">
                                    <label>Trạng thái hồ sơ</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           data-bind="visible: hoSoId>0,value: $root.getTenTrangthai(hoSoChiTiet.Tbdhoso.fiIdTrangThai())" type="text">
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
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiTenDoanhNghiep" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Mã số thuế<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="<spring:message code="sbv.01.form.27"/>"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiMaNguoiTao" type="text">
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
                                           placeholder="Địa chỉ trụ sở"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDiaChi" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Điện thoại<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="Điện thoại"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDienThoai" type="text">
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
                                           placeholder="Fax"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiFax" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Số văn bản<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" data-bind="value: hoSoChiTiet.Tbdhoso.fiSoGiayTo"
                                           placeholder="Số giấy kinh doanh"
                                           type="text">
                                </div>

                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Ngày cấp<span class="nsw-require-field">*</span> </label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiNgayCapCongVan ">
                                    <input name="ngayNopTuNgay" id="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: hoSoChiTiet.Tbdhoso.fiNgayCapCongVan "/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần II: Loại hình kinh doanh vận tải</span><span
                            class="nsw-require-field">*</span>
                    </div>
                    <div class="panel-body">

                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-12" style="font-weight: bold">
                                    Ghi chú: Đối với phương tiện vận chuyển hành khách theo tuyến cố định bổ sung thêm
                                    các thông tin sau:
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Tuyến vận tải<span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiMaTuyen ">
                                    <select name="tuyenvantai"
                                            class="form-control select2" data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,options: $root.danhSachTuyen,
                                            optionsText: 'fiTenTuyen',
                                            optionsValue: 'fiMaTuyen',
                                            value: hoSoChiTiet.Tbdhoso.fiMaTuyen ,optionsCaption: '--Chọn tuyến--',
                                            valueAllowUnset: true,
                                            event: { 'change': $root.chonTuyenVanTai }">
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Tỉnh/ Thành phố đi (Việt Nam)<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiTenTinhDi ">
                                    <input type="text" class="form-control"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,value: hoSoChiTiet.Tbdhoso.fiTenTinhDi">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Bến xe đi<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiBenDi ">
                                    <input type="text" class="form-control"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,value: hoSoChiTiet.Tbdhoso.fiBenDi">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Tỉnh/ Thành phố đến ( Campuchia )<span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiTenTinhDen ">
                                    <input type="text" class="form-control"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,value: hoSoChiTiet.Tbdhoso.fiTenTinhDen">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Bến xe đến (Campuchia)<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiBenDen ">
                                    <input type="text" class="form-control"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,value: hoSoChiTiet.Tbdhoso.fiBenDen">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2 label-text-right">
                                    <label>Cự ly<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiCuLy ">
                                    <input type="text" class="form-control"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,value: hoSoChiTiet.Tbdhoso.fiCuLy">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Hành trình<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input type="text"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,value: hoSoChiTiet.Tbdhoso.fiHanhTrinh"
                                           class="form-control">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: Danh sách xe đề nghị cấp Giấy phép liên vận Việt - Campuchia - Lào: </span>
                        <%--<a href="javascript:;"--%>
                           <%--data-bind="click: $root.themPhuongtien, visible: editMode"><i class="fa fa-plus-circle"--%>
                                                                                         <%--style="font-size: 20px;"></i></a>--%>
                    </div>

                    <div class="panel-body" style="width: 100%; overflow-x: scroll">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column"
                               id="sample_1">
                            <thead style="text-align: center; ">
                            <tr>
                                <th colspan="13">
                                    <a href="javascript:;" data-bind="click: $root.themPhuongtien, visible: editMode">
                                        <i class="fa fa-plus" style="font-size: 20px; padding: 15px; border: 1px solid; border-radius: 50%;"></i>
                                    </a>
                                </th>
                            </tr>
                            </thead>
                            <thead>
                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                <th class="text-center">STT</th>
                                <th class="text-center">Biển số xe</th>
                                <th class="text-center">Tên chủ sở hữu</th>
                                <th class="text-center">Mác xe</th>
                                <th class="text-center">Trọng tải ghế</th>
                                <th class="text-center">Năm sản xuất</th>
                                <th class="text-center" data-bind="visible : editMode">Chức năng</th>
                            </tr>
                            </thead>

                            <tbody id="list-container-view"
                                   data-bind="foreach: { data: $root.hoSoChiTiet.Tbdphuongtien, as: 'item'}">
                            <tr>
                                <td class="text-center" data-bind="text: $index()+1"></td>
                                <td style="width: 80px" data-bind="text: item.fiBienSo"></td>
                                <td style="width: 50px" data-bind="text: item.fiTenSoHuu"></td>
                                <td style="width: 120px" data-bind="text: $root.getTenNhanhieu(item.fiMaNhanHieu())"></td>
                                <td style="width: 50px" data-bind="text: item.fiTrongTai"></td>
                                <td style="width: 50px" data-bind="text: item.fiNamSanXuat"></td>
                                <td style="display: table-cell;vertical-align: middle; text-align: center; width: 100px;" data-bind="visible : editMode">
                                    <a href="javascript:;"
                                       data-bind="click: $root.suaPhuongtien ,visible: (!item.editing() && editMode)"><i
                                            class="fa fa-edit"
                                            style="font-size: 20px;"></i></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.xoaPhuongtien ,visible: (!item.editing() && editMode)"><i
                                            class="fa fa-trash"
                                            style="font-size: 20px"></i></a>
                                    <a href="javascript:;"
                                       data-bind="click: $root.editOk ,visible: (item.editing() && editMode)"><i
                                            class="fa fa-save"
                                            style="font-size: 20px"></i></a>
                                </td>
                                <%--<td style="display: table-cell;vertical-align: middle; text-align: center; width: 100px;">--%>
                                </td>
                            </tr>
                            </tbody>

                        </table>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: THÔNG TIN TỆP ĐÍNH KÈM</span>
                    </div>
                    <div class="panel-body">
                        <jsp:include page="upload_file.jsp"></jsp:include>
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
                                               data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiChucDanh">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group" style="margin-top: 15px;">
                                <div class="col-md-12">
                                    <div class="col-md-2 label-text-right">
                                        <label>Địa điểm ký<span class="nsw-require-field">*</span></label>
                                    </div>
                                    <div class="col-md-4"><input class="form-control" type="text"
                                                                 data-bind="value: hoSoChiTiet.Tbddoanhnghiepky.fiDiaDiemKy">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group nsw-text-center">
                    <a href="javascript:;" class="btn green"
                       data-bind="click: $root.luuHoSo,, visible: editMode"><i
                            class="fa fa-save"></i>Ghi lại</a>
                    <a href="javascript:;"
                       data-bind="click: $root.guiHoSo,visible: editMode"
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
<template id="thongtinxe-template">
    <div class="row" id="thongtinxe-vm">
        <div class="col-md-12">
            <form role="form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label>Biển số xe <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiBksXe" id="fiBksXe-New" name="fiBksXe" data-bind="optionsCaption: 'Chọn...',
                                    optionsValue : 'id',
                                    options : lstBKS,
                                    optionsText : 'name',
                                    value: fiBksXe ,
                                    event: {change: getDetailXe}">

                            </select>
                        </div>

                        <div class="col-md-2 nsw-text-right">
                            <label>Trọng tải<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiSoGhe" name="fiSoGhe" maxlength="255"
                                   type="text" data-bind="value : fiSoGhe" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label>Tên người sở hữu <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiTenChuxe" name="fiTenChuxe" maxlength="255"
                                   type="text" data-bind="value : fiTenChuxe" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label>Năm sản xuất <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiNamSx" name="fiNamSx" maxlength="255"
                                   type="text" data-bind="value : fiNamSx" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label>Mác xe <a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-control select2 fiMaCkXn" id="fiMaCkXn-New" name="fiMaCkXn" data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMaNhanhieu',value: fiMaNhanhieu , options : lstNhanHieu, optionsText : 'fiTenHieu'"></select>
                            <input type="hidden" id="fiTenCkXn" name="fiTenCkXn" data-bind="value : fiTenCkXn"/>
                        </div>

                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

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
    var titleLabel =${titleLabel};
</script>
<script type="text/javascript" src="<c:url value="/app/mt/qlgp/p56/edit.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/qlgp/p56/model.js?v=${ version }"/>"
        charset="utf-8"></script>