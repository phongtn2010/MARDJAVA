function TbdDinhKemYCSGP04() {

    this.fiId = ko.observable(null);

    this.fiIdYeuCauSGP = ko.observable(null).extend({required : false});

    this.fiFileTypeName = ko.observable(null).extend({required : true});

    this.fiFileGroup = ko.observable(null).extend({required : true});

    this.fiFileTypeCode = ko.observable(null).extend({required : true});

    this.fiFileName = ko.observable(null).extend({required : true, maxLength : 250});

    this.link = ko.observable(null);

    this.valid = ko.validatedObservable(this);
}

