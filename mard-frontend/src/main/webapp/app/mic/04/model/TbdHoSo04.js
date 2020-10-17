function TbdHoSo04() {

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

	this.fiNoiDNCapPhep = ko.observable(null).extend({required : true, maxLength : 50});

	this.fiTenTCCaNhan = ko.observable(null).extend({required : true, maxLength : 50});

	this.fiTenCQChuQuan = ko.observable(null).extend({maxLength : 255});

	this.fiDiaChi = ko.observable(null).extend({required : true, maxLength : 500});

	this.fiSoDienThoai = ko.observable(null).extend({required : true, maxLength : 50});

	this.fiFax = ko.observable(null).extend({required : false, maxLength : 50});

	this.fiEmail = ko.observable(null).extend({required : true, maxLength : 50, email: true});

	this.fiWebsite = ko.observable(null).extend({maxLength : 50});

	this.fiNhapKhauSach = ko.observable(1).extend({required : true, maxLength : 50});

	this.fiStatusName = ko.observable(i18nextko.t('statusNew')());

    this.fiTenNguoiKy = ko.observable(null).extend({required : false, maxLength : 255});

    this.fiChucDanh = ko.observable(null).extend({maxLength : 100});


    this.valid = ko.validatedObservable(this);
}

