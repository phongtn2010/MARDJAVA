function TbdNguoiThamDinh04() {

	this.fiId = ko.observable(null);

	this.fiIdHoSo = ko.observable(null).extend({required : true});

	this.fiHoTen = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiNgaySinh = ko.observable(null).extend({required : true});

	this.fiTrinhDoNghiepVu = ko.observable(null).extend({required : true, maxLength : 500});

	this.fiTrinhDoChuyenMon = ko.observable(null).extend({required : true, maxLength : 500});

	this.fiTrinhDoNgoaiNgu = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiThamNienCongTac = ko.observable(null).extend({required : true, maxLength : 1000});


    this.actionEditEnable = ko.observable(isView ? false : true);
    this.actionDeleteEnable = ko.observable(isView ? false : true);

	this.valid = ko.validatedObservable(this);
}

