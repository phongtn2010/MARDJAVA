function Form03VM(data, options) {
    var self = this;
    var hoso = options.hoso ? options.hoso : {};
    self.lstUOMs = ko.observable((options && options.hasOwnProperty('lstUOMs')) ? options.lstUOMs : []);
    data.lstUOMs = options.lstUOMs;
    self.fiDispatchType = ko.observable(data.fiQuarantineType);//1 DONG VAT, 2 SPDV, 3 BOT THIT XUONG, 4 DONG THOI DONG VAT, 5 DONG THOI SPDV
    self.fiProductType = data.fiQuarantineType;
    self.isAnimal = ko.observable(self.fiProductType === 1);
    self.lstGoodForChoose = ko.observableArray(mapTbdGoods03(data.lstGood));

    self.fiHSType = ko.observable(1);
    self.fiHSStatus = ko.observable(0);
    self.fiHSCode = ko.observable(hoso ? hoso.fiHSCode : null);
    self.fiIdHS = ko.observable(hoso ? hoso.fiIdHS : null);

    self.lstGood = ko.observableArray([]).extend({
        validation: {
            validator: function (val, params) {
                return val.length >= params;
            },
            message: "Thông tin hàng hóa " + NSWLang["common_msg_formvalid_isrequired"],
            params: 1
        }
    });
    self.lstCompany = ko.observableArray([]).extend({
        validation: {
            validator: function (val, params) {
                return val.length >= params;
            },
            message: "Công ty xuất khẩu " + NSWLang["common_msg_formvalid_isrequired"],
            params: 1
        }
    });
    self.lstQuarantine = ko.observableArray([]).extend({
        validation: {
            validator: function (val, params) {
                if (data.fiQuarantineType === 1) {
                    return val.length >= params;
                }
                return true;
            },
            message: "Nơi cách ly kiểm dịch " + NSWLang["common_msg_formvalid_isrequired"],
            params: 1
        }
    });
    self.lstManufacture = ko.observableArray([]).extend({
        validation: {
            validator: function (val, params) {
                if (data.fiQuarantineType > 1) {
                    return val.length >= params;
                }
                return true;
            },
            message: "Nhà máy sản xuất chế biến " + NSWLang["common_msg_formvalid_isrequired"],
            params: 1
        }
    });
    self.fiPurpose = ko.observable(data.fiPurpose).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiQuarantineTimeFrom = ko.observable(null);
    self.fiQuarantineTimeTo = ko.observable(null);
    // self.filesVM = ko.observable(new AttachmentVM(data.lstAtch3));
    self.kyHoSoVM = ko.observable(new KyHoSoVM(options)).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiExportCountryName = ko.observable(hoso.fiExportCountryName).trimmed();
    self.fiExportCountryCode = ko.observable(hoso.fiExportCountryCode).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiImportCountryCode = ko.observable(hoso.fiImportCountryCode).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiImportCountryName = ko.observable(hoso.fiImportCountryName).trimmed();

    self.fiExportPortDestCode = ko.observable(hoso.fiExportPortDestCode).trimmed();
    self.fiExportPortDestName = ko.observable(hoso.fiExportPortDestName).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTransportType = ko.observable(hoso.fiTransportType).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMonitoringLocName = ko.observable(hoso.fiMonitoringLocName).trimmed();
    self.fiMonitoringLocTimeFrom = ko.observable(hoso.fiMonitoringLocTimeFrom ? new Date(hoso.fiMonitoringLocTimeFrom) : null).trimmed();
    self.fiMonitoringLocTimeTo = ko.observable(hoso.fiMonitoringLocTimeTo ? new Date(hoso.fiMonitoringLocTimeTo) : null).trimmed();
    self.fiCertificateQuantity = ko.observable(hoso.fiCertificateQuantity).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiContractNo = ko.observable(hoso.fiContractNo).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiImportContactPerson = ko.observable(hoso.fiImportContactPerson).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiExportContactPerson = ko.observable(hoso.fiExportContactPerson).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiBillOfLadingNo = ko.observable(hoso.fiBillOfLadingNo).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiBillOfLadingIssuedDate = ko.observable(hoso.fiBillOfLadingIssuedDate ? new Date(hoso.fiBillOfLadingIssuedDate) : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiQuarantineName = ko.observable(hoso.fiQuarantineName).trimmed();

    self.validateForm = function () {
        var option = {
            fiPurpose: self.fiPurpose,
            fiQuarantineTimeFrom: self.fiQuarantineTimeFrom,
            fiQuarantineTimeTo: self.fiQuarantineTimeTo,
            fiExportCountryCode: self.fiExportCountryCode,
            fiImportCountryCode: self.fiImportCountryCode,
            fiExportPortDestName: self.fiExportPortDestName,
            fiCertificateQuantity: self.fiCertificateQuantity,
            fiContractNo: self.fiContractNo,
            fiExportContactPerson: self.fiExportContactPerson,
            kyHoSoVM: self.kyHoSoVM,
            fiTransportType: self.fiTransportType,
            fiImportContactPerson: self.fiImportContactPerson,
            fiBillOfLadingNo: self.fiBillOfLadingNo,
            fiBillOfLadingIssuedDate: self.fiBillOfLadingIssuedDate
        };
        self.errors = ko.validation.group(option, {deep: true});
        if (self.errors().length > 0) {
            self.errors.showAllMessages();
            return false;
        } else {
            return true;
        }
    };

    self.validateList = function () {
        var valid = true;
        if (data.fiQuarantineType === 1) {
            valid = valid && (self.lstQuarantine().length > 0)
        } else {
            // valid = valid && (self.lstManufacture().length > 0)
        }

        return valid && self.lstGood().length > 0 && self.lstCompany().length > 0
    };

    self.uploadFileVM = ko.observable(new UploadFileVM(hoso ? hoso.lstAtch ? hoso.lstAtch : [] : [], options.lstAtch3 ? options.lstAtch3 : []));

    self.lstAtchGr = ko.observableArray([]);

    if (options.lstAtch) {
        self.lstAtchGr(mapAttachmentVM(options.lstAtch));
    }
    if (options.lstAtch3) {
        for (var i = 0; i < options.lstAtch3.length; i++) {
            var attachment = new AttachmentVM({
                fiTenLoai: options.lstAtch3[i].name,
                fiMaLoai: options.lstAtch3[i].id
            });
            self.lstAtchGr.push(attachment);
        }
    }

    self.isValid = function () {
        var valid = true;
        if (data.fiQuarantineType === 1) {
            valid = valid && (self.lstQuarantine().length > 0)
        } else {
            valid = valid && (self.lstManufacture().length > 0)
        }
        return valid && self.fiPurpose.isValid()
            && self.fiPurpose.isValid()
            && self.fiQuarantineTimeFrom.isValid()
            && self.fiQuarantineTimeTo.isValid()
            && self.fiExportCountryCode.isValid()
            && self.fiImportCountryCode.isValid()
            && self.fiExportPortDestName.isValid()
            && self.fiTransportType.isValid()
            && self.fiCertificateQuantity.isValid()
            && self.fiContractNo.isValid()
            && self.fiImportContactPerson.isValid()
            && self.fiExportContactPerson.isValid()
            && self.kyHoSoVM().isValid()
            && self.lstGood().length > 0
            && self.lstCompany().length > 0
    };

    self.getlstAtchs = function () {
        var lstAtchGr = self.uploadFileVM().lstAtch();
        var result = [];
        for (var i = 0; i < lstAtchGr.length; i++) {
            var lstFiles = JSON.parse(ko.toJSON(lstAtchGr[i].lstFiles()));
            result = result.concat(lstFiles);
        }
        return result;
    };

    self.frmAddGood = ko.observable(new AddGoodVM(data, function (productToAdd) {
        var good = new Goods03(self.lstGood().length + 1, productToAdd);
        var isUpdate = false;
        for (var i = 0; i < self.lstGood().length; i++) {
            if (self.lstGood()[i].fiProductCode().indexOf(good.fiProductCode()) >= 0) {
                self.lstGood.replace(self.lstGood()[i], good);
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            self.lstGood.push(good)
        }
    }));

    self.updateGoods03 = function (index, data) {
        self.frmAddGood().update(index, data);
    };

    self.frmAddCompany = ko.observable(new AddCompanyVM(data.lstCompany, function (companyToAdd) {
        var company = new Company03(self.lstCompany().length + 1, companyToAdd);
        var isUpdate = false;
        for (var i = 0; i < self.lstCompany().length; i++) {
            if (self.lstCompany()[i].fiIdExporter() === company.fiIdExporter()) {
                self.lstCompany.replace(self.lstCompany()[i], company);
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            self.lstCompany.push(company)
        }
    }));

    self.frmAddIsoLocation = ko.observable(new AddIsoLocationVM(data.lstIsoLoc, function (isoLocationToAdd) {
        var isoLoc = new IsoLoc03(self.lstQuarantine().length + 1, isoLocationToAdd);
        var isUpdate = false;
        for (var i = 0; i < self.lstQuarantine().length; i++) {
            if (self.lstQuarantine()[i].fiIdQuarLoc() === isoLoc.fiIdQuarLoc()) {
                self.lstQuarantine.replace(self.lstQuarantine()[i], isoLoc);
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            self.lstQuarantine.push(isoLoc)
        }
    }));

    self.frmAddMfs = ko.observable(new AddMfsVM(data.lstMfr, function (mfs) {

        var mfss = new Mfs03(self.lstManufacture().length + 1, mfs);
        var isUpdate = false;
        for (var i = 0; i < self.lstManufacture().length; i++) {
            if (self.lstManufacture()[i].fiIdFactory() === mfss.fiIdFactory()) {
                self.lstManufacture.replace(self.lstQuarantine()[i], mfss);
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            self.lstManufacture.push(mfss)
        }

    }));

    if (hoso) {
        if (hoso.fiQuarantineTimeFrom) {
            self.fiQuarantineTimeFrom(new Date(hoso.fiQuarantineTimeFrom))
        }
        if (hoso.fiQuarantineTimeTo) {
            self.fiQuarantineTimeTo(new Date(hoso.fiQuarantineTimeTo))
        }
    }


    if (hoso && hoso.lstGood && hoso.lstExporter && hoso.lstIsolatedLocation && hoso.lstProdMfr) {
        hoso.lstGood.forEach(function (item) {
            self.lstGood.push(new Goods03(self.lstGood().length + 1, item))
        });

        hoso.lstExporter.forEach(function (item) {
            self.lstCompany.push(new Company03(self.lstCompany().length + 1, item))
        });

        hoso.lstIsolatedLocation.forEach(function (item) {
            self.lstQuarantine.push(new IsoLoc03(self.lstQuarantine().length + 1, item))
        });

        hoso.lstProdMfr.forEach(function (item) {
            self.lstManufacture.push(new Mfs03(self.lstManufacture().length + 1, item))
        })
    }

    self.onDeleteManufacture = function (index) {
        self.lstManufacture.splice(index, 1);
    };

    self.onDeleteQuarantine = function (index) {
        self.lstQuarantine.splice(index, 1);
    };

    self.onDeleteCompany = function (index) {
        self.lstCompany.splice(index, 1);
    };

    self.onDeleteGoods = function (index) {
        self.lstGood.splice(index, 1);
    };

    self.onNuocNhapKhauPick = function () {

    };

    self.onNuocXuatKhauPick = function () {

    };


    self.toJSON = function () {
        var exclude = ["toJSON",
            "onNuocXuatKhauPick",
            "onNuocNhapKhauPick",
            "updateGoods03",
            "kyHoSoVM",
            "fiDispatchType",
            "frmAddCompany",
            "frmAddGood",
            "frmAddIsoLocation",
            "frmAddMfs",
            "lstCompany",
            "lstGoodForChoose",
            "lstManufacture",
            "lstAtchGr",
            "lstQuarantine",
            "uploadFileVM"];

        var model = ko.toJS(self);

        model = $.extend(model, self.kyHoSoVM().toJSON());

        model.lstProdMfr = mapMfgFactoryToSend(model.lstManufacture);
        model.lstExporter = mapExporterToSend(model.lstCompany);
        model.lstGood = mapProduct03ToSend(model.lstGood);
        model.lstIsolatedLocation = mapIsolatedLocationToSend(model.lstQuarantine);

        model.lstAtch = self.getlstAtchs();

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}

function mapExporterToSend(list) {
    var rs = [];

    for (var i = 0; i < list.length; i++) {
        rs.push({
            fiExporterName: list[i].fiCompanyName,
            fiExporterAddress: list[i].fiCompanyAddress
        })
    }

    return rs;
}

function mapMfgFactoryToSend(list) {
    var rs = [];

    for (var i = 0; i < list.length; i++) {
        rs.push({
            fiCompanyName: list[i].fiManufactureName,
            fiCompanyAddress: list[i].fiManufactureAddress
        })
    }

    return rs;
}

function mapIsolatedLocationToSend(list) {
    var rs = [];

    for (var i = 0; i < list.length; i++) {
        rs.push({
            fiIsoLocName: list[i].fiQuarantineName,
            fiIsoLocAddress: list[i].fiQuarantineAddress
        })
    }

    return rs;
}

function mapProduct03ToSend(goods) {
    var rs = [];


    for (var i = 0; i < goods.length; i++) {
        rs.push({
            fiProductCode: goods[i].fiProductCode,
            fiProductName: goods[i].fiProductName,
            fiProductScienceName: goods[i].fiProductScienceName,
            fiNumber: goods[i].fiNumber === "-" ? null : goods[i].fiNumber,
            fiPackingWay: goods[i].fiPackingType === "-" ? null : goods[i].fiPackingType,
            fiUnitCode: goods[i].fiUnitCode === "-" ? null : goods[i].fiUnitCode,
            fiUnitName: goods[i].fiUnitName === "-" ? null : goods[i].fiUnitName,
            fiNetWeight: goods[i].fiNetWeight === "-" ? null : goods[i].fiNetWeight,
            fiNWUnitCode: goods[i].fiNWUnitCode === "-" ? null : goods[i].fiNWUnitCode,
            fiNWUnitName: goods[i].fiNWUnitName === "-" ? null : goods[i].fiNWUnitName,
            fiGrossWeight: goods[i].fiGrossWeight === "-" ? null : goods[i].fiGrossWeight,
            fiGWUnitCode: goods[i].fiGWUnitCode === "-" ? null : goods[i].fiGWUnitCode,
            fiGWUnitName: goods[i].fiGWUnitName === "-" ? null : goods[i].fiGWUnitName,
            fiCountryOrigin: goods[i].fiCountryOrigin === "-" ? null : goods[i].fiCountryOrigin,
            fiCountryOriginName: goods[i].fiCountryOriginName === "-" ? null : goods[i].fiCountryOriginName,
            fiQuantityFemale: goods[i].fiQtyFemale === "-" ? null : goods[i].fiQtyFemale,
            fiQuantityMale: goods[i].fiQtyMale === "-" ? null : goods[i].fiQtyMale,
            fiAge: goods[i].fiAge === "-" ? null : goods[i].fiAge,
            fiImportPortOfDestName: goods[i].fiPortName === "-" ? null : goods[i].fiPortName,
            fiImportPortDestCode: goods[i].fiPortCode === "-" ? null : goods[i].fiPortCode
            // fiImportPortDestCode: goods[i].
        })
    }

    return rs;
}