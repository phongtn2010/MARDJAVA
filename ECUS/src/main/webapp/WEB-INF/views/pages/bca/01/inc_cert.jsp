<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<template id="form-a-template">
    <div class="row">
        <form role="form" class="form-horizontal" id="form-a">
            <div class="form-group">
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.sogp" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.coquancap" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiTenCoquan" readonly="readonly"/>
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.nguoiky" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNguoiky" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.chucdanh" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiChucdanhNguoiky" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.diadiemky" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiDiadiemKy" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngayky" />: </label>
                    </div>
                    <div class="col-md-4">  
                        <input class="form-control" type="text" data-bind="value : fiNgayky" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngayhieuluc" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNgayHieuluc" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngayhethan" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNgayHethan" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.nguoidaidien" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNguoiDaidien" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.anhdaidien" />: </label>
                    </div>
                    <div class="col-md-4">
                        <a target="_blank" data-bind="text: fiTenAnh, attr: { href: downloadUrl}"></a>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.cmndhochieu" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiSoCmnd" readonly="readonly"/>
                    </div>
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.ngaycap" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiNgaycapCmnd" readonly="readonly"/>
                    </div>
                </div> 
                <div class="col-md-12">
                    <div class="col-md-2 nsw-text-right">
                        <label><spring:message code="bca.01.giayphep.dươcphepmang" />: </label>
                    </div>
                    <div class="col-md-4">
                        <input class="form-control" type="text" data-bind="value : fiDuocmang" readonly="readonly"/>
                    </div>
                </div>

                <b><spring:message code="bca.01.giayphep.dshanghoa"/></b>
                    <div class="form-group">
                        <div class="col-md-12">
                            <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                <thead>
                                    <tr class="nsw-tr tr-nsw1-bgcolor">
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.stt" /></th>
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.ten" /></th>
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.mahs" /></th>
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.chungloai" /></th>
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.soluong" /></th>
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.dvtinh" /></th>
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.kichthuoc" /></th>
                                        <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.chucnang" /></th>
                                    </tr>
                                </thead>
                                <tbody data-bind="foreach: lstHangHoa">
                                    <tr>
                                        <td data-bind="text : STT"></td>  
                                        <td data-bind="text : fiTenhanghoa"></td>
                                        <td data-bind="text : fiMahs" class="text-center"></td>
                                        <td data-bind="text : fiChungloai"></td>
                                        <td data-bind="text : fiSoluong" class="text-center"></td>
                                        <td data-bind="text : fiTenDvt" class="text-center"></td>
                                        <td data-bind="text : fiKichthuoc"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>


                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="bca.01.giayphep.lydo" />: </label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" type="text" data-bind="value : fiLydo" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="bca.01.giayphep.phuongtien" />: </label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" type="text" data-bind="value : fiPhuongtien" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="bca.01.giayphep.ckvao" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiCuakhauVao" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="bca.01.giayphep.ckra" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiCuakhauRa" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="bca.01.giayphep.khongmang" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiNeuKhongmang" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="bca.01.giayphep.hoanthanhmang" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiNeuHoanthanh" readonly="readonly"/>
                        </div>
                        <div class="col-md-6">
                            <label><spring:message code="bca.01.giayphep.baolai" />: </label>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="bca.01.giayphep.giayphep" />: </label>
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