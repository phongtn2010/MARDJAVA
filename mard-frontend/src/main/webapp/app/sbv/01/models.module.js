function ThongTinChungModel() {

	this.idHS = ko.observable(0);

	this.enable = ko.observable(true);

	this.maCoQuan = ko.observable('-1').extend({
		required : true,
		maxLength : 50,
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

    this.valid.errors.showAllMessages(false);
	
}

function ThongTinNgoaiTeModel() {

	this.hinhThucXNK = ko.observable('-1').extend({
        required : true
    });
	this.maCuaKhau = ko.observable().extend({
		required : true,
		maxLength : 20
	});
	this.xuatNhapKhauTuNgay = ko.observable('').extend({
		required : true,
		maxLength: 10,
		dateVI: true
	});
	this.xuatNhapKhauDenNgay = ko.observable('').extend({
		required : true,
		maxLength: 10,
		dateVI: true
	});
	this.capGiayPhepLanDau = ko.observable(true).extend({
        required : true,
    });
	
	this.soGiayPhepDaCap = ko.observable('').extend({
		maxLength : 20
	});
	this.doiTacXuatNhapKhau = ko.observable('').extend({
		required : true,
		maxLength : 255
	});

	this.ghiChu = ko.observable('').extend({
		maxLength : 2000
	});

    // this.valid = ko.validatedObservable(this);

    this.valid = ko.validatedObservable({
        hinhThucXNK : this.hinhThucXNK,
        maCuaKhau : this.maCuaKhau,
        xuatNhapKhauTuNgay: this.xuatNhapKhauTuNgay,
        xuatNhapKhauDenNgay: this.xuatNhapKhauDenNgay,
        capGiayPhepLanDau: this.capGiayPhepLanDau,
        soGiayPhepDaCap: this.soGiayPhepDaCap,
        doiTacXuatNhapKhau: this.doiTacXuatNhapKhau,
        ghiChu: this.ghiChu
    });
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
	this.showButtonEdit = ko.observable(false);
	this.showButtonDelete = ko.observable(false);
	this.showButtonXemGXN = ko.observable(false);
	this.showButtonXinRut = ko.observable(false);
	this.showButtonSend = ko.observable(false);
	this.showButtonVanBan = ko.observable(false);
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
ko.validation.registerExtenders();

function showError(item, rowIndex, isDebug) {
    for (var key in item) {

        if (isDebug) {
            if (item[key] != undefined && item[key] != null) {
                console.log(key + " is valid: " + item[key].isValid());
            }
        }
        if (item[key] != undefined && item[key] != null && key != 'valid') {
			console.log(item[key]);
            if (item[key]  && item[key].isValid() == false) {
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