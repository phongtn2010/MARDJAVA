var Tbdphuongtien = function () {
    this.fiPhuongtienId = ko.observable();
    this.fiBienso = ko.observable();
    this.fiChuphuongtien = ko.observable();
    this.fiBiensocu = ko.observable();
    this.fiKhoihang = ko.observable();
    this.fiNamsanxuat = ko.observable();
    this.fiDongphuongtien = ko.observable();
    this.fiSokhung = ko.observable();
    this.fiSomay = ko.observable();
    this.fiMausac = ko.observable();
    this.fiTungay = ko.observable();
    this.fiDenngay = ko.observable();
    this.fiSocong = ko.observable();
    this.fiIdHoso = ko.observable();
    this.fiHinhthucHoatdong = ko.observable();
    this.objectTypeDate = ['fiTungay', 'fiDenngay'];
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
    this.fiIdDinhkem = ko.observable();
    this.fiTailieuId = ko.observable();
    this.fiIdHoso = ko.observable();
    this.fiTenDinhkem = ko.observable();
    this.fiMaDinhkem = ko.observable();
    this.fiTenFile = ko.observable();
    this.fiGhichu = ko.observable();
    this.fiDuongdan = ko.observable();
    this.fiUrlDinhkem = ko.observable();
    this.fiSothutu = ko.observable();
    this.fiTrangthai = ko.observable();
    this.objectTypeDate = [];
}

var Tbddanhmucfile = function(fiIdDanhMuc, fiMaDanhMuc, fiTenDanhMuc){
    this.fiIdDanhmuc = ko.observable(fiIdDanhMuc);
    this.fiMaDanhmuc = ko.observable(fiMaDanhMuc);
    this.fiTenDanhmuc = ko.observable(fiTenDanhMuc);
}

var Tbdhoso = function () {
    self = this;
    this.fiIdHoso = ko.observable();
    this.fixedRoadTransport = ko.observable();
    this.fiIdBophan = ko.observable().extend({required: {message: 'Đơn vị không được trống!'}});
    this.fiTenbophan = ko.observable();
    this.fiTendoanhnghiep = ko.observable();
    this.fiMatinh = ko.observable();
    this.fiMahuyen = ko.observable();
    this.fiMaphuong = ko.observable();
    this.fiDiachi = ko.observable();
    this.fiDienthoai = ko.observable();
    this.fiFax = ko.observable('');
    this.fiGiayphepkinhdoanh = ko.observable('').extend({required: {message: 'Giấy phép không được trống!'}}).extend({
        validation: [{
            validator: function (val, lenght) {
                return val && val.length <= lenght;
            },
            message: 'Giấy phép không được vượt quá 255 ký tự',
            params: 255
        }]
    }).extend({
        pattern: {
            message: 'Giấy phép không được chưa ký tự đặc biệt',
            params: '[a-zA-Z0-9]+$'
        }
    });
    this.fiNgaydangky = ko.observable().extend({required: {message: 'Ngày cấp phép không được trống!'}});
    this.fiCoquancapphep = ko.observable();
    this.fiSochungchi = ko.observable();
    this.fiNgaycapchungchi = ko.observable();
    this.fiCoquancapchungchi = ko.observable();
    this.fiMucdich = ko.observable();
    this.fiLoaikinhdoanh = ko.observable();
    this.fiTinhdi = ko.observable().extend({
        required: {
            message: 'Tỉnh đi không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiGadi = ko.observable().extend({
        required: {
            message: 'Bến xe đi không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiTinhden = ko.observable().extend({
        required: {
            message: 'Tỉnh đến không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiGaden = ko.observable().extend({
        required: {
            message: 'Bến xe đến không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiQuangduong = ko.observable().extend({
        required: {
            message: 'Khoảng cách không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiMatuyen = ko.observable().extend({
        required: {
            message: 'Tuyến vận tải không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiMotatuyen = ko.observable();
    this.fiSogiaytochapthuan = ko.observable().extend({
        required: {
            message: 'Công văn không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    }).extend({
        validation: [{
            validator: function (val, lenght) {
                return !self.fixedRoadTransport() || (val && val.length <= lenght);
            },
            message: 'Cơ quan cấp phép không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiNgaychapthuan = ko.observable().extend({
        required: {
            message: 'Ngày cấp phép không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiCuakhau = ko.observable().extend({
        required: {
            message: 'Cửa khẩu đến không được trống!',
            onlyIf: function () {
                return self.fixedRoadTransport();
            }
        }
    });
    this.fiNgayketthuc = ko.observable();
    this.fiThutucId = ko.observable();
    this.fiTenThutuc = ko.observable();
    this.fiNguoitao = ko.observable();
    this.fiManguoitao = ko.observable();
    this.fiTrangthai = ko.observable();
    this.fiTenTrangthai = ko.observable();
    this.fiNgaytao = ko.observable();
    this.fiNgaycapphep = ko.observable();
    this.fiNgaygui = ko.observable();
    this.fiNgaynhan = ko.observable();
    this.fiMaHoso = ko.observable();
    this.fiIdGiayphep = ko.observable();
    this.fiLydorut = ko.observable();
    this.fiLoaihinh = ko.observable();
    this.fiLydocaplai = ko.observable();
    this.fiLydorut = ko.observable();
    this.fiLoaihoso = ko.observable();
    this.fiWebsite = ko.observable();
    this.fiNhomthutuc = ko.observable();
    this.fiSogiayphep = ko.observable();
    this.fiEmail = ko.observable();
    this.objectTypeDate = ['fiNgaydangky', 'fiNgaycapchungchi', 'fiNgaytao', 'fiNgaycapphep', 'fiNgaygui',
        'fiNgaynhan', 'fiNgaychapthuan', 'fiNgayketthuc'];
}

var HosoChiTietModel = function () {
    this.Tbdhoso = new Tbdhoso();
    this.Tbsloaihinhvantai = new Tbsloaihinhvantai();
    this.Tbddoanhnghiepky = new Tbddoanhnghiepky();
    this.Tbdphuongtien = ko.observableArray(0);
    this.Tbddinhkem = ko.observableArray(0);
}

var UserCustom = function () {
    this.companyAddress = ko.observable();
    this.companyEmail = ko.observable();
    this.companyFax = ko.observable();
    this.companyName = ko.observable();
    this.companyPhoneNumber = ko.observable();
    this.registrationNo = ko.observable();
}

var Tbdgiayphep = function () {
    this.fiIdGiayphep = ko.observable();
    this.fiSoGiayphep = ko.observable();
    this.fiLoaigiayphepId = ko.observable();
    this.fiTenDoanhnghiep = ko.observable();
    this.fiDiachiDoanhnghiep = ko.observable();
    this.fiFax = ko.observable();
    this.fiDienthoai = ko.observable();
    this.fiEmail = ko.observable();
    this.fiWebsite = ko.observable();
    this.fiGiayphepkinhdoanh = ko.observable();
    this.fiNgaydangky = ko.observable();
    this.fiNgayhethan = ko.observable();
    this.fiLoaihinhvantai = ko.observable();
    this.fiNgaycapphep = ko.observable();
    this.fiNgaycaphethan = ko.observable();
    this.fiNgayky = ko.observable();
    this.fiNguoiky = ko.observable();
    this.fiChuky = ko.observable();
    this.fiCuakhau = ko.observable();
    this.fiTuyenkhuvuc = ko.observable();
    this.fiDiemdentuyen = ko.observable();
    this.fiGadi = ko.observable();
    this.fiGaden = ko.observable();
    this.fiTinhdi = ko.observable();
    this.fiTinhden = ko.observable();
    this.fiNThietbithaythe = ko.observable();
    this.fiNgaygiahan = ko.observable();
    this.fiGhichugiahan = ko.observable();
    this.fiNThietbicuoi = ko.observable();
    this.fiIdHoso = ko.observable();
    this.fiTrangthai = ko.observable();
    this.fiLyDo = ko.observable();
    this.fiLinkGiayphep= ko.observable();
    this.fiNoiky = ko.observable();
    this.fiChucdanh = ko.observable();
    this.objectTypeDate = ['fiNgaydangky', 'fiNgayhethan', 'fiNgaycapphep', 'fiNgaycaphethan', 'fiNgayky',
        'fiNgaygiahan'];
}

var Tbddoanhnghiepky = function () {
    this.fiDoanhnghiepKyId = ko.observable();
    this.fiTenNguoiKy = ko.observable().extend({required: {message: 'Tên người ký không được trống!'}}).extend({
        validation: [{
            validator: function (val, lenght) {
                return val && val.length <= lenght;
            },
            message: 'Tên người ký không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiChucdanh = ko.observable();
    this.fiDiadiemKy = ko.observable().extend({required: {message: 'Địa điểm ký không được trống!'}}).extend({
        validation: [{
            validator: function (val, lenght) {
                return val && val.length <= lenght;
            },
            message: 'Địa điểm ký không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiNgayKy = ko.observable();
    this.fiIdHoso = ko.observable();
    this.objectTypeDate = ['fiNgayKy'];
}

var DateForm = function () {
    this.FROM = ko.observable(null);
    this.TO = ko.observable(null);
    this.objectTypeDate = ['FROM', 'TO'];
}