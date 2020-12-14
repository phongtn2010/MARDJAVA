<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><spring:message code="mt.36.giayphep.danhsach" /></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="mt.36.giayphep.stt" /></th>
                        <th class="text-center"><spring:message code="mt.36.giayphep.lichsu" /></th>
                        <th class="text-center"><spring:message code="mt.36.giayphep.sogiayphep" /></th>
                        <th class="text-center"><spring:message code="mt.36.giayphep.loaigiayphep" /></th>
                        <th class="text-center"><spring:message code="mt.36.giayphep.ngaycapphep" /></th>
                        <th class="text-center"><spring:message code="mt.36.giayphep.biensoxe" /></th>
                        <th class="text-center"><spring:message code="mt.36.giayphep.trangthai" /></th>
                        <th class="text-center"><spring:message code="mt.36.giayphep.xemgiayphep" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstGiayPhep">
                    <tr>
                        <td data-bind="text : STT"></td>  
                        <td class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-history" data-bind="visible: true, click: $parent.bXemLichSuClick.bind($parent)" src="" alt=""></i></a>
                        </td>
                        <td data-bind="text : fiSoGp"></td>
                        <td data-bind="text : fiLoaiGp"></td>
                        <td class="text-center" data-bind="text : fiGpTuNgayText"></td> 
                        <td data-bind="text : fiBksXe"></td>
                        <td data-bind="text : fiTenTt"></td>
                        <td class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-lg fa-search tooltips" data-original-title="Xem giấy phép" data-bind="click: $parent.bXemThongBaoClick.bind($parent)" src="" alt=""></i></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</fieldset>
<template id="form-b-template">
    <div class="row">
        <form role="form" class="form-horizontal" id="form-b">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.sogiayphep" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.nguoiky" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiTenNgKy" readonly="readonly"/>
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.tendoanhnghiep" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiTenDn" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.chucdanh" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiChucDanh" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.diadiemky" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiDiaDiem" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.ngayky" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control"data-bind="value : fiNgaykyText" type="text" readonly/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.biensoxe" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiBksXe" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.sohanhkhach" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoGhe" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.giatritungay" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"data-bind="value : fiGpTuNgayText" type="text" readonly/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.giatridenngay" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" data-bind="value : fiGpDenNgayText" type="text" readonly/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.tuyenvantaitu" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiTuyenDi" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.tuyenvantaiden" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiTuyenDen" readonly="readonly"/>
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.hanhtrinh" />: </label>
                    </div>
                    <div class="col-md-8">
                        <input class="form-control" type="text" data-bind="value : fiHanhtrinh" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.mucdich" />: </label>
                    </div>
                    <div class="col-md-8">
                        <input type="checkbox" id="cbThuongMai" name="cbThuongMai" value="cbThuongMai"></input>
                        <label for="cbThuongMai">Thương mại</label>
                        <br/>
                        <input type="checkbox" id="cbCongVu" name="cbCongVu" value="cbCongVu"></input>
                        <label for="cbCongVu">Công vụ</label>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.link" />: </label>
                    </div>
                    <div class="col-md-8">
                        <table class="tb-content tb-none-border w100p">
                            <tbody data-bind="foreach: lstDinhKem">
                                <tr>
                                    <td class="left">
                                        <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiUrl}"></a>
                                    </td>            
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </form>
    </div>
</template>
<template id="form-f-template">
    <div class="row">
        <form role="form" class="form-horizontal" id="form-f">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.sogiayphep" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.nguoiky" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiTenNgKy" readonly="readonly"/>
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.tendoanhnghiep" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiTenDn" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.chucdanh" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiChucDanh" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.diadiemky" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiDiaDiem" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.ngayky" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiNgaykyText" readonly="readonly"/>
                    </div>
                </div>            
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.giatritungay" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"data-bind="value : fiGpTuNgayText" type="text" readonly/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.giatridenngay" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" data-bind="value : fiGpDenNgayText" type="text" readonly/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.biensoxe" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiBksXe" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.soghe" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoGhe" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.sokhung" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoKhung" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.somay" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoMay" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.mauson" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiMauSon" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.nhanhieu" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiTenHieu" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.tuyenvantaitu" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiTuyenDi" readonly="readonly"/>
                    </div>
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.tuyenvantaiden" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiTuyenDen" readonly="readonly"/>
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.hanhtrinh" />: </label>
                    </div>
                    <div class="col-md-8">
                        <input class="form-control" type="text" data-bind="value : fiHanhtrinh" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.mucdich" />: </label>
                    </div>
                    <div class="col-md-8">
                        <input type="checkbox" id="cbThuongMai" name="cbThuongMai" value="cbThuongMai"></input>
                        <label for="cbThuongMai">Thương mại</label>
                        <br/>
                        <input type="checkbox" id="cbCongVu" name="cbCongVu" value="cbCongVu"></input>
                        <label for="cbCongVu">Công vụ</label>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <label><spring:message code="mt.36.giayphep.link" />: </label>
                    </div>
                    <div class="col-md-8">
                        <table class="tb-content tb-none-border w100p">
                            <tbody data-bind="foreach: lstDinhKem">
                                <tr>
                                    <td class="left">
                                        <a target="_blank" data-bind="text: fiTenTep, attr: { href: fiUrl}"></a>
                                    </td>            
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
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
                    <th class="text-center"><b><spring:message code="mt.36.lichsu.stt" /></b></th>
                    <th><b><spring:message code="mt.36.lichsu.nguoixuly" /></b></th>
                    <th><b><spring:message code="mt.36.lichsu.donvixuly" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="mt.36.lichsu.noidung" /></b></th>
                    <th class="text-center"><b><spring:message code="mt.36.lichsu.thoigian" /></b></th>
                    <th style="max-width: 200px;"><b><spring:message code="mt.36.lichsu.trangthaihoso" /></b></th>
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