function TbdDinhKem03() {

	this.fiId = ko.observable(null);

	this.fiIdHoSo = ko.observable(null).extend({required : true});

    this.fiFileTypeName = ko.observable(null).extend({required : true});

    this.fiFileGroup = ko.observable(null).extend({required : true});

    this.fiFileTypeCode = ko.observable(null).extend({required : true});

	this.fiFileName = ko.observable(null).extend({required : true, maxLength : 250});

    this.link = ko.observable(null);

	this.valid = ko.validatedObservable({
		fiId: this.fiId,
		fiIdHoSo: this.fiIdHoSo,
		fiPath: this.fiPath,
		fiUuid: this.fiUuid,
		fiSize: this.fiSize,
		fiFileCode: this.fiFileCode,
		fiFileName: this.fiFileName,
		fiFileByte: this.fiFileByte,
	});
}

