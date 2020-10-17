var AddIsoLocationVM = function(isoLocations, onAddIsoLocation) {
    var self = this;
    self.errorMsg = ko.observable(null);
    self.listIsoLocation = ko.observableArray(isoLocations);
    self.fiIsoLocAddress = ko.observable(null);

    self.addIsoLocation = function () {
        var company = isoLocations[$("#frmDiaDiemCachLyKiemDich").prop('selectedIndex') - 1];

        if (company != null) {
            onAddIsoLocation(company);
            self.fiIsoLocAddress(null);
            self.errorMsg(null);
            $("#frmDiaDiemCachLyKiemDich").prop('selectedIndex',0);
            $("#modal_addIsoLocation").modal('toggle')
        } else {
            self.errorMsg("Vui lòng chọn địa điểm cách ly kiểm dịch")
        }
    };

    self.onClose = function() {
        self.fiIsoLocAddress(null);
        self.errorMsg(null);
        $("#frmDiaDiemCachLyKiemDich").prop('selectedIndex',0);
    }


    self.onChooseIsoLocation = function () {
        if ($("#frmDiaDiemCachLyKiemDich").prop('selectedIndex')) {
            var isoLocation = isoLocations[$("#frmDiaDiemCachLyKiemDich").prop('selectedIndex') - 1];
            self.fiIsoLocAddress(isoLocation.fiIsoLocAddress);
        }
    };
};