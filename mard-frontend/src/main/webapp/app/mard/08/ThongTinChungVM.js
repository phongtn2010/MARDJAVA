function ThongTinChungVM (data) {
    var ttcVMSelf = this;
    ttcVMSelf.fiHSStatus = ko.observable((data && data.hasOwnProperty('fiHSStatus')) ? data.fiHSStatus : null);
    ttcVMSelf.fiTaxCode = ko.observable((data && data.hasOwnProperty('fiTaxCode')) ? data.fiTaxCode : null);
    ttcVMSelf.fiHSCreatedDate = ko.observable((data && data.hasOwnProperty('fiHSCreatedDate')) ? new Date(data.fiHSCreatedDate) : null);

    ttcVMSelf.fiRegistrationNo = ko.observable((data && data.hasOwnProperty('fiRegistrationNo')) ? data.fiRegistrationNo : null);
    ttcVMSelf.fiHSCode = ko.observable((data && data.hasOwnProperty('fiHSCode')) ? data.fiHSCode : null);
    ttcVMSelf.fiImporterName = ko.observable((data && data.hasOwnProperty('fiImporterName')) ? data.fiImporterName : null);
    ttcVMSelf.fiImporterAddress = ko.observable((data && data.hasOwnProperty('fiImporterAddress')) ? data.fiImporterAddress : null);
    ttcVMSelf.fiImporterTel = ko.observable((data && data.hasOwnProperty('fiImporterTel')) ? data.fiImporterTel : null);
    ttcVMSelf.fiImporterFax = ko.observable((data && data.hasOwnProperty('fiImporterFax')) ? data.fiImporterFax : null);
    ttcVMSelf.fiImporterEmail = ko.observable((data && data.hasOwnProperty('fiImporterEmail')) ? data.fiImporterEmail : null)
        .extend({
            email: {params: true, message: NSWLang["common_msg_invalid_email"]}
        });
    ttcVMSelf.fiIdentityNumber = ko.observable((data && data.hasOwnProperty('fiIdentityNumber')) ? data.fiIdentityNumber : null);

    ttcVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(ttcVMSelf));
        data.fiHSCreatedDate = ttcVMSelf.fiHSCreatedDate().getTime();
        return data;
    }
}