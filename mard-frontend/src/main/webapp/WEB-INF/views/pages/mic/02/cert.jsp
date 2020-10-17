<%@ page pageEncoding="UTF-8"%>
<page size="A3" class="a4-padding">
    <b>Thủ tục Cấp giấy phép nhập khẩu thiết bị in</b>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label>Số giấy phép </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoGiayPhep" readonly data-bind="value : fiSoGiayPhep" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Nơi cấp giấy phép</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiNoiCapGp" readonly name="fiNoiCapGp" data-bind="value : fiNoiCapGp" type="text"/>

            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">    
            <div class="col-md-2 nsw-text-right">
                <label>Tên người ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenNguoiKy" readonly name="fiTenNguoiKy" data-bind="value : fiTenNguoiKy" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Chức danh </label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiChucDanh" readonly data-bind="value : fiChucDanh" type="text"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">    
            <div class="col-md-2 nsw-text-right">
                <label>Ngày cấp giấy phép</label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly disabled id="fiNgayCapPhep" name="fiNgayCapPhep" data-bind="datepicker : fiNgayCapPhep" type="text" data-date-format="dd/mm/yyyy" />

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Số đơn đề nghị cấp phép</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoDonDeNghi" readonly data-bind="value : fiSoDonDeNghi" type="text"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">    
            <div class="col-md-2 nsw-text-right">
                <label>Ngày đề nghị cấp phép</label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly disabled id="fiNgayDeNghi" name="fiNgayDeNghi" data-bind="datepicker : fiNgayDeNghi" type="text" data-date-format="dd/mm/yyyy" />

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Tên cơ sở đề nghị</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiTenToChuc" readonly data-bind="value : fiTenToChuc" type="text"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">    
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ trụ sở</label>
            </div>
            <div class="col-md-4">
                 <input class="form-control" name="fiDiaChiTc" readonly data-bind="value : fiDiaChiTc" type="text"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Mục đích nhập khẩu</label>
            </div>
            <div class="col-md-4">
                 <input class="form-control" name="fiMdNhapKhau" readonly data-bind="value : fiMdNhapKhau" type="text"/>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">    
            <div class="col-md-2 nsw-text-right">
                <label>Địa chỉ đặt máy lần đầu</label>
            </div>
            <div class="col-md-4">
                 <input class="form-control" name="fiDiaChiDatMay" readonly data-bind="value : fiDiaChiDatMay" type="text"/>

            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Link giấy phép</label>
            </div>
            <div class="col-md-4">
                  <a target="_blank" data-bind="text: fiLinkGiayphep"></a>
            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <b>Phần II: Danh sách thiết bị nhập khẩu</b>
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th class="text-center">STT</th>
                        <th class="text-center">Tên Máy</th>
                        <th class="text-center">Tên hãng sản xuất</th>
                        <th class="text-center">Model máy</th>
                        <th class="text-center">Nước sản xuất</th>
                        <th class="text-center">Năm sản xuất</th>
                        <th class="text-center">Số lượng máy</th>
                        <th class="text-center">Chức năng</th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstThietBiNk02">
                    <tr>
                        <td data-bind="text : $index() + 1"></td>  
                        <td data-bind="text : fiTenMay"></td>  
                        <td data-bind="text : fiTenHangSx"></td>  
                        <td data-bind="text : fiModelMay"></td>  
                        <td data-bind="text : fiNuocSx"></td>  
                        <td data-bind="text : fiNamSx"></td>  
                        <td data-bind="text : fiSoLuong"></td>  
                        <td style="width: 220px" class="text-center">
                            <a class="btn green bt-center" data-bind="click: popupTBNK"><i class="fa fa-eye"></i> Xem</a>
                    </td>
                    </tr>
                </tbody>
            </table>
        </div>
         <p class="nsw-text-center">
        <a data-bind="click : btnXinSuaClick" href="javascript:void(0);" class="btn blue"><i class="fa fa-edit"></i> Xin sửa giấy phép</a>
         </p>
    </div>
</page>

