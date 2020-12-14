<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="myModal" class="modal" tabindex="-1" data-width="1100">
    <form id="form-themxe">
        <fieldset class="fieldset">
        <div class="form-horizontal">
            <div class="panel panel-default">
                <div class="modal-header">
                    <span class="caption-subject bold uppercase">Thêm Xe</span>
                </div>
                <div class="panel-body">
                    <div class="form-group" style="margin-top: 15px;">
                        <div class="col-md-12">
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.bienso" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <select  id="fiBienSoXe" class="form-control select2 " data-bind="value: $root.phuongtien.fiBienSo,
                                    optionsCaption: '...Chọn...',
                                    optionsValue : 'id',
                                    optionsText : 'name',
                                    options : $root.danhSachBKS,
                                    event: {change: getPhuongtienOnClick}" style="width: 200px;">
                                </select>
                            </div>
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.nhanhieu" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <select disabled="true"
                                        class="form-control select2" data-bind="options: $root.danhSachNhanHieu,
                                            optionsText: 'fiTenHieu',
                                            optionsValue: 'fiMaNhanhieu',
                                            valueAllowUnset: true,
                                            value: $root.phuongtien.fiMaNhanHieu ,optionsCaption: '--Chọn nhãn hiệu--'">
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px;">
                        <div class="col-md-12">
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.trongtai" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <input type="text"  placeholder="Trọng tải" disabled="true" class="form-control" data-bind="value: $root.phuongtien.fiTrongTai">
                            </div>
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.namsanxuat" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <input type="text"  placeholder="Năm sản xuất" disabled="true" class="form-control" data-bind="value:$root.phuongtien.fiNamSanXuat">
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px;">
                        <div class="col-md-12">
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.sokhung" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <input type="text"  placeholder="Số khung"  disabled="true" class="form-control" data-bind="value:$root.phuongtien.fiSoKhung">
                            </div>
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.somay" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <input type="text"  placeholder="Số máy" disabled="true" class="form-control" data-bind="value:$root.phuongtien.fiSoMay">
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px;">
                        <div class="col-md-12">
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.mausac" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <input type="text"  placeholder="Màu sắc" disabled="true" class="form-control" data-bind="value:$root.phuongtien.fiMauSon">
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px;">
                        <div class="col-md-12">
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.tungay" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control form-control-inline date-picker"
                                       data-date-format="dd/mm/yyyy" size="16" type="text"
                                       data-bind="datepicker:$root.phuongtien.fiTuNgay"
                                       placeholder="dd/mm/yyyy"/>
                            </div>
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.denngay" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control form-control-inline date-picker"
                                       data-date-format="dd/mm/yyyy" size="16" type="text"
                                       data-bind="datepicker:$root.phuongtien.fiDenNgay"
                                       placeholder="dd/mm/yyyy"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px;">
                        <div class="col-md-12">
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.hthoatdong" /><span class="nsw-require-field">*</span> </label>
                            </div>
                            <div class="col-md-4" >
                                <select id="fihthd" class="form-control" data-bind="value: $root.phuongtien.fiHinhThucHD, valueAllowUnset: true">
                                    <option value="1">Vận chuyển hàng hoá</option>
                                    <option value="2">Vận chuyển hành khách</option>
                                </select>
                            </div>
                            <div class="col-md-2  label-text-right">
                                <label><spring:message code="sbv.01.hosoxe.cuakhau" /><span class="nsw-require-field">*</span></label>
                            </div>
                            <div class="col-md-4" >
                                <select id="fiCuaKhau" class="form-control select2" data-bind="options: $root.danhSachCuaKhau,
                                                                    optionsText: 'fiTenCuakhau',
                                                                    optionsValue: 'fiMaCuakhau',
                                                                    valueAllowUnset: true,
                                                                    value:$root.phuongtien.fiMaCuaKhau ,optionsCaption: '--Chọn của khẩu đến--'">
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn blue" data-bind="click: $root.luuXe"><spring:message code="sbv.01.form.48" /></button>
                    <button type="button" data-dismiss="modal" class="btn red"><spring:message code="sbv.01.hosoxe.dong" /></button>
                </div>
            </div>
        </div>
    </fieldset>
    </form>
</div>