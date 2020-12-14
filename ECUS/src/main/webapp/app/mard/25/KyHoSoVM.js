function KyHoSoVM(data) {
    var kyHoSoVMSelf = this;
    kyHoSoVMSelf.fiSignAddress = ko.observable((data && data.hasOwnProperty('fiSignAddress')) ? data.fiSignAddress : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    kyHoSoVMSelf.fiSignName = ko.observable((data && data.hasOwnProperty('fiSignName')) ? data.fiSignName : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    kyHoSoVMSelf.fiSignPosition = ko.observable((data && data.hasOwnProperty('fiSignPosition')) ? data.fiSignPosition : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    kyHoSoVMSelf.fiSignDate = ko.observable((data && data.hasOwnProperty('fiSignDate')) ? new Date(data.fiSignDate) : null);

    kyHoSoVMSelf.lstProvince = ko.observableArray((data && data.hasOwnProperty('lstProvince')) ? data.lstProvince : null);
}