function ThongTinChungVM (hoso, data) {
    var self = this;
    self.fiHSStatus = ko.observable((hoso && hoso.hasOwnProperty('fiHSStatus')) ? data.mapTrangthai[hoso.fiHSStatus.toString()] : "Tạo mới");
    self.fiNSWFileCode = ko.observable((hoso && hoso.hasOwnProperty('fiNSWFileCode')) ? hoso.fiNSWFileCode : null);
    self.fiHSCreatedDate = ko.observable((hoso && hoso.hasOwnProperty('fiHSCreatedDate')) ? hoso.fiHSCreatedDate : new Date());
    self.fiRegistrationNo = ko.observable((hoso && hoso.hasOwnProperty('fiNSWFileCode')) ? hoso.fiNSWFileCode : "Mã được sinh sau khi lưu hồ sơ");
    self.fiDepartmentCode = ko.observable((hoso && hoso.hasOwnProperty('fiDepartmentCode')) ? hoso.fiDepartmentCode : null);
    self.fiDepartmentNameVni = ko.observable((hoso && hoso.hasOwnProperty('fiDepartmentNameVni')) ? hoso.fiDepartmentNameVni : null);
    self.fiDepartmentName = ko.observable((hoso && hoso.hasOwnProperty('fiDepartmentName')) ? hoso.fiDepartmentName : null);
    self.fiTaxCode = ko.observable((hoso && hoso.hasOwnProperty('fiTaxCode')) ? hoso.fiTaxCode : data.maSoThue);
    self.fiExporterNameVni = ko.observable((hoso && hoso.hasOwnProperty('fiExporterNameVni')) ? hoso.fiExporterNameVni : data.tenCongty);
    self.fiExporterName = ko.observable((hoso && hoso.hasOwnProperty('fiExporterName')) ? hoso.fiExporterName : null);
    self.fiExporterAdressVni = ko.observable((hoso && hoso.hasOwnProperty('fiExporterAdressVni')) ? hoso.fiExporterAdressVni : data.diaChiCongty);
    self.fiExporterAdress = ko.observable((hoso && hoso.hasOwnProperty('fiExporterAdress')) ? hoso.fiExporterAdress : null);
    self.fiIdentityNumber = ko.observable((hoso && hoso.hasOwnProperty('fiIdentityNumber')) ? hoso.fiIdentityNumber : null);
    self.fiIdentityIssueDate = ko.observable((hoso && hoso.fiIdentityIssueDate) ? new Date(hoso.fiIdentityIssueDate) : null);
    self.fiIdentityIssueAdress = ko.observable((hoso && hoso.hasOwnProperty('fiIdentityIssueAdress')) ? hoso.fiIdentityIssueAdress : null);
    self.fiExporterTel = ko.observable((hoso && hoso.hasOwnProperty('fiExporterTel')) ? hoso.fiExporterTel : data.dienthoaiCongty);
    self.fiExporterFax = ko.observable((hoso && hoso.hasOwnProperty('fiExporterFax')) ? hoso.fiExporterFax : data.faxCongty);
    self.fiExporterEmail = ko.observable((hoso && hoso.hasOwnProperty('fiExporterEmail')) ? hoso.fiExporterEmail : data.emailCongty);

    self.fiDepartment = ko.observable(null);
    self.lstTranThuY = ko.observable(data.lstTramThuY);

    if (hoso && hoso.fiDepartmentCode != null) {
        data.lstTramThuY.forEach(function (value) {
            if (value.id === hoso.fiDepartmentCode) {
                self.fiDepartment(value)
            }
        })
    }

    self.fiDepartment.subscribe(function(department) {
        if (department){
            self.fiDepartmentCode(department.id);
            self.fiDepartmentNameVni(department.nameVni);
            self.fiDepartmentName(department.nameEng);
        }
    });

    self.toJSON = function () {
        var exclude = ["toJSON", "fiDepartment", "lstTranThuY", "fiHSStatus"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }
        return model;
    }
}
