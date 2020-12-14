function KyHoSoVM(data) {
    var self = this;
    var hoso = data.hoso;
    self.lstProvince = ko.observable(data.lstProvince);
    self.fiSignedBy = ko.observable(hoso ? hoso.fiSignedBy : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiSignedDate = ko.observable(hoso ? new Date(hoso.fiSignedDate) : new Date());
    self.fiSigningLocation = ko.observable(hoso ? hoso.fiSigningLocation : null).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiSignedByTitle = ko.observable(hoso ? hoso.fiSignedByTitle : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    self.toJSON = function (){
        var model = ko.toJS(self);
        delete model.lstProvince;
        return model;
    };

    self.isValid = function () {
        return self.fiSignedBy.isValid() && self.fiSigningLocation.isValid() && self.fiSignedByTitle.isValid()
    }
}