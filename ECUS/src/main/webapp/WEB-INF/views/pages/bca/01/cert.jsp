<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><spring:message code="bca.01.giayphep.danhsach" /></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="bca.01.giayphep.danhsach.stt" /></th>
                        <th class="text-center"><spring:message code="bca.01.giayphep.danhsach.sogp" /></th>
                        <th class="text-center"><spring:message code="bca.01.giayphep.danhsach.ngaycap" /></th>
                        <th class="text-center"><spring:message code="bca.01.giayphep.danhsach.trangthai" /></th>
                        <th class="text-center"><spring:message code="bca.01.giayphep.danhsach.xemgiayphep" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstGiayPhep">
                    <tr>
                        <td data-bind="text : STT"></td>  
                        <td data-bind="text : fiSoGp"></td>
                        <td data-bind="text : fiNgayCPText"></td>
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
<template id="form-template">
        <form role="form" class="form-horizontal" >
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.sogp" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.coquancap" /> </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiTenCoquan" readonly="readonly"/>
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.nguoiky" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNguoiky" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.chucdanh" /> </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiChucdanhNguoiky" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.diadiemky" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiDiadiemKy" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngayky" /> </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control"data-bind="value : fiNgaykyText" type="text" readonly/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngayhieuluc" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control " type="text" data-bind="value : fiNgayHieulucText" readonly="readonly" />
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngayhethan" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control " type="text" data-bind="value : fiNgayHethanText" readonly="readonly" />
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.nguoidaidien" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control"data-bind="value : fiNguoiDaidien" type="text" readonly/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.anhdaidien" /> </label>
                    </div>
                    <div class="col-md-4">  
                        <a target="_blank" data-bind="text: fiTenAnh, attr: { href: downloadUrlAnh}"></a>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.cmndhochieu" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoCmnd" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngaycap" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control " type="text" data-bind="value : fiNgaycapCmndText" readonly="readonly" />
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.dươcphepmang" /></label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiDuocmang" readonly="readonly"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <b><spring:message code="bca.01.giayphep.dshanghoa"/></b>
                        <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                            <thead>
                                <tr class="nsw-tr tr-nsw1-bgcolor">
                                    <th class="text-center"><spring:message code="bca.01.giayphep.dshanghoa.stt" /></th>
                                    <th class="text-center"><spring:message code="bca.01.giayphep.dshanghoa.ten" /></th>
                                    <th class="text-center"><spring:message code="bca.01.giayphep.dshanghoa.mahs" /></th>
                                    <th class="text-center"><spring:message code="bca.01.giayphep.dshanghoa.chungloai"/></th>
                                    <th class="text-center"><spring:message code="bca.01.giayphep.dshanghoa.soluong" /></th>
                                    <th class="text-center"><spring:message code="bca.01.giayphep.dshanghoa.dvtinh" /></th>
                                    <th class="text-center"><spring:message code="bca.01.giayphep.dshanghoa.kichthuoc" /></th>
                                </tr>
                            </thead>
                            <tbody data-bind="foreach: lstHangHoa">
                                <tr>
                                    <td data-bind="text : $index() + 1"></td>  
                                    <td data-bind="text : fiTenHh"></td>  
                                    <td data-bind="text : fiMaHs"></td>  
                                    <td data-bind="text : fiChungloai"></td>
                                    <td data-bind="text : fiSoluong"></td>  
                                    <td data-bind="text : fiDvTinh"></td>  
                                    <td data-bind="text : fiKichthuoc"></td>
                                </tr>
                            </tbody>
                        </table>            
                    </div>
                </div>


                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.lydo" /> </label>
                    </div>
                    <div class="col-md-10">
                        <input class="form-control" type="text" data-bind="value : fiLydo" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.phuongtien" /> </label>
                    </div>
                    <div class="col-md-10">
                        <input class="form-control" type="text" data-bind="value : fiPhuongtien" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ckvao" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiCuakhauVao" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ckra" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiCuakhauRa" readonly="readonly"/>
                    </div>
                </div>   
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.khongmang" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNeuKhongmang" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.hoanthanhmang" /> </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNeuHoanthanh" readonly="readonly"/>
                    </div>
                    <div class="col-md-6 text-left">
                        <label><spring:message code="bca.01.giayphep.baolai" /> </label>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep" /> </label>
                    </div>
                    <div class="col-md-4">
                        <a target="_blank" data-bind="text: fiTenTepgp, attr: { href: downloadUrlGp}"></a>
                    </div>
                </div>

            </div>
        </form>
</template>