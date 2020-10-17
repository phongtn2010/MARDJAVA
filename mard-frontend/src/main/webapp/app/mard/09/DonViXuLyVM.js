function DonViXyLyVM(lstTramThuY, hoso, callback) {
    var self = this;

    //danh sach tram thu y
    self.lstTramThuY = ko.observableArray(mapCategory(lstTramThuY ? lstTramThuY : []));

    var mapTramThuY = {};

    lstTramThuY.forEach(function (item) {
        mapTramThuY[item.id] = item.name
    });

    //don vi kiem dich
    self.fiDvkd = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });


    // "fiQuarantineDepartmentCode": "BNN-KDDV-I-1",
    //     "fiMonitoringDepartmentCode": "BNN-KDDV-IV-1",

    var fiQuarantineDepartmentNameCode = null;
    var fiQuarantineDepartmentName = null;
    var fiMonitoringDepartmentNameCode = null;
    var fiMonitoringDepartmentName = null;

    if (hoso) {
        fiQuarantineDepartmentNameCode = hoso.fiQuarantineDepartmentCode;
        fiMonitoringDepartmentNameCode = hoso.fiMonitoringDepartmentCode;
        fiQuarantineDepartmentName = mapTramThuY[hoso.fiQuarantineDepartmentCode];
        fiMonitoringDepartmentName = mapTramThuY[hoso.fiMonitoringDepartmentCode];
    }

    //don vi giam sat
    self.fiQuarantineDepartmentName = ko.observable(fiQuarantineDepartmentName);

    self.fiQuarantineDepartmentNameCode = ko.observable(fiQuarantineDepartmentNameCode).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiMonitoringDepartmentNameCode = ko.observable(fiMonitoringDepartmentNameCode).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiMonitoringDepartmentName = ko.observable(fiMonitoringDepartmentName);

    self.onDvgs = function () {
        if (self.fiMonitoringDepartmentNameCode()) {
            self.fiMonitoringDepartmentName($("#fiMaDvgs option:selected").text());
        } else {
            self.fiMonitoringDepartmentName(null);
        }
    };
    self.onDvkd = function () {
        if (self.fiQuarantineDepartmentNameCode()) {
            self.fiQuarantineDepartmentName($("#fiMaDvkd option:selected").text());
        } else {
            self.fiQuarantineDepartmentName(null);
        }
    };

    self.isValid = function() {
        return self.fiQuarantineDepartmentNameCode.isValid() && self.fiMonitoringDepartmentNameCode.isValid()
    };

    self.toJSON = function () {
        return {
            fiQuarantineDepartmentCode: self.fiQuarantineDepartmentNameCode(),
            fiQuarantineDepartmentName: self.fiQuarantineDepartmentName(),
            fiMonitoringDepartmentCode: self.fiMonitoringDepartmentNameCode(),
            fiMonitoringDepartmentName: self.fiMonitoringDepartmentName()
        }
    }
}