<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="incLanguages.jsp" %>
<div class="row" id="danhSachVM">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"><spring:message code="most.04.danhsach.tenthutuc" /></span>
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
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.04.danhsach.mahoso" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" data-bind="value: maHoSo, valueUpdate: 'afterkeydown'" name="maHoSo" id="maHoSo" placeholder="<spring:message code="most.03.danhsach.mahoso" />" type="text">
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.04.danhsach.trangthai" /></label>
                                                </div>
                                                <div class="col-md-4">                                                    
                                                    <select id="trangThaiHoSo" name="trangThaiHoSo" class="form-control select2" 
                                                            data-bind="value : trangThaiHoSo, options : fiTrangthaiList, optionsValue : 'id', optionsText : 'name', optionsCaption: 'Chọn...'">
                                                    </select>
                                                </div>
                                            </div>  
                                        </div> 
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.04.danhsach.ngaytao1" /></label>
                                                </div>
                                                <div class="col-md-4">                                        
                                                    <input name="ngayTaoTuNgay" id="ngayTaoTuNgay" data-bind="datepicker : ngayTaoTuNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy"  type="text" value="" />
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.04.danhsach.ngaytao2" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input name="ngayTaoDenNgay" id="ngayTaoDenNgay" data-bind="datepicker : ngayTaoDenNgay" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                                                </div>
                                            </div>  
                                        </div>
                                        <div class="form-group"> 
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Số giấy phép</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="soGiayPhep" id="soGiayPhep" data-bind="value : soGiayPhep" placeholder="Số giấy phép được cấp" type="text">
                                                </div>
                                                <div class="col-md-2 nsw-text-right">
                                                    <label>Mã doanh nghiệp</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input class="form-control" name="nguoiTao" id="nguoiTao" data-bind="value : nguoiTao" placeholder="Tên tài khoản đăng nhập hệ thống 1 Cửa" type="text">
                                                </div> 
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="col-md-2 nsw-text-right">
                                                    <label><spring:message code="most.04.danhsach.nhomhanghoa" /></label>
                                                </div>
                                                <div class="col-md-4">
                                                    <select class="form-control" id="maNhomHangHoa" name="maNhomHangHoa" 
                                                            data-bind="optionsCaption: '<spring:message code="common.chon" />', value : maNhomHangHoa, optionsText: 'fiTen', optionsValue:'fiMa', options : lstNhomHangHoa"></select>
                                                </div>
                                                <div class="col-md-2">

                                                </div>
                                                <div class="col-md-4">
                                                    <a href="javascript:;" class="btn green" id="searchHoSo" data-bind="click: onSearchClick"><i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" /></a>
                                                </div>
                                            </div>  
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
                </div>                                
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center w50"><spring:message code="most.04.danhsach.tb.stt" /></th>
                            <th class="text-center w100"><spring:message code="most.04.danhsach.tb.lichsuxuly" /></th>
                            <th class="text-center"><spring:message code="most.04.danhsach.tb.mahoso" /></th>
                            <th class=""><spring:message code="most.04.danhsach.tb.nhomhanghoa" /></th>
                            <th class="text-center w150"><spring:message code="most.04.danhsach.tb.ngaytao" /></th>
                            <th class=""><spring:message code="most.04.danhsach.tb.trangthai" /></th>
                            <th class="text-center w50"><spring:message code="most.04.danhsach.tb.xemgiaychungnhan" /></th>                            
                        </tr>
                    </thead>
                    <tbody id="list-container" data-bind="template: { name: 'itemTmpl', foreach: most03Items }">
                    </tbody>
                    <script id="itemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT"></td>
                            <td style="max-width: 200px;" class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-history fa-lg" data-bind="click: $parent.onViewHistoryClick.bind($parent)" src="" alt=""/></a>
                            </td> 
                            <td class="text-center">
                                <a href="javascript:void(0)" data-bind="text : fiMaHoso, event : {click : $parent.onViewDetail.bind($parent)}"></a>
                            </td> 
                            <td class="" data-bind="text : fiDsTenNhomHH"></td> 
                            <td class="text-center" data-bind="text : fiNgaytao"></td> 
                            <td class="" data-bind="text : fiTenTt"></td>
                            <td class="text-center">
                                <a href="javascript:void(0)"><i class="fa fa-search fa-lg" data-bind="visible: bXemGiayChungNhan, click: $parent.bXemQuyetDinhClick.bind($parent)" src="" alt=""/></a>
                            </td>                             
                        </tr>                      
                        </script>
                    </table>
                    <div class="row">                            

                        <div class="col col-md-6 nsw-text-right">
                            <div id="list-pager" class="pull-left"> 
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
    <template id="bosungtailieu-tmpl">
        <form role="form" class="form-horizontal" id="Most04BoSungTaiLieuForm">
            <div class="row-border">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2">
                            <label><spring:message code="most.04.bosungtailieu.noidungyeucau" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <b><spring:message code="most.04.bosungtailieu.yeucau" /></b>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2">
                            <label><spring:message code="most.04.bosungtailieu.thongtinbosung" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <textarea id="fiThongtinbosung" name="fiThongtinbosung" data-bind="value: fiThongtinbosung"  maxlength="500" class="form-control" 
                                      height="200px"></textarea>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2">
                            <label><spring:message code="most.04.dinhkem.tailentep" /><a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <input id="fiTep" class="form-control" type="file" data-bind="event: {change: fileUpload}"/>
                            <a href="javascript:void(0);" class="btn green" id="upload" data-bind="click: uploadClick"><i class="fa fa-upload"></i> Tải lên</a>
                        </div>
                    </div>
                </div>  
                <div class="form-group">
                    <div class="col-md-12">
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstDinhkem10">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="w50 text-center"><spring:message code="most.04.dinhkem.stt" /></th>
                                    <th><spring:message code="most.04.dinhkem.tentep" /></th>
                                    <th class="w100 text-center" style="width: 30px;">Xóa</th>
                                </tr>
                            </thead>
                            <tbody id="file-container" data-bind="template: { name: 'dinhkemTmpl', foreach: lstDinhkem }">
                            </tbody>
                            <script id="dinhkemTmpl" type="text/html">
                                <tr>
                                    <td data-bind="text: stt"></td>  
                                    <td data-bind="text: fiTenTep"></td>
                                    <td class="text-center" >
                                        <a href="javascript:void(0);"><i class="fa fa-remove" data-bind="visible: bXoa, click: $parent.bXoaClick.bind($parent)"/></a>
                                    </td>  
                                </tr>                      
                                </script>
                            </table>
                        </div>
                    </div>
                </div>
            </form>
        </template>    
        <template id="lichsu-tmpl">
            <div class="row">
                <form role="form" class="form-horizontal" id="lichsu-form">
                    <div class="form-group">

                    </div>
                </form>
            </div>
        </template>
        <template id="ruthoso-tmpl">
            <div class="row">
                <form role="form" class="form-horizontal" name="ruthoso-form" id="ruthoso-form">
                    <div class="col-md-12">
                        <p><label data-bind="text: fiMsg"></label><b data-bind="text: fiMaHoso"></b></p>
                    </div>
                    <div class="col-md-2" data-bind="style: { display: fiTrangthai() <= 1 ? 'none' : '' }">
                        <label><spring:message code="common.msg.ly_do" /></label>
                        <a class="nsw-require-field">*</a>
                    </div>
                    <div class="col-md-10" data-bind="style: { display: fiTrangthai() <= 1 ? 'none' : '' }">
                        <textarea name="Reason" id="fiContent" data-bind="value: fiContent" require="true" placeholder="<spring:message code="common.msg.ly_do" />" style="width: 90%; height: 150px;" maxlength="500"></textarea>
                    </div>
                </form>
            </div>
        </template>
        <template id="confirm-tmpl">
            <div class="row">
                <form role="form" class="form-horizontal" id="xoahoso-form">
                    <div class="col-md-12">
                        <span data-bind="text: fiMsg"></span><b data-bind="text: fiMaHoso"></b>
                    </div>
                </form>
            </div>
        </template>
        <template id="history-tmpl">
            <form role="form" class="form-horizontal" id="history-form">
                <p><spring:message code="common.history.mahoso" /> <b data-bind="text: fiMaHoso"></b></p>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr>
                            <th><b><spring:message code="common.history.stt" /></b></th>
                            <th><b><spring:message code="common.history.donvixuly" /></b></th>
                            <th><b><spring:message code="common.history.nguoixuly" /></b></th>
                            <th><b><spring:message code="common.history.thoigian" /></b></th>
                            <th><b><spring:message code="common.history.noidung" /></b></th>
                            <th><b><spring:message code="common.history.hanxuly" /></b></th>
                            <th><b><spring:message code="common.history.trangthaihoso" /></b></th>
                            <th><b><spring:message code="common.tai_lieu_dinh_kem" /></b></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'historyItemTmpl', foreach: historyItems }">
                    </tbody>
                    <script id="historyItemTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : STT"></td>
                            <td class="text-center" data-bind="text : fiTenDvgui"></td> 
                            <td class="text-center" data-bind="text : fiTenNggui"></td> 
                            <td class="text-center" data-bind="text : fiNgaytao"></td> 
                            <td class="text-center" data-bind="text : fiNoidung"></td> 
                            <td class="text-center" data-bind="text : fiThoihan"></td> 
                            <td class="text-center" data-bind="text : fiTenTt"></td> 
                            <td class="text-center">
                                <a target="_blank" data-bind="visible: true, attr: { href: downloadUrl, title: fiFileCode }"><p data-bind="text : fiFileName" ></p></a>
                            </td>
                        </tr>                      
                        </script>
                    </table>
                </form>
            </template>

            <script src="<c:url value='/app/most/04/Model.js?v=${version}'/>" type="text/javascript"></script>
            <script src="<c:url value='/app/most/04/Index.js?v=${version}' />" type="text/javascript"></script>