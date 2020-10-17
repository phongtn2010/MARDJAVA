<%@ page pageEncoding="UTF-8"%>
<page size="A3" class="a4-padding">
    <b>THÔNG TIN GIẤY PHÉP NHẬP KHẨU CHẤT PHÓNG XẠ</b>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label>Tên cơ quan cấp</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiCoQuanCap" readonly data-bind="value : fiCoQuanCap" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số giấy phép</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiSoGiayPhep" readonly name="fiSoGiayPhep" data-bind="value : fiSoGiayPhep" type="text"/>

            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">    
            <div class="col-md-2 nsw-text-right">
                <label>Ngày ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly disabled id="fiNgayKy" name="fiNgayKy" data-bind="datepicker : fiNgayKy" type="text" data-date-format="dd/mm/yyyy" />

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Người ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiNguoiKy" readonly data-bind="value : fiNguoiKy" type="text"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">    
            <div class="col-md-2 nsw-text-right">
                <label>Ngày hiệu lực từ ngày</label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly disabled id="fiHieulucTungay" name="fiHieulucTungay" data-bind="datepicker : fiHieulucTungay" type="text" data-date-format="dd/mm/yyyy" />

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Ngày hiệu lực đến  ngày</label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly disabled id="fiHieulucDenngay" name="fiHieulucDenngay" data-bind="datepicker : fiHieulucDenngay" type="text" data-date-format="dd/mm/yyyy" />
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <b>CÁC ĐẶC TRƯNG CỦA NGUỒN BỨC XẠ TRONG CÔNG VIỆC BỨC XẠ ĐƯỢC CẤP GIẤY PHÉP</b>
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center"><spring:message code="most.05.hoso.lichsu.stt" /></th>
                <th class="text-center"><spring:message code="most.05.hoso.phongXakin.tenDVPhongXa" /></th>
                <th class="text-center"><spring:message code="most.05.xemketqua.dangNguon" /></th>
                <th class="text-center"><spring:message code="most.05.xemketqua.maHieuSoSeri" /></th>
                <th class="text-center"><spring:message code="most.05.hoso.phongXakin.nuocSanXuat" /></th>
                <th class="text-center"><spring:message code="most.05.xemketqua.trangThaiVatLyHo" /></th>
                <th class="text-center"><spring:message code="most.05.xemketqua.hoatDoNgayXD" /></th>
                <th class="text-center"><spring:message code="most.05.xemketqua.cvBucXa" /></th>
                <th class="text-center"><spring:message code="most.05.xemketqua.thietBiDiKem" /></th>
                </tr>
                </thead>
                <tbody data-bind="foreach: lstDactrungnguon05">
                    <tr>
                        <td data-bind="text : $index() + 1"></td>  
                        <td data-bind="text : fiTenDongViPx"></td>  
                        <td data-bind="text : fiDangNguon"></td>  
                        <td data-bind="text : fiMaHieuSoSeri"></td>  
                        <td data-bind="text : fiHangNuocSanXuat"></td>  
                        <td data-bind="text : fiTrangThaiVatLy"></td>  
                        <td data-bind="text : fiHoatDo"></td>  
                        <td data-bind="text : fiCongViecBxLienQuan"></td>  
                        <td data-bind="text : fiThietBiDiKem"></td>  
                    </tr>
                </tbody>
            </table>
            <p class="content">
                File văn bản cho phép
            </p>
            <table class="tb-content tb-none-border w100p">
                <tbody>
                    <tr>
                        <td class="left">
                            <a target="_blank" data-bind="text: fiTenTepTin, attr: { href: downloadUrl}"></a>
                        </td>            
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</page>

