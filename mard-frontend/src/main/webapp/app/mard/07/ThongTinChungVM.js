function ThongTinChungVM(options) {
    var ttcVMSelf = this;
    ttcVMSelf.fiHSStatus = ko.observable((options && options.hasOwnProperty('fiHSStatus')) ? options.fiHSStatus : null);
    ttcVMSelf.fiTaxCode = ko.observable((options && options.hasOwnProperty('fiTaxCode')) ? options.fiTaxCode : null);
    ttcVMSelf.fiHSCreatedDate = ko.observable((options && options.hasOwnProperty('fiCreatedDate')) ? new Date(options.fiCreatedDate) : new Date());

    ttcVMSelf.fiNSWFileCode = ko.observable((options && options.hasOwnProperty('fiNSWFileCode')) ? options.fiNSWFileCode : null);
    ttcVMSelf.fiNameOfRegistration = ko.observable((options && options.hasOwnProperty('fiNameOfRegistration')) ? options.fiNameOfRegistration : null);
    ttcVMSelf.fiAddressOfRegistration = ko.observable((options && options.hasOwnProperty('fiAddressOfRegistration')) ? options.fiAddressOfRegistration : null);
    ttcVMSelf.fiPhoneOfRegistration = ko.observable((options && options.hasOwnProperty('fiPhoneOfRegistration')) ? options.fiPhoneOfRegistration : null);
    ttcVMSelf.fiPhoneOfRegistration.extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
    });
    ttcVMSelf.fiNumberOfRegistration = ko.observable((options && options.hasOwnProperty('fiNumberOfRegistration')) ? options.fiNumberOfRegistration : null);
    ttcVMSelf.fiFaxOfRegistration = ko.observable((options && options.hasOwnProperty('fiFaxOfRegistration')) ? options.fiFaxOfRegistration : null);
    ttcVMSelf.fiEmailOfRegistration = ko.observable((options && options.hasOwnProperty('fiEmailOfRegistration')) ? options.fiEmailOfRegistration : null)
        .extend({
            email: {params: true, message: NSWLang["common_msg_invalid_email"]}
        });
    ttcVMSelf.fiIdentityNumber = ko.observable((options && options.hasOwnProperty('fiIdentityNumber')) ? options.fiIdentityNumber : null);
    ttcVMSelf.fiIdentityIssueDate = ko.observable((options && options.fiIdentityIssueDate) ? new Date(options.fiIdentityIssueDate) : null);
    ttcVMSelf.fiIdentityIssueAddress = ko.observable((options && options.hasOwnProperty('fiIdentityIssueAddress')) ? options.fiIdentityIssueAddress : null);

    ttcVMSelf.errors = ko.validation.group(ttcVMSelf);

    ttcVMSelf.validate = function () {
        if (ttcVMSelf.errors().length > 0) {
            ttcVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    ttcVMSelf.toJSON = function () {
        return {
            fiHSStatus: ttcVMSelf.fiHSStatus(),
            fiTaxCode: ttcVMSelf.fiTaxCode(),
            fiHSCreatedDate: ttcVMSelf.fiHSCreatedDate().getTime(),
            fiNSWFileCode: ttcVMSelf.fiNSWFileCode(),
            fiNameOfRegistration: ttcVMSelf.fiNameOfRegistration(),
            fiAddressOfRegistration: ttcVMSelf.fiAddressOfRegistration(),
            fiPhoneOfRegistration: ttcVMSelf.fiPhoneOfRegistration(),
            fiNumberOfRegistration: ttcVMSelf.fiNumberOfRegistration(),
            fiFaxOfRegistration: ttcVMSelf.fiFaxOfRegistration(),
            fiEmailOfRegistration: ttcVMSelf.fiEmailOfRegistration(),
            fiIdentityNumber: ttcVMSelf.fiIdentityNumber(),
            fiIdentityIssueDate: ttcVMSelf.fiIdentityIssueDate() ? ttcVMSelf.fiIdentityIssueDate().getTime() : null,
            fiIdentityIssueAddress: ttcVMSelf.fiIdentityIssueAddress()
        }
    }
}