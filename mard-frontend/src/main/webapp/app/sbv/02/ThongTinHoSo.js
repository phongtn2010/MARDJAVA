function ThongTinHoSoVM(options) {
    var self = this;
    self.fiIdHS = ko.observable((options && options.hasOwnProperty('fiIdHS')) ? options.fiIdHS : null);
    self.fiHSType = ko.observable((options && options.hasOwnProperty('fiHSType')) ? options.fiHSType : null);
    self.thongtinDNVM = ko.observable(new ThongTinDNVM(options));
    self.kyHoSoVM = ko.observable(new KyHoSoVM(options));
    self.thongtinHangHoa = ko.observable(new ThongTinHangHoaVM(options));
    // self.lstProfileStatus  = ko.observableArray((options && options.hasOwnProperty('lstProfileStatus')) ? options.lstProfileStatus :[]);
    self.getData = function () {
        var body = {
            "fiIdHS": self.fiIdHS(),
            "fiTenDoanhNghiep": self.thongtinDNVM().fiTenDoanhNghiep(),
            "fiTruSoChinh": self.thongtinDNVM().fiTruSoChinh(),
            "fiMaSoThue": self.thongtinDNVM().fiMaSoThue(),
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
            "fiVonPhapDinh": self.thongtinDNVM().fiVonPhapDinh(),
            "fiTiLeXK": self.thongtinDNVM().fiTiLeXK(),
            "fiSoLuongCBCN": self.thongtinDNVM().fiSoLuongCBCN(),
            "fiThoiGianHD": self.thongtinDNVM().fiThoiGianHD(),
            "fiNamDeNghi": self.thongtinDNVM().fiNamDeNghi(),
            "fiNoiKy": self.kyHoSoVM().fiNoiKy(),
            "fiChucVuKy": self.kyHoSoVM().fiChucVuKy(),
            "fiNguoiKy": self.kyHoSoVM().fiNguoiKyHS(),
            "fiNgayKy": self.kyHoSoVM().fiNgayKyHS(),
            "fiThoiGianXNK": self.thongtinHangHoa().fiThoiGianXNK(),
            "fiIdCuaKhau": self.thongtinHangHoa().fiIdCuaKhau(),
            "fiSoGiayDaCap": self.thongtinHangHoa().fiSoGiayDaCap(),
            "fiCapLanDau": self.thongtinHangHoa().fiCapLanDau(),
            "fiProductList": []
        }
        switch (self.fiHSType().toString()) {
            case "1": {
                body["fiProductList"] = self.thongtinHangHoa().productVM().fiProductList();
                break;
            }
            case "2": {
                body["fiProductList"] = self.thongtinHangHoa().productVM().fiProductList();
                break;
            }
            default: return;
        }
        return body;
    }
}