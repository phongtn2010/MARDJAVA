/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var triggerTab = function (tab) {
    var $tab = $('#' + tab);
    if ($tab.length > 0) {// ?
        $tab.trigger('click');
    }
};
function ResultVM(options) {
    var self = this;

    self.fiIdVb = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiCountryCode = ko.observable(null);
    self.fiPermitNumber = ko.observable(null);
    self.fiBarCode = ko.observable(null);
    self.fiScheduledPassenger = ko.observable(null);
    self.fiNonscheduledPassenger = ko.observable(null);
    self.fiCargo = ko.observable(null);
    self.fiIauthorityName = ko.observable(null);
    self.fiIauthorityAddress = ko.observable(null);
    self.fiIauthorityContact = ko.observable(null);
    self.fiBeneficiaryName = ko.observable(null);
    self.fiBeneficiaryAddress = ko.observable(null);
    self.fiBeneficiaryContact = ko.observable(null);
    self.fiLicenceNumber = ko.observable(null);
    self.fiIntinerary = ko.observable(null);
    self.fiFrequencyOperations = ko.observable(null);
    self.fiMaximumCapacity = ko.observable(null);
    self.fiOtherRestrictions = ko.observable(null);
    self.fiPeriodvalidityFrom = ko.observable(null);
    self.fiPeriodvalidityTo = ko.observable(null);
    self.lsAllocatedNumber58 = ko.observableArray([]);
    self.lstDinhKem = ko.observableArray([]);
    self.fiTenNgKy = ko.observable(null);
    self.fiChucDanh = ko.observable(null);
    self.fiDiaDiem = ko.observable(null);
    self.fiNgayky = ko.observable(null);

    var data = null;
    if (options.vanban) {
        data = options.vanban;

        self.fiTenNgKy(data.chuKyCqxl.fiTenNgKy);
        self.fiChucDanh(data.chuKyCqxl.fiChucDanh);
        self.fiDiaDiem(data.chuKyCqxl.fiDiaDiem);
        self.fiNgayky(new Date(data.chuKyCqxl.fiNgayky).toDayFirstWithTime());

        self.fiScheduledPassenger(data.permit58.fiScheduledPassenger);
        self.fiNonscheduledPassenger(data.permit58.fiNonscheduledPassenger);
        self.fiCargo(data.permit58.fiCargo);
        if (self.fiScheduledPassenger() == 1) {
            $('.fiScheduledPassenger').prop('checked', true);
        }
        if (self.fiNonscheduledPassenger() == 1) {
            $('.fiNonscheduledPassenger').prop('checked', true);
        }
        if (self.fiCargo() == 1) {
            $('.fiCargo').prop('checked', true);
        }
    }
    if (data) {
        ko.mapping.fromJS(data, {}, self);
    }

    if (options.tab) {
        triggerTab('a-tab-mt-2');
    }

}

