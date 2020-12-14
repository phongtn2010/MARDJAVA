<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fieldset>
    <legend><b><spring:message code="moit.04.hoso.thongtinhanghoa" /></b></legend>
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.mucdichnk" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control" type="text" id="fiMucdichNk" name="fiMucdichNk" data-bind="value : fiMucdichNk" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.soluong" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="number" id="fiSoluong" name="fiSoluong" data-bind="value : fiSoluong" maxlength="250" readonly/>
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.qcdonggoi" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control" type="text" id="fiQuycachDonggoi" name="fiQuycachDonggoi" data-bind="value : fiQuycachDonggoi" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.ctkiemsoat" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiCachthucKiemsoat" name="fiCachthucKiemsoat" data-bind="value : fiCachthucKiemsoat" maxlength="250" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.dvguihang" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control" type="text" id="fiDvGuihang" name="fiDvGuihang" data-bind="value : fiDvGuihang" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.nguoigui" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiNguoigui" name="fiNguoigui" data-bind="value : fiNguoigui" maxlength="250" />
            </div>
        </div>  
    </div>    
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.dtnguoigui" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control" type="text" id="fiSdtNguoigui" name="fiSdtNguoigui" data-bind="value : fiSdtNguoigui" maxlength="250" />
            </div>           
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.dvnhanhang" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control" type="text" id="fiDvNhanhang" name="fiDvNhanhang" data-bind="value : fiDvNhanhang" maxlength="250" />
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.nguoinhan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" type="text" id="fiNguoinhan" name="fiNguoinhan" data-bind="value : fiNguoinhan" maxlength="250" />
            </div>
        </div>  
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="moit.04.hoso.thongtinhanghoa.dtdvnhan" /><a class="nsw-require-field">*</a></label>
            </div>
            <div class="col-md-4">                
                <input class="form-control" type="text" id="fiSdtNguoinhan" name="fiSdtNguoinhan" data-bind="value : fiSdtNguoinhan" maxlength="250" />
            </div>           
        </div>  
    </div> 
    <legend><spring:message code="moit.04.hoso.thongtinhanghoa.bangsluongmhang" /></legend> 
    <div class="form-group">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="moit.04.hoso.thongtinhanghoa.stt" /></th>
                        <th class="text-center"><spring:message code="moit.04.hoso.thongtinhanghoa.mahang" /></th>
                        <th class="text-center"><spring:message code="moit.04.hoso.thongtinhanghoa.soluongbao" /></th>
                        <th class="text-center"><spring:message code="moit.04.hoso.thongtinhanghoa.chucnang" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHanghoas">
                    <tr>
                        <td data-bind="text : fiStt">
                        </td>  
                        <td style="width: 220px">
                            <input class="form-control" name="fiMahang" data-bind="value : fiMahang" maxlength="2000"/>
                        </td>
                        <td>
                            <input class="form-control" name="fiSoluong" type="number" data-bind="value : fiSoluong, event: {change: $parent.countSoluongBao.bind($parent)}" maxlength="7"/>
                        </td>
                        <td class="text-center">
                            <a class="btn red bt-center" data-bind="click: $parent.removeHangHoaOnClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <span data-bind="text : errorHHMessage" style="color:red;"> </span>
            <br/>
            <a class="btn green bt-center" data-bind="click: addHangHoaOnClick"><i class="fa fa-add fa-lg"></i> Thêm Hàng hoá</a>
        </div>
    </div>
</fieldset>