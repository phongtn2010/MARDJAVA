function KyHoSoVM(hoso, lstProvince) {
    var self = this;
    if (hoso == null) hoso = {};
    self.lstProvince = ko.observable(lstProvince);
    self.fiSignName = ko.observable(hoso ? hoso.fiSignName : null);
    self.fiSignAddress = ko.observable(hoso ? hoso.fiSignAddress : null);

    self.toJSON = function (){
        var model = ko.toJS(self);
        delete model.lstProvince;
        return model;
    }
}