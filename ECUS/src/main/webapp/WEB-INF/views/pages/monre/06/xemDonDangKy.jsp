<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
    .validationMessage{
        color:red;
    }
</style>
<form role="form" class="form-horizontal" id="monre06Form">
    <fieldset>
        <legend><spring:message code="monre.06.hoso.thongtinchung" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.danhsach.mahoso" /></label>
                </div>
                <div class="col-md-4" data-bind="text : fiMaHoso">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                    <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso" readonly=""/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.danhsach.trangthai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTt" name="fiTenTt" readonly="" data-bind="value : fiTenTt" type="text" readonly/>
                    <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.ngaytao" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" disabled id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">  
                    <select class="form-control" id="fiMaCqCap" name="fiMaCqCap" disabled data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMa', selectedText : fiTenCqCap, value : fiMaCqCap, options : lstDonViXuLy, optionsText : 'fiTen'"></select>
                    <input type="hidden" id="fiTenCqCap" name="fiTenCqCap" data-bind="value : fiTenCqCap"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDiachiTsc" name="fiDiachiTsc" readonly="readonly" type="text" data-bind="value: fiDiachiTsc" maxlength="250"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.dienthoai" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDtDn" name="fiDtDn" readonly="readonly" placeholder="" data-bind="value: fiDtDn" type="text" maxlength="13"/>
                </div>
            </div>  
        </div>  
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.nguoidaidien" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNgDaidien" name="fiNgDaidien" readonly="readonly" type="text" data-bind="value: fiNgDaidien" maxlength="250"/>
                </div>
            </div>  
        </div>        
    </fieldset>
    <fieldset>
        <legend><spring:message code="monre.06.hoso.thongtingxn" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-12">
                    <div class="mt-radio-inline">
                        <label class="mt-radio">
                            <input type="radio" disabled name="optionsRadios" readonly="readonly" id="optionsRadios_0" value="0" checked=""> Trực tiếp sử dụng phế liệu nhập khẩu làm nguyên liệu sản xuất
                            <span></span>
                        </label>
                        <label class="mt-radio">
                            <input type="radio" disabled name="optionsRadios" readonly="readonly" id="optionsRadios_1" value="1"> Nhận ủy thác nhập khẩu phế liệu
                            <span></span>
                        </label>
                    </div>
                </div>                
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.thongtingxn.sogxn" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <div class="col-md-8">
                        <input class="form-control" id="fiSoGcn" name="fiSoGcn" readonly="readonly" data-bind="value : fiSoGcn" type="text" required maxlength="100"/>
                    </div>
                    <div class="col-md-4">
                        <button href="javascript:void(0);" class="btn blue" disabled="" id="btnSearchGCN" data-bind="click : bTimGiayXacNhanClick"><i class="fa fa-search" ></i> Tra cứu</button>
                    </div>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <spring:message code="monre.06.hoso.thongtingxn.ngaycap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" disabled id="fiNgaycapGcn" readonly="readonly" name="fiNgaycapGcn"  data-bind="datepicker : fiNgaycapGcn" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.thongtingxn.ngayhethan" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" disabled id="fiHieulucdenngay" name="fiHieulucdenngay"  data-bind="datepicker : fiHieulucdenngay" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <spring:message code="monre.06.hoso.thongtingxn.coquancap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiCqCapGcn" readonly="readonly" name="fiCqCapGcn" data-bind="value : fiCqCapGcn" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>         
    </fieldset>
    <fieldset>
        <legend><spring:message code="monre.06.hoso.thongtinlh" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.thongtinlh.nguoilienhe" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNgLienhe" name="fiNgLienhe" readonly="readonly" data-bind="value : fiNgLienhe" type="text" required maxlength="250"/>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.thongtinlh.chucvu" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiChvuNgLh" readonly="readonly" name="fiChvuNgLh" data-bind="value : fiChvuNgLh" type="text" maxlength="50"/>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.thongtinlh.dienthoai" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSdtNgLh" name="fiSdtNgLh" readonly="readonly" data-bind="value : fiSdtNgLh" type="text" required maxlength="50"/>
                </div>

                <div class="col-md-2 nsw-text-right">
                    <spring:message code="monre.06.hoso.thongtinlh.fax" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxNgLh" readonly="readonly" name="fiFaxNgLh" data-bind="value : fiFaxNgLh" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message code="monre.06.hoso.thongtinlh.email" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailNgLh" name="fiEmailNgLh" readonly="readonly" data-bind="value : fiEmailNgLh" type="text" maxlength="50"/>
                </div>
            </div>  
        </div> 
    </fieldset>           
    <fieldset>
        <legend><spring:message code="monre.06.hoso.thongtinlohang" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>1. <spring:message code="monre.06.hoso.thongtinlohang.tenphelieu" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenPlNk" name="fiTenPlNk" readonly="readonly" data-bind="value : fiTenPlNk" maxlength="2000"></input>
                    
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>2. <spring:message code="monre.06.hoso.thongtinlohang.xuatxu" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiXuatxuPl" name="fiXuatxuPl" readonly="readonly" data-bind="value : fiXuatxuPl" maxlength="250"></input>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>3. <spring:message code="monre.06.hoso.thongtinlohang.tochuccanhan" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenTcxk" name="fiTenTcxk" readonly="readonly" data-bind="value : fiTenTcxk" maxlength="500"></input>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>4. <spring:message code="monre.06.hoso.thongtinlohang.tencangxuatkhau" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiCangXk" name="fiCangXk" readonly="readonly" data-bind="value : fiCangXk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>5. <spring:message code="monre.06.hoso.thongtinlohang.tencuakhaunhap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiCuakhauNk" name="fiCuakhauNk" readonly="readonly" data-bind="value : fiCuakhauNk" maxlength="250"></input>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label>6. <spring:message code="monre.06.hoso.thongtinlohang.dukienthoigian" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control date-picker" id="fiTgDukien" readonly="readonly" name="fiTgDukien" data-bind="datepicker : fiTgDukien" type="text" data-date-format="dd/mm/yyyy">
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-12 nsw-text-right">
                    <label>7. <spring:message code="monre.06.hoso.thongtinlohang.chitiet" /> </label>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.tt" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.tenphelieu" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.mahs" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.kldn" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.klconlai" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.tenlohang" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.thoidiemnk" /></th>
                            <th class="text-center" style="max-width: 100px;"><spring:message code="monre.06.hoso.thongtinlohang.cuakhaunhap" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.khoiluongnhap" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'tbdphelieuTmpl', foreach: lstLoHang }">
                    </tbody>
                    <script id="tbdphelieuTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : fiStt">
                            </td>  
                            <td data-bind="text : fiTenloaiPl">
                            </td> 
                            <td data-bind="text : fiMaHs">
                            </td>
                            <td data-bind="text : fiKhoiLuongDuocPhep">
                            </td>
                            <td data-bind="text : fiKhoiLuongConLai">
                            </td>
                            <td data-bind="text : fiLhTen">
                            </td>
                            <td data-bind="date : fiLhTgian">
                            </td>
                            <td data-bind="text : fiLhTenCuakhau">
                            </td>
                            <td data-bind="text : fiLhKluong">
                            </td>
                        </tr>                      
                        </script>
                    </table>
                </div>
            </div>
        </fieldset>        
    </form>

     