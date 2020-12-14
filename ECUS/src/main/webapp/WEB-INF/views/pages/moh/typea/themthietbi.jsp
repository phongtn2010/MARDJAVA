<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="incLanguage.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light ">
            <div class="portlet-title">
                <div class="caption font-dark">
                    <i class="icon-settings font-dark"></i>
                    <span class="caption-subject bold uppercase"><span class="caption-subject bold uppercase"> <spring:message code="moh.typea.themthietbi.khai_bao_thiet_bi" /></span>
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">                    
                    <div class="row">
                        <div class="col-md-12">
                            <form role="form" class="form-horizontal" id="form-ttb">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2"> 
                                            <label><spring:message code="moh.typea.thietbi.ten" /></label>
                                            <a class="nsw-require-field">*</a>
                                        </div>
                                        <div class="col-md-4">                                        
                                            <input class="form-control" id="fiTentrangtb" name="fiTentrangtb" maxlength="20" require="true" value="" 
                                                   field="moh_typea_tenthietbi"  type="text">
                                        </div>
                                        <div class="col-md-2">  
                                            <label><spring:message code="moh.typea.themthietbi.loai_thiet_bi" /></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input name="fiLoaitb" id="fiLoaiThietBi" require="true" field="fiLoaiThietBi" maxlength="13" 
                                                   class="form-control"  type="text" />
                                        </div>
                                    </div>  
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2"> 
                                            <label><spring:message code="moh.typea.themthietbi.chu_so_huu" /></label>
                                            <a class="nsw-require-field">*</a>
                                        </div>
                                        <div class="col-md-4">                                        
                                           <input class="form-control" id="fiChusohuu" name="fiChusohuu" maxlength="20" require="true" value="" 
                                                   field="moh_typea_chusohuu"  type="text">
                                        </div>
                                        <div class="col-md-2">  
                                            <label><spring:message code="moh.typea.themthietbi.dc_chu_so_huu" /></label>
                                             <a class="nsw-require-field">*</a>
                                        </div>
                                        <div class="col-md-4">
                                            <input name="fiDiachicsh" id="fiDiachicsh" require="true" field="fiDiaChiCsh" maxlength="13" field="moh_typea_dc_chu_so_huu"
                                                   class="form-control" type="text" />
                                        </div>
                                    </div>  
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <div class="col-md-2"> 
                                            <label><spring:message code="moh.typea.themthietbi.qg_chu_so_huu" /></label>
                                            <a class="nsw-require-field">*</a>
                                        </div>
                                        <div class="col-md-4">                                        
                                            <select class="form-control select2" id="fiQuocgiacsh" : String name="fiQuocgiacsh" field="moh_typea_qg_chu_so_huu" required="true">
                                               <option value="-1"><spring:message code="common.chon" /></option>
                                           </select>
                                        </div>
                                        <div class="col-md-2">  
                                            <label><spring:message code="moh.typea.thietbi.tieu_chuan_ap_dung" /></label>
                                             <a class="nsw-require-field">*</a>
                                        </div>
                                        <div class="col-md-4">
                                            <input name="fiTieuchuan" id="fiTieuchuan" require="true" field="moh_typea_thietbi_tieuchuanapdung" 
                                                   maxlength="13" class="form-control" type="text" />
                                        </div>
                                    </div>  
                                </div>        
                                    <br>
                                <fieldset>
                                    <legend><spring:message code="moh.typea.chitiettb" /></legend>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-2">
                                                <label><spring:message code="moh.typea.chitiettb.phu_luc" /></label>
                                            </div>
                                            <div class="col-md-9">
                                                <div class="col-md-6">
                                                    <div class="col-lg-1 col-sm-1"><input id="isAttached" name="isAttached" type="checkbox"></div>
                                                    <div class="col-lg-11 col-sm-11"><input id="addFile" class="btn condition" type="file"></div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="condition"><spring:message code="moh.typea.tepdinhkem.tai_ve" /></label>
                                                    <a><i class="fa fa-lg fa-close condition" style="color:red"></i></a>
                                                </div>
                                            </div>
                                        </div>  
                                    </div> 
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-2">
                                                <label><spring:message code="moh.typea.chitiettb.ten_chi_tiet" /></label>
                                                <a class="nsw-require-field">*</a>
                                            </div>
                                            <div class="col-md-4">
                                                <input class="form-control phuluc" id="fiTen" name="fiTen"  maxlength="50" require="true" field="moh_typea_ten_chi_tiet" >
                                            </div>
                                            <div class="col-md-2">
                                                <label><spring:message code="moh.typea.thietbi.ma_san_pham" /></label>
                                                <a class="nsw-require-field">*</a>
                                            </div>
                                            <div class="col-md-4">
                                                <input class="form-control phuluc" id="fiLoai" name="fiLoai" field="moh_typea_thietbi_ma_san_pham" maxlength="50" type="text" required="true">
                                            </div>
                                        </div>  
                                    </div> 
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-2">
                                                <label><spring:message code="moh.typea.chitiettb.dong_goi" /></label>
                                            </div>
                                            <div class="col-md-4">
                                                <input class="form-control phuluc" id="fiQuycach" name="fiQuycach" field="moh_typea_chitiettb_dong_goi" maxlength="250"  type="text" >
                                            </div>
                                             <div class="col-md-2">
                                                <label><spring:message code="moh.typea.chitiettb.hang_sx" /></label>
                                                <a class="nsw-require-field">*</a>
                                            </div>
                                            <div class="col-md-4">
                                                <input class="form-control phuluc" id="fiHangSx" name="fiHangsx" field="moh_typea_hangsx" maxlength="250"  type="text" required="true">
                                                
                                            </div>   
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12">
                                            <div class="col-md-2">
                                                <label><spring:message code="moh.typea.chitiettb.dia_chi_cssx" /></label>
                                                <a class="nsw-require-field">*</a>
                                            </div>
                                            <div class="col-md-4">                                        
                                                <input name="fiDiachisx" id="fiDiachisx" field="moh_typea_dia_chi_sx" 
                                                       class="form-control form-control-inline phuluc" required type="text" />
                                            </div>

                                            <div class="col-md-2">
                                                <label><spring:message code="moh.typea.chitiettb.nuoc_sx" /></label>
                                                <a class="nsw-require-field">*</a>
                                            </div>
                                            <div class="col-md-4">
                                                <select class="form-control" id="fiQgsx" name="fiQgsx" field="moh_typea_nuoc_sx">
                                                    <option value="-1"><spring:message code="common.chon" /></option>
                                                </select>
                                            </div>
                                        </div>  
                                    </div>
                                    <hr>
                                </fieldset>
                            </form>
                            <fieldset>
                                <legend><spring:message code="moh.typea.cosobaohanh" /></legend>
                                <a> <i style="color:blue" id="addWarranty" class="fa fa-plus-circle fa-2x"></i> </a> Thêm mới cơ sở bảo hành
                                 <br>
                                <br>
                                <form role="form" class="form-horizontal" id="form-bh">
                                    <table class="table table-striped table-bordered table-hover table-checkable order-column" id="sample_1">
                                        <thead>
                                            <tr>
                                                <th> <spring:message code="common.table.col.stt" /></th>
                                                <th> <spring:message code="moh.typea.cosobaohanh" /> </th>
                                                <th> <spring:message code="moh.typea.cosobaohanh.dia_chi" /> </th>
                                                <th> <spring:message code="moh.typea.hoso.dien_thoai" /> </th>
                                                <th> <spring:message code="moh.typea.hoso.di_dong" /> </th>
                                                <th> <spring:message code="moh.typea.cosobaohanh.hanh_dong" /> </th>
                                            </tr>
                                        </thead>
                                        <tbody id="list-container">
                                            <tr>
                                                <td>1</td>
                                                <td>Cty sản xuất thiết bị ACV</td>
                                                <td>Hoàng Mai, Hà Nội</td>
                                                <td>Hoàng Mai, Hà Nội</td>
                                                <td>0953246321</td>
                                                <td>
                                                    <a><i class="fa fa-pencil fa-lg"></i></a>
                                                    &nbsp;&nbsp;
                                                    <a><i class="fa fa-close fa-lg"></i></a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>     
                                </form>
                                <div class="col col-lg-5 "></div>
                                <input type = "submit" value="<spring:message code="moh.typea.button.luu"/>">
                                <button><spring:message code="conmon.button.huy" /></button>
                                <hr>
                            </fieldset>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/app/moh/typea/formtable.js' />" type="text/javascript"></script>                                    
<script src="<c:url value='/app/moh/typea/themthietbi.module.js' />" type="text/javascript"></script>
<script>
     $(document).ready(function () {
        $.fn.select2.defaults.set("theme", "bootstrap");
        var controller = new addEquipController();
        controller.init({
            container: 'list-container',
            form: 'searchForm01',
            pager: 'list-pager'
        });    
    });
</script>