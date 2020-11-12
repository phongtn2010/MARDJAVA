function ThongTinHoSoVM(options) {
    var self = this;
    self.thongtinDNVM = ko.observable(new ThongTinDNVM(options));
    self.kyHoSoVM = ko.observable(new KyHoSoVM(options));
    self.thongtinHangHoa = ko.observable(new ThongTinHangHoaVM(options));
    self.getData = function () {
        var body = {
            "fiTenDoanhNghiep": self.thongtinDNVM().fiTenDoanhNghiep(),
            "fiTruSoChinh": self.thongtinDNVM().fiTruSoChinh(),
            "fiDienThoai": self.thongtinDNVM().fiDienThoai(),
            "fiTrangThaiHoSo": 0,
            "fiFax": self.thongtinDNVM().fiSoFax(),
            "fiSoDonDN": self.thongtinDNVM().fiSoDonDN(),
            "fiNguoiDaiDien": self.thongtinDNVM().fiNguoiDaiDien(),
            "fiGiayCNDT": self.thongtinDNVM().fiGiayCNDT(),
            "fiNgayCapGiay": self.thongtinDNVM().fiNgayCapGiay(),
            "fiHinhThucDauTu": self.thongtinDNVM().fiHinhThucDauTu(),
            "fiTongVon": self.thongtinDNVM().fiTongVon(),
            "fiVonVay": self.thongtinDNVM().fiVonVay(),
            "fiTiLeXK": self.thongtinDNVM().fiTiLeXK(),
            "fiSoLuongCBCN": self.thongtinDNVM().fiSoLuongCBCN(),
            "fiThoiGianHD": self.thongtinDNVM().fiThoiGianHD(),
            "fiNamDeNghi": self.thongtinDNVM().fiNamDeNghi(),
            "fiNoiKy": self.kyHoSoVM().fiNoiKy(),
            "fiChucVuKy": self.kyHoSoVM().fiChucVuKy(),
            "fiNguoiKy": self.kyHoSoVM().fiNguoiKyHS(),
            "fiNgayKy": self.kyHoSoVM().fiNgayKyHS(),
            // "fiMSThue": self.fiMSThue(),
            // "fiTaxCode": self.thongtinChungVM().fiTaxCode(),
            // "fiHSCreatedDate": new Date(self.thongtinChungVM().fiHSCreatedDate()).getTime(),
            // "fiRegistrationNo": self.thongtinChungVM().fiRegistrationNo(),
            // "fiImporterAddress": self.thongtinChungVM().fiImporterAddress(),
            // "fiImporterName": self.thongtinChungVM().fiImporterName(),
            // "fiImporterTel": self.thongtinChungVM().fiImporterTel(),
            // "fiImporterFax": self.thongtinChungVM().fiImporterFax(),
            // "fiImporterEmail": self.thongtinChungVM().fiImporterEmail(),
            // "fiSignAddress": self.kyHoSoVM().fiSignAddress(),
            // "fiSignDate": new Date(self.kyHoSoVM().fiSignDate()).getTime(),
            // "fiSignName": self.kyHoSoVM().fiSignName(),
            // "fiSignPosition": self.kyHoSoVM().fiSignPosition(),
            // "fiProductList": [],
            // "fiExporterCountryList": [],
            // "fiLocationQuarantineList": [],
            // "fiProcessingList": [],
            // "fiAttachmentList": self.uploadFileVM().getLstAttachments()
        }
        return body;
    }
}