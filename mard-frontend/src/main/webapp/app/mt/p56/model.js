var Tbddanhmucfile = function(fiIdDanhMuc, fiMaDanhMuc, fiTenDanhMuc){
	this.fiIdDanhmuc = ko.observable(fiIdDanhMuc);
    this.fiMaDanhmuc = ko.observable(fiMaDanhMuc);
    this.fiTenDanhmuc = ko.observable(fiTenDanhMuc);
}
var Tbdphuongtien = function () {
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
    this.fiCuaKhau = ko.observable().extend({required: {message: 'Mã cửa khẩu xuất - nhập không được trống!'}});
    this.fiIdHoSo = ko.observable();
    this.fiStt = ko.observable();
    this.fiHinhThucHD = ko.observable().extend({required: {message: 'Hình thức hoạt động không được trống!'}});
    this.objectTypeDate = ['fiTuNgay', 'fiDenNgay'];
    this.editing = ko.observable(false);
}

var Tbsloaihinhvantai = function () {
    this.fiIdHoso = ko.observable();
    this.fixedRoadTransport = ko.observable(true);
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
    self = this;
    this.fiTenTrangThai = ko.observable();
    this.fiMaTuyen = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiSoGiayTo = ko.observable();
    this.fiIdCqxl = ko.observable().extend({required: {message: 'Đơn vị không được trống!'}});
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
    this.fiBenDi = ko.observable();
    this.fiMaTinhDi = ko.observable();
    this.fiTenTinhDi = ko.observable();
    this.fiBenDen = ko.observable();
    this.fiMaTinhDen = ko.observable();
    this.fiTenTinhDen = ko.observable();
    this.fiCuLy = ko.observable();
    this.fiHanhTrinh = ko.observable();
    this.fiCoQuanCapPhep = ko.observable();
    this.fiSoCongVan = ko.observable();
    this.fiNgayCapCongVan = ko.observable();
    this.fiDiaDiem = ko.observable();
    this.fiTenTuyen = ko.observable();
    this.fiNgayTao = ko.observable();
    this.fiNgayGui = ko.observable();
    this.fiTenNguoiKy = ko.observable();
    this.fiChucDanh = ko.observable();
    this.fiDiaDiemKy = ko.observable();
    this.fiNgayCapPhep = ko.observable();
    this.fiNgayDangKy = ko.observable();
    this.objectTypeDate = ['fiNgayDangKy', 'fiNgaycapchungchi', 'fiNgayTao', 'fiNgayCapCongVan', 'fiNgayGui',
        'fiNgaynhan', 'fiNgaychapthuan', 'fiNgayCapPhep', 'fiNgayKy'];
     
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
    this.fiIdHoSo = ko.observable();
    this.fiLyDoSua = ko.observable();
    this.fiLyDoRut = ko.observable();
    this.fiSoVanBan = ko.observable();
    this.fiTenDoanhNghiep = ko.observable();
    this.fiTenNguoiKy = ko.observable();
    this.fiChucDanh = ko.observable();
    this.fiDiaDiemKy = ko.observable();
    this.fiNgayKy = ko.observable();
    this.fiLinkGiayPhep=ko.observable();
    this.objectTypeDate = ['fiNgayKy'];
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
var Tbsmucdichchuyendi = function () {
    this.fiIdHoso = ko.observable();
    this.fiCongvu = ko.observable();
    this.fiKinhdoanh = ko.observable();
    this.fiCanhan = ko.observable();
    this.fiKhac = ko.observable();
    this.objectTypeDate = [];
}
var DateForm = function () {
    this.FROM = ko.observable(null);
    this.TO = ko.observable(null);
    this.objectTypeDate = ['FROM', 'TO'];
}