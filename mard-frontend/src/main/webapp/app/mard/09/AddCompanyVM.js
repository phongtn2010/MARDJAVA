var AddCompanyVM = function(companies, onAddCompany) {
    var self = this;
    self.errorMsg = ko.observable(null);
    self.listCompany = ko.observableArray(companies);
    self.fiExporterAddress = ko.observable(null);

    self.addCompany = function () {
        var company = companies[$("#frmTenCongTyXuatKhau").prop('selectedIndex') - 1];
        if (company != null) {
            onAddCompany(company);
            self.fiExporterAddress(null);
            self.errorMsg(null);
            $("#frmTenCongTyXuatKhau").prop('selectedIndex', 0);
            $("#modal_addCompany").modal('toggle')
        } else {
            self.errorMsg("Vui lòng chọn công ty xuất khẩu")
        }
    };


    self.onClose = function() {
        $("#frmTenCongTyXuatKhau").prop('selectedIndex', 0);
        self.fiExporterAddress(null);
    };

    self.onChooseCompany = function () {
        if ($("#frmTenCongTyXuatKhau").prop('selectedIndex')) {
            var company = companies[$("#frmTenCongTyXuatKhau").prop('selectedIndex') - 1];
            self.fiExporterAddress(company.fiExporterAddress);
        }
    };
};