<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<template id="form-vtgms-template">
    <div class="row">
        <form role="form" class="form-horizontal" id="form-vtgms">
            <div class="form-group">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.sogiayphep" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.donvinguoikhaithac" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiDvNkt" readonly="readonly"/>
                        </div>
                    </div> 
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.diachi" />: </label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" type="text" data-bind="value : fiDiachiDn" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.tel" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiSdtDn" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.fax" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiFax" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.nguoiky" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiTenNgKy" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.chucdanh" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiChucDanh" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.diadiemky" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiDiaDiem" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.ngayky" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiNgaykyText" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.gptungay" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiGpTuNgayText" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.gpdenngay" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiGpDenNgayText" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.sophuongtien" />: </label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" type="text" data-bind="value : fiSoDkpt" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.namsx" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiNamSx" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.nhanhieu" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiTenHieu" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.loaixe" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiLoaixe" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.loaiphuongtien" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <label><input type="checkbox" disabled class="loaiphuongtien" id="xetai"/><spring:message code="mt.61.giayphep.loaiphuongtien.xetai"/></label>
                                    </div>
                                    <div class="col-md-4">
                                        <label><input type="checkbox" disabled class="loaiphuongtien" id="xekhach"/><spring:message code="mt.61.giayphep.loaiphuongtien.xekhach"/></label>
                                    </div>
                                    <div class="col-md-4">
                                        <label><input type="checkbox" disabled class="loaiphuongtien" id="xekhac"/><spring:message code="mt.61.giayphep.loaiphuongtien.xekhac"/></label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.mauson" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiMauSon" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.somay" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiSoMay" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.sokhung" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiSoKhung" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.cuakhau" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiTenCkXn" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.vunghoatdong" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiVung" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.noiden" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiNoiden" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.loaihinhhd" />: </label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control" type="text" data-bind="value : fiLoaihinhhd" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.giahan" />: </label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="text" data-bind="value : fiSoGp" readonly="readonly"/>
                        </div>
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.ghichu" />: </label>
                        </div>
                        <div class="col-md-4">  
                            <input class="form-control" type="text" data-bind="value : fiTenNgKy" readonly="readonly"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2 nsw-text-right">
                            <label><spring:message code="mt.61.giayphep.linkgp" />: </label>
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
            </div>
        </form>
    </div>
</template>