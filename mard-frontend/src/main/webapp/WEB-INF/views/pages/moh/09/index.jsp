<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<div class="row" id="mt-container">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"><span data-bind="text: title" class="caption-subject bold uppercase"></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="caption-subject bold uppercase"><i class="fa fa-gift"></i> <spring:message code="moh.09.tracuu.timkiem" /> </span>
                                </div>
                                <div class="panel-body">
                                    <form role="form" class="form-horizontal" name="searchForm">
                                        <div class="form-group" style="margin-top: 15px;">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="moh.09.tracuu.mahoso" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="maHoSo" id="maHoSo" placeholder="<spring:message code="moh.09.tracuu.mahoso" />" data-bind="value : maHoSo, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="<spring:message code="common.tracuu.ma_ho_so" />" type="text"/>
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="moh.09.tracuu.trangthaihoso" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2" 
                                                            data-bind="value : trangThaiHoSo, options : lstTrangThai, optionsValue : 'id', optionsCaption: 'Tất cả...', optionsText : 'name'">
                                                    </select>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="moh.09.tracuu.ngaytaotu" /></label>
                                                </div>
                                                <div class="col-md-4">   
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" placeholder="<spring:message code="moh.09.tracuu.ngaytaotu" />" data-bind="datepicker : ngayTaoTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" maxlength="10" />
                                                </div>

                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="moh.09.tracuu.ngaytaoden" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="ngayTaoDenNgay" placeholder="<spring:message code="moh.09.tracuu.ngaytaoden" />" data-bind="datepicker : ngayTaoDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" maxlength="10" />
                                                </div>
                                            </div>  
                                        </div>

                                        <div class="form-group"> 
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="moh.09.tracuu.sotiepnhan" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="soTiephan" id="soTiephan" data-bind="value : soTiephan, executeOnEnter : searchFieldEnter, valueUpdate: 'input'" placeholder="Số tiếp nhận" type="text">
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="moh.09.tracuu.tochuckiemtra" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select name="coQuanKiemTra" class="form-control select2" 
                                                            data-bind="value : coQuanKiemTra, options : lstCoQuanKiemTra, optionsValue : 'fiMaTckt', optionsCaption: 'Tất cả...', optionsText : 'fiTenTckt'">
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group nsw-text-center">
                                            <a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: searchHoSoClick"><i class="fa fa-search"></i> Tìm kiếm</a>
                                            <a href="javascript:;" class="btn green" id="btnAddNew" data-bind="click : btnAddNewClick"><i class="fa fa-edit"></i> Thêm mới</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">                            
                    <div class="col col-md-6">
                        <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
                    </div>
                    <div class="col col-md-6 nsw-text-right">
                        <div id="list-pager" class="nsw-flr"> 
                            <!-- ko with:paging()-->
                            <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                                <li data-bind="css: { disabled: !firstPageActive() }">
                                    <a data-bind="click: goToFirst">Trang đầu</a>
                                </li>
                                <li data-bind="css: { disabled: !previousPageActive() }">
                                    <a data-bind="click: goToPrevious">Trang trước</a>
                                </li>
                                <!-- ko foreach: getPages() -->
                                <li data-bind="css: { active: $parent.currentPage() === $data }">
                                    <a data-bind="click: $parent.goToPage, text: $data"></a>
                                </li>
                                <!-- /ko -->
                                <li data-bind="css: { disabled: !nextPageActive() }">
                                    <a data-bind="click: goToNext">Trang sau</a>
                                </li>
                                <li data-bind="css: { disabled: !lastPageActive() }">
                                    <a data-bind="click: goToLast">Trang cuối</a>
                                </li>
                            </ul>
                            <!-- /ko -->
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="monre06Items">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"> <spring:message code="moh.09.danhsach.stt" /></th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="moh.09.danhsach.lichsutacdong" /> </th>
                            <th class="text-center" style="width: 120px;"> <spring:message code="moh.09.danhsach.mahoso" /> </th>
                            <th class="text-center" style="max-width: 200px;"> <spring:message code="moh.09.danhsach.tochuckiemtra" /> </th>
                            <th class="text-center" style="max-width: 200px;"> <spring:message code="moh.09.danhsach.sotiepnhan" /> </th>
                            <th class="text-center"> <spring:message code="moh.09.danhsach.trangthai" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="moh.09.danhsach.ngaygui" /> </th>
                            <th class="text-center" style="width: 25px;"> <spring:message code="moh.09.danhsach.sua" /> </th>
                            <th class="text-center" style="width: 25px;"> <spring:message code="moh.09.danhsach.xoa" /> </th>
                            <th class="text-center" style="width: 25px;"> <spring:message code="moh.09.danhsach.gui" /> </th>
                            <th class="text-center" style="width: 25px;"> <spring:message code="moh.09.danhsach.xinrut" /> </th>
                            <th class="text-center" style="width: 25px;"> <spring:message code="moh.09.danhsach.thongbaophi" /> </th>
                            <th class="text-center" style="width: 100px;"> <spring:message code="moh.09.danhsach.ketqua" /> </th>
                            <th class="text-center" style="width: 200px;"> <spring:message code="moh.09.danhsach.guibaocao" /> </th>

                        </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT">
                            </td>  
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-history" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="text : fiMaHoso, click: $parent.bXemClick.bind($parent)"></a>
                            </td> 
                            <td data-bind="text : fiTenTckt"></td>
                            <td data-bind="text : fiSoChungnhan"></td>
                            <td>
                                <a href="javascript:void(0)" data-bind="text : fiTenTrangthai, 
                                            event : {click : $parent.fiTrangThaiClick.bind($parent)}, 
                                            style: { color: fiTrangthai() === TU_CHOI_CAP_PHEP ? 'green' : 'black' }"></a>
                            </td>
                            <td class="text-center" data-bind="text : fiNgaynopText"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-edit tooltips" data-original-title="Sửa hồ sơ" data-bind="visible: bSuaHoSo, click: $parent.bSuaClick.bind($parent)" src="" alt=""/></a>
                            </td> 
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-close tooltips" style="color:red" data-original-title="Xoá hồ sơ" data-bind="visible: bXoaHoSo, click: $parent.bXoaClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-arrow-right" data-original-title="Gửi hồ sơ" data-bind="visible: bGuiHoSo, click: $parent.bGuiHoSoClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-arrow-circle-o-down tooltips" data-original-title="Xin rút hồ sơ" data-bind="visible: bXinRutHoSo, click: $parent.bXinRutHoSoClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Thông báo phí" data-bind="visible: bXemThongBaoPhi, click: $parent.bSendPaymentClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Kết quả" data-bind="visible: bXemKetQua, click: $parent.bXemThongBaoClick.bind($parent)" src="" alt=""/></a>
                            </td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Gửi báo cáo xử lý lô hàng không đạt" data-bind="visible: bGuiBaoCao, click: $parent.bSendReportClick.bind($parent)" src="" alt=""/></a>
                            </td>
                        </tr>                      
                        </script>
                    </table>
                    <div class="row">                            
                        <div class="col col-md-6">
                        </div>
                        <div class="col col-md-6 nsw-text-right">
                            <div id="list-pager" class="nsw-flr"> 
                                <!-- ko with:paging()-->
                                <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                                    <li data-bind="css: { disabled: !firstPageActive() }">
                                        <a data-bind="click: goToFirst">Trang đầu</a>
                                    </li>
                                    <li data-bind="css: { disabled: !previousPageActive() }">
                                        <a data-bind="click: goToPrevious">Trang trước</a>
                                    </li>
                                    <!-- ko foreach: getPages() -->
                                    <li data-bind="css: { active: $parent.currentPage() === $data }">
                                        <a data-bind="click: $parent.goToPage, text: $data"></a>
                                    </li>
                                    <!-- /ko -->
                                    <li data-bind="css: { disabled: !nextPageActive() }">
                                        <a data-bind="click: goToNext">Trang sau</a>
                                    </li>
                                    <li data-bind="css: { disabled: !lastPageActive() }">
                                        <a data-bind="click: goToLast">Trang cuối</a>
                                    </li>
                                </ul>
                                <!-- /ko -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="inc_script.jsp" %>
    <script type="text/javascript" charset="UTF-8">
        var user = JSON.parse('${user}');
        NSWLang["moh.BYTE0500009.tenthutuc"] = "<spring:message code="moh.BYTE0500009.tenthutuc" />";
        NSWLang["moh.BYTE0500010.tenthutuc"] = "<spring:message code="moh.BYTE0500010.tenthutuc" />";

        NSWLang["moh.BYTE0500009.phuongthuckt"] = "<spring:message code="moh.BYTE0500009.phuongthuckt" />";
        NSWLang["moh.BYTE0500010.phuongthuckt"] = "<spring:message code="moh.BYTE0500010.phuongthuckt" />";

        var uploadUrl = '${upload}';
    </script>
    <script src="<c:url value='/app/moh/09/model.js?v=${version}'/>" type="text/javascript"></script>
    <script src="<c:url value='/app/moh/09/ReportVM.js?v=${version}'/>" type="text/javascript"></script>
    <script src="<c:url value='/app/moh/09/Payment.js?v=${version}'/>" type="text/javascript"></script>
    <script src="<c:url value='/app/moh/09/index.js?v=${version}' />" type="text/javascript"></script>

    <template id="confirm-tmpl">
        <div class="row">
            <form role="form" class="form-horizontal" id="xoahoso-form">
                <div class="col-md-12">
                    <span data-bind="text: fiMsg"></span><b data-bind="text: fiMaHoso"></b>
                </div>
            </form>
        </div>
    </template>
    <template id="lichsu-tmpl">
        <div class="row">
            <form role="form" class="form-horizontal" id="lichsu-form">
                <div class="form-group">

                </div>
            </form>
        </div>
    </template>
    <template id="history-tmpl">
        <form role="form" class="form-horizontal" id="history-form">
            <p><spring:message code="common.history.mahoso" /> <b data-bind="text: fiMaHoso"></b></p>
            <div class="row">                            
                <div class="col col-md-6">
                    <spring:message code="common.tong" /> <b><a id="lbTotalRecords" data-bind="text: totalCount" href="javascript:void(0);"></a> </b><spring:message code="common.pager.ban_ghi" />
                </div>
                <div class="col col-md-6 nsw-text-right">
                    <div class="nsw-flr"> 
                        <!-- ko with:paging()-->
                        <ul data-bind="visible: true" class="flip pull-left pagination pagination-sm">
                            <li data-bind="css: { disabled: !firstPageActive() }">
                                <a data-bind="click: goToFirst">Trang đầu</a>
                            </li>
                            <li data-bind="css: { disabled: !previousPageActive() }">
                                <a data-bind="click: goToPrevious">Trang trước</a>
                            </li>
                            <!-- ko foreach: getPages() -->
                            <li data-bind="css: { active: $parent.currentPage() === $data }">
                                <a data-bind="click: $parent.goToPage, text: $data"></a>
                            </li>
                            <!-- /ko -->
                            <li data-bind="css: { disabled: !nextPageActive() }">
                                <a data-bind="click: goToNext">Trang sau</a>
                            </li>
                            <li data-bind="css: { disabled: !lastPageActive() }">
                                <a data-bind="click: goToLast">Trang cuối</a>
                            </li>
                        </ul>
                        <!-- /ko -->
                    </div>
                </div>
            </div>
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr>
                        <th class="text-center"><b><spring:message code="mt.lichsu.stt" /></b></th>
                        <th><b><spring:message code="mt.lichsu.nguoixuly" /></b></th>
                        <th><b><spring:message code="mt.lichsu.donvixuly" /></b></th>
                        <th style="max-width: 200px;"><b><spring:message code="mt.lichsu.noidung" /></b></th>
                        <th class="text-center"><b><spring:message code="mt.lichsu.thoigian" /></b></th>
                        <th style="max-width: 200px;"><b><spring:message code="mt.lichsu.trangthaihoso" /></b></th>
                    </tr>
                </thead>
                <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
                </tbody>
                <script id="historyItemTmpl" type="text/html">
                    <tr>
                        <td data-bind="text : STT"></td>
                        <td class="text-left" data-bind="text : fiTenNggui"></td> 
                        <td class="text-left" data-bind="text : fiTenDvgui"></td> 
                        <td class="text-left" data-bind="text : fiNoidung"></td> 
                        <td class="text-center" data-bind="text : fiNgaytao"></td> 
                        <td class="text-left" data-bind="text : fiTenTt"></td>                     
                    </tr>                      
                    </script>
                </table>        
            </form>
        </template>
        <template id="ruthoso-tmpl">
            <div class="row">
                <form role="form" class="form-horizontal" name="ruthoso-form" id="ruthoso-form">
                    <div class="col-md-12">
                        <p><label data-bind="text: fiMsg"></label><b data-bind="text: fiMaHoso"></b></p>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="common.msg.ly_do" /></label>
                        <a class="nsw-require-field">*</a>
                    </div>
                    <div class="col-md-10">
                        <textarea name="fiContent" id="fiContent" data-bind="value: fiContent" require="true" placeholder="<spring:message code="common.msg.ly_do" />" style="width: 90%; height: 150px;" maxlength="500"></textarea>
                    </div>
                </form>
            </div>
        </template>    
        <template id="kqxl-template">
            <form role="form" class="form-horizontal" id="kqxl-form">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label>Mã hồ sơ: </label>
                        </div>
                        <div class="col-md-8" data-bind="text : fiMaHoso">  
                        </div>
                    </div>  
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label>Nội dung: </label>
                        </div>
                        <div class="col-md-8" data-bind="text : fiNoidungXl">  
                        </div>
                    </div>   
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label>Ngày xử lý: </label>
                        </div>
                        <div class="col-md-8" data-bind="date : fiNgayXl">  
                        </div>
                    </div>   
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label>Đơn vị xử lý: </label>
                        </div>
                        <div class="col-md-8" data-bind="text : fiTenCqxl">  
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <label>Người xử lý: </label>
                        </div>
                        <div class="col-md-8" data-bind="text : fiNguoiXl">  
                        </div>
                    </div> 
                    <div class="col-md-12" data-bind="visible: isVisibleLink">
                        <div class="col-md-4">
                            <label>Link công văn: </label>
                        </div>
                        <div class="col-md-8">  
                            <a target="_blank" href="javascript:void(0);" data-bind="attr: { href: fiLinkCvan}"><i class="fa fa-download fa-lg"></i></a>
                        </div>
                    </div>
                </div>
            </form>
        </template> 
        <template id="payment-tmpl">
            <form role="form" class="form-horizontal" id="payment-form">
                <b><spring:message code="moh.09.thongbaophi" /></b>
                <div class="row">
                    <div class="col-md-5 nsw-text-right">
                        <label><spring:message code="moh.09.thongbaophi.coquanyeucau" /></label>
                    </div>
                    <div class="col-md-7">
                        <p><b data-bind="text: fiTenTckt"></b></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 nsw-text-right">
                        <label><spring:message code="moh.09.thongbaophi.sotienphainop" /></label>
                    </div>
                    <div class="col-md-7">
                        <p><b data-bind="text: fiTongTien"></b></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 nsw-text-right">
                        <label><spring:message code="moh.09.thongbaophi.sotaikhoan" /></label>
                    </div>
                    <div class="col-md-7">
                        <p><b data-bind="text: fiSoTk"></b></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 nsw-text-right">
                        <label><spring:message code="moh.09.thongbaophi.nganhang" /></label>
                    </div>
                    <div class="col-md-7">
                        <p><b data-bind="text: fiNganHang"></b></p>
                    </div>
                </div>
                <b><spring:message code="moh.09.thongbaophi.xacnhanthanhtoan" /></b>
                <div class="row">
                    <div class="col-md-5 nsw-text-right">
                        <label><spring:message code="moh.09.thongbaophi.loaithanhtoan" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-7">
                        <select class="form-control select2 fiLoaiTt" id="fiLoaiTt" name="fiLoaiTt"  
                                data-bind="value: fiLoaiTt, 
                            optionsCaption: 'Chọn...', 
                            optionsValue : 'id',
                            options : lstLoaiThanhToan, 
                            optionsText : 'name'"></select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 nsw-text-right">
                        <label><spring:message code="moh.09.thongbaophi.chungtu" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-7">
                        <a class="btn btn-info btn-xs" data-bind="click : doUpload, visible: canUpload">Đính kèm</a>
                        <a target="_blank" href="javascript:void(0);" data-bind="visible: canDownload, attr: { href: fiDuongDan}, text: fiTenTep"><i class="fa fa-download fa-lg"></i></a>
                        <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="visible: canDownload, click: removeAttach"></i></a>
                    </div>
                </div>

                <div class="row">   
                    <div class="col-md-5">
                        <a>(Bắt buộc với Loại thanh toán là Chuyển khoản)</a>
                    </div>
                    <div class="col-md-7"></div>
                </div>
                <div class="row" style="display:none">    
                    <div class="col-md-5 nsw-text-right">
                        <label>Ghi chú <a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-7">
                        <textarea name="fiContent" id="fiContent" data-bind="value: fiContent" require="true" style="width: 100%; height: 150px;" maxlength="500"></textarea>
                    </div>
                </div>
            </form>
        </template>
        <template id="report-tmpl">
            <form role="form" class="form-horizontal" name="ruthoso-form" id="report-form">   
                <div class="row">
                    <div class="col-md-4 nsw-text-right">
                        <label>Tệp báo cáo <a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-8">
                        <a class="btn btn-info btn-xs" data-bind="click : doUpload">Đính kèm</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-8">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center">Tên tệp</th>                        
                                    <th class="text-center" style="width: 150px">Chức năng</th>
                                </tr>
                            </thead>
                            <tbody data-bind="template: { name: 'dinhKemTmpl', foreach: lstDinhKems }">
                            </tbody>
                            <script id="dinhKemTmpl" type="text/html">
                                <tr>
                                    <td>
                                        <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiDuongDan}"></a>
                                    </td> 
                                    <td class="text-center">
                                        <a href="javascript:void(0);"><i class="fa fa-trash red fa-lg" style="color:red" data-bind="click: $parent.removeAttach "/></a>
                                    </td>  
                                </tr>                      
                                </script>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 nsw-text-right">
                            <label>Nội dung</label>
                        </div>
                        <div class="col-md-8">
                            <textarea name="fiNoidung" id="fiNoidung" data-bind="value: fiNoidung" require="true" style="width: 100%; height: 150px;" maxlength="500"></textarea>
                        </div>
                    </div>
                </form>
            </template>