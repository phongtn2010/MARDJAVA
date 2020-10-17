function TbdHoSo03() {

	this.fiIdHoSo = ko.observable(null);

	this.fiDocumentType = ko.observable(null).extend({required : false, maxLength : 255});

	this.fiDocumentName = ko.observable(null).extend({required : false, maxLength : 255});

	this.fiStatus = ko.observable(null).extend({required : true});

	this.fiOldStatus = ko.observable(null);

	this.fiVersion = ko.observable(null);

	this.fiCreateDate = ko.observable(null).extend({required : true});

	this.fiModifiedDate = ko.observable(null).extend({required : true});

	this.fiSendDate = ko.observable(null);

	this.fiReceiveDate = ko.observable(null);

	this.fiActive = ko.observable(null).extend({required : true});

	this.fiReasonDrawal = ko.observable(null).extend({maxLength : 500});

	this.fiReasonCorrection = ko.observable(null).extend({maxLength : 500});

	this.fiTaxCode = ko.observable(null).extend({required : true, maxLength : 14});

	this.fiSoDonDeNghi = ko.observable(null).extend({required : true, maxLength : 255});

	this.fiNoiDNCapPhep = ko.observable(null).extend({required : true, maxLength : 50, notEqual: '---  ---'});

	this.fiTenTCCaNhan = ko.observable(null).extend({required : true, maxLength : 50});

	this.fiTenCQChuQuan = ko.observable(null).extend({maxLength : 255});

	this.fiDiaChi = ko.observable(null).extend({required : true, maxLength : 500});

	this.fiSoDienThoai = ko.observable(null).extend({required : true, maxLength : 50});

	this.fiTongSoXBPham = ko.observable(0).extend({required : false, maxLength : 100});

	this.fiTongSoBangDia = ko.observable(null).extend({required : true, maxLength : 100});

	this.fiXuatXu = ko.observable(null).extend({required : true ,maxLength : 2000});

	this.fiTenNhaCC = ko.observable(null).extend({required : true ,maxLength : 2000});

	this.fiCuaKhauNhap = ko.observable(null).extend({required : true ,maxLength : 2000});

	this.fiStatusName = ko.observable(i18nextko.t('statusNew')());

    this.fiTenNguoiKy = ko.observable(null).extend({required : false, maxLength : 255});

    this.fiChucDanh = ko.observable(null).extend({maxLength : 100});

    this.fiDiaDiemKy = ko.observable(null).extend({required : false, maxLength : 100, notEqual: '---  ---'});

	this.fiTongSoTenXBP = ko.observable(0).extend({required : true});

    this.valid = ko.validatedObservable(this);
}

