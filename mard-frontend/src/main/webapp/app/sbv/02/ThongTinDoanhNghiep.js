function ThongTinDNVM(data) {
    var ttdnVMSelf = this;
    console.log(data);
    ttdnVMSelf.fiTenDoanhNghiep = ko.observable((data && data.hasOwnProperty('fiImporterName')) ? data.fiImporterName : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    ttdnVMSelf.fiTruSoChinh = ko.observable((data && data.hasOwnProperty('fiImporterAddress')) ? data.fiImporterAddress : null);
    ttdnVMSelf.fiDienThoai = ko.observable((data && data.hasOwnProperty('fiDienThoai')) ? data.fiDienThoai : null);
    ttdnVMSelf.fiMaSoThue = ko.observable((data && data.hasOwnProperty('fiTaxCode')) ? data.fiTaxCode : null);
    ttdnVMSelf.fiSoFax = ko.observable((data && data.hasOwnProperty('fiSoFax')) ? data.fiSoFax : null);
    ttdnVMSelf.fiSoDonDN = ko.observable((data && data.hasOwnProperty('fiSoDonDN')) ? data.fiSoDonDN : null);
    ttdnVMSelf.fiNguoiDaiDien = ko.observable((data && data.hasOwnProperty('fiNguoiDaiDien')) ? data.fiNguoiDaiDien : null);
    ttdnVMSelf.fiGiayCNDT = ko.observable((data && data.hasOwnProperty('fiGiayCNDT')) ? data.fiGiayCNDT : null);
    ttdnVMSelf.fiNgayCapGiay = ko.observable((data && data.hasOwnProperty('fiNgayCapGiay')) ? data.fiNgayCapGiay : null);
    ttdnVMSelf.fiHinhThucDauTu = ko.observable((data && data.hasOwnProperty('fiHinhThucDauTu')) ? data.fiHinhThucDauTu : null);
    ttdnVMSelf.fiTongVon = ko.observable((data && data.hasOwnProperty('fiTongVon')) ? data.fiTongVon : null);
    ttdnVMSelf.fiVonPhapDinh = ko.observable((data && data.hasOwnProperty('fiVonPhapDinh')) ? data.fiVonPhapDinh : null);
    ttdnVMSelf.fiVonVay = ko.observable((data && data.hasOwnProperty('fiVonVay')) ? data.fiVonVay : null);
    ttdnVMSelf.fiTiLeXK = ko.observable((data && data.hasOwnProperty('fiTiLeXK')) ? data.fiTiLeXK : null);
    ttdnVMSelf.fiSoLuongCBCN = ko.observable((data && data.hasOwnProperty('fiSoLuongCBCN')) ? data.fiSoLuongCBCN : null);
    ttdnVMSelf.fiThoiGianHD = ko.observable((data && data.hasOwnProperty('fiThoiGianHD')) ? data.fiThoiGianHD : null);
    ttdnVMSelf.fiNamDeNghi = ko.observable((data && data.hasOwnProperty('fiNamDeNghi')) ? data.fiNamDeNghi : null);
    ttdnVMSelf.fiTrangThaiHoSo = ko.observable((data && data.hasOwnProperty('fiTrangThaiHoSo')) ? data.fiTrangThaiHoSo : null);
}