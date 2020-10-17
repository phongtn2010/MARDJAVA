<%@ page pageEncoding="UTF-8"%>
<page size="A4" class="a4-padding">
    <b style="float: left;width: 100%;margin-bottom: 10px;">Thông tin văn bản chấp thuận</b>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">
                <label>Số văn bản</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiSoVanban" readonly data-bind="value : fiSoVanban" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Cơ quan cấp</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" id="fiTenCqCap" readonly name="fiTenCqCap" data-bind="value : fiTenCqCap" type="text" />

            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">            
            <div class="col-md-2 nsw-text-right">

                <label>Người ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control" name="fiNguoiKy" readonly data-bind="value : fiNguoiKy" type="text"/>
            </div>
            <div class="col-md-2 nsw-text-right">
                <label>Ngày ký</label>
            </div>
            <div class="col-md-4">
                <input class="form-control date-picker" placeholder="dd/mm/yyyy" readonly disabled id="fiNgayKy" name="fiNgayKy" data-bind="datepicker : fiNgayKy" type="text" data-date-format="dd/mm/yyyy" />

            </div>
        </div> 
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <b style="float: left;width: 100%;margin-bottom: 10px;">Danh sách hàng hoá</b>
            <table class="table table-striped table-bordered table-hover table-checkable order-column" id="lstHanghoa10" style="float: left;width: 100%;table-layout: fixed;">
                <thead>
                    <tr class="nsw-tr tr-nsw1-bgcolor">
                        <th style="width: 8%" class="text-center"><spring:message code="moit.01.hoso.thongtinhanghoa.stt" /></th>
                        <th style="width: 20%" class="text-center"><spring:message code="moit.01.hoso.thongtinhanghoa.mahs" /></th>
                        <th style="width: 72%" class="text-center"><spring:message code="moit.01.hoso.thongtinhanghoa.motahanghoa" /></th>
                    </tr>
                </thead>
                <tbody data-bind="foreach: lstHanghoas">
                    <tr>
                        <td data-bind="text : $index() + 1"></td>  
                        <td data-bind="text : fiMaHs"></td>  
                        <td data-bind="text : fiTenHh" style="width: 220px;text-align: left;word-wrap: break-word;max-width: 220px !important;vertical-align: middle;"></td>  
                    </tr>
                </tbody>
            </table>
            
            <style>
                .table-bordered > tbody > tr > td{word-wrap: break-word !important;vertical-align: middle !important;}
            </style>
            
            <p class="content">
                File văn bản
            </p>
            <table class="tb-content tb-none-border w100p">
                <tbody>
                    <tr>
                        <td class="left">
                            <a target="_blank" data-bind="text: fiTenTep, attr: { href: fileUrl}"></a>
                        </td>            
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</page>

