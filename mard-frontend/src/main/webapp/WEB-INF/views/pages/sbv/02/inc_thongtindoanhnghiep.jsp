<fieldset data-bind="with: thongtinDNVM">
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
                            data-bind="value: fiTenDoanhNghiep"
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
                            data-bind="value: fiTruSoChinh "
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.dien_thoai"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiDienThoai "
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
                            data-bind="value: fiMSThue "
                            class="form-control"
                            disabled/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.fax"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiSoFax "
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
                            data-bind="value: fiSoDonDN , enable: $root.isEditable()"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.nguoi_dai_dien"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiNguoiDaiDien , enable: $root.isEditable()"
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
                            data-bind="value: fiGiayCNDT , enable: $root.isEditable()"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.ngay_cap_hs"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiNgayCapGiay , enable: $root.isEditable()"
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
                            data-bind="value: fiHinhThucDauTu , enable: $root.isEditable()"
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
                            data-bind="value: fiTongVon"
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
                            data-bind="value: fiVonPhapDinh"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.von_vay"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiVonVay"
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
                            data-bind="value: fiTiLeXK"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.soluong_CBCN"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiSoLuongCBCN"
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
                            data-bind="value: fiThoiGianHD"
                            class="form-control"/>
                </div>
                <div class="col-md-2 nsw-text-right">
                    <label><spring:message
                            code="sbv.02.nam_de_nghi"/><a class="nsw-require-field">*</a></label>
                </div>
                <div class="col-md-4">
                    <input
                            data-bind="value: fiNamDeNghi"
                            class="form-control"/>
                </div>
            </div>
        </div>
    </form>
</fieldset>