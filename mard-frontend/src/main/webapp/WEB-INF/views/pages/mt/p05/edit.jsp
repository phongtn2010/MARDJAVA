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
                        class="caption-subject bold uppercase"> ${titleLabel}</span>
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
                                <div class="col-md-2  label-text-right">
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
                                             valueAllowUnset: true, enable: hoSoChiTiet.Tbdhoso.fiTrangthai() == null || hoSoChiTiet.Tbdhoso.fiTrangthai() == 0">
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
                                <div class="col-md-2  label-text-right">
                                    <label>Tên doanh nghiệp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="Tên doanh nghiệp"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiTendoanhnghiep" type="text">
                                </div>
                                <div class="col-md-2  label-text-right">
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
                                <div class="col-md-2  label-text-right">
                                    <label>Địa chỉ trụ sở<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="Địa chỉ trụ sở"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDiachi" type="text">
                                </div>
                                <div class="col-md-2  label-text-right">
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
                                <div class="col-md-2  label-text-right">
                                    <label>Fax</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control"
                                           placeholder="<spring:message code="sbv.01.form.31" />"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiFax" type="text">
                                </div>
                                <div class="col-md-2  label-text-right">
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
                                <div class="col-md-2  label-text-right">
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
                                <div class="col-md-2  label-text-right">
                                    <label>Giấy phép vận tải đường bộ quốc tế Việt - Lào do Tổng cục Đường bộ Việt
                                        Nam cấp số</label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiSochungchi ">
                                    <input class="form-control"
                                           placeholder="Giấy phép vận tải"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiSochungchi" type="text">
                                </div>
                                <div class="col-md-2  label-text-right">
                                    <label>Ngày cấp</label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiNgaydangky ">
                                    <input name="ngayNopTuNgay" id="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: hoSoChiTiet.Tbdhoso.fiNgaydangky, dateInput"/>
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
                                <div class="col-md-2  label-text-right">
                                    <label>Loại hình hoạt động<span class="nsw-require-field">*</span></label>
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
                                                           data-bind="checked: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,event:{ change: changeFixedRoadTransport}"/>
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
                                </div>
                            </div>
                        </div>
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
                                <div class="col-md-2  label-text-right">
                                    <label>Tuyến vận tải<span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiMatuyen ">
                                    <select name="tuyenvantai"
                                            class="form-control select2" data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,options: $root.danhSachTuyen,
                                            optionsText: 'fiTenTuyen',
                                            optionsValue: 'fiMaTuyen',
                                            value: hoSoChiTiet.Tbdhoso.fiMatuyen ,optionsCaption: '--Chọn tuyến--',
                                            valueAllowUnset: true,
                                            event: { 'change': $root.chonTuyenVanTai }">
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
                                    <label>Tỉnh/ Thành phố đi (Việt Nam)<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiTinhdi ">
                                    <input disabled type="text" class="form-control"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiTinhdi">
                                </div>
                                <div class="col-md-2  label-text-right">
                                    <label>Bến xe đi<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiGadi ">
                                    <input disabled type="text" class="form-control"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiGadi">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
                                    <label>Tỉnh/ Thành phố đến ( Lào )<span
                                            class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiTinhden ">
                                    <input disabled type="text" class="form-control"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiTinhden">
                                </div>
                                <div class="col-md-2  label-text-right">
                                    <label>Bến xe đến (Lào)<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiGaden ">
                                    <input disabled type="text" class="form-control"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiGaden">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
                                    <label>Cự ly<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiQuangduong ">
                                    <input disabled type="text" class="form-control"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiQuangduong">
                                </div>
                                <div class="col-md-2  label-text-right">
                                    <label>Hành trình<span class="nsw-require-field">*</span></label>
                                </div>
                                <div disabled class="col-md-4">
                                    <input disabled type="text"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiMotatuyen"
                                           class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
                                    <label>Cửa khẩu đến<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <select name="cuakhau"
                                            class="form-control select2" data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport,options: $root.danhSachCuaKhau,
                                            optionsText: 'fiTenCuakhau',
                                            optionsValue: 'fiMaCuakhau',
                                            valueAllowUnset: true,
                                            value: hoSoChiTiet.Tbdhoso.fiCuakhau,
                                            optionsCaption: '--Chọn của khẩu đến--'">
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-2  label-text-right">
                                    <label>Đã được Tổng cục Đường bộ Việt Nam chấp thuận khai thác tuyến tại công văn
                                        số<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input  type="text"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport, value: hoSoChiTiet.Tbdhoso.fiSogiaytochapthuan"
                                           class="form-control">
                                </div>
                                <div class="col-md-2  label-text-right">
                                    <label>Ngày cấp<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4" data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiNgaycapphep ">
                                    <input name="ngaycap"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="enable: hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport, datepicker: hoSoChiTiet.Tbdhoso.fiNgaychapthuan, dateInput"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: Danh sách xe đề nghị cấp Giấy phép liên vận Việt - Lào: </span>
                    </div>
                    <div class="panel-body" style="width: 100%; overflow-x: scroll">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column"
                               id="sample_1">
                            <thead style="text-align: center;">
                            <tr>
                                <th colspan="13">
                                    <a href="javascript:;" data-bind="click: $root.themXe, visible: editMode">
                                        <i class="fa fa-plus" style="font-size: 20px; padding: 15px; border: 1px solid; border-radius: 50%;"></i>
                                    </a>
                                </th>
                            </tr>
                            </thead>
                            <thead>
                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                <th class="text-center">STT</th>
                                <th class="text-center">Biển số xe</th>
                                <th class="text-center">Trọng tải ghế</th>
                                <th class="text-center">Thời gian đề nghị Giấy phép từ ngày</th>
                                <th class="text-center">Thời gian đề nghị Giấy phép đến ngày</th>
                                <th class="text-center">Hình thức hoạt động</th>
                                <th class="text-center">Cửa khẩu Xuất - nhập</th>
                                <th class="text-center" data-bind="visible : editMode">Chức năng</th>
                            </tr>
                            </thead>
                            <tbody id="list-container-view"
                                   data-bind="foreach: { data: $root.customPagination.pageData(), as: 'item'}">
                            <tr>
                                <td class="text-center" data-bind="text: (($root.customPagination.currentPage() - 1) * 5 + $index() + 1)"></td>
                                <td style="width: 80px" data-bind="text: item.fiBienso"></td>
                                <td style="width: 50px" data-bind="text: item.fiKhoihang"></td>
                                <td style="width: 120px"
                                    data-bind="text: moment(item.fiTungay()).format('DD/MM/YYYY')"></td>
                                <td style="width: 120px"
                                    data-bind="text: moment(item.fiDenngay()).format('DD/MM/YYYY')"></td>
                                <td style="width: 120px"
                                    data-bind="text: (item.fiHinhthucHoatdong==1) ? 'Vận chuyển hàng hoá' : 'Vận chuyển hành khách'"></td>
                                <td style="width: 300px" data-bind="text: $root.getTenCuaKhau(item.fiSocong())"></td>
                                <td style="display: table-cell;vertical-align: middle; text-align: center;width: 100px;" data-bind="visible : editMode">
                                    <div class="col-md-6">
                                        <a href="javascript:;" data-bind="click: $root.suaPhuongtien">
                                            <i class="fa fa-edit" style="font-size: 20px;"></i>
                                        </a>
                                    </div>
                                    <div class="col-md-6">
                                        <a href="javascript:;" data-bind="click: $root.xoaPhuongtien ,">
                                            <i class="fa fa-trash" style="font-size: 20px"></i>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                            <tbody>
                            <jsp:include page="inc_popup_danhsachxe.jsp"></jsp:include>
                            </tbody>
                        </table>
                        <div class="nsw-flr" data-bind="if: $root.customPagination.totalPage() > 1">
                            <ul class="flip pull-left pagination pagination-sm">
                                <!-- ko foreach: $root.customPagination.pageChilds() -->
                                <li data-bind="css: { active: $data == $root.customPagination.currentPage() }">
                                    <a href="#"
                                       data-bind="text: $data, click: $root.customPagination.goToPage.bind($data)"></a>
                                </li>
                                <!-- /ko -->
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: THÔNG TIN TỆP ĐÍNH KÈM</span>
                    </div>
                    <div class="panel-body">
                        <jsp:include page="upload_file_${procedureId}.jsp"></jsp:include> 
                        <%-- <jsp:include page="upload_file.jsp"></jsp:include> --%>
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
</script>

<script type="text/javascript" src="<c:url value="/app/mt/lib/cmonfunc.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p05/edit.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p05/model.js?v=${ version }"/>"
        charset="utf-8"></script>