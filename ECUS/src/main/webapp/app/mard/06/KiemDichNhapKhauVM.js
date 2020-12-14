function RegAnimalVM(options) {
    var regAnimalVMSelf = this;
    regAnimalVMSelf.productVM = ko.observable(new ProductVM(options, ['fiProductBusinessName', 'fiProductScienceName', 'fiSizeOrType',  'fiQuantity', 'fiPackageUnitCode', 'fiOriginCountryCode']));
    regAnimalVMSelf.exporterVM = ko.observable(new ExporterVM(options, ['fiExporterCountryName', 'fiExporterCountryAddress']));
    regAnimalVMSelf.productMfrVM = ko.observable(new ProdMfrVM(options, ['fiProcessingName', 'fiProcessingAddress']));
    regAnimalVMSelf.isoLocationVM = ko.observable(new IsoLocationVM(options, ['fiLocationQuarantineName', 'fiLocationQuarantineAddress']));

    regAnimalVMSelf.lstPurpose = ko.observableArray([
        "Kinh doanh thực phẩm",
        "Làm giống nuôi thương phẩm",
        "Làm giống bố mẹ",
        "Làm thủ công mĩ nghệ",
        "Làm cảnh",
        "Chế biến thực phẩm",
        "Khác"
    ])

    regAnimalVMSelf.fiTimeQuarantine = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalVMSelf.fiBordergateName = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalVMSelf.fiPurpose = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalVMSelf.fiRelatedDocuments = ko.observable(null);

    regAnimalVMSelf.applyState = function (data) {
        if (data.fiProductList) {
            regAnimalVMSelf.productVM().fiProductList(data.fiProductList);
        }
        if (data.fiExporterCountryList) {
            regAnimalVMSelf.exporterVM().fiExporterCountryList(data.fiExporterCountryList);
        }
        if (data.fiProcessingList) {
            regAnimalVMSelf.productMfrVM().fiProcessingList(data.fiProcessingList);
        }
        if (data.fiLocationQuarantineList) {
            regAnimalVMSelf.isoLocationVM().fiLocationQuarantineList(data.fiLocationQuarantineList);
        }

        regAnimalVMSelf.fiTimeQuarantine((data && data.hasOwnProperty('fiTimeQuarantine')) ? data.fiTimeQuarantine : null);
        regAnimalVMSelf.fiBordergateName((data && data.hasOwnProperty('fiBordergateName')) ? data.fiBordergateName : null);
        regAnimalVMSelf.fiPurpose((data && data.hasOwnProperty('fiPurpose')) ? data.fiPurpose : null);
        regAnimalVMSelf.fiRelatedDocuments((data && data.hasOwnProperty('fiRelatedDocuments')) ? data.fiRelatedDocuments : null);
    }

    regAnimalVMSelf.validateObject = function () {
        return {
            fiTimeQuarantine: regAnimalVMSelf.fiTimeQuarantine,
            fiBordergateName: regAnimalVMSelf.fiBordergateName,
            fiPurpose: regAnimalVMSelf.fiPurpose,
            fiProductList: regAnimalVMSelf.productVM().fiProductList,
            fiExporterCountryList: regAnimalVMSelf.exporterVM().fiExporterCountryList,
            fiProcessingList: regAnimalVMSelf.productMfrVM().fiProcessingList,
            fiLocationQuarantineList: regAnimalVMSelf.isoLocationVM().fiLocationQuarantineList
        }
    }
}

function RegAnimalProductVM(options) {
    var regAnimalProdVMSelf = this;
    regAnimalProdVMSelf.productVM = ko.observable(new ProductVM(options, ['fiProductBusinessName', 'fiSizeOrType',  'fiQuantity', 'fiPackageUnitCode', 'fiOriginCountryCode']));
    regAnimalProdVMSelf.exporterVM = ko.observable(new ExporterVM(options, ['fiExporterCountryName', 'fiExporterCountryAddress']));
    regAnimalProdVMSelf.productMfrVM = ko.observable(new ProdMfrVM(options, ['fiProcessingName', 'fiProcessingAddress']));

    regAnimalProdVMSelf.lstPurpose = ko.observableArray([
        "Kinh doanh thực phẩm",
        "Làm giống nuôi thương phẩm",
        "Làm giống bố mẹ",
        "Làm thủ công mĩ nghệ",
        "Làm cảnh",
        "Chế biến thực phẩm",
        "Khác"
    ])

    regAnimalProdVMSelf.fiTimeQuarantine = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalProdVMSelf.fiBordergateName = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalProdVMSelf.fiPurpose = ko.observable()
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalProdVMSelf.fiPurpose.subscribe(function (item) {
        if (item && item == 'Kinh doanh thực phẩm') {
            regAnimalProdVMSelf.productMfrVM().isRequireApprovalNumber(true);
        } else {
            regAnimalProdVMSelf.productMfrVM().isRequireApprovalNumber(false);
        }
    })
    regAnimalProdVMSelf.fiRelatedDocuments = ko.observable(null);

    regAnimalProdVMSelf.applyState = function(data) {
        if (data.fiProductList) {
            regAnimalProdVMSelf.productVM().fiProductList(data.fiProductList);
        }
        if (data.fiExporterCountryList) {
            regAnimalProdVMSelf.exporterVM().fiExporterCountryList(data.fiExporterCountryList);
        }
        if (data.fiProcessingList) {
            regAnimalProdVMSelf.productMfrVM().fiProcessingList(data.fiProcessingList);
        }

        regAnimalProdVMSelf.fiTimeQuarantine((data && data.hasOwnProperty('fiTimeQuarantine')) ? data.fiTimeQuarantine : null);
        regAnimalProdVMSelf.fiBordergateName((data && data.hasOwnProperty('fiBordergateName')) ? data.fiBordergateName : null);
        regAnimalProdVMSelf.fiPurpose((data && data.hasOwnProperty('fiPurpose')) ? data.fiPurpose : null);
        regAnimalProdVMSelf.fiRelatedDocuments((data && data.hasOwnProperty('fiRelatedDocuments')) ? data.fiRelatedDocuments : null)
    }

    regAnimalProdVMSelf.validateObject = function () {
        return {
            fiTimeQuarantine: regAnimalProdVMSelf.fiTimeQuarantine,
            fiBordergateName: regAnimalProdVMSelf.fiBordergateName,
            fiPurpose: regAnimalProdVMSelf.fiPurpose,
            fiProductList: regAnimalProdVMSelf.productVM().fiProductList,
            fiExporterCountryList: regAnimalProdVMSelf.exporterVM().fiExporterCountryList,
            fiProcessingList: regAnimalProdVMSelf.productMfrVM().fiProcessingList,
        }
    }
}

function KiemDichNhapKhauVM (options) {
    var kdnkVMSelf = this;
    kdnkVMSelf.fiIdHS = ko.observable((options && options.hasOwnProperty('fiIdHS')) ? options.fiIdHS : null);
    kdnkVMSelf.fiNSWFileCode = ko.observable((options && options.hasOwnProperty('fiNSWFileCode')) ? options.fiNSWFileCode : null);
    kdnkVMSelf.fiReason = ko.observable((options && options.hasOwnProperty('fiReason')) ? options.fiReason : null);
    if (options.isRequestEdit) {
        kdnkVMSelf.fiReason.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    }
    kdnkVMSelf.fiHSType = ko.observable((options && options.hasOwnProperty('fiHSType')) ? options.fiHSType : null);
    kdnkVMSelf.thongtinChungVM = ko.observable(new ThongTinChungVM(options));
    kdnkVMSelf.kyHoSoVM = ko.observable(new KyHoSoVM(options));
    kdnkVMSelf.lstProfileStatus = ko.observableArray((options && options.hasOwnProperty('lstProfileStatus')) ? options.lstProfileStatus : null);

    kdnkVMSelf.regAnimalVM = ko.observable(new RegAnimalVM(options));
    kdnkVMSelf.regAnimalProductVM = ko.observable(new RegAnimalProductVM(options));
    if (options.fiHSType == 1 || options.fiHSType == "1") {
        kdnkVMSelf.regAnimalVM().applyState(options);
    } else if (options.fiHSType == 2 || options.fiHSType == "2") {
        kdnkVMSelf.regAnimalProductVM().applyState(options);
    }

    kdnkVMSelf.fiHSType.subscribe(function (item) {
        if (item == 2 || item == '2') {
            kdnkVMSelf.regAnimalProductVM().productVM().fiProductType(kdnkVMSelf.fiHSType());
            kdnkVMSelf.regAnimalProductVM().productVM().fiPackageUnitCode("KG");
        }
    })

    kdnkVMSelf.uploadFileVM = ko.observable(new UploadFileVM(options.fiAttachmentList ? options.fiAttachmentList: [], options.lstAtchType ? options.lstAtchType : []));

    kdnkVMSelf.errorMsg = ko.observable(null);

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
            kyHoSoVM: kdnkVMSelf.kyHoSoVM,
            fiReason: kdnkVMSelf.fiReason
        }
        switch (kdnkVMSelf.fiHSType().toString()) {
            case "1":
                option = $.extend(option, {regAnimalVM: kdnkVMSelf.regAnimalVM().validateObject()});

                kdnkVMSelf.errors = ko.validation.group(option, {deep: true});
                break;
            case "2":
                option = $.extend(option, {regAnimalProductVM: kdnkVMSelf.regAnimalProductVM().validateObject()});

                kdnkVMSelf.errors = ko.validation.group(option, {deep: true});
                break;
            default: return;
        }
        if (kdnkVMSelf.fiHSType() == "2" && 
            kdnkVMSelf.regAnimalProductVM().fiPurpose() == 'Kinh doanh thực phẩm') {
            var hasErrorKDTP = false;
            var lstProcessing = kdnkVMSelf.regAnimalProductVM().productMfrVM().fiProcessingList();
            lstProcessing.forEach(function (processing) {
                console.log('pro', processing);
                if (!processing.fiProcessingApprovalNumber) {
                    hasErrorKDTP = true;
                }
            });
            if (hasErrorKDTP) {
                kdnkVMSelf.errorMsg('Vui lòng nhập mã số của cơ sở nuôi, sản xuất giống, cơ sở sơ chế, chế biến sản phẩm động vật thủy sản tại nước xuất khẩu');
                return false;
            } else {
                kdnkVMSelf.errorMsg(null);
            }
        }
        if (kdnkVMSelf.errors().length > 0) {
            kdnkVMSelf.errors.showAllMessages();
            kdnkVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
            return false;
        }
        kdnkVMSelf.errorMsg('');
        return true;
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
        var body = {
            "fiIdHS": kdnkVMSelf.fiIdHS(),
            "fiNSWFileCode": kdnkVMSelf.fiNSWFileCode(),
            "fiReason": kdnkVMSelf.fiReason(),
            "fiHSStatus": 0,
            "fiHSType": kdnkVMSelf.fiHSType(),
            "fiTaxCode": kdnkVMSelf.thongtinChungVM().fiTaxCode(),
            "fiHSCreatedDate": new Date(kdnkVMSelf.thongtinChungVM().fiHSCreatedDate()).getTime(),
            "fiRegistrationNo": kdnkVMSelf.thongtinChungVM().fiRegistrationNo(),
            "fiImporterAddress": kdnkVMSelf.thongtinChungVM().fiImporterAddress(),
            "fiImporterName": kdnkVMSelf.thongtinChungVM().fiImporterName(),
            "fiImporterTel": kdnkVMSelf.thongtinChungVM().fiImporterTel(),
            "fiImporterFax": kdnkVMSelf.thongtinChungVM().fiImporterFax(),
            "fiImporterEmail": kdnkVMSelf.thongtinChungVM().fiImporterEmail(),
            "fiSignAddress": kdnkVMSelf.kyHoSoVM().fiSignAddress(),
            "fiSignDate": new Date(kdnkVMSelf.kyHoSoVM().fiSignDate()).getTime(),
            "fiSignName": kdnkVMSelf.kyHoSoVM().fiSignName(),
            "fiSignPosition": kdnkVMSelf.kyHoSoVM().fiSignPosition(),
            "fiProductList": [],
            "fiExporterCountryList": [],
            "fiLocationQuarantineList": [],
            "fiProcessingList": [],
            "fiAttachmentList": kdnkVMSelf.uploadFileVM().getLstAttachments()
        }
        switch (kdnkVMSelf.fiHSType().toString()) {
            case "1": {
                body["fiProductList"] = kdnkVMSelf.regAnimalVM().productVM().fiProductList();
                body["fiExporterCountryList"] = kdnkVMSelf.regAnimalVM().exporterVM().fiExporterCountryList();
                body["fiProcessingList"] = kdnkVMSelf.regAnimalVM().productMfrVM().fiProcessingList();
                body["fiLocationQuarantineList"] = kdnkVMSelf.regAnimalVM().isoLocationVM().fiLocationQuarantineList();

                body["fiTimeQuarantine"] = kdnkVMSelf.regAnimalVM().fiTimeQuarantine();
                body["fiBordergateName"] = kdnkVMSelf.regAnimalVM().fiBordergateName();
                body["fiPurpose"] = kdnkVMSelf.regAnimalVM().fiPurpose();
                body["fiRelatedDocuments"] = kdnkVMSelf.regAnimalVM().fiRelatedDocuments();
                break;
            }
            case "2": {
                body["fiProductList"] = kdnkVMSelf.regAnimalProductVM().productVM().fiProductList();
                body["fiExporterCountryList"] = kdnkVMSelf.regAnimalProductVM().exporterVM().fiExporterCountryList();
                body["fiProcessingList"] = kdnkVMSelf.regAnimalProductVM().productMfrVM().fiProcessingList();

                body["fiTimeQuarantine"] = kdnkVMSelf.regAnimalProductVM().fiTimeQuarantine();
                body["fiBordergateName"] = kdnkVMSelf.regAnimalProductVM().fiBordergateName();
                body["fiPurpose"] = kdnkVMSelf.regAnimalProductVM().fiPurpose();
                body["fiRelatedDocuments"] = kdnkVMSelf.regAnimalProductVM().fiRelatedDocuments();
                break;
            }
            default: return;
        }
        return body;
    }
}
