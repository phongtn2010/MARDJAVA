function KyHoSoVM (data) {
    var kyHoSoVMSelf = this;
    kyHoSoVMSelf.fiSigningLocation = ko.observable((data && data.hasOwnProperty('fiSigningLocation')) ? data.fiSigningLocation : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        messagesOnModified: false
    });
    kyHoSoVMSelf.fiSignedBy = ko.observable((data && data.hasOwnProperty('fiSignedBy')) ? data.fiSignedBy : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        messagesOnModified: false
    });
    kyHoSoVMSelf.fiSignedByTitle = ko.observable((data && data.hasOwnProperty('fiSignedByTitle')) ? data.fiSignedByTitle : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    kyHoSoVMSelf.lstProvince = ko.observableArray((data && data.hasOwnProperty('lstProvince')) ? data.lstProvince : []);

    kyHoSoVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(kyHoSoVMSelf));
        delete data.lstProvince;
        return data;
    }
}