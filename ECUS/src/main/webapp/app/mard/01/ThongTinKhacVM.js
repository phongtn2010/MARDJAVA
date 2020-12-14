function ThongTinKhacVM (data, options) {
    var self = this;
    self.fiImporteNameAddressVni = ko.observable((data && data.hasOwnProperty('fiImporteNameAddressVni')) ? data.fiImporteNameAddressVni : null);
    self.fiImporteNameAddress = ko.observable((data && data.hasOwnProperty('fiImporteNameAddress')) ? data.fiImporteNameAddress : null);
    self.fiImporterTel = ko.observable((data && data.hasOwnProperty('fiImporterTel')) ? data.fiImporterTel : null);
    self.fiImporterFax = ko.observable((data && data.hasOwnProperty('fiImporterFax')) ? data.fiImporterFax : null);
    self.fiImporterEmail = ko.observable((data && data.hasOwnProperty('fiImporterEmail')) ? data.fiImporterEmail : null);
    self.fiEntryPointCode = ko.observable((data && data.hasOwnProperty('fiEntryPointCode')) ? data.fiEntryPointCode : null);
    self.fiEntryPointNameVni = ko.observable((data && data.hasOwnProperty('fiEntryPointNameVni')) ? data.fiEntryPointNameVni : null);
    self.fiEntryPointName = ko.observable((data && data.hasOwnProperty('fiEntryPointName')) ? data.fiEntryPointName : null);
    self.fiBorderGateCode = ko.observable((data && data.hasOwnProperty('fiBorderGateCode')) ? data.fiBorderGateCode : null);
    self.fiBordergateNameVni = ko.observable((data && data.hasOwnProperty('fiBordergateNameVni')) ? data.fiBordergateNameVni : null);
    self.fiBordergateName = ko.observable((data && data.hasOwnProperty('fiBordergateName')) ? data.fiBordergateName : null);
    self.fiMeansTransportNameVni = ko.observable((data && data.hasOwnProperty('fiMeansTransportNameVni')) ? data.fiMeansTransportNameVni : null);
    self.fiMeansTransportName = ko.observable((data && data.hasOwnProperty('fiMeansTransportName')) ? data.fiMeansTransportName : null);
    self.fiContaine = ko.observable((data && data.hasOwnProperty('fiContaine')) ? data.fiContaine : null);
    self.fiDepartureDateFrom = ko.observable((data && data.fiDepartureDateFrom) ? new Date(data.fiDepartureDateFrom) : null);
    self.fiExpectingDateFrom = ko.observable((data && data.fiExpectingDateFrom) ? new Date(data.fiExpectingDateFrom) : null);
    self.fiImporterCountryCode = ko.observable((data && data.hasOwnProperty('fiImporterCountryCode')) ? data.fiImporterCountryCode : null);
    self.fiImporterCountryNameVni = ko.observable((data && data.hasOwnProperty('fiImporterCountryNameVni')) ? data.fiImporterCountryNameVni : null);
    self.fiImporterCountryName = ko.observable((data && data.hasOwnProperty('fiImporterCountryName')) ? data.fiImporterCountryName : null);
    self.fiTransitCountryCode = ko.observable((data && data.hasOwnProperty('fiTransitCountryCode')) ? data.fiTransitCountryCode : null);
    self.fiTransitCountryNameVni = ko.observable((data && data.hasOwnProperty('fiTransitCountryNameVni')) ? data.fiTransitCountryNameVni : null);
    self.fiTransitCountryName = ko.observable((data && data.hasOwnProperty('fiTransitCountryName')) ? data.fiTransitCountryName : null);
    self.fiConditionsTransport = ko.observable((data && data.hasOwnProperty('fiConditionsTransport')) ? data.fiConditionsTransport : null);
    self.fiOtherTransport = ko.observable((data && data.hasOwnProperty('fiOtherTransport')) ? data.fiOtherTransport : null);
    self.fiTransportAttrachFile = ko.observable((data && data.hasOwnProperty('fiTransportAttrachFile')) ? data.fiTransportAttrachFile : null);
    self.fiLocationQuarantineVni = ko.observable((data && data.hasOwnProperty('fiLocationQuarantineVni')) ? data.fiLocationQuarantineVni : null);
    self.fiLocationQuarantine = ko.observable((data && data.hasOwnProperty('fiLocationQuarantine')) ? data.fiLocationQuarantine : null);
    self.fiTimeQuarantine = ko.observable((data && data.hasOwnProperty('fiTimeQuarantine')) ? new Date(data.fiTimeQuarantine) : null);
    self.fiHealthCertificateContent = ko.observable((data && data.hasOwnProperty('fiHealthCertificateContent')) ? data.fiHealthCertificateContent : null);
    self.fiHealthCertificateContentVni = ko.observable((data && data.hasOwnProperty('fiHealthCertificateContentVni')) ? data.fiHealthCertificateContentVni : null);

    self.lstCountry = ko.observable(options.lstCountry);

    self.fiImporterCountryCode.subscribe(function (countrycode) {
        if (countrycode) {
            var country = self.lstCountry().filter(function (val) {
                return val.countrycode == countrycode;
            })
            self.fiImporterCountryNameVni(country.length > 0 ? country[0].countryname : '');
            self.fiImporterCountryName(country.length > 0 ? country[0].countryname : '');
        }
    })

    self.fiTransitCountryCode.subscribe(function (countrycode) {
        if (countrycode) {
            var country = self.lstCountry().filter(function (val) {
                return val.countrycode == countrycode;
            })
            self.fiTransitCountryNameVni(country.length > 0 ? country[0].countryname : '');
            self.fiTransitCountryName(country.length > 0 ? country[0].countryname : '');
        }
    })

    self.toJSON = function () {
        var exclude = ["toJSON"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }
        return model;
    }
}
