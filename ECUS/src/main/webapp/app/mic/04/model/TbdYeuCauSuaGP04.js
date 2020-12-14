function TbdYeuCauSuaGP04() {

    this.fiId = ko.observable(null);

    this.fiNoiDung = ko.observable(null).extend({required : true,  maxLength : 2000});

    this.fiNgayYeuCau = ko.observable(null).extend({required : true});

    this.fiIdGiayPhep = ko.observable(null).extend({required : true});

    this.valid = ko.validatedObservable(this);
}

