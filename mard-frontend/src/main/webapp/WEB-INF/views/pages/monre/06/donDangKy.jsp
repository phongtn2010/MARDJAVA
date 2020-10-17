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
                <div class="col-md-2">
                    <label><spring:message code="monre.06.danhsach.mahoso" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                    <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso"/>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.06.danhsach.trangthai" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                    <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.ngaytao" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.donvixuly" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaCqCap" name="fiMaCqCap" data-bind="optionsCaption: 'Chọn...', optionsValue : 'fiMa', selectedText : fiTenCqCap, value : fiMaCqCap, options : lstDonViXuLy, optionsText : 'fiTen'"></select>
                    <input type="hidden" id="fiTenCqCap" name="fiTenCqCap" data-bind="value : fiTenCqCap"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiMstDn" name="fiMstDn" readonly="readonly" data-bind="value : fiMstDn" maxlength="13" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.nguoidaidien" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNgDaidien" name="fiNgDaidien" type="text" data-bind="value: fiNgDaidien" maxlength="250"/>
                </div>
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.diachitruso" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDiachiTsc" name="fiDiachiTsc" readonly="readonly" type="text" data-bind="value: fiDiachiTsc" maxlength="250"/>
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
                            <input type="radio" name="optionsRadios" id="optionsRadios_0" value="0" data-bind="click: $parent.onTrucTiepClick.bind($parent)" checked=""> Trực tiếp sử dụng phế liệu nhập khẩu làm nguyên liệu sản xuất
                            <span></span>
                        </label>
                        <label class="mt-radio">
                            <input type="radio" name="optionsRadios" id="optionsRadios_1" value="1" data-bind="click: $parent.onUyThacClick.bind($parent)"> Nhận ủy thác nhập khẩu phế liệu
                            <span></span>
                        </label>
                    </div>
                </div>                
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.thongtingxn.sogxn" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4" style="padding-left: 0px;">
                    <div class="col-md-8">
                        <input class="form-control" id="fiSoGcn" name="fiSoGcn" data-bind="value : fiSoGcn" type="text" maxlength="100"/>
                    </div>
                    <div class="col-md-4">
                        <button href="javascript:void(0);" class="btn blue" id="btnSearchGCN" data-bind="click : bTimGiayXacNhanClick"><i class="fa fa-search" ></i> Tra cứu</button>
                    </div>
                </div>

                <div class="col-md-2">
                    <spring:message code="monre.06.hoso.thongtingxn.ngaycap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapGcn" name="fiNgaycapGcn"  data-bind="datepicker : fiNgaycapGcn" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.thongtingxn.ngayhethan" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiHieulucdenngay" name="fiHieulucdenngay"  data-bind="datepicker : fiHieulucdenngay" type="text" data-date-format="dd/mm/yyyy" readonly/>
                </div>

                <div class="col-md-2">
                    <spring:message code="monre.06.hoso.thongtingxn.coquancap" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiCqCapGcn" readonly="readonly" name="fiCqCapGcn" data-bind="value : fiCqCapGcn" type="text" maxlength="250"/>
                </div>
            </div> 
        </div>         
    </fieldset>
    <fieldset>
        <legend><spring:message code="monre.06.hoso.thongtinlh" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.thongtinlh.nguoilienhe" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNgLienhe" name="fiNgLienhe" data-bind="value : fiNgLienhe" type="text" required maxlength="250"/>
                </div>

                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.thongtinlh.chucvu" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiChvuNgLh" name="fiChvuNgLh" data-bind="value : fiChvuNgLh" type="text" maxlength="50"/>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.thongtinlh.dienthoai" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSdtNgLh" name="fiSdtNgLh" data-bind="value : fiSdtNgLh" type="text" required maxlength="50"/>
                </div>

                <div class="col-md-2">
                    <spring:message code="monre.06.hoso.thongtinlh.fax" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxNgLh" name="fiFaxNgLh" data-bind="value : fiFaxNgLh" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="monre.06.hoso.thongtinlh.email" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailNgLh" name="fiEmailNgLh" data-bind="value : fiEmailNgLh" type="text" maxlength="50"/>
                </div>
            </div>  
        </div> 
    </fieldset>           
    <fieldset>
        <legend><spring:message code="monre.06.hoso.thongtinlohang" /></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>1. <spring:message code="monre.06.hoso.thongtinlohang.tenphelieu" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenPlNk" name="fiTenPlNk" data-bind="value : fiTenPlNk" maxlength="2000"></input>
                    
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>2. <spring:message code="monre.06.hoso.thongtinlohang.xuatxu" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiXuatxuPl" name="fiXuatxuPl" data-bind="value : fiXuatxuPl" maxlength="250"></input>
                </div>
            </div>  
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>3. <spring:message code="monre.06.hoso.thongtinlohang.tochuccanhan" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiTenTcxk" name="fiTenTcxk" data-bind="value : fiTenTcxk" maxlength="500"></input>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>4. <spring:message code="monre.06.hoso.thongtinlohang.tencangxuatkhau" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiCangXk" name="fiCangXk" data-bind="value : fiCangXk" maxlength="250"></input>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>5. <spring:message code="monre.06.hoso.thongtinlohang.tencuakhaunhap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">                                        
                    <input class="form-control" id="fiCuakhauNk" name="fiCuakhauNk" data-bind="value : fiCuakhauNk" maxlength="250"></input>
                </div>
            </div>  
        </div> 

        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label>6. <spring:message code="monre.06.hoso.thongtinlohang.dukienthoigian" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control date-picker" id="fiTgDukien" name="fiTgDukien" data-bind="datepicker : fiTgDukien" type="text" data-date-format="dd/mm/yyyy">
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-12">
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
                            <th class="text-center" style="max-width: 200px;"><spring:message code="monre.06.hoso.thongtinlohang.cuakhaunhap" /></th>
                            <th class="text-center" style="width: 50px;"><spring:message code="monre.06.hoso.thongtinlohang.khoiluongnhap" /></th>
                            <th class="text-center"><spring:message code="monre.06.hoso.thongtinlohang.chucnang" /></th>
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
                            <td class="text-center">
                                <a href="javascript:void(0);"><i class="fa fa-edit" data-bind="click: $parent.bSuaLoHangClick.bind($parent)" src="" alt=""/></a>
                                <a href="javascript:void(0);"><i class="fa fa-trash" data-bind="click: $parent.bXoaLoHangClick.bind($parent)" src="" alt=""/></a>
                            </td>
                        </tr>                      
                        </script>
                        <tfoot>
                            <tr>
                                <td>
                                    
                                </td>
                                <td>
                                    <select id="fiTenphelieu" class="form-control select2" data-bind="value: fiIdpl, 
                                                                        optionsCaption: 'Chọn...', 
                                                                        optionsValue : 'fiIdpl', 
                                                                        optionsText : 'fiTenphelieu', 
                                                                        options : dsLoaiPheLieu,
                                                                        event: {change: fiLhIdLoaiPlChange}"></select>
                                </td>
                                <td data-bind="text: fiMaHs"></td>
                                <td data-bind="text: fiKhoiLuongDuocPhep"></td>
                                <td data-bind="text: fiKhoiLuongConLai"></td>
                                <td>
                                    <input class="form-control" id="fiLhTen" name="fiLhTen" data-bind="value : fiLhTen" maxlength="250"></input>
                                </td>
                                <td>
                                    <input class="form-control date-picker" id="fiLhTgian" name="fiLhTgian" data-bind="datepicker : fiLhTgian" type="text" data-date-format="dd/mm/yyyy">
                                </td>
                                <td>
                                    <select class="form-control select2" id="fiLhMaCuakhau" data-bind="optionsCaption: 'Chọn...', value : fiLhMaCuakhau, optionsValue : 'gateCode', optionsText : 'gateName', options : lstCuaKhau, event: {change: fiLhMaCuakhauChange}" style="width: 150px;"></select>
                                </td>
                                <td>
                                    <input class="form-control" id="fiLhKluong" name="fiLhKluong" data-bind="value : fiLhKluong"></input>
                                </td>
                                <td>
                                    <a href="javascript:void(0);" class="btn grey" data-bind="event: {click: btnThemLoHang}"><i class="fa fa-save"></i>Lưu</a>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                    <span data-bind="text : errorThongTinPheLieuMessage" style="color:red;"> </span>    
                </div>
            </div>
        </fieldset>        
    </form>

     