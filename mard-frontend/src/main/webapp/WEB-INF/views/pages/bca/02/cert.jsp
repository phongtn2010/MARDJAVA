<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<page size="A3" class="a4-padding">
    <b><spring:message code="bca.02.giayphep.chitiet"/></b>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.sogp"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoGp" readonly data-bind="value : fiSoGp" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.tencq"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCoquan" readonly name="fiTenCoquan" data-bind="value : fiTenCoquan" type="text" />
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.nguoiky"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiNguoiky" readonly data-bind="value : fiNguoiky" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.chucdanh"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiChucdanhNguoiky" readonly name="fiChucdanhNguoiky" data-bind="value : fiChucdanhNguoiky" type="text" />
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.diadiemky"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiDiadiemKy" readonly data-bind="value : fiDiadiemKy" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.ngayky"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" id="fiNgayky" readonly name="fiNgayky" data-bind="datepicker : fiNgayky" type="text"
                       disabled placeholder="dd/mm/yyyy"  data-date-format="dd/mm/yyyy"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.capchocq"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiTenDoanhnghiepDk" readonly data-bind="value : fiTenDoanhnghiepDk" type="text"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.theogiaydk"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoDonDk" readonly data-bind="value : fiSoDonDk" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.ngayguidk"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" id="fiNgayDonDk" readonly name="fiNgayDonDk" data-bind="datepicker : fiNgayDonDk" type="text" 
                       disabled placeholder="dd/mm/yyyy"  data-date-format="dd/mm/yyyy"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.uynhiem"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiNguoiDaidien" readonly data-bind="value : fiNguoiDaidien" type="text"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.mangso"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoCmnd" readonly data-bind="value : fiSoCmnd" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.ngaycap"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" id="fiNgaycapCmnd" readonly name="fiNgaycapCmnd" data-bind="datepicker : fiNgaycapCmnd" 
                       type="text" disabled placeholder="dd/mm/yyyy"  data-date-format="dd/mm/yyyy"/>

            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.cqcap"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiNoicapCmnd" readonly data-bind="value : fiNoicapCmnd" type="text"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.lenhxuat"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiLenhxuat" readonly data-bind="value : fiLenhxuat" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.cqcaplenhxuat"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiCqcLenhxuat" readonly name="fiCqcLenhxuat" data-bind="value : fiCqcLenhxuat" type="text" />
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">
            <b><spring:message code="bca.02.giayphep.danhsach"/></b>
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="bca.02.giayphep.danhsach.stt" /></th>
                        <th class="text-center"><spring:message code="bca.02.giayphep.danhsach.loai" /></th>
                        <th class="text-center"><spring:message code="bca.02.giayphep.danhsach.soluong" /></th>
                        <th class="text-center"><spring:message code="bca.02.giayphep.danhsach.dvtinh"/></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHangHoa">
                    <tr>
                        <td data-bind="text : $index() + 1"></td>  
                        <td data-bind="text : fiTenHanghoa"></td>  
                        <td data-bind="text : fiSoluong"></td>  
                        <td data-bind="text : fiTenDvtinh"></td>
                    </tr>
                </tbody>
            </table>            
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.tuyenduongtu"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiTuyenduongTu" readonly data-bind="value : fiTuyenduongTu" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.qua"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTuyenduongQua" readonly name="fiTuyenduongQua" data-bind="value : fiTuyenduongQua" type="text" />
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.den"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiTuyenduongDen" readonly data-bind="value : fiTuyenduongDen" type="text"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.thoihan"/></label>
            </div>
            <div class="col-md-2 nsw-text-right">
                <input class="form-control" name="fiThoihan" readonly data-bind="value : fiThoihan" type="text"/>
            </div>
            <div class="col-md-2 text-left">
                <label><spring:message code="bca.02.giayphep.ngay"/></label>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.tungay"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" name="fiNgayHieuluc" readonly data-bind="datepicker : fiNgayHieuluc" type="text"
                       disabled placeholder="dd/mm/yyyy"  data-date-format="dd/mm/yyyy"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.denngay"/></label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" id="fiNgayHethan" readonly name="fiNgayHethan" data-bind="datepicker : fiNgayHethan" type="text"
                       disabled placeholder="dd/mm/yyyy"  data-date-format="dd/mm/yyyy"/>
            </div>
        </div> 
    </div> 
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label><spring:message code="bca.02.giayphep.giayphep"/></label>
            </div>
            <div class="col-md-8">
                <a target="_blank" data-bind="text: fiTenTeptinGp, attr: { href: downloadUrl}"></a>
            </div>            
        </div> 
    </div>
</page>

