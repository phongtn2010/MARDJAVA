var Tbdphuongtien = function () {
    this.fiPhuongtienId = ko.observable();
    this.fiBienso = ko.observable('').extend({required: {message: 'Biển số xe không được trống!'}});
    this.fiChuphuongtien = ko.observable();
    this.fiBiensocu = ko.observable();
    this.fiKhoihang = ko.observable('').extend({required: {message: 'Trọng tải xe không được trống!'}});
    this.fiNamsanxuat = ko.observable('').extend({required: {message: 'Năm sản xuất không được trống!'}});
    this.fiDongphuongtien = ko.observable('').extend({required: {message: 'Nhãn hiệu xe không được trống!'}});
    this.fiSokhung = ko.observable('').extend({required: {message: 'Số khung không được trống!'}});
    this.fiSomay = ko.observable('').extend({required: {message: 'Số máy không được trống!'}});
    this.fiMausac = ko.observable('').extend({required: {message: 'Màu sơn không được trống!'}});
    this.fiTungay = ko.observable('').extend({required: {message: 'Từ ngày cấp phép không được trống!'}});
    this.fiDenngay = ko.observable('').extend({required: {message: 'Đến ngày cấp phép không được trống!'}});
    this.fiSocong = ko.observable('').extend({required: {message: 'Mã cửa khẩu xuất - nhập không được trống!'}});
    this.fiIdHoso = ko.observable();
    this.fiHinhthucHoatdong = ko.observable().extend({required: {message: 'Hình thức hoạt động không được trống!'}});
    this.objectTypeDate = ['fiTungay', 'fiDenngay'];
    this.editing = ko.observable(false);
    this.fiIdPhuongTien = ko.observable();
}


//var Tbsloaihinhvantai = function () {
//    this.fiIdHoso = ko.observable();
//    this.fixedRoadTransport = ko.observable();
//    this.contractRoadTransport = ko.observable();
//    this.passengerTransport = ko.observable();
//    this.cargoTransport = ko.observable();
//    this.passengerTaxi = ko.observable();
//    this.objectTypeDate = [];
//}

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
    this.fiFax = ko.observable('').extend({maxLength : 255 });
    this.fiGiayphepkinhdoanh = ko.observable('');
    this.fiNgaydangky = ko.observable();
    this.fiCoquancapphep = ko.observable();
    this.fiSochungchi = ko.observable();
    this.fiNgaycapchungchi = ko.observable();
    this.fiCoquancapchungchi = ko.observable();
    this.fiMucdich = ko.observable();
    this.fiLoaikinhdoanh = ko.observable();
    this.fiTinhdi = ko.observable();
    this.fiGadi = ko.observable();
    this.fiTinhden = ko.observable();
    this.fiGaden = ko.observable();
    this.fiQuangduong = ko.observable();
    this.fiMatuyen = ko.observable();
    this.fiMotatuyen = ko.observable();
    this.fiSogiaytochapthuan = ko.observable();
    this.fiNgaychapthuan = ko.observable();
    this.fiCuakhau = ko.observable();
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
    this.fiEmail = ko.observable().extend({maxLength : 255 });
    this.objectTypeDate = ['fiNgaydangky', 'fiNgaycapchungchi', 'fiNgaytao', 'fiNgaycapphep', 'fiNgaygui',
        'fiNgaynhan', 'fiNgaychapthuan', 'fiNgayketthuc'];
}

var HosoChiTietModel = function () {
    this.Tbdhoso = new Tbdhoso();
   this.TbdGiaHan = new TbdGiaHan();
//    this.Tbsloaihinhvantai = new Tbsloaihinhvantai();
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
    this.fiIdGiayphep = ko.observable();
    this.fiSoGiayphep = ko.observable();
    this.fiLoaigiayphepId = ko.observable();
    this.fiDiachiDoanhnghiep = ko.observable();
    this.fiFax = ko.observable();
    this.fiDienthoai = ko.observable();
    this.fiEmail = ko.observable();
    this.fiWebsite = ko.observable();
    this.fiNgayhethan = ko.observable();
    this.fiLoaihinhvantai = ko.observable();
    this.fiCappheptungay = ko.observable();
    this.fiCapphepdenngay = ko.observable();
    this.fiNgayky = ko.observable();
    this.fiNguoiky = ko.observable();
    this.fiChuky = ko.observable();
    this.fiCuakhau = ko.observable();
    this.fiNgaygiahan = ko.observable();
    this.fiGhichugiahan = ko.observable();
    this.fiIdHoso = ko.observable();
    this.fiTrangthai = ko.observable();
    this.fiLydosua = ko.observable();
    this.fiLydorut = ko.observable();
    this.fiLinkGiayphep = ko.observable();
    this.fiNoiden=ko.observable();
    this.fiCuakhau=ko.observable();
    this.fiVunghoatdong=ko.observable();
    this.fiNoiky = ko.observable();
    this.fiChucdanh = ko.observable();
    this.fiBienso = ko.observable();
    this.fiBiensocu = ko.observable();
    this.fiChuphuongtien = ko.observable();
    this.fiTenNhanhieu = ko.observable();
    this.fiIdGiayphep = ko.observable();
    this.fiIdHoso = ko.observable();
    this.fiKhoihang = ko.observable();
    this.fiLoaiphuongtien = ko.observable();
    this.fiMaNhanhieu = ko.observable();
    this.fiMausac = ko.observable();
    this.fiModel = ko.observable();
    this.fiNamsanxuat = ko.observable();
    this.fiSocong = ko.observable();
    this.fiSokhung = ko.observable();
    this.fiSomay = ko.observable();
    this.fiLoaixe=ko.observable();
    this.objectTypeDate = ['fiNgaydangky', 'fiNgayhethan', 'fiCappheptungay', 'fiNgaycaphethan', 'fiNgayky',
        'fiNgaygiahan'];
}

var Tbdgiayphepgiahan = function () {	
	this.fiIdGiayphep = ko.observable(); 
    this.fiIdHoso = ko.observable(); 
    this.fiSoDangKyPhuongTien= ko.observable();
    this.fiNgayNhapCanh= ko.observable();
    this.fiSoGiayPhepPhuongTien= ko.observable(); 
    this.fiNoiCapSoGPPhuongTien= ko.observable(); 
    this.fiHieuLucSoGPPhuongTienTuNgay= ko.observable(); 
    this.fiHieuLucSoGPPhuongTienDenNgay= ko.observable(); 
    this.fiLyDoGiaHan= ko.observable(); 
    this.fiLoaiGiaHan= ko.observable(); 
    this.fiSoGiaHan= ko.observable(); 
    this.fiGiaHanTuNgay= ko.observable(); 
    this.fiGiaHanDenNGay= ko.observable(); 
    this.fiWebsite= ko.observable(); 
    this.fiGiayphepkinhdoanh= ko.observable(); 
    this.fiNgaydangky= ko.observable(); 
    this.fiCoquancapphep= ko.observable(); 
    this.objectTypeDate = ['fiNgayNhapCanh','fiHieuLucSoGPPhuongTienTuNgay', 'fiHieuLucSoGPPhuongTienDenNgay', 'fiGiaHanTuNgay', 'fiGiaHanDenNGay', 'fiNgaydangky'];
	
}
var Tbdgiayphepdinhkem = function () {	
	this.fiDinhkemId= ko.observable();
	this.fiMadinhkem= ko.observable();
	this.fiTenDinhkem= ko.observable();
	this.fiGhichudinhkem= ko.observable();
    this.fiDuongdandinhkem= ko.observable();
    this.fiTenFile= ko.observable();
    this.fiUrlDinhkem= ko.observable();
    this.fiSothutu= ko.observable();
    this.fiTrangthai= ko.observable();
    this.fiIdGiayphep= ko.observable();
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
    this.fiChucdanh = ko.observable().extend({
        validation: [{
            validator: function (val, lenght) {
                return !val || val.length <= lenght;
            },
            message: 'Chức danh không được vượt quá 255 ký tự',
            params: 255
        }]
    });
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

var TbdGiaHan = function(){
	self = this;
   this.fiIdHoso=ko.observable() ;
  
   this.fiSoDangKyPhuongTien = ko.observable().extend({required: {message: 'Số đăng ký không được trống!'}}).extend({
       validation: [{
           validator: function (val, lenght) {
               return val && val.length <= lenght;
           },
           message: 'Số đăng ký không được vượt quá 255 ký tự',
           params: 255
       }]
   });
   this.fiSoGiayPhepPhuongTien = ko.observable().extend({required: {message: 'Số giấy phép không được trống!'}}).extend({
       validation: [{
           validator: function (val, lenght) {
               return val && val.length <= lenght;
           },
           message: 'Số giấy phép không được vượt quá 255 ký tự',
           params: 255
       }]
   });
   
   this.fiNoiCapSoGPPhuongTien = ko.observable().extend({required: {message: 'Nơi cấp không được trống!'}}).extend({
       validation: [{
           validator: function (val, lenght) {
               return val && val.length <= lenght;
           },
           message: 'Nơi cấp không được vượt quá 500 ký tự',
           params: 500
       }]
   });
   this.fiLyDoGiaHan = ko.observable().extend({required: {message: 'Lý do gia hạn không được trống!'}}).extend({
       validation: [{
           validator: function (val, lenght) {
               return val && val.length <= lenght;
           },
           message: 'Lý do không được vượt quá 500 ký tự',
           params: 500
       }]
   });
   this.fiSoGiaHan = ko.observable().extend({required: {message: 'Số gia hạn không được trống!'}}).extend({
       validation: [{
           validator: function (val, lenght) {
               return val && val.length <= lenght;
           },
           message: 'Số gia hạn không được vượt quá 255 ký tự',
           params: 255
       }]
   });
   this.fiLoaiGiaHan = ko.observable("0");

   this.fiNgayNhapCanh = ko.observable('').extend({
       required: {
           message: 'Ngày nhập cảnh không được trống!'
          
       }
   });
   
   this.fiGiaHanDenNGay = ko.observable('').extend({
       required: {
           message: 'Thời gian gia hạn không được trống!'
        }
           
   });
   this.fiGiaHanTuNgay = ko.observable('').extend({
       required: {
           message: 'Thời gian gia hạn không được trống!'
          
       }
   });
   this.fiHieuLucSoGPPhuongTienTuNgay = ko.observable('').extend({
       required: {
           message: 'Ngày cấp không được trống!'
          
       }
   });
   this.fiHieuLucSoGPPhuongTienDenNgay = ko.observable();
  // this.fiHieuLucSoGPPhuongTienTuNgay = ko.observable();
   
   this.objectTypeDate = ['fiNgayNhapCanh', 'fiHieuLucSoGPPhuongTienTuNgay', 'fiHieuLucSoGPPhuongTienDenNgay', 'fiGiaHanTuNgay', 'fiGiaHanDenNGay'];
  
}
