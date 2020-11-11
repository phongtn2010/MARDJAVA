function ThongTinHangHoaVM(data) {
    var self = this;
    self.fiTenDoanhNghiep = ko.observable((data && data.hasOwnProperty('fiTenDoanhNghiep')) ? data.fiTenDoanhNghiep : null);
    self.fiTruSoChinh = ko.observable((data && data.hasOwnProperty('fiTenDoanhNghiep')) ? data.fiTenDoanhNghiep : null);
    self.fiDienThoai = ko.observable((data && data.hasOwnProperty('fiDienThoai')) ? data.fiDienThoai : null);
    self.fiMSThue = ko.observable((data && data.hasOwnProperty('fiMSThue')) ? data.fiMSThue : null);
    self.fiFax = ko.observable((data && data.hasOwnProperty('fiFax')) ? data.fiFax : null);
    self.fiSoDonDN = ko.observable((data && data.hasOwnProperty('fiSoDonDN')) ? data.fiSoDonDN : null);
    self.fiNguoiDaiDien = ko.observable((data && data.hasOwnProperty('fiNguoiDaiDien')) ? data.fiNguoiDaiDien : null);
    self.fiGiayCNDT = ko.observable((data && data.hasOwnProperty('fiGiayCNDT')) ? data.fiGiayCNDT : null);
    self.fiNgayCap = ko.observable((data && data.hasOwnProperty('fiNgayCap')) ? data.fiNgayCap : null);
    self.fiHinhThucDauTu = ko.observable((data && data.hasOwnProperty('fiHinhThucDauTu')) ? data.fiHinhThucDauTu : null);
    self.fiTongVon = ko.observable((data && data.hasOwnProperty('fiTongVon')) ? data.fiTongVon : null);
    self.fiVonPhapDinh = ko.observable((data && data.hasOwnProperty('fiVonPhapDinh')) ? data.fiVonPhapDinh : null);
    self.fiVonVay = ko.observable((data && data.hasOwnProperty('fiVonVay')) ? data.fiVonVay : null);
    self.fiTiLeXK = ko.observable((data && data.hasOwnProperty('fiTiLeXK')) ? data.fiTiLeXK : null);
    self.fiSoLuongCBCN = ko.observable((data && data.hasOwnProperty('fiSoLuongCBCN')) ? data.fiSoLuongCBCN : null);
    self.fiThoiGianHD = ko.observable((data && data.hasOwnProperty('fiThoiGianHD')) ? data.fiThoiGianHD : null);
    self.fiNamDeNghi = ko.observable((data && data.hasOwnProperty('fiNamDeNghi')) ? data.fiNamDeNghi : null);


}