/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Buyer20a(options) {
    var self = this;

    var buyerData = null;
    var hoso = options.hoso;
    if (hoso) {
        buyerData = {
            fiBuyerName: hoso.fiBuyer.fiBuyerName,
            fiBuyerIdentityNo: hoso.fiBuyer.fiBuyerIdentityNo,
            fiBuyerDateOfIdentity: hoso.fiBuyer.fiBuyerDateOfIdentity ? new Date(hoso.fiBuyer.fiBuyerDateOfIdentity) : null,
            fiBuyerPlaceOfIdentity: hoso.fiBuyer.fiBuyerPlaceOfIdentity,
            fiBuyerAddress: hoso.fiBuyer.fiBuyerAddress,
            fiBuyerTel:hoso.fiBuyer.fiBuyerTel,
            fiBuyerFax:hoso.fiBuyer.fiBuyerFax ,
            fiPortOfDestinationName: hoso.fiBuyer.fiPortOfDestinationName,
            fiImportingDateFrom: new Date(hoso.fiBuyer.fiImportingDateFrom),
            fiImportingDateTo: new Date(hoso.fiBuyer.fiImportingDateTo),
            fiLadingBill: hoso.fiBuyer.fiLadingBill,
            fiLadingBillDate: new Date(hoso.fiBuyer.fiLadingBillDate)
        }
    }

    self.fiBuyerName = ko.observable(buyerData ? buyerData.fiBuyerName : user.companyName).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiBuyerIdentityNo = ko.observable(buyerData ? buyerData.fiBuyerIdentityNo : null).trimmed();
    self.fiBuyerDateOfIdentity = ko.observable(buyerData ? buyerData.fiBuyerDateOfIdentity : null).trimmed();
    self.fiBuyerPlaceOfIdentity = ko.observable(buyerData ? buyerData.fiBuyerPlaceOfIdentity : null).trimmed();
    self.fiBuyerAddress = ko.observable(buyerData ? buyerData.fiBuyerAddress : user.companyAddress).trimmed();
    self.fiBuyerTel = ko.observable(buyerData ? buyerData.fiBuyerTel : user.companyPhoneNumber).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiBuyerFax = ko.observable(buyerData ? buyerData.fiBuyerFax : null).trimmed();
    self.fiPortOfDestinationName = ko.observable(buyerData ? buyerData.fiPortOfDestinationName : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiImportingDateFrom = ko.observable(buyerData ? buyerData.fiImportingDateFrom : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiImportingDateTo = ko.observable(buyerData ? buyerData.fiImportingDateTo : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiLadingBill = ko.observable(buyerData ? buyerData.fiLadingBill : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});
    self.fiLadingBillDate = ko.observable(buyerData ? buyerData.fiLadingBillDate : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});


    self.isValid = function () {
        return self.fiBuyerName.isValid()
            && self.fiBuyerAddress.isValid()
            && self.fiBuyerTel.isValid()
            && self.fiPortOfDestinationName.isValid()
            && self.fiImportingDateFrom.isValid()
            && self.fiImportingDateTo.isValid()
            && self.fiLadingBill.isValid()
            && self.fiLadingBillDate.isValid()
    }
}

function Form20VM(license, options) {
    var self = this;
    var hoso = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //Thong tin chung
    self.fiHSType = ko.observable(2).trimmed();
    self.fiHSStatus = ko.observable(hoso ? hoso.fiHSStatus : 0).trimmed();
    self.fiProductType = license.fiQuarantineType;
    self.isAnimal = ko.observable(self.fiProductType === 4).trimmed();
    self.lstCuakhau = ko.observableArray(license.lstCuakhau);
    self.lstCountry = ko.observableArray(license.lstQuocgia);

    self.fiHSCode = ko.observable(hoso ? hoso.fiHSCode : null).trimmed();
    self.fiIdHS = ko.observable(hoso ? hoso.fiIdHS : null).trimmed();

    self.fiBuyer = ko.observable(new Buyer20a(options)).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    self.fiStorageLocation = ko.observable(hoso ? hoso.fiStorageLocation : null).trimmed().extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    self.fiHoatdong = ko.observable(1);

    self.fiTenTt = ko.observable("Tạo mới");
    self.uploadFileVM = ko.observable(new UploadFileVM(hoso ? hoso.lstAtch ? hoso.lstAtch : [] : [], options ? options.lstAtch20a : []));


    self.fiSamplingDateFrom = ko.observable(hoso ? hoso.fiSamplingDateFrom ? new Date(hoso.fiSamplingDateFrom) : null : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiSamplingDateTo = ko.observable(hoso ? hoso.fiSamplingDateTo ? new Date(hoso.fiSamplingDateTo) : null : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiSamplingLocation = ko.observable(hoso ? hoso.fiSamplingLocation : null).trimmed().extend({
    });

    self.fiContactName = ko.observable(hoso ? hoso.fiContactName : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });
    self.fiContactAddress = ko.observable(hoso ? hoso.fiContactAddress : null);
    self.fiContactTel = ko.observable(hoso ? hoso.fiContactTel : null).trimmed().extend({
    });

    self.fiPurpose = ko.observable(license ? license.fiPurpose : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiSoCv = ko.observable(null).trimmed();

    self.lstSeller =  ko.observableArray([]);
    self.lstGood =  ko.observableArray([]);
    self.lstProdMfr = ko.observableArray([]);

    self.onDeleteGoods = function(item) {
        self.lstGood.splice(item, 1);
    };

    self.onDeleteSeller = function(item) {
        self.lstSeller.splice(item, 1);
    };

    self.onUpdateSeller = function(index, data) {
        self.frmAddExporter().update(index, data);
    };

    self.onDeleteProdMfr = function(item) {
        self.lstProdMfr.splice(item, 1);
    };

    self.documentsVM = ko.observable(new DocumentsVM(hoso ? hoso.lstDocument : [], options.lstDocumentTypes)).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});


    self.validateForm = function() {
        var option = {
            fiPurpose: self.fiPurpose,
            fiSamplingDateFrom: self.fiSamplingDateFrom,
            fiSamplingDateTo: self.fiSamplingDateTo,
            fiSamplingLocation: self.fiSamplingLocation,
            fiContactName: self.fiContactName,
            fiContactTel: self.fiContactTel,
            kyHoSoVM: self.kyHoSoVM,
            fiBuyer: self.fiBuyer,
            fiStorageLocation: self.fiStorageLocation
        };

        self.errors = ko.validation.group(option, { deep: true });
        if (self.errors().length > 0) {
            self.errors.showAllMessages();
            return false;
        } else {
            return true;
        }
    };

    self.isValidList = function() {
        return self.lstSeller().length > 0
            && self.lstGood().length > 0 && self.documentsVM().isValid()
    };

    self.isValid = function () {
        return self.fiBuyer().isValid()
            && self.lstSeller().length > 0
            && self.lstGood().length > 0
            && self.fiPurpose.isValid()
            && self.fiSamplingDateFrom.isValid()
            && self.fiSamplingDateTo.isValid()
            && self.fiSamplingLocation.isValid()
            && self.fiContactName.isValid()
            && self.fiContactTel.isValid()
            && self.kyHoSoVM().isValid()
            && self.documentsVM().isValid()
    };

    if (hoso) {
        self.fiPurpose(hoso.fiPurpose);
        hoso.lstSeller.forEach(function (value) {
            self.lstSeller.push(new Exporter20(self.lstSeller().length + 1, value))
        });
        hoso.lstGood.forEach(function (value) {
            self.lstGood.push(new Goods03(self.lstGood().length + 1, value))
        });
        hoso.lstProdMfr.forEach(function (value) {
            self.lstProdMfr.push(new Mfs03(self.lstProdMfr().length + 1, value))
        });
    }

    self.kyHoSoVM = ko.observable(new KyHoSoVM(options)).extend({ required: {params: true, message: NSWLang["common_msg_formvaild_required"]}});

    // self.filesVM = ko.observable(new AttachmentVM(license.lstAtch20a));

    self.lstAtchGr = ko.observableArray([]);

    if (options.lstAtch) {
        self.lstAtchGr(mapAttachmentVM(options.lstAtch));
    }
    if (options.lstAtch20a) {
        for (var i = 0; i < options.lstAtch20a.length; i++) {
            var attachment = new AttachmentVM({
                fiTenLoai: options.lstAtch20a[i].name,
                fiMaLoai: options.lstAtch20a[i].id
            });
            self.lstAtchGr.push(attachment);
        }
    }

    self.getlstAtchs = function() {
        var lstAtchGr = self.uploadFileVM().lstAtch();
        var result = [];
        for (var i = 0; i < lstAtchGr.length; i++) {
            var lstFiles = JSON.parse(ko.toJSON(lstAtchGr[i].lstFiles()));
            result = result.concat(lstFiles);
        }
        return result;
    };




    self.frmAddGood = ko.observable(new AddGood20VM(license, options.mapQuocgia, options.mapCuakhau, function (productToAdd) {
        var good = new Goods03(self.lstGood().length + 1, productToAdd);
        var isUpdate = false;
        for (var i = 0; i < self.lstGood().length; i++){
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

    self.frmAddExporter = ko.observable(new AddExporter20VM(license.lstCompany, function (exporterToAdd) {
        self.lstSeller.push(new Exporter20(self.lstSeller().length + 1, exporterToAdd))
    }));

    self.frmAddMfs = ko.observable(new AddMfsVM20a(license.lstMfr, function (mfs) {
        var mfss = new Mfs03(self.lstProdMfr().length + 1, mfs);
        var isUpdate = false;
        for (var i = 0; i < self.lstProdMfr().length; i++){
            if (self.lstProdMfr()[i].fiIdFactory() === mfss.fiIdFactory()) {
                self.lstProdMfr.replace(self.lstProdMfr()[i], mfss);
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            self.lstProdMfr.push(mfss)
        }
    }));

    self.updateGoods20 = function(index, data) {
        self.frmAddGood().update(index, data);
    };

    self.isValidForm = function () {
        delete self.hoangHoaVM;
        delete self.pop;
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorHangHoa = true;

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        /*if (self.fiNgayKy() == null) {
         alert('Ngày ký là thông tin bắt buộc.');
         errorHoso = false;
         return errorHoso;
         }*/

        if (!self.lstHanghoas() || self.lstHanghoas().length <= 0) {
            self.errorHangHoaMessage('* Chưa khai báo thông tin hàng hoá');
            errorHangHoa = false;
            return errorHangHoa;
        }

        return errorHoso && errorHangHoa;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.removeProductClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của sản phẩm này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstHanghoas.remove(function (o) {
                                return o.group() == item.group();
                            });
                            for (var i = 0; i < self.lstHanghoas().length; i++) {
                                self.lstHanghoas()[i].fiStt(i + 1);
                            }
                            app.popupRemove(pop.selector);
                        }
                    },
                    {
                        name: 'Huỷ',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        }
    };

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["lstGoodForChoose", "frmAddExporter", "frmAddGood",
            "frmAddMfs", "kyHoSoVM", "init", "lstCountry", "lstCuakhau",
            "lstCqgsBac", "lstCqgsNam", "lstCqgsTrung", "toJSON", "removeProductClick",
            "fiDocument1Number", "fiDocument2Number", "fiDocument3Number", "documentsVM",
        "fiDocument1Date", "fiDocument2Date", "fiDocument3Date", "fiTenTt", "fiHoatdong"];

        var model = ko.toJS(self);

        model = $.extend(model, self.kyHoSoVM().toJSON());

        model.lstAtch = self.getlstAtchs();

        model.lstDocument = self.documentsVM().toJSON()

        model.lstGood = mapGoods20ToSend(model.lstGood);
        model.lstProdMfr = mapMfgFactoryToSend(model.lstProdMfr);
        model.lstSeller = mapSellerToSend(model.lstSeller);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}


function mapGoods20ToSend(goods) {
    var rs = [];

    for (var i = 0; i < goods.length; i++) {
        rs.push({
            fiProductCode: goods[i].fiProductCode,
            fiProductName: goods[i].fiProductName,
            fiProductScienceName: goods[i].fiProductScienceName,
            fiNumber: goods[i].fiNumber === "-" ? null : goods[i].fiNumber,
            fiPackingWay: goods[i].fiPackingType === "-" ? null :goods[i].fiPackingType,
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
            fiQuantityFemale:  goods[i].fiQuantityFemale === "-" ? null : goods[i].fiQtyFemale,
            fiQuantityMale: goods[i].fiQuantityMale === "-" ? null : goods[i].fiQtyMale,
            fiAge: goods[i].fiAge === "-" ? null : goods[i].fiAge,
            fiCirculateNo: goods[i].fiCirculateNo,
            fiImportPortOfDestName: goods[i].fiPortName === "-" ? null : goods[i].fiPortName,
            fiImportPortDestCode: goods[i].fiPortCode === "-" ? null : goods[i].fiPortCode,
            // fiPackingWay: goods[]
        })
    }

    return rs;
}

function mapMfgFactoryToSend(mfgFactories) {
    var rs = [];

    for (var i = 0; i < mfgFactories.length; i++) {
        rs.push({
            fiCompanyAddress: mfgFactories[i].fiManufactureAddress,
            fiCompanyName: mfgFactories[i].fiManufactureName
        })
    }

    return rs;
}

function mapSellerToSend(sellers) {
    var rs = [];

    for (var i = 0; i < sellers.length; i++) {
        rs.push({
            "fiPortOfDepartureName": sellers[i].fiPortOfDepartureName,
            "fiSellerAddress": sellers[i].fiExporterAddress,
            "fiSellerFax": sellers[i].fiExporterFax,
            "fiSellerName": sellers[i].fiExporterName,
            "fiSellerPhone": sellers[i].fiExporterPhone,
            "fiSellerStateCode": sellers[i].fiSellerStateCode,
            "fiSellerStateName": sellers[i].fiExporterCountry
        })
    }

    return rs;
}
