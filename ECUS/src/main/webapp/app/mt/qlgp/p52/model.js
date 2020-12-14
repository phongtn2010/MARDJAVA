var Tbdphuongtien = function () {
    this.fiIdPhuongTien = ko.observable();
    this.fiBienSo = ko.observable().extend({required: {message: 'Biển số xe không được trống!'}});
    this.fiTenSoHuu = ko.observable();
    this.fiTrongTai = ko.observable().extend({required: {message: 'Trọng tải xe không được trống!'}});
    this.fiNamSanXuat = ko.observable().extend({required: {message: 'Năm sản xuất không được trống!'}});
    this.fiMaNhanHieu = ko.observable().extend({required: {message: 'Nhãn hiệu xe không được trống!'}});
    this.fiSoKhung = ko.observable().extend({required: {message: 'Số khung không được trống!'}});
    this.fiSoMay = ko.observable().extend({required: {message: 'Số máy không được trống!'}});
    this.fiMauSon = ko.observable().extend({required: {message: 'Màu sơn không được trống!'}});
    this.fiTuNgay = ko.observable().extend({required: {message: 'Từ ngày cấp phép không được trống!'}});
    this.fiDenNgay = ko.observable().extend({required: {message: 'Đến ngày cấp phép không được trống!'}});
    this.fiMaCuaKhau = ko.observable().extend({required: {message: 'Mã cửa khẩu xuất - nhập không được trống!'}});
    this.fiIdHoSo = ko.observable();
    this.fiHinhThucHD = ko.observable().extend({required: {message: 'Hình thức hoạt động không được trống!'}});
    this.objectTypeDate = ['fiTuNgay', 'fiDenNgay'];
    this.editing = ko.observable(false);
    this.fiStt = ko.observable();
}

var Tbsmucdichchuyendi = function () {
    this.fiIdHoSo = ko.observable();
    this.fiCongvu = ko.observable();
    this.fiDoanhnghiep = ko.observable();
    this.fiCanhan = ko.observable();
    this.fiKhac = ko.observable();
    this.objectTypeDate = [];
}

var Tbddinhkem = function () {
    this.fiIdDinhKem = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiTenChungTu = ko.observable();
    this.fiMaChungTu = ko.observable();
    this.fiTenFile = ko.observable();
    this.fiGhiChu = ko.observable();
    this.fiDuongDan = ko.observable();
    this.fiSoThuTu = ko.observable();
    this.fiTrangThai = ko.observable();
    this.objectTypeDate = [];
}

var Tbdhoso = function () {
    this.fiTenTrangThai = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiIdBoPhan = ko.observable().extend({required: {message: 'Đơn vị không được trống!'}});
    this.fiTenBoPhan = ko.observable();
    this.fiTenDoanhNghiep = ko.observable();
    this.fiMaTinh = ko.observable();
    this.fiMaHuyen = ko.observable();
    this.fiMaPhuong = ko.observable();
    this.fiDiaChi = ko.observable();
    this.fiDienThoai = ko.observable();
    // this.fiIdCqxl = ko.observable();
    this.fiFax = ko.observable('');
    this.fiCoQuanCap = ko.observable('').extend({required: {message: 'Cơ Quan cấp không được trống!'}}).extend({
        validation: [{
            validator: function (val, lenght) {
                return val && val.length <= lenght;
            },
            message: 'Cơ Quan cấp không được vượt quá 255 ký tự',
            params: 255
        }]
    }).extend({
        pattern: {
            message: 'Cơ Quan cấp không được chưa ký tự đặc biệt',
            params: '[A-Za-z0-9_]+'
        }
    });
    this.fiNgayTao = ko.observable();
    this.fiNgayDangKy = ko.observable().extend({required: {message: 'Ngày cấp phép không được trống!'}});
    this.fiCoquancapphep = ko.observable();
    this.fiSoChungChi = ko.observable();
    this.fiNgayCapChungChi = ko.observable();
    this.fiCoQuanCapChungChi = ko.observable();
    this.fiMucDich = ko.observable();
    this.fiLoaiKinhDoanh = ko.observable();
    this.fiTinhDi = ko.observable();
    this.fiGaDi = ko.observable();
    this.fiTinhDen = ko.observable();
    this.fiGaDen = ko.observable();
    this.fiQuangDuong = ko.observable();
    this.fiMaTuyen = ko.observable();
    this.fiMoTaTuyen = ko.observable();
    this.fiSoGiayToChapThuan = ko.observable();
    this.fiNgayChapThuan = ko.observable();
    this.fiNgayKetThuc = ko.observable();
    this.fiThuTucId = ko.observable();
    this.fiTenThuTuc = ko.observable();
    this.fiNguoiTao = ko.observable();
    this.fiMaNguoiTao = ko.observable();
    this.fiTrangThai = ko.observable();
    this.fiIdTrangThai = ko.observable();
    this.fiTenTrangthai = ko.observable();
    this.fiNgayCapPhep = ko.observable();
    this.fiNgayGui = ko.observable();
    this.fiNgayNhan = ko.observable();
    this.fiMaHoSo = ko.observable();
    this.fiIdGiayphep = ko.observable();
    this.fiLoaiHinh = ko.observable();
    this.fiLyDoCapLai = ko.observable();
    this.fiLyDoRut = ko.observable();
    this.fiLoaiHoSo = ko.observable();
    this.fiCuaKhau = ko.observable();
    this.fiSoGiayPhepKinhDoanh = ko.observable().extend({
        validation: [{
            validator: function (val, lenght) {
                return !val || val.length <= lenght;
            },
            message: 'Số Chứng Nhận kinh Doanh không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiNhomThutuc = ko.observable();
    this.fiSoGiayPhep = ko.observable();
    this.fiTenNguoiKy = ko.observable();
    this.fiChucDanh = ko.observable();
    this.fiDiaDiemKy = ko.observable();

    // this.fiEmail = ko.observable();
    this.objectTypeDate = ['fiNgayDangKy', 'fiNgayCapChungChi', 'fiNgayTao', 'fiNgayCapCongVan', 'fiNgayGui',
        'fiNgayNhan', 'fiNgayChapThuan', 'fiNgayKetThuc', 'fiNgayKy'];
}


var Tbddanhmucfile = function(fiIdDanhMuc, fiMaDanhMuc, fiTenDanhMuc){
    this.fiIdDanhmuc = ko.observable(fiIdDanhMuc);
    this.fiMaDanhmuc = ko.observable(fiMaDanhMuc);
    this.fiTenDanhmuc = ko.observable(fiTenDanhMuc);
}

var HosoChiTietModel = function () {
    this.Tbdhoso = new Tbdhoso();
    this.Tbsmucdichchuyendi = new Tbsmucdichchuyendi();
    this.Tbddoanhnghiepky = new Tbddoanhnghiepky();
    this.Tbdphuongtien = ko.observableArray();
    this.Tbddinhkem = ko.observableArray();
}

var UserCustom = function () {
    this.companyAddress = ko.observable();
    this.companyFax = ko.observable();
    this.companyName = ko.observable();
    this.companyPhoneNumber = ko.observable();
    this.registrationNo = ko.observable();
    this.ssoId=ko.observable();
}

var Tbdgiayphep = function () {
    this.fiIdGiayPhep = ko.observable();
    this.fiSoGiayPhep = ko.observable();
    this.fiLoaiGiayPhepId = ko.observable();
    this.fiDiaChiDoanhNghiep = ko.observable();
    this.fiFax = ko.observable();
    this.fiNgayHetHan = ko.observable();
    this.fiLoaiHinhvanTai = ko.observable();
    this.fiNgayCapPhep = ko.observable();
    this.fiNgayCapHetHan = ko.observable();
    this.fiNgayKy = ko.observable();
    this.fiNguoiKy = ko.observable();
    this.fiChuKy = ko.observable();
    this.fiCuaKhau = ko.observable();
    this.fiTuyenkhuvuc = ko.observable();
    this.fiDiemdentuyen = ko.observable();
    this.fiGaDi = ko.observable();
    this.fiGaDen = ko.observable();
    this.fiTinhDi = ko.observable();
    this.fiTinhDen = ko.observable();
    this.fiNThietBiThayThe = ko.observable();
    this.fiNgayGiaHan = ko.observable();
    this.fiGhichuGiahan = ko.observable();
    this.fiNThietbicuoi = ko.observable();
    this.fiIdHoSo = ko.observable();
    this.fiTrangthai = ko.observable();
    this.fiIdTrangThai = ko.observable();
    this.fiLyDo = ko.observable();
    this.fiLinkGP= ko.observable();
    this.objectTypeDate = ['fiNgayHetHan', 'fiNgayCapPhep', 'fiNgayCapHetHan', 'fiNgayKy',
        'fiNgayGiaHan'];
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