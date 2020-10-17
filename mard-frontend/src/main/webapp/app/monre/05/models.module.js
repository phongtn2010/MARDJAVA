
function ThongTinChungModel() {
	
	this.idHS =  ko.observable(0);
	
	this.enable =  ko.observable(true);
	
	this.maCoQuan =  ko.observable('-1').extend({
		required : true,
		maxLength : 50
	});
	
	this.tenCoQuan =  ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	
	this.tenDN =  ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	
	this.maSoThue =  ko.observable('').extend({
		required : true,
		maxLength : 20
	});
	
	this.truSoChinh =  ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	
	this.nguoiDaiDien =  ko.observable('').extend({
		required : true,
		maxLength : 250
	});
	
	this.soDTNguoiDaiDien =  ko.observable('').extend({
		required : true,
		maxLength : 20
	});
	
	this.faxNguoiDaiDien =  ko.observable('').extend({
		maxLength : 20
	});
	
	this.emailNguoiDaiDien =  ko.observable('').extend({
		required : true,
		maxLength : 255,
		email: true
	});
	
	this.soGCNDKKD  =  ko.observable('').extend({
		required : true,
		maxLength : 50,
	});
	
	this.ngayCapGCNDKKD =  ko.observable('').extend({
		required : true,
		pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
	});
	
	this.noiCapGCNDKKD =  ko.observable('').extend({
		required : true,
		maxLength : 255,
	});
	
	this.valid = ko.validatedObservable({

		maCoQuan : this.maCoQuan,
		tenCoQuan : this.tenCoQuan,
		tenDN : this.tenDN,
		maSoThue : this.maSoThue,
		truSoChinh : this.truSoChinh,
		nguoiDaiDien : this.nguoiDaiDien,
		soDTNguoiDaiDien : this.soDTNguoiDaiDien,
		emailNguoiDaiDien : this.emailNguoiDaiDien,
		soGCNDKKD : this.soGCNDKKD,
		ngayCapGCNDKKD : this.ngayCapGCNDKKD,
		noiCapGCNDKKD : this.noiCapGCNDKKD

	});
}

function CoSoSXModel() {

	this.tenCoSo = ko.observable().extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});

	this.diaChiCoSo = ko.observable().extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});

	this.email = ko.observable().extend({
		email : true,
		maxLength : 255
	});

	this.soDienThoai = ko.observable().extend({
		maxLength : 50
	});

	this.fax = ko.observable('').extend({
		maxLength : 50
	});

	this.tenTinh = ko.observable('').extend({
		required : true,
		minLength : 1,
		maxLength : 50
	});

	this.maTinh = ko.observable('-1').extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});
	

	this.tenHuyen = ko.observable('').extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});

	this.maHuyen = ko.observable('-1').extend({
		required : true,
		minLength : 1,
		maxLength : 50
	});
	
	this.tenXaPhuong = ko.observable('').extend({
		required : true,
		minLength : 1,
		maxLength : 50
	});

	this.maXaPhuong = ko.observable('-1').extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});
	
	this.email = ko.observable().extend({
		email : true,
		minLength : 1,
		maxLength : 255
	});
	
	this.fax = ko.observable().extend({
		minLength : 1,
		maxLength : 255
	});

	this.idCS = ko.observable(0);

	this.tbdThongTinCoSoSXId = ko.observable(0);

	this.idHS = ko.observable(0);

	this.enableDelete = ko.observable(false);

	this.enableUpdate = ko.observable(false);

	this.checked = ko.observable(false);
	
	this.checkValue = ko.observable('');

	this.selected = ko.observable(false);
	
	this.soThuTu = ko.observable(1);
	
	this.soThuTu2 = ko.observable(1);

	this.index = ko.observable(0);

	this.canUpdate = ko.observable(false);
	
	this.canDelete = ko.observable(false);
	
	this.valid = ko.validatedObservable({

		tenCoSo : this.tenCoSo,
		diaChiCoSo : this.diaChiCoSo,
		email : this.email,
		tenTinh : this.tenTinh,
		tenHuyen : this.tenHuyen,
		maHuyen : this.maHuyen,
		tenXaPhuong : this.tenXaPhuong,
		maXaPhuong : this.maXaPhuong

	});

}

function PheLieuModel() {

	this.soThuTu = ko.observable();

	this.donViUyThac2 = ko.observable('').extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});
	
	this.donViUyThac = ko.observable('');

	this.index = ko.observable();

	this.taoMoi = ko.observable(1);

	this.capNhat = ko.observable(0);

	this.xoaBo = ko.observable(0);

	this.enable = ko.observable(true);

	this.tenPheLieu = ko.observable('');
	
	this.tenPheLieu2 = ko.observable('-1').extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});
	
	this.maHS = ko.observable('').extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});
	
	this.maHS2 = ko.observable('-1').extend({
		required : true,
		minLength : 1,
		maxLength : 255
	});

	this.idPL = ko.observable(0);

	this.idHS = ko.observable(0);

	this.khoiLuong = ko.observable('').extend({
		required : true,
		number: true,
		min : 0.001,
		pattern: '^[0-9]{1,15}(.[0-9]{0,3})?'
	});
	
	this.khoiLuongInput = ko.observable('');
	
	this.khoiLuong6Input = ko.observable('');
	
	this.khoiLuong6 = ko.observable('').extend({
		required : true,
		number: true,
		min : 0.001,
		pattern: '^[0-9]{1,15}(.[0-9]{0,3})?'
	});
	
	this.canDelete = ko.observable(false);

	this.canUpdate = ko.observable(false);
	
	this.valid = ko.validatedObservable({
		tenPheLieu2 : this.tenPheLieu2,
		maHS2 : this.maHS2,
		khoiLuong : this.khoiLuong,
		khoiLuong6 : this.khoiLuong6,

	});
	this.valid2 = ko.validatedObservable({
		donViUyThac2 : this.donViUyThac2
	});
}

function TepTinModel() {
	
	this.tepLoai1 = ko.observableArray();
	
	this.tepLoai2 = ko.observableArray();
	
	this.tepLoai3 = ko.observableArray();
	
	this.tepLoai4 = ko.observableArray();
	
	this.tepLoai5 = ko.observableArray();
	
	this.tepLoai6 = ko.observableArray();
	
	this.tepLoai7 = ko.observableArray();
	
	this.tepLoai8 = ko.observableArray();
	
	this.id = ko.observable(0);
	
	this.idHS = ko.observable(0);
	
	this.index = ko.observable(0);
	
	this.tenTepTin = ko.observable('');
	
	this.tenTepTinId = ko.observable('');
	
	this.tenLoaiTep = ko.observable('');
	
	this.loaiTepTin = ko.observable(-1);
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
	this.idHS = ko.observable();
	this.maHoSo = ko.observable();
	this.tenDN = ko.observable();
	this.ngayGui = ko.observable();
	this.ngayCap = ko.observable();
	this.tenTrangThai = ko.observable();
	this.trangThai = ko.observable();
	this.showButtonEdit = ko.observable(false);
	this.showButtonDelete = ko.observable(false);
	this.showButtonXemGXN = ko.observable(false);
	this.showButtonTBPhi = ko.observable(false);
	this.showButtonXinRut = ko.observable(false);
	
}