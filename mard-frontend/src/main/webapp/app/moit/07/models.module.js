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
	this.fax = ko.observable('');
	/*this.fax = ko.observable('').extend({
		maxLength : 50,
		required : true,
	});*/
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
		maxLength : 12,
		dateVI: true
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
	this.loaiGiayPhep = ko.observable().extend({
		required : false,
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
	this.faxNoiSanXuat = ko.observable('');
	/*this.faxNoiSanXuat = ko.observable('').extend({
		required : true,
		maxLength : 50
	});*/
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
	this.xuatNhapKhauTuNgay = ko.observable('').extend({maxLength: 12, dateVI: true});
	this.xuatNhapKhauDenNgay = ko.observable('').extend({maxLength: 12, dateVI: true});
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
	/*this.idCuaKhau = ko.observable(0);
	this.tenCuaKhau = ko.observable('');
	this.maCuaKhau = ko.observable('');
	this.idHoSo = ko.observable('');*/
	
	this.soThuTu = ko.observable();
	this.idCuaKhau = ko.observable(0);
	this.tenCuaKhau = ko.observable('');
	this.maCuaKhau = ko.observable('');
	this.idHoSo = ko.observable('');
	this.checked = ko.observable(false);
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
function dateToTime(ddMMyyyy) {
    if (ddMMyyyy == undefined || ddMMyyyy == null || ddMMyyyy == '') return 0;
    var d = ddMMyyyy.toString().split("/");
    return new Date(d[2] + "-" + d[1] + "-" + d[0]).getTime();
}

function test(pattern, value) {
    var res = pattern.test(value);
    return res;
}
ko.validation.rules['dateVI'] = {
    validator: function (val, otherVal) {
        if (otherVal == true) {
            if (val) {
                var check = test(/^((0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|2[0-9])[0-9]{2})$/m, val);
                if (check == false) return false;
                var s = val.split("\/");
                var month = parseInt(s[1]);
                var soCuoi = parseInt(s[2].substring(2,4));
                var year = parseInt(s[2]);
                if (month === 2) {
                    if (soCuoi % 4 === 0 || (soCuoi === 0 && year % 100 === 0)) {
                        return test(/^((29\/02\/2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$/m, val);
                    } else {
                        return test(/^((0[1-9]|1[0-9]|2[0-8])\/02\/((19|2[0-9])[0-9]{2}))$/m, val);
                    }
                }
                var thang30Ngay = [4, 6, 9, 11];
                if (thang30Ngay.includes(month)) {
                    return test(/^((0[1-9]|[12][0-9]|30)\/(0[469]|11)\/((19|2[0-9])[0-9]{2}))$/m, val);
                }
                var thang31Ngay = [1, 3, 5, 7, 8, 10, 12];
                if (thang31Ngay.includes(month)) {
                    return test(/^((0[1-9]|[12][0-9]|3[01])\/(0[13578]|10|12)\/((19|2[0-9])[0-9]{2}))$/m, val);
                }
            }
        }
        return true;
    },
    message: 'Sai định dạng ngày/tháng/năm (dd/mm/yyyy) hoặc năm bắt đầu từ 1900-2999 hoặc ngày nhập không đúng theo lịch.'
};


ko.validation.rules['notEqual'] = {
    validator: function (val, otherVal) {
        if (val) {
            return val != otherVal;
        }
        return false;
    },
    message: ''
};
ko.validation.rules['greaterThan'] = {
    validator: function (val, otherVal) {
        if (val) {
            return dateToTime(val) > dateToTime(otherVal);
        }
        return true;
    },
    message: 'Giá trị nhập phải lớn hơn {0}.'
};
ko.validation.rules['greaterThanOrEqual'] = {
    validator: function (val, otherVal) {
        if (val) {
            return dateToTime(val) >= dateToTime(otherVal);
        }
        return true;
    },
    message: 'Giá trị nhập phải lớn hơn hoặc bằng {0}.'
};

function showError(item, rowIndex, isDebug) {
    for (var key in item) {
        if (isDebug) {
            if (item[key] != undefined && item[key] != null) {
                console.log(key + " is valid: " + item[key].isValid());
            }
        }
        if (item[key] != undefined && item[key] != null && key != 'valid') {
            if (item[key].isValid() == false) {
                var eleId = "#" + key;
                if (rowIndex != undefined && rowIndex != null) eleId += rowIndex;
                if($(eleId).length) {
                    $(eleId).focus();
                    return;
                }
            }
        }
    }
}

ko.validation.registerExtenders();

function isKeyControl(keyCode) {
    var reuslt = $.inArray(keyCode, [37, 39, 46, 47, 8, 116]);
    if (reuslt !== -1) return true;
    return false;
}

ko.bindingHandlers.dateInput = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;
            var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
            if (isKeyControl(keyCode) === true) return true;
            if (value.length === 2 || value.length === 5) {
                if (isKeyControl(keyCode) === true) return true;
                var month = parseInt(value.substring(3, 5));
                var day = parseInt(value.substring(0, 2));
                if ( day > 31 || day === 0 || month > 12 || month === 0) return false;
                if (keyCode === 191) return true;
                return false;
            }
            if (value.length >= 10) {
                if (isKeyControl(keyCode) === true) return true;
                return false;
            }
            if ($.inArray(keyCode, keys) === -1) return false;
            if (allBindings.dateInput) {
                allBindings.dateInput.call(viewModel, viewModel, e.target, element);
            }
            return true;
        });
    }
}

ko.bindingHandlers.numberFormatInput = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;
            var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
            if (isKeyControl(keyCode) === true) return true;

            if ($.inArray(keyCode, keys) === -1) return false;
            if (allBindings.numberFormatInput) {
                allBindings.numberFormatInput.call(viewModel, viewModel, e.target, element);
            }
            return true;
        });
    }
}

ko.bindingHandlers.textFormatInput = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        var ctrlDown = false,
            ctrlKey = 17,
            cmdKey = 91,
            vKey = 86,
            cKey = 67;
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;
            if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = true;
            if (ctrlDown && (e.keyCode == vKey || e.keyCode == cKey)) return false;
            if (isKeyControl(keyCode) === true) return true;
            if ((keyCode >= 97 && keyCode <= 122) || (keyCode >= 65 && keyCode <= 90) || keyCode === 188 || keyCode == 32 || keyCode === 190) {
                if (allBindings.textFormatInput) {
                    allBindings.textFormatInput.call(viewModel, viewModel, e.target, element);
                }
                return true;
            };
            return false;
        });

        $(element).keyup(function (e) {
            if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = false;
        });
    }
}