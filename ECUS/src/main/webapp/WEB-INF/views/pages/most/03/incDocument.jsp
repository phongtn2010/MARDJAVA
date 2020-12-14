<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form role="form" class="form-horizontal" id="Most03Form">
    <div class="row-border" data-bind="visible: visibleLyDoSDBS">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.lydosuahoso" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <textarea id="fiLydoDc" name="fiReasonSDBS" data-bind="value: fiReasonSDBS"  maxlength="2000" class="form-control" placeholder="<spring:message code="most.03.dondangky.lydosuahoso" />"
                              height="200px"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.dondangky.loaihoso" /></b>
        <hr/>
    </div>
    <div class="row-border">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.loaihoso2" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <select class="form-control" id="fiLoaiHoso" name="fiLoaiHoso" 
                            data-bind="optionsCaption: '<spring:message code="common.chon" />', value : fiLoaiHoso, optionsText: 'name', optionsValue:'id', options : lstLoaiHoSo"></select>
                </div>                
            </div>
        </div>            
    </div>

    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.dondangky.thongtindoanhnghiep" /></b>
        <hr/>
    </div>
    <div class="row-border">
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.tencoso" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenCoso" name="fiTenCoso" maxlength="101"  
                           type="text" data-bind="value : fiTenCoso" placeholder="<spring:message code="most.03.dondangky.tencoso" />" readonly="true">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMstDn" name="fiMstDn" maxlength="14"  
                           type="text" data-bind="value : fiMstDn" placeholder="<spring:message code="most.03.dondangky.masothue" />" readonly="true">
                </div>
            </div>
        </div>
                
                
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.dienthoai" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSdt" name="fiSdt" maxlength="50"  
                           type="text" data-bind="value : fiSdt" placeholder="<spring:message code="most.03.dondangky.dienthoai" />">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.diachitruso" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDiachiTsc" name="fiDiachiTsc" maxlength="255"  
                           type="text" data-bind="value : fiDiachiTsc" placeholder="<spring:message code="most.03.dondangky.diachitruso" />" readonly="true">
                </div>
            </div>
        </div>
                
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.email" /> <a class="nsw-require-field">*</a> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmail" name="fiEmail" maxlength="50"  
                           type="text" data-bind="value : fiEmail" placeholder="<spring:message code="most.03.dondangky.email" />">
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.vanphonggiaodich" /></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiDiachiVpgg" name="fiDiachiVpgg" maxlength="255"  
                           type="text" data-bind="value : fiDiachiVpgg" placeholder="<spring:message code="most.03.dondangky.vanphonggiaodich" />">
                </div>
            </div>
        </div>
                
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.sodangkykinhdoanh" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSoDkkd" name="fiSoDkkd" maxlength="50"  
                           type="text" data-bind="value : fiSoDkkd" placeholder="<spring:message code="most.03.dondangky.sodangkykinhdoanh" />" readonly="true">
                </div>
               <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.Fax" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiFax" name="fiFax" maxlength="50"  
                           type="text" data-bind="value : fiFax" placeholder="<spring:message code="most.03.dondangky.Fax" />">
                </div>
            </div>
        </div>
                
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.coquancap" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiCqCap" name="fiCqCap" maxlength="255"  
                           type="text" data-bind="value : fiCqCap" placeholder="<spring:message code="most.03.dondangky.coquancap" />" >
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.ngaycap" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input name="fiNgaycap" id="fiNgaycap" placeholder="<spring:message code="most.03.dondangky.ngaycap" />" data-bind="value:fiNgaycap, datepicker : fiNgaycap" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" />
                </div>
            </div>
        </div>
                
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.nguoidaidien" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNguoiDaidien" name="fiNguoiDaidien" maxlength="100"  
                           type="text" data-bind="value : fiNguoiDaidien" placeholder="<spring:message code="most.03.dondangky.nguoidaidien" />" >
                </div>
                <div class="col-md-2">
                    <label><spring:message code="most.03.dondangky.chucvunguoidd" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiChucvuNguoidaidien" name="fiChucvuNguoidaidien" maxlength="50"  
                           type="text" data-bind="value : fiChucvuNguoidaidien" placeholder="<spring:message code="most.03.dondangky.chucvunguoidd" />" >
                </div>
            </div>
        </div>
    </div>
    <div class="row-border">
        <b class="nsw-text-underline"><spring:message code="most.03.tokhai.tokhai" /></b>
        <hr/>
        <a href="javascript:void(0);" id="btnThemMoiToKhai" data-bind="click: bThemMoiToKhai" class="btn blue">
            <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
        </a>
    </div>
    <div class="row-border">
        <table class="table table-striped table-bordered table-hover table-checkable order-column">
            <thead>
                <tr class="nsw-tr tr-nsw1-bgcolor">
                    <th class="text-center w50"><spring:message code="most.03.tokhai.stt" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.sotokhai" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.ngaydangky" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.mahaiquan" /></th>
                    <th class="text-center"><spring:message code="conmon.button.view" /></th>
                    <th class="text-center"><spring:message code="most.03.tokhai.xoa" /></th>
                  
                </tr>
            </thead>
            <tbody data-bind="template: { name: 'dstkTmpl', foreach: toKhaiHQs}">
            </tbody>
            <script id="dstkTmpl" type="text/html">
                <tr>
                    <td data-bind="text : stt"></td>                        
                    <td class="text-center" data-bind="text : fiSoTk"></td>
                    <td class="text-center" data-bind="text : fiNgayDKVN"></td> 
                    <td class="text-center" data-bind="text : fiMaHq"></td>
                    <td style="max-width: 200px;" class="text-center">
                        <a href="javascript:void(0)"><i class="fa fa-search" data-bind="click: $parent.onViewToKhaiClick.bind($parent)" src="" alt=""/></a>
                    </td> 
                    <td style="max-width: 200px;" class="text-center">
                        <a href="javascript:void(0)"><i class="fa fa-remove" data-bind="click: $parent.bXoaToKhai.bind($parent)" src="" alt=""/></a>
                    </td> 
                </tr>                      
                </script>
            </table>
        </div>
        <div class="row-border">
            <b class="nsw-text-underline"><spring:message code="most.03.hanghoa.hanghoa" /></b>
            <hr/>
            <a href="javascript:void(0);" id="btnThemMoiHangHoa" data-bind="click: bThemMoiHangHoa" class="btn blue">
                <i class="fa fa-edit"></i> <spring:message code="common.button.them_moi" />
            </a>
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center w50"><spring:message code="most.03.hanghoa.tt" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.tenphuongtiendo" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.sotokhai" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.mahs" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.hangsanxuat" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.nuocsanxuat" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.kyhieu" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.kieu" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.phamvido" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.capchinhxac" /></th>                        
                        <th class="text-center" style="max-width: 15%"><spring:message code="most.03.hanghoa.dactinhdoluong" /></th>
                        <th class="text-center"><spring:message code="most.03.hanghoa.ghichu" /></th>
                        <th class="text-center"><spring:message code="most.03.tokhai.sua" /></th>
                        <th class="text-center"><spring:message code="most.03.tokhai.xoa" /></th>
                    </tr>
                </thead>
                <tbody data-bind="template: { name: 'hanghoaTmpl', foreach: hangHoas }">
                </tbody>
                <script id="hanghoaTmpl" type="text/html">
                    <tr>
                        <td data-bind="text : stt"></td>                        
                        <td data-bind="text : fiTenHh"></td>
                        <td data-bind="text : fiSotk"></td>
                        <td data-bind="text : fiMaHs"></td>
                        <td data-bind="text : fiTenNsx"></td> 
                        <td class="text-center" data-bind="text : fiTenQg"></td>
                        <td data-bind="text : fiKyhieu"></td>
                        <td data-bind="text : fiKieu"></td>
                        <td data-bind="text : fiPhamvido"></td>
                        <td data-bind="text : fiCapCx"></td>                        
                        <td data-bind="text : fiDactinhKt"></td>
                        <td data-bind="text : fiGhiChu"></td>
                        <td style="max-width: 200px;" class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-edit" data-bind="click: $parent.bSuaHangHoaClick.bind($parent)" src="" alt=""/></a>
                        </td> 
                        <td style="max-width: 200px;" class="text-center">
                            <a href="javascript:void(0)"><i class="fa fa-remove" data-bind="click: $parent.bXoaHangHoaClick.bind($parent)" src="" alt=""/></a>
                        </td> 
                    </tr>                      
                    </script>
                </table>
                <span data-bind="text : errorHanghoaText" style="color:red;"> </span>        
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="most.03.hanghoa.denghimiengiam" /></label>
                            </div>
                            <div class="col-md-10">
                                <textarea id="fiDnMienTnm" name="fiDnMienTnm" data-bind="value: fiDnMienTnm"  
                                          maxlength="500" class="form-control" field="<spring:message code="most.03.hanghoa.denghimiengiam" />" 
                                          placeholder="<spring:message code="most.03.hanghoa.denghimiengiam" />" height="200px"></textarea>
                            </div>
                        </div>
                    </div>
                </div> 
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                <label><spring:message code="most.03.hanghoa.lydo" /></label>
                            </div>
                            <div class="col-md-10">
                                <textarea id="fiLydoDnMien" name="fiLydoDnMien" data-bind="value: fiLydoDnMien"  
                                          maxlength="2000" class="form-control" field="<spring:message code="most.03.hanghoa.lydo" />" 
                                          placeholder="<spring:message code="most.03.hanghoa.lydo" />" height="500px"></textarea>
                            </div>
                        </div> 
                    </div> 
                </div>
            </div>
        </form>
        <template id="hanghoa-template">
            <form role="form" class="form-horizontal hanghoa-form" id="hanghoa-form">
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.sotokhai" /></label>
                    </div>
                    <div class="col-md-9">
                        <input id="fiSotk" name="fiSotk" data-bind="value: fiSotk" maxlength="12" class="form-control" placeholder="<spring:message code="most.03.hanghoa.sotokhai" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.tenphuongtiendo" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-9">                 
                        <select class="form-control" id="fiMaHh" name="fiMaHh" 
                                data-bind="optionsCaption: '<spring:message code="common.chon" />', 
                                    value : fiMaHh, 
                                    options : lstPhuongTienDo, 
                                    optionsText: 'fiTen', 
                                    optionsValue:'fiMa',
                                    event:{change:fiMaHhChange}">
                        </select>
                        <input type="hidden" id="fiIdHh" name="fiIdHh" data-bind="value : fiIdHh"/>
                        <input id="fiTenHhKhac" name="fiTenHhKhac" data-bind="value: fiTenHhKhac, visible: visibleTenHhKhac" maxlength="255" class="form-control" placeholder="<spring:message code="most.03.hanghoa.tenphuongtiendo" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.mahs" /></label>
                    </div>
                    <div class="col-md-9">
                        <input id="fiSotk" name="fiMaHs" data-bind="value: fiMaHs" maxlength="12" class="form-control" placeholder="<spring:message code="most.03.hanghoa.mahs" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.kieu" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-9">
                        <input id="fiKieu" name="fiKieu" data-bind="value: fiKieu" maxlength="50" class="form-control" placeholder="<spring:message code="most.03.hanghoa.kieu" />" type="text" />
                    </div>
                </div>  
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.kyhieu" /></label>
                    </div>
                    <div class="col-md-9">
                        <input id="fiKyhieu" name="fiKyhieu" data-bind="value: fiKyhieu" maxlength="50" class="form-control" placeholder="<spring:message code="most.03.hanghoa.kyhieu" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.hangsanxuat" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-9">
                        <input id="fiTenNsx" name="fiTenNsx" data-bind="value: fiTenNsx" maxlength="255" class="form-control" placeholder="<spring:message code="most.03.hanghoa.hangsanxuat" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.nuocsanxuat" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-9">                 
                        <select class="form-control" id="fiMaQg" name="fiMaQg" 
                                data-bind="optionsCaption: '<spring:message code="common.chon" />', value : fiMaQg, selectedText : fiTenQg, options : lstQuocGia, optionsText: 'namevi', optionsValue:'statecode'"></select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.phamvido" /></label>
                    </div>
                    <div class="col-md-9">
                        <input id="fiPhamvido" name="fiPhamvido" data-bind="value: fiPhamvido" maxlength="255" class="form-control" placeholder="<spring:message code="most.03.hanghoa.phamvido" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.capchinhxac" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-9">
                        <input id="fiCapCx" name="fiCapCx" data-bind="value: fiCapCx" maxlength="50" class="form-control" placeholder="<spring:message code="most.03.hanghoa.capchinhxac" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.dactinhdoluong" /></label>
                    </div>
                    <div class="col-md-9">
                        <textarea id="fiDactinhKt" name="fiDactinhKt" data-bind="value: fiDactinhKt" maxlength="2000" class="form-control" placeholder="<spring:message code="most.03.hanghoa.dactinhdoluong" />" type="text" ></textarea>
                    </div>
                </div>                
                <div class="form-group">
                    <div class="col-md-3">
                        <label><spring:message code="most.03.hanghoa.ghichu" /></label>
                    </div>
                    <div class="col-md-9">
                        <textarea id="fiGhiChu" name="fiGhiChu" data-bind="value: fiGhiChu" maxlength="1000" class="form-control" placeholder="<spring:message code="most.03.hanghoa.ghichu" />" type="text" ></textarea>
                    </div>
                </div>
            </form>
        </template>  
        <template id="tokhai-template">
            <form role="form" class="form-horizontal" id="tokhai-form">
                <p><b class="nsw-text-underline"><spring:message code="most.03.tokhai.form.title" /></b></p>
                <div class="form-group">
                    <div class="col-md-2">
                        <label class="control-label"><spring:message code="most.03.tokhai.form.sotk" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input id="sotk" name="sotk" data-bind="value: sotk" maxlength="12" class="form-control" placeholder="<spring:message code="most.03.tokhai.form.sotk" />" type="text" />
                    </div>            
                    <div class="col-md-2">
                        <label class="control-label"><spring:message code="most.03.tokhai.form.namdangky" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">                
                        <input id="namdk" name="namdk" data-bind="value: namdk" maxlength="6" class="form-control" placeholder="<spring:message code="most.03.tokhai.form.namdangky" />" type="text" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <label class="control-label"><spring:message code="most.03.tokhai.form.mahaiquan" /><a class="nsw-require-field">*</a></label>
                    </div>
                    <div class="col-md-4">
                        <input id="mahq" name="mahq" data-bind="value: mahq, event: {change: onEnterMahq}" maxlength="6" class="form-control" placeholder="<spring:message code="most.03.tokhai.form.mahaiquan" />" type="text" />
                    </div>
                    <div class="col-md-6">
                        <select class="form-control" id="lstHaiQuan" name="lstHaiQuan" 
                                data-bind="optionsCaption: '<spring:message code="common.chon" />', 
                                            value : mahq2, 
                                            options : lstHaiQuan, 
                                            optionsText: 'ten_HQ',  
                                            optionsValue:'ma_HQ',
                                            event: {change: onSelectedHQ}">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12 nsw-text-center">
                        <a href="javascript:void(0);" id="btnToKhaiSearch" data-bind="click: onBtnToKhaiSearchClick" class="btn blue">
                            <i class="fa fa-search"></i> <spring:message code="common.button.tim_kiem" />
                        </a>
                    </div>
                </div>
                <p><b class="nsw-text-underline red"><spring:message code="most.03.tokhai.form.thongtintk" /></b></p>
                <hr />    
                <p><b class="nsw-text-underline"><spring:message code="most.03.tokhai.form.thongtinchung" /></b></p>
                <div class="panel-body"> 
                    <div class="row">
                        <div class="col-md-3">
                            <label><spring:message code="most.03.tokhai.form.sotk" /></label>
                        </div>
                        <div class="col-md-3">
                            <b data-bind="text : fiSoTk"></b>
                        </div>
                        <div class="col-md-3">
                            <label><spring:message code="most.03.tokhai.form.mahaiquan" /></label>
                        </div>
                        <div class="col-md-3">
                            <b data-bind="text : fiMaHq"></b>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <label><spring:message code="most.03.tokhai.form.ngaydk" /></label>
                        </div>
                        <div class="col-md-3">
                            <b data-bind="text : fiNgayDKVN"></b>
                        </div>        
                    </div>
                </div>
                <p><b class="nsw-text-underline"><spring:message code="most.03.tokhai.form.danhsachhanghoa" /></b></p>
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <thead>
                        <tr>
                            <th><b><spring:message code="most.03.tokhai.form.stt" /></b></th>
                            <th class="nsw-text-center"></th>
                            <th><b><spring:message code="most.03.tokhai.form.mahs" /></b></th>
                            <th><b><spring:message code="most.03.tokhai.form.tenhanghoa" /></b></th>
                            <th><b><spring:message code="most.03.tokhai.form.soluong" /></b></th>
                            <th><b><spring:message code="most.03.tokhai.form.donvitinh" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'hanghoaTKSearchTmpl', foreach: lstHanghoa }">
                    </tbody>
                    <script id="hanghoaTKSearchTmpl" type="text/html">
                        <tr>
                            <td data-bind="text : fiStt"></td>                        
                            <td class="text-center"><input type="checkbox" data-bind="checked: isChecked" /></td>
                            <td class="text-center" data-bind="text : fiMaHs"></td> 
                            <td data-bind="text : fiTenHh"></td>
                            <td class="text-center" data-bind="text : fiKlSl"></td>
                            <td class="text-center" data-bind="text : fiTenDv"></td>
                        </tr>                      
                        </script>
                    </table>
                </form>
            </template>
            <template id="tokhai-tmpl">
                <form role="form" class="form-horizontal" id="tokhai-form">
                    <p><b class="nsw-text-underline"><spring:message code="common.tokhai.thongtinchung" /></b></p>
                    <div class="panel-body"> 
                        <div class="row">
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.sotokhai" /></label>
                            </div>
                            <div class="col-md-3">
                                <b data-bind="text: fiSoTk"></b>
                            </div>
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.mahaiquan" /></label>
                            </div>
                            <div class="col-md-3"> 
                                <b data-bind="text: fiMaHq"></b>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.ngaydangky" /></label>
                            </div>
                            <div class="col-md-3">
                                <b data-bind="text: fiNgayDKVN"></b>
                            </div>        
                        </div>
                    </div>
                    <p><b class="nsw-text-underline"><spring:message code="common.tokhai.nnk" /></b></p>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.nnk.tencongty" /></label>
                            </div>
                            <div class="col-md-3">
                                <b data-bind="text: fiTenDvNk"></b>
                            </div>
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.nnk.diachi" /></label>
                            </div>
                            <div class="col-md-3">
                                <b data-bind="text: fiDiachiDvNk"></b>
                            </div>        
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.nnk.dienthoai" /></label>
                            </div>
                            <div class="col-md-3">
                                <b></b>
                            </div>        
                        </div>
                    </div>
                    <p><b class="nsw-text-underline"><spring:message code="common.tokhai.nxk" /></b></p>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.nxk.tencongty" /></label>
                            </div>
                            <div class="col-md-3">
                                <b data-bind="text: fiTenDvXk"></b>
                            </div>

                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.nxk.nuoc" /></label>
                            </div>
                            <div class="col-md-3">
                                <b data-bind="text: fiNuocXk"></b>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <label><spring:message code="common.tokhai.nxk.diachi" /></label>
                            </div>
                            <div class="col-md-3">
                                <b data-bind="text: fiDiachiDvXk"></b>
                            </div>        
                        </div>
                    </div>
                    <p><b class="nsw-text-underline"><spring:message code="common.tokhai.hanghoa" /></b></p>
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <thead>
                            <tr>
                                <th class="text-center"><b><spring:message code="most.03.tokhai.form.mahs" /></b></th>
                                <th><b><spring:message code="most.03.tokhai.form.tenhanghoa" /></b></th>
                                <th class="text-center"><b><spring:message code="most.03.tokhai.form.soluong" /></b></th>
                                <th class="text-center"><b><spring:message code="most.03.tokhai.form.donvitinh" /></th>
                            </tr>
                        </thead>
                        <tbody data-bind="template: { name: 'hanghoaTKSearchTmpl', foreach: toKhaiHQDs }">
                        </tbody>
                        <script id="hanghoaTKSearchTmpl" type="text/html">
                            <tr>
                                <td class="text-center" data-bind="text : fiMaHs"></td> 
                                <td data-bind="text : fiTenHh"></td>
                                <td class="text-center" data-bind="text : fiKlSl"></td>
                                <td class="text-center" data-bind="text : fiTenDv"></td>
                            </tr>                      
                            </script>
                        </table>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-4">
                                    <label><spring:message code="common.tokhai.soluong" /></label>
                                </div>
                                <div class="col-md-8">
                                    <b data-bind="text: fiSoluong"></b>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <label><spring:message code="common.tokhai.tongtrongluong" /></label>
                                </div>
                                <div class="col-md-8">
                                    <b data-bind="text: fiTong"></b>
                                </div>
                            </div>
                        </div>
                        <p><b class="nsw-text-underline"><spring:message code="common.tokhai.vdhd" /></b></p>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-4">
                                    <label><spring:message code="common.tokhai.vdhd.sohoadon" /></label>
                                </div>
                                <div class="col-md-8">
                                    <b data-bind="text: fiSoHoadon"></b>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <label><spring:message code="common.tokhai.vdhd.ngaycaphoadon" /></label>
                                </div>
                                <div class="col-md-8">
                                    <b data-bind="text: fiNgayCapHoaDon"></b>
                                </div>
                            </div>    
                        </div>
                    </form>
                </template>