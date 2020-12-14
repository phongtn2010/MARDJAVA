function TbdThietBi03() {

	this.fiId = ko.observable(null);

	this.fiIdHoSo = ko.observable(null).extend({required : true});

	this.fiMaISBN = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiTenGoc = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiTenTiengViet = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiTenTacGia = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiTenNhaCC = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiTheLoai = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiSoBan = ko.observable(0).extend({required : true, maxLength : 255});

	this.fiSoLuongDia = ko.observable(0).extend({required : true, maxLength : 255});

	this.fiSoLuongBang = ko.observable(0).extend({required : true, maxLength : 255});

	this.fiSoLuongCatset = ko.observable(0).extend({required : true, maxLength : 255});

	this.fiPhamViSuDung = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiHinhThucKhac = ko.observable(null).extend({required : true, maxLength : 255});

    this.fiTomTat = ko.observable(null).extend({required : true, maxLength : 1000});

    this.actionEditEnable = ko.observable(isView ? false : true);
    this.actionDeleteEnable = ko.observable(isView ? false : true);

	this.valid = ko.validatedObservable({
		fiId: this.fiId,
		fiIdHoSo: this.fiIdHoSo,
		fiMaISBN: this.fiMaISBN,
		fiTenGoc: this.fiTenGoc,
		fiTenTiengViet: this.fiTenTiengViet,
		fiTenTacGia: this.fiTenTacGia,
		fiTenNhaCC: this.fiTenNhaCC,
		fiTheLoai: this.fiTheLoai,
		fiSoBan: this.fiSoBan,
		fiSoLuongDia: this.fiSoLuongDia,
		fiSoLuongBang: this.fiSoLuongBang,
		fiSoLuongCatset: this.fiSoLuongCatset,
		fiPhamViSuDung: this.fiPhamViSuDung,
		fiHinhThucKhac: this.fiHinhThucKhac,
        fiTomTat: this.fiTomTat,
	});
}

