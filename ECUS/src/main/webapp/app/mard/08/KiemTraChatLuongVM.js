function RegQltVM(data) {
    var reqQltVMSelf = this;
    reqQltVMSelf.exporterVM = ko.observable(new ExporterVM(data, ['fiExporterName', 'fiExporterAddress', 'fiCountryOrigin'],
        NSWLang["mard.08.table.ben_ban_hang"]));
    reqQltVMSelf.productMfrVM = ko.observable(new ProdMfrVM(data, ['fiMfrName', 'fiMfrAddress', 'fiMfrCountryrigin'],
        NSWLang["mard.08.table.co_so_sx"]));
    reqQltVMSelf.productVM = ko.observable(new ProductVM(data, ['fiProductName', 'fiNumber', 'fiUnitCode',
    'fiNetWeight', 'fiNWUnitCode', 'fiGrossWeight', 'fiGWUnitCode', 'fiCountryOrigin'],
        NSWLang["mard.08.table.thong_tin_hang_hoa"]));
    reqQltVMSelf.animalProductVM = ko.observable(new ProductVM(data, ['fiProductName', 'fiNumber', 'fiCountryOrigin'],
        NSWLang["mard.08.table.thong_tin_dong_vat"]));

    reqQltVMSelf.fiStorageLocation = ko.observable(null);
    reqQltVMSelf.fiSamplingDateFrom = ko.observable(null);
    reqQltVMSelf.fiSamplingDateTo = ko.observable(null);
    reqQltVMSelf.fiSamplingLocation = ko.observable(null);
    reqQltVMSelf.fiContactName = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    reqQltVMSelf.fiContactTel = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    reqQltVMSelf.fiContactEmail = ko.observable(null)
        .extend({
            email: {params: true, message: NSWLang["common_msg_invalid_email"]}
        });
    reqQltVMSelf.fiContactAddress = ko.observable(null);
    reqQltVMSelf.fiIntendedPurpose = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    reqQltVMSelf.fiProcessingDate = ko.observable(null);
    reqQltVMSelf.fiProvidedDocument = ko.observable(null);
    reqQltVMSelf.fiSrcPortName = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    reqQltVMSelf.documentsVM = ko.observable((data && data.hasOwnProperty('lstDocument')) ? new DocumentsVM(data.lstDocument, data.lstDocType) : new DocumentsVM([], data.lstDocType));

    reqQltVMSelf.lstDocType = ko.observableArray((data && data.hasOwnProperty('lstDocType')) ? data.lstDocType : []);

    reqQltVMSelf.applyState = function(data) {
        if (data.fiHSType == 4 && data.lstProduct) {
            reqQltVMSelf.animalProductVM().lstProduct(data.lstProduct);
        } else if (data.fiHSType == 5 && data.lstProduct) {
            reqQltVMSelf.productVM().lstProduct(data.lstProduct);
        }
        if (data.lstExporter) {
            reqQltVMSelf.exporterVM().lstExporter(data.lstExporter);
        }
        if (data.lstProdMfr) {
            reqQltVMSelf.productMfrVM().lstProdMfr(data.lstProdMfr);
        }
        reqQltVMSelf.fiStorageLocation((data && data.hasOwnProperty('fiStorageLocation')) ? data.fiStorageLocation : null);
        reqQltVMSelf.fiSamplingDateFrom((data && data.fiSamplingDateFrom) ? new Date(data.fiSamplingDateFrom) : null);
        reqQltVMSelf.fiSamplingDateTo((data && data.fiSamplingDateTo) ? new Date(data.fiSamplingDateTo) : null);
        reqQltVMSelf.fiSamplingLocation((data && data.hasOwnProperty('fiSamplingLocation')) ? data.fiSamplingLocation : null);
        reqQltVMSelf.fiContactName((data && data.hasOwnProperty('fiContactName')) ? data.fiContactName : null);
        reqQltVMSelf.fiContactTel((data && data.hasOwnProperty('fiContactTel')) ? data.fiContactTel : null)

        reqQltVMSelf.fiContactEmail((data && data.hasOwnProperty('fiContactEmail')) ? data.fiContactEmail : null)

        reqQltVMSelf.fiContactAddress((data && data.hasOwnProperty('fiContactAddress')) ? data.fiContactAddress : null);
        reqQltVMSelf.fiIntendedPurpose((data && data.hasOwnProperty('fiIntendedPurpose')) ? data.fiIntendedPurpose : null)

        reqQltVMSelf.fiProcessingDate((data && data.fiProcessingDate) ? data.fiProcessingDate : null);
        reqQltVMSelf.fiProvidedDocument((data && data.hasOwnProperty('fiProvidedDocument')) ? data.fiProvidedDocument : null);
        reqQltVMSelf.fiSrcPortName((data && data.hasOwnProperty('fiSrcPortName')) ? data.fiSrcPortName : null)

        reqQltVMSelf.documentsVM((data && data.hasOwnProperty('lstDocument')) ? new DocumentsVM(data.lstDocument, data.lstDocType) : new DocumentsVM([], data.lstDocType));
    }

    reqQltVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(reqQltVMSelf));
        var exclude = ['productVM', 'exporterVM', 'productMfrVM', 'animalProductVM', 'documentsVM', 'lstDocType', 'fiHSType'];
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.lstExporter = reqQltVMSelf.exporterVM().lstExporter();
        data.lstProdMfr = reqQltVMSelf.productMfrVM().lstProdMfr();
        data.lstDocument = reqQltVMSelf.documentsVM().getData();

        data.fiSamplingDateFrom = reqQltVMSelf.fiSamplingDateFrom() ? new Date(reqQltVMSelf.fiSamplingDateFrom()) : null;
        data.fiSamplingDateTo = reqQltVMSelf.fiSamplingDateTo() ? new Date(reqQltVMSelf.fiSamplingDateTo()) : null;

        return data;
    }

    reqQltVMSelf.validateObject = function (type) {
        return {
            fiContactName: reqQltVMSelf.fiContactName,
            fiContactTel: reqQltVMSelf.fiContactTel,
            fiIntendedPurpose: reqQltVMSelf.fiIntendedPurpose,
            fiSrcPortName: reqQltVMSelf.fiSrcPortName,
            lstProduct: type == 4 ? reqQltVMSelf.animalProductVM().lstProduct : reqQltVMSelf.productVM().lstProduct,
            lstExporter: reqQltVMSelf.exporterVM().lstExporter,
            lstProdMfr: reqQltVMSelf.productMfrVM().lstProdMfr,
            lstDocument: reqQltVMSelf.documentsVM().lstDocuments
        }
    }
}

function BuyerVM(data) {
    var buyerVMSelf = this;
    buyerVMSelf.fiBuyerIdentityNumber = ko.observable((data && data.hasOwnProperty('fiBuyerIdentityNumber')) ? data.fiBuyerIdentityNumber : null)
    buyerVMSelf.fiBuyerIdentityDate = ko.observable((data && data.fiBuyerIdentityDate) ? new Date(data.fiBuyerIdentityDate) : null)
    buyerVMSelf.fiBuyerIdentityPlace = ko.observable((data && data.hasOwnProperty('fiBuyerIdentityPlace')) ? data.fiBuyerIdentityPlace : null);
    buyerVMSelf.fiBuyerName = ko.observable((data && data.hasOwnProperty('fiBuyerName')) ? data.fiBuyerName : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    buyerVMSelf.fiBuyerTel = ko.observable((data && data.hasOwnProperty('fiBuyerTel')) ? data.fiBuyerTel : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    buyerVMSelf.fiBuyerFax = ko.observable((data && data.hasOwnProperty('fiBuyerFax')) ? data.fiBuyerFax : null);
    buyerVMSelf.fiBuyerAddress = ko.observable((data && data.hasOwnProperty('fiBuyerAddress')) ? data.fiBuyerAddress : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    buyerVMSelf.fiImportingDateFrom = ko.observable((data && data.fiImportingDateFrom) ? new Date(data.fiImportingDateFrom) : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    buyerVMSelf.fiImportingDateTo = ko.observable((data && data.fiImportingDateTo) ? new Date(data.fiImportingDateTo) : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
    buyerVMSelf.fiDstPortName = ko.observable((data && data.hasOwnProperty('fiDstPortName')) ? data.fiDstPortName : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });

    buyerVMSelf.lstProvince = ko.observableArray((data && data.hasOwnProperty('lstProvince')) ? data.lstProvince : null);

    buyerVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(buyerVMSelf));
        data.fiBuyerIdentityDate = buyerVMSelf.fiBuyerIdentityDate() ? new Date(buyerVMSelf.fiBuyerIdentityDate()) : null;
        data.fiImportingDateFrom = buyerVMSelf.fiImportingDateFrom() ? new Date(buyerVMSelf.fiImportingDateFrom()) : null;
        data.fiImportingDateTo = buyerVMSelf.fiImportingDateTo() ? new Date(buyerVMSelf.fiImportingDateTo()) : null;

        delete data.lstProvince;
        return data;
    }
}

function KiemTraChatLuongVM(data) {
    var ktclVMSelf = this;
    ktclVMSelf.fiHSType = ko.observable((data && data.hasOwnProperty('fiHSType')) ? data.fiHSType : null);
    ktclVMSelf.fiIdHS = ko.observable((data && data.hasOwnProperty('fiIdHS')) ? data.fiIdHS : null);
    ktclVMSelf.fiHSCode = ko.observable((data && data.hasOwnProperty('fiHSCode')) ? data.fiHSCode : null);
    ktclVMSelf.thongtinChungVM = ko.observable(new ThongTinChungVM(data));
    ktclVMSelf.kyHoSoVM = ko.observable(new KyHoSoVM(data));
    ktclVMSelf.fiModifyReason = ko.observable((data && data.hasOwnProperty('fiModifyReason')) ? data.fiModifyReason : null);
    ktclVMSelf.attachmentVM = ko.observable(new AttachmentVM(data));

    ktclVMSelf.buyerVM = ko.observable(new BuyerVM(data));
    ktclVMSelf.regQltVM = ko.observable(new RegQltVM(data));

    ktclVMSelf.uploadFileVM = ko.observable(new UploadFileVM(data.lstAtch ? data.lstAtch: [], data.lstAtchType20A ? data.lstAtchType20A : []));

    ktclVMSelf.lstProfileStatus = ko.observableArray((data && data.hasOwnProperty('lstProfileStatus')) ? data.lstProfileStatus : null);

    ktclVMSelf.errorMsg = ko.observable(null);

    ktclVMSelf.regQltVM().applyState(data);

    ktclVMSelf.fiHSType.subscribe(function (item) {
        if (item == 5 || item == '5') {
            ktclVMSelf.regQltVM().productVM().productType(ktclVMSelf.fiHSType());
            ktclVMSelf.regQltVM().productVM().fiNWUnitCode("KG");
            ktclVMSelf.regQltVM().productVM().fiGWUnitCode("KG");
            ktclVMSelf.regQltVM().productVM().fiUnitCode("KG");
        }
    })

    ktclVMSelf.getProfileStatus = function (statuscode) {
        var lstProfileStatus = ktclVMSelf.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.id == Number(statuscode);
        })
        if (pos)
            return pos.name;
        else return statuscode;
    }

    ktclVMSelf.validateForm = function() {
        ktclVMSelf.errors = ko.validation.group({
            thongtinChungVM: ktclVMSelf.thongtinChungVM,
            kyHoSoVM: ktclVMSelf.kyHoSoVM,
            buyerVM: ktclVMSelf.buyerVM,
            regQltVM: ktclVMSelf.regQltVM().validateObject(ktclVMSelf.fiHSType())
        }, { deep: true })

        var errorsList = ktclVMSelf.errors().filter(function (el) {
            return el != "";
        });
        if (errorsList.length > 0) {
            ktclVMSelf.errors.showAllMessages();
            ktclVMSelf.errorMsg(NSWLang["common_msg_formvalid_filled"]);
            return false;
        } else {
            ktclVMSelf.errorMsg('');
            return true;
        }
    }

    ktclVMSelf.validateAttachment = function() {
        if (!ktclVMSelf.uploadFileVM().validate()) {
            ktclVMSelf.errorMsg(NSWLang["file_msg_chua_chon_file"]);
            return false;
        } else {
            ktclVMSelf.errorMsg(null);
            return true;
        }
    }

    ktclVMSelf.getData = function () {
        var data = JSON.parse(ko.toJSON(ktclVMSelf));
        var exclude = ['regQltVM', 'buyerVM', 'attachmentVM', 'lstProfileStatus', 'thongtinChungVM', 'kyHoSoVM', 'uploadFileVM'];
        for (var key in data) {
            if (exclude.indexOf(key) >= 0) {
                delete data[key];
            }
        }
        data.lstAtch = ktclVMSelf.uploadFileVM().getLstAttachments();
        data = $.extend(data, ktclVMSelf.thongtinChungVM().getData());
        data = $.extend(data, ktclVMSelf.kyHoSoVM().getData());
        data = $.extend(data, ktclVMSelf.regQltVM().getData());
        data = $.extend(data, ktclVMSelf.buyerVM().getData());
        data.lstProduct = ktclVMSelf.fiHSType() == 4 ? ktclVMSelf.regQltVM().animalProductVM().lstProduct() : ktclVMSelf.regQltVM().productVM().lstProduct();

        return data;
    }
}
