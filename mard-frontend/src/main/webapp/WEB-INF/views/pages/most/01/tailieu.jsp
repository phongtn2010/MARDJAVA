<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.hopdong" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="hopdong-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"> <spring:message code="common.table.col.stt" /></th>
                        <th class="w150"> <spring:message code="most.01.hopdong.sohopdong" /></th>
                        <th class="w150 nsw-text-center"> <spring:message code="most.01.hopdong.ngayhopdong" /> </th>
                        <th> <spring:message code="most.01.hopdong.file" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.hopdong.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="hopdong-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="hopdong-tmpl">
                        <td> </td>
                        <td class="w150"> 
                            <input class="form-control" name="fiSoVb" id="txtSohopdong" field="most_01_hopdong_sohopdong" maxlength="50" placeholder="<spring:message code="most.01.hopdong.sohopdong" />" type="text">
                        </td>
                        <td class="w150">
                            <input name="fiNgayCap" id="txtNgayHopDong" style="width: 200px" require="true" field="most_01_hopdong_ngayhopdong" class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />                                                            
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="hopdong-ip" type="file" > </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.hopdong.command.luu" />" 
                                  data-container="body" id="btnFileHopDongThemMoi"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</div>

<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.vandon" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="vandon-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"> <spring:message code="common.table.col.stt" /></th>
                        <th class="w150"> <spring:message code="most.01.vandon.sovandon" /></th>
                        <th class="w100 nsw-text-center"> <spring:message code="most.01.vandon.ngay" /> </th>
                        <th> <spring:message code="most.01.vandon.file" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.vandon.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="vandon-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="vandon-tmpl">
                        <td> </td>
                        <td class="w150"> 
                            <input name="fiSoVb" id="txtSoVanDon" field="most_01_vandon_sovandon" 
                                   class="form-control" placeholder="<spring:message code="most.01.vandon.sovandon" />" maxlength="50" type="text">
                        </td>
                        <td class="w150">
                            <input style="width: 200px" name="fiNgayCap" id="txtNgayVanDon" require="true" field="most_01_vandon_ngay" 
                                   class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="vandon-ip" type="file"> </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-lg fa-2x fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.vandon.command.luu" />" 
                                  data-container="body" id="btnFileVanDonThemMoi"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</div>  

<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.hoadon" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="hoadon-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"> <spring:message code="common.table.col.stt" /></th>
                        <th class="w150"> <spring:message code="most.01.hoadon.sohoadon" /></th>
                        <th class="w150 nsw-text-center"> <spring:message code="most.01.hoadon.ngay" /> </th>
                        <th> <spring:message code="most.01.hoadon.file" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.hoadon.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="hoadon-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="hoadon-tmpl">
                        <td></td>
                        <td class="w150"> 
                            <input name="fiSoVb" id="txtSoHoaDon" field="most_01_hoadon_sohoadon" 
                                   class="form-control" placeholder="<spring:message code="most.01.hoadon.sohoadon" />" maxlength="50" type="text" />
                        </td>
                        <td class="w150">
                            <input style="width: 200px" name="fiNgayCap" id="txtNgayHoaDon" require="true" field="most_01_hoadon_ngay" 
                                   class="form-control form-control-inline date-picker" 
                                   data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="hoadon-ip" type="file"> </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.hoadon.command.luu" />" 
                                  data-container="body" id="btnFileHoaDonThemMoi"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</div>

<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.dmhanghoa" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="dmhanghoa-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"><spring:message code="common.table.col.stt" /></th>
                        <th class="w150"><spring:message code="most.01.dmhanghoa.tendanhmuc" /></th>
                        <th class="w150 nsw-text-center"><spring:message code="most.01.dmhanghoa.ngay" /> </th>
                        <th> <spring:message code="most.01.dmhanghoa.file" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.dmhanghoa.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="dmhanghoa-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr class="odd gradeX" id="dmhanghoa-tmpl">
                        <td></td>
                        <td class="w150"> 
                            <input name="fiSoVb" id="txtTenDM" field="most_01_dmhanghoa_tendanhmuc" class="form-control" placeholder="<spring:message code="most.01.dmhanghoa.tendanhmuc" />" maxlength="50" type="text">
                        </td>
                        <td class="w150">
                            <input style="width: 200px" name="fiNgayCap" id="txtNgayDM" require="true" field="most_01_dmhanghoa_ngay" 
                                   class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" />
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="dmhanghoa-ip" type="file"> </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.dmhanghoa.command.luu" />" 
                                  data-container="body" id="btnFileDMHangHoaThemMoi"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</div>
<div class="row-border">
    <div class="row-border">
        <p><b class="nsw-text-underline"><spring:message code="most.01.gcn" /></b></p>
    </div>
    <div class="row-border">
        <form role="form" class="form-horizontal" id="gcn-file-form">
            <table class="table table-striped table-bordered table-hover order-column">
                <thead>
                    <tr>
                        <th class="w70 nsw-text-center"> <spring:message code="common.table.col.stt" /></th>
                        <th class="w150"> <spring:message code="most.01.gcn.loaigcn" /></th>
                        <th class="w150"> <spring:message code="most.01.gcn.sogcn" /></th>
                        <th class="w150 nsw-text-center"> <spring:message code="most.01.gcn.ngay" /> </th>
                        <th class="w150"> <spring:message code="most.01.gcn.donvicap" /> </th>
                        <th class="w250"> <spring:message code="most.01.gcn.hanghoa" /> </th>
                        <th> <spring:message code="most.01.gcn.file" /> </th>
                        <th class="w100" style="display: ${IsView}"> <spring:message code="most.01.gcn.chucnang" /> </th>                           
                    </tr>
                </thead>
                <tbody id="gcn-container">

                </tbody>
                <tfoot style="display: ${IsView}">
                    <tr id="gcn-tmpl">
                        <td></td>
                        <td>
                            <select id="fiMaLoaiTaiLieuGCN" name="fiMaLoai" class="form-control select2" require="true" field="most_01_gcn_loaigcn">
                                <option value="-1"><spring:message code="common.chon" /></option>
                                <c:forEach items="${giaychungnhan.data}" var="item">
                                    <option value="${item.fiMa}">${item.fiTen}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="fiTenLoai" id="fiTenLoai" value=""/>
                        </td>
                        <td class="w150"> 
                            <input name="fiSoVb" id="txtSoGCN" maxlength="50" field="most_01_gcn_sogcn" value="" class="form-control" placeholder="<spring:message code="most.01.gcn.sogcn" />" type="text">
                        </td>
                        <td class="w150">
                            <input name="fiNgayCap" id="txtNgayGCN" require="true" field="most_01_gcn_ngay" value="" 
                                   class="form-control form-control-inline date-picker" data-date-format="dd/mm/yyyy" size="16" type="text" value="" /></a>
                        </td>
                        <td class="w250"> 
                            <input name="fiDvCap" id="txtDonViCapGCN" maxlength="255" require="true" field="most_01_gcn_donvicap" value="" class="form-control" placeholder="<spring:message code="most.01.gcn.donvicap" />" type="text">
                        </td>
                        <td class="w150"> 
                            <a href="javascript:;" id="btnAddHangHoa" class="btn icon-btn blue custom-icon-btn" data="0">                                
                                <div> <spring:message code="most.01.gcn.chon" /> </div>
                                <span class="badge badge-success" id="badge-0">0</span>
                            </a>
                        </td>
                        <td>
                            <div class="fileinput fileinput-new" data-provides="fileinput">
                                <span class="btn grey btn-file">
                                    <span class="fileinput-new"> <spring:message code="file.chon_file" /> </span>
                                    <span class="fileinput-exists"> <spring:message code="file.chon_file" /> </span>
                                    <input value="" type="hidden"><input id="gcn-ip"type="file" > </span>
                                <span class="fileinput-filename"></span> &nbsp;
                                <a href="javascript:;" class="close fileinput-exists" data-dismiss="fileinput"> </a>
                            </div>
                        </td>
                        <td class="nsw-text-center">
                            <a><i class="fa fa-2x fa-lg fa-plus-circle tooltips" data-placement="top" 
                                  data-original-title="<spring:message code="most.01.gcn.command.luu" />" 
                                  data-container="body" id="btnThemMoiGCN"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</div>