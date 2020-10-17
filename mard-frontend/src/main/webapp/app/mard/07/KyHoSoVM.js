function KyHoSoVM (options) {
    var kyHoSoVMSelf = this;
    kyHoSoVMSelf.fiSignAddress = ko.observable((options && options.hasOwnProperty('fiSignAddress')) ? options.fiSignAddress : null);
    kyHoSoVMSelf.fiSignAddress.extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
    });
    kyHoSoVMSelf.fiSignName = ko.observable((options && options.hasOwnProperty('fiSignName')) ? options.fiSignName : null);
    kyHoSoVMSelf.fiSignName.extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
    });
    kyHoSoVMSelf.fiSignPosition = ko.observable((options && options.hasOwnProperty('fiSignPosition')) ? options.fiSignPosition : null);
    kyHoSoVMSelf.fiSignPosition.extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
    });

    kyHoSoVMSelf.lstProvince = ko.observableArray((options && options.hasOwnProperty('lstProvince')) ? options.lstProvince : null);

    kyHoSoVMSelf.errors = ko.validation.group(kyHoSoVMSelf);

    kyHoSoVMSelf.validate = function () {
        if (kyHoSoVMSelf.errors().length > 0) {
            kyHoSoVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    kyHoSoVMSelf.toJSON = function () {
        return {
            fiSignAddress: kyHoSoVMSelf.fiSignAddress(),
            fiSignName: kyHoSoVMSelf.fiSignName(),
            fiSignPosition: kyHoSoVMSelf.fiSignPosition(),
        }
    }
}