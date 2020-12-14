function ThongTinChungModel() {

	this.idHS = ko.observable(0);

	this.enable = ko.observable(true);

	this.maCoQuan = ko.observable('-1').extend({
		required : true,
		maxLength : 50
	});
	
	this.maSoThue = ko.observable('');
	this.tenNganHang = ko.observable('');
	this.maChiNhanh = ko.observable('');
	this.diaChi = ko.observable('');
	this.dienThoai = ko.observable('');
	this.fax = ko.observable('');
	this.ngayTao = ko.observable();
	this.tenTrangThai = ko.observable('');

	this.valid = ko.validatedObservable({

		maCoQuan : this.maCoQuan,
	});
	
	
}

function ThongTinNgoaiTeModel() {

	this.hinhThucXNK = ko.observable('1');
	this.maCuaKhau = ko.observable().extend({
		required : true,
		maxLength : 20
	});
	this.xuatNhapKhauTuNgay = ko.observable('').extend({
		required : true,
	});
	this.xuatNhapKhauDenNgay = ko.observable('').extend({
		required : true,
	});
	this.capGiayPhepLanDau = ko.observable(true);
	
	this.soGiayPhepDaCap = ko.observable('').extend({
		maxLength : 20
	});
	this.doiTacXuatNhapKhau = ko.observable('').extend({
		required : true,
		maxLength : 255
	});

	this.valid = ko.validatedObservable({

		maCuaKhau : this.maCuaKhau,
		xuatNhapKhauTuNgay : this.xuatNhapKhauTuNgay,
		xuatNhapKhauDenNgay : this.xuatNhapKhauDenNgay,
		capPhepLanDau : this.capPhepLanDau,
		soGiayPhep : this.soGiayPhep,
		doiTacXuatNhapKhau : this.doiTacXuatNhapKhau,
	});
	
	this.ghiChu = ko.observable('').extend({
		maxLength : 2000
	});;
}

function ThongTinTienTeModel() {

	this.soThuTu = ko.observable(1);
	this.idHoSo = ko.observable(0);
	this.idTienTe = ko.observable(0);
	this.soLuongNgoaiTeBangSo = ko.observable('').extend({
		required : true,
		maxLength : 255
	});
	this.soLuongNgoaiTeBangChu = ko.observable('').extend({
		required : true,
		maxLength : 255
	});
	this.maLoaiTienTe = ko.observable('-1').extend({
		required : true,
		maxLength : 255
	});
	
	this.enable = ko.observable(true);
	this.isDelete = ko.observable(false);
	this.isUpdate = ko.observable(false);
	this.isCreate = ko.observable(true);
	this.ghiChu = ko.observable('');

	this.valid = ko.validatedObservable({
		soLuongNgoaiTeBangSo : this.soLuongNgoaiTeBangSo,
		soLuongNgoaiTeBangChu : this.soLuongNgoaiTeBangChu,
		maLoaiTienTe: this.maLoaiTienTe
	});
}

function TepTinModel() {

	this.idTepTin = ko.observable(0);
	this.idHoSo = ko.observable(0);
	this.guID = ko.observable();
	this.duongDanFile = ko.observable('');
	this.tenTepDinhKem = ko.observable('');
	this.maLoaiTep = ko.observable('');
	this.loaiTep = ko.observable('');
	this.tenLoaiTepDinhKem = ko.observable('');
	this.fileCode = ko.observable('');
	this.link = ko.observable('');
	this.xemHoSo = ko.observable(false);
	this.size = ko.observable(0);
}

function GiayXacNhanModel() {

	this.soGXNDaCap = ko.observable('').extend({
		required : true,
		maxLength : 20
	});

	this.ngayCap = ko.observable('').extend({
		required : true,
		maxLength : 16
	});

	this.ngayHetHan = ko.observable('').extend({
		required : true,
		maxLength : 16
	});

	this.lyDo = ko.observable('').extend({
		required : true,
		maxLength : 500
	});

	this.exists = ko.observable(false);

	this.valid = ko.validatedObservable({
		soGXNDaCap : this.soGXNDaCap,
		ngayCap : this.ngayCap,
		ngayHetHan : this.ngayHetHan,
		lyDo : this.lyDo
	});
}

function HoSoModel() {

	this.soThuTu = ko.observable();
	this.idHoSo = ko.observable();
	this.maHoSo = ko.observable();
	this.tenNganHang = ko.observable();
	this.ngayTao = ko.observable();
	this.hinhThucXNK = ko.observable();
	this.tenTrangThai = ko.observable();
	this.trangThai = ko.observable();
	this.soGiayPhep = ko.observable();
	this.ngayCap = ko.observable();
	this.showButtonEdit = ko.observable(false);
	this.showButtonDelete = ko.observable(false);
	this.showButtonXemGXN = ko.observable(false);
	this.showButtonXinRut = ko.observable(false);
	this.showButtonSend = ko.observable(false);
	this.showButtonVanBan = ko.observable(false);
}