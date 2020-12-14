<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<input type="hidden" value="${ IS_SIGN_KEY }" id="kySo"/>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="caption-subject bold uppercase">Xem giấy phép</span>
            </div>
            <div class="panel-body">
                <form role="form" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2 label-text-right">
                                <label>Số giấy phép</label>
                            </div>
                            <div class="col-md-4">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="value: giayphep.fiSoGiayphep"
                                       class="form-control form-control-inline " size="16" type="text" disabled/>
                            </div>
                            <div class="col-md-2 label-text-right">
                                <label>Đăng ký lần đầu</label>
                            </div>
                            <div class="col-md-4">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="datepicker: giayphep.fiNgaydangky" data-date-format="dd/mm/yyyy"
                                       class="form-control form-control-inline " size="16" type="text" disabled/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12 label-text-right">
                            <div class="col-md-2 label-text-right">
                                <label>Người ký</label>
                            </div>
                            <div class="col-md-4">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="value: giayphep.fiNguoiky"
                                       class="form-control form-control-inline " size="16" type="text" disabled/></div>
                            <div class="col-md-2 label-text-right">
                                <label>Chức danh</label>
                            </div>
                            <div class="col-md-4">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="value: giayphep.fiIdGiayphep"
                                       class="form-control form-control-inline " size="16" type="text" disabled/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2 label-text-right">
                                <label>Địa điểm ký</label>
                            </div>
                            <div class="col-md-4">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="value: giayphep.fiIdGiayphep"
                                       class="form-control form-control-inline " size="16" type="text" disabled/></div>
                            <div class="col-md-2 label-text-right">
                                <label>Ngày ký</label>
                            </div>
                            <div class="col-md-4">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="datepicker: giayphep.fiNgayky"  data-date-format="dd/mm/yyyy"
                                       class="form-control form-control-inline " size="16" type="text" disabled/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2 label-text-right">
                                <label>Giấy phép có hiệu lực đến</label>
                            </div>
                            <div class="col-md-4">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="datepicker: giayphep.fiNgaycaphethan"  data-date-format="dd/mm/yyyy"
                                       class="form-control form-control-inline " size="16" type="text" disabled/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2 label-text-right">
                                <label>Loại hình hoạt động</label>
                            </div>
                            <div class="col-md-10">
                                <input name="ngayNopTuNgay" field="common_tracuu_ngay_tao_tu"
                                       data-bind="value: giayphep.fiLoaihinhvantai"
                                       class="form-control form-control-inline " size="16" type="text" disabled/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2 label-text-right">
                                <label>Link giấy phép</label>
                            </div>
                            <div class="col-md-10">
                                <a target="_blank" data-bind="text: 'Link công văn', attr: { href: giayphep.fiLinkGiayphep}"></a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="form-group nsw-text-center">
        <a class="btn green bt-center btwidth" id="btSua"
           data-bind="attr: { 'id': giayphep.fiIdGiayphep },click: $root.suaGiayPhep"> <i
                class="fa fa-edit" aria-hidden="true"></i> &nbsp;
            Xin sửa giấy phép </a>
        <a class="btn blue bt-center btwidth" id="btTra"
           data-bind="attr: { 'id': giayphep.fiIdGiayphep },click: $root.traGiayPhep"> <i
                class="fa fa-undo" aria-hidden="true"></i></i>&nbsp;
            Trả lại giấy phép </a>
        <a href="javascript:;"
           data-bind="click: $root.dong" class="btn red bt-center btwidth" id="btDong"> <i
                class="fa fa-times" aria-hidden="true"></i></i>&nbsp;
            <spring:message code="common.button.dong"/> </a>
    </div>
</div>
<script type="text/javascript"
        src="<c:url value="/app/mt/p52/license.module.js?v=${ version }"/>"
        charset="utf-8"></script>
<script type="text/javascript" src="<c:url value="/app/mt/p52/model.js?v=${ version }"/>"
        charset="utf-8"></script>

<script>
    var giayPhepId = "${giayPhepId}";
</script>
<script>
    if(giayPhepId){
        var procedureId = '${procedureId}';
    }
</script>