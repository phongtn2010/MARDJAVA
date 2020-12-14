function ThongTinChungModel() {
	
	this.maSoThue = ko.observable('').extend({
		required : true,
		maxLength : 13
	});
	this.tenDoanhNghiep = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.diaChiDoanhNghiep = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.dienThoai = ko.observable('').extend({
		required : true,
		maxLength : 50
	});
	this.fax = ko.observable('').extend({
		maxLength : 50,
		required : true,
	});
	this.email = ko.observable('').extend({
		email : true,
		required : true,
		maxLength : 250
	});
	this.loaiHinh = ko.observable('-1').extend({
		required : true,
	});
	this.noiCapGDKKD  = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.soGiayChungNhanDKKD  = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.ngayCapGiayChungNhan = ko.observable('').extend({
		required : true,
		maxLength : 10
	});
	this.diaChiSanXuat = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.soGiayPhepTCTN = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.ngayCapGiayPhepTCTN = ko.observable('').extend({
		maxLength : 10
	});
	this.ngayCapGiayPhep = ko.observable('').extend({
		required : true,
		maxLength : 10
	});
	this.loaiGiayPhep = ko.observable(-1).extend({
		required : true,
	});
	this.soGiayPhepDaCap = ko.observable('').extend({
		maxLength : 50
	});
	this.soGiayPhepTCTN = ko.observable('').extend({
		maxLength : 50
	});
	this.lyDoGiaHan = ko.observable('').extend({
		maxLength : 2000
	});
	this.xemHoSo = ko.observable(false);
	
	
	this.dienThoaiNoiSanXuat = ko.observable('').extend({
		required : true,
		maxLength : 50
	});
	this.dienThoaiNguoiLienHe = ko.observable('').extend({
		required : true,
		maxLength : 50
	});

	this.faxNoiSanXuat = ko.observable('').extend({
		required : true,
		maxLength : 50
	});
	this.tenNguoiDaiDien = ko.observable('').extend({
		required : true,
		maxLength : 100
	});
	this.tenNguoiLienHe = ko.observable('').extend({
		required : true,
		maxLength : 100
	});
	this.emailNguoiLienHe = ko.observable('').extend({
		maxLength : 100,
		required : true,
		email: true
	});
	this.hinhThucXNK = ko.observable('').extend({
		required : true,
	});
	this.maTinhTP = ko.observable('-1').extend({
		required : true,
	});
	this.valid = ko.validatedObservable({
		maSoThue : this.maSoThue,
		tenDoanhNghiep : this.tenDoanhNghiep,
		diaChiDoanhNghiep : this.diaChiDoanhNghiep,
		dienThoai : this.dienThoai,
		fax : this.fax,
		email : this.email,
		soGiayChungNhanDKKD : this.soGiayChungNhanDKKD,
		ngayCapGiayChungNhan : this.ngayCapGiayChungNhan,
		diaChiSanXuat : this.diaChiSanXuat,
		soGiayPhepTCTN : this.soGiayPhepTCTN,
		ngayCapGiayPhepTCTN : this.ngayCapGiayPhepTCTN,
		loaiGiayPhep : this.loaiGiayPhep,
		dienThoaiNoiSanXuat: this.dienThoaiNoiSanXuat,
		dienThoaiNguoiLienHe: this.dienThoaiNguoiLienHe,
		faxNoiSanXuat: this.faxNoiSanXuat,
		tenNguoiDaiDien: this.tenNguoiDaiDien,
		tenNguoiLienHe: this.tenNguoiLienHe,
		emailNguoiLienHe: this.emailNguoiLienHe,
		hinhThucXNK: this.hinhThucXNK,
		noiCapGDKKD : this.noiCapGDKKD 
	});
}

function ThongTinHangHoaModel() {
	this.mucDich = ko.observable('').extend({
		maxLength : 2000
	});
	this.cuaKhaus = ko.observableArray([]);
	this.phuongTiens = ko.observableArray([]);
	this.haiQuans = ko.observableArray([]);
	this.xuatNhapKhauTuNgay = ko.observable('');
	this.xuatNhapKhauDenNgay = ko.observable('');
	this.soLanThucHien = ko.observable('').extend({
		maxLength : 250
	});
	this.xemHoSo = ko.observable(false);
	this.valid = ko.validatedObservable({
		mucDich : this.mucDich,
		soLanThucHien : this.soLanThucHien,
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
	this.tenDoanhNghiep = ko.observable();
	this.ngayNop = ko.observable();
	this.ngayCapGiayPhep = ko.observable();
	this.tenTrangThai = ko.observable();
	this.trangThai = ko.observable();
	this.showButtonEdit = ko.observable(false);
	this.showButtonDelete = ko.observable(false);
	this.showButtonXinRut = ko.observable(false);
	this.showButtonXemGXN = ko.observable(false);
	this.showButtonXinSua = ko.observable(false);
	this.xemHoSo = ko.observable(false);
	this.maSoGP = ko.observable('');
}

function HangHoaModel() {
	this.idHangHoa = ko.observable(0);
	this.chiTiet = ko.observable('');
	this.idHoSo = ko.observable(0);
	this.soLuong = ko.observable('');
	this.soLuongHQ = ko.observable('');
	this.soLuongConLai = ko.observable('');
	this.donViTinh = ko.observable('');
	this.tenHangHoa = ko.observable('');
	this.tenTCTN = ko.observable('');
	this.hamLuong = ko.observable('');
	this.trangThai = ko.observable(-1);
	this.idCu = ko.observable(0);
	this.enable = ko.observable(true);
	this.update = ko.observable(false);
	this.xemHoSo = ko.observable(false);
}

function XinSuaHoSoModel(){
	this.lyDoSua = ko.observable('').extend({
		required : true,
		maxLength : 2000
	});
	this.xemHoSo = ko.observable(false);
	
	this.valid = ko.validatedObservable({
		lyDoSua : this.lyDoSua,
	});
}

function ChiTietHangHoaModel() {
	this.idHangHoa = ko.observable(0);
	this.code = ko.observable('-1');
	this.maCAS = ko.observable('');
	this.idHoSo = ko.observable(0);
	this.maHS = ko.observable('');
	this.congThucHoaHoc = ko.observable('');
	this.tenTiengAnh = ko.observable('');
	this.tenTiengViet = ko.observable('');
	this.tenKhoaHoc = ko.observable('');
	this.tenThuongMai = ko.observable('');
	this.maHonHop = ko.observable('');
	this.hamLuong = ko.observable('');
	this.soLuongHonHop = ko.observable('');
	this.trangThaiHangHoa = ko.observable(-1);
	this.tenTrangThaiHangHoa = ko.observable(-1);
	this.donViTinh = ko.observable(-1);
	this.moTa = ko.observable('');
	this.soLuong = ko.observable('');
	this.soLuongDaNhap = ko.observable('');
	this.soLuongConLai = ko.observable('');
	this.xoaMaCAS = ko.observable('');
	this.loaiTienChat = ko.observable('');
	this.idCu = ko.observable(0);
}

function CKModel() {
	this.idCuaKhau = ko.observable(0);
	this.tenCuaKhau = ko.observable('');
	this.maCuaKhau = ko.observable('');
	this.idHoSo = ko.observable('');
}

function PTModel() {
	this.tenPhuongTien = ko.observable('');
	this.loaiPhuongTien = ko.observable('');
	this.idPhuongTien = ko.observable(0);
	this.idHoSo = ko.observable(0);
}

function HQModel() {
	this.tenHaiQuan = ko.observable('');
	this.idHaiQuan = ko.observable('');
	this.maHaiQuan = ko.observable(0);
}
