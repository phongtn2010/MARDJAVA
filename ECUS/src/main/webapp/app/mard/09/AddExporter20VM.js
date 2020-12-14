var AddExporter20VM = function(companies, onAddExporter) {
    var self = this;
    self.errorMsg = ko.observable(null);
    self.listCompany = ko.observableArray(companies);
    self.fiSellerName = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiSellerState = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiSellerAddress = ko.observable(null).trimmed();
    self.fiSellerStateCode = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiSellerStateName = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiSellerPhone = ko.observable(null).trimmed();
    self.fiSellerFax = ko.observable(null).trimmed();
    self.fiPortOfDepartureName = ko.observable(null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    self.countries = ko.observableArray([]);


    function validateData()  {
        return self.fiSellerName.isValid()
            && self.fiSellerState.isValid()
            && self.fiPortOfDepartureName.isValid()
    }

    self.update = function(index, data) {

    };

    self.onClose = function() {
        self.fiSellerStateName(null);
        self.fiSellerPhone(null);
        self.fiSellerState(null);
        self.fiSellerFax(null);
        self.fiSellerAddress(null);
        self.fiPortOfDepartureName(null);
        $("#frmBenBanHang").prop('selectedIndex',0);
        $("#selectNuocXuatHang").prop('selectedIndex',0);
    }

    self.addExporter = function () {
        if (validateData()){
            var company = companies[$("#frmBenBanHang").prop('selectedIndex') - 1];
            company.fiSellerStateCode = self.fiSellerState().countrycode;
            company.fiSellerStateName = self.fiSellerState().countryname;
            company.fiSellerPhone = self.fiSellerPhone();
            company.fiSellerFax = self.fiSellerFax();
            company.fiPortOfDepartureName = self.fiPortOfDepartureName();
            self.fiSellerStateName(null);
            self.fiSellerPhone(null);
            self.fiSellerFax(null);
            self.fiSellerAddress(null);
            self.fiPortOfDepartureName(null);
            $("#frmBenBanHang").prop('selectedIndex',0);
            $("#selectNuocXuatHang").prop('selectedIndex',0);
            onAddExporter(company);

            $("#modal_addExporter").modal('toggle');
        } else {
            self.errorMsg("Vui lòng nhập đầy đủ các thông tin bắt buộc")
        }

    };


    self.onChooseExporter = function () {
        if ($("#frmBenBanHang").prop('selectedIndex')) {
            var company = companies[$("#frmBenBanHang").prop('selectedIndex') - 1];
            self.fiSellerAddress(company.fiExporterAddress);
        }
    };

    self.onChooseCountry = function () {
        if ($("#selectNuocXuatHang").prop('selectedIndex')) {

        }
    }
};