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
                                           placeholder="Mã số thuế"
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
                                           placeholder="Địa chỉ công ty"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiDiachi" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Điện thoại<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled="true"
                                           placeholder="Số điện thoại"
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
                                           placeholder="Fax"
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
                                    <label>Giấy phép vận tải đường bộ quốc tế Việt - Campuchia do Tổng cục Đường bộ Việt
                                        Nam cấp số<span class="nsw-require-field">*</span></label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiGiayphepkinhdoanh ">
                                    <input class="form-control"
                                           placeholder="Giấy phép vận tải"
                                           data-bind="value: hoSoChiTiet.Tbdhoso.fiGiayphepkinhdoanh" type="text">
                                </div>
                                <div class="col-md-2 label-text-right">
                                    <label>Ngày cấp<span class="nsw-require-field">*</span> </label>
                                </div>
                                <div class="col-md-4"
                                     data-bind="validationElement: hoSoChiTiet.Tbdhoso.fiNgaydangky ">
                                    <input name="ngayNopTuNgay" id="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                           class="form-control form-control-inline date-picker"
                                           data-date-format="dd/mm/yyyy" size="16" type="text"
                                           placeholder="dd/mm/yyyy"
                                           data-bind="datepicker: hoSoChiTiet.Tbdhoso.fiNgaydangky"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần II: Mục đích chuyến đi</span><span
                            class="nsw-require-field">*</span>
                    </div>
                    <div class="panel-body">
                        <div class="form-group" style="margin-top: 15px;">
                            <div class="col-md-12">
                                <div class="col-md-10">
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-6">
                                                <div id="u280" class="ax_default checkbox">
                                                    <label for="u280_input" style="position: absolute; left: 0px;">
                                                        <div id="u280_text" class="text ">
                                                            <p>
                                                                <span>Công vụ</span>
                                                            </p>
                                                        </div>
                                                    </label>
                                                    <input id="u280_input" type="checkbox" value="checkbox"
                                                           data-bind="checked: hoSoChiTiet.Tbsmucdichchuyendi.fiCongvu"/>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div id="u281" class="ax_default checkbox">
                                                    <label for="u281_input" style="position: absolute; left: 0px;">
                                                        <div id="u281_text" class="text ">
                                                            <p><span>Hoạt động kinh doanh</span></p>
                                                        </div>
                                                    </label>
                                                    <input id="u281_input" type="checkbox" value="checkbox"
                                                           data-bind="checked: hoSoChiTiet.Tbsmucdichchuyendi.fiKinhdoanh"/>
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
                                                            <p><span>Cá nhân</span></p>
                                                        </div>
                                                    </label>
                                                    <input id="u285_input" type="checkbox" value="checkbox"
                                                           data-bind="checked: hoSoChiTiet.Tbsmucdichchuyendi.fiCanhan"/>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div id="u286" class="ax_default checkbox">
                                                    <label for="u286_input" style="position: absolute; left: 0px;">
                                                        <div id="u286_text" class="text ">
                                                            <p><span>Mục đích khác</span></p>
                                                        </div>
                                                    </label>
                                                    <input id="u286_input" type="checkbox" value="checkbox"
                                                           data-bind="checked: hoSoChiTiet.Tbsmucdichchuyendi.fiKhac"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="caption-subject bold uppercase">Phần III: Danh sách xe đề nghị cấp Giấy phép liên vận Việt - Campuchia: </span>
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
                                <%--<th class="text-center">Năm sản xuất</th>--%>
                                <%--<th class="text-center">Nhãn hiệu</th>--%>
                                <%--<th class="text-center">Số khung</th>--%>
                                <%--<th class="text-center">Số máy</th>--%>
                                <%--<th class="text-center">Màu sơn</th>--%>
                                <th class="text-center">Thời gian đề nghị Giấy phép từ ngày</th>
                                <th class="text-center">Thời gian đề nghị Giấy phép đến ngày</th>
                                <th class="text-center">Hình thức hoạt động</th>
                                <th class="text-center">Cửa khẩu Xuất - nhập</th>
                                <th class="text-center" data-bind="visible : editMode">Chức năng</th>
                            </tr>
                            </thead>
                            <%--<tbody id="list-container"--%>
                            <%--data-bind="foreach: { data: $root.hoSoChiTiet.Tbdphuongtien, as: 'item'},visible : editMode">--%>
                            <%--<tr>--%>
                            <%--<td class="text-center" data-bind="text: $index()+1"></td>--%>
                            <%--<td>--%>
                            <%--<input type="text" style="width: 80px" class="form-control"--%>
                            <%--data-bind="value: item.fiBienso,enable: item.editing">--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<input type="text" style="width: 50px" class="form-control"--%>
                            <%--data-bind="value: item.fiKhoihang,enable: item.editing">--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<input type="text" style="width: 80px" class="form-control"--%>
                            <%--data-bind="value: item.fiNamsanxuat,enable: item.editing">--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<select name="nhanhieu" style="width: 120px"--%>
                            <%--class="form-control select2" data-bind="enable: item.editing,options: $root.danhSachNhanHieu,--%>
                            <%--optionsText: 'fiTenHieu',--%>
                            <%--optionsValue: 'fiMaNhanhieu',--%>
                            <%--valueAllowUnset: true,--%>
                            <%--value: item.fiDongphuongtien ,optionsCaption: '--Chọn nhãn hiệu--'">--%>
                            <%--</select>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<input type="text" style="width: 50px" class="form-control"--%>
                            <%--data-bind="value:item.fiSokhung,enable: item.editing">--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<input type="text" style="width: 50px" class="form-control"--%>
                            <%--data-bind="value:item.fiSomay,enable: item.editing">--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<input type="text" style="width: 80px" class="form-control"--%>
                            <%--data-bind="value:item.fiMausac,enable: item.editing">--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<input class="form-control form-control-inline date-picker" style="width: 120px"--%>
                            <%--data-date-format="dd/mm/yyyy" size="16" type="text"--%>
                            <%--data-bind="datepicker: item.fiTungay,enable: item.editing"--%>
                            <%--placeholder="dd/mm/yyyy"/>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<input class="form-control form-control-inline date-picker"--%>
                            <%--style="width: 120px"--%>
                            <%--data-date-format="dd/mm/yyyy" size="16" type="text"--%>
                            <%--data-bind="datepicker: item.fiDenngay,enable: item.editing"--%>
                            <%--placeholder="dd/mm/yyyy"/>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<select style="width: 120px" class="form-control" data-bind="enable: item.editing,value: item.fiHinhthucHoatdong,valueAllowUnset: true">--%>
                            <%--<option value="1">Vận chuyển hàng hoá</option>--%>
                            <%--<option value="2">Vận chuyển hành khách</option>--%>
                            <%--</select>--%>
                            <%--</td>--%>
                            <%--<td>--%>
                            <%--<select style="width: 300px" name="cuakhau"--%>
                            <%--class="form-control select2" data-bind="enable: item.editing,options: $root.danhSachCuaKhau,--%>
                            <%--optionsText: 'fiTenCuakhau',--%>
                            <%--optionsValue: 'fiMaCuakhau',--%>
                            <%--valueAllowUnset: true,--%>
                            <%--value: item.fiSocong ,optionsCaption: '--Chọn của khẩu đến--'">--%>
                            <%--</select>--%>
                            <%--</td>--%>
                            <%--<td style="display: table-cell;vertical-align: middle; text-align: center;width: 100px;">--%>
                            <%--<div class="col-md-6">--%>
                            <%--<a href="javascript:;" data-bind="click: $root.suaPhuongtien">--%>
                            <%--<i class="fa fa-edit" style="font-size: 20px;"></i>--%>
                            <%--</a>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-6">--%>
                            <%--<a href="javascript:;" data-bind="click: $root.xoaPhuongtien ,">--%>
                            <%--<i class="fa fa-trash" style="font-size: 20px"></i>--%>
                            <%--</a>--%>
                            <%--</div>--%>
                            <%--</td>--%>
                            <%--</tr>--%>
                            <%--</tbody>--%>
                            <tbody id="list-container-view"
                                   data-bind="foreach: { data: $root.hoSoChiTiet.Tbdphuongtien, as: 'item'}">
                            <tr>
                                <td class="text-center" data-bind="text: $index()+1"></td>
                                <td style="width: 80px" data-bind="text: item.fiBienso"></td>
                                <td style="width: 50px" data-bind="text: item.fiKhoihang"></td>
                                <%--<td style="width: 80px" data-bind="text: item.fiNamsanxuat"></td>--%>
                                <%--<td style="width: 120px"--%>
                                <%--data-bind="text: $root.getTenNhanhieu(item.fiDongphuongtien())"></td>--%>
                                <%--<td style="width: 50px" data-bind="text: item.fiSokhung"></td>--%>
                                <%--<td style="width: 50px" data-bind="text: item.fiSomay"></td>--%>
                                <%--<td style="width: 80px" data-bind="text: item.fiMausac"></td>--%>
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
    var procedureId = '${procedureId}';
</script>
<script>
    var editMode = ${editMode};
</script>
<script type="text/javascript" src="<c:url value="/app/mt/qlgp/p27/edit.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/qlgp/p27/model.js?v=${ version }"/>"
        charset="utf-8"></script>