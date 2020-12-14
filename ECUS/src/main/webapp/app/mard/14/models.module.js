
function TbsMucDich14() {
    this.fiId = ko.observable(null);
    this.fiCode = ko.observable(null);
    this.fiName = ko.observable(null);
    this.fiDisplayGroup = ko.observable(null);
    this.fiDocumentType = ko.observable(null);
}
function TbdHoSo14() {

    this.fiIdHoSo = ko.observable(null);

    this.fiDocumentType = ko.observable(null).extend({required : true, maxLength : 255});

    this.fiDocumentName = ko.observable(null);

    this.fiStatus = ko.observable(null).extend({required : true});

    this.fiCreateDate = ko.observable(null).extend({required : true});

    this.fiModifiedDate = ko.observable(null).extend({required : true});

    this.fiReceiveDate = ko.observable(null);

    this.fiActive = ko.observable(null).extend({required : true});

    this.fiApplicationNo = ko.observable(null).extend({required : true, maxLength : 20});

    this.fiNameOfRegistration = ko.observable(null).extend({required : true, maxLength : 255});

    this.fiAddressOfRegistration = ko.observable(null).extend({required : true, maxLength : 500});

    this.fiPhone = ko.observable(null).extend({maxLength : 50});

    this.fiEmail = ko.observable(null).extend({maxLength : 250, email: true});

    this.fiFax = ko.observable(null).extend({maxLength : 250});

    this.fiTaxCode = ko.observable(null).extend({required : true, maxLength : 14});

    this.fiPurposes = ko.observable(null).extend({required : true, maxLength : 250});

    this.fiPurposeOtherNote = ko.observable(null).extend({maxLength : 500});

    this.fiToxicityUsed = ko.observable(null).extend({maxLength : 500});

    this.fiTestingUsed = ko.observable(null).extend({maxLength : 500});

    this.fiGates = ko.observable(null).extend({required : true, maxLength : 500});

    this.fiImportTimeFrom = ko.observable(null).extend({maxLength: 12, dateVI: true});

    this.fiImportTimeTo = ko.observable().extend({required : true, maxLength: 12, dateVI: true});

    this.fiStatusName = ko.observable(null);

    this.fiReasonCorrection = ko.observable(null);
    this.fiReasonDrawal = ko.observable(null);
    this.fiSended = ko.observable(0);
    this.fiVersion = ko.observable(0);

    this.valid = ko.validatedObservable(this);

}

function TbdThuoc14() {

    this.fiId = ko.observable(0);

    this.fiIdHoSo = ko.observable(0);

    this.fiSort = ko.observable(0);

    this.fiTypeGood = ko.observable('').extend({required : true, maxLength : 250, notEqual: -1});

    this.fiNameOfGoods = ko.observable('').extend({required : true, maxLength : 250});

    this.fiWeight = ko.observable('').extend({required : true, number: true});

    this.fiWeightUnitCode = ko.observable('').extend({required : true, maxLength : 18, notEqual: -1});

    this.fiWeightUnitName = ko.observable('-1');

    this.fiMainUse = ko.observable('').extend({required : true, maxLength : 500});

    this.fiOrigin = ko.observable('').extend({required : true, maxLength : 500});

    this.enable = ko.observable(true);

    this.valid = ko.validatedObservable({
        fiId: this.fiId,
        fiIdHoSo: this.fiIdHoSo,
        fiSort: this.fiSort,
        fiTypeGood: this.fiTypeGood,
        fiNameOfGoods: this.fiNameOfGoods,
        fiWeight: this.fiWeight,
        fiWeightUnitCode: this.fiWeightUnitCode,
        fiWeightUnitName: this.fiWeightUnitName,
        fiMainUse: this.fiMainUse,
        fiOrigin: this.fiOrigin,


    });
}

function TbdThanhToan14() {
    this.fiId = ko.observable(0);

    this.fiIdHoSo = ko.observable(0).extend({required : false});

    this.fiTotalFee = ko.observable('').extend({required : true, number: true});

    this.fiTotalFeeChar = ko.observable('').extend({required : true, maxLength : 250});

    this.fiNote = ko.observable('').extend({required : false, maxLength : 250});

    this.fiPaymentName = ko.observable('').extend({required : true, maxLength : 250});

    this.fiPaymentDate = ko.observable(moment(new Date()).format('DD/MM/YYYY')).extend({required : false, maxLength : 14});

    this.fiAttachedDocName = ko.observable('').extend({required : false, maxLength : 250});

    this.fiFileName = ko.observable('').extend({required : true, maxLength : 500});

    this.fiPath = ko.observable('').extend({required : true, maxLength : 500});

    this.fiUuid = ko.observable('').extend({required : true, maxLength : 500});

    this.fiFileCode = ko.observable('').extend({required : true, maxLength : 500});

    this.fiCreateDate = ko.observable('').extend({required : false, maxLength : 500});

    this.fiSended = ko.observable(0).extend({required : false});

    this.fiLink = ko.observable('').extend({required : false});

    this.enable = ko.observable(true);

    this.valid = ko.validatedObservable(this);
}

function TepTinModel() {

    this.link = ko.observable('');

    this.xemHoSo = ko.observable(false);

    this.fiId = ko.observable(null);

    this.fiIdHoSo = ko.observable(null).extend({required: true});

    this.fiPath = ko.observable(null).extend({required: true, maxLength: 250});

    this.fiUuid = ko.observable(null).extend({required: true, maxLength: 250});

    this.fiSize = ko.observable(null).extend({required: true});

    this.fiFileCode = ko.observable(null).extend({required: true});

    this.fiFileName = ko.observable(null).extend({required: true, maxLength: 250});

    this.fiFileByte = ko.observable(null).extend({maxLength: 250});

    this.fiFileGroup = ko.observable(null).extend({required: true, maxLength: 250});

    this.fiFileTypeCode = ko.observable(null).extend({required : true, maxLength : 250});


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

function TbdHoSo() {
    this.fiIdHoSo = ko.observable(null);

    this.fiDocumentType = ko.observable(null).extend({
        required: true,
        maxLength: 255
    });

    this.fiDocumentName = ko.observable(null).extend({
        required: true,
        maxLength: 255
    });

    this.fiStatus = ko.observable(null).extend({
        required: true
    });

    this.fiCreateDate = ko.observable(null).extend({
        required: true
    });

    this.fiModifiedDate = ko.observable(null).extend({
        required: true
    });

    this.fiReceiveDate = ko.observable(null);

    this.fiActive = ko.observable(null).extend({
        required: true
    });

    this.fiApplicationNo = ko.observable(null).extend({
        required: true,
        maxLength: 20
    });

    this.fiNameOfRegistration = ko.observable(null).extend({
        required: true,
        maxLength: 255
    });

    this.fiAddressOfRegistration = ko.observable(null).extend({
        required: true,
        maxLength: 500
    });

    this.fiPhone = ko.observable(null).extend({
        maxLength: 50
    });

    this.fiEmail = ko.observable(null).extend({
        maxLength: 250
    });

    this.fiFax = ko.observable(null).extend({
        maxLength: 250
    });

    this.fiTaxCode = ko.observable(null).extend({
        required: true,
        maxLength: 14
    });

    this.fiPurposes = ko.observable(null).extend({
        required: true,
        maxLength: 250
    });

    this.fiPurposeOtherNote = ko.observable(null).extend({
        maxLength: 500
    });

    this.fiToxicityUsed = ko.observable(null).extend({
        maxLength: 500
    });

    this.fiTestingUsed = ko.observable(null).extend({
        maxLength: 500
    });

    this.fiGates = ko.observable(null).extend({
        required: true,
        maxLength: 500
    });

    this.fiImportTimeFrom = ko.observable(null);

    this.fiImportTimeTo = ko.observable(null).extend({
        required: true
    });

    this.fiSignConfirmName = ko.observable(null).extend({
        maxLength: 100
    });

    this.fiDispatchNo = ko.observable(null).extend({
        required: true,
        maxLength: 50
    });

    this.fiSignConfirmDate = ko.observable(null).extend({
        required: true
    });

    this.fiStatusName = ko.observable(null).extend({
        required: true
    });

    this.fiSendDate = ko.observable(null).extend({
        required: true
    });
    this.showButtonEdit = ko.observable(false);
    this.showButtonDelete = ko.observable(false);
    this.showButtonXemGXN = ko.observable(false);
    this.showButtonXinRut = ko.observable(false);
    this.showButtonXinSuaHoSo = ko.observable(false);
    this.showButtonThongBaoPhi = ko.observable(false);

}

function SearchFormModel() {

    this.fiDocumentType = ko.observable(null);
    this.fiDocumentName = ko.observable(null);
    this.fiTaxCode = ko.observable(taxCode);
    this.fiStatus = ko.observable(null);
    this.fromFiSendDate = ko.observable(null).extend({dateVI: true, maxLength: 12});
    this.toFiSendDate = ko.observable(null).extend({dateVI: true, maxLength: 12});
    this.fiDispatchNo = ko.observable(null);
    this.fromFiSignConfirmDate = ko.observable(null).extend({dateVI: true, maxLength: 12});
    this.toFiSignConfirmDate = ko.observable(null).extend({dateVI: true, maxLength: 12});
    this.valid = ko.validatedObservable(this);

}






