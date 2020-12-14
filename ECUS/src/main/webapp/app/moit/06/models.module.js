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
	this.soGiayChungNhanDKKD = ko.observable('').extend({
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

	this.maTinhTP = ko.observable('-1').extend({
		required : true,
	});
	this.noiCapGiayChungNhanDKKD = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.tenNguoiDaiDien = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.daiDienChucVu = ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	this.daiDienNamSinh = ko.observable('').extend({
		required : true,
	});
	
	this.daiDienGioiTinh = ko.observable('-1').extend({
		required : true,
		maxLength : 250
	});
	this.daiDienDiaChi = ko.observable('').extend({
		required : true,
		maxLength : 250
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
		maTinhTP : this.maTinhTP,
		noiCapGiayChungNhanDKKD : this.noiCapGiayChungNhanDKKD,
		tenNguoiDaiDien : this.tenNguoiDaiDien,
		daiDienChucVu : this.daiDienChucVu,
		daiDienNamSinh : this.daiDienNamSinh,
		daiDienGioiTinh : this.daiDienGioiTinh,
		daiDienDiaChi : this.daiDienDiaChi
	});
}

function ThongTinHangHoaModel() {
	this.mucDich = ko.observable('').extend({
		maxLength : 2000
	});
	this.cuaKhaus = ko.observableArray([]);
	this.phuongTiens = ko.observableArray([]);
	this.xemHoSo = ko.observable(false);
	this.valid = ko.validatedObservable({
		mucDich : this.mucDich,
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
	this.donViTinh = ko.observable('');
	this.tenHangHoa = ko.observable('');
	this.tenTCTN = ko.observable('');
	this.hamLuong = ko.observable('');
	this.trangThai = ko.observable(-1);
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