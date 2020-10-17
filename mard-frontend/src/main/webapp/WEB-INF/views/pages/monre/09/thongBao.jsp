<%-- 
    Document   : thongBao
    Created on : Dec 23, 2017, 12:16:46 PM
    Author     : AnNguyen
--%>

<%@ page pageEncoding="UTF-8"%>
<%@include file="word.jsp" %>
<page size="A4" class="a4-padding">
    <fieldset>
        <p class="title" style="text-align: left;">
        <spring:message code="monre.09.thongbao" />
        </p>
        <table class="w100p tb-none-border">
            <tr>
                <td style="text-align: right;"><label style="text-align: right;"><spring:message code="monre.09.thongbao.tencoquancap" /></label></td>
                <td><input class="form-control" id="fiCoQuanCap" name="fiCoQuanCap" type="text" data-bind="value : fiCoQuanCap" readonly="readonly"/></td>
                <td style="text-align: right;"><label><spring:message code="monre.09.thongbao.sovanban" /></label></td>
                <td><input class="form-control" id="fiSoVanBan" name="fiSoVanBan" data-bind="value : fiSoVanBan" type="text" readonly/></td>
            </tr>
            <tr>
                <td style="text-align: right;"><label><spring:message code="monre.09.thongbao.ngayky" /></label></td>
                <td><input class="form-control" id="fiNgayKy" name="fiNgayKy" type="text" data-bind="value : fiNgayKy" readonly="readonly"/></td>
                <td style="text-align: right;"><label style="text-align: right;" ><spring:message code="monre.09.thongbao.nguoiky" /></label></td>
                <td><input class="form-control" id="fiNguoiKy" name="fiNguoiKy" data-bind="value : fiNguoiKy" type="text" readonly/></td>
            </tr>
            <tr>
                <td style="text-align: right;"><label><spring:message code="monre.09.thongbao.file" /></label></td>
                <td colspan="3">
                    <a data-bind="attr: { href: exportHref}"  target="_blank" class="btn grey" id="btnTai"><i class="fa fa-download"></i> <span data-bind="text: fiTenTep"></span></a>
                </td>            
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <p class="title" style="text-align: left;">
        <spring:message code="monre.09.hoso.mucdichduarann" />
        </p>
        <div class="form-group">
            <div class="col-md-12" style="width: 150%">
                <div class="col-md-7" style="text-align: right;margin-left: -20px; width: 545px;" >
                    <label><input  name="fiMucDich" disabled type="radio" value="1" data-bind="checked: fiMucDich"/><spring:message code="monre.09.hoso.mucdichduarann.nghiencuu" /></label>
                </div>
                <div class="col-md-5" style="text-align: left">
                    <label><input  name="fiMucDich" disabled type="radio" value="2" data-bind="checked: fiMucDich"/><spring:message code="monre.09.hoso.mucdichduarann.hoctap" /></label>
                </div>
            </div>  
        </div>       
    </fieldset> 
    <fieldset>
        <p class="title" style="text-align: left;">
        <spring:message code="monre.09.hoso.thongtinng" />
        </p>

        <!-- table nguon gen -->

        <div class="form-group">
            <div class="col-md-12" style="width: 105%; margin-left: -20px">
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
                    <tbody data-bind="template: { name: 'TmplNguonGen', foreach: lstNguongen9 }">
                    </tbody>
                    <script id="TmplNguonGen" type="text/html">
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
                                    <a class="btn green bt-center" data-bind="click: $parent.editTTGenClick.bind($parent)"><i class="fa fa-edit"></i> xem</a>
                                </td>
                        </tr>                      
                        </script>
                    </table>

                </div>
                <div class="col-md-12" style="width: 105%; margin-left: -20px">
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
                        <tbody data-bind="template: { name: 'TmplMauGen', foreach: lstMaugen9 }">
                        </tbody>
                        <script id="TmplMauGen" type="text/html">
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
                                    <a class="btn green bt-center" data-bind="click: $parent.editMauGenClick.bind($parent)"><i class="fa fa-edit"></i> xem</a>
                                </td>
                            </tr>                      
                            </script>
                        </table>
                        <div class="form-group">
                            <div class="col-md-12" style="width: 109%; margin-left: -35px">
                                <div class="col-md-2">
                                    <label style="text-align: right">Thời gian thu thập (Duration start time)</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control date-picker" disabled id="fiThoiGianBatDau" name="fiThoiGianBatDau" data-bind="datepicker : fiThoiGianBatDau" type="text" data-date-format="dd/mm/yyyy" />
                                </div>
                                <div class="col-md-2">
                                    <label style="text-align: right">Thời gian kết thúc (Duration end time)</label>
                                </div>
                                <div class="col-md-4">
                                    <input class="form-control date-picker" disabled id="fiThoiGianKetThuc" name="fiThoiGianKetThuc" data-bind="datepicker : fiThoiGianKetThuc" type="text" data-date-format="dd/mm/yyyy"/>
                                </div>
                            </div>  
                        </div> 
                        <div class="form-group">
                            <div class="col-md-12" style="margin-left: -37px;width: 109%">
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
                <p class="title" style="text-align: left;">
                <spring:message code="monre.09.hoso.thongtinbencc" />
                </p>
                <div class="form-group">
                    <div class="col-md-12"  style="width: 110% ;margin-left: -38px">
                        <div class="col-md-2" style="text-align: right">
                            <label>Tên tổ chức (Full name of the organization)</label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiTenToChuc" name="fiTenToChuc" data-bind="value : fiTenToChuc" type="text" />
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Người đại diện (Name of the representative of the organization)</label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiNguoiDaiDien" name="fiNguoiDaiDien" data-bind="value : fiNguoiDaiDien" type="text"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12"  style="width: 110% ;margin-left: -38px">
                        <div class="col-md-2" style="text-align: right">
                            <label>Địa chỉ liên hệ (Address)</label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiDiaChiCc" name="fiDiaChiCc" data-bind="value : fiDiaChiCc" type="text"/>
                        </div>
                        <div class="col-md-2" style="text-align: right">
                            <label>Chức vụ (Position)</label>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" disabled id="fiChucVuCc" name="fiChucVuCc" data-bind="value : fiChucVuCc" type="text"/>
                        </div>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12" style="width: 110% ;margin-left: -38px">
                        <div class="col-md-2" style="text-align: right">
                            <label>Điện thoại (Phone)</label>
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
                <p class="title" style="text-align: left;">
                <spring:message code="monre.09.hoso.ttvvsdng" />
                </p>
                <div class="form-group">
                    <div class="col-md-12">
                            <label>Sử dụng nguồn gen ở nước ngoài (Information on the utilization of genetic resources abroad)</label>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12" style="width: 103%">
                            <textarea class="form-control" disabled rows="3" id="fiSuDungNguonGen" data-bind="value : fiSuDungNguonGen" type="text"></textarea>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                            <label>Số lượng/Khối lượng nguồn gen đăng ký đưa ra khỏi lãnh thổ nước Cộng hòa xã hội chủ nghĩa Việt Nam (Amount/ quantity collected)</label>
                    </div>  
                </div>
                <div class="form-group">
                    <div class="col-md-12" style="width: 103%">
                            <textarea class="form-control" disabled rows="3" id="fiSoLuong" data-bind="value : fiSoLuong"></textarea>
                    </div>  
                </div>
            </fieldset>

            <!--popup open-->
            <template id="NguonGen-template">
                <div class="row" id="NguonGenpop">
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-2" style="text-align: right">
                                <label>Tên thông thường (Common name)</label>
                            </div>
                            <div class="col-md-4">
                                <input class="form-control" disabled id="fiTenThongThuong" name="fiTenThongThuong" data-bind="value : fiTenThongThuong" type="text"/>
                            </div>
                            <div class="col-md-2" style="text-align: right">
                                <label>Tên khoa học (Scientific name)</label>
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

            <template id="mauGen-template">
                <div class="row" id="mauGen-vm">
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
                            </div>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-3" style="text-align: right">
                                <label>Tên mẫu (Sample of genetic resources)</label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" disabled id="fiTenMau" name="fiTenMau" data-bind="value : fiTenMau" type="text"/>
                            </div>
                            <div class="col-md-3" style="text-align: right">
                                <label>Tên khoa học</label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" disabled id="fiTenMauKhoaHoc" name="fiTenMauKhoaHoc" data-bind="value : fiTenMauKhoaHoc" type="text"/>
                            </div>
                        </div>  
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="col-md-3" style="text-align: right">
                                <label>Số lượng/Khối lượng nguồn gen đăng ký đưa ra khỏi lãnh thổ nước Cộng Hòa Xã Hội Chủ Nghia Việt Nam (Amount/ quantity collected)</label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" disabled id="fiSoLuong" name="fiSoLuong" data-bind="value : fiSoLuong" type="text"/>
                            </div>
                            <div class="col-md-3" style="text-align: right">
                                <label>Đơn vị(Unit)</label>
                            </div>
                            <div class="col-md-3">
                                <input class="form-control" disabled id="fiDonViTinh" name="fiDonViTinh" data-bind="value : fiDonViTinh" type="text"/>
                            </div>
                        </div>  
                    </div>
                    <div class="form-group">
                        <div class="col-md-12" style="margin-bottom: 10px; text-align: right" >
                            <div class="col-md-3">
                                <label>Địa điểm (Address)</label>
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
        </page>
