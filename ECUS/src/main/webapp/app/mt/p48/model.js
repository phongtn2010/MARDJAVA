var Tbddanhmucfile = function(fiIdDanhMuc, fiMaDanhMuc, fiTenDanhMuc){
	this.fiIdDanhmuc = ko.observable(fiIdDanhMuc);
    this.fiMaDanhmuc = ko.observable(fiMaDanhMuc);
    this.fiTenDanhmuc = ko.observable(fiTenDanhMuc);
}
var Tbdphuongtien = function () {
    this.fiStt = ko.observable();
    this.fiIdPhuongTien = ko.observable();
    this.fiBienSo = ko.observable().extend({required: {message: 'Biển số xe không được trống!'}});
    this.fiTenSoHuu = ko.observable();
    this.fiBiensocu = ko.observable();
    this.fiTrongTai = ko.observable().extend({required: {message: 'Trọng tải xe không được trống!'}});
    this.fiNamSanXuat = ko.observable().extend({required: {message: 'Năm sản xuất không được trống!'}});
    this.fiMaNhanHieu = ko.observable().extend({required: {message: 'Nhãn hiệu xe không được trống!'}});
    this.fiTenNhanHieu = ko.observable();
    this.fiSoKhung = ko.observable().extend({required: {message: 'Số khung không được trống!'}});
    this.fiSoMay = ko.observable().extend({required: {message: 'Số máy không được trống!'}});
    this.fiMauSon = ko.observable().extend({required: {message: 'Màu sơn không được trống!'}});
    this.fiTuNgay = ko.observable().extend({required: {message: 'Từ ngày cấp phép không được trống!'}});
    this.fiDenNgay = ko.observable().extend({required: {message: 'Đến ngày cấp phép không được trống!'}});
    this.fiMaCuaKhau = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiHinhThucHD = ko.observable().extend({required: {message: 'Hình thức hoạt động không được trống!'}});
    this.objectTypeDate = ['fiTuNgay', 'fiDenNgay'];
    this.editing = ko.observable(false);
}

var Tbsloaihinhvantai = function () {
    this.fiIdHoso = ko.observable();
    this.fixedRoadTransport = ko.observable();
    this.contractRoadTransport = ko.observable();
    this.passengerTransport = ko.observable();
    this.cargoTransport = ko.observable();
    this.passengerTaxi = ko.observable();
    this.objectTypeDate = [];
}

var Tbddinhkem = function () {
    this.fiIdDinhKem = ko.observable();
    this.fiTailieuId = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiTenChungTu = ko.observable();
    this.fiMaChungTu = ko.observable();
    this.fiTenFile = ko.observable();
    this.fiGhichu = ko.observable();
    this.fiDuongDan = ko.observable();
    this.fiUrlDinhkem = ko.observable();
    this.fiSothutu = ko.observable();
    this.fiTrangThai = ko.observable();
    this.objectTypeDate = [];
}

var Tbdhoso = function () {
    var self = this;
    this.fiTenTrangThai = ko.observable();
    this.fiMaTuyen = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiIdBoPhan = ko.observable().extend({required: {message: 'Đơn vị không được trống!'}});
    this.fiTenbophan = ko.observable();
    this.fixedRoadTransport = ko.observable();
    this.fiIdTrangThai = ko.observable();
    this.fiLoaiHoSo = ko.observable();
    this.fiMaHoSo = ko.observable();
    this.fiXoa = ko.observable();
    this.fiLyDoRut = ko.observable();
    this.fiIdGiayPhep = ko.observable();
    this.fiNguoiTao = ko.observable();
    this.fiMaNguoiTao = ko.observable();
    this.fiKinhGui = ko.observable();
    this.fiTenDoanhNghiep = ko.observable();
    this.fiDiaChi = ko.observable();
    this.fiDienThoai = ko.observable();
    this.fiFax = ko.observable().extend({maxLength : 255 });
    this.fiLoaiHinh = ko.observable();
    this.fiLyDoCapLai = ko.observable();
    this.fiMaTuyenDen = ko.observable();
    this.fiTenTuyenDen = ko.observable();
    this.fiBenDi = ko.observable().extend({
        required: {
            message: 'Bến xe đi không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiMaTinhDi = ko.observable();
    this.fiTenTinhDi = ko.observable().extend({
        required: {
            message: 'Tỉnh đi không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiBenDen = ko.observable().extend({
        required: {
            message: 'Bến xe đến không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiMaTinhDen = ko.observable();
    this.fiTenTinhDen = ko.observable().extend({
        required: {
            message: 'Tỉnh đến không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiCuLy = ko.observable().extend({
        required: {
            message: 'Khoảng cách không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiHanhTrinh = ko.observable().extend({
        required: {
            message: 'Hành trình không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiCoQuanCapPhep = ko.observable().extend({
        required: {
            message: 'Sở Giao thông vận tải cấp không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiSoCongVan = ko.observable().extend({
        required: {
            message: 'Công văn không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiNgayCapCongVan = ko.observable().extend({
        required: {
            message: 'Ngày cấp phép không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });

    this.fiNgayTao = ko.observable();
    this.fiNgayGui = ko.observable();
    this.fiTenNguoiKy = ko.observable();
    this.fiChucDanh = ko.observable();
    this.fiDiaDiemKy = ko.observable();
    this.fiNgayKy = ko.observable();
    this.objectTypeDate = ['fiNgaydangky', 'fiNgaycapchungchi', 'fiNgayTao', 'fiNgayCapCongVan', 'fiNgayGui',
        'fiNgaynhan', 'fiNgaychapthuan', 'fiNgayketthuc', 'fiNgayKy'];
     
}

var HosoChiTietModel = function () {
    this.Tbdhoso = new Tbdhoso();
    this.Tbsloaihinhvantai = new Tbsloaihinhvantai();
    this.Tbddoanhnghiepky = new Tbddoanhnghiepky();
    this.Tbdphuongtien = ko.observableArray();
    this.Tbddinhkem = ko.observableArray();
}

var UserCustom = function () {
    this.companyAddress = ko.observable();
    this.companyEmail = ko.observable().extend({maxLength : 255 });
    this.companyFax = ko.observable().extend({maxLength : 255 });
    this.companyName = ko.observable();
    this.companyPhoneNumber = ko.observable();
    this.registrationNo = ko.observable();
    this.ssoId=ko.observable();
}

var Tbdgiayphep = function () {
    this.fiIdGiayPhep = ko.observable();
    this.fiIdTrangThai = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiSoGiayPhep = ko.observable();
    this.fiLyDoSua = ko.observable();
    this.fiLyDoRut = ko.observable();
    this.fiSoDangKy = ko.observable();
    this.fiNamSanXuat = ko.observable();
    this.fiMaNhanHieu = ko.observable();
    this.fiTenNhanHieu = ko.observable();
    this.fiLoaiXe = ko.observable();
    this.fiTruck = ko.observable();
    this.fiBus = ko.observable();
    this.fiOther = ko.observable();
    this.fiMauSon = ko.observable();
    this.fiSoMay = ko.observable();
    this.fiSoKhung = ko.observable();
    this.fiTenDonVi = ko.observable();
    this.fiDiaChi = ko.observable();
    this.fiTel = ko.observable();
    this.fiFax = ko.observable();
    this.fiTenCPT = ko.observable();
    this.fiDiachiCPT = ko.observable();
    this.fiTelCPT = ko.observable();
    this.fiFaxCPT = ko.observable();
    this.fiNgayHetHan = ko.observable();
    this.fiMaCuaKhau = ko.observable();
    this.fiTenCuaKhau = ko.observable();
    this.fiKhuVucHD = ko.observable();
    this.fiTuyenHD = ko.observable();
    this.fiVanTai = ko.observable();
    this.fiGhiChu = ko.observable();
    this.fiThoiGianGiaHan = ko.observable();
    this.fiTenNguoiKy = ko.observable();
    this.fiChucDanh = ko.observable();
    this.fiDiaDiemKy = ko.observable();
    this.fiNgayKy = ko.observable();
    this.fiNgayCapPhep = ko.observable();
    this.fiBienSo = ko.observable();
    this.fiTrongTai = ko.observable();
    this.isSelected = ko.observable(false);
    this.fiLinkGP = ko.observable();

    this.objectTypeDate = ['fiNgayKy', 'fiNgayCapPhep', 'fiNgayHetHan', 'fiThoiGianGiaHan'];
}
var Tbddoanhnghiepky = function () {
    this.fiDoanhNghiepKyId = ko.observable();
    this.fiTenNguoiKy = ko.observable().extend({required: {message: 'Tên người ký không được trống!'}}).extend({
        validation: [{
            validator: function (val, lenght) {
                return val && val.length <= lenght;
            },
            message: 'Tên người ký không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiChucDanh = ko.observable().extend({
        validation: [{
            validator: function (val, lenght) {
                return !val || val.length <= lenght;
            },
            message: 'Chức danh không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiDiaDiemKy = ko.observable().extend({required: {message: 'Địa điểm ký không được trống!'}}).extend({
        validation: [{
            validator: function (val, lenght) {
                return val && val.length <= lenght;
            },
            message: 'Địa điểm ký không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiNgayKy = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.objectTypeDate = ['fiNgayKy'];
}

var DateForm = function () {
    this.FROM = ko.observable(null);
    this.TO = ko.observable(null);
    this.objectTypeDate = ['FROM', 'TO'];
}