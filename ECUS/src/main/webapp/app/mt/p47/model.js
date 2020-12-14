
var Tbddanhmucfile = function(fiIdDanhMuc, fiMaDanhMuc, fiTenDanhMuc){
	this.fiIdDanhmuc = ko.observable(fiIdDanhMuc);
    this.fiMaDanhmuc = ko.observable(fiMaDanhMuc);
    this.fiTenDanhmuc = ko.observable(fiTenDanhMuc);
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
//var Tbsloaihinhvantai = function () {
//    this.fiIdHoso = ko.observable();
//    this.fixedRoadTransport = ko.observable();
//    this.contractRoadTransport = ko.observable();
//    this.passengerTransport = ko.observable();
//    this.cargoTransport = ko.observable();
//    this.passengerTaxi = ko.observable();
//    this.objectTypeDate = [];
//}

var Tbdhoso = function () {
    this.fiIdHoso = ko.observable();
    this.fiIdBophan = ko.observable().extend({required: {message: 'Đơn vị không được trống!'}});
    this.fiTenbophan = ko.observable();
    this.fiTendoanhnghiep = ko.observable();
    this.fiMatinh = ko.observable();
    this.fiMahuyen = ko.observable();
    this.fiMaphuong = ko.observable();
    this.fiDiachi = ko.observable();
    this.fiDienthoai = ko.observable();
    this.fiFax = ko.observable();
    this.fiGiayphepkinhdoanh = ko.observable();
    this.fiNgaydangky = ko.observable();
    this.fiCoquancapphep = ko.observable();
    this.fiSochungchi = ko.observable();
    this.fiNgaycapchungchi = ko.observable();
    this.fiCoquancapchungchi = ko.observable();
    this.fiMucdich = ko.observable();
    this.fiLoaikinhdoanh = ko.observable();
    this.fiMatuyen = ko.observable();
    this.fiMotatuyen = ko.observable();
    this.fiSogiaytochapthuan = ko.observable();
    this.fiNgaychapthuan = ko.observable();
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
    this.fiWebsite = ko.observable().extend({
        validation: [{
            validator: function (val, lenght) {
                return !val || val.length <= lenght;
            },
            message: 'Website không được vượt quá 255 ký tự',
            params: 255
        }]
    });
    this.fiNhomthutuc = ko.observable();
    this.fiSogiayphep = ko.observable();
    this.fiEmail = ko.observable();
    this.objectTypeDate = ['fiNgaydangky', 'fiNgaycapchungchi', 'fiNgaytao', 'fiNgaycapphep', 'fiNgaygui',
        'fiNgaynhan', 'fiNgaychapthuan', 'fiNgayketthuc'];
}

var HosoChiTietModel = function () {
    this.Tbdhoso = new Tbdhoso();
   // this.Tbsloaihinhvantai = new Tbsloaihinhvantai();
    this.Tbddoanhnghiepky = new Tbddoanhnghiepky();
    this.Tbddinhkem = ko.observableArray(0);
    this.TbdGiaHan = new TbdGiaHan();
}

var UserCustom = function () {
    this.companyAddress = ko.observable();
    this.companyEmail = ko.observable();
    this.companyFax = ko.observable();
    this.companyName = ko.observable();
    this.companyPhoneNumber = ko.observable();
    this.registrationNo = ko.observable();
    this.ssoId = ko.observable();
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
    this.fiLinkGiayphep = ko.observable();
    this.fiNoiky = ko.observable();
    this.fiChucdanh = ko.observable();
    this.objectTypeDate = ['fiNgaydangky', 'fiNgayhethan', 'fiNgaycapphep', 'fiNgaycaphethan', 'fiNgayky',
        'fiNgaygiahan'];
}
var Tbdgiayphepgiahan = function () {		
	this.fiIdHoso= ko.observable();
	this.fiLoaiGiayPhep= ko.observable();
	this.fiNgayHetHanGPVT= ko.observable();
	this.fiSoNgayGiaHan= ko.observable();
	this.fiGiaHanTuNgay= ko.observable();
	this.fiGiaHanDenNGay= ko.observable();
    this.fiLyDoGiaHan= ko.observable();
    this.fiWebsite= ko.observable();
    this.fiGiayphepkinhdoanh= ko.observable();
    this.fiNgaydangky= ko.observable();
    this.fiCoquancapphep= ko.observable();
	
    this.objectTypeDate = ['fiNgaydangky','fiGiaHanTuNgay', 'fiGiaHanDenNGay', 'fiGiaHanTuNgay', 'fiNgayHetHanGPVT'];
	
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


var TbdGiaHan= function(){
		this.fiIdHoso = ko.observable();
	  
	    this.fiSoNgayGiaHan = ko.observable().extend({required: {message: 'Số ngày gia hạn không được trống!'}}).extend({
	        validation: [{
	            validator: function (val, lenght) {
	                return val && val.length <= lenght;
	            },
	            message: 'Số  ngày gia hạn không được vượt quá 255 ký tự',
	            params: 255
	        }]
	    });
	    this.fiLyDoGiaHan = ko.observable().extend({required: {message: 'Lý do không được trống!'}}).extend({
	        validation: [{
	            validator: function (val, lenght) {
	                return val && val.length <= lenght;
	            },
	            message: 'Lý do không được vượt quá 500 ký tự',
	            params: 500
	        }]
	    });
	    
	    this.fiLoaiGiayPhep = ko.observable().extend({required: {message: 'Loại giấy phép không được trống!'}}).extend({
	        validation: [{
	            validator: function (val, lenght) {
	                return val && val.length <= lenght;
	            },
	            message: 'Loại giấy phép không được vượt quá 255 ký tự',
	            params: 255
	        }]
	    });
	    this.fiNgayHetHanGPVT = ko.observable('').extend({
	        required: {
	            message: 'Ngày hết hạn GPVT không được trống!'
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
//	    this.fiNgayHetHanGPVT = ko.observable();
//		
//		this.fiGiaHanDenNGay = ko.observable();
//		this.fiGiaHanTuNgay = ko.observable();
		   
	    this.objectTypeDate = ['fiGiaHanTuNgay', 'fiGiaHanDenNGay', 'fiNgayHetHanGPVT'];
	
}
