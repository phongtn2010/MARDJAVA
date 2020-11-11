<fieldset data-bind="with: thongtinChungVM">
    <legend><b><spring:message code="sbv.02.tokhai.thong_tin_dn"/></b></legend>
    <form role="form" class="form-horizontal">
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.ten_doanh_nghiep"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiTenDoanhNghiep"
                            class="form-control"
                            disabled/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.tru_so_chinh"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiTruSoChinh"
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.dien_thoai"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiDienThoai"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.ma_so_thue"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiMSThue"
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.fax"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiFax"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.so_don_de_nghi"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiSoDonDN"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.nguoi_dai_dien"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiNguoiDaiDien"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.giayCNDT_CNDKDN"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiGiayCNDT"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.ngay_cap_hs"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="datepicker: fiNgayCap"
                            class="form-control form-control-inline date-picker"
                            data-date-format="dd/mm/yyyy" type="text" value=""
                            maxlength="10" />
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.hinh_thuc_dau_tu"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input
                            data-bind="fiHinhThucDauTu"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.von_dau_tu"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-10">
                    <input
                            data-bind="fiTongVon"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.von_phap_dinh"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiVonPhapDinh"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.von_vay"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiVonVay"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.ti_le_XK"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiTiLeXK"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.soluong_CBCN"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiSoLuongCBCN"
                            class="form-control"/>
                </div>
            </div>
        </div>
        <div class="form-group" style="margin-top: 15px">
            <div class="col-md-12">
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.thoi_gian_hd"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiThoiGianHD"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.nam_de_nghi"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="fiNamDeNghi"
                            class="form-control"/>
                </div>
            </div>
        </div>
    </form>
</fieldset>