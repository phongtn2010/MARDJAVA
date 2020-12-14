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
                    <label>Mã hồ sơ</label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiMaHoso" name="fiMaHoso" maxlength="255"  
                           type="text" data-bind="value : fiMaHoso" readonly="readonly"/>
                    <input type="hidden" id="fiIdHoso" name="fiIdHoso" data-bind="value : fiIdHoso"/>
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label>Trạng thái hồ sơ</label>
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
                    <label>Ngày tạo</label>
                </div>
                <div class="col-md-4">
                 
                    <input class="form-control date-picker" id="fiNgaytao" name="fiNgaytao"  data-bind="datepicker : fiNgaytao" type="text" data-date-format="dd/mm/yyyy" disabled/>
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label>Đơn vị xử lý<a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">                                        
                    <select class="form-control select2" id="fiMaCoQuan" name="fiMaCoQuan" data-bind="optionsCaption: '---Chọn---'
                   ,optionsValue : 'id'
                    ,selectedText : fiTenCoQuan
                    ,value : fiMaCoQuan
                    ,options : lstDonViXuLy
                    ,optionsText : 'name'"></select>
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
                    <input class="form-control" type="text" id="fiNguoiDaiDien" name="fiNguoiDaiDien"  data-bind="value : fiNguoiDaiDien" />
                </div>
            </div>  
        </div> 
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.dienthoai"/> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiSdtDn" name="fiSdtDn" data-bind="value : fiSdtDn" type="text" maxlength="50" readonly="readonly"/>
                </div>

                <div class="col-md-2" style="text-align: right">
                    <spring:message code="monre.09.hoso.fax" />
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiFaxDn" name="fiFaxDn" data-bind="value : fiFaxDn" type="text" maxlength="50"/>
                </div>
            </div> 
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.email" /> </label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiEmailDn" name="fiEmailDn" data-bind="value : fiEmailDn" type="email" maxlength="50"/>
                </div>

                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.sodkkd" /><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control form-control-inline" id="fiSoGcnDkkd" name="fiSoGcnDkkd" data-bind="value : fiSoGcnDkkd" type="text" maxlength="250" />
                </div>
            </div>  
        </div>         
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.ngaycap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control date-picker" id="fiNgaycapGcnDkkd" placeholder="dd/MM/yyyy" name="fiNgaycapGcnDkkd" data-bind="datepicker : fiNgaycapGcnDkkd" type="text" data-date-format="dd/mm/yyyy"/>
                </div>
                <div class="col-md-2" style="text-align: right">
                    <label><spring:message code="monre.09.hoso.noicap" /> <a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input class="form-control" id="fiNoicapGcnDkkd" name="fiNoicapGcnDkkd" data-bind="value : fiNoicapGcnDkkd" type="text" maxlength="250"/>
                </div>
            </div>  
        </div>        
    </fieldset>
    <fieldset>
        <legend><spring:message code="monre.09.hoso.mucdichduarann"/></legend>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-6" style="text-align: right">
                    <label ><input name="fiMucDich" type="radio"  value="1" data-bind="checked: fiMucDich,event:{change: changeMucdich} " /><spring:message code="monre.09.hoso.mucdichduarann.nghiencuu" /></label>
                </div>
                <div class="col-md-6" style="text-align: left">
                    <label><input name="fiMucDich" type="radio" value="2" data-bind="checked: fiMucDich,event:{change: changeMucdich} " /><spring:message code="monre.09.hoso.mucdichduarann.hoctap" /></label>
                </div>
            </div>
                <div id="mucdichAction"><span data-bind="text : isValidMucDich" style="color:red; margin-left: 220px; font-size: 12px;"></span><br>  </div>
        </div> 
    </fieldset> 

    <fieldset>
        <legend><spring:message code="monre.09.hoso.thongtinng" /></legend>

        <!-- table nguon gen -->

        <div class="form-group">
            <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover table-checkable order-column">
                    <div style="margin-bottom: 10px;"> <label><b><spring:message code="monre.09.hoso.thongtinng.tenttGen" /></b></label>
                        <a href="javascript:void(0);" class="btn green" data-bind="click: bThemNguonGenDKClick"><i class="fa fa-search-plus"></i>Thêm</a>
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
                                <a class="btn green bt-center" data-bind="click: $parent.editTTGenClick.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                                <a class="btn red bt-center" data-bind="click: $parent.removeTTGenClick.bind($parent),visible: isShowDel"><i class="fa fa-trash"></i> Xoá</a>
                            </td>
                        </tr>                      
                    </script>
                    </table>
                        <div id="isValidNguonGen"><span data-bind="text : isValidNguonGen" style="color:red; font-size: 12px;"></span><br></div>
                </div>
                <div class="col-md-12">
                    <table class="table table-striped table-bordered table-hover table-checkable order-column">
                        <div style="margin-bottom: 10px;"><label><b><spring:message code="monre.09.hoso.thongtinng.mauNguonGen" /></b></label>
                            <a href="javascript:void(0);" class="btn green" data-bind="event: {click: bThemMauGenClick}"><i class="fa fa-search-plus"></i>Thêm</a>

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
                                <td data-bind="text : $index() +1">
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
                                    <a class="btn green bt-center" data-bind="click: $parent.editMauGenClick.bind($parent)"><i class="fa fa-edit"></i> Sửa</a>
                                    <a class="btn red bt-center" data-bind="click: $parent.removeMauGenClick.bind($parent)"><i class="fa fa-trash"></i> Xoá</a>
                                </td>
                            </tr>                      
                            </script>
                        </table>
                        
                        <div id="isValidMauGen"><span data-bind="text : isValidMauGen" style="color:red; font-size: 12px;"></span><br></div>
                    </div>
                    <div class="col-md-12">   
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2">
                                    <label style="text-align: right">Thời gian thu thập (Duration start time)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control date-picker" id="fiThoiGianBatDau" name="fiThoiGianBatDau" placeholder="dd/MM/yyyy" data-bind="datepicker : fiThoiGianBatDau" type="text" data-date-format="dd/mm/yyyy" />
                                </div>
                                <div class="col-md-2">
                                    <label style="text-align: right">Thời gian kết thúc (Duration end time)<a class="nsw-require-field">*</a></label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control date-picker" id="fiThoiGianKetThuc" name="fiThoiGianKetThuc" placeholder="dd/MM/yyyy" data-bind="datepicker : fiThoiGianKetThuc,event:{change: isValidDate}" type="text" data-date-format="dd/mm/yyyy"/>
                                </div>
                            </div>  
                        </div> 
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="col-md-2">
                                    <label style="text-align: right">Cách thức thu thập (Describe how it was collected)</label>
                                </div>
                                <div class="col-md-10">
                                    <textarea class="form-control" rows="3" id="fiCachThucThuThap"  data-bind="value : fiCachThucThuThap" type="text" style="resize: none;"></textarea>
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
                            <input class="form-control" id="fiTenToChuc" name="fiTenToChuc" data-bind="value : fiTenToChuc" type="text" />
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Người đại diện (Name of the representative of the organization)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiNguoiDaiDienCc" name="fiNguoiDaiDienCc" data-bind="value : fiNguoiDaiDienCc" type="text"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Địa chỉ liên hệ (Address)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiDiaChiCc" name="fiDiaChiCc" data-bind="value : fiDiaChiCc" type="text"/>
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Chức vụ (Position)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiChucVuCc" name="fiChucVuCc" data-bind="value : fiChucVuCc" type="text"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Điện thoại (Phone)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiSdtCc" name="fiSdtCc" data-bind="value : fiSdtCc" type="text"/>
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Fax(Fax)</label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" id="fiFaxCc" name="fiFaxCc" data-bind="value : fiFaxCc" type="text"/>
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
                            <textarea class="form-control" rows="3" id="fiSuDungNguonGen" data-bind="value : fiSuDungNguonGen" type="text" style="resize:  none;"></textarea>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-2" style="text-align: right">
                            <label>Số lượng/Khối lượng nguồn gen đăng ký đưa ra khỏi lãnh thổ nước Cộng hòa xã hội chủ nghĩa Việt Nam (Amount/ quantity collected)<a class="nsw-require-field">*</a></label>
                        </div>
                        <div class="col-md-10">
                            <textarea class="form-control" rows="3" id="fiSoLuong" data-bind="value : fiSoLuong " style="resize:  none;"></textarea>
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
                                <input class="form-control" id="fiTenThongThuong" name="fiTenThongThuong" data-bind="value : fiTenThongThuong" type="text"/>
                            </div>
                            <div class="col-md-2" style="text-align: right">
                                <label>Tên khoa học (Scientific name)<a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" id="fiTenKhoaHoc" name="fiTenKhoaHoc" data-bind="value : fiTenKhoaHoc" type="text"/>
                            </div>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2" style="text-align: right">
                                <label>Tên khác (Other name)</label>
                            </div>
                            <div class="col-md-10">
                                <input class="form-control" id="fiTenKhac" name="fiTenKhac" data-bind="value : fiTenKhac" type="text"/>
                            </div>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2" style="text-align: right">
                                <label>Thông tin dự kiến sử dụng tri thức truyền thống về nguồn gen (Traditional knowledge on genetic resources )</label>
                            </div>
                            <div class="col-md-10">
                                <textarea class="form-control" rows="3" id="fiThongTinNguonGen" data-bind="value : fiThongTinNguonGen" type="text" style="resize: none;"></textarea>
                            </div>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2" style="text-align: right">
                                <label>Mô tả nguồn gen (Describe)</label>
                            </div>
                            <div class="col-md-10">
                                <textarea class="form-control" rows="3" id="fiMoTaNguonGen" data-bind="value : fiMoTaNguonGen" type="text" style="resize: none;"></textarea>
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
                                <label>Tên nguồn gen (Name of genetic resources)<a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-9" >
                                <!--TamDT-->
                                <select class="form-control select2" id="fiTenNguonGen" name="fiTenNguonGen" data-bind="optionsCaption: '---Chọn---'
                                    , optionsValue : 'id'
                                    , selectedText : fiTenNguonGen
                                    , value : fiIdNguonGen
                                    , options : slcNguonGen
                                    , optionsText : 'name'"></select>
                            </div>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-3" style="text-align: right">
                                <label>Tên mẫu (Sample of genetic resources)<a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" id="fiTenMau" name="fiTenMau" data-bind="value : fiTenMau" type="text"/>
                            </div>
                            <div class="col-md-3" style="text-align: right">
                                <label>Tên khoa học<a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" id="fiTenMauKhoaHoc" name="fiTenMauKhoaHoc" data-bind="value : fiTenMauKhoaHoc" type="text"/>
                            </div>
                        </div>  
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-3" style="text-align: right">
                                <label>Số lượng/Khối lượng nguồn gen đăng ký đưa ra khỏi lãnh thổ nước Cộng Hòa Xã Hội Chủ Nghia Việt Nam (Amount/ quantity collected)<a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" id="fiSoLuong" name="fiSoLuong" data-bind="value : fiSoLuong" type="number" max="12345678" min ="1" oninput="validity.valid||(value='');"/>
                            </div>
                            <div class="col-md-3" style="text-align: right">
                                <label>Đơn vị(Unit)<a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" id="fiDonViTinh" name="fiDonViTinh" data-bind="value : fiDonViTinh" type="text"/>
                            </div>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-md-12" style="margin-bottom: 10px;" >
                            <div class="col-md-3" style="text-align: right">
                                <label>Địa điểm (Address)<a class="nsw-require-field">*</a></label>
                            </div>
                            <div class="col-md-9">
                                <input class="form-control" id="fiDiaDiem" name="fiDiaDiem" data-bind="value : fiDiaDiem" type="text"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-3" style="text-align: right">
                                <label>Mô tả cách thức thu thập (Describe how it was collected)</label>
                            </div>
                            <div class="col-md-9">
                                <textarea class="form-control" rows="3" id="fiCachThucThuThapMau" data-bind="value : fiCachThucThuThapMau" type="text" style="resize: none;"></textarea>
                            </div>
                        </div>  
                    </div>
                </div> 
            </template> 
        </form>




