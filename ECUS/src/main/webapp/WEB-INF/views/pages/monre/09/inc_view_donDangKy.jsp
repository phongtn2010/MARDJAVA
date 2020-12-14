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
<form role="form" class="form-horizontal" id="monre09Form">
    <fieldset>
        <legend><spring:message code="monre.09.hoso.thongtinchung" /></legend>


        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label>Mã Hồ Sơ</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                    <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso"/>
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label>Trạng Thái Hồ sơ</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiTenTt" name="fiTenTt" data-bind="value : fiTenTt" type="text" readonly/>
                    <input class="form-control" id="fiTrangthai" name="fiTrangthai" data-bind="value : fiTrangthai" type="text" readonly style="display:none;"/>
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label>Ngày Tạo</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" disabled="disabled"/>
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label>Đơn vị xử lý<a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" disabled id="fiMaCoQuan" name="fiMa" data-bind="optionsCaption: 'Chọn...'
                    , optionsValue : 'id'
                    , selectedText : fiTenCoQuan
                    , value : fiMaCoQuan
                    , options : lstDonViXuLy
                    , optionsText : 'name'"></select>
                    <!--<input type="hidden" id="fiTenCoQuan" name="fiTenCoQuan" data-bind="value : fiTenCoQuan"/>-->
                </div>
            </div>  
        </div>


        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.tendoanhnghiep" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTenDn" name="fiTenDn" readonly="readonly" data-bind="value : fiTenDn" maxlength="250" />
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.masothue" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" id="fiMaSoThue" name="fiMaSoThue" readonly="readonly" data-bind="value : fiMaSoThue" maxlength="13" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.diachitruso" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" id="fiTruSoChinh" name="fiTruSoChinh" readonly="readonly" data-bind="value : fiTruSoChinh" maxlength="250" />
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.nguoidaidien" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <input class="form-control" type="text" disabled id="fiNguoiDaiDien" name="fiNguoiDaiDien"  data-bind="value : fiNguoiDaiDien" maxlength="13" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.dienthoai" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSdtDn" name="fiSdtDn" data-bind="value : fiSdtDn" type="text" maxlength="50" readonly="readonly"/>
                </div>

                <div class="col-md-2" style="text-align: right">
                    <spring:message code="monre.09.hoso.fax" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline"  disabled id="fiFaxDn" name="fiFaxDn" data-bind="value : fiFaxDn" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.email" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailDn" name="fiEmailDn" data-bind="value : fiEmailDn" type="text" maxlength="50" disabled/>
                </div>

                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.sodkkd" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" disabled id="fiSoGcnDkkd" name="fiSoGcnDkkd" data-bind="value : fiSoGcnDkkd" type="text" maxlength="250" />
                </div>
            </div>  
        </div>         
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.ngaycap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" disabled id="fiNgaycapGcnDkkd" name="fiNgaycapGcnDkkd" data-bind="datepicker : fiNgaycapGcnDkkd" type="text" data-date-format="dd/mm/yyyy" />
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.noicap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoicapGcnDkkd" disabled name="fiNoicapGcnDkkd" data-bind="value : fiNoicapGcnDkkd" type="text" maxlength="250"/>
                </div>
            </div>  
        </div>        
    </fieldset>
    <fieldset>
        <legend><spring:message code="monre.09.hoso.mucdichduarann" /></legend>
       <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-6" style="text-align: right">
                    <label><input name="fiMucDich" type="radio" value="1" data-bind="checked: fiMucDich" disabled /><spring:message code="monre.09.hoso.mucdichduarann.nghiencuu" /></label>
                </div>
                <div class="col-md-6" style="text-align: left">
                    <label><input name="fiMucDich" type="radio" value="2" data-bind="checked: fiMucDich" disabled /><spring:message code="monre.09.hoso.mucdichduarann.hoctap" /></label>
                </div>
            </div>  
        </div>       
    </fieldset> 

    <fieldset>
        <legend><spring:message code="monre.09.hoso.thongtinng" /></legend>

        <!-- table nguon gen -->

        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <div style="margin-bottom: 10px;"> <label><b><spring:message code="monre.09.hoso.thongtinng.tenttGen" /></b></label>
                    </div>

                    <thead>
                        <tr class="nsw-tr tr-nsw1-bgcolor">
                            <th class="text-center" style="width: 50px;"><spring:message code="monre.09.hoso.thongtinng.tt" /></th>
                            <th class="text-center"><spring:message code="monre.09.hoso.thongtinng.tenThongThuong" /></th>
                            <th class="text-center"><spring:message code="monre.09.hoso.thongtinng.tenKhoaHoc" /></th>
                            <th class="text-center"><spring:message code="monre.09.hoso.thongtinng.tenKhac" /></th>
                            <th class="text-center" style="width: 150px;"><spring:message code="monre.09.hoso.thongtinng.chucnang" /></th>
                        </tr>
                    </thead>
                    <tbody data-bind="template: { name: 'cssxTmplNguonGen', foreach: lstNguongen9 }">
                    </tbody>
                    <script id="cssxTmplNguonGen" type="text/html">
                        <tr>
                            <td data-bind="text : $index() +1">
                            </td>
                            <td data-bind="text : fiTenThongThuong">
                            </td>
                            <td data-bind="text : fiTenKhoaHoc">
                            </td>
                            <td data-bind="text : fiTenKhac">
                            </td>
                            <td class="text-center">
                                <a class="btn green bt-center" data-bind="click: $parent.OpenNguonGenClick.bind($parent)"><i class="fa fa-edit"></i> Xem</a>
                            </td>
                        </tr>                      
                        </script>
                    </table>
                    
                </div>
                <div class="col-md-12">
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <div style="margin-bottom: 10px;"><label><b><spring:message code="monre.09.hoso.thongtinng.mauNguonGen" /></b></label>

                        </div>

                        <thead>
                            <tr class="nsw-tr tr-nsw1-bgcolor">
                                <th class="text-center" style="width: 50px;"><spring:message code="monre.09.hoso.thongtinng.tt" /></th>
                                <th class="text-center"><spring:message code="monre.09.hoso.thongtinng.tenNguonGen" /></th>
                                <th class="text-center">Tên mẫu (Samples of genetic resources)</th>
                                <th class="text-center">Số lượng (Quantity)</th>
                                <th class="text-center"><spring:message code="monre.09.hoso.thongtinng.diaDiem" /></th>
                                <th class="text-center" style="width: 150px;"><spring:message code="monre.09.hoso.thongtinng.chucnang" /></th>
                            </tr>
                        </thead>
                        <tbody data-bind="template: { name: 'cssxTmplMauGen', foreach: lstMaugen9 }">
                        </tbody>
                        <script id="cssxTmplMauGen" type="text/html">
                            <tr>
                                <td data-bind="text : stt">
                                </td>
                                <td data-bind="text : fiTenNguonGen">
                                </td>
                                <td data-bind="text : fiTenMau">
                                </td>
                                <td data-bind="text : fiSoLuong">
                                </td>
                                <td data-bind="text : fiDiaDiem">
                                </td>
                                <td class="text-center">
                                    <a class="btn green bt-center" data-bind="click: $parent.OpenMauGenClick.bind($parent)"><i class="fa fa-edit"></i> xem</a>
                                </td>
                            </tr>                      
                            </script>
                        </table>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2">
                                    <label style="text-align: right">Thời gian thu thập (Duration start time)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control date-picker" disabled id="fiThoiGianBatDau" name="fiThoiGianBatDau" data-bind="datepicker : fiThoiGianBatDau" type="text" data-date-format="dd/mm/yyyy" />
                                </div>
                                <div class="col-md-2">
                                    <label style="text-align: right">Thời gian kết thúc (Duration end time)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control date-picker" disabled id="fiThoiGianKetThuc" name="fiThoiGianKetThuc" data-bind="datepicker : fiThoiGianKetThuc" type="text" data-date-format="dd/mm/yyyy"/>
                                </div>
                            </div>  
                        </div> 
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2">
                                    <label style="text-align: right">Cách thức thu thập (Describe how it was collected)</label>
                                </div>
                                <div class="col-md-10">
                                    <textarea class="form-control" disabled rows="3" id="fiCachThucThuThap"  data-bind="value : fiCachThucThuThap" type="text"></textarea>
                                </div>
                            </div>  
                        </div> 
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend><spring:message code="monre.09.hoso.thongtinbencc" /></legend>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Tên tổ chức (Full name of the organization)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiTenToChuc" name="fiTenToChuc" data-bind="value : fiTenToChuc" type="text" />
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Người đại diện (Name of the representative of the organization)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiNguoiDaiDienCc" name="fiNguoiDaiDienCc" data-bind="value : fiNguoiDaiDienCc" type="text"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Địa chỉ liên hệ (Address)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiDiaChiCc" name="fiDiaChiCc" data-bind="value : fiDiaChiCc" type="text"/>
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Chức vụ (Position)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiChucVuCc" name="fiChucVuCc" data-bind="value : fiChucVuCc" type="text"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Điện thoại (Phone)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiSdtCc" name="fiSdtCc" data-bind="value : fiSdtCc" type="text"/>
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Fax(Fax)</label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiFaxCc" name="fiFaxCc" data-bind="value : fiFaxCc" type="text"/>
                        </div>
                    </div>  
                </div>       
            </fieldset>
            <fieldset>
                <legend>Phần V: THÔNG TIN VỀ VIỆC SỬ DỤNG NGUỒN GEN Ở NƯỚC NGOÀI (INFORMATION ON THE UTILIZATION OF GENETIC RESOURCES ABROAD)</legend>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Sử dụng nguồn gen ở nước ngoài (Information on the utilization of genetic resources abroad)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <textarea class="form-control" disabled rows="3" id="fiSuDungNguonGen" data-bind="value : fiSuDungNguonGen" type="text"></textarea>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Số lượng/Khối lượng nguồn gen đăng ký đưa ra khỏi lãnh thổ nước Cộng hòa xã hội chủ nghĩa Việt Nam (Amount/ quantity collected)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <textarea class="form-control" disabled rows="3" id="fiSoLuong" data-bind="value : fiSoLuong"></textarea>
                        </div>
                    </div>  
                </div>
            </fieldset>

                <!-- popup them thong tin -->
                <template id="thongTinGenDK-template">
                    <div class="row" id="thongTinGenpop">
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2" style="text-align: right">
                                    <label>Tên thông thường (Common name)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled id="fiTenThongThuong" name="fiTenThongThuong" data-bind="value : fiTenThongThuong" type="text"/>
                                </div>
                                <div class="col-md-2" style="text-align: right">
                                    <label>Tên khoa học (Scientific name)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control" disabled id="fiTenKhoaHoc" name="fiTenKhoaHoc" data-bind="value : fiTenKhoaHoc" type="text"/>
                                </div>
                            </div>  
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2" style="text-align: right">
                                    <label>Tên khác (Other name)</label>
                                </div>
                                <div class="col-md-10">
                                    <input class="form-control" disabled id="fiTenKhac" name="fiTenKhac" data-bind="value : fiTenKhac" type="text"/>
                                </div>
                            </div>  
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2" style="text-align: right">
                                    <label>Thông tin dự kiến sử dụng tri thức truyền thống về nguồn gen (Traditional knowledge on genetic resources )</label>
                                </div>
                                <div class="col-md-10">
                                    <textarea class="form-control" disabled rows="3" id="fiThongTinNguonGen" data-bind="value : fiThongTinNguonGen" type="text"></textarea>
                                </div>
                            </div>  
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2" style="text-align: right">
                                    <label>Mô tả nguồn gen (Describe)</label>
                                </div>
                                <div class="col-md-10">
                                    <textarea class="form-control" disabled rows="3" id="fiMoTaNguonGen" data-bind="value : fiMoTaNguonGen" type="text"></textarea>
                                </div>
                            </div>  
                        </div>
                    </div> 
                </template>

                <template id="mauNguonGen-template">
                    <div class="row" id="mauNguonGen-vm">
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-3" style="text-align: right">
                                    <label>Tên nguồn gen (Name of genetic resources)</label>
                                </div>
                                <div class="col-md-9" >
                                    <!--TamDT-->
                                     <select class="form-control select2" disabled id="fiTenNguonGen" name="fiTenNguonGen" data-bind="optionsCaption: 'Chọn...'
                                    , optionsValue : 'id'
                                    , selectedText : fiTenNguonGen
                                    , value : fiIdNguonGen
                                    , options : slcNguonGen
                                    , optionsText : 'name'"></select>
                                    <!--<input type="hidden" id="fiIdNguonGen" name="fiIdNguonGen" data-bind="value : fiIdNguonGen"/>-->
                                </div>
                            </div>  
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-3" style="text-align: right">
                                    <label>Tên mẫu (Sample of genetic resources)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-3">
                                    <input class="form-control" disabled id="fiTenMau" name="fiTenMau" data-bind="value : fiTenMau" type="text"/>
                                </div>
                                <div class="col-md-3" style="text-align: right">
                                    <label>Tên khoa học<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-3">
                                    <input class="form-control" disabled id="fiTenMauKhoaHoc" name="fiTenMauKhoaHoc" data-bind="value : fiTenMauKhoaHoc" type="text"/>
                                </div>
                            </div>  
                        </div>
                        
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-3" style="text-align: right">
                                    <label>Số lượng/Khối lượng nguồn gen đăng ký đưa ra khỏi lãnh thổ nước Cộng Hòa Xã Hội Chủ Nghia Việt Nam (Amount/ quantity collected)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-3">
                                    <input class="form-control" disabled id="fiSoLuong" name="fiSoLuong" data-bind="value : fiSoLuong" type="text"/>
                                </div>
                                <div class="col-md-3" style="text-align: right">
                                    <label>Đơn vị(Unit)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-3">
                                    <input class="form-control" disabled id="fiDonViTinh" name="fiDonViTinh" data-bind="value : fiDonViTinh" type="text"/>
                                </div>
                            </div>  
                        </div>
                        <div class="form-group">
                            <div class="col-md-12" style="margin-bottom: 10px; text-align: right" >
                                <div class="col-md-3">
                                    <label>Địa điểm (Address)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-9">
                                    <input class="form-control" disabled id="fiDiaDiem" name="fiDiaDiem" data-bind="value : fiDiaDiem" type="text"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-3" style="text-align: right">
                                    <label>Mô tả cách thức thu thập (Describe how it was collected)</label>
                                </div>
                                <div class="col-md-9">
                                    <textarea class="form-control" disabled rows="3" id="fiCachThucThuThapMau" data-bind="value : fiCachThucThuThapMau" type="text"></textarea>
                                </div>
                            </div>  
                        </div>
                    </div> 
                </template> 
            </form>
           



