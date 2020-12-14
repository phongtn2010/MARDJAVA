function RegAnimalVM(data) {
    var regAnimalVMSelf = this;
    regAnimalVMSelf.productVM = ko.observable(new ProductVM(data, ['fiProductName', 'fiQtyMale', 'fiQtyFemale', 'fiUnitCode', 'fiCountryOrigin', 'fiPortName'],
        NSWLang["mard.08.table.thong_tin_dong_vat"]));
    regAnimalVMSelf.exporterVM = ko.observable(new ExporterVM(data, ['fiExporterName', 'fiExporterAddress'],
        NSWLang["mard.08.table.cong_ty_xk"]));
    regAnimalVMSelf.isoLocationVM = ko.observable(new IsoLocationVM(data, ['fiIsoLocName', 'fiIsoLocAddress'],
        NSWLang["mard.08.table.dia_diem_kiem_dich"]));

    regAnimalVMSelf.fiProcessingDate = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    regAnimalVMSelf.fiIntendedPurpose = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    regAnimalVMSelf.fiProvidedDocument = ko.observable(null);
    regAnimalVMSelf.fiAnimalFarm = ko.observable(null);
    regAnimalVMSelf.fiAnimalFarmAddress = ko.observable(null);

    regAnimalVMSelf.applyState = function (data) {
        if (data.lstProduct) {
            regAnimalVMSelf.productVM().lstProduct(data.lstProduct);
        }
        if (data.lstExporter) {
            regAnimalVMSelf.exporterVM().lstExporter(data.lstExporter);
        }
        if (data.lstIsolatedLocation) {
            regAnimalVMSelf.isoLocationVM().lstIsolatedLocation(data.lstIsolatedLocation);
        }

        regAnimalVMSelf.fiProcessingDate((data && data.hasOwnProperty('fiProcessingDate')) ? data.fiProcessingDate : null);
        regAnimalVMSelf.fiIntendedPurpose((data && data.hasOwnProperty('fiIntendedPurpose')) ? data.fiIntendedPurpose : null);
        regAnimalVMSelf.fiProvidedDocument((data && data.hasOwnProperty('fiProvidedDocument')) ? data.fiProvidedDocument : null);
        regAnimalVMSelf.fiAnimalFarm((data && data.hasOwnProperty('fiAnimalFarm')) ? data.fiAnimalFarm : null);
        regAnimalVMSelf.fiAnimalFarmAddress((data && data.hasOwnProperty('fiAnimalFarmAddress')) ? data.fiAnimalFarmAddress : null);
    }

    regAnimalVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(regAnimalVMSelf));
        var exclude = ['productVM', 'exporterVM', 'isoLocationVM'];
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.lstProduct = regAnimalVMSelf.productVM().lstProduct();
        data.lstExporter = regAnimalVMSelf.exporterVM().lstExporter();
        data.lstIsolatedLocation = regAnimalVMSelf.isoLocationVM().lstIsolatedLocation();
        return data;
    }

    regAnimalVMSelf.validateObject = {
        fiProcessingDate: regAnimalVMSelf.fiProcessingDate,
        fiIntendedPurpose: regAnimalVMSelf.fiIntendedPurpose,
        lstProduct: regAnimalVMSelf.productVM().lstProduct,
        lstExporter: regAnimalVMSelf.exporterVM().lstExporter,
        lstIsolatedLocation: regAnimalVMSelf.isoLocationVM().lstIsolatedLocation
    }
}

function RegAnimalProductVM(data) {
    var regAnimalProductVMSelf = this;
    regAnimalProductVMSelf.productVM = ko.observable(new ProductVM(data, ['fiProductName', 'fiNumber', 'fiUnitCode', 'fiCountryOrigin', 'fiPortName'],
        NSWLang["mard.08.table.thong_tin_hang_hoa"]));
    regAnimalProductVMSelf.exporterVM = ko.observable(new ExporterVM(data, ['fiExporterName', 'fiExporterAddress'],
        NSWLang["mard.08.table.cong_ty_xk"]));
    regAnimalProductVMSelf.productMfrVM = ko.observable(new ProdMfrVM(data, ['fiMfrName', 'fiMfrAddress'],
        NSWLang["mard.08.table.nha_may_sx"]));

    regAnimalProductVMSelf.fiProcessingDate = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    regAnimalProductVMSelf.fiIntendedPurpose = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    regAnimalProductVMSelf.fiProvidedDocument = ko.observable(null);

    regAnimalProductVMSelf.applyState = function (data) {
        if (data.lstProduct) {
            regAnimalProductVMSelf.productVM().lstProduct(data.lstProduct);
        }
        if (data.lstExporter) {
            regAnimalProductVMSelf.exporterVM().lstExporter(data.lstExporter);
        }
        if (data.lstProdMfr) {
            regAnimalProductVMSelf.productMfrVM().lstProdMfr(data.lstProdMfr);
        }

        regAnimalProductVMSelf.fiProcessingDate((data && data.hasOwnProperty('fiProcessingDate')) ? data.fiProcessingDate : null);
        regAnimalProductVMSelf.fiIntendedPurpose((data && data.hasOwnProperty('fiIntendedPurpose')) ? data.fiIntendedPurpose : null);
        regAnimalProductVMSelf.fiProvidedDocument((data && data.hasOwnProperty('fiProvidedDocument')) ? data.fiProvidedDocument : null);
    }

    regAnimalProductVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(regAnimalProductVMSelf));
        var exclude = ['productVM', 'exporterVM', 'productMfrVM'];
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.lstProduct = regAnimalProductVMSelf.productVM().lstProduct();
        data.lstExporter = regAnimalProductVMSelf.exporterVM().lstExporter();
        data.lstProdMfr = regAnimalProductVMSelf.productMfrVM().lstProdMfr();
        return data;
    };

    regAnimalProductVMSelf.validateObject = {
        fiProcessingDate: regAnimalProductVMSelf.fiProcessingDate,
        fiIntendedPurpose: regAnimalProductVMSelf.fiIntendedPurpose,
        lstProduct: regAnimalProductVMSelf.productVM().lstProduct,
        lstExporter: regAnimalProductVMSelf.exporterVM().lstExporter,
        lstProdMfr: regAnimalProductVMSelf.productMfrVM().lstProdMfr,
    }
}

function RegBoneMealVM(data) {
    var regBoneMealVMSelf = this;
    regBoneMealVMSelf.productVM = ko.observable(new ProductVM(data, ['fiProductName', 'fiNumber', 'fiUnitCode', 'fiCountryOrigin', 'fiPortName'],
        NSWLang["mard.08.table.thong_tin_hang_hoa"]));
    regBoneMealVMSelf.exporterVM = ko.observable(new ExporterVM(data, ['fiExporterName', 'fiExporterAddress'],
        NSWLang["mard.08.table.cong_ty_xk"]));
    regBoneMealVMSelf.productMfrVM = ko.observable(new ProdMfrVM(data, ['fiMfrName', 'fiMfrAddress'],
        NSWLang["mard.08.table.nha_may_sx"]));
    regBoneMealVMSelf.mfgFactoryVM = ko.observable(new MfgFactoryVM(data, ['fiFactoryName', 'fiFactoryAddress'],
        NSWLang["mard.08.table.co_so_sx_tacn"]));

    regBoneMealVMSelf.fiProcessingDate = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    regBoneMealVMSelf.fiIntendedPurpose = ko.observableArray([]);
    regBoneMealVMSelf.fiOtherPurpose = ko.observable(null)
    regBoneMealVMSelf.fiProvidedDocument = ko.observable(null);

    regBoneMealVMSelf.applyState = function (data) {
        if (data.lstProduct) {
            regBoneMealVMSelf.productVM().lstProduct(data.lstProduct);
        }
        if (data.lstExporter) {
            regBoneMealVMSelf.exporterVM().lstExporter(data.lstExporter);
        }
        if (data.lstProdMfr) {
            regBoneMealVMSelf.productMfrVM().lstProdMfr(data.lstProdMfr);
        }
        if (data.lstMfgFactory) {
            regBoneMealVMSelf.mfgFactoryVM().lstMfgFactory(data.lstMfgFactory);
        }

        regBoneMealVMSelf.fiProcessingDate((data && data.hasOwnProperty('fiProcessingDate')) ? data.fiProcessingDate : null);
        if (data && data.hasOwnProperty('fiIntendedPurpose')) {
            var fiIntendedPurpose = data.fiIntendedPurpose.split(',');
            regBoneMealVMSelf.fiIntendedPurpose(fiIntendedPurpose);
        }
        regBoneMealVMSelf.fiProvidedDocument((data && data.hasOwnProperty('fiProvidedDocument')) ? data.fiProvidedDocument : null);
        regBoneMealVMSelf.fiOtherPurpose((data && data.hasOwnProperty('fiOtherPurpose')) ? data.fiOtherPurpose : null);
    }

    regBoneMealVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(regBoneMealVMSelf));
        var exclude = ['productVM', 'exporterVM', 'productMfrVM', 'mfgFactoryVM'];
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.fiIntendedPurpose = regBoneMealVMSelf.fiIntendedPurpose().toString();
        data.lstProduct = regBoneMealVMSelf.productVM().lstProduct();
        data.lstExporter = regBoneMealVMSelf.exporterVM().lstExporter();
        data.lstProdMfr = regBoneMealVMSelf.productMfrVM().lstProdMfr();
        data.lstMfgFactory = regBoneMealVMSelf.mfgFactoryVM().lstMfgFactory();
        return data;
    }

    regBoneMealVMSelf.validateObject = {
        fiProcessingDate: regBoneMealVMSelf.fiProcessingDate,
        lstProduct: regBoneMealVMSelf.productVM().lstProduct,
        lstExporter: regBoneMealVMSelf.exporterVM().lstExporter,
        lstProdMfr: regBoneMealVMSelf.productMfrVM().lstProdMfr,
    }
}

function KiemDichNhapKhauVM(data) {
    var kdnkVMSelf = this;
    kdnkVMSelf.regAnimalVM = ko.observable(new RegAnimalVM(data));
    kdnkVMSelf.regAnimalProductVM = ko.observable(new RegAnimalProductVM(data));
    kdnkVMSelf.regBoneMealVM = ko.observable(new RegBoneMealVM(data));
    kdnkVMSelf.fiHSType = ko.observable((data && data.hasOwnProperty('fiHSType')) ? data.fiHSType : null);
    kdnkVMSelf.fiHSType.subscribe(function (item) {
        if (item == 2 || item == '2') {
            kdnkVMSelf.regAnimalProductVM().productVM().productType(kdnkVMSelf.fiHSType());
            kdnkVMSelf.regAnimalProductVM().productVM().fiUnitCode("KG");
        }
        else if (item == 3 || item == '3') {
            kdnkVMSelf.regBoneMealVM().productVM().productType(kdnkVMSelf.fiHSType());
            kdnkVMSelf.regBoneMealVM().productVM().fiUnitCode("KG");
        }
    })
    kdnkVMSelf.fiIdHS = ko.observable((data && data.hasOwnProperty('fiIdHS')) ? data.fiIdHS : null);
    kdnkVMSelf.fiHSCode = ko.observable((data && data.hasOwnProperty('fiHSCode')) ? data.fiHSCode : null);
    kdnkVMSelf.fiModifyReason = ko.observable((data && data.hasOwnProperty('fiModifyReason')) ? data.fiModifyReason : null);
    kdnkVMSelf.lstProfileStatus = ko.observableArray((data && data.hasOwnProperty('lstProfileStatus')) ? data.lstProfileStatus : null);

    kdnkVMSelf.thongtinChungVM = ko.observable(new ThongTinChungVM(data));
    kdnkVMSelf.kyHoSoVM = ko.observable(new KyHoSoVM(data));

    kdnkVMSelf.errorMsg = ko.observable(null);

    kdnkVMSelf.uploadFileVM = ko.observable(new UploadFileVM(data.lstAtch ? data.lstAtch : [], data.lstAtchType20 ? data.lstAtchType20 : []));

    if (data.fiHSType == 1) {
        kdnkVMSelf.regAnimalVM().applyState(data);
    } else if (data.fiHSType == 2) {
        kdnkVMSelf.regAnimalProductVM().applyState(data);
    } else if (data.fiHSType == 3) {
        kdnkVMSelf.regBoneMealVM().applyState(data);
    }

    kdnkVMSelf.getProfileStatus = function (statuscode) {
        var lstProfileStatus = kdnkVMSelf.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.id == Number(statuscode);
        })
        if (pos)
            return pos.name;
        else return statuscode;
    }

    kdnkVMSelf.validateForm = function () {
        var option = {
            thongtinChungVM: kdnkVMSelf.thongtinChungVM,
            kyHoSoVM: kdnkVMSelf.kyHoSoVM
        }
        switch (kdnkVMSelf.fiHSType().toString()) {
            case "1":
                option = $.extend(option, {regAnimalVM: kdnkVMSelf.regAnimalVM().validateObject});

                kdnkVMSelf.errors = ko.validation.group(option, {deep: true});
                break;
            case "2":
                option = $.extend(option, {regAnimalProductVM: kdnkVMSelf.regAnimalProductVM().validateObject});

                kdnkVMSelf.errors = ko.validation.group(option, {deep: true});
                break;
            case "3":
                option = $.extend(option, {regBoneMealVM: kdnkVMSelf.regBoneMealVM().validateObject});

                kdnkVMSelf.errors = ko.validation.group(option, {deep: true});
                break;
            default:
                return;
        }
        if (kdnkVMSelf.errors().length > 0) {
            kdnkVMSelf.errors.showAllMessages();
            kdnkVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
            return false;
        } else {
            kdnkVMSelf.errorMsg('');
            return true;
        }
    }

    kdnkVMSelf.validateAttachment = function () {
        if (!kdnkVMSelf.uploadFileVM().validate()) {
            kdnkVMSelf.errorMsg(NSWLang["file_msg_chua_chon_file"]);
            return false;
        } else {
            kdnkVMSelf.errorMsg(null);
            return true;
        }
    }

    kdnkVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(kdnkVMSelf));
        var exclude = ['regAnimalVM', 'regAnimalProductVM', 'regBoneMealVM', 'lstProfileStatus', 'thongtinChungVM', 'kyHoSoVM', 'uploadFileVM'];
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.lstAtch = kdnkVMSelf.uploadFileVM().getLstAttachments();
        data = $.extend(data, kdnkVMSelf.thongtinChungVM().getData());
        data = $.extend(data, kdnkVMSelf.kyHoSoVM().getData());
        switch (kdnkVMSelf.fiHSType().toString()) {
            case "1":
                data = $.extend(data, kdnkVMSelf.regAnimalVM().getData());
                break;
            case "2":
                data = $.extend(data, kdnkVMSelf.regAnimalProductVM().getData());
                break;
            case "3":
                data = $.extend(data, kdnkVMSelf.regBoneMealVM().getData());
                break;
            default:
                return;
        }

        return data;
    }
}
