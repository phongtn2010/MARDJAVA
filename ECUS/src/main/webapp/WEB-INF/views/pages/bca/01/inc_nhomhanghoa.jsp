<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>  
    <legend><b><spring:message code="bca.01.hoso.thontinnhomhh" /></b></legend>
    <%@include file="inc_css.jsp" %>
   
    
    <div class="form-group">
        <div class="col-md-12">
            <a class="btn green bt-center" style="margin:5px " data-bind="click: addNhomHHClick"><i class="fa fa-add fa-lg"></i> Thêm nhóm hàng hóa</a>
            <div class="tabbable-custom ">
                <ul class="nav nav-tabs" data-bind="foreach: lstNhomHangHoa">
                    <li class="tab">
                        <a data-toggle="tab"> <b data-bind="text : fiTenNhh"></b></a><span class="fa fa-trash red" data-bind="click: $parent.removeNhomHHClick.bind($parent)"></span>
                    </li>
                </ul>

                <div class="tab-content"  data-bind="foreach: lstNhomHangHoa">
                    <div class="tab-pane tab-import">
                        <form role="form" class="form-horizontal">
                            <b><spring:message code="bca.01.hoso.thontinnhomhh.nhomhh"/><a style="margin-left: 5px" data-bind="text: STT"></a> </b>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tennhom" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-10">
                                        <input class="form-control" id="fiTenNhh" name="fiTenNhh" maxlength="255"  
                                               type="text" data-bind="value : fiTenNhh"/>
                                    </div>
                                </div>  
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.nguoidaidien" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiNguoiDaidien" name="fiNguoiDaidien" maxlength="255"  
                                               type="text" data-bind="value : fiNguoiDaidien"/>
                                    </div>
                                </div>  
                            </div>  
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.anhdaidien" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" 
                                               accept=".jpg,.tif"/>
                                        <a target="_blank" data-bind="text: fiTenAnh, attr: { href: downloadUrl}"></a>
                                        <span class="validationMessage" style="display: none;" data-bind="attr: {'id': 'file_lbl_' + STT()}">Thông tin bắt buộc nhập</span>
                                    </div>
                                    <div class="col-md-1">
                                        <div class="col-md-1" id="valid-img">
                                            <a class="fa fa-trash red fa-lg" style="color: red; padding-top: 10px;"data-bind="visible: canDelete, event: {click: deleteImg }"></a>
                                        </div>
                                    </div>
                                </div> 
                            </div>   
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.cmndhochieu" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiHochieu" name="fiHochieu" maxlength="255"  
                                               type="text" data-bind="value : fiHochieu"/>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.ngaycap" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control datepicker" id="fiNgaycapHochieu" name="fiNgaycapHochieu" maxlength="255" readonly style="background-color: #fff !important" 
                                               type="text" data-bind=" datepicker : fiNgaycapHochieu" placeholder="dd/mm/yyyy" data-date-format="dd/mm/yyyy"/>
                                        <span class="validationMessage" style="display: none;" data-bind="attr: {'id': 'fiNgaycapHochieu_lbl_' + STT()}">Thông tin bắt buộc nhập</span>
                                    </div>
                                </div>
                            </div>

                            <b><spring:message code="bca.01.hoso.thontinnhomhh.dshh"/></b>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                                        <thead>
                                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.stt" /></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.ten" /><a class="nsw-require-field">*</a></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.mahs" /></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.chungloai" /><a class="nsw-require-field">*</a></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.soluong" /><a class="nsw-require-field">*</a></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.dvtinh" /><a class="nsw-require-field">*</a></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.kichthuoc" /><a class="nsw-require-field">*</a></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.chucnang" /></th>
                                            </tr>
                                        </thead>
                                        <tbody data-bind="foreach: lstHanghoa01s">
                                            <tr>
                                                <td data-bind="text : $index() +1"></td>  
                                                <td><input class="form-control"  name="fiTenhanghoa" data-bind="value : fiTenhanghoa" maxlength="250"/></td>
                                                <td><input class="form-control"  name="fiMahs" data-bind="value : fiMahs" maxlength="250"/></td>
                                                <td><input class="form-control"  name="fiChungloai" data-bind="value : fiChungloai" maxlength="250"/></td>
                                                <td><input class="form-control"  style="text-align: right;" name="fiSoluong" data-bind="value : fiSoluong" maxlength="250"/></td>
                                                <td><input class="form-control"  name="fiTenDvt" data-bind="value : fiTenDvt" maxlength="250"/></td>
                                                <td><input class="form-control"  name="fiKichthuoc" data-bind="value : fiKichthuoc" maxlength="250"/></td>
                                                <td style="width: 220px" class="text-center">
                                                    <a class="btn red bt-center" data-bind="click: $parent.removeHangHoaOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <a class="btn green bt-center" data-bind="click: $parent.addHanghoaClick.bind($parent)"><i class="fa fa-add fa-lg"></i> Thêm hàng hóa</a>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.lydo" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-10">
                                        <input class="form-control" id="fiLydo" name="fiLydo" maxlength="255"  
                                               type="text" data-bind="value : fiLydo"/>
                                    </div>
                                </div>  
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.hinhthuc" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <select class="form-control select2" id="fiHinhthuc" name="fiHinhthuc" data-bind="optionsCaption: '---Chọn---', optionsValue : 'id', 
                                                        value : fiHinhthuc, options : lstHinhthuc, optionsText : 'name'"></select>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.ptvanchuyen" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiPtVanchuyen" name="fiPtVanchuyen" maxlength="255"  
                                               type="text" data-bind="value : fiPtVanchuyen"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tgvaotungay" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control datepicker" name="fiThoigianvaoTungay" maxlength="255" id="fiThoigianvaoTungay" 
                                               type="text" data-bind="datepicker : fiThoigianvaoTungay,event:{change:validTimeInOut}" placeholder="dd/mm/yyyy" readonly style="background-color: #fff !important" data-date-format="dd/mm/yyyy"/>
                                        <span class="validationMessage" style="display: none;" data-bind="attr: {'id': 'fiThoigianvaoTungay_lbl_' + STT()}">Thông tin bắt buộc nhập</span>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tgvaodenngay" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control datepicker" id="fiThoigianvaoDenngay" name="fiThoigianvaoDenngay" maxlength="255"  
                                               type="text" data-bind="datepicker : fiThoigianvaoDenngay,event:{change:validTimeInOut}" placeholder="dd/mm/yyyy" readonly style="background-color: #fff !important" data-date-format="dd/mm/yyyy"/>
                                        <span class="validationMessage" style="display: none;" data-bind="attr: {'id': 'fiThoigianvaoDenngay_lbl_' + STT()}">Thông tin bắt buộc nhập</span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tgratungay" /></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control datepicker" id="fiThoigianraTungay" name="fiThoigianraTungay" maxlength="255"  
                                               type="text" data-bind="datepicker : fiThoigianraTungay,event:{change:validTimeInOut}" placeholder="dd/mm/yyyy" readonly style="background-color: #fff !important" data-date-format="dd/mm/yyyy"/>
                                        <span class="validationMessage" style="display: none;" data-bind="attr: {'id': 'fiThoigianraTungay_lbl_' + STT()}">Thông tin bắt buộc nhập</span>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tgradenngay" /></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control datepicker" id="fiThoigianraDenngay" name="fiThoigianraDenngay" maxlength="255"  
                                               type="text" data-bind="datepicker : fiThoigianraDenngay,event:{change:validTimeInOut}" placeholder="dd/mm/yyyy" readonly style="background-color: #fff !important" data-date-format="dd/mm/yyyy"/>
                                        <span class="validationMessage" style="display: none;" data-bind="attr: {'id': 'fiThoigianraDenngay_lbl_' + STT()}">Thông tin bắt buộc nhập</span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.cuakhauvao" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiCuakhauVao" name="fiCuakhauVao" maxlength="255"  
                                               type="text" data-bind="value : fiCuakhauVao"/>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.cuakhaura" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input class="form-control" id="fiCuakhauRa" name="fiCuakhauRa" maxlength="255"  
                                               type="text" data-bind="value : fiCuakhauRa"/>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>  
            <span class="validationMessage" id="lbl-nhomHH" style="display: none;">Thông tin bắt buộc nhập</span>
        </div>  
    </div>
</fieldset>