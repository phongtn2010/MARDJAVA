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
            <div class="tabbable-custom ">
                <ul class="nav nav-tabs" data-bind="foreach: lstNhomHangHoa">
                    <li class="tab">
                        <a data-toggle="tab"> <b data-bind="text : fiTenNhh"></b></a>
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
                                        <input disabled class="form-control" id="fiTenNhh" name="fiTenNhh" maxlength="255"  
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
                                        <input disabled class="form-control" id="fiNguoiDaidien" name="fiNguoiDaidien" maxlength="255"  
                                               type="text" data-bind="value : fiNguoiDaidien"/>
                                    </div>
                                </div>  
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.anhdaidien" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control" type="file" data-bind="visible: canUpload, event: {change: doUpload }" accept=".pdf,.jpg,.tif"/>
                                        <a target="_blank" data-bind="text: fiTenAnh, attr: { href: downloadUrl}"></a>
                                    </div>
                                </div> 
                            </div>   
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.cmndhochieu" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control" id="fiHochieu" name="fiHochieu" maxlength="255"  
                                               type="text" data-bind="value : fiHochieu"/>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.ngaycap" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control datepicker" id="fiNgaycapHochieu" name="fiNgaycapHochieu" maxlength="255"  
                                               type="text" data-bind="datepicker : fiNgaycapHochieu" placeholder="dd/mm/yyyy" data-date-format="dd/mm/yyyy"/>
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
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.ten" /></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.mahs" /></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.chungloai" /></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.soluong" /></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.dvtinh" /></th>
                                                <th class="text-center"><spring:message code="bca.01.hoso.thontinnhomhh.dshh.kichthuoc" /></th>
                                            </tr>
                                        </thead>
                                        <tbody data-bind="foreach: lstHanghoa01s">
                                            <tr>
                                                <td data-bind="text : STT"></td>  
                                                <td><input disabled class="form-control"  name="fiTenhanghoa" data-bind="value : fiTenhanghoa" maxlength="250"/></td>
                                                <td><input disabled class="form-control"  name="fiMahs" data-bind="value : fiMahs" maxlength="250"/></td>
                                                <td><input disabled class="form-control"  name="fiChungloai" data-bind="value : fiChungloai" maxlength="250"/></td>
                                                <td><input disabled class="form-control"  name="fiSoluong" data-bind="value : fiSoluong" maxlength="250"/></td>
                                                <td><input disabled class="form-control"  name="fiTenDvt" data-bind="value : fiTenDvt" maxlength="250"/></td>
                                                <td><input disabled class="form-control"  name="fiKichthuoc" data-bind="value : fiKichthuoc" maxlength="250"/></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.lydo" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-10">
                                        <input disabled class="form-control" id="fiLydo" name="fiLydo" maxlength="255"  
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
                                        <select disabled class="form-control select2" id="fiHinhthuc" name="fiHinhthuc" data-bind="optionsCaption: 'Chọn...', optionsValue : 'id', value : fiHinhthuc, options : lstHinhthuc, optionsText : 'name'"></select>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.ptvanchuyen" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control" id="fiPtVanchuyen" name="fiPtVanchuyen" maxlength="255"  
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
                                        <input disabled class="form-control datepicker" id="fiThoigianvaoTungay" name="fiThoigianvaoTungay" maxlength="255"  
                                               type="text" data-bind="datepicker : fiThoigianvaoTungay" placeholder="dd/mm/yyyy" data-date-format="dd/mm/yyyy"/>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tgvaodenngay" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control datepicker" id="fiThoigianvaoDenngay" name="fiThoigianvaoDenngay" maxlength="255"  
                                               type="text" data-bind="datepicker : fiThoigianvaoDenngay" placeholder="dd/mm/yyyy" data-date-format="dd/mm/yyyy"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tgratungay" /></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control datepicker" id="fiThoigianraTungay" name="fiThoigianraTungay" maxlength="255"  
                                               type="date" data-bind="datepicker : fiThoigianraTungay"  data-date-format="dd/mm/yyyy"/>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.tgradenngay" /></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control datepicker" id="fiThoigianraDenngay" name="fiThoigianraDenngay" maxlength="255"  
                                               type="date" data-bind="datepicker : fiThoigianraDenngay"  data-date-format="dd/mm/yyyy"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.cuakhauvao" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control" id="fiCuakhauVao" name="fiCuakhauVao" maxlength="255"  
                                               type="text" data-bind="value : fiCuakhauVao"/>
                                    </div>
                                    <div class="col-md-2 nsw-text-right">
                                        <label><spring:message code="bca.01.hoso.thontinnhomhh.cuakhaura" /><a class="nsw-require-field">*</a></label>
                                    </div>
                                    <div class="col-md-4">
                                        <input disabled class="form-control" id="fiCuakhauRa" name="fiCuakhauRa" maxlength="255"  
                                               type="text" data-bind="value : fiCuakhauRa"/>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>  
            <span data-bind="text : $parent.formVM().errorHHMessage();" style="color:red;"> </span>
        </div>  
    </div>
</fieldset>