function ThongTinChungVM(options) {
    var self = this;

    var hoso = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;
    self.disableBecauseEdit = ko.observable(!!hoso);

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiLoaiDon = ko.observable(options.maThuTuc);


    self.fiTaxCode = ko.observable(null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });

    self.fiHSCode = ko.observable(hoso ? hoso.fiHSCode ? hoso.fiHSCode : "Mã hồ sơ tự động sinh khi lưu hoặc gửi" : "Mã hồ sơ tự động sinh khi lưu hoặc gửi").extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiNameOfRegistration = ko.observable(null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });

    self.fiAddressOfRegistration = ko.observable(null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });

    self.fiPhone = ko.observable().trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });

    self.fiFax = ko.observable(null).trimmed().extend({
    });

    self.fiEmail = ko.observable(null).trimmed().extend({
        email: {message: 'Email không đúng định dạng', params: true}
    });
    //fiKDStatus
    //mapTrangthai
    self.fiHSStatus = ko.observable(hoso !== null && hoso.hasOwnProperty('fiHSStatus') ? hoso.fiHSStatus : 0);
    self.fiTenTt = ko.observable(hoso !== null && hoso.hasOwnProperty('fiHSStatus') ? options.mapTrangthai[hoso.fiHSStatus.toString()] : options.mapTrangthai["0"]);
    self.fiHSCreatedDate = ko.observable(hoso !== null && hoso.hasOwnProperty('fiCreatedDate') ? new Date(hoso.fiCreatedDate) : new Date());

    self.fiNameOfRegistration(hoso !== null && hoso.hasOwnProperty('fiNameOfRegistration') ? hoso.fiNameOfRegistration : user.companyName);
    self.fiTaxCode(hoso !== null && hoso.hasOwnProperty('fiTaxCode') ? hoso.fiTaxCode : user.username);
    self.fiAddressOfRegistration(hoso !== null && hoso.hasOwnProperty('fiAddressOfRegistration') ? hoso.fiAddressOfRegistration : user.companyAddress);
    self.fiPhone(hoso !== null && hoso.hasOwnProperty('fiPhone') ? hoso.fiPhone : user.companyPhoneNumber);
    self.fiFax(hoso !== null && hoso.hasOwnProperty('fiFax') ? hoso.fiFax : user.companyFax);
    self.fiEmail(hoso !== null && hoso.hasOwnProperty('fiEmail') ? hoso.fiEmail : user.companyEmail);

    self.toJSON = function () {
        var exclude = [];

        var model = ko.toJS(self);

        model.fiNameOfRegistration = model.fiNameOfRegistration;
        model.fiAddressOfRegistration = model.fiAddressOfRegistration;
        model.fiFax = model.fiFax;
        model.fiPhone = model.fiPhone;
        model.fiEmail = model.fiEmail;

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    }
}